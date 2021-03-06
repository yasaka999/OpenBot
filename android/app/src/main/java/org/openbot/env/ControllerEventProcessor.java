package org.openbot.env;

import io.reactivex.rxjava3.subjects.PublishSubject;

public final class ControllerEventProcessor {

  public enum ControllerEventsTypes {
    LOGGING,
    INDICATOR_LEFT,
    INDICATOR_RIGHT,
    INDICATOR_STOP,
    DRIVE_MODE,
    NOISE,
    NETWROK,
    DRIVE_CMD,
  }

  public static class DriveValue {
    DriveValue(Float l, Float r) {
      leftValue = l;
      rightValue = r;
    }

    private Float leftValue;
    private Float rightValue;

    public Float getLeftValue() {
      return leftValue;
    }

    public Float getRightValue() {
      return rightValue;
    }
  }

  public static class ControllerEvent<T> {
    public ControllerEventsTypes type;
    public T payload;
  }

  private ControllerEventProcessor() {}

  private static PublishSubject<ControllerEvent> subject = PublishSubject.create();

  public static PublishSubject<ControllerEvent> getProcessor() {
    return subject;
  }

  public static void emitEvent(ControllerEvent event) {
    subject.onNext(event);
  }
}
