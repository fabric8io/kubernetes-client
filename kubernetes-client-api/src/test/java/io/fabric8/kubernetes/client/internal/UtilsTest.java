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
package io.fabric8.kubernetes.client.internal;

import io.fabric8.kubernetes.api.model.Binding;
import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.LimitRange;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodTemplate;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apps.ControllerRevision;
import io.fabric8.kubernetes.api.model.apps.DaemonSet;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.authentication.TokenReview;
import io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReview;
import io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJob;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.api.model.discovery.v1beta1.EndpointSlice;
import io.fabric8.kubernetes.api.model.extensions.Ingress;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicy;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.Role;
import io.fabric8.kubernetes.api.model.rbac.RoleBinding;
import io.fabric8.kubernetes.api.model.scheduling.v1beta1.PriorityClass;
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachment;
import io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriver;
import io.fabric8.kubernetes.api.model.storage.v1beta1.CSINode;
import io.fabric8.kubernetes.client.lib.FileSystem;
import io.fabric8.kubernetes.client.utils.CommonThreadPool;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilsTest {

  @Test
  void existingSysPropShouldReturnValue() {
    System.setProperty("something", "value");
    assertEquals("value", Utils.getSystemPropertyOrEnvVar("something"));
    System.getProperties().remove("something");
  }

  @Test
  void missingSysPropAndEnvVarShouldReturnNull() {
    assertNull(Utils.getSystemPropertyOrEnvVar("doesn't exist"));
  }

  @Test
  void existingEnvVarShouldReturnValue() {
    assertEquals("value", Utils.getSystemPropertyOrEnvVar("ENV_VAR_EXISTS"));
  }

  @Test
  void existingEnvVarShouldReturnValueFromConvertedSysPropName() {
    assertEquals("value", Utils.getSystemPropertyOrEnvVar("env.var.exists"));
  }

  @Test
  void existingEnvVarShouldReturnBooleanValueFromConvertedSysPropName() {
    Assertions.assertTrue(Utils.getSystemPropertyOrEnvVar("env.var.exists.boolean", false));
  }

  @Test
  void missingEnvVarShouldReturnDefaultValue() {
    Assertions.assertTrue(Utils.getSystemPropertyOrEnvVar("DONT_EXIST", true));
  }

  @Test
  @DisplayName("interpolateString, String with no placeholders and empty parameters, should return input")
  void interpolateStringTest() {
    // Given
    final String input = "I don't have placeholders";
    // When
    final String result = Utils.interpolateString(input, Collections.emptyMap());
    // Then
    assertEquals("I don't have placeholders", result);
  }

  @Test
  @DisplayName("interpolateString, String with no placeholders and null parameters, should return input")
  void interpolateStringNullParametersTest() {
    // Given
    final String input = "I don't have placeholders";
    // When
    final String result = Utils.interpolateString(input, null);
    // Then
    assertEquals("I don't have placeholders", result);
  }

  @Test
  @DisplayName("interpolateString, String with no placeholders and null parameter values, should return input")
  void interpolateStringNullParameterValuesTest() {
    // Given
    final String input = "I don't have placeholders";
    // When
    final String result = Utils.interpolateString(input, Collections.singletonMap("KEY", null));
    // Then
    assertEquals("I don't have placeholders", result);
  }

  @Test
  @DisplayName("interpolateString, String with mixed placeholders and parameters, should return interpolated input")
  void interpolateStringWithParametersTest() {
    // Given
    final String input = "This is a \"${SINGLE_CURLY_BRACE}\" and the following is code ${NOT_REPLACED}: \"${{RENDER_UNQUOTED}}\" ${{ALREADY_UNQUOTED}}";
    final Map<String, String> parameters = new HashMap<>();
    parameters.put("SINGLE_CURLY_BRACE", "template string");
    parameters.put("RENDER_UNQUOTED", "'1' === '1';");
    parameters.put("ALREADY_UNQUOTED", "/* END */");
    parameters.put("NOT_THERE", "/* END */");
    parameters.put(null, "NULL key is ignored");
    parameters.put("NULL_VALUE", null);
    // When
    final String result = Utils.interpolateString(input, parameters);
    // Then
    assertEquals("This is a \"template string\" and the following is code ${NOT_REPLACED}: '1' === '1'; /* END */", result);
  }

  @Test
  void testGetPluralFromKind() {
    // Given
    SortedMap<String, Class> pluralToKubernetesResourceMap = new TreeMap<>();
    pluralToKubernetesResourceMap.put("bindings", Binding.class);
    pluralToKubernetesResourceMap.put("componentstatuses", ComponentStatus.class);
    pluralToKubernetesResourceMap.put("configmaps", ConfigMap.class);
    pluralToKubernetesResourceMap.put("endpoints", Endpoints.class);
    pluralToKubernetesResourceMap.put("events", Event.class);
    pluralToKubernetesResourceMap.put("limitranges", LimitRange.class);
    pluralToKubernetesResourceMap.put("namespaces", Namespace.class);
    pluralToKubernetesResourceMap.put("nodes", Node.class);
    pluralToKubernetesResourceMap.put("persistentvolumeclaims", PersistentVolumeClaim.class);
    pluralToKubernetesResourceMap.put("persistentvolumes", PersistentVolume.class);
    pluralToKubernetesResourceMap.put("pods", Pod.class);
    pluralToKubernetesResourceMap.put("podtemplates", PodTemplate.class);
    pluralToKubernetesResourceMap.put("replicationcontrollers", ReplicationController.class);
    pluralToKubernetesResourceMap.put("resourcequotas", ResourceQuota.class);
    pluralToKubernetesResourceMap.put("secrets", Secret.class);
    pluralToKubernetesResourceMap.put("serviceaccounts", ServiceAccount.class);
    pluralToKubernetesResourceMap.put("services", Service.class);
    pluralToKubernetesResourceMap.put("mutatingwebhookconfigurations", MutatingWebhookConfiguration.class);
    pluralToKubernetesResourceMap.put("validatingwebhookconfigurations", ValidatingWebhookConfiguration.class);
    pluralToKubernetesResourceMap.put("customresourcedefinitions", CustomResourceDefinition.class);
    pluralToKubernetesResourceMap.put("controllerrevisions", ControllerRevision.class);
    pluralToKubernetesResourceMap.put("daemonsets", DaemonSet.class);
    pluralToKubernetesResourceMap.put("deployments", Deployment.class);
    pluralToKubernetesResourceMap.put("replicasets", ReplicaSet.class);
    pluralToKubernetesResourceMap.put("statefulsets", StatefulSet.class);
    pluralToKubernetesResourceMap.put("tokenreviews", TokenReview.class);
    pluralToKubernetesResourceMap.put("localsubjectaccessreviews", LocalSubjectAccessReview.class);
    pluralToKubernetesResourceMap.put("selfsubjectaccessreviews", SelfSubjectAccessReview.class);
    pluralToKubernetesResourceMap.put("selfsubjectrulesreviews", SelfSubjectRulesReview.class);
    pluralToKubernetesResourceMap.put("subjectaccessreviews", SubjectAccessReview.class);
    pluralToKubernetesResourceMap.put("horizontalpodautoscalers", HorizontalPodAutoscaler.class);
    pluralToKubernetesResourceMap.put("cronjobs", CronJob.class);
    pluralToKubernetesResourceMap.put("jobs", Job.class);
    pluralToKubernetesResourceMap.put("certificatesigningrequests", CertificateSigningRequest.class);
    pluralToKubernetesResourceMap.put("leases", Lease.class);
    pluralToKubernetesResourceMap.put("endpointslices", EndpointSlice.class);
    pluralToKubernetesResourceMap.put("ingresses", Ingress.class);
    pluralToKubernetesResourceMap.put("networkpolicies", NetworkPolicy.class);
    pluralToKubernetesResourceMap.put("poddisruptionbudgets", PodDisruptionBudget.class);
    pluralToKubernetesResourceMap.put("podsecuritypolicies", PodSecurityPolicy.class);
    pluralToKubernetesResourceMap.put("clusterrolebindings", ClusterRoleBinding.class);
    pluralToKubernetesResourceMap.put("clusterroles", ClusterRole.class);
    pluralToKubernetesResourceMap.put("rolebindings", RoleBinding.class);
    pluralToKubernetesResourceMap.put("roles", Role.class);
    pluralToKubernetesResourceMap.put("priorityclasses", PriorityClass.class);
    pluralToKubernetesResourceMap.put("csidrivers", CSIDriver.class);
    pluralToKubernetesResourceMap.put("csinodes", CSINode.class);
    pluralToKubernetesResourceMap.put("storageclasses", StorageClass.class);
    pluralToKubernetesResourceMap.put("volumeattachments", VolumeAttachment.class);

    // When & Then
    pluralToKubernetesResourceMap.forEach(
        (plural, kubernetesResource) -> assertEquals(plural, Utils.getPluralFromKind(kubernetesResource.getSimpleName())));
  }

  @Test
  @DisplayName("Should test whether resource is namespaced or not")
  void testWhetherNamespacedOrNot() {
    assertTrue(Utils.isResourceNamespaced(Binding.class));
    assertFalse(Utils.isResourceNamespaced(ComponentStatus.class));
    assertTrue(Utils.isResourceNamespaced(ConfigMap.class));
    assertTrue(Utils.isResourceNamespaced(Endpoints.class));
    assertTrue(Utils.isResourceNamespaced(Event.class));
    assertTrue(Utils.isResourceNamespaced(LimitRange.class));
    assertFalse(Utils.isResourceNamespaced(Namespace.class));
    assertFalse(Utils.isResourceNamespaced(Node.class));
    assertTrue(Utils.isResourceNamespaced(PersistentVolumeClaim.class));
    assertFalse(Utils.isResourceNamespaced(PersistentVolume.class));
    assertTrue(Utils.isResourceNamespaced(Pod.class));
    assertTrue(Utils.isResourceNamespaced(PodTemplate.class));
    assertTrue(Utils.isResourceNamespaced(ReplicationController.class));
    assertTrue(Utils.isResourceNamespaced(ResourceQuota.class));
    assertTrue(Utils.isResourceNamespaced(Secret.class));
    assertTrue(Utils.isResourceNamespaced(ServiceAccount.class));
    assertTrue(Utils.isResourceNamespaced(Service.class));
    assertFalse(Utils.isResourceNamespaced(MutatingWebhookConfiguration.class));
    assertFalse(Utils.isResourceNamespaced(ValidatingWebhookConfiguration.class));
    assertFalse(Utils.isResourceNamespaced(CustomResourceDefinition.class));
    assertTrue(Utils.isResourceNamespaced(ControllerRevision.class));
    assertTrue(Utils.isResourceNamespaced(DaemonSet.class));
    assertTrue(Utils.isResourceNamespaced(Deployment.class));
    assertTrue(Utils.isResourceNamespaced(ReplicaSet.class));
    assertTrue(Utils.isResourceNamespaced(StatefulSet.class));
    assertFalse(Utils.isResourceNamespaced(TokenReview.class));
    assertTrue(Utils.isResourceNamespaced(LocalSubjectAccessReview.class));
    assertFalse(Utils.isResourceNamespaced(SelfSubjectAccessReview.class));
    assertFalse(Utils.isResourceNamespaced(SelfSubjectRulesReview.class));
    assertFalse(Utils.isResourceNamespaced(SubjectAccessReview.class));
    assertTrue(Utils.isResourceNamespaced(HorizontalPodAutoscaler.class));
    assertTrue(Utils.isResourceNamespaced(CronJob.class));
    assertTrue(Utils.isResourceNamespaced(Job.class));
    assertFalse(Utils.isResourceNamespaced(CertificateSigningRequest.class));
    assertTrue(Utils.isResourceNamespaced(Lease.class));
    assertTrue(Utils.isResourceNamespaced(EndpointSlice.class));
    assertTrue(Utils.isResourceNamespaced(Ingress.class));
    assertTrue(Utils.isResourceNamespaced(NetworkPolicy.class));
    assertTrue(Utils.isResourceNamespaced(PodDisruptionBudget.class));
    assertFalse(Utils.isResourceNamespaced(PodSecurityPolicy.class));
    assertFalse(Utils.isResourceNamespaced(ClusterRoleBinding.class));
    assertFalse(Utils.isResourceNamespaced(ClusterRole.class));
    assertTrue(Utils.isResourceNamespaced(RoleBinding.class));
    assertTrue(Utils.isResourceNamespaced(Role.class));
    assertFalse(Utils.isResourceNamespaced(PriorityClass.class));
    assertFalse(Utils.isResourceNamespaced(CSIDriver.class));
    assertFalse(Utils.isResourceNamespaced(CSINode.class));
    assertFalse(Utils.isResourceNamespaced(StorageClass.class));
    assertFalse(Utils.isResourceNamespaced(VolumeAttachment.class));
  }

  @Test
  @DisplayName("isNotNullOrEmpty, null, should return false")
  void isNotNullOrEmpty() {
    // When
    final boolean result1 = Utils.isNotNullOrEmpty((Map) null);
    final boolean result2 = Utils.isNotNullOrEmpty((String) null);
    final boolean result3 = Utils.isNotNullOrEmpty("");

    // Then
    assertFalse(result1);
    assertFalse(result2);
    assertFalse(result3);
  }

  @Test
  @DisplayName("isNotNull, null, should return false")
  void isNotNull() {
    // Given
    String[] emptyArray = new String[] {};

    // When
    final boolean result = Utils.isNotNull(emptyArray);

    // Then
    assertTrue(result);
  }

  @Test
  @DisplayName("isNotNullOrEmpty, some null values, should return true")
  void isNotNullOrEmptySomeAreNullTest() {
    // Given
    String[] testSample = new String[] { "notNullObj", null, null };

    // When
    final boolean result = Utils.isNotNullOrEmpty(testSample);

    // Then
    assertTrue(result);
  }

  @Test
  @DisplayName("isNotNull, some null values, should return true")
  void isNotNullSomeAreNullTest() {
    // Given
    String[] testSample = new String[] { "notNullObj", null, null };

    // When
    final boolean result = Utils.isNotNull(testSample);

    // Then
    assertFalse(result);
  }

  @Test
  @DisplayName("isNotNull, no null values, should return true")
  void isNotNullNoneAreNullTest() {
    String[] testSample = new String[] { "Not null", "Not null either" };

    // When
    final boolean result = Utils.isNotNull(testSample);

    // Then
    assertTrue(result);
  }

  @Test
  @DisplayName("test getting system path")
  void testGetSystemPathVariable() {
    // When
    String pathVariable = Utils.getSystemPathVariable();

    // Then
    assertNotNull(pathVariable);
    assertTrue(pathVariable.contains(File.pathSeparator));
  }

  @Test
  @DisplayName("Should get command prefix")
  void testGetCommandPlatformPrefix() {
    List<String> commandPrefix = Utils.getCommandPlatformPrefix();

    assertNotNull(commandPrefix);
    assertEquals(2, commandPrefix.size());
    switch (FileSystem.getCurrent()) {
      case WINDOWS:
        assertEquals("cmd.exe", commandPrefix.get(0));
        assertEquals("/c", commandPrefix.get(1));
        break;
      default:
        assertEquals("sh", commandPrefix.get(0));
        assertEquals("-c", commandPrefix.get(1));
    }
  }

  @Test
  void testDaemonThreadFactory() {
    ThreadFactory tf = Utils.daemonThreadFactory(this);
    Thread t = tf.newThread(() -> {
    });
    assertTrue(t.isDaemon());
    assertTrue(t.getName().startsWith(UtilsTest.class.getSimpleName()));
  }

  @Test
  void testSerialExecution() throws Exception {
    AtomicInteger counter = new AtomicInteger();
    CompletableFuture<?> completableFuture = new CompletableFuture<Void>();
    Utils.scheduleWithVariableRate(completableFuture, CommonThreadPool.get(), () -> {
      counter.getAndIncrement();
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
      }
      // if the counter is greater than 1, another thread has executed
      assertEquals(1, counter.get());
      completableFuture.complete(null);
    }, 0, () -> 1L, TimeUnit.MILLISECONDS);
    completableFuture.get(1, TimeUnit.SECONDS);
  }
}
