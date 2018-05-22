package thread_watcher.thread.controller.user_method_controller;

import java.util.ArrayList;
import java.util.List;

public class UserMethodController {
    private final List<String> activeThreads;

    public UserMethodController(){
        activeThreads = new ArrayList<>();
    }
    public boolean checkIsThreadActive(String methodName){
        if (arrayLoop(methodName) == null){
            activeThreads.add(methodName);
            return true;
        }else{
            return false;
        }
    }
    public boolean threadFinishied(String name){
        String stringToRemove = arrayLoop(name);
        activeThreads.remove(stringToRemove);
        return true;
    }

    private String arrayLoop(String stringToSearch){
        for (String string : activeThreads) {
            if (string.equals(stringToSearch)) {
                return string;
            }
        }
        return null;
    }
}
