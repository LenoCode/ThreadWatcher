package thread_watcher.models.abstractions.user_method;


import async_communicator.AsyncCommunicator;

public abstract class UserMethod {
    protected final AsyncCommunicator asyncCommunicator;

    public UserMethod(){
        asyncCommunicator = AsyncCommunicator.getAsyncCommunicator();
    }
}
