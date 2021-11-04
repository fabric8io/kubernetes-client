/**
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


package io.fabric8.tekton.mock;

import io.fabric8.kubernetes.client.server.mock.KubernetesMixedDispatcher;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServerExtension;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.tekton.client.NamespacedTektonClient;
import io.fabric8.tekton.client.TektonClient;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * The class that implements JUnit5 extension mechanism. You can use it directly in your JUnit test
 * by annotating it with <code>@ExtendWith(TektonMockServerExtension.class)</code> or through
 * <code>@EnableTektonMockClient</code> annotation
 */
public class TektonMockServerExtension extends KubernetesMockServerExtension {
  private TektonMockServer tektonMockServer;
  private NamespacedTektonClient tektonClient;

  @Override
  protected void destroy() {
    tektonMockServer.destroy();
    tektonClient.close();
  }

  @Override
  protected Class<?> getClientType() {
    return TektonClient.class;
  }

  @Override
  protected Class<?> getKubernetesMockServerType() {
    return TektonMockServer.class;
  }

  @Override
  protected void initializeKubernetesClientAndMockServer(Class<?> testClass) {
    EnableTektonMockClient a = testClass.getAnnotation(EnableTektonMockClient.class);
    final Map<ServerRequest, Queue<ServerResponse>> responses = new HashMap<>();
    tektonMockServer = a.crud()
      ? new TektonMockServer(new Context(), new MockWebServer(), responses, new KubernetesMixedDispatcher(responses), a.https())
      : new TektonMockServer(a.https());
    tektonMockServer.init();
    tektonClient = tektonMockServer.createTekton();
  }

  @Override
  protected void setFieldIfKubernetesClientOrMockServer(ExtensionContext context, boolean isStatic, Field field) throws IllegalAccessException {
    setFieldIfEqualsToProvidedType(context, isStatic, field, getClientType(), (i, f) -> f.set(i, tektonClient));
    setFieldIfEqualsToProvidedType(context, isStatic, field, getKubernetesMockServerType(), (i, f) -> f.set(i, tektonMockServer));
  }
}


