package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

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
public class CustomResourceValidationFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceValidationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private JSONSchemaPropsBuilder openAPIV3Schema;

  public CustomResourceValidationFluent() {
  }
  
  public CustomResourceValidationFluent(CustomResourceValidation instance) {
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
  
  public JSONSchemaProps buildOpenAPIV3Schema() {
    return this.openAPIV3Schema != null ? this.openAPIV3Schema.build() : null;
  }
  
  protected void copyInstance(CustomResourceValidation instance) {
    instance = instance != null ? instance : new CustomResourceValidation();
    if (instance != null) {
        this.withOpenAPIV3Schema(instance.getOpenAPIV3Schema());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OpenAPIV3SchemaNested<A> editOpenAPIV3Schema() {
    return this.withNewOpenAPIV3SchemaLike(Optional.ofNullable(this.buildOpenAPIV3Schema()).orElse(null));
  }
  
  public OpenAPIV3SchemaNested<A> editOrNewOpenAPIV3Schema() {
    return this.withNewOpenAPIV3SchemaLike(Optional.ofNullable(this.buildOpenAPIV3Schema()).orElse(new JSONSchemaPropsBuilder().build()));
  }
  
  public OpenAPIV3SchemaNested<A> editOrNewOpenAPIV3SchemaLike(JSONSchemaProps item) {
    return this.withNewOpenAPIV3SchemaLike(Optional.ofNullable(this.buildOpenAPIV3Schema()).orElse(item));
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
    CustomResourceValidationFluent that = (CustomResourceValidationFluent) o;
    if (!(Objects.equals(openAPIV3Schema, that.openAPIV3Schema))) {
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
  
  public boolean hasOpenAPIV3Schema() {
    return this.openAPIV3Schema != null;
  }
  
  public int hashCode() {
    return Objects.hash(openAPIV3Schema, additionalProperties);
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
    if (!(openAPIV3Schema == null)) {
        sb.append("openAPIV3Schema:");
        sb.append(openAPIV3Schema);
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
  
  public OpenAPIV3SchemaNested<A> withNewOpenAPIV3Schema() {
    return new OpenAPIV3SchemaNested(null);
  }
  
  public OpenAPIV3SchemaNested<A> withNewOpenAPIV3SchemaLike(JSONSchemaProps item) {
    return new OpenAPIV3SchemaNested(item);
  }
  
  public A withOpenAPIV3Schema(JSONSchemaProps openAPIV3Schema) {
    this._visitables.remove("openAPIV3Schema");
    if (openAPIV3Schema != null) {
        this.openAPIV3Schema = new JSONSchemaPropsBuilder(openAPIV3Schema);
        this._visitables.get("openAPIV3Schema").add(this.openAPIV3Schema);
    } else {
        this.openAPIV3Schema = null;
        this._visitables.get("openAPIV3Schema").remove(this.openAPIV3Schema);
    }
    return (A) this;
  }
  public class OpenAPIV3SchemaNested<N> extends JSONSchemaPropsFluent<OpenAPIV3SchemaNested<N>> implements Nested<N>{
  
    JSONSchemaPropsBuilder builder;
  
    OpenAPIV3SchemaNested(JSONSchemaProps item) {
      this.builder = new JSONSchemaPropsBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceValidationFluent.this.withOpenAPIV3Schema(builder.build());
    }
    
    public N endOpenAPIV3Schema() {
      return and();
    }
    
  }
}