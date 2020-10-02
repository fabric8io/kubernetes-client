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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.mockwebserver.crud.AttributeSet;

import java.util.Collections;
import java.util.List;

public class KubernetesCrudAttributesExtractor extends KubernetesAttributesExtractor {
  public KubernetesCrudAttributesExtractor() {
    super(Collections.emptyList());
  }

  public KubernetesCrudAttributesExtractor(List<CustomResourceDefinitionContext> crdContexts) {
    super(crdContexts);
  }

    @Override
    public AttributeSet extract(HasMetadata hasMetadata) {
        return extractMetadataAttributes(hasMetadata);
    }
}
