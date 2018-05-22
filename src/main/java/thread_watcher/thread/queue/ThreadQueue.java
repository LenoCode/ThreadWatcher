package thread_watcher.thread.queue;

import thread_watcher.non_concrete.models.user_implementation.user_method.UserMethod;
import thread_watcher.thread.controller.ThreadController;
import thread_watcher.thread.queue.queued_thread.QueuedThread;
import thread_watcher.user_parts.thread_bundle.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ThreadQueue {

    private final List<QueuedThread> threadsInQueue;
    private boolean action;

    public ThreadQueue(){
        threadsInQueue = new ArrayList<>();
    }

    public void addThreadToQueue(UserMethod userMethod, Bundle bundle){
        QueuedThread queuedThread = new QueuedThread();
        queuedThread.setBundle(bundle);
        queuedThread.setUserMethod(userMethod);
        threadsInQueue.add(queuedThread);
    }

    public void threadFinished(String threadName) {
        QueuedThread queuedThread = arrayLoop(threadName);
        if (queuedThread != null){
            threadsInQueue.remove(queuedThread);
            ThreadController.getThreadController().startQueueUserMethod(queuedThread.getUserMethod(),queuedThread.getBundle());
        }
    }

    private QueuedThread arrayLoop(String stringToSearch){
        for (QueuedThread queuedThread : threadsInQueue){
            String string =queuedThread.getUserMethod().getClass().getSimpleName();
            if (string.equals(stringToSearch)){
                return queuedThread;
            }
        }
        return null;
    }
}
