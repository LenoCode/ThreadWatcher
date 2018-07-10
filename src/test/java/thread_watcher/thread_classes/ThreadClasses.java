package thread_watcher.thread_classes;

import thread_watcher.models.abstractions.user_method.UserMethod;
import thread_watcher.models.annotations.ThreadMethod;
import thread_watcher.user_parts.thread_bundle.Bundle;

public class ThreadClasses extends UserMethod {


    @ThreadMethod(paramNames = {"notification"})
    public void test(Bundle bundle){
        String notitfication = (String) bundle.getArguments("notification");
        System.out.println(notitfication +" -----------------------------------------------------------------------------------------------------  "+" aaall goood");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
