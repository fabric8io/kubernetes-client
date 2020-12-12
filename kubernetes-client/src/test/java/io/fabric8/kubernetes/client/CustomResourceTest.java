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

import io.fabric8.kubernetes.model.annotation.ApiGroup;
import io.fabric8.kubernetes.model.annotation.ApiVersion;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomResourceTest {
  private static class MissingApiVersion extends CustomResource {
  }
  
  @ApiVersion(Good.VERSION)
  @ApiGroup(Good.GROUP)
  private static class Good extends CustomResource {
    public static final String VERSION = "v1beta1";
    public static final String GROUP = "sample.fabric8.io";
  }
  
  @Test
  public void missingGroupAndVersionShouldFail() {
    assertThrows(IllegalArgumentException.class, () -> new MissingApiVersion().getApiVersion());
  }
  
  @Test
  public void valuesShouldProperlyBeComputedFromDefaultsAndAnnotations() {
    final Good good = new Good();
    assertEquals("Good", good.getKind());
    assertEquals("goods", good.getPlural());
    assertEquals(Good.GROUP + "/" + Good.VERSION, good.getApiVersion());
    assertEquals(good.getPlural() + "." + Good.GROUP, good.getCRDName());
    assertEquals(Good.VERSION, good.getVersion());
    assertEquals(Good.GROUP, good.getGroup());
  }
}
