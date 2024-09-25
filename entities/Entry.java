package CaseStudy.entities;

import java.util.LinkedList;

public class Entry {
    private String keyword;
    private LinkedList<Definition> definitions;

    public Entry(String keyword) {
        this.keyword = keyword;
        this.definitions = new LinkedList<>();
    }

    public String getKeyword() {
        return keyword;
    }

    public LinkedList<Definition> getDefinitions() {
        return definitions;
    }

    public void addDefinition(Definition def) {
        this.definitions.add(def);
    }

    public boolean removeDefinition(String type) {
        return definitions.removeIf(d -> d.getType().equals(type));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Keyword: ").append(keyword).append("\n");

        if (definitions.isEmpty()) {
            result.append("No definitions available.\n");
        } else {
            for (Definition definition : definitions) {
                result.append(definition.toString()).append("\n");
            }
        }

        return result.toString();
    }
}
