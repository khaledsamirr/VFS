import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static boolean checkpath(Directory r, String p) {
        for (int i = 0; i < r.getSubDirectories().size(); i++) {
            if (r.getSubDirectories().get(i).equals(p))
                return true;
        }
        for (int i = 0; i < r.getFiles().size(); i++) {
            if (r.getSubDirectories().get(i).equals(p))
                return true;
        }
        return false;
    }

    public static void updateFile(FileWriter VFS, Directory Dir) throws IOException {
        VFS.write("<" + Dir.name + ">" + "\t" + Dir.id + "\t" + Dir.size + "\n");
        for (int i = 0; i < Dir.files.size(); i++) {
            VFS.write(Dir.files.get(i).name + "\t" + Dir.id + "\t" + Dir.size + "\n");
        }
        for (int i = 0; i < Dir.subDirectories.size(); i++) {
            updateFile(VFS, Dir.subDirectories.get(i));
        }
    }

    public static void loadFile(Scanner sc, Scanner sc1, Directory Dir) {
        int counter = 0;
        String temp = "";
        if (sc.hasNext()) {

            temp = sc.next();
            counter++;
            Dir.name = temp.substring(1, temp.length() - 1);
            Dir.id = sc.next();
            counter++;
            Dir.size = Double.valueOf(sc.next());
            counter++;
        }
        if (sc.hasNext()) {
            temp = sc.next();

            while (temp.charAt(0) != '<') {
                Filex tempFile = new Filex();
                tempFile.name = temp;
                counter++;
                temp = sc.next();
                counter++;
                tempFile.id = temp;
                temp = sc.next();
                counter++;
                tempFile.size = Double.valueOf(temp);
                counter++;
                Dir.files.add(tempFile);
                if (sc.hasNext()) {
                    temp = sc.next();
                }
            }
        }
        for (int i = 0; i < counter; i++) {
            sc1.next();
        }

        if (sc.hasNext()) {
            while (temp.charAt(0) == '<') {
                Dir.subDirectories.add(new Directory());
                loadFile(sc1, sc1, Dir.subDirectories.get(Dir.subDirectories.size() - 1));

            }
        }

    }

    public static void main(String args[]) throws IOException {
        Directory rootDirectory = new Directory();
        //FileWriter VFS_Write = new FileWriter("backupFile.txt");
        File VFS_Read = new File("backupFile.txt");
        Scanner cmd = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        String input = "";
        String[] cmds = new String[0];
        String[] dirs = new String[0];

        Scanner fileSC = new Scanner(VFS_Read);
        Scanner secfileSC = new Scanner(VFS_Read);
        loadFile(fileSC, secfileSC, rootDirectory);

        System.out.println(rootDirectory.name);
        System.out.println(rootDirectory.id);

        System.out.println(rootDirectory.files.get(0).name);
        System.out.println(rootDirectory.files.get(0).id);

        System.out.println("-------------------------------");

        System.out.println(rootDirectory.subDirectories.get(0).name);
        System.out.println(rootDirectory.subDirectories.get(0).id);

        System.out.println(rootDirectory.subDirectories.get(0).files.get(0).name);
        System.out.println(rootDirectory.subDirectories.get(0).files.get(0).id);

        System.out.println("Enter Disk's number of blocks: ");
        int N = in.nextInt();
        String path = "";

        while (true) {
            input = cmd.nextLine();
            cmds = input.split(" ");
            dirs = cmds[1].split("/");

            if (cmds[0].equals("CreateFile")) {
                System.out.println("Enter path of file: ");
                path = cmd.nextLine();
                int l = dirs.length;
                while (l > 2) {
                    if (checkpath(rootDirectory.getSubDirectories().get(l), path)) ;
                }

            } else if (cmds[0].equals("CreateFolder")) {

            } else if (cmds[0].equals("DeleteFile")) {

            } else if (cmds[0].equals("DeleteFolder")) {

            } else if (cmds[0].equals("DisplayDiskStatus")) {

            } else if (cmds[0].equals("DisplayDiskStructure")) {

            } else if (cmds[0].equalsIgnoreCase("exit")) {
                //VFS_Write.close();


            } else {
                System.out.println("Wrong Command!");
            }

        }


    }

}
