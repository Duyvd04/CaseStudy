package CaseStudy.entities;

public class Definition {
    private String type;
    private String meaning;
    private String sentence;
    private String sentenceMeaning;

    public Definition(String type, String meaning, String sentence, String sentenceMeaning) {
        this.type = type;
        this.meaning = meaning;
        this.sentence = sentence;
        this.sentenceMeaning = sentenceMeaning;
    }

    public String getType() {
        return type;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getSentence() {
        return sentence;
    }

    public String getSentenceMeaning() {
        return sentenceMeaning;
    }

    @Override
    public String toString() {
        return "Type: " + type + "\n" +
                "Meaning: " + meaning + "\n" +
                "Example: " + sentence + "\n" +
                "Example Meaning: " + sentenceMeaning;
    }
}
