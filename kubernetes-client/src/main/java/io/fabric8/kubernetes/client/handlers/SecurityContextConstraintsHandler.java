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

import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.SecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.internal.SecurityContextConstraintsOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service
public class SecurityContextConstraintsHandler implements ResourceHandler<SecurityContextConstraints, SecurityContextConstraintsBuilder> {
  @Override
  public String getKind() {
    return SecurityContextConstraints.class.getSimpleName();
  }

  @Override
  public SecurityContextConstraints create(OkHttpClient client, Config config, String namespace, SecurityContextConstraints item) {
    return new SecurityContextConstraintsOperationsImpl(client, config, null, namespace, null, true, item, null, false).create();
  }

  @Override
  public SecurityContextConstraints replace(OkHttpClient client, Config config, String namespace, SecurityContextConstraints item) {
    return new SecurityContextConstraintsOperationsImpl(client, config, null, namespace, null, true, item, null, false).replace(item);
  }

  @Override
  public SecurityContextConstraints reload(OkHttpClient client, Config config, String namespace, SecurityContextConstraints item) {
    return new SecurityContextConstraintsOperationsImpl(client, config, null, namespace, null, true, item, null, false).fromServer().get();
  }

  @Override
  public SecurityContextConstraintsBuilder edit(SecurityContextConstraints item) {
    return new SecurityContextConstraintsBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, SecurityContextConstraints item) {
    return new SecurityContextConstraintsOperationsImpl(client, config, null, namespace, null, true, item, null, false).delete(item);
  }
}
