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

import io.fabric8.commons.AssumingK8sVersionAtLeast;
import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.APIService;
import io.fabric8.kubernetes.api.model.APIServiceBuilder;
import io.fabric8.kubernetes.api.model.APIServiceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class APIServiceIT {

  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion =
    new AssumingK8sVersionAtLeast("1", "16");

  @ArquillianResource
  KubernetesClient client;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(APIServiceIT.class.getResourceAsStream("/apiservice-it.yml"));
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(APIServiceIT.class.getResourceAsStream("/apiservice-it.yml"));
  }

  @Test
  public void get() {
    APIService result = client.apiServices().withName("v1.tests.example.com").get();
    assertThat(result)
      .hasFieldOrPropertyWithValue("spec.group", "tests.example.com")
      .hasFieldOrPropertyWithValue("spec.version", "v1");
  }

  @Test
  public void list() {
    APIServiceList result = client.apiServices().list();
    assertThat(result).extracting(APIServiceList::getItems)
      .asInstanceOf(InstanceOfAssertFactories.list(APIService.class))
      .anyMatch(t -> t.getMetadata().getName().equals("v1.tests.example.com"));
  }

  @Test
  public void update() {
    APIService result = client.apiServices().withName("v1.tests.example.com")
      .edit(c -> new APIServiceBuilder(c)
        .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata()
        .build());
    assertThat(result)
      .hasFieldOrPropertyWithValue("metadata.annotations.foo", "bar")
      .hasFieldOrPropertyWithValue("spec.group", "tests.example.com")
      .hasFieldOrPropertyWithValue("spec.version", "v1");
  }

  @Test
  @Ignore(value = "https://github.com/fabric8io/kubernetes-client/issues/3668")
  public void delete() {
    assertThat(client.apiServices().withName("v1beta1.delete.fabric8.io").delete()).isTrue();
  }
}
