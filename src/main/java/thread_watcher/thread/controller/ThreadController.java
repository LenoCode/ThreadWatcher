package thread_watcher.thread.controller;

import async_communicator.AsyncCommunicator;
import thread_watcher.models.abstractions.controller.notifier_controller.Notifier;
import thread_watcher.models.abstractions.user_method.UserMethod;
import thread_watcher.models.annotations.ThreadMethod;
import thread_watcher.user_parts.thread_bundle.Bundle;

import java.lang.reflect.Method;


public class ThreadController extends Notifier {
    private static  ThreadController threadController;
    private final AsyncCommunicator asyncCommunicator;


    private ThreadController(){
        asyncCommunicator = AsyncCommunicator.getAsyncCommunicator();
    }
    public static ThreadController getThreadController(){
        if (threadController == null){
            threadController = new ThreadController();
        }
        return threadController;
    }

    public synchronized long startUserMethod(String methodName, UserMethod userMethod, Object ... objects){
        Method method = getMethod(methodName,userMethod);
        ThreadMethod userMethodParametersName = method.getAnnotation(ThreadMethod.class);
        Bundle bundle = Bundle.createBundle(userMethodParametersName,objects);

        Thread configuredThread;
        long threadId;
        if (userMethodController.checkForEmptySpace(userMethod.getClass().getSimpleName())){
            configuredThread = setupThread(threadRunner.runThread(method,userMethod,bundle));
            threadId = configuredThread.getId();
            asyncCommunicator.initNewThread(threadId);
            configuredThread.start();
        }else{
            int ordinal_num = threadQueue.addToQueue(userMethod.getClass().getSimpleName());
            configuredThread =setupThread(threadRunner.queueRunThread(ordinal_num,threadQueue,method,userMethod,bundle));
            threadId = configuredThread.getId();
            asyncCommunicator.initNewThread(configuredThread.getId());
            configuredThread.start();
        }
        return threadId;
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
