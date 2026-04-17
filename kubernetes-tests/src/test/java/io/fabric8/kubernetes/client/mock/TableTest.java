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

import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.Table;
import io.fabric8.kubernetes.api.model.TableColumnDefinition;
import io.fabric8.kubernetes.api.model.TableRow;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.mockwebserver.http.RecordedRequest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for Table support: fetching resources as server-rendered tables via
 * content negotiation (application/json;as=Table;v=v1;g=meta.k8s.io).
 */
@EnableKubernetesMockClient
class TableTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void getAsTableReturnsSingleRowWithColumnDefinitions() throws InterruptedException {
    Table table = table(
        List.of(columnDef("Name", "string"), columnDef("Ready", "string"), columnDef("Status", "string")),
        List.of(row("my-pod", "1/1", "Running")));

    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods/my-pod")
        .andReturn(200, table)
        .once();

    Table result = client.pods()
        .inNamespace("default")
        .withName("my-pod")
        .getAsTable();

    assertThat(result.getColumnDefinitions())
        .extracting("name")
        .containsExactly("Name", "Ready", "Status");
    assertThat(result.getRows()).hasSize(1);
    assertThat(result.getRows().get(0).getCells())
        .containsExactly("my-pod", "1/1", "Running");

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept"))
        .isEqualTo("application/json;as=Table;v=v1;g=meta.k8s.io");
  }

  @Test
  void listAsTableReturnsRowsForAllResourcesInNamespace() throws InterruptedException {
    Table table = table(
        List.of(columnDef("Name", "string"), columnDef("Status", "string")),
        List.of(
            row("pod-1", "Running"),
            row("pod-2", "Pending"),
            row("pod-3", "Running")));

    server.expect().get()
        .withPath("/api/v1/namespaces/production/pods")
        .andReturn(200, table)
        .once();

    Table result = client.pods()
        .inNamespace("production")
        .listAsTable();

    assertThat(result.getRows())
        .hasSize(3)
        .extracting(r -> r.getCells().get(0))
        .containsExactly("pod-1", "pod-2", "pod-3");

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept"))
        .isEqualTo("application/json;as=Table;v=v1;g=meta.k8s.io");
  }

  @Test
  void listAsTableWithLabelSelectorFiltersRows() {
    Table table = table(
        List.of(columnDef("Name", "string"), columnDef("Status", "string")),
        List.of(row("app-pod-1", "Running"), row("app-pod-2", "Running")));

    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods?labelSelector=" + Utils.toUrlEncoded("app=my-app"))
        .andReturn(200, table)
        .once();

    Table result = client.pods()
        .inNamespace("default")
        .withLabel("app", "my-app")
        .listAsTable();

    assertThat(result.getRows()).hasSize(2);
    assertThat(result.getRows().get(0).getCells().get(0)).isEqualTo("app-pod-1");
  }

  @Test
  void listAsTableWithOptionsPassesPaginationParameters() {
    Table table = table(
        List.of(columnDef("Name", "string")),
        List.of(row("pod-1"), row("pod-2")));

    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods?limit=2")
        .andReturn(200, table)
        .once();

    Table result = client.pods()
        .inNamespace("default")
        .listAsTable(new ListOptionsBuilder().withLimit(2L).build());

    assertThat(result.getRows()).hasSize(2);
  }

  @Test
  void listAsTableWorksForNonCoreApiResources() {
    Table table = table(
        List.of(columnDef("Name", "string"), columnDef("Ready", "string"), columnDef("Up-to-date", "string")),
        List.of(row("my-deploy", "3/3", "3"), row("other-deploy", "1/1", "1")));

    server.expect().get()
        .withPath("/apis/apps/v1/namespaces/staging/deployments")
        .andReturn(200, table)
        .once();

    Table result = client.apps().deployments()
        .inNamespace("staging")
        .listAsTable();

    assertThat(result.getColumnDefinitions())
        .extracting("name")
        .containsExactly("Name", "Ready", "Up-to-date");
    assertThat(result.getRows()).hasSize(2);
  }

  @Test
  void listAsTableWorksForClusterScopedResources() {
    Table table = table(
        List.of(columnDef("Name", "string"), columnDef("Status", "string"), columnDef("Roles", "string")),
        List.of(row("node-1", "Ready", "control-plane"), row("node-2", "Ready", "worker")));

    server.expect().get()
        .withPath("/api/v1/nodes")
        .andReturn(200, table)
        .once();

    Table result = client.nodes()
        .listAsTable();

    assertThat(result.getRows())
        .hasSize(2)
        .extracting(r -> r.getCells().get(0))
        .containsExactly("node-1", "node-2");
  }

  @Test
  void getAsTableReturnsNullWhenResourceNotFound() {
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

  @Test
  void listAsTableAcrossAllNamespaces() {
    Table table = table(
        List.of(columnDef("Name", "string"), columnDef("Namespace", "string")),
        List.of(row("pod-a", "ns-1"), row("pod-b", "ns-2")));

    server.expect().get()
        .withPath("/api/v1/pods")
        .andReturn(200, table)
        .once();

    Table result = client.pods()
        .inAnyNamespace()
        .listAsTable();

    assertThat(result.getRows())
        .hasSize(2)
        .extracting(r -> r.getCells().get(1))
        .containsExactly("ns-1", "ns-2");
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