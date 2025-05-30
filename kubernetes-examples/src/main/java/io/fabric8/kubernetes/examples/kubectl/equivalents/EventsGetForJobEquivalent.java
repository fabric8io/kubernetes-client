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
package io.fabric8.kubernetes.examples.kubectl.equivalents;

import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This example is Java equivalent to `kubectl events --for job/jobName`, or
 * `kubectl get events --field-selector involvedObject.kind=Job,involvedObject.name=jobName,involvedObject.apiVersion=batch/v1`.
 * It gets events related to a specified Job in a Kubernetes cluster.
 * <p>
 * This example demonstrates how to retrieve events for a specific Kubernetes resource.
 * The same approach can be adapted to fetch events for other resource types,
 * such as Pods, Deployments, or Services, by modifying the {@link ObjectReference}
 * to point to the desired resource. You would need to change the `apiVersion`,
 * `kind`, and `name` fields in the {@link ObjectReferenceBuilder} accordingly.
 * </p>
 */
public class EventsGetForJobEquivalent {
  private static final Logger logger = LoggerFactory.getLogger(EventsGetForJobEquivalent.class);

  public static void main(String[] args) {
    try (final KubernetesClient k8s = new KubernetesClientBuilder().build()) {
      ObjectReference objectReference = new ObjectReferenceBuilder().withApiVersion("batch/v1")
          .withKind("Job")
          .withName("jobName")
          .build();

      k8s.v1()
          .events()
          .inNamespace("default")
          .withInvolvedObject(objectReference)
          .list()
          .getItems()
          .stream()
          .map(Event::getMessage)
          .forEach(logger::info);
    }
  }
}
