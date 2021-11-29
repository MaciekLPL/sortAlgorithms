import pl.lejczak.project.model.SortingAlgorithm;
import pl.lejczak.project.model.InsertionSort;
import pl.lejczak.project.model.BubbleSort;
import pl.lejczak.project.model.AlgorithmProvider;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

/**
 * AlgorithmProvider tests
 * @author Maciej Lejczak
 * @version 1.0
 */
public class ProviderTest {
    /** Provider test object */
    private static AlgorithmProvider provider;
    
    @BeforeAll
    public static void setUp() {
        provider = new AlgorithmProvider();
    }
    
    /**
     * Tests creator of bubble sort algorithm - case sensitivity.
     * @param name name of algorithm passed to function
     */
    @ParameterizedTest
    @ValueSource(strings = {"BubbleSort", "bubblesort", "BUBBLESORT"})
    public void testBubbleCreator(String name) {  
        SortingAlgorithm result = provider.createAlgorithm(name);
        assertTrue(result instanceof BubbleSort, "Provider did not create object of proper type"); 
    }
    /**
     * Tests creator of insertion sort algorithm - case sensitivity.
     * @param name name of algorithm passed to function
     */
    @ParameterizedTest
    @ValueSource(strings = {"InsertionSort", "insertionsort", "INSERTIONSORT"})
    public void testInsertionCreator(String name) {  
        SortingAlgorithm result = provider.createAlgorithm(name);
        assertTrue(result instanceof InsertionSort, "Provider did not create object of proper type"); 
    }
    /**
     * Tests creator with incorrect values.
     * @param name name of algorithm passed to function
     */
    @ParameterizedTest
    @ValueSource(strings = {"bubble", "InsertionSor", "null", "nazwa", "435435", "12.3"})
    public void testNullCreator(String name) {  
        SortingAlgorithm result = provider.createAlgorithm(name);
        assertTrue(result == null, "Provider did not create object of proper type"); 
    }
}
