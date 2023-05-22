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
package io.fabric8.kubernetes.internal;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.internal.KubernetesDeserializer.TypeKey;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesDeserializerTest {

  private KubernetesDeserializer.Mapping mapping;

  @BeforeEach
  public void beforeEach() {
    this.mapping = new KubernetesDeserializer.Mapping();
    this.mapping.registerClassesFromClassLoaders();
  }

  @Test
  void shouldRegisterKind() {
    // given
    String version = "version1";
    String kind = "kind1";
    TypeKey key = mapping.createKey(version, kind);
    assertThat(mapping.getForKey(key)).isNull();
    // when
    mapping.registerKind(version, kind, SmurfResource.class);
    // then
    Class<? extends KubernetesResource> clazz = mapping.getForKey(key);
    assertThat(clazz).isEqualTo(SmurfResource.class);
  }

  @Test
  void shouldNotRegisterKindWithoutVersionIfNullVersion() {
    // given
    String version = null;
    String kind = "kind1";
    TypeKey key = mapping.createKey(version, kind);
    // when
    mapping.registerKind(version, kind, SmurfResource.class);
    // then
    Class<? extends KubernetesResource> clazz = mapping.getForKey(key);
    assertThat(clazz).isNull();
  }

  @Test
  void shouldReturnMappedClass() {
    // given
    String version = "version1";
    String kind = SmurfResource.class.getSimpleName();
    TypeKey key = mapping.createKey(version, kind);
    assertThat(mapping.getForKey(key)).isNull();
    mapping.registerKind(version, kind, SmurfResource.class);
    // when
    Class<? extends KubernetesResource> clazz = mapping.getForKey(key);
    // then
    assertThat(clazz).isEqualTo(SmurfResource.class);
  }

  @Test
  void shouldReturnNullIfKeyIsNull() {
    // given
    // when
    Class<? extends KubernetesResource> clazz = mapping.getForKey(null);
    // then
    assertThat(clazz).isNull();
  }

  @Test
  void shouldLoadClassInPackage() {
    // given
    TypeKey key = mapping.getKeyFromClass(Pod.class);
    // when
    Class<? extends KubernetesResource> clazz = mapping.getForKey(key);
    // then
    assertThat(clazz).isEqualTo(Pod.class);
  }

  @Test
  void shouldNotLoadClassInPackage() {
    // given
    TypeKey key = mapping.createKey("other/v1", Pod.class.getSimpleName());
    // when
    Class<? extends KubernetesResource> clazz = mapping.getForKey(key);
    // then
    assertThat(clazz).isNull();
  }

  @Test
  void shouldNotLoadClassInPackageIfNotKubernetesResource() {
    // given Quantity is not a KubernetesResource
    TypeKey key = mapping.createKey("42", Quantity.class.getSimpleName());
    // when
    Class<? extends KubernetesResource> clazz = mapping.getForKey(key);
    // then
    assertThat(clazz).isNull();
  }

  @Test
  void shouldNotLoadClassIfKeyOnlyHasKind() {
    // given
    TypeKey key = mapping.createKey(null, Pod.class.getSimpleName());
    // when
    Class<? extends KubernetesResource> clazz = mapping.getForKey(key);
    // then
    assertThat(clazz).isNull();
  }

  @Group("")
  @Kind("Hitchhiker")
  @Version("42")
  private static final class SmurfResource implements KubernetesResource {
  }
}
