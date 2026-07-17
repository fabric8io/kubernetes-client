package io.fabric8.openshift.api.model.operator.v1;

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
public class AdditionalNetworkDefinitionFluent<A extends io.fabric8.openshift.api.model.operator.v1.AdditionalNetworkDefinitionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private String namespace;
  private String rawCNIConfig;
  private SimpleMacvlanConfigBuilder simpleMacvlanConfig;
  private String type;

  public AdditionalNetworkDefinitionFluent() {
  }
  
  public AdditionalNetworkDefinitionFluent(AdditionalNetworkDefinition instance) {
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
  
  public SimpleMacvlanConfig buildSimpleMacvlanConfig() {
    return this.simpleMacvlanConfig != null ? this.simpleMacvlanConfig.build() : null;
  }
  
  protected void copyInstance(AdditionalNetworkDefinition instance) {
    instance = instance != null ? instance : new AdditionalNetworkDefinition();
    if (instance != null) {
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withRawCNIConfig(instance.getRawCNIConfig());
        this.withSimpleMacvlanConfig(instance.getSimpleMacvlanConfig());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SimpleMacvlanConfigNested<A> editOrNewSimpleMacvlanConfig() {
    return this.withNewSimpleMacvlanConfigLike(Optional.ofNullable(this.buildSimpleMacvlanConfig()).orElse(new SimpleMacvlanConfigBuilder().build()));
  }
  
  public SimpleMacvlanConfigNested<A> editOrNewSimpleMacvlanConfigLike(SimpleMacvlanConfig item) {
    return this.withNewSimpleMacvlanConfigLike(Optional.ofNullable(this.buildSimpleMacvlanConfig()).orElse(item));
  }
  
  public SimpleMacvlanConfigNested<A> editSimpleMacvlanConfig() {
    return this.withNewSimpleMacvlanConfigLike(Optional.ofNullable(this.buildSimpleMacvlanConfig()).orElse(null));
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
    AdditionalNetworkDefinitionFluent that = (AdditionalNetworkDefinitionFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(rawCNIConfig, that.rawCNIConfig))) {
      return false;
    }
    if (!(Objects.equals(simpleMacvlanConfig, that.simpleMacvlanConfig))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getRawCNIConfig() {
    return this.rawCNIConfig;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasRawCNIConfig() {
    return this.rawCNIConfig != null;
  }
  
  public boolean hasSimpleMacvlanConfig() {
    return this.simpleMacvlanConfig != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, namespace, rawCNIConfig, simpleMacvlanConfig, type, additionalProperties);
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
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(rawCNIConfig == null)) {
        sb.append("rawCNIConfig:");
        sb.append(rawCNIConfig);
        sb.append(",");
    }
    if (!(simpleMacvlanConfig == null)) {
        sb.append("simpleMacvlanConfig:");
        sb.append(simpleMacvlanConfig);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public SimpleMacvlanConfigNested<A> withNewSimpleMacvlanConfig() {
    return new SimpleMacvlanConfigNested(null);
  }
  
  public SimpleMacvlanConfigNested<A> withNewSimpleMacvlanConfigLike(SimpleMacvlanConfig item) {
    return new SimpleMacvlanConfigNested(item);
  }
  
  public A withRawCNIConfig(String rawCNIConfig) {
    this.rawCNIConfig = rawCNIConfig;
    return (A) this;
  }
  
  public A withSimpleMacvlanConfig(SimpleMacvlanConfig simpleMacvlanConfig) {
    this._visitables.remove("simpleMacvlanConfig");
    if (simpleMacvlanConfig != null) {
        this.simpleMacvlanConfig = new SimpleMacvlanConfigBuilder(simpleMacvlanConfig);
        this._visitables.get("simpleMacvlanConfig").add(this.simpleMacvlanConfig);
    } else {
        this.simpleMacvlanConfig = null;
        this._visitables.get("simpleMacvlanConfig").remove(this.simpleMacvlanConfig);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class SimpleMacvlanConfigNested<N> extends SimpleMacvlanConfigFluent<SimpleMacvlanConfigNested<N>> implements Nested<N>{
  
    SimpleMacvlanConfigBuilder builder;
  
    SimpleMacvlanConfigNested(SimpleMacvlanConfig item) {
      this.builder = new SimpleMacvlanConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AdditionalNetworkDefinitionFluent.this.withSimpleMacvlanConfig(builder.build());
    }
    
    public N endSimpleMacvlanConfig() {
      return and();
    }
    
  }
}