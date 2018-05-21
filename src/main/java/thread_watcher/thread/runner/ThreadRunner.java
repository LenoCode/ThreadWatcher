package thread_watcher.thread.runner;

import thread_watcher.non_concrete.models.user_implementation.user_method.UserMethod;

public class ThreadRunner {

    public void runThread(UserMethod userMethod){
        try{
            userMethod.callUserMethod();
        }catch (Exception exception){

        }

    }
}
