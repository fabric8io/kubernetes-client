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
package io.fabric8.kubernetes;

import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.APIService;
import io.fabric8.kubernetes.api.model.APIServiceBuilder;
import io.fabric8.kubernetes.api.model.APIServiceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class APIServiceIT {
  @ArquillianResource
  KubernetesClient client;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(APIServiceIT.class.getResourceAsStream("/apiservice-it.yml"));
  }

  @Test
  public void get() {
    APIService apiService = client.apiServices().withName("v1beta1.get.fabric8.io").get();
    assertThat(apiService).isNotNull();
  }

  @Test
  public void list() {
    APIServiceList aAPIServiceList = client.apiServices().list();
    assertNotNull(aAPIServiceList);
    assertTrue(aAPIServiceList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    APIService apiService = client.apiServices().withName("v1beta1.update.fabric8.io").edit(c -> new APIServiceBuilder(c)
      .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata()
      .build());

    assertNotNull(apiService);
    assertEquals("bar", apiService.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.apiServices().withName("v1beta1.delete.fabric8.io").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(APIServiceIT.class.getResourceAsStream("/apiservice-it.yml"));
  }
}
