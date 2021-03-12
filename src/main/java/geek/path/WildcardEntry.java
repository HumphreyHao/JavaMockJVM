package geek.path;

import java.io.IOException;

import geek.PathEntry;

/**
 * @author zhaohao <zhaohao@kuaishou.com>
 * Created on 2021-03-12
 */
public class WildcardEntry implements PathEntry {
    public WildcardEntry(String path) {

    }

    public byte[] readClass(String className) throws IOException {
        return new byte[0];
    }
}
