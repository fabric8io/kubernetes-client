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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitOperationContext;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.openshift.client.internal.readiness.OpenShiftReadiness;
import okhttp3.OkHttpClient;

public class OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl extends NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl {

  OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(OperationContext context, NamespaceVisitOperationContext namespaceVisitOperationContext) {
    super(context, namespaceVisitOperationContext);
  }

  public OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(OkHttpClient httpClient, Config configuration, HasMetadata item) {
    super(httpClient, configuration, item);
  }

  @Override
  protected Readiness getReadiness() {
    return OpenShiftReadiness.getInstance();
  }

  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl newInstance(OperationContext context,
      NamespaceVisitOperationContext namespaceVisitOperationContext) {
    return new OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(context, namespaceVisitOperationContext);
  }
}
