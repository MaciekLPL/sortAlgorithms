import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pl.lejczak.project.model.*;

/**
 * AlgorithmProvider tests
 * @author Maciej Lejczak
 * @version 1.0
 */
public class ProviderTest {
    
    private static AlgorithmProvider provider;
    
    @BeforeAll
    public static void setUp() {
        provider = new AlgorithmProvider();
    }
    
    
    @ParameterizedTest
    @ValueSource(strings = {"BubbleSort", "bubblesort", "BUBBLESORT"})
    public void testBubbleCreator(String name) {  
        SortingAlgorithm result = provider.createAlgorithm(name);
        assertTrue(result instanceof BubbleSort, "Provider did not create object of proper type"); 
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"InsertionSort", "insertionsort", "INSERTIONSORT"})
    public void testInsertionCreator(String name) {  
        SortingAlgorithm result = provider.createAlgorithm(name);
        assertTrue(result instanceof InsertionSort, "Provider did not create object of proper type"); 
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"bubble", "InsertionSor", "null", "nazwa", "435435", "12.3"})
    public void testNullCreator(String name) {  
        SortingAlgorithm result = provider.createAlgorithm(name);
        assertTrue(result == null, "Provider did not create object of proper type"); 
    }
}
