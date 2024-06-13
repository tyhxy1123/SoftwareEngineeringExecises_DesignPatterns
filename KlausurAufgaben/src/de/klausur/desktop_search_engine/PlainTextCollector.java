package de.klausur.desktop_search_engine;

import java.util.*;
public class PlainTextCollector implements KeywordCollector{
    @Override
    public Set<String> getKeywords(Resource res) {

        if(res == null) throw new NullPointerException();

        Set<String> set = new HashSet<String>();
        TextFileIterator iterator = new TextFileIterator(res);

        while(iterator.hasNext()){

            String word = iterator.next();
            if(word != null) set.add(word);
        }

        return set;
    }
}