package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
public class ResourceHandleFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceHandleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String data;
  private String driverName;
  private StructuredResourceHandleBuilder structuredData;

  public ResourceHandleFluent() {
  }
  
  public ResourceHandleFluent(ResourceHandle instance) {
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
  
  public StructuredResourceHandle buildStructuredData() {
    return this.structuredData != null ? this.structuredData.build() : null;
  }
  
  protected void copyInstance(ResourceHandle instance) {
    instance = instance != null ? instance : new ResourceHandle();
    if (instance != null) {
        this.withData(instance.getData());
        this.withDriverName(instance.getDriverName());
        this.withStructuredData(instance.getStructuredData());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StructuredDataNested<A> editOrNewStructuredData() {
    return this.withNewStructuredDataLike(Optional.ofNullable(this.buildStructuredData()).orElse(new StructuredResourceHandleBuilder().build()));
  }
  
  public StructuredDataNested<A> editOrNewStructuredDataLike(StructuredResourceHandle item) {
    return this.withNewStructuredDataLike(Optional.ofNullable(this.buildStructuredData()).orElse(item));
  }
  
  public StructuredDataNested<A> editStructuredData() {
    return this.withNewStructuredDataLike(Optional.ofNullable(this.buildStructuredData()).orElse(null));
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
    ResourceHandleFluent that = (ResourceHandleFluent) o;
    if (!(Objects.equals(data, that.data))) {
      return false;
    }
    if (!(Objects.equals(driverName, that.driverName))) {
      return false;
    }
    if (!(Objects.equals(structuredData, that.structuredData))) {
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
  
  public String getData() {
    return this.data;
  }
  
  public String getDriverName() {
    return this.driverName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasData() {
    return this.data != null;
  }
  
  public boolean hasDriverName() {
    return this.driverName != null;
  }
  
  public boolean hasStructuredData() {
    return this.structuredData != null;
  }
  
  public int hashCode() {
    return Objects.hash(data, driverName, structuredData, additionalProperties);
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
    if (!(data == null)) {
        sb.append("data:");
        sb.append(data);
        sb.append(",");
    }
    if (!(driverName == null)) {
        sb.append("driverName:");
        sb.append(driverName);
        sb.append(",");
    }
    if (!(structuredData == null)) {
        sb.append("structuredData:");
        sb.append(structuredData);
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
  
  public A withData(String data) {
    this.data = data;
    return (A) this;
  }
  
  public A withDriverName(String driverName) {
    this.driverName = driverName;
    return (A) this;
  }
  
  public StructuredDataNested<A> withNewStructuredData() {
    return new StructuredDataNested(null);
  }
  
  public StructuredDataNested<A> withNewStructuredDataLike(StructuredResourceHandle item) {
    return new StructuredDataNested(item);
  }
  
  public A withStructuredData(StructuredResourceHandle structuredData) {
    this._visitables.remove("structuredData");
    if (structuredData != null) {
        this.structuredData = new StructuredResourceHandleBuilder(structuredData);
        this._visitables.get("structuredData").add(this.structuredData);
    } else {
        this.structuredData = null;
        this._visitables.get("structuredData").remove(this.structuredData);
    }
    return (A) this;
  }
  public class StructuredDataNested<N> extends StructuredResourceHandleFluent<StructuredDataNested<N>> implements Nested<N>{
  
    StructuredResourceHandleBuilder builder;
  
    StructuredDataNested(StructuredResourceHandle item) {
      this.builder = new StructuredResourceHandleBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceHandleFluent.this.withStructuredData(builder.build());
    }
    
    public N endStructuredData() {
      return and();
    }
    
  }
}