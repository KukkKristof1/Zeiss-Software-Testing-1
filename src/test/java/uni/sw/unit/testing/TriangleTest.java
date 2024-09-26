package uni.sw.unit.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @BeforeAll
    public static void setup()
    {
        System.out.println("BeforeAll demo: setup test execution");
    }

    @AfterAll
    public static void tearDown()
    {
        System.out.println("AfterAll demo: tear down test execution");
    }

    @BeforeEach
    public void initTest()
    {
        System.out.println("BeforeEach demo: init test case");
    }

    @AfterEach
    public void tearDownText(){
        System.out.println("AfterEach demo: tear down test case");
    }


    @Test
    public void testGenericTriangle(){
        
        Triangle triangle = new Triangle(3, 4, 6);

        assertTrue(triangle instanceof Triangle);
        assertFalse(triangle.isEquilateral());

    }

    @Test
    public void testIsoscalesTriangle()
    {
        Triangle triangle1 = new Triangle(3, 3 , 5);
        Triangle triangle2 = new Triangle(3, 4 , 5);

        assertTrue(triangle1 instanceof Triangle);
        assertTrue(triangle2 instanceof Triangle);

        assertTrue(triangle1.isIsosceles());
        assertFalse(triangle2.isIsosceles());

    }

    @Test
    public void testEquilateralTriangle()
    {
        Triangle triangle1 = new Triangle(5, 5 , 5);
        Triangle triangle2 = new Triangle(3, 4 , 5);

        assertTrue(triangle1 instanceof Triangle);
        assertTrue(triangle2 instanceof Triangle);

        assertTrue(triangle1.isIsosceles());
        assertTrue(triangle1.isEquilateral());

        assertFalse(triangle2.isIsosceles());
        assertFalse(triangle2.isEquilateral());

    }

    @Test
    public void testRightAngeledTriangle()
    {
        Triangle triangle1 = new Triangle(6, 8, 10);
        Triangle triangle2 = new Triangle(10, 6, 8);
        Triangle triangle3 = new Triangle(8, 10, 6);
        Triangle triangle4 = new Triangle(5, 5, 5);

        assertTrue(triangle1 instanceof Triangle);   
        assertTrue(triangle2 instanceof Triangle);   
        assertTrue(triangle3 instanceof Triangle);   
        assertTrue(triangle4 instanceof Triangle);   

        assertTrue(triangle1.isRightAngeled());
        assertTrue(triangle2.isRightAngeled());
        assertTrue(triangle3.isRightAngeled());
        assertFalse(triangle4.isRightAngeled());
        

    }

    @Test
    public void testPerimeter()
    {
        Triangle triangle = new Triangle(100, 251, 178);

        assertTrue(triangle instanceof Triangle);

        assertEquals(529, triangle.getPerimeter(), "Calculated perimeter doesn't match expected value!");
    }

    @Test
    public void testArea()
    {
        Triangle triangle = new Triangle(3, 4, 6);

        assertTrue(triangle instanceof Triangle);

        double testValue = 5.333;
        double marginOfError = 0.001;
        double calculatedArea = triangle.getArea();

        assertEquals(calculatedArea, testValue, marginOfError);
    }

    @Test
    public void testNotConstructableTriangle()
    {
        Exception exception = assertThrows(ArithmeticException.class, () ->{
            new Triangle(3, 4, 7);
        });

        assertTrue(exception.getMessage().contains("The triangle cannot be constructed from the the numbers"));

        assertThrows(ArithmeticException.class, () ->{
            new Triangle(3, 7, 4);
        });

        assertThrows(ArithmeticException.class, () ->{
            new Triangle(7, 3, 4);
        });

    }

}