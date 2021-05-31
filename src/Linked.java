import java.util.ArrayList;

public class Linked implements Allocation{
    @Override
    public boolean createFile(Directory dir, String name, int filesize, ArrayList<allocated> periods, ArrayList<Boolean> status) {
        return false;
    }

    @Override
    public boolean createDirectory(Directory dir, String name) {
        return false;
    }

    @Override
    public int deleteFile(Directory dir, String name, ArrayList<allocated> periods, ArrayList<Boolean> status) {
        return 0;
    }

    @Override
    public int deleteDirectory(Directory dir, ArrayList<allocated> periods, ArrayList<Boolean> status) {
        return 0;
    }
}
