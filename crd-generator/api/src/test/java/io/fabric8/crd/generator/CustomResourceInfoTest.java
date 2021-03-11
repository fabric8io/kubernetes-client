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
package io.fabric8.crd.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.Test;

public class CustomResourceInfoTest {

  public static class Spec {}
  public static class Status {}

  @Group(Foo.GROUP)
  @Version(Foo.VERSION)
  public static class Foo extends CustomResource<Spec, Status> {

    public static final String GROUP = "sample.fabric8.io";
    public static final String VERSION = "v1";
  }

  @Test
  void foo() {
    final CustomResourceInfo info = CustomResourceInfo.fromClass(Foo.class);
    assertEquals(Foo.GROUP, info.group());
    assertEquals(Foo.VERSION, info.version());
  }
}
