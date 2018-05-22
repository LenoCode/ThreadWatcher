package thread_watcher.thread.runner;

import thread_watcher.non_concrete.models.user_implementation.user_method.UserMethod;

import thread_watcher.thread.controller.ThreadController;
import thread_watcher.thread.queue.queued_thread.ThreadQueue_test;
import thread_watcher.user_parts.thread_bundle.Bundle;

public class ThreadRunner{

    public Runnable runThread(UserMethod userMethod, Bundle bundle){
        return new Runnable() {
            @Override
            public void run() {
                runUserMethod(userMethod,bundle);
            }
        };
    }

    public Runnable queueRunThread(int ordinal_num,ThreadQueue_test threadQueue_test, UserMethod userMethod, Bundle bundle){
        return new Runnable() {
            @Override
            public void run() {
                String methodName = userMethod.getClass().getSimpleName();
                while(!threadQueue_test.queueStatus(methodName,ordinal_num)){
                }
                runUserMethod(userMethod,bundle);
            }
        };
    }

    private void runUserMethod(UserMethod userMethod,Bundle bundle){
        try{
            userMethod.callUserMethod(bundle);
        }catch (Exception exception){
            throw new RuntimeException();
        }
        finally {
            ThreadController.getThreadController().notifyThreadFinished(userMethod.getClass().getSimpleName());
        }
    }
}
