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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ShardField;
import io.fabric8.kubernetes.client.dsl.ShardSelector;
import io.fabric8.kubernetes.client.dsl.ShardSelectorBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false)
class ShardSelectorFilterTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  @DisplayName("a typed ShardSelector is sent as the shardSelector query parameter of a list request")
  void listSendsTypedShardSelector() throws InterruptedException {
    ShardSelector selector = new ShardSelectorBuilder()
        .addShard(0, 4)
        .addShard(2, 4)
        .build();
    server.expect()
        .withPath("/api/v1/namespaces/test/pods?shardSelector=" + encodeQueryValue(selector.toExpression()))
        .andReturn(200, new PodListBuilder().addNewItem().and().build())
        .once();

    assertThat(client.pods().withShardSelector(selector).list().getItems()).hasSize(1);

    assertThat(decodedPathOfLastRequest()).isEqualTo("/api/v1/namespaces/test/pods?shardSelector=" +
        "shardRange(object.metadata.uid, '0x0000000000000000', '0x4000000000000000') || " +
        "shardRange(object.metadata.uid, '0x8000000000000000', '0xc000000000000000')");
  }

  @Test
  @DisplayName("the typed and the String overloads of withShardSelector produce the same request")
  void typedSelectorMatchesEquivalentExpression() throws InterruptedException {
    String expression = "shardRange(object.metadata.namespace, '0x0000000000000000', '0x8000000000000000')";
    server.expect()
        .withPath("/api/v1/namespaces/test/pods?shardSelector=" + encodeQueryValue(expression))
        .andReturn(200, new PodListBuilder().addNewItem().and().build())
        .always();

    assertThat(client.pods().withShardSelector(expression).list().getItems()).hasSize(1);
    String pathForExpression = decodedPathOfLastRequest();

    assertThat(client.pods()
        .withShardSelector(ShardSelector.ofShard(ShardField.NAMESPACE, 0, 2))
        .list()
        .getItems()).hasSize(1);

    assertThat(decodedPathOfLastRequest()).isEqualTo(pathForExpression);
  }

  @Test
  @DisplayName("a typed ShardSelector combines with the other filters instead of replacing them")
  void combinesWithLabelSelector() throws InterruptedException {
    ShardSelector selector = ShardSelector.ofShard(1, 2);
    server.expect()
        .withPath("/api/v1/namespaces/test/pods?labelSelector=" + encodeQueryValue("key1=value1")
            + "&shardSelector=" + encodeQueryValue(selector.toExpression()))
        .andReturn(200, new PodListBuilder().addNewItem().and().addNewItem().and().build())
        .once();

    assertThat(client.pods()
        .withLabel("key1", "value1")
        .withShardSelector(selector)
        .list()
        .getItems()).hasSize(2);

    assertThat(decodedPathOfLastRequest())
        .contains("labelSelector=key1=value1")
        .contains("shardSelector=" + selector.toExpression());
  }

  private String decodedPathOfLastRequest() throws InterruptedException {
    return URLDecoder.decode(server.getLastRequest().getPath(), StandardCharsets.UTF_8);
  }

  /**
   * Mirrors the encoding of {@code URLUtils.URLBuilder#addQueryParameter}, which escapes the space of a
   * shard selector expression as {@code %20} rather than as {@code +}.
   */
  private static String encodeQueryValue(String value) {
    return Utils.toUrlEncoded(value).replace("+", "%20");
  }
}
