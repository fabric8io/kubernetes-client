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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import io.fabric8.openshift.client.internal.readiness.OpenShiftReadiness;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenShiftOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
  extends HasMetadataOperation<T, L, R> {

  public static final String OPENSHIFT_APIGROUP_SUFFIX = "openshift.io";

  public OpenShiftOperation(OperationContext ctx) {
    super(wrap(ctx));
    updateApiVersion();
  }

  static OperationContext wrap(OperationContext context) {
    OpenShiftConfig config = OpenShiftConfig.wrap(context.getConfig());
    String oapiVersion = config.getOapiVersion();
    if (Utils.isNotNullOrEmpty(context.getApiGroupName())) {
      return getOperationContextWithApiGroupName(config, context, oapiVersion);
    } else {
      String apiGroupUrl = URLUtils.join(config.getMasterUrl(), "oapi", oapiVersion);
      return context.withConfig(new OpenShiftConfigBuilder(config).withOpenShiftUrl(apiGroupUrl).build()).withApiGroupVersion(oapiVersion);
    }
  }

  static OperationContext getOperationContextWithApiGroupName(OpenShiftConfig config, OperationContext context, String oapiVersion) {
    String apiGroupVersionFromConfig = Utils.isNotNullOrEmpty(context.getApiGroupVersion()) ? context.getApiGroupVersion() : oapiVersion;
    if (isOpenShiftApiGroup(context.getApiGroupName())) {
      return getOpenShiftOperationContext(config, context, apiGroupVersionFromConfig);
    } else {
      return getOperationContextWithApiGroupVersion(config, context, apiGroupVersionFromConfig);
    }
  }

  private static OperationContext getOpenShiftOperationContext(OpenShiftConfig config, OperationContext context, String oapiVersion) {
    if (config.isOpenshiftApiGroupsEnabled()) {
      return getOperationContextWithApiGroupVersion(config, context, oapiVersion);
    } else {
      String apiGroupUrl = URLUtils.join(config.getMasterUrl(), "oapi", oapiVersion);
      return context.withConfig(new OpenShiftConfigBuilder(config).withOpenShiftUrl(apiGroupUrl).build()).withApiGroupName(context.getApiGroupName()).withApiGroupVersion(oapiVersion);
    }
  }

  private static OperationContext getOperationContextWithApiGroupVersion(OpenShiftConfig config, OperationContext context, String version) {
    String apiGroupUrl = URLUtils.join(config.getMasterUrl(), "apis", context.getApiGroupName(), version);
    String apiGroupVersion = URLUtils.join(context.getApiGroupName(), version);
    return context.withConfig(new OpenShiftConfigBuilder(config).withOpenShiftUrl(apiGroupUrl).build()).withApiGroupName(context.getApiGroupName()).withApiGroupVersion(apiGroupVersion);
  }

  private static boolean isOpenShiftApiGroup(String apiGroupName) {
    return apiGroupName.contains(OPENSHIFT_APIGROUP_SUFFIX);
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

  @Override
  public Readiness getReadiness() {
    return OpenShiftReadiness.getInstance();
  }

  private void updateApiVersion() {
    this.apiVersion = ApiVersionUtil.joinApiGroupAndVersion(apiGroupName, apiGroupVersion);
  }

  @Override
  protected Class<? extends Config> getConfigType() {
    return OpenShiftConfig.class;
  }
}
