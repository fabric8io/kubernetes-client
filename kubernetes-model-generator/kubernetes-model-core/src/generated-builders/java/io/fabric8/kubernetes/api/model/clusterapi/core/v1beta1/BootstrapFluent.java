package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class BootstrapFluent<A extends io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.BootstrapFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder configRef;
  private String dataSecretName;

  public BootstrapFluent() {
  }
  
  public BootstrapFluent(Bootstrap instance) {
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
  
  public ObjectReference buildConfigRef() {
    return this.configRef != null ? this.configRef.build() : null;
  }
  
  protected void copyInstance(Bootstrap instance) {
    instance = instance != null ? instance : new Bootstrap();
    if (instance != null) {
        this.withConfigRef(instance.getConfigRef());
        this.withDataSecretName(instance.getDataSecretName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigRefNested<A> editConfigRef() {
    return this.withNewConfigRefLike(Optional.ofNullable(this.buildConfigRef()).orElse(null));
  }
  
  public ConfigRefNested<A> editOrNewConfigRef() {
    return this.withNewConfigRefLike(Optional.ofNullable(this.buildConfigRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ConfigRefNested<A> editOrNewConfigRefLike(ObjectReference item) {
    return this.withNewConfigRefLike(Optional.ofNullable(this.buildConfigRef()).orElse(item));
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
    BootstrapFluent that = (BootstrapFluent) o;
    if (!(Objects.equals(configRef, that.configRef))) {
      return false;
    }
    if (!(Objects.equals(dataSecretName, that.dataSecretName))) {
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
  
  public String getDataSecretName() {
    return this.dataSecretName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigRef() {
    return this.configRef != null;
  }
  
  public boolean hasDataSecretName() {
    return this.dataSecretName != null;
  }
  
  public int hashCode() {
    return Objects.hash(configRef, dataSecretName, additionalProperties);
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
    if (!(configRef == null)) {
        sb.append("configRef:");
        sb.append(configRef);
        sb.append(",");
    }
    if (!(dataSecretName == null)) {
        sb.append("dataSecretName:");
        sb.append(dataSecretName);
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
  
  public A withConfigRef(ObjectReference configRef) {
    this._visitables.remove("configRef");
    if (configRef != null) {
        this.configRef = new ObjectReferenceBuilder(configRef);
        this._visitables.get("configRef").add(this.configRef);
    } else {
        this.configRef = null;
        this._visitables.get("configRef").remove(this.configRef);
    }
    return (A) this;
  }
  
  public A withDataSecretName(String dataSecretName) {
    this.dataSecretName = dataSecretName;
    return (A) this;
  }
  
  public ConfigRefNested<A> withNewConfigRef() {
    return new ConfigRefNested(null);
  }
  
  public ConfigRefNested<A> withNewConfigRefLike(ObjectReference item) {
    return new ConfigRefNested(item);
  }
  public class ConfigRefNested<N> extends ObjectReferenceFluent<ConfigRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ConfigRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BootstrapFluent.this.withConfigRef(builder.build());
    }
    
    public N endConfigRef() {
      return and();
    }
    
  }
}