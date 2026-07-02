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
public class NodeRuntimeHandlerFluent<A extends io.fabric8.kubernetes.api.model.NodeRuntimeHandlerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NodeRuntimeHandlerFeaturesBuilder features;
  private String name;

  public NodeRuntimeHandlerFluent() {
  }
  
  public NodeRuntimeHandlerFluent(NodeRuntimeHandler instance) {
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
  
  public NodeRuntimeHandlerFeatures buildFeatures() {
    return this.features != null ? this.features.build() : null;
  }
  
  protected void copyInstance(NodeRuntimeHandler instance) {
    instance = instance != null ? instance : new NodeRuntimeHandler();
    if (instance != null) {
        this.withFeatures(instance.getFeatures());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FeaturesNested<A> editFeatures() {
    return this.withNewFeaturesLike(Optional.ofNullable(this.buildFeatures()).orElse(null));
  }
  
  public FeaturesNested<A> editOrNewFeatures() {
    return this.withNewFeaturesLike(Optional.ofNullable(this.buildFeatures()).orElse(new NodeRuntimeHandlerFeaturesBuilder().build()));
  }
  
  public FeaturesNested<A> editOrNewFeaturesLike(NodeRuntimeHandlerFeatures item) {
    return this.withNewFeaturesLike(Optional.ofNullable(this.buildFeatures()).orElse(item));
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
    NodeRuntimeHandlerFluent that = (NodeRuntimeHandlerFluent) o;
    if (!(Objects.equals(features, that.features))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFeatures() {
    return this.features != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(features, name, additionalProperties);
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
    if (!(features == null)) {
        sb.append("features:");
        sb.append(features);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withFeatures(NodeRuntimeHandlerFeatures features) {
    this._visitables.remove("features");
    if (features != null) {
        this.features = new NodeRuntimeHandlerFeaturesBuilder(features);
        this._visitables.get("features").add(this.features);
    } else {
        this.features = null;
        this._visitables.get("features").remove(this.features);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public FeaturesNested<A> withNewFeatures() {
    return new FeaturesNested(null);
  }
  
  public A withNewFeatures(Boolean recursiveReadOnlyMounts,Boolean userNamespaces) {
    return (A) this.withFeatures(new NodeRuntimeHandlerFeatures(recursiveReadOnlyMounts, userNamespaces));
  }
  
  public FeaturesNested<A> withNewFeaturesLike(NodeRuntimeHandlerFeatures item) {
    return new FeaturesNested(item);
  }
  public class FeaturesNested<N> extends NodeRuntimeHandlerFeaturesFluent<FeaturesNested<N>> implements Nested<N>{
  
    NodeRuntimeHandlerFeaturesBuilder builder;
  
    FeaturesNested(NodeRuntimeHandlerFeatures item) {
      this.builder = new NodeRuntimeHandlerFeaturesBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeRuntimeHandlerFluent.this.withFeatures(builder.build());
    }
    
    public N endFeatures() {
      return and();
    }
    
  }
}