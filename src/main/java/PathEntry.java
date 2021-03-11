import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @Description JVM可读取的类路径项,分为4种类型, 目录, 压缩包(jar或者zip),
 * 通配符或者混合形式, 我们定义一个接口来抽象上述四种类型
 * @Param
 * @return
 **/
public interface PathEntry {

    byte[] readClass(String className) throws IOException;

    static PathEntry create(String path){

        if(path.contains(File.pathSeparator)){
            return new CompositeEntry(path);
        }
    }
}
