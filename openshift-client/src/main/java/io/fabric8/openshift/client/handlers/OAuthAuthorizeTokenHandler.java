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
package io.fabric8.openshift.client.handlers;

import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenBuilder;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.internal.OAuthAuthorizeTokenOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@Component
@Service
public class OAuthAuthorizeTokenHandler implements ResourceHandler<OAuthAuthorizeToken, OAuthAuthorizeTokenBuilder> {

  @Override
  public String getKind() {
    return OAuthAuthorizeToken.class.getSimpleName();
  }
  @Override
  public OAuthAuthorizeToken create(OkHttpClient client, Config config, String namespace, OAuthAuthorizeToken item) {
      return new OAuthAuthorizeTokenOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).create();
  }

  @Override
  public OAuthAuthorizeToken replace(OkHttpClient client, Config config, String namespace, OAuthAuthorizeToken item) {
    return new OAuthAuthorizeTokenOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, true, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).replace(item);
  }

  @Override
  public OAuthAuthorizeToken reload(OkHttpClient client, Config config, String namespace, OAuthAuthorizeToken item) {
    return new OAuthAuthorizeTokenOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).fromServer().get();
  }

  @Override
  public OAuthAuthorizeTokenBuilder edit(OAuthAuthorizeToken item) {
    return new OAuthAuthorizeTokenBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, OAuthAuthorizeToken item) {
      return new OAuthAuthorizeTokenOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).delete(item);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, OAuthAuthorizeToken item, Watcher<OAuthAuthorizeToken> watcher) {
    return new OAuthAuthorizeTokenOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, OAuthAuthorizeToken item, String resourceVersion, Watcher<OAuthAuthorizeToken> watcher) {
    return new OAuthAuthorizeTokenOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(resourceVersion, watcher);
  }

  @Override
  public OAuthAuthorizeToken waitUntilReady(OkHttpClient client, Config config, String namespace, OAuthAuthorizeToken item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new OAuthAuthorizeTokenOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).waitUntilReady(amount, timeUnit);
  }
}
