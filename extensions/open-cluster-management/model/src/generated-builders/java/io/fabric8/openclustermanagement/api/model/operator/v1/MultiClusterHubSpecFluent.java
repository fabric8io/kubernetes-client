package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Toleration;
import java.lang.Boolean;
import java.lang.Long;
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
public class MultiClusterHubSpecFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.MultiClusterHubSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String availabilityConfig;
  private Boolean disableHubSelfManagement;
  private Boolean disableUpdateClusterImageSets;
  private String imagePullSecret;
  private String localClusterName;
  private NetworkPoliciesConfigBuilder networkPolicies;
  private Map<String,String> nodeSelector;
  private OverridesBuilder overrides;
  private List<Toleration> tolerations = new ArrayList<Toleration>();

  public MultiClusterHubSpecFluent() {
  }
  
  public MultiClusterHubSpecFluent(MultiClusterHubSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
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
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTolerations(Toleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.add(index, item);
    return (A) this;
  }
  
  public NetworkPoliciesConfig buildNetworkPolicies() {
    return this.networkPolicies != null ? this.networkPolicies.build() : null;
  }
  
  public Overrides buildOverrides() {
    return this.overrides != null ? this.overrides.build() : null;
  }
  
  protected void copyInstance(MultiClusterHubSpec instance) {
    instance = instance != null ? instance : new MultiClusterHubSpec();
    if (instance != null) {
        this.withAvailabilityConfig(instance.getAvailabilityConfig());
        this.withDisableHubSelfManagement(instance.getDisableHubSelfManagement());
        this.withDisableUpdateClusterImageSets(instance.getDisableUpdateClusterImageSets());
        this.withImagePullSecret(instance.getImagePullSecret());
        this.withLocalClusterName(instance.getLocalClusterName());
        this.withNetworkPolicies(instance.getNetworkPolicies());
        this.withNodeSelector(instance.getNodeSelector());
        this.withOverrides(instance.getOverrides());
        this.withTolerations(instance.getTolerations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NetworkPoliciesNested<A> editNetworkPolicies() {
    return this.withNewNetworkPoliciesLike(Optional.ofNullable(this.buildNetworkPolicies()).orElse(null));
  }
  
  public NetworkPoliciesNested<A> editOrNewNetworkPolicies() {
    return this.withNewNetworkPoliciesLike(Optional.ofNullable(this.buildNetworkPolicies()).orElse(new NetworkPoliciesConfigBuilder().build()));
  }
  
  public NetworkPoliciesNested<A> editOrNewNetworkPoliciesLike(NetworkPoliciesConfig item) {
    return this.withNewNetworkPoliciesLike(Optional.ofNullable(this.buildNetworkPolicies()).orElse(item));
  }
  
  public OverridesNested<A> editOrNewOverrides() {
    return this.withNewOverridesLike(Optional.ofNullable(this.buildOverrides()).orElse(new OverridesBuilder().build()));
  }
  
  public OverridesNested<A> editOrNewOverridesLike(Overrides item) {
    return this.withNewOverridesLike(Optional.ofNullable(this.buildOverrides()).orElse(item));
  }
  
  public OverridesNested<A> editOverrides() {
    return this.withNewOverridesLike(Optional.ofNullable(this.buildOverrides()).orElse(null));
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
    MultiClusterHubSpecFluent that = (MultiClusterHubSpecFluent) o;
    if (!(Objects.equals(availabilityConfig, that.availabilityConfig))) {
      return false;
    }
    if (!(Objects.equals(disableHubSelfManagement, that.disableHubSelfManagement))) {
      return false;
    }
    if (!(Objects.equals(disableUpdateClusterImageSets, that.disableUpdateClusterImageSets))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecret, that.imagePullSecret))) {
      return false;
    }
    if (!(Objects.equals(localClusterName, that.localClusterName))) {
      return false;
    }
    if (!(Objects.equals(networkPolicies, that.networkPolicies))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(overrides, that.overrides))) {
      return false;
    }
    if (!(Objects.equals(tolerations, that.tolerations))) {
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
  
  public String getAvailabilityConfig() {
    return this.availabilityConfig;
  }
  
  public Boolean getDisableHubSelfManagement() {
    return this.disableHubSelfManagement;
  }
  
  public Boolean getDisableUpdateClusterImageSets() {
    return this.disableUpdateClusterImageSets;
  }
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public String getImagePullSecret() {
    return this.imagePullSecret;
  }
  
  public Toleration getLastToleration() {
    return this.tolerations.get(tolerations.size() - 1);
  }
  
  public String getLocalClusterName() {
    return this.localClusterName;
  }
  
  public Toleration getMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public Toleration getToleration(int index) {
    return this.tolerations.get(index);
  }
  
  public List<Toleration> getTolerations() {
    return this.tolerations;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailabilityConfig() {
    return this.availabilityConfig != null;
  }
  
  public boolean hasDisableHubSelfManagement() {
    return this.disableHubSelfManagement != null;
  }
  
  public boolean hasDisableUpdateClusterImageSets() {
    return this.disableUpdateClusterImageSets != null;
  }
  
  public boolean hasImagePullSecret() {
    return this.imagePullSecret != null;
  }
  
  public boolean hasLocalClusterName() {
    return this.localClusterName != null;
  }
  
  public boolean hasMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworkPolicies() {
    return this.networkPolicies != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasOverrides() {
    return this.overrides != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(availabilityConfig, disableHubSelfManagement, disableUpdateClusterImageSets, imagePullSecret, localClusterName, networkPolicies, nodeSelector, overrides, tolerations, additionalProperties);
  }
  
  public A removeAllFromTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
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
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTolerations(Toleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
    }
    return (A) this;
  }
  
  public A setToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(availabilityConfig == null)) {
        sb.append("availabilityConfig:");
        sb.append(availabilityConfig);
        sb.append(",");
    }
    if (!(disableHubSelfManagement == null)) {
        sb.append("disableHubSelfManagement:");
        sb.append(disableHubSelfManagement);
        sb.append(",");
    }
    if (!(disableUpdateClusterImageSets == null)) {
        sb.append("disableUpdateClusterImageSets:");
        sb.append(disableUpdateClusterImageSets);
        sb.append(",");
    }
    if (!(imagePullSecret == null)) {
        sb.append("imagePullSecret:");
        sb.append(imagePullSecret);
        sb.append(",");
    }
    if (!(localClusterName == null)) {
        sb.append("localClusterName:");
        sb.append(localClusterName);
        sb.append(",");
    }
    if (!(networkPolicies == null)) {
        sb.append("networkPolicies:");
        sb.append(networkPolicies);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(overrides == null)) {
        sb.append("overrides:");
        sb.append(overrides);
        sb.append(",");
    }
    if (!(tolerations == null) && !(tolerations.isEmpty())) {
        sb.append("tolerations:");
        sb.append(tolerations);
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
  
  public A withAvailabilityConfig(String availabilityConfig) {
    this.availabilityConfig = availabilityConfig;
    return (A) this;
  }
  
  public A withDisableHubSelfManagement() {
    return withDisableHubSelfManagement(true);
  }
  
  public A withDisableHubSelfManagement(Boolean disableHubSelfManagement) {
    this.disableHubSelfManagement = disableHubSelfManagement;
    return (A) this;
  }
  
  public A withDisableUpdateClusterImageSets() {
    return withDisableUpdateClusterImageSets(true);
  }
  
  public A withDisableUpdateClusterImageSets(Boolean disableUpdateClusterImageSets) {
    this.disableUpdateClusterImageSets = disableUpdateClusterImageSets;
    return (A) this;
  }
  
  public A withImagePullSecret(String imagePullSecret) {
    this.imagePullSecret = imagePullSecret;
    return (A) this;
  }
  
  public A withLocalClusterName(String localClusterName) {
    this.localClusterName = localClusterName;
    return (A) this;
  }
  
  public A withNetworkPolicies(NetworkPoliciesConfig networkPolicies) {
    this._visitables.remove("networkPolicies");
    if (networkPolicies != null) {
        this.networkPolicies = new NetworkPoliciesConfigBuilder(networkPolicies);
        this._visitables.get("networkPolicies").add(this.networkPolicies);
    } else {
        this.networkPolicies = null;
        this._visitables.get("networkPolicies").remove(this.networkPolicies);
    }
    return (A) this;
  }
  
  public NetworkPoliciesNested<A> withNewNetworkPolicies() {
    return new NetworkPoliciesNested(null);
  }
  
  public A withNewNetworkPolicies(Boolean enabled) {
    return (A) this.withNetworkPolicies(new NetworkPoliciesConfig(enabled));
  }
  
  public NetworkPoliciesNested<A> withNewNetworkPoliciesLike(NetworkPoliciesConfig item) {
    return new NetworkPoliciesNested(item);
  }
  
  public OverridesNested<A> withNewOverrides() {
    return new OverridesNested(null);
  }
  
  public OverridesNested<A> withNewOverridesLike(Overrides item) {
    return new OverridesNested(item);
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public A withOverrides(Overrides overrides) {
    this._visitables.remove("overrides");
    if (overrides != null) {
        this.overrides = new OverridesBuilder(overrides);
        this._visitables.get("overrides").add(this.overrides);
    } else {
        this.overrides = null;
        this._visitables.get("overrides").remove(this.overrides);
    }
    return (A) this;
  }
  
  public A withTolerations(List<Toleration> tolerations) {
    if (tolerations != null) {
        this.tolerations = new ArrayList();
        for (Toleration item : tolerations) {
          this.addToTolerations(item);
        }
    } else {
      this.tolerations = null;
    }
    return (A) this;
  }
  
  public A withTolerations(Toleration... tolerations) {
    if (this.tolerations != null) {
        this.tolerations.clear();
        _visitables.remove("tolerations");
    }
    if (tolerations != null) {
      for (Toleration item : tolerations) {
        this.addToTolerations(item);
      }
    }
    return (A) this;
  }
  public class NetworkPoliciesNested<N> extends NetworkPoliciesConfigFluent<NetworkPoliciesNested<N>> implements Nested<N>{
  
    NetworkPoliciesConfigBuilder builder;
  
    NetworkPoliciesNested(NetworkPoliciesConfig item) {
      this.builder = new NetworkPoliciesConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) MultiClusterHubSpecFluent.this.withNetworkPolicies(builder.build());
    }
    
    public N endNetworkPolicies() {
      return and();
    }
    
  }
  public class OverridesNested<N> extends OverridesFluent<OverridesNested<N>> implements Nested<N>{
  
    OverridesBuilder builder;
  
    OverridesNested(Overrides item) {
      this.builder = new OverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) MultiClusterHubSpecFluent.this.withOverrides(builder.build());
    }
    
    public N endOverrides() {
      return and();
    }
    
  }
}