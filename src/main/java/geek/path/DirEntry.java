package geek.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import geek.PathEntry;

/**
 * @author zhaohao <zhaohao@kuaishou.com>
 * Created on 2021-03-12
 * 表示目录形式的类路径,只需要一个字段来存放目录的绝对路径
 */
public class DirEntry implements PathEntry {

    private final Path absolutePath;

    public DirEntry(String path) {
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        return Files.readAllBytes(absolutePath.resolve(className));
    }

    @Override
    public String toString() {
        return this.absolutePath.toString();
    }

}
