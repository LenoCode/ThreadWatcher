package thread_watcher.thread.controller;

import thread_watcher.non_concrete.abstractions.controller.notifier_controller.Notifier;
import thread_watcher.non_concrete.annotations.UserMethodParametersName;
import thread_watcher.non_concrete.models.user_implementation.user_method.UserMethod;
import thread_watcher.user_parts.thread_bundle.Bundle;

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

    public void startUserMethod(UserMethod userMethod, Object ... objects){
        UserMethodParametersName userMethodParametersName = userMethod.getClass().getDeclaredAnnotation(UserMethodParametersName.class);
        Bundle bundle = Bundle.createBundle(userMethodParametersName,objects);

        if (userMethodController.checkIsThreadActive(userMethod.getClass().getSimpleName())){
           setupThread(threadRunner.runThread(userMethod,bundle)).start();
        }else{
            int ordinal_num = threadQueue.addToQueue(userMethod.getClass().getSimpleName());
            setupThread(threadRunner.queueRunThread(ordinal_num,threadQueue,userMethod,bundle)).start();
        }
    }

    public void startQueueUserMethod(UserMethod userMethod,Bundle bundle){
        setupThread(threadRunner.runThread(userMethod,bundle)).start();
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
