package thread_watcher.thread.queue.queued_thread;

import java.util.*;

public class ThreadQueue_test {

    private int lastestThread;
    private final Map<String,ArrayList<Integer>> queue;

    public ThreadQueue_test(){
        lastestThread = 0;
        queue = new HashMap<>();
    }

    public int addToQueue(String methodName){
        if (queue.containsKey(methodName)){
            ArrayList<Integer> methodQueue = queue.get(methodName);
            methodQueue.add(lastestThread);
        }else{
            ArrayList<Integer> methodQueue = new ArrayList<>();
            methodQueue.add(lastestThread);
            queue.put(methodName,methodQueue);
        }
        return lastestThread++;
    }
    public boolean queueStatus(String methodName,int ordinal_num){
        if (queue.containsKey(methodName)){
            ArrayList arrayList = queue.get(methodName);

            if (getNextNumber(arrayList) == ordinal_num){
                if (checkIfQueueIsEmpty(arrayList)){
                    queue.remove(methodName);
                }
                return true;
            }else{
                return false;
            }
        }
        return true;
    }

    private int getNextNumber(ArrayList<Integer> arrayList){
        return arrayList.get(0);
    }

    private boolean checkIfQueueIsEmpty(ArrayList<Integer> arrayList){
        if (arrayList.size() < 2){
            arrayList.clear();
            return true;
        }else{
            arrayList.remove(0);
            return false;
        }
    }
}
