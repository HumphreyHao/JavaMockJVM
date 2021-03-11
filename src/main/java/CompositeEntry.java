import java.io.IOException;

/**
 * @program: JavaMockJVM
 * @description:
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
