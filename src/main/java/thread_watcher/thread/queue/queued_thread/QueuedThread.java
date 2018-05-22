package thread_watcher.thread.queue.queued_thread;

import thread_watcher.non_concrete.models.user_implementation.user_method.UserMethod;
import thread_watcher.user_parts.thread_bundle.Bundle;

public class QueuedThread {

    private UserMethod userMethod;
    private Bundle bundle;

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public UserMethod getUserMethod() {
        return userMethod;
    }

    public void setUserMethod(UserMethod userMethod) {
        this.userMethod = userMethod;
    }
}
