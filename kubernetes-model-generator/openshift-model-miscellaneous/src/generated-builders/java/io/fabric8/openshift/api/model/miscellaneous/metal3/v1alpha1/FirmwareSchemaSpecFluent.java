package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class FirmwareSchemaSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.FirmwareSchemaSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String hardwareModel;
  private String hardwareVendor;
  private Map<String,SettingSchema> schema;

  public FirmwareSchemaSpecFluent() {
  }
  
  public FirmwareSchemaSpecFluent(FirmwareSchemaSpec instance) {
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
  
  public A addToSchema(Map<String,SettingSchema> map) {
    if (this.schema == null && map != null) {
      this.schema = new LinkedHashMap();
    }
    if (map != null) {
      this.schema.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSchema(String key,SettingSchema value) {
    if (this.schema == null && key != null && value != null) {
      this.schema = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.schema.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(FirmwareSchemaSpec instance) {
    instance = instance != null ? instance : new FirmwareSchemaSpec();
    if (instance != null) {
        this.withHardwareModel(instance.getHardwareModel());
        this.withHardwareVendor(instance.getHardwareVendor());
        this.withSchema(instance.getSchema());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    FirmwareSchemaSpecFluent that = (FirmwareSchemaSpecFluent) o;
    if (!(Objects.equals(hardwareModel, that.hardwareModel))) {
      return false;
    }
    if (!(Objects.equals(hardwareVendor, that.hardwareVendor))) {
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
  
  public String getHardwareModel() {
    return this.hardwareModel;
  }
  
  public String getHardwareVendor() {
    return this.hardwareVendor;
  }
  
  public Map<String,SettingSchema> getSchema() {
    return this.schema;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHardwareModel() {
    return this.hardwareModel != null;
  }
  
  public boolean hasHardwareVendor() {
    return this.hardwareVendor != null;
  }
  
  public boolean hasSchema() {
    return this.schema != null;
  }
  
  public int hashCode() {
    return Objects.hash(hardwareModel, hardwareVendor, schema, additionalProperties);
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
  
  public A removeFromSchema(String key) {
    if (this.schema == null) {
      return (A) this;
    }
    if (key != null && this.schema != null) {
      this.schema.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSchema(Map<String,SettingSchema> map) {
    if (this.schema == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.schema != null) {
          this.schema.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hardwareModel == null)) {
        sb.append("hardwareModel:");
        sb.append(hardwareModel);
        sb.append(",");
    }
    if (!(hardwareVendor == null)) {
        sb.append("hardwareVendor:");
        sb.append(hardwareVendor);
        sb.append(",");
    }
    if (!(schema == null) && !(schema.isEmpty())) {
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
  
  public A withHardwareModel(String hardwareModel) {
    this.hardwareModel = hardwareModel;
    return (A) this;
  }
  
  public A withHardwareVendor(String hardwareVendor) {
    this.hardwareVendor = hardwareVendor;
    return (A) this;
  }
  
  public <K,V>A withSchema(Map<String,SettingSchema> schema) {
    if (schema == null) {
      this.schema = null;
    } else {
      this.schema = new LinkedHashMap(schema);
    }
    return (A) this;
  }
  
}