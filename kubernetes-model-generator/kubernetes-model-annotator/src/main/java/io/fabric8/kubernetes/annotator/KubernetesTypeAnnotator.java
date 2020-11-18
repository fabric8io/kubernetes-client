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
package io.fabric8.kubernetes.annotator;

import com.sun.codemodel.*;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

public class KubernetesTypeAnnotator extends KubernetesCoreTypeAnnotator {

    private static final String BUILDABLE_REFERENCE_VALUE = "value";

    @Override
    public void processBuildable(JDefinedClass clazz) {
      try {
        JAnnotationUse buildable = clazz.annotate(Buildable.class)
          .param("editableEnabled", false)
          .param("validationEnabled", false)
          .param("generateBuilderPackage", false)
          .param("lazyCollectionInitEnabled", false)
          .param("builderPackage", "io.fabric8.kubernetes.api.builder");

        JAnnotationArrayMember arrayMember = buildable.paramArray("refs");
        arrayMember.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.ObjectMeta"));
        arrayMember.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.LabelSelector"));
        arrayMember.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.Container"));
        arrayMember.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.PodTemplateSpec"));
        arrayMember.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.ResourceRequirements"));
        arrayMember.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.IntOrString"));
        arrayMember.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.ObjectReference"));
        arrayMember.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.LocalObjectReference"));
        arrayMember.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.PersistentVolumeClaim"));

      } catch (JClassAlreadyExistsException e) {
        e.printStackTrace();
      }
    }

}
