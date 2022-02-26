package test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOLab {
    public static void main(String[] args) throws Exception {
        IOLab o = new IOLab();
        o.readFile(new File("src/main/java/test/hello.txt"));
        o.writeFile(new File("src/main/java/test/output.txt"), "hello\n, i want be you friend.");

        o.copy("src/main/java/test/hello.txt", "src/main/java/test/copy.txt");
    }

    public void copy(String source, String target) {

        try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(target)) {

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(File source) {
        if (source == null || !source.exists() || !source.isFile()) {
            throw new RuntimeException("not a file");
        }

        try (InputStream input = new FileInputStream(source)) {

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = input.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(File target, String msg) {
        if (target == null) {
            throw new RuntimeException("null pointer");
        }

        try (OutputStream output = new FileOutputStream(target)) {

            output.write(msg.getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
