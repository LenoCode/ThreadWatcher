package thread_watcher.user_parts.thread_bundle;

import thread_watcher.models.annotations.ThreadMethod;

import java.util.HashMap;
import java.util.Map;

public class Bundle {
    private final Map<String,Object>  arguments;

    private Bundle(){
        arguments = new HashMap<>();
    }


    public static Bundle createBundle(ThreadMethod userMethodParametersName, Object ... objects){
        Bundle bundle = new Bundle();
        bundle.setupBundleWithArguments(userMethodParametersName.paramNames(),objects);
        return bundle;
    }

    private void setupBundleWithArguments(String[] paramNames, Object ... objects){
        for (int i = 0; i < objects.length; i++){
            arguments.put(paramNames[i],objects[i]);
        }
    }

    public Object getArguments(String objectName){
        Object object = arguments.get(objectName);
        if (object == null){
            throw new NullPointerException();
        }else{
            return object;
        }
    }

}
