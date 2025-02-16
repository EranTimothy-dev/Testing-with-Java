package junittesting.lifecyclehooks;

import java.util.HashMap;
import java.util.Map;


public class ShoppingCart {

    private Map<String, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(String product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void removeItem(String product, int quantity) {
        if (items.containsKey(product)) {
            int currentQuantity = items.get(product);
            if (currentQuantity <= quantity) {
                items.remove(product);
            } else {
                items.put(product, currentQuantity - quantity);
            }
        }
    }

    public int getTotalItems() {
        int total = 0;
        for (int quantity : items.values()) {
            total += quantity;
        }
        return total;
    }
}
