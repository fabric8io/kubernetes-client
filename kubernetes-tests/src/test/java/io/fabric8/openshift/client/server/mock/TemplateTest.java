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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServicePort;
import io.fabric8.kubernetes.api.model.ServiceSpec;
import io.fabric8.kubernetes.client.utils.IOHelpers;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.api.model.TemplateListBuilder;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import io.fabric8.openshift.client.ParameterValue;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.fabric8.kubernetes.client.utils.ReplaceValueStream.replaceValues;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TemplateTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer();

  @Test
  public void testList() {
   server.expect().withPath("/oapi/v1/namespaces/test/templates").andReturn(200, new TemplateListBuilder().build()).once();
   server.expect().withPath("/oapi/v1/namespaces/ns1/templates").andReturn(200, new TemplateListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

   server.expect().withPath("/oapi/v1/templates").andReturn(200, new TemplateListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

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
  public void testListWithParams() throws IOException {
    String json = IOHelpers.readFully(getClass().getResourceAsStream("/template-list-with-number-params.json"));

    server.expect().withPath("/oapi/v1/namespaces/test/templates").andReturn(200, json).always();

    OpenShiftClient client = server.getOpenshiftClient();

    Map<String,String> map = new HashMap<>();
    map.put("PORT", "8080");

    TemplateList templateList = client.templates().withParameters(map).list();
    assertNotNull(templateList);
    assertEquals(1, templateList.getItems().size());
  }


  @Test
  public void testGet() {
   server.expect().withPath("/oapi/v1/namespaces/test/templates/tmpl1").andReturn(200, new TemplateBuilder()
      .withNewMetadata().withName("tmpl1").endMetadata()
      .build()).once();

   server.expect().withPath("/oapi/v1/namespaces/ns1/templates/tmpl2").andReturn(200, new TemplateBuilder()
      .withNewMetadata().withName("tmpl2").endMetadata()
      .build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

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
  public void testDelete() {
   server.expect().withPath("/oapi/v1/namespaces/test/templates/tmpl1").andReturn(200, new TemplateBuilder().build()).once();
   server.expect().withPath("/oapi/v1/namespaces/ns1/templates/tmpl2").andReturn(200, new TemplateBuilder().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    Boolean deleted = client.templates().withName("tmpl1").delete();
    assertNotNull(deleted);

    deleted = client.templates().withName("tmpl2").delete();
    assertFalse(deleted);

    deleted = client.templates().inNamespace("ns1").withName("tmpl2").delete();
    assertTrue(deleted);
  }


  @Test
  public void testProcess() {
   server.expect().withPath("/oapi/v1/namespaces/test/templates/tmpl1").andReturn(200, new TemplateBuilder().build()).once();
   server.expect().withPath("/oapi/v1/namespaces/test/processedtemplates").andReturn( 201, new KubernetesListBuilder().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();
    KubernetesList list = client.templates().withName("tmpl1").process(new ParameterValue("name1", "value1"));
    assertNotNull(list);
  }

  @Test
  public void shouldLoadTemplateWithNumberParameters() throws Exception {
    OpenShiftClient client = new DefaultOpenShiftClient(new OpenShiftConfigBuilder().withDisableApiGroupCheck(true).build());
    Map<String,String> map = new HashMap<>();
    map.put("PORT", "8080");
    KubernetesList list = client.templates().load(replaceValues(getClass().getResourceAsStream("/template-with-number-params.yml"), map)).processLocally(map);
    assertListIsServiceWithPort8080(list);
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
    assertEquals(new Integer(8080), port.getPort());
  }

  @Test
  public void testLoadParameterizedNumberTemplate() throws IOException {
    String json = IOHelpers.readFully(getClass().getResourceAsStream("/template-with-number-params.json"));
    server.expect().withPath("/oapi/v1/namespaces/test/templates/tmpl1").andReturn(200, json).once();

    Map<String,String> map = new HashMap<>();
    map.put("PORT", "8080");

    OpenShiftClient client = server.getOpenshiftClient();
    Template template = client.templates().withParameters(map).withName("tmpl1").get();
    List<HasMetadata> list = template.getObjects();
    assertListIsServiceWithPort8080(list);
  }

  @Test
  public void testProcessParameterizedNumberTemplate() throws IOException {
    String json = IOHelpers.readFully(getClass().getResourceAsStream("/template-with-number-params.json"));
    server.expect().withPath("/oapi/v1/namespaces/test/templates/tmpl1").andReturn(200, json).once();

    Map<String,String> map = new HashMap<>();
    map.put("PORT", "8080");

    OpenShiftClient client = server.getOpenshiftClient();
    KubernetesList list = client.templates().withName("tmpl1").processLocally(map);
    assertListIsServiceWithPort8080(list);
  }
}
