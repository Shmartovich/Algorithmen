public class Main {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        list.append('a');
        list.append('m');
        list.append('o');
        list.append('g');
        list.append('u');
        list.append('s');
        list.print();

        LinkedListDoubly<Character> linkedListDoubly = new LinkedListDoubly<>();
        linkedListDoubly.append('a');
        linkedListDoubly.append('m');
        linkedListDoubly.append('o');
        linkedListDoubly.append('g');
        linkedListDoubly.append('u');
        linkedListDoubly.append('s');
        linkedListDoubly.revert();
        linkedListDoubly.print();
    }
}