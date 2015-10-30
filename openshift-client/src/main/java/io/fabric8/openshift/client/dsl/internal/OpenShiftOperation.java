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

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.EditReplaceDeletable;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.openshift.client.OpenShiftConfig;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenShiftOperation<T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>, R extends ClientResource<T, D>>
  extends HasMetadataOperation<T, L, D, R> {

  protected OpenShiftOperation(OkHttpClient client, OpenShiftConfig config, String resourceT, String namespace, String name, Boolean cascading, T item) {
    super(client, config, resourceT, namespace, name, cascading, item);
  }

  @Override
  public URL getRootUrl() {
    try {
      return new URL(OpenShiftConfig.wrap(getConfig()).getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public R withName(String name) {
    try {
      return (R) getClass()
        .getConstructor(OkHttpClient.class, OpenShiftConfig.class, String.class, String.class, Boolean.class, getType())
        .newInstance(client, getConfig(), getNamespace(), name, isCascading(), getItem());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public OpenShiftOperation<T, L, D, R> inNamespace(String namespace) {
    try {
      return getClass()
        .getConstructor(OkHttpClient.class, OpenShiftConfig.class, String.class, String.class, Boolean.class, getType())
        .newInstance(client, getConfig(), namespace, getName(), isCascading(), getItem());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }


  @Override
  public EditReplaceDeletable<T, T, D, Boolean> cascading(boolean enabled) {
    try {
      return (R) getClass()
        .getConstructor(OkHttpClient.class, OpenShiftConfig.class, String.class, String.class, Boolean.class, getType())
        .newInstance(client, getConfig(), getNamespace(), getName(), enabled, getItem());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public R load(InputStream is) {
    try {
      return (R) getClass()
        .getConstructor(OkHttpClient.class, OpenShiftConfig.class, String.class, String.class, Boolean.class, getType())
        .newInstance(client, getConfig(), getNamespace(), getName(), isCascading(), unmarshal(is, getType()));
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public OpenShiftConfig getConfig() {
    return OpenShiftConfig.wrap(super.getConfig());
  }
}
