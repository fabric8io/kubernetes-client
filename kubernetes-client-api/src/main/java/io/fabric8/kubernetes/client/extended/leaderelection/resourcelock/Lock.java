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

import io.fabric8.kubernetes.client.KubernetesClient;

public interface Lock {

  String LEADER_ELECTION_RECORD_ANNOTATION_KEY = "control-plane.alpha.kubernetes.io/leader";

  /**
   * Returns the current {@link LeaderElectionRecord} or null if none.
   *
   * @param client used to retrieve the LeaderElectionRecord
   * @return the current LeaderElectionRecord or null if none
   */
  LeaderElectionRecord get(KubernetesClient client);

  /**
   * Attempt to create a new {@link LeaderElectionRecord}.
   *
   * @param client used to retrieve the LeaderElectionRecord
   * @param leaderElectionRecord to update
   * @throws LockException if update was not possible
   */
  void create(
      KubernetesClient client, LeaderElectionRecord leaderElectionRecord) throws LockException;

  /**
   * Attempts to update the current {@link LeaderElectionRecord}.
   *
   * @param client used to retrieve the LeaderElectionRecord
   * @param leaderElectionRecord to update
   * @throws LockException if update was not possible
   */
  void update(
      KubernetesClient client, LeaderElectionRecord leaderElectionRecord) throws LockException;

  /**
   * Returns the unique id of the lock holder.
   *
   * This id is to compare ids with current {@link LeaderElectionRecord#getHolderIdentity()}
   * to check for leadership.
   *
   * @return unique id for the lock
   */
  String identity();

  /**
   * Full description of the current lock.
   *
   * @return lock description
   */
  String describe();
}
