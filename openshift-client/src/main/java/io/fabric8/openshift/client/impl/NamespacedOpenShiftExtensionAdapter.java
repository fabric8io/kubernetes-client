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

package io.fabric8.openshift.client.impl;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

/**
 * This class is necessary because the extension logic checks for an exact class match,
 * even though an {@link OpenShiftClientImpl} is already known via the {@link OpenShiftExtensionAdapter}
 */
@Component
@Service
public class NamespacedOpenShiftExtensionAdapter implements ExtensionAdapter<NamespacedOpenShiftClient> {

  @Override
  public Class<NamespacedOpenShiftClient> getExtensionType() {
    return NamespacedOpenShiftClient.class;
  }

  @Override
  public NamespacedOpenShiftClient adapt(Client client) {
    return new OpenShiftClientImpl(client);
  }

}
