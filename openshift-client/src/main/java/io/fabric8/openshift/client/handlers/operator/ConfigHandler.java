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
package io.fabric8.openshift.client.handlers.operator;

import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.operator.v1.Config;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.internal.operator.ConfigOperationsImpl;
import okhttp3.OkHttpClient;

public class ConfigHandler implements ResourceHandler<io.fabric8.openshift.api.model.operator.v1.Config, io.fabric8.openshift.api.model.operator.v1.ConfigBuilder> {

  @Override
  public String getKind() {
    return io.fabric8.openshift.api.model.operator.v1.Config.class.getSimpleName();
  }

  @Override
  public String getApiVersion() {
      return "operator.openshift.io/v1";
    }

  @Override
  public io.fabric8.openshift.api.model.operator.v1.ConfigBuilder edit(io.fabric8.openshift.api.model.operator.v1.Config item) {
    return new io.fabric8.openshift.api.model.operator.v1.ConfigBuilder(item);
  }

  @Override
  public Resource<Config> resource(OkHttpClient client, io.fabric8.kubernetes.client.Config config, String namespace,
            Config item) {
    return new ConfigOperationsImpl(client, OpenShiftConfig.wrap(config)).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName());
  }
}
