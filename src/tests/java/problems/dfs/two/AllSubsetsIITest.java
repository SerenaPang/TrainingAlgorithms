package problems.dfs.two;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllSubsetsIITest {

    @Test
    public void test1() throws Exception {
        AllSubsetsII as = new AllSubsetsII();
        String set = "abc";
        List<String> expected = new ArrayList<>();
        expected.add("abc");
        expected.add("ab");
        expected.add("ac");
        expected.add("a");
        expected.add("bc");
        expected.add("b");
        expected.add("c");
        expected.add("");
        List<String> actual = as.subSets(set);
        assertEquals(expected, actual);
    }

}