package de.klausur.desktop_search_engine;

import java.util.Set;

public interface KeywordCollector{
    Set<String> getKeywords(Resource res);
}