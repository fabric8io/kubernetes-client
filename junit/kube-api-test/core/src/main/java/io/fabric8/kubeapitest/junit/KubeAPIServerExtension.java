/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubeapitest.junit;

import io.fabric8.kubeapitest.KubeAPIServer;
import io.fabric8.kubeapitest.KubeAPIServerConfig;
import io.fabric8.kubeapitest.KubeAPIServerConfigBuilder;
import io.fabric8.kubeapitest.KubeAPITestException;
import org.junit.jupiter.api.extension.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class KubeAPIServerExtension
    implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

  private static final Logger log = LoggerFactory.getLogger(KubeAPIServerExtension.class);

  private KubeAPIServer kubeApiServer;
  private List<ClientInjectionHandler> clientInjectionHandlers;

  public KubeAPIServerExtension() {
    var loader = ServiceLoader.load(ClientInjectionHandler.class);
    clientInjectionHandlers = loader.stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
  }

  @Override
  public void beforeAll(ExtensionContext extensionContext) {
    initialize(extensionContext, true);
  }

  @Override
  public void afterAll(ExtensionContext extensionContext) {
    stopIfAnnotationPresent(extensionContext);
  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) {
    initialize(extensionContext, false);
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) {
    stopIfAnnotationPresent(extensionContext);
  }

  private void initialize(ExtensionContext extensionContext, boolean staticContext) {
    var targetInjectors = clientInjectionHandlers.stream()
        .filter(h -> h.isTargetFieldAvailable(extensionContext, staticContext))
        .collect(Collectors.toList());

    startIfAnnotationPresent(extensionContext, !targetInjectors.isEmpty());

    targetInjectors.forEach(i -> i.inject(extensionContext, staticContext, kubeApiServer));
  }

  private void startIfAnnotationPresent(ExtensionContext extensionContext,
      boolean willInjectClient) {
    extensionContext.getElement().ifPresent(ae -> {
      var annotation = getExtensionAnnotationInstance(ae);

      annotation.ifPresent(a -> {
        if (!willInjectClient && !a.updateKubeConfigFile()) {
          log.warn(
              "Neither kube config file will be updated or client info will be injected into the test. "
                  +
                  "This is probably a misconfiguration since server won't be easily accessible.");
        }
        startApiServer(a);
      });
    });
  }

  private void startApiServer(EnableKubeAPIServer annotation) {
    kubeApiServer = new KubeAPIServer(annotationToConfig(annotation));
    kubeApiServer.start();
  }

  private void stopIfAnnotationPresent(ExtensionContext extensionContext) {
    extensionContext.getElement().ifPresent(ae -> {
      var annotation = getExtensionAnnotationInstance(ae);
      annotation.ifPresent(a -> {
        clientInjectionHandlers.forEach(ih -> ih.cleanup(extensionContext));
        kubeApiServer.stop();
      });
    });
  }

  private KubeAPIServerConfig annotationToConfig(EnableKubeAPIServer annotation) {
    var builder = KubeAPIServerConfigBuilder.anAPIServerConfig();
    var version = annotation.kubeAPIVersion();
    if (!EnableKubeAPIServer.NOT_SET.equals(version)) {
      builder.withApiServerVersion(version);
    }
    if (annotation.apiServerFlags().length > 0) {
      builder.withApiServerFlags(List.of(annotation.apiServerFlags()));
    }

    builder.withUpdateKubeConfig(annotation.updateKubeConfigFile());
    return builder.build();
  }

  private Optional<EnableKubeAPIServer> getExtensionAnnotationInstance(AnnotatedElement ae) {
    var annotations = Arrays.stream(ae.getAnnotations())
        .filter(a -> a.annotationType().isAssignableFrom(EnableKubeAPIServer.class))
        .collect(Collectors.toList());
    if (annotations.size() > 1) {
      throw new KubeAPITestException(
          "Only one instance of @EnableKubeAPIServer annotation is allowed");
    } else if (annotations.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.of((EnableKubeAPIServer) annotations.get(0));
    }
  }

}
