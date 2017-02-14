package io.fabric8.kubernetes.client;

class RequestConfigHolder {

  private static final ThreadLocal<RequestConfig> REQUEST_CONFIG = new ThreadLocal<>();

  static RequestConfig get() {
    return REQUEST_CONFIG.get();
  }

  static void set(RequestConfig requestConfig) {
    REQUEST_CONFIG.set(requestConfig);
  }

  static void remove() {
    REQUEST_CONFIG.remove();
  }
}
