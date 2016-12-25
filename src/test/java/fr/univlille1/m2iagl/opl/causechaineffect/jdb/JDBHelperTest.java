package fr.univlille1.m2iagl.opl.causechaineffect.jdb;

import fr.univlille1.m2iagl.opl.causechaineffect.model.Breakpoint;
import fr.univlille1.m2iagl.opl.causechaineffect.model.Constants;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JDBHelperTest {

    /**
     * Test of launch method, of class JDBHelper.
     */
    @Test
    public void testLaunch() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
        JDBHelper jdbHelper = new JDBHelper("fr.univlille1.m2iagl.opl.causechaineffect.main.LaunchJDBMain",new Breakpoint(33,"fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge"),0);
        System.setProperty("os.name","linux");
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
        JDBHelper jdbHelper = new JDBHelper("fr.univlille1.m2iagl.opl.causechaineffect.main.LaunchJDBMain",new Breakpoint(5,"testfilename"),0);
        Map<String, Object> expResult = null;
        Map<String, Object> result = jdbHelper.getVars();
        assertEquals(expResult, result);
    }
    
}
