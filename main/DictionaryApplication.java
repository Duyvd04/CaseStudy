package CaseStudy.main;

import CaseStudy.controller.DictionaryController;
import CaseStudy.service.DictionaryService;

import java.util.Scanner;

public class DictionaryApplication {
    public static void main(String[] args) {
        DictionaryController dictionaryController = new DictionaryController();
        Scanner scanner = new Scanner(System.in);

        String dictionaryFilePath = "D:/Duy/codegym/baitap/module2/src/CaseStudy/resources/dictionary/dictionary.txt";
        try {
            DictionaryService.getInstance().loadFromFile(dictionaryFilePath);
            System.out.println("Dictionary loaded from file.");
        } catch (Exception e) {
            System.out.println("Error loading dictionary: " + e.getMessage());
        }

        while (true) {
            System.out.println("\nChoose an action: [lookup | define | drop | export | import | exit]");
            String action = scanner.nextLine().trim();

            switch (action) {
                case "lookup":
                    System.out.print("Enter keyword to lookup: ");
                    String keyword = scanner.nextLine();
                    System.out.println("Result: " + dictionaryController.lookup(keyword));
                    break;

                case "define":
                    System.out.print("Enter keyword: ");
                    keyword = scanner.nextLine();
                    System.out.print("Enter type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter meaning: ");
                    String meaning = scanner.nextLine();
                    System.out.print("Enter example sentence: ");
                    String sentence = scanner.nextLine();
                    System.out.print("Enter sentence meaning: ");
                    String sentenceMeaning = scanner.nextLine();

                    dictionaryController.define(keyword, type, meaning, sentence, sentenceMeaning);
                    System.out.println("Definition added.");
                    break;

                case "drop":
                    System.out.print("Enter keyword to drop: ");
                    keyword = scanner.nextLine();
                    boolean dropped = dictionaryController.drop(keyword);
                    System.out.println(dropped ? "Dropped successfully." : "Keyword not found.");
                    break;

                case "export":
                    String exportPath = "D:/Duy/codegym/baitap/module2/src/CaseStudy/resources/dictionary/dictionary.txt";
                    try {
                        dictionaryController.export(exportPath);
                        System.out.println("Exported to " + exportPath);
                    } catch (Exception e) {
                        System.out.println("Failed to export: " + e.getMessage());
                    }
                    break;

                case "import":
                    String importPath = "D:/Duy/codegym/baitap/module2/src/CaseStudy/resources/dictionary/dictionary2.txt";
                    try {
                        DictionaryService.getInstance().loadFromFile(importPath);
                        System.out.println("Dictionary loaded from " + importPath);
                    } catch (Exception e) {
                        System.out.println("Failed to import: " + e.getMessage());
                    }
                    break;

                case "exit":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid action. Please try again.");
            }
        }
    }
}
