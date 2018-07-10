package thread_watcher.thread.queue;

import thread_watcher.thread.controller.ThreadController;

import java.util.*;

public class ThreadQueue {

    private int lastestThread;
    private final Map<String,ArrayList<Integer>> queue;
    private final Object lockQueue = new Object();

    public ThreadQueue(){
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
    public boolean waitMethodTurn(String methodName,int ordinal_num){
        System.out.println("Method not ready");
        boolean notReady = true;
        ThreadController threadController = ThreadController.getThreadController();

        System.out.println("MUTEX ..................");
        while(notReady){
            synchronized (lockQueue) {
                try{
                    notReady = readyTurn(threadController,methodName,ordinal_num);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    private boolean readyTurn(ThreadController threadController,String methodName,int ordinal_num)throws Exception{
        if (threadController.checkIfThreadFinished(methodName)) {
            if (queueStatus(methodName, ordinal_num)) {
                return false;
            }
        }
        return true;
    }


    private boolean queueStatus(String methodName,int ordinal_num){
        if (queue.containsKey(methodName)){
            ArrayList arrayList = queue.get(methodName);
            System.out.println("get next number   "+getNextNumber(arrayList)+ "     "+ordinal_num);
            if (getNextNumber(arrayList) == ordinal_num){
                if (checkIfQueueIsEmpty(arrayList)){
                    queue.remove(methodName);
                }
                ThreadController.getThreadController().notifyUserAboutNewThread(methodName);
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
            lastestThread = 0;
            return true;
        }else{
            arrayList.remove(0);
            return false;
        }
    }
}
