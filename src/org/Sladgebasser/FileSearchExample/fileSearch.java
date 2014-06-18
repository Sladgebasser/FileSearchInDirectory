package dir;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class fileSearch {

    public static void main(String[] args) {
        String Path;
        String Extension = "";
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("enter path to directory");
                Path = bf.readLine();
                File Buffer = new File(Path);
                if (!Buffer.exists()) {
                    System.out.println("directory doesn't exists");
                } else break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("enter extension (if no extension - all files in directory will be listed)");
            Extension = bf.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        File Directory = new File(Path);
        ArrayList<File> ListFiles = new ArrayList<File>();
        if (Directory.listFiles()==null)
            System.out.println("empty directory");
        else {
            ListFiles.addAll(Arrays.asList(Directory.listFiles()));
            for (int i = 0; i < ListFiles.size(); i++) {
                if (ListFiles.get(i).toString().endsWith(Extension)) {
                    System.out.println(ListFiles.get(i));
                }
                if (ListFiles.get(i).listFiles() != null) {
                    ListFiles.addAll(Arrays.asList(ListFiles.get(i).listFiles()));
                }
            }
        }
    }
}
