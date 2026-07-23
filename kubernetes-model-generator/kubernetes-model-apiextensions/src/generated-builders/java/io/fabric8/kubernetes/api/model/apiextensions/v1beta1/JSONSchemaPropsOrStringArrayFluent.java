package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class JSONSchemaPropsOrStringArrayFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArrayFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> property = new ArrayList<String>();
  private JSONSchemaPropsBuilder schema;

  public JSONSchemaPropsOrStringArrayFluent() {
  }
  
  public JSONSchemaPropsOrStringArrayFluent(JSONSchemaPropsOrStringArray instance) {
    this.copyInstance(instance);
  }

  public A addAllToProperty(Collection<String> items) {
    if (this.property == null) {
      this.property = new ArrayList();
    }
    for (String item : items) {
      this.property.add(item);
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
  
  public A addToProperty(String... items) {
    if (this.property == null) {
      this.property = new ArrayList();
    }
    for (String item : items) {
      this.property.add(item);
    }
    return (A) this;
  }
  
  public A addToProperty(int index,String item) {
    if (this.property == null) {
      this.property = new ArrayList();
    }
    this.property.add(index, item);
    return (A) this;
  }
  
  public JSONSchemaProps buildSchema() {
    return this.schema != null ? this.schema.build() : null;
  }
  
  protected void copyInstance(JSONSchemaPropsOrStringArray instance) {
    instance = instance != null ? instance : new JSONSchemaPropsOrStringArray();
    if (instance != null) {
        this.withProperty(instance.getProperty());
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
    JSONSchemaPropsOrStringArrayFluent that = (JSONSchemaPropsOrStringArrayFluent) o;
    if (!(Objects.equals(property, that.property))) {
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
  
  public String getFirstProperty() {
    return this.property.get(0);
  }
  
  public String getLastProperty() {
    return this.property.get(property.size() - 1);
  }
  
  public String getMatchingProperty(Predicate<String> predicate) {
      for (String item : property) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getProperty() {
    return this.property;
  }
  
  public String getProperty(int index) {
    return this.property.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingProperty(Predicate<String> predicate) {
      for (String item : property) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProperty() {
    return this.property != null && !(this.property.isEmpty());
  }
  
  public boolean hasSchema() {
    return this.schema != null;
  }
  
  public int hashCode() {
    return Objects.hash(property, schema, additionalProperties);
  }
  
  public A removeAllFromProperty(Collection<String> items) {
    if (this.property == null) {
      return (A) this;
    }
    for (String item : items) {
      this.property.remove(item);
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
  
  public A removeFromProperty(String... items) {
    if (this.property == null) {
      return (A) this;
    }
    for (String item : items) {
      this.property.remove(item);
    }
    return (A) this;
  }
  
  public A setToProperty(int index,String item) {
    if (this.property == null) {
      this.property = new ArrayList();
    }
    this.property.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(property == null) && !(property.isEmpty())) {
        sb.append("property:");
        sb.append(property);
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
  
  public SchemaNested<A> withNewSchema() {
    return new SchemaNested(null);
  }
  
  public SchemaNested<A> withNewSchemaLike(JSONSchemaProps item) {
    return new SchemaNested(item);
  }
  
  public A withProperty(List<String> property) {
    if (property != null) {
        this.property = new ArrayList();
        for (String item : property) {
          this.addToProperty(item);
        }
    } else {
      this.property = null;
    }
    return (A) this;
  }
  
  public A withProperty(String... property) {
    if (this.property != null) {
        this.property.clear();
        _visitables.remove("property");
    }
    if (property != null) {
      for (String item : property) {
        this.addToProperty(item);
      }
    }
    return (A) this;
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
      return (N) JSONSchemaPropsOrStringArrayFluent.this.withSchema(builder.build());
    }
    
    public N endSchema() {
      return and();
    }
    
  }
}