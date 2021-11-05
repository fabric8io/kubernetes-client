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

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;

import static okhttp3.TlsVersion.TLS_1_2;

class MasterProtocolTest {

    @Test
    void testWithSSL() {
        KubernetesMockServer sslServer = new KubernetesMockServer();
        sslServer.init();

        String host = sslServer.getHostName();
        int port = sslServer.getPort();
        Config config = new ConfigBuilder()
                .withMasterUrl(host + ":" +port)
                .withTlsVersions(TLS_1_2)
                .withTrustCerts(true)
                .build();
        assertTrue(config.getMasterUrl().toLowerCase(Locale.ROOT).startsWith(Config.HTTPS_PROTOCOL_PREFIX));

        sslServer.destroy();
    }

    @Test
    void testWithoutSSL() {
        KubernetesMockServer plainServer = new KubernetesMockServer(false);
        plainServer.init();
        String host = plainServer.getHostName();
        int port = plainServer.getPort();
        Config config = new ConfigBuilder()
                .withMasterUrl(host + ":" +port)
                .build();
        assertTrue(config.getMasterUrl().toLowerCase(Locale.ROOT).startsWith(Config.HTTP_PROTOCOL_PREFIX));
        plainServer.destroy();
    }
}
