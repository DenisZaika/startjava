public class Verifier {
    
    public boolean shouldContinue() {
        System.out.print(Reflector.getCurrMethodName() +
                "() -> программа выполняется далее или завершается? ");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.print(Reflector.getCurrMethodName() +
                "() -> последовательность содержит уникальную цифру? ");
        return false;
    }

    public boolean isLetter() {
        System.out.print(Reflector.getCurrMethodName() +
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public boolean hasEqualDigits() {
        System.out.print(Reflector.getCurrMethodName() +
                "() -> в проверяемых числах, есть равные цифры? ");
        return false;
    }

    public boolean hasRemainigAttempts() {
        System.out.print(Reflector.getCurrMethodName() +
                "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isEmptyString() {
        System.out.print(Reflector.getCurrMethodName() +
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public boolean isEvenNumber() {
        System.out.print(Reflector.getCurrMethodName() +
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return true;
    }
    
    public boolean isValidFilePath() {
        System.out.print(Reflector.getCurrMethodName() +
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return false;
    }

    public boolean isExistingFile() {
        System.out.print(Reflector.getCurrMethodName() +
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}