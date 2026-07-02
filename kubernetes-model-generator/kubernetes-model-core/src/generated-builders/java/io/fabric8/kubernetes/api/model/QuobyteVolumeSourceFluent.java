package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class QuobyteVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.QuobyteVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String group;
  private Boolean readOnly;
  private String registry;
  private String tenant;
  private String user;
  private String volume;

  public QuobyteVolumeSourceFluent() {
  }
  
  public QuobyteVolumeSourceFluent(QuobyteVolumeSource instance) {
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
  
  protected void copyInstance(QuobyteVolumeSource instance) {
    instance = instance != null ? instance : new QuobyteVolumeSource();
    if (instance != null) {
        this.withGroup(instance.getGroup());
        this.withReadOnly(instance.getReadOnly());
        this.withRegistry(instance.getRegistry());
        this.withTenant(instance.getTenant());
        this.withUser(instance.getUser());
        this.withVolume(instance.getVolume());
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
    QuobyteVolumeSourceFluent that = (QuobyteVolumeSourceFluent) o;
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
      return false;
    }
    if (!(Objects.equals(registry, that.registry))) {
      return false;
    }
    if (!(Objects.equals(tenant, that.tenant))) {
      return false;
    }
    if (!(Objects.equals(user, that.user))) {
      return false;
    }
    if (!(Objects.equals(volume, that.volume))) {
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
  
  public String getGroup() {
    return this.group;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public String getRegistry() {
    return this.registry;
  }
  
  public String getTenant() {
    return this.tenant;
  }
  
  public String getUser() {
    return this.user;
  }
  
  public String getVolume() {
    return this.volume;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGroup() {
    return this.group != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public boolean hasRegistry() {
    return this.registry != null;
  }
  
  public boolean hasTenant() {
    return this.tenant != null;
  }
  
  public boolean hasUser() {
    return this.user != null;
  }
  
  public boolean hasVolume() {
    return this.volume != null;
  }
  
  public int hashCode() {
    return Objects.hash(group, readOnly, registry, tenant, user, volume, additionalProperties);
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
    if (!(group == null)) {
        sb.append("group:");
        sb.append(group);
        sb.append(",");
    }
    if (!(readOnly == null)) {
        sb.append("readOnly:");
        sb.append(readOnly);
        sb.append(",");
    }
    if (!(registry == null)) {
        sb.append("registry:");
        sb.append(registry);
        sb.append(",");
    }
    if (!(tenant == null)) {
        sb.append("tenant:");
        sb.append(tenant);
        sb.append(",");
    }
    if (!(user == null)) {
        sb.append("user:");
        sb.append(user);
        sb.append(",");
    }
    if (!(volume == null)) {
        sb.append("volume:");
        sb.append(volume);
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
  
  public A withGroup(String group) {
    this.group = group;
    return (A) this;
  }
  
  public A withReadOnly() {
    return withReadOnly(true);
  }
  
  public A withReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return (A) this;
  }
  
  public A withRegistry(String registry) {
    this.registry = registry;
    return (A) this;
  }
  
  public A withTenant(String tenant) {
    this.tenant = tenant;
    return (A) this;
  }
  
  public A withUser(String user) {
    this.user = user;
    return (A) this;
  }
  
  public A withVolume(String volume) {
    this.volume = volume;
    return (A) this;
  }
  
}