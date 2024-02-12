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
package io.fabric8.junit.jupiter.api;

import io.fabric8.junit.jupiter.RequireK8sSupportCondition;
import io.fabric8.kubernetes.api.model.HasMetadata;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to mark a test class as requiring support for a specific Kubernetes resource type.
 */
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(RequireK8sSupportCondition.class)
public @interface RequireK8sSupport {
  Class<? extends HasMetadata> value();
}
