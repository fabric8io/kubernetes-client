package io.javaoperatorsdk.jenvtest;

public class JenvtestException extends RuntimeException {

  public JenvtestException() {}

  public JenvtestException(String message) {
    super(message);
  }

  public JenvtestException(String message, Throwable cause) {
    super(message, cause);
  }

  public JenvtestException(Throwable cause) {
    super(cause);
  }

  public JenvtestException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
