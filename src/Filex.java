import java.io.File;
import java.util.ArrayList;

public class Filex {
    protected String name = "";
    protected String id = "";
    protected int size = 0;
    protected ArrayList<Integer> allocatedBlocks = new ArrayList<Integer>();
    protected boolean deleted;

    public Filex() {
    }

    public Filex(String name) {
        this.name = name;
    }

    public Filex(String name, int size, ArrayList<Integer> allocatedBlocks) {
        this.name = name;
        this.size = size;
        this.allocatedBlocks = allocatedBlocks;
        deleted = false;
    }

}
