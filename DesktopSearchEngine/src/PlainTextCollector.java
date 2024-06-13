import java.util.HashSet;
import java.util.Set;

public class PlainTextCollector implements KeywordCollector{
    @Override
    public Set<String> getKeywords(Resource res) {
        Set<String> set = new HashSet<String>();
//        set.addAll(new DefaultCollector().getKeywords(res));
        TextFileIterator iterator = new TextFileIterator(res);
        String fileContent = iterator.getAsString(res);
        //process the String from Iterator, split it into different single words.
        //store all words into set
        /*
        * Insert code here
        */
        set.add(fileContent);
        return set;
    }
}