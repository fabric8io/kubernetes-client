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

import static io.fabric8.kubernetes.client.Config.DEFAULT_LOGGING_INTERVAL;
import static io.fabric8.kubernetes.client.Config.DEFAULT_MAX_CONCURRENT_REQUESTS_PER_HOST;
import static io.fabric8.kubernetes.client.Config.DEFAULT_ROLLING_TIMEOUT;
import static io.fabric8.kubernetes.client.Config.DEFAULT_SCALE_TIMEOUT;
import static io.fabric8.kubernetes.client.Config.DEFAULT_WEBSOCKET_PING_INTERVAL;
import static io.fabric8.kubernetes.client.Config.DEFAULT_WEBSOCKET_TIMEOUT;

public class RequestConfig {

  private String username;
  private String password;
  private String oauthToken;
  private int watchReconnectInterval = 1000;
  private int watchReconnectLimit = -1;
  private int connectionTimeout = 10 * 1000;
  private int requestTimeout = 10 * 1000;
  private long rollingTimeout = DEFAULT_ROLLING_TIMEOUT;
  private long scaleTimeout = DEFAULT_SCALE_TIMEOUT;
  private int loggingInterval = DEFAULT_LOGGING_INTERVAL;
  private long websocketTimeout = DEFAULT_WEBSOCKET_TIMEOUT;
  private long websocketPingInterval = DEFAULT_WEBSOCKET_PING_INTERVAL;
  private int maxConcurrentRequestsPerHost = DEFAULT_MAX_CONCURRENT_REQUESTS_PER_HOST;

  RequestConfig() {
  }

  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
  public RequestConfig(String username, String password, String oauthToken,
                       int watchReconnectLimit, int watchReconnectInterval,
                       int connectionTimeout, long rollingTimeout, int requestTimeout, long scaleTimeout, int loggingInterval,
                       long websocketTimeout, long websocketPingInterval,
                       int maxConcurrentRequestsPerHost) {
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
    this.maxConcurrentRequestsPerHost = maxConcurrentRequestsPerHost;
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
    return oauthToken;
  }

  public void setOauthToken(String oauthToken) {
    this.oauthToken = oauthToken;
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

  public int getConnectionTimeout() {
    return connectionTimeout;
  }

  public void setConnectionTimeout(int connectionTimeout) {
    this.connectionTimeout = connectionTimeout;
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

  public int getMaxConcurrentRequestsPerHost() {
    return maxConcurrentRequestsPerHost;
  }

  public void setMaxConcurrentRequestsPerHost(int maxConcurrentRequestsPerHost) {
    this.maxConcurrentRequestsPerHost = maxConcurrentRequestsPerHost;
  }
}
