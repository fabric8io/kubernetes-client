package io.fabric8.openshift.api.model.config.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NutanixFailureDomainFluent<A extends io.fabric8.openshift.api.model.config.v1.NutanixFailureDomainFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NutanixResourceIdentifierBuilder cluster;
  private String name;
  private ArrayList<NutanixResourceIdentifierBuilder> subnets = new ArrayList<NutanixResourceIdentifierBuilder>();

  public NutanixFailureDomainFluent() {
  }
  
  public NutanixFailureDomainFluent(NutanixFailureDomain instance) {
    this.copyInstance(instance);
  }

  public A addAllToSubnets(Collection<NutanixResourceIdentifier> items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (NutanixResourceIdentifier item : items) {
        NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public SubnetsNested<A> addNewSubnet() {
    return new SubnetsNested(-1, null);
  }
  
  public A addNewSubnet(String name,String type,String uuid) {
    return (A) this.addToSubnets(new NutanixResourceIdentifier(name, type, uuid));
  }
  
  public SubnetsNested<A> addNewSubnetLike(NutanixResourceIdentifier item) {
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
  
  public A addToSubnets(NutanixResourceIdentifier... items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (NutanixResourceIdentifier item : items) {
        NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubnets(int index,NutanixResourceIdentifier item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
    if (index < 0 || index >= subnets.size()) {
        _visitables.get("subnets").add(builder);
        subnets.add(builder);
    } else {
        _visitables.get("subnets").add(builder);
        subnets.add(index, builder);
    }
    return (A) this;
  }
  
  public NutanixResourceIdentifier buildCluster() {
    return this.cluster != null ? this.cluster.build() : null;
  }
  
  public NutanixResourceIdentifier buildFirstSubnet() {
    return this.subnets.get(0).build();
  }
  
  public NutanixResourceIdentifier buildLastSubnet() {
    return this.subnets.get(subnets.size() - 1).build();
  }
  
  public NutanixResourceIdentifier buildMatchingSubnet(Predicate<NutanixResourceIdentifierBuilder> predicate) {
      for (NutanixResourceIdentifierBuilder item : subnets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NutanixResourceIdentifier buildSubnet(int index) {
    return this.subnets.get(index).build();
  }
  
  public List<NutanixResourceIdentifier> buildSubnets() {
    return this.subnets != null ? build(subnets) : null;
  }
  
  protected void copyInstance(NutanixFailureDomain instance) {
    instance = instance != null ? instance : new NutanixFailureDomain();
    if (instance != null) {
        this.withCluster(instance.getCluster());
        this.withName(instance.getName());
        this.withSubnets(instance.getSubnets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterNested<A> editCluster() {
    return this.withNewClusterLike(Optional.ofNullable(this.buildCluster()).orElse(null));
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
  
  public SubnetsNested<A> editMatchingSubnet(Predicate<NutanixResourceIdentifierBuilder> predicate) {
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
  
  public ClusterNested<A> editOrNewCluster() {
    return this.withNewClusterLike(Optional.ofNullable(this.buildCluster()).orElse(new NutanixResourceIdentifierBuilder().build()));
  }
  
  public ClusterNested<A> editOrNewClusterLike(NutanixResourceIdentifier item) {
    return this.withNewClusterLike(Optional.ofNullable(this.buildCluster()).orElse(item));
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
    NutanixFailureDomainFluent that = (NutanixFailureDomainFluent) o;
    if (!(Objects.equals(cluster, that.cluster))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCluster() {
    return this.cluster != null;
  }
  
  public boolean hasMatchingSubnet(Predicate<NutanixResourceIdentifierBuilder> predicate) {
      for (NutanixResourceIdentifierBuilder item : subnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(cluster, name, subnets, additionalProperties);
  }
  
  public A removeAllFromSubnets(Collection<NutanixResourceIdentifier> items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (NutanixResourceIdentifier item : items) {
        NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
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
  
  public A removeFromSubnets(NutanixResourceIdentifier... items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (NutanixResourceIdentifier item : items) {
        NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
        _visitables.get("subnets").remove(builder);
        this.subnets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubnets(Predicate<NutanixResourceIdentifierBuilder> predicate) {
    if (subnets == null) {
      return (A) this;
    }
    Iterator<NutanixResourceIdentifierBuilder> each = subnets.iterator();
    List visitables = _visitables.get("subnets");
    while (each.hasNext()) {
        NutanixResourceIdentifierBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubnetsNested<A> setNewSubnetLike(int index,NutanixResourceIdentifier item) {
    return new SubnetsNested(index, item);
  }
  
  public A setToSubnets(int index,NutanixResourceIdentifier item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
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
    if (!(cluster == null)) {
        sb.append("cluster:");
        sb.append(cluster);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withCluster(NutanixResourceIdentifier cluster) {
    this._visitables.remove("cluster");
    if (cluster != null) {
        this.cluster = new NutanixResourceIdentifierBuilder(cluster);
        this._visitables.get("cluster").add(this.cluster);
    } else {
        this.cluster = null;
        this._visitables.get("cluster").remove(this.cluster);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ClusterNested<A> withNewCluster() {
    return new ClusterNested(null);
  }
  
  public A withNewCluster(String name,String type,String uuid) {
    return (A) this.withCluster(new NutanixResourceIdentifier(name, type, uuid));
  }
  
  public ClusterNested<A> withNewClusterLike(NutanixResourceIdentifier item) {
    return new ClusterNested(item);
  }
  
  public A withSubnets(List<NutanixResourceIdentifier> subnets) {
    if (this.subnets != null) {
      this._visitables.get("subnets").clear();
    }
    if (subnets != null) {
        this.subnets = new ArrayList();
        for (NutanixResourceIdentifier item : subnets) {
          this.addToSubnets(item);
        }
    } else {
      this.subnets = null;
    }
    return (A) this;
  }
  
  public A withSubnets(NutanixResourceIdentifier... subnets) {
    if (this.subnets != null) {
        this.subnets.clear();
        _visitables.remove("subnets");
    }
    if (subnets != null) {
      for (NutanixResourceIdentifier item : subnets) {
        this.addToSubnets(item);
      }
    }
    return (A) this;
  }
  public class ClusterNested<N> extends NutanixResourceIdentifierFluent<ClusterNested<N>> implements Nested<N>{
  
    NutanixResourceIdentifierBuilder builder;
  
    ClusterNested(NutanixResourceIdentifier item) {
      this.builder = new NutanixResourceIdentifierBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixFailureDomainFluent.this.withCluster(builder.build());
    }
    
    public N endCluster() {
      return and();
    }
    
  }
  public class SubnetsNested<N> extends NutanixResourceIdentifierFluent<SubnetsNested<N>> implements Nested<N>{
  
    NutanixResourceIdentifierBuilder builder;
    int index;
  
    SubnetsNested(int index,NutanixResourceIdentifier item) {
      this.index = index;
      this.builder = new NutanixResourceIdentifierBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixFailureDomainFluent.this.setToSubnets(index, builder.build());
    }
    
    public N endSubnet() {
      return and();
    }
    
  }
}