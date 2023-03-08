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

package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.Utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JdkHttpClientFactory implements HttpClient.Factory {

  static class ShutdownableExecutor implements Executor {

    private ExecutorService es;

    public ShutdownableExecutor(ExecutorService es) {
      this.es = es;
    }

    @Override
    public void execute(Runnable command) {
      es.execute(command);
    }

    public void shutdownNow() {
      es.shutdownNow();
    }

  }

  @Override
  public JdkHttpClientBuilderImpl newBuilder() {
    return new JdkHttpClientBuilderImpl(this);
  }

  /**
   * Additional configuration to be applied to the builder after the {@link Config} has been processed.
   *
   * @param builder
   */
  protected void additionalConfig(java.net.http.HttpClient.Builder builder) {
    // no default implementation
  }

  /**
   * Create a new builder. This can be overridden to modify the builder prior to the {@link Config} being processed.
   *
   * @return the builder
   */
  protected java.net.http.HttpClient.Builder createNewHttpClientBuilder() {
    ExecutorService ex = Executors.newCachedThreadPool(Utils.daemonThreadFactory(this));

    return java.net.http.HttpClient.newBuilder().executor(new ShutdownableExecutor(ex));
  }

  /**
   * Cleanup hook called by {@link HttpClient#close()}
   *
   * @param jdkHttpClientImpl
   */
  protected void closeHttpClient(JdkHttpClientImpl jdkHttpClientImpl) {
    jdkHttpClientImpl.getHttpClient().executor().filter(ShutdownableExecutor.class::isInstance)
        .map(ShutdownableExecutor.class::cast).ifPresent(ShutdownableExecutor::shutdownNow);
  }

  /**
   * Due to go/kubernetes bug https://github.com/golang/go/issues/57824
   * expect continue is not supported for jdk. Override this method if you are using a
   * kubernetes version with the fix and require this support (currently only used for
   * submitting openshift builds)
   *
   * @return
   */
  protected boolean useExpectContinue() {
    return false;
  }

}
