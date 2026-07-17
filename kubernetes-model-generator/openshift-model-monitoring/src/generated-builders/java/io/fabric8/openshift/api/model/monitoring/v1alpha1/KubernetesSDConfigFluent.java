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
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class KubernetesSDConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.KubernetesSDConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiServer;
  private AttachMetadataBuilder attachMetadata;
  private SafeAuthorizationBuilder authorization;
  private BasicAuthBuilder basicAuth;
  private Boolean enableHTTP2;
  private Boolean followRedirects;
  private NamespaceDiscoveryBuilder namespaces;
  private String noProxy;
  private OAuth2Builder oauth2;
  private Map<String,List<SecretKeySelector>> proxyConnectHeader;
  private Boolean proxyFromEnvironment;
  private String proxyUrl;
  private String role;
  private ArrayList<K8SSelectorConfigBuilder> selectors = new ArrayList<K8SSelectorConfigBuilder>();
  private SafeTLSConfigBuilder tlsConfig;

  public KubernetesSDConfigFluent() {
  }
  
  public KubernetesSDConfigFluent(KubernetesSDConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToSelectors(Collection<K8SSelectorConfig> items) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    for (K8SSelectorConfig item : items) {
        K8SSelectorConfigBuilder builder = new K8SSelectorConfigBuilder(item);
        _visitables.get("selectors").add(builder);
        this.selectors.add(builder);
    }
    return (A) this;
  }
  
  public SelectorsNested<A> addNewSelector() {
    return new SelectorsNested(-1, null);
  }
  
  public A addNewSelector(String field,String label,String role) {
    return (A) this.addToSelectors(new K8SSelectorConfig(field, label, role));
  }
  
  public SelectorsNested<A> addNewSelectorLike(K8SSelectorConfig item) {
    return new SelectorsNested(-1, item);
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
  
  public A addToSelectors(K8SSelectorConfig... items) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    for (K8SSelectorConfig item : items) {
        K8SSelectorConfigBuilder builder = new K8SSelectorConfigBuilder(item);
        _visitables.get("selectors").add(builder);
        this.selectors.add(builder);
    }
    return (A) this;
  }
  
  public A addToSelectors(int index,K8SSelectorConfig item) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    K8SSelectorConfigBuilder builder = new K8SSelectorConfigBuilder(item);
    if (index < 0 || index >= selectors.size()) {
        _visitables.get("selectors").add(builder);
        selectors.add(builder);
    } else {
        _visitables.get("selectors").add(builder);
        selectors.add(index, builder);
    }
    return (A) this;
  }
  
  public AttachMetadata buildAttachMetadata() {
    return this.attachMetadata != null ? this.attachMetadata.build() : null;
  }
  
  public SafeAuthorization buildAuthorization() {
    return this.authorization != null ? this.authorization.build() : null;
  }
  
  public BasicAuth buildBasicAuth() {
    return this.basicAuth != null ? this.basicAuth.build() : null;
  }
  
  public K8SSelectorConfig buildFirstSelector() {
    return this.selectors.get(0).build();
  }
  
  public K8SSelectorConfig buildLastSelector() {
    return this.selectors.get(selectors.size() - 1).build();
  }
  
  public K8SSelectorConfig buildMatchingSelector(Predicate<K8SSelectorConfigBuilder> predicate) {
      for (K8SSelectorConfigBuilder item : selectors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NamespaceDiscovery buildNamespaces() {
    return this.namespaces != null ? this.namespaces.build() : null;
  }
  
  public OAuth2 buildOauth2() {
    return this.oauth2 != null ? this.oauth2.build() : null;
  }
  
  public K8SSelectorConfig buildSelector(int index) {
    return this.selectors.get(index).build();
  }
  
  public List<K8SSelectorConfig> buildSelectors() {
    return this.selectors != null ? build(selectors) : null;
  }
  
  public SafeTLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(KubernetesSDConfig instance) {
    instance = instance != null ? instance : new KubernetesSDConfig();
    if (instance != null) {
        this.withApiServer(instance.getApiServer());
        this.withAttachMetadata(instance.getAttachMetadata());
        this.withAuthorization(instance.getAuthorization());
        this.withBasicAuth(instance.getBasicAuth());
        this.withEnableHTTP2(instance.getEnableHTTP2());
        this.withFollowRedirects(instance.getFollowRedirects());
        this.withNamespaces(instance.getNamespaces());
        this.withNoProxy(instance.getNoProxy());
        this.withOauth2(instance.getOauth2());
        this.withProxyConnectHeader(instance.getProxyConnectHeader());
        this.withProxyFromEnvironment(instance.getProxyFromEnvironment());
        this.withProxyUrl(instance.getProxyUrl());
        this.withRole(instance.getRole());
        this.withSelectors(instance.getSelectors());
        this.withTlsConfig(instance.getTlsConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AttachMetadataNested<A> editAttachMetadata() {
    return this.withNewAttachMetadataLike(Optional.ofNullable(this.buildAttachMetadata()).orElse(null));
  }
  
  public AuthorizationNested<A> editAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(null));
  }
  
  public BasicAuthNested<A> editBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(null));
  }
  
  public SelectorsNested<A> editFirstSelector() {
    if (selectors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "selectors"));
    }
    return this.setNewSelectorLike(0, this.buildSelector(0));
  }
  
  public SelectorsNested<A> editLastSelector() {
    int index = selectors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "selectors"));
    }
    return this.setNewSelectorLike(index, this.buildSelector(index));
  }
  
  public SelectorsNested<A> editMatchingSelector(Predicate<K8SSelectorConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < selectors.size();i++) {
      if (predicate.test(selectors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "selectors"));
    }
    return this.setNewSelectorLike(index, this.buildSelector(index));
  }
  
  public NamespacesNested<A> editNamespaces() {
    return this.withNewNamespacesLike(Optional.ofNullable(this.buildNamespaces()).orElse(null));
  }
  
  public Oauth2Nested<A> editOauth2() {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(null));
  }
  
  public AttachMetadataNested<A> editOrNewAttachMetadata() {
    return this.withNewAttachMetadataLike(Optional.ofNullable(this.buildAttachMetadata()).orElse(new AttachMetadataBuilder().build()));
  }
  
  public AttachMetadataNested<A> editOrNewAttachMetadataLike(AttachMetadata item) {
    return this.withNewAttachMetadataLike(Optional.ofNullable(this.buildAttachMetadata()).orElse(item));
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
  
  public NamespacesNested<A> editOrNewNamespaces() {
    return this.withNewNamespacesLike(Optional.ofNullable(this.buildNamespaces()).orElse(new NamespaceDiscoveryBuilder().build()));
  }
  
  public NamespacesNested<A> editOrNewNamespacesLike(NamespaceDiscovery item) {
    return this.withNewNamespacesLike(Optional.ofNullable(this.buildNamespaces()).orElse(item));
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
  
  public SelectorsNested<A> editSelector(int index) {
    if (selectors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "selectors"));
    }
    return this.setNewSelectorLike(index, this.buildSelector(index));
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
    KubernetesSDConfigFluent that = (KubernetesSDConfigFluent) o;
    if (!(Objects.equals(apiServer, that.apiServer))) {
      return false;
    }
    if (!(Objects.equals(attachMetadata, that.attachMetadata))) {
      return false;
    }
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(basicAuth, that.basicAuth))) {
      return false;
    }
    if (!(Objects.equals(enableHTTP2, that.enableHTTP2))) {
      return false;
    }
    if (!(Objects.equals(followRedirects, that.followRedirects))) {
      return false;
    }
    if (!(Objects.equals(namespaces, that.namespaces))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(oauth2, that.oauth2))) {
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
    if (!(Objects.equals(role, that.role))) {
      return false;
    }
    if (!(Objects.equals(selectors, that.selectors))) {
      return false;
    }
    if (!(Objects.equals(tlsConfig, that.tlsConfig))) {
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
  
  public String getApiServer() {
    return this.apiServer;
  }
  
  public Boolean getEnableHTTP2() {
    return this.enableHTTP2;
  }
  
  public Boolean getFollowRedirects() {
    return this.followRedirects;
  }
  
  public String getNoProxy() {
    return this.noProxy;
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
  
  public String getRole() {
    return this.role;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiServer() {
    return this.apiServer != null;
  }
  
  public boolean hasAttachMetadata() {
    return this.attachMetadata != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasBasicAuth() {
    return this.basicAuth != null;
  }
  
  public boolean hasEnableHTTP2() {
    return this.enableHTTP2 != null;
  }
  
  public boolean hasFollowRedirects() {
    return this.followRedirects != null;
  }
  
  public boolean hasMatchingSelector(Predicate<K8SSelectorConfigBuilder> predicate) {
      for (K8SSelectorConfigBuilder item : selectors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaces() {
    return this.namespaces != null;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public boolean hasOauth2() {
    return this.oauth2 != null;
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
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasSelectors() {
    return this.selectors != null && !(this.selectors.isEmpty());
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiServer, attachMetadata, authorization, basicAuth, enableHTTP2, followRedirects, namespaces, noProxy, oauth2, proxyConnectHeader, proxyFromEnvironment, proxyUrl, role, selectors, tlsConfig, additionalProperties);
  }
  
  public A removeAllFromSelectors(Collection<K8SSelectorConfig> items) {
    if (this.selectors == null) {
      return (A) this;
    }
    for (K8SSelectorConfig item : items) {
        K8SSelectorConfigBuilder builder = new K8SSelectorConfigBuilder(item);
        _visitables.get("selectors").remove(builder);
        this.selectors.remove(builder);
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
  
  public A removeFromSelectors(K8SSelectorConfig... items) {
    if (this.selectors == null) {
      return (A) this;
    }
    for (K8SSelectorConfig item : items) {
        K8SSelectorConfigBuilder builder = new K8SSelectorConfigBuilder(item);
        _visitables.get("selectors").remove(builder);
        this.selectors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSelectors(Predicate<K8SSelectorConfigBuilder> predicate) {
    if (selectors == null) {
      return (A) this;
    }
    Iterator<K8SSelectorConfigBuilder> each = selectors.iterator();
    List visitables = _visitables.get("selectors");
    while (each.hasNext()) {
        K8SSelectorConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SelectorsNested<A> setNewSelectorLike(int index,K8SSelectorConfig item) {
    return new SelectorsNested(index, item);
  }
  
  public A setToSelectors(int index,K8SSelectorConfig item) {
    if (this.selectors == null) {
      this.selectors = new ArrayList();
    }
    K8SSelectorConfigBuilder builder = new K8SSelectorConfigBuilder(item);
    if (index < 0 || index >= selectors.size()) {
        _visitables.get("selectors").add(builder);
        selectors.add(builder);
    } else {
        _visitables.get("selectors").add(builder);
        selectors.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiServer == null)) {
        sb.append("apiServer:");
        sb.append(apiServer);
        sb.append(",");
    }
    if (!(attachMetadata == null)) {
        sb.append("attachMetadata:");
        sb.append(attachMetadata);
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
    if (!(namespaces == null)) {
        sb.append("namespaces:");
        sb.append(namespaces);
        sb.append(",");
    }
    if (!(noProxy == null)) {
        sb.append("noProxy:");
        sb.append(noProxy);
        sb.append(",");
    }
    if (!(oauth2 == null)) {
        sb.append("oauth2:");
        sb.append(oauth2);
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
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
        sb.append(",");
    }
    if (!(selectors == null) && !(selectors.isEmpty())) {
        sb.append("selectors:");
        sb.append(selectors);
        sb.append(",");
    }
    if (!(tlsConfig == null)) {
        sb.append("tlsConfig:");
        sb.append(tlsConfig);
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
  
  public A withApiServer(String apiServer) {
    this.apiServer = apiServer;
    return (A) this;
  }
  
  public A withAttachMetadata(AttachMetadata attachMetadata) {
    this._visitables.remove("attachMetadata");
    if (attachMetadata != null) {
        this.attachMetadata = new AttachMetadataBuilder(attachMetadata);
        this._visitables.get("attachMetadata").add(this.attachMetadata);
    } else {
        this.attachMetadata = null;
        this._visitables.get("attachMetadata").remove(this.attachMetadata);
    }
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
  
  public A withNamespaces(NamespaceDiscovery namespaces) {
    this._visitables.remove("namespaces");
    if (namespaces != null) {
        this.namespaces = new NamespaceDiscoveryBuilder(namespaces);
        this._visitables.get("namespaces").add(this.namespaces);
    } else {
        this.namespaces = null;
        this._visitables.get("namespaces").remove(this.namespaces);
    }
    return (A) this;
  }
  
  public AttachMetadataNested<A> withNewAttachMetadata() {
    return new AttachMetadataNested(null);
  }
  
  public A withNewAttachMetadata(Boolean node) {
    return (A) this.withAttachMetadata(new AttachMetadata(node));
  }
  
  public AttachMetadataNested<A> withNewAttachMetadataLike(AttachMetadata item) {
    return new AttachMetadataNested(item);
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
  
  public NamespacesNested<A> withNewNamespaces() {
    return new NamespacesNested(null);
  }
  
  public NamespacesNested<A> withNewNamespacesLike(NamespaceDiscovery item) {
    return new NamespacesNested(item);
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
  
  public A withNoProxy(String noProxy) {
    this.noProxy = noProxy;
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
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  
  public A withSelectors(List<K8SSelectorConfig> selectors) {
    if (this.selectors != null) {
      this._visitables.get("selectors").clear();
    }
    if (selectors != null) {
        this.selectors = new ArrayList();
        for (K8SSelectorConfig item : selectors) {
          this.addToSelectors(item);
        }
    } else {
      this.selectors = null;
    }
    return (A) this;
  }
  
  public A withSelectors(K8SSelectorConfig... selectors) {
    if (this.selectors != null) {
        this.selectors.clear();
        _visitables.remove("selectors");
    }
    if (selectors != null) {
      for (K8SSelectorConfig item : selectors) {
        this.addToSelectors(item);
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
  public class AttachMetadataNested<N> extends AttachMetadataFluent<AttachMetadataNested<N>> implements Nested<N>{
  
    AttachMetadataBuilder builder;
  
    AttachMetadataNested(AttachMetadata item) {
      this.builder = new AttachMetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesSDConfigFluent.this.withAttachMetadata(builder.build());
    }
    
    public N endAttachMetadata() {
      return and();
    }
    
  }
  public class AuthorizationNested<N> extends SafeAuthorizationFluent<AuthorizationNested<N>> implements Nested<N>{
  
    SafeAuthorizationBuilder builder;
  
    AuthorizationNested(SafeAuthorization item) {
      this.builder = new SafeAuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesSDConfigFluent.this.withAuthorization(builder.build());
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
      return (N) KubernetesSDConfigFluent.this.withBasicAuth(builder.build());
    }
    
    public N endBasicAuth() {
      return and();
    }
    
  }
  public class NamespacesNested<N> extends NamespaceDiscoveryFluent<NamespacesNested<N>> implements Nested<N>{
  
    NamespaceDiscoveryBuilder builder;
  
    NamespacesNested(NamespaceDiscovery item) {
      this.builder = new NamespaceDiscoveryBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesSDConfigFluent.this.withNamespaces(builder.build());
    }
    
    public N endNamespaces() {
      return and();
    }
    
  }
  public class Oauth2Nested<N> extends OAuth2Fluent<Oauth2Nested<N>> implements Nested<N>{
  
    OAuth2Builder builder;
  
    Oauth2Nested(OAuth2 item) {
      this.builder = new OAuth2Builder(this, item);
    }
  
    public N and() {
      return (N) KubernetesSDConfigFluent.this.withOauth2(builder.build());
    }
    
    public N endOauth2() {
      return and();
    }
    
  }
  public class SelectorsNested<N> extends K8SSelectorConfigFluent<SelectorsNested<N>> implements Nested<N>{
  
    K8SSelectorConfigBuilder builder;
    int index;
  
    SelectorsNested(int index,K8SSelectorConfig item) {
      this.index = index;
      this.builder = new K8SSelectorConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesSDConfigFluent.this.setToSelectors(index, builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class TlsConfigNested<N> extends SafeTLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    SafeTLSConfigBuilder builder;
  
    TlsConfigNested(SafeTLSConfig item) {
      this.builder = new SafeTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesSDConfigFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}