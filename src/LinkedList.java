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
    1) ... als direkte Listenmanipulation ("Zeiger umbiegen"; Standard-Aufgabe)
    2) ... als print-artiger Durchlauf durch die Liste mit gleichzeitigem prepend der
    Elemente in eine Hilfsliste (entspricht Neuaufbau; Vorteil: die alte Liste existiert danach
    weiter; Nachteil: es wird doppelt soviel Speicher belegt)
    3) (geht nur bei doppelt verketteter Liste) symmetrischer Tausch der next/prev-Zeiger
    (sehr einfache Übung, falls man schon eine Doppelverkettung hat)
    */
    void revert() {
        if (head == null) {
            System.out.println("nothing to revert");
            return;
        }
        LinkedElement<T> temp = head;
        LinkedElement<T> previous = head;
        while (temp.next != null) {
            LinkedElement<T> nextEl = temp.next;
            LinkedElement<T> nextElNext = nextEl.next;
            nextEl.next = temp;
            previous = nextEl;
            temp = nextElNext;
            nextElNext.next = previous;


        }
        head.next = null;
        temp.next = previous;
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
