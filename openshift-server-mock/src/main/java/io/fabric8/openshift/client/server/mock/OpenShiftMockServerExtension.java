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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesCrudDispatcher;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServerExtension;
import io.fabric8.mockwebserver.Context;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;

/**
 * The class that implements JUnit5 extension mechanism. You can use it directly in your JUnit test
 * by annotating it with <code>@ExtendWith(OpenShiftMockServerExtension.class)</code> or through
 * <code>@EnableOpenShiftMockClient</code> annotation
 */
public class OpenShiftMockServerExtension extends KubernetesMockServerExtension {
  private OpenShiftMockServer openShiftMockServer;
  private NamespacedOpenShiftClient openShiftClient;

  @Override
  protected void destroy() {
    openShiftMockServer.destroy();
    openShiftClient.close();
  }

  @Override
  protected Class<?> getClientType() {
    return OpenShiftClient.class;
  }

  @Override
  protected Class<?> getKubernetesMockServerType() {
    return OpenShiftMockServer.class;
  }

  @Override
  protected boolean initializeKubernetesClientAndMockServer(Class<?> testClass, boolean isStatic) {
    EnableOpenShiftMockClient a = testClass.getAnnotation(EnableOpenShiftMockClient.class);
    if(!isStatic && !testClass.getAnnotation(EnableOpenShiftMockClient.class).instanceMock()) {
      return false;
    }
    openShiftMockServer = a.crud()
      ? new OpenShiftMockServer(new Context(), new MockWebServer(), new HashMap<>(), new KubernetesCrudDispatcher(Collections.emptyList()), a.https())
      : new OpenShiftMockServer(a.https());
    openShiftMockServer.init();
    openShiftClient = openShiftMockServer.createOpenShiftClient();
    return true;
  }

  @Override
  protected void setFieldIfKubernetesClientOrMockServer(ExtensionContext context, boolean isStatic, Field field) throws IllegalAccessException {
    setFieldIfEqualsToProvidedType(context, isStatic, field, getClientType(), (i, f) -> f.set(i, openShiftClient));
    setFieldIfEqualsToProvidedType(context, isStatic, field, getKubernetesMockServerType(), (i, f) -> f.set(i, openShiftMockServer));
  }
}
