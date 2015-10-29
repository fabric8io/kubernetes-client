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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerStatus;

public class SerializationUtils {

  private static ObjectMapper mapper;

  private static ObjectMapper statelessMapper;

  public static ObjectMapper getStatelessMapper() {
    if (statelessMapper == null) {
      statelessMapper = new ObjectMapper(new YAMLFactory());
      statelessMapper.addMixIn(ObjectMeta.class, ObjectMetaMixIn.class);
      statelessMapper.addMixIn(ReplicationController.class, StatelessReplicationControllerMixIn.class);
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

  abstract class ObjectMetaMixIn extends ObjectMeta {
    @JsonIgnore
    private String creationTimestamp;
    @JsonIgnore
    private String deletionTimestamp;
    @JsonIgnore
    private Long generation;
    @JsonIgnore
    private String resourceVersion;
    @JsonIgnore
    private String selfLink;
    @JsonIgnore
    private String uid;

    @Override
    @JsonIgnore
    public abstract String getCreationTimestamp();
    @Override
    @JsonIgnore
    public abstract String getDeletionTimestamp();
    @Override
    @JsonIgnore
    public abstract Long getGeneration();
    @Override
    @JsonIgnore
    public abstract String getResourceVersion();
    @Override
    @JsonIgnore
    public abstract String getSelfLink();
    @Override
    @JsonIgnore
    public abstract String getUid();
  }

  abstract class StatelessReplicationControllerMixIn extends ReplicationController {
    @JsonIgnore
    private ReplicationControllerStatus status;

    @Override
    @JsonIgnore
    public abstract ReplicationControllerStatus getStatus();
  }

}
