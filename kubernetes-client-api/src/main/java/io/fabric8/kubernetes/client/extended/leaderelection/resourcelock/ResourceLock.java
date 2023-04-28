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

import java.util.Objects;

public abstract class ResourceLock<T extends HasMetadata> implements Lock {

  private final ObjectMeta meta;
  private final String identity;
  private T resource;

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
  public synchronized LeaderElectionRecord get(KubernetesClient client) {
    resource = client.resources(getKind()).inNamespace(meta.getNamespace()).withName(meta.getName()).get();
    if (resource != null) {
      return toRecord(resource);
    }
    return null;
  }

  @Override
  public synchronized void create(KubernetesClient client, LeaderElectionRecord leaderElectionRecord) {
    resource = client.resource(toResource(leaderElectionRecord, getObjectMeta(null))).create();
  }

  @Override
  public synchronized void update(KubernetesClient client, LeaderElectionRecord leaderElectionRecord) {
    Objects.requireNonNull(resource, "get or create must be called first");
    client.resource(toResource(leaderElectionRecord, getObjectMeta(resource.getMetadata().getResourceVersion())))
        .patch(PatchContext.of(PatchType.JSON_MERGE));
  }

  /**
   * Convert the record to a resource
   *
   * @param leaderElectionRecord
   * @param meta not null
   * @return
   */
  protected abstract T toResource(LeaderElectionRecord leaderElectionRecord, ObjectMetaBuilder meta);

  protected abstract LeaderElectionRecord toRecord(T resource);

  protected ObjectMetaBuilder getObjectMeta(String version) {
    return new ObjectMetaBuilder(meta).withResourceVersion(version);
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

  void setResource(T resource) {
    this.resource = resource;
  }

}
