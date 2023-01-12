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
package io.fabric8.junit.jupiter;

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * Must be used in conjunction with {@link KubernetesExtension} to be able to consume a KubernetesClient
 */
public class LoadKubernetesManifestsExtension implements HasKubernetesClient, BeforeAllCallback, AfterAllCallback {

  @Override
  public void beforeAll(ExtensionContext context) {
    final LoadKubernetesManifests annotation = context.getRequiredTestClass()
        .getAnnotation(LoadKubernetesManifests.class);
    final KubernetesClient kc = getClient(context);
    for (String resource : annotation.value()) {
      kc.load(context.getRequiredTestClass().getResourceAsStream(resource)).create();
    }
  }

  @Override
  public void afterAll(ExtensionContext context) {
    final LoadKubernetesManifests annotation = context.getRequiredTestClass()
        .getAnnotation(LoadKubernetesManifests.class);
    if (annotation.deleteAfterTest()) {
      final KubernetesClient kc = getClient(context);
      for (String resource : annotation.value()) {
        kc.load(context.getRequiredTestClass().getResourceAsStream(resource))
            .withGracePeriod(annotation.deleteGracePeriod()).delete();
      }
    }

  }
}
