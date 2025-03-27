package arraystack;

import java.util.Arrays;

import stacks.Stack;

/**
 * An array-based implementation of the {@code Stack} interface
 * having no upper-limit on the number of elements in the stack.
 */
public class ArrayStack extends AbstractArrayStack implements Stack {
    
    /**
     * Initializes an empty stack.
     */
    public ArrayStack() {
        super();
    }
    
    /**
     * Initializes this stack by copying another array-based
     * stack. After copying, this stack will have the same
     * size, sequence of elements, and capacity as the copied
     * stack. 
     * 
     * @param other the stack to copy
     */
    public ArrayStack(AbstractArrayStack other) {
        super(other);
    }
    
    /**
     * Pushes an element onto the top of this stack.
     * 
     * @param elem the element to push onto this stack
     * @return true 
     */
    @Override
    public boolean push(String elem) {
        if (this.size() == this.arr.length) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }
        return super.push(elem);
    }
}