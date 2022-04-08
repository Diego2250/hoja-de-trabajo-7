import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {
    Tree<String, String> t = new Tree<>(); 

    @Test
    public void insert() {
        t.insert("hello", "hola");
        assertEquals(t.Search("hello"), "hola");
    }

    @Test
    public void search() {
        t.insert("goodbye", "adios");
        assertEquals(t.Search("goodbye"), "adios");
    }

}
