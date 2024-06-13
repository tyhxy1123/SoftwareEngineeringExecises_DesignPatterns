package de.klausur.code_playground;

import java.util.*;

public class Test {
    public Test(){
        //call relevant test method here

    }
    public static void main(String[] args) {
        new Test();
    }

    public void addAllTest(){
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        set1.add("String1");
        set1.add("String2");
        set1.add("String3");
        set2.addAll(set1);
        System.out.println(set2);

    }

    public void floatToInteger(){

    }

    public void mapOverwriteTest(){

        Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
        if(map.isEmpty()){
//            Integer j = 0;
            int j = 100;
            while(j > 0){
                char c = 'a';
                List<Character> temp = new LinkedList<Character>();
                for(int i = 0; i < j; i++){
                    temp.add(c);
                    c++;
                }
                map.put(j, temp);
                j--;
            }
        }
        List<Character> list = new LinkedList<Character>();
        char[] chars = "Well done!".toCharArray();
        for(char temp : chars){
            list.add(temp);
        }
        map.put(1, list);
        System.out.println(map);
    }

}
