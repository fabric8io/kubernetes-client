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
package io.fabric8.istio.mock;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.junit.jupiter.api.extension.ExtensionContext;

import io.fabric8.istio.client.IstioClient;
import io.fabric8.istio.client.NamespacedIstioClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMixedDispatcher;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServerExtension;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * The class that implements JUnit5 extension mechanism. You can use it directly in your JUnit test
 * by annotating it with <code>@ExtendWith(KnativeMockServerExtension.class)</code> or through
 * <code>@EnableKnativeMockClient</code> annotation
 */
public class IstioMockServerExtension extends KubernetesMockServerExtension {
  private IstioMockServer mockServer;
  private NamespacedIstioClient istioClient;

  @Override
  protected void destroy() {
    mockServer.destroy();
    istioClient.close();
  }

  @Override
  protected Class<?> getClientType() {
    return IstioClient.class;
  }

  @Override
  protected Class<?> getKubernetesMockServerType() {
    return IstioMockServer.class;
  }

  @Override
  protected void initializeKubernetesClientAndMockServer(Class<?> testClass) {
    EnableIstioMockClient a = testClass.getAnnotation(EnableIstioMockClient.class);
    final Map<ServerRequest, Queue<ServerResponse>> responses = new HashMap<>();
    mockServer = a.crud()
      ? new IstioMockServer(new Context(), new MockWebServer(), responses, new KubernetesMixedDispatcher(responses), a.https())
      : new IstioMockServer(a.https());
    mockServer.init();
    istioClient = mockServer.createIstio();
  }

  @Override
  protected void setFieldIfKubernetesClientOrMockServer(ExtensionContext context, boolean isStatic, Field field) throws IllegalAccessException {
    setFieldIfEqualsToProvidedType(context, isStatic, field, getClientType(), (i, f) -> f.set(i, istioClient));
    setFieldIfEqualsToProvidedType(context, isStatic, field, getKubernetesMockServerType(), (i, f) -> f.set(i, mockServer));
  }
}
