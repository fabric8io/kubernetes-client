package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class TLSConfigFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.TLSConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private FrontendTLSValidationBuilder validation;

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
  
  public FrontendTLSValidation buildValidation() {
    return this.validation != null ? this.validation.build() : null;
  }
  
  protected void copyInstance(TLSConfig instance) {
    instance = instance != null ? instance : new TLSConfig();
    if (instance != null) {
        this.withValidation(instance.getValidation());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ValidationNested<A> editOrNewValidation() {
    return this.withNewValidationLike(Optional.ofNullable(this.buildValidation()).orElse(new FrontendTLSValidationBuilder().build()));
  }
  
  public ValidationNested<A> editOrNewValidationLike(FrontendTLSValidation item) {
    return this.withNewValidationLike(Optional.ofNullable(this.buildValidation()).orElse(item));
  }
  
  public ValidationNested<A> editValidation() {
    return this.withNewValidationLike(Optional.ofNullable(this.buildValidation()).orElse(null));
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
    if (!(Objects.equals(validation, that.validation))) {
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
  
  public boolean hasValidation() {
    return this.validation != null;
  }
  
  public int hashCode() {
    return Objects.hash(validation, additionalProperties);
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
    if (!(validation == null)) {
        sb.append("validation:");
        sb.append(validation);
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
  
  public ValidationNested<A> withNewValidation() {
    return new ValidationNested(null);
  }
  
  public ValidationNested<A> withNewValidationLike(FrontendTLSValidation item) {
    return new ValidationNested(item);
  }
  
  public A withValidation(FrontendTLSValidation validation) {
    this._visitables.remove("validation");
    if (validation != null) {
        this.validation = new FrontendTLSValidationBuilder(validation);
        this._visitables.get("validation").add(this.validation);
    } else {
        this.validation = null;
        this._visitables.get("validation").remove(this.validation);
    }
    return (A) this;
  }
  public class ValidationNested<N> extends FrontendTLSValidationFluent<ValidationNested<N>> implements Nested<N>{
  
    FrontendTLSValidationBuilder builder;
  
    ValidationNested(FrontendTLSValidation item) {
      this.builder = new FrontendTLSValidationBuilder(this, item);
    }
  
    public N and() {
      return (N) TLSConfigFluent.this.withValidation(builder.build());
    }
    
    public N endValidation() {
      return and();
    }
    
  }
}