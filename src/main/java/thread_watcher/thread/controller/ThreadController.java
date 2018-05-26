package thread_watcher.thread.controller;

import thread_watcher.non_concrete.abstractions.controller.notifier_controller.Notifier;
import thread_watcher.non_concrete.annotations.ThreadMethod;
import thread_watcher.non_concrete.models.user_implementation.user_method.UserMethod;
import thread_watcher.user_parts.thread_bundle.Bundle;

import java.lang.reflect.Method;


public class ThreadController extends Notifier {
    private static  ThreadController threadController;


    private ThreadController(){
    }
    public static ThreadController getThreadController(){
        if (threadController == null){
            threadController = new ThreadController();
        }
        return threadController;
    }

    public synchronized void startUserMethod(String methodName,UserMethod userMethod, Object ... objects){
        Method method = getMethod(methodName,userMethod);
        ThreadMethod userMethodParametersName = method.getAnnotation(ThreadMethod.class);
        Bundle bundle = Bundle.createBundle(userMethodParametersName,objects);

        if (userMethodController.checkForEmptySpace(userMethod.getClass().getSimpleName())){
            setupThread(threadRunner.runThread(method,userMethod,bundle)).start();
        }else{
            int ordinal_num = threadQueue.addToQueue(userMethod.getClass().getSimpleName());
            setupThread(threadRunner.queueRunThread(ordinal_num,threadQueue,method,userMethod,bundle)).start();
        }
    }

    private Method getMethod(String methodName,UserMethod userMethod){
        try {
            Method method = userMethod.getClass().getMethod(methodName,Bundle.class);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Thread setupThread(Runnable runnable){
        Thread thread = new Thread(runnable);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("uhvatio sam error na threadu");
            }
        };
        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        return thread;
    }
}
