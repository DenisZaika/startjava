public class Main {
    
    public static void main(String[] args) {
        doNonBooleanMethods();
        doBooleanMethods();
    }

    private static void doNonBooleanMethods() {
        NonBooleanMethods nonBm = new NonBooleanMethods();
        System.out.println("\n1. HЕ BOOLEAN-МЕТОДЫ");
        nonBm.findLongestWord();
        nonBm.selectMenuItem();
        nonBm.calculateAverageGrade();
        nonBm.countUniqueWords();
        nonBm.showErrorMessage();
        nonBm.syncDataWithCloud();
        nonBm.restoreFromBackup();
        nonBm.pauseDownload();
        nonBm.resetSettings();
        nonBm.writeToFile();
        nonBm.convertCelsiusToFahrenheit();
        nonBm.enterMathExpression();
        nonBm.determineRaceWinner();
        nonBm.findBookByAuthor();
    }

    private static void doBooleanMethods() {
        BooleanMethods bm = new BooleanMethods();
        System.out.println("\n2. BOOLEAN-МЕТОДЫ");
        System.out.println(bm.shouldContinue());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isLetter());
        System.out.println(bm.hasEqualDigits());
        System.out.println(bm.hasRemainigAttempts());
        System.out.println(bm.isEmptyString());
        System.out.println(bm.isEvenNumber());
        System.out.println(bm.isValidFilePath());
        System.out.println(bm.isExistingFile());
    }
}