package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class HostFirmwareSettingsStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HostFirmwareSettingsStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private String lastUpdated;
  private SchemaReferenceBuilder schema;
  private Map<String,String> settings;

  public HostFirmwareSettingsStatusFluent() {
  }
  
  public HostFirmwareSettingsStatusFluent(HostFirmwareSettingsStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToSettings(Map<String,String> map) {
    if (this.settings == null && map != null) {
      this.settings = new LinkedHashMap();
    }
    if (map != null) {
      this.settings.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSettings(String key,String value) {
    if (this.settings == null && key != null && value != null) {
      this.settings = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.settings.put(key, value);
    }
    return (A) this;
  }
  
  public SchemaReference buildSchema() {
    return this.schema != null ? this.schema.build() : null;
  }
  
  protected void copyInstance(HostFirmwareSettingsStatus instance) {
    instance = instance != null ? instance : new HostFirmwareSettingsStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withLastUpdated(instance.getLastUpdated());
        this.withSchema(instance.getSchema());
        this.withSettings(instance.getSettings());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SchemaNested<A> editOrNewSchema() {
    return this.withNewSchemaLike(Optional.ofNullable(this.buildSchema()).orElse(new SchemaReferenceBuilder().build()));
  }
  
  public SchemaNested<A> editOrNewSchemaLike(SchemaReference item) {
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
    HostFirmwareSettingsStatusFluent that = (HostFirmwareSettingsStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
      return false;
    }
    if (!(Objects.equals(schema, that.schema))) {
      return false;
    }
    if (!(Objects.equals(settings, that.settings))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,String> getSettings() {
    return this.settings;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSchema() {
    return this.schema != null;
  }
  
  public boolean hasSettings() {
    return this.settings != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, lastUpdated, schema, settings, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSettings(String key) {
    if (this.settings == null) {
      return (A) this;
    }
    if (key != null && this.settings != null) {
      this.settings.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSettings(Map<String,String> map) {
    if (this.settings == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.settings != null) {
          this.settings.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
        sb.append(",");
    }
    if (!(schema == null)) {
        sb.append("schema:");
        sb.append(schema);
        sb.append(",");
    }
    if (!(settings == null) && !(settings.isEmpty())) {
        sb.append("settings:");
        sb.append(settings);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  
  public SchemaNested<A> withNewSchema() {
    return new SchemaNested(null);
  }
  
  public A withNewSchema(String name,String namespace) {
    return (A) this.withSchema(new SchemaReference(name, namespace));
  }
  
  public SchemaNested<A> withNewSchemaLike(SchemaReference item) {
    return new SchemaNested(item);
  }
  
  public A withSchema(SchemaReference schema) {
    this._visitables.remove("schema");
    if (schema != null) {
        this.schema = new SchemaReferenceBuilder(schema);
        this._visitables.get("schema").add(this.schema);
    } else {
        this.schema = null;
        this._visitables.get("schema").remove(this.schema);
    }
    return (A) this;
  }
  
  public <K,V>A withSettings(Map<String,String> settings) {
    if (settings == null) {
      this.settings = null;
    } else {
      this.settings = new LinkedHashMap(settings);
    }
    return (A) this;
  }
  public class SchemaNested<N> extends SchemaReferenceFluent<SchemaNested<N>> implements Nested<N>{
  
    SchemaReferenceBuilder builder;
  
    SchemaNested(SchemaReference item) {
      this.builder = new SchemaReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HostFirmwareSettingsStatusFluent.this.withSchema(builder.build());
    }
    
    public N endSchema() {
      return and();
    }
    
  }
}