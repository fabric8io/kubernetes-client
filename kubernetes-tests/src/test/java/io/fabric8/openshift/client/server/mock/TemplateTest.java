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

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.api.model.TemplateListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.ParameterValue;

import org.junit.Rule;
import org.junit.Test;

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
}
