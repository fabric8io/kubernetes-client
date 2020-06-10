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

import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenShiftOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, D extends Doneable<T>, R extends Resource<T, D>>
  extends HasMetadataOperation<T, L, D, R> {

  public OpenShiftOperation(OperationContext ctx) {
    super(wrap(ctx));
  }

  private static OperationContext wrap(OperationContext context) {
    OpenShiftConfig config = OpenShiftConfig.wrap(context.getConfig());
    String oapiVersion = config.getOapiVersion();
    if (Utils.isNotNullOrEmpty(context.getApiGroupName())) {
        if (config.isOpenshiftApiGroupsEnabled()) {
          String apiGroupUrl = URLUtils.join(config.getMasterUrl(), "apis", context.getApiGroupName(), oapiVersion);
          String apiGroupVersion = URLUtils.join(context.getApiGroupName(), oapiVersion);
          return context.withConfig(new OpenShiftConfigBuilder(config).withOpenShiftUrl(apiGroupUrl).build()).withApiGroupName(context.getApiGroupName()).withApiGroupVersion(apiGroupVersion);
        } else {
          String apiGroupUrl = URLUtils.join(config.getMasterUrl(), "oapi", oapiVersion);
          return context.withConfig(new OpenShiftConfigBuilder(config).withOpenShiftUrl(apiGroupUrl).build()).withApiGroupName(context.getApiGroupName()).withApiGroupVersion(oapiVersion);
        }
    } else {
      String apiGroupUrl = URLUtils.join(config.getMasterUrl(), "oapi", oapiVersion);
      return context.withConfig(new OpenShiftConfigBuilder(config).withOpenShiftUrl(apiGroupUrl).build()).withApiGroupVersion(oapiVersion);
    }
  }

  @Override
  public OpenShiftConfig getConfig() {
    return OpenShiftConfig.wrap(super.getConfig());
  }

  @Override
  public URL getRootUrl() {
    // This is an OpenShift resource. If no API Group Name is specified, use /oapi endpoint
    if (Utils.isNullOrEmpty(context.getApiGroupName())) {
      try {
        return new URL(OpenShiftConfig.wrap(getConfig()).getOpenShiftUrl());
      } catch (MalformedURLException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    } else {
      return super.getRootUrl();
    }
  }

  protected Class<? extends Config> getConfigType() {
    return OpenShiftConfig.class;
  }
}
