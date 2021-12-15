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
package io.fabric8.istio.test.v1alpha3;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.jupiter.api.Test;

import io.fabric8.istio.api.networking.v1alpha3.Percent;
import io.fabric8.istio.api.networking.v1alpha3.VirtualService;
import io.fabric8.istio.api.networking.v1alpha3.VirtualServiceBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.utils.Serialization;

public class VirtualServiceTest {

  @Test
  public void roundtripBasicVirtualServiceShouldWork() throws Exception {
    final String apiVersion = "networking.istio.io/v1alpha3";
    final VirtualService virtualService = new VirtualServiceBuilder().withApiVersion(apiVersion)
      .withNewMetadata().withName("vs_name").withNamespace("ns").endMetadata()
      .withNewSpec().withHosts("svc_name")
      .addNewHttp()
      .withNewFault()
      .withNewDelay()
      .withNewHTTPFaultInjectionDelayFixedHttpType()
      .withFixedDelay("1s")
      .endHTTPFaultInjectionDelayFixedHttpType()
      .withPercent(10)
      .endDelay()
      .endFault()
      .endHttp()
      .endSpec()
      .build();
    final String output = Serialization.yamlMapper().writeValueAsString(virtualService);

    HasMetadata reloaded = Serialization.yamlMapper().readValue(output, HasMetadata.class);

    assertEquals(apiVersion, reloaded.getApiVersion());
  }

  @Test
  public void loadingFromYAMLIssue103ShouldWork() throws Exception {
    final InputStream inputStream = VirtualServiceTest.class.getResourceAsStream("/v1alpha3/virtual-service-issue103.yaml");
    final VirtualService virtualService = Serialization.yamlMapper().readValue(inputStream, VirtualService.class);

        /*
        ...
        spec:
  http:
    - fault:
        delay:
          fixedDelay: 6s
          percentage:
            value: 90.0

              ...
         */
    final Percent percentage = virtualService.getSpec().getHttp().get(0).getFault().getDelay().getPercentage();
    assertEquals(90, percentage.getValue().intValue());
  }
}
