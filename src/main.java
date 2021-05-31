import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {

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
                Filex tempFile;
                tempFile = new Filex();
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
        String[] cmds ;

        Scanner fileSC = new Scanner(VFS_Read);
        Scanner secfileSC = new Scanner(VFS_Read);
        //loadFile(fileSC, secfileSC, rootDirectory);
        system sys=new system();
        Allocation allocation;
        System.out.println("Enter Disk's number of blocks: ");
        int N = in.nextInt();
        System.out.println("Enter Allocation method: ");
        System.out.println("1- Contiguous Allocation");
        System.out.println("2- Indexed Allocation");
        System.out.println("3- Linked Allocation");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                allocation = new Contiguous();
                sys = new system(N, allocation);
                break;
            case 2:
        }
        String path = "";
        while (true) {
            System.out.println("Enter Command: ");
            input = cmd.nextLine();
            cmds = input.split(" ");

            if (cmds[0].equals("createFile")) {
                if(cmds.length>=3) {
                    sys.createfile(cmds[1], Integer.parseInt(cmds[2]));
                }
                else
                    System.out.println("wrong inputs!");
            } else if (cmds[0].equals("createFolder")) {
                sys.createfolder(cmds[1]);
            } else if (cmds[0].equals("deleteFile")) {
                sys.deletefile(cmds[1]);
            } else if (cmds[0].equals("deleteFolder")) {
                sys.deletefolder(cmds[1]);
            } else if (cmds[0].equals("displayDiskStatus")) {
                sys.DisplayDiskStatus();
            } else if (cmds[0].equals("displayDiskStructure")) {
                sys.DisplayDiskStructure();
            } else if (cmds[0].equalsIgnoreCase("exit")) {
                //VFS_Write.close();


            } else {
                System.out.println("Wrong Command!");
            }

        }


    }

}
