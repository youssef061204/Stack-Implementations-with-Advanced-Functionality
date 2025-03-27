package linkedstack;

import java.util.function.Predicate;

/**
 * A predicate that tests if a string starts with a specified character.
 */
public class StringStartsWith implements Predicate<String> {
    private final char ch;
    
    /**
     * Initializes this predicate to test if strings start with the specified character.
     * 
     * @param ch the character to test for
     */
    public StringStartsWith(char ch) {
        this.ch = ch;
    }
    
    @Override
    public boolean test(String t) {
        return !t.isEmpty() && t.charAt(0) == ch;
    }
}