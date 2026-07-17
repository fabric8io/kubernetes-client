package io.fabric8.openshift.api.model.config.v1;

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
public class FulcioCAWithRekorFluent<A extends io.fabric8.openshift.api.model.config.v1.FulcioCAWithRekorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String fulcioCAData;
  private PolicyFulcioSubjectBuilder fulcioSubject;
  private String rekorKeyData;

  public FulcioCAWithRekorFluent() {
  }
  
  public FulcioCAWithRekorFluent(FulcioCAWithRekor instance) {
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
  
  public PolicyFulcioSubject buildFulcioSubject() {
    return this.fulcioSubject != null ? this.fulcioSubject.build() : null;
  }
  
  protected void copyInstance(FulcioCAWithRekor instance) {
    instance = instance != null ? instance : new FulcioCAWithRekor();
    if (instance != null) {
        this.withFulcioCAData(instance.getFulcioCAData());
        this.withFulcioSubject(instance.getFulcioSubject());
        this.withRekorKeyData(instance.getRekorKeyData());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FulcioSubjectNested<A> editFulcioSubject() {
    return this.withNewFulcioSubjectLike(Optional.ofNullable(this.buildFulcioSubject()).orElse(null));
  }
  
  public FulcioSubjectNested<A> editOrNewFulcioSubject() {
    return this.withNewFulcioSubjectLike(Optional.ofNullable(this.buildFulcioSubject()).orElse(new PolicyFulcioSubjectBuilder().build()));
  }
  
  public FulcioSubjectNested<A> editOrNewFulcioSubjectLike(PolicyFulcioSubject item) {
    return this.withNewFulcioSubjectLike(Optional.ofNullable(this.buildFulcioSubject()).orElse(item));
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
    FulcioCAWithRekorFluent that = (FulcioCAWithRekorFluent) o;
    if (!(Objects.equals(fulcioCAData, that.fulcioCAData))) {
      return false;
    }
    if (!(Objects.equals(fulcioSubject, that.fulcioSubject))) {
      return false;
    }
    if (!(Objects.equals(rekorKeyData, that.rekorKeyData))) {
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
  
  public String getFulcioCAData() {
    return this.fulcioCAData;
  }
  
  public String getRekorKeyData() {
    return this.rekorKeyData;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFulcioCAData() {
    return this.fulcioCAData != null;
  }
  
  public boolean hasFulcioSubject() {
    return this.fulcioSubject != null;
  }
  
  public boolean hasRekorKeyData() {
    return this.rekorKeyData != null;
  }
  
  public int hashCode() {
    return Objects.hash(fulcioCAData, fulcioSubject, rekorKeyData, additionalProperties);
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
    if (!(fulcioCAData == null)) {
        sb.append("fulcioCAData:");
        sb.append(fulcioCAData);
        sb.append(",");
    }
    if (!(fulcioSubject == null)) {
        sb.append("fulcioSubject:");
        sb.append(fulcioSubject);
        sb.append(",");
    }
    if (!(rekorKeyData == null)) {
        sb.append("rekorKeyData:");
        sb.append(rekorKeyData);
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
  
  public A withFulcioCAData(String fulcioCAData) {
    this.fulcioCAData = fulcioCAData;
    return (A) this;
  }
  
  public A withFulcioSubject(PolicyFulcioSubject fulcioSubject) {
    this._visitables.remove("fulcioSubject");
    if (fulcioSubject != null) {
        this.fulcioSubject = new PolicyFulcioSubjectBuilder(fulcioSubject);
        this._visitables.get("fulcioSubject").add(this.fulcioSubject);
    } else {
        this.fulcioSubject = null;
        this._visitables.get("fulcioSubject").remove(this.fulcioSubject);
    }
    return (A) this;
  }
  
  public FulcioSubjectNested<A> withNewFulcioSubject() {
    return new FulcioSubjectNested(null);
  }
  
  public A withNewFulcioSubject(String oidcIssuer,String signedEmail) {
    return (A) this.withFulcioSubject(new PolicyFulcioSubject(oidcIssuer, signedEmail));
  }
  
  public FulcioSubjectNested<A> withNewFulcioSubjectLike(PolicyFulcioSubject item) {
    return new FulcioSubjectNested(item);
  }
  
  public A withRekorKeyData(String rekorKeyData) {
    this.rekorKeyData = rekorKeyData;
    return (A) this;
  }
  public class FulcioSubjectNested<N> extends PolicyFulcioSubjectFluent<FulcioSubjectNested<N>> implements Nested<N>{
  
    PolicyFulcioSubjectBuilder builder;
  
    FulcioSubjectNested(PolicyFulcioSubject item) {
      this.builder = new PolicyFulcioSubjectBuilder(this, item);
    }
  
    public N and() {
      return (N) FulcioCAWithRekorFluent.this.withFulcioSubject(builder.build());
    }
    
    public N endFulcioSubject() {
      return and();
    }
    
  }
}