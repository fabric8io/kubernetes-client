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

package io.fabric8.kubernetes.client.dsl.internal.batch.v1beta1;

import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJob;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.http.HttpClient;

import java.io.InputStream;

public class CronJobOperationsImpl extends HasMetadataOperation<CronJob, CronJobList, Resource<CronJob>> {

  public CronJobOperationsImpl(HttpClient client, Config config) {
    this(client, config, null);
  }

  public CronJobOperationsImpl(HttpClient client, Config config, String namespace) {
    this(new OperationContext().withHttpClient(client).withConfig(config).withNamespace(namespace).withPropagationPolicy(DEFAULT_PROPAGATION_POLICY));
  }

  public CronJobOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("batch")
      .withApiGroupVersion("v1beta1")
      .withCascading(true)
      .withPlural("cronjobs"), CronJob.class, CronJobList.class);
  }


  @Override
  public CronJobOperationsImpl newInstance(OperationContext context) {
    return new CronJobOperationsImpl(context);
  }

  @Override
  public Resource<CronJob> load(InputStream is) {
    try {
      CronJob item = unmarshal(is, CronJob.class);
      return new CronJobOperationsImpl(context.withItem(item));
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }
}
