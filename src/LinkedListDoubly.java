public class LinkedListDoubly <T> extends LinkedList <T>{
    LinkedElementDoubly<T> tail;

    //todo doubly LinkedList
    class LinkedElementDoubly<T> extends LinkedElement<T>{
        LinkedElementDoubly<T> previous;
    }
    //am ende anhängen
    @Override
    public void append(T e) {
        LinkedElementDoubly<T> newElem = new LinkedElementDoubly<>();
        newElem.data = e;
        newElem.next = null;

        if(tail != null){
            tail.next = newElem;
            newElem.previous = tail;
            tail = newElem;
        }
        else{
            head = newElem;
            tail = newElem;
        }
    }
    //todo der rest unten bearbeiten
    //todo Löschen eines Referenzelements leicht (bzw. direkt) möglich
    //todo Einfügen vor und nach einem Referenzelement möglich
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
