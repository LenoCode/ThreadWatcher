package thread_watcher.thread.caller;

import thread_watcher.models.abstractions.user_method.UserMethod;
import thread_watcher.thread.controller.ThreadController;

public class ThreadCaller {
    private static ThreadCaller threadCaller;
    private final ThreadController threadController;

    private ThreadCaller(){
        threadController = ThreadController.getThreadController();
    }
    public static ThreadCaller getThreadCaller(){
        if (threadCaller == null){
            threadCaller = new ThreadCaller();
        }
        return threadCaller;
    }
    public<A extends UserMethod> long callThread(Class<A> userMethodClass, String methodName, Object ... args) throws InstantiationException, IllegalAccessException {
        try {
            UserMethod userMethod = instantiateUserMethod(userMethodClass);
            return threadController.startUserMethod(methodName,userMethod,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private <A extends UserMethod> A instantiateUserMethod(Class<A> userMethodClass ) throws IllegalAccessException, InstantiationException {
        return userMethodClass.newInstance();
    }
}
