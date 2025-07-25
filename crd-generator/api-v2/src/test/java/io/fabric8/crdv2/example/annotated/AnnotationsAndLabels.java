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
package io.fabric8.crdv2.example.annotated;

import io.fabric8.crd.generator.annotation.Annotations;
import io.fabric8.crd.generator.annotation.Labels;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

@Group("samples.fabric8.io")
@Version("v1alpha1")
@Annotations({"example.io/processed-by=fabric8", "example.io/version=v1.0.0"})
@Labels({"app.kubernetes.io/managed-by=fabric8", "app.kubernetes.io/component=crd"})
public class AnnotationsAndLabels extends CustomResource<AnnotatedSpec, Void> {

} 
