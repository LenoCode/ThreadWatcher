package test.gym;

import test.gym.Methods.Method1;
import thread_watcher.thread.controller.ThreadController;

public class Main {

    static int a =0;

    public static void main(String[] args){
        ThreadController controller = ThreadController.getThreadController();


        controller.startUserMethod("callUserMethod",new Method1(),"Kingkong0","car");
        System.out.println("END");
    }




    public static int test(){
        return a++;
    }
}
