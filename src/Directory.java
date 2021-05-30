import java.util.ArrayList;

public class Directory {
    protected String name = "";
    protected String id = "";
    protected double size = 0.0;
    protected String directoryPath;
    protected ArrayList<Filex> files = new ArrayList<Filex>();
    protected ArrayList<Directory> subDirectories = new ArrayList<Directory>();
    protected boolean deleted = false;


    public void printDirectoryStructure(int level) {
    }

    public ArrayList<Directory> getSubDirectories() {
        return subDirectories;
    }

    public ArrayList<Filex> getFiles() {
        return files;
    }
}
