package linkedstack;

import java.util.function.BiPredicate;

/**
 * A predicate that tests if one string is "less than" another string. A string
 * {@code t} is less than another string {@code u} if {@code t} comes before
 * {@code u} when compared in lexicographical (dictionary) order.
 */
public class StringLessThan implements BiPredicate<String, String> {
    @Override
    public boolean test(String t, String u) {
        return t.compareTo(u) < 0;
    }
}
