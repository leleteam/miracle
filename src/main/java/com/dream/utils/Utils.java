package com.dream.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String generateSourceId(String head){
        String clientid = head + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmssnnnnnnnnn")).substring(0, 16);
        return clientid;
    }
}
