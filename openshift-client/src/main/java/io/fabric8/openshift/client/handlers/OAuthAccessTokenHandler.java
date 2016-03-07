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

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenBuilder;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.internal.OAuthAccessTokenOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service
public class OAuthAccessTokenHandler implements ResourceHandler<OAuthAccessToken, OAuthAccessTokenBuilder> {

  @Override
  public String getKind() {
    return OAuthAccessToken.class.getSimpleName();
  }

  @Override
  public OAuthAccessToken create(OkHttpClient client, Config config, String namespace, OAuthAccessToken item) {
      return new OAuthAccessTokenOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1).create();
  }

  @Override
  public OAuthAccessToken replace(OkHttpClient client, Config config, String namespace, OAuthAccessToken item) {
    return new OAuthAccessTokenOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1).replace(item);
  }

  @Override
  public OAuthAccessToken reload(OkHttpClient client, Config config, String namespace, OAuthAccessToken item) {
    return new OAuthAccessTokenOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1).fromServer().get();
  }

  @Override
  public OAuthAccessTokenBuilder edit(OAuthAccessToken item) {
    return new OAuthAccessTokenBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, OAuthAccessToken item) {
      return new OAuthAccessTokenOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1).delete(item);
    }
}
