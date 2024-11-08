public class LinkedListDoubly <T>{
    private LinkedElementDoubly<T> head;
    private LinkedElementDoubly<T> tail;

    class LinkedElementDoubly<T>{
        private T data;
        private LinkedElementDoubly<T> previous;
        private LinkedElementDoubly<T> next;
    }
    //am ende anhängen
    public void append(T e) {
        LinkedElementDoubly<T> newElem = new LinkedElementDoubly<>();
        newElem.data = e;
        newElem.next = null;
        newElem.previous = null;

        if(tail == null || head == null){
            head = newElem;
            tail = newElem;
        }
        else{
            tail.next = newElem;
            newElem.previous = tail;
            tail = newElem;
        }
    }
    //todo der rest unten bearbeiten
    //todo Löschen eines Referenzelements leicht (bzw. direkt) möglich
    //todo Einfügen vor und nach einem Referenzelement möglich
    public void prepend(T e) {
        LinkedElementDoubly<T> newElem = new LinkedElementDoubly<>();
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
        LinkedElementDoubly<T> temp = head;
        LinkedElementDoubly<T> lastEl = temp;
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
    void revert() {
        LinkedElementDoubly<T> actual = head;
        LinkedElementDoubly<T> temp = head;
        while(actual != null){
            LinkedElementDoubly<T> next = actual.next;

            temp = actual.next;
            actual.next = actual.previous;
            actual.previous = temp;

            actual = next;
        }
        temp = head;
        head = tail;
        tail = temp;
    }

    public void print() {
        LinkedElementDoubly<T> actual = head;
        while (actual != null) {
            System.out.print(actual.data);
            actual = actual.next;
        }
        System.out.println();
    }

    //recursive print
    public void rprint(LinkedElementDoubly<T> el) {
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

    public LinkedElementDoubly<T> getHead() {
        return head;
    }
}
