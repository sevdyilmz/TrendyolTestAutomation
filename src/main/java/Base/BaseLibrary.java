package Base;

public class BaseLibrary extends TestData {

    public void sleep(int millis) throws InterruptedException {

        Thread.sleep(millis);

    }

    public void assertEquals(String actual, String expected){

        assertEquals(actual, expected);
    }
}