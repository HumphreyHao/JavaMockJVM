package geek.path;

import java.io.IOException;

import geek.PathEntry;

/**
 * @program: JavaMockJVM
 * @description: 这个类代表的是以文件分隔符";" 分割的多个路径
 * 实际上可以分割成更小的Entry去处理
 * @author: Hao Zhao
 * @create: 2021-03-11 09:45
 **/
public class CompositeEntry implements PathEntry {
    public CompositeEntry(String path) {
        return;
    }

    public byte[] readClass(String className) throws IOException {
        return new byte[0];
    }
}
