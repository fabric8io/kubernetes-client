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
import io.fabric8.kubernetes.client.internal.patchmixins.BuildMixIn;
import io.fabric8.kubernetes.client.internal.patchmixins.ObjectMetaMixIn;
import io.fabric8.openshift.api.model.Build;

public class PatchUtils {

  private static ObjectMapper patchMapper;

  public static ObjectMapper patchMapper() {
    if (patchMapper == null) {
      patchMapper = new ObjectMapper();
      patchMapper.addMixInAnnotations(ObjectMeta.class, ObjectMetaMixIn.class);
      patchMapper.addMixInAnnotations(Build.class, BuildMixIn.class);
      patchMapper.setConfig(patchMapper().getSerializationConfig().without(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS));
    }
    return patchMapper;
  }


}
