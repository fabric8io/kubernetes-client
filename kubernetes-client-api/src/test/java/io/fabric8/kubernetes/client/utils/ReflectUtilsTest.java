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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;

class ReflectUtilsTest {

  static class Foo {
    private ObjectMeta metadata;

    public void setMetadata(ObjectMeta metadata) {
      this.metadata = metadata;
    }

    public ObjectMeta getMetadata() {
      return metadata;
    }
  }

  static class Bar extends Foo {
  }

  static abstract class AbstractBaz implements HasMetadata {
    private ObjectMeta metadata;
    private String apiVersion;

    @Override
    public void setMetadata(ObjectMeta metadata) {
      this.metadata = metadata;
    }

    @Override
    public ObjectMeta getMetadata() {
      return this.metadata;
    }

    @Override
    public void setApiVersion(String version) {
      this.apiVersion = version;
    }

    @Override
    public String getApiVersion() {
      return this.apiVersion;
    }

  }

  static class Baz extends AbstractBaz {
    @Override
    public String getKind() {
      return Baz.class.getSimpleName();
    }
  }

  @Test
  void testDirectReflection() throws ReflectiveOperationException {
    ObjectMeta meta = new ObjectMeta();
    Foo foo = new Foo();
    foo.setMetadata(meta);
    assertSame(meta, ReflectUtils.objectMetadata(foo));
  }

  @Test
  void testDerivedReflection() throws ReflectiveOperationException {
    ObjectMeta meta = new ObjectMeta();
    Foo bar = new Bar();
    bar.setMetadata(meta);
    assertSame(meta, ReflectUtils.objectMetadata(bar));
  }

  @Test
  void testInstanceOf() throws ReflectiveOperationException {
    ObjectMeta meta = new ObjectMeta();
    Baz baz = new Baz();
    baz.setMetadata(meta);
    assertSame(meta, ReflectUtils.objectMetadata(baz));
  }

  @Test
  void testObjectMetadataReturnsNullOnNull() throws ReflectiveOperationException {
    // Given
    Object input = null;

    // When
    ObjectMeta result = ReflectUtils.objectMetadata(input);

    // Then
    assertThat(result).isNull();
  }

  @Test
  void testNamespaceReturnsValidNamespace() throws ReflectiveOperationException {
    // Given
    Object input = new ConfigMapBuilder().withNewMetadata().withNamespace("ns1").endMetadata().build();

    // When
    String result = ReflectUtils.namespace(input);

    // Then
    assertThat(result).isNotNull().isEqualTo("ns1");
  }

  @Test
  void testNamespaceReturnsBlankNamespace() throws ReflectiveOperationException {
    // Given
    Object input = null;

    // When
    String result = ReflectUtils.namespace(input);

    // Then
    assertThat(result).isNotNull().isBlank();
  }

}
