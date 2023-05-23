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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import io.fabric8.zjsonpatch.JsonDiff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class PatchUtils {

  public enum Format {
    YAML,
    JSON
  }

  private PatchUtils() {
  }

  public static String withoutRuntimeState(Object object, Format format, boolean omitStatus,
      KubernetesSerialization serialization) {
    Function<Object, String> mapper = format == Format.JSON ? serialization::asJson : serialization::asYaml;
    return mapper.apply(withoutRuntimeState(object, omitStatus, serialization));
  }

  static JsonNode withoutRuntimeState(Object object, boolean omitStatus, KubernetesSerialization serialization) {
    ObjectNode raw = serialization.convertValue(object, ObjectNode.class);

    // it makes the diffs more compact to not have empty arrays
    removeEmptyArrays(raw);

    Optional.ofNullable(raw.get("metadata")).filter(ObjectNode.class::isInstance).map(ObjectNode.class::cast).ifPresent(m -> {
      m.remove("creationTimestamp");
      m.remove("deletionTimestamp");
      m.remove("generation");
      m.remove("selfLink");
      m.remove("uid");
    });
    if (omitStatus) {
      raw.remove("status");
    }
    return raw;
  }

  private static void removeEmptyArrays(ObjectNode raw) {
    List<String> toRemove = new ArrayList<>();
    for (Iterator<String> names = raw.fieldNames(); names.hasNext();) {
      String name = names.next();
      JsonNode node = raw.get(name);
      if (node.isArray() && node.size() == 0) {
        toRemove.add(name);
      }
      if (node.isObject()) {
        removeEmptyArrays((ObjectNode) node);
      }
    }
    raw.remove(toRemove);
  }

  public static String jsonDiff(Object current, Object updated, boolean omitStatus, KubernetesSerialization serialization) {
    return serialization
        .asJson(JsonDiff.asJson(withoutRuntimeState(current, omitStatus, serialization),
            withoutRuntimeState(updated, omitStatus, serialization)));
  }

}
