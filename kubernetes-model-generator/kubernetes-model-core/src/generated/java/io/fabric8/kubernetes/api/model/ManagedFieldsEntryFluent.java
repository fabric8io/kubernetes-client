package io.fabric8.kubernetes.api.model;

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
public class ManagedFieldsEntryFluent<A extends io.fabric8.kubernetes.api.model.ManagedFieldsEntryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String fieldsType;
  private FieldsV1Builder fieldsV1;
  private String manager;
  private String operation;
  private String subresource;
  private String time;

  public ManagedFieldsEntryFluent() {
  }
  
  public ManagedFieldsEntryFluent(ManagedFieldsEntry instance) {
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
  
  public FieldsV1 buildFieldsV1() {
    return this.fieldsV1 != null ? this.fieldsV1.build() : null;
  }
  
  protected void copyInstance(ManagedFieldsEntry instance) {
    instance = instance != null ? instance : new ManagedFieldsEntry();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withFieldsType(instance.getFieldsType());
        this.withFieldsV1(instance.getFieldsV1());
        this.withManager(instance.getManager());
        this.withOperation(instance.getOperation());
        this.withSubresource(instance.getSubresource());
        this.withTime(instance.getTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FieldsV1Nested<A> editFieldsV1() {
    return this.withNewFieldsV1Like(Optional.ofNullable(this.buildFieldsV1()).orElse(null));
  }
  
  public FieldsV1Nested<A> editOrNewFieldsV1() {
    return this.withNewFieldsV1Like(Optional.ofNullable(this.buildFieldsV1()).orElse(new FieldsV1Builder().build()));
  }
  
  public FieldsV1Nested<A> editOrNewFieldsV1Like(FieldsV1 item) {
    return this.withNewFieldsV1Like(Optional.ofNullable(this.buildFieldsV1()).orElse(item));
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
    ManagedFieldsEntryFluent that = (ManagedFieldsEntryFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(fieldsType, that.fieldsType))) {
      return false;
    }
    if (!(Objects.equals(fieldsV1, that.fieldsV1))) {
      return false;
    }
    if (!(Objects.equals(manager, that.manager))) {
      return false;
    }
    if (!(Objects.equals(operation, that.operation))) {
      return false;
    }
    if (!(Objects.equals(subresource, that.subresource))) {
      return false;
    }
    if (!(Objects.equals(time, that.time))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getFieldsType() {
    return this.fieldsType;
  }
  
  public String getManager() {
    return this.manager;
  }
  
  public String getOperation() {
    return this.operation;
  }
  
  public String getSubresource() {
    return this.subresource;
  }
  
  public String getTime() {
    return this.time;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasFieldsType() {
    return this.fieldsType != null;
  }
  
  public boolean hasFieldsV1() {
    return this.fieldsV1 != null;
  }
  
  public boolean hasManager() {
    return this.manager != null;
  }
  
  public boolean hasOperation() {
    return this.operation != null;
  }
  
  public boolean hasSubresource() {
    return this.subresource != null;
  }
  
  public boolean hasTime() {
    return this.time != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, fieldsType, fieldsV1, manager, operation, subresource, time, additionalProperties);
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
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(fieldsType == null)) {
        sb.append("fieldsType:");
        sb.append(fieldsType);
        sb.append(",");
    }
    if (!(fieldsV1 == null)) {
        sb.append("fieldsV1:");
        sb.append(fieldsV1);
        sb.append(",");
    }
    if (!(manager == null)) {
        sb.append("manager:");
        sb.append(manager);
        sb.append(",");
    }
    if (!(operation == null)) {
        sb.append("operation:");
        sb.append(operation);
        sb.append(",");
    }
    if (!(subresource == null)) {
        sb.append("subresource:");
        sb.append(subresource);
        sb.append(",");
    }
    if (!(time == null)) {
        sb.append("time:");
        sb.append(time);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withFieldsType(String fieldsType) {
    this.fieldsType = fieldsType;
    return (A) this;
  }
  
  public A withFieldsV1(FieldsV1 fieldsV1) {
    this._visitables.remove("fieldsV1");
    if (fieldsV1 != null) {
        this.fieldsV1 = new FieldsV1Builder(fieldsV1);
        this._visitables.get("fieldsV1").add(this.fieldsV1);
    } else {
        this.fieldsV1 = null;
        this._visitables.get("fieldsV1").remove(this.fieldsV1);
    }
    return (A) this;
  }
  
  public A withManager(String manager) {
    this.manager = manager;
    return (A) this;
  }
  
  public FieldsV1Nested<A> withNewFieldsV1() {
    return new FieldsV1Nested(null);
  }
  
  public FieldsV1Nested<A> withNewFieldsV1Like(FieldsV1 item) {
    return new FieldsV1Nested(item);
  }
  
  public A withOperation(String operation) {
    this.operation = operation;
    return (A) this;
  }
  
  public A withSubresource(String subresource) {
    this.subresource = subresource;
    return (A) this;
  }
  
  public A withTime(String time) {
    this.time = time;
    return (A) this;
  }
  public class FieldsV1Nested<N> extends FieldsV1Fluent<FieldsV1Nested<N>> implements Nested<N>{
  
    FieldsV1Builder builder;
  
    FieldsV1Nested(FieldsV1 item) {
      this.builder = new FieldsV1Builder(this, item);
    }
  
    public N and() {
      return (N) ManagedFieldsEntryFluent.this.withFieldsV1(builder.build());
    }
    
    public N endFieldsV1() {
      return and();
    }
    
  }
}