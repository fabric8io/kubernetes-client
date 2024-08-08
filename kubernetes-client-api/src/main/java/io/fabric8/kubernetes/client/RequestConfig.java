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
  private Integer watchReconnectInterval = 1000;
  private Integer watchReconnectLimit = -1;
  private Integer uploadRequestTimeout = DEFAULT_UPLOAD_REQUEST_TIMEOUT;
  private Integer requestRetryBackoffLimit = DEFAULT_REQUEST_RETRY_BACKOFFLIMIT;
  private Integer requestRetryBackoffInterval = DEFAULT_REQUEST_RETRY_BACKOFFINTERVAL;
  private Integer requestTimeout = DEFAULT_REQUEST_TIMEOUT;
  private Long scaleTimeout = DEFAULT_SCALE_TIMEOUT;
  private Integer loggingInterval = DEFAULT_LOGGING_INTERVAL;

  RequestConfig() {
  }

  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
  public RequestConfig(Integer watchReconnectLimit, Integer watchReconnectInterval, Integer requestTimeout,
      Long scaleTimeout, Integer loggingInterval, Integer requestRetryBackoffLimit,
      Integer requestRetryBackoffInterval, Integer uploadRequestTimeout) {
    this.watchReconnectLimit = watchReconnectLimit;
    this.watchReconnectInterval = watchReconnectInterval;
    this.requestTimeout = requestTimeout;
    this.scaleTimeout = scaleTimeout;
    this.loggingInterval = loggingInterval;
    this.requestRetryBackoffLimit = requestRetryBackoffLimit;
    this.requestRetryBackoffInterval = requestRetryBackoffInterval;
    this.uploadRequestTimeout = uploadRequestTimeout;
  }

  public Integer getWatchReconnectInterval() {
    return watchReconnectInterval;
  }

  public void setWatchReconnectInterval(Integer watchReconnectInterval) {
    this.watchReconnectInterval = watchReconnectInterval;
  }

  public Integer getWatchReconnectLimit() {
    return watchReconnectLimit;
  }

  public void setWatchReconnectLimit(Integer watchReconnectLimit) {
    this.watchReconnectLimit = watchReconnectLimit;
  }

  public Integer getRequestTimeout() {
    return requestTimeout;
  }

  public void setRequestTimeout(Integer requestTimeout) {
    this.requestTimeout = requestTimeout;
  }

  public Integer getRequestRetryBackoffLimit() {
    return requestRetryBackoffLimit;
  }

  public void setRequestRetryBackoffLimit(Integer requestRetryBackoffLimit) {
    this.requestRetryBackoffLimit = requestRetryBackoffLimit;
  }

  public Integer getRequestRetryBackoffInterval() {
    return requestRetryBackoffInterval;
  }

  public void setRequestRetryBackoffInterval(Integer requestRetryBackoffInterval) {
    this.requestRetryBackoffInterval = requestRetryBackoffInterval;
  }

  public Integer getUploadRequestTimeout() {
    return uploadRequestTimeout;
  }

  public void setUploadRequestTimeout(Integer uploadRequestTimeout) {
    this.uploadRequestTimeout = uploadRequestTimeout;
  }

  public Long getScaleTimeout() {
    return scaleTimeout;
  }

  public void setScaleTimeout(Long scaleTimeout) {
    this.scaleTimeout = scaleTimeout;
  }

  public Integer getLoggingInterval() {
    return loggingInterval;
  }

  public void setLoggingInterval(Integer loggingInterval) {
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
