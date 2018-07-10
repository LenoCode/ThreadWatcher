package thread_watcher;

import org.junit.Before;
import org.junit.Test;
import thread_watcher.thread.caller.ThreadCaller;
import thread_watcher.thread_classes.ThreadClasses;

public class BasicTest {
    private final ThreadCaller threadCaller = ThreadCaller.getThreadCaller();

    @Before
    public void before(){
    }


    @Test
    public void initTest() throws IllegalAccessException, InstantiationException {
        int a= 0;
        while(true){
            threadCaller.callThread(ThreadClasses.class,"test",Integer.toString(a));
            ++a;
        }
    }
}
