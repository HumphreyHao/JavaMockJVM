import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import lombok.Data;

/**
 * @program: JavaMockJVM
 * @description: 解析命令行参数
 * @author: Hao Zhao
 * @create: 2021-03-11 08:22
 **/
@Data
public class Cmd {
    @Parameter(names = {"-?", "-help"}, description = "输出帮助信息", order = 3, help = true)
    private boolean helpFlag = false;
    @Parameter(names = "-version", description = "输出版本号并退出", order = 2)
    private boolean versionFlag = false;
    @Parameter(names = {"-cp", "-classpath"}, description = "类路径", order = 1)
    private String classpath;
    @Parameter(description = "主类和参数")
    private List<String> mainClassAndArgs;
    @Parameter(names = "-Xjre", description = "path to jre", order = 4)
    private String jre;

    private boolean ok;


    public static Cmd parse(String[] argv) {
        Cmd args = new Cmd();
        //导入args
        JCommander cmd = JCommander.newBuilder().addObject(args).build();
        //解析输入参数
        cmd.parse(argv);
        args.ok = true;
        return args;
    }
}
