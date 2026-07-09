package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class JSONSchemaPropsOrArrayFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArrayFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<JSONSchemaPropsBuilder> jSONSchemas = new ArrayList<JSONSchemaPropsBuilder>();
  private JSONSchemaPropsBuilder schema;

  public JSONSchemaPropsOrArrayFluent() {
  }
  
  public JSONSchemaPropsOrArrayFluent(JSONSchemaPropsOrArray instance) {
    this.copyInstance(instance);
  }

  public A addAllToJSONSchemas(Collection<JSONSchemaProps> items) {
    if (this.jSONSchemas == null) {
      this.jSONSchemas = new ArrayList();
    }
    for (JSONSchemaProps item : items) {
        JSONSchemaPropsBuilder builder = new JSONSchemaPropsBuilder(item);
        _visitables.get("jSONSchemas").add(builder);
        this.jSONSchemas.add(builder);
    }
    return (A) this;
  }
  
  public JSONSchemasNested<A> addNewJSONSchema() {
    return new JSONSchemasNested(-1, null);
  }
  
  public JSONSchemasNested<A> addNewJSONSchemaLike(JSONSchemaProps item) {
    return new JSONSchemasNested(-1, item);
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
  
  public A addToJSONSchemas(JSONSchemaProps... items) {
    if (this.jSONSchemas == null) {
      this.jSONSchemas = new ArrayList();
    }
    for (JSONSchemaProps item : items) {
        JSONSchemaPropsBuilder builder = new JSONSchemaPropsBuilder(item);
        _visitables.get("jSONSchemas").add(builder);
        this.jSONSchemas.add(builder);
    }
    return (A) this;
  }
  
  public A addToJSONSchemas(int index,JSONSchemaProps item) {
    if (this.jSONSchemas == null) {
      this.jSONSchemas = new ArrayList();
    }
    JSONSchemaPropsBuilder builder = new JSONSchemaPropsBuilder(item);
    if (index < 0 || index >= jSONSchemas.size()) {
        _visitables.get("jSONSchemas").add(builder);
        jSONSchemas.add(builder);
    } else {
        _visitables.get("jSONSchemas").add(builder);
        jSONSchemas.add(index, builder);
    }
    return (A) this;
  }
  
  public JSONSchemaProps buildFirstJSONSchema() {
    return this.jSONSchemas.get(0).build();
  }
  
  public JSONSchemaProps buildJSONSchema(int index) {
    return this.jSONSchemas.get(index).build();
  }
  
  public List<JSONSchemaProps> buildJSONSchemas() {
    return this.jSONSchemas != null ? build(jSONSchemas) : null;
  }
  
  public JSONSchemaProps buildLastJSONSchema() {
    return this.jSONSchemas.get(jSONSchemas.size() - 1).build();
  }
  
  public JSONSchemaProps buildMatchingJSONSchema(Predicate<JSONSchemaPropsBuilder> predicate) {
      for (JSONSchemaPropsBuilder item : jSONSchemas) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public JSONSchemaProps buildSchema() {
    return this.schema != null ? this.schema.build() : null;
  }
  
  protected void copyInstance(JSONSchemaPropsOrArray instance) {
    instance = instance != null ? instance : new JSONSchemaPropsOrArray();
    if (instance != null) {
        this.withJSONSchemas(instance.getJSONSchemas());
        this.withSchema(instance.getSchema());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public JSONSchemasNested<A> editFirstJSONSchema() {
    if (jSONSchemas.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "jSONSchemas"));
    }
    return this.setNewJSONSchemaLike(0, this.buildJSONSchema(0));
  }
  
  public JSONSchemasNested<A> editJSONSchema(int index) {
    if (jSONSchemas.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "jSONSchemas"));
    }
    return this.setNewJSONSchemaLike(index, this.buildJSONSchema(index));
  }
  
  public JSONSchemasNested<A> editLastJSONSchema() {
    int index = jSONSchemas.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "jSONSchemas"));
    }
    return this.setNewJSONSchemaLike(index, this.buildJSONSchema(index));
  }
  
  public JSONSchemasNested<A> editMatchingJSONSchema(Predicate<JSONSchemaPropsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < jSONSchemas.size();i++) {
      if (predicate.test(jSONSchemas.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "jSONSchemas"));
    }
    return this.setNewJSONSchemaLike(index, this.buildJSONSchema(index));
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
    JSONSchemaPropsOrArrayFluent that = (JSONSchemaPropsOrArrayFluent) o;
    if (!(Objects.equals(jSONSchemas, that.jSONSchemas))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasJSONSchemas() {
    return this.jSONSchemas != null && !(this.jSONSchemas.isEmpty());
  }
  
  public boolean hasMatchingJSONSchema(Predicate<JSONSchemaPropsBuilder> predicate) {
      for (JSONSchemaPropsBuilder item : jSONSchemas) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSchema() {
    return this.schema != null;
  }
  
  public int hashCode() {
    return Objects.hash(jSONSchemas, schema, additionalProperties);
  }
  
  public A removeAllFromJSONSchemas(Collection<JSONSchemaProps> items) {
    if (this.jSONSchemas == null) {
      return (A) this;
    }
    for (JSONSchemaProps item : items) {
        JSONSchemaPropsBuilder builder = new JSONSchemaPropsBuilder(item);
        _visitables.get("jSONSchemas").remove(builder);
        this.jSONSchemas.remove(builder);
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
  
  public A removeFromJSONSchemas(JSONSchemaProps... items) {
    if (this.jSONSchemas == null) {
      return (A) this;
    }
    for (JSONSchemaProps item : items) {
        JSONSchemaPropsBuilder builder = new JSONSchemaPropsBuilder(item);
        _visitables.get("jSONSchemas").remove(builder);
        this.jSONSchemas.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromJSONSchemas(Predicate<JSONSchemaPropsBuilder> predicate) {
    if (jSONSchemas == null) {
      return (A) this;
    }
    Iterator<JSONSchemaPropsBuilder> each = jSONSchemas.iterator();
    List visitables = _visitables.get("jSONSchemas");
    while (each.hasNext()) {
        JSONSchemaPropsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public JSONSchemasNested<A> setNewJSONSchemaLike(int index,JSONSchemaProps item) {
    return new JSONSchemasNested(index, item);
  }
  
  public A setToJSONSchemas(int index,JSONSchemaProps item) {
    if (this.jSONSchemas == null) {
      this.jSONSchemas = new ArrayList();
    }
    JSONSchemaPropsBuilder builder = new JSONSchemaPropsBuilder(item);
    if (index < 0 || index >= jSONSchemas.size()) {
        _visitables.get("jSONSchemas").add(builder);
        jSONSchemas.add(builder);
    } else {
        _visitables.get("jSONSchemas").add(builder);
        jSONSchemas.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(jSONSchemas == null) && !(jSONSchemas.isEmpty())) {
        sb.append("jSONSchemas:");
        sb.append(jSONSchemas);
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
  
  public A withJSONSchemas(List<JSONSchemaProps> jSONSchemas) {
    if (this.jSONSchemas != null) {
      this._visitables.get("jSONSchemas").clear();
    }
    if (jSONSchemas != null) {
        this.jSONSchemas = new ArrayList();
        for (JSONSchemaProps item : jSONSchemas) {
          this.addToJSONSchemas(item);
        }
    } else {
      this.jSONSchemas = null;
    }
    return (A) this;
  }
  
  public A withJSONSchemas(JSONSchemaProps... jSONSchemas) {
    if (this.jSONSchemas != null) {
        this.jSONSchemas.clear();
        _visitables.remove("jSONSchemas");
    }
    if (jSONSchemas != null) {
      for (JSONSchemaProps item : jSONSchemas) {
        this.addToJSONSchemas(item);
      }
    }
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
  public class JSONSchemasNested<N> extends JSONSchemaPropsFluent<JSONSchemasNested<N>> implements Nested<N>{
  
    JSONSchemaPropsBuilder builder;
    int index;
  
    JSONSchemasNested(int index,JSONSchemaProps item) {
      this.index = index;
      this.builder = new JSONSchemaPropsBuilder(this, item);
    }
  
    public N and() {
      return (N) JSONSchemaPropsOrArrayFluent.this.setToJSONSchemas(index, builder.build());
    }
    
    public N endJSONSchema() {
      return and();
    }
    
  }
  public class SchemaNested<N> extends JSONSchemaPropsFluent<SchemaNested<N>> implements Nested<N>{
  
    JSONSchemaPropsBuilder builder;
  
    SchemaNested(JSONSchemaProps item) {
      this.builder = new JSONSchemaPropsBuilder(this, item);
    }
  
    public N and() {
      return (N) JSONSchemaPropsOrArrayFluent.this.withSchema(builder.build());
    }
    
    public N endSchema() {
      return and();
    }
    
  }
}