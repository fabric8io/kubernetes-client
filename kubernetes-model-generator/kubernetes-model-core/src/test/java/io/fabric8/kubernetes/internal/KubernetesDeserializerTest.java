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

import io.fabric8.kubernetes.api.KubernetesResourceMappingProvider;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.internal.KubernetesDeserializer.TypeKey;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KubernetesDeserializerTest {

  private KubernetesDeserializer.Mapping mapping;

  @BeforeEach
  public void beforeEach() {
    this.mapping = new TestableMapping(createProvider());
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
  void shouldNPEIfRegisterNullKind() {
    // given
    // when
    assertThrows(NullPointerException.class, () -> {
      mapping.registerKind("version1", null, SmurfResource.class);
    });
    // then throws
  }

  @Test
  void shouldRegisterKindWithoutVersionIfNullVersion() {
    // given
    String version = null;
    String kind = "kind1";
    TypeKey key = mapping.createKey(version, kind);
    // when
    mapping.registerKind(version, kind, SmurfResource.class);
    // then
    Class<? extends KubernetesResource> clazz = mapping.getForKey(key);
    assertThat(clazz).isEqualTo(SmurfResource.class);
  }

  @Test
  void shouldRegisterProvider() {
    // given
    TypeKey key = mapping.createKey("42", "Hitchhiker");
    assertThat(mapping.getForKey(key)).isNull();
    KubernetesResourceMappingProvider provider = createProvider(
        Pair.of("42#Hitchhiker", SmurfResource.class));
    // when
    mapping.registerProvider(provider);
    // then
    Class<? extends KubernetesResource> clazz = mapping.getForKey(key);
    assertThat(clazz).isEqualTo(SmurfResource.class);
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

  private KubernetesResourceMappingProvider createProvider(Pair<String, Class<? extends KubernetesResource>>... mappings) {
    return () -> Stream.of(mappings)
        .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
  }

  public static final class TestableMapping extends KubernetesDeserializer.Mapping {

    private final KubernetesResourceMappingProvider provider;

    public TestableMapping(KubernetesResourceMappingProvider provider) {
      this.provider = provider;
    }

    @Override
    protected Stream<KubernetesResourceMappingProvider> getAllMappingProviders() {
      return Stream.of(provider);
    }

  }

  private static final class SmurfResource implements KubernetesResource {
  }
}
