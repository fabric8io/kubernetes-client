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
package io.fabric8.kubernetes.client.server.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(crud = true, kubernetesClientBuilderCustomizer = KubernetesMockServerExtensionKubernetesClientBuilderTest.CustomSerialization.class)
class KubernetesMockServerExtensionKubernetesClientBuilderTest {

  KubernetesClient client;

  @Test
  void usesCustomMapper() {
    // Given
    final Pod pod = new PodBuilder().withNewMetadata().withName("name").endMetadata().build();
    // When
    client.pods().resource(pod).create();
    // Then
    assertThat(client.pods())
        .returns(null, pr -> pr.withName("name").get())
        .extracting(pr -> pr.withName("name-extended").get())
        .isNotNull();
  }

  public static final class CustomSerialization implements Consumer<KubernetesClientBuilder> {

    @Override
    public void accept(KubernetesClientBuilder builder) {
      final ObjectMapper customMapper = new ObjectMapper();
      customMapper.addMixIn(ObjectMeta.class, ObjectMetaMixin.class);
      builder.withKubernetesSerialization(new KubernetesSerialization(customMapper, true));
    }

    private static final class ObjectMetaMixin {
      @JsonSerialize(using = StringAppenderSerializer.class)
      @JsonProperty("name")
      String name;
    }

    private static final class StringAppenderSerializer extends StdSerializer<String> {

      private StringAppenderSerializer() {
        super(String.class);
      }

      @Override
      public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(s + "-extended");
      }
    }
  }
}
