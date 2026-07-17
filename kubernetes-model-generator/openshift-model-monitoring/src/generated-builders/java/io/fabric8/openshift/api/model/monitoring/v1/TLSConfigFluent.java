package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class TLSConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.TLSConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretOrConfigMapBuilder ca;
  private String caFile;
  private SecretOrConfigMapBuilder cert;
  private String certFile;
  private Boolean insecureSkipVerify;
  private String keyFile;
  private SecretKeySelector keySecret;
  private String maxVersion;
  private String minVersion;
  private String serverName;

  public TLSConfigFluent() {
  }
  
  public TLSConfigFluent(TLSConfig instance) {
    this.copyInstance(instance);
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
  
  public SecretOrConfigMap buildCa() {
    return this.ca != null ? this.ca.build() : null;
  }
  
  public SecretOrConfigMap buildCert() {
    return this.cert != null ? this.cert.build() : null;
  }
  
  protected void copyInstance(TLSConfig instance) {
    instance = instance != null ? instance : new TLSConfig();
    if (instance != null) {
        this.withCa(instance.getCa());
        this.withCaFile(instance.getCaFile());
        this.withCert(instance.getCert());
        this.withCertFile(instance.getCertFile());
        this.withInsecureSkipVerify(instance.getInsecureSkipVerify());
        this.withKeyFile(instance.getKeyFile());
        this.withKeySecret(instance.getKeySecret());
        this.withMaxVersion(instance.getMaxVersion());
        this.withMinVersion(instance.getMinVersion());
        this.withServerName(instance.getServerName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CaNested<A> editCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(null));
  }
  
  public CertNested<A> editCert() {
    return this.withNewCertLike(Optional.ofNullable(this.buildCert()).orElse(null));
  }
  
  public CaNested<A> editOrNewCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(new SecretOrConfigMapBuilder().build()));
  }
  
  public CaNested<A> editOrNewCaLike(SecretOrConfigMap item) {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(item));
  }
  
  public CertNested<A> editOrNewCert() {
    return this.withNewCertLike(Optional.ofNullable(this.buildCert()).orElse(new SecretOrConfigMapBuilder().build()));
  }
  
  public CertNested<A> editOrNewCertLike(SecretOrConfigMap item) {
    return this.withNewCertLike(Optional.ofNullable(this.buildCert()).orElse(item));
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
    TLSConfigFluent that = (TLSConfigFluent) o;
    if (!(Objects.equals(ca, that.ca))) {
      return false;
    }
    if (!(Objects.equals(caFile, that.caFile))) {
      return false;
    }
    if (!(Objects.equals(cert, that.cert))) {
      return false;
    }
    if (!(Objects.equals(certFile, that.certFile))) {
      return false;
    }
    if (!(Objects.equals(insecureSkipVerify, that.insecureSkipVerify))) {
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
    if (!(Objects.equals(serverName, that.serverName))) {
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
  
  public String getCaFile() {
    return this.caFile;
  }
  
  public String getCertFile() {
    return this.certFile;
  }
  
  public Boolean getInsecureSkipVerify() {
    return this.insecureSkipVerify;
  }
  
  public String getKeyFile() {
    return this.keyFile;
  }
  
  public SecretKeySelector getKeySecret() {
    return this.keySecret;
  }
  
  public String getMaxVersion() {
    return this.maxVersion;
  }
  
  public String getMinVersion() {
    return this.minVersion;
  }
  
  public String getServerName() {
    return this.serverName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCa() {
    return this.ca != null;
  }
  
  public boolean hasCaFile() {
    return this.caFile != null;
  }
  
  public boolean hasCert() {
    return this.cert != null;
  }
  
  public boolean hasCertFile() {
    return this.certFile != null;
  }
  
  public boolean hasInsecureSkipVerify() {
    return this.insecureSkipVerify != null;
  }
  
  public boolean hasKeyFile() {
    return this.keyFile != null;
  }
  
  public boolean hasKeySecret() {
    return this.keySecret != null;
  }
  
  public boolean hasMaxVersion() {
    return this.maxVersion != null;
  }
  
  public boolean hasMinVersion() {
    return this.minVersion != null;
  }
  
  public boolean hasServerName() {
    return this.serverName != null;
  }
  
  public int hashCode() {
    return Objects.hash(ca, caFile, cert, certFile, insecureSkipVerify, keyFile, keySecret, maxVersion, minVersion, serverName, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ca == null)) {
        sb.append("ca:");
        sb.append(ca);
        sb.append(",");
    }
    if (!(caFile == null)) {
        sb.append("caFile:");
        sb.append(caFile);
        sb.append(",");
    }
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
    if (!(insecureSkipVerify == null)) {
        sb.append("insecureSkipVerify:");
        sb.append(insecureSkipVerify);
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
    if (!(serverName == null)) {
        sb.append("serverName:");
        sb.append(serverName);
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
  
  public A withCa(SecretOrConfigMap ca) {
    this._visitables.remove("ca");
    if (ca != null) {
        this.ca = new SecretOrConfigMapBuilder(ca);
        this._visitables.get("ca").add(this.ca);
    } else {
        this.ca = null;
        this._visitables.get("ca").remove(this.ca);
    }
    return (A) this;
  }
  
  public A withCaFile(String caFile) {
    this.caFile = caFile;
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
  
  public A withInsecureSkipVerify() {
    return withInsecureSkipVerify(true);
  }
  
  public A withInsecureSkipVerify(Boolean insecureSkipVerify) {
    this.insecureSkipVerify = insecureSkipVerify;
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
  
  public CaNested<A> withNewCa() {
    return new CaNested(null);
  }
  
  public CaNested<A> withNewCaLike(SecretOrConfigMap item) {
    return new CaNested(item);
  }
  
  public CertNested<A> withNewCert() {
    return new CertNested(null);
  }
  
  public CertNested<A> withNewCertLike(SecretOrConfigMap item) {
    return new CertNested(item);
  }
  
  public A withNewKeySecret(String key,String name,Boolean optional) {
    return (A) this.withKeySecret(new SecretKeySelector(key, name, optional));
  }
  
  public A withServerName(String serverName) {
    this.serverName = serverName;
    return (A) this;
  }
  public class CaNested<N> extends SecretOrConfigMapFluent<CaNested<N>> implements Nested<N>{
  
    SecretOrConfigMapBuilder builder;
  
    CaNested(SecretOrConfigMap item) {
      this.builder = new SecretOrConfigMapBuilder(this, item);
    }
  
    public N and() {
      return (N) TLSConfigFluent.this.withCa(builder.build());
    }
    
    public N endCa() {
      return and();
    }
    
  }
  public class CertNested<N> extends SecretOrConfigMapFluent<CertNested<N>> implements Nested<N>{
  
    SecretOrConfigMapBuilder builder;
  
    CertNested(SecretOrConfigMap item) {
      this.builder = new SecretOrConfigMapBuilder(this, item);
    }
  
    public N and() {
      return (N) TLSConfigFluent.this.withCert(builder.build());
    }
    
    public N endCert() {
      return and();
    }
    
  }
}