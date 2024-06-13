import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;


public class PredicateIterator<T> {

    private Iterator<T> iter;
    private Predicate<T> pred;
    private T argument;
    private List<T> list;
    private Iterator<T> it;

    public PredicateIterator(Iterator<T> iter, Predicate<T> pred, T argument) {
        this.iter = iter;
        this.pred = pred;
        this.argument = argument;
        list = new LinkedList();
        while(iter.hasNext()){
            T temp = iter.next();
            if(pred.predicate(temp, argument)){
                list.add(temp);
            }
        }
        this.it = list.iterator();

    }

    public boolean hasNext(){

        return it.hasNext();

//        if(!iter.hasNext()) return false;
//        while(iter.hasNext()){
//            T temp = iter.next();
//            if(pred.predicate(temp, argument)){
//                nextValue = temp;
//                return true;
//            }
//            temp = iter.next();
//        }
//        return false;
    }

    public T next(){

        if(it.hasNext()){
            return it.next();
        }
        else throw new NoSuchElementException();
//        if(iter.hasNext()){
//            T temp = iter.next();
//            if(pred.predicate(temp, argument)){
//                nextValue = temp;
//                return temp;
//            }
//        }
//        throw new NoSuchElementException();
    }

    public void remove(){
        return;
    }
}
