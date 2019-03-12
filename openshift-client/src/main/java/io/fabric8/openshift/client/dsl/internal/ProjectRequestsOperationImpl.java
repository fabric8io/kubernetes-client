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

import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.utils.URLUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.openshift.api.model.DoneableProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.ProjectRequestOperation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.PROJECT;

public class ProjectRequestsOperationImpl extends OperationSupport implements ProjectRequestOperation {

  public ProjectRequestsOperationImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public ProjectRequestsOperationImpl(OperationContext context) {
    super(context.withApiGroupName(PROJECT)
      .withPlural("projectrequests"));
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }

  @Override
  public URL getRootUrl() {
    try {
      return new URL(OpenShiftConfig.wrap(getConfig()).getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private ProjectRequest updateApiVersion(ProjectRequest p) {
      p.setApiVersion(this.apiGroupVersion);
      return p;
  }

  @Override
  public ProjectRequest create(ProjectRequest... resources) {
    try {
      if (resources.length > 1) {
        throw new IllegalArgumentException("Too many items to create.");
      } else if (resources.length == 1) {
        return handleCreate(updateApiVersion(resources[0]), ProjectRequest.class);
      } else if (getItem() == null) {
        throw new IllegalArgumentException("Nothing to create.");
      } else {
        return handleCreate(updateApiVersion(getItem()), ProjectRequest.class);
      }
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public DoneableProjectRequest createNew() {
    return new DoneableProjectRequest(item -> {
      try {
        return create(item);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    });
  }

  @Override
  public Status list() {
    try {
      URL requestUrl = getNamespacedUrl();
      Request.Builder requestBuilder = new Request.Builder().get().url(requestUrl);
      return handleResponse(requestBuilder, Status.class);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public Status list(Integer limitVal, String continueVal) {
    try {
      URL requestUrl = getNamespacedUrl();
      if(limitVal != null) {
        requestUrl = new URL(URLUtils.join(requestUrl.toString(), "?limit=" + limitVal.toString()));
      } else if(continueVal != null) {
        requestUrl = new URL(URLUtils.join(requestUrl.toString(), "?limit=" + limitVal.toString() + "&continue=" + continueVal));
      }
      Request.Builder requestBuilder = new Request.Builder().get().url(requestUrl);
      return handleResponse(requestBuilder, Status.class);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }

  }

  public ProjectRequest getItem() {
    return (ProjectRequest) context.getItem();
  }
}
