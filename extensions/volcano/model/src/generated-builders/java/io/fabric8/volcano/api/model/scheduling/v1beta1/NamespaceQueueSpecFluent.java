package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
import java.lang.Boolean;
import java.lang.Integer;
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
public class NamespaceQueueSpecFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.NamespaceQueueSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Quantity> capability;
  private String dequeueStrategy;
  private Map<String,Quantity> deserved;
  private GuaranteeBuilder guarantee;
  private String parent;
  private Integer priority;
  private Boolean reclaimable;

  public NamespaceQueueSpecFluent() {
  }
  
  public NamespaceQueueSpecFluent(NamespaceQueueSpec instance) {
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
  
  public A addToCapability(Map<String,Quantity> map) {
    if (this.capability == null && map != null) {
      this.capability = new LinkedHashMap();
    }
    if (map != null) {
      this.capability.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCapability(String key,Quantity value) {
    if (this.capability == null && key != null && value != null) {
      this.capability = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.capability.put(key, value);
    }
    return (A) this;
  }
  
  public A addToDeserved(Map<String,Quantity> map) {
    if (this.deserved == null && map != null) {
      this.deserved = new LinkedHashMap();
    }
    if (map != null) {
      this.deserved.putAll(map);
    }
    return (A) this;
  }
  
  public A addToDeserved(String key,Quantity value) {
    if (this.deserved == null && key != null && value != null) {
      this.deserved = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.deserved.put(key, value);
    }
    return (A) this;
  }
  
  public Guarantee buildGuarantee() {
    return this.guarantee != null ? this.guarantee.build() : null;
  }
  
  protected void copyInstance(NamespaceQueueSpec instance) {
    instance = instance != null ? instance : new NamespaceQueueSpec();
    if (instance != null) {
        this.withCapability(instance.getCapability());
        this.withDequeueStrategy(instance.getDequeueStrategy());
        this.withDeserved(instance.getDeserved());
        this.withGuarantee(instance.getGuarantee());
        this.withParent(instance.getParent());
        this.withPriority(instance.getPriority());
        this.withReclaimable(instance.getReclaimable());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GuaranteeNested<A> editGuarantee() {
    return this.withNewGuaranteeLike(Optional.ofNullable(this.buildGuarantee()).orElse(null));
  }
  
  public GuaranteeNested<A> editOrNewGuarantee() {
    return this.withNewGuaranteeLike(Optional.ofNullable(this.buildGuarantee()).orElse(new GuaranteeBuilder().build()));
  }
  
  public GuaranteeNested<A> editOrNewGuaranteeLike(Guarantee item) {
    return this.withNewGuaranteeLike(Optional.ofNullable(this.buildGuarantee()).orElse(item));
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
    NamespaceQueueSpecFluent that = (NamespaceQueueSpecFluent) o;
    if (!(Objects.equals(capability, that.capability))) {
      return false;
    }
    if (!(Objects.equals(dequeueStrategy, that.dequeueStrategy))) {
      return false;
    }
    if (!(Objects.equals(deserved, that.deserved))) {
      return false;
    }
    if (!(Objects.equals(guarantee, that.guarantee))) {
      return false;
    }
    if (!(Objects.equals(parent, that.parent))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(reclaimable, that.reclaimable))) {
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
  
  public Map<String,Quantity> getCapability() {
    return this.capability;
  }
  
  public String getDequeueStrategy() {
    return this.dequeueStrategy;
  }
  
  public Map<String,Quantity> getDeserved() {
    return this.deserved;
  }
  
  public String getParent() {
    return this.parent;
  }
  
  public Integer getPriority() {
    return this.priority;
  }
  
  public Boolean getReclaimable() {
    return this.reclaimable;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCapability() {
    return this.capability != null;
  }
  
  public boolean hasDequeueStrategy() {
    return this.dequeueStrategy != null;
  }
  
  public boolean hasDeserved() {
    return this.deserved != null;
  }
  
  public boolean hasGuarantee() {
    return this.guarantee != null;
  }
  
  public boolean hasParent() {
    return this.parent != null;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasReclaimable() {
    return this.reclaimable != null;
  }
  
  public int hashCode() {
    return Objects.hash(capability, dequeueStrategy, deserved, guarantee, parent, priority, reclaimable, additionalProperties);
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
  
  public A removeFromCapability(String key) {
    if (this.capability == null) {
      return (A) this;
    }
    if (key != null && this.capability != null) {
      this.capability.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCapability(Map<String,Quantity> map) {
    if (this.capability == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.capability != null) {
          this.capability.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromDeserved(String key) {
    if (this.deserved == null) {
      return (A) this;
    }
    if (key != null && this.deserved != null) {
      this.deserved.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromDeserved(Map<String,Quantity> map) {
    if (this.deserved == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.deserved != null) {
          this.deserved.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(capability == null) && !(capability.isEmpty())) {
        sb.append("capability:");
        sb.append(capability);
        sb.append(",");
    }
    if (!(dequeueStrategy == null)) {
        sb.append("dequeueStrategy:");
        sb.append(dequeueStrategy);
        sb.append(",");
    }
    if (!(deserved == null) && !(deserved.isEmpty())) {
        sb.append("deserved:");
        sb.append(deserved);
        sb.append(",");
    }
    if (!(guarantee == null)) {
        sb.append("guarantee:");
        sb.append(guarantee);
        sb.append(",");
    }
    if (!(parent == null)) {
        sb.append("parent:");
        sb.append(parent);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
        sb.append(",");
    }
    if (!(reclaimable == null)) {
        sb.append("reclaimable:");
        sb.append(reclaimable);
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
  
  public <K,V>A withCapability(Map<String,Quantity> capability) {
    if (capability == null) {
      this.capability = null;
    } else {
      this.capability = new LinkedHashMap(capability);
    }
    return (A) this;
  }
  
  public A withDequeueStrategy(String dequeueStrategy) {
    this.dequeueStrategy = dequeueStrategy;
    return (A) this;
  }
  
  public <K,V>A withDeserved(Map<String,Quantity> deserved) {
    if (deserved == null) {
      this.deserved = null;
    } else {
      this.deserved = new LinkedHashMap(deserved);
    }
    return (A) this;
  }
  
  public A withGuarantee(Guarantee guarantee) {
    this._visitables.remove("guarantee");
    if (guarantee != null) {
        this.guarantee = new GuaranteeBuilder(guarantee);
        this._visitables.get("guarantee").add(this.guarantee);
    } else {
        this.guarantee = null;
        this._visitables.get("guarantee").remove(this.guarantee);
    }
    return (A) this;
  }
  
  public GuaranteeNested<A> withNewGuarantee() {
    return new GuaranteeNested(null);
  }
  
  public GuaranteeNested<A> withNewGuaranteeLike(Guarantee item) {
    return new GuaranteeNested(item);
  }
  
  public A withParent(String parent) {
    this.parent = parent;
    return (A) this;
  }
  
  public A withPriority(Integer priority) {
    this.priority = priority;
    return (A) this;
  }
  
  public A withReclaimable() {
    return withReclaimable(true);
  }
  
  public A withReclaimable(Boolean reclaimable) {
    this.reclaimable = reclaimable;
    return (A) this;
  }
  public class GuaranteeNested<N> extends GuaranteeFluent<GuaranteeNested<N>> implements Nested<N>{
  
    GuaranteeBuilder builder;
  
    GuaranteeNested(Guarantee item) {
      this.builder = new GuaranteeBuilder(this, item);
    }
  
    public N and() {
      return (N) NamespaceQueueSpecFluent.this.withGuarantee(builder.build());
    }
    
    public N endGuarantee() {
      return and();
    }
    
  }
}