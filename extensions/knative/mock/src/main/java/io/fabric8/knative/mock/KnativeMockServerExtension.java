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

package io.fabric8.knative.mock;


import io.fabric8.knative.client.KnativeClient;
import io.fabric8.knative.client.NamespacedKnativeClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMixedDispatcher;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServerExtension;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * The class that implements JUnit5 extension mechanism. You can use it directly in your JUnit test
 * by annotating it with <code>@ExtendWith(KnativeMockServerExtension.class)</code> or through
 * <code>@EnableKnativeMockClient</code> annotation
 */
public class KnativeMockServerExtension extends KubernetesMockServerExtension {
  private KnativeMockServer knativeMockServer;
  private NamespacedKnativeClient knativeClient;

  @Override
  protected void destroy() {
    knativeMockServer.destroy();
    knativeClient.close();
  }

  @Override
  protected Class<?> getClientType() {
    return KnativeClient.class;
  }

  @Override
  protected Class<?> getKubernetesMockServerType() {
    return KnativeMockServer.class;
  }

  @Override
  protected void initializeKubernetesClientAndMockServer(Class<?> testClass) {
    EnableKnativeMockClient a = testClass.getAnnotation(EnableKnativeMockClient.class);
    final Map<ServerRequest, Queue<ServerResponse>> responses = new HashMap<>();
    knativeMockServer = a.crud()
      ? new KnativeMockServer(new Context(), new MockWebServer(), responses, new KubernetesMixedDispatcher(responses), a.https())
      : new KnativeMockServer(a.https());
  knativeMockServer.init();
   knativeClient = knativeMockServer.createKnative();
  }

  @Override
  protected void setFieldIfKubernetesClientOrMockServer(ExtensionContext context, boolean isStatic, Field field) throws IllegalAccessException {
    setFieldIfEqualsToProvidedType(context, isStatic, field, getClientType(), (i, f) -> f.set(i, knativeClient));
    setFieldIfEqualsToProvidedType(context, isStatic, field, getKubernetesMockServerType(), (i, f) -> f.set(i, knativeMockServer));
  }
}
