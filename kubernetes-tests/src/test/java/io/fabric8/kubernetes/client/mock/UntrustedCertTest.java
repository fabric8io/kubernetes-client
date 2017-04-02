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

package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;

public class UntrustedCertTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  private final String CA_CERT_DATA = "LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSURJRENDQW9tZ0F3SUJBZ0lFTmQ3MHp6QU5CZ2txaGtpRzl3MEJBUVVGQURCT01Rc3dDUVlEVlFRR0V3SlYKVXpFUU1BNEdBMVVFQ2hNSFJYRjFhV1poZURFdE1Dc0dBMVVFQ3hNa1JYRjFhV1poZUNCVFpXTjFjbVVnUTJWeQpkR2xtYVdOaGRHVWdRWFYwYUc5eWFYUjVNQjRYRFRrNE1EZ3lNakUyTkRFMU1Wb1hEVEU0TURneU1qRTJOREUxCk1Wb3dUakVMTUFrR0ExVUVCaE1DVlZNeEVEQU9CZ05WQkFvVEIwVnhkV2xtWVhneExUQXJCZ05WQkFzVEpFVngKZFdsbVlYZ2dVMlZqZFhKbElFTmxjblJwWm1sallYUmxJRUYxZEdodmNtbDBlVENCbnpBTkJna3Foa2lHOXcwQgpBUUVGQUFPQmpRQXdnWWtDZ1lFQXdWMnhXR2NJWXU2Z21pMGZDRzJSRkdpWUNoNysyZ1J2RTRSaUljUFJmTTZmCkJlQzRBZkJPTk96aWlwVUVaS3p4YTFOZkJiUExaNEMvUWdLTy90MEJDZXpoQUJSUC9QdndETjFEdWxzcjRSK0EKY0prVlY1TVc4UStYYXJmQ2FDTWN6RTFaTUt4UkhqdXZLOWJ1WTBWN3hkbGZVTkxqVUE4NmlPZS9GUDNneDdrQwpBd0VBQWFPQ0FRa3dnZ0VGTUhBR0ExVWRId1JwTUdjd1phQmpvR0drWHpCZE1Rc3dDUVlEVlFRR0V3SlZVekVRCk1BNEdBMVVFQ2hNSFJYRjFhV1poZURFdE1Dc0dBMVVFQ3hNa1JYRjFhV1poZUNCVFpXTjFjbVVnUTJWeWRHbG0KYVdOaGRHVWdRWFYwYUc5eWFYUjVNUTB3Q3dZRFZRUURFd1JEVWt3eE1Cb0dBMVVkRUFRVE1CR0JEekl3TVRndwpPREl5TVRZME1UVXhXakFMQmdOVkhROEVCQU1DQVFZd0h3WURWUjBqQkJnd0ZvQVVTT1pvK1N2U3NwWFhSOWdqCklCQlBNNWlRbjlRd0hRWURWUjBPQkJZRUZFam1hUGtyMHJLVjEwZllJeUFRVHpPWWtKL1VNQXdHQTFVZEV3UUYKTUFNQkFmOHdHZ1lKS29aSWh2WjlCMEVBQkEwd0N4c0ZWak11TUdNREFnYkFNQTBHQ1NxR1NJYjNEUUVCQlFVQQpBNEdCQUZqT0tlcjg5OTYxemdLNUY3V0YwYm5qNEpYTUpURU5BS2FTYm4rMmttT2VVSlhSbW0va0VkNWpoVzZZCjdxai9Xc2pUVmJKbWNWZmV3Q0hyUFNxbkkwa0JCSVpDZS96dWY2SVdVclZuWjlOQTJ6c21XTElvZHoydUZIZGgKMXZvcVppZWdEZnFuYzF6cWNQR1VJV1ZFWC9yODd5bG9xYUtIZWU5NTcwK3NCM2M0Ci0tLS0tRU5EIENFUlRJRklDQVRFLS0tLS0=";

  @Test(expected = KubernetesClientException.class)
  public void testList() {
   server.expect().withPath("/api/v1/namespaces/test/pods").andReturn(200, new PodListBuilder().build()).once();
    //We override the config to create a client that doesn't trust all certs.
    Config override = new ConfigBuilder(server.getClient().getConfiguration())
            .withTrustCerts(false)
            .build();

    KubernetesClient client = new DefaultKubernetesClient(override);
    client.pods().list();
  }

  @Test(expected = KubernetesClientException.class)
  public void testListWithCaCerts() {
   server.expect().withPath("/api/v1/namespaces/test/pods").andReturn(200, new PodListBuilder().build()).once();
    //We override the config to create a client that doesn't trust all certs.
    Config override = new ConfigBuilder(server.getClient().getConfiguration())
            .withTrustCerts(false)
            .withCaCertData(CA_CERT_DATA)
            .build();

    KubernetesClient client = new DefaultKubernetesClient(override);
    client.pods().list();
  }

  @Test
  public void testListWithTrustCerts() {
   server.expect().withPath("/api/v1/namespaces/test/pods").andReturn(200, new PodListBuilder().build()).once();
    //We override the config to create a client that doesn't trust all certs.
    Config override = new ConfigBuilder(server.getClient().getConfiguration())
            .withTrustCerts(true)
            .withCaCertData(CA_CERT_DATA)
            .build();

    KubernetesClient client = new DefaultKubernetesClient(override);
    client.pods().list();
  }

}
