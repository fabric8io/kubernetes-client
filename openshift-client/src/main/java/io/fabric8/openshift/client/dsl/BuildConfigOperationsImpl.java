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
package io.fabric8.openshift.client.dsl;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.BuildConfigClientResource;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Triggerable;
import io.fabric8.kubernetes.client.dsl.Typeable;
import io.fabric8.kubernetes.client.dsl.internal.BaseOperation;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.DoneableBuildConfig;
import io.fabric8.openshift.api.model.WebHookTrigger;
import io.fabric8.openshift.client.OpenShiftClient;

import java.net.URL;
import java.util.concurrent.Future;

public class BuildConfigOperationsImpl extends OpenshiftOperation<OpenShiftClient, BuildConfig, BuildConfigList, DoneableBuildConfig,
  BuildConfigClientResource<BuildConfig, DoneableBuildConfig, Void, Void>>
  implements BuildConfigOperation
 {

  private final String secret;
   private final String triggerType;

   public BuildConfigOperationsImpl(OpenShiftClient client, String secret, String triggerType) {
    super(client, "buildconfigs", null, null);
    this.triggerType = triggerType;
    this.secret = secret;
  }

  public BuildConfigOperationsImpl(OpenShiftClient client, String namespace, String name, String secret, String triggerType) {
    super(client, "buildconfigs", namespace, name);
    this.triggerType = triggerType;
    this.secret = secret;
  }

  @Override
  public BuildConfigClientResource<BuildConfig, DoneableBuildConfig, Void, Void> withName(String name) {
    try {
      return  getClass()
        .getConstructor(OpenShiftClient.class, String.class, String.class, String.class, String.class)
        .newInstance(getClient(), getNamespace(), name, secret, triggerType);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, BuildConfig, BuildConfigList, DoneableBuildConfig, BuildConfigClientResource<BuildConfig, DoneableBuildConfig, Void, Void>> inNamespace(String namespace) {
    try {
      return getClass()
        .getConstructor(OpenShiftClient.class, String.class, String.class, String.class, String.class)
        .newInstance(getClient(), namespace, getName(), secret, triggerType);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }



  @Override
  public Typeable<Triggerable<WebHookTrigger, Void>> withSecret(String secret) {
    return new BuildConfigOperationsImpl(getClient(), getNamespace(), getName(), secret, triggerType);
  }

  @Override
  public Void instantiate(BuildRequest request) {
    try {
      URL instantiationUrl = new URL(getResourceUrl().toString() + "/instantiate");
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
       URL webhooksUrl = new URL(getResourceUrl().toString() + "/webhooks/");
       URL triggerUrl = new URL(webhooksUrl, secret+"/"+triggerType);
       AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().preparePost(triggerUrl.toString());
       requestBuilder.addHeader("Content-Type", "application/json");
       requestBuilder.addHeader("X-Github-Event", "push");
       requestBuilder.setBody(BaseOperation.mapper.writer().writeValueAsString(trigger));
       Future<Response> f = requestBuilder.execute();
       Response r = f.get();
       if (r.getStatusCode() != 200) {
         Status status = BaseOperation.mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
         throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
       }
     } catch (Exception e) {
       throw KubernetesClientException.launderThrowable(e);
     }
     return null;
   }

   @Override
   public Triggerable<WebHookTrigger, Void> withType(String type) {
     return new BuildConfigOperationsImpl(getClient(), getNamespace(), getName(), secret, type);
   }
 }
