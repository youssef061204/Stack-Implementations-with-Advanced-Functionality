package arraystack;

import java.util.Arrays;

import stacks.Stack;

/**
 * An abstract class that provides common functionality for array-based stacks.
 */
public abstract class AbstractArrayStack implements Stack {
    // the initial capacity of the stack
    protected static final int DEFAULT_CAPACITY = 16;
    
    // the index of the top element of the stack
    protected int top;
    
    // the array of elements
    protected String[] arr;
    
    /**
     * Initializes an empty stack.
     */
    public AbstractArrayStack() {
        this.top = -1;
        this.arr = new String[DEFAULT_CAPACITY];
    }
    
    /**
     * Initializes this stack by copying another array-based
     * stack. After copying, this stack will have the same
     * size, sequence of elements, and capacity as the copied
     * stack. 
     * 
     * @param other the stack to copy
     */
    protected AbstractArrayStack(AbstractArrayStack other) {
        this.top = other.top;
        this.arr = Arrays.copyOf(other.arr, other.arr.length);
    }
    
    /**
     * Returns the number of elements in this stack.
     * 
     * @return the number of elements in this stack
     */
    @Override
    public int size() {
        return this.top + 1;
    }
    
    /**
     * Pushes an element onto the top of this stack if there is
     * sufficient capacity in this stack's array to store the element.
     * Does nothing and returns false if sufficient capacity is not
     * available.
     * 
     * @param elem the element to push onto this stack
     * @return true if there is sufficient capacity, false otherwise 
     */
    public boolean push(String elem) {
        if (this.size() == this.arr.length) {
            return false;
        }
        this.top++;
        this.arr[this.top] = elem;
        return true;
    }
    
    /**
     * Removes the element on the top of this stack and returns the element.
     * 
     * @return the top element of this stack
     * @throws RuntimeException if the stack is empty
     */
    @Override
    public String pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("popped an empty stack");
        }
        String element = this.arr[this.top];
        this.arr[this.top] = null;
        this.top--;
        return element;
    }
    
    /**
     * Returns a string representation of this stack.
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("top: ");
        if (this.size() != 0) {
            int i = this.size() - 1;
            b.append(this.arr[i]);
            for (i = this.size() - 2; i >= 0; i--) {
                b.append(", ");
                b.append(this.arr[i]);
            }
        }
        b.append(" :bottom");
        return b.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractArrayStack)) {
            return false;
        }
        AbstractArrayStack other = (AbstractArrayStack) obj;
        
        if (this.size() != other.size()) {
            return false;
        }
        
        for (int i = 0; i < this.size(); i++) {
            if (!this.arr[i].equals(other.arr[i])) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < this.size(); i++) {
            hash += this.arr[i].hashCode();
        }
        return hash;
    }
}