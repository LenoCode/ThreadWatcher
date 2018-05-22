package thread_watcher.non_concrete.abstractions.controller.thread_controller_objects;

import thread_watcher.thread.controller.user_method_controller.UserMethodController;
import thread_watcher.thread.queue.queued_thread.ThreadQueue_test;
import thread_watcher.thread.runner.ThreadRunner;

public abstract class ThreadControllerObjects {
    protected final UserMethodController userMethodController;
    protected final ThreadRunner threadRunner;
    protected final ThreadQueue_test threadQueue;


    protected  ThreadControllerObjects(){
        userMethodController = new UserMethodController();
        threadRunner = new ThreadRunner();
        threadQueue = new ThreadQueue_test();
    }
}
