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
package io.fabric8.kubernetes.client;

import io.sundr.builder.annotations.Buildable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.fabric8.kubernetes.client.Config.DEFAULT_LOGGING_INTERVAL;
import static io.fabric8.kubernetes.client.Config.DEFAULT_REQUEST_RETRY_BACKOFFINTERVAL;
import static io.fabric8.kubernetes.client.Config.DEFAULT_REQUEST_RETRY_BACKOFFLIMIT;
import static io.fabric8.kubernetes.client.Config.DEFAULT_REQUEST_TIMEOUT;
import static io.fabric8.kubernetes.client.Config.DEFAULT_SCALE_TIMEOUT;
import static io.fabric8.kubernetes.client.Config.DEFAULT_UPLOAD_REQUEST_TIMEOUT;

public class RequestConfig {

  private String impersonateUsername;

  private String[] impersonateGroups = new String[0];

  private Map<String, List<String>> impersonateExtras = new HashMap<>();
  private int watchReconnectInterval = 1000;
  private int watchReconnectLimit = -1;
  private int uploadRequestTimeout = DEFAULT_UPLOAD_REQUEST_TIMEOUT;
  private int requestRetryBackoffLimit = DEFAULT_REQUEST_RETRY_BACKOFFLIMIT;
  private int requestRetryBackoffInterval = DEFAULT_REQUEST_RETRY_BACKOFFINTERVAL;
  private int requestTimeout = DEFAULT_REQUEST_TIMEOUT;
  private long scaleTimeout = DEFAULT_SCALE_TIMEOUT;
  private int loggingInterval = DEFAULT_LOGGING_INTERVAL;

  RequestConfig() {
  }

  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
  public RequestConfig(int watchReconnectLimit, int watchReconnectInterval, int requestTimeout,
      long scaleTimeout, int loggingInterval, int requestRetryBackoffLimit,
      int requestRetryBackoffInterval, int uploadRequestTimeout) {
    this.watchReconnectLimit = watchReconnectLimit;
    this.watchReconnectInterval = watchReconnectInterval;
    this.requestTimeout = requestTimeout;
    this.scaleTimeout = scaleTimeout;
    this.loggingInterval = loggingInterval;
    this.requestRetryBackoffLimit = requestRetryBackoffLimit;
    this.requestRetryBackoffInterval = requestRetryBackoffInterval;
    this.uploadRequestTimeout = uploadRequestTimeout;
  }

  public int getWatchReconnectInterval() {
    return watchReconnectInterval;
  }

  public void setWatchReconnectInterval(int watchReconnectInterval) {
    this.watchReconnectInterval = watchReconnectInterval;
  }

  public int getWatchReconnectLimit() {
    return watchReconnectLimit;
  }

  public void setWatchReconnectLimit(int watchReconnectLimit) {
    this.watchReconnectLimit = watchReconnectLimit;
  }

  public int getRequestTimeout() {
    return requestTimeout;
  }

  public void setRequestTimeout(int requestTimeout) {
    this.requestTimeout = requestTimeout;
  }

  public int getRequestRetryBackoffLimit() {
    return requestRetryBackoffLimit;
  }

  public void setRequestRetryBackoffLimit(int requestRetryBackoffLimit) {
    this.requestRetryBackoffLimit = requestRetryBackoffLimit;
  }

  public int getRequestRetryBackoffInterval() {
    return requestRetryBackoffInterval;
  }

  public void setRequestRetryBackoffInterval(int requestRetryBackoffInterval) {
    this.requestRetryBackoffInterval = requestRetryBackoffInterval;
  }

  public int getUploadRequestTimeout() {
    return uploadRequestTimeout;
  }

  public void setUploadRequestTimeout(int uploadRequestTimeout) {
    this.uploadRequestTimeout = uploadRequestTimeout;
  }

  public long getScaleTimeout() {
    return scaleTimeout;
  }

  public void setScaleTimeout(long scaleTimeout) {
    this.scaleTimeout = scaleTimeout;
  }

  public int getLoggingInterval() {
    return loggingInterval;
  }

  public void setLoggingInterval(int loggingInterval) {
    this.loggingInterval = loggingInterval;
  }

  public void setImpersonateUsername(String impersonateUsername) {
    this.impersonateUsername = impersonateUsername;
  }

  public String getImpersonateUsername() {
    return impersonateUsername;
  }

  public void setImpersonateGroups(String... impersonateGroups) {
    this.impersonateGroups = impersonateGroups == null ? new String[0]
        : Arrays.copyOf(impersonateGroups, impersonateGroups.length);
  }

  public String[] getImpersonateGroups() {
    return impersonateGroups;
  }

  public void setImpersonateExtras(Map<String, List<String>> impersonateExtras) {
    this.impersonateExtras = new HashMap<>(impersonateExtras);
  }

  public Map<String, List<String>> getImpersonateExtras() {
    return Collections.unmodifiableMap(impersonateExtras);
  }
}
