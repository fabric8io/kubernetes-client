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

package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorRequirement;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.client.dsl.FilterNested;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.utils.Utils;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class FilterNestedImpl<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
    implements FilterNested<FilterWatchListDeletable<T, L, R>> {

  private static final String INVOLVED_OBJECT_NAME = "involvedObject.name";
  private static final String INVOLVED_OBJECT_NAMESPACE = "involvedObject.namespace";
  private static final String INVOLVED_OBJECT_KIND = "involvedObject.kind";
  private static final String INVOLVED_OBJECT_UID = "involvedObject.uid";
  private static final String INVOLVED_OBJECT_RESOURCE_VERSION = "involvedObject.resourceVersion";
  private static final String INVOLVED_OBJECT_API_VERSION = "involvedObject.apiVersion";
  private static final String INVOLVED_OBJECT_FIELD_PATH = "involvedObject.fieldPath";

  private final BaseOperation<T, L, R> baseOperation;
  private OperationContext context;

  FilterNestedImpl(BaseOperation<T, L, R> baseOperation) {
    this.baseOperation = baseOperation;
    // create a context copy
    context = this.baseOperation.context;
    context = this.context.copy();
    // create map copies - this could be done lazily if needed
    context.labels = new LinkedHashMap<>(this.baseOperation.context.getLabels());
    context.labelsNot = new LinkedHashMap<>(this.baseOperation.context.getLabelsNot());
    context.labelsIn = new LinkedHashMap<>(this.baseOperation.context.getLabelsIn());
    context.labelsNotIn = new LinkedHashMap<>(this.baseOperation.context.getLabelsNotIn());
    context.fields = new LinkedHashMap<>(this.baseOperation.context.getFields());
    // Use a multi-value map as its possible to define keyA != foo && keyA != bar
    context.fieldsNot = new LinkedHashMap<>(this.baseOperation.context.getFieldsNot());
    context.selectorAsString = this.baseOperation.context.selectorAsString;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withLabels(Map<String, String> labels) {
    this.context.labels.putAll(labels);
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withoutLabels(Map<String, String> labels) {
    // Re-use "withoutLabel" to convert values from String to String[]
    labels.forEach(this::withoutLabel);
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withLabelIn(String key, String... values) {
    context.labelsIn.put(key, values);
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withLabelNotIn(String key, String... values) {
    context.labelsNotIn.put(key, values);
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withLabel(String key, String value) {
    context.labels.put(key, value);
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withoutLabel(String key, String value) {
    context.labelsNot.merge(key, new String[] { value }, (oldList, newList) -> {
      final String[] concatList = (String[]) Array.newInstance(String.class, oldList.length + newList.length);
      System.arraycopy(oldList, 0, concatList, 0, oldList.length);
      System.arraycopy(newList, 0, concatList, oldList.length, newList.length);
      return concatList;
    });
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withFields(Map<String, String> fields) {
    this.context.fields.putAll(fields);
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withField(String key, String value) {
    this.context.fields.put(key, value);
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withoutFields(Map<String, String> fields) {
    // Re-use "withoutField" to convert values from String to String[]
    fields.forEach(this::withoutField);
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withoutField(String key, String value) {
    context.fieldsNot.merge(key, new String[] { value }, (oldList, newList) -> {
      if (Utils.isNotNullOrEmpty(newList[0])) { // Only add new values when not null
        final String[] concatList = (String[]) Array.newInstance(String.class, oldList.length + newList.length);
        System.arraycopy(oldList, 0, concatList, 0, oldList.length);
        System.arraycopy(newList, 0, concatList, oldList.length, newList.length);
        return concatList;
      } else {
        return oldList;
      }
    });
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withLabelSelector(LabelSelector selector) {
    Map<String, String> matchLabels = selector.getMatchLabels();
    if (matchLabels != null) {
      withLabels(matchLabels);
    }
    List<LabelSelectorRequirement> matchExpressions = selector.getMatchExpressions();
    if (matchExpressions != null) {
      for (LabelSelectorRequirement req : matchExpressions) {
        String operator = req.getOperator();
        String key = req.getKey();
        switch (operator) {
          case "In":
            withLabelIn(key, req.getValues().toArray(new String[] {}));
            break;
          case "NotIn":
            withLabelNotIn(key, req.getValues().toArray(new String[] {}));
            break;
          case "DoesNotExist":
            withoutLabel(key);
            break;
          case "Exists":
            withLabel(key);
            break;
          default:
            throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
      }
    }
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withInvolvedObject(ObjectReference objectReference) {
    if (objectReference.getName() != null) {
      context.fields.put(INVOLVED_OBJECT_NAME, objectReference.getName());
    }
    if (objectReference.getNamespace() != null) {
      context.fields.put(INVOLVED_OBJECT_NAMESPACE, objectReference.getNamespace());
    }
    if (objectReference.getKind() != null) {
      context.fields.put(INVOLVED_OBJECT_KIND, objectReference.getKind());
    }
    if (objectReference.getUid() != null) {
      context.fields.put(INVOLVED_OBJECT_UID, objectReference.getUid());
    }
    if (objectReference.getResourceVersion() != null) {
      context.fields.put(INVOLVED_OBJECT_RESOURCE_VERSION, objectReference.getResourceVersion());
    }
    if (objectReference.getApiVersion() != null) {
      context.fields.put(INVOLVED_OBJECT_API_VERSION, objectReference.getApiVersion());
    }
    if (objectReference.getFieldPath() != null) {
      context.fields.put(INVOLVED_OBJECT_FIELD_PATH, objectReference.getFieldPath());
    }
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, R> and() {
    return this.baseOperation.newInstance(context);
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withLabelSelector(String selectorAsString) {
    this.context.selectorAsString = selectorAsString;
    return this;
  }
}
