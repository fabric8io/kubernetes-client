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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Optional;

public class ConfigMapLock implements Lock {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigMapLock.class);

  private final String configMapNamespace;
  private final String configMapName;
  private final String identity;
  private final ObjectMapper objectMapper;

  public ConfigMapLock(String configMapNamespace, String configMapName, String identity) {
    this.configMapNamespace = Objects.requireNonNull(configMapNamespace, "configMapNamespace is required");
    this.configMapName = Objects.requireNonNull(configMapName, "configMapName is required");
    this.identity = Objects.requireNonNull(identity, "identity is required");
    objectMapper = Serialization.jsonMapper();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LeaderElectionRecord get(KubernetesClient client) {
    final ConfigMap configMap = client
        .configMaps().inNamespace(configMapNamespace).withName(configMapName).get();
    return Optional.ofNullable(configMap)
        .map(ConfigMap::getMetadata)
        .map(ObjectMeta::getAnnotations)
        .map(annotations -> annotations.get(LEADER_ELECTION_RECORD_ANNOTATION_KEY))
        .map(annotation -> {
          try {
            return objectMapper.readValue(annotation, new TypeReference<LeaderElectionRecord>() {
            });
          } catch (JsonProcessingException ex) {
            LOGGER.error("Error deserializing LeaderElectionRecord from ConfigMap", ex);
            return null;
          }
        })
        .map(record -> {
          record.setVersion(configMap.getMetadata().getResourceVersion());
          return record;
        })
        .orElse(null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void create(
      KubernetesClient client, LeaderElectionRecord leaderElectionRecord) throws LockException {

    try {
      client.configMaps().inNamespace(configMapNamespace).withName(configMapName).create(new ConfigMapBuilder()
          .editOrNewMetadata().withNamespace(configMapNamespace).withName(configMapName)
          .addToAnnotations(LEADER_ELECTION_RECORD_ANNOTATION_KEY, objectMapper.writeValueAsString(leaderElectionRecord))
          .endMetadata()
          .build());
    } catch (Exception e) {
      throw new LockException("Unable to create ConfigMapLock", e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update(
      KubernetesClient client, LeaderElectionRecord leaderElectionRecord) throws LockException {

    try {
      final ConfigMap toReplace = client.configMaps().inNamespace(configMapNamespace).withName(configMapName).get();
      toReplace.getMetadata().getAnnotations()
          .put(LEADER_ELECTION_RECORD_ANNOTATION_KEY, objectMapper.writeValueAsString(leaderElectionRecord));
      // Use replace instead of edit to avoid concurrent modifications, resourceVersion is locked to original record version
      client.configMaps().inNamespace(configMapNamespace).withName(configMapName)
          .lockResourceVersion((String) Objects.requireNonNull(leaderElectionRecord.getVersion()))
          .replace(toReplace);
    } catch (Exception e) {
      throw new LockException("Unable to update ConfigMapLock", e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String identity() {
    return identity;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String describe() {
    return String.format("ConfigMapLock: %s - %s (%s)", configMapNamespace, configMapName, identity);
  }
}
