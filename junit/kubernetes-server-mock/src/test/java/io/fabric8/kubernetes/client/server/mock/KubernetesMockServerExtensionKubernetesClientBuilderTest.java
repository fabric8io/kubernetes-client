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
package io.fabric8.kubernetes.client.server.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.Test;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.ser.std.StdSerializer;

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
      final ObjectMapper customMapper = JsonMapper.builder()
          .addMixIn(ObjectMeta.class, ObjectMetaMixin.class)
          .build();
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
      public void serialize(String s, JsonGenerator jsonGenerator, SerializationContext serializationContext) {
        jsonGenerator.writeString(s + "-extended");
      }
    }
  }
}
