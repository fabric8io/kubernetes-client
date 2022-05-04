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

package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.util.Map;

/**
 * Holds state related to crds by manipulating the crds known to the attributes extractor
 */
public class CustomResourceDefinitionProcessor {

  private static final String V1BETA1_PATH = "/apis/apiextensions.k8s.io/v1beta1/customresourcedefinitions";
  private static final String V1_PATH = "/apis/apiextensions.k8s.io/v1/customresourcedefinitions";

  private final KubernetesAttributesExtractor extractor;

  public CustomResourceDefinitionProcessor(KubernetesAttributesExtractor extractor) {
    this.extractor = extractor;
  }

  public void process(String path, String crdString, boolean delete) {
    CustomResourceDefinitionContext context = null;
    if (path.startsWith(V1BETA1_PATH)) {
      io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition crd = Serialization
          .unmarshal(crdString, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition.class);
      context = CustomResourceDefinitionContext.fromCrd(crd);
    } else if (path.startsWith(V1_PATH)) {
      CustomResourceDefinition crd = Serialization.unmarshal(crdString, CustomResourceDefinition.class);
      context = CustomResourceDefinitionContext.fromCrd(crd);
    } else {
      return;
    }
    if (delete) {
      extractor.removeCrdContext(context);
    } else {
      extractor.addCrdContext(context);
    }
  }

  public boolean isStatusSubresource(Map<String, String> pathValues) {
    CustomResourceDefinitionContext context = extractor.getCrdContext(pathValues.get(KubernetesAttributesExtractor.API),
        pathValues.get(KubernetesAttributesExtractor.VERSION), pathValues.get(KubernetesAttributesExtractor.PLURAL));
    if (context == null) {
      return false;
    }
    return context.isStatusSubresource();
  }

}
