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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.batch.v1.CronJob;
import io.fabric8.kubernetes.api.model.batch.v1.CronJobList;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.ScalableResource;
import io.fabric8.kubernetes.client.dsl.V1BatchAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.internal.batch.v1.JobOperationsImpl;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1BatchAPIGroupClient extends ClientAdapter<V1BatchAPIGroupClient> implements V1BatchAPIGroupDSL {

  @Override
  public MixedOperation<Job, JobList, ScalableResource<Job>> jobs() {
    return new JobOperationsImpl(this);
  }

  @Override
  public MixedOperation<CronJob, CronJobList, Resource<CronJob>> cronjobs() {
    return resources(CronJob.class, CronJobList.class);
  }

  @Override
  public V1BatchAPIGroupClient newInstance() {
    return new V1BatchAPIGroupClient();
  }
}
