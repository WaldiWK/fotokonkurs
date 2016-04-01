package pl.kuranc.fotokonkurs.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "pl.kuranc.fotokonkurs.fotokonkurs";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}