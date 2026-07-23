package io.fabric8.chaosmesh.v1alpha1;

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
public class PodNetworkChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.PodNetworkChaosSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RawIPSetBuilder> ipsets = new ArrayList<RawIPSetBuilder>();
  private ArrayList<RawIptablesBuilder> iptables = new ArrayList<RawIptablesBuilder>();
  private ArrayList<RawTrafficControlBuilder> tcs = new ArrayList<RawTrafficControlBuilder>();

  public PodNetworkChaosSpecFluent() {
  }
  
  public PodNetworkChaosSpecFluent(PodNetworkChaosSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToIpsets(Collection<RawIPSet> items) {
    if (this.ipsets == null) {
      this.ipsets = new ArrayList();
    }
    for (RawIPSet item : items) {
        RawIPSetBuilder builder = new RawIPSetBuilder(item);
        _visitables.get("ipsets").add(builder);
        this.ipsets.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIptables(Collection<RawIptables> items) {
    if (this.iptables == null) {
      this.iptables = new ArrayList();
    }
    for (RawIptables item : items) {
        RawIptablesBuilder builder = new RawIptablesBuilder(item);
        _visitables.get("iptables").add(builder);
        this.iptables.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTcs(Collection<RawTrafficControl> items) {
    if (this.tcs == null) {
      this.tcs = new ArrayList();
    }
    for (RawTrafficControl item : items) {
        RawTrafficControlBuilder builder = new RawTrafficControlBuilder(item);
        _visitables.get("tcs").add(builder);
        this.tcs.add(builder);
    }
    return (A) this;
  }
  
  public IpsetsNested<A> addNewIpset() {
    return new IpsetsNested(-1, null);
  }
  
  public IpsetsNested<A> addNewIpsetLike(RawIPSet item) {
    return new IpsetsNested(-1, item);
  }
  
  public IptablesNested<A> addNewIptable() {
    return new IptablesNested(-1, null);
  }
  
  public IptablesNested<A> addNewIptableLike(RawIptables item) {
    return new IptablesNested(-1, item);
  }
  
  public TcsNested<A> addNewTc() {
    return new TcsNested(-1, null);
  }
  
  public TcsNested<A> addNewTcLike(RawTrafficControl item) {
    return new TcsNested(-1, item);
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
  
  public A addToIpsets(RawIPSet... items) {
    if (this.ipsets == null) {
      this.ipsets = new ArrayList();
    }
    for (RawIPSet item : items) {
        RawIPSetBuilder builder = new RawIPSetBuilder(item);
        _visitables.get("ipsets").add(builder);
        this.ipsets.add(builder);
    }
    return (A) this;
  }
  
  public A addToIpsets(int index,RawIPSet item) {
    if (this.ipsets == null) {
      this.ipsets = new ArrayList();
    }
    RawIPSetBuilder builder = new RawIPSetBuilder(item);
    if (index < 0 || index >= ipsets.size()) {
        _visitables.get("ipsets").add(builder);
        ipsets.add(builder);
    } else {
        _visitables.get("ipsets").add(builder);
        ipsets.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIptables(RawIptables... items) {
    if (this.iptables == null) {
      this.iptables = new ArrayList();
    }
    for (RawIptables item : items) {
        RawIptablesBuilder builder = new RawIptablesBuilder(item);
        _visitables.get("iptables").add(builder);
        this.iptables.add(builder);
    }
    return (A) this;
  }
  
  public A addToIptables(int index,RawIptables item) {
    if (this.iptables == null) {
      this.iptables = new ArrayList();
    }
    RawIptablesBuilder builder = new RawIptablesBuilder(item);
    if (index < 0 || index >= iptables.size()) {
        _visitables.get("iptables").add(builder);
        iptables.add(builder);
    } else {
        _visitables.get("iptables").add(builder);
        iptables.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTcs(RawTrafficControl... items) {
    if (this.tcs == null) {
      this.tcs = new ArrayList();
    }
    for (RawTrafficControl item : items) {
        RawTrafficControlBuilder builder = new RawTrafficControlBuilder(item);
        _visitables.get("tcs").add(builder);
        this.tcs.add(builder);
    }
    return (A) this;
  }
  
  public A addToTcs(int index,RawTrafficControl item) {
    if (this.tcs == null) {
      this.tcs = new ArrayList();
    }
    RawTrafficControlBuilder builder = new RawTrafficControlBuilder(item);
    if (index < 0 || index >= tcs.size()) {
        _visitables.get("tcs").add(builder);
        tcs.add(builder);
    } else {
        _visitables.get("tcs").add(builder);
        tcs.add(index, builder);
    }
    return (A) this;
  }
  
  public RawIPSet buildFirstIpset() {
    return this.ipsets.get(0).build();
  }
  
  public RawIptables buildFirstIptable() {
    return this.iptables.get(0).build();
  }
  
  public RawTrafficControl buildFirstTc() {
    return this.tcs.get(0).build();
  }
  
  public RawIPSet buildIpset(int index) {
    return this.ipsets.get(index).build();
  }
  
  public List<RawIPSet> buildIpsets() {
    return this.ipsets != null ? build(ipsets) : null;
  }
  
  public RawIptables buildIptable(int index) {
    return this.iptables.get(index).build();
  }
  
  public List<RawIptables> buildIptables() {
    return this.iptables != null ? build(iptables) : null;
  }
  
  public RawIPSet buildLastIpset() {
    return this.ipsets.get(ipsets.size() - 1).build();
  }
  
  public RawIptables buildLastIptable() {
    return this.iptables.get(iptables.size() - 1).build();
  }
  
  public RawTrafficControl buildLastTc() {
    return this.tcs.get(tcs.size() - 1).build();
  }
  
  public RawIPSet buildMatchingIpset(Predicate<RawIPSetBuilder> predicate) {
      for (RawIPSetBuilder item : ipsets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RawIptables buildMatchingIptable(Predicate<RawIptablesBuilder> predicate) {
      for (RawIptablesBuilder item : iptables) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RawTrafficControl buildMatchingTc(Predicate<RawTrafficControlBuilder> predicate) {
      for (RawTrafficControlBuilder item : tcs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RawTrafficControl buildTc(int index) {
    return this.tcs.get(index).build();
  }
  
  public List<RawTrafficControl> buildTcs() {
    return this.tcs != null ? build(tcs) : null;
  }
  
  protected void copyInstance(PodNetworkChaosSpec instance) {
    instance = instance != null ? instance : new PodNetworkChaosSpec();
    if (instance != null) {
        this.withIpsets(instance.getIpsets());
        this.withIptables(instance.getIptables());
        this.withTcs(instance.getTcs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IpsetsNested<A> editFirstIpset() {
    if (ipsets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ipsets"));
    }
    return this.setNewIpsetLike(0, this.buildIpset(0));
  }
  
  public IptablesNested<A> editFirstIptable() {
    if (iptables.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "iptables"));
    }
    return this.setNewIptableLike(0, this.buildIptable(0));
  }
  
  public TcsNested<A> editFirstTc() {
    if (tcs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tcs"));
    }
    return this.setNewTcLike(0, this.buildTc(0));
  }
  
  public IpsetsNested<A> editIpset(int index) {
    if (ipsets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ipsets"));
    }
    return this.setNewIpsetLike(index, this.buildIpset(index));
  }
  
  public IptablesNested<A> editIptable(int index) {
    if (iptables.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "iptables"));
    }
    return this.setNewIptableLike(index, this.buildIptable(index));
  }
  
  public IpsetsNested<A> editLastIpset() {
    int index = ipsets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ipsets"));
    }
    return this.setNewIpsetLike(index, this.buildIpset(index));
  }
  
  public IptablesNested<A> editLastIptable() {
    int index = iptables.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "iptables"));
    }
    return this.setNewIptableLike(index, this.buildIptable(index));
  }
  
  public TcsNested<A> editLastTc() {
    int index = tcs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tcs"));
    }
    return this.setNewTcLike(index, this.buildTc(index));
  }
  
  public IpsetsNested<A> editMatchingIpset(Predicate<RawIPSetBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ipsets.size();i++) {
      if (predicate.test(ipsets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ipsets"));
    }
    return this.setNewIpsetLike(index, this.buildIpset(index));
  }
  
  public IptablesNested<A> editMatchingIptable(Predicate<RawIptablesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < iptables.size();i++) {
      if (predicate.test(iptables.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "iptables"));
    }
    return this.setNewIptableLike(index, this.buildIptable(index));
  }
  
  public TcsNested<A> editMatchingTc(Predicate<RawTrafficControlBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tcs.size();i++) {
      if (predicate.test(tcs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tcs"));
    }
    return this.setNewTcLike(index, this.buildTc(index));
  }
  
  public TcsNested<A> editTc(int index) {
    if (tcs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tcs"));
    }
    return this.setNewTcLike(index, this.buildTc(index));
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
    PodNetworkChaosSpecFluent that = (PodNetworkChaosSpecFluent) o;
    if (!(Objects.equals(ipsets, that.ipsets))) {
      return false;
    }
    if (!(Objects.equals(iptables, that.iptables))) {
      return false;
    }
    if (!(Objects.equals(tcs, that.tcs))) {
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
  
  public boolean hasIpsets() {
    return this.ipsets != null && !(this.ipsets.isEmpty());
  }
  
  public boolean hasIptables() {
    return this.iptables != null && !(this.iptables.isEmpty());
  }
  
  public boolean hasMatchingIpset(Predicate<RawIPSetBuilder> predicate) {
      for (RawIPSetBuilder item : ipsets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIptable(Predicate<RawIptablesBuilder> predicate) {
      for (RawIptablesBuilder item : iptables) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTc(Predicate<RawTrafficControlBuilder> predicate) {
      for (RawTrafficControlBuilder item : tcs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTcs() {
    return this.tcs != null && !(this.tcs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(ipsets, iptables, tcs, additionalProperties);
  }
  
  public A removeAllFromIpsets(Collection<RawIPSet> items) {
    if (this.ipsets == null) {
      return (A) this;
    }
    for (RawIPSet item : items) {
        RawIPSetBuilder builder = new RawIPSetBuilder(item);
        _visitables.get("ipsets").remove(builder);
        this.ipsets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIptables(Collection<RawIptables> items) {
    if (this.iptables == null) {
      return (A) this;
    }
    for (RawIptables item : items) {
        RawIptablesBuilder builder = new RawIptablesBuilder(item);
        _visitables.get("iptables").remove(builder);
        this.iptables.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTcs(Collection<RawTrafficControl> items) {
    if (this.tcs == null) {
      return (A) this;
    }
    for (RawTrafficControl item : items) {
        RawTrafficControlBuilder builder = new RawTrafficControlBuilder(item);
        _visitables.get("tcs").remove(builder);
        this.tcs.remove(builder);
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
  
  public A removeFromIpsets(RawIPSet... items) {
    if (this.ipsets == null) {
      return (A) this;
    }
    for (RawIPSet item : items) {
        RawIPSetBuilder builder = new RawIPSetBuilder(item);
        _visitables.get("ipsets").remove(builder);
        this.ipsets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIptables(RawIptables... items) {
    if (this.iptables == null) {
      return (A) this;
    }
    for (RawIptables item : items) {
        RawIptablesBuilder builder = new RawIptablesBuilder(item);
        _visitables.get("iptables").remove(builder);
        this.iptables.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTcs(RawTrafficControl... items) {
    if (this.tcs == null) {
      return (A) this;
    }
    for (RawTrafficControl item : items) {
        RawTrafficControlBuilder builder = new RawTrafficControlBuilder(item);
        _visitables.get("tcs").remove(builder);
        this.tcs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromIpsets(Predicate<RawIPSetBuilder> predicate) {
    if (ipsets == null) {
      return (A) this;
    }
    Iterator<RawIPSetBuilder> each = ipsets.iterator();
    List visitables = _visitables.get("ipsets");
    while (each.hasNext()) {
        RawIPSetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromIptables(Predicate<RawIptablesBuilder> predicate) {
    if (iptables == null) {
      return (A) this;
    }
    Iterator<RawIptablesBuilder> each = iptables.iterator();
    List visitables = _visitables.get("iptables");
    while (each.hasNext()) {
        RawIptablesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTcs(Predicate<RawTrafficControlBuilder> predicate) {
    if (tcs == null) {
      return (A) this;
    }
    Iterator<RawTrafficControlBuilder> each = tcs.iterator();
    List visitables = _visitables.get("tcs");
    while (each.hasNext()) {
        RawTrafficControlBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public IpsetsNested<A> setNewIpsetLike(int index,RawIPSet item) {
    return new IpsetsNested(index, item);
  }
  
  public IptablesNested<A> setNewIptableLike(int index,RawIptables item) {
    return new IptablesNested(index, item);
  }
  
  public TcsNested<A> setNewTcLike(int index,RawTrafficControl item) {
    return new TcsNested(index, item);
  }
  
  public A setToIpsets(int index,RawIPSet item) {
    if (this.ipsets == null) {
      this.ipsets = new ArrayList();
    }
    RawIPSetBuilder builder = new RawIPSetBuilder(item);
    if (index < 0 || index >= ipsets.size()) {
        _visitables.get("ipsets").add(builder);
        ipsets.add(builder);
    } else {
        _visitables.get("ipsets").add(builder);
        ipsets.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIptables(int index,RawIptables item) {
    if (this.iptables == null) {
      this.iptables = new ArrayList();
    }
    RawIptablesBuilder builder = new RawIptablesBuilder(item);
    if (index < 0 || index >= iptables.size()) {
        _visitables.get("iptables").add(builder);
        iptables.add(builder);
    } else {
        _visitables.get("iptables").add(builder);
        iptables.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTcs(int index,RawTrafficControl item) {
    if (this.tcs == null) {
      this.tcs = new ArrayList();
    }
    RawTrafficControlBuilder builder = new RawTrafficControlBuilder(item);
    if (index < 0 || index >= tcs.size()) {
        _visitables.get("tcs").add(builder);
        tcs.add(builder);
    } else {
        _visitables.get("tcs").add(builder);
        tcs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ipsets == null) && !(ipsets.isEmpty())) {
        sb.append("ipsets:");
        sb.append(ipsets);
        sb.append(",");
    }
    if (!(iptables == null) && !(iptables.isEmpty())) {
        sb.append("iptables:");
        sb.append(iptables);
        sb.append(",");
    }
    if (!(tcs == null) && !(tcs.isEmpty())) {
        sb.append("tcs:");
        sb.append(tcs);
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
  
  public A withIpsets(List<RawIPSet> ipsets) {
    if (this.ipsets != null) {
      this._visitables.get("ipsets").clear();
    }
    if (ipsets != null) {
        this.ipsets = new ArrayList();
        for (RawIPSet item : ipsets) {
          this.addToIpsets(item);
        }
    } else {
      this.ipsets = null;
    }
    return (A) this;
  }
  
  public A withIpsets(RawIPSet... ipsets) {
    if (this.ipsets != null) {
        this.ipsets.clear();
        _visitables.remove("ipsets");
    }
    if (ipsets != null) {
      for (RawIPSet item : ipsets) {
        this.addToIpsets(item);
      }
    }
    return (A) this;
  }
  
  public A withIptables(List<RawIptables> iptables) {
    if (this.iptables != null) {
      this._visitables.get("iptables").clear();
    }
    if (iptables != null) {
        this.iptables = new ArrayList();
        for (RawIptables item : iptables) {
          this.addToIptables(item);
        }
    } else {
      this.iptables = null;
    }
    return (A) this;
  }
  
  public A withIptables(RawIptables... iptables) {
    if (this.iptables != null) {
        this.iptables.clear();
        _visitables.remove("iptables");
    }
    if (iptables != null) {
      for (RawIptables item : iptables) {
        this.addToIptables(item);
      }
    }
    return (A) this;
  }
  
  public A withTcs(List<RawTrafficControl> tcs) {
    if (this.tcs != null) {
      this._visitables.get("tcs").clear();
    }
    if (tcs != null) {
        this.tcs = new ArrayList();
        for (RawTrafficControl item : tcs) {
          this.addToTcs(item);
        }
    } else {
      this.tcs = null;
    }
    return (A) this;
  }
  
  public A withTcs(RawTrafficControl... tcs) {
    if (this.tcs != null) {
        this.tcs.clear();
        _visitables.remove("tcs");
    }
    if (tcs != null) {
      for (RawTrafficControl item : tcs) {
        this.addToTcs(item);
      }
    }
    return (A) this;
  }
  public class IpsetsNested<N> extends RawIPSetFluent<IpsetsNested<N>> implements Nested<N>{
  
    RawIPSetBuilder builder;
    int index;
  
    IpsetsNested(int index,RawIPSet item) {
      this.index = index;
      this.builder = new RawIPSetBuilder(this, item);
    }
  
    public N and() {
      return (N) PodNetworkChaosSpecFluent.this.setToIpsets(index, builder.build());
    }
    
    public N endIpset() {
      return and();
    }
    
  }
  public class IptablesNested<N> extends RawIptablesFluent<IptablesNested<N>> implements Nested<N>{
  
    RawIptablesBuilder builder;
    int index;
  
    IptablesNested(int index,RawIptables item) {
      this.index = index;
      this.builder = new RawIptablesBuilder(this, item);
    }
  
    public N and() {
      return (N) PodNetworkChaosSpecFluent.this.setToIptables(index, builder.build());
    }
    
    public N endIptable() {
      return and();
    }
    
  }
  public class TcsNested<N> extends RawTrafficControlFluent<TcsNested<N>> implements Nested<N>{
  
    RawTrafficControlBuilder builder;
    int index;
  
    TcsNested(int index,RawTrafficControl item) {
      this.index = index;
      this.builder = new RawTrafficControlBuilder(this, item);
    }
  
    public N and() {
      return (N) PodNetworkChaosSpecFluent.this.setToTcs(index, builder.build());
    }
    
    public N endTc() {
      return and();
    }
    
  }
}