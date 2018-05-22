package test.gym.Methods;

import thread_watcher.non_concrete.annotations.UserMethodParametersName;
import thread_watcher.non_concrete.models.user_implementation.user_method.UserMethod;
import thread_watcher.user_parts.thread_bundle.Bundle;


@UserMethodParametersName(paramNames = {"param1","param2"})
public class Method1 implements UserMethod {
    @Override
    public void callUserMethod(Bundle bundle) throws Exception {
        System.out.println(bundle.getArguments("param1") +    "   A OVO JE SVE");
    }
}
