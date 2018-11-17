
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class GraderLoadTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000); // 1000 milliseconds for timeout

    static Dictionary dictionary;
    Grader grader;

    @BeforeClass
    public static void setUpOnce() throws Exception {
        dictionary = new Dictionary();
        dictionary.loadDictionaryFromFile("dictionary.txt");
    }


    @Before
    public void setUp() throws Exception {
        grader = new Grader(dictionary);
    }

    @Test
    public void whenInitializedThenAvailable() throws Exception {
        assertTrue(grader.isAvailable());
    }

    @Test
    public void givenInvalidStudentWhenGradingThenFailNAvailable() throws Exception {
        assertFalse(grader.gradeStudent("not-exists"));
        assertTrue(grader.isAvailable());
    }

    @Test
    public void givenValidStudentWhenGradingThenSuccessNNotAvailable() throws Exception {
        assertTrue(grader.gradeStudent("11111111"));
        assertFalse(grader.isAvailable());
    }

    @Test
    public void givenGradedStudentGraderWhenResetThenNullStudentNAvailable() throws Exception {
        assertTrue(grader.isAvailable()); // available after init
        assertTrue(grader.gradeStudent("11111111")); // successful grading
        assertFalse(grader.isAvailable()); // not avlb after successful grading
        grader.reset();
        assertNull(grader.getStudent()); // null after reset
        assertTrue(grader.isAvailable()); // avlb after reset
    }
}