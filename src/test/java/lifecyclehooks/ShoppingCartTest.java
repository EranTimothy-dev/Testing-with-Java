package lifecyclehooks;

import junittesting.lifecyclehooks.ShoppingCart;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {
    /**
     * Using the BeforeEach and AfterEach lifecycle annotations allow us to set up and clear up after each test
     * so that it doesn't affect other tests.
     * This makes sure that out test cases run in isolation according to the 'I'(Independent) in the FIRST principle
     * */

    private static ShoppingCart cart;

    @BeforeEach
    public void setUp(){
        cart = new ShoppingCart();
    }

    @Test
    public void addItem() {
        cart.addItem("Product A", 2);
        cart.addItem("Product C", 3);
        assertEquals(5, cart.getTotalItems());
    }

    @Test
    public void removeItem() {
        cart.addItem("Product A", 2);
        cart.removeItem("Product A", 1);
        assertEquals(1, cart.getTotalItems());
    }

    @AfterEach
    public void tearDown(){
        cart = null;
    }

}
