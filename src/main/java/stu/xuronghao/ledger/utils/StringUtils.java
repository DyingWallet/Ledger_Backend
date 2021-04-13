package stu.xuronghao.ledger.utils;

public class StringUtils {
    public static boolean EmptyString(String str) {
        return str == null || "".equals(str);
    }

    public static String format(String des, String... strArr) {
        String[] tmp = des.split(ConstantVariable.FORMAT_REGEX_PATTERN);
        StringBuilder desBuilder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            desBuilder.append(tmp[i]).append(strArr[i]);
        }
        return desBuilder.toString();
    }

}