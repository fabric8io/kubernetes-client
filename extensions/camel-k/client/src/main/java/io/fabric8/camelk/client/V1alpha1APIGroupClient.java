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
package io.fabric8.camelk.client;

import io.fabric8.camelk.client.dsl.V1alpha1APIGroupDSL;
import io.fabric8.camelk.v1alpha1.Kamelet;
import io.fabric8.camelk.v1alpha1.KameletBinding;
import io.fabric8.camelk.v1alpha1.KameletBindingList;
import io.fabric8.camelk.v1alpha1.KameletList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1alpha1APIGroupClient extends ClientAdapter<V1alpha1APIGroupClient> implements V1alpha1APIGroupDSL {

  @Override
  public V1alpha1APIGroupClient newInstance() {
    return new V1alpha1APIGroupClient();
  }

  @Override
  public MixedOperation<Kamelet, KameletList, Resource<Kamelet>> kamelets() {
    return resources(Kamelet.class, KameletList.class);
  }

  @Override
  public MixedOperation<KameletBinding, KameletBindingList, Resource<KameletBinding>> kameletBindings() {
    return resources(KameletBinding.class, KameletBindingList.class);
  }
}
