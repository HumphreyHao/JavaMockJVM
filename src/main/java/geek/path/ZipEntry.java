package geek.path;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import geek.PathEntry;

/**
 * @author zhaohao <zhaohao@kuaishou.com>
 * Created on 2021-03-12
 */
public class ZipEntry implements PathEntry {

    private final Path absolutePath;

    public ZipEntry(String path) {
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    /**
     * class的相对路径就是压缩内部的目录的路径
     * java.nio提供了一个FileSystem类,可以快速的读取压缩包.
     */
    @Override
    public byte[] readClass(String className) throws IOException {
        try (FileSystem zipFs = FileSystems.newFileSystem(absolutePath, null)) {
            return Files.readAllBytes(zipFs.getPath(className));
        }
    }

    @Override
    public String toString() {
        return this.absolutePath.toString();
    }
}
