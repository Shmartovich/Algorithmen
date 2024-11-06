public class LinkedList<T> {
    private LinkedElement<T> head;

    private class LinkedElement<T> {
        T data;
        LinkedElement<T> next;
    }

    //am ende anhängen
    public void append(T e) {
        LinkedElement<T> newElem = new LinkedElement<>();
        newElem.data = e;
        newElem.next = null;

        if (head == null) {
            head = newElem;
        } else {
            LinkedElement<T> lastEl = head;
            while (lastEl.next != null) {
                lastEl = lastEl.next;
            }
            lastEl.next = newElem;
        }
    }

    //am anfang anhängen
    public void prepend(T e) {
        LinkedElement<T> newElem = new LinkedElement<>();
        newElem.data = e;
        newElem.next = null;

        if (head != null) {
            newElem.next = head;
        } else {
            head = newElem;
        }
    }

    //get and delete last
    T pop() {
        if(head==null){
            return null;
        }
        LinkedElement<T> temp = head;
        LinkedElement<T> lastEl = temp;
        if (temp.next == null) {
            head = null;
            return temp.data;
        }
        while (temp.next != null) {
            lastEl = temp;
            temp = temp.next;
        }
        lastEl.next = null;
        return temp.data;
    }
    //todo revert amogus -> sugoma
    void revert(){
        if (head == null) {
            return;
        }
        LinkedElement<T> tail = head;

        LinkedElement<T> temp = head;
        while (temp.next != null) {
            LinkedElement<T> previous = temp;
            LinkedElement<T> actualElNext = temp.next;
            if(actualElNext.next==null){
                tail = actualElNext;
                actualElNext.next = temp;
            }
            else{
                actualElNext.next = previous;
                temp = temp.next;
            }
        }
        head = temp;
    }

    public void print() {
        LinkedElement<T> el = head;
        while (el != null) {
            System.out.print(el.data);
            el = el.next;
        }
        System.out.println();
    }
}
