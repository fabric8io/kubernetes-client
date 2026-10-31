package io.fabric8.kubernetes.api.model;

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
public class NodeAllocatableOverheadResourcesFluent<A extends io.fabric8.kubernetes.api.model.NodeAllocatableOverheadResourcesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private QuantityBuilder perContainer;
  private QuantityBuilder perPod;

  public NodeAllocatableOverheadResourcesFluent() {
  }
  
  public NodeAllocatableOverheadResourcesFluent(NodeAllocatableOverheadResources instance) {
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
  
  public Quantity buildPerContainer() {
    return this.perContainer != null ? this.perContainer.build() : null;
  }
  
  public Quantity buildPerPod() {
    return this.perPod != null ? this.perPod.build() : null;
  }
  
  protected void copyInstance(NodeAllocatableOverheadResources instance) {
    instance = instance != null ? instance : new NodeAllocatableOverheadResources();
    if (instance != null) {
        this.withName(instance.getName());
        this.withPerContainer(instance.getPerContainer());
        this.withPerPod(instance.getPerPod());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PerContainerNested<A> editOrNewPerContainer() {
    return this.withNewPerContainerLike(Optional.ofNullable(this.buildPerContainer()).orElse(new QuantityBuilder().build()));
  }
  
  public PerContainerNested<A> editOrNewPerContainerLike(Quantity item) {
    return this.withNewPerContainerLike(Optional.ofNullable(this.buildPerContainer()).orElse(item));
  }
  
  public PerPodNested<A> editOrNewPerPod() {
    return this.withNewPerPodLike(Optional.ofNullable(this.buildPerPod()).orElse(new QuantityBuilder().build()));
  }
  
  public PerPodNested<A> editOrNewPerPodLike(Quantity item) {
    return this.withNewPerPodLike(Optional.ofNullable(this.buildPerPod()).orElse(item));
  }
  
  public PerContainerNested<A> editPerContainer() {
    return this.withNewPerContainerLike(Optional.ofNullable(this.buildPerContainer()).orElse(null));
  }
  
  public PerPodNested<A> editPerPod() {
    return this.withNewPerPodLike(Optional.ofNullable(this.buildPerPod()).orElse(null));
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
    NodeAllocatableOverheadResourcesFluent that = (NodeAllocatableOverheadResourcesFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(perContainer, that.perContainer))) {
      return false;
    }
    if (!(Objects.equals(perPod, that.perPod))) {
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
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPerContainer() {
    return this.perContainer != null;
  }
  
  public boolean hasPerPod() {
    return this.perPod != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, perContainer, perPod, additionalProperties);
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
    if (!(perContainer == null)) {
        sb.append("perContainer:");
        sb.append(perContainer);
        sb.append(",");
    }
    if (!(perPod == null)) {
        sb.append("perPod:");
        sb.append(perPod);
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
  
  public PerContainerNested<A> withNewPerContainer() {
    return new PerContainerNested(null);
  }
  
  public A withNewPerContainer(String amount) {
    return (A) this.withPerContainer(new Quantity(amount));
  }
  
  public A withNewPerContainer(String amount,String format) {
    return (A) this.withPerContainer(new Quantity(amount, format));
  }
  
  public PerContainerNested<A> withNewPerContainerLike(Quantity item) {
    return new PerContainerNested(item);
  }
  
  public PerPodNested<A> withNewPerPod() {
    return new PerPodNested(null);
  }
  
  public A withNewPerPod(String amount) {
    return (A) this.withPerPod(new Quantity(amount));
  }
  
  public A withNewPerPod(String amount,String format) {
    return (A) this.withPerPod(new Quantity(amount, format));
  }
  
  public PerPodNested<A> withNewPerPodLike(Quantity item) {
    return new PerPodNested(item);
  }
  
  public A withPerContainer(Quantity perContainer) {
    this._visitables.remove("perContainer");
    if (perContainer != null) {
        this.perContainer = new QuantityBuilder(perContainer);
        this._visitables.get("perContainer").add(this.perContainer);
    } else {
        this.perContainer = null;
        this._visitables.get("perContainer").remove(this.perContainer);
    }
    return (A) this;
  }
  
  public A withPerPod(Quantity perPod) {
    this._visitables.remove("perPod");
    if (perPod != null) {
        this.perPod = new QuantityBuilder(perPod);
        this._visitables.get("perPod").add(this.perPod);
    } else {
        this.perPod = null;
        this._visitables.get("perPod").remove(this.perPod);
    }
    return (A) this;
  }
  public class PerContainerNested<N> extends QuantityFluent<PerContainerNested<N>> implements Nested<N>{
  
    QuantityBuilder builder;
  
    PerContainerNested(Quantity item) {
      this.builder = new QuantityBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeAllocatableOverheadResourcesFluent.this.withPerContainer(builder.build());
    }
    
    public N endPerContainer() {
      return and();
    }
    
  }
  public class PerPodNested<N> extends QuantityFluent<PerPodNested<N>> implements Nested<N>{
  
    QuantityBuilder builder;
  
    PerPodNested(Quantity item) {
      this.builder = new QuantityBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeAllocatableOverheadResourcesFluent.this.withPerPod(builder.build());
    }
    
    public N endPerPod() {
      return and();
    }
    
  }
}