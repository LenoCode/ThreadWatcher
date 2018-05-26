package thread_watcher.thread.runner;

import thread_watcher.non_concrete.models.user_implementation.user_method.UserMethod;

import thread_watcher.thread.controller.ThreadController;
import thread_watcher.thread.queue.ThreadQueue;
import thread_watcher.user_parts.thread_bundle.Bundle;

import java.lang.reflect.Method;

public class ThreadRunner{

    public Runnable runThread(Method method, UserMethod userMethod, Bundle bundle){
        return new Runnable() {
            @Override
            public void run() {
                try{
                    runUserMethod(method,userMethod,bundle);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
    }

    public Runnable queueRunThread(int ordinal_num, ThreadQueue threadQueue_test,Method method ,UserMethod userMethod, Bundle bundle){
        return new Runnable() {
            @Override
            public void run() {
                try{
                    String methodName = userMethod.getClass().getSimpleName();
                    threadQueue_test.waitMethodTurn(methodName,ordinal_num);
                    runUserMethod(method,userMethod,bundle);
                }catch (Exception e){
                   e.printStackTrace();
                }
            }
        };
    }

    private void runUserMethod(Method method,UserMethod userMethod,Bundle bundle){
        try{
            method.invoke(userMethod,bundle);
        }catch (Exception exception){
            throw new RuntimeException("");
        }
        finally {
            ThreadController.getThreadController().notifyThreadFinished(userMethod.getClass().getSimpleName());
        }
    }
}
