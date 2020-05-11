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
    mappings.put("serving.knative.dev/v1beta1#Configuration", io.fabric8.knative.serving.v1beta1.Configuration.class);
    mappings.put("serving.knative.dev/v1beta1#Revision", io.fabric8.knative.serving.v1beta1.Revision.class);
    mappings.put("serving.knative.dev/v1beta1#Service", io.fabric8.knative.serving.v1beta1.Service.class);
    mappings.put("serving.knative.dev/v1beta1#Route", io.fabric8.knative.serving.v1beta1.Route.class);

    mappings.put("serving.knative.dev/v1#Configuration", io.fabric8.knative.serving.v1.Configuration.class);
    mappings.put("serving.knative.dev/v1#Revision", io.fabric8.knative.serving.v1.Revision.class);
    mappings.put("serving.knative.dev/v1#Service", io.fabric8.knative.serving.v1.Service.class);
    mappings.put("serving.knative.dev/v1#Route", io.fabric8.knative.serving.v1.Route.class);

    mappings.put("eventing.knative.dev/v1alpha1#Broker", io.fabric8.knative.eventing.v1alpha1.Broker.class);
    mappings.put("eventing.knative.dev/v1alpha1#Channel", io.fabric8.knative.messaging.v1alpha1.Channel.class);
    mappings.put("eventing.knative.dev/v1alpha1#EventType", io.fabric8.knative.eventing.v1alpha1.EventType.class);
    mappings.put("eventing.knative.dev/v1alpha1#Trigger", io.fabric8.knative.eventing.v1alpha1.Trigger.class);
    mappings.put("eventing.knative.dev/v1alpha1#Subscription", io.fabric8.knative.messaging.v1alpha1.Subscription.class);

    mappings.put("messaging.knative.dev/v1alpha1#InMemoryChannel", io.fabric8.knative.messaging.v1alpha1.InMemoryChannel.class);
    mappings.put("messaging.knative.dev/v1alpha1#Sequence", io.fabric8.knative.flows.v1alpha1.Sequence.class);
  }

  public Map<String, Class<? extends KubernetesResource>> getMappings() {
    return mappings;
  }
}
