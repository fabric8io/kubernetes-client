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
package io.fabric8.crd.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Decorates the CRD with the "None" conversion strategy.
 * <p>
 * If this strategy is used, the built-in converter of the Kubernetes API server changes the apiVersion to the version
 * which is marked as stored and would not touch any other field in the custom resource.
 * Note that only one strategy can be used at the same time for a single CRD.
 * If the "None" strategy doesn't fit, use the {@link WebhookConversion} strategy.
 * </p>
 * 
 * @see <a href=
 *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definition-versioning/#specify-multiple-versions">
 *      Kubernetes Docs - CRD Versioning
 *      </a>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoneConversion {
}
