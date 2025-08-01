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
package io.fabric8.crdv2.generator;

import io.fabric8.crd.generator.annotation.Annotations;
import io.fabric8.crd.generator.annotation.Labels;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.Scope;
import io.fabric8.kubernetes.model.annotation.Categories;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomResourceInfoTest {

  public static class Spec {
  }

  public static class Status {
  }

  private static final String GROUP = "sample.fabric8.io";
  private static final String VERSION = "v1";

  @Group(GROUP)
  @Version(VERSION)
  @ShortNames("s")
  @Categories("cat")
  public static class ClusteredCR extends
      io.fabric8.kubernetes.client.CustomResource<Spec, Status> {
  }

  @Group(GROUP)
  @Version(VERSION)
  public static class NamespacedCR extends io.fabric8.kubernetes.client.CustomResource<Spec, Status>
      implements Namespaced {
  }

  @Group(GROUP)
  @Version(VERSION)
  static class PackagePrivateInnerCustomResource extends
      io.fabric8.kubernetes.client.CustomResource<Void, Void> {
  }

  @Group(GROUP)
  @Version(VERSION)
  private static class PrivateInnerCustomResource extends
      io.fabric8.kubernetes.client.CustomResource<Void, Void> {
  }

  @Group(GROUP)
  @Version(VERSION)
  private static class NoDefaultConstructorCustomResource extends CustomResource<Void, Void> {
    NoDefaultConstructorCustomResource(String s) {
    }
  }

  @Group(GROUP)
  @Version(VERSION)
  @Annotations({ "test-annotation=test-value", "another-annotation=another-value" })
  @Labels({ "test-label=test-value", "another-label=another-value" })
  public static class AnnotatedCR extends io.fabric8.kubernetes.client.CustomResource<Spec, Status> {
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

  @Test
  void shouldProperlyCreateCustomResourceInfo() {
    CustomResourceInfo info = CustomResourceInfo.fromClass(ClusteredCR.class);
    assertEquals(GROUP, info.group());
    assertEquals(VERSION, info.version());
    assertEquals(Scope.CLUSTER, info.scope());
    assertEquals(ClusteredCR.class.getCanonicalName(), info.crClassName()); // todo: should we actually use the type name here?
    assertTrue(info.specClassName().isPresent());
    String specClassName = info.specClassName().get();
    assertEquals(Spec.class.getName(), specClassName);
    // todo: check that we can load and instantiate class from the returned class name
    /*
     * Class<?> specClass = Class.forName(specClassName);
     * Object o = specClass.getDeclaredConstructor().newInstance();
     * assertNotNull(o);
     */
    assertTrue(info.statusClassName().isPresent());
    assertEquals(Status.class.getName(), info.statusClassName().get());
    assertEquals(HasMetadata.getSingular(ClusteredCR.class), info.singular());
    assertEquals(HasMetadata.getPlural(ClusteredCR.class), info.plural());
    assertEquals(CustomResource.getCRDName(ClusteredCR.class), info.crdName());
    assertArrayEquals(CustomResource.getShortNames(ClusteredCR.class), info.shortNames());
    assertArrayEquals(CustomResource.getCategories(ClusteredCR.class), info.categories());
    assertTrue(info.served());
    assertTrue(info.storage());
    assertEquals(HasMetadata.getKind(ClusteredCR.class), info.kind());
  }

  @Test
  void shouldCreateCustomResourceInfoFromPackagePrivateClass() {
    CustomResourceInfo info = CustomResourceInfo.fromClass(PackagePrivateInnerCustomResource.class);
    assertNotNull(info);
  }

  @Test
  void shouldCreateCustomResourceInfoFromPrivateClass() {
    CustomResourceInfo info = CustomResourceInfo.fromClass(PrivateInnerCustomResource.class);
    assertNotNull(info);
  }

  @Test
  void shouldFailForMissingDefaultConstructor() {
    assertThrows(IllegalStateException.class,
        () -> CustomResourceInfo.fromClass(NoDefaultConstructorCustomResource.class));
  }

  @Test
  void shouldIncludeAnnotationsAndLabelsInCustomResourceInfo() {
    CustomResourceInfo info = CustomResourceInfo.fromClass(AnnotatedCR.class);

    String[] expectedAnnotations = { "test-annotation=test-value", "another-annotation=another-value" };
    String[] expectedLabels = { "test-label=test-value", "another-label=another-value" };

    assertArrayEquals(expectedAnnotations, info.annotations());
    assertArrayEquals(expectedLabels, info.labels());
  }
}
