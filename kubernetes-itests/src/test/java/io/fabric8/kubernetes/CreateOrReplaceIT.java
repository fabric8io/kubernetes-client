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

import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServicePort;
import io.fabric8.kubernetes.api.model.ServiceSpec;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.Ingress;
import io.fabric8.kubernetes.api.model.networking.v1.IngressBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ListVisitFromServerGetDeleteRecreateWaitApplicable;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.MapEntry.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 16)
class CreateOrReplaceIT {

  static KubernetesClient client;

  private static Map<String, String> labels;

  @BeforeAll
  static void setUp() {
    labels = new HashMap<>();
    labels.put("app", "fabric8-e2e-test");
    labels.put("suite", "create-or-replace");
  }

  @AfterAll
  static void cleanup() {
    client.network().v1().ingresses().withLabels(labels).withGracePeriod(0L).delete();
    client.secrets().withLabels(labels).withGracePeriod(0L).delete();
    client.apps().deployments().withLabels(labels).withGracePeriod(0L).delete();
    client.services().withLabels(labels).withGracePeriod(0L).delete();
    client.configMaps().withLabels(labels).withGracePeriod(0L).delete();
  }

  @Test
  void testCreateOrReplaceConfigMap() {
    final String name = "create-or-replace-configmap";
    ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata().withLabels(labels).withName(name).endMetadata()
        .addToData("first", "1st")
        .build();

    // 1st createOrReplace(); should create the resource
    configMap = client.configMaps().createOrReplace(configMap);
    assertNotNull(configMap);
    assertEquals(name, configMap.getMetadata().getName());
    assertEquals("1st", configMap.getData().get("first"));

    // Modify resource
    Map<String, String> data = configMap.getData();
    data.put("second", "2nd");
    data.put("third", "3rd");
    configMap.setData(data);

    // 2nd createOrReplace(); should update the resource
    configMap = client.configMaps().createOrReplace(configMap);
    assertNotNull(configMap);
    assertEquals("2nd", configMap.getData().get("second"));
    assertEquals("3rd", configMap.getData().get("third"));
  }

  @Test
  void testCreateOrReplaceService() {
    final String name = "create-or-replace-service";
    Service service = new ServiceBuilder()
        .withNewMetadata().withName(name).withLabels(labels).endMetadata()
        .withNewSpec()
        .addToSelector("app", "testapp")
        .addNewPort()
        .withProtocol("TCP")
        .withPort(80)
        .withTargetPort(new IntOrString(9376))
        .endPort()
        .endSpec()
        .build();

    // 1st createOrReplace(); should create the resource
    service = client.services().createOrReplace(service);
    assertNotNull(service);
    assertEquals(name, service.getMetadata().getName());
    assertEquals(1, service.getSpec().getPorts().size());
    assertEquals(9376, service.getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());

    // Modify resource
    ServiceSpec serviceSpec = service.getSpec();
    // https://github.com/fabric8io/kubernetes-client/issues/2399
    service.getSpec().setClusterIP(null);
    service.getSpec().setClusterIPs(Collections.emptyList());
    List<ServicePort> ports = serviceSpec.getPorts();
    ports.get(0).setTargetPort(new IntOrString(9090));

    // 2nd createOrReplace(); should update the resource
    service = client.services().createOrReplace(service);
    assertNotNull(service);
    assertEquals(9090, service.getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
  }

  @Test
  void testCreateOrReplaceDeployment() {
    final String name = "create-or-replace-deployment";
    Deployment deployment = new DeploymentBuilder()
        .withNewMetadata()
        .withName(name)
        .withLabels(labels)
        .addToLabels("final-app", "busybox")
        .endMetadata()
        .withNewSpec()
        .withReplicas(1)
        .withNewSelector()
        .addToMatchLabels("final-app", "busybox")
        .endSelector()
        .withNewTemplate()
        .withNewMetadata().addToLabels("final-app", "busybox").endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withName("busybox")
        .withImage("busybox")
        .withCommand("sleep", "10")
        .withImagePullPolicy("IfNotPresent")
        .endContainer()
        .withRestartPolicy("Always")
        .endSpec()
        .endTemplate()
        .endSpec()
        .build();

    // 1st createOrReplace(); should create the resource
    deployment = client.apps().deployments().createOrReplace(deployment);
    assertNotNull(deployment);
    assertEquals(name, deployment.getMetadata().getName());
    assertEquals(1, deployment.getSpec().getTemplate().getSpec().getContainers().size());
    assertEquals("busybox", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());

    // Modify resource
    deployment.getSpec().getTemplate().getSpec().getContainers().get(0).setImage("scratch");

    // 2nd createOrReplace(); should update the resource
    deployment = client.apps().deployments().createOrReplace(deployment);
    assertNotNull(deployment);
    assertEquals("scratch", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
  }

  @Test
  void testCreateOrReplaceSecret() {
    final String name = "create-or-replace-secret";
    Secret secret = new SecretBuilder()
        .withNewMetadata().withName(name).withLabels(labels).endMetadata()
        .addToData("username", "ferferfe")
        .addToData("password", "MWYyZDFlMmU2N2Rm")
        .build();

    // 1st createOrReplace(); should create the resource
    secret = client.secrets().createOrReplace(secret);
    assertNotNull(secret);
    assertThat(secret)
        .hasFieldOrPropertyWithValue("metadata.name", name)
        .hasFieldOrPropertyWithValue("data.username", "ferferfe")
        .hasFieldOrPropertyWithValue("data.password", "MWYyZDFlMmU2N2Rm")
        .extracting("metadata.creationTimestamp").asString().isNotBlank();

    // Modify resource
    Map<String, String> data = secret.getData();
    data.put("apitoken", "c29tZXRva2Vu");

    // 2nd createOrReplace; should update the resource
    secret = client.secrets().createOrReplace(secret);
    assertNotNull(secret);
    assertEquals("c29tZXRva2Vu", secret.getData().get("apitoken"));
  }

  @Test
  void testCreateOrReplaceIngress() {
    final String name = "create-or-replace-ingress";
    Ingress ingress = new IngressBuilder()
        .withNewMetadata()
        .withName(name)
        .withLabels(labels)
        .endMetadata()
        .withNewSpec()
        .addNewRule()
        .withNewHttp()
        .addNewPath()
        .withPath("/testPath")
        .withPathType("Prefix")
        .withNewBackend()
        .withNewService()
        .withName("test")
        .withNewPort().withNumber(80).endPort()
        .endService()
        .endBackend()
        .endPath()
        .endHttp()
        .endRule()
        .endSpec()
        .build();

    // 1st createOrReplace(); should create the resource
    ingress = client.network().v1().ingresses().createOrReplace(ingress);
    assertNotNull(ingress);
    assertEquals(name, ingress.getMetadata().getName());
    assertEquals(1, ingress.getSpec().getRules().size());

    // Modify resource
    ingress.getMetadata().setAnnotations(Collections.singletonMap("nginx.ingress.kubernetes.io/rewrite-target", "/"));

    // 2nd createOrReplace; should update the resource
    ingress = client.network().v1().ingresses().createOrReplace(ingress);
    assertNotNull(ingress);
    assertEquals("/", ingress.getMetadata().getAnnotations().get("nginx.ingress.kubernetes.io/rewrite-target"));
  }

  @Test
  void testCreateOrReplaceGenericResource() {
    // Given
    final String name = "create-or-replace-generic-resource";
    ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata().withName(name).withLabels(labels).endMetadata()
        .addToData("a1", "A1")
        .addToData("a2", "A2")
        .build();
    // When
    final ConfigMap createdResource = client.resource(configMap).createOrReplace();
    configMap.setData(Collections.singletonMap("b1", "B1"));
    final HasMetadata resource = client.resource(configMap).createOrReplace();
    // Then
    assertThat(createdResource)
        .hasFieldOrPropertyWithValue("metadata.name", name)
        .isNotEqualTo(resource)
        .extracting("data").asInstanceOf(InstanceOfAssertFactories.MAP)
        .containsOnly(entry("a1", "A1"), entry("a2", "A2"));

    assertThat(resource)
        .hasFieldOrPropertyWithValue("metadata.name", name)
        .extracting("data").asInstanceOf(InstanceOfAssertFactories.MAP)
        .hasSize(1)
        .containsEntry("b1", "B1");
  }

  @Test
  void testCreateOrReplaceGenericResourceList() {
    // Given
    InputStream resourceListV1 = getClass().getResourceAsStream("/createorreplace-it-testlist-v1.yml");
    InputStream resourceListV2 = getClass().getResourceAsStream("/createorreplace-it-testlist-v2.yml");

    // When
    List<HasMetadata> listCreated = client.load(resourceListV1).createOrReplace();
    final List<HasMetadata> resourceList = client.load(resourceListV2).createOrReplace();

    // Then
    assertNotNull(listCreated);
    assertEquals(2, listCreated.size());
    Optional<HasMetadata> serviceResult = listCreated.stream().filter(p -> p instanceof Service).findFirst();
    assertTrue(serviceResult.isPresent());
    Service service = (Service) serviceResult.get();
    assertEquals(9376, service.getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());

    assertNotNull(resourceList);
    assertEquals(2, resourceList.size());
    Optional<HasMetadata> serviceV2Result = resourceList.stream().filter(p -> p instanceof Service).findFirst();
    assertTrue(serviceV2Result.isPresent());
    Service serviceV2 = (Service) serviceV2Result.get();
    assertEquals(9090, serviceV2.getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
  }

  @Test
  void testCreateOrReplaceDeletingExisting() {
    // Given
    List<HasMetadata> listToCreate = new ArrayList<>();
    listToCreate.add(new ConfigMapBuilder()
        .withNewMetadata().withName("create-or-replace-it-delete-existing-configmap").withLabels(labels).endMetadata()
        .addToData("A", "a")
        .addToData("B", "b")
        .build());
    listToCreate.add(new SecretBuilder()
        .withNewMetadata().withName("create-or-replace-it-delete-existing-secret").withLabels(labels).endMetadata()
        .addToData("USERNAME", "YWRtaW4=")
        .addToData("PASSWORD", "MWYyZDFlMmU2N2Rm")
        .build());

    // When
    ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> op = client
        .resourceList(listToCreate);
    List<HasMetadata> listCreated = op.createOrReplace();
    op.delete();
    op.waitUntilCondition(Objects::isNull, 30, TimeUnit.SECONDS);
    final List<HasMetadata> resourceList = op.createOrReplace();

    // Then
    assertNotNull(listCreated);
    assertEquals(2, listCreated.size());
    listCreated.sort(Comparator.comparing(HasMetadata::getKind));

    assertNotNull(resourceList);
    assertEquals(2, resourceList.size());
    resourceList.sort(Comparator.comparing(HasMetadata::getKind));
    assertEquals(listCreated.get(0).getMetadata().getName(), resourceList.get(0).getMetadata().getName());
    assertNotEquals(listCreated.get(0).getMetadata().getUid(), resourceList.get(0).getMetadata().getUid());
    assertEquals(listCreated.get(1).getMetadata().getName(), resourceList.get(1).getMetadata().getName());
    assertNotEquals(listCreated.get(1).getMetadata().getUid(), resourceList.get(1).getMetadata().getUid());
  }

}
