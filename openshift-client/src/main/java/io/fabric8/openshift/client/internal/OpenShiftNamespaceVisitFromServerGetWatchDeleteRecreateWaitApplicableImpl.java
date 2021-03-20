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
package io.fabric8.openshift.client.internal;

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.openshift.client.internal.readiness.OpenShiftReadiness;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.util.List;

public class OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl extends NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl {
  public OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, InputStream is, Boolean cascading, long watchRetryInitialBackoffMillis, double watchRetryBackoffMultiplier, boolean dryRun) {
    super(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, is, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  public OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, Object item, long gracePeriodSeconds, DeletionPropagation propagationPolicy, Boolean cascading, long watchRetryInitialBackoffMillis, double watchRetryBackoffMultiplier, boolean dryRun) {
    super(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, item, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
  protected Readiness getReadiness() {
    return OpenShiftReadiness.getInstance();
  }
}
