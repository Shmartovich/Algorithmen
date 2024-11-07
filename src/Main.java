public class Main {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        list.prepend('a');
        list.prepend('m');
        list.prepend('o');
        list.prepend('g');
        list.prepend('u');
        list.prepend('s');
        list.print();

        //list.revert();

        list.rprint(list.getHead());
    }
}