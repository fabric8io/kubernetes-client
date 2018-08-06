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
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

public class CronJobOperationsImpl extends HasMetadataOperation<CronJob, CronJobList, DoneableCronJob, Resource<CronJob, DoneableCronJob>> {
  public CronJobOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(client, config, "v1beta1", namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public CronJobOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, CronJob item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, config, "batch", apiVersion, "cronjobs", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
  }
  @Override
  public Resource<CronJob, DoneableCronJob> load(InputStream is) {
    try {
      CronJob item = unmarshal(is, CronJob.class);
      return new CronJobOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), item, getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }
}
