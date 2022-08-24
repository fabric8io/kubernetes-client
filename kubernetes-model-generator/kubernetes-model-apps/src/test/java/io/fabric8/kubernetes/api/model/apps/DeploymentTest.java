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
package io.fabric8.kubernetes.api.model.apps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.HostAlias;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.util.Helper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeploymentTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void kubernetesDeploymentTest() throws Exception {
    // given
    final String originalJson = Helper.loadJson("/valid-deployment.json");

    // when
    final Deployment deployment = mapper.readValue(originalJson, Deployment.class);
    final String serializedJson = mapper.writeValueAsString(deployment);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(originalJson);
  }

  @Test
  void kubernetesDeploymentBuilderTest() {
    // Making a deployment using Builder classes.
    Deployment deployment = new DeploymentBuilder()
        .withNewMetadata()
        .addToAnnotations("fabric8.io/iconUrl", "img/icons/spring-boot.svg")
        .addToAnnotations("fabric8.io/metrics-path",
            "dashboard/file/kubernetes-pods.json/?var-project=fabric8-maven-sample-zero-config&var-version=3.5-SNAPSHOT")
        .addToAnnotations("fabric8.io/scm-url",
            "https://github.com/spring-projects/spring-boot/spring-boot-starter-parent/fabric8-maven-sample-zero-config")
        .addToLabels("app", "fabric8-maven-sample-zero-config")
        .addToLabels("provider", "fabric8")
        .addToLabels("version", "3.5-SNAPSHOT")
        .addToLabels("group", "io.fabric8")
        .withName("fabric8-maven-sample-zero-config")
        .withCreationTimestamp("2017-11-01 13:21:22 UTC")
        .withDeletionTimestamp("2017-11-02 13:21:22 UTC")
        .withNamespace("myproject")
        .withGenerateName("zero-config-test")
        .withOwnerReferences()
        .endMetadata()
        .withNewSpec()
        .withMinReadySeconds(5)
        .withPaused(false)
        .withReplicas(5)
        .withRevisionHistoryLimit(3)
        .withNewSelector()
        .addToMatchLabels("app", "fabric8-maven-sample-zero-config")
        .addToMatchLabels("provider", "fabric8")
        .addToMatchLabels("group", "io.fabric8")
        .endSelector()
        .withNewStrategy()
        .withType("Rolling")
        .withNewRollingUpdate()
        .withMaxSurge(new IntOrString(20))
        .withMaxUnavailable(new IntOrString(20))
        .endRollingUpdate()
        .endStrategy()
        .withNewTemplate()
        .withNewMetadata()
        .addToAnnotations("fabric8.io/metrics-path",
            "dashboard/file/kubernetes-pods.json/?var-project=fabric8-maven-sample-zero-config&var-version=3.5-SNAPSHOT")
        .addToAnnotations("fabric8.io/scm-url",
            "https://github.com/spring-projects/spring-boot/spring-boot-starter-parent/fabric8-maven-sample-zero-config")
        .addToAnnotations("fabric8.io/iconUrl", "img/icons/spring-boot.svg")
        .addToLabels("app", "fabric8-maven-sample-zero-config")
        .addToLabels("provider", "fabric8")
        .addToLabels("version", "3.5-SNAPSHOT")
        .addToLabels("group", "io.fabric8")
        .endMetadata()
        .withNewSpec()
        .withActiveDeadlineSeconds(10L)
        .addNewContainer()
        .addToCommand("printenv")
        .addToArgs("HOSTNAME", "KUBERNETES_PORT")
        .addNewEnv()
        .withName("KUBERNETES_NAMESPACE")
        .withNewValueFrom()
        .withNewFieldRef()
        .endFieldRef()
        .endValueFrom()
        .endEnv()

        // test env name pattern "[-._a-zA-Z][-._a-zA-Z0-9]*"
        .addNewEnv()
        .withName("KUBERNETES-NAME")
        .withNewValueFrom()
        .withNewFieldRef()
        .endFieldRef()
        .endValueFrom()
        .endEnv()
        .addNewEnv()
        .withName("KUBERNETES.CLUSTERNAME")
        .withNewValueFrom()
        .withNewFieldRef()
        .endFieldRef()
        .endValueFrom()
        .endEnv()

        .withImage("fabric8/fabric8-maven-sample-zero-config:snapshot-171129-120114-0102")
        .withImagePullPolicy("IfNotPresent")
        .withName("spring-boot")
        .addNewEnvFrom()
        .withNewSecretRef()
        .withName("my-app-secret")
        .endSecretRef()
        .endEnvFrom()
        .withNewLivenessProbe()
        .withNewHttpGet()
        .withPath("/healthz")
        .withPort(new IntOrString("8080"))
        .addNewHttpHeader("X-Custom-Header", "Awesome")
        .endHttpGet()
        .withInitialDelaySeconds(5)
        .withPeriodSeconds(5)
        .withTimeoutSeconds(5)
        .withFailureThreshold(5)
        .withSuccessThreshold(5)
        .endLivenessProbe()
        .withNewReadinessProbe()
        .withNewExec()
        .addToCommand("cat")
        .addToCommand("/temp/healthy")
        .endExec()
        .withInitialDelaySeconds(5)
        .withPeriodSeconds(5)
        .withTimeoutSeconds(5)
        .withFailureThreshold(5)
        .withSuccessThreshold(5)
        .endReadinessProbe()
        .addNewPort()
        .withContainerPort(8080)
        .withName("http")
        .withProtocol("TCP")
        .withHostIP("127.0.0.1")
        .withHostPort(50)
        .endPort()
        .addNewPort()
        .withContainerPort(9779)
        .withName("prometheus")
        .withProtocol("TCP")
        .endPort()
        .addNewPort()
        .withContainerPort(8778)
        .withName("jolokia")
        .withProtocol("TCP")
        .endPort()
        .withStdin(false)
        .withStdinOnce(false)
        .withNewResources()
        .addToRequests(Collections.singletonMap("memory", new Quantity("64Mi")))
        .addToRequests(Collections.singletonMap("cpu", new Quantity("250m")))
        .addToLimits(Collections.singletonMap("memory", new Quantity("128Mi")))
        .addToLimits(Collections.singletonMap("cpu", new Quantity("500m")))
        .endResources()
        .withTerminationMessagePath("/tmp/my-log")
        .withTerminationMessagePolicy("FallbackToLogsOnError")
        .withTty(false)
        .addToVolumeMounts(new VolumeMount("/cache", "", "cache-volume", true, null, null))
        .withWorkingDir("/workdir")
        .endContainer()
        .withDnsPolicy("ClusterFirst")
        .addToHostAliases(new HostAlias(Arrays.asList("foo.local", "bar.local"), "127.0.0.1"))
        .addToHostAliases(new HostAlias(Arrays.asList("foo.remote", "bar.remote"), "10.0.2.3"))
        .withHostIPC(false)
        .withHostNetwork(false)
        .withHostname("localhost")
        .withHostPID(false)
        .addToImagePullSecrets(new LocalObjectReference("regsecret"))
        .addToInitContainers(new io.fabric8.kubernetes.api.model.ContainerBuilder()
            .withName("init-mydb")
            .withImage("busybox")
            .addToCommand("sh")
            .addToCommand("-c")
            .addToCommand("until nslookup mydb; do echo waiting for mydb; sleep 2; done;")
            .build())
        .withNodeName("node1")
        .withNodeSelector(Collections.singletonMap("disktype", "ssd"))
        .withServiceAccount("robot")
        .withServiceAccountName("robot")
        .withSubdomain("test")
        .withRestartPolicy("Always")
        .withSchedulerName("default")
        .withTerminationGracePeriodSeconds(30L)
        .addToVolumes(new io.fabric8.kubernetes.api.model.VolumeBuilder()
            .withName("test-volume")
            .withNewAwsElasticBlockStore()
            .withVolumeID("<volume-id>")
            .withFsType("ext4")
            .endAwsElasticBlockStore()
            .build())
        .endSpec()
        .endTemplate()
        .endSpec()
        .build();

    // Assert that we serve as Expected
    assertEquals("fabric8-maven-sample-zero-config", deployment.getMetadata().getName());
    assertEquals("apps/v1", deployment.getApiVersion());

    // Assert Metadata
    assertArrayEquals(new Object[] { "fabric8.io/iconUrl", "fabric8.io/metrics-path", "fabric8.io/scm-url" },
        deployment.getMetadata().getAnnotations().keySet().toArray());
    assertArrayEquals(
        new Object[] { "img/icons/spring-boot.svg",
            "dashboard/file/kubernetes-pods.json/?var-project=fabric8-maven-sample-zero-config&var-version=3.5-SNAPSHOT",
            "https://github.com/spring-projects/spring-boot/spring-boot-starter-parent/fabric8-maven-sample-zero-config" },
        deployment.getMetadata().getAnnotations().values().toArray());
    assertArrayEquals(
        new Object[] { "app", "provider", "version", "group" }, deployment.getMetadata().getLabels().keySet().toArray());
    assertArrayEquals(
        new Object[] { "fabric8-maven-sample-zero-config", "fabric8", "3.5-SNAPSHOT", "io.fabric8", },
        deployment.getMetadata().getLabels().values().toArray());
    assertEquals("fabric8-maven-sample-zero-config", deployment.getMetadata().getName());
    assertEquals("myproject", deployment.getMetadata().getNamespace());
    assertEquals("zero-config-test", deployment.getMetadata().getGenerateName());
    assertTrue(deployment.getMetadata().getOwnerReferences().isEmpty());

    // Assert Spec
    assertEquals(5, deployment.getSpec().getMinReadySeconds().intValue());
    assertFalse(deployment.getSpec().getPaused());
    assertEquals(5, deployment.getSpec().getReplicas().intValue());
    assertEquals(3, deployment.getSpec().getRevisionHistoryLimit().intValue());
    assertArrayEquals(
        new Object[] { "app", "provider", "group" }, deployment.getSpec().getSelector().getMatchLabels().keySet().toArray());
    assertArrayEquals(
        new Object[] { "fabric8-maven-sample-zero-config", "fabric8", "io.fabric8" },
        deployment.getSpec().getSelector().getMatchLabels().values().toArray());
    assertEquals("Rolling", deployment.getSpec().getStrategy().getType());
    assertEquals(20, deployment.getSpec().getStrategy().getRollingUpdate().getMaxSurge().getIntVal().intValue());
    assertEquals(20, deployment.getSpec().getStrategy().getRollingUpdate().getMaxUnavailable().getIntVal().intValue());

    // Assert Spec's template
    assertArrayEquals(
        new Object[] { "fabric8.io/metrics-path", "fabric8.io/scm-url", "fabric8.io/iconUrl" },
        deployment.getSpec().getTemplate().getMetadata().getAnnotations().keySet().toArray());
    assertArrayEquals(
        new Object[] {
            "dashboard/file/kubernetes-pods.json/?var-project=fabric8-maven-sample-zero-config&var-version=3.5-SNAPSHOT",
            "https://github.com/spring-projects/spring-boot/spring-boot-starter-parent/fabric8-maven-sample-zero-config",
            "img/icons/spring-boot.svg"
        }, deployment.getSpec().getTemplate().getMetadata().getAnnotations().values().toArray());
    assertArrayEquals(
        new Object[] { "app", "provider", "version", "group" },
        deployment.getSpec().getTemplate().getMetadata().getLabels().keySet().toArray());
    assertArrayEquals(
        new Object[] { "fabric8-maven-sample-zero-config", "fabric8", "3.5-SNAPSHOT", "io.fabric8" },
        deployment.getSpec().getTemplate().getMetadata().getLabels().values().toArray());
    assertEquals(10, deployment.getSpec().getTemplate().getSpec().getActiveDeadlineSeconds().intValue());

    // Assert Spec's template's container
    assertEquals(1, deployment.getSpec().getTemplate().getSpec().getContainers().size());
    assertArrayEquals(new Object[] { "printenv" },
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getCommand().toArray());
    assertArrayEquals(new Object[] { "HOSTNAME", "KUBERNETES_PORT" },
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getArgs().toArray());
    assertEquals(3, deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getEnv().size());
    assertEquals("KUBERNETES_NAMESPACE",
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getEnv().get(0).getName());
    assertEquals("KUBERNETES-NAME",
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getEnv().get(1).getName());
    assertEquals("KUBERNETES.CLUSTERNAME",
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getEnv().get(2).getName());
    assertEquals("fabric8/fabric8-maven-sample-zero-config:snapshot-171129-120114-0102",
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
    assertEquals("IfNotPresent", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getImagePullPolicy());
    assertEquals("spring-boot", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getName());
    assertEquals(1, deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getEnvFrom().size());
    assertEquals("my-app-secret",
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getEnvFrom().get(0).getSecretRef().getName());
    assertEquals("/healthz",
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getLivenessProbe().getHttpGet().getPath());
    assertEquals("8080", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getLivenessProbe().getHttpGet()
        .getPort().getStrVal());
    assertEquals("X-Custom-Header", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getLivenessProbe()
        .getHttpGet().getHttpHeaders().get(0).getName());
    assertEquals("Awesome", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getLivenessProbe().getHttpGet()
        .getHttpHeaders().get(0).getValue());
    assertEquals(5, deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getLivenessProbe()
        .getInitialDelaySeconds().intValue());
    assertEquals(5,
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getLivenessProbe().getPeriodSeconds().intValue());
    assertEquals(5, deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getLivenessProbe().getFailureThreshold()
        .intValue());
    assertEquals(5, deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getLivenessProbe().getSuccessThreshold()
        .intValue());
    assertEquals(3, deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().size());
    assertEquals(8080,
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().get(0).getContainerPort().intValue());
    assertEquals("http", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().get(0).getName());
    assertEquals("TCP", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().get(0).getProtocol());
    assertEquals("127.0.0.1",
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().get(0).getHostIP());
    assertEquals(50,
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().get(0).getHostPort().intValue());
    assertEquals(9779,
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().get(1).getContainerPort().intValue());
    assertEquals("prometheus", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().get(1).getName());
    assertEquals("TCP", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().get(1).getProtocol());
    assertEquals(8778,
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().get(2).getContainerPort().intValue());
    assertEquals("jolokia", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().get(2).getName());
    assertEquals("TCP", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getPorts().get(2).getProtocol());
    assertFalse(deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getStdin());
    assertFalse(deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getStdinOnce());
    assertArrayEquals(new Object[] { "memory", "cpu" },
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getResources().getRequests().keySet().toArray());
    assertArrayEquals(new Object[] { "memory", "cpu" },
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getResources().getLimits().keySet().toArray());
    assertEquals("/tmp/my-log",
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getTerminationMessagePath());
    assertEquals("FallbackToLogsOnError",
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getTerminationMessagePolicy());
    assertFalse(deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getTty());
    assertEquals(1, deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getVolumeMounts().size());
    assertEquals("/cache",
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getVolumeMounts().get(0).getMountPath());
    assertEquals("cache-volume",
        deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getVolumeMounts().get(0).getName());
    assertEquals("/workdir", deployment.getSpec().getTemplate().getSpec().getContainers().get(0).getWorkingDir());

    assertEquals("ClusterFirst", deployment.getSpec().getTemplate().getSpec().getDnsPolicy());
    assertEquals(2, deployment.getSpec().getTemplate().getSpec().getHostAliases().size());
    assertEquals("127.0.0.1", deployment.getSpec().getTemplate().getSpec().getHostAliases().get(0).getIp());
    assertArrayEquals(new Object[] { "foo.local", "bar.local" },
        deployment.getSpec().getTemplate().getSpec().getHostAliases().get(0).getHostnames().toArray());
    assertEquals("10.0.2.3", deployment.getSpec().getTemplate().getSpec().getHostAliases().get(1).getIp());
    assertArrayEquals(new Object[] { "foo.remote", "bar.remote" },
        deployment.getSpec().getTemplate().getSpec().getHostAliases().get(1).getHostnames().toArray());
    assertFalse(deployment.getSpec().getTemplate().getSpec().getHostIPC());
    assertFalse(deployment.getSpec().getTemplate().getSpec().getHostNetwork());
    assertFalse(deployment.getSpec().getTemplate().getSpec().getHostPID());
    assertEquals("localhost", deployment.getSpec().getTemplate().getSpec().getHostname());
    assertEquals(1, deployment.getSpec().getTemplate().getSpec().getImagePullSecrets().size());
    assertEquals("regsecret", deployment.getSpec().getTemplate().getSpec().getImagePullSecrets().get(0).getName());
    assertEquals(1, deployment.getSpec().getTemplate().getSpec().getInitContainers().size());
    assertEquals("init-mydb", deployment.getSpec().getTemplate().getSpec().getInitContainers().get(0).getName());
    assertEquals("busybox", deployment.getSpec().getTemplate().getSpec().getInitContainers().get(0).getImage());
    assertArrayEquals(new Object[] { "sh", "-c", "until nslookup mydb; do echo waiting for mydb; sleep 2; done;" },
        deployment.getSpec().getTemplate().getSpec().getInitContainers().get(0).getCommand().toArray());
    assertEquals("node1", deployment.getSpec().getTemplate().getSpec().getNodeName());
    assertEquals("ssd", deployment.getSpec().getTemplate().getSpec().getNodeSelector().get("disktype"));
    assertEquals("robot", deployment.getSpec().getTemplate().getSpec().getServiceAccount());
    assertEquals("robot", deployment.getSpec().getTemplate().getSpec().getServiceAccountName());
    assertEquals("test", deployment.getSpec().getTemplate().getSpec().getSubdomain());
    assertEquals("Always", deployment.getSpec().getTemplate().getSpec().getRestartPolicy());
    assertEquals("default", deployment.getSpec().getTemplate().getSpec().getSchedulerName());
    assertEquals(30, deployment.getSpec().getTemplate().getSpec().getTerminationGracePeriodSeconds().intValue());
    assertEquals(1, deployment.getSpec().getTemplate().getSpec().getVolumes().size());
    assertEquals("test-volume", deployment.getSpec().getTemplate().getSpec().getVolumes().get(0).getName());
    assertEquals("<volume-id>",
        deployment.getSpec().getTemplate().getSpec().getVolumes().get(0).getAwsElasticBlockStore().getVolumeID());
    assertEquals("ext4",
        deployment.getSpec().getTemplate().getSpec().getVolumes().get(0).getAwsElasticBlockStore().getFsType());
  }
}
