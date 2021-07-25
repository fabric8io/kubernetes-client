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
package io.fabric8.openshift.client.dsl.internal.image;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Deletable;
import io.fabric8.kubernetes.client.dsl.Nameable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.CreateOnlyResourceOperationsImpl;
import io.fabric8.openshift.api.model.ImageSignature;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ImageSignatureOperationsImpl extends CreateOnlyResourceOperationsImpl<ImageSignature, ImageSignature> implements Deletable, Nameable<ImageSignatureOperationsImpl> {

  public ImageSignatureOperationsImpl(OkHttpClient client, Config config, String apiGroupName, String apiGroupVersion, String plural) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config), apiGroupName, apiGroupVersion, plural);
  }

  public ImageSignatureOperationsImpl(OperationContext context, String apiGroupName, String apiGroupVersion, String plural) {
    super(context, apiGroupName, apiGroupVersion, plural, ImageSignature.class);
  }

  @Override
  public Boolean delete() {
    try {
      handleDelete(getResourceUrl(), context.getGracePeriodSeconds(), context.getPropagationPolicy(), context.getResourceVersion(), context.getCascading());
      return true;
    } catch (IOException | ExecutionException exception) {
      return false;
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      return false;
    }
  }

  @Override
  public ImageSignatureOperationsImpl withName(String name) {
    return new ImageSignatureOperationsImpl(context.withName(name), context.getApiGroupName(), context.getApiGroupVersion(), context.getPlural());
  }
}
