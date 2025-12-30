public class Stack {

    private Node top;
    public int size = 0;

    public Stack() {
        top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {

        if (isEmpty()){
            return -1;
        }
        
        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
