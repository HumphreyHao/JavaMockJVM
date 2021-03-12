package geek;

import java.io.File;
import java.io.IOException;

import geek.path.CompositeEntry;
import geek.path.DirEntry;
import geek.path.WildcardEntry;
import geek.path.ZipEntry;

/**
 * @Description JVM可读取的类路径项, 分为4种类型, 目录, 压缩包(jar或者zip),
 * 通配符或者混合形式, 我们定义一个接口来抽象上述四种类型
 * 这个方法的参数是class的相对路径,create()根据传入的路径字符串来判断具体创建哪种实现类.
 * @Param
 * @return
 **/
public interface PathEntry {

    /**
     * 读取出className这个类文件的所有字节内容
     * @param className
     * @return
     * @throws IOException
     */
    byte[] readClass(String className) throws IOException;

    static PathEntry create(String path) {

        // 路径含有File中定义的路径分隔符
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        }

        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }

        if (path.endsWith(".jar") || path.endsWith(".JAR")
                || path.endsWith(".zip") || (path.endsWith(".ZIP"))) {
            return new ZipEntry(path);
        }

        return new DirEntry(path);
    }
}
