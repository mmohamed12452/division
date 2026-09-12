package Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigParser {
    public static void main(String[] args) {
        String regex = "^([a-z]+)\\s*=\\s*(?:(\"(?>[^\"\\\\]|\\\\.)*\")|(-?\\d+)|(true|false))\\s*;$";
        Pattern pattern = Pattern.compile(regex);

        String[] tests = {
                "name = \"Mr.Bryson \\\"Session workshop\\\"\";", // Valid string with escaped quotes
                "age = -25;",                         // Valid negative int
                "active = true;",                    // Valid boolean
                "price = 12.34;",                    // Invalid (float)
                "title = \"unclosed;",               // Invalid (missing quote)
                "key = \"bad escape \\\" ;"           // Invalid (last quote escaped)
        };
        for (String test : tests) {
            Matcher m = pattern.matcher(test);
            if (m.find()) {
                String key = m.group(1);
                String type = "";
                String value = "";
            }
            for (String testing : tests) {
                Matcher ms = pattern.matcher(test);
                if (m.find()) {
                    String key = m.group(1);
                    String type = "";
                    String value = "";

                    if (m.group(2) != null) {
                        type = "STRING";
                        value = m.group(2);
                    } else if (m.group(3) != null) {
                        type = "INTEGER";
                        value = m.group(3);
                    } else if (m.group(4) != null) {
                        type = "BOOLEAN";
                        value = m.group(4);
                    }
                    System.out.printf("MATCH: Key: %s | Type: %s | Value: %s%n", key, type, value);
                } else {
                    System.out.println("REJECTED: " + test);
                }

            }
        }
    }
}
