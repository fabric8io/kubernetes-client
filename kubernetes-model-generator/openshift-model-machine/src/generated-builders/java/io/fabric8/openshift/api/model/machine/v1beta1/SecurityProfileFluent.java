package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class SecurityProfileFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.SecurityProfileFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean encryptionAtHost;
  private SecuritySettingsBuilder settings;

  public SecurityProfileFluent() {
  }
  
  public SecurityProfileFluent(SecurityProfile instance) {
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
  
  public SecuritySettings buildSettings() {
    return this.settings != null ? this.settings.build() : null;
  }
  
  protected void copyInstance(SecurityProfile instance) {
    instance = instance != null ? instance : new SecurityProfile();
    if (instance != null) {
        this.withEncryptionAtHost(instance.getEncryptionAtHost());
        this.withSettings(instance.getSettings());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SettingsNested<A> editOrNewSettings() {
    return this.withNewSettingsLike(Optional.ofNullable(this.buildSettings()).orElse(new SecuritySettingsBuilder().build()));
  }
  
  public SettingsNested<A> editOrNewSettingsLike(SecuritySettings item) {
    return this.withNewSettingsLike(Optional.ofNullable(this.buildSettings()).orElse(item));
  }
  
  public SettingsNested<A> editSettings() {
    return this.withNewSettingsLike(Optional.ofNullable(this.buildSettings()).orElse(null));
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
    SecurityProfileFluent that = (SecurityProfileFluent) o;
    if (!(Objects.equals(encryptionAtHost, that.encryptionAtHost))) {
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
  
  public Boolean getEncryptionAtHost() {
    return this.encryptionAtHost;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEncryptionAtHost() {
    return this.encryptionAtHost != null;
  }
  
  public boolean hasSettings() {
    return this.settings != null;
  }
  
  public int hashCode() {
    return Objects.hash(encryptionAtHost, settings, additionalProperties);
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
    if (!(encryptionAtHost == null)) {
        sb.append("encryptionAtHost:");
        sb.append(encryptionAtHost);
        sb.append(",");
    }
    if (!(settings == null)) {
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
  
  public A withEncryptionAtHost() {
    return withEncryptionAtHost(true);
  }
  
  public A withEncryptionAtHost(Boolean encryptionAtHost) {
    this.encryptionAtHost = encryptionAtHost;
    return (A) this;
  }
  
  public SettingsNested<A> withNewSettings() {
    return new SettingsNested(null);
  }
  
  public SettingsNested<A> withNewSettingsLike(SecuritySettings item) {
    return new SettingsNested(item);
  }
  
  public A withSettings(SecuritySettings settings) {
    this._visitables.remove("settings");
    if (settings != null) {
        this.settings = new SecuritySettingsBuilder(settings);
        this._visitables.get("settings").add(this.settings);
    } else {
        this.settings = null;
        this._visitables.get("settings").remove(this.settings);
    }
    return (A) this;
  }
  public class SettingsNested<N> extends SecuritySettingsFluent<SettingsNested<N>> implements Nested<N>{
  
    SecuritySettingsBuilder builder;
  
    SettingsNested(SecuritySettings item) {
      this.builder = new SecuritySettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityProfileFluent.this.withSettings(builder.build());
    }
    
    public N endSettings() {
      return and();
    }
    
  }
}