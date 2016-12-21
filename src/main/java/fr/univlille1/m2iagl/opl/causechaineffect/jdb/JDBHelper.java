package fr.univlille1.m2iagl.opl.causechaineffect.jdb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import fr.univlille1.m2iagl.opl.causechaineffect.model.Breakpoint;
import fr.univlille1.m2iagl.opl.causechaineffect.model.Constants;

public class JDBHelper {

	private String mainClass;
	private Breakpoint breakpoint;

	private BufferedWriter writer;

	private Map<String, Object> vars;

	public JDBHelper(String mainClass, Breakpoint breakpoint) {
		this.mainClass = mainClass;
		this.breakpoint = breakpoint;
	}

	public void launch() {
		try {
			ProcessBuilder builder = new ProcessBuilder("jdb");
			// Set the working dir to the 'bin' dir
			builder.directory(new File(System.getProperty("user.dir") + Constants.SEPARATOR + "bin"));
			Process process = builder.start();
			
			OutputStream stdin = process.getOutputStream();
			InputStream stdout = process.getInputStream();

			writer = new BufferedWriter(new OutputStreamWriter(stdin));

			writeCommand("stop at " + breakpoint.toString());
			getOutput(stdout);
			
			writeCommand("run " + mainClass);
			getOutput(stdout);

			writeCommand("locals");
			parseVars(stdout);
			
			writeCommand("exit");
			
			process.destroy();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void writeCommand(String command) throws Exception {
		writer.write(command + "\n");
		writer.flush();
		Thread.sleep(Constants.MS_BETWEEN_COMMAND);

	}
	
	public Map<String, Object> getVars(){
		return vars;
	}

	private void parseVars(InputStream outputStream) throws IOException {
		this.vars = new HashMap<String, Object>();
		
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

	private String getOutput(InputStream outputStream) throws IOException {
		byte[] buffer = new byte[100000];
		int bytesRead;
		String s = "";
		while (outputStream.available() > 0) {
			bytesRead = outputStream.read(buffer);
			if (bytesRead > 0) {
				s += new String(buffer, 0, bytesRead) + "\n";
			}
		}

		return s;
	}

}
