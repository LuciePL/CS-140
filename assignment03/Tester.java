package assignment03;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class Tester{
    @Test
    public void negotiateTest() {
        Person me = new Person();
        Person them = new Person();
        Negotiator negotiator = new Negotiator();

        Bunny s = new Bunny("s");
        me.getFarm().addBunny(s);
        assertEquals(s, me.getFarm().findBunny("s"));
        me.getFarm().removeBunny(s);
        assertEquals(null, me.getFarm().findBunny("s"));

        Bunny a = new Bunny("a");
        Bunny b = new Bunny("b");
        Bunny c = new Bunny("c");
        Bunny d = new Bunny("d");
        Bunny e = new Bunny("e");
        Bunny f = new Bunny("f");
        me.getFarm().addBunny(a);
        me.getFarm().addBunny(b);
        me.getFarm().addBunny(c);
        them.getFarm().addBunny(d);
        them.getFarm().addBunny(e);
        them.getFarm().addBunny(f);

        negotiator.trade("a", me, them);
        assertEquals(null, me.getFarm().findBunny("a"));
        assertEquals(a, them.getFarm().findBunny("a"));
        assertEquals(b, me.getFarm().findBunny("b"));
        assertEquals(c, me.getFarm().findBunny("c"));
        assertEquals(null, me.getFarm().findBunny("d"));
        assertEquals(null, me.getFarm().findBunny("e"));
        assertEquals(null, me.getFarm().findBunny("f"));
        assertEquals(a, them.getFarm().findBunny("a"));
        assertEquals(null, them.getFarm().findBunny("b"));
        assertEquals(null, them.getFarm().findBunny("c"));
        assertEquals(d, them.getFarm().findBunny("d"));
        assertEquals(e, them.getFarm().findBunny("e"));
        assertEquals(f, them.getFarm().findBunny("f"));

        negotiator.trade("f", them, me);
        assertEquals(f, me.getFarm().findBunny("f"));
        assertEquals(null, them.getFarm().findBunny("f"));
    }
	
	@Test
	public void contestTest() {
		 Person p1 = new Person();
		 p1.getFarm().addBunny(new Bunny("s"));
		 Person p2 = new Person();
		 ArrayList<Person> people = new ArrayList<Person>();
		 people.add(p1);
		 people.add(p2);
		 Contest c = new Contest();
		 assertEquals(p1, c.run(people));
		 p2.getFarm().addBunny(new Bunny("s"));
		 p2.getFarm().addBunny(new Bunny("daa"));
		 assertEquals(p2, c.run(people));
		 Person p3 = new Person();
		 p3.getFarm().addBunny(new Bunny("d"));
		 people.add(p3);
		 assertEquals(p2, c.run(people));
		 p3.getFarm().addBunny(new Bunny("s"));
		 p3.getFarm().addBunny(new Bunny("a"));
		 assertEquals(p2, c.run(people));
		 p3.getFarm().addBunny(new Bunny("adds"));
		 p3.getFarm().addBunny(new Bunny("as"));
		 assertEquals(p3, c.run(people));
	}
}