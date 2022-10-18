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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.zjsonpatch.JsonDiff;

import java.util.Map;
import java.util.function.BiFunction;

public class PatchUtils {

  public enum Format {
    YAML,
    JSON
  }

  private PatchUtils() {
  }

  private static class SingletonHolder {
    public static final ObjectMapper patchMapper;
    public static final ObjectMapper yamlMapper;

    static {
      patchMapper = Serialization.jsonMapper().copy();
      patchMapper.addMixIn(ObjectMeta.class, ObjectMetaMixIn.class);
      patchMapper.setConfig(patchMapper.getSerializationConfig().without(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS));

      yamlMapper = Serialization.yamlMapper().copy();
      yamlMapper.addMixIn(ObjectMeta.class, ObjectMetaMixIn.class);
      yamlMapper.setConfig(yamlMapper.getSerializationConfig().without(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS));
    }
  }

  public static String withoutRuntimeState(Object object, Format format, boolean omitStatus) {
    return withoutRuntimeState(object, format, omitStatus, (m, v) -> {
      try {
        return m.writeValueAsString(v);
      } catch (JsonProcessingException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    });
  }

  static JsonNode withoutRuntimeState(Object object, boolean omitStatus) {
    return withoutRuntimeState(object, Format.JSON, omitStatus, (m, v) -> m.convertValue(v, JsonNode.class));
  }

  static <T> T withoutRuntimeState(Object object, Format format, boolean omitStatus,
      BiFunction<ObjectMapper, Object, T> result) {
    ObjectMapper mapper = SingletonHolder.patchMapper;
    if (format == Format.YAML) {
      mapper = SingletonHolder.yamlMapper;
    }
    Object value = object;
    if (omitStatus) {
      Map<?, ?> raw = mapper.convertValue(object, Map.class);
      raw.remove("status");
      value = raw;
    }
    return result.apply(mapper, value);
  }

  public static String jsonDiff(Object current, Object updated, boolean omitStatus) {
    try {
      return SingletonHolder.patchMapper.writeValueAsString(
          JsonDiff.asJson(withoutRuntimeState(current, omitStatus), withoutRuntimeState(updated, omitStatus)));
    } catch (JsonProcessingException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

}
