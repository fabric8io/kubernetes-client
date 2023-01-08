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
package io.fabric8.openshift.client.internal;

import io.fabric8.kubernetes.client.Config;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

class OpenShiftOAuthInterceptorTest {

  @Test
  void testTokenSharing() {
    AtomicReference<String> reference = new AtomicReference<>();
    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(null, null, reference);
    OpenShiftOAuthInterceptor other = interceptor.withConfig(Config.empty());
    assertNotSame(interceptor, other);
    assertSame(reference, other.getOauthToken());
  }

}
