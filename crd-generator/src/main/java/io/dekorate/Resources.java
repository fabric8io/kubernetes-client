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
import io.dekorate.utils.Metadata;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Resources {

  private static final String DEFAULT_GROUP = "kubernetes";
  private final Map<String, KubernetesListBuilder> groups = new LinkedHashMap<>();
  private final KubernetesListBuilder global = new KubernetesListBuilder();
  private final Set<Decorator> globalDecorators = new HashSet<>();

  private final Map<String, Set<Decorator>> groupDecorators = new HashMap<>();
  private final Map<String, Set<Decorator>> customDecorators = new HashMap<>();
  private final Map<String, KubernetesListBuilder> customGroups = new HashMap<>();

  private static final Comparator<Decorator> DECORATOR_COMPARATOR = (a, b) -> a.compareTo(b) == 0
    ? b.compareTo(a)
    : a.equals(b) ? 0 : 1;

  /**
   * Get all registered groups.
   *
   * @return The groups map.
   */
  public Map<String, KubernetesListBuilder> groups() {
    return this.groups;
  }


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
   * Add a {@link Decorator} to the specified resource group.
   *
   * @param group The group.
   * @param decorator The decorator.
   */
  public void decorate(String group, Decorator decorator) {
    if (!groupDecorators.containsKey(group)) {
      groupDecorators.put(group, new TreeSet<>());
    }
    groupDecorators.get(group).add(decorator);
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
   * Add a resource to the specified group.
   *
   * @param group The group.
   * @param metadata The resource.
   */
  public void add(String group, HasMetadata metadata) {
    if (!groups.containsKey(group)) {
      groups.put(group, new KubernetesListBuilder());
    }

    if (!groups.get(group).hasMatchingItem(Metadata.matching(metadata))) {
      groups.get(group).addToItems(metadata);
    }
  }

  /**
   * Add a {@link Decorator} to the specified custom group.
   * Custom groups hold custom resources and are not mixed and matched with Kubernetes/Openshift resources.
   * To add a custom decorator, you need to explicitly specify it using this method.
   *
   * @param group The group.
   * @param decorator The decorator.
   */
  public void decorateCustom(String group, Decorator decorator) {
    if (!customDecorators.containsKey(group)) {
      customDecorators.put(group, new TreeSet<>());
    }
    customDecorators.get(group).add(decorator);
  }

  /**
   * Add a resource to the specified custom group.
   * Custom groups hold custom resources and are not mixed and matched with Kubernetes/Openshift resources.
   * To add a custom resource, you need to explicitly specify it using this method.
   *
   * @param group The group.
   * @param metadata The resource.
   */
  public void addCustom(String group, HasMetadata metadata) {
    if (!customGroups.containsKey(group)) {
      customGroups.put(group, new KubernetesListBuilder());
    }
    if (!customGroups.get(group).hasMatchingItem(Metadata.matching(metadata))) {
      customGroups.get(group).addToItems(metadata);
    }
  }

  /**
   * Generate all resources.
   *
   * @return A map of {@link KubernetesList} by group name.
   */
  protected Map<String, KubernetesList> generate() {
    if (!this.global.getItems().isEmpty()) {
      if (this.groups.isEmpty()) {
        KubernetesListBuilder builder = new KubernetesListBuilder();
        builder.addToItems(global.buildItems().toArray(new HasMetadata[global.getItems().size()]));
        this.groups.put(DEFAULT_GROUP, builder);
      } else {
        this.groups.forEach((group, builder) -> builder
          .addToItems(global.buildItems().toArray(new HasMetadata[global.getItems().size()])));
      }
    }

    Map<String, KubernetesListBuilder> groups = new HashMap<>(this.groups);

    Map<String, KubernetesList> resources = new HashMap<>();

    groups.forEach((group, l) -> {
      if (!groupDecorators.containsKey(group) || groupDecorators.get(group).isEmpty()) {
        groupDecorators.put(group, globalDecorators);
      }
    });

    groupDecorators.forEach((group, decorators) -> {
      if (groups.containsKey(group)) {
        Set<Decorator> union = new TreeSet<>(DECORATOR_COMPARATOR);
        union.addAll(decorators);
        union.addAll(globalDecorators);
        for (Decorator d : applyConstraints(union)) {
          groups.get(group).accept(d);
        }
      }
    });
    groups.forEach((g, b) -> resources.put(g, b.build()));

    if (customDecorators.isEmpty()) {
      customGroups.forEach((group, l) -> customDecorators.put(group, globalDecorators));
    }

    customDecorators.forEach((group, decorators) -> {
      if (customGroups.containsKey(group)) {
        Set<Decorator> union = new TreeSet<>(DECORATOR_COMPARATOR);
        union.addAll(decorators);
        union.addAll(globalDecorators);
        for (Decorator d : applyConstraints(union)) {
          customGroups.get(group).accept(d);
        }
      }
    });
    customGroups.forEach((g, b) -> resources.put(g, b.build()));

    return resources;
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
