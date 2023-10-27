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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class VisitorTest {

  @Test
  @Disabled("https://github.com/sundrio/sundrio/issues/438")
  void visitorShouldVisitOnlyOnce() {
    // Given
    final AtomicInteger counter = new AtomicInteger();
    final KubernetesListBuilder listBuilder = new KubernetesListBuilder();
    listBuilder.addToItems(
        new DeploymentBuilder()
            .withNewSpec().withNewTemplate().withNewSpec().addNewContainer()
            .withImage("foo")
            .endContainer().endSpec().endTemplate().endSpec());
    // When
    listBuilder.accept(new TypedVisitor<ContainerBuilder>() {
      @Override
      public void visit(ContainerBuilder containerBuilder) {
        counter.incrementAndGet();
      }
    });
    // Then
    assertThat(counter).hasValue(1);
  }
}
