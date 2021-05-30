import java.util.ArrayList;

public class Directory {
    private String directoryPath;
    private ArrayList<File> files=new ArrayList<File>();
    private ArrayList<Directory>subDirectories=new ArrayList<Directory>();
    private boolean deleted = false;
    public void printDirectoryStructure(int level) {
    }

    public ArrayList<Directory> getSubDirectories() {
        return subDirectories;
    }

    public ArrayList<File> getFiles() {
        return files;
    }
}
