package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
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
public class WebTLSConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.WebTLSConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretOrConfigMapBuilder cert;
  private String certFile;
  private List<String> cipherSuites = new ArrayList<String>();
  private String clientAuthType;
  private String clientCAFile;
  private SecretOrConfigMapBuilder clientCa;
  private List<String> curvePreferences = new ArrayList<String>();
  private String keyFile;
  private SecretKeySelector keySecret;
  private String maxVersion;
  private String minVersion;
  private Boolean preferServerCipherSuites;

  public WebTLSConfigFluent() {
  }
  
  public WebTLSConfigFluent(WebTLSConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToCipherSuites(Collection<String> items) {
    if (this.cipherSuites == null) {
      this.cipherSuites = new ArrayList();
    }
    for (String item : items) {
      this.cipherSuites.add(item);
    }
    return (A) this;
  }
  
  public A addAllToCurvePreferences(Collection<String> items) {
    if (this.curvePreferences == null) {
      this.curvePreferences = new ArrayList();
    }
    for (String item : items) {
      this.curvePreferences.add(item);
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
  
  public A addToCipherSuites(String... items) {
    if (this.cipherSuites == null) {
      this.cipherSuites = new ArrayList();
    }
    for (String item : items) {
      this.cipherSuites.add(item);
    }
    return (A) this;
  }
  
  public A addToCipherSuites(int index,String item) {
    if (this.cipherSuites == null) {
      this.cipherSuites = new ArrayList();
    }
    this.cipherSuites.add(index, item);
    return (A) this;
  }
  
  public A addToCurvePreferences(String... items) {
    if (this.curvePreferences == null) {
      this.curvePreferences = new ArrayList();
    }
    for (String item : items) {
      this.curvePreferences.add(item);
    }
    return (A) this;
  }
  
  public A addToCurvePreferences(int index,String item) {
    if (this.curvePreferences == null) {
      this.curvePreferences = new ArrayList();
    }
    this.curvePreferences.add(index, item);
    return (A) this;
  }
  
  public SecretOrConfigMap buildCert() {
    return this.cert != null ? this.cert.build() : null;
  }
  
  public SecretOrConfigMap buildClientCa() {
    return this.clientCa != null ? this.clientCa.build() : null;
  }
  
  protected void copyInstance(WebTLSConfig instance) {
    instance = instance != null ? instance : new WebTLSConfig();
    if (instance != null) {
        this.withCert(instance.getCert());
        this.withCertFile(instance.getCertFile());
        this.withCipherSuites(instance.getCipherSuites());
        this.withClientAuthType(instance.getClientAuthType());
        this.withClientCAFile(instance.getClientCAFile());
        this.withClientCa(instance.getClientCa());
        this.withCurvePreferences(instance.getCurvePreferences());
        this.withKeyFile(instance.getKeyFile());
        this.withKeySecret(instance.getKeySecret());
        this.withMaxVersion(instance.getMaxVersion());
        this.withMinVersion(instance.getMinVersion());
        this.withPreferServerCipherSuites(instance.getPreferServerCipherSuites());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CertNested<A> editCert() {
    return this.withNewCertLike(Optional.ofNullable(this.buildCert()).orElse(null));
  }
  
  public ClientCaNested<A> editClientCa() {
    return this.withNewClientCaLike(Optional.ofNullable(this.buildClientCa()).orElse(null));
  }
  
  public CertNested<A> editOrNewCert() {
    return this.withNewCertLike(Optional.ofNullable(this.buildCert()).orElse(new SecretOrConfigMapBuilder().build()));
  }
  
  public CertNested<A> editOrNewCertLike(SecretOrConfigMap item) {
    return this.withNewCertLike(Optional.ofNullable(this.buildCert()).orElse(item));
  }
  
  public ClientCaNested<A> editOrNewClientCa() {
    return this.withNewClientCaLike(Optional.ofNullable(this.buildClientCa()).orElse(new SecretOrConfigMapBuilder().build()));
  }
  
  public ClientCaNested<A> editOrNewClientCaLike(SecretOrConfigMap item) {
    return this.withNewClientCaLike(Optional.ofNullable(this.buildClientCa()).orElse(item));
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
    WebTLSConfigFluent that = (WebTLSConfigFluent) o;
    if (!(Objects.equals(cert, that.cert))) {
      return false;
    }
    if (!(Objects.equals(certFile, that.certFile))) {
      return false;
    }
    if (!(Objects.equals(cipherSuites, that.cipherSuites))) {
      return false;
    }
    if (!(Objects.equals(clientAuthType, that.clientAuthType))) {
      return false;
    }
    if (!(Objects.equals(clientCAFile, that.clientCAFile))) {
      return false;
    }
    if (!(Objects.equals(clientCa, that.clientCa))) {
      return false;
    }
    if (!(Objects.equals(curvePreferences, that.curvePreferences))) {
      return false;
    }
    if (!(Objects.equals(keyFile, that.keyFile))) {
      return false;
    }
    if (!(Objects.equals(keySecret, that.keySecret))) {
      return false;
    }
    if (!(Objects.equals(maxVersion, that.maxVersion))) {
      return false;
    }
    if (!(Objects.equals(minVersion, that.minVersion))) {
      return false;
    }
    if (!(Objects.equals(preferServerCipherSuites, that.preferServerCipherSuites))) {
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
  
  public String getCertFile() {
    return this.certFile;
  }
  
  public String getCipherSuite(int index) {
    return this.cipherSuites.get(index);
  }
  
  public List<String> getCipherSuites() {
    return this.cipherSuites;
  }
  
  public String getClientAuthType() {
    return this.clientAuthType;
  }
  
  public String getClientCAFile() {
    return this.clientCAFile;
  }
  
  public String getCurvePreference(int index) {
    return this.curvePreferences.get(index);
  }
  
  public List<String> getCurvePreferences() {
    return this.curvePreferences;
  }
  
  public String getFirstCipherSuite() {
    return this.cipherSuites.get(0);
  }
  
  public String getFirstCurvePreference() {
    return this.curvePreferences.get(0);
  }
  
  public String getKeyFile() {
    return this.keyFile;
  }
  
  public SecretKeySelector getKeySecret() {
    return this.keySecret;
  }
  
  public String getLastCipherSuite() {
    return this.cipherSuites.get(cipherSuites.size() - 1);
  }
  
  public String getLastCurvePreference() {
    return this.curvePreferences.get(curvePreferences.size() - 1);
  }
  
  public String getMatchingCipherSuite(Predicate<String> predicate) {
      for (String item : cipherSuites) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingCurvePreference(Predicate<String> predicate) {
      for (String item : curvePreferences) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMaxVersion() {
    return this.maxVersion;
  }
  
  public String getMinVersion() {
    return this.minVersion;
  }
  
  public Boolean getPreferServerCipherSuites() {
    return this.preferServerCipherSuites;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCert() {
    return this.cert != null;
  }
  
  public boolean hasCertFile() {
    return this.certFile != null;
  }
  
  public boolean hasCipherSuites() {
    return this.cipherSuites != null && !(this.cipherSuites.isEmpty());
  }
  
  public boolean hasClientAuthType() {
    return this.clientAuthType != null;
  }
  
  public boolean hasClientCAFile() {
    return this.clientCAFile != null;
  }
  
  public boolean hasClientCa() {
    return this.clientCa != null;
  }
  
  public boolean hasCurvePreferences() {
    return this.curvePreferences != null && !(this.curvePreferences.isEmpty());
  }
  
  public boolean hasKeyFile() {
    return this.keyFile != null;
  }
  
  public boolean hasKeySecret() {
    return this.keySecret != null;
  }
  
  public boolean hasMatchingCipherSuite(Predicate<String> predicate) {
      for (String item : cipherSuites) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCurvePreference(Predicate<String> predicate) {
      for (String item : curvePreferences) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxVersion() {
    return this.maxVersion != null;
  }
  
  public boolean hasMinVersion() {
    return this.minVersion != null;
  }
  
  public boolean hasPreferServerCipherSuites() {
    return this.preferServerCipherSuites != null;
  }
  
  public int hashCode() {
    return Objects.hash(cert, certFile, cipherSuites, clientAuthType, clientCAFile, clientCa, curvePreferences, keyFile, keySecret, maxVersion, minVersion, preferServerCipherSuites, additionalProperties);
  }
  
  public A removeAllFromCipherSuites(Collection<String> items) {
    if (this.cipherSuites == null) {
      return (A) this;
    }
    for (String item : items) {
      this.cipherSuites.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromCurvePreferences(Collection<String> items) {
    if (this.curvePreferences == null) {
      return (A) this;
    }
    for (String item : items) {
      this.curvePreferences.remove(item);
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
  
  public A removeFromCipherSuites(String... items) {
    if (this.cipherSuites == null) {
      return (A) this;
    }
    for (String item : items) {
      this.cipherSuites.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromCurvePreferences(String... items) {
    if (this.curvePreferences == null) {
      return (A) this;
    }
    for (String item : items) {
      this.curvePreferences.remove(item);
    }
    return (A) this;
  }
  
  public A setToCipherSuites(int index,String item) {
    if (this.cipherSuites == null) {
      this.cipherSuites = new ArrayList();
    }
    this.cipherSuites.set(index, item);
    return (A) this;
  }
  
  public A setToCurvePreferences(int index,String item) {
    if (this.curvePreferences == null) {
      this.curvePreferences = new ArrayList();
    }
    this.curvePreferences.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cert == null)) {
        sb.append("cert:");
        sb.append(cert);
        sb.append(",");
    }
    if (!(certFile == null)) {
        sb.append("certFile:");
        sb.append(certFile);
        sb.append(",");
    }
    if (!(cipherSuites == null) && !(cipherSuites.isEmpty())) {
        sb.append("cipherSuites:");
        sb.append(cipherSuites);
        sb.append(",");
    }
    if (!(clientAuthType == null)) {
        sb.append("clientAuthType:");
        sb.append(clientAuthType);
        sb.append(",");
    }
    if (!(clientCAFile == null)) {
        sb.append("clientCAFile:");
        sb.append(clientCAFile);
        sb.append(",");
    }
    if (!(clientCa == null)) {
        sb.append("clientCa:");
        sb.append(clientCa);
        sb.append(",");
    }
    if (!(curvePreferences == null) && !(curvePreferences.isEmpty())) {
        sb.append("curvePreferences:");
        sb.append(curvePreferences);
        sb.append(",");
    }
    if (!(keyFile == null)) {
        sb.append("keyFile:");
        sb.append(keyFile);
        sb.append(",");
    }
    if (!(keySecret == null)) {
        sb.append("keySecret:");
        sb.append(keySecret);
        sb.append(",");
    }
    if (!(maxVersion == null)) {
        sb.append("maxVersion:");
        sb.append(maxVersion);
        sb.append(",");
    }
    if (!(minVersion == null)) {
        sb.append("minVersion:");
        sb.append(minVersion);
        sb.append(",");
    }
    if (!(preferServerCipherSuites == null)) {
        sb.append("preferServerCipherSuites:");
        sb.append(preferServerCipherSuites);
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
  
  public A withCert(SecretOrConfigMap cert) {
    this._visitables.remove("cert");
    if (cert != null) {
        this.cert = new SecretOrConfigMapBuilder(cert);
        this._visitables.get("cert").add(this.cert);
    } else {
        this.cert = null;
        this._visitables.get("cert").remove(this.cert);
    }
    return (A) this;
  }
  
  public A withCertFile(String certFile) {
    this.certFile = certFile;
    return (A) this;
  }
  
  public A withCipherSuites(List<String> cipherSuites) {
    if (cipherSuites != null) {
        this.cipherSuites = new ArrayList();
        for (String item : cipherSuites) {
          this.addToCipherSuites(item);
        }
    } else {
      this.cipherSuites = null;
    }
    return (A) this;
  }
  
  public A withCipherSuites(String... cipherSuites) {
    if (this.cipherSuites != null) {
        this.cipherSuites.clear();
        _visitables.remove("cipherSuites");
    }
    if (cipherSuites != null) {
      for (String item : cipherSuites) {
        this.addToCipherSuites(item);
      }
    }
    return (A) this;
  }
  
  public A withClientAuthType(String clientAuthType) {
    this.clientAuthType = clientAuthType;
    return (A) this;
  }
  
  public A withClientCAFile(String clientCAFile) {
    this.clientCAFile = clientCAFile;
    return (A) this;
  }
  
  public A withClientCa(SecretOrConfigMap clientCa) {
    this._visitables.remove("clientCa");
    if (clientCa != null) {
        this.clientCa = new SecretOrConfigMapBuilder(clientCa);
        this._visitables.get("clientCa").add(this.clientCa);
    } else {
        this.clientCa = null;
        this._visitables.get("clientCa").remove(this.clientCa);
    }
    return (A) this;
  }
  
  public A withCurvePreferences(List<String> curvePreferences) {
    if (curvePreferences != null) {
        this.curvePreferences = new ArrayList();
        for (String item : curvePreferences) {
          this.addToCurvePreferences(item);
        }
    } else {
      this.curvePreferences = null;
    }
    return (A) this;
  }
  
  public A withCurvePreferences(String... curvePreferences) {
    if (this.curvePreferences != null) {
        this.curvePreferences.clear();
        _visitables.remove("curvePreferences");
    }
    if (curvePreferences != null) {
      for (String item : curvePreferences) {
        this.addToCurvePreferences(item);
      }
    }
    return (A) this;
  }
  
  public A withKeyFile(String keyFile) {
    this.keyFile = keyFile;
    return (A) this;
  }
  
  public A withKeySecret(SecretKeySelector keySecret) {
    this.keySecret = keySecret;
    return (A) this;
  }
  
  public A withMaxVersion(String maxVersion) {
    this.maxVersion = maxVersion;
    return (A) this;
  }
  
  public A withMinVersion(String minVersion) {
    this.minVersion = minVersion;
    return (A) this;
  }
  
  public CertNested<A> withNewCert() {
    return new CertNested(null);
  }
  
  public CertNested<A> withNewCertLike(SecretOrConfigMap item) {
    return new CertNested(item);
  }
  
  public ClientCaNested<A> withNewClientCa() {
    return new ClientCaNested(null);
  }
  
  public ClientCaNested<A> withNewClientCaLike(SecretOrConfigMap item) {
    return new ClientCaNested(item);
  }
  
  public A withNewKeySecret(String key,String name,Boolean optional) {
    return (A) this.withKeySecret(new SecretKeySelector(key, name, optional));
  }
  
  public A withPreferServerCipherSuites() {
    return withPreferServerCipherSuites(true);
  }
  
  public A withPreferServerCipherSuites(Boolean preferServerCipherSuites) {
    this.preferServerCipherSuites = preferServerCipherSuites;
    return (A) this;
  }
  public class CertNested<N> extends SecretOrConfigMapFluent<CertNested<N>> implements Nested<N>{
  
    SecretOrConfigMapBuilder builder;
  
    CertNested(SecretOrConfigMap item) {
      this.builder = new SecretOrConfigMapBuilder(this, item);
    }
  
    public N and() {
      return (N) WebTLSConfigFluent.this.withCert(builder.build());
    }
    
    public N endCert() {
      return and();
    }
    
  }
  public class ClientCaNested<N> extends SecretOrConfigMapFluent<ClientCaNested<N>> implements Nested<N>{
  
    SecretOrConfigMapBuilder builder;
  
    ClientCaNested(SecretOrConfigMap item) {
      this.builder = new SecretOrConfigMapBuilder(this, item);
    }
  
    public N and() {
      return (N) WebTLSConfigFluent.this.withClientCa(builder.build());
    }
    
    public N endClientCa() {
      return and();
    }
    
  }
}