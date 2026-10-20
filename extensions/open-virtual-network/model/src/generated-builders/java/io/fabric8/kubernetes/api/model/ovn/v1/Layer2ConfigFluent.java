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
public class Layer2ConfigFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.Layer2ConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> defaultGatewayIPs = new ArrayList<String>();
  private List<String> infrastructureSubnets = new ArrayList<String>();
  private IPAMConfigBuilder ipam;
  private List<String> joinSubnets = new ArrayList<String>();
  private MACSecurityConfigBuilder macSecurity;
  private Integer mtu;
  private List<String> reservedSubnets = new ArrayList<String>();
  private String role;
  private List<String> subnets = new ArrayList<String>();

  public Layer2ConfigFluent() {
  }
  
  public Layer2ConfigFluent(Layer2Config instance) {
    this.copyInstance(instance);
  }

  public A addAllToDefaultGatewayIPs(Collection<String> items) {
    if (this.defaultGatewayIPs == null) {
      this.defaultGatewayIPs = new ArrayList();
    }
    for (String item : items) {
      this.defaultGatewayIPs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToInfrastructureSubnets(Collection<String> items) {
    if (this.infrastructureSubnets == null) {
      this.infrastructureSubnets = new ArrayList();
    }
    for (String item : items) {
      this.infrastructureSubnets.add(item);
    }
    return (A) this;
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
  
  public A addAllToReservedSubnets(Collection<String> items) {
    if (this.reservedSubnets == null) {
      this.reservedSubnets = new ArrayList();
    }
    for (String item : items) {
      this.reservedSubnets.add(item);
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
  
  public A addToDefaultGatewayIPs(String... items) {
    if (this.defaultGatewayIPs == null) {
      this.defaultGatewayIPs = new ArrayList();
    }
    for (String item : items) {
      this.defaultGatewayIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToDefaultGatewayIPs(int index,String item) {
    if (this.defaultGatewayIPs == null) {
      this.defaultGatewayIPs = new ArrayList();
    }
    this.defaultGatewayIPs.add(index, item);
    return (A) this;
  }
  
  public A addToInfrastructureSubnets(String... items) {
    if (this.infrastructureSubnets == null) {
      this.infrastructureSubnets = new ArrayList();
    }
    for (String item : items) {
      this.infrastructureSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addToInfrastructureSubnets(int index,String item) {
    if (this.infrastructureSubnets == null) {
      this.infrastructureSubnets = new ArrayList();
    }
    this.infrastructureSubnets.add(index, item);
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
  
  public A addToReservedSubnets(String... items) {
    if (this.reservedSubnets == null) {
      this.reservedSubnets = new ArrayList();
    }
    for (String item : items) {
      this.reservedSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addToReservedSubnets(int index,String item) {
    if (this.reservedSubnets == null) {
      this.reservedSubnets = new ArrayList();
    }
    this.reservedSubnets.add(index, item);
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
  
  protected void copyInstance(Layer2Config instance) {
    instance = instance != null ? instance : new Layer2Config();
    if (instance != null) {
        this.withDefaultGatewayIPs(instance.getDefaultGatewayIPs());
        this.withInfrastructureSubnets(instance.getInfrastructureSubnets());
        this.withIpam(instance.getIpam());
        this.withJoinSubnets(instance.getJoinSubnets());
        this.withMacSecurity(instance.getMacSecurity());
        this.withMtu(instance.getMtu());
        this.withReservedSubnets(instance.getReservedSubnets());
        this.withRole(instance.getRole());
        this.withSubnets(instance.getSubnets());
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
    Layer2ConfigFluent that = (Layer2ConfigFluent) o;
    if (!(Objects.equals(defaultGatewayIPs, that.defaultGatewayIPs))) {
      return false;
    }
    if (!(Objects.equals(infrastructureSubnets, that.infrastructureSubnets))) {
      return false;
    }
    if (!(Objects.equals(ipam, that.ipam))) {
      return false;
    }
    if (!(Objects.equals(joinSubnets, that.joinSubnets))) {
      return false;
    }
    if (!(Objects.equals(macSecurity, that.macSecurity))) {
      return false;
    }
    if (!(Objects.equals(mtu, that.mtu))) {
      return false;
    }
    if (!(Objects.equals(reservedSubnets, that.reservedSubnets))) {
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
  
  public String getDefaultGatewayIP(int index) {
    return this.defaultGatewayIPs.get(index);
  }
  
  public List<String> getDefaultGatewayIPs() {
    return this.defaultGatewayIPs;
  }
  
  public String getFirstDefaultGatewayIP() {
    return this.defaultGatewayIPs.get(0);
  }
  
  public String getFirstInfrastructureSubnet() {
    return this.infrastructureSubnets.get(0);
  }
  
  public String getFirstJoinSubnet() {
    return this.joinSubnets.get(0);
  }
  
  public String getFirstReservedSubnet() {
    return this.reservedSubnets.get(0);
  }
  
  public String getFirstSubnet() {
    return this.subnets.get(0);
  }
  
  public String getInfrastructureSubnet(int index) {
    return this.infrastructureSubnets.get(index);
  }
  
  public List<String> getInfrastructureSubnets() {
    return this.infrastructureSubnets;
  }
  
  public String getJoinSubnet(int index) {
    return this.joinSubnets.get(index);
  }
  
  public List<String> getJoinSubnets() {
    return this.joinSubnets;
  }
  
  public String getLastDefaultGatewayIP() {
    return this.defaultGatewayIPs.get(defaultGatewayIPs.size() - 1);
  }
  
  public String getLastInfrastructureSubnet() {
    return this.infrastructureSubnets.get(infrastructureSubnets.size() - 1);
  }
  
  public String getLastJoinSubnet() {
    return this.joinSubnets.get(joinSubnets.size() - 1);
  }
  
  public String getLastReservedSubnet() {
    return this.reservedSubnets.get(reservedSubnets.size() - 1);
  }
  
  public String getLastSubnet() {
    return this.subnets.get(subnets.size() - 1);
  }
  
  public String getMatchingDefaultGatewayIP(Predicate<String> predicate) {
      for (String item : defaultGatewayIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingInfrastructureSubnet(Predicate<String> predicate) {
      for (String item : infrastructureSubnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingJoinSubnet(Predicate<String> predicate) {
      for (String item : joinSubnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingReservedSubnet(Predicate<String> predicate) {
      for (String item : reservedSubnets) {
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
  
  public String getReservedSubnet(int index) {
    return this.reservedSubnets.get(index);
  }
  
  public List<String> getReservedSubnets() {
    return this.reservedSubnets;
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
  
  public boolean hasDefaultGatewayIPs() {
    return this.defaultGatewayIPs != null && !(this.defaultGatewayIPs.isEmpty());
  }
  
  public boolean hasInfrastructureSubnets() {
    return this.infrastructureSubnets != null && !(this.infrastructureSubnets.isEmpty());
  }
  
  public boolean hasIpam() {
    return this.ipam != null;
  }
  
  public boolean hasJoinSubnets() {
    return this.joinSubnets != null && !(this.joinSubnets.isEmpty());
  }
  
  public boolean hasMacSecurity() {
    return this.macSecurity != null;
  }
  
  public boolean hasMatchingDefaultGatewayIP(Predicate<String> predicate) {
      for (String item : defaultGatewayIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingInfrastructureSubnet(Predicate<String> predicate) {
      for (String item : infrastructureSubnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingJoinSubnet(Predicate<String> predicate) {
      for (String item : joinSubnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingReservedSubnet(Predicate<String> predicate) {
      for (String item : reservedSubnets) {
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
  
  public boolean hasReservedSubnets() {
    return this.reservedSubnets != null && !(this.reservedSubnets.isEmpty());
  }
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(defaultGatewayIPs, infrastructureSubnets, ipam, joinSubnets, macSecurity, mtu, reservedSubnets, role, subnets, additionalProperties);
  }
  
  public A removeAllFromDefaultGatewayIPs(Collection<String> items) {
    if (this.defaultGatewayIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.defaultGatewayIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromInfrastructureSubnets(Collection<String> items) {
    if (this.infrastructureSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.infrastructureSubnets.remove(item);
    }
    return (A) this;
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
  
  public A removeAllFromReservedSubnets(Collection<String> items) {
    if (this.reservedSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.reservedSubnets.remove(item);
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
  
  public A removeFromDefaultGatewayIPs(String... items) {
    if (this.defaultGatewayIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.defaultGatewayIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromInfrastructureSubnets(String... items) {
    if (this.infrastructureSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.infrastructureSubnets.remove(item);
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
  
  public A removeFromReservedSubnets(String... items) {
    if (this.reservedSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.reservedSubnets.remove(item);
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
  
  public A setToDefaultGatewayIPs(int index,String item) {
    if (this.defaultGatewayIPs == null) {
      this.defaultGatewayIPs = new ArrayList();
    }
    this.defaultGatewayIPs.set(index, item);
    return (A) this;
  }
  
  public A setToInfrastructureSubnets(int index,String item) {
    if (this.infrastructureSubnets == null) {
      this.infrastructureSubnets = new ArrayList();
    }
    this.infrastructureSubnets.set(index, item);
    return (A) this;
  }
  
  public A setToJoinSubnets(int index,String item) {
    if (this.joinSubnets == null) {
      this.joinSubnets = new ArrayList();
    }
    this.joinSubnets.set(index, item);
    return (A) this;
  }
  
  public A setToReservedSubnets(int index,String item) {
    if (this.reservedSubnets == null) {
      this.reservedSubnets = new ArrayList();
    }
    this.reservedSubnets.set(index, item);
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
    if (!(defaultGatewayIPs == null) && !(defaultGatewayIPs.isEmpty())) {
        sb.append("defaultGatewayIPs:");
        sb.append(defaultGatewayIPs);
        sb.append(",");
    }
    if (!(infrastructureSubnets == null) && !(infrastructureSubnets.isEmpty())) {
        sb.append("infrastructureSubnets:");
        sb.append(infrastructureSubnets);
        sb.append(",");
    }
    if (!(ipam == null)) {
        sb.append("ipam:");
        sb.append(ipam);
        sb.append(",");
    }
    if (!(joinSubnets == null) && !(joinSubnets.isEmpty())) {
        sb.append("joinSubnets:");
        sb.append(joinSubnets);
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
    if (!(reservedSubnets == null) && !(reservedSubnets.isEmpty())) {
        sb.append("reservedSubnets:");
        sb.append(reservedSubnets);
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
  
  public A withDefaultGatewayIPs(List<String> defaultGatewayIPs) {
    if (defaultGatewayIPs != null) {
        this.defaultGatewayIPs = new ArrayList();
        for (String item : defaultGatewayIPs) {
          this.addToDefaultGatewayIPs(item);
        }
    } else {
      this.defaultGatewayIPs = null;
    }
    return (A) this;
  }
  
  public A withDefaultGatewayIPs(String... defaultGatewayIPs) {
    if (this.defaultGatewayIPs != null) {
        this.defaultGatewayIPs.clear();
        _visitables.remove("defaultGatewayIPs");
    }
    if (defaultGatewayIPs != null) {
      for (String item : defaultGatewayIPs) {
        this.addToDefaultGatewayIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withInfrastructureSubnets(List<String> infrastructureSubnets) {
    if (infrastructureSubnets != null) {
        this.infrastructureSubnets = new ArrayList();
        for (String item : infrastructureSubnets) {
          this.addToInfrastructureSubnets(item);
        }
    } else {
      this.infrastructureSubnets = null;
    }
    return (A) this;
  }
  
  public A withInfrastructureSubnets(String... infrastructureSubnets) {
    if (this.infrastructureSubnets != null) {
        this.infrastructureSubnets.clear();
        _visitables.remove("infrastructureSubnets");
    }
    if (infrastructureSubnets != null) {
      for (String item : infrastructureSubnets) {
        this.addToInfrastructureSubnets(item);
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
  
  public A withReservedSubnets(List<String> reservedSubnets) {
    if (reservedSubnets != null) {
        this.reservedSubnets = new ArrayList();
        for (String item : reservedSubnets) {
          this.addToReservedSubnets(item);
        }
    } else {
      this.reservedSubnets = null;
    }
    return (A) this;
  }
  
  public A withReservedSubnets(String... reservedSubnets) {
    if (this.reservedSubnets != null) {
        this.reservedSubnets.clear();
        _visitables.remove("reservedSubnets");
    }
    if (reservedSubnets != null) {
      for (String item : reservedSubnets) {
        this.addToReservedSubnets(item);
      }
    }
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
  public class IpamNested<N> extends IPAMConfigFluent<IpamNested<N>> implements Nested<N>{
  
    IPAMConfigBuilder builder;
  
    IpamNested(IPAMConfig item) {
      this.builder = new IPAMConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) Layer2ConfigFluent.this.withIpam(builder.build());
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
      return (N) Layer2ConfigFluent.this.withMacSecurity(builder.build());
    }
    
    public N endMacSecurity() {
      return and();
    }
    
  }
}