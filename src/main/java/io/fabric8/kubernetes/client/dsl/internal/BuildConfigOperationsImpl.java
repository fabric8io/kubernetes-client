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

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.BuildConfigResource;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Triggerable;
import io.fabric8.kubernetes.client.dsl.Typeable;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.DoneableBuildConfig;
import io.fabric8.openshift.api.model.WebHookTrigger;

import java.net.URL;
import java.util.concurrent.Future;

public class BuildConfigOperationsImpl extends BaseOperation<BuildConfig, BuildConfigList, DoneableBuildConfig,
  BuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Boolean>>
  implements BuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Boolean>,
  Typeable<Triggerable<WebHookTrigger>>,
  Triggerable<WebHookTrigger>
 {

  private final String secret;
   private final String triggerType;

   public BuildConfigOperationsImpl(AsyncHttpClient httpClient, URL rootUrl, String secret, String triggerType) {
    super(httpClient, rootUrl, "buildconfigs", null, null, BuildConfig.class, BuildConfigList.class, DoneableBuildConfig.class);
    this.triggerType = triggerType;
    this.secret = secret;
  }

  public BuildConfigOperationsImpl(AsyncHttpClient httpClient, URL rootUrl, String namespace, String name, String secret, String triggerType) {
    super(httpClient, rootUrl, "buildconfigs", namespace, name);
    this.triggerType = triggerType;
    this.secret = secret;
  }

  @Override
  public BuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Boolean> withName(String name) {
    try {
      return  getClass()
        .getConstructor(AsyncHttpClient.class, URL.class, String.class, String.class, String.class, String.class)
        .newInstance(getHttpClient(), getRootUrl(), getNamespace(), name, secret, triggerType);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public NonNamespaceOperation<BuildConfig, BuildConfig, BuildConfigList, DoneableBuildConfig, Void, Boolean, BuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Boolean>> inNamespace(String namespace) {
    try {
      return getClass()
        .getConstructor(AsyncHttpClient.class, URL.class, String.class, String.class, String.class, String.class)
        .newInstance(getHttpClient(), getRootUrl(), namespace, getName(), secret, triggerType);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }



  @Override
  public Typeable<Triggerable<WebHookTrigger>> withSecret(String secret) {
    return new BuildConfigOperationsImpl(getHttpClient(), getRootUrl(), getNamespace(), getName(), secret, triggerType);
  }

  @Override
  public void instantiate(BuildRequest request) {
    try {
      URL instantiationUrl = new URL(getResourceUrl().toString() + "/instantiate");
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().preparePost(instantiationUrl.toString());
      requestBuilder.setBody(mapper.writer().writeValueAsString(request));
      handleResponse(requestBuilder, 201);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

   @Override
   public void trigger(WebHookTrigger trigger) {
     try {
       //TODO: This needs some attention.
       URL webhooksUrl = new URL(getResourceUrl().toString() + "/webhooks/");
       URL triggerUrl = new URL(webhooksUrl, secret+"/"+triggerType);
       AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().preparePost(triggerUrl.toString());
       requestBuilder.addHeader("Content-Type", "application/json");
       requestBuilder.addHeader("X-Github-Event", "push");
       requestBuilder.setBody(mapper.writer().writeValueAsString(trigger));
       Future<Response> f = requestBuilder.execute();
       Response r = f.get();
       if (r.getStatusCode() != 200) {
         Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
         throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
       }
     } catch (Exception e) {
       throw KubernetesClientException.launderThrowable(e);
     }
   }

   @Override
   public Triggerable<WebHookTrigger> withType(String type) {
     return new BuildConfigOperationsImpl(getHttpClient(), getRootUrl(), getNamespace(), getName(), secret, type);
   }
 }
