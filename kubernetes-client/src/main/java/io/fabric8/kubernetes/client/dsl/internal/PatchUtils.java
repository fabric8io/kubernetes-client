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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.flipkart.zjsonpatch.JsonDiff;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.ResourceCompare;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.util.Optional;

public class PatchUtils {

  public enum Format {
    YAML,
    JSON
  }

  private PatchUtils() {
  }

  private static class SingletonHolder {
    public static final ObjectMapper patchMapper;

    static {
      patchMapper = Serialization.jsonMapper().copy();
      // if this isn't set the patches are still correct, but not as compact for some reason - array values are added individually
      patchMapper.setConfig(patchMapper.getSerializationConfig().without(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS));
    }
  }

  public static String withoutRuntimeState(Object object, Format format, boolean omitStatus) {
    ObjectMapper mapper = format == Format.JSON ? Serialization.jsonMapper() : Serialization.yamlMapper();
    try {
      return mapper.writeValueAsString(withoutRuntimeState(object, omitStatus));
    } catch (JsonProcessingException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  /**
   * See also {@link ResourceCompare#withoutRuntimeState}
   */
  static JsonNode withoutRuntimeState(Object object, boolean omitStatus) {
    ObjectNode raw = SingletonHolder.patchMapper.convertValue(object, ObjectNode.class);
    Optional.ofNullable(raw.get("metadata")).filter(ObjectNode.class::isInstance).map(ObjectNode.class::cast).ifPresent(m -> {
      m.remove("creationTimestamp");
      m.remove("deletionTimestamp");
      m.remove("generation");
      m.remove("resourceVersion");
      m.remove("selfLink");
      m.remove("uid");
    });
    if (omitStatus) {
      raw.remove("status");
    }
    return raw;
  }

  public static String jsonDiff(Object current, Object updated, boolean omitStatus) {
    try {
      return Serialization.jsonMapper().writeValueAsString(
          JsonDiff.asJson(withoutRuntimeState(current, omitStatus), withoutRuntimeState(updated, omitStatus)));
    } catch (JsonProcessingException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

}
