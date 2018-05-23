package test.gym;

import test.gym.Methods.Method1;
import thread_watcher.thread.controller.ThreadController;

public class Main {

    static int a =0;

    public static void main(String[] args){
        ThreadController controller = ThreadController.getThreadController();


        controller.startUserMethod(new Method1(),"Kingkong0","car");
        controller.startUserMethod(new Method1(),"Kingkong1","car");
        controller.startUserMethod(new Method1(),"Kingkong2","car");
        controller.startUserMethod(new Method1(),"Kingkong3","car");
        controller.startUserMethod(new Method1(),"Kingkong4","car");
        controller.startUserMethod(new Method1(),"Kingkong5","car");
        controller.startUserMethod(new Method1(),"Kingkong6","car");
        controller.startUserMethod(new Method1(),"Kingkong7","car");
        controller.startUserMethod(new Method1(),"Kingkong8","car");
        controller.startUserMethod(new Method1(),"Kingkong9","car");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n\n\n\n");
    }




    public static int test(){
        return a++;
    }
}
