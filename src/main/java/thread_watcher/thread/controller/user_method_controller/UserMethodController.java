package thread_watcher.thread.controller.user_method_controller;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class UserMethodController {
    private final List<String> activeThreads;

    public UserMethodController(){
        activeThreads = new ArrayList<>();
    }

    public boolean checkForEmptySpace(String methodName){
        if (arrayLoop(methodName) == null){
            return catchEmptySpace(methodName);
        }else{
            return false;
        }
    }
    public boolean catchEmptySpace(String methodName){
        return activeThreads.add(methodName);
    }

    public boolean threadFinishied(String name){
        String stringToRemove = arrayLoop(name);
        activeThreads.remove(stringToRemove);
        return true;
    }
    public boolean checkIfThreadActive(String methodName){
        return arrayLoop(methodName) == null;
    }

    private String arrayLoop(String stringToSearch){
        try {
            for (String string : activeThreads) {
                if (string.equals(stringToSearch)) {
                    return string;
                }
            }
            return null;
        }catch (NullPointerException|ConcurrentModificationException e){
            return null;
        }
    }
}
