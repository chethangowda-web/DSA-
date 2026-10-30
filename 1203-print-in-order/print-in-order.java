public class Foo {
  private AtomicBoolean firstDone = new AtomicBoolean(false);
  private AtomicBoolean secondDone = new AtomicBoolean(false);

  public void first(Runnable printFirst) throws InterruptedException {
    printFirst.run();
    firstDone.set(true);
  }

  public void second(Runnable printSecond) throws InterruptedException {
    while (!firstDone.get()) {
      // wait for first to be completed
    }
    printSecond.run();
    secondDone.set(true);
  }

  public void third(Runnable printThird) throws InterruptedException {
    while (!firstDone.get() || !secondDone.get()) {
      // wait for first and second to be completed
    }
    printThird.run();
  }
}