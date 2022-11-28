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
package io.fabric8.kubernetes.jsonschema2pojo;

import com.sun.codemodel.JDefinedClass;
import org.jsonschema2pojo.GenerationConfig;

import java.util.List;

public class KubernetesTypeAnnotator extends KubernetesCoreTypeAnnotator {

  public KubernetesTypeAnnotator(GenerationConfig generationConfig) {
    super(generationConfig);
  }

  @Override
  protected boolean generateBuilderPackage() {
    return false;
  }

  @Override
  protected void addBuildableTypes(JDefinedClass clazz, List<String> types) {
    types.add("io.fabric8.kubernetes.api.model.ObjectMeta");
    types.add("io.fabric8.kubernetes.api.model.LabelSelector");
    types.add("io.fabric8.kubernetes.api.model.Container");
    types.add("io.fabric8.kubernetes.api.model.PodTemplateSpec");
    types.add("io.fabric8.kubernetes.api.model.ResourceRequirements");
    types.add("io.fabric8.kubernetes.api.model.IntOrString");
    types.add("io.fabric8.kubernetes.api.model.ObjectReference");
    types.add("io.fabric8.kubernetes.api.model.LocalObjectReference");
    types.add("io.fabric8.kubernetes.api.model.PersistentVolumeClaim");
    if (clazz.fields().values().stream()
        .anyMatch(f -> f.type().fullName().contains("io.fabric8.kubernetes.api.model.KubernetesResource")
            || f.type().fullName().contains("io.fabric8.kubernetes.api.model.HasMetadata")
            || f.type().fullName().contains("io.fabric8.kubernetes.api.model.RawExtension"))) {
      types.add("io.fabric8.kubernetes.api.model.GenericKubernetesResource");
      types.add("io.fabric8.kubernetes.api.model.runtime.RawExtension");
    }
  }

}
