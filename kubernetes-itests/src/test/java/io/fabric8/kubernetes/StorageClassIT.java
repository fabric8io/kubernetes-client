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

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassBuilder;
import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.client.KubernetesClient;
import static junit.framework.TestCase.assertNotNull;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class StorageClassIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private StorageClass storageClass;

  private String name = UUID.randomUUID().toString();


  @Before
  public void init() {
    ObjectMeta metadata = new ObjectMeta();
    metadata.setName(name);

    Map<String, String> parameters = new HashMap<>();
    parameters.put("key", "value1");

    storageClass = new StorageClassBuilder().withApiVersion("storage.k8s.io/v1")
      .withKind("StorageClass")
      .withMetadata(metadata)
      .withParameters(parameters)
      .withProvisioner("k8s.io/minikube-hostpath")
      .build();

    client.storage().storageClasses().createOrReplace(storageClass);
  }

  @Test
  public void load() {
    StorageClass storageClassLoaded = client.storage().storageClasses().load(getClass().getResourceAsStream("/test-storageclass.yml")).get();
    assertNotNull(storageClassLoaded);
    assertEquals("gluster-vol-default", storageClassLoaded.getMetadata().getName());
  }

  @Test
  public void get() {
    storageClass = client.storage().storageClasses().withName(name).get();
    assertNotNull(storageClass);
  }

  @Test
  public void list() {
    StorageClassList storageClassList = client.storage().storageClasses().list();
    assertNotNull(storageClassList);
    assertTrue(storageClassList.getItems().size() > 1);
  }

  @Test
  public void update() {
    storageClass = client.storage().storageClasses().withName(name).edit().editMetadata().addToLabels("testLabel", "testLabelValue").endMetadata().done();
    assertNotNull(storageClass);
    assertEquals("testLabelValue", storageClass.getMetadata().getLabels().get("testLabel"));
  }

  @Test
  public void delete() {
    assertTrue(client.storage().storageClasses().delete(storageClass));
  }

}
