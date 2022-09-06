package dailyPromblem;

public class s1115 {
    class FooBar {
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        volatile boolean permitFoo = true;

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n;) {
                if (permitFoo) {
                    printFoo.run();
                    i++;
                    permitFoo = false;
                } else {
                    // 线程让步
                    Thread.yield();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n;) {
                if (!permitFoo) {
                    printBar.run();
                    i++;
                    permitFoo = true;
                } else {
                    Thread.yield();
                }
            }
        }

    }
}
