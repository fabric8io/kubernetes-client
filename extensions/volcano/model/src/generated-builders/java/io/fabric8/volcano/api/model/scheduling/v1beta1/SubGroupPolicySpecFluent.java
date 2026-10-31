package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class SubGroupPolicySpecFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.SubGroupPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder labelSelector;
  private List<String> matchLabelKeys = new ArrayList<String>();
  private Integer minSubGroups;
  private String name;
  private NetworkTopologySpecBuilder networkTopology;
  private Integer subGroupSize;

  public SubGroupPolicySpecFluent() {
  }
  
  public SubGroupPolicySpecFluent(SubGroupPolicySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatchLabelKeys(Collection<String> items) {
    if (this.matchLabelKeys == null) {
      this.matchLabelKeys = new ArrayList();
    }
    for (String item : items) {
      this.matchLabelKeys.add(item);
    }
    return (A) this;
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
  
  public A addToMatchLabelKeys(String... items) {
    if (this.matchLabelKeys == null) {
      this.matchLabelKeys = new ArrayList();
    }
    for (String item : items) {
      this.matchLabelKeys.add(item);
    }
    return (A) this;
  }
  
  public A addToMatchLabelKeys(int index,String item) {
    if (this.matchLabelKeys == null) {
      this.matchLabelKeys = new ArrayList();
    }
    this.matchLabelKeys.add(index, item);
    return (A) this;
  }
  
  public LabelSelector buildLabelSelector() {
    return this.labelSelector != null ? this.labelSelector.build() : null;
  }
  
  public NetworkTopologySpec buildNetworkTopology() {
    return this.networkTopology != null ? this.networkTopology.build() : null;
  }
  
  protected void copyInstance(SubGroupPolicySpec instance) {
    instance = instance != null ? instance : new SubGroupPolicySpec();
    if (instance != null) {
        this.withLabelSelector(instance.getLabelSelector());
        this.withMatchLabelKeys(instance.getMatchLabelKeys());
        this.withMinSubGroups(instance.getMinSubGroups());
        this.withName(instance.getName());
        this.withNetworkTopology(instance.getNetworkTopology());
        this.withSubGroupSize(instance.getSubGroupSize());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LabelSelectorNested<A> editLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(null));
  }
  
  public NetworkTopologyNested<A> editNetworkTopology() {
    return this.withNewNetworkTopologyLike(Optional.ofNullable(this.buildNetworkTopology()).orElse(null));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelectorLike(LabelSelector item) {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(item));
  }
  
  public NetworkTopologyNested<A> editOrNewNetworkTopology() {
    return this.withNewNetworkTopologyLike(Optional.ofNullable(this.buildNetworkTopology()).orElse(new NetworkTopologySpecBuilder().build()));
  }
  
  public NetworkTopologyNested<A> editOrNewNetworkTopologyLike(NetworkTopologySpec item) {
    return this.withNewNetworkTopologyLike(Optional.ofNullable(this.buildNetworkTopology()).orElse(item));
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
    SubGroupPolicySpecFluent that = (SubGroupPolicySpecFluent) o;
    if (!(Objects.equals(labelSelector, that.labelSelector))) {
      return false;
    }
    if (!(Objects.equals(matchLabelKeys, that.matchLabelKeys))) {
      return false;
    }
    if (!(Objects.equals(minSubGroups, that.minSubGroups))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(networkTopology, that.networkTopology))) {
      return false;
    }
    if (!(Objects.equals(subGroupSize, that.subGroupSize))) {
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
  
  public String getFirstMatchLabelKey() {
    return this.matchLabelKeys.get(0);
  }
  
  public String getLastMatchLabelKey() {
    return this.matchLabelKeys.get(matchLabelKeys.size() - 1);
  }
  
  public String getMatchLabelKey(int index) {
    return this.matchLabelKeys.get(index);
  }
  
  public List<String> getMatchLabelKeys() {
    return this.matchLabelKeys;
  }
  
  public String getMatchingMatchLabelKey(Predicate<String> predicate) {
      for (String item : matchLabelKeys) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMinSubGroups() {
    return this.minSubGroups;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Integer getSubGroupSize() {
    return this.subGroupSize;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLabelSelector() {
    return this.labelSelector != null;
  }
  
  public boolean hasMatchLabelKeys() {
    return this.matchLabelKeys != null && !(this.matchLabelKeys.isEmpty());
  }
  
  public boolean hasMatchingMatchLabelKey(Predicate<String> predicate) {
      for (String item : matchLabelKeys) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMinSubGroups() {
    return this.minSubGroups != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNetworkTopology() {
    return this.networkTopology != null;
  }
  
  public boolean hasSubGroupSize() {
    return this.subGroupSize != null;
  }
  
  public int hashCode() {
    return Objects.hash(labelSelector, matchLabelKeys, minSubGroups, name, networkTopology, subGroupSize, additionalProperties);
  }
  
  public A removeAllFromMatchLabelKeys(Collection<String> items) {
    if (this.matchLabelKeys == null) {
      return (A) this;
    }
    for (String item : items) {
      this.matchLabelKeys.remove(item);
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
  
  public A removeFromMatchLabelKeys(String... items) {
    if (this.matchLabelKeys == null) {
      return (A) this;
    }
    for (String item : items) {
      this.matchLabelKeys.remove(item);
    }
    return (A) this;
  }
  
  public A setToMatchLabelKeys(int index,String item) {
    if (this.matchLabelKeys == null) {
      this.matchLabelKeys = new ArrayList();
    }
    this.matchLabelKeys.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(labelSelector == null)) {
        sb.append("labelSelector:");
        sb.append(labelSelector);
        sb.append(",");
    }
    if (!(matchLabelKeys == null) && !(matchLabelKeys.isEmpty())) {
        sb.append("matchLabelKeys:");
        sb.append(matchLabelKeys);
        sb.append(",");
    }
    if (!(minSubGroups == null)) {
        sb.append("minSubGroups:");
        sb.append(minSubGroups);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(networkTopology == null)) {
        sb.append("networkTopology:");
        sb.append(networkTopology);
        sb.append(",");
    }
    if (!(subGroupSize == null)) {
        sb.append("subGroupSize:");
        sb.append(subGroupSize);
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
  
  public A withLabelSelector(LabelSelector labelSelector) {
    this._visitables.remove("labelSelector");
    if (labelSelector != null) {
        this.labelSelector = new LabelSelectorBuilder(labelSelector);
        this._visitables.get("labelSelector").add(this.labelSelector);
    } else {
        this.labelSelector = null;
        this._visitables.get("labelSelector").remove(this.labelSelector);
    }
    return (A) this;
  }
  
  public A withMatchLabelKeys(List<String> matchLabelKeys) {
    if (matchLabelKeys != null) {
        this.matchLabelKeys = new ArrayList();
        for (String item : matchLabelKeys) {
          this.addToMatchLabelKeys(item);
        }
    } else {
      this.matchLabelKeys = null;
    }
    return (A) this;
  }
  
  public A withMatchLabelKeys(String... matchLabelKeys) {
    if (this.matchLabelKeys != null) {
        this.matchLabelKeys.clear();
        _visitables.remove("matchLabelKeys");
    }
    if (matchLabelKeys != null) {
      for (String item : matchLabelKeys) {
        this.addToMatchLabelKeys(item);
      }
    }
    return (A) this;
  }
  
  public A withMinSubGroups(Integer minSubGroups) {
    this.minSubGroups = minSubGroups;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
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
  
  public LabelSelectorNested<A> withNewLabelSelector() {
    return new LabelSelectorNested(null);
  }
  
  public LabelSelectorNested<A> withNewLabelSelectorLike(LabelSelector item) {
    return new LabelSelectorNested(item);
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
  
  public A withSubGroupSize(Integer subGroupSize) {
    this.subGroupSize = subGroupSize;
    return (A) this;
  }
  public class LabelSelectorNested<N> extends LabelSelectorFluent<LabelSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    LabelSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) SubGroupPolicySpecFluent.this.withLabelSelector(builder.build());
    }
    
    public N endLabelSelector() {
      return and();
    }
    
  }
  public class NetworkTopologyNested<N> extends NetworkTopologySpecFluent<NetworkTopologyNested<N>> implements Nested<N>{
  
    NetworkTopologySpecBuilder builder;
  
    NetworkTopologyNested(NetworkTopologySpec item) {
      this.builder = new NetworkTopologySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) SubGroupPolicySpecFluent.this.withNetworkTopology(builder.build());
    }
    
    public N endNetworkTopology() {
      return and();
    }
    
  }
}