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
package io.fabric8.istio.test.v1beta1;

import io.fabric8.istio.api.networking.v1beta1.CorsPolicy;
import io.fabric8.istio.api.networking.v1beta1.CorsPolicyBuilder;
import io.fabric8.istio.api.networking.v1beta1.StringMatch;
import io.fabric8.istio.api.networking.v1beta1.StringMatchPrefix;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author <a href="claprun@redhat.com">Christophe Laprun</a>
 */
class CorsPolicyTest {
  @Test
  void roundtripShouldWork() throws Exception {
    final String prefix = "example.com";
    final String allowOrigin = "bar.com";
    final CorsPolicy policy = new CorsPolicyBuilder()
        .addNewAllowOrigin()
        .withNewStringMatchPrefixType(prefix)
        .endAllowOrigin()
        .addToDeprecatedAllowOrigin(allowOrigin)
        .build();

    final String output = Serialization.yamlMapper().writeValueAsString(policy);

    CorsPolicy reloaded = Serialization.yamlMapper().readValue(output, CorsPolicy.class);

    assertEquals(1, reloaded.getAllowOrigins().size());
    final StringMatch match = reloaded.getAllowOrigins().get(0);
    if (match.getMatchType() instanceof StringMatchPrefix) {
      StringMatchPrefix prefixMatchType = (StringMatchPrefix) match.getMatchType();
      assertEquals(prefix, prefixMatchType.getPrefix());
    } else {
      fail();
    }

    assertEquals(1, reloaded.getDeprecatedAllowOrigin().size());
    assertEquals(allowOrigin, reloaded.getDeprecatedAllowOrigin().get(0));

    assertEquals(policy, reloaded);
  }
}
