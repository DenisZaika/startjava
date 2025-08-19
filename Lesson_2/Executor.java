public class Executor {
    
    public static void main(String[] args) {
        Processor processor = new Processor();
        Verifier verifier = new Verifier();
        executeProcessorMethods(processor);
        executeVerifierMethods(verifier);
    }

    public static void executeProcessorMethods(Processor processor) {
        System.out.println("\n1. HЕ BOOLEAN-МЕТОДЫ");
        processor.findLongestWord();
        processor.selectMenuItem();
        processor.calculateAverageGrade();
        processor.countUniqueWords();
        processor.showErrorMessage();
        processor.syncDataWithCloud();
        processor.restoreFromBackup();
        processor.pauseDownload();
        processor.resetSettings();
        processor.writeToFile();
        processor.convertCelsiusToFahrenheit();
        processor.enterMathExpression();
        processor.determineRaceWinner();
        processor.findBookByAuthor();
    }

    public static void executeVerifierMethods(Verifier verifier) {
        System.out.println("\n2. BOOLEAN-МЕТОДЫ");
        System.out.println(verifier.shouldContinue());
        System.out.println(verifier.hasUniqueDigit());
        System.out.println(verifier.isLetter());
        System.out.println(verifier.hasEqualDigits());
        System.out.println(verifier.hasRemainigAttempts());
        System.out.println(verifier.isEmptyString());
        System.out.println(verifier.isEvenNumber());
        System.out.println(verifier.isValidFilePath());
        System.out.println(verifier.isExistingFile());
    }
}