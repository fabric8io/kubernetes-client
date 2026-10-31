package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class LocalnetConfigFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.LocalnetConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> excludeSubnets = new ArrayList<String>();
  private IPAMConfigBuilder ipam;
  private MACSecurityConfigBuilder macSecurity;
  private Integer mtu;
  private String physicalNetworkName;
  private String role;
  private List<String> subnets = new ArrayList<String>();
  private VLANConfigBuilder vlan;

  public LocalnetConfigFluent() {
  }
  
  public LocalnetConfigFluent(LocalnetConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToExcludeSubnets(Collection<String> items) {
    if (this.excludeSubnets == null) {
      this.excludeSubnets = new ArrayList();
    }
    for (String item : items) {
      this.excludeSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSubnets(Collection<String> items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (String item : items) {
      this.subnets.add(item);
    }
    return (A) this;
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
  
  public A addToExcludeSubnets(String... items) {
    if (this.excludeSubnets == null) {
      this.excludeSubnets = new ArrayList();
    }
    for (String item : items) {
      this.excludeSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addToExcludeSubnets(int index,String item) {
    if (this.excludeSubnets == null) {
      this.excludeSubnets = new ArrayList();
    }
    this.excludeSubnets.add(index, item);
    return (A) this;
  }
  
  public A addToSubnets(String... items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (String item : items) {
      this.subnets.add(item);
    }
    return (A) this;
  }
  
  public A addToSubnets(int index,String item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    this.subnets.add(index, item);
    return (A) this;
  }
  
  public IPAMConfig buildIpam() {
    return this.ipam != null ? this.ipam.build() : null;
  }
  
  public MACSecurityConfig buildMacSecurity() {
    return this.macSecurity != null ? this.macSecurity.build() : null;
  }
  
  public VLANConfig buildVlan() {
    return this.vlan != null ? this.vlan.build() : null;
  }
  
  protected void copyInstance(LocalnetConfig instance) {
    instance = instance != null ? instance : new LocalnetConfig();
    if (instance != null) {
        this.withExcludeSubnets(instance.getExcludeSubnets());
        this.withIpam(instance.getIpam());
        this.withMacSecurity(instance.getMacSecurity());
        this.withMtu(instance.getMtu());
        this.withPhysicalNetworkName(instance.getPhysicalNetworkName());
        this.withRole(instance.getRole());
        this.withSubnets(instance.getSubnets());
        this.withVlan(instance.getVlan());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IpamNested<A> editIpam() {
    return this.withNewIpamLike(Optional.ofNullable(this.buildIpam()).orElse(null));
  }
  
  public MacSecurityNested<A> editMacSecurity() {
    return this.withNewMacSecurityLike(Optional.ofNullable(this.buildMacSecurity()).orElse(null));
  }
  
  public IpamNested<A> editOrNewIpam() {
    return this.withNewIpamLike(Optional.ofNullable(this.buildIpam()).orElse(new IPAMConfigBuilder().build()));
  }
  
  public IpamNested<A> editOrNewIpamLike(IPAMConfig item) {
    return this.withNewIpamLike(Optional.ofNullable(this.buildIpam()).orElse(item));
  }
  
  public MacSecurityNested<A> editOrNewMacSecurity() {
    return this.withNewMacSecurityLike(Optional.ofNullable(this.buildMacSecurity()).orElse(new MACSecurityConfigBuilder().build()));
  }
  
  public MacSecurityNested<A> editOrNewMacSecurityLike(MACSecurityConfig item) {
    return this.withNewMacSecurityLike(Optional.ofNullable(this.buildMacSecurity()).orElse(item));
  }
  
  public VlanNested<A> editOrNewVlan() {
    return this.withNewVlanLike(Optional.ofNullable(this.buildVlan()).orElse(new VLANConfigBuilder().build()));
  }
  
  public VlanNested<A> editOrNewVlanLike(VLANConfig item) {
    return this.withNewVlanLike(Optional.ofNullable(this.buildVlan()).orElse(item));
  }
  
  public VlanNested<A> editVlan() {
    return this.withNewVlanLike(Optional.ofNullable(this.buildVlan()).orElse(null));
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
    LocalnetConfigFluent that = (LocalnetConfigFluent) o;
    if (!(Objects.equals(excludeSubnets, that.excludeSubnets))) {
      return false;
    }
    if (!(Objects.equals(ipam, that.ipam))) {
      return false;
    }
    if (!(Objects.equals(macSecurity, that.macSecurity))) {
      return false;
    }
    if (!(Objects.equals(mtu, that.mtu))) {
      return false;
    }
    if (!(Objects.equals(physicalNetworkName, that.physicalNetworkName))) {
      return false;
    }
    if (!(Objects.equals(role, that.role))) {
      return false;
    }
    if (!(Objects.equals(subnets, that.subnets))) {
      return false;
    }
    if (!(Objects.equals(vlan, that.vlan))) {
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
  
  public String getExcludeSubnet(int index) {
    return this.excludeSubnets.get(index);
  }
  
  public List<String> getExcludeSubnets() {
    return this.excludeSubnets;
  }
  
  public String getFirstExcludeSubnet() {
    return this.excludeSubnets.get(0);
  }
  
  public String getFirstSubnet() {
    return this.subnets.get(0);
  }
  
  public String getLastExcludeSubnet() {
    return this.excludeSubnets.get(excludeSubnets.size() - 1);
  }
  
  public String getLastSubnet() {
    return this.subnets.get(subnets.size() - 1);
  }
  
  public String getMatchingExcludeSubnet(Predicate<String> predicate) {
      for (String item : excludeSubnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSubnet(Predicate<String> predicate) {
      for (String item : subnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMtu() {
    return this.mtu;
  }
  
  public String getPhysicalNetworkName() {
    return this.physicalNetworkName;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public String getSubnet(int index) {
    return this.subnets.get(index);
  }
  
  public List<String> getSubnets() {
    return this.subnets;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExcludeSubnets() {
    return this.excludeSubnets != null && !(this.excludeSubnets.isEmpty());
  }
  
  public boolean hasIpam() {
    return this.ipam != null;
  }
  
  public boolean hasMacSecurity() {
    return this.macSecurity != null;
  }
  
  public boolean hasMatchingExcludeSubnet(Predicate<String> predicate) {
      for (String item : excludeSubnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubnet(Predicate<String> predicate) {
      for (String item : subnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMtu() {
    return this.mtu != null;
  }
  
  public boolean hasPhysicalNetworkName() {
    return this.physicalNetworkName != null;
  }
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public boolean hasVlan() {
    return this.vlan != null;
  }
  
  public int hashCode() {
    return Objects.hash(excludeSubnets, ipam, macSecurity, mtu, physicalNetworkName, role, subnets, vlan, additionalProperties);
  }
  
  public A removeAllFromExcludeSubnets(Collection<String> items) {
    if (this.excludeSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.excludeSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSubnets(Collection<String> items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subnets.remove(item);
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
  
  public A removeFromExcludeSubnets(String... items) {
    if (this.excludeSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.excludeSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSubnets(String... items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subnets.remove(item);
    }
    return (A) this;
  }
  
  public A setToExcludeSubnets(int index,String item) {
    if (this.excludeSubnets == null) {
      this.excludeSubnets = new ArrayList();
    }
    this.excludeSubnets.set(index, item);
    return (A) this;
  }
  
  public A setToSubnets(int index,String item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    this.subnets.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(excludeSubnets == null) && !(excludeSubnets.isEmpty())) {
        sb.append("excludeSubnets:");
        sb.append(excludeSubnets);
        sb.append(",");
    }
    if (!(ipam == null)) {
        sb.append("ipam:");
        sb.append(ipam);
        sb.append(",");
    }
    if (!(macSecurity == null)) {
        sb.append("macSecurity:");
        sb.append(macSecurity);
        sb.append(",");
    }
    if (!(mtu == null)) {
        sb.append("mtu:");
        sb.append(mtu);
        sb.append(",");
    }
    if (!(physicalNetworkName == null)) {
        sb.append("physicalNetworkName:");
        sb.append(physicalNetworkName);
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
    if (!(vlan == null)) {
        sb.append("vlan:");
        sb.append(vlan);
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
  
  public A withExcludeSubnets(List<String> excludeSubnets) {
    if (excludeSubnets != null) {
        this.excludeSubnets = new ArrayList();
        for (String item : excludeSubnets) {
          this.addToExcludeSubnets(item);
        }
    } else {
      this.excludeSubnets = null;
    }
    return (A) this;
  }
  
  public A withExcludeSubnets(String... excludeSubnets) {
    if (this.excludeSubnets != null) {
        this.excludeSubnets.clear();
        _visitables.remove("excludeSubnets");
    }
    if (excludeSubnets != null) {
      for (String item : excludeSubnets) {
        this.addToExcludeSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withIpam(IPAMConfig ipam) {
    this._visitables.remove("ipam");
    if (ipam != null) {
        this.ipam = new IPAMConfigBuilder(ipam);
        this._visitables.get("ipam").add(this.ipam);
    } else {
        this.ipam = null;
        this._visitables.get("ipam").remove(this.ipam);
    }
    return (A) this;
  }
  
  public A withMacSecurity(MACSecurityConfig macSecurity) {
    this._visitables.remove("macSecurity");
    if (macSecurity != null) {
        this.macSecurity = new MACSecurityConfigBuilder(macSecurity);
        this._visitables.get("macSecurity").add(this.macSecurity);
    } else {
        this.macSecurity = null;
        this._visitables.get("macSecurity").remove(this.macSecurity);
    }
    return (A) this;
  }
  
  public A withMtu(Integer mtu) {
    this.mtu = mtu;
    return (A) this;
  }
  
  public IpamNested<A> withNewIpam() {
    return new IpamNested(null);
  }
  
  public A withNewIpam(String lifecycle,String mode) {
    return (A) this.withIpam(new IPAMConfig(lifecycle, mode));
  }
  
  public IpamNested<A> withNewIpamLike(IPAMConfig item) {
    return new IpamNested(item);
  }
  
  public MacSecurityNested<A> withNewMacSecurity() {
    return new MacSecurityNested(null);
  }
  
  public A withNewMacSecurity(String mode) {
    return (A) this.withMacSecurity(new MACSecurityConfig(mode));
  }
  
  public MacSecurityNested<A> withNewMacSecurityLike(MACSecurityConfig item) {
    return new MacSecurityNested(item);
  }
  
  public VlanNested<A> withNewVlan() {
    return new VlanNested(null);
  }
  
  public VlanNested<A> withNewVlanLike(VLANConfig item) {
    return new VlanNested(item);
  }
  
  public A withPhysicalNetworkName(String physicalNetworkName) {
    this.physicalNetworkName = physicalNetworkName;
    return (A) this;
  }
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  
  public A withSubnets(List<String> subnets) {
    if (subnets != null) {
        this.subnets = new ArrayList();
        for (String item : subnets) {
          this.addToSubnets(item);
        }
    } else {
      this.subnets = null;
    }
    return (A) this;
  }
  
  public A withSubnets(String... subnets) {
    if (this.subnets != null) {
        this.subnets.clear();
        _visitables.remove("subnets");
    }
    if (subnets != null) {
      for (String item : subnets) {
        this.addToSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withVlan(VLANConfig vlan) {
    this._visitables.remove("vlan");
    if (vlan != null) {
        this.vlan = new VLANConfigBuilder(vlan);
        this._visitables.get("vlan").add(this.vlan);
    } else {
        this.vlan = null;
        this._visitables.get("vlan").remove(this.vlan);
    }
    return (A) this;
  }
  public class IpamNested<N> extends IPAMConfigFluent<IpamNested<N>> implements Nested<N>{
  
    IPAMConfigBuilder builder;
  
    IpamNested(IPAMConfig item) {
      this.builder = new IPAMConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) LocalnetConfigFluent.this.withIpam(builder.build());
    }
    
    public N endIpam() {
      return and();
    }
    
  }
  public class MacSecurityNested<N> extends MACSecurityConfigFluent<MacSecurityNested<N>> implements Nested<N>{
  
    MACSecurityConfigBuilder builder;
  
    MacSecurityNested(MACSecurityConfig item) {
      this.builder = new MACSecurityConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) LocalnetConfigFluent.this.withMacSecurity(builder.build());
    }
    
    public N endMacSecurity() {
      return and();
    }
    
  }
  public class VlanNested<N> extends VLANConfigFluent<VlanNested<N>> implements Nested<N>{
  
    VLANConfigBuilder builder;
  
    VlanNested(VLANConfig item) {
      this.builder = new VLANConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) LocalnetConfigFluent.this.withVlan(builder.build());
    }
    
    public N endVlan() {
      return and();
    }
    
  }
}