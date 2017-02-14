package io.fabric8.kubernetes.client;

public class RequestConfigHolder {

  private static final ThreadLocal<RequestConfig> REQUEST_CONFIG = new ThreadLocal<>();

  public static RequestConfig get() {
    return REQUEST_CONFIG.get();
  }

  public static void set(RequestConfig requestConfig) {
    REQUEST_CONFIG.set(requestConfig);
  }

  public static void remove() {
    REQUEST_CONFIG.remove();
  }
}
