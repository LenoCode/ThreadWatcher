package test.gym;

public class Main {




    public static void main(String[] args){
        Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Excpetion from that "+e.getLocalizedMessage());
            }
        };
        String b=null;
        Thread s = new Thread(new Runnable() {
            @Override
            public void run() {
                b.substring(0);
            }
        });
        s.setUncaughtExceptionHandler(exceptionHandler);
        s.start();
    }
}
