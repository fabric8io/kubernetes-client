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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class HandlersTest {

  static class MyPod extends Pod {

  }

  static class MyPodOperationsImpl extends HasMetadataOperation<MyPod, KubernetesResourceList<MyPod>, Resource<MyPod>> {

    public MyPodOperationsImpl(Client client) {
      super(new OperationContext().withClient(client), MyPod.class, null);
    }

  }

  @Test
  public void testRegister() {
    Handlers handlers = new Handlers();
    handlers.register(MyPod.class, MyPodOperationsImpl::new);

    BaseClient mock = Mockito.mock(BaseClient.class, Mockito.RETURNS_SELF);
    Mockito.when(mock.adapt(BaseClient.class).getHandlers()).thenReturn(handlers);

    assertThat(handlers.get(new MyPod(), null).operation(mock, null)).isInstanceOf(MyPodOperationsImpl.class);

    handlers.unregister(MyPod.class);

    assertThat(handlers.get(new MyPod(), null).operation(mock, null)).isInstanceOf(HasMetadataOperationsImpl.class);
  }
}
