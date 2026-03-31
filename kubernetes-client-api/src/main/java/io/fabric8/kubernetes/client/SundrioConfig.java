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

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.fabric8.kubernetes.api.model.AuthProviderConfig;
import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.sundr.builder.annotations.Buildable;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * To add a new config option:
 * <ol>
 * <li>add a field in this class. Adding getters / setters is optional
 * <li>add logic in the {@link Config} constructor to copy the field. Optionally add auto configuration logic.
 * <li>no other changes are typically necessary
 * </ol>
 * 
 * This class is necessary to be able to cleanly deserialize the config.
 * It is also used to autogenerate a builder for the Config class using Sundrio while providing
 * specific behavior for the build() method.
 *
 * This way we can extend the default SundrioConfigBuilder, overriding the build method and enabling autoconfiguration only in
 * this case.
 *
 * The builder is also capable of having a state of the Config with null values (no defaults or autoconfigured).
 *
 * The end purpose is for users to actually use the builder to override the default values or autoconfigured ones
 * by providing their values through the builder withXxx accessors
 */
@Buildable(lazyCollectionInitEnabled = false, lazyMapInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false
/* , ignore = "additionalProperties" */)
@SuppressWarnings({ "LombokGetterMayBeUsed", "LombokSetterMayBeUsed" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SundrioConfig {

  private Boolean trustCerts;
  private Boolean disableHostnameVerification;
  private String masterUrl;
  private String apiVersion;
  private String namespace;
  private Boolean defaultNamespace;
  private String caCertFile;
  private String caCertData;
  private String clientCertFile;
  private String clientCertData;
  private String clientKeyFile;
  private String clientKeyData;
  private String clientKeyAlgo;
  private String clientKeyPassphrase;
  private String trustStoreFile;
  private String trustStorePassphrase;
  private String keyStoreFile;
  private String keyStorePassphrase;
  private AuthProviderConfig authProvider;
  private String username;
  private String password;
  private volatile String oauthToken;
  @JsonIgnore
  private volatile String autoOAuthToken;
  @JsonIgnore
  private OAuthTokenProvider oauthTokenProvider;
  private Long websocketPingInterval;
  private Integer connectionTimeout;
  private Integer maxConcurrentRequests;
  private Integer maxConcurrentRequestsPerHost;

  private List<NamedContext> contexts;
  private NamedContext currentContext;

  private Integer watchReconnectInterval;
  private Integer watchReconnectLimit;
  private Integer uploadRequestTimeout;
  private Integer requestRetryBackoffLimit;
  private Integer requestRetryBackoffInterval;
  private Integer requestTimeout;
  private Long scaleTimeout;
  private Integer loggingInterval;
  private String impersonateUsername;
  private String[] impersonateGroups;
  private Map<String, List<String>> impersonateExtras;

  private Boolean http2Disable;
  private String httpProxy;
  private String httpsProxy;
  private String proxyUsername;
  private String proxyPassword;
  private String[] noProxy;
  private String userAgent;
  private TlsVersion[] tlsVersions;
  private String tlsServerName;

  private Boolean onlyHttpWatches;

  private Boolean watchList;

  /**
   * custom headers
   */
  private Map<String, String> customHeaders;

  private Boolean autoConfigure;

  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  /*
   * Begin specific overrides for getters / setters
   * Only needed if changing the default signature, adding javadocs, etc.
   */

  public void setImpersonateGroups(String... impersonateGroup) {
    this.impersonateGroups = impersonateGroup;
  }

  /**
   * Returns all the {@link NamedContext}s that exist in the kube config
   *
   * @return all the contexts
   *
   * @see NamedContext
   */
  public List<NamedContext> getContexts() {
    return contexts;
  }

  /**
   * Returns the current context that's defined in the kube config. Returns {@code null} if there's none
   *
   * @return the current context
   *
   * @see NamedContext
   */
  public NamedContext getCurrentContext() {
    return currentContext;
  }

}
