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
package io.fabric8.knative.api.model;

import io.fabric8.kubernetes.api.KubernetesResourceMappingProvider;
import io.fabric8.kubernetes.api.model.KubernetesResource;

import java.util.HashMap;
import java.util.Map;

public class KnativeResourceMappingProvider implements KubernetesResourceMappingProvider {

  public final Map<String, Class<? extends KubernetesResource>> mappings = new HashMap<>();

  public KnativeResourceMappingProvider() {
    mappings.put("serving.knative.dev/v1#Configuration", io.fabric8.knative.serving.v1.Configuration.class);
    mappings.put("serving.knative.dev/v1#Revision", io.fabric8.knative.serving.v1.Revision.class);
    mappings.put("serving.knative.dev/v1#Service", io.fabric8.knative.serving.v1.Service.class);
    mappings.put("serving.knative.dev/v1#Route", io.fabric8.knative.serving.v1.Route.class);

    mappings.put("eventing.knative.dev/v1#Broker", io.fabric8.knative.eventing.v1.Broker.class);
    mappings.put("eventing.knative.dev/v1#Channel", io.fabric8.knative.messaging.v1.Channel.class);
    mappings.put("eventing.knative.dev/v1beta1#EventType", io.fabric8.knative.eventing.v1beta1.EventType.class);
    mappings.put("eventing.knative.dev/v1#Trigger", io.fabric8.knative.eventing.v1.Trigger.class);
    mappings.put("eventing.knative.dev/v1#Subscription", io.fabric8.knative.messaging.v1.Subscription.class);

    mappings.put("messaging.knative.dev/v1#InMemoryChannel", io.fabric8.knative.messaging.v1.InMemoryChannel.class);
    mappings.put("messaging.knative.dev/v1#Sequence", io.fabric8.knative.flows.v1.Sequence.class);
    mappings.put("sources.knative.dev/v1#PingSource", io.fabric8.knative.sources.v1.PingSource.class);
    mappings.put("sources.knative.dev/v1#ContainerSource", io.fabric8.knative.sources.v1.ContainerSource.class);
    mappings.put("sources.knative.dev/v1#ApiServerSource", io.fabric8.knative.sources.v1.ApiServerSource.class);
    mappings.put("sources.knative.dev/v1#SinkBinding", io.fabric8.knative.sources.v1.SinkBinding.class);
    mappings.put("sources.knative.dev/v1alpha1#AwsSqsSource",
        io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.AwsSqsSource.class);
    mappings.put("sources.knative.dev/v1alpha1#CouchDbSource",
        io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.CouchDbSource.class);
    mappings.put("sources.knative.dev/v1alpha1#GitHubSource",
        io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubSource.class);
    mappings.put("bindings.knative.dev/v1alpha1#GitHubBinding",
        io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubBinding.class);
    mappings.put("sources.knative.dev/v1alpha1#GitLabSource",
        io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabSource.class);
    mappings.put("bindings.knative.dev/v1alpha1#GitLabBinding",
        io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabBinding.class);
    mappings.put("sources.knative.dev/v1alpha1#PrometheusSource",
        io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.PrometheusSource.class);
    mappings.put("sources.knative.dev/v1beta1#KafkaSource",
        io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaSource.class);
    mappings.put("messaging.knative.dev/v1beta1#KafkaChannel",
        io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaChannel.class);
    mappings.put("bindings.knative.dev/v1beta11#KafkaBinding",
        io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaBinding.class);
  }

  public Map<String, Class<? extends KubernetesResource>> getMappings() {
    return mappings;
  }
}
