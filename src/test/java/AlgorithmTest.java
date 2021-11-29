import pl.lejczak.project.model.InsertionSort;
import pl.lejczak.project.model.BubbleSort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pl.lejczak.project.EmptyDataException;

/**
 * Sorting algorithm test.
 * @author Maciej Lejczak
 * @version 1.0
 */
public class AlgorithmTest {
    /** BubbleSort test object */
    private BubbleSort bs;
    /** InseritonSort test object */
    private InsertionSort is;
    
    /**
     * Creates new instances of sorting algorithms before each test.
     */
    @BeforeEach
    public void reset() {
        bs = new BubbleSort();
        is = new InsertionSort();
    }
    
    /**
     * Exception test, checks if exception is thrown at empty data pass.
     * @param list empty arrays to be checked
     */
    @ParameterizedTest
    @MethodSource("emptyArrayLists")
    public void testException(ArrayList<Integer> list) {
        
        bs.setData(list);
        is.setData(list);
        
        try {
            
            bs.getData();
            is.getData();
            
            fail("An exception should be thrown when data is empty.");
        } catch (EmptyDataException e) {
        }
    }
    
    /**
     * Bubbles sort algorithm test, checks if numbers are sorted properly.
     * @param list array to be sorted.
     */
    @ParameterizedTest
    @MethodSource("properArrayLists")
    public void testInsertionSort(ArrayList<Integer> list) {
        
        is.setData(list);
        
        while (!is.isSorted()) {
            is.sort();
        }
        
        Collections.sort(list);
        
        try {
            assertTrue(is.getData().equals(list), "Array was not sorted properly by InsertionSort");
        } catch (EmptyDataException ex) {
        }
        

    }
    
    /**
     * Insertion sort algorithm test, checks if numbers are sorted properly.
     * @param list array to be sorted.
     */
    @ParameterizedTest
    @MethodSource("properArrayLists")
    public void testBubbleSort(ArrayList<Integer> list) {
        
        bs.setData(list);
        
        while (!bs.isSorted()) {
            bs.sort();
        }
        
        Collections.sort(list);
        
        try {     
            assertTrue(bs.getData().equals(list), "Array was not sorted properly by BubbleSort");
        } catch (EmptyDataException ex) {
        }
    }
    
    /**
     * Creates stream of empty arrays as arguments for tests.
     * @return Stream with empty arrays
     */
    static Stream<Arguments> emptyArrayLists() {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.clear();
        
        return Stream.of(
            Arguments.of((Object) new ArrayList<Integer>()), 
            Arguments.of(al));
    }
    
    /**
     * Creates stream of arrays with valid data as arguments for tests.
     * @return Stream with correct arrays
     */
    static Stream<Arguments> properArrayLists() {
        
        return Stream.of(
            Arguments.of((Object) new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))), 
            Arguments.of((Object) new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, -1))),
            Arguments.of((Object) new ArrayList<>(Arrays.asList(-6, -5, -3, -0, -1, -2))),
            Arguments.of((Object) new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0))),
            Arguments.of((Object) new ArrayList<>(Arrays.asList(-800, -400, -200, 200, 400, 800)))
            );
    }
}
