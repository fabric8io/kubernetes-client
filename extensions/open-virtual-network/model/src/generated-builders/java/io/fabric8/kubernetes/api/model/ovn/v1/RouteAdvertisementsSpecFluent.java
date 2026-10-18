package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class RouteAdvertisementsSpecFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.RouteAdvertisementsSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> advertisements = new ArrayList<String>();
  private LabelSelectorBuilder frrConfigurationSelector;
  private ArrayList<NetworkSelectorBuilder> networkSelectors = new ArrayList<NetworkSelectorBuilder>();
  private LabelSelectorBuilder nodeSelector;
  private String targetVRF;

  public RouteAdvertisementsSpecFluent() {
  }
  
  public RouteAdvertisementsSpecFluent(RouteAdvertisementsSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdvertisements(Collection<String> items) {
    if (this.advertisements == null) {
      this.advertisements = new ArrayList();
    }
    for (String item : items) {
      this.advertisements.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNetworkSelectors(Collection<NetworkSelector> items) {
    if (this.networkSelectors == null) {
      this.networkSelectors = new ArrayList();
    }
    for (NetworkSelector item : items) {
        NetworkSelectorBuilder builder = new NetworkSelectorBuilder(item);
        _visitables.get("networkSelectors").add(builder);
        this.networkSelectors.add(builder);
    }
    return (A) this;
  }
  
  public NetworkSelectorsNested<A> addNewNetworkSelector() {
    return new NetworkSelectorsNested(-1, null);
  }
  
  public NetworkSelectorsNested<A> addNewNetworkSelectorLike(NetworkSelector item) {
    return new NetworkSelectorsNested(-1, item);
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
  
  public A addToAdvertisements(String... items) {
    if (this.advertisements == null) {
      this.advertisements = new ArrayList();
    }
    for (String item : items) {
      this.advertisements.add(item);
    }
    return (A) this;
  }
  
  public A addToAdvertisements(int index,String item) {
    if (this.advertisements == null) {
      this.advertisements = new ArrayList();
    }
    this.advertisements.add(index, item);
    return (A) this;
  }
  
  public A addToNetworkSelectors(NetworkSelector... items) {
    if (this.networkSelectors == null) {
      this.networkSelectors = new ArrayList();
    }
    for (NetworkSelector item : items) {
        NetworkSelectorBuilder builder = new NetworkSelectorBuilder(item);
        _visitables.get("networkSelectors").add(builder);
        this.networkSelectors.add(builder);
    }
    return (A) this;
  }
  
  public A addToNetworkSelectors(int index,NetworkSelector item) {
    if (this.networkSelectors == null) {
      this.networkSelectors = new ArrayList();
    }
    NetworkSelectorBuilder builder = new NetworkSelectorBuilder(item);
    if (index < 0 || index >= networkSelectors.size()) {
        _visitables.get("networkSelectors").add(builder);
        networkSelectors.add(builder);
    } else {
        _visitables.get("networkSelectors").add(builder);
        networkSelectors.add(index, builder);
    }
    return (A) this;
  }
  
  public NetworkSelector buildFirstNetworkSelector() {
    return this.networkSelectors.get(0).build();
  }
  
  public LabelSelector buildFrrConfigurationSelector() {
    return this.frrConfigurationSelector != null ? this.frrConfigurationSelector.build() : null;
  }
  
  public NetworkSelector buildLastNetworkSelector() {
    return this.networkSelectors.get(networkSelectors.size() - 1).build();
  }
  
  public NetworkSelector buildMatchingNetworkSelector(Predicate<NetworkSelectorBuilder> predicate) {
      for (NetworkSelectorBuilder item : networkSelectors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkSelector buildNetworkSelector(int index) {
    return this.networkSelectors.get(index).build();
  }
  
  public List<NetworkSelector> buildNetworkSelectors() {
    return this.networkSelectors != null ? build(networkSelectors) : null;
  }
  
  public LabelSelector buildNodeSelector() {
    return this.nodeSelector != null ? this.nodeSelector.build() : null;
  }
  
  protected void copyInstance(RouteAdvertisementsSpec instance) {
    instance = instance != null ? instance : new RouteAdvertisementsSpec();
    if (instance != null) {
        this.withAdvertisements(instance.getAdvertisements());
        this.withFrrConfigurationSelector(instance.getFrrConfigurationSelector());
        this.withNetworkSelectors(instance.getNetworkSelectors());
        this.withNodeSelector(instance.getNodeSelector());
        this.withTargetVRF(instance.getTargetVRF());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NetworkSelectorsNested<A> editFirstNetworkSelector() {
    if (networkSelectors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "networkSelectors"));
    }
    return this.setNewNetworkSelectorLike(0, this.buildNetworkSelector(0));
  }
  
  public FrrConfigurationSelectorNested<A> editFrrConfigurationSelector() {
    return this.withNewFrrConfigurationSelectorLike(Optional.ofNullable(this.buildFrrConfigurationSelector()).orElse(null));
  }
  
  public NetworkSelectorsNested<A> editLastNetworkSelector() {
    int index = networkSelectors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "networkSelectors"));
    }
    return this.setNewNetworkSelectorLike(index, this.buildNetworkSelector(index));
  }
  
  public NetworkSelectorsNested<A> editMatchingNetworkSelector(Predicate<NetworkSelectorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < networkSelectors.size();i++) {
      if (predicate.test(networkSelectors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "networkSelectors"));
    }
    return this.setNewNetworkSelectorLike(index, this.buildNetworkSelector(index));
  }
  
  public NetworkSelectorsNested<A> editNetworkSelector(int index) {
    if (networkSelectors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "networkSelectors"));
    }
    return this.setNewNetworkSelectorLike(index, this.buildNetworkSelector(index));
  }
  
  public NodeSelectorNested<A> editNodeSelector() {
    return this.withNewNodeSelectorLike(Optional.ofNullable(this.buildNodeSelector()).orElse(null));
  }
  
  public FrrConfigurationSelectorNested<A> editOrNewFrrConfigurationSelector() {
    return this.withNewFrrConfigurationSelectorLike(Optional.ofNullable(this.buildFrrConfigurationSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public FrrConfigurationSelectorNested<A> editOrNewFrrConfigurationSelectorLike(LabelSelector item) {
    return this.withNewFrrConfigurationSelectorLike(Optional.ofNullable(this.buildFrrConfigurationSelector()).orElse(item));
  }
  
  public NodeSelectorNested<A> editOrNewNodeSelector() {
    return this.withNewNodeSelectorLike(Optional.ofNullable(this.buildNodeSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NodeSelectorNested<A> editOrNewNodeSelectorLike(LabelSelector item) {
    return this.withNewNodeSelectorLike(Optional.ofNullable(this.buildNodeSelector()).orElse(item));
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
    RouteAdvertisementsSpecFluent that = (RouteAdvertisementsSpecFluent) o;
    if (!(Objects.equals(advertisements, that.advertisements))) {
      return false;
    }
    if (!(Objects.equals(frrConfigurationSelector, that.frrConfigurationSelector))) {
      return false;
    }
    if (!(Objects.equals(networkSelectors, that.networkSelectors))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(targetVRF, that.targetVRF))) {
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
  
  public String getAdvertisement(int index) {
    return this.advertisements.get(index);
  }
  
  public List<String> getAdvertisements() {
    return this.advertisements;
  }
  
  public String getFirstAdvertisement() {
    return this.advertisements.get(0);
  }
  
  public String getLastAdvertisement() {
    return this.advertisements.get(advertisements.size() - 1);
  }
  
  public String getMatchingAdvertisement(Predicate<String> predicate) {
      for (String item : advertisements) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getTargetVRF() {
    return this.targetVRF;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdvertisements() {
    return this.advertisements != null && !(this.advertisements.isEmpty());
  }
  
  public boolean hasFrrConfigurationSelector() {
    return this.frrConfigurationSelector != null;
  }
  
  public boolean hasMatchingAdvertisement(Predicate<String> predicate) {
      for (String item : advertisements) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNetworkSelector(Predicate<NetworkSelectorBuilder> predicate) {
      for (NetworkSelectorBuilder item : networkSelectors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworkSelectors() {
    return this.networkSelectors != null && !(this.networkSelectors.isEmpty());
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasTargetVRF() {
    return this.targetVRF != null;
  }
  
  public int hashCode() {
    return Objects.hash(advertisements, frrConfigurationSelector, networkSelectors, nodeSelector, targetVRF, additionalProperties);
  }
  
  public A removeAllFromAdvertisements(Collection<String> items) {
    if (this.advertisements == null) {
      return (A) this;
    }
    for (String item : items) {
      this.advertisements.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNetworkSelectors(Collection<NetworkSelector> items) {
    if (this.networkSelectors == null) {
      return (A) this;
    }
    for (NetworkSelector item : items) {
        NetworkSelectorBuilder builder = new NetworkSelectorBuilder(item);
        _visitables.get("networkSelectors").remove(builder);
        this.networkSelectors.remove(builder);
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
  
  public A removeFromAdvertisements(String... items) {
    if (this.advertisements == null) {
      return (A) this;
    }
    for (String item : items) {
      this.advertisements.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNetworkSelectors(NetworkSelector... items) {
    if (this.networkSelectors == null) {
      return (A) this;
    }
    for (NetworkSelector item : items) {
        NetworkSelectorBuilder builder = new NetworkSelectorBuilder(item);
        _visitables.get("networkSelectors").remove(builder);
        this.networkSelectors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromNetworkSelectors(Predicate<NetworkSelectorBuilder> predicate) {
    if (networkSelectors == null) {
      return (A) this;
    }
    Iterator<NetworkSelectorBuilder> each = networkSelectors.iterator();
    List visitables = _visitables.get("networkSelectors");
    while (each.hasNext()) {
        NetworkSelectorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public NetworkSelectorsNested<A> setNewNetworkSelectorLike(int index,NetworkSelector item) {
    return new NetworkSelectorsNested(index, item);
  }
  
  public A setToAdvertisements(int index,String item) {
    if (this.advertisements == null) {
      this.advertisements = new ArrayList();
    }
    this.advertisements.set(index, item);
    return (A) this;
  }
  
  public A setToNetworkSelectors(int index,NetworkSelector item) {
    if (this.networkSelectors == null) {
      this.networkSelectors = new ArrayList();
    }
    NetworkSelectorBuilder builder = new NetworkSelectorBuilder(item);
    if (index < 0 || index >= networkSelectors.size()) {
        _visitables.get("networkSelectors").add(builder);
        networkSelectors.add(builder);
    } else {
        _visitables.get("networkSelectors").add(builder);
        networkSelectors.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(advertisements == null) && !(advertisements.isEmpty())) {
        sb.append("advertisements:");
        sb.append(advertisements);
        sb.append(",");
    }
    if (!(frrConfigurationSelector == null)) {
        sb.append("frrConfigurationSelector:");
        sb.append(frrConfigurationSelector);
        sb.append(",");
    }
    if (!(networkSelectors == null) && !(networkSelectors.isEmpty())) {
        sb.append("networkSelectors:");
        sb.append(networkSelectors);
        sb.append(",");
    }
    if (!(nodeSelector == null)) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(targetVRF == null)) {
        sb.append("targetVRF:");
        sb.append(targetVRF);
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
  
  public A withAdvertisements(List<String> advertisements) {
    if (advertisements != null) {
        this.advertisements = new ArrayList();
        for (String item : advertisements) {
          this.addToAdvertisements(item);
        }
    } else {
      this.advertisements = null;
    }
    return (A) this;
  }
  
  public A withAdvertisements(String... advertisements) {
    if (this.advertisements != null) {
        this.advertisements.clear();
        _visitables.remove("advertisements");
    }
    if (advertisements != null) {
      for (String item : advertisements) {
        this.addToAdvertisements(item);
      }
    }
    return (A) this;
  }
  
  public A withFrrConfigurationSelector(LabelSelector frrConfigurationSelector) {
    this._visitables.remove("frrConfigurationSelector");
    if (frrConfigurationSelector != null) {
        this.frrConfigurationSelector = new LabelSelectorBuilder(frrConfigurationSelector);
        this._visitables.get("frrConfigurationSelector").add(this.frrConfigurationSelector);
    } else {
        this.frrConfigurationSelector = null;
        this._visitables.get("frrConfigurationSelector").remove(this.frrConfigurationSelector);
    }
    return (A) this;
  }
  
  public A withNetworkSelectors(List<NetworkSelector> networkSelectors) {
    if (this.networkSelectors != null) {
      this._visitables.get("networkSelectors").clear();
    }
    if (networkSelectors != null) {
        this.networkSelectors = new ArrayList();
        for (NetworkSelector item : networkSelectors) {
          this.addToNetworkSelectors(item);
        }
    } else {
      this.networkSelectors = null;
    }
    return (A) this;
  }
  
  public A withNetworkSelectors(NetworkSelector... networkSelectors) {
    if (this.networkSelectors != null) {
        this.networkSelectors.clear();
        _visitables.remove("networkSelectors");
    }
    if (networkSelectors != null) {
      for (NetworkSelector item : networkSelectors) {
        this.addToNetworkSelectors(item);
      }
    }
    return (A) this;
  }
  
  public FrrConfigurationSelectorNested<A> withNewFrrConfigurationSelector() {
    return new FrrConfigurationSelectorNested(null);
  }
  
  public FrrConfigurationSelectorNested<A> withNewFrrConfigurationSelectorLike(LabelSelector item) {
    return new FrrConfigurationSelectorNested(item);
  }
  
  public NodeSelectorNested<A> withNewNodeSelector() {
    return new NodeSelectorNested(null);
  }
  
  public NodeSelectorNested<A> withNewNodeSelectorLike(LabelSelector item) {
    return new NodeSelectorNested(item);
  }
  
  public A withNodeSelector(LabelSelector nodeSelector) {
    this._visitables.remove("nodeSelector");
    if (nodeSelector != null) {
        this.nodeSelector = new LabelSelectorBuilder(nodeSelector);
        this._visitables.get("nodeSelector").add(this.nodeSelector);
    } else {
        this.nodeSelector = null;
        this._visitables.get("nodeSelector").remove(this.nodeSelector);
    }
    return (A) this;
  }
  
  public A withTargetVRF(String targetVRF) {
    this.targetVRF = targetVRF;
    return (A) this;
  }
  public class FrrConfigurationSelectorNested<N> extends LabelSelectorFluent<FrrConfigurationSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    FrrConfigurationSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteAdvertisementsSpecFluent.this.withFrrConfigurationSelector(builder.build());
    }
    
    public N endFrrConfigurationSelector() {
      return and();
    }
    
  }
  public class NetworkSelectorsNested<N> extends NetworkSelectorFluent<NetworkSelectorsNested<N>> implements Nested<N>{
  
    NetworkSelectorBuilder builder;
    int index;
  
    NetworkSelectorsNested(int index,NetworkSelector item) {
      this.index = index;
      this.builder = new NetworkSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteAdvertisementsSpecFluent.this.setToNetworkSelectors(index, builder.build());
    }
    
    public N endNetworkSelector() {
      return and();
    }
    
  }
  public class NodeSelectorNested<N> extends LabelSelectorFluent<NodeSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NodeSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteAdvertisementsSpecFluent.this.withNodeSelector(builder.build());
    }
    
    public N endNodeSelector() {
      return and();
    }
    
  }
}