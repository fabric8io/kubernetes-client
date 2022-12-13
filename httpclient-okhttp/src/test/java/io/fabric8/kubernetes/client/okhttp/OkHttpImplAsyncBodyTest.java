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
package io.fabric8.kubernetes.client.okhttp;

import okio.BufferedSource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.nio.ByteBuffer;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OkHttpImplAsyncBodyTest {

  @Test
  void testClosedWhenExhausted() throws Exception {
    BufferedSource source = mock(BufferedSource.class);
    when(source.exhausted()).thenReturn(true);
    OkHttpClientImpl.OkHttpAsyncBody<List<ByteBuffer>> asyncBody = new OkHttpClientImpl.OkHttpAsyncBody<List<ByteBuffer>>(null,
        source,
        Runnable::run) {

      @Override
      protected List<ByteBuffer> process(BufferedSource source) {
        return null;
      }
    };

    asyncBody.consume();
    Mockito.verify(source).close();
  }
}
