import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))
        ) {
            String str = br.readLine();
            if(str.equals("7")) {
                new Problem7(br, bw);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
