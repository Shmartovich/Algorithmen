public class ArrayQueue <T> extends LinkedList<T>{
    public void enqueue(T e){
        prepend(e);
    }

    public T dequeue( ){
        return pop();
    }

    /*todo Schreiben Sie eine entsprechende Test-Klasse, die Ihren Ringpuffer nutzt, indem sie
einige Nutzdaten (vorzugsweise: Character) speichert und wieder zuückholt.
● Testen Sie das Wrap-Around-Verhalten Ihres Ringpuffers.
● Testen Sie die "Überfüllung" (Was kann man dabei machen? Was macht Ihre Lösung?)
*/

}
