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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public abstract class ResourceLock<T extends HasMetadata> implements Lock {

  private final ObjectMeta meta;
  private final String identity;

  public ResourceLock(String namespace, String name, String identity) {
    this(new ObjectMetaBuilder().withNamespace(namespace).withName(name).build(), identity);
  }

  public ResourceLock(ObjectMeta meta, String identity) {
    this.meta = meta;
    Objects.requireNonNull(meta.getNamespace(), "namespace is required");
    Objects.requireNonNull(meta.getName(), "name is required");
    this.identity = Objects.requireNonNull(identity, "identity is required");
  }

  protected abstract Class<T> getKind();

  @Override
  public LeaderElectionRecord get(KubernetesClient client) {
    return getResource(client).map(this::toRecordInternal).orElse(null);
  }

  private Optional<T> getResource(KubernetesClient client) {
    return Optional.ofNullable(client.resources(getKind()).inNamespace(meta.getNamespace()).withName(meta.getName()).get());
  }

  @Override
  public void create(KubernetesClient client, LeaderElectionRecord leaderElectionRecord) {
    client.resource(toResource(leaderElectionRecord, getObjectMeta(leaderElectionRecord.getVersion()))).create();
  }

  @Override
  public void update(KubernetesClient client, LeaderElectionRecord leaderElectionRecord) {
    client.resource(toResource(leaderElectionRecord, getObjectMeta(leaderElectionRecord.getVersion())))
        .patch(PatchContext.of(PatchType.STRATEGIC_MERGE));
  }

  /**
   * Convert the record to a resource
   *
   * @param leaderElectionRecord
   * @param meta not null
   * @return
   */
  protected abstract T toResource(LeaderElectionRecord leaderElectionRecord, ObjectMeta meta);

  protected LeaderElectionRecord toRecordInternal(T resource) {
    LeaderElectionRecord result = toRecord(resource);
    result.setVersion(resource.getMetadata().getResourceVersion());
    return result;
  }

  protected abstract LeaderElectionRecord toRecord(T resource);

  protected ObjectMeta getObjectMeta(Serializable version) {
    return new ObjectMetaBuilder(meta).withResourceVersion((String) version).build();
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
    return String.format("%sLock: %s - %s (%s)", getKind().getSimpleName(), meta.getNamespace(), meta.getName(), identity);
  }

}
