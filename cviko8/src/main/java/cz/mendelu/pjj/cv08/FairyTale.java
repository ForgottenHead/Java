package cz.mendelu.pjj.cv08;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FairyTale {

    public static void main(String[] args) {
        try (var r = new BufferedReader(
                new InputStreamReader
                        (new FileInputStream("monty-python-fairy-tale.txt"), StandardCharsets.UTF_8));
             var w = new FileWriter("postavy.txt")) {

                //regex101.com
                var pattern = Pattern.compile("^(.+?):\\s\\((.+?)\\)");

                String currLine;
                Matcher matcher;
                while ((currLine = r.readLine()) != null) {
                    matcher = pattern.matcher(currLine);
                    if (matcher.find()) {
                        System.out.printf("Postava %s: hra %s\n", matcher.group(1), matcher.group(2));
                        w.write(String.format("Postava %s: hra %s\n", matcher.group(1), matcher.group(2)));
                    }
                }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
