package thread_watcher.models.abstractions.controller.thread_controller_objects;

import thread_watcher.thread.controller.user_method_controller.UserMethodController;
import thread_watcher.thread.queue.ThreadQueue;
import thread_watcher.thread.runner.ThreadRunner;

public abstract class ThreadControllerObjects {
    protected final UserMethodController userMethodController;
    protected final ThreadRunner threadRunner;
    protected final ThreadQueue threadQueue;


    protected  ThreadControllerObjects(){
        userMethodController = new UserMethodController();
        threadRunner = new ThreadRunner();
        threadQueue = new ThreadQueue();
    }
}
