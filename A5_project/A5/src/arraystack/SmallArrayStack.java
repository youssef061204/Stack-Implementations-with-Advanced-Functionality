package arraystack;

import stacks.Stack;

/**
 * An array-based implementation of the {@code Stack} interface having an
 * upper-limit on the number of elements in the stack.
 */
public class SmallArrayStack extends AbstractArrayStack implements Stack {
    
    /**
     * Initializes this stack to have a fixed-capacity equal to
     * the specified non-negative capacity.
     * 
     * @param capacity the capacity of this stack
     * @throws IllegalArgumentException if {@code capacity < 1}
     */
    public SmallArrayStack(int capacity) {
        super();
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        this.arr = new String[capacity];
    }
    
    /**
     * Initializes this stack by copying another array-based
     * stack. After copying, this stack will have the same
     * size, sequence of elements, and capacity as the copied
     * stack. 
     * 
     * @param other the stack to copy
     */
    public SmallArrayStack(AbstractArrayStack other) {
        super(other);
    }
    
    /**
     * Returns the capacity of this stack.
     * 
     * @return the capacity of this stack
     */
    public int capacity() {
        return this.arr.length;
    }
}