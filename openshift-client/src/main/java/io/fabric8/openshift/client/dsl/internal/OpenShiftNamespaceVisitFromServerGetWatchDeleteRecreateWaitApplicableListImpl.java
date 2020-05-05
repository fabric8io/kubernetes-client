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
package io.fabric8.openshift.client.dsl.internal;

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.HasMetadataVisitiableBuilder;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl;
import io.fabric8.kubernetes.client.handlers.KubernetesListHandler;
import io.fabric8.openshift.client.OpenShiftHandlers;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl extends NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl {
  public OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, InputStream is, Map<String, String> parameters, Boolean cascading, DeletionPropagation propagationPolicy) {
    super(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, is, parameters, cascading, propagationPolicy);
  }

  public OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, Object item, InputStream inputStream, Map<String, String> parameters, long gracePeriodSeconds, DeletionPropagation propagationPolicy, Boolean cascading) {
    super(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, item, inputStream, parameters, gracePeriodSeconds, propagationPolicy, cascading);
  }

  @Override
  public <T> ResourceHandler handlerOf(T item) {
    if (item instanceof HasMetadata) {
      return OpenShiftHandlers.<HasMetadata, HasMetadataVisitiableBuilder>get(((HasMetadata) item).getKind(), ((HasMetadata) item).getApiVersion());
    } else if (item instanceof KubernetesList) {
      return new KubernetesListHandler();
    }  else {
      throw new IllegalArgumentException("Could not find a registered handler for item: [" + item + "].");
    }
  }
}
