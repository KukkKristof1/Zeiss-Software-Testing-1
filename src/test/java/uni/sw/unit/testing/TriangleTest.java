package uni.sw.unit.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void testGenericTriangle(){
        
        Triangle triangle = new Triangle(3, 4, 6);

        assertTrue(triangle instanceof Triangle);
        assertFalse(triangle.isEquilateral());

    }

    @Test
    public void testIsoscalesTriangle()
    {
        Triangle triangle = new Triangle(3, 3 , 5);

        assertTrue(triangle instanceof Triangle);

        assertTrue(triangle.isIsosceles());

    }

    @Test
    public void testEquilateralTriangle()
    {
        Triangle triangle = new Triangle(5, 5 , 5);

        assertTrue(triangle instanceof Triangle);

        assertTrue(triangle.isIsosceles());
        assertTrue(triangle.isEquilateral());

    }

    @Test
    public void testRightAngeledTriangle()
    {
        Triangle triangle = new Triangle(6, 8, 10);

        assertTrue(triangle instanceof Triangle);   

        assertTrue(triangle.isRightAngeled());
    }

    @Test
    public void testPerimeter()
    {
        Triangle triangle = new Triangle(100, 251, 178);

        assertTrue(triangle instanceof Triangle);

        assertEquals(triangle.getPerimeter(), 529);
    }
}