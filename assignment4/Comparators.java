package assignment04;

import java.util.Comparator;
import java.util.function.Function;
import java.util.ArrayList;

public class Comparators {

    /**
     * Return a comparator which compares bunny farms where the one with the greater
     * amount of bunnies is considered greater than the other
     */
    public Comparator<BunnyFarm> getBunnyFarmComparator() {
        return Comparator.comparing((BunnyFarm b) -> b.getBunnies().size());
		
    }

    /**
     * Return a comparator for person where it first compares their names.
     * If there names are the same then it compares the amount of bunnies
     * on their farm, where the one with the greatest amount is the larger
     * of the two.
     */
   public Comparator<Person> getPersonComparator() {
        return Comparator.comparing(Person::getName).thenComparing(Comparator.comparing((Person g) -> g.getFarm().getBunnies().size()));
    }

    /**
     * Return a comparator for person where it first compares their names.
     * Then if those are the same then it compares the amount of bunnies
     * on the farm where the greatest amount is the larger of the two.
     * Then if those are the same it compares the length of the names
     * of all the bunnies on the farm, with the greatest sum being
     * the larger of the two.
     */
    public Comparator<Person> getPersonComparatorComplex() {
        return Comparator.comparing(Person::getName).thenComparing(Comparator.comparing((Person g) -> g.getFarm().getBunnies().size())).thenComparing(Comparator.comparing((Person q) -> q.bunnyLength(q)));
    }
}
