package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorBuilder;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ACMEIssuerDNS01ProviderRFC2136Fluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderRFC2136Fluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String nameserver;
  private String protocol;
  private String tsigAlgorithm;
  private String tsigKeyName;
  private SecretKeySelectorBuilder tsigSecretSecretRef;

  public ACMEIssuerDNS01ProviderRFC2136Fluent() {
  }
  
  public ACMEIssuerDNS01ProviderRFC2136Fluent(ACMEIssuerDNS01ProviderRFC2136 instance) {
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
  
  public SecretKeySelector buildTsigSecretSecretRef() {
    return this.tsigSecretSecretRef != null ? this.tsigSecretSecretRef.build() : null;
  }
  
  protected void copyInstance(ACMEIssuerDNS01ProviderRFC2136 instance) {
    instance = instance != null ? instance : new ACMEIssuerDNS01ProviderRFC2136();
    if (instance != null) {
        this.withNameserver(instance.getNameserver());
        this.withProtocol(instance.getProtocol());
        this.withTsigAlgorithm(instance.getTsigAlgorithm());
        this.withTsigKeyName(instance.getTsigKeyName());
        this.withTsigSecretSecretRef(instance.getTsigSecretSecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TsigSecretSecretRefNested<A> editOrNewTsigSecretSecretRef() {
    return this.withNewTsigSecretSecretRefLike(Optional.ofNullable(this.buildTsigSecretSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public TsigSecretSecretRefNested<A> editOrNewTsigSecretSecretRefLike(SecretKeySelector item) {
    return this.withNewTsigSecretSecretRefLike(Optional.ofNullable(this.buildTsigSecretSecretRef()).orElse(item));
  }
  
  public TsigSecretSecretRefNested<A> editTsigSecretSecretRef() {
    return this.withNewTsigSecretSecretRefLike(Optional.ofNullable(this.buildTsigSecretSecretRef()).orElse(null));
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
    ACMEIssuerDNS01ProviderRFC2136Fluent that = (ACMEIssuerDNS01ProviderRFC2136Fluent) o;
    if (!(Objects.equals(nameserver, that.nameserver))) {
      return false;
    }
    if (!(Objects.equals(protocol, that.protocol))) {
      return false;
    }
    if (!(Objects.equals(tsigAlgorithm, that.tsigAlgorithm))) {
      return false;
    }
    if (!(Objects.equals(tsigKeyName, that.tsigKeyName))) {
      return false;
    }
    if (!(Objects.equals(tsigSecretSecretRef, that.tsigSecretSecretRef))) {
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
  
  public String getNameserver() {
    return this.nameserver;
  }
  
  public String getProtocol() {
    return this.protocol;
  }
  
  public String getTsigAlgorithm() {
    return this.tsigAlgorithm;
  }
  
  public String getTsigKeyName() {
    return this.tsigKeyName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasNameserver() {
    return this.nameserver != null;
  }
  
  public boolean hasProtocol() {
    return this.protocol != null;
  }
  
  public boolean hasTsigAlgorithm() {
    return this.tsigAlgorithm != null;
  }
  
  public boolean hasTsigKeyName() {
    return this.tsigKeyName != null;
  }
  
  public boolean hasTsigSecretSecretRef() {
    return this.tsigSecretSecretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(nameserver, protocol, tsigAlgorithm, tsigKeyName, tsigSecretSecretRef, additionalProperties);
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
    if (!(nameserver == null)) {
        sb.append("nameserver:");
        sb.append(nameserver);
        sb.append(",");
    }
    if (!(protocol == null)) {
        sb.append("protocol:");
        sb.append(protocol);
        sb.append(",");
    }
    if (!(tsigAlgorithm == null)) {
        sb.append("tsigAlgorithm:");
        sb.append(tsigAlgorithm);
        sb.append(",");
    }
    if (!(tsigKeyName == null)) {
        sb.append("tsigKeyName:");
        sb.append(tsigKeyName);
        sb.append(",");
    }
    if (!(tsigSecretSecretRef == null)) {
        sb.append("tsigSecretSecretRef:");
        sb.append(tsigSecretSecretRef);
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
  
  public A withNameserver(String nameserver) {
    this.nameserver = nameserver;
    return (A) this;
  }
  
  public TsigSecretSecretRefNested<A> withNewTsigSecretSecretRef() {
    return new TsigSecretSecretRefNested(null);
  }
  
  public A withNewTsigSecretSecretRef(String key,String name) {
    return (A) this.withTsigSecretSecretRef(new SecretKeySelector(key, name));
  }
  
  public TsigSecretSecretRefNested<A> withNewTsigSecretSecretRefLike(SecretKeySelector item) {
    return new TsigSecretSecretRefNested(item);
  }
  
  public A withProtocol(String protocol) {
    this.protocol = protocol;
    return (A) this;
  }
  
  public A withTsigAlgorithm(String tsigAlgorithm) {
    this.tsigAlgorithm = tsigAlgorithm;
    return (A) this;
  }
  
  public A withTsigKeyName(String tsigKeyName) {
    this.tsigKeyName = tsigKeyName;
    return (A) this;
  }
  
  public A withTsigSecretSecretRef(SecretKeySelector tsigSecretSecretRef) {
    this._visitables.remove("tsigSecretSecretRef");
    if (tsigSecretSecretRef != null) {
        this.tsigSecretSecretRef = new SecretKeySelectorBuilder(tsigSecretSecretRef);
        this._visitables.get("tsigSecretSecretRef").add(this.tsigSecretSecretRef);
    } else {
        this.tsigSecretSecretRef = null;
        this._visitables.get("tsigSecretSecretRef").remove(this.tsigSecretSecretRef);
    }
    return (A) this;
  }
  public class TsigSecretSecretRefNested<N> extends SecretKeySelectorFluent<TsigSecretSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    TsigSecretSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderRFC2136Fluent.this.withTsigSecretSecretRef(builder.build());
    }
    
    public N endTsigSecretSecretRef() {
      return and();
    }
    
  }
}