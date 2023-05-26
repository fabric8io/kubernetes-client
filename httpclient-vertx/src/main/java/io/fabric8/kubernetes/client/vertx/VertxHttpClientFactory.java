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

package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.Config;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.file.FileSystemOptions;
import io.vertx.ext.web.client.WebClientOptions;

import static io.vertx.core.spi.resolver.ResolverProvider.DISABLE_DNS_RESOLVER_PROP_NAME;

public class VertxHttpClientFactory implements io.fabric8.kubernetes.client.http.HttpClient.Factory {

  private final Vertx vertx;

  public VertxHttpClientFactory() {
    this.vertx = createVertxInstance();
  }

  @Override
  public VertxHttpClientBuilder<VertxHttpClientFactory> newBuilder() {
    return new VertxHttpClientBuilder<>(this, vertx);
  }

  private static synchronized Vertx createVertxInstance() {
    // We must disable the async DNS resolver as it can cause issues when resolving the Vault instance.
    // This is done using the DISABLE_DNS_RESOLVER_PROP_NAME system property.
    // The DNS resolver used by vert.x is configured during the (synchronous) initialization.
    // So, we just need to disable the async resolver around the Vert.x instance creation.
    final String originalValue = System.getProperty(DISABLE_DNS_RESOLVER_PROP_NAME);
    Vertx vertx;
    try {
      System.setProperty(DISABLE_DNS_RESOLVER_PROP_NAME, "true");
      vertx = Vertx.vertx(new VertxOptions()
          .setFileSystemOptions(new FileSystemOptions().setFileCachingEnabled(false).setClassPathResolvingEnabled(false)));
    } finally {
      // Restore the original value
      if (originalValue == null) {
        System.clearProperty(DISABLE_DNS_RESOLVER_PROP_NAME);
      } else {
        System.setProperty(DISABLE_DNS_RESOLVER_PROP_NAME, originalValue);
      }
    }
    return vertx;
  }

  /**
   * Additional configuration to be applied to the options after the {@link Config} has been processed.
   */
  protected void additionalConfig(WebClientOptions options) {
    // no default implementation
  }
}
