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

package io.fabric8.mockwebserver.internal;

import io.fabric8.mockwebserver.MockServerException;
import io.fabric8.mockwebserver.utils.SSLUtils;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;

public class MockSSLContextFactory {

  private MockSSLContextFactory() {
  }

  public static SSLContext create() {
    try {
      KeyManager[] keyManagers = SSLUtils.keyManagers(MockSSLContextFactory.class.getResourceAsStream("/ssl/fabric8.crt"),
          MockSSLContextFactory.class.getResourceAsStream("/ssl/fabric8-private-key.pem"),
          "RSA", "");
      return SSLUtils.sslContext(keyManagers, null, true);
    } catch (Exception e) {
      throw new MockServerException("Exception creating SSLContext", e);
    }
  }
}
