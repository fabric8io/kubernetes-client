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
package io.fabric8.kubernetes.client;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.function.Consumer;

import io.fabric8.kubernetes.client.ResourceHandler.Key;
import io.fabric8.kubernetes.client.handlers.KubernetesListHandler;
import io.fabric8.kubernetes.client.handlers.core.v1.ServiceHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ResourceHandlerTest {

  @Test
  public void testKeyString() {
    Key k = new Key("deployment", "apps/v1");
    assertEquals("Key[kind=`deployment`, apiVersion=`apps/v1`]", k.toString());
  }

  @Test
  public void testKeyHashCode() {
    Key k1 = new Key("deployment", "apps/v1");
    Key k2 = new Key("deployment", "apps/v1");
    assertEquals(k1.hashCode(), k2.hashCode());
  }

  @Test
  public void testKeyEquals() {
    Key k1 = new Key("deployment", "apps/v1");
    Key k2 = new Key("deployment", "apps/v1");
    assertEquals(k1, k2);

    k1 = new Key("deployment", "apps/v1");
    k2 = new Key("other", "apps/v1");
    assertNotEquals(k1, k2);

    k1 = new Key("deployment", "apps/v1");
    k2 = new Key("deployment", "other");
    assertNotEquals(k1, k2);
  }

  @Test
  public void testAllRegisteredResourceHandlersKeysDiffer() {
    Map<Key,ResourceHandler<?,?>> keys = new LinkedHashMap<>();
    @SuppressWarnings("rawtypes")
    Consumer<ResourceHandler> check = h -> {
      ResourceHandler<?, ?> conflict = keys.put(new Key(h.getKind(), h.getApiVersion()), h);
      assertTrue(conflict==null || conflict.getClass().equals(h.getClass()), 
          "Identical keys for different handlers "+h+" and "+conflict);
    };
    ServiceLoader.load(ResourceHandler.class).forEach(check);
    // explicitly test KubernetesList because it is not included above in pojo, but it is a service in OSGi
    check.accept(new KubernetesListHandler());
    // and ServiceHandler which should already have been included above, but is known to conflict with KubernetesList
    check.accept(new ServiceHandler());
  }

}
