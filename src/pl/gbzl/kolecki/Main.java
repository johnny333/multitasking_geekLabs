package pl.gbzl.kolecki;

public class Main {

    public static void main(String[] args) {
        Word A = new Word("java");
        Word B = new Word("kompilator");
        A.setOtherThred(B);
        B.setOtherThred(A);
        A.start();
        B.start();


        try {
            A.join();
            B.join();
        } catch (InterruptedException e) {}
    }
}
class Word extends Thread {
    private String word;
    private Thread other;

    public Word(String aWord) {
        this.word = aWord;
    }

    public void setOtherThred(Thread thread) {
        this.other = thread;
    }

    public void run() {
        for (int i = 0; i < this.word.length(); i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.print(e.toString());
            }
            System.out.println(this.word.charAt(i));

        }
    }
}