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

import io.fabric8.kubernetes.api.model.Status;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WatcherExceptionTest {

  @Test
  void testIsHttpGone() {
    WatcherException we = new WatcherException("I've failed");
    assertFalse(we.isHttpGone());

    we = new WatcherException("I've failed", new ClassCastException());
    assertFalse(we.isHttpGone());

    we = new WatcherException("I've failed",
        new KubernetesClientException("http gone", HttpURLConnection.HTTP_GONE, new Status()));
    assertTrue(we.isHttpGone());
  }

}
