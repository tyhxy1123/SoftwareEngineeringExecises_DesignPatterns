public class PredicateLength<T extends String> implements Predicate<T> {
    @Override
    public boolean predicate(T element, T argument) {
        if(element == null || argument == null) return false;
        if(element.length() == Integer.parseInt(argument)) return true;

        else return false;
    }
}
