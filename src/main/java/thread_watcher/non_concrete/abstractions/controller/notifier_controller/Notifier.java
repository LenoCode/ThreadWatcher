package thread_watcher.non_concrete.abstractions.controller.notifier_controller;

import thread_watcher.non_concrete.abstractions.controller.thread_controller_objects.ThreadControllerObjects;


public abstract class Notifier extends ThreadControllerObjects {


    public Notifier(){
        super();
    }

    public void notifyThreadFinished(String threadName){
        userMethodController.threadFinishied(threadName);
    }

}
