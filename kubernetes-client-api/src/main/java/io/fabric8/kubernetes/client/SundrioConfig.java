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

  protected Boolean trustCerts;
  protected Boolean disableHostnameVerification;
  protected String masterUrl;
  protected String apiVersion;
  protected String namespace;
  protected Boolean defaultNamespace;
  protected String caCertFile;
  protected String caCertData;
  protected String clientCertFile;
  protected String clientCertData;
  protected String clientKeyFile;
  protected String clientKeyData;
  protected String clientKeyAlgo;
  protected String clientKeyPassphrase;
  protected String trustStoreFile;
  protected String trustStorePassphrase;
  protected String keyStoreFile;
  protected String keyStorePassphrase;
  protected AuthProviderConfig authProvider;
  protected String username;
  protected String password;
  protected volatile String oauthToken;
  @JsonIgnore
  protected volatile String autoOAuthToken;
  @JsonIgnore
  protected OAuthTokenProvider oauthTokenProvider;
  protected Long websocketPingInterval;
  protected Integer connectionTimeout;
  protected Integer maxConcurrentRequests;
  protected Integer maxConcurrentRequestsPerHost;

  protected List<NamedContext> contexts;
  protected NamedContext currentContext;

  protected Integer watchReconnectInterval;
  protected Integer watchReconnectLimit;
  protected Integer uploadRequestTimeout;
  protected Integer requestRetryBackoffLimit;
  protected Integer requestRetryBackoffInterval;
  protected Integer requestTimeout;
  protected Long scaleTimeout;
  protected Integer loggingInterval;
  protected String impersonateUsername;
  protected String[] impersonateGroups;
  protected Map<String, List<String>> impersonateExtras;

  protected Boolean http2Disable;
  protected String httpProxy;
  protected String httpsProxy;
  protected String proxyUsername;
  protected String proxyPassword;
  protected String[] noProxy;
  protected String userAgent;
  protected TlsVersion[] tlsVersions;

  protected Boolean onlyHttpWatches;

  protected Boolean watchList;

  /**
   * custom headers
   */
  protected Map<String, String> customHeaders;

  protected Boolean autoConfigure;

  @JsonIgnore
  protected Map<String, Object> additionalProperties = new HashMap<>();

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
