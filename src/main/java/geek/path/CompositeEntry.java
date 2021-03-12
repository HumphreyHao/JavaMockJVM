package geek.path;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import geek.PathEntry;

/**
 * @program: JavaMockJVM
 * @description: 这个类代表的是以文件分隔符";" 分割的多个路径
 * 实际上可以分割成更小的Entry去处理
 * @author: Hao Zhao
 * @create: 2021-03-11 09:45
 **/
public class CompositeEntry implements PathEntry {

    private final List<PathEntry> entryList = new ArrayList<>();

    public CompositeEntry(String pathList) {
        String[] paths = pathList.split(File.pathSeparator);
        Arrays.stream(paths).forEach(x -> entryList.add(PathEntry.create(x)));
    }

    public byte[] readClass(String className) throws IOException {
        return new byte[0];
    }
}
