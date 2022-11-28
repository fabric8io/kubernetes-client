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
import io.sundr.builder.annotations.BuildableReference;
import org.jsonschema2pojo.GenerationConfig;

import java.util.List;

/**
 * Adds more {@link BuildableReference}s to regular annotator to minimize
 * the code changes in the built-in types from combining annotators.
 */
public class ExtensionTypeAnnotator extends KubernetesTypeAnnotator {

  public ExtensionTypeAnnotator(GenerationConfig generationConfig) {
    super(generationConfig);
  }

  @Override
  protected void addBuildableTypes(JDefinedClass clazz, List<String> types) {
    super.addBuildableTypes(clazz, types);
    types.add("io.fabric8.kubernetes.api.model.EnvVar");
    types.add("io.fabric8.kubernetes.api.model.ContainerPort");
    types.add("io.fabric8.kubernetes.api.model.Volume");
    types.add("io.fabric8.kubernetes.api.model.VolumeMount");
  }

}
