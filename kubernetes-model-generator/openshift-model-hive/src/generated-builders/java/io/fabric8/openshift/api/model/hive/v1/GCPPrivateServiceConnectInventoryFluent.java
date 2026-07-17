package io.fabric8.openshift.api.model.hive.v1;

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
public class GCPPrivateServiceConnectInventoryFluent<A extends io.fabric8.openshift.api.model.hive.v1.GCPPrivateServiceConnectInventoryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String network;
  private ArrayList<GCPPrivateServiceConnectSubnetBuilder> subnets = new ArrayList<GCPPrivateServiceConnectSubnetBuilder>();

  public GCPPrivateServiceConnectInventoryFluent() {
  }
  
  public GCPPrivateServiceConnectInventoryFluent(GCPPrivateServiceConnectInventory instance) {
    this.copyInstance(instance);
  }

  public A addAllToSubnets(Collection<GCPPrivateServiceConnectSubnet> items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (GCPPrivateServiceConnectSubnet item : items) {
        GCPPrivateServiceConnectSubnetBuilder builder = new GCPPrivateServiceConnectSubnetBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public SubnetsNested<A> addNewSubnet() {
    return new SubnetsNested(-1, null);
  }
  
  public A addNewSubnet(String region,String subnet) {
    return (A) this.addToSubnets(new GCPPrivateServiceConnectSubnet(region, subnet));
  }
  
  public SubnetsNested<A> addNewSubnetLike(GCPPrivateServiceConnectSubnet item) {
    return new SubnetsNested(-1, item);
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
  
  public A addToSubnets(GCPPrivateServiceConnectSubnet... items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (GCPPrivateServiceConnectSubnet item : items) {
        GCPPrivateServiceConnectSubnetBuilder builder = new GCPPrivateServiceConnectSubnetBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubnets(int index,GCPPrivateServiceConnectSubnet item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    GCPPrivateServiceConnectSubnetBuilder builder = new GCPPrivateServiceConnectSubnetBuilder(item);
    if (index < 0 || index >= subnets.size()) {
        _visitables.get("subnets").add(builder);
        subnets.add(builder);
    } else {
        _visitables.get("subnets").add(builder);
        subnets.add(index, builder);
    }
    return (A) this;
  }
  
  public GCPPrivateServiceConnectSubnet buildFirstSubnet() {
    return this.subnets.get(0).build();
  }
  
  public GCPPrivateServiceConnectSubnet buildLastSubnet() {
    return this.subnets.get(subnets.size() - 1).build();
  }
  
  public GCPPrivateServiceConnectSubnet buildMatchingSubnet(Predicate<GCPPrivateServiceConnectSubnetBuilder> predicate) {
      for (GCPPrivateServiceConnectSubnetBuilder item : subnets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GCPPrivateServiceConnectSubnet buildSubnet(int index) {
    return this.subnets.get(index).build();
  }
  
  public List<GCPPrivateServiceConnectSubnet> buildSubnets() {
    return this.subnets != null ? build(subnets) : null;
  }
  
  protected void copyInstance(GCPPrivateServiceConnectInventory instance) {
    instance = instance != null ? instance : new GCPPrivateServiceConnectInventory();
    if (instance != null) {
        this.withNetwork(instance.getNetwork());
        this.withSubnets(instance.getSubnets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SubnetsNested<A> editFirstSubnet() {
    if (subnets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subnets"));
    }
    return this.setNewSubnetLike(0, this.buildSubnet(0));
  }
  
  public SubnetsNested<A> editLastSubnet() {
    int index = subnets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subnets"));
    }
    return this.setNewSubnetLike(index, this.buildSubnet(index));
  }
  
  public SubnetsNested<A> editMatchingSubnet(Predicate<GCPPrivateServiceConnectSubnetBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subnets.size();i++) {
      if (predicate.test(subnets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subnets"));
    }
    return this.setNewSubnetLike(index, this.buildSubnet(index));
  }
  
  public SubnetsNested<A> editSubnet(int index) {
    if (subnets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subnets"));
    }
    return this.setNewSubnetLike(index, this.buildSubnet(index));
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
    GCPPrivateServiceConnectInventoryFluent that = (GCPPrivateServiceConnectInventoryFluent) o;
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(subnets, that.subnets))) {
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
  
  public String getNetwork() {
    return this.network;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingSubnet(Predicate<GCPPrivateServiceConnectSubnetBuilder> predicate) {
      for (GCPPrivateServiceConnectSubnetBuilder item : subnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(network, subnets, additionalProperties);
  }
  
  public A removeAllFromSubnets(Collection<GCPPrivateServiceConnectSubnet> items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (GCPPrivateServiceConnectSubnet item : items) {
        GCPPrivateServiceConnectSubnetBuilder builder = new GCPPrivateServiceConnectSubnetBuilder(item);
        _visitables.get("subnets").remove(builder);
        this.subnets.remove(builder);
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
  
  public A removeFromSubnets(GCPPrivateServiceConnectSubnet... items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (GCPPrivateServiceConnectSubnet item : items) {
        GCPPrivateServiceConnectSubnetBuilder builder = new GCPPrivateServiceConnectSubnetBuilder(item);
        _visitables.get("subnets").remove(builder);
        this.subnets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubnets(Predicate<GCPPrivateServiceConnectSubnetBuilder> predicate) {
    if (subnets == null) {
      return (A) this;
    }
    Iterator<GCPPrivateServiceConnectSubnetBuilder> each = subnets.iterator();
    List visitables = _visitables.get("subnets");
    while (each.hasNext()) {
        GCPPrivateServiceConnectSubnetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubnetsNested<A> setNewSubnetLike(int index,GCPPrivateServiceConnectSubnet item) {
    return new SubnetsNested(index, item);
  }
  
  public A setToSubnets(int index,GCPPrivateServiceConnectSubnet item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    GCPPrivateServiceConnectSubnetBuilder builder = new GCPPrivateServiceConnectSubnetBuilder(item);
    if (index < 0 || index >= subnets.size()) {
        _visitables.get("subnets").add(builder);
        subnets.add(builder);
    } else {
        _visitables.get("subnets").add(builder);
        subnets.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(subnets == null) && !(subnets.isEmpty())) {
        sb.append("subnets:");
        sb.append(subnets);
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
  
  public A withNetwork(String network) {
    this.network = network;
    return (A) this;
  }
  
  public A withSubnets(List<GCPPrivateServiceConnectSubnet> subnets) {
    if (this.subnets != null) {
      this._visitables.get("subnets").clear();
    }
    if (subnets != null) {
        this.subnets = new ArrayList();
        for (GCPPrivateServiceConnectSubnet item : subnets) {
          this.addToSubnets(item);
        }
    } else {
      this.subnets = null;
    }
    return (A) this;
  }
  
  public A withSubnets(GCPPrivateServiceConnectSubnet... subnets) {
    if (this.subnets != null) {
        this.subnets.clear();
        _visitables.remove("subnets");
    }
    if (subnets != null) {
      for (GCPPrivateServiceConnectSubnet item : subnets) {
        this.addToSubnets(item);
      }
    }
    return (A) this;
  }
  public class SubnetsNested<N> extends GCPPrivateServiceConnectSubnetFluent<SubnetsNested<N>> implements Nested<N>{
  
    GCPPrivateServiceConnectSubnetBuilder builder;
    int index;
  
    SubnetsNested(int index,GCPPrivateServiceConnectSubnet item) {
      this.index = index;
      this.builder = new GCPPrivateServiceConnectSubnetBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPPrivateServiceConnectInventoryFluent.this.setToSubnets(index, builder.build());
    }
    
    public N endSubnet() {
      return and();
    }
    
  }
}