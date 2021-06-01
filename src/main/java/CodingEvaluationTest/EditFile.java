package analytics.testing.PerformanceTest.MathUtils;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;

public class EditFile {
    public static void main(String[] args) throws IOException {

        BufferedReader fr = new BufferedReader(new FileReader("out.txt"));
        String date = fr.readLine();
        String time = fr.readLine();
        String line = fr.readLine();

        while (!line.startsWith("Benchmark")) {
            line = fr.readLine();
        }

        Hashtable<String, Float> my_dict = new Hashtable<>();
        String method = "";

        line = fr.readLine();
        while (line != null) {
            char c;
            for (int i = 0; i < line.length(); i++) {
                c = line.charAt(i);
                method += c;
                if (c == ' ') {
                    break;
                }
            }
            float f = Float.parseFloat(line.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
            my_dict.put(method, f);
            line = fr.readLine();

        }
        fr.close();
        File file = new File("log.txt");
        /*
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
        PrintStream stream = new PrintStream(new FileOutputStream("log.txt", true));
        */
        FileUtils.writeStringToFile(
                file, date + "\n", StandardCharsets.UTF_8, true);
        FileUtils.writeStringToFile(
                file, time + "\n", StandardCharsets.UTF_8, true);
        FileUtils.writeStringToFile(
                file, String.valueOf(my_dict.get("PerformanceTest.MathUtils.MathUtilsPerformanceJMH.getStandardDeviationStreams")), StandardCharsets.UTF_8, true);
        System.out.println(my_dict.get("PerformanceTest.MathUtils.MathUtilsPerformanceJMH.getMaximum"));
        System.out.println(date);
        System.out.println(time);
        System.out.println();
        System.out.println(my_dict);

        StringBuilder key = new StringBuilder("PerformanceTest.MathUtils.MathUtilsPerformanceJMH.getMaximum");

        Float value = my_dict.get("PerformanceTest.MathUtils.MathUtilsPerformanceJMH.getMaximum");
        System.out.println(value);

    }
}
