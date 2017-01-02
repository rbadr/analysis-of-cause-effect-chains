package fr.univlille1.m2iagl.opl.causechaineffect.jdb;

import fr.univlille1.m2iagl.opl.causechaineffect.model.Breakpoint;
import fr.univlille1.m2iagl.opl.causechaineffect.model.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBHelper {

	private String mainClass;
	private Breakpoint breakpoint;
	private int index;

	private BufferedWriter writer;
	private InputStream stdout;

	private Map<String, String> vars;
	
	private String[] varsToDump;
	
	private boolean verbose;


	public JDBHelper(boolean verbose, String mainClass, Breakpoint breakpoint, int index) {
		this.verbose = verbose;
		this.mainClass = mainClass;
		this.breakpoint = breakpoint;
		this.index = index;
	}

	public void launch() {
		try {
			ProcessBuilder builder = new ProcessBuilder("jdb");
			builder.directory(new File(Constants.folder));
			Process process = builder.start();

			OutputStream stdin = process.getOutputStream();
			stdout = process.getInputStream();

			writer = new BufferedWriter(new OutputStreamWriter(stdin));

			writeCommand("stop at " + breakpoint.toString());
			getOutput(stdout);
			
			writeCommand("run " + mainClass + " " + index);
			getOutput(stdout);

			getToTheRightCall();

			writeCommand("locals");
			parseVars(stdout);
			getVarsToDump();
			
			for(String varToDump: varsToDump){
				writeCommand("dump " + varToDump);
				parseDupedVars(stdout);
			}

			writeCommand("exit");
			
			process.destroy();

		} catch (Exception ex) {
			if(ex.getMessage() != null && ex.getMessage().equals(Constants.CANAL_MESSAGE)){
				vars = null;
				if(verbose)
					System.out.println("-----------------------------");
			} else {
				ex.printStackTrace();
			}
		}
	}

	private void getToTheRightCall() throws Exception{
		for(int i=1;i<breakpoint.getNb();i++){
			writeCommand("cont");
			getOutput(stdout);
		}
	}

	private void writeCommand(String command) throws Exception {
		if(verbose)
			System.out.println(command);
		
		writer.write(command + "\n");
		writer.flush();
		Thread.sleep(Constants.MS_BETWEEN_COMMAND);
	}

	public Map<String, String> getVars(){
		return vars;
	}

	private void parseVars(InputStream outputStream) throws IOException {
		this.vars = new HashMap<>();

		String s = getOutput(outputStream);
		
		String[] line = s.split("\n");

		if(line[0].contains(Constants.METHOD_ARGUMENTS)){
			int i = 1;
			while(!line[i].contains(Constants.LOCAL_VARIABLES)){
				String[] tmp = line[i].split(" = ");
				vars.put(tmp[0], tmp[1]);

				i++;
			}
			i++;

			while(!line[i].contains(Constants.MAIN)){
				String[] tmp = line[i].split(" = ");
				vars.put(tmp[0], tmp[1]);

				i++;
			}
		}
	}
	
	private void parseDupedVars(InputStream outputStream) throws IOException{
		String s = getOutput(outputStream);
		
		s = s.replaceAll("\n", "").replaceAll("main\\[1\\]", "");
		
		
		String[] tmp = s.split(" = ");
		
		vars.put(tmp[0].replaceAll(" " , ""), tmp[1]);
	}
	
	private void getVarsToDump(){
		List<String> list = new ArrayList<>();
		for(String key : vars.keySet()){
			if(vars.get(key).startsWith(Constants.INSTANCE_OF))
				list.add(key);
		}
		
		varsToDump = list.toArray(new String[list.size()]);
	}

	private String getOutput(InputStream outputStream) throws IOException {
		byte[] buffer = new byte[100000];
		int bytesRead;
                StringBuilder bld = new StringBuilder();
		while (outputStream.available() > 0) {
			bytesRead = outputStream.read(buffer);
			if (bytesRead > 0) {
                            bld.append(new String(buffer, 0, bytesRead)).append("\n");
                        }
                }
                String str = bld.toString();
		return str;
	}
}
