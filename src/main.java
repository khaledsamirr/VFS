import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static boolean checkpath(Directory r,String p){
        for(int i=0;i<r.getSubDirectories().size();i++){
            if(r.getSubDirectories().get(i).equals(p))
                return true;
        }
        for(int i=0;i<r.getFiles().size();i++){
            if(r.getSubDirectories().get(i).equals(p))
                return true;
        }
        return false;
    }
    public static void main(String args[]) {
        Directory rootDirectory = null;
        Scanner cmd = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        String input = "";
        String[] cmds = new String[0];
        String[] dirs = new String[0];
        System.out.println("Enter Disk's number of blocks: ");
        int N=in.nextInt();
        String path="";
        while(true){
            input=cmd.nextLine();
            cmds = input.split(" ");
            dirs=cmds[1].split("/");
            if(cmds[0].equals("CreateFile")){
                System.out.println("Enter path of file: ");
                path=cmd.nextLine();
                int l=dirs.length;
                while(l>2){
                    if(checkpath(rootDirectory.getSubDirectories().get(l),path));
                }

            }
            else if(cmds[0].equals("CreateFolder")){

            }else if(cmds[0].equals("DeleteFile")){

            }else if(cmds[0].equals("DeleteFolder")){

            }else if(cmds[0].equals("DisplayDiskStatus")){

            }else if(cmds[0].equals("DisplayDiskStructure")){

            }else{
                System.out.println("Wrong Command!");
            }

        }

    }

}
