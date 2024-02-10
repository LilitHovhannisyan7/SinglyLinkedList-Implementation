
//Singly-Linked list
//Required: push_back(val), push_front(val), pop_back(), pop_front(), search(val)
//Other: insert(position, val), delete(pos), insert(pos, singly_linked_list)
//For C++ -> all ctor and dtor functionality.
//If I missed some functionality for both DS, just add them as discussed during the lecture.
class MySingleLinkedList<T>
{
    static class Node<T>
    {
        T value;
        Node<T> next;
        Node(T value)
        {
            this.value = value;
        }
    }
    private Node <T> head;

    public Node<T> getHead()
    {
        return this.head;
    }
    public void pushBack(T val)
    {
        Node<T> node = new Node<>(val);
        if(this.head == null)
        {
            this.head = node;
            this.head.next = null;
        }
        else
        {
            Node<T> current = this.head;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = node;
            node.next = null;
        }
    }

    public void pushFront(T val)
    {
        Node<T> node = new Node<>(val);
        if(this.head == null)
        {
            this.head = node;
        }
        else
        {
            node.next = this.head;
            this.head = node;
        }
    }

    public Node<T> popBack()
    {
        if(this.head == null)
        {
            throw new RuntimeException("Invalid");
        }
        else
        {
            Node<T> current = this.head;
            while(current.next.next != null)
            {
                current = current.next;
            }
            Node<T> temp = current.next;
            current.next = null;
            return temp;
        }
    }
    public Node<T> popFront()
    {
        if(this.head == null)
        {
            throw new RuntimeException("Invalid");
        }
        else
        {
            Node<T> temp = this.head;
            this.head = this.head.next;
            return temp;
        }
    }

    public int search(T val)
    {
        Node<T> current = this.head;
        int index = 0;
        while(current != null)
        {
            if(current.value.equals(val))
            {
                return index;
            }
            ++index;
            current = current.next;
        }
        return - 1;
    }

    public void insert(int pos, T val)
    {
        if(pos < 0 || pos > this.getSize())
        {
            throw new RuntimeException("Invalid position");
        }
        else if(pos == this.getSize())
        {
            this.pushBack(val);
        }
        else if(pos == 0)
        {
            this.pushFront(val);
        }
        else {
            Node<T> current = head;
            Node<T> node = new Node<>(val);
            int count = 0;
            while (count != pos - 1) {
                current = current.next;
                ++count;
            }
            Node<T> temp = current.next;
            current.next = node;
            node.next = temp;
        }
    }


    public void insert(int pos, MySingleLinkedList<T> list)
    {
        if(pos < 0 || pos > this.getSize())
        {
            throw new RuntimeException("Invalid position");
        }
        int i = 0;
        Node<T> current = list.head;
        while(current != null)
        {
            this.insert(pos, current.value);
            current = current.next;
            pos = pos + i;
        }
    }
    public int getSize()
    {
        Node current = this.head;
        int count = 0;
        while(current != null)
        {
            ++count;
            current = current.next;
        }
        return count;
    }

    public Node<T> delete(int pos)
    {
        if(pos < 0 || pos >= this.getSize())
        {
            throw new RuntimeException("Invalid position");
        }
        Node<T> current = head;
        int count = 0;
        while(count != pos - 1)
        {
            current = current.next;
            ++count;
        }
        Node<T> temp = current.next;
        current.next = current.next.next;
        return temp;
    }

    @Override
    public String toString()
    {
        Node current = this.head;
        StringBuilder sBuild = new StringBuilder();
        while(current != null)
        {
            sBuild.append(current.value + " ");
            current = current.next;
        }
        return sBuild.toString();
    }

}

public class Main
{
    public static void main(String [] args)
    {
        MySingleLinkedList<Integer> linkedList = new MySingleLinkedList<>();

        linkedList.pushBack(1);
        linkedList.pushBack(2);
        linkedList.pushFront(0);
        linkedList.pushBack(3);
        System.out.println(linkedList);

        //MySingleLinkedList.Node<Integer> poppedFront = linkedList.popFront();
        System.out.println(linkedList.popFront().value);
        System.out.println(linkedList);

        //MySingleLinkedList.Node<Integer> poppedBack = linkedList.popBack();
        System.out.println(linkedList.popBack().value);
        System.out.println(linkedList);

        int searchIndex = linkedList.search(2);
        System.out.println(searchIndex);

        linkedList.insert(1, 10);
        System.out.println(linkedList);


        //MySingleLinkedList.Node<Integer> deletedNode = linkedList.delete(2);
        System.out.println(linkedList.delete(1).value);
        System.out.println(linkedList);

        MySingleLinkedList<Integer> secondList = new MySingleLinkedList<>();
        secondList.pushBack(100);
        secondList.pushBack(200);
        secondList.pushBack(300);

        linkedList.insert(0, secondList);
        System.out.println(linkedList);


    }
}