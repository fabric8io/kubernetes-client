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

package io.fabric8.kubernetes.client.dsl.internal.extensions.v1beta1;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.RollableScalableResourceOperation;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class LegacyRollableScalableResourceOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
    extends RollableScalableResourceOperation<T, L, R> {

  protected LegacyRollableScalableResourceOperation(PodOperationContext context, OperationContext superContext, Class<T> type,
      Class<L> listType) {
    super(context, superContext, type, listType);
  }

  @Override
  public Scale scale(Scale scaleParam) {
    return scale(scaleParam, this);
  }

  public static Scale scale(Scale scaleParam, HasMetadataOperation<?, ?, ?> operation) {
    // handles the conversion back in forth between v1beta1.scale and v1.scale
    // the sticking point is mostly the conversion of the selector from a map to a single string
    GenericKubernetesResource scale = operation.handleScale(
        Optional.ofNullable(scaleParam)
            .map(s -> operation.getKubernetesSerialization().unmarshal(operation.getKubernetesSerialization().asYaml(s),
                GenericKubernetesResource.class))
            .map(g -> {
              g.getAdditionalProperties().put("status", null);
              // could explicitly set the apiVersion, but that doesn't seem to be required
              return g;
            }).orElse(null),
        GenericKubernetesResource.class);
    return Optional.ofNullable(scale).map(s -> {
      Optional.ofNullable((Map) s.getAdditionalProperties().get("status"))
          .ifPresent(status -> Optional.ofNullable((Map<String, Object>) status.get("selector"))
              .ifPresent(selector -> status.put("selector",
                  selector.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining(";")))));
      return s;
    }).map(s -> operation.getKubernetesSerialization().unmarshal(operation.getKubernetesSerialization().asYaml(s), Scale.class))
        .orElse(null);
  }

}
