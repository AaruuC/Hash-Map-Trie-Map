import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class HashMapTest {
    HashMap<Object, String> map;
    HashMap<Object, String> constructor;
    Entry<Object, String> entry;
    Iterator<Entry<Object, String>> iter;
    
    @Before
    public void setUp() {
        map = new HashMap<Object, String>(16);
    }
    
    @Test
    public void sizeTest() {
        assertEquals(0, map.size());
        map.put("asd", "asd");
        assertEquals(1, map.size());
    }
    
    @Test
    public void getTest() {
        assertNull(map.remove("asd"));
        Object obj1 = new Object() {
            @Override
            public int hashCode() {
                return 5;
            }
        };
        
        Object obj2 = new Object() {
            @Override
            public int hashCode() {
                return 5;
            }
        };
        
        Object obj3 = new Object() {
            @Override
            public int hashCode() {
                return 5;
            }
        };
        map.put(obj1, "asdf");
        map.put(obj2, "zxc");
        map.put(obj3, "asdzxc");
        assertEquals("asdf", map.get(obj1));
        assertEquals("zxc", map.get(obj2));
        assertEquals("asdzxc", map.get(obj3));
        assertNull(map.get("asdzxczxc"));
        map.put(null, "asdfg");
        assertEquals("asdfg", map.get(null));
    }
    
    @Test
    public void containsKeyTest() {
        map.put("asd", "asdf");
        map.put("asas", "asdf");
        map.put("asdd", "asdf");
        map.put("fdgasd", "asdf");
        map.put(null, "asdf");
        map.put("asd123", "asdf");
        assertTrue(map.containsKey("asd123"));
        assertTrue(map.containsKey(null));
        assertFalse(map.containsKey("zxc"));
        Object obj1 = new Object() {
            @Override
            public int hashCode() {
                return 5;
            }
        };
        
        Object obj2 = new Object() {
            @Override
            public int hashCode() {
                return 5;
            }
        };
        
        Object obj3 = new Object() {
            @Override
            public int hashCode() {
                return 5;
            }
        };
        map.put(obj1, "asdf");
        map.put(obj2, "zxc");
        map.put(obj3, "asdzxc");
        assertTrue(map.containsKey(obj1));
        assertTrue(map.containsKey(obj2));
        assertTrue(map.containsKey(obj3));
    }
    
    @Test
    public void putTest() {
        assertNull(map.put("asd", "asd"));
        assertEquals("asd", map.put("asd", "asdf"));
        assertNull(map.put("asdasd", "asdasd"));
        assertNull(map.put("asdasdasd", "asdasdasd"));
        assertEquals("asdasd", map.put("asdasd", "asdfgh"));
        assertNull(map.put(null, "asd"));
    }
    
//    @Test
//    public void resizeTest() {
//        maxMap.resize(0);
//    }
    
    @Test
    public void removeTest() {
        assertNull(map.remove("asd"));
        Object obj1 = new Object() {
            @Override
            public int hashCode() {
                return 5;
            }
        };
        
        Object obj2 = new Object() {
            @Override
            public int hashCode() {
                return 5;
            }
        };
        
        Object obj3 = new Object() {
            @Override
            public int hashCode() {
                return 5;
            }
        };
        
        map.put(obj1, "asd");
        map.put(obj2, "asdf");
        map.put(obj3, "asdfg");
        assertEquals("asdf", map.remove(obj2));
        assertEquals("asdfg", map.remove(obj3));
        assertEquals("asd", map.remove(obj1));
        map.put("", "asd");
        assertNull(map.remove(null));
    }
    
    @Test
    public void containsValueTest() {
        map.put(null, null);
        map.put("asd", "asdasd");
        assertTrue(map.containsValue("asdasd"));
        map.put("asd", "asdasdasd");
        assertFalse(map.containsValue("asdasd"));
        assertTrue(map.containsValue("asdasdasd"));
    }
    
    @Test
    public void clearTest() {
        map.put("asd", "asdasd");
        assertTrue(map.containsValue("asdasd"));
        assertTrue(map.containsKey("asd"));
        map.clear();
        assertFalse(map.containsValue("asdasd"));
        assertFalse(map.containsKey("asd"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void negativeCapacityConstructorTest() {
        constructor = new HashMap<Object, String>(-1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void negativeLoadFactorConstructorTest() {
        constructor = new HashMap<Object, String>(15, -1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nanLoadFactorConstructorTest() {
        constructor = new HashMap<Object, String>(15,  (float) 0 / 0);
    }
    
    @Test
    public void emptyConstructorTest() {
        constructor = new HashMap<Object, String>();
    }
    
    @Test
    public void getTableTest() {
        map.getTable();
    }
    
    @Test
    public void resizeTest() {
        map = new HashMap<Object, String>(8);
        map.put("asd", "asd");
        map.put("asd1", "asd");
        map.put("asd2", "asd");
        map.put("asd3", "asd");
        map.put("asd4", "asd");
        map.put("asd5", "asd");
        map.put("asd6", "asd");
        map.put("asd7", "asd");
    }
    
    @Test(expected = NoSuchElementException.class)
    public void lazyIteratorTest() {
        map.put("asd", "asd");
        map.put("asd1", "asd");
        map.put("asd2", "asd");
        iter = map.entryIterator();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
    }
}
