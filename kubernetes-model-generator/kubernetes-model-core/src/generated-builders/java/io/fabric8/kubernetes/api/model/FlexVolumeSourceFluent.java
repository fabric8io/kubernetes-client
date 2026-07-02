package io.fabric8.kubernetes.api.model;

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
public class FlexVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.FlexVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String driver;
  private String fsType;
  private Map<String,String> options;
  private Boolean readOnly;
  private LocalObjectReferenceBuilder secretRef;

  public FlexVolumeSourceFluent() {
  }
  
  public FlexVolumeSourceFluent(FlexVolumeSource instance) {
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
  
  public A addToOptions(Map<String,String> map) {
    if (this.options == null && map != null) {
      this.options = new LinkedHashMap();
    }
    if (map != null) {
      this.options.putAll(map);
    }
    return (A) this;
  }
  
  public A addToOptions(String key,String value) {
    if (this.options == null && key != null && value != null) {
      this.options = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.options.put(key, value);
    }
    return (A) this;
  }
  
  public LocalObjectReference buildSecretRef() {
    return this.secretRef != null ? this.secretRef.build() : null;
  }
  
  protected void copyInstance(FlexVolumeSource instance) {
    instance = instance != null ? instance : new FlexVolumeSource();
    if (instance != null) {
        this.withDriver(instance.getDriver());
        this.withFsType(instance.getFsType());
        this.withOptions(instance.getOptions());
        this.withReadOnly(instance.getReadOnly());
        this.withSecretRef(instance.getSecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SecretRefNested<A> editOrNewSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public SecretRefNested<A> editOrNewSecretRefLike(LocalObjectReference item) {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(item));
  }
  
  public SecretRefNested<A> editSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(null));
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
    FlexVolumeSourceFluent that = (FlexVolumeSourceFluent) o;
    if (!(Objects.equals(driver, that.driver))) {
      return false;
    }
    if (!(Objects.equals(fsType, that.fsType))) {
      return false;
    }
    if (!(Objects.equals(options, that.options))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
      return false;
    }
    if (!(Objects.equals(secretRef, that.secretRef))) {
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
  
  public String getDriver() {
    return this.driver;
  }
  
  public String getFsType() {
    return this.fsType;
  }
  
  public Map<String,String> getOptions() {
    return this.options;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDriver() {
    return this.driver != null;
  }
  
  public boolean hasFsType() {
    return this.fsType != null;
  }
  
  public boolean hasOptions() {
    return this.options != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public boolean hasSecretRef() {
    return this.secretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(driver, fsType, options, readOnly, secretRef, additionalProperties);
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
  
  public A removeFromOptions(String key) {
    if (this.options == null) {
      return (A) this;
    }
    if (key != null && this.options != null) {
      this.options.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromOptions(Map<String,String> map) {
    if (this.options == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.options != null) {
          this.options.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(driver == null)) {
        sb.append("driver:");
        sb.append(driver);
        sb.append(",");
    }
    if (!(fsType == null)) {
        sb.append("fsType:");
        sb.append(fsType);
        sb.append(",");
    }
    if (!(options == null) && !(options.isEmpty())) {
        sb.append("options:");
        sb.append(options);
        sb.append(",");
    }
    if (!(readOnly == null)) {
        sb.append("readOnly:");
        sb.append(readOnly);
        sb.append(",");
    }
    if (!(secretRef == null)) {
        sb.append("secretRef:");
        sb.append(secretRef);
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
  
  public A withDriver(String driver) {
    this.driver = driver;
    return (A) this;
  }
  
  public A withFsType(String fsType) {
    this.fsType = fsType;
    return (A) this;
  }
  
  public SecretRefNested<A> withNewSecretRef() {
    return new SecretRefNested(null);
  }
  
  public A withNewSecretRef(String name) {
    return (A) this.withSecretRef(new LocalObjectReference(name));
  }
  
  public SecretRefNested<A> withNewSecretRefLike(LocalObjectReference item) {
    return new SecretRefNested(item);
  }
  
  public <K,V>A withOptions(Map<String,String> options) {
    if (options == null) {
      this.options = null;
    } else {
      this.options = new LinkedHashMap(options);
    }
    return (A) this;
  }
  
  public A withReadOnly() {
    return withReadOnly(true);
  }
  
  public A withReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return (A) this;
  }
  
  public A withSecretRef(LocalObjectReference secretRef) {
    this._visitables.remove("secretRef");
    if (secretRef != null) {
        this.secretRef = new LocalObjectReferenceBuilder(secretRef);
        this._visitables.get("secretRef").add(this.secretRef);
    } else {
        this.secretRef = null;
        this._visitables.get("secretRef").remove(this.secretRef);
    }
    return (A) this;
  }
  public class SecretRefNested<N> extends LocalObjectReferenceFluent<SecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    SecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) FlexVolumeSourceFluent.this.withSecretRef(builder.build());
    }
    
    public N endSecretRef() {
      return and();
    }
    
  }
}