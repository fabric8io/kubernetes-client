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

import io.fabric8.kubernetes.api.model.Table;
import io.fabric8.kubernetes.api.model.TableColumnDefinition;
import io.fabric8.kubernetes.api.model.TableRow;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.mockwebserver.http.RecordedRequest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false)
class TableAcceptHeaderTest {

  private static final String EXPECTED_ACCEPT = "application/json;as=Table;v=v1;g=meta.k8s.io,"
      + "application/json;as=Table;v=v1beta1;g=meta.k8s.io,"
      + "application/json";

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void getSendsCorrectAcceptHeader() throws InterruptedException {
    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods/my-pod")
        .andReturn(200, table(
            List.of(columnDef("Name", "string")),
            List.of(row("my-pod"))))
        .once();

    client.pods().inNamespace("default").withName("my-pod").getAsTable();

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept")).isEqualTo(EXPECTED_ACCEPT);
  }

  @Test
  void listSendsCorrectAcceptHeader() throws InterruptedException {
    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods")
        .andReturn(200, table(
            List.of(columnDef("Name", "string")),
            List.of(row("pod-1"))))
        .once();

    client.pods().inNamespace("default").listAsTable();

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept")).isEqualTo(EXPECTED_ACCEPT);
  }

  @Test
  void getAcceptHeaderForNonCoreApiResources() throws InterruptedException {
    server.expect().get()
        .withPath("/apis/apps/v1/namespaces/staging/deployments/my-deploy")
        .andReturn(200, table(
            List.of(columnDef("Name", "string")),
            List.of(row("my-deploy"))))
        .once();

    client.apps().deployments().inNamespace("staging").withName("my-deploy").getAsTable();

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept")).isEqualTo(EXPECTED_ACCEPT);
  }

  @Test
  void listAcceptHeaderForClusterScopedResources() throws InterruptedException {
    server.expect().get()
        .withPath("/api/v1/nodes")
        .andReturn(200, table(
            List.of(columnDef("Name", "string")),
            List.of(row("node-1"))))
        .once();

    client.nodes().listAsTable();

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept")).isEqualTo(EXPECTED_ACCEPT);
  }

  @Test
  void listAcceptHeaderInAnyNamespace() throws InterruptedException {
    server.expect().get()
        .withPath("/api/v1/pods")
        .andReturn(200, table(
            List.of(columnDef("Name", "string")),
            List.of(row("pod-a"))))
        .once();

    client.pods().inAnyNamespace().listAsTable();

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept")).isEqualTo(EXPECTED_ACCEPT);
  }

  @Test
  void getReturnsNullOn404() {
    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods/missing-pod")
        .andReturn(404,
            "{\"kind\":\"Status\",\"apiVersion\":\"v1\",\"status\":\"Failure\",\"reason\":\"NotFound\",\"code\":404}")
        .once();

    Table result = client.pods()
        .inNamespace("default")
        .withName("missing-pod")
        .getAsTable();

    assertThat(result).isNull();
  }

  // --- helpers ---

  private static TableColumnDefinition columnDef(String name, String type) {
    TableColumnDefinition def = new TableColumnDefinition();
    def.setName(name);
    def.setType(type);
    return def;
  }

  private static TableRow row(Object... cells) {
    TableRow row = new TableRow();
    row.setCells(Arrays.asList(cells));
    return row;
  }

  private static Table table(List<TableColumnDefinition> columns, List<TableRow> rows) {
    Table t = new Table();
    t.setApiVersion("meta.k8s.io/v1");
    t.setKind("Table");
    t.setColumnDefinitions(columns);
    t.setRows(rows);
    return t;
  }
}
