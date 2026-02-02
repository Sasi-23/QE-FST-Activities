package demos;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class TestCalculator {
    private Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test 
    public void testAdd(){
        assertEquals(4, calculator.add(2, 2));
    }


}

