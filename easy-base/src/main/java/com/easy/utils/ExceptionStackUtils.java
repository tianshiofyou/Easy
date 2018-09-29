package com.easy.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionStackUtils {
    public static String getStackTrace(Throwable anexcepObj) {
        try (StringWriter sw = new StringWriter();
             PrintWriter printWriter = new PrintWriter(sw)) {
            if (anexcepObj != null) {
                anexcepObj.printStackTrace(printWriter);
                printWriter.flush();
                sw.flush();
                return sw.toString();
            } else {
                return "";
            }
        } catch (IOException e) {
            return "";
        }
    }
}
