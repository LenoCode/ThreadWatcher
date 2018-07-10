package thread_watcher.thread.runner;


import async_communicator.AsyncCommunicator;
import thread_watcher.models.abstractions.user_method.UserMethod;
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
                    System.out.println("ovo je novi thread "+Thread.currentThread().getId());
                    AsyncCommunicator.getAsyncCommunicator().threadStarted();
                    runUserMethod(method,userMethod,bundle);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
    }

    public Runnable queueRunThread(int ordinal_num, ThreadQueue threadQueue,Method method ,UserMethod userMethod, Bundle bundle){
        return new Runnable() {
            @Override
            public void run() {
                try{
                    AsyncCommunicator.getAsyncCommunicator().threadStarted();
                    String methodName = userMethod.getClass().getSimpleName();
                    threadQueue.waitMethodTurn(methodName,ordinal_num);
                    System.out.println("Queue je zavrsio ");
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
            exception.printStackTrace();
            System.out.println(exception.getMessage() + " exception caught at runUserMethod");
            throw new RuntimeException(exception.getMessage());
        }
        finally {
            System.out.println("Tu sam ");
            AsyncCommunicator.getAsyncCommunicator().threadFinished();
            ThreadController.getThreadController().notifyThreadFinished(userMethod.getClass().getSimpleName());
        }
    }
}
