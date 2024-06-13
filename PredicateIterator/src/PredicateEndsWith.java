public class PredicateEndsWith<T extends String> implements Predicate<T> {
    @Override
    public boolean predicate(T element, T argument) {
        if(element == null || argument == null) return false;
        if(argument.length() > element.length()) return false;
        int i = argument.length() - 1;
        int j = element.length() - 1;

        while(i >= 0 && j >= 0){
            if(element.charAt(j) != argument.charAt(i)) return false;
            i--;
            j--;
        }

        return true;
    }
}
