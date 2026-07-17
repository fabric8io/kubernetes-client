package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class NICFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.NICFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String ip;
  private LLDPBuilder lldp;
  private String mac;
  private String model;
  private String name;
  private String pciAddress;
  private Boolean pxe;
  private Integer speedGbps;
  private Integer vlanId;
  private ArrayList<VLANBuilder> vlans = new ArrayList<VLANBuilder>();

  public NICFluent() {
  }
  
  public NICFluent(NIC instance) {
    this.copyInstance(instance);
  }

  public A addAllToVlans(Collection<VLAN> items) {
    if (this.vlans == null) {
      this.vlans = new ArrayList();
    }
    for (VLAN item : items) {
        VLANBuilder builder = new VLANBuilder(item);
        _visitables.get("vlans").add(builder);
        this.vlans.add(builder);
    }
    return (A) this;
  }
  
  public VlansNested<A> addNewVlan() {
    return new VlansNested(-1, null);
  }
  
  public A addNewVlan(Integer id,String name) {
    return (A) this.addToVlans(new VLAN(id, name));
  }
  
  public VlansNested<A> addNewVlanLike(VLAN item) {
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
  
  public A addToVlans(VLAN... items) {
    if (this.vlans == null) {
      this.vlans = new ArrayList();
    }
    for (VLAN item : items) {
        VLANBuilder builder = new VLANBuilder(item);
        _visitables.get("vlans").add(builder);
        this.vlans.add(builder);
    }
    return (A) this;
  }
  
  public A addToVlans(int index,VLAN item) {
    if (this.vlans == null) {
      this.vlans = new ArrayList();
    }
    VLANBuilder builder = new VLANBuilder(item);
    if (index < 0 || index >= vlans.size()) {
        _visitables.get("vlans").add(builder);
        vlans.add(builder);
    } else {
        _visitables.get("vlans").add(builder);
        vlans.add(index, builder);
    }
    return (A) this;
  }
  
  public VLAN buildFirstVlan() {
    return this.vlans.get(0).build();
  }
  
  public VLAN buildLastVlan() {
    return this.vlans.get(vlans.size() - 1).build();
  }
  
  public LLDP buildLldp() {
    return this.lldp != null ? this.lldp.build() : null;
  }
  
  public VLAN buildMatchingVlan(Predicate<VLANBuilder> predicate) {
      for (VLANBuilder item : vlans) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VLAN buildVlan(int index) {
    return this.vlans.get(index).build();
  }
  
  public List<VLAN> buildVlans() {
    return this.vlans != null ? build(vlans) : null;
  }
  
  protected void copyInstance(NIC instance) {
    instance = instance != null ? instance : new NIC();
    if (instance != null) {
        this.withIp(instance.getIp());
        this.withLldp(instance.getLldp());
        this.withMac(instance.getMac());
        this.withModel(instance.getModel());
        this.withName(instance.getName());
        this.withPciAddress(instance.getPciAddress());
        this.withPxe(instance.getPxe());
        this.withSpeedGbps(instance.getSpeedGbps());
        this.withVlanId(instance.getVlanId());
        this.withVlans(instance.getVlans());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VlansNested<A> editFirstVlan() {
    if (vlans.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "vlans"));
    }
    return this.setNewVlanLike(0, this.buildVlan(0));
  }
  
  public VlansNested<A> editLastVlan() {
    int index = vlans.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "vlans"));
    }
    return this.setNewVlanLike(index, this.buildVlan(index));
  }
  
  public LldpNested<A> editLldp() {
    return this.withNewLldpLike(Optional.ofNullable(this.buildLldp()).orElse(null));
  }
  
  public VlansNested<A> editMatchingVlan(Predicate<VLANBuilder> predicate) {
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
  
  public LldpNested<A> editOrNewLldp() {
    return this.withNewLldpLike(Optional.ofNullable(this.buildLldp()).orElse(new LLDPBuilder().build()));
  }
  
  public LldpNested<A> editOrNewLldpLike(LLDP item) {
    return this.withNewLldpLike(Optional.ofNullable(this.buildLldp()).orElse(item));
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
    NICFluent that = (NICFluent) o;
    if (!(Objects.equals(ip, that.ip))) {
      return false;
    }
    if (!(Objects.equals(lldp, that.lldp))) {
      return false;
    }
    if (!(Objects.equals(mac, that.mac))) {
      return false;
    }
    if (!(Objects.equals(model, that.model))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(pciAddress, that.pciAddress))) {
      return false;
    }
    if (!(Objects.equals(pxe, that.pxe))) {
      return false;
    }
    if (!(Objects.equals(speedGbps, that.speedGbps))) {
      return false;
    }
    if (!(Objects.equals(vlanId, that.vlanId))) {
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
  
  public String getIp() {
    return this.ip;
  }
  
  public String getMac() {
    return this.mac;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getPciAddress() {
    return this.pciAddress;
  }
  
  public Boolean getPxe() {
    return this.pxe;
  }
  
  public Integer getSpeedGbps() {
    return this.speedGbps;
  }
  
  public Integer getVlanId() {
    return this.vlanId;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIp() {
    return this.ip != null;
  }
  
  public boolean hasLldp() {
    return this.lldp != null;
  }
  
  public boolean hasMac() {
    return this.mac != null;
  }
  
  public boolean hasMatchingVlan(Predicate<VLANBuilder> predicate) {
      for (VLANBuilder item : vlans) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasModel() {
    return this.model != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPciAddress() {
    return this.pciAddress != null;
  }
  
  public boolean hasPxe() {
    return this.pxe != null;
  }
  
  public boolean hasSpeedGbps() {
    return this.speedGbps != null;
  }
  
  public boolean hasVlanId() {
    return this.vlanId != null;
  }
  
  public boolean hasVlans() {
    return this.vlans != null && !(this.vlans.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(ip, lldp, mac, model, name, pciAddress, pxe, speedGbps, vlanId, vlans, additionalProperties);
  }
  
  public A removeAllFromVlans(Collection<VLAN> items) {
    if (this.vlans == null) {
      return (A) this;
    }
    for (VLAN item : items) {
        VLANBuilder builder = new VLANBuilder(item);
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
  
  public A removeFromVlans(VLAN... items) {
    if (this.vlans == null) {
      return (A) this;
    }
    for (VLAN item : items) {
        VLANBuilder builder = new VLANBuilder(item);
        _visitables.get("vlans").remove(builder);
        this.vlans.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromVlans(Predicate<VLANBuilder> predicate) {
    if (vlans == null) {
      return (A) this;
    }
    Iterator<VLANBuilder> each = vlans.iterator();
    List visitables = _visitables.get("vlans");
    while (each.hasNext()) {
        VLANBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public VlansNested<A> setNewVlanLike(int index,VLAN item) {
    return new VlansNested(index, item);
  }
  
  public A setToVlans(int index,VLAN item) {
    if (this.vlans == null) {
      this.vlans = new ArrayList();
    }
    VLANBuilder builder = new VLANBuilder(item);
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
    if (!(ip == null)) {
        sb.append("ip:");
        sb.append(ip);
        sb.append(",");
    }
    if (!(lldp == null)) {
        sb.append("lldp:");
        sb.append(lldp);
        sb.append(",");
    }
    if (!(mac == null)) {
        sb.append("mac:");
        sb.append(mac);
        sb.append(",");
    }
    if (!(model == null)) {
        sb.append("model:");
        sb.append(model);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(pciAddress == null)) {
        sb.append("pciAddress:");
        sb.append(pciAddress);
        sb.append(",");
    }
    if (!(pxe == null)) {
        sb.append("pxe:");
        sb.append(pxe);
        sb.append(",");
    }
    if (!(speedGbps == null)) {
        sb.append("speedGbps:");
        sb.append(speedGbps);
        sb.append(",");
    }
    if (!(vlanId == null)) {
        sb.append("vlanId:");
        sb.append(vlanId);
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
  
  public A withIp(String ip) {
    this.ip = ip;
    return (A) this;
  }
  
  public A withLldp(LLDP lldp) {
    this._visitables.remove("lldp");
    if (lldp != null) {
        this.lldp = new LLDPBuilder(lldp);
        this._visitables.get("lldp").add(this.lldp);
    } else {
        this.lldp = null;
        this._visitables.get("lldp").remove(this.lldp);
    }
    return (A) this;
  }
  
  public A withMac(String mac) {
    this.mac = mac;
    return (A) this;
  }
  
  public A withModel(String model) {
    this.model = model;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public LldpNested<A> withNewLldp() {
    return new LldpNested(null);
  }
  
  public A withNewLldp(String portID,String switchID,String switchSystemName) {
    return (A) this.withLldp(new LLDP(portID, switchID, switchSystemName));
  }
  
  public LldpNested<A> withNewLldpLike(LLDP item) {
    return new LldpNested(item);
  }
  
  public A withPciAddress(String pciAddress) {
    this.pciAddress = pciAddress;
    return (A) this;
  }
  
  public A withPxe() {
    return withPxe(true);
  }
  
  public A withPxe(Boolean pxe) {
    this.pxe = pxe;
    return (A) this;
  }
  
  public A withSpeedGbps(Integer speedGbps) {
    this.speedGbps = speedGbps;
    return (A) this;
  }
  
  public A withVlanId(Integer vlanId) {
    this.vlanId = vlanId;
    return (A) this;
  }
  
  public A withVlans(List<VLAN> vlans) {
    if (this.vlans != null) {
      this._visitables.get("vlans").clear();
    }
    if (vlans != null) {
        this.vlans = new ArrayList();
        for (VLAN item : vlans) {
          this.addToVlans(item);
        }
    } else {
      this.vlans = null;
    }
    return (A) this;
  }
  
  public A withVlans(VLAN... vlans) {
    if (this.vlans != null) {
        this.vlans.clear();
        _visitables.remove("vlans");
    }
    if (vlans != null) {
      for (VLAN item : vlans) {
        this.addToVlans(item);
      }
    }
    return (A) this;
  }
  public class LldpNested<N> extends LLDPFluent<LldpNested<N>> implements Nested<N>{
  
    LLDPBuilder builder;
  
    LldpNested(LLDP item) {
      this.builder = new LLDPBuilder(this, item);
    }
  
    public N and() {
      return (N) NICFluent.this.withLldp(builder.build());
    }
    
    public N endLldp() {
      return and();
    }
    
  }
  public class VlansNested<N> extends VLANFluent<VlansNested<N>> implements Nested<N>{
  
    VLANBuilder builder;
    int index;
  
    VlansNested(int index,VLAN item) {
      this.index = index;
      this.builder = new VLANBuilder(this, item);
    }
  
    public N and() {
      return (N) NICFluent.this.setToVlans(index, builder.build());
    }
    
    public N endVlan() {
      return and();
    }
    
  }
}