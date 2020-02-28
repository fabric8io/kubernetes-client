/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.client.internal.serializationmixins.ObjectMetaMixIn;
import io.fabric8.kubernetes.client.internal.serializationmixins.ReplicationControllerMixIn;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerializationUtils {

  private static ObjectMapper mapper;

  private static ObjectMapper statelessMapper;

  public static ObjectMapper getStatelessMapper() {
    if (statelessMapper == null) {
      statelessMapper = new ObjectMapper(new YAMLFactory());
      statelessMapper.addMixInAnnotations(ObjectMeta.class, ObjectMetaMixIn.class);
      statelessMapper.addMixInAnnotations(ReplicationController.class, ReplicationControllerMixIn.class);
    }
    return statelessMapper;
  }

  public static ObjectMapper getMapper() {
    if (mapper == null) {
      mapper = new ObjectMapper(new YAMLFactory());
    }
    return mapper;
  }

  public static String dumpAsYaml(HasMetadata obj) throws JsonProcessingException {
    return getMapper().writeValueAsString(obj);
  }

  public static String dumpWithoutRuntimeStateAsYaml(HasMetadata obj) throws JsonProcessingException {
    return getStatelessMapper().writeValueAsString(obj);
  }

}
