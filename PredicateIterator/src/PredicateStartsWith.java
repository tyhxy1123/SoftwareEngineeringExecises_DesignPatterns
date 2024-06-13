public class PredicateStartsWith<T extends String> implements Predicate<T> {
    @Override
    public boolean predicate(T element, T argument) {
        if(element == null || argument == null) return false;
        if(argument.length() > element.length()) return false;
        int i = 0;
        int eL = element.length();
        int aL = argument.length();
        while(i < eL && i < aL){
            if(element.charAt(i) != argument.charAt(i)) return false;
            i++;
        }
        return true;
    }
}
