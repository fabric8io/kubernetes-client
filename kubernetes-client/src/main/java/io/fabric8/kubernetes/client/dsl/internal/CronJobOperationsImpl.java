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

package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.batch.CronJob;
import io.fabric8.kubernetes.api.model.batch.CronJobList;
import io.fabric8.kubernetes.api.model.batch.DoneableCronJob;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

public class CronJobOperationsImpl extends HasMetadataOperation<CronJob, CronJobList, DoneableCronJob, Resource<CronJob, DoneableCronJob>> {

  public CronJobOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public CronJobOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("batch")
      .withApiGroupVersion("v1beta1")
      .withPlural("cronjobs"));
    this.type = CronJob.class;
    this.listType = CronJobList.class;
    this.doneableType = DoneableCronJob.class;
  }


  @Override
  public CronJobOperationsImpl newInstance(OperationContext context) {
    return new CronJobOperationsImpl(context);
  }

  @Override
  public Resource<CronJob, DoneableCronJob> load(InputStream is) {
    try {
      CronJob item = unmarshal(is, CronJob.class);
      return new CronJobOperationsImpl(context.withItem(item));
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }
}
