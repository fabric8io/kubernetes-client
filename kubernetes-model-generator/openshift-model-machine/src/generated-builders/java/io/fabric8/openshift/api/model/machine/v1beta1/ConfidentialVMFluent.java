package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class ConfidentialVMFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.ConfidentialVMFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private UEFISettingsBuilder uefiSettings;

  public ConfidentialVMFluent() {
  }
  
  public ConfidentialVMFluent(ConfidentialVM instance) {
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
  
  public UEFISettings buildUefiSettings() {
    return this.uefiSettings != null ? this.uefiSettings.build() : null;
  }
  
  protected void copyInstance(ConfidentialVM instance) {
    instance = instance != null ? instance : new ConfidentialVM();
    if (instance != null) {
        this.withUefiSettings(instance.getUefiSettings());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public UefiSettingsNested<A> editOrNewUefiSettings() {
    return this.withNewUefiSettingsLike(Optional.ofNullable(this.buildUefiSettings()).orElse(new UEFISettingsBuilder().build()));
  }
  
  public UefiSettingsNested<A> editOrNewUefiSettingsLike(UEFISettings item) {
    return this.withNewUefiSettingsLike(Optional.ofNullable(this.buildUefiSettings()).orElse(item));
  }
  
  public UefiSettingsNested<A> editUefiSettings() {
    return this.withNewUefiSettingsLike(Optional.ofNullable(this.buildUefiSettings()).orElse(null));
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
    ConfidentialVMFluent that = (ConfidentialVMFluent) o;
    if (!(Objects.equals(uefiSettings, that.uefiSettings))) {
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
  
  public boolean hasUefiSettings() {
    return this.uefiSettings != null;
  }
  
  public int hashCode() {
    return Objects.hash(uefiSettings, additionalProperties);
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
    if (!(uefiSettings == null)) {
        sb.append("uefiSettings:");
        sb.append(uefiSettings);
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
  
  public UefiSettingsNested<A> withNewUefiSettings() {
    return new UefiSettingsNested(null);
  }
  
  public A withNewUefiSettings(String secureBoot,String virtualizedTrustedPlatformModule) {
    return (A) this.withUefiSettings(new UEFISettings(secureBoot, virtualizedTrustedPlatformModule));
  }
  
  public UefiSettingsNested<A> withNewUefiSettingsLike(UEFISettings item) {
    return new UefiSettingsNested(item);
  }
  
  public A withUefiSettings(UEFISettings uefiSettings) {
    this._visitables.remove("uefiSettings");
    if (uefiSettings != null) {
        this.uefiSettings = new UEFISettingsBuilder(uefiSettings);
        this._visitables.get("uefiSettings").add(this.uefiSettings);
    } else {
        this.uefiSettings = null;
        this._visitables.get("uefiSettings").remove(this.uefiSettings);
    }
    return (A) this;
  }
  public class UefiSettingsNested<N> extends UEFISettingsFluent<UefiSettingsNested<N>> implements Nested<N>{
  
    UEFISettingsBuilder builder;
  
    UefiSettingsNested(UEFISettings item) {
      this.builder = new UEFISettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) ConfidentialVMFluent.this.withUefiSettings(builder.build());
    }
    
    public N endUefiSettings() {
      return and();
    }
    
  }
}