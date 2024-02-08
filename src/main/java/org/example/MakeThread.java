package org.example;

public class MakeThread extends Thread {
    // 공유 변수로 사용할 count
    public static int count = 0;

    @Override
    public void run() {
        // 스레드가 실행할 코드
        for (int i = 0; i < 10000; i++) {
                count++;
        }
    }

    public static void main(String[] args) {
        // MakeThread 객체를 3개 생성
        MakeThread thread1 = new MakeThread();
        MakeThread thread2 = new MakeThread();
        MakeThread thread3 = new MakeThread();

        // 각 스레드를 시작
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // 모든 스레드가 실행을 마칠 때까지 기다림
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 최종 결과 출력
        System.out.println("Final count value: " + count);
    }
}
