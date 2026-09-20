package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
import java.lang.Integer;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PodGroupSpecFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.PodGroupSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer minMember;
  private Map<String,Quantity> minResources;
  private Map<String,Integer> minTaskMember;
  private NetworkTopologySpecBuilder networkTopology;
  private String priorityClassName;
  private String queue;
  private ArrayList<SubGroupPolicySpecBuilder> subGroupPolicy = new ArrayList<SubGroupPolicySpecBuilder>();

  public PodGroupSpecFluent() {
  }
  
  public PodGroupSpecFluent(PodGroupSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToSubGroupPolicy(Collection<SubGroupPolicySpec> items) {
    if (this.subGroupPolicy == null) {
      this.subGroupPolicy = new ArrayList();
    }
    for (SubGroupPolicySpec item : items) {
        SubGroupPolicySpecBuilder builder = new SubGroupPolicySpecBuilder(item);
        _visitables.get("subGroupPolicy").add(builder);
        this.subGroupPolicy.add(builder);
    }
    return (A) this;
  }
  
  public SubGroupPolicyNested<A> addNewSubGroupPolicy() {
    return new SubGroupPolicyNested(-1, null);
  }
  
  public SubGroupPolicyNested<A> addNewSubGroupPolicyLike(SubGroupPolicySpec item) {
    return new SubGroupPolicyNested(-1, item);
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
  
  public A addToMinResources(Map<String,Quantity> map) {
    if (this.minResources == null && map != null) {
      this.minResources = new LinkedHashMap();
    }
    if (map != null) {
      this.minResources.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMinResources(String key,Quantity value) {
    if (this.minResources == null && key != null && value != null) {
      this.minResources = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.minResources.put(key, value);
    }
    return (A) this;
  }
  
  public A addToMinTaskMember(Map<String,Integer> map) {
    if (this.minTaskMember == null && map != null) {
      this.minTaskMember = new LinkedHashMap();
    }
    if (map != null) {
      this.minTaskMember.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMinTaskMember(String key,Integer value) {
    if (this.minTaskMember == null && key != null && value != null) {
      this.minTaskMember = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.minTaskMember.put(key, value);
    }
    return (A) this;
  }
  
  public A addToSubGroupPolicy(SubGroupPolicySpec... items) {
    if (this.subGroupPolicy == null) {
      this.subGroupPolicy = new ArrayList();
    }
    for (SubGroupPolicySpec item : items) {
        SubGroupPolicySpecBuilder builder = new SubGroupPolicySpecBuilder(item);
        _visitables.get("subGroupPolicy").add(builder);
        this.subGroupPolicy.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubGroupPolicy(int index,SubGroupPolicySpec item) {
    if (this.subGroupPolicy == null) {
      this.subGroupPolicy = new ArrayList();
    }
    SubGroupPolicySpecBuilder builder = new SubGroupPolicySpecBuilder(item);
    if (index < 0 || index >= subGroupPolicy.size()) {
        _visitables.get("subGroupPolicy").add(builder);
        subGroupPolicy.add(builder);
    } else {
        _visitables.get("subGroupPolicy").add(builder);
        subGroupPolicy.add(index, builder);
    }
    return (A) this;
  }
  
  public SubGroupPolicySpec buildFirstSubGroupPolicy() {
    return this.subGroupPolicy.get(0).build();
  }
  
  public SubGroupPolicySpec buildLastSubGroupPolicy() {
    return this.subGroupPolicy.get(subGroupPolicy.size() - 1).build();
  }
  
  public SubGroupPolicySpec buildMatchingSubGroupPolicy(Predicate<SubGroupPolicySpecBuilder> predicate) {
      for (SubGroupPolicySpecBuilder item : subGroupPolicy) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkTopologySpec buildNetworkTopology() {
    return this.networkTopology != null ? this.networkTopology.build() : null;
  }
  
  public List<SubGroupPolicySpec> buildSubGroupPolicy() {
    return this.subGroupPolicy != null ? build(subGroupPolicy) : null;
  }
  
  public SubGroupPolicySpec buildSubGroupPolicy(int index) {
    return this.subGroupPolicy.get(index).build();
  }
  
  protected void copyInstance(PodGroupSpec instance) {
    instance = instance != null ? instance : new PodGroupSpec();
    if (instance != null) {
        this.withMinMember(instance.getMinMember());
        this.withMinResources(instance.getMinResources());
        this.withMinTaskMember(instance.getMinTaskMember());
        this.withNetworkTopology(instance.getNetworkTopology());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withQueue(instance.getQueue());
        this.withSubGroupPolicy(instance.getSubGroupPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SubGroupPolicyNested<A> editFirstSubGroupPolicy() {
    if (subGroupPolicy.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subGroupPolicy"));
    }
    return this.setNewSubGroupPolicyLike(0, this.buildSubGroupPolicy(0));
  }
  
  public SubGroupPolicyNested<A> editLastSubGroupPolicy() {
    int index = subGroupPolicy.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subGroupPolicy"));
    }
    return this.setNewSubGroupPolicyLike(index, this.buildSubGroupPolicy(index));
  }
  
  public SubGroupPolicyNested<A> editMatchingSubGroupPolicy(Predicate<SubGroupPolicySpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subGroupPolicy.size();i++) {
      if (predicate.test(subGroupPolicy.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subGroupPolicy"));
    }
    return this.setNewSubGroupPolicyLike(index, this.buildSubGroupPolicy(index));
  }
  
  public NetworkTopologyNested<A> editNetworkTopology() {
    return this.withNewNetworkTopologyLike(Optional.ofNullable(this.buildNetworkTopology()).orElse(null));
  }
  
  public NetworkTopologyNested<A> editOrNewNetworkTopology() {
    return this.withNewNetworkTopologyLike(Optional.ofNullable(this.buildNetworkTopology()).orElse(new NetworkTopologySpecBuilder().build()));
  }
  
  public NetworkTopologyNested<A> editOrNewNetworkTopologyLike(NetworkTopologySpec item) {
    return this.withNewNetworkTopologyLike(Optional.ofNullable(this.buildNetworkTopology()).orElse(item));
  }
  
  public SubGroupPolicyNested<A> editSubGroupPolicy(int index) {
    if (subGroupPolicy.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subGroupPolicy"));
    }
    return this.setNewSubGroupPolicyLike(index, this.buildSubGroupPolicy(index));
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
    PodGroupSpecFluent that = (PodGroupSpecFluent) o;
    if (!(Objects.equals(minMember, that.minMember))) {
      return false;
    }
    if (!(Objects.equals(minResources, that.minResources))) {
      return false;
    }
    if (!(Objects.equals(minTaskMember, that.minTaskMember))) {
      return false;
    }
    if (!(Objects.equals(networkTopology, that.networkTopology))) {
      return false;
    }
    if (!(Objects.equals(priorityClassName, that.priorityClassName))) {
      return false;
    }
    if (!(Objects.equals(queue, that.queue))) {
      return false;
    }
    if (!(Objects.equals(subGroupPolicy, that.subGroupPolicy))) {
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
  
  public Integer getMinMember() {
    return this.minMember;
  }
  
  public Map<String,Quantity> getMinResources() {
    return this.minResources;
  }
  
  public Map<String,Integer> getMinTaskMember() {
    return this.minTaskMember;
  }
  
  public String getPriorityClassName() {
    return this.priorityClassName;
  }
  
  public String getQueue() {
    return this.queue;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingSubGroupPolicy(Predicate<SubGroupPolicySpecBuilder> predicate) {
      for (SubGroupPolicySpecBuilder item : subGroupPolicy) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMinMember() {
    return this.minMember != null;
  }
  
  public boolean hasMinResources() {
    return this.minResources != null;
  }
  
  public boolean hasMinTaskMember() {
    return this.minTaskMember != null;
  }
  
  public boolean hasNetworkTopology() {
    return this.networkTopology != null;
  }
  
  public boolean hasPriorityClassName() {
    return this.priorityClassName != null;
  }
  
  public boolean hasQueue() {
    return this.queue != null;
  }
  
  public boolean hasSubGroupPolicy() {
    return this.subGroupPolicy != null && !(this.subGroupPolicy.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(minMember, minResources, minTaskMember, networkTopology, priorityClassName, queue, subGroupPolicy, additionalProperties);
  }
  
  public A removeAllFromSubGroupPolicy(Collection<SubGroupPolicySpec> items) {
    if (this.subGroupPolicy == null) {
      return (A) this;
    }
    for (SubGroupPolicySpec item : items) {
        SubGroupPolicySpecBuilder builder = new SubGroupPolicySpecBuilder(item);
        _visitables.get("subGroupPolicy").remove(builder);
        this.subGroupPolicy.remove(builder);
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
  
  public A removeFromMinResources(String key) {
    if (this.minResources == null) {
      return (A) this;
    }
    if (key != null && this.minResources != null) {
      this.minResources.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMinResources(Map<String,Quantity> map) {
    if (this.minResources == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.minResources != null) {
          this.minResources.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromMinTaskMember(String key) {
    if (this.minTaskMember == null) {
      return (A) this;
    }
    if (key != null && this.minTaskMember != null) {
      this.minTaskMember.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMinTaskMember(Map<String,Integer> map) {
    if (this.minTaskMember == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.minTaskMember != null) {
          this.minTaskMember.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromSubGroupPolicy(SubGroupPolicySpec... items) {
    if (this.subGroupPolicy == null) {
      return (A) this;
    }
    for (SubGroupPolicySpec item : items) {
        SubGroupPolicySpecBuilder builder = new SubGroupPolicySpecBuilder(item);
        _visitables.get("subGroupPolicy").remove(builder);
        this.subGroupPolicy.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubGroupPolicy(Predicate<SubGroupPolicySpecBuilder> predicate) {
    if (subGroupPolicy == null) {
      return (A) this;
    }
    Iterator<SubGroupPolicySpecBuilder> each = subGroupPolicy.iterator();
    List visitables = _visitables.get("subGroupPolicy");
    while (each.hasNext()) {
        SubGroupPolicySpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubGroupPolicyNested<A> setNewSubGroupPolicyLike(int index,SubGroupPolicySpec item) {
    return new SubGroupPolicyNested(index, item);
  }
  
  public A setToSubGroupPolicy(int index,SubGroupPolicySpec item) {
    if (this.subGroupPolicy == null) {
      this.subGroupPolicy = new ArrayList();
    }
    SubGroupPolicySpecBuilder builder = new SubGroupPolicySpecBuilder(item);
    if (index < 0 || index >= subGroupPolicy.size()) {
        _visitables.get("subGroupPolicy").add(builder);
        subGroupPolicy.add(builder);
    } else {
        _visitables.get("subGroupPolicy").add(builder);
        subGroupPolicy.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(minMember == null)) {
        sb.append("minMember:");
        sb.append(minMember);
        sb.append(",");
    }
    if (!(minResources == null) && !(minResources.isEmpty())) {
        sb.append("minResources:");
        sb.append(minResources);
        sb.append(",");
    }
    if (!(minTaskMember == null) && !(minTaskMember.isEmpty())) {
        sb.append("minTaskMember:");
        sb.append(minTaskMember);
        sb.append(",");
    }
    if (!(networkTopology == null)) {
        sb.append("networkTopology:");
        sb.append(networkTopology);
        sb.append(",");
    }
    if (!(priorityClassName == null)) {
        sb.append("priorityClassName:");
        sb.append(priorityClassName);
        sb.append(",");
    }
    if (!(queue == null)) {
        sb.append("queue:");
        sb.append(queue);
        sb.append(",");
    }
    if (!(subGroupPolicy == null) && !(subGroupPolicy.isEmpty())) {
        sb.append("subGroupPolicy:");
        sb.append(subGroupPolicy);
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
  
  public A withMinMember(Integer minMember) {
    this.minMember = minMember;
    return (A) this;
  }
  
  public <K,V>A withMinResources(Map<String,Quantity> minResources) {
    if (minResources == null) {
      this.minResources = null;
    } else {
      this.minResources = new LinkedHashMap(minResources);
    }
    return (A) this;
  }
  
  public <K,V>A withMinTaskMember(Map<String,Integer> minTaskMember) {
    if (minTaskMember == null) {
      this.minTaskMember = null;
    } else {
      this.minTaskMember = new LinkedHashMap(minTaskMember);
    }
    return (A) this;
  }
  
  public A withNetworkTopology(NetworkTopologySpec networkTopology) {
    this._visitables.remove("networkTopology");
    if (networkTopology != null) {
        this.networkTopology = new NetworkTopologySpecBuilder(networkTopology);
        this._visitables.get("networkTopology").add(this.networkTopology);
    } else {
        this.networkTopology = null;
        this._visitables.get("networkTopology").remove(this.networkTopology);
    }
    return (A) this;
  }
  
  public NetworkTopologyNested<A> withNewNetworkTopology() {
    return new NetworkTopologyNested(null);
  }
  
  public A withNewNetworkTopology(Integer highestTierAllowed,String highestTierName,String mode) {
    return (A) this.withNetworkTopology(new NetworkTopologySpec(highestTierAllowed, highestTierName, mode));
  }
  
  public NetworkTopologyNested<A> withNewNetworkTopologyLike(NetworkTopologySpec item) {
    return new NetworkTopologyNested(item);
  }
  
  public A withPriorityClassName(String priorityClassName) {
    this.priorityClassName = priorityClassName;
    return (A) this;
  }
  
  public A withQueue(String queue) {
    this.queue = queue;
    return (A) this;
  }
  
  public A withSubGroupPolicy(List<SubGroupPolicySpec> subGroupPolicy) {
    if (this.subGroupPolicy != null) {
      this._visitables.get("subGroupPolicy").clear();
    }
    if (subGroupPolicy != null) {
        this.subGroupPolicy = new ArrayList();
        for (SubGroupPolicySpec item : subGroupPolicy) {
          this.addToSubGroupPolicy(item);
        }
    } else {
      this.subGroupPolicy = null;
    }
    return (A) this;
  }
  
  public A withSubGroupPolicy(SubGroupPolicySpec... subGroupPolicy) {
    if (this.subGroupPolicy != null) {
        this.subGroupPolicy.clear();
        _visitables.remove("subGroupPolicy");
    }
    if (subGroupPolicy != null) {
      for (SubGroupPolicySpec item : subGroupPolicy) {
        this.addToSubGroupPolicy(item);
      }
    }
    return (A) this;
  }
  public class NetworkTopologyNested<N> extends NetworkTopologySpecFluent<NetworkTopologyNested<N>> implements Nested<N>{
  
    NetworkTopologySpecBuilder builder;
  
    NetworkTopologyNested(NetworkTopologySpec item) {
      this.builder = new NetworkTopologySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupSpecFluent.this.withNetworkTopology(builder.build());
    }
    
    public N endNetworkTopology() {
      return and();
    }
    
  }
  public class SubGroupPolicyNested<N> extends SubGroupPolicySpecFluent<SubGroupPolicyNested<N>> implements Nested<N>{
  
    SubGroupPolicySpecBuilder builder;
    int index;
  
    SubGroupPolicyNested(int index,SubGroupPolicySpec item) {
      this.index = index;
      this.builder = new SubGroupPolicySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupSpecFluent.this.setToSubGroupPolicy(index, builder.build());
    }
    
    public N endSubGroupPolicy() {
      return and();
    }
    
  }
}