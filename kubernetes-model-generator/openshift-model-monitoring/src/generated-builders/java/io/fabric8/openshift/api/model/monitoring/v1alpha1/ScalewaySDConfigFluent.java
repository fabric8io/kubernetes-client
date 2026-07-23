package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigFluent;
import java.lang.Boolean;
import java.lang.Integer;
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
public class ScalewaySDConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.ScalewaySDConfigFluent<A>> extends BaseFluent<A>{

  private String accessKey;
  private Map<String,Object> additionalProperties;
  private String apiURL;
  private Boolean enableHTTP2;
  private Boolean followRedirects;
  private String nameFilter;
  private String noProxy;
  private Integer port;
  private String projectID;
  private Map<String,List<SecretKeySelector>> proxyConnectHeader;
  private Boolean proxyFromEnvironment;
  private String proxyUrl;
  private String refreshInterval;
  private String role;
  private SecretKeySelector secretKey;
  private List<String> tagsFilter = new ArrayList<String>();
  private SafeTLSConfigBuilder tlsConfig;
  private String zone;

  public ScalewaySDConfigFluent() {
  }
  
  public ScalewaySDConfigFluent(ScalewaySDConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToTagsFilter(Collection<String> items) {
    if (this.tagsFilter == null) {
      this.tagsFilter = new ArrayList();
    }
    for (String item : items) {
      this.tagsFilter.add(item);
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
  
  public A addToTagsFilter(String... items) {
    if (this.tagsFilter == null) {
      this.tagsFilter = new ArrayList();
    }
    for (String item : items) {
      this.tagsFilter.add(item);
    }
    return (A) this;
  }
  
  public A addToTagsFilter(int index,String item) {
    if (this.tagsFilter == null) {
      this.tagsFilter = new ArrayList();
    }
    this.tagsFilter.add(index, item);
    return (A) this;
  }
  
  public SafeTLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(ScalewaySDConfig instance) {
    instance = instance != null ? instance : new ScalewaySDConfig();
    if (instance != null) {
        this.withAccessKey(instance.getAccessKey());
        this.withApiURL(instance.getApiURL());
        this.withEnableHTTP2(instance.getEnableHTTP2());
        this.withFollowRedirects(instance.getFollowRedirects());
        this.withNameFilter(instance.getNameFilter());
        this.withNoProxy(instance.getNoProxy());
        this.withPort(instance.getPort());
        this.withProjectID(instance.getProjectID());
        this.withProxyConnectHeader(instance.getProxyConnectHeader());
        this.withProxyFromEnvironment(instance.getProxyFromEnvironment());
        this.withProxyUrl(instance.getProxyUrl());
        this.withRefreshInterval(instance.getRefreshInterval());
        this.withRole(instance.getRole());
        this.withSecretKey(instance.getSecretKey());
        this.withTagsFilter(instance.getTagsFilter());
        this.withTlsConfig(instance.getTlsConfig());
        this.withZone(instance.getZone());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ScalewaySDConfigFluent that = (ScalewaySDConfigFluent) o;
    if (!(Objects.equals(accessKey, that.accessKey))) {
      return false;
    }
    if (!(Objects.equals(apiURL, that.apiURL))) {
      return false;
    }
    if (!(Objects.equals(enableHTTP2, that.enableHTTP2))) {
      return false;
    }
    if (!(Objects.equals(followRedirects, that.followRedirects))) {
      return false;
    }
    if (!(Objects.equals(nameFilter, that.nameFilter))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(projectID, that.projectID))) {
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
    if (!(Objects.equals(role, that.role))) {
      return false;
    }
    if (!(Objects.equals(secretKey, that.secretKey))) {
      return false;
    }
    if (!(Objects.equals(tagsFilter, that.tagsFilter))) {
      return false;
    }
    if (!(Objects.equals(tlsConfig, that.tlsConfig))) {
      return false;
    }
    if (!(Objects.equals(zone, that.zone))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAccessKey() {
    return this.accessKey;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getApiURL() {
    return this.apiURL;
  }
  
  public Boolean getEnableHTTP2() {
    return this.enableHTTP2;
  }
  
  public String getFirstTagsFilter() {
    return this.tagsFilter.get(0);
  }
  
  public Boolean getFollowRedirects() {
    return this.followRedirects;
  }
  
  public String getLastTagsFilter() {
    return this.tagsFilter.get(tagsFilter.size() - 1);
  }
  
  public String getMatchingTagsFilter(Predicate<String> predicate) {
      for (String item : tagsFilter) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNameFilter() {
    return this.nameFilter;
  }
  
  public String getNoProxy() {
    return this.noProxy;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public String getProjectID() {
    return this.projectID;
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
  
  public String getRole() {
    return this.role;
  }
  
  public SecretKeySelector getSecretKey() {
    return this.secretKey;
  }
  
  public List<String> getTagsFilter() {
    return this.tagsFilter;
  }
  
  public String getTagsFilter(int index) {
    return this.tagsFilter.get(index);
  }
  
  public String getZone() {
    return this.zone;
  }
  
  public boolean hasAccessKey() {
    return this.accessKey != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiURL() {
    return this.apiURL != null;
  }
  
  public boolean hasEnableHTTP2() {
    return this.enableHTTP2 != null;
  }
  
  public boolean hasFollowRedirects() {
    return this.followRedirects != null;
  }
  
  public boolean hasMatchingTagsFilter(Predicate<String> predicate) {
      for (String item : tagsFilter) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNameFilter() {
    return this.nameFilter != null;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasProjectID() {
    return this.projectID != null;
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
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasSecretKey() {
    return this.secretKey != null;
  }
  
  public boolean hasTagsFilter() {
    return this.tagsFilter != null && !(this.tagsFilter.isEmpty());
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public boolean hasZone() {
    return this.zone != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessKey, apiURL, enableHTTP2, followRedirects, nameFilter, noProxy, port, projectID, proxyConnectHeader, proxyFromEnvironment, proxyUrl, refreshInterval, role, secretKey, tagsFilter, tlsConfig, zone, additionalProperties);
  }
  
  public A removeAllFromTagsFilter(Collection<String> items) {
    if (this.tagsFilter == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tagsFilter.remove(item);
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
  
  public A removeFromTagsFilter(String... items) {
    if (this.tagsFilter == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tagsFilter.remove(item);
    }
    return (A) this;
  }
  
  public A setToTagsFilter(int index,String item) {
    if (this.tagsFilter == null) {
      this.tagsFilter = new ArrayList();
    }
    this.tagsFilter.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(accessKey == null)) {
        sb.append("accessKey:");
        sb.append(accessKey);
        sb.append(",");
    }
    if (!(apiURL == null)) {
        sb.append("apiURL:");
        sb.append(apiURL);
        sb.append(",");
    }
    if (!(enableHTTP2 == null)) {
        sb.append("enableHTTP2:");
        sb.append(enableHTTP2);
        sb.append(",");
    }
    if (!(followRedirects == null)) {
        sb.append("followRedirects:");
        sb.append(followRedirects);
        sb.append(",");
    }
    if (!(nameFilter == null)) {
        sb.append("nameFilter:");
        sb.append(nameFilter);
        sb.append(",");
    }
    if (!(noProxy == null)) {
        sb.append("noProxy:");
        sb.append(noProxy);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(projectID == null)) {
        sb.append("projectID:");
        sb.append(projectID);
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
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
        sb.append(",");
    }
    if (!(secretKey == null)) {
        sb.append("secretKey:");
        sb.append(secretKey);
        sb.append(",");
    }
    if (!(tagsFilter == null) && !(tagsFilter.isEmpty())) {
        sb.append("tagsFilter:");
        sb.append(tagsFilter);
        sb.append(",");
    }
    if (!(tlsConfig == null)) {
        sb.append("tlsConfig:");
        sb.append(tlsConfig);
        sb.append(",");
    }
    if (!(zone == null)) {
        sb.append("zone:");
        sb.append(zone);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessKey(String accessKey) {
    this.accessKey = accessKey;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withApiURL(String apiURL) {
    this.apiURL = apiURL;
    return (A) this;
  }
  
  public A withEnableHTTP2() {
    return withEnableHTTP2(true);
  }
  
  public A withEnableHTTP2(Boolean enableHTTP2) {
    this.enableHTTP2 = enableHTTP2;
    return (A) this;
  }
  
  public A withFollowRedirects() {
    return withFollowRedirects(true);
  }
  
  public A withFollowRedirects(Boolean followRedirects) {
    this.followRedirects = followRedirects;
    return (A) this;
  }
  
  public A withNameFilter(String nameFilter) {
    this.nameFilter = nameFilter;
    return (A) this;
  }
  
  public A withNewSecretKey(String key,String name,Boolean optional) {
    return (A) this.withSecretKey(new SecretKeySelector(key, name, optional));
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(SafeTLSConfig item) {
    return new TlsConfigNested(item);
  }
  
  public A withNoProxy(String noProxy) {
    this.noProxy = noProxy;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withProjectID(String projectID) {
    this.projectID = projectID;
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
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  
  public A withSecretKey(SecretKeySelector secretKey) {
    this.secretKey = secretKey;
    return (A) this;
  }
  
  public A withTagsFilter(List<String> tagsFilter) {
    if (tagsFilter != null) {
        this.tagsFilter = new ArrayList();
        for (String item : tagsFilter) {
          this.addToTagsFilter(item);
        }
    } else {
      this.tagsFilter = null;
    }
    return (A) this;
  }
  
  public A withTagsFilter(String... tagsFilter) {
    if (this.tagsFilter != null) {
        this.tagsFilter.clear();
        _visitables.remove("tagsFilter");
    }
    if (tagsFilter != null) {
      for (String item : tagsFilter) {
        this.addToTagsFilter(item);
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
  
  public A withZone(String zone) {
    this.zone = zone;
    return (A) this;
  }
  public class TlsConfigNested<N> extends SafeTLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    SafeTLSConfigBuilder builder;
  
    TlsConfigNested(SafeTLSConfig item) {
      this.builder = new SafeTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScalewaySDConfigFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}