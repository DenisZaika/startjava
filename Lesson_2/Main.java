public class Main {
    
    public static void main(String[] args) {
        doNonBooleanMethods();
        doBooleanMethods();
    }

    private static void doNonBooleanMethods() {
        NonBooleanMethods nonBooleanMethods = new NonBooleanMethods();
        System.out.println("\n1. HЕ BOOLEAN-МЕТОДЫ");
        nonBooleanMethods.findLongestWord();
        nonBooleanMethods.selectMenuItem();
        nonBooleanMethods.calculateAverageGrade();
        nonBooleanMethods.countUniqueWords();
        nonBooleanMethods.showErrorMessage();
        nonBooleanMethods.syncDataWithCloud();
        nonBooleanMethods.restoreFromBackup();
        nonBooleanMethods.pauseDownload();
        nonBooleanMethods.resetSettings();
        nonBooleanMethods.writeToFile();
        nonBooleanMethods.convertCelsiusToFahrenheit();
        nonBooleanMethods.enterMathExpression();
        nonBooleanMethods.determineRaceWinner();
        nonBooleanMethods.findBookByAuthor();
    }

    private static void doBooleanMethods() {
        BooleanMethods booleanMethods = new BooleanMethods();
        System.out.println("\n2. BOOLEAN-МЕТОДЫ");
        System.out.println(booleanMethods.shouldContinue());
        System.out.println(booleanMethods.hasUniqueDigit());
        System.out.println(booleanMethods.isLetter());
        System.out.println(booleanMethods.hasEqualDigits());
        System.out.println(booleanMethods.hasRemainigAttempts());
        System.out.println(booleanMethods.isEmptyString());
        System.out.println(booleanMethods.isEvenNumber());
        System.out.println(booleanMethods.isValidFilePath());
        System.out.println(booleanMethods.isExistingFile());
    }
}