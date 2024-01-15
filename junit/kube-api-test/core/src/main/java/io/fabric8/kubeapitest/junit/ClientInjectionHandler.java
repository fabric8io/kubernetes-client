package io.fabric8.kubeapitest.junit;

import org.junit.jupiter.api.extension.ExtensionContext;

import io.fabric8.kubeapitest.KubeAPIServer;

public interface ClientInjectionHandler {

  boolean isTargetFieldAvailable(ExtensionContext extensionContext,
      boolean staticField);

  void inject(ExtensionContext extensionContext,
      boolean staticField, KubeAPIServer kubeApiServer);

  default void cleanup(ExtensionContext extensionContext) {}
}
