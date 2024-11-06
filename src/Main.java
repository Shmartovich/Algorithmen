//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
        LinkedList<Character> list2 = new LinkedList<>();
        list2.append('a');
        list2.append('m');
        list2.append('o');
        list2.append('g');
        list2.append('u');
        list2.append('s');
        list2.pop();
        list2.pop();
        list2.pop();
        list2.pop();
        list2.pop();
        list2.pop();
        list2.pop();
        list2.append('l');
        list2.print();

        list.revert();
        list.print();
    }
}