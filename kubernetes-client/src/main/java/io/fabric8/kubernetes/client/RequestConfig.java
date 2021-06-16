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
import static io.fabric8.kubernetes.client.Config.DEFAULT_MAX_CONCURRENT_REQUESTS;
import static io.fabric8.kubernetes.client.Config.DEFAULT_MAX_CONCURRENT_REQUESTS_PER_HOST;
import static io.fabric8.kubernetes.client.Config.DEFAULT_REQUEST_RETRY_BACKOFFLIMIT;
import static io.fabric8.kubernetes.client.Config.DEFAULT_REQUEST_RETRY_BACKOFFINTERVAL;
import static io.fabric8.kubernetes.client.Config.DEFAULT_ROLLING_TIMEOUT;
import static io.fabric8.kubernetes.client.Config.DEFAULT_SCALE_TIMEOUT;
import static io.fabric8.kubernetes.client.Config.DEFAULT_UPLOAD_CONNECTION_TIMEOUT;
import static io.fabric8.kubernetes.client.Config.DEFAULT_UPLOAD_REQUEST_TIMEOUT;
import static io.fabric8.kubernetes.client.Config.DEFAULT_WEBSOCKET_PING_INTERVAL;
import static io.fabric8.kubernetes.client.Config.DEFAULT_WEBSOCKET_TIMEOUT;

public class RequestConfig {

  private String username;
  private String password;
  private String oauthToken;
  private OAuthTokenProvider oauthTokenProvider;
  private String impersonateUsername;

  private String[] impersonateGroups = new String[0];

  private Map<String, List<String>> impersonateExtras = new HashMap<>();
  private int watchReconnectInterval = 1000;
  private int watchReconnectLimit = -1;
  private int connectionTimeout = 10 * 1000;
  private int uploadConnectionTimeout = DEFAULT_UPLOAD_CONNECTION_TIMEOUT;
  private int uploadRequestTimeout = DEFAULT_UPLOAD_REQUEST_TIMEOUT;
  private int requestRetryBackoffLimit = DEFAULT_REQUEST_RETRY_BACKOFFLIMIT;
  private int requestRetryBackoffInterval = DEFAULT_REQUEST_RETRY_BACKOFFINTERVAL;
  private int requestTimeout = 10 * 1000;
  private long rollingTimeout = DEFAULT_ROLLING_TIMEOUT;
  private long scaleTimeout = DEFAULT_SCALE_TIMEOUT;
  private int loggingInterval = DEFAULT_LOGGING_INTERVAL;
  private long websocketTimeout = DEFAULT_WEBSOCKET_TIMEOUT;
  private long websocketPingInterval = DEFAULT_WEBSOCKET_PING_INTERVAL;
  private int maxConcurrentRequests = DEFAULT_MAX_CONCURRENT_REQUESTS;
  private int maxConcurrentRequestsPerHost = DEFAULT_MAX_CONCURRENT_REQUESTS_PER_HOST;

  RequestConfig() {
  }

  /**
   * For backward compatibility
   * Use RequestConfigBuilder instead
   *
   * @param username user name
   * @param password password
   * @param oauthToken oauthToken
   * @param watchReconnectLimit watch reconnect limit
   * @param watchReconnectInterval watch reconnect interval
   * @param connectionTimeout connection timeout
   * @param rollingTimeout rolling timeout
   * @param requestTimeout request timeout
   * @param scaleTimeout scale timeout
   * @param loggingInterval logging interval
   * @param websocketTimeout web socket timeout
   * @param maxConcurrentRequestsPerHost max concurrent requests per host
   */
  @Deprecated
  public RequestConfig(String username, String password, String oauthToken,
                       int watchReconnectLimit, int watchReconnectInterval,
                       int connectionTimeout, long rollingTimeout, int requestTimeout, long scaleTimeout, int loggingInterval,
                       long websocketTimeout, long websocketPingInterval,
                       int maxConcurrentRequests, int maxConcurrentRequestsPerHost) {
    this(username, password, oauthToken, watchReconnectLimit, watchReconnectInterval, connectionTimeout, rollingTimeout, requestTimeout, scaleTimeout, loggingInterval,
         websocketTimeout,  websocketPingInterval,maxConcurrentRequests, maxConcurrentRequestsPerHost, null, DEFAULT_REQUEST_RETRY_BACKOFFLIMIT, DEFAULT_REQUEST_RETRY_BACKOFFINTERVAL,
         DEFAULT_UPLOAD_CONNECTION_TIMEOUT, DEFAULT_UPLOAD_REQUEST_TIMEOUT);
  }

  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
  public RequestConfig(String username, String password, String oauthToken,
                       int watchReconnectLimit, int watchReconnectInterval,
                       int connectionTimeout, long rollingTimeout, int requestTimeout, long scaleTimeout, int loggingInterval,
                       long websocketTimeout, long websocketPingInterval,
                       int maxConcurrentRequests, int maxConcurrentRequestsPerHost, OAuthTokenProvider oauthTokenProvider,
                       int requestRetryBackoffLimit, int requestRetryBackoffInterval, int uploadConnectionTimeout, int uploadRequestTimeout) {
    this.username = username;
    this.oauthToken = oauthToken;
    this.password = password;
    this.watchReconnectLimit = watchReconnectLimit;
    this.watchReconnectInterval = watchReconnectInterval;
    this.connectionTimeout = connectionTimeout;
    this.rollingTimeout = rollingTimeout;
    this.requestTimeout = requestTimeout;
    this.scaleTimeout = scaleTimeout;
    this.websocketTimeout = websocketTimeout;
    this.loggingInterval = loggingInterval;
    this.websocketPingInterval = websocketPingInterval;
    this.maxConcurrentRequests = maxConcurrentRequests;
    this.maxConcurrentRequestsPerHost = maxConcurrentRequestsPerHost;
    this.oauthTokenProvider = oauthTokenProvider;
    this.requestRetryBackoffLimit = requestRetryBackoffLimit;
    this.requestRetryBackoffInterval = requestRetryBackoffInterval;
    this.uploadConnectionTimeout = uploadConnectionTimeout;
    this.uploadRequestTimeout = uploadRequestTimeout;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getWatchReconnectInterval() {
    return watchReconnectInterval;
  }

  public void setWatchReconnectInterval(int watchReconnectInterval) {
    this.watchReconnectInterval = watchReconnectInterval;
  }

  public String getOauthToken() {
    if (oauthTokenProvider != null) {
      return oauthTokenProvider.getToken();
    }
    return oauthToken;
  }

  public void setOauthToken(String oauthToken) {
    this.oauthToken = oauthToken;
  }

  public OAuthTokenProvider getOauthTokenProvider() {
    return oauthTokenProvider;
  }

  public void setOauthTokenProvider(OAuthTokenProvider oauthTokenProvider) {
    this.oauthTokenProvider = oauthTokenProvider;
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

  public int getConnectionTimeout() {
    return connectionTimeout;
  }

  public void setConnectionTimeout(int connectionTimeout) {
    this.connectionTimeout = connectionTimeout;
  }

  public int getUploadConnectionTimeout() {
    return uploadConnectionTimeout;
  }

  public void setUploadConnectionTimeout(int uploadConnectionTimeout) {
    this.uploadConnectionTimeout = uploadConnectionTimeout;
  }

  public int getUploadRequestTimeout() {
    return uploadRequestTimeout;
  }

  public void setUploadRequestTimeout(int uploadRequestTimeout) {
    this.uploadRequestTimeout = uploadRequestTimeout;
  }

  public long getRollingTimeout() {
    return rollingTimeout;
  }

  public void setRollingTimeout(long rollingTimeout) {
    this.rollingTimeout = rollingTimeout;
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

  public long getWebsocketTimeout() {
    return websocketTimeout;
  }

  public void setWebsocketTimeout(long websocketTimeout) {
    this.websocketTimeout = websocketTimeout;
  }

  public long getWebsocketPingInterval() {
    return websocketPingInterval;
  }

  public void setWebsocketPingInterval(long websocketPingInterval) {
    this.websocketPingInterval = websocketPingInterval;
  }

  public int getMaxConcurrentRequests() {
    return maxConcurrentRequests;
  }

  public void setMaxConcurrentRequests(int maxConcurrentRequests) {
    this.maxConcurrentRequests = maxConcurrentRequests;
  }

  public int getMaxConcurrentRequestsPerHost() {
    return maxConcurrentRequestsPerHost;
  }

  public void setMaxConcurrentRequestsPerHost(int maxConcurrentRequestsPerHost) {
    this.maxConcurrentRequestsPerHost = maxConcurrentRequestsPerHost;
  }

  public void setImpersonateUsername(String impersonateUsername) {
    this.impersonateUsername = impersonateUsername;
  }

  public String getImpersonateUsername() {
    return impersonateUsername;
  }

  /**
   * Method to set Impersonate Group
   *
   * @param impersonateGroup impersonate group string
   * @deprecated Use {@link #setImpersonateGroups(String...)} instead
   */
  @Deprecated
  public void setImpersonateGroup(String impersonateGroup) {
    setImpersonateGroups(impersonateGroup);
  }

  /**
   * Method for getting Impersonate Groups
   *
   * @return Impersonate group string
   * @deprecated Use {@link #getImpersonateGroups()} instead
   */
  @Deprecated
  public String getImpersonateGroup() {
    return (impersonateGroups == null || impersonateGroups.length == 0) ? null : impersonateGroups[0];
  }

  public void setImpersonateGroups(String... impersonateGroups) {
    this.impersonateGroups = impersonateGroups == null ? new String[0] : Arrays.copyOf(impersonateGroups, impersonateGroups.length);
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
