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
package io.fabric8.kubernetes.client;

public class ConfigFluent<A extends ConfigFluent<A>> extends SundrioConfigFluent<A> {
  public ConfigFluent() {
    super();
  }

  public ConfigFluent(Config instance) {
    super();
    this.copyInstance(instance);
  }

  // no need to override the base logic
  public void copyInstance(Config instance) {
    super.copyInstance(instance);
  }

  // Fix #https://github.com/fabric8io/kubernetes-client/issues/6249
  // Unboxed builder methods (should allow for the co-existience of <6.13.2 and 6.13.x)
  public A withTrustCerts(boolean trustCerts) {
    return this.withTrustCerts(Boolean.valueOf(trustCerts));
  }

  public A withDisableHostnameVerification(boolean disableHostnameVerification) {
    return this.withDisableHostnameVerification(Boolean.valueOf(disableHostnameVerification));
  }

  public A withWebsocketPingInterval(long websocketPingInterval) {
    return this.withWebsocketPingInterval(Long.valueOf(websocketPingInterval));
  }

  public A withConnectionTimeout(int connectionTimeout) {
    return this.withConnectionTimeout(Integer.valueOf(connectionTimeout));
  }

  public A withMaxConcurrentRequests(int maxConcurrentRequests) {
    return this.withMaxConcurrentRequests(Integer.valueOf(maxConcurrentRequests));
  }

  public A withWatchReconnectInterval(int watchReconnectInterval) {
    return this.withWatchReconnectInterval(Integer.valueOf(watchReconnectInterval));
  }

  public A withWatchReconnectLimit(int watchReconnectLimit) {
    return this.withWatchReconnectLimit(Integer.valueOf(watchReconnectLimit));
  }

  public A withUploadRequestTimeout(int uploadRequestTimeout) {
    return this.withUploadRequestTimeout(Integer.valueOf(uploadRequestTimeout));
  }

  public A withRequestRetryBackoffLimit(int requestRetryBackoffLimit) {
    return this.withRequestRetryBackoffLimit(Integer.valueOf(requestRetryBackoffLimit));
  }

  public A withRequestRetryBackoffInterval(int requestRetryBackoffInterval) {
    return this.withRequestRetryBackoffInterval(Integer.valueOf(requestRetryBackoffInterval));
  }

  public A withRequestTimeout(int requestTimeout) {
    return this.withRequestTimeout(Integer.valueOf(requestTimeout));
  }

  public A withScaleTimeout(long scaleTimeout) {
    return this.withScaleTimeout(Long.valueOf(scaleTimeout));
  }

  public A withLoggingInterval(int loggingInterval) {
    return this.withLoggingInterval(Integer.valueOf(loggingInterval));
  }

  public A withHttp2Disable(boolean http2Disable) {
    return this.withHttp2Disable(Boolean.valueOf(http2Disable));
  }

  public A withOnlyHttpWatches(boolean onlyHttpWatches) {
    return this.withOnlyHttpWatches(Boolean.valueOf(onlyHttpWatches));
  }

  public A withAutoConfigure(boolean autoConfigure) {
    return this.withAutoConfigure(Boolean.valueOf(autoConfigure));
  }

}
