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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

public class HandlersTest {
  
  static class MyPod extends Pod {
    
  }
  
  static class MyPodOperationsImpl extends HasMetadataOperation<MyPod, KubernetesResourceList<MyPod>, Resource<MyPod>> {

    public MyPodOperationsImpl(ClientContext clientContext) {
      super(new OperationContext(), MyPod.class, null);
    }
    
  }
  
  @Test
  public void testRegister() {
    Handlers.register(MyPod.class, MyPodOperationsImpl::new);

    assertThat(Handlers.get(new MyPod(), null).operation(new SimpleClientContext(), null), Matchers.instanceOf(MyPodOperationsImpl.class));
    
    Handlers.unregister(MyPod.class);
    
    assertThat(Handlers.get(new MyPod(), null).operation(new SimpleClientContext(), null), Matchers.instanceOf(HasMetadataOperationsImpl.class));
  }
}
