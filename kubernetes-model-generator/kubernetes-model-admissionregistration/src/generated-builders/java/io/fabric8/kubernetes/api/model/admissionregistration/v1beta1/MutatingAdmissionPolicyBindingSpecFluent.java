package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

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
public class MutatingAdmissionPolicyBindingSpecFluent<A extends io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingAdmissionPolicyBindingSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MatchResourcesBuilder matchResources;
  private ParamRefBuilder paramRef;
  private String policyName;

  public MutatingAdmissionPolicyBindingSpecFluent() {
  }
  
  public MutatingAdmissionPolicyBindingSpecFluent(MutatingAdmissionPolicyBindingSpec instance) {
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
  
  public MatchResources buildMatchResources() {
    return this.matchResources != null ? this.matchResources.build() : null;
  }
  
  public ParamRef buildParamRef() {
    return this.paramRef != null ? this.paramRef.build() : null;
  }
  
  protected void copyInstance(MutatingAdmissionPolicyBindingSpec instance) {
    instance = instance != null ? instance : new MutatingAdmissionPolicyBindingSpec();
    if (instance != null) {
        this.withMatchResources(instance.getMatchResources());
        this.withParamRef(instance.getParamRef());
        this.withPolicyName(instance.getPolicyName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchResourcesNested<A> editMatchResources() {
    return this.withNewMatchResourcesLike(Optional.ofNullable(this.buildMatchResources()).orElse(null));
  }
  
  public MatchResourcesNested<A> editOrNewMatchResources() {
    return this.withNewMatchResourcesLike(Optional.ofNullable(this.buildMatchResources()).orElse(new MatchResourcesBuilder().build()));
  }
  
  public MatchResourcesNested<A> editOrNewMatchResourcesLike(MatchResources item) {
    return this.withNewMatchResourcesLike(Optional.ofNullable(this.buildMatchResources()).orElse(item));
  }
  
  public ParamRefNested<A> editOrNewParamRef() {
    return this.withNewParamRefLike(Optional.ofNullable(this.buildParamRef()).orElse(new ParamRefBuilder().build()));
  }
  
  public ParamRefNested<A> editOrNewParamRefLike(ParamRef item) {
    return this.withNewParamRefLike(Optional.ofNullable(this.buildParamRef()).orElse(item));
  }
  
  public ParamRefNested<A> editParamRef() {
    return this.withNewParamRefLike(Optional.ofNullable(this.buildParamRef()).orElse(null));
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
    MutatingAdmissionPolicyBindingSpecFluent that = (MutatingAdmissionPolicyBindingSpecFluent) o;
    if (!(Objects.equals(matchResources, that.matchResources))) {
      return false;
    }
    if (!(Objects.equals(paramRef, that.paramRef))) {
      return false;
    }
    if (!(Objects.equals(policyName, that.policyName))) {
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
  
  public String getPolicyName() {
    return this.policyName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchResources() {
    return this.matchResources != null;
  }
  
  public boolean hasParamRef() {
    return this.paramRef != null;
  }
  
  public boolean hasPolicyName() {
    return this.policyName != null;
  }
  
  public int hashCode() {
    return Objects.hash(matchResources, paramRef, policyName, additionalProperties);
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
    if (!(matchResources == null)) {
        sb.append("matchResources:");
        sb.append(matchResources);
        sb.append(",");
    }
    if (!(paramRef == null)) {
        sb.append("paramRef:");
        sb.append(paramRef);
        sb.append(",");
    }
    if (!(policyName == null)) {
        sb.append("policyName:");
        sb.append(policyName);
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
  
  public A withMatchResources(MatchResources matchResources) {
    this._visitables.remove("matchResources");
    if (matchResources != null) {
        this.matchResources = new MatchResourcesBuilder(matchResources);
        this._visitables.get("matchResources").add(this.matchResources);
    } else {
        this.matchResources = null;
        this._visitables.get("matchResources").remove(this.matchResources);
    }
    return (A) this;
  }
  
  public MatchResourcesNested<A> withNewMatchResources() {
    return new MatchResourcesNested(null);
  }
  
  public MatchResourcesNested<A> withNewMatchResourcesLike(MatchResources item) {
    return new MatchResourcesNested(item);
  }
  
  public ParamRefNested<A> withNewParamRef() {
    return new ParamRefNested(null);
  }
  
  public ParamRefNested<A> withNewParamRefLike(ParamRef item) {
    return new ParamRefNested(item);
  }
  
  public A withParamRef(ParamRef paramRef) {
    this._visitables.remove("paramRef");
    if (paramRef != null) {
        this.paramRef = new ParamRefBuilder(paramRef);
        this._visitables.get("paramRef").add(this.paramRef);
    } else {
        this.paramRef = null;
        this._visitables.get("paramRef").remove(this.paramRef);
    }
    return (A) this;
  }
  
  public A withPolicyName(String policyName) {
    this.policyName = policyName;
    return (A) this;
  }
  public class MatchResourcesNested<N> extends MatchResourcesFluent<MatchResourcesNested<N>> implements Nested<N>{
  
    MatchResourcesBuilder builder;
  
    MatchResourcesNested(MatchResources item) {
      this.builder = new MatchResourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingAdmissionPolicyBindingSpecFluent.this.withMatchResources(builder.build());
    }
    
    public N endMatchResources() {
      return and();
    }
    
  }
  public class ParamRefNested<N> extends ParamRefFluent<ParamRefNested<N>> implements Nested<N>{
  
    ParamRefBuilder builder;
  
    ParamRefNested(ParamRef item) {
      this.builder = new ParamRefBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingAdmissionPolicyBindingSpecFluent.this.withParamRef(builder.build());
    }
    
    public N endParamRef() {
      return and();
    }
    
  }
}