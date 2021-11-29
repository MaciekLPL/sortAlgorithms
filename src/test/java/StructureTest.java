import pl.lejczak.project.model.InsertionStructure;
import pl.lejczak.project.model.BubbleStructure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

/**
 * Structure test.
 * @author Maciej Lejczak
 * @version 1.0
 */
public class StructureTest {
    
    /** BubbleStructure test object */
    private BubbleStructure bs;
    /** InsertionStructure test object */
    private InsertionStructure is;
    
    /**
     * Creates new instances of structures for sorting algorithms before each test.
     */
    @BeforeEach
    public void reset() {
        bs = new BubbleStructure();
        is = new InsertionStructure();
    }
    
    /**
     * Bubble sort algorithm step test, checks if elements are moved correctly.
     * @param i index of element to be moved
     * @param j index where element should be moves
     */
    @ParameterizedTest
    @MethodSource("properArrayLists")
    public void testBubbleStructure(int i, int j, ArrayList<Integer> list) {
        
        bs.setData(list);
        int size = bs.getSize();
        int v1 = bs.getValue(i);
        int v2 = bs.getValue(j);
        bs.sortStep(i, j);
 
        assertEquals(v1, bs.getValue(j), "Values ​​are not the same");
        assertEquals(v2, bs.getValue(i), "Values ​​are not the same");
        assertEquals(bs.getSize(), size, "Size is not the same");

    }
    /**
     * Insertion sort algorithm step test, checks if elements are moved correctly.
     * @param i index of element to be moved
     * @param j index where element should be moves
     */
    @ParameterizedTest
    @MethodSource("properArrayLists")
    public void testInsertionSort(int i, int j, ArrayList<Integer> list) {
        
        is.setData(list);
        int size = is.getSize();
        int v1 = is.getValue(i);
        int v2 = is.getValue(j);
        is.sortStep(i, j);
 
        assertEquals(v1, is.getValue(j), "Values ​​are not the same");
        assertEquals(v2, is.getValue(j + 1), "Values ​​are not the same");
        assertEquals(is.getSize(), size, "Size is not the same");

    }
    
    /**
     * Creates stream of arrays with valid data as arguments for tests.
     * @return Stream with correct arrays
     */
    static Stream<Arguments> properArrayLists() {
        
        return Stream.of(
            Arguments.of(5, 1, (Object) new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))), 
            Arguments.of(5, 2, (Object) new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, -1))),
            Arguments.of(2, 0, (Object) new ArrayList<>(Arrays.asList(-6, -5, -3, -0, -1, -2))),
            Arguments.of(2, 1, (Object) new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0))),
            Arguments.of(5, 4, (Object) new ArrayList<>(Arrays.asList(-800, -400, -200, 200, 400, 800)))
            );
    }
}
