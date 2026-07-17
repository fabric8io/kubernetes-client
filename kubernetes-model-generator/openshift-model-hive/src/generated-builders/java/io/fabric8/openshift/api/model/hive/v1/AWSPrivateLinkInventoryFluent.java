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
public class AWSPrivateLinkInventoryFluent<A extends io.fabric8.openshift.api.model.hive.v1.AWSPrivateLinkInventoryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String region;
  private ArrayList<AWSPrivateLinkSubnetBuilder> subnets = new ArrayList<AWSPrivateLinkSubnetBuilder>();
  private String vpcID;

  public AWSPrivateLinkInventoryFluent() {
  }
  
  public AWSPrivateLinkInventoryFluent(AWSPrivateLinkInventory instance) {
    this.copyInstance(instance);
  }

  public A addAllToSubnets(Collection<AWSPrivateLinkSubnet> items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (AWSPrivateLinkSubnet item : items) {
        AWSPrivateLinkSubnetBuilder builder = new AWSPrivateLinkSubnetBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public SubnetsNested<A> addNewSubnet() {
    return new SubnetsNested(-1, null);
  }
  
  public A addNewSubnet(String availabilityZone,String subnetID) {
    return (A) this.addToSubnets(new AWSPrivateLinkSubnet(availabilityZone, subnetID));
  }
  
  public SubnetsNested<A> addNewSubnetLike(AWSPrivateLinkSubnet item) {
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
  
  public A addToSubnets(AWSPrivateLinkSubnet... items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (AWSPrivateLinkSubnet item : items) {
        AWSPrivateLinkSubnetBuilder builder = new AWSPrivateLinkSubnetBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubnets(int index,AWSPrivateLinkSubnet item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    AWSPrivateLinkSubnetBuilder builder = new AWSPrivateLinkSubnetBuilder(item);
    if (index < 0 || index >= subnets.size()) {
        _visitables.get("subnets").add(builder);
        subnets.add(builder);
    } else {
        _visitables.get("subnets").add(builder);
        subnets.add(index, builder);
    }
    return (A) this;
  }
  
  public AWSPrivateLinkSubnet buildFirstSubnet() {
    return this.subnets.get(0).build();
  }
  
  public AWSPrivateLinkSubnet buildLastSubnet() {
    return this.subnets.get(subnets.size() - 1).build();
  }
  
  public AWSPrivateLinkSubnet buildMatchingSubnet(Predicate<AWSPrivateLinkSubnetBuilder> predicate) {
      for (AWSPrivateLinkSubnetBuilder item : subnets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AWSPrivateLinkSubnet buildSubnet(int index) {
    return this.subnets.get(index).build();
  }
  
  public List<AWSPrivateLinkSubnet> buildSubnets() {
    return this.subnets != null ? build(subnets) : null;
  }
  
  protected void copyInstance(AWSPrivateLinkInventory instance) {
    instance = instance != null ? instance : new AWSPrivateLinkInventory();
    if (instance != null) {
        this.withRegion(instance.getRegion());
        this.withSubnets(instance.getSubnets());
        this.withVpcID(instance.getVpcID());
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
  
  public SubnetsNested<A> editMatchingSubnet(Predicate<AWSPrivateLinkSubnetBuilder> predicate) {
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
    AWSPrivateLinkInventoryFluent that = (AWSPrivateLinkInventoryFluent) o;
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(subnets, that.subnets))) {
      return false;
    }
    if (!(Objects.equals(vpcID, that.vpcID))) {
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
  
  public String getRegion() {
    return this.region;
  }
  
  public String getVpcID() {
    return this.vpcID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingSubnet(Predicate<AWSPrivateLinkSubnetBuilder> predicate) {
      for (AWSPrivateLinkSubnetBuilder item : subnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public boolean hasVpcID() {
    return this.vpcID != null;
  }
  
  public int hashCode() {
    return Objects.hash(region, subnets, vpcID, additionalProperties);
  }
  
  public A removeAllFromSubnets(Collection<AWSPrivateLinkSubnet> items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (AWSPrivateLinkSubnet item : items) {
        AWSPrivateLinkSubnetBuilder builder = new AWSPrivateLinkSubnetBuilder(item);
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
  
  public A removeFromSubnets(AWSPrivateLinkSubnet... items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (AWSPrivateLinkSubnet item : items) {
        AWSPrivateLinkSubnetBuilder builder = new AWSPrivateLinkSubnetBuilder(item);
        _visitables.get("subnets").remove(builder);
        this.subnets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubnets(Predicate<AWSPrivateLinkSubnetBuilder> predicate) {
    if (subnets == null) {
      return (A) this;
    }
    Iterator<AWSPrivateLinkSubnetBuilder> each = subnets.iterator();
    List visitables = _visitables.get("subnets");
    while (each.hasNext()) {
        AWSPrivateLinkSubnetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubnetsNested<A> setNewSubnetLike(int index,AWSPrivateLinkSubnet item) {
    return new SubnetsNested(index, item);
  }
  
  public A setToSubnets(int index,AWSPrivateLinkSubnet item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    AWSPrivateLinkSubnetBuilder builder = new AWSPrivateLinkSubnetBuilder(item);
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
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(subnets == null) && !(subnets.isEmpty())) {
        sb.append("subnets:");
        sb.append(subnets);
        sb.append(",");
    }
    if (!(vpcID == null)) {
        sb.append("vpcID:");
        sb.append(vpcID);
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
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withSubnets(List<AWSPrivateLinkSubnet> subnets) {
    if (this.subnets != null) {
      this._visitables.get("subnets").clear();
    }
    if (subnets != null) {
        this.subnets = new ArrayList();
        for (AWSPrivateLinkSubnet item : subnets) {
          this.addToSubnets(item);
        }
    } else {
      this.subnets = null;
    }
    return (A) this;
  }
  
  public A withSubnets(AWSPrivateLinkSubnet... subnets) {
    if (this.subnets != null) {
        this.subnets.clear();
        _visitables.remove("subnets");
    }
    if (subnets != null) {
      for (AWSPrivateLinkSubnet item : subnets) {
        this.addToSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withVpcID(String vpcID) {
    this.vpcID = vpcID;
    return (A) this;
  }
  public class SubnetsNested<N> extends AWSPrivateLinkSubnetFluent<SubnetsNested<N>> implements Nested<N>{
  
    AWSPrivateLinkSubnetBuilder builder;
    int index;
  
    SubnetsNested(int index,AWSPrivateLinkSubnet item) {
      this.index = index;
      this.builder = new AWSPrivateLinkSubnetBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSPrivateLinkInventoryFluent.this.setToSubnets(index, builder.build());
    }
    
    public N endSubnet() {
      return and();
    }
    
  }
}