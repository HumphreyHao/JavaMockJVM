package geek;

/**
 * @program: JavaMockJVM
 * @description: 启动的主类
 * @author: Hao Zhao
 * @create: 2021-03-11 08:44
 **/
public class Main {

    public static void main(String[] args){
        Cmd cmd = Cmd.parse(args);

        if(!cmd.isOk() || cmd.isHelpFlag()) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }
        if(cmd.isVersionFlag()) {
            System.out.println("java version \"1.8.0\"");
            return;
        }

        startJVM(cmd);

    }

    private static void startJVM(Cmd cmd) {
        System.out.printf("classpath:%s class:%s \n",
                cmd.getClasspath(),
                cmd.getMainClassAndArgs());
    }
}
