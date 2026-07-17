package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
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
public class AlertmanagerEndpointsFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.AlertmanagerEndpointsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RelabelConfigBuilder> alertRelabelings = new ArrayList<RelabelConfigBuilder>();
  private String apiVersion;
  private SafeAuthorizationBuilder authorization;
  private BasicAuthBuilder basicAuth;
  private String bearerTokenFile;
  private Boolean enableHttp2;
  private String name;
  private String namespace;
  private String noProxy;
  private String pathPrefix;
  private IntOrStringBuilder port;
  private Map<String,List<SecretKeySelector>> proxyConnectHeader;
  private Boolean proxyFromEnvironment;
  private String proxyUrl;
  private ArrayList<RelabelConfigBuilder> relabelings = new ArrayList<RelabelConfigBuilder>();
  private String scheme;
  private Sigv4Builder sigv4;
  private String timeout;
  private TLSConfigBuilder tlsConfig;

  public AlertmanagerEndpointsFluent() {
  }
  
  public AlertmanagerEndpointsFluent(AlertmanagerEndpoints instance) {
    this.copyInstance(instance);
  }

  public A addAllToAlertRelabelings(Collection<RelabelConfig> items) {
    if (this.alertRelabelings == null) {
      this.alertRelabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("alertRelabelings").add(builder);
        this.alertRelabelings.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRelabelings(Collection<RelabelConfig> items) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").add(builder);
        this.relabelings.add(builder);
    }
    return (A) this;
  }
  
  public AlertRelabelingsNested<A> addNewAlertRelabeling() {
    return new AlertRelabelingsNested(-1, null);
  }
  
  public AlertRelabelingsNested<A> addNewAlertRelabelingLike(RelabelConfig item) {
    return new AlertRelabelingsNested(-1, item);
  }
  
  public RelabelingsNested<A> addNewRelabeling() {
    return new RelabelingsNested(-1, null);
  }
  
  public RelabelingsNested<A> addNewRelabelingLike(RelabelConfig item) {
    return new RelabelingsNested(-1, item);
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
  
  public A addToAlertRelabelings(RelabelConfig... items) {
    if (this.alertRelabelings == null) {
      this.alertRelabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("alertRelabelings").add(builder);
        this.alertRelabelings.add(builder);
    }
    return (A) this;
  }
  
  public A addToAlertRelabelings(int index,RelabelConfig item) {
    if (this.alertRelabelings == null) {
      this.alertRelabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= alertRelabelings.size()) {
        _visitables.get("alertRelabelings").add(builder);
        alertRelabelings.add(builder);
    } else {
        _visitables.get("alertRelabelings").add(builder);
        alertRelabelings.add(index, builder);
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
  
  public A addToRelabelings(RelabelConfig... items) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").add(builder);
        this.relabelings.add(builder);
    }
    return (A) this;
  }
  
  public A addToRelabelings(int index,RelabelConfig item) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= relabelings.size()) {
        _visitables.get("relabelings").add(builder);
        relabelings.add(builder);
    } else {
        _visitables.get("relabelings").add(builder);
        relabelings.add(index, builder);
    }
    return (A) this;
  }
  
  public RelabelConfig buildAlertRelabeling(int index) {
    return this.alertRelabelings.get(index).build();
  }
  
  public List<RelabelConfig> buildAlertRelabelings() {
    return this.alertRelabelings != null ? build(alertRelabelings) : null;
  }
  
  public SafeAuthorization buildAuthorization() {
    return this.authorization != null ? this.authorization.build() : null;
  }
  
  public BasicAuth buildBasicAuth() {
    return this.basicAuth != null ? this.basicAuth.build() : null;
  }
  
  public RelabelConfig buildFirstAlertRelabeling() {
    return this.alertRelabelings.get(0).build();
  }
  
  public RelabelConfig buildFirstRelabeling() {
    return this.relabelings.get(0).build();
  }
  
  public RelabelConfig buildLastAlertRelabeling() {
    return this.alertRelabelings.get(alertRelabelings.size() - 1).build();
  }
  
  public RelabelConfig buildLastRelabeling() {
    return this.relabelings.get(relabelings.size() - 1).build();
  }
  
  public RelabelConfig buildMatchingAlertRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : alertRelabelings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RelabelConfig buildMatchingRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : relabelings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IntOrString buildPort() {
    return this.port != null ? this.port.build() : null;
  }
  
  public RelabelConfig buildRelabeling(int index) {
    return this.relabelings.get(index).build();
  }
  
  public List<RelabelConfig> buildRelabelings() {
    return this.relabelings != null ? build(relabelings) : null;
  }
  
  public Sigv4 buildSigv4() {
    return this.sigv4 != null ? this.sigv4.build() : null;
  }
  
  public TLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(AlertmanagerEndpoints instance) {
    instance = instance != null ? instance : new AlertmanagerEndpoints();
    if (instance != null) {
        this.withAlertRelabelings(instance.getAlertRelabelings());
        this.withApiVersion(instance.getApiVersion());
        this.withAuthorization(instance.getAuthorization());
        this.withBasicAuth(instance.getBasicAuth());
        this.withBearerTokenFile(instance.getBearerTokenFile());
        this.withEnableHttp2(instance.getEnableHttp2());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withNoProxy(instance.getNoProxy());
        this.withPathPrefix(instance.getPathPrefix());
        this.withPort(instance.getPort());
        this.withProxyConnectHeader(instance.getProxyConnectHeader());
        this.withProxyFromEnvironment(instance.getProxyFromEnvironment());
        this.withProxyUrl(instance.getProxyUrl());
        this.withRelabelings(instance.getRelabelings());
        this.withScheme(instance.getScheme());
        this.withSigv4(instance.getSigv4());
        this.withTimeout(instance.getTimeout());
        this.withTlsConfig(instance.getTlsConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AlertRelabelingsNested<A> editAlertRelabeling(int index) {
    if (alertRelabelings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "alertRelabelings"));
    }
    return this.setNewAlertRelabelingLike(index, this.buildAlertRelabeling(index));
  }
  
  public AuthorizationNested<A> editAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(null));
  }
  
  public BasicAuthNested<A> editBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(null));
  }
  
  public AlertRelabelingsNested<A> editFirstAlertRelabeling() {
    if (alertRelabelings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "alertRelabelings"));
    }
    return this.setNewAlertRelabelingLike(0, this.buildAlertRelabeling(0));
  }
  
  public RelabelingsNested<A> editFirstRelabeling() {
    if (relabelings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "relabelings"));
    }
    return this.setNewRelabelingLike(0, this.buildRelabeling(0));
  }
  
  public AlertRelabelingsNested<A> editLastAlertRelabeling() {
    int index = alertRelabelings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "alertRelabelings"));
    }
    return this.setNewAlertRelabelingLike(index, this.buildAlertRelabeling(index));
  }
  
  public RelabelingsNested<A> editLastRelabeling() {
    int index = relabelings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "relabelings"));
    }
    return this.setNewRelabelingLike(index, this.buildRelabeling(index));
  }
  
  public AlertRelabelingsNested<A> editMatchingAlertRelabeling(Predicate<RelabelConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < alertRelabelings.size();i++) {
      if (predicate.test(alertRelabelings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "alertRelabelings"));
    }
    return this.setNewAlertRelabelingLike(index, this.buildAlertRelabeling(index));
  }
  
  public RelabelingsNested<A> editMatchingRelabeling(Predicate<RelabelConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < relabelings.size();i++) {
      if (predicate.test(relabelings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "relabelings"));
    }
    return this.setNewRelabelingLike(index, this.buildRelabeling(index));
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
  
  public PortNested<A> editOrNewPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(new IntOrStringBuilder().build()));
  }
  
  public PortNested<A> editOrNewPortLike(IntOrString item) {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(item));
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
  
  public PortNested<A> editPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(null));
  }
  
  public RelabelingsNested<A> editRelabeling(int index) {
    if (relabelings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "relabelings"));
    }
    return this.setNewRelabelingLike(index, this.buildRelabeling(index));
  }
  
  public Sigv4Nested<A> editSigv4() {
    return this.withNewSigv4Like(Optional.ofNullable(this.buildSigv4()).orElse(null));
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
    AlertmanagerEndpointsFluent that = (AlertmanagerEndpointsFluent) o;
    if (!(Objects.equals(alertRelabelings, that.alertRelabelings))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(basicAuth, that.basicAuth))) {
      return false;
    }
    if (!(Objects.equals(bearerTokenFile, that.bearerTokenFile))) {
      return false;
    }
    if (!(Objects.equals(enableHttp2, that.enableHttp2))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(pathPrefix, that.pathPrefix))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
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
    if (!(Objects.equals(relabelings, that.relabelings))) {
      return false;
    }
    if (!(Objects.equals(scheme, that.scheme))) {
      return false;
    }
    if (!(Objects.equals(sigv4, that.sigv4))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getBearerTokenFile() {
    return this.bearerTokenFile;
  }
  
  public Boolean getEnableHttp2() {
    return this.enableHttp2;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getNoProxy() {
    return this.noProxy;
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
  
  public String getScheme() {
    return this.scheme;
  }
  
  public String getTimeout() {
    return this.timeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAlertRelabelings() {
    return this.alertRelabelings != null && !(this.alertRelabelings.isEmpty());
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasBasicAuth() {
    return this.basicAuth != null;
  }
  
  public boolean hasBearerTokenFile() {
    return this.bearerTokenFile != null;
  }
  
  public boolean hasEnableHttp2() {
    return this.enableHttp2 != null;
  }
  
  public boolean hasMatchingAlertRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : alertRelabelings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : relabelings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public boolean hasPathPrefix() {
    return this.pathPrefix != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
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
  
  public boolean hasRelabelings() {
    return this.relabelings != null && !(this.relabelings.isEmpty());
  }
  
  public boolean hasScheme() {
    return this.scheme != null;
  }
  
  public boolean hasSigv4() {
    return this.sigv4 != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(alertRelabelings, apiVersion, authorization, basicAuth, bearerTokenFile, enableHttp2, name, namespace, noProxy, pathPrefix, port, proxyConnectHeader, proxyFromEnvironment, proxyUrl, relabelings, scheme, sigv4, timeout, tlsConfig, additionalProperties);
  }
  
  public A removeAllFromAlertRelabelings(Collection<RelabelConfig> items) {
    if (this.alertRelabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("alertRelabelings").remove(builder);
        this.alertRelabelings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRelabelings(Collection<RelabelConfig> items) {
    if (this.relabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").remove(builder);
        this.relabelings.remove(builder);
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
  
  public A removeFromAlertRelabelings(RelabelConfig... items) {
    if (this.alertRelabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("alertRelabelings").remove(builder);
        this.alertRelabelings.remove(builder);
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
  
  public A removeFromRelabelings(RelabelConfig... items) {
    if (this.relabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").remove(builder);
        this.relabelings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAlertRelabelings(Predicate<RelabelConfigBuilder> predicate) {
    if (alertRelabelings == null) {
      return (A) this;
    }
    Iterator<RelabelConfigBuilder> each = alertRelabelings.iterator();
    List visitables = _visitables.get("alertRelabelings");
    while (each.hasNext()) {
        RelabelConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRelabelings(Predicate<RelabelConfigBuilder> predicate) {
    if (relabelings == null) {
      return (A) this;
    }
    Iterator<RelabelConfigBuilder> each = relabelings.iterator();
    List visitables = _visitables.get("relabelings");
    while (each.hasNext()) {
        RelabelConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AlertRelabelingsNested<A> setNewAlertRelabelingLike(int index,RelabelConfig item) {
    return new AlertRelabelingsNested(index, item);
  }
  
  public RelabelingsNested<A> setNewRelabelingLike(int index,RelabelConfig item) {
    return new RelabelingsNested(index, item);
  }
  
  public A setToAlertRelabelings(int index,RelabelConfig item) {
    if (this.alertRelabelings == null) {
      this.alertRelabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= alertRelabelings.size()) {
        _visitables.get("alertRelabelings").add(builder);
        alertRelabelings.add(builder);
    } else {
        _visitables.get("alertRelabelings").add(builder);
        alertRelabelings.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRelabelings(int index,RelabelConfig item) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= relabelings.size()) {
        _visitables.get("relabelings").add(builder);
        relabelings.add(builder);
    } else {
        _visitables.get("relabelings").add(builder);
        relabelings.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(alertRelabelings == null) && !(alertRelabelings.isEmpty())) {
        sb.append("alertRelabelings:");
        sb.append(alertRelabelings);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
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
    if (!(bearerTokenFile == null)) {
        sb.append("bearerTokenFile:");
        sb.append(bearerTokenFile);
        sb.append(",");
    }
    if (!(enableHttp2 == null)) {
        sb.append("enableHttp2:");
        sb.append(enableHttp2);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
    if (!(pathPrefix == null)) {
        sb.append("pathPrefix:");
        sb.append(pathPrefix);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
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
    if (!(relabelings == null) && !(relabelings.isEmpty())) {
        sb.append("relabelings:");
        sb.append(relabelings);
        sb.append(",");
    }
    if (!(scheme == null)) {
        sb.append("scheme:");
        sb.append(scheme);
        sb.append(",");
    }
    if (!(sigv4 == null)) {
        sb.append("sigv4:");
        sb.append(sigv4);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
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
  
  public A withAlertRelabelings(List<RelabelConfig> alertRelabelings) {
    if (this.alertRelabelings != null) {
      this._visitables.get("alertRelabelings").clear();
    }
    if (alertRelabelings != null) {
        this.alertRelabelings = new ArrayList();
        for (RelabelConfig item : alertRelabelings) {
          this.addToAlertRelabelings(item);
        }
    } else {
      this.alertRelabelings = null;
    }
    return (A) this;
  }
  
  public A withAlertRelabelings(RelabelConfig... alertRelabelings) {
    if (this.alertRelabelings != null) {
        this.alertRelabelings.clear();
        _visitables.remove("alertRelabelings");
    }
    if (alertRelabelings != null) {
      for (RelabelConfig item : alertRelabelings) {
        this.addToAlertRelabelings(item);
      }
    }
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
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
  
  public A withBearerTokenFile(String bearerTokenFile) {
    this.bearerTokenFile = bearerTokenFile;
    return (A) this;
  }
  
  public A withEnableHttp2() {
    return withEnableHttp2(true);
  }
  
  public A withEnableHttp2(Boolean enableHttp2) {
    this.enableHttp2 = enableHttp2;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
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
  
  public PortNested<A> withNewPort() {
    return new PortNested(null);
  }
  
  public A withNewPort(Object value) {
    return (A) this.withPort(new IntOrString(value));
  }
  
  public PortNested<A> withNewPortLike(IntOrString item) {
    return new PortNested(item);
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
  
  public A withPathPrefix(String pathPrefix) {
    this.pathPrefix = pathPrefix;
    return (A) this;
  }
  
  public A withPort(IntOrString port) {
    this._visitables.remove("port");
    if (port != null) {
        this.port = new IntOrStringBuilder(port);
        this._visitables.get("port").add(this.port);
    } else {
        this.port = null;
        this._visitables.get("port").remove(this.port);
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
  
  public A withRelabelings(List<RelabelConfig> relabelings) {
    if (this.relabelings != null) {
      this._visitables.get("relabelings").clear();
    }
    if (relabelings != null) {
        this.relabelings = new ArrayList();
        for (RelabelConfig item : relabelings) {
          this.addToRelabelings(item);
        }
    } else {
      this.relabelings = null;
    }
    return (A) this;
  }
  
  public A withRelabelings(RelabelConfig... relabelings) {
    if (this.relabelings != null) {
        this.relabelings.clear();
        _visitables.remove("relabelings");
    }
    if (relabelings != null) {
      for (RelabelConfig item : relabelings) {
        this.addToRelabelings(item);
      }
    }
    return (A) this;
  }
  
  public A withScheme(String scheme) {
    this.scheme = scheme;
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
  
  public A withTimeout(String timeout) {
    this.timeout = timeout;
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
  public class AlertRelabelingsNested<N> extends RelabelConfigFluent<AlertRelabelingsNested<N>> implements Nested<N>{
  
    RelabelConfigBuilder builder;
    int index;
  
    AlertRelabelingsNested(int index,RelabelConfig item) {
      this.index = index;
      this.builder = new RelabelConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerEndpointsFluent.this.setToAlertRelabelings(index, builder.build());
    }
    
    public N endAlertRelabeling() {
      return and();
    }
    
  }
  public class AuthorizationNested<N> extends SafeAuthorizationFluent<AuthorizationNested<N>> implements Nested<N>{
  
    SafeAuthorizationBuilder builder;
  
    AuthorizationNested(SafeAuthorization item) {
      this.builder = new SafeAuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerEndpointsFluent.this.withAuthorization(builder.build());
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
      return (N) AlertmanagerEndpointsFluent.this.withBasicAuth(builder.build());
    }
    
    public N endBasicAuth() {
      return and();
    }
    
  }
  public class PortNested<N> extends IntOrStringFluent<PortNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    PortNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerEndpointsFluent.this.withPort(builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
  public class RelabelingsNested<N> extends RelabelConfigFluent<RelabelingsNested<N>> implements Nested<N>{
  
    RelabelConfigBuilder builder;
    int index;
  
    RelabelingsNested(int index,RelabelConfig item) {
      this.index = index;
      this.builder = new RelabelConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerEndpointsFluent.this.setToRelabelings(index, builder.build());
    }
    
    public N endRelabeling() {
      return and();
    }
    
  }
  public class Sigv4Nested<N> extends Sigv4Fluent<Sigv4Nested<N>> implements Nested<N>{
  
    Sigv4Builder builder;
  
    Sigv4Nested(Sigv4 item) {
      this.builder = new Sigv4Builder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerEndpointsFluent.this.withSigv4(builder.build());
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
      return (N) AlertmanagerEndpointsFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}