package io.fabric8.certmanager.api.model.acme.v1;

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
public class ACMEChallengeSolverFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ACMEChallengeSolverDNS01Builder dns01;
  private ACMEChallengeSolverHTTP01Builder http01;
  private CertificateDNSNameSelectorBuilder selector;

  public ACMEChallengeSolverFluent() {
  }
  
  public ACMEChallengeSolverFluent(ACMEChallengeSolver instance) {
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
  
  public ACMEChallengeSolverDNS01 buildDns01() {
    return this.dns01 != null ? this.dns01.build() : null;
  }
  
  public ACMEChallengeSolverHTTP01 buildHttp01() {
    return this.http01 != null ? this.http01.build() : null;
  }
  
  public CertificateDNSNameSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(ACMEChallengeSolver instance) {
    instance = instance != null ? instance : new ACMEChallengeSolver();
    if (instance != null) {
        this.withDns01(instance.getDns01());
        this.withHttp01(instance.getHttp01());
        this.withSelector(instance.getSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public Dns01Nested<A> editDns01() {
    return this.withNewDns01Like(Optional.ofNullable(this.buildDns01()).orElse(null));
  }
  
  public Http01Nested<A> editHttp01() {
    return this.withNewHttp01Like(Optional.ofNullable(this.buildHttp01()).orElse(null));
  }
  
  public Dns01Nested<A> editOrNewDns01() {
    return this.withNewDns01Like(Optional.ofNullable(this.buildDns01()).orElse(new ACMEChallengeSolverDNS01Builder().build()));
  }
  
  public Dns01Nested<A> editOrNewDns01Like(ACMEChallengeSolverDNS01 item) {
    return this.withNewDns01Like(Optional.ofNullable(this.buildDns01()).orElse(item));
  }
  
  public Http01Nested<A> editOrNewHttp01() {
    return this.withNewHttp01Like(Optional.ofNullable(this.buildHttp01()).orElse(new ACMEChallengeSolverHTTP01Builder().build()));
  }
  
  public Http01Nested<A> editOrNewHttp01Like(ACMEChallengeSolverHTTP01 item) {
    return this.withNewHttp01Like(Optional.ofNullable(this.buildHttp01()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new CertificateDNSNameSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(CertificateDNSNameSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    ACMEChallengeSolverFluent that = (ACMEChallengeSolverFluent) o;
    if (!(Objects.equals(dns01, that.dns01))) {
      return false;
    }
    if (!(Objects.equals(http01, that.http01))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDns01() {
    return this.dns01 != null;
  }
  
  public boolean hasHttp01() {
    return this.http01 != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public int hashCode() {
    return Objects.hash(dns01, http01, selector, additionalProperties);
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
    if (!(dns01 == null)) {
        sb.append("dns01:");
        sb.append(dns01);
        sb.append(",");
    }
    if (!(http01 == null)) {
        sb.append("http01:");
        sb.append(http01);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
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
  
  public A withDns01(ACMEChallengeSolverDNS01 dns01) {
    this._visitables.remove("dns01");
    if (dns01 != null) {
        this.dns01 = new ACMEChallengeSolverDNS01Builder(dns01);
        this._visitables.get("dns01").add(this.dns01);
    } else {
        this.dns01 = null;
        this._visitables.get("dns01").remove(this.dns01);
    }
    return (A) this;
  }
  
  public A withHttp01(ACMEChallengeSolverHTTP01 http01) {
    this._visitables.remove("http01");
    if (http01 != null) {
        this.http01 = new ACMEChallengeSolverHTTP01Builder(http01);
        this._visitables.get("http01").add(this.http01);
    } else {
        this.http01 = null;
        this._visitables.get("http01").remove(this.http01);
    }
    return (A) this;
  }
  
  public Dns01Nested<A> withNewDns01() {
    return new Dns01Nested(null);
  }
  
  public Dns01Nested<A> withNewDns01Like(ACMEChallengeSolverDNS01 item) {
    return new Dns01Nested(item);
  }
  
  public Http01Nested<A> withNewHttp01() {
    return new Http01Nested(null);
  }
  
  public Http01Nested<A> withNewHttp01Like(ACMEChallengeSolverHTTP01 item) {
    return new Http01Nested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(CertificateDNSNameSelector item) {
    return new SelectorNested(item);
  }
  
  public A withSelector(CertificateDNSNameSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new CertificateDNSNameSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  public class Dns01Nested<N> extends ACMEChallengeSolverDNS01Fluent<Dns01Nested<N>> implements Nested<N>{
  
    ACMEChallengeSolverDNS01Builder builder;
  
    Dns01Nested(ACMEChallengeSolverDNS01 item) {
      this.builder = new ACMEChallengeSolverDNS01Builder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverFluent.this.withDns01(builder.build());
    }
    
    public N endDns01() {
      return and();
    }
    
  }
  public class Http01Nested<N> extends ACMEChallengeSolverHTTP01Fluent<Http01Nested<N>> implements Nested<N>{
  
    ACMEChallengeSolverHTTP01Builder builder;
  
    Http01Nested(ACMEChallengeSolverHTTP01 item) {
      this.builder = new ACMEChallengeSolverHTTP01Builder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverFluent.this.withHttp01(builder.build());
    }
    
    public N endHttp01() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends CertificateDNSNameSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    CertificateDNSNameSelectorBuilder builder;
  
    SelectorNested(CertificateDNSNameSelector item) {
      this.builder = new CertificateDNSNameSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}