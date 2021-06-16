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
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.Nameable;
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.openshift.api.model.ImageStreamImage;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ImageStreamImageOperationsImpl extends OperationSupport implements Gettable<ImageStreamImage>, Nameable<ImageStreamImageOperationsImpl>, Namespaceable<ImageStreamImageOperationsImpl> {

  public ImageStreamImageOperationsImpl(OkHttpClient client, Config config, String apiGroupName, String apiGroupVersion, String plural) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config).withApiGroupName(apiGroupName).withApiGroupVersion(apiGroupVersion).withPlural(plural));
  }

  public ImageStreamImageOperationsImpl(OperationContext context) {
    super(context);
  }

  @Override
  public ImageStreamImage get() {
    try {
      return handleGet(getResourceUrl(), ImageStreamImage.class);
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(ie);
    }
  }

  @Override
  public ImageStreamImageOperationsImpl withName(String name) {
    return new ImageStreamImageOperationsImpl(context.withName(name));
  }

  @Override
  public ImageStreamImageOperationsImpl inNamespace(String namespace) {
    return new ImageStreamImageOperationsImpl(context.withNamespace(namespace));
  }
}
