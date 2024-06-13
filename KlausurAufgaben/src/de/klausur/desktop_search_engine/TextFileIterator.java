package de.klausur.desktop_search_engine;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TextFileIterator implements Iterator<String> {

    private int charIndex;
    private String fileContent;

    public TextFileIterator(Resource res){

        if(res == null) throw new NullPointerException();

        fileContent = getAsString(res);
    }

    public boolean hasNext(){

        int probe = charIndex;

        while(probe < fileContent.length() && !Character.isLetterOrDigit(fileContent.charAt(probe))) probe++;

        if(probe >= fileContent.length()) return false;

        return true;
    }

    public String next(){

        int beginIndex = charIndex;

        while (charIndex < fileContent.length() && !Character.isLetterOrDigit(fileContent.charAt(charIndex))) {

            charIndex++;
        }

        beginIndex = charIndex;

        while (charIndex < fileContent.length() && Character.isLetterOrDigit(fileContent.charAt(charIndex))) {

            charIndex++;
            if((charIndex + 2) < fileContent.length()){
                if(fileContent.charAt(charIndex) == '-'
                        && fileContent.charAt(charIndex+1) == '\n'){
                    fileContent = fileContent.substring(0, charIndex) + fileContent.substring(charIndex + 2);
                }
            }
        }

        if (charIndex == beginIndex) throw new NoSuchElementException();

        String word = fileContent.substring(beginIndex, charIndex);
//        fileContent = fileContent.substring(charIndex);
//        charIndex = 0;
        return word;
    }

    public void remove(){

        throw new UnsupportedOperationException();
    }

    public String getAsString(Resource res){

        return "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";
    }
}