package de.klausur.desktop_search_engine;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Resource res = new Resource("Test1", "/lsjdf/sjf", new ResourceType("test", new PlainTextCollector()));
        DesktopSearch ds = new DesktopSearch();
        ds.registerResource(res);
        ds.registerType("txt", res.getType());
        List<Resource> list = ds.processRequest("well");
        PlainTextCollector ptc = new PlainTextCollector();
        Set<String> set = ptc.getKeywords(res);
        System.out.println(set);
    }
}
