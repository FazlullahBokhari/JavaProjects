public class MTBasics {

    public static void main(String[] args) {

        MyThread thread = new MyThread();
        //thread.start();
        thread.run();

    }

    private static class MyThread extends Thread{

        @Override
        public void run(){
            System.out.println("In thread : "+currentThread().getName());
        }
    }
}
