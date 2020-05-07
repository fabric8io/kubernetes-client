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
package io.fabric8.kudo.api.model;

import io.fabric8.kubernetes.api.KubernetesResourceMappingProvider;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import java.util.HashMap;
import java.util.Map;

public class KudoResourceMappingProvider implements KubernetesResourceMappingProvider {

    public final Map<String, Class<? extends KubernetesResource>> mappings = new HashMap<>();

    public KudoResourceMappingProvider () {
      mappings.put("kudo.dev/v1beta1#InstanceList", io.fabric8.kudo.v1beta1.InstanceList.class);
      mappings.put("kudo.dev/v1beta1#Instance", io.fabric8.kudo.v1beta1.Instance.class);
      mappings.put("kudo.dev/v1beta1#OperatorVersion", io.fabric8.kudo.v1beta1.OperatorVersion.class);
      mappings.put("kudo.dev/v1beta1#OperatorVersionList", io.fabric8.kudo.v1beta1.OperatorVersionList.class);
      mappings.put("kudo.dev/v1beta1#Operator", io.fabric8.kudo.v1beta1.Operator.class);
      mappings.put("kudo.dev/v1beta1#OperatorList", io.fabric8.kudo.v1beta1.OperatorList.class);
    }
     
    public Map<String, Class<? extends KubernetesResource>> getMappings() {
        return mappings;
    }
}
