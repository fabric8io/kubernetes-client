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
import io.fabric8.kubernetes.api.model.LimitRange;
import io.fabric8.kubernetes.api.model.LimitRangeBuilder;
import io.fabric8.kubernetes.api.model.LimitRangeList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
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
public class LimitRangeIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private LimitRange limitRange;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(LimitRangeIT.class.getResourceAsStream("/limitrange-it.yml"));
  }

  @Test
  public void get() {
    limitRange = client.limitRanges().inNamespace(session.getNamespace()).withName("limitrange-get").get();
    assertThat(limitRange).isNotNull();
  }

  @Test
  public void list() {
    LimitRangeList aEndpointList = client.limitRanges().inNamespace(session.getNamespace()).list();
    assertNotNull(aEndpointList);
    assertTrue(aEndpointList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    limitRange = client.limitRanges().inNamespace(session.getNamespace()).withName("limitrange-update").edit(c -> new LimitRangeBuilder(c)
      .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata().build());

    assertNotNull(limitRange);
    assertEquals("bar", limitRange.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.limitRanges().inNamespace(session.getNamespace()).withName("limitrange-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(LimitRangeIT.class.getResourceAsStream("/limitrange-it.yml"));
  }
}
