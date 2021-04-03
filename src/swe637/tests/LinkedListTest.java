import org.junit.Test;
import swe637.java.LinkedList;
import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void addTest(){
        LinkedList<Integer> l = new LinkedList<>();
        assertTrue(l.add(2));
    }

    @Test
    public void removeTest_with_non_null_member(){
        LinkedList<String> l = new LinkedList<>();
        l.add("lion");
        l.add(null);
        l.add("eagle");
        l.add("snake");
        assertTrue(l.remove("eagle"));
    }

    @Test
    public void removeTest_with_null(){
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(null);
        l.add(2);
        l.add(3);
        assertTrue(l.remove(null));
    }

    @Test
    public void addAllTest(){
        LinkedList<String> l = new LinkedList<>();
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("one");
        l2.add("two");
        assertTrue(l.addAll(l2));
    }

    @Test(expected=NullPointerException.class)
    public void addAllTest_throws_NPE(){
        LinkedList<Integer> l = new LinkedList<>();
        l.addAll(null);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void addAllTest_throws_IOOBE_when_index_less_than_zero(){
        LinkedList<String> l = new LinkedList<>();
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("test");
        l2.add("test2");

        l.addAll(-2, l2);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void addAllTest_throws_IOOBE_when_index_greater_than_size(){
        LinkedList<String> l = new LinkedList<>();
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("test");
        l2.add("test2");

        l.addAll(5, l2);
    }

    @Test
    public void addAllTest_should_return_false(){
        LinkedList<String> l = new LinkedList<>();
        LinkedList<String> l2 = new LinkedList<>();
        assertFalse(l.addAll(0, l2));
    }

    @Test
    public void addAllTest_return_true(){
        LinkedList<String> l = new LinkedList<>();
        l.add("eggs");
        l.add("coffee");
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("test");
        l2.add("test2");
        l2.add("test3");
        l2.add("test4");
        assertTrue(l.addAll(1, l2));
    }

    @Test
    public void clearTest_removes_all_members(){
        LinkedList<String> l = new LinkedList<>();
        l.add("eggs");
        l.add("coffee");
        l.add("toast");
        l.clear();

        assertEquals(0, l.size());
    }

    @Test
    public void getTest_return_correct_member(){
        LinkedList<String> l = new LinkedList<>();
        l.add("eggs");
        l.add("coffee");

        assertEquals("coffee", l.get(1));
    }

    @Test
    public void setTest_replaces_correct_member(){
        LinkedList<String> l = new LinkedList<>();
        l.add("eggs");
        l.add("coffee");
        assertEquals("coffee", l.set(1, "orange juice"));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void setTest_throws_IOOBE_when_index_greater_than_size(){
        LinkedList<String> l = new LinkedList<>();
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("eggs");
        l2.add("coffee");
        l.set(5, "water");
    }

    @Test
    public void addTest_(){
        LinkedList<String> l = new LinkedList<>();
        l.add("eggs");
        l.add("coffee");
        l.add(0, "french toast");
        assertEquals(0, l.indexOf("french toast"));
        assertEquals(1, l.indexOf("eggs"));
        assertEquals(2, l.indexOf("coffee"));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void addTest_throws_IOOBE_when_index_greater_than_size(){
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("eggs");
        l2.add("coffee");
        l2.set(4, "water");
    }

    @Test
    public void removeTest_(){
        LinkedList<String> l = new LinkedList<>();
        l.add("eggs");
        l.add("coffee");
        assertEquals("coffee", l.remove(1));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void removeTest_throws_IOOBE_when_index_greater_than_size(){
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("eggs");
        l2.add("coffee");
        l2.remove(4);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void entryTest_throws_IOOBE_when_index_is_less_than_zero(){
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("test");
        l2.add("test2");
        l2.entry(-1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void entryTest_throws_IOOBE_when_index_greater_is_than_or_equal_to_zero(){
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("test");
        l2.add("test2");
        l2.entry(5);
    }

    @Test
    public void entryTest_index_less_than_size_bitshift_1_right(){
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("test");
        l2.add("test2");
        l2.add("test3");
        l2.add("test4");
        LinkedList.Entry<String> e = l2.entry(2);

        assertEquals("test4", e.toString());
    }

    @Test
    public void entryTest_index_greater_than_or_equal_to_size_bitshift_1_right(){
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("test");
        l2.add("test2");
        l2.add("test3");
        l2.add("test4");
        LinkedList.Entry<String> e = l2.entry(2);

        assertEquals("test", e.toString());
    }
}