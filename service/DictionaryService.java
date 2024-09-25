package CaseStudy.service;

import CaseStudy.entities.Entry;
import CaseStudy.entities.Definition;
import CaseStudy.entities.DefinitionFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DictionaryService {
    private static DictionaryService instance;
    private Map<String, Entry> dictionary;

    private DictionaryService() {
        dictionary = new HashMap<>();
    }

    public static DictionaryService getInstance() {
        if (instance == null) {
            instance = new DictionaryService();
        }
        return instance;
    }

    public void define(String keyword, String type, String meaning, String example, String sentenceMeaning) {
        Entry entry = dictionary.get(keyword);
        if (entry == null) {
            entry = new Entry(keyword);
            dictionary.put(keyword, entry);
        }
        Definition def = DefinitionFactory.createDefinition(type, meaning, example, sentenceMeaning);
        entry.addDefinition(def);
    }

    public Entry lookup(String keyword) {
        return dictionary.get(keyword);
    }

    public boolean drop(String keyword) {
        return dictionary.remove(keyword) != null;
    }

    public void export(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Entry entry : dictionary.values()) {
                writer.write("@" + entry.getKeyword() + "\n");
                for (Definition def : entry.getDefinitions()) {
                    writer.write(def.getType() + "\n");
                    writer.write(def.getMeaning() + "\n");
                    if (!def.getSentence().isEmpty()) {
                        writer.write(def.getSentence() + "\n" + def.getSentenceMeaning() + "\n");
                    }
                }
                writer.write("\n");
            }
        }
    }

    public void loadFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Entry currentEntry = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("@")) {
                    String keyword = line.substring(1).trim();
                    currentEntry = new Entry(keyword);
                    dictionary.put(keyword, currentEntry);
                } else if (currentEntry != null) {
                    String type = line;
                    String meaning = reader.readLine();
                    String sentence = reader.readLine();
                    String sentenceMeaning = reader.readLine();

                    Definition def = DefinitionFactory.createDefinition(type, meaning, sentence, sentenceMeaning);
                    currentEntry.addDefinition(def);
                }
            }
        }
    }

    public void saveToFile(String filePath) throws IOException {
        export(filePath);
    }
}
