package io.javaoperatorsdk.jenvtest.junit;

import org.junit.jupiter.api.extension.ExtensionContext;

import io.javaoperatorsdk.jenvtest.KubeAPIServer;

public interface ClientInjectionHandler {

  boolean isTargetFieldAvailable(ExtensionContext extensionContext,
      boolean staticField);

  void inject(ExtensionContext extensionContext,
      boolean staticField, KubeAPIServer kubeApiServer);

  default void cleanup(ExtensionContext extensionContext) {}
}
