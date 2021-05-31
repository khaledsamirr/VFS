import java.io.File;
import java.util.ArrayList;
class node {
        int block;
        int next;
        public node(int block){
            this.block=block;
        }
}
public class Filex {
    protected String name = "";
    protected String id = "";
    protected int size = 0;
    protected ArrayList<node> allocatedBlocks = new ArrayList<node>();
    protected boolean deleted;

    public Filex() {
    }

    public Filex(String name) {
        this.name = name;
    }

    public Filex(String name, int size, ArrayList<node> allocatedBlocks) {
        this.name = name;
        this.size = size;
        this.allocatedBlocks = allocatedBlocks;
        deleted = false;
    }

}
