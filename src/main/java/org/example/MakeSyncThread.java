package org.example;

public class MakeSyncThread extends Thread {
    // 공유 변수로 사용할 count
    public static int count = 0;

    @Override
    public void run() {
        // 스레드가 실행할 코드
        for (int i = 0; i < 10000; i++) {
            // count를 안전하게 증가시키기 위해 synchronized 블록 사용
            synchronized (MakeThread.class) {
                count++;
            }
        }
    }

    public static void main(String[] args) {
        // MakeThread 객체를 3개 생성
        MakeSyncThread thread1 = new MakeSyncThread();
        MakeSyncThread thread2 = new MakeSyncThread();
        MakeSyncThread thread3 = new MakeSyncThread();

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
