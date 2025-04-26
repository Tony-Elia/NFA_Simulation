import Problems.Problem7;
import Problems.Problem8;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))
        ) {
            String str;
            while ((str = br.readLine()) != null) {
                switch (str) {
                    case "7" -> new Problem7(br, bw);
                    case "8" -> new Problem8(br, bw);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
