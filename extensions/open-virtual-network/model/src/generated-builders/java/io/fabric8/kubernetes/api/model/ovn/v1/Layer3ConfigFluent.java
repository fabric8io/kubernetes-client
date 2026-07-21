package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class Layer3ConfigFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.Layer3ConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> joinSubnets = new ArrayList<String>();
  private Integer mtu;
  private String role;
  private ArrayList<Layer3SubnetBuilder> subnets = new ArrayList<Layer3SubnetBuilder>();

  public Layer3ConfigFluent() {
  }
  
  public Layer3ConfigFluent(Layer3Config instance) {
    this.copyInstance(instance);
  }

  public A addAllToJoinSubnets(Collection<String> items) {
    if (this.joinSubnets == null) {
      this.joinSubnets = new ArrayList();
    }
    for (String item : items) {
      this.joinSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSubnets(Collection<Layer3Subnet> items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (Layer3Subnet item : items) {
        Layer3SubnetBuilder builder = new Layer3SubnetBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public SubnetsNested<A> addNewSubnet() {
    return new SubnetsNested(-1, null);
  }
  
  public A addNewSubnet(String cidr,Integer hostSubnet) {
    return (A) this.addToSubnets(new Layer3Subnet(cidr, hostSubnet));
  }
  
  public SubnetsNested<A> addNewSubnetLike(Layer3Subnet item) {
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
  
  public A addToJoinSubnets(String... items) {
    if (this.joinSubnets == null) {
      this.joinSubnets = new ArrayList();
    }
    for (String item : items) {
      this.joinSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addToJoinSubnets(int index,String item) {
    if (this.joinSubnets == null) {
      this.joinSubnets = new ArrayList();
    }
    this.joinSubnets.add(index, item);
    return (A) this;
  }
  
  public A addToSubnets(Layer3Subnet... items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (Layer3Subnet item : items) {
        Layer3SubnetBuilder builder = new Layer3SubnetBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubnets(int index,Layer3Subnet item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    Layer3SubnetBuilder builder = new Layer3SubnetBuilder(item);
    if (index < 0 || index >= subnets.size()) {
        _visitables.get("subnets").add(builder);
        subnets.add(builder);
    } else {
        _visitables.get("subnets").add(builder);
        subnets.add(index, builder);
    }
    return (A) this;
  }
  
  public Layer3Subnet buildFirstSubnet() {
    return this.subnets.get(0).build();
  }
  
  public Layer3Subnet buildLastSubnet() {
    return this.subnets.get(subnets.size() - 1).build();
  }
  
  public Layer3Subnet buildMatchingSubnet(Predicate<Layer3SubnetBuilder> predicate) {
      for (Layer3SubnetBuilder item : subnets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Layer3Subnet buildSubnet(int index) {
    return this.subnets.get(index).build();
  }
  
  public List<Layer3Subnet> buildSubnets() {
    return this.subnets != null ? build(subnets) : null;
  }
  
  protected void copyInstance(Layer3Config instance) {
    instance = instance != null ? instance : new Layer3Config();
    if (instance != null) {
        this.withJoinSubnets(instance.getJoinSubnets());
        this.withMtu(instance.getMtu());
        this.withRole(instance.getRole());
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
  
  public SubnetsNested<A> editMatchingSubnet(Predicate<Layer3SubnetBuilder> predicate) {
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
    Layer3ConfigFluent that = (Layer3ConfigFluent) o;
    if (!(Objects.equals(joinSubnets, that.joinSubnets))) {
      return false;
    }
    if (!(Objects.equals(mtu, that.mtu))) {
      return false;
    }
    if (!(Objects.equals(role, that.role))) {
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
  
  public String getFirstJoinSubnet() {
    return this.joinSubnets.get(0);
  }
  
  public String getJoinSubnet(int index) {
    return this.joinSubnets.get(index);
  }
  
  public List<String> getJoinSubnets() {
    return this.joinSubnets;
  }
  
  public String getLastJoinSubnet() {
    return this.joinSubnets.get(joinSubnets.size() - 1);
  }
  
  public String getMatchingJoinSubnet(Predicate<String> predicate) {
      for (String item : joinSubnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMtu() {
    return this.mtu;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasJoinSubnets() {
    return this.joinSubnets != null && !(this.joinSubnets.isEmpty());
  }
  
  public boolean hasMatchingJoinSubnet(Predicate<String> predicate) {
      for (String item : joinSubnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubnet(Predicate<Layer3SubnetBuilder> predicate) {
      for (Layer3SubnetBuilder item : subnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMtu() {
    return this.mtu != null;
  }
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(joinSubnets, mtu, role, subnets, additionalProperties);
  }
  
  public A removeAllFromJoinSubnets(Collection<String> items) {
    if (this.joinSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.joinSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSubnets(Collection<Layer3Subnet> items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (Layer3Subnet item : items) {
        Layer3SubnetBuilder builder = new Layer3SubnetBuilder(item);
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
  
  public A removeFromJoinSubnets(String... items) {
    if (this.joinSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.joinSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSubnets(Layer3Subnet... items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (Layer3Subnet item : items) {
        Layer3SubnetBuilder builder = new Layer3SubnetBuilder(item);
        _visitables.get("subnets").remove(builder);
        this.subnets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubnets(Predicate<Layer3SubnetBuilder> predicate) {
    if (subnets == null) {
      return (A) this;
    }
    Iterator<Layer3SubnetBuilder> each = subnets.iterator();
    List visitables = _visitables.get("subnets");
    while (each.hasNext()) {
        Layer3SubnetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubnetsNested<A> setNewSubnetLike(int index,Layer3Subnet item) {
    return new SubnetsNested(index, item);
  }
  
  public A setToJoinSubnets(int index,String item) {
    if (this.joinSubnets == null) {
      this.joinSubnets = new ArrayList();
    }
    this.joinSubnets.set(index, item);
    return (A) this;
  }
  
  public A setToSubnets(int index,Layer3Subnet item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    Layer3SubnetBuilder builder = new Layer3SubnetBuilder(item);
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
    if (!(joinSubnets == null) && !(joinSubnets.isEmpty())) {
        sb.append("joinSubnets:");
        sb.append(joinSubnets);
        sb.append(",");
    }
    if (!(mtu == null)) {
        sb.append("mtu:");
        sb.append(mtu);
        sb.append(",");
    }
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
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
  
  public A withJoinSubnets(List<String> joinSubnets) {
    if (joinSubnets != null) {
        this.joinSubnets = new ArrayList();
        for (String item : joinSubnets) {
          this.addToJoinSubnets(item);
        }
    } else {
      this.joinSubnets = null;
    }
    return (A) this;
  }
  
  public A withJoinSubnets(String... joinSubnets) {
    if (this.joinSubnets != null) {
        this.joinSubnets.clear();
        _visitables.remove("joinSubnets");
    }
    if (joinSubnets != null) {
      for (String item : joinSubnets) {
        this.addToJoinSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withMtu(Integer mtu) {
    this.mtu = mtu;
    return (A) this;
  }
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  
  public A withSubnets(List<Layer3Subnet> subnets) {
    if (this.subnets != null) {
      this._visitables.get("subnets").clear();
    }
    if (subnets != null) {
        this.subnets = new ArrayList();
        for (Layer3Subnet item : subnets) {
          this.addToSubnets(item);
        }
    } else {
      this.subnets = null;
    }
    return (A) this;
  }
  
  public A withSubnets(Layer3Subnet... subnets) {
    if (this.subnets != null) {
        this.subnets.clear();
        _visitables.remove("subnets");
    }
    if (subnets != null) {
      for (Layer3Subnet item : subnets) {
        this.addToSubnets(item);
      }
    }
    return (A) this;
  }
  public class SubnetsNested<N> extends Layer3SubnetFluent<SubnetsNested<N>> implements Nested<N>{
  
    Layer3SubnetBuilder builder;
    int index;
  
    SubnetsNested(int index,Layer3Subnet item) {
      this.index = index;
      this.builder = new Layer3SubnetBuilder(this, item);
    }
  
    public N and() {
      return (N) Layer3ConfigFluent.this.setToSubnets(index, builder.build());
    }
    
    public N endSubnet() {
      return and();
    }
    
  }
}