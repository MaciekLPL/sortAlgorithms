import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pl.lejczak.project.EmptyDataException;
import pl.lejczak.project.model.*;

/**
 * Sorting algorithm test.
 * @author Maciej Lejczak
 * @version 1.0
 */
public class AlgorithmTest {
    
    private BubbleSort bs;
    private InsertionSort is;
    
    @BeforeEach
    public void reset() {
        bs = new BubbleSort();
        is = new InsertionSort();
    }
    
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
    
    
    static Stream<Arguments> emptyArrayLists() {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.clear();
        
        return Stream.of(
            Arguments.of((Object) new ArrayList<Integer>()), 
            Arguments.of(al));
    }
    
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
