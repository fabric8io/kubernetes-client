package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

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
public class MutationFluent<A extends io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1.MutationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ApplyConfigurationBuilder applyConfiguration;
  private JSONPatchBuilder jsonPatch;
  private String patchType;

  public MutationFluent() {
  }
  
  public MutationFluent(Mutation instance) {
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
  
  public ApplyConfiguration buildApplyConfiguration() {
    return this.applyConfiguration != null ? this.applyConfiguration.build() : null;
  }
  
  public JSONPatch buildJsonPatch() {
    return this.jsonPatch != null ? this.jsonPatch.build() : null;
  }
  
  protected void copyInstance(Mutation instance) {
    instance = instance != null ? instance : new Mutation();
    if (instance != null) {
        this.withApplyConfiguration(instance.getApplyConfiguration());
        this.withJsonPatch(instance.getJsonPatch());
        this.withPatchType(instance.getPatchType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ApplyConfigurationNested<A> editApplyConfiguration() {
    return this.withNewApplyConfigurationLike(Optional.ofNullable(this.buildApplyConfiguration()).orElse(null));
  }
  
  public JsonPatchNested<A> editJsonPatch() {
    return this.withNewJsonPatchLike(Optional.ofNullable(this.buildJsonPatch()).orElse(null));
  }
  
  public ApplyConfigurationNested<A> editOrNewApplyConfiguration() {
    return this.withNewApplyConfigurationLike(Optional.ofNullable(this.buildApplyConfiguration()).orElse(new ApplyConfigurationBuilder().build()));
  }
  
  public ApplyConfigurationNested<A> editOrNewApplyConfigurationLike(ApplyConfiguration item) {
    return this.withNewApplyConfigurationLike(Optional.ofNullable(this.buildApplyConfiguration()).orElse(item));
  }
  
  public JsonPatchNested<A> editOrNewJsonPatch() {
    return this.withNewJsonPatchLike(Optional.ofNullable(this.buildJsonPatch()).orElse(new JSONPatchBuilder().build()));
  }
  
  public JsonPatchNested<A> editOrNewJsonPatchLike(JSONPatch item) {
    return this.withNewJsonPatchLike(Optional.ofNullable(this.buildJsonPatch()).orElse(item));
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
    MutationFluent that = (MutationFluent) o;
    if (!(Objects.equals(applyConfiguration, that.applyConfiguration))) {
      return false;
    }
    if (!(Objects.equals(jsonPatch, that.jsonPatch))) {
      return false;
    }
    if (!(Objects.equals(patchType, that.patchType))) {
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
  
  public String getPatchType() {
    return this.patchType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApplyConfiguration() {
    return this.applyConfiguration != null;
  }
  
  public boolean hasJsonPatch() {
    return this.jsonPatch != null;
  }
  
  public boolean hasPatchType() {
    return this.patchType != null;
  }
  
  public int hashCode() {
    return Objects.hash(applyConfiguration, jsonPatch, patchType, additionalProperties);
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
    if (!(applyConfiguration == null)) {
        sb.append("applyConfiguration:");
        sb.append(applyConfiguration);
        sb.append(",");
    }
    if (!(jsonPatch == null)) {
        sb.append("jsonPatch:");
        sb.append(jsonPatch);
        sb.append(",");
    }
    if (!(patchType == null)) {
        sb.append("patchType:");
        sb.append(patchType);
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
  
  public A withApplyConfiguration(ApplyConfiguration applyConfiguration) {
    this._visitables.remove("applyConfiguration");
    if (applyConfiguration != null) {
        this.applyConfiguration = new ApplyConfigurationBuilder(applyConfiguration);
        this._visitables.get("applyConfiguration").add(this.applyConfiguration);
    } else {
        this.applyConfiguration = null;
        this._visitables.get("applyConfiguration").remove(this.applyConfiguration);
    }
    return (A) this;
  }
  
  public A withJsonPatch(JSONPatch jsonPatch) {
    this._visitables.remove("jsonPatch");
    if (jsonPatch != null) {
        this.jsonPatch = new JSONPatchBuilder(jsonPatch);
        this._visitables.get("jsonPatch").add(this.jsonPatch);
    } else {
        this.jsonPatch = null;
        this._visitables.get("jsonPatch").remove(this.jsonPatch);
    }
    return (A) this;
  }
  
  public ApplyConfigurationNested<A> withNewApplyConfiguration() {
    return new ApplyConfigurationNested(null);
  }
  
  public A withNewApplyConfiguration(String expression) {
    return (A) this.withApplyConfiguration(new ApplyConfiguration(expression));
  }
  
  public ApplyConfigurationNested<A> withNewApplyConfigurationLike(ApplyConfiguration item) {
    return new ApplyConfigurationNested(item);
  }
  
  public JsonPatchNested<A> withNewJsonPatch() {
    return new JsonPatchNested(null);
  }
  
  public A withNewJsonPatch(String expression) {
    return (A) this.withJsonPatch(new JSONPatch(expression));
  }
  
  public JsonPatchNested<A> withNewJsonPatchLike(JSONPatch item) {
    return new JsonPatchNested(item);
  }
  
  public A withPatchType(String patchType) {
    this.patchType = patchType;
    return (A) this;
  }
  public class ApplyConfigurationNested<N> extends ApplyConfigurationFluent<ApplyConfigurationNested<N>> implements Nested<N>{
  
    ApplyConfigurationBuilder builder;
  
    ApplyConfigurationNested(ApplyConfiguration item) {
      this.builder = new ApplyConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) MutationFluent.this.withApplyConfiguration(builder.build());
    }
    
    public N endApplyConfiguration() {
      return and();
    }
    
  }
  public class JsonPatchNested<N> extends JSONPatchFluent<JsonPatchNested<N>> implements Nested<N>{
  
    JSONPatchBuilder builder;
  
    JsonPatchNested(JSONPatch item) {
      this.builder = new JSONPatchBuilder(this, item);
    }
  
    public N and() {
      return (N) MutationFluent.this.withJsonPatch(builder.build());
    }
    
    public N endJsonPatch() {
      return and();
    }
    
  }
}