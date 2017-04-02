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

package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static okhttp3.TlsVersion.TLS_1_0;

public class MasterProtocolTest {

    @Test
    public void testWithSSL() throws IOException {
        KubernetesMockServer sslServer = new KubernetesMockServer();
        sslServer.init();

        String host = sslServer.getHostName();
        Integer port = sslServer.getPort();
        Config config = new ConfigBuilder()
                .withMasterUrl(host + ":" +port)
                .withTlsVersions(TLS_1_0)
                .withTrustCerts(true)
                .build();
        Assert.assertTrue(config.getMasterUrl().toLowerCase().startsWith(Config.HTTPS_PROTOCOL_PREFIX));

        sslServer.destroy();
    }

    @Test
    public void testWithoutSSL() throws IOException {
        KubernetesMockServer plainServer = new KubernetesMockServer(false);
        plainServer.init();
        String host = plainServer.getHostName();
        Integer port = plainServer.getPort();
        Config config = new ConfigBuilder()
                .withMasterUrl(host + ":" +port)
                .build();
        Assert.assertTrue(config.getMasterUrl().toLowerCase().startsWith(Config.HTTP_PROTOCOL_PREFIX));
        plainServer.destroy();
    }
}
