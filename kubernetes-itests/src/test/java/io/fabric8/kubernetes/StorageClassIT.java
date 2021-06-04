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
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassBuilder;
import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.client.KubernetesClient;
import static junit.framework.TestCase.assertNotNull;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class StorageClassIT {
  @ArquillianResource
  KubernetesClient client;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(StorageClassIT.class.getResourceAsStream("/storageclass-it.yml"));
  }

  @Test
  public void load() {
    StorageClass storageClassLoaded = client.storage().storageClasses().load(getClass().getResourceAsStream("/test-storageclass.yml")).get();
    assertNotNull(storageClassLoaded);
    assertEquals("gluster-vol-default", storageClassLoaded.getMetadata().getName());
  }

  @Test
  public void get() {
    StorageClass storageClass = client.storage().storageClasses().withName("storageclass-get").get();
    assertNotNull(storageClass);
  }

  @Test
  public void list() {
    StorageClassList storageClassList = client.storage().storageClasses().list();
    assertNotNull(storageClassList);
    assertTrue(storageClassList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    StorageClass storageClass = client.storage().storageClasses().withName("storageclass-update").edit(s -> new StorageClassBuilder(s).editMetadata().addToLabels("testLabel", "testLabelValue").endMetadata().build());
    assertNotNull(storageClass);
    assertEquals("testLabelValue", storageClass.getMetadata().getLabels().get("testLabel"));
  }

  @Test
  public void delete() {
    assertTrue(client.storage().storageClasses().withName("storageclass-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(StorageClassIT.class.getResourceAsStream("/storageclass-it.yml"));
  }

}
