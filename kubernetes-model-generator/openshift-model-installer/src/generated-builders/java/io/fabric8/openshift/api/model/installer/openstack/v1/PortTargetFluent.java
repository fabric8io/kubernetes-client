package io.fabric8.openshift.api.model.installer.openstack.v1;

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
public class PortTargetFluent<A extends io.fabric8.openshift.api.model.installer.openstack.v1.PortTargetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<FixedIPBuilder> fixedIPs = new ArrayList<FixedIPBuilder>();
  private NetworkFilterBuilder network;

  public PortTargetFluent() {
  }
  
  public PortTargetFluent(PortTarget instance) {
    this.copyInstance(instance);
  }

  public A addAllToFixedIPs(Collection<FixedIP> items) {
    if (this.fixedIPs == null) {
      this.fixedIPs = new ArrayList();
    }
    for (FixedIP item : items) {
        FixedIPBuilder builder = new FixedIPBuilder(item);
        _visitables.get("fixedIPs").add(builder);
        this.fixedIPs.add(builder);
    }
    return (A) this;
  }
  
  public FixedIPsNested<A> addNewFixedIP() {
    return new FixedIPsNested(-1, null);
  }
  
  public FixedIPsNested<A> addNewFixedIPLike(FixedIP item) {
    return new FixedIPsNested(-1, item);
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
  
  public A addToFixedIPs(FixedIP... items) {
    if (this.fixedIPs == null) {
      this.fixedIPs = new ArrayList();
    }
    for (FixedIP item : items) {
        FixedIPBuilder builder = new FixedIPBuilder(item);
        _visitables.get("fixedIPs").add(builder);
        this.fixedIPs.add(builder);
    }
    return (A) this;
  }
  
  public A addToFixedIPs(int index,FixedIP item) {
    if (this.fixedIPs == null) {
      this.fixedIPs = new ArrayList();
    }
    FixedIPBuilder builder = new FixedIPBuilder(item);
    if (index < 0 || index >= fixedIPs.size()) {
        _visitables.get("fixedIPs").add(builder);
        fixedIPs.add(builder);
    } else {
        _visitables.get("fixedIPs").add(builder);
        fixedIPs.add(index, builder);
    }
    return (A) this;
  }
  
  public FixedIP buildFirstFixedIP() {
    return this.fixedIPs.get(0).build();
  }
  
  public FixedIP buildFixedIP(int index) {
    return this.fixedIPs.get(index).build();
  }
  
  public List<FixedIP> buildFixedIPs() {
    return this.fixedIPs != null ? build(fixedIPs) : null;
  }
  
  public FixedIP buildLastFixedIP() {
    return this.fixedIPs.get(fixedIPs.size() - 1).build();
  }
  
  public FixedIP buildMatchingFixedIP(Predicate<FixedIPBuilder> predicate) {
      for (FixedIPBuilder item : fixedIPs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkFilter buildNetwork() {
    return this.network != null ? this.network.build() : null;
  }
  
  protected void copyInstance(PortTarget instance) {
    instance = instance != null ? instance : new PortTarget();
    if (instance != null) {
        this.withFixedIPs(instance.getFixedIPs());
        this.withNetwork(instance.getNetwork());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FixedIPsNested<A> editFirstFixedIP() {
    if (fixedIPs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "fixedIPs"));
    }
    return this.setNewFixedIPLike(0, this.buildFixedIP(0));
  }
  
  public FixedIPsNested<A> editFixedIP(int index) {
    if (fixedIPs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "fixedIPs"));
    }
    return this.setNewFixedIPLike(index, this.buildFixedIP(index));
  }
  
  public FixedIPsNested<A> editLastFixedIP() {
    int index = fixedIPs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "fixedIPs"));
    }
    return this.setNewFixedIPLike(index, this.buildFixedIP(index));
  }
  
  public FixedIPsNested<A> editMatchingFixedIP(Predicate<FixedIPBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < fixedIPs.size();i++) {
      if (predicate.test(fixedIPs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "fixedIPs"));
    }
    return this.setNewFixedIPLike(index, this.buildFixedIP(index));
  }
  
  public NetworkNested<A> editNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(null));
  }
  
  public NetworkNested<A> editOrNewNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(new NetworkFilterBuilder().build()));
  }
  
  public NetworkNested<A> editOrNewNetworkLike(NetworkFilter item) {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(item));
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
    PortTargetFluent that = (PortTargetFluent) o;
    if (!(Objects.equals(fixedIPs, that.fixedIPs))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
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
  
  public boolean hasFixedIPs() {
    return this.fixedIPs != null && !(this.fixedIPs.isEmpty());
  }
  
  public boolean hasMatchingFixedIP(Predicate<FixedIPBuilder> predicate) {
      for (FixedIPBuilder item : fixedIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public int hashCode() {
    return Objects.hash(fixedIPs, network, additionalProperties);
  }
  
  public A removeAllFromFixedIPs(Collection<FixedIP> items) {
    if (this.fixedIPs == null) {
      return (A) this;
    }
    for (FixedIP item : items) {
        FixedIPBuilder builder = new FixedIPBuilder(item);
        _visitables.get("fixedIPs").remove(builder);
        this.fixedIPs.remove(builder);
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
  
  public A removeFromFixedIPs(FixedIP... items) {
    if (this.fixedIPs == null) {
      return (A) this;
    }
    for (FixedIP item : items) {
        FixedIPBuilder builder = new FixedIPBuilder(item);
        _visitables.get("fixedIPs").remove(builder);
        this.fixedIPs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFixedIPs(Predicate<FixedIPBuilder> predicate) {
    if (fixedIPs == null) {
      return (A) this;
    }
    Iterator<FixedIPBuilder> each = fixedIPs.iterator();
    List visitables = _visitables.get("fixedIPs");
    while (each.hasNext()) {
        FixedIPBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FixedIPsNested<A> setNewFixedIPLike(int index,FixedIP item) {
    return new FixedIPsNested(index, item);
  }
  
  public A setToFixedIPs(int index,FixedIP item) {
    if (this.fixedIPs == null) {
      this.fixedIPs = new ArrayList();
    }
    FixedIPBuilder builder = new FixedIPBuilder(item);
    if (index < 0 || index >= fixedIPs.size()) {
        _visitables.get("fixedIPs").add(builder);
        fixedIPs.add(builder);
    } else {
        _visitables.get("fixedIPs").add(builder);
        fixedIPs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(fixedIPs == null) && !(fixedIPs.isEmpty())) {
        sb.append("fixedIPs:");
        sb.append(fixedIPs);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
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
  
  public A withFixedIPs(List<FixedIP> fixedIPs) {
    if (this.fixedIPs != null) {
      this._visitables.get("fixedIPs").clear();
    }
    if (fixedIPs != null) {
        this.fixedIPs = new ArrayList();
        for (FixedIP item : fixedIPs) {
          this.addToFixedIPs(item);
        }
    } else {
      this.fixedIPs = null;
    }
    return (A) this;
  }
  
  public A withFixedIPs(FixedIP... fixedIPs) {
    if (this.fixedIPs != null) {
        this.fixedIPs.clear();
        _visitables.remove("fixedIPs");
    }
    if (fixedIPs != null) {
      for (FixedIP item : fixedIPs) {
        this.addToFixedIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withNetwork(NetworkFilter network) {
    this._visitables.remove("network");
    if (network != null) {
        this.network = new NetworkFilterBuilder(network);
        this._visitables.get("network").add(this.network);
    } else {
        this.network = null;
        this._visitables.get("network").remove(this.network);
    }
    return (A) this;
  }
  
  public NetworkNested<A> withNewNetwork() {
    return new NetworkNested(null);
  }
  
  public A withNewNetwork(String id,String name) {
    return (A) this.withNetwork(new NetworkFilter(id, name));
  }
  
  public NetworkNested<A> withNewNetworkLike(NetworkFilter item) {
    return new NetworkNested(item);
  }
  public class FixedIPsNested<N> extends FixedIPFluent<FixedIPsNested<N>> implements Nested<N>{
  
    FixedIPBuilder builder;
    int index;
  
    FixedIPsNested(int index,FixedIP item) {
      this.index = index;
      this.builder = new FixedIPBuilder(this, item);
    }
  
    public N and() {
      return (N) PortTargetFluent.this.setToFixedIPs(index, builder.build());
    }
    
    public N endFixedIP() {
      return and();
    }
    
  }
  public class NetworkNested<N> extends NetworkFilterFluent<NetworkNested<N>> implements Nested<N>{
  
    NetworkFilterBuilder builder;
  
    NetworkNested(NetworkFilter item) {
      this.builder = new NetworkFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) PortTargetFluent.this.withNetwork(builder.build());
    }
    
    public N endNetwork() {
      return and();
    }
    
  }
}