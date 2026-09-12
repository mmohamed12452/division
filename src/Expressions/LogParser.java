package Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    public static void main(String[] args) {
        String logLine = "[INFO] User alice@example.com logged in from 192.168.1.1";

        // Here is my Regex breakdown
        // \\[ (.*?) \\]         -> Lazy match inside brackets (Level)
        // .*?                   -> Skip text until we find...
        // ([\\w\\.-]+@\\S+)     -> The email pattern
        // .*?                   -> Skip text until we find...
        // (\\d{1,3}(?:\\.\\d{1,3}){3}) -> The IP address
        String regex = "\\[(?<level>.*?)\\]\\s+.*?(?<email>[\\w\\.-]+@[\\w\\.-]+\\.\\w+).*?(?<ip>\\d{1,3}(?:\\.\\d{1,3}){3})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(logLine);

        if (matcher.find()){
            System.out.println("Log Level: " + matcher.group("level"));
            System.out.println("Email: " + matcher.group("email"));
            System.out.println("IP Address: " + matcher.group("ip"));
        }else {
            System.out.println("No match found.");
        }
    }
}
