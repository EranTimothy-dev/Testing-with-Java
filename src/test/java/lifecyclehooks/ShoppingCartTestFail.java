package lifecyclehooks;

import junittesting.lifecyclehooks.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTestFail {
    /**
     * This test will fail since the cart object is shared across both test cases, making the second test case incorrect
     * since the first test also adds items to the same cart, to avoid this we can use JUnits life cycles annotations
     * to set up before each test method is run using the BeforeEach and AfterEach annotation.
     * */

    private static ShoppingCart cart = new ShoppingCart();

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

}
