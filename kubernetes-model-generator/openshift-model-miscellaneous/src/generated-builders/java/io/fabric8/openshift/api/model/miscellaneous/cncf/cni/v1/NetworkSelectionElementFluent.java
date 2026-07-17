package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NetworkSelectionElementFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkSelectionElementFluent<A>> extends BaseFluent<A>{

  private String _interface;
  private Map<String,Object> additionalProperties;
  private BandwidthEntryBuilder bandwidth;
  private Map<String,Object> cniArgs;
  private List<String> defaultRoute = new ArrayList<String>();
  private String infinibandGuid;
  private String ipamClaimReference;
  private List<String> ips = new ArrayList<String>();
  private String mac;
  private String name;
  private String namespace;
  private ArrayList<PortMapEntryBuilder> portMappings = new ArrayList<PortMapEntryBuilder>();

  public NetworkSelectionElementFluent() {
  }
  
  public NetworkSelectionElementFluent(NetworkSelectionElement instance) {
    this.copyInstance(instance);
  }

  public A addAllToDefaultRoute(Collection<String> items) {
    if (this.defaultRoute == null) {
      this.defaultRoute = new ArrayList();
    }
    for (String item : items) {
      this.defaultRoute.add(item);
    }
    return (A) this;
  }
  
  public A addAllToIps(Collection<String> items) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    for (String item : items) {
      this.ips.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPortMappings(Collection<PortMapEntry> items) {
    if (this.portMappings == null) {
      this.portMappings = new ArrayList();
    }
    for (PortMapEntry item : items) {
        PortMapEntryBuilder builder = new PortMapEntryBuilder(item);
        _visitables.get("portMappings").add(builder);
        this.portMappings.add(builder);
    }
    return (A) this;
  }
  
  public PortMappingsNested<A> addNewPortMapping() {
    return new PortMappingsNested(-1, null);
  }
  
  public A addNewPortMapping(Integer containerPort,String hostIP,Integer hostPort,String protocol) {
    return (A) this.addToPortMappings(new PortMapEntry(containerPort, hostIP, hostPort, protocol));
  }
  
  public PortMappingsNested<A> addNewPortMappingLike(PortMapEntry item) {
    return new PortMappingsNested(-1, item);
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
  
  public A addToCniArgs(Map<String,Object> map) {
    if (this.cniArgs == null && map != null) {
      this.cniArgs = new LinkedHashMap();
    }
    if (map != null) {
      this.cniArgs.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCniArgs(String key,Object value) {
    if (this.cniArgs == null && key != null && value != null) {
      this.cniArgs = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.cniArgs.put(key, value);
    }
    return (A) this;
  }
  
  public A addToDefaultRoute(String... items) {
    if (this.defaultRoute == null) {
      this.defaultRoute = new ArrayList();
    }
    for (String item : items) {
      this.defaultRoute.add(item);
    }
    return (A) this;
  }
  
  public A addToDefaultRoute(int index,String item) {
    if (this.defaultRoute == null) {
      this.defaultRoute = new ArrayList();
    }
    this.defaultRoute.add(index, item);
    return (A) this;
  }
  
  public A addToIps(String... items) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    for (String item : items) {
      this.ips.add(item);
    }
    return (A) this;
  }
  
  public A addToIps(int index,String item) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    this.ips.add(index, item);
    return (A) this;
  }
  
  public A addToPortMappings(PortMapEntry... items) {
    if (this.portMappings == null) {
      this.portMappings = new ArrayList();
    }
    for (PortMapEntry item : items) {
        PortMapEntryBuilder builder = new PortMapEntryBuilder(item);
        _visitables.get("portMappings").add(builder);
        this.portMappings.add(builder);
    }
    return (A) this;
  }
  
  public A addToPortMappings(int index,PortMapEntry item) {
    if (this.portMappings == null) {
      this.portMappings = new ArrayList();
    }
    PortMapEntryBuilder builder = new PortMapEntryBuilder(item);
    if (index < 0 || index >= portMappings.size()) {
        _visitables.get("portMappings").add(builder);
        portMappings.add(builder);
    } else {
        _visitables.get("portMappings").add(builder);
        portMappings.add(index, builder);
    }
    return (A) this;
  }
  
  public BandwidthEntry buildBandwidth() {
    return this.bandwidth != null ? this.bandwidth.build() : null;
  }
  
  public PortMapEntry buildFirstPortMapping() {
    return this.portMappings.get(0).build();
  }
  
  public PortMapEntry buildLastPortMapping() {
    return this.portMappings.get(portMappings.size() - 1).build();
  }
  
  public PortMapEntry buildMatchingPortMapping(Predicate<PortMapEntryBuilder> predicate) {
      for (PortMapEntryBuilder item : portMappings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PortMapEntry buildPortMapping(int index) {
    return this.portMappings.get(index).build();
  }
  
  public List<PortMapEntry> buildPortMappings() {
    return this.portMappings != null ? build(portMappings) : null;
  }
  
  protected void copyInstance(NetworkSelectionElement instance) {
    instance = instance != null ? instance : new NetworkSelectionElement();
    if (instance != null) {
        this.withBandwidth(instance.getBandwidth());
        this.withCniArgs(instance.getCniArgs());
        this.withDefaultRoute(instance.getDefaultRoute());
        this.withInfinibandGuid(instance.getInfinibandGuid());
        this.withInterface(instance.getInterface());
        this.withIpamClaimReference(instance.getIpamClaimReference());
        this.withIps(instance.getIps());
        this.withMac(instance.getMac());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withPortMappings(instance.getPortMappings());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BandwidthNested<A> editBandwidth() {
    return this.withNewBandwidthLike(Optional.ofNullable(this.buildBandwidth()).orElse(null));
  }
  
  public PortMappingsNested<A> editFirstPortMapping() {
    if (portMappings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "portMappings"));
    }
    return this.setNewPortMappingLike(0, this.buildPortMapping(0));
  }
  
  public PortMappingsNested<A> editLastPortMapping() {
    int index = portMappings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "portMappings"));
    }
    return this.setNewPortMappingLike(index, this.buildPortMapping(index));
  }
  
  public PortMappingsNested<A> editMatchingPortMapping(Predicate<PortMapEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < portMappings.size();i++) {
      if (predicate.test(portMappings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "portMappings"));
    }
    return this.setNewPortMappingLike(index, this.buildPortMapping(index));
  }
  
  public BandwidthNested<A> editOrNewBandwidth() {
    return this.withNewBandwidthLike(Optional.ofNullable(this.buildBandwidth()).orElse(new BandwidthEntryBuilder().build()));
  }
  
  public BandwidthNested<A> editOrNewBandwidthLike(BandwidthEntry item) {
    return this.withNewBandwidthLike(Optional.ofNullable(this.buildBandwidth()).orElse(item));
  }
  
  public PortMappingsNested<A> editPortMapping(int index) {
    if (portMappings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "portMappings"));
    }
    return this.setNewPortMappingLike(index, this.buildPortMapping(index));
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
    NetworkSelectionElementFluent that = (NetworkSelectionElementFluent) o;
    if (!(Objects.equals(bandwidth, that.bandwidth))) {
      return false;
    }
    if (!(Objects.equals(cniArgs, that.cniArgs))) {
      return false;
    }
    if (!(Objects.equals(defaultRoute, that.defaultRoute))) {
      return false;
    }
    if (!(Objects.equals(infinibandGuid, that.infinibandGuid))) {
      return false;
    }
    if (!(Objects.equals(_interface, that._interface))) {
      return false;
    }
    if (!(Objects.equals(ipamClaimReference, that.ipamClaimReference))) {
      return false;
    }
    if (!(Objects.equals(ips, that.ips))) {
      return false;
    }
    if (!(Objects.equals(mac, that.mac))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(portMappings, that.portMappings))) {
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
  
  public Map<String,Object> getCniArgs() {
    return this.cniArgs;
  }
  
  public List<String> getDefaultRoute() {
    return this.defaultRoute;
  }
  
  public String getDefaultRoute(int index) {
    return this.defaultRoute.get(index);
  }
  
  public String getFirstDefaultRoute() {
    return this.defaultRoute.get(0);
  }
  
  public String getFirstIp() {
    return this.ips.get(0);
  }
  
  public String getInfinibandGuid() {
    return this.infinibandGuid;
  }
  
  public String getInterface() {
    return this._interface;
  }
  
  public String getIp(int index) {
    return this.ips.get(index);
  }
  
  public String getIpamClaimReference() {
    return this.ipamClaimReference;
  }
  
  public List<String> getIps() {
    return this.ips;
  }
  
  public String getLastDefaultRoute() {
    return this.defaultRoute.get(defaultRoute.size() - 1);
  }
  
  public String getLastIp() {
    return this.ips.get(ips.size() - 1);
  }
  
  public String getMac() {
    return this.mac;
  }
  
  public String getMatchingDefaultRoute(Predicate<String> predicate) {
      for (String item : defaultRoute) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIp(Predicate<String> predicate) {
      for (String item : ips) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBandwidth() {
    return this.bandwidth != null;
  }
  
  public boolean hasCniArgs() {
    return this.cniArgs != null;
  }
  
  public boolean hasDefaultRoute() {
    return this.defaultRoute != null && !(this.defaultRoute.isEmpty());
  }
  
  public boolean hasInfinibandGuid() {
    return this.infinibandGuid != null;
  }
  
  public boolean hasInterface() {
    return this._interface != null;
  }
  
  public boolean hasIpamClaimReference() {
    return this.ipamClaimReference != null;
  }
  
  public boolean hasIps() {
    return this.ips != null && !(this.ips.isEmpty());
  }
  
  public boolean hasMac() {
    return this.mac != null;
  }
  
  public boolean hasMatchingDefaultRoute(Predicate<String> predicate) {
      for (String item : defaultRoute) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIp(Predicate<String> predicate) {
      for (String item : ips) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPortMapping(Predicate<PortMapEntryBuilder> predicate) {
      for (PortMapEntryBuilder item : portMappings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasPortMappings() {
    return this.portMappings != null && !(this.portMappings.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(bandwidth, cniArgs, defaultRoute, infinibandGuid, _interface, ipamClaimReference, ips, mac, name, namespace, portMappings, additionalProperties);
  }
  
  public A removeAllFromDefaultRoute(Collection<String> items) {
    if (this.defaultRoute == null) {
      return (A) this;
    }
    for (String item : items) {
      this.defaultRoute.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromIps(Collection<String> items) {
    if (this.ips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ips.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPortMappings(Collection<PortMapEntry> items) {
    if (this.portMappings == null) {
      return (A) this;
    }
    for (PortMapEntry item : items) {
        PortMapEntryBuilder builder = new PortMapEntryBuilder(item);
        _visitables.get("portMappings").remove(builder);
        this.portMappings.remove(builder);
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
  
  public A removeFromCniArgs(String key) {
    if (this.cniArgs == null) {
      return (A) this;
    }
    if (key != null && this.cniArgs != null) {
      this.cniArgs.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCniArgs(Map<String,Object> map) {
    if (this.cniArgs == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.cniArgs != null) {
          this.cniArgs.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromDefaultRoute(String... items) {
    if (this.defaultRoute == null) {
      return (A) this;
    }
    for (String item : items) {
      this.defaultRoute.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromIps(String... items) {
    if (this.ips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ips.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPortMappings(PortMapEntry... items) {
    if (this.portMappings == null) {
      return (A) this;
    }
    for (PortMapEntry item : items) {
        PortMapEntryBuilder builder = new PortMapEntryBuilder(item);
        _visitables.get("portMappings").remove(builder);
        this.portMappings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPortMappings(Predicate<PortMapEntryBuilder> predicate) {
    if (portMappings == null) {
      return (A) this;
    }
    Iterator<PortMapEntryBuilder> each = portMappings.iterator();
    List visitables = _visitables.get("portMappings");
    while (each.hasNext()) {
        PortMapEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PortMappingsNested<A> setNewPortMappingLike(int index,PortMapEntry item) {
    return new PortMappingsNested(index, item);
  }
  
  public A setToDefaultRoute(int index,String item) {
    if (this.defaultRoute == null) {
      this.defaultRoute = new ArrayList();
    }
    this.defaultRoute.set(index, item);
    return (A) this;
  }
  
  public A setToIps(int index,String item) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    this.ips.set(index, item);
    return (A) this;
  }
  
  public A setToPortMappings(int index,PortMapEntry item) {
    if (this.portMappings == null) {
      this.portMappings = new ArrayList();
    }
    PortMapEntryBuilder builder = new PortMapEntryBuilder(item);
    if (index < 0 || index >= portMappings.size()) {
        _visitables.get("portMappings").add(builder);
        portMappings.add(builder);
    } else {
        _visitables.get("portMappings").add(builder);
        portMappings.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bandwidth == null)) {
        sb.append("bandwidth:");
        sb.append(bandwidth);
        sb.append(",");
    }
    if (!(cniArgs == null) && !(cniArgs.isEmpty())) {
        sb.append("cniArgs:");
        sb.append(cniArgs);
        sb.append(",");
    }
    if (!(defaultRoute == null) && !(defaultRoute.isEmpty())) {
        sb.append("defaultRoute:");
        sb.append(defaultRoute);
        sb.append(",");
    }
    if (!(infinibandGuid == null)) {
        sb.append("infinibandGuid:");
        sb.append(infinibandGuid);
        sb.append(",");
    }
    if (!(_interface == null)) {
        sb.append("_interface:");
        sb.append(_interface);
        sb.append(",");
    }
    if (!(ipamClaimReference == null)) {
        sb.append("ipamClaimReference:");
        sb.append(ipamClaimReference);
        sb.append(",");
    }
    if (!(ips == null) && !(ips.isEmpty())) {
        sb.append("ips:");
        sb.append(ips);
        sb.append(",");
    }
    if (!(mac == null)) {
        sb.append("mac:");
        sb.append(mac);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(portMappings == null) && !(portMappings.isEmpty())) {
        sb.append("portMappings:");
        sb.append(portMappings);
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
  
  public A withBandwidth(BandwidthEntry bandwidth) {
    this._visitables.remove("bandwidth");
    if (bandwidth != null) {
        this.bandwidth = new BandwidthEntryBuilder(bandwidth);
        this._visitables.get("bandwidth").add(this.bandwidth);
    } else {
        this.bandwidth = null;
        this._visitables.get("bandwidth").remove(this.bandwidth);
    }
    return (A) this;
  }
  
  public <K,V>A withCniArgs(Map<String,Object> cniArgs) {
    if (cniArgs == null) {
      this.cniArgs = null;
    } else {
      this.cniArgs = new LinkedHashMap(cniArgs);
    }
    return (A) this;
  }
  
  public A withDefaultRoute(List<String> defaultRoute) {
    if (defaultRoute != null) {
        this.defaultRoute = new ArrayList();
        for (String item : defaultRoute) {
          this.addToDefaultRoute(item);
        }
    } else {
      this.defaultRoute = null;
    }
    return (A) this;
  }
  
  public A withDefaultRoute(String... defaultRoute) {
    if (this.defaultRoute != null) {
        this.defaultRoute.clear();
        _visitables.remove("defaultRoute");
    }
    if (defaultRoute != null) {
      for (String item : defaultRoute) {
        this.addToDefaultRoute(item);
      }
    }
    return (A) this;
  }
  
  public A withInfinibandGuid(String infinibandGuid) {
    this.infinibandGuid = infinibandGuid;
    return (A) this;
  }
  
  public A withInterface(String _interface) {
    this._interface = _interface;
    return (A) this;
  }
  
  public A withIpamClaimReference(String ipamClaimReference) {
    this.ipamClaimReference = ipamClaimReference;
    return (A) this;
  }
  
  public A withIps(List<String> ips) {
    if (ips != null) {
        this.ips = new ArrayList();
        for (String item : ips) {
          this.addToIps(item);
        }
    } else {
      this.ips = null;
    }
    return (A) this;
  }
  
  public A withIps(String... ips) {
    if (this.ips != null) {
        this.ips.clear();
        _visitables.remove("ips");
    }
    if (ips != null) {
      for (String item : ips) {
        this.addToIps(item);
      }
    }
    return (A) this;
  }
  
  public A withMac(String mac) {
    this.mac = mac;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public BandwidthNested<A> withNewBandwidth() {
    return new BandwidthNested(null);
  }
  
  public A withNewBandwidth(Integer egressBurst,Integer egressRate,Integer ingressBurst,Integer ingressRate) {
    return (A) this.withBandwidth(new BandwidthEntry(egressBurst, egressRate, ingressBurst, ingressRate));
  }
  
  public BandwidthNested<A> withNewBandwidthLike(BandwidthEntry item) {
    return new BandwidthNested(item);
  }
  
  public A withPortMappings(List<PortMapEntry> portMappings) {
    if (this.portMappings != null) {
      this._visitables.get("portMappings").clear();
    }
    if (portMappings != null) {
        this.portMappings = new ArrayList();
        for (PortMapEntry item : portMappings) {
          this.addToPortMappings(item);
        }
    } else {
      this.portMappings = null;
    }
    return (A) this;
  }
  
  public A withPortMappings(PortMapEntry... portMappings) {
    if (this.portMappings != null) {
        this.portMappings.clear();
        _visitables.remove("portMappings");
    }
    if (portMappings != null) {
      for (PortMapEntry item : portMappings) {
        this.addToPortMappings(item);
      }
    }
    return (A) this;
  }
  public class BandwidthNested<N> extends BandwidthEntryFluent<BandwidthNested<N>> implements Nested<N>{
  
    BandwidthEntryBuilder builder;
  
    BandwidthNested(BandwidthEntry item) {
      this.builder = new BandwidthEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSelectionElementFluent.this.withBandwidth(builder.build());
    }
    
    public N endBandwidth() {
      return and();
    }
    
  }
  public class PortMappingsNested<N> extends PortMapEntryFluent<PortMappingsNested<N>> implements Nested<N>{
  
    PortMapEntryBuilder builder;
    int index;
  
    PortMappingsNested(int index,PortMapEntry item) {
      this.index = index;
      this.builder = new PortMapEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSelectionElementFluent.this.setToPortMappings(index, builder.build());
    }
    
    public N endPortMapping() {
      return and();
    }
    
  }
}