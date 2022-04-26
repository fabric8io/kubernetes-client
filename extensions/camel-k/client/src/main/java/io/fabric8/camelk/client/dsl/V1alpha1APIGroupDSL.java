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
package io.fabric8.camelk.client.dsl;

import io.fabric8.camelk.v1alpha1.Kamelet;
import io.fabric8.camelk.v1alpha1.KameletBinding;
import io.fabric8.camelk.v1alpha1.KameletBindingList;
import io.fabric8.camelk.v1alpha1.KameletList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public interface V1alpha1APIGroupDSL extends Client {
  /**
   * API entrypoint for Kamelet(camel.apache.org/v1)
   *
   * @return MixedOperation for Kamelet class
   */
  MixedOperation<Kamelet, KameletList, Resource<Kamelet>> kamelets();

  /**
   * API entrypoint for KameletBinding (camel.apache.org/v1alpha1)
   *
   * @return {@link MixedOperation} for KameletBinding
   */
  MixedOperation<KameletBinding, KameletBindingList, Resource<KameletBinding>> kameletBindings();
}
