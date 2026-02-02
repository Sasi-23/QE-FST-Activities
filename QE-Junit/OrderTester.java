package demos;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.Random.class)
public class OrderTester{
    @Test
    public void test0(){
        System.out.print("test0");
    }
    @Test
    public void test2(){
        System.out.print("test2");
    }
    @Test
    public void test3(){
        System.out.print("test3");
    }
    @Test
    public void test4(){
        System.out.print("test4");
    }
    @Test
    public void test5(){
        System.out.print("test5");
    }

}






