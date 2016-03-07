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
package io.fabric8.kubernetes.client.handlers;

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.internal.ServiceAccountOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service
public class ServiceAccountHandler implements ResourceHandler<ServiceAccount, ServiceAccountBuilder> {
  @Override
  public String getKind() {
    return ServiceAccount.class.getSimpleName();
  }

  @Override
  public ServiceAccount create(OkHttpClient client, Config config, String namespace, ServiceAccount item) {
    return new ServiceAccountOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1).create();
  }

  @Override
  public ServiceAccount replace(OkHttpClient client, Config config, String namespace, ServiceAccount item) {
    return new ServiceAccountOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1).replace(item);
  }

  @Override
  public ServiceAccount reload(OkHttpClient client, Config config, String namespace, ServiceAccount item) {
    return new ServiceAccountOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1).fromServer().get();
  }

  @Override
  public ServiceAccountBuilder edit(ServiceAccount item) {
    return new ServiceAccountBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, ServiceAccount item) {
    return new ServiceAccountOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1).delete(item);
  }
}
