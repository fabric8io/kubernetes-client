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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Triggerable;
import io.fabric8.kubernetes.client.dsl.Typeable;
import io.fabric8.kubernetes.client.dsl.internal.BaseOperation;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.client.internal.URLUtils;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.DoneableBuildConfig;
import io.fabric8.openshift.api.model.WebHookTrigger;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.dsl.ClientBuildConfigResource;
import io.fabric8.openshift.client.dsl.BuildConfigOperation;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Future;

public class BuildConfigOperationsImpl extends OpenshiftOperation<OpenShiftClient, BuildConfig, BuildConfigList, DoneableBuildConfig,
  ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Void>>
  implements BuildConfigOperation {

  private final String secret;
  private final String triggerType;

  public BuildConfigOperationsImpl(OpenShiftClient client) {
    this(client, null, null, true, null, null, null);
  }

  public BuildConfigOperationsImpl(OpenShiftClient client, String namespace, String name, Boolean cascading, BuildConfig item, String secret, String triggerType) {
    super(client, "buildconfigs", namespace, name, cascading, item);
    this.triggerType = triggerType;
    this.secret = secret;
  }

  @Override
  public ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Void> withName(String name) {
    return new BuildConfigOperationsImpl(getClient(), getNamespace(), name, isCascading(), getItem(), secret, triggerType);
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, BuildConfig, BuildConfigList, DoneableBuildConfig, ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Void>> inNamespace(String namespace) {
    return new BuildConfigOperationsImpl(getClient(), namespace, getName(), isCascading(), getItem(), secret, triggerType);
  }


  @Override
  public Typeable<Triggerable<WebHookTrigger, Void>> withSecret(String secret) {
    return new BuildConfigOperationsImpl(getClient(), getNamespace(), getName(), isCascading(), getItem(), secret, triggerType);
  }

  @Override
  public ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Void> load(InputStream is) {
    return new BuildConfigOperationsImpl(getClient(), getNamespace(), getName(), isCascading(), getClient().unmarshal(is, getType()), secret, triggerType);
  }

  @Override
  public Void instantiate(BuildRequest request) {
    try {
      URL instantiationUrl = new URL(URLUtils.join(getResourceUrl().toString(), "instantiate"));
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().preparePost(instantiationUrl.toString());
      requestBuilder.setBody(BaseOperation.mapper.writer().writeValueAsString(request));
      handleResponse(requestBuilder, 201);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    return null;
  }

  @Override
  public Void trigger(WebHookTrigger trigger) {
    try {
      //TODO: This needs some attention.
      String triggerUrl = URLUtils.join(getResourceUrl().toString(), "webhooks", secret, triggerType);
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().preparePost(triggerUrl);
      requestBuilder.addHeader("Content-Type", "application/json");
      requestBuilder.addHeader("X-Github-Event", "push");
      requestBuilder.setBody(BaseOperation.mapper.writer().writeValueAsString(trigger));
      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      assertResponseCode(r, 200);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    return null;
  }

  @Override
  public Triggerable<WebHookTrigger, Void> withType(String type) {
    return new BuildConfigOperationsImpl(getClient(), getNamespace(), getName(), isCascading(), getItem(), secret, type);
  }
}
