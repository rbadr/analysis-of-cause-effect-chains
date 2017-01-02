package fr.univlille1.m2iagl.opl.causechaineffect.jdb;

import fr.univlille1.m2iagl.opl.causechaineffect.model.Breakpoint;
import fr.univlille1.m2iagl.opl.causechaineffect.model.Constants;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JDBHelperTest {

    @Test
        public void testLaunch() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            JDBHelper jdbHelper = new JDBHelper(true,"fr.univlille1.m2iagl.opl.causechaineffect.main.LaunchJDBMain",new Breakpoint(33,"fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge",2),0);
            System.setProperty("os.name","linux");
            Constants.init();
            jdbHelper.launch();
            
            Field mainClass = JDBHelper.class.getDeclaredField("mainClass");
            mainClass.setAccessible(true);
            
            String mainClassResult = mainClass.get(jdbHelper).toString();
            String expectedMainClass = "fr.univlille1.m2iagl.opl.causechaineffect.main.LaunchJDBMain";
            
            assertEquals(expectedMainClass, mainClassResult);
        }
        
            @Test
        public void testLaunchThrowsException() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            JDBHelper jdbHelper = new JDBHelper(true,"fr.univlille1.m2iagl.opl.causechaineffect.main.LaunchJDBMain",new Breakpoint(33,"fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge",1),0);
            Constants.init();
            jdbHelper.launch();
            
            Field mainClass = JDBHelper.class.getDeclaredField("mainClass");
            mainClass.setAccessible(true);
            
            String mainClassResult = mainClass.get(jdbHelper).toString();
            String expectedMainClass = "fr.univlille1.m2iagl.opl.causechaineffect.main.LaunchJDBMain";
            
            assertEquals(expectedMainClass, mainClassResult);
        }
    
        /**
         * Test of getVars method, of class JDBHelper.
         */
        @Test
        public void testGetVars() {
            JDBHelper jdbHelper = new JDBHelper(true,"fr.univlille1.m2iagl.opl.causechaineffect.main.LaunchJDBMain",new Breakpoint(5,"testfilename",1),0);
            Map<String, String> expResult = null;
            Map<String, String> result = jdbHelper.getVars();
            assertEquals(expResult, result);
        }

    
}



