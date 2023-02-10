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

import java.util.Objects;
import java.util.Optional;

public abstract class ResourceLock<T extends HasMetadata> implements Lock {

  private final String namespace;
  private final String name;
  private final String identity;

  public ResourceLock(String namespace, String name, String identity) {
    this.namespace = Objects.requireNonNull(namespace, "namespace is required");
    this.name = Objects.requireNonNull(name, "name is required");
    this.identity = Objects.requireNonNull(identity, "identity is required");
  }

  protected abstract Class<T> getKind();

  @Override
  public LeaderElectionRecord get(KubernetesClient client) {
    return getResource(client).map(this::toRecord).orElse(null);
  }

  private Optional<T> getResource(KubernetesClient client) {
    return Optional.ofNullable(client.resources(getKind()).inNamespace(namespace).withName(name).get());
  }

  @Override
  public void create(KubernetesClient client, LeaderElectionRecord leaderElectionRecord) {
    client.resource(toResource(leaderElectionRecord, getObjectMeta(null), null)).create();
  }

  @Override
  public void update(KubernetesClient client, LeaderElectionRecord leaderElectionRecord) {
    // this should be an edit, but we've disabled the ability for it to have optimistic locking
    client.resource(getResource(client).map(r -> toResource(leaderElectionRecord, getObjectMeta(r), r))
        .orElseThrow(() -> new NullPointerException())).lockResourceVersion().replace();
  }

  /**
   * Convert the record to a resource
   *
   * @param leaderElectionRecord
   * @param meta not null
   * @param current may be null
   * @return
   */
  protected abstract T toResource(LeaderElectionRecord leaderElectionRecord, ObjectMeta meta, T current);

  protected abstract LeaderElectionRecord toRecord(T resource);

  protected ObjectMeta getObjectMeta(T current) {
    ObjectMetaBuilder builder = Optional.ofNullable(current).map(HasMetadata::getMetadata).map(ObjectMetaBuilder::new)
        .orElse(new ObjectMetaBuilder());
    return builder.withNamespace(namespace).withName(name).build();
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
    return String.format("%sLock: %s - %s (%s)", getKind().getSimpleName(), namespace, name, identity);
  }

}
