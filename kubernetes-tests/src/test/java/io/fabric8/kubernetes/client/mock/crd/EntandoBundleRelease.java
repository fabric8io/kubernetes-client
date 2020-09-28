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
package io.fabric8.kubernetes.client.mock.crd;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.CustomResource;

public class EntandoBundleRelease extends CustomResource implements Namespaced {
  private EntandoBundleReleaseSpec spec;

  @Override
  public String getApiVersion() {
    return "demo.fabric8.io/v1alpha1";
  }

  @Override
  public ObjectMeta getMetadata() {
    return super.getMetadata();
  }

  public EntandoBundleReleaseSpec getSpec() {
    return spec;
  }

  public void setSpec(EntandoBundleReleaseSpec spec) {
    this.spec = spec;
  }

  @Override
  public String toString() {
    return "EntandoBundleRelease{"+
      "apiVersion='" + getApiVersion() + "'" +
      ", metadata=" + getMetadata() +
      ", spec=" + spec +
      "}";
  }
}
