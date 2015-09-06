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

import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.CreateFromLoadable;
import io.fabric8.openshift.api.model.DoneableOAuthClient;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientList;
import io.fabric8.openshift.client.OpenShiftClient;

public class OAuthClientOperationsImpl extends OpenshiftOperation<OpenShiftClient, OAuthClient, OAuthClientList, DoneableOAuthClient,
  ClientResource<OAuthClient, DoneableOAuthClient>, CreateFromLoadable<OAuthClient, DoneableOAuthClient>> {

  public OAuthClientOperationsImpl(OpenShiftClient client) {
    super(client, "oauthclients", null, null, true);
    super(client, "oauthclients", null, (String) null);
  }

  public OAuthClientOperationsImpl(OpenShiftClient client, String namespace, String name, Boolean cascading) {
    super(client, "oauthclients", namespace, name, cascading);
  public OAuthClientOperationsImpl(OpenShiftClient client, String namespace, String name) {
    super(client, "oauthclients", namespace, name);
  }

  public OAuthClientOperationsImpl(OpenShiftClient client, String namespace, OAuthClient o) {
    super(client, "oauthclients", namespace, o);
  }
}
