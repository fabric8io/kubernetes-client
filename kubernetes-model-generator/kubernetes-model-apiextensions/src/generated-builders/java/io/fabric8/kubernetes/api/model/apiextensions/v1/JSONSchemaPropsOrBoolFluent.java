package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class JSONSchemaPropsOrBoolFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allows;
  private JSONSchemaPropsBuilder schema;

  public JSONSchemaPropsOrBoolFluent() {
  }
  
  public JSONSchemaPropsOrBoolFluent(JSONSchemaPropsOrBool instance) {
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
  
  public JSONSchemaProps buildSchema() {
    return this.schema != null ? this.schema.build() : null;
  }
  
  protected void copyInstance(JSONSchemaPropsOrBool instance) {
    instance = instance != null ? instance : new JSONSchemaPropsOrBool();
    if (instance != null) {
        this.withAllows(instance.getAllows());
        this.withSchema(instance.getSchema());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SchemaNested<A> editOrNewSchema() {
    return this.withNewSchemaLike(Optional.ofNullable(this.buildSchema()).orElse(new JSONSchemaPropsBuilder().build()));
  }
  
  public SchemaNested<A> editOrNewSchemaLike(JSONSchemaProps item) {
    return this.withNewSchemaLike(Optional.ofNullable(this.buildSchema()).orElse(item));
  }
  
  public SchemaNested<A> editSchema() {
    return this.withNewSchemaLike(Optional.ofNullable(this.buildSchema()).orElse(null));
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
    JSONSchemaPropsOrBoolFluent that = (JSONSchemaPropsOrBoolFluent) o;
    if (!(Objects.equals(allows, that.allows))) {
      return false;
    }
    if (!(Objects.equals(schema, that.schema))) {
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
  
  public Boolean getAllows() {
    return this.allows;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllows() {
    return this.allows != null;
  }
  
  public boolean hasSchema() {
    return this.schema != null;
  }
  
  public int hashCode() {
    return Objects.hash(allows, schema, additionalProperties);
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
    if (!(allows == null)) {
        sb.append("allows:");
        sb.append(allows);
        sb.append(",");
    }
    if (!(schema == null)) {
        sb.append("schema:");
        sb.append(schema);
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
  
  public A withAllows() {
    return withAllows(true);
  }
  
  public A withAllows(Boolean allows) {
    this.allows = allows;
    return (A) this;
  }
  
  public SchemaNested<A> withNewSchema() {
    return new SchemaNested(null);
  }
  
  public SchemaNested<A> withNewSchemaLike(JSONSchemaProps item) {
    return new SchemaNested(item);
  }
  
  public A withSchema(JSONSchemaProps schema) {
    this._visitables.remove("schema");
    if (schema != null) {
        this.schema = new JSONSchemaPropsBuilder(schema);
        this._visitables.get("schema").add(this.schema);
    } else {
        this.schema = null;
        this._visitables.get("schema").remove(this.schema);
    }
    return (A) this;
  }
  public class SchemaNested<N> extends JSONSchemaPropsFluent<SchemaNested<N>> implements Nested<N>{
  
    JSONSchemaPropsBuilder builder;
  
    SchemaNested(JSONSchemaProps item) {
      this.builder = new JSONSchemaPropsBuilder(this, item);
    }
  
    public N and() {
      return (N) JSONSchemaPropsOrBoolFluent.this.withSchema(builder.build());
    }
    
    public N endSchema() {
      return and();
    }
    
  }
}