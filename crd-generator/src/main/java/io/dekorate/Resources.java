/**
 * Copyright 2018 The original authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.dekorate;

import io.dekorate.kubernetes.decorator.Decorator;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Resources {
  private final KubernetesListBuilder global = new KubernetesListBuilder();
  private final Set<Decorator> globalDecorators = new HashSet<>();

  /**
   * Get the global builder
   *
   * @return The groups map.
   */
  public KubernetesListBuilder global() {
    return this.global;
  }

  /**
   * Add a {@link Decorator}.
   *
   * @param decorator The decorator.
   */
  public void decorate(Decorator decorator) {
    globalDecorators.add(decorator);
  }


  /**
   * Add a resource to all groups.
   *
   * @param metadata
   */
  public void add(HasMetadata metadata) {
    global.addToItems(metadata);
  }


  /**
   * Generate all resources.
   *
   * @return A map of {@link KubernetesList} by group name.
   */
  public KubernetesList generate() {
    for (Decorator decorator : applyConstraints(globalDecorators)) {
      this.global.accept(decorator);
    }
    return this.global.build();
  }

  public List<Decorator> applyConstraints(Set<Decorator> decorators) {
    List<Decorator> result = new ArrayList<>();
    Decorator[] array = decorators.toArray(new Decorator[decorators.size()]);
    // We can't guarantee that `when `decorator a < b and b < c then a < c``.
    // Why?
    // Because our comparators express constraints on particular pairs and can't express the global order.
    // So, in order to be accurate we need to compare each decorator, with ALL OTHER decorators.
    // In other words we don't ANY sorting algorithm, we need bubble sort.
    bubbleSort(array);
    for (Decorator d : array) {
      result.add(d);
    }
    return result;
  }

  /**
   * Bubble sort for decorators.
   */
  public void bubbleSort(Decorator[] decorators) {
    int n = decorators.length;
    Decorator temp = null;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < (n - i); j++) {
        if (decorators[j].compareTo(decorators[j - 1]) < 0) {
          temp = decorators[j - 1];
          decorators[j - 1] = decorators[j];
          decorators[j] = temp;
        }
      }
    }
  }
}
