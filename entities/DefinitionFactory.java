package CaseStudy.entities;


public class DefinitionFactory {
    public static Definition createDefinition(String type, String meaning, String sentence, String sentenceMeaning) {
        return new Definition(type, meaning, sentence, sentenceMeaning);
    }
}
