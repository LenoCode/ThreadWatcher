package test.gym.Methods;

import thread_watcher.non_concrete.annotations.ThreadMethod;
import thread_watcher.non_concrete.models.user_implementation.user_method.UserMethod;
import thread_watcher.user_parts.thread_bundle.Bundle;



public class Method1 implements UserMethod {

    @Override
    @ThreadMethod(paramNames = {"param1","param2"})
    public void callUserMethod(Bundle bundle) throws Exception {
        try{
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("FINISHED FINE " + bundle.getArguments("param1"));
    }
}
