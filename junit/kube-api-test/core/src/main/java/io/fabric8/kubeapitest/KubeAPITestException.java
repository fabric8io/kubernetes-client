package io.fabric8.kubeapitest;

public class KubeAPITestException extends RuntimeException {

  public KubeAPITestException() {}

  public KubeAPITestException(String message) {
    super(message);
  }

  public KubeAPITestException(String message, Throwable cause) {
    super(message, cause);
  }

  public KubeAPITestException(Throwable cause) {
    super(cause);
  }

  public KubeAPITestException(String message, Throwable cause, boolean enableSuppression,
                              boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
