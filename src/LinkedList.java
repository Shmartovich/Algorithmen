public class LinkedList<T> {
    LinkedElement<T> head;
    LinkedElement<T> tail;

    class LinkedElement<T> {
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
            tail = newElem;
        } else {
            LinkedElement<T> lastEl = head;
            while (lastEl.next != null) {
                lastEl = lastEl.next;
            }
            lastEl.next = newElem;
            tail = lastEl;
        }
    }

    //am anfang anhängen
    public void prepend(T e) {
        LinkedElement<T> newElem = new LinkedElement<>();
        newElem.data = e;
        newElem.next = null;

        if (head == null) {
            head = newElem;
            tail = newElem;
        } else {
            newElem.next = head;
            head = newElem;
        }
    }

    //get and delete last
    //todo with tail
    T pop() {
        if (head == null) {
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
    /*

    3) (geht nur bei doppelt verketteter Liste) symmetrischer Tausch der next/prev-Zeiger
    (sehr einfache Übung, falls man schon eine Doppelverkettung hat)
    */
    //Zeiger umbiegen
    void revert() {
        if (head == null) {
            System.out.println("nothing to revert");
            return;
        }
        LinkedElement<T> actualEl = head;
        LinkedElement<T> previous = null;
        while (actualEl.next != null) {
            LinkedElement<T> nextEl = actualEl.next;
            actualEl.next = previous;
            previous = actualEl;
            actualEl = nextEl;
        }
        actualEl.next = previous;
        head = actualEl;
    }
    //print-artiger Durchlauf
    void revertWithPrepend(){
        LinkedList<T> newList = new LinkedList<>();
        LinkedElement<T> temp = head;
        while(temp != null){
            newList.prepend(temp.data);
            temp = temp.next;
        }
        temp = newList.getHead();
        while(temp != null){
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public void print() {
        LinkedElement<T> el = head;
        while (el != null) {
            System.out.print(el.data);
            el = el.next;
        }
        System.out.println();
    }

    //recursive print
    public void rprint(LinkedElement<T> el) {
        if (el != null) {
            //print list reverted
            /*
            System.out.print(el.data);
            rprint(el.next);
            */
            System.out.print(el.data);
            rprint(el.next);
        } else {
            System.out.println();
        }
    }

    public LinkedElement<T> getHead() {
        return head;
    }
}
