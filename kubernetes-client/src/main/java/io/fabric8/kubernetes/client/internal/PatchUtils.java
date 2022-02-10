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
package io.fabric8.kubernetes.client.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.internal.serializationmixins.ObjectMetaMixIn;

public class PatchUtils {
  private PatchUtils() { }

  private static class SingletonHolder {
    public static final ObjectMapper patchMapper;

    static {
      patchMapper = new ObjectMapper();
      patchMapper.addMixIn(ObjectMeta.class, ObjectMetaMixIn.class);
      patchMapper.setConfig(patchMapper.getSerializationConfig().without(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS));
    }
  }

  public static void addMixInToMapper(Class<?> target, Class<?> mixInSource) {
    SingletonHolder.patchMapper.addMixIn(target, mixInSource);
  }

  public static ObjectMapper patchMapper() {
    return SingletonHolder.patchMapper;
  }
}
