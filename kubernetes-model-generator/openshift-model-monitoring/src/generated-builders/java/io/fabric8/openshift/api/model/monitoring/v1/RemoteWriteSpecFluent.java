package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import java.lang.Boolean;
import java.lang.Integer;
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
public class RemoteWriteSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.RemoteWriteSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AuthorizationBuilder authorization;
  private AzureADBuilder azureAd;
  private BasicAuthBuilder basicAuth;
  private String bearerToken;
  private String bearerTokenFile;
  private Boolean enableHTTP2;
  private Boolean followRedirects;
  private Map<String,String> headers;
  private String messageVersion;
  private MetadataConfigBuilder metadataConfig;
  private String name;
  private String noProxy;
  private OAuth2Builder oauth2;
  private Map<String,List<SecretKeySelector>> proxyConnectHeader;
  private Boolean proxyFromEnvironment;
  private String proxyUrl;
  private QueueConfigBuilder queueConfig;
  private String remoteTimeout;
  private Boolean roundRobinDNS;
  private Boolean sendExemplars;
  private Boolean sendNativeHistograms;
  private Sigv4Builder sigv4;
  private TLSConfigBuilder tlsConfig;
  private String url;
  private ArrayList<RelabelConfigBuilder> writeRelabelConfigs = new ArrayList<RelabelConfigBuilder>();

  public RemoteWriteSpecFluent() {
  }
  
  public RemoteWriteSpecFluent(RemoteWriteSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToWriteRelabelConfigs(Collection<RelabelConfig> items) {
    if (this.writeRelabelConfigs == null) {
      this.writeRelabelConfigs = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("writeRelabelConfigs").add(builder);
        this.writeRelabelConfigs.add(builder);
    }
    return (A) this;
  }
  
  public WriteRelabelConfigsNested<A> addNewWriteRelabelConfig() {
    return new WriteRelabelConfigsNested(-1, null);
  }
  
  public WriteRelabelConfigsNested<A> addNewWriteRelabelConfigLike(RelabelConfig item) {
    return new WriteRelabelConfigsNested(-1, item);
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
  
  public A addToHeaders(Map<String,String> map) {
    if (this.headers == null && map != null) {
      this.headers = new LinkedHashMap();
    }
    if (map != null) {
      this.headers.putAll(map);
    }
    return (A) this;
  }
  
  public A addToHeaders(String key,String value) {
    if (this.headers == null && key != null && value != null) {
      this.headers = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.headers.put(key, value);
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
  
  public A addToWriteRelabelConfigs(RelabelConfig... items) {
    if (this.writeRelabelConfigs == null) {
      this.writeRelabelConfigs = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("writeRelabelConfigs").add(builder);
        this.writeRelabelConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToWriteRelabelConfigs(int index,RelabelConfig item) {
    if (this.writeRelabelConfigs == null) {
      this.writeRelabelConfigs = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= writeRelabelConfigs.size()) {
        _visitables.get("writeRelabelConfigs").add(builder);
        writeRelabelConfigs.add(builder);
    } else {
        _visitables.get("writeRelabelConfigs").add(builder);
        writeRelabelConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public Authorization buildAuthorization() {
    return this.authorization != null ? this.authorization.build() : null;
  }
  
  public AzureAD buildAzureAd() {
    return this.azureAd != null ? this.azureAd.build() : null;
  }
  
  public BasicAuth buildBasicAuth() {
    return this.basicAuth != null ? this.basicAuth.build() : null;
  }
  
  public RelabelConfig buildFirstWriteRelabelConfig() {
    return this.writeRelabelConfigs.get(0).build();
  }
  
  public RelabelConfig buildLastWriteRelabelConfig() {
    return this.writeRelabelConfigs.get(writeRelabelConfigs.size() - 1).build();
  }
  
  public RelabelConfig buildMatchingWriteRelabelConfig(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : writeRelabelConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetadataConfig buildMetadataConfig() {
    return this.metadataConfig != null ? this.metadataConfig.build() : null;
  }
  
  public OAuth2 buildOauth2() {
    return this.oauth2 != null ? this.oauth2.build() : null;
  }
  
  public QueueConfig buildQueueConfig() {
    return this.queueConfig != null ? this.queueConfig.build() : null;
  }
  
  public Sigv4 buildSigv4() {
    return this.sigv4 != null ? this.sigv4.build() : null;
  }
  
  public TLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  public RelabelConfig buildWriteRelabelConfig(int index) {
    return this.writeRelabelConfigs.get(index).build();
  }
  
  public List<RelabelConfig> buildWriteRelabelConfigs() {
    return this.writeRelabelConfigs != null ? build(writeRelabelConfigs) : null;
  }
  
  protected void copyInstance(RemoteWriteSpec instance) {
    instance = instance != null ? instance : new RemoteWriteSpec();
    if (instance != null) {
        this.withAuthorization(instance.getAuthorization());
        this.withAzureAd(instance.getAzureAd());
        this.withBasicAuth(instance.getBasicAuth());
        this.withBearerToken(instance.getBearerToken());
        this.withBearerTokenFile(instance.getBearerTokenFile());
        this.withEnableHTTP2(instance.getEnableHTTP2());
        this.withFollowRedirects(instance.getFollowRedirects());
        this.withHeaders(instance.getHeaders());
        this.withMessageVersion(instance.getMessageVersion());
        this.withMetadataConfig(instance.getMetadataConfig());
        this.withName(instance.getName());
        this.withNoProxy(instance.getNoProxy());
        this.withOauth2(instance.getOauth2());
        this.withProxyConnectHeader(instance.getProxyConnectHeader());
        this.withProxyFromEnvironment(instance.getProxyFromEnvironment());
        this.withProxyUrl(instance.getProxyUrl());
        this.withQueueConfig(instance.getQueueConfig());
        this.withRemoteTimeout(instance.getRemoteTimeout());
        this.withRoundRobinDNS(instance.getRoundRobinDNS());
        this.withSendExemplars(instance.getSendExemplars());
        this.withSendNativeHistograms(instance.getSendNativeHistograms());
        this.withSigv4(instance.getSigv4());
        this.withTlsConfig(instance.getTlsConfig());
        this.withUrl(instance.getUrl());
        this.withWriteRelabelConfigs(instance.getWriteRelabelConfigs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthorizationNested<A> editAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(null));
  }
  
  public AzureAdNested<A> editAzureAd() {
    return this.withNewAzureAdLike(Optional.ofNullable(this.buildAzureAd()).orElse(null));
  }
  
  public BasicAuthNested<A> editBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(null));
  }
  
  public WriteRelabelConfigsNested<A> editFirstWriteRelabelConfig() {
    if (writeRelabelConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "writeRelabelConfigs"));
    }
    return this.setNewWriteRelabelConfigLike(0, this.buildWriteRelabelConfig(0));
  }
  
  public WriteRelabelConfigsNested<A> editLastWriteRelabelConfig() {
    int index = writeRelabelConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "writeRelabelConfigs"));
    }
    return this.setNewWriteRelabelConfigLike(index, this.buildWriteRelabelConfig(index));
  }
  
  public WriteRelabelConfigsNested<A> editMatchingWriteRelabelConfig(Predicate<RelabelConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < writeRelabelConfigs.size();i++) {
      if (predicate.test(writeRelabelConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "writeRelabelConfigs"));
    }
    return this.setNewWriteRelabelConfigLike(index, this.buildWriteRelabelConfig(index));
  }
  
  public MetadataConfigNested<A> editMetadataConfig() {
    return this.withNewMetadataConfigLike(Optional.ofNullable(this.buildMetadataConfig()).orElse(null));
  }
  
  public Oauth2Nested<A> editOauth2() {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(null));
  }
  
  public AuthorizationNested<A> editOrNewAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(new AuthorizationBuilder().build()));
  }
  
  public AuthorizationNested<A> editOrNewAuthorizationLike(Authorization item) {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(item));
  }
  
  public AzureAdNested<A> editOrNewAzureAd() {
    return this.withNewAzureAdLike(Optional.ofNullable(this.buildAzureAd()).orElse(new AzureADBuilder().build()));
  }
  
  public AzureAdNested<A> editOrNewAzureAdLike(AzureAD item) {
    return this.withNewAzureAdLike(Optional.ofNullable(this.buildAzureAd()).orElse(item));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(new BasicAuthBuilder().build()));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuthLike(BasicAuth item) {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(item));
  }
  
  public MetadataConfigNested<A> editOrNewMetadataConfig() {
    return this.withNewMetadataConfigLike(Optional.ofNullable(this.buildMetadataConfig()).orElse(new MetadataConfigBuilder().build()));
  }
  
  public MetadataConfigNested<A> editOrNewMetadataConfigLike(MetadataConfig item) {
    return this.withNewMetadataConfigLike(Optional.ofNullable(this.buildMetadataConfig()).orElse(item));
  }
  
  public Oauth2Nested<A> editOrNewOauth2() {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(new OAuth2Builder().build()));
  }
  
  public Oauth2Nested<A> editOrNewOauth2Like(OAuth2 item) {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(item));
  }
  
  public QueueConfigNested<A> editOrNewQueueConfig() {
    return this.withNewQueueConfigLike(Optional.ofNullable(this.buildQueueConfig()).orElse(new QueueConfigBuilder().build()));
  }
  
  public QueueConfigNested<A> editOrNewQueueConfigLike(QueueConfig item) {
    return this.withNewQueueConfigLike(Optional.ofNullable(this.buildQueueConfig()).orElse(item));
  }
  
  public Sigv4Nested<A> editOrNewSigv4() {
    return this.withNewSigv4Like(Optional.ofNullable(this.buildSigv4()).orElse(new Sigv4Builder().build()));
  }
  
  public Sigv4Nested<A> editOrNewSigv4Like(Sigv4 item) {
    return this.withNewSigv4Like(Optional.ofNullable(this.buildSigv4()).orElse(item));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(new TLSConfigBuilder().build()));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfigLike(TLSConfig item) {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(item));
  }
  
  public QueueConfigNested<A> editQueueConfig() {
    return this.withNewQueueConfigLike(Optional.ofNullable(this.buildQueueConfig()).orElse(null));
  }
  
  public Sigv4Nested<A> editSigv4() {
    return this.withNewSigv4Like(Optional.ofNullable(this.buildSigv4()).orElse(null));
  }
  
  public TlsConfigNested<A> editTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(null));
  }
  
  public WriteRelabelConfigsNested<A> editWriteRelabelConfig(int index) {
    if (writeRelabelConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "writeRelabelConfigs"));
    }
    return this.setNewWriteRelabelConfigLike(index, this.buildWriteRelabelConfig(index));
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
    RemoteWriteSpecFluent that = (RemoteWriteSpecFluent) o;
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(azureAd, that.azureAd))) {
      return false;
    }
    if (!(Objects.equals(basicAuth, that.basicAuth))) {
      return false;
    }
    if (!(Objects.equals(bearerToken, that.bearerToken))) {
      return false;
    }
    if (!(Objects.equals(bearerTokenFile, that.bearerTokenFile))) {
      return false;
    }
    if (!(Objects.equals(enableHTTP2, that.enableHTTP2))) {
      return false;
    }
    if (!(Objects.equals(followRedirects, that.followRedirects))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(messageVersion, that.messageVersion))) {
      return false;
    }
    if (!(Objects.equals(metadataConfig, that.metadataConfig))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
    if (!(Objects.equals(queueConfig, that.queueConfig))) {
      return false;
    }
    if (!(Objects.equals(remoteTimeout, that.remoteTimeout))) {
      return false;
    }
    if (!(Objects.equals(roundRobinDNS, that.roundRobinDNS))) {
      return false;
    }
    if (!(Objects.equals(sendExemplars, that.sendExemplars))) {
      return false;
    }
    if (!(Objects.equals(sendNativeHistograms, that.sendNativeHistograms))) {
      return false;
    }
    if (!(Objects.equals(sigv4, that.sigv4))) {
      return false;
    }
    if (!(Objects.equals(tlsConfig, that.tlsConfig))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
      return false;
    }
    if (!(Objects.equals(writeRelabelConfigs, that.writeRelabelConfigs))) {
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
  
  public String getBearerToken() {
    return this.bearerToken;
  }
  
  public String getBearerTokenFile() {
    return this.bearerTokenFile;
  }
  
  public Boolean getEnableHTTP2() {
    return this.enableHTTP2;
  }
  
  public Boolean getFollowRedirects() {
    return this.followRedirects;
  }
  
  public Map<String,String> getHeaders() {
    return this.headers;
  }
  
  public String getMessageVersion() {
    return this.messageVersion;
  }
  
  public String getName() {
    return this.name;
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
  
  public String getRemoteTimeout() {
    return this.remoteTimeout;
  }
  
  public Boolean getRoundRobinDNS() {
    return this.roundRobinDNS;
  }
  
  public Boolean getSendExemplars() {
    return this.sendExemplars;
  }
  
  public Boolean getSendNativeHistograms() {
    return this.sendNativeHistograms;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasAzureAd() {
    return this.azureAd != null;
  }
  
  public boolean hasBasicAuth() {
    return this.basicAuth != null;
  }
  
  public boolean hasBearerToken() {
    return this.bearerToken != null;
  }
  
  public boolean hasBearerTokenFile() {
    return this.bearerTokenFile != null;
  }
  
  public boolean hasEnableHTTP2() {
    return this.enableHTTP2 != null;
  }
  
  public boolean hasFollowRedirects() {
    return this.followRedirects != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null;
  }
  
  public boolean hasMatchingWriteRelabelConfig(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : writeRelabelConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessageVersion() {
    return this.messageVersion != null;
  }
  
  public boolean hasMetadataConfig() {
    return this.metadataConfig != null;
  }
  
  public boolean hasName() {
    return this.name != null;
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
  
  public boolean hasQueueConfig() {
    return this.queueConfig != null;
  }
  
  public boolean hasRemoteTimeout() {
    return this.remoteTimeout != null;
  }
  
  public boolean hasRoundRobinDNS() {
    return this.roundRobinDNS != null;
  }
  
  public boolean hasSendExemplars() {
    return this.sendExemplars != null;
  }
  
  public boolean hasSendNativeHistograms() {
    return this.sendNativeHistograms != null;
  }
  
  public boolean hasSigv4() {
    return this.sigv4 != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public boolean hasWriteRelabelConfigs() {
    return this.writeRelabelConfigs != null && !(this.writeRelabelConfigs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(authorization, azureAd, basicAuth, bearerToken, bearerTokenFile, enableHTTP2, followRedirects, headers, messageVersion, metadataConfig, name, noProxy, oauth2, proxyConnectHeader, proxyFromEnvironment, proxyUrl, queueConfig, remoteTimeout, roundRobinDNS, sendExemplars, sendNativeHistograms, sigv4, tlsConfig, url, writeRelabelConfigs, additionalProperties);
  }
  
  public A removeAllFromWriteRelabelConfigs(Collection<RelabelConfig> items) {
    if (this.writeRelabelConfigs == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("writeRelabelConfigs").remove(builder);
        this.writeRelabelConfigs.remove(builder);
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
  
  public A removeFromHeaders(String key) {
    if (this.headers == null) {
      return (A) this;
    }
    if (key != null && this.headers != null) {
      this.headers.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromHeaders(Map<String,String> map) {
    if (this.headers == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.headers != null) {
          this.headers.remove(key);
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
  
  public A removeFromWriteRelabelConfigs(RelabelConfig... items) {
    if (this.writeRelabelConfigs == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("writeRelabelConfigs").remove(builder);
        this.writeRelabelConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromWriteRelabelConfigs(Predicate<RelabelConfigBuilder> predicate) {
    if (writeRelabelConfigs == null) {
      return (A) this;
    }
    Iterator<RelabelConfigBuilder> each = writeRelabelConfigs.iterator();
    List visitables = _visitables.get("writeRelabelConfigs");
    while (each.hasNext()) {
        RelabelConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public WriteRelabelConfigsNested<A> setNewWriteRelabelConfigLike(int index,RelabelConfig item) {
    return new WriteRelabelConfigsNested(index, item);
  }
  
  public A setToWriteRelabelConfigs(int index,RelabelConfig item) {
    if (this.writeRelabelConfigs == null) {
      this.writeRelabelConfigs = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= writeRelabelConfigs.size()) {
        _visitables.get("writeRelabelConfigs").add(builder);
        writeRelabelConfigs.add(builder);
    } else {
        _visitables.get("writeRelabelConfigs").add(builder);
        writeRelabelConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(authorization == null)) {
        sb.append("authorization:");
        sb.append(authorization);
        sb.append(",");
    }
    if (!(azureAd == null)) {
        sb.append("azureAd:");
        sb.append(azureAd);
        sb.append(",");
    }
    if (!(basicAuth == null)) {
        sb.append("basicAuth:");
        sb.append(basicAuth);
        sb.append(",");
    }
    if (!(bearerToken == null)) {
        sb.append("bearerToken:");
        sb.append(bearerToken);
        sb.append(",");
    }
    if (!(bearerTokenFile == null)) {
        sb.append("bearerTokenFile:");
        sb.append(bearerTokenFile);
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
    if (!(headers == null) && !(headers.isEmpty())) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(messageVersion == null)) {
        sb.append("messageVersion:");
        sb.append(messageVersion);
        sb.append(",");
    }
    if (!(metadataConfig == null)) {
        sb.append("metadataConfig:");
        sb.append(metadataConfig);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
    if (!(queueConfig == null)) {
        sb.append("queueConfig:");
        sb.append(queueConfig);
        sb.append(",");
    }
    if (!(remoteTimeout == null)) {
        sb.append("remoteTimeout:");
        sb.append(remoteTimeout);
        sb.append(",");
    }
    if (!(roundRobinDNS == null)) {
        sb.append("roundRobinDNS:");
        sb.append(roundRobinDNS);
        sb.append(",");
    }
    if (!(sendExemplars == null)) {
        sb.append("sendExemplars:");
        sb.append(sendExemplars);
        sb.append(",");
    }
    if (!(sendNativeHistograms == null)) {
        sb.append("sendNativeHistograms:");
        sb.append(sendNativeHistograms);
        sb.append(",");
    }
    if (!(sigv4 == null)) {
        sb.append("sigv4:");
        sb.append(sigv4);
        sb.append(",");
    }
    if (!(tlsConfig == null)) {
        sb.append("tlsConfig:");
        sb.append(tlsConfig);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
        sb.append(",");
    }
    if (!(writeRelabelConfigs == null) && !(writeRelabelConfigs.isEmpty())) {
        sb.append("writeRelabelConfigs:");
        sb.append(writeRelabelConfigs);
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
  
  public A withAuthorization(Authorization authorization) {
    this._visitables.remove("authorization");
    if (authorization != null) {
        this.authorization = new AuthorizationBuilder(authorization);
        this._visitables.get("authorization").add(this.authorization);
    } else {
        this.authorization = null;
        this._visitables.get("authorization").remove(this.authorization);
    }
    return (A) this;
  }
  
  public A withAzureAd(AzureAD azureAd) {
    this._visitables.remove("azureAd");
    if (azureAd != null) {
        this.azureAd = new AzureADBuilder(azureAd);
        this._visitables.get("azureAd").add(this.azureAd);
    } else {
        this.azureAd = null;
        this._visitables.get("azureAd").remove(this.azureAd);
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
  
  public A withBearerToken(String bearerToken) {
    this.bearerToken = bearerToken;
    return (A) this;
  }
  
  public A withBearerTokenFile(String bearerTokenFile) {
    this.bearerTokenFile = bearerTokenFile;
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
  
  public <K,V>A withHeaders(Map<String,String> headers) {
    if (headers == null) {
      this.headers = null;
    } else {
      this.headers = new LinkedHashMap(headers);
    }
    return (A) this;
  }
  
  public A withMessageVersion(String messageVersion) {
    this.messageVersion = messageVersion;
    return (A) this;
  }
  
  public A withMetadataConfig(MetadataConfig metadataConfig) {
    this._visitables.remove("metadataConfig");
    if (metadataConfig != null) {
        this.metadataConfig = new MetadataConfigBuilder(metadataConfig);
        this._visitables.get("metadataConfig").add(this.metadataConfig);
    } else {
        this.metadataConfig = null;
        this._visitables.get("metadataConfig").remove(this.metadataConfig);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public AuthorizationNested<A> withNewAuthorization() {
    return new AuthorizationNested(null);
  }
  
  public AuthorizationNested<A> withNewAuthorizationLike(Authorization item) {
    return new AuthorizationNested(item);
  }
  
  public AzureAdNested<A> withNewAzureAd() {
    return new AzureAdNested(null);
  }
  
  public AzureAdNested<A> withNewAzureAdLike(AzureAD item) {
    return new AzureAdNested(item);
  }
  
  public BasicAuthNested<A> withNewBasicAuth() {
    return new BasicAuthNested(null);
  }
  
  public BasicAuthNested<A> withNewBasicAuthLike(BasicAuth item) {
    return new BasicAuthNested(item);
  }
  
  public MetadataConfigNested<A> withNewMetadataConfig() {
    return new MetadataConfigNested(null);
  }
  
  public A withNewMetadataConfig(Integer maxSamplesPerSend,Boolean send,String sendInterval) {
    return (A) this.withMetadataConfig(new MetadataConfig(maxSamplesPerSend, send, sendInterval));
  }
  
  public MetadataConfigNested<A> withNewMetadataConfigLike(MetadataConfig item) {
    return new MetadataConfigNested(item);
  }
  
  public Oauth2Nested<A> withNewOauth2() {
    return new Oauth2Nested(null);
  }
  
  public Oauth2Nested<A> withNewOauth2Like(OAuth2 item) {
    return new Oauth2Nested(item);
  }
  
  public QueueConfigNested<A> withNewQueueConfig() {
    return new QueueConfigNested(null);
  }
  
  public QueueConfigNested<A> withNewQueueConfigLike(QueueConfig item) {
    return new QueueConfigNested(item);
  }
  
  public Sigv4Nested<A> withNewSigv4() {
    return new Sigv4Nested(null);
  }
  
  public Sigv4Nested<A> withNewSigv4Like(Sigv4 item) {
    return new Sigv4Nested(item);
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(TLSConfig item) {
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
  
  public A withQueueConfig(QueueConfig queueConfig) {
    this._visitables.remove("queueConfig");
    if (queueConfig != null) {
        this.queueConfig = new QueueConfigBuilder(queueConfig);
        this._visitables.get("queueConfig").add(this.queueConfig);
    } else {
        this.queueConfig = null;
        this._visitables.get("queueConfig").remove(this.queueConfig);
    }
    return (A) this;
  }
  
  public A withRemoteTimeout(String remoteTimeout) {
    this.remoteTimeout = remoteTimeout;
    return (A) this;
  }
  
  public A withRoundRobinDNS() {
    return withRoundRobinDNS(true);
  }
  
  public A withRoundRobinDNS(Boolean roundRobinDNS) {
    this.roundRobinDNS = roundRobinDNS;
    return (A) this;
  }
  
  public A withSendExemplars() {
    return withSendExemplars(true);
  }
  
  public A withSendExemplars(Boolean sendExemplars) {
    this.sendExemplars = sendExemplars;
    return (A) this;
  }
  
  public A withSendNativeHistograms() {
    return withSendNativeHistograms(true);
  }
  
  public A withSendNativeHistograms(Boolean sendNativeHistograms) {
    this.sendNativeHistograms = sendNativeHistograms;
    return (A) this;
  }
  
  public A withSigv4(Sigv4 sigv4) {
    this._visitables.remove("sigv4");
    if (sigv4 != null) {
        this.sigv4 = new Sigv4Builder(sigv4);
        this._visitables.get("sigv4").add(this.sigv4);
    } else {
        this.sigv4 = null;
        this._visitables.get("sigv4").remove(this.sigv4);
    }
    return (A) this;
  }
  
  public A withTlsConfig(TLSConfig tlsConfig) {
    this._visitables.remove("tlsConfig");
    if (tlsConfig != null) {
        this.tlsConfig = new TLSConfigBuilder(tlsConfig);
        this._visitables.get("tlsConfig").add(this.tlsConfig);
    } else {
        this.tlsConfig = null;
        this._visitables.get("tlsConfig").remove(this.tlsConfig);
    }
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
  public A withWriteRelabelConfigs(List<RelabelConfig> writeRelabelConfigs) {
    if (this.writeRelabelConfigs != null) {
      this._visitables.get("writeRelabelConfigs").clear();
    }
    if (writeRelabelConfigs != null) {
        this.writeRelabelConfigs = new ArrayList();
        for (RelabelConfig item : writeRelabelConfigs) {
          this.addToWriteRelabelConfigs(item);
        }
    } else {
      this.writeRelabelConfigs = null;
    }
    return (A) this;
  }
  
  public A withWriteRelabelConfigs(RelabelConfig... writeRelabelConfigs) {
    if (this.writeRelabelConfigs != null) {
        this.writeRelabelConfigs.clear();
        _visitables.remove("writeRelabelConfigs");
    }
    if (writeRelabelConfigs != null) {
      for (RelabelConfig item : writeRelabelConfigs) {
        this.addToWriteRelabelConfigs(item);
      }
    }
    return (A) this;
  }
  public class AuthorizationNested<N> extends AuthorizationFluent<AuthorizationNested<N>> implements Nested<N>{
  
    AuthorizationBuilder builder;
  
    AuthorizationNested(Authorization item) {
      this.builder = new AuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) RemoteWriteSpecFluent.this.withAuthorization(builder.build());
    }
    
    public N endAuthorization() {
      return and();
    }
    
  }
  public class AzureAdNested<N> extends AzureADFluent<AzureAdNested<N>> implements Nested<N>{
  
    AzureADBuilder builder;
  
    AzureAdNested(AzureAD item) {
      this.builder = new AzureADBuilder(this, item);
    }
  
    public N and() {
      return (N) RemoteWriteSpecFluent.this.withAzureAd(builder.build());
    }
    
    public N endAzureAd() {
      return and();
    }
    
  }
  public class BasicAuthNested<N> extends BasicAuthFluent<BasicAuthNested<N>> implements Nested<N>{
  
    BasicAuthBuilder builder;
  
    BasicAuthNested(BasicAuth item) {
      this.builder = new BasicAuthBuilder(this, item);
    }
  
    public N and() {
      return (N) RemoteWriteSpecFluent.this.withBasicAuth(builder.build());
    }
    
    public N endBasicAuth() {
      return and();
    }
    
  }
  public class MetadataConfigNested<N> extends MetadataConfigFluent<MetadataConfigNested<N>> implements Nested<N>{
  
    MetadataConfigBuilder builder;
  
    MetadataConfigNested(MetadataConfig item) {
      this.builder = new MetadataConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RemoteWriteSpecFluent.this.withMetadataConfig(builder.build());
    }
    
    public N endMetadataConfig() {
      return and();
    }
    
  }
  public class Oauth2Nested<N> extends OAuth2Fluent<Oauth2Nested<N>> implements Nested<N>{
  
    OAuth2Builder builder;
  
    Oauth2Nested(OAuth2 item) {
      this.builder = new OAuth2Builder(this, item);
    }
  
    public N and() {
      return (N) RemoteWriteSpecFluent.this.withOauth2(builder.build());
    }
    
    public N endOauth2() {
      return and();
    }
    
  }
  public class QueueConfigNested<N> extends QueueConfigFluent<QueueConfigNested<N>> implements Nested<N>{
  
    QueueConfigBuilder builder;
  
    QueueConfigNested(QueueConfig item) {
      this.builder = new QueueConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RemoteWriteSpecFluent.this.withQueueConfig(builder.build());
    }
    
    public N endQueueConfig() {
      return and();
    }
    
  }
  public class Sigv4Nested<N> extends Sigv4Fluent<Sigv4Nested<N>> implements Nested<N>{
  
    Sigv4Builder builder;
  
    Sigv4Nested(Sigv4 item) {
      this.builder = new Sigv4Builder(this, item);
    }
  
    public N and() {
      return (N) RemoteWriteSpecFluent.this.withSigv4(builder.build());
    }
    
    public N endSigv4() {
      return and();
    }
    
  }
  public class TlsConfigNested<N> extends TLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    TLSConfigBuilder builder;
  
    TlsConfigNested(TLSConfig item) {
      this.builder = new TLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RemoteWriteSpecFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
  public class WriteRelabelConfigsNested<N> extends RelabelConfigFluent<WriteRelabelConfigsNested<N>> implements Nested<N>{
  
    RelabelConfigBuilder builder;
    int index;
  
    WriteRelabelConfigsNested(int index,RelabelConfig item) {
      this.index = index;
      this.builder = new RelabelConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RemoteWriteSpecFluent.this.setToWriteRelabelConfigs(index, builder.build());
    }
    
    public N endWriteRelabelConfig() {
      return and();
    }
    
  }
}