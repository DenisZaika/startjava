package com.startjava.lesson_2_3_4.method.naming;

public class BooleanMethods {
    
    public boolean shouldContinue() {
        System.out.print(MethodName.getCurrent() +
                "() -> программа выполняется далее или завершается? ");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.print(MethodName.getCurrent() +
                "() -> последовательность содержит уникальную цифру? ");
        return false;
    }

    public boolean isLetter() {
        System.out.print(MethodName.getCurrent() +
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public boolean hasEqualDigits() {
        System.out.print(MethodName.getCurrent() +
                "() -> в проверяемых числах, есть равные цифры? ");
        return false;
    }

    public boolean hasRemainigAttempts() {
        System.out.print(MethodName.getCurrent() +
                "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isEmptyString() {
        System.out.print(MethodName.getCurrent() +
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public boolean isEvenNumber() {
        System.out.print(MethodName.getCurrent() +
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return true;
    }
    
    public boolean isValidFilePath() {
        System.out.print(MethodName.getCurrent() +
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return false;
    }

    public boolean isExistingFile() {
        System.out.print(MethodName.getCurrent() +
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}