public class MethodName {

    public static String getCurrent() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}