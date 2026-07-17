package io.fabric8.openshift.api.model.config.v1;

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
public class ExternalPlatformStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.ExternalPlatformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CloudControllerManagerStatusBuilder cloudControllerManager;

  public ExternalPlatformStatusFluent() {
  }
  
  public ExternalPlatformStatusFluent(ExternalPlatformStatus instance) {
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
  
  public CloudControllerManagerStatus buildCloudControllerManager() {
    return this.cloudControllerManager != null ? this.cloudControllerManager.build() : null;
  }
  
  protected void copyInstance(ExternalPlatformStatus instance) {
    instance = instance != null ? instance : new ExternalPlatformStatus();
    if (instance != null) {
        this.withCloudControllerManager(instance.getCloudControllerManager());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CloudControllerManagerNested<A> editCloudControllerManager() {
    return this.withNewCloudControllerManagerLike(Optional.ofNullable(this.buildCloudControllerManager()).orElse(null));
  }
  
  public CloudControllerManagerNested<A> editOrNewCloudControllerManager() {
    return this.withNewCloudControllerManagerLike(Optional.ofNullable(this.buildCloudControllerManager()).orElse(new CloudControllerManagerStatusBuilder().build()));
  }
  
  public CloudControllerManagerNested<A> editOrNewCloudControllerManagerLike(CloudControllerManagerStatus item) {
    return this.withNewCloudControllerManagerLike(Optional.ofNullable(this.buildCloudControllerManager()).orElse(item));
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
    ExternalPlatformStatusFluent that = (ExternalPlatformStatusFluent) o;
    if (!(Objects.equals(cloudControllerManager, that.cloudControllerManager))) {
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
  
  public boolean hasCloudControllerManager() {
    return this.cloudControllerManager != null;
  }
  
  public int hashCode() {
    return Objects.hash(cloudControllerManager, additionalProperties);
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
    if (!(cloudControllerManager == null)) {
        sb.append("cloudControllerManager:");
        sb.append(cloudControllerManager);
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
  
  public A withCloudControllerManager(CloudControllerManagerStatus cloudControllerManager) {
    this._visitables.remove("cloudControllerManager");
    if (cloudControllerManager != null) {
        this.cloudControllerManager = new CloudControllerManagerStatusBuilder(cloudControllerManager);
        this._visitables.get("cloudControllerManager").add(this.cloudControllerManager);
    } else {
        this.cloudControllerManager = null;
        this._visitables.get("cloudControllerManager").remove(this.cloudControllerManager);
    }
    return (A) this;
  }
  
  public CloudControllerManagerNested<A> withNewCloudControllerManager() {
    return new CloudControllerManagerNested(null);
  }
  
  public A withNewCloudControllerManager(String state) {
    return (A) this.withCloudControllerManager(new CloudControllerManagerStatus(state));
  }
  
  public CloudControllerManagerNested<A> withNewCloudControllerManagerLike(CloudControllerManagerStatus item) {
    return new CloudControllerManagerNested(item);
  }
  public class CloudControllerManagerNested<N> extends CloudControllerManagerStatusFluent<CloudControllerManagerNested<N>> implements Nested<N>{
  
    CloudControllerManagerStatusBuilder builder;
  
    CloudControllerManagerNested(CloudControllerManagerStatus item) {
      this.builder = new CloudControllerManagerStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ExternalPlatformStatusFluent.this.withCloudControllerManager(builder.build());
    }
    
    public N endCloudControllerManager() {
      return and();
    }
    
  }
}