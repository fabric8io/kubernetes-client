/*
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
package io.fabric8.kubernetes.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PluralizeTest {

  @DisplayName("toPlural, should return argument's plural")
  @ParameterizedTest(name = "{index}: ''{1}'' plural is ''{0}''")
  @MethodSource("toPluralInput")
  void toPlural(String plural, String singular) {
    assertEquals(plural, Pluralize.toPlural(singular));
  }

  static Stream<Arguments> toPluralInput() {
    return Stream.of(
        arguments("", ""),
        arguments(null, null),
        arguments("equipment", "equipment"),
        arguments("news", "news"),
        arguments("people", "person"),
        arguments("children", "child"),
        arguments("shoes", "shoe"),
        arguments("loves", "love"),
        arguments("movies", "movie"),
        arguments("lives", "life"),
        arguments("chives", "chive"),
        arguments("diminutives", "diminutive"),
        arguments("dice", "die"),
        arguments("scarves", "scarf"),
        arguments("humans", "human"),
        arguments("definitions", "definition"),
        arguments("statuses", "status"),
        arguments("endpoints", "endpoints"),
        arguments("pods", "podmetrics"),
        arguments("nodes", "nodemetrics"),
        arguments("women", "woman"),
        arguments("men", "man"),
        arguments("dnses", "dns"),
        arguments("egressqoses", "egressqos"),
        arguments("bindings", "binding"),
        arguments("componentstatuses", "componentstatus"),
        arguments("configmaps", "configmap"),
        arguments("endpoints", "endpoints"),
        arguments("events", "event"),
        arguments("limitranges", "limitrange"),
        arguments("namespaces", "namespace"),
        arguments("nodes", "node"),
        arguments("persistentvolumeclaims", "persistentvolumeclaim"),
        arguments("persistentvolumes", "persistentvolume"),
        arguments("pods", "pod"),
        arguments("podtemplates", "podtemplate"),
        arguments("replicationcontrollers", "replicationcontroller"),
        arguments("resourcequotas", "resourcequota"),
        arguments("secrets", "secret"),
        arguments("serviceaccounts", "serviceaccount"),
        arguments("services", "service"),
        arguments("mutatingwebhookconfigurations", "mutatingwebhookconfiguration"),
        arguments("validatingwebhookconfigurations", "validatingwebhookconfiguration"),
        arguments("customresourcedefinitions", "customresourcedefinition"),
        arguments("controllerrevisions", "controllerrevision"),
        arguments("daemonsets", "daemonset"),
        arguments("deployments", "deployment"),
        arguments("replicasets", "replicaset"),
        arguments("statefulsets", "statefulset"),
        arguments("tokenreviews", "tokenreview"),
        arguments("localsubjectaccessreviews", "localsubjectaccessreview"),
        arguments("selfsubjectaccessreviews", "selfsubjectaccessreview"),
        arguments("selfsubjectrulesreviews", "selfsubjectrulesreview"),
        arguments("subjectaccessreviews", "subjectaccessreview"),
        arguments("horizontalpodautoscalers", "horizontalpodautoscaler"),
        arguments("cronjobs", "cronjob"),
        arguments("jobs", "job"),
        arguments("certificatesigningrequests", "certificatesigningrequest"),
        arguments("leases", "lease"),
        arguments("endpointslices", "endpointslice"),
        arguments("ingresses", "ingress"),
        arguments("networkpolicies", "networkpolicy"),
        arguments("poddisruptionbudgets", "poddisruptionbudget"),
        arguments("podsecuritypolicies", "podsecuritypolicy"),
        arguments("clusterrolebindings", "clusterrolebinding"),
        arguments("clusterroles", "clusterrole"),
        arguments("rolebindings", "rolebinding"),
        arguments("roles", "role"),
        arguments("priorityclasses", "priorityclass"),
        arguments("csidrivers", "csidriver"),
        arguments("csinodes", "csinode"),
        arguments("storageclasses", "storageclass"),
        arguments("volumeattachments", "volumeattachment"));
  }

}
