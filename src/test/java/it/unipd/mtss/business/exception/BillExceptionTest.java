////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class BillExceptionTest {
    BillException exception;

    @BeforeEach
    public void setUp() {
        this.exception = new BillException("Errore");
    }

    @Test
    public void testIsAnException() {
        assertInstanceOf(Exception.class, exception);
    }

    @Test
    public void testGetMessage() {
        try {
            throw exception;
        }
        catch (BillException e) {
            assertEquals("Errore", e.getMessage());
        }
    }
}
