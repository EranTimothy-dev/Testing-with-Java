package testsuites;

import junittesting.testsuites.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    public void constructorAndGetters() {
        Product product = new Product(1, "Test Product", 100.0);
        assertEquals(1, product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals(100.0, product.getPrice());
    }

    @Test
    public void setPrice() {
        Product product = new Product(1, "Test Product", 100.0);
        product.setPrice(150.0);
        assertEquals(150.0, product.getPrice());
    }

    @Test
    public void applyDiscountValidPercentage() {
        Product product = new Product(1, "Test Product", 100.0);
        product.applyDiscount(10.0);
        assertEquals(90.0, product.getPrice());
    }

    @Test
    public void applyDiscountInvalidPercentage() {
        Product product = new Product(1, "Test Product", 100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            product.applyDiscount(-10.0);
        });
        assertEquals("Percentage must be between 0 and 100", exception.getMessage());
    }

    @Test
    public void applyDiscountAboveHundredPercentage() {
        Product product = new Product(1, "Test Product", 100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            product.applyDiscount(110.0);
        });
        assertEquals("Percentage must be between 0 and 100", exception.getMessage());
    }

}
