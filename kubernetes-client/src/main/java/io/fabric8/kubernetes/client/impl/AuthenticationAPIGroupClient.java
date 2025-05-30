/*
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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.client.V1AuthenticationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AuthenticationAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class AuthenticationAPIGroupClient extends ClientAdapter<AuthenticationAPIGroupClient>
    implements AuthenticationAPIGroupDSL {
  @Override
  public V1AuthenticationAPIGroupDSL v1() {
    return adapt(V1AuthenticationAPIGroupClient.class);
  }

  @Override
  public AuthenticationAPIGroupClient newInstance() {
    return new AuthenticationAPIGroupClient();
  }
}
