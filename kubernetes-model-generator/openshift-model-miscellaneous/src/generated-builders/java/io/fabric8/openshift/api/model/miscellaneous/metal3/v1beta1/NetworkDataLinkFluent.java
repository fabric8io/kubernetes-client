package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class NetworkDataLinkFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.NetworkDataLinkFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NetworkDataLinkBondBuilder> bonds = new ArrayList<NetworkDataLinkBondBuilder>();
  private ArrayList<NetworkDataLinkEthernetBuilder> ethernets = new ArrayList<NetworkDataLinkEthernetBuilder>();
  private ArrayList<NetworkDataLinkVlanBuilder> vlans = new ArrayList<NetworkDataLinkVlanBuilder>();

  public NetworkDataLinkFluent() {
  }
  
  public NetworkDataLinkFluent(NetworkDataLink instance) {
    this.copyInstance(instance);
  }

  public A addAllToBonds(Collection<NetworkDataLinkBond> items) {
    if (this.bonds == null) {
      this.bonds = new ArrayList();
    }
    for (NetworkDataLinkBond item : items) {
        NetworkDataLinkBondBuilder builder = new NetworkDataLinkBondBuilder(item);
        _visitables.get("bonds").add(builder);
        this.bonds.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToEthernets(Collection<NetworkDataLinkEthernet> items) {
    if (this.ethernets == null) {
      this.ethernets = new ArrayList();
    }
    for (NetworkDataLinkEthernet item : items) {
        NetworkDataLinkEthernetBuilder builder = new NetworkDataLinkEthernetBuilder(item);
        _visitables.get("ethernets").add(builder);
        this.ethernets.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVlans(Collection<NetworkDataLinkVlan> items) {
    if (this.vlans == null) {
      this.vlans = new ArrayList();
    }
    for (NetworkDataLinkVlan item : items) {
        NetworkDataLinkVlanBuilder builder = new NetworkDataLinkVlanBuilder(item);
        _visitables.get("vlans").add(builder);
        this.vlans.add(builder);
    }
    return (A) this;
  }
  
  public BondsNested<A> addNewBond() {
    return new BondsNested(-1, null);
  }
  
  public BondsNested<A> addNewBondLike(NetworkDataLinkBond item) {
    return new BondsNested(-1, item);
  }
  
  public EthernetsNested<A> addNewEthernet() {
    return new EthernetsNested(-1, null);
  }
  
  public EthernetsNested<A> addNewEthernetLike(NetworkDataLinkEthernet item) {
    return new EthernetsNested(-1, item);
  }
  
  public VlansNested<A> addNewVlan() {
    return new VlansNested(-1, null);
  }
  
  public VlansNested<A> addNewVlanLike(NetworkDataLinkVlan item) {
    return new VlansNested(-1, item);
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
  
  public A addToBonds(NetworkDataLinkBond... items) {
    if (this.bonds == null) {
      this.bonds = new ArrayList();
    }
    for (NetworkDataLinkBond item : items) {
        NetworkDataLinkBondBuilder builder = new NetworkDataLinkBondBuilder(item);
        _visitables.get("bonds").add(builder);
        this.bonds.add(builder);
    }
    return (A) this;
  }
  
  public A addToBonds(int index,NetworkDataLinkBond item) {
    if (this.bonds == null) {
      this.bonds = new ArrayList();
    }
    NetworkDataLinkBondBuilder builder = new NetworkDataLinkBondBuilder(item);
    if (index < 0 || index >= bonds.size()) {
        _visitables.get("bonds").add(builder);
        bonds.add(builder);
    } else {
        _visitables.get("bonds").add(builder);
        bonds.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToEthernets(NetworkDataLinkEthernet... items) {
    if (this.ethernets == null) {
      this.ethernets = new ArrayList();
    }
    for (NetworkDataLinkEthernet item : items) {
        NetworkDataLinkEthernetBuilder builder = new NetworkDataLinkEthernetBuilder(item);
        _visitables.get("ethernets").add(builder);
        this.ethernets.add(builder);
    }
    return (A) this;
  }
  
  public A addToEthernets(int index,NetworkDataLinkEthernet item) {
    if (this.ethernets == null) {
      this.ethernets = new ArrayList();
    }
    NetworkDataLinkEthernetBuilder builder = new NetworkDataLinkEthernetBuilder(item);
    if (index < 0 || index >= ethernets.size()) {
        _visitables.get("ethernets").add(builder);
        ethernets.add(builder);
    } else {
        _visitables.get("ethernets").add(builder);
        ethernets.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVlans(NetworkDataLinkVlan... items) {
    if (this.vlans == null) {
      this.vlans = new ArrayList();
    }
    for (NetworkDataLinkVlan item : items) {
        NetworkDataLinkVlanBuilder builder = new NetworkDataLinkVlanBuilder(item);
        _visitables.get("vlans").add(builder);
        this.vlans.add(builder);
    }
    return (A) this;
  }
  
  public A addToVlans(int index,NetworkDataLinkVlan item) {
    if (this.vlans == null) {
      this.vlans = new ArrayList();
    }
    NetworkDataLinkVlanBuilder builder = new NetworkDataLinkVlanBuilder(item);
    if (index < 0 || index >= vlans.size()) {
        _visitables.get("vlans").add(builder);
        vlans.add(builder);
    } else {
        _visitables.get("vlans").add(builder);
        vlans.add(index, builder);
    }
    return (A) this;
  }
  
  public NetworkDataLinkBond buildBond(int index) {
    return this.bonds.get(index).build();
  }
  
  public List<NetworkDataLinkBond> buildBonds() {
    return this.bonds != null ? build(bonds) : null;
  }
  
  public NetworkDataLinkEthernet buildEthernet(int index) {
    return this.ethernets.get(index).build();
  }
  
  public List<NetworkDataLinkEthernet> buildEthernets() {
    return this.ethernets != null ? build(ethernets) : null;
  }
  
  public NetworkDataLinkBond buildFirstBond() {
    return this.bonds.get(0).build();
  }
  
  public NetworkDataLinkEthernet buildFirstEthernet() {
    return this.ethernets.get(0).build();
  }
  
  public NetworkDataLinkVlan buildFirstVlan() {
    return this.vlans.get(0).build();
  }
  
  public NetworkDataLinkBond buildLastBond() {
    return this.bonds.get(bonds.size() - 1).build();
  }
  
  public NetworkDataLinkEthernet buildLastEthernet() {
    return this.ethernets.get(ethernets.size() - 1).build();
  }
  
  public NetworkDataLinkVlan buildLastVlan() {
    return this.vlans.get(vlans.size() - 1).build();
  }
  
  public NetworkDataLinkBond buildMatchingBond(Predicate<NetworkDataLinkBondBuilder> predicate) {
      for (NetworkDataLinkBondBuilder item : bonds) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkDataLinkEthernet buildMatchingEthernet(Predicate<NetworkDataLinkEthernetBuilder> predicate) {
      for (NetworkDataLinkEthernetBuilder item : ethernets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkDataLinkVlan buildMatchingVlan(Predicate<NetworkDataLinkVlanBuilder> predicate) {
      for (NetworkDataLinkVlanBuilder item : vlans) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkDataLinkVlan buildVlan(int index) {
    return this.vlans.get(index).build();
  }
  
  public List<NetworkDataLinkVlan> buildVlans() {
    return this.vlans != null ? build(vlans) : null;
  }
  
  protected void copyInstance(NetworkDataLink instance) {
    instance = instance != null ? instance : new NetworkDataLink();
    if (instance != null) {
        this.withBonds(instance.getBonds());
        this.withEthernets(instance.getEthernets());
        this.withVlans(instance.getVlans());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BondsNested<A> editBond(int index) {
    if (bonds.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "bonds"));
    }
    return this.setNewBondLike(index, this.buildBond(index));
  }
  
  public EthernetsNested<A> editEthernet(int index) {
    if (ethernets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ethernets"));
    }
    return this.setNewEthernetLike(index, this.buildEthernet(index));
  }
  
  public BondsNested<A> editFirstBond() {
    if (bonds.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "bonds"));
    }
    return this.setNewBondLike(0, this.buildBond(0));
  }
  
  public EthernetsNested<A> editFirstEthernet() {
    if (ethernets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ethernets"));
    }
    return this.setNewEthernetLike(0, this.buildEthernet(0));
  }
  
  public VlansNested<A> editFirstVlan() {
    if (vlans.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "vlans"));
    }
    return this.setNewVlanLike(0, this.buildVlan(0));
  }
  
  public BondsNested<A> editLastBond() {
    int index = bonds.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "bonds"));
    }
    return this.setNewBondLike(index, this.buildBond(index));
  }
  
  public EthernetsNested<A> editLastEthernet() {
    int index = ethernets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ethernets"));
    }
    return this.setNewEthernetLike(index, this.buildEthernet(index));
  }
  
  public VlansNested<A> editLastVlan() {
    int index = vlans.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "vlans"));
    }
    return this.setNewVlanLike(index, this.buildVlan(index));
  }
  
  public BondsNested<A> editMatchingBond(Predicate<NetworkDataLinkBondBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < bonds.size();i++) {
      if (predicate.test(bonds.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "bonds"));
    }
    return this.setNewBondLike(index, this.buildBond(index));
  }
  
  public EthernetsNested<A> editMatchingEthernet(Predicate<NetworkDataLinkEthernetBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ethernets.size();i++) {
      if (predicate.test(ethernets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ethernets"));
    }
    return this.setNewEthernetLike(index, this.buildEthernet(index));
  }
  
  public VlansNested<A> editMatchingVlan(Predicate<NetworkDataLinkVlanBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < vlans.size();i++) {
      if (predicate.test(vlans.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "vlans"));
    }
    return this.setNewVlanLike(index, this.buildVlan(index));
  }
  
  public VlansNested<A> editVlan(int index) {
    if (vlans.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "vlans"));
    }
    return this.setNewVlanLike(index, this.buildVlan(index));
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
    NetworkDataLinkFluent that = (NetworkDataLinkFluent) o;
    if (!(Objects.equals(bonds, that.bonds))) {
      return false;
    }
    if (!(Objects.equals(ethernets, that.ethernets))) {
      return false;
    }
    if (!(Objects.equals(vlans, that.vlans))) {
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
  
  public boolean hasBonds() {
    return this.bonds != null && !(this.bonds.isEmpty());
  }
  
  public boolean hasEthernets() {
    return this.ethernets != null && !(this.ethernets.isEmpty());
  }
  
  public boolean hasMatchingBond(Predicate<NetworkDataLinkBondBuilder> predicate) {
      for (NetworkDataLinkBondBuilder item : bonds) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEthernet(Predicate<NetworkDataLinkEthernetBuilder> predicate) {
      for (NetworkDataLinkEthernetBuilder item : ethernets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVlan(Predicate<NetworkDataLinkVlanBuilder> predicate) {
      for (NetworkDataLinkVlanBuilder item : vlans) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasVlans() {
    return this.vlans != null && !(this.vlans.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(bonds, ethernets, vlans, additionalProperties);
  }
  
  public A removeAllFromBonds(Collection<NetworkDataLinkBond> items) {
    if (this.bonds == null) {
      return (A) this;
    }
    for (NetworkDataLinkBond item : items) {
        NetworkDataLinkBondBuilder builder = new NetworkDataLinkBondBuilder(item);
        _visitables.get("bonds").remove(builder);
        this.bonds.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromEthernets(Collection<NetworkDataLinkEthernet> items) {
    if (this.ethernets == null) {
      return (A) this;
    }
    for (NetworkDataLinkEthernet item : items) {
        NetworkDataLinkEthernetBuilder builder = new NetworkDataLinkEthernetBuilder(item);
        _visitables.get("ethernets").remove(builder);
        this.ethernets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVlans(Collection<NetworkDataLinkVlan> items) {
    if (this.vlans == null) {
      return (A) this;
    }
    for (NetworkDataLinkVlan item : items) {
        NetworkDataLinkVlanBuilder builder = new NetworkDataLinkVlanBuilder(item);
        _visitables.get("vlans").remove(builder);
        this.vlans.remove(builder);
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
  
  public A removeFromBonds(NetworkDataLinkBond... items) {
    if (this.bonds == null) {
      return (A) this;
    }
    for (NetworkDataLinkBond item : items) {
        NetworkDataLinkBondBuilder builder = new NetworkDataLinkBondBuilder(item);
        _visitables.get("bonds").remove(builder);
        this.bonds.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromEthernets(NetworkDataLinkEthernet... items) {
    if (this.ethernets == null) {
      return (A) this;
    }
    for (NetworkDataLinkEthernet item : items) {
        NetworkDataLinkEthernetBuilder builder = new NetworkDataLinkEthernetBuilder(item);
        _visitables.get("ethernets").remove(builder);
        this.ethernets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVlans(NetworkDataLinkVlan... items) {
    if (this.vlans == null) {
      return (A) this;
    }
    for (NetworkDataLinkVlan item : items) {
        NetworkDataLinkVlanBuilder builder = new NetworkDataLinkVlanBuilder(item);
        _visitables.get("vlans").remove(builder);
        this.vlans.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromBonds(Predicate<NetworkDataLinkBondBuilder> predicate) {
    if (bonds == null) {
      return (A) this;
    }
    Iterator<NetworkDataLinkBondBuilder> each = bonds.iterator();
    List visitables = _visitables.get("bonds");
    while (each.hasNext()) {
        NetworkDataLinkBondBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromEthernets(Predicate<NetworkDataLinkEthernetBuilder> predicate) {
    if (ethernets == null) {
      return (A) this;
    }
    Iterator<NetworkDataLinkEthernetBuilder> each = ethernets.iterator();
    List visitables = _visitables.get("ethernets");
    while (each.hasNext()) {
        NetworkDataLinkEthernetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVlans(Predicate<NetworkDataLinkVlanBuilder> predicate) {
    if (vlans == null) {
      return (A) this;
    }
    Iterator<NetworkDataLinkVlanBuilder> each = vlans.iterator();
    List visitables = _visitables.get("vlans");
    while (each.hasNext()) {
        NetworkDataLinkVlanBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public BondsNested<A> setNewBondLike(int index,NetworkDataLinkBond item) {
    return new BondsNested(index, item);
  }
  
  public EthernetsNested<A> setNewEthernetLike(int index,NetworkDataLinkEthernet item) {
    return new EthernetsNested(index, item);
  }
  
  public VlansNested<A> setNewVlanLike(int index,NetworkDataLinkVlan item) {
    return new VlansNested(index, item);
  }
  
  public A setToBonds(int index,NetworkDataLinkBond item) {
    if (this.bonds == null) {
      this.bonds = new ArrayList();
    }
    NetworkDataLinkBondBuilder builder = new NetworkDataLinkBondBuilder(item);
    if (index < 0 || index >= bonds.size()) {
        _visitables.get("bonds").add(builder);
        bonds.add(builder);
    } else {
        _visitables.get("bonds").add(builder);
        bonds.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToEthernets(int index,NetworkDataLinkEthernet item) {
    if (this.ethernets == null) {
      this.ethernets = new ArrayList();
    }
    NetworkDataLinkEthernetBuilder builder = new NetworkDataLinkEthernetBuilder(item);
    if (index < 0 || index >= ethernets.size()) {
        _visitables.get("ethernets").add(builder);
        ethernets.add(builder);
    } else {
        _visitables.get("ethernets").add(builder);
        ethernets.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVlans(int index,NetworkDataLinkVlan item) {
    if (this.vlans == null) {
      this.vlans = new ArrayList();
    }
    NetworkDataLinkVlanBuilder builder = new NetworkDataLinkVlanBuilder(item);
    if (index < 0 || index >= vlans.size()) {
        _visitables.get("vlans").add(builder);
        vlans.add(builder);
    } else {
        _visitables.get("vlans").add(builder);
        vlans.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bonds == null) && !(bonds.isEmpty())) {
        sb.append("bonds:");
        sb.append(bonds);
        sb.append(",");
    }
    if (!(ethernets == null) && !(ethernets.isEmpty())) {
        sb.append("ethernets:");
        sb.append(ethernets);
        sb.append(",");
    }
    if (!(vlans == null) && !(vlans.isEmpty())) {
        sb.append("vlans:");
        sb.append(vlans);
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
  
  public A withBonds(List<NetworkDataLinkBond> bonds) {
    if (this.bonds != null) {
      this._visitables.get("bonds").clear();
    }
    if (bonds != null) {
        this.bonds = new ArrayList();
        for (NetworkDataLinkBond item : bonds) {
          this.addToBonds(item);
        }
    } else {
      this.bonds = null;
    }
    return (A) this;
  }
  
  public A withBonds(NetworkDataLinkBond... bonds) {
    if (this.bonds != null) {
        this.bonds.clear();
        _visitables.remove("bonds");
    }
    if (bonds != null) {
      for (NetworkDataLinkBond item : bonds) {
        this.addToBonds(item);
      }
    }
    return (A) this;
  }
  
  public A withEthernets(List<NetworkDataLinkEthernet> ethernets) {
    if (this.ethernets != null) {
      this._visitables.get("ethernets").clear();
    }
    if (ethernets != null) {
        this.ethernets = new ArrayList();
        for (NetworkDataLinkEthernet item : ethernets) {
          this.addToEthernets(item);
        }
    } else {
      this.ethernets = null;
    }
    return (A) this;
  }
  
  public A withEthernets(NetworkDataLinkEthernet... ethernets) {
    if (this.ethernets != null) {
        this.ethernets.clear();
        _visitables.remove("ethernets");
    }
    if (ethernets != null) {
      for (NetworkDataLinkEthernet item : ethernets) {
        this.addToEthernets(item);
      }
    }
    return (A) this;
  }
  
  public A withVlans(List<NetworkDataLinkVlan> vlans) {
    if (this.vlans != null) {
      this._visitables.get("vlans").clear();
    }
    if (vlans != null) {
        this.vlans = new ArrayList();
        for (NetworkDataLinkVlan item : vlans) {
          this.addToVlans(item);
        }
    } else {
      this.vlans = null;
    }
    return (A) this;
  }
  
  public A withVlans(NetworkDataLinkVlan... vlans) {
    if (this.vlans != null) {
        this.vlans.clear();
        _visitables.remove("vlans");
    }
    if (vlans != null) {
      for (NetworkDataLinkVlan item : vlans) {
        this.addToVlans(item);
      }
    }
    return (A) this;
  }
  public class BondsNested<N> extends NetworkDataLinkBondFluent<BondsNested<N>> implements Nested<N>{
  
    NetworkDataLinkBondBuilder builder;
    int index;
  
    BondsNested(int index,NetworkDataLinkBond item) {
      this.index = index;
      this.builder = new NetworkDataLinkBondBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataLinkFluent.this.setToBonds(index, builder.build());
    }
    
    public N endBond() {
      return and();
    }
    
  }
  public class EthernetsNested<N> extends NetworkDataLinkEthernetFluent<EthernetsNested<N>> implements Nested<N>{
  
    NetworkDataLinkEthernetBuilder builder;
    int index;
  
    EthernetsNested(int index,NetworkDataLinkEthernet item) {
      this.index = index;
      this.builder = new NetworkDataLinkEthernetBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataLinkFluent.this.setToEthernets(index, builder.build());
    }
    
    public N endEthernet() {
      return and();
    }
    
  }
  public class VlansNested<N> extends NetworkDataLinkVlanFluent<VlansNested<N>> implements Nested<N>{
  
    NetworkDataLinkVlanBuilder builder;
    int index;
  
    VlansNested(int index,NetworkDataLinkVlan item) {
      this.index = index;
      this.builder = new NetworkDataLinkVlanBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataLinkFluent.this.setToVlans(index, builder.build());
    }
    
    public N endVlan() {
      return and();
    }
    
  }
}