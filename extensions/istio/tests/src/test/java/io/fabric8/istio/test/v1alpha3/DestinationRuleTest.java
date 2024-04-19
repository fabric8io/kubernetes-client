/*
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
package io.fabric8.istio.test.v1alpha3;

import io.fabric8.istio.api.networking.v1alpha3.DestinationRule;
import io.fabric8.istio.api.networking.v1alpha3.IsLoadBalancerSettingsConsistentHashLBHashKey;
import io.fabric8.istio.api.networking.v1alpha3.IsLoadBalancerSettingsLbPolicy;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHash;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBHttpCookie;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * @author <a href="claprun@redhat.com">Christophe Laprun</a>
 */
class DestinationRuleTest {

  @Test
  void loadingFromYAMLIssue82ShouldWork() throws Exception {
    final InputStream inputStream = DestinationRuleTest.class.getResourceAsStream("/v1alpha3/destination-rule-issue82.yaml");
    final DestinationRule destinationRule = Serialization.yamlMapper().readValue(inputStream, DestinationRule.class);

    final IsLoadBalancerSettingsLbPolicy policy = destinationRule.getSpec().getTrafficPolicy().getLoadBalancer().getLbPolicy();
    assertInstanceOf(LoadBalancerSettingsConsistentHash.class, policy);
    final LoadBalancerSettingsConsistentHash consistentHashLbPolicy = (LoadBalancerSettingsConsistentHash) policy;
    final IsLoadBalancerSettingsConsistentHashLBHashKey hashKey = consistentHashLbPolicy.getConsistentHash().getHashKey();
    assertInstanceOf(LoadBalancerSettingsConsistentHashLBHttpCookie.class, hashKey);
    final LoadBalancerSettingsConsistentHashLBHttpCookie httpCookieHashKey = (LoadBalancerSettingsConsistentHashLBHttpCookie) hashKey;
    assertEquals("user", httpCookieHashKey.getHttpCookie().getName());
  }
}
