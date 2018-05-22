package test.gym;

import test.gym.Methods.Method1;
import thread_watcher.thread.controller.ThreadController;

public class Main {

    static int a =0;

    public static void main(String[] args){
        ThreadController controller = ThreadController.getThreadController();

        controller.startUserMethod(new Method1(),"sta je to","car");
        controller.startUserMethod(new Method1(),"Kingkong","car");
    }



    public static int test(){
        return a++;
    }
}
