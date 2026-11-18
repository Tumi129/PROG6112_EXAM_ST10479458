import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    // Q.1.4 Unit Test 1
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product p = new Product();
        int[][] mockData = { {10, 10, 10}, {5, 5, 5}, {2, 2, 2} };
        // Total should be 30 + 15 + 6 = 51
        assertEquals(51, p.GetTotalProductsSold(mockData));
    }

    // Q.1.4 Unit Test 2
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product p = new Product();
        int[][] mockData = { {10, 10, 10}, {5, 5, 5}, {2, 2, 2} };
        // Total is 51, divided by 9 months = 5.66...
        assertEquals(5.66, p.GetAverageProductSold(mockData), 0.01); 
    }

    // Q.2.6 Unit Test 1
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations();
        // 15% of 1000 should be 150
        assertEquals(150.0, calc.GetVat(1000.0), 0.01);
    }
}
