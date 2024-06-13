import junit.framework.TestCase;
import Koenigreich.Einwohner;

public class EinwohnerTest extends TestCase {
    protected Einwohner einwohner;

    protected void setUp(){
        einwohner = new Einwohner();
    }

    public void teststeuerE1(){
        try{
            einwohner.setEinkommen(-1);
            fail("keine Exception aufgetreten");
        } catch (IllegalArgumentException e){
            assertEquals("Einkommen darf nicht negativ sein", e.getMessage());
        } catch (Exception e){
            fail("Nicht erwartete Exception aufgetreten");
        }
    }

    public void testSteuerE2(){
        einwohner.setEinkommen(0);
        assertEquals(1,einwohner.steuer());
    }

    public void testSteuerE3(){
        einwohner.setEinkommen(20);
        assertEquals(2,einwohner.steuer());
    }

    public void testSteuerE4(){
        einwohner.setEinkommen(25);
        assertEquals(2,einwohner.steuer());
    }
}
