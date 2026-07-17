package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuth;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuthBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuthFluent;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2Builder;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2Fluent;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorization;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorizationBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorizationFluent;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigFluent;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ConsulSDConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.ConsulSDConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allowStale;
  private SafeAuthorizationBuilder authorization;
  private BasicAuthBuilder basicAuth;
  private String datacenter;
  private Boolean enableHTTP2;
  private String filter;
  private Boolean followRedirects;
  private String healthFilter;
  private String namespace;
  private String noProxy;
  private Map<String,String> nodeMeta;
  private OAuth2Builder oauth2;
  private String partition;
  private String pathPrefix;
  private Map<String,List<SecretKeySelector>> proxyConnectHeader;
  private Boolean proxyFromEnvironment;
  private String proxyUrl;
  private String refreshInterval;
  private String scheme;
  private String server;
  private List<String> services = new ArrayList<String>();
  private String tagSeparator;
  private List<String> tags = new ArrayList<String>();
  private SafeTLSConfigBuilder tlsConfig;
  private SecretKeySelector tokenRef;

  public ConsulSDConfigFluent() {
  }
  
  public ConsulSDConfigFluent(ConsulSDConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToServices(Collection<String> items) {
    if (this.services == null) {
      this.services = new ArrayList();
    }
    for (String item : items) {
      this.services.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTags(Collection<String> items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToNodeMeta(Map<String,String> map) {
    if (this.nodeMeta == null && map != null) {
      this.nodeMeta = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeMeta.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeMeta(String key,String value) {
    if (this.nodeMeta == null && key != null && value != null) {
      this.nodeMeta = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeMeta.put(key, value);
    }
    return (A) this;
  }
  
  public A addToProxyConnectHeader(Map<String,List<SecretKeySelector>> map) {
    if (this.proxyConnectHeader == null && map != null) {
      this.proxyConnectHeader = new LinkedHashMap();
    }
    if (map != null) {
      this.proxyConnectHeader.putAll(map);
    }
    return (A) this;
  }
  
  public A addToProxyConnectHeader(String key,List<SecretKeySelector> value) {
    if (this.proxyConnectHeader == null && key != null && value != null) {
      this.proxyConnectHeader = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.proxyConnectHeader.put(key, value);
    }
    return (A) this;
  }
  
  public A addToServices(String... items) {
    if (this.services == null) {
      this.services = new ArrayList();
    }
    for (String item : items) {
      this.services.add(item);
    }
    return (A) this;
  }
  
  public A addToServices(int index,String item) {
    if (this.services == null) {
      this.services = new ArrayList();
    }
    this.services.add(index, item);
    return (A) this;
  }
  
  public A addToTags(String... items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
    }
    return (A) this;
  }
  
  public A addToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.add(index, item);
    return (A) this;
  }
  
  public SafeAuthorization buildAuthorization() {
    return this.authorization != null ? this.authorization.build() : null;
  }
  
  public BasicAuth buildBasicAuth() {
    return this.basicAuth != null ? this.basicAuth.build() : null;
  }
  
  public OAuth2 buildOauth2() {
    return this.oauth2 != null ? this.oauth2.build() : null;
  }
  
  public SafeTLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(ConsulSDConfig instance) {
    instance = instance != null ? instance : new ConsulSDConfig();
    if (instance != null) {
        this.withAllowStale(instance.getAllowStale());
        this.withAuthorization(instance.getAuthorization());
        this.withBasicAuth(instance.getBasicAuth());
        this.withDatacenter(instance.getDatacenter());
        this.withEnableHTTP2(instance.getEnableHTTP2());
        this.withFilter(instance.getFilter());
        this.withFollowRedirects(instance.getFollowRedirects());
        this.withHealthFilter(instance.getHealthFilter());
        this.withNamespace(instance.getNamespace());
        this.withNoProxy(instance.getNoProxy());
        this.withNodeMeta(instance.getNodeMeta());
        this.withOauth2(instance.getOauth2());
        this.withPartition(instance.getPartition());
        this.withPathPrefix(instance.getPathPrefix());
        this.withProxyConnectHeader(instance.getProxyConnectHeader());
        this.withProxyFromEnvironment(instance.getProxyFromEnvironment());
        this.withProxyUrl(instance.getProxyUrl());
        this.withRefreshInterval(instance.getRefreshInterval());
        this.withScheme(instance.getScheme());
        this.withServer(instance.getServer());
        this.withServices(instance.getServices());
        this.withTagSeparator(instance.getTagSeparator());
        this.withTags(instance.getTags());
        this.withTlsConfig(instance.getTlsConfig());
        this.withTokenRef(instance.getTokenRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthorizationNested<A> editAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(null));
  }
  
  public BasicAuthNested<A> editBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(null));
  }
  
  public Oauth2Nested<A> editOauth2() {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(null));
  }
  
  public AuthorizationNested<A> editOrNewAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(new SafeAuthorizationBuilder().build()));
  }
  
  public AuthorizationNested<A> editOrNewAuthorizationLike(SafeAuthorization item) {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(item));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(new BasicAuthBuilder().build()));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuthLike(BasicAuth item) {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(item));
  }
  
  public Oauth2Nested<A> editOrNewOauth2() {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(new OAuth2Builder().build()));
  }
  
  public Oauth2Nested<A> editOrNewOauth2Like(OAuth2 item) {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(item));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(new SafeTLSConfigBuilder().build()));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfigLike(SafeTLSConfig item) {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(item));
  }
  
  public TlsConfigNested<A> editTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    ConsulSDConfigFluent that = (ConsulSDConfigFluent) o;
    if (!(Objects.equals(allowStale, that.allowStale))) {
      return false;
    }
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(basicAuth, that.basicAuth))) {
      return false;
    }
    if (!(Objects.equals(datacenter, that.datacenter))) {
      return false;
    }
    if (!(Objects.equals(enableHTTP2, that.enableHTTP2))) {
      return false;
    }
    if (!(Objects.equals(filter, that.filter))) {
      return false;
    }
    if (!(Objects.equals(followRedirects, that.followRedirects))) {
      return false;
    }
    if (!(Objects.equals(healthFilter, that.healthFilter))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(nodeMeta, that.nodeMeta))) {
      return false;
    }
    if (!(Objects.equals(oauth2, that.oauth2))) {
      return false;
    }
    if (!(Objects.equals(partition, that.partition))) {
      return false;
    }
    if (!(Objects.equals(pathPrefix, that.pathPrefix))) {
      return false;
    }
    if (!(Objects.equals(proxyConnectHeader, that.proxyConnectHeader))) {
      return false;
    }
    if (!(Objects.equals(proxyFromEnvironment, that.proxyFromEnvironment))) {
      return false;
    }
    if (!(Objects.equals(proxyUrl, that.proxyUrl))) {
      return false;
    }
    if (!(Objects.equals(refreshInterval, that.refreshInterval))) {
      return false;
    }
    if (!(Objects.equals(scheme, that.scheme))) {
      return false;
    }
    if (!(Objects.equals(server, that.server))) {
      return false;
    }
    if (!(Objects.equals(services, that.services))) {
      return false;
    }
    if (!(Objects.equals(tagSeparator, that.tagSeparator))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
      return false;
    }
    if (!(Objects.equals(tlsConfig, that.tlsConfig))) {
      return false;
    }
    if (!(Objects.equals(tokenRef, that.tokenRef))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Boolean getAllowStale() {
    return this.allowStale;
  }
  
  public String getDatacenter() {
    return this.datacenter;
  }
  
  public Boolean getEnableHTTP2() {
    return this.enableHTTP2;
  }
  
  public String getFilter() {
    return this.filter;
  }
  
  public String getFirstService() {
    return this.services.get(0);
  }
  
  public String getFirstTag() {
    return this.tags.get(0);
  }
  
  public Boolean getFollowRedirects() {
    return this.followRedirects;
  }
  
  public String getHealthFilter() {
    return this.healthFilter;
  }
  
  public String getLastService() {
    return this.services.get(services.size() - 1);
  }
  
  public String getLastTag() {
    return this.tags.get(tags.size() - 1);
  }
  
  public String getMatchingService(Predicate<String> predicate) {
      for (String item : services) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getNoProxy() {
    return this.noProxy;
  }
  
  public Map<String,String> getNodeMeta() {
    return this.nodeMeta;
  }
  
  public String getPartition() {
    return this.partition;
  }
  
  public String getPathPrefix() {
    return this.pathPrefix;
  }
  
  public Map<String,List<SecretKeySelector>> getProxyConnectHeader() {
    return this.proxyConnectHeader;
  }
  
  public Boolean getProxyFromEnvironment() {
    return this.proxyFromEnvironment;
  }
  
  public String getProxyUrl() {
    return this.proxyUrl;
  }
  
  public String getRefreshInterval() {
    return this.refreshInterval;
  }
  
  public String getScheme() {
    return this.scheme;
  }
  
  public String getServer() {
    return this.server;
  }
  
  public String getService(int index) {
    return this.services.get(index);
  }
  
  public List<String> getServices() {
    return this.services;
  }
  
  public String getTag(int index) {
    return this.tags.get(index);
  }
  
  public String getTagSeparator() {
    return this.tagSeparator;
  }
  
  public List<String> getTags() {
    return this.tags;
  }
  
  public SecretKeySelector getTokenRef() {
    return this.tokenRef;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowStale() {
    return this.allowStale != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasBasicAuth() {
    return this.basicAuth != null;
  }
  
  public boolean hasDatacenter() {
    return this.datacenter != null;
  }
  
  public boolean hasEnableHTTP2() {
    return this.enableHTTP2 != null;
  }
  
  public boolean hasFilter() {
    return this.filter != null;
  }
  
  public boolean hasFollowRedirects() {
    return this.followRedirects != null;
  }
  
  public boolean hasHealthFilter() {
    return this.healthFilter != null;
  }
  
  public boolean hasMatchingService(Predicate<String> predicate) {
      for (String item : services) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public boolean hasNodeMeta() {
    return this.nodeMeta != null;
  }
  
  public boolean hasOauth2() {
    return this.oauth2 != null;
  }
  
  public boolean hasPartition() {
    return this.partition != null;
  }
  
  public boolean hasPathPrefix() {
    return this.pathPrefix != null;
  }
  
  public boolean hasProxyConnectHeader() {
    return this.proxyConnectHeader != null;
  }
  
  public boolean hasProxyFromEnvironment() {
    return this.proxyFromEnvironment != null;
  }
  
  public boolean hasProxyUrl() {
    return this.proxyUrl != null;
  }
  
  public boolean hasRefreshInterval() {
    return this.refreshInterval != null;
  }
  
  public boolean hasScheme() {
    return this.scheme != null;
  }
  
  public boolean hasServer() {
    return this.server != null;
  }
  
  public boolean hasServices() {
    return this.services != null && !(this.services.isEmpty());
  }
  
  public boolean hasTagSeparator() {
    return this.tagSeparator != null;
  }
  
  public boolean hasTags() {
    return this.tags != null && !(this.tags.isEmpty());
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public boolean hasTokenRef() {
    return this.tokenRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(allowStale, authorization, basicAuth, datacenter, enableHTTP2, filter, followRedirects, healthFilter, namespace, noProxy, nodeMeta, oauth2, partition, pathPrefix, proxyConnectHeader, proxyFromEnvironment, proxyUrl, refreshInterval, scheme, server, services, tagSeparator, tags, tlsConfig, tokenRef, additionalProperties);
  }
  
  public A removeAllFromServices(Collection<String> items) {
    if (this.services == null) {
      return (A) this;
    }
    for (String item : items) {
      this.services.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTags(Collection<String> items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromNodeMeta(String key) {
    if (this.nodeMeta == null) {
      return (A) this;
    }
    if (key != null && this.nodeMeta != null) {
      this.nodeMeta.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeMeta(Map<String,String> map) {
    if (this.nodeMeta == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeMeta != null) {
          this.nodeMeta.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromProxyConnectHeader(String key) {
    if (this.proxyConnectHeader == null) {
      return (A) this;
    }
    if (key != null && this.proxyConnectHeader != null) {
      this.proxyConnectHeader.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromProxyConnectHeader(Map<String,List<SecretKeySelector>> map) {
    if (this.proxyConnectHeader == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.proxyConnectHeader != null) {
          this.proxyConnectHeader.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromServices(String... items) {
    if (this.services == null) {
      return (A) this;
    }
    for (String item : items) {
      this.services.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTags(String... items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
    }
    return (A) this;
  }
  
  public A setToServices(int index,String item) {
    if (this.services == null) {
      this.services = new ArrayList();
    }
    this.services.set(index, item);
    return (A) this;
  }
  
  public A setToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowStale == null)) {
        sb.append("allowStale:");
        sb.append(allowStale);
        sb.append(",");
    }
    if (!(authorization == null)) {
        sb.append("authorization:");
        sb.append(authorization);
        sb.append(",");
    }
    if (!(basicAuth == null)) {
        sb.append("basicAuth:");
        sb.append(basicAuth);
        sb.append(",");
    }
    if (!(datacenter == null)) {
        sb.append("datacenter:");
        sb.append(datacenter);
        sb.append(",");
    }
    if (!(enableHTTP2 == null)) {
        sb.append("enableHTTP2:");
        sb.append(enableHTTP2);
        sb.append(",");
    }
    if (!(filter == null)) {
        sb.append("filter:");
        sb.append(filter);
        sb.append(",");
    }
    if (!(followRedirects == null)) {
        sb.append("followRedirects:");
        sb.append(followRedirects);
        sb.append(",");
    }
    if (!(healthFilter == null)) {
        sb.append("healthFilter:");
        sb.append(healthFilter);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(noProxy == null)) {
        sb.append("noProxy:");
        sb.append(noProxy);
        sb.append(",");
    }
    if (!(nodeMeta == null) && !(nodeMeta.isEmpty())) {
        sb.append("nodeMeta:");
        sb.append(nodeMeta);
        sb.append(",");
    }
    if (!(oauth2 == null)) {
        sb.append("oauth2:");
        sb.append(oauth2);
        sb.append(",");
    }
    if (!(partition == null)) {
        sb.append("partition:");
        sb.append(partition);
        sb.append(",");
    }
    if (!(pathPrefix == null)) {
        sb.append("pathPrefix:");
        sb.append(pathPrefix);
        sb.append(",");
    }
    if (!(proxyConnectHeader == null) && !(proxyConnectHeader.isEmpty())) {
        sb.append("proxyConnectHeader:");
        sb.append(proxyConnectHeader);
        sb.append(",");
    }
    if (!(proxyFromEnvironment == null)) {
        sb.append("proxyFromEnvironment:");
        sb.append(proxyFromEnvironment);
        sb.append(",");
    }
    if (!(proxyUrl == null)) {
        sb.append("proxyUrl:");
        sb.append(proxyUrl);
        sb.append(",");
    }
    if (!(refreshInterval == null)) {
        sb.append("refreshInterval:");
        sb.append(refreshInterval);
        sb.append(",");
    }
    if (!(scheme == null)) {
        sb.append("scheme:");
        sb.append(scheme);
        sb.append(",");
    }
    if (!(server == null)) {
        sb.append("server:");
        sb.append(server);
        sb.append(",");
    }
    if (!(services == null) && !(services.isEmpty())) {
        sb.append("services:");
        sb.append(services);
        sb.append(",");
    }
    if (!(tagSeparator == null)) {
        sb.append("tagSeparator:");
        sb.append(tagSeparator);
        sb.append(",");
    }
    if (!(tags == null) && !(tags.isEmpty())) {
        sb.append("tags:");
        sb.append(tags);
        sb.append(",");
    }
    if (!(tlsConfig == null)) {
        sb.append("tlsConfig:");
        sb.append(tlsConfig);
        sb.append(",");
    }
    if (!(tokenRef == null)) {
        sb.append("tokenRef:");
        sb.append(tokenRef);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAllowStale() {
    return withAllowStale(true);
  }
  
  public A withAllowStale(Boolean allowStale) {
    this.allowStale = allowStale;
    return (A) this;
  }
  
  public A withAuthorization(SafeAuthorization authorization) {
    this._visitables.remove("authorization");
    if (authorization != null) {
        this.authorization = new SafeAuthorizationBuilder(authorization);
        this._visitables.get("authorization").add(this.authorization);
    } else {
        this.authorization = null;
        this._visitables.get("authorization").remove(this.authorization);
    }
    return (A) this;
  }
  
  public A withBasicAuth(BasicAuth basicAuth) {
    this._visitables.remove("basicAuth");
    if (basicAuth != null) {
        this.basicAuth = new BasicAuthBuilder(basicAuth);
        this._visitables.get("basicAuth").add(this.basicAuth);
    } else {
        this.basicAuth = null;
        this._visitables.get("basicAuth").remove(this.basicAuth);
    }
    return (A) this;
  }
  
  public A withDatacenter(String datacenter) {
    this.datacenter = datacenter;
    return (A) this;
  }
  
  public A withEnableHTTP2() {
    return withEnableHTTP2(true);
  }
  
  public A withEnableHTTP2(Boolean enableHTTP2) {
    this.enableHTTP2 = enableHTTP2;
    return (A) this;
  }
  
  public A withFilter(String filter) {
    this.filter = filter;
    return (A) this;
  }
  
  public A withFollowRedirects() {
    return withFollowRedirects(true);
  }
  
  public A withFollowRedirects(Boolean followRedirects) {
    this.followRedirects = followRedirects;
    return (A) this;
  }
  
  public A withHealthFilter(String healthFilter) {
    this.healthFilter = healthFilter;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public AuthorizationNested<A> withNewAuthorization() {
    return new AuthorizationNested(null);
  }
  
  public AuthorizationNested<A> withNewAuthorizationLike(SafeAuthorization item) {
    return new AuthorizationNested(item);
  }
  
  public BasicAuthNested<A> withNewBasicAuth() {
    return new BasicAuthNested(null);
  }
  
  public BasicAuthNested<A> withNewBasicAuthLike(BasicAuth item) {
    return new BasicAuthNested(item);
  }
  
  public Oauth2Nested<A> withNewOauth2() {
    return new Oauth2Nested(null);
  }
  
  public Oauth2Nested<A> withNewOauth2Like(OAuth2 item) {
    return new Oauth2Nested(item);
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(SafeTLSConfig item) {
    return new TlsConfigNested(item);
  }
  
  public A withNewTokenRef(String key,String name,Boolean optional) {
    return (A) this.withTokenRef(new SecretKeySelector(key, name, optional));
  }
  
  public A withNoProxy(String noProxy) {
    this.noProxy = noProxy;
    return (A) this;
  }
  
  public <K,V>A withNodeMeta(Map<String,String> nodeMeta) {
    if (nodeMeta == null) {
      this.nodeMeta = null;
    } else {
      this.nodeMeta = new LinkedHashMap(nodeMeta);
    }
    return (A) this;
  }
  
  public A withOauth2(OAuth2 oauth2) {
    this._visitables.remove("oauth2");
    if (oauth2 != null) {
        this.oauth2 = new OAuth2Builder(oauth2);
        this._visitables.get("oauth2").add(this.oauth2);
    } else {
        this.oauth2 = null;
        this._visitables.get("oauth2").remove(this.oauth2);
    }
    return (A) this;
  }
  
  public A withPartition(String partition) {
    this.partition = partition;
    return (A) this;
  }
  
  public A withPathPrefix(String pathPrefix) {
    this.pathPrefix = pathPrefix;
    return (A) this;
  }
  
  public <K,V>A withProxyConnectHeader(Map<String,List<SecretKeySelector>> proxyConnectHeader) {
    if (proxyConnectHeader == null) {
      this.proxyConnectHeader = null;
    } else {
      this.proxyConnectHeader = new LinkedHashMap(proxyConnectHeader);
    }
    return (A) this;
  }
  
  public A withProxyFromEnvironment() {
    return withProxyFromEnvironment(true);
  }
  
  public A withProxyFromEnvironment(Boolean proxyFromEnvironment) {
    this.proxyFromEnvironment = proxyFromEnvironment;
    return (A) this;
  }
  
  public A withProxyUrl(String proxyUrl) {
    this.proxyUrl = proxyUrl;
    return (A) this;
  }
  
  public A withRefreshInterval(String refreshInterval) {
    this.refreshInterval = refreshInterval;
    return (A) this;
  }
  
  public A withScheme(String scheme) {
    this.scheme = scheme;
    return (A) this;
  }
  
  public A withServer(String server) {
    this.server = server;
    return (A) this;
  }
  
  public A withServices(List<String> services) {
    if (services != null) {
        this.services = new ArrayList();
        for (String item : services) {
          this.addToServices(item);
        }
    } else {
      this.services = null;
    }
    return (A) this;
  }
  
  public A withServices(String... services) {
    if (this.services != null) {
        this.services.clear();
        _visitables.remove("services");
    }
    if (services != null) {
      for (String item : services) {
        this.addToServices(item);
      }
    }
    return (A) this;
  }
  
  public A withTagSeparator(String tagSeparator) {
    this.tagSeparator = tagSeparator;
    return (A) this;
  }
  
  public A withTags(List<String> tags) {
    if (tags != null) {
        this.tags = new ArrayList();
        for (String item : tags) {
          this.addToTags(item);
        }
    } else {
      this.tags = null;
    }
    return (A) this;
  }
  
  public A withTags(String... tags) {
    if (this.tags != null) {
        this.tags.clear();
        _visitables.remove("tags");
    }
    if (tags != null) {
      for (String item : tags) {
        this.addToTags(item);
      }
    }
    return (A) this;
  }
  
  public A withTlsConfig(SafeTLSConfig tlsConfig) {
    this._visitables.remove("tlsConfig");
    if (tlsConfig != null) {
        this.tlsConfig = new SafeTLSConfigBuilder(tlsConfig);
        this._visitables.get("tlsConfig").add(this.tlsConfig);
    } else {
        this.tlsConfig = null;
        this._visitables.get("tlsConfig").remove(this.tlsConfig);
    }
    return (A) this;
  }
  
  public A withTokenRef(SecretKeySelector tokenRef) {
    this.tokenRef = tokenRef;
    return (A) this;
  }
  public class AuthorizationNested<N> extends SafeAuthorizationFluent<AuthorizationNested<N>> implements Nested<N>{
  
    SafeAuthorizationBuilder builder;
  
    AuthorizationNested(SafeAuthorization item) {
      this.builder = new SafeAuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsulSDConfigFluent.this.withAuthorization(builder.build());
    }
    
    public N endAuthorization() {
      return and();
    }
    
  }
  public class BasicAuthNested<N> extends BasicAuthFluent<BasicAuthNested<N>> implements Nested<N>{
  
    BasicAuthBuilder builder;
  
    BasicAuthNested(BasicAuth item) {
      this.builder = new BasicAuthBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsulSDConfigFluent.this.withBasicAuth(builder.build());
    }
    
    public N endBasicAuth() {
      return and();
    }
    
  }
  public class Oauth2Nested<N> extends OAuth2Fluent<Oauth2Nested<N>> implements Nested<N>{
  
    OAuth2Builder builder;
  
    Oauth2Nested(OAuth2 item) {
      this.builder = new OAuth2Builder(this, item);
    }
  
    public N and() {
      return (N) ConsulSDConfigFluent.this.withOauth2(builder.build());
    }
    
    public N endOauth2() {
      return and();
    }
    
  }
  public class TlsConfigNested<N> extends SafeTLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    SafeTLSConfigBuilder builder;
  
    TlsConfigNested(SafeTLSConfig item) {
      this.builder = new SafeTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsulSDConfigFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}