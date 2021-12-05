import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TrieMapTest {

    TrieMap<Integer> trie;
    
    @Before
    public void setUp() {
        trie = new TrieMap<Integer>();
    }
    
    @Test
    public void putTest() {
        assertNull(trie.put("asd", 5));
        assertNull(trie.put("asdfg", 11));
        assertNull(trie.put("asdzxc", 12));
        assertEquals(Integer.valueOf(12), trie.put("asdzxc", 16));
        assertNull(trie.put("", 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullKeyPutTest() {
        trie.put(null, 5);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullValuePutTest() {
        trie.put("asd", null);
    }
    
    @Test
    public void getTest() {
        trie.put("asd", 5);
        trie.put("asdfg", 11);
        trie.put("asdzxc", 12);
        assertEquals(Integer.valueOf(5), trie.get("asd"));
        assertEquals(Integer.valueOf(11), trie.get("asdfg"));
        assertEquals(Integer.valueOf(12), trie.get("asdzxc"));
        trie.put("asdzxc", 16);
        assertEquals(Integer.valueOf(16), trie.get("asdzxc"));
        assertNull(trie.get("as"));
        assertNull(trie.get("dasd"));
        assertNull(trie.get("asdzxcz"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullKeyGetTest() {
        trie.get(null);
    }
    
    @Test
    public void containsKeyTest() {
        trie.put("asd", 5);
        trie.put("asdfg", 11);
        trie.put("asdzxc", 12);
        trie.put("ccc", 15);
        assertTrue(trie.containsKey("asdzxc"));
        assertFalse(trie.containsKey("dasd"));
        assertFalse(trie.containsKey("asdf"));
        assertFalse(trie.containsKey("cccc"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullKeyContainsKeyTest() {
        trie.containsKey(null);
    }
    
    @Test
    public void containsValueTest() {
        trie.put("asd", 5);
        trie.put("asdfg", 11);
        trie.put("asdzxc", 12);
        trie.put("ccc", 15);
        assertTrue(trie.containsValue(15));
        assertFalse(trie.containsValue(123));
        trie.put("", 158);
        assertFalse(trie.containsValue(155));
        trie.put("", 155);
        assertTrue(trie.containsValue(155));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullValueContainsValueTest() {
        trie.containsValue(null);
    }
    
    @Test 
    public void removeTest() {
        assertNull(trie.remove("asd"));
        assertNull(trie.remove(""));
        trie.put("asd", 5);
        trie.put("asdfg", 11);
        trie.put("asdzxc", 12);
        trie.put("ccc", 15);
        trie.put("", 16);
        assertEquals(Integer.valueOf(16), trie.remove(""));
        assertEquals(Integer.valueOf(5), trie.remove("asd"));
        assertEquals(Integer.valueOf(11), trie.remove("asdfg"));
        assertEquals(Integer.valueOf(12), trie.remove("asdzxc"));
        assertEquals(Integer.valueOf(15), trie.remove("ccc"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullKeyRemoveTest() {
        trie.remove(null);
    }
    
    @Test
    public void sizeTest() {
        trie.put("asd", 5);
        assertEquals(1, trie.size());
        trie.put("asd", 15);
        assertEquals(1, trie.size());
        trie.remove("");
        assertEquals(1, trie.size());
        trie.remove("asd");
        assertEquals(0, trie.size());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void convertToCharTest() {
        trie.put("123zxc", 5);
        trie.put("`23zxc", 5);
        trie.put("Azxc", 5);
    }
}
