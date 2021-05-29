import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        Directory rootDirectory;
        Scanner cmd = new Scanner(System.in);
        String input = "";
        String[] cmds = new String[0];
        while(true){
            input=cmd.nextLine();
            cmds = input.split(" ");
            if(cmds[0].equals("CreateFile")){

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
