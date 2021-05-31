import java.util.ArrayList;

public class Indexed implements Allocation {
    @Override
    public boolean createFile(Directory dir, String name, int filesize, ArrayList<allocated> periods, ArrayList<Boolean> status) {
        ArrayList<Integer> allocatedBlocks = new ArrayList<>();
        for (int i = 0; i < status.size(); i++) {
            if (!status.get(i)) {
                status.set(i, true);
                filesize--;
                allocatedBlocks.add(i);
            }
            if (filesize == 0) {
                Filex file = new Filex(name, filesize, allocatedBlocks);
                dir.files.add(file);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean createDirectory(Directory dir, String name) {
        dir.subDirectories.add(new Directory(name));
        return true;
    }

    @Override
    public int deleteFile(Directory dir, String name, ArrayList<allocated> periods, ArrayList<Boolean> status) {
        for (Filex file : dir.files) {
            if (file.name.equals(name)) {
                for (int i = 0; i < file.allocatedBlocks.size(); i++) {
                    status.set(file.allocatedBlocks.get(i), false);
                }
                file.deleted = true;
                return file.allocatedBlocks.size();
            }
        }
        return 0;
    }

    @Override
    public int deleteDirectory(Directory dir, ArrayList<allocated> periods, ArrayList<Boolean> status) {
        int space = 0;
        for (Filex file : dir.files) {
            for (int i = 0; i < file.allocatedBlocks.size(); i++) {
                status.set(file.allocatedBlocks.get(i), false);
            }
            file.deleted = true;
            space += file.allocatedBlocks.size();
        }
        for (Directory directory : dir.subDirectories) {
            space += deleteDirectory(directory, periods, status);
        }
        dir.deleted = true;
        return space;
    }
}
