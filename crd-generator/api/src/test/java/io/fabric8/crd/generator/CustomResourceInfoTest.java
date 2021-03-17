/**
 * Copyright (C) 2015 Red Hat, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.fabric8.crd.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.Scope;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.Test;

public class CustomResourceInfoTest {

  public static class Spec {

  }

  public static class Status {

  }

  private static final String GROUP = "sample.fabric8.io";
  private static final String VERSION = "v1";

  @Group(GROUP)
  @Version(VERSION)
  public static class ClusteredCR extends CustomResource<Spec, Status> {

  }

  @Group(GROUP)
  @Version(VERSION)
  public static class NamespacedCR extends CustomResource<Spec, Status> implements Namespaced {

  }

  @Test
  void shouldBeProperlyScoped() {
    CustomResourceInfo info = CustomResourceInfo.fromClass(ClusteredCR.class);
    assertEquals(GROUP, info.group());
    assertEquals(VERSION, info.version());
    assertEquals(Scope.CLUSTER, info.scope());

    info = CustomResourceInfo.fromClass(NamespacedCR.class);
    assertEquals(GROUP, info.group());
    assertEquals(VERSION, info.version());
    assertEquals(Scope.NAMESPACED, info.scope());
  }
}
