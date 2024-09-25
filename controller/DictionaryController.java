package CaseStudy.controller;


import CaseStudy.entities.Entry;
import CaseStudy.service.DictionaryService;

public class DictionaryController {
    private DictionaryService service = DictionaryService.getInstance();

    public Entry lookup(String keyword) {
        return service.lookup(keyword);
    }

    public void define(String keyword, String type, String meaning, String sentence, String sentenceMeaning) {
        service.define(keyword, type, meaning, sentence, sentenceMeaning);
    }

    public boolean drop(String keyword) {
        return service.drop(keyword);
    }

    public void export(String filePath) throws Exception {
        service.export(filePath);
    }
}
