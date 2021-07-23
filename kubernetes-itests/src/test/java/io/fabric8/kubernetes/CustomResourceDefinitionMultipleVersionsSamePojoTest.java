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
import io.fabric8.crd.bicycle.Bicycle;
import io.fabric8.crd.bicycle.BicycleList;
import io.fabric8.crd.bicycle.BicycleSpec;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class CustomResourceDefinitionMultipleVersionsSamePojoTest {
  private MixedOperation<Bicycle, BicycleList, Resource<Bicycle>> v1BicycleClient;
  private MixedOperation<Bicycle, BicycleList, Resource<Bicycle>> v1beta1BicycleClient;

  @ArquillianResource
  KubernetesClient client;

  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion = new AssumingK8sVersionAtLeast("1", "16");

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(CustomResourceDefinitionMultipleVersionsSamePojoTest.class.getResourceAsStream("/bicycle-crd.yml"));
  }

  @Before
  public void initBicycleClients() {
    v1BicycleClient = client.customResources(new CustomResourceDefinitionContext.Builder()
      .withGroup("demos.fabric8.io")
      .withPlural("bicycles")
      .withVersion("v1")
      .withScope("Cluster")
      .build(), Bicycle.class, BicycleList.class);
    v1beta1BicycleClient = client.customResources(new CustomResourceDefinitionContext.Builder()
      .withGroup("demos.fabric8.io")
      .withPlural("bicycles")
      .withVersion("v1beta1")
      .withScope("Cluster")
      .build(), Bicycle.class, BicycleList.class);
  }

  @Test
  public void v1CreateListDelete() {
    // Create
    String name = "santa-cruz-heckler-mx-carbon";
    Bicycle bicycle = createBicycle("v1", name, 60, 8, 20, "Heckler");
    Bicycle createdBicycle = v1BicycleClient.create(bicycle);
    assertThat(createdBicycle).isNotNull();

    // List
    BicycleList bicycleList = v1BicycleClient.list();
    assertThat(bicycleList).isNotNull();
    assertThat(bicycleList.getItems()).hasSizeGreaterThanOrEqualTo(1);

    // Delete
    Boolean isDeleted = v1BicycleClient.withName(name).delete();
    assertThat(isDeleted).isTrue();
  }

  @Test
  public void v1beta1CreateListDelete() {
    // Create
    String name = "pinarello-grevil-grx-gravel";
    Bicycle bicycle = createBicycle("v1beta1", name, 68, 4, 18, "GRX 1x 650b Gravel");
    Bicycle createdBicycle = v1beta1BicycleClient.create(bicycle);
    assertThat(createdBicycle).isNotNull();

    // List
    BicycleList bicycleList = v1beta1BicycleClient.list();
    assertThat(bicycleList).isNotNull();
    assertThat(bicycleList.getItems()).hasSizeGreaterThanOrEqualTo(1);

    // Delete
    Boolean isDeleted = v1beta1BicycleClient.withName(name).delete();
    assertThat(isDeleted).isTrue();
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(CustomResourceDefinitionMultipleVersionsSamePojoTest.class.getResourceAsStream("/bicycle-crd.yml"));
  }

  private Bicycle createBicycle(String version, String name, int cadence, int gear, int speed, String modelName) {
    Bicycle bicycle = new Bicycle();
    bicycle.setApiVersion(bicycle.getGroup() + "/" + version);
    bicycle.setMetadata(new ObjectMetaBuilder().withName(name).build());
    BicycleSpec bicycleSpec = new BicycleSpec();

    bicycleSpec.setCadence(cadence);
    bicycleSpec.setGear(gear);
    bicycleSpec.setSpeed(speed);
    bicycleSpec.setModelName(modelName);

    return bicycle;
  }
}
