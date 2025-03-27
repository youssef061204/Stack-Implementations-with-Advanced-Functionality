package linkedstack;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import stacks.Stack;

/**
 * A linked list-based implementation of the {@code Stack} interface.
 *
 */
public class LinkedStack implements Stack {
    // the number of elements currently on the stack
    private int size;

    // the node containing the top element of the stack
    private Node top;

    private class Node {
        // the element stored in the node
        String elem;

        // the link to the next node in the sequence
        Node next;

        Node(String elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    /**
     * Initializes an empty stack.
     */
    public LinkedStack() {
        this.size = 0;
        this.top = null;
    }

    /**
     * Initializes this stack so that it has the specified top,
     * middle, and bottom elements.
     * 
     * @param top the string at the top of this stack
     * @param middle the string in the middle of this stack
     * @param bottom the string at the bottom of this stack
     */
    public LinkedStack(String top, String middle, String bottom) {
        this.size = 3;
        this.top = new Node(top, new Node(middle, new Node(bottom, null)));
    }

    /**
     * Returns the number of elements in this stack.
     * 
     * @return the number of elements in this stack
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Pushes the specified element on to the top of this stack. Such operations
     * always succeed.
     * 
     * @param elem the element to be pushed on to the top of this stack
     * @return true
     */
    @Override
    public boolean push(String elem) {
        Node n = new Node(elem, this.top);
        this.top = n;
        this.size++;
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
        String popped = this.top.elem;
        this.top = this.top.next;
        this.size--;
        return popped;
    }

    /**
     * Returns the element on the top of this stack without removing it from the stack.
     * 
     * @return the top element of this stack
     * @throws RuntimeException if the stack is empty
     */
    public String peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("peeked at an empty stack");
        }
        return this.top.elem;
    }

    /**
     * Returns a string representation of this stack. The elements of the stack
     * appear in the returned string in sequence starting from the top of the stack
     * to the bottom of the stack with each element separated from the next using a
     * newline character.
     * 
     * @return a string representation of this stack
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("top: ");
        if (this.size() != 0) {
            Node n = this.top;
            b.append(n.elem);
            for (int i = 1; i < this.size(); i++) {
                n = n.next;
                b.append(", ");
                b.append(n.elem);
            }
        }
        b.append(" :bottom");
        return b.toString();
    }

    /**
     * Pushes {@code elem} onto the top of this stack if and only if {@code elem}
     * satisfies the predicate {@code p}.
     * 
     * @param elem a string
     * @param p    a predicate
     * @return {@code true} if {@code elem} satisfies the predicate {@code p},
     *         {@code false} otherwise
     */
    public boolean pushIf(String elem, Predicate<String> p) {
        if (p.test(elem)) {
            return this.push(elem);
        }
        return false;
    }

    /**
     * Pushes {@code elem} onto the top of this stack if and only if {@code elem}
     * and the top element of the stack satisfy the bi-predicate {@code p}.
     * 
     * <p>
     * There must be at least one element on this stack when calling this
     * method, otherwise an exception is thrown.
     * 
     * @param elem a string
     * @param p    a bi-predicate
     * @return {@code true} if {@code elem} and the top element of the stack satisfy
     *         the bi-predicate {@code p}, {@code false} otherwise
     * @throws IllegalArgumentException if this stack is empty
     */
    public boolean pushIf(String elem, BiPredicate<String, String> p) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (p.test(elem, this.top.elem)) {
            return this.push(elem);
        }
        return false;
    }

    /**
     * Moves the bottom element to the top of the stack leaving the
     * relative order of the other elements unchanged.
     */
    public void bottomsUp() {
        if (this.size < 2) {
            return;
        }
        
        Node current = this.top;
        Node prev = null;
        
        // Find the second last node
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        
        // Move bottom to top
        current.next = this.top;
        this.top = current;
        prev.next = null;
    }
}