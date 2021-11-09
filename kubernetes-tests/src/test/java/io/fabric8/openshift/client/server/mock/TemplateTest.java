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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.api.model.APIGroupListBuilder;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServicePort;
import io.fabric8.kubernetes.api.model.ServiceSpec;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.utils.IOHelpers;
import io.fabric8.openshift.api.model.ParameterBuilder;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.api.model.TemplateListBuilder;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import io.fabric8.openshift.client.ParameterValue;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class TemplateTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void testList() {
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/templates").andReturn(200, new TemplateListBuilder().build()).once();
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/ns1/templates").andReturn(200, new TemplateListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();
    server.expect().withPath("/apis").andReturn(200, new APIGroupListBuilder()
      .addNewGroup()
      .withApiVersion("v1")
      .withName("autoscaling.k8s.io")
      .endGroup()
      .addNewGroup()
      .withApiVersion("v1")
      .withName("security.openshift.io")
      .endGroup()
      .build()).always();

    server.expect().withPath("/apis/template.openshift.io/v1/templates").andReturn(200, new TemplateListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();


    TemplateList templateList = client.templates().list();
    assertNotNull(templateList);
    assertEquals(0, templateList.getItems().size());

    templateList = client.templates().inNamespace("ns1").list();
    assertNotNull(templateList);
    assertEquals(2, templateList.getItems().size());

    templateList = client.templates().inAnyNamespace().list();
    assertNotNull(templateList);
    assertEquals(3, templateList.getItems().size());
  }

  @Test
  void testListWithParams() throws IOException {
    String json = IOHelpers.readFully(getClass().getResourceAsStream("/template-list-with-number-params.json"));

    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/templates").andReturn(200, json).always();


    Map<String, String> map = new HashMap<>();
    map.put("PORT", "8080");

    TemplateList templateList = client.templates().withParameters(map).list();
    assertNotNull(templateList);
    assertEquals(1, templateList.getItems().size());
  }


  @Test
  void testGet() {
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/templates/tmpl1").andReturn(200, new TemplateBuilder()
      .withNewMetadata().withName("tmpl1").endMetadata()
      .build()).once();

    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/ns1/templates/tmpl2").andReturn(200, new TemplateBuilder()
      .withNewMetadata().withName("tmpl2").endMetadata()
      .build()).once();


    Template template = client.templates().withName("tmpl1").get();
    assertNotNull(template);
    assertEquals("tmpl1", template.getMetadata().getName());

    template = client.templates().withName("tmpl2").get();
    assertNull(template);

    template = client.templates().inNamespace("ns1").withName("tmpl2").get();
    assertNotNull(template);
    assertEquals("tmpl2", template.getMetadata().getName());
  }


  @Test
  void testDelete() {
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/templates/tmpl1").andReturn(200, new TemplateBuilder().build()).once();
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/ns1/templates/tmpl2").andReturn(200, new TemplateBuilder().build()).once();


    Boolean deleted = client.templates().withName("tmpl1").delete();
    assertNotNull(deleted);

    deleted = client.templates().withName("tmpl2").delete();
    assertFalse(deleted);

    deleted = client.templates().inNamespace("ns1").withName("tmpl2").delete();
    assertTrue(deleted);
  }

  @Test
  void testCreateWithHandler() {
    Template template = new TemplateBuilder()
      .editOrNewMetadata()
      .withName("tmpl3")
      .withNamespace("test")
      .endMetadata()
      .build();

    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/templates").andReturn(200, template).once();
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/templates/tmpl3").andReturn(404, new StatusBuilder().withCode(404).build()).once();


    Template created = client.resource(template).createOrReplace();
    assertNotNull(created);
  }


  @Test
  void testProcess() {
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/templates/tmpl1").andReturn(200, new TemplateBuilder().build()).once();
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/processedtemplates").andReturn(201, new KubernetesListBuilder().build()).once();

    KubernetesList list = client.templates().withName("tmpl1").process(new ParameterValue("name1", "value1"));
    assertNotNull(list);
  }

  @Test
  void shouldLoadTemplateWithNumberParameters() {
    OpenShiftClient client = new DefaultOpenShiftClient(new OpenShiftConfigBuilder().withDisableApiGroupCheck(true).build());
    Map<String, String> map = new HashMap<>();
    map.put("PORT", "8080");
    KubernetesList list = client.templates().withParameters(map).load(getClass().getResourceAsStream("/template-with-number-params.yml")).processLocally(map);
    assertListIsServiceWithPort8080(list);
    assertThat(list.getItems()).singleElement()
      .isInstanceOf(Service.class)
      .extracting("spec.ports").asList().singleElement()
      .hasFieldOrPropertyWithValue("port", 8080);
  }

  @Test
  void shouldGetTemplateWithNumberParameters() {
    OpenShiftClient client = new DefaultOpenShiftClient(new OpenShiftConfigBuilder().withDisableApiGroupCheck(true).build());
    Template template = client.templates().load(getClass().getResourceAsStream("/template-with-number-params.yml")).get();
    assertThat(template)
      .extracting(Template::getObjects).asList()
      .singleElement()
      .isInstanceOf(Service.class)
      .extracting("spec.ports").asList().singleElement()
      .hasFieldOrPropertyWithValue("additionalProperties.port", "${PORT}");
  }

  @Test
  void shouldGetTemplateWithMultipleObjects() {
    OpenShiftClient client = new DefaultOpenShiftClient(new OpenShiftConfigBuilder().withDisableApiGroupCheck(true).build());
    Template template = client.templates().load(getClass().getResourceAsStream("/template-with-multiple-objects.yml")).get();
    assertThat(template)
      .extracting(Template::getObjects).asList()
      .hasSize(3)
      .satisfies(l -> assertThat(l).first()
        .isInstanceOf(Service.class)
        .extracting("spec.ports").asList().singleElement()
        .hasFieldOrPropertyWithValue("additionalProperties.port", "${PORT}"))
      .satisfies(l -> assertThat(l).element(1)
        .isInstanceOf(Service.class)
        .extracting("spec.ports").asList().singleElement()
        .hasFieldOrPropertyWithValue("additionalProperties.port", "${BAZ_PORT}"))
      .satisfies(l -> assertThat(l).element(2)
        .isInstanceOf(ConfigMap.class)
        .hasFieldOrPropertyWithValue("metadata.name", "qux")
        .hasFieldOrPropertyWithValue("additionalProperties.immutable", "${IMMUTABLE}"));
  }

  protected void assertListIsServiceWithPort8080(KubernetesList list) {
    assertNotNull(list);
    assertListIsServiceWithPort8080(list.getItems());
  }

  protected static void assertListIsServiceWithPort8080(List<HasMetadata> items) {
    assertNotNull(items);
    assertEquals(1, items.size());
    HasMetadata item = items.get(0);
    assertTrue(item instanceof Service);
    Service service = (Service) item;
    ServiceSpec serviceSpec = service.getSpec();
    assertNotNull(serviceSpec);
    List<ServicePort> ports = serviceSpec.getPorts();
    assertEquals(1, ports.size());
    ServicePort port = ports.get(0);
    assertEquals(Integer.valueOf(8080), port.getPort());
  }

  @Test
  void testLoadParameterizedNumberTemplate() throws IOException {
    String json = IOHelpers.readFully(getClass().getResourceAsStream("/template-with-number-params.json"));
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/templates/tmpl1").andReturn(200, json).once();

    Map<String, String> map = new HashMap<>();
    map.put("PORT", "8080");

    Template template = client.templates().withParameters(map).withName("tmpl1").get();
    List<HasMetadata> list = template.getObjects();
    assertListIsServiceWithPort8080(list);
  }

  @Test
  void testProcessParameterizedNumberTemplate() throws IOException {
    String json = IOHelpers.readFully(getClass().getResourceAsStream("/template-with-number-params.json"));
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/templates/tmpl1").andReturn(200, json).once();

    Map<String, String> map = new HashMap<>();
    map.put("PORT", "8080");

    KubernetesList list = client.templates().withName("tmpl1").processLocally(map);
    assertListIsServiceWithPort8080(list);
  }

  @Test
  void testNullParameterMapValueShouldNotThrowNullPointerException() {
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/templates/tmpl1").andReturn(200, new TemplateBuilder()
      .withNewMetadata().withName("tmpl1").endMetadata()
      .withParameters(new ParameterBuilder().withName("key").build())
      .build()).once();
    Map<String, String> nullValueMap = singletonMap("key", null);
    KubernetesList list = client.templates().withName("tmpl1").processLocally(nullValueMap);
    assertNotNull(list);
  }

  @Test
  void testEmptyParameterMapValueShouldNotThrowNullPointerException() {
    server.expect().withPath("/apis/template.openshift.io/v1/namespaces/test/templates/tmpl1").andReturn(200, new TemplateBuilder()
      .withNewMetadata().withName("tmpl1").endMetadata()
      .withParameters(new ParameterBuilder().withName("key").build())
      .build()).once();
    Map<String, String> emptyValueMap = singletonMap("key", "");
    KubernetesList list = client.templates().withName("tmpl1").processLocally(emptyValueMap);
    assertNotNull(list);
  }

  @Test
  void testCreateOrReplaceOpenShif4() {
    // Given
    Template template = getTemplateBuilder().build();
    server.expect().post().withPath("/apis/template.openshift.io/v1/namespaces/ns1/templates")
      .andReturn(HttpURLConnection.HTTP_OK, template)
      .once();

    // When
    template = client.templates().inNamespace("ns1").createOrReplace(template);

    // Then
    assertNotNull(template);
  }

  private TemplateBuilder getTemplateBuilder() {
    Pod pod = new PodBuilder()
      .withNewMetadata().withName("redis-master").endMetadata()
      .withNewSpec()
      .addNewContainer()
      .addNewEnv().withName("REDIS_PASSWORD").withValue("${REDIS_PASSWORD}").endEnv()
      .withImage("dockerfile/redis")
      .addNewPort()
      .withContainerPort(6379)
      .withProtocol("TCP")
      .endPort()
      .endContainer()
      .endSpec()
      .build();
    return new TemplateBuilder()
      .withNewMetadata()
      .withName("redis-template")
      .addToAnnotations("description", "Description")
      .addToAnnotations("iconClass", "icon-redis")
      .addToAnnotations("tags", "database,nosql")
      .endMetadata()
      .addToObjects(pod)
      .addNewParameter()
      .withDescription("Password used for Redis authentication")
      .withFrom("[A-Z0-9]{8}")
      .withGenerate("expression")
      .withName("REDIS_PASSWORD")
      .endParameter()
      .addToLabels("redis", "master");
  }

}
