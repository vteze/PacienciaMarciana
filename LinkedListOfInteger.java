package TRAB1PT2;

public class LinkedListOfInteger {

    class Node {
		public int element;
		public Node next;
		public Node prev;
		
		public Node(int element) {
			this.element = element;
			this.next = null;
			this.prev = null;
		}
	}

    Node head;
    Node tail;
    int count;

    public LinkedListOfInteger() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    public void add(int index, int value) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            tail = newNode;
            tail.prev = current;
        }
        count++;
    }

    public int get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public int remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        int value;
        if (index == 0) {
            value = head.element;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            value = current.next.element;
            current.next = current.next.next;
        }
        count--;
        return value;
    }

    public int remove() {
        if (count == 0) {
            throw new IndexOutOfBoundsException();
        }
        int value = tail.element;
        tail = tail.next;
        count--;
        return value;
    }

    public int size() {
        return count;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.element == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(int value) {
        Node current = head;
        for (int i = 0; i < count; i++) {
            if (current.element == value) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf(int value) {
        Node current = head;
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (current.element == value) {
                index = i;
            }
            current = current.next;
        }
        return index;
    }

    public void addFirst(int value) {
        add(0, value);
    }

    public void addLast(int value) {
        add(value);
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove();
    }

    public int getFirst() {
        return get(0);
    }

    public int getLast() {
        return get(count - 1);
    }

    public void set(int index, int value) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = value;
    }
}
