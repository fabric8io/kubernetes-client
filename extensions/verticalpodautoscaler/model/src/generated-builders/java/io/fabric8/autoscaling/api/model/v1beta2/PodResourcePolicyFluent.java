package io.fabric8.autoscaling.api.model.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PodResourcePolicyFluent<A extends io.fabric8.autoscaling.api.model.v1beta2.PodResourcePolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ContainerResourcePolicyBuilder> containerPolicies = new ArrayList<ContainerResourcePolicyBuilder>();

  public PodResourcePolicyFluent() {
  }
  
  public PodResourcePolicyFluent(PodResourcePolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToContainerPolicies(Collection<ContainerResourcePolicy> items) {
    if (this.containerPolicies == null) {
      this.containerPolicies = new ArrayList();
    }
    for (ContainerResourcePolicy item : items) {
        ContainerResourcePolicyBuilder builder = new ContainerResourcePolicyBuilder(item);
        _visitables.get("containerPolicies").add(builder);
        this.containerPolicies.add(builder);
    }
    return (A) this;
  }
  
  public ContainerPoliciesNested<A> addNewContainerPolicy() {
    return new ContainerPoliciesNested(-1, null);
  }
  
  public ContainerPoliciesNested<A> addNewContainerPolicyLike(ContainerResourcePolicy item) {
    return new ContainerPoliciesNested(-1, item);
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
  
  public A addToContainerPolicies(ContainerResourcePolicy... items) {
    if (this.containerPolicies == null) {
      this.containerPolicies = new ArrayList();
    }
    for (ContainerResourcePolicy item : items) {
        ContainerResourcePolicyBuilder builder = new ContainerResourcePolicyBuilder(item);
        _visitables.get("containerPolicies").add(builder);
        this.containerPolicies.add(builder);
    }
    return (A) this;
  }
  
  public A addToContainerPolicies(int index,ContainerResourcePolicy item) {
    if (this.containerPolicies == null) {
      this.containerPolicies = new ArrayList();
    }
    ContainerResourcePolicyBuilder builder = new ContainerResourcePolicyBuilder(item);
    if (index < 0 || index >= containerPolicies.size()) {
        _visitables.get("containerPolicies").add(builder);
        containerPolicies.add(builder);
    } else {
        _visitables.get("containerPolicies").add(builder);
        containerPolicies.add(index, builder);
    }
    return (A) this;
  }
  
  public List<ContainerResourcePolicy> buildContainerPolicies() {
    return this.containerPolicies != null ? build(containerPolicies) : null;
  }
  
  public ContainerResourcePolicy buildContainerPolicy(int index) {
    return this.containerPolicies.get(index).build();
  }
  
  public ContainerResourcePolicy buildFirstContainerPolicy() {
    return this.containerPolicies.get(0).build();
  }
  
  public ContainerResourcePolicy buildLastContainerPolicy() {
    return this.containerPolicies.get(containerPolicies.size() - 1).build();
  }
  
  public ContainerResourcePolicy buildMatchingContainerPolicy(Predicate<ContainerResourcePolicyBuilder> predicate) {
      for (ContainerResourcePolicyBuilder item : containerPolicies) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PodResourcePolicy instance) {
    instance = instance != null ? instance : new PodResourcePolicy();
    if (instance != null) {
        this.withContainerPolicies(instance.getContainerPolicies());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainerPoliciesNested<A> editContainerPolicy(int index) {
    if (containerPolicies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "containerPolicies"));
    }
    return this.setNewContainerPolicyLike(index, this.buildContainerPolicy(index));
  }
  
  public ContainerPoliciesNested<A> editFirstContainerPolicy() {
    if (containerPolicies.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containerPolicies"));
    }
    return this.setNewContainerPolicyLike(0, this.buildContainerPolicy(0));
  }
  
  public ContainerPoliciesNested<A> editLastContainerPolicy() {
    int index = containerPolicies.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containerPolicies"));
    }
    return this.setNewContainerPolicyLike(index, this.buildContainerPolicy(index));
  }
  
  public ContainerPoliciesNested<A> editMatchingContainerPolicy(Predicate<ContainerResourcePolicyBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < containerPolicies.size();i++) {
      if (predicate.test(containerPolicies.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "containerPolicies"));
    }
    return this.setNewContainerPolicyLike(index, this.buildContainerPolicy(index));
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
    PodResourcePolicyFluent that = (PodResourcePolicyFluent) o;
    if (!(Objects.equals(containerPolicies, that.containerPolicies))) {
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
  
  public boolean hasContainerPolicies() {
    return this.containerPolicies != null && !(this.containerPolicies.isEmpty());
  }
  
  public boolean hasMatchingContainerPolicy(Predicate<ContainerResourcePolicyBuilder> predicate) {
      for (ContainerResourcePolicyBuilder item : containerPolicies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(containerPolicies, additionalProperties);
  }
  
  public A removeAllFromContainerPolicies(Collection<ContainerResourcePolicy> items) {
    if (this.containerPolicies == null) {
      return (A) this;
    }
    for (ContainerResourcePolicy item : items) {
        ContainerResourcePolicyBuilder builder = new ContainerResourcePolicyBuilder(item);
        _visitables.get("containerPolicies").remove(builder);
        this.containerPolicies.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromContainerPolicies(ContainerResourcePolicy... items) {
    if (this.containerPolicies == null) {
      return (A) this;
    }
    for (ContainerResourcePolicy item : items) {
        ContainerResourcePolicyBuilder builder = new ContainerResourcePolicyBuilder(item);
        _visitables.get("containerPolicies").remove(builder);
        this.containerPolicies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromContainerPolicies(Predicate<ContainerResourcePolicyBuilder> predicate) {
    if (containerPolicies == null) {
      return (A) this;
    }
    Iterator<ContainerResourcePolicyBuilder> each = containerPolicies.iterator();
    List visitables = _visitables.get("containerPolicies");
    while (each.hasNext()) {
        ContainerResourcePolicyBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ContainerPoliciesNested<A> setNewContainerPolicyLike(int index,ContainerResourcePolicy item) {
    return new ContainerPoliciesNested(index, item);
  }
  
  public A setToContainerPolicies(int index,ContainerResourcePolicy item) {
    if (this.containerPolicies == null) {
      this.containerPolicies = new ArrayList();
    }
    ContainerResourcePolicyBuilder builder = new ContainerResourcePolicyBuilder(item);
    if (index < 0 || index >= containerPolicies.size()) {
        _visitables.get("containerPolicies").add(builder);
        containerPolicies.add(builder);
    } else {
        _visitables.get("containerPolicies").add(builder);
        containerPolicies.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(containerPolicies == null) && !(containerPolicies.isEmpty())) {
        sb.append("containerPolicies:");
        sb.append(containerPolicies);
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
  
  public A withContainerPolicies(List<ContainerResourcePolicy> containerPolicies) {
    if (this.containerPolicies != null) {
      this._visitables.get("containerPolicies").clear();
    }
    if (containerPolicies != null) {
        this.containerPolicies = new ArrayList();
        for (ContainerResourcePolicy item : containerPolicies) {
          this.addToContainerPolicies(item);
        }
    } else {
      this.containerPolicies = null;
    }
    return (A) this;
  }
  
  public A withContainerPolicies(ContainerResourcePolicy... containerPolicies) {
    if (this.containerPolicies != null) {
        this.containerPolicies.clear();
        _visitables.remove("containerPolicies");
    }
    if (containerPolicies != null) {
      for (ContainerResourcePolicy item : containerPolicies) {
        this.addToContainerPolicies(item);
      }
    }
    return (A) this;
  }
  public class ContainerPoliciesNested<N> extends ContainerResourcePolicyFluent<ContainerPoliciesNested<N>> implements Nested<N>{
  
    ContainerResourcePolicyBuilder builder;
    int index;
  
    ContainerPoliciesNested(int index,ContainerResourcePolicy item) {
      this.index = index;
      this.builder = new ContainerResourcePolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) PodResourcePolicyFluent.this.setToContainerPolicies(index, builder.build());
    }
    
    public N endContainerPolicy() {
      return and();
    }
    
  }
}