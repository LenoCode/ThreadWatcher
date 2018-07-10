package thread_watcher.models.abstractions.controller.notifier_controller;

import thread_watcher.models.abstractions.controller.thread_controller_objects.ThreadControllerObjects;


public abstract class Notifier extends ThreadControllerObjects {


    public Notifier(){
        super();
    }

    public void notifyThreadFinished(String threadName){
        userMethodController.threadFinishied(threadName);
    }
    public boolean checkIfThreadFinished(String threadName){
        return userMethodController.checkIfThreadActive(threadName);
    }
    public boolean notifyUserAboutNewThread(String methodName){
        return userMethodController.catchEmptySpace(methodName);
    }

}
