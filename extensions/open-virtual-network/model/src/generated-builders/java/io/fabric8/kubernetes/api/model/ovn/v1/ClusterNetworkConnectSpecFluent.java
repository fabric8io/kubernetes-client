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
public class ClusterNetworkConnectSpecFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.ClusterNetworkConnectSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ConnectSubnetBuilder> connectSubnets = new ArrayList<ConnectSubnetBuilder>();
  private List<String> connectivity = new ArrayList<String>();
  private ArrayList<NetworkSelectorBuilder> networkSelectors = new ArrayList<NetworkSelectorBuilder>();

  public ClusterNetworkConnectSpecFluent() {
  }
  
  public ClusterNetworkConnectSpecFluent(ClusterNetworkConnectSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToConnectSubnets(Collection<ConnectSubnet> items) {
    if (this.connectSubnets == null) {
      this.connectSubnets = new ArrayList();
    }
    for (ConnectSubnet item : items) {
        ConnectSubnetBuilder builder = new ConnectSubnetBuilder(item);
        _visitables.get("connectSubnets").add(builder);
        this.connectSubnets.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConnectivity(Collection<String> items) {
    if (this.connectivity == null) {
      this.connectivity = new ArrayList();
    }
    for (String item : items) {
      this.connectivity.add(item);
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
  
  public ConnectSubnetsNested<A> addNewConnectSubnet() {
    return new ConnectSubnetsNested(-1, null);
  }
  
  public A addNewConnectSubnet(String cidr,Integer networkPrefix) {
    return (A) this.addToConnectSubnets(new ConnectSubnet(cidr, networkPrefix));
  }
  
  public ConnectSubnetsNested<A> addNewConnectSubnetLike(ConnectSubnet item) {
    return new ConnectSubnetsNested(-1, item);
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
  
  public A addToConnectSubnets(ConnectSubnet... items) {
    if (this.connectSubnets == null) {
      this.connectSubnets = new ArrayList();
    }
    for (ConnectSubnet item : items) {
        ConnectSubnetBuilder builder = new ConnectSubnetBuilder(item);
        _visitables.get("connectSubnets").add(builder);
        this.connectSubnets.add(builder);
    }
    return (A) this;
  }
  
  public A addToConnectSubnets(int index,ConnectSubnet item) {
    if (this.connectSubnets == null) {
      this.connectSubnets = new ArrayList();
    }
    ConnectSubnetBuilder builder = new ConnectSubnetBuilder(item);
    if (index < 0 || index >= connectSubnets.size()) {
        _visitables.get("connectSubnets").add(builder);
        connectSubnets.add(builder);
    } else {
        _visitables.get("connectSubnets").add(builder);
        connectSubnets.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConnectivity(String... items) {
    if (this.connectivity == null) {
      this.connectivity = new ArrayList();
    }
    for (String item : items) {
      this.connectivity.add(item);
    }
    return (A) this;
  }
  
  public A addToConnectivity(int index,String item) {
    if (this.connectivity == null) {
      this.connectivity = new ArrayList();
    }
    this.connectivity.add(index, item);
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
  
  public ConnectSubnet buildConnectSubnet(int index) {
    return this.connectSubnets.get(index).build();
  }
  
  public List<ConnectSubnet> buildConnectSubnets() {
    return this.connectSubnets != null ? build(connectSubnets) : null;
  }
  
  public ConnectSubnet buildFirstConnectSubnet() {
    return this.connectSubnets.get(0).build();
  }
  
  public NetworkSelector buildFirstNetworkSelector() {
    return this.networkSelectors.get(0).build();
  }
  
  public ConnectSubnet buildLastConnectSubnet() {
    return this.connectSubnets.get(connectSubnets.size() - 1).build();
  }
  
  public NetworkSelector buildLastNetworkSelector() {
    return this.networkSelectors.get(networkSelectors.size() - 1).build();
  }
  
  public ConnectSubnet buildMatchingConnectSubnet(Predicate<ConnectSubnetBuilder> predicate) {
      for (ConnectSubnetBuilder item : connectSubnets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
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
  
  protected void copyInstance(ClusterNetworkConnectSpec instance) {
    instance = instance != null ? instance : new ClusterNetworkConnectSpec();
    if (instance != null) {
        this.withConnectSubnets(instance.getConnectSubnets());
        this.withConnectivity(instance.getConnectivity());
        this.withNetworkSelectors(instance.getNetworkSelectors());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConnectSubnetsNested<A> editConnectSubnet(int index) {
    if (connectSubnets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "connectSubnets"));
    }
    return this.setNewConnectSubnetLike(index, this.buildConnectSubnet(index));
  }
  
  public ConnectSubnetsNested<A> editFirstConnectSubnet() {
    if (connectSubnets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "connectSubnets"));
    }
    return this.setNewConnectSubnetLike(0, this.buildConnectSubnet(0));
  }
  
  public NetworkSelectorsNested<A> editFirstNetworkSelector() {
    if (networkSelectors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "networkSelectors"));
    }
    return this.setNewNetworkSelectorLike(0, this.buildNetworkSelector(0));
  }
  
  public ConnectSubnetsNested<A> editLastConnectSubnet() {
    int index = connectSubnets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "connectSubnets"));
    }
    return this.setNewConnectSubnetLike(index, this.buildConnectSubnet(index));
  }
  
  public NetworkSelectorsNested<A> editLastNetworkSelector() {
    int index = networkSelectors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "networkSelectors"));
    }
    return this.setNewNetworkSelectorLike(index, this.buildNetworkSelector(index));
  }
  
  public ConnectSubnetsNested<A> editMatchingConnectSubnet(Predicate<ConnectSubnetBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < connectSubnets.size();i++) {
      if (predicate.test(connectSubnets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "connectSubnets"));
    }
    return this.setNewConnectSubnetLike(index, this.buildConnectSubnet(index));
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
    ClusterNetworkConnectSpecFluent that = (ClusterNetworkConnectSpecFluent) o;
    if (!(Objects.equals(connectSubnets, that.connectSubnets))) {
      return false;
    }
    if (!(Objects.equals(connectivity, that.connectivity))) {
      return false;
    }
    if (!(Objects.equals(networkSelectors, that.networkSelectors))) {
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
  
  public List<String> getConnectivity() {
    return this.connectivity;
  }
  
  public String getConnectivity(int index) {
    return this.connectivity.get(index);
  }
  
  public String getFirstConnectivity() {
    return this.connectivity.get(0);
  }
  
  public String getLastConnectivity() {
    return this.connectivity.get(connectivity.size() - 1);
  }
  
  public String getMatchingConnectivity(Predicate<String> predicate) {
      for (String item : connectivity) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConnectSubnets() {
    return this.connectSubnets != null && !(this.connectSubnets.isEmpty());
  }
  
  public boolean hasConnectivity() {
    return this.connectivity != null && !(this.connectivity.isEmpty());
  }
  
  public boolean hasMatchingConnectSubnet(Predicate<ConnectSubnetBuilder> predicate) {
      for (ConnectSubnetBuilder item : connectSubnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingConnectivity(Predicate<String> predicate) {
      for (String item : connectivity) {
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
  
  public int hashCode() {
    return Objects.hash(connectSubnets, connectivity, networkSelectors, additionalProperties);
  }
  
  public A removeAllFromConnectSubnets(Collection<ConnectSubnet> items) {
    if (this.connectSubnets == null) {
      return (A) this;
    }
    for (ConnectSubnet item : items) {
        ConnectSubnetBuilder builder = new ConnectSubnetBuilder(item);
        _visitables.get("connectSubnets").remove(builder);
        this.connectSubnets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConnectivity(Collection<String> items) {
    if (this.connectivity == null) {
      return (A) this;
    }
    for (String item : items) {
      this.connectivity.remove(item);
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
  
  public A removeFromConnectSubnets(ConnectSubnet... items) {
    if (this.connectSubnets == null) {
      return (A) this;
    }
    for (ConnectSubnet item : items) {
        ConnectSubnetBuilder builder = new ConnectSubnetBuilder(item);
        _visitables.get("connectSubnets").remove(builder);
        this.connectSubnets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConnectivity(String... items) {
    if (this.connectivity == null) {
      return (A) this;
    }
    for (String item : items) {
      this.connectivity.remove(item);
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
  
  public A removeMatchingFromConnectSubnets(Predicate<ConnectSubnetBuilder> predicate) {
    if (connectSubnets == null) {
      return (A) this;
    }
    Iterator<ConnectSubnetBuilder> each = connectSubnets.iterator();
    List visitables = _visitables.get("connectSubnets");
    while (each.hasNext()) {
        ConnectSubnetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public ConnectSubnetsNested<A> setNewConnectSubnetLike(int index,ConnectSubnet item) {
    return new ConnectSubnetsNested(index, item);
  }
  
  public NetworkSelectorsNested<A> setNewNetworkSelectorLike(int index,NetworkSelector item) {
    return new NetworkSelectorsNested(index, item);
  }
  
  public A setToConnectSubnets(int index,ConnectSubnet item) {
    if (this.connectSubnets == null) {
      this.connectSubnets = new ArrayList();
    }
    ConnectSubnetBuilder builder = new ConnectSubnetBuilder(item);
    if (index < 0 || index >= connectSubnets.size()) {
        _visitables.get("connectSubnets").add(builder);
        connectSubnets.add(builder);
    } else {
        _visitables.get("connectSubnets").add(builder);
        connectSubnets.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConnectivity(int index,String item) {
    if (this.connectivity == null) {
      this.connectivity = new ArrayList();
    }
    this.connectivity.set(index, item);
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
    if (!(connectSubnets == null) && !(connectSubnets.isEmpty())) {
        sb.append("connectSubnets:");
        sb.append(connectSubnets);
        sb.append(",");
    }
    if (!(connectivity == null) && !(connectivity.isEmpty())) {
        sb.append("connectivity:");
        sb.append(connectivity);
        sb.append(",");
    }
    if (!(networkSelectors == null) && !(networkSelectors.isEmpty())) {
        sb.append("networkSelectors:");
        sb.append(networkSelectors);
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
  
  public A withConnectSubnets(List<ConnectSubnet> connectSubnets) {
    if (this.connectSubnets != null) {
      this._visitables.get("connectSubnets").clear();
    }
    if (connectSubnets != null) {
        this.connectSubnets = new ArrayList();
        for (ConnectSubnet item : connectSubnets) {
          this.addToConnectSubnets(item);
        }
    } else {
      this.connectSubnets = null;
    }
    return (A) this;
  }
  
  public A withConnectSubnets(ConnectSubnet... connectSubnets) {
    if (this.connectSubnets != null) {
        this.connectSubnets.clear();
        _visitables.remove("connectSubnets");
    }
    if (connectSubnets != null) {
      for (ConnectSubnet item : connectSubnets) {
        this.addToConnectSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withConnectivity(List<String> connectivity) {
    if (connectivity != null) {
        this.connectivity = new ArrayList();
        for (String item : connectivity) {
          this.addToConnectivity(item);
        }
    } else {
      this.connectivity = null;
    }
    return (A) this;
  }
  
  public A withConnectivity(String... connectivity) {
    if (this.connectivity != null) {
        this.connectivity.clear();
        _visitables.remove("connectivity");
    }
    if (connectivity != null) {
      for (String item : connectivity) {
        this.addToConnectivity(item);
      }
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
  public class ConnectSubnetsNested<N> extends ConnectSubnetFluent<ConnectSubnetsNested<N>> implements Nested<N>{
  
    ConnectSubnetBuilder builder;
    int index;
  
    ConnectSubnetsNested(int index,ConnectSubnet item) {
      this.index = index;
      this.builder = new ConnectSubnetBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterNetworkConnectSpecFluent.this.setToConnectSubnets(index, builder.build());
    }
    
    public N endConnectSubnet() {
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
      return (N) ClusterNetworkConnectSpecFluent.this.setToNetworkSelectors(index, builder.build());
    }
    
    public N endNetworkSelector() {
      return and();
    }
    
  }
}