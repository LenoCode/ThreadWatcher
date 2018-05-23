package test.gym;

public class RunMain {

    public static void main(String[] args){
        for (int i = 0 ; i < 100 ; ++i){
            Main.main(args);
            System.out.println("Finished  "+i);
        }
    }
}
