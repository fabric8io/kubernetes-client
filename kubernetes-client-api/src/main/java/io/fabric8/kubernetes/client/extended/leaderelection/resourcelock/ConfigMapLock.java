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
package io.fabric8.kubernetes.client.extended.leaderelection.resourcelock;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class ConfigMapLock extends ResourceLock<ConfigMap> {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigMapLock.class);

  public ConfigMapLock(String configMapNamespace, String configMapName, String identity) {
    super(configMapNamespace, configMapName, identity);
  }

  public ConfigMapLock(ObjectMeta meta, String identity) {
    super(meta, identity);
  }

  @Override
  protected Class<ConfigMap> getKind() {
    return ConfigMap.class;
  }

  @Override
  protected LeaderElectionRecord toRecord(ConfigMap resource) {
    return Optional.ofNullable(resource.getMetadata().getAnnotations())
        .map(annotations -> annotations.get(LEADER_ELECTION_RECORD_ANNOTATION_KEY))
        .map(annotation -> {
          try {
            return Serialization.unmarshal(annotation, LeaderElectionRecord.class);
          } catch (KubernetesClientException ex) {
            LOGGER.error("Error deserializing LeaderElectionRecord from ConfigMap", ex);
            return null;
          }
        })
        .orElse(null);
  }

  @Override
  protected ConfigMap toResource(LeaderElectionRecord leaderElectionRecord, ObjectMetaBuilder meta) {
    return new ConfigMapBuilder()
        .withMetadata(
            meta.addToAnnotations(LEADER_ELECTION_RECORD_ANNOTATION_KEY, Serialization.asJson(leaderElectionRecord)).build())
        .build();
  }

}
