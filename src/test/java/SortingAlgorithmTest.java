import junittesting.SortingAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingAlgorithmTest {

    private final SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();

    @Test
    void sort_unsortedArrayTest() {
        int[] input = {5, 3, 8, 4, 2};
        int[] expected = {2, 3, 4, 5, 8};

        int[] sortedArray = sortingAlgorithm.sort(input);
//        assertEquals(expected, sortedArray, () -> "Array was not sorted successfully");
        // assertEquals checks if the objects has the same references,
        // not their content, which results in false negatives, where the answer is true but the result is false. Therefore;
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    void sortNullTest() {
        assertArrayEquals(null, sortingAlgorithm.sort(null));
    }

    @Test
    void sortEmptyArrayTest() {
        assertArrayEquals(new int[]{}, sortingAlgorithm.sort(new int[] {}));
    }

    @Test
    void sortNegativeArrayTest() {
        int[] input = {-5, -3, -8, -4, -2};
        int[] expected = {-8, -5, -4, -3, -2};

        assertArrayEquals(expected, sortingAlgorithm.sort(input));
    }


}
