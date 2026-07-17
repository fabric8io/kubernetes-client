package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class HybridOverlayConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.HybridOverlayConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterNetworkEntryBuilder> hybridClusterNetwork = new ArrayList<ClusterNetworkEntryBuilder>();
  private Long hybridOverlayVXLANPort;

  public HybridOverlayConfigFluent() {
  }
  
  public HybridOverlayConfigFluent(HybridOverlayConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToHybridClusterNetwork(Collection<ClusterNetworkEntry> items) {
    if (this.hybridClusterNetwork == null) {
      this.hybridClusterNetwork = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("hybridClusterNetwork").add(builder);
        this.hybridClusterNetwork.add(builder);
    }
    return (A) this;
  }
  
  public HybridClusterNetworkNested<A> addNewHybridClusterNetwork() {
    return new HybridClusterNetworkNested(-1, null);
  }
  
  public A addNewHybridClusterNetwork(String cidr,Long hostPrefix) {
    return (A) this.addToHybridClusterNetwork(new ClusterNetworkEntry(cidr, hostPrefix));
  }
  
  public HybridClusterNetworkNested<A> addNewHybridClusterNetworkLike(ClusterNetworkEntry item) {
    return new HybridClusterNetworkNested(-1, item);
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
  
  public A addToHybridClusterNetwork(ClusterNetworkEntry... items) {
    if (this.hybridClusterNetwork == null) {
      this.hybridClusterNetwork = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("hybridClusterNetwork").add(builder);
        this.hybridClusterNetwork.add(builder);
    }
    return (A) this;
  }
  
  public A addToHybridClusterNetwork(int index,ClusterNetworkEntry item) {
    if (this.hybridClusterNetwork == null) {
      this.hybridClusterNetwork = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= hybridClusterNetwork.size()) {
        _visitables.get("hybridClusterNetwork").add(builder);
        hybridClusterNetwork.add(builder);
    } else {
        _visitables.get("hybridClusterNetwork").add(builder);
        hybridClusterNetwork.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterNetworkEntry buildFirstHybridClusterNetwork() {
    return this.hybridClusterNetwork.get(0).build();
  }
  
  public List<ClusterNetworkEntry> buildHybridClusterNetwork() {
    return this.hybridClusterNetwork != null ? build(hybridClusterNetwork) : null;
  }
  
  public ClusterNetworkEntry buildHybridClusterNetwork(int index) {
    return this.hybridClusterNetwork.get(index).build();
  }
  
  public ClusterNetworkEntry buildLastHybridClusterNetwork() {
    return this.hybridClusterNetwork.get(hybridClusterNetwork.size() - 1).build();
  }
  
  public ClusterNetworkEntry buildMatchingHybridClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : hybridClusterNetwork) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(HybridOverlayConfig instance) {
    instance = instance != null ? instance : new HybridOverlayConfig();
    if (instance != null) {
        this.withHybridClusterNetwork(instance.getHybridClusterNetwork());
        this.withHybridOverlayVXLANPort(instance.getHybridOverlayVXLANPort());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HybridClusterNetworkNested<A> editFirstHybridClusterNetwork() {
    if (hybridClusterNetwork.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "hybridClusterNetwork"));
    }
    return this.setNewHybridClusterNetworkLike(0, this.buildHybridClusterNetwork(0));
  }
  
  public HybridClusterNetworkNested<A> editHybridClusterNetwork(int index) {
    if (hybridClusterNetwork.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "hybridClusterNetwork"));
    }
    return this.setNewHybridClusterNetworkLike(index, this.buildHybridClusterNetwork(index));
  }
  
  public HybridClusterNetworkNested<A> editLastHybridClusterNetwork() {
    int index = hybridClusterNetwork.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "hybridClusterNetwork"));
    }
    return this.setNewHybridClusterNetworkLike(index, this.buildHybridClusterNetwork(index));
  }
  
  public HybridClusterNetworkNested<A> editMatchingHybridClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < hybridClusterNetwork.size();i++) {
      if (predicate.test(hybridClusterNetwork.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "hybridClusterNetwork"));
    }
    return this.setNewHybridClusterNetworkLike(index, this.buildHybridClusterNetwork(index));
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
    HybridOverlayConfigFluent that = (HybridOverlayConfigFluent) o;
    if (!(Objects.equals(hybridClusterNetwork, that.hybridClusterNetwork))) {
      return false;
    }
    if (!(Objects.equals(hybridOverlayVXLANPort, that.hybridOverlayVXLANPort))) {
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
  
  public Long getHybridOverlayVXLANPort() {
    return this.hybridOverlayVXLANPort;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHybridClusterNetwork() {
    return this.hybridClusterNetwork != null && !(this.hybridClusterNetwork.isEmpty());
  }
  
  public boolean hasHybridOverlayVXLANPort() {
    return this.hybridOverlayVXLANPort != null;
  }
  
  public boolean hasMatchingHybridClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : hybridClusterNetwork) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(hybridClusterNetwork, hybridOverlayVXLANPort, additionalProperties);
  }
  
  public A removeAllFromHybridClusterNetwork(Collection<ClusterNetworkEntry> items) {
    if (this.hybridClusterNetwork == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("hybridClusterNetwork").remove(builder);
        this.hybridClusterNetwork.remove(builder);
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
  
  public A removeFromHybridClusterNetwork(ClusterNetworkEntry... items) {
    if (this.hybridClusterNetwork == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("hybridClusterNetwork").remove(builder);
        this.hybridClusterNetwork.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHybridClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
    if (hybridClusterNetwork == null) {
      return (A) this;
    }
    Iterator<ClusterNetworkEntryBuilder> each = hybridClusterNetwork.iterator();
    List visitables = _visitables.get("hybridClusterNetwork");
    while (each.hasNext()) {
        ClusterNetworkEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HybridClusterNetworkNested<A> setNewHybridClusterNetworkLike(int index,ClusterNetworkEntry item) {
    return new HybridClusterNetworkNested(index, item);
  }
  
  public A setToHybridClusterNetwork(int index,ClusterNetworkEntry item) {
    if (this.hybridClusterNetwork == null) {
      this.hybridClusterNetwork = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= hybridClusterNetwork.size()) {
        _visitables.get("hybridClusterNetwork").add(builder);
        hybridClusterNetwork.add(builder);
    } else {
        _visitables.get("hybridClusterNetwork").add(builder);
        hybridClusterNetwork.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hybridClusterNetwork == null) && !(hybridClusterNetwork.isEmpty())) {
        sb.append("hybridClusterNetwork:");
        sb.append(hybridClusterNetwork);
        sb.append(",");
    }
    if (!(hybridOverlayVXLANPort == null)) {
        sb.append("hybridOverlayVXLANPort:");
        sb.append(hybridOverlayVXLANPort);
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
  
  public A withHybridClusterNetwork(List<ClusterNetworkEntry> hybridClusterNetwork) {
    if (this.hybridClusterNetwork != null) {
      this._visitables.get("hybridClusterNetwork").clear();
    }
    if (hybridClusterNetwork != null) {
        this.hybridClusterNetwork = new ArrayList();
        for (ClusterNetworkEntry item : hybridClusterNetwork) {
          this.addToHybridClusterNetwork(item);
        }
    } else {
      this.hybridClusterNetwork = null;
    }
    return (A) this;
  }
  
  public A withHybridClusterNetwork(ClusterNetworkEntry... hybridClusterNetwork) {
    if (this.hybridClusterNetwork != null) {
        this.hybridClusterNetwork.clear();
        _visitables.remove("hybridClusterNetwork");
    }
    if (hybridClusterNetwork != null) {
      for (ClusterNetworkEntry item : hybridClusterNetwork) {
        this.addToHybridClusterNetwork(item);
      }
    }
    return (A) this;
  }
  
  public A withHybridOverlayVXLANPort(Long hybridOverlayVXLANPort) {
    this.hybridOverlayVXLANPort = hybridOverlayVXLANPort;
    return (A) this;
  }
  public class HybridClusterNetworkNested<N> extends ClusterNetworkEntryFluent<HybridClusterNetworkNested<N>> implements Nested<N>{
  
    ClusterNetworkEntryBuilder builder;
    int index;
  
    HybridClusterNetworkNested(int index,ClusterNetworkEntry item) {
      this.index = index;
      this.builder = new ClusterNetworkEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) HybridOverlayConfigFluent.this.setToHybridClusterNetwork(index, builder.build());
    }
    
    public N endHybridClusterNetwork() {
      return and();
    }
    
  }
}