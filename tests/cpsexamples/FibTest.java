package cpsexamples;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FibTest{
    Fib fib;
    
    @Before
    public void setUp(){
        fib = new Fib();
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link Fib#getFib()}.
     */
    @Test
    public final void testGetFib_BaseCases(){
        assertEquals(1, fib.getFib(1));
        assertEquals(1, fib.getFib(2));
    }

    /**
     * Test method for {@link Fib#getFib()}.
     */
    @Test
    public final void testGetFib_RecursiveCase(){
        assertEquals(13, fib.getFib(7));
        assertEquals(21, fib.getFib(8));
        assertEquals(144, fib.getFib(12));
    }
}
