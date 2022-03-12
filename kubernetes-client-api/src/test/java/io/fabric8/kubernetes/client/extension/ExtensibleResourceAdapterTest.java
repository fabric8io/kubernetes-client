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

package io.fabric8.kubernetes.client.extension;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.Client;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExtensibleResourceAdapterTest {

  static class MyResource extends ExtensibleResourceAdapter<Pod> {

    @Override
    public ExtensibleResourceAdapter<Pod> newInstance() {
      return new MyResource();
    }

    @Override
    public Pod get() {
      return new Pod();
    }

  }

  @Test
  void testWrappingOperations() {
    MyResource myResource = new MyResource();
    myResource.init(Mockito.mock(ExtensibleResource.class), Mockito.mock(Client.class));
    // make sure MyResource.get is still called
    assertNotNull(myResource.fromServer().get());
  }

}
