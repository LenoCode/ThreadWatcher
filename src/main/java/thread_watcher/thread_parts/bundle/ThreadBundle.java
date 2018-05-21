package thread_watcher.thread_parts.bundle;

import java.util.HashMap;

public class ThreadBundle {
    private final HashMap<String, Object> arguments;

    public ThreadBundle(Object...objects){
        arguments = new HashMap<>();
        for (Object object : objects){
            arguments.put(object.getClass().getSimpleName(),object);
        }
    }
    public Object getObject(String objectName){
        return arguments.get(objectName);
    }

}
