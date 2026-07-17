package io.fabric8.openshift.api.model.installer.ovirt.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.config.v1.OvirtPlatformLoadBalancer;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.installer.ovirt.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AffinityGroupBuilder> affinityGroups = new ArrayList<AffinityGroupBuilder>();
  private String apiVip;
  private List<String> apiVips = new ArrayList<String>();
  private MachinePoolBuilder defaultMachinePlatform;
  private String ingressVip;
  private List<String> ingressVips = new ArrayList<String>();
  private OvirtPlatformLoadBalancer loadBalancer;
  private String ovirtClusterId;
  private String ovirtNetworkName;
  private String ovirtStorageDomainId;
  private String vnicProfileID;

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
    this.copyInstance(instance);
  }

  public A addAllToAffinityGroups(Collection<AffinityGroup> items) {
    if (this.affinityGroups == null) {
      this.affinityGroups = new ArrayList();
    }
    for (AffinityGroup item : items) {
        AffinityGroupBuilder builder = new AffinityGroupBuilder(item);
        _visitables.get("affinityGroups").add(builder);
        this.affinityGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToApiVips(Collection<String> items) {
    if (this.apiVips == null) {
      this.apiVips = new ArrayList();
    }
    for (String item : items) {
      this.apiVips.add(item);
    }
    return (A) this;
  }
  
  public A addAllToIngressVips(Collection<String> items) {
    if (this.ingressVips == null) {
      this.ingressVips = new ArrayList();
    }
    for (String item : items) {
      this.ingressVips.add(item);
    }
    return (A) this;
  }
  
  public AffinityGroupsNested<A> addNewAffinityGroup() {
    return new AffinityGroupsNested(-1, null);
  }
  
  public A addNewAffinityGroup(String description,Boolean enforcing,String name,Integer priority) {
    return (A) this.addToAffinityGroups(new AffinityGroup(description, enforcing, name, priority));
  }
  
  public AffinityGroupsNested<A> addNewAffinityGroupLike(AffinityGroup item) {
    return new AffinityGroupsNested(-1, item);
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
  
  public A addToAffinityGroups(AffinityGroup... items) {
    if (this.affinityGroups == null) {
      this.affinityGroups = new ArrayList();
    }
    for (AffinityGroup item : items) {
        AffinityGroupBuilder builder = new AffinityGroupBuilder(item);
        _visitables.get("affinityGroups").add(builder);
        this.affinityGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addToAffinityGroups(int index,AffinityGroup item) {
    if (this.affinityGroups == null) {
      this.affinityGroups = new ArrayList();
    }
    AffinityGroupBuilder builder = new AffinityGroupBuilder(item);
    if (index < 0 || index >= affinityGroups.size()) {
        _visitables.get("affinityGroups").add(builder);
        affinityGroups.add(builder);
    } else {
        _visitables.get("affinityGroups").add(builder);
        affinityGroups.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToApiVips(String... items) {
    if (this.apiVips == null) {
      this.apiVips = new ArrayList();
    }
    for (String item : items) {
      this.apiVips.add(item);
    }
    return (A) this;
  }
  
  public A addToApiVips(int index,String item) {
    if (this.apiVips == null) {
      this.apiVips = new ArrayList();
    }
    this.apiVips.add(index, item);
    return (A) this;
  }
  
  public A addToIngressVips(String... items) {
    if (this.ingressVips == null) {
      this.ingressVips = new ArrayList();
    }
    for (String item : items) {
      this.ingressVips.add(item);
    }
    return (A) this;
  }
  
  public A addToIngressVips(int index,String item) {
    if (this.ingressVips == null) {
      this.ingressVips = new ArrayList();
    }
    this.ingressVips.add(index, item);
    return (A) this;
  }
  
  public AffinityGroup buildAffinityGroup(int index) {
    return this.affinityGroups.get(index).build();
  }
  
  public List<AffinityGroup> buildAffinityGroups() {
    return this.affinityGroups != null ? build(affinityGroups) : null;
  }
  
  public MachinePool buildDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null ? this.defaultMachinePlatform.build() : null;
  }
  
  public AffinityGroup buildFirstAffinityGroup() {
    return this.affinityGroups.get(0).build();
  }
  
  public AffinityGroup buildLastAffinityGroup() {
    return this.affinityGroups.get(affinityGroups.size() - 1).build();
  }
  
  public AffinityGroup buildMatchingAffinityGroup(Predicate<AffinityGroupBuilder> predicate) {
      for (AffinityGroupBuilder item : affinityGroups) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withAffinityGroups(instance.getAffinityGroups());
        this.withApiVip(instance.getApiVip());
        this.withApiVips(instance.getApiVips());
        this.withDefaultMachinePlatform(instance.getDefaultMachinePlatform());
        this.withIngressVip(instance.getIngressVip());
        this.withIngressVips(instance.getIngressVips());
        this.withLoadBalancer(instance.getLoadBalancer());
        this.withOvirtClusterId(instance.getOvirtClusterId());
        this.withOvirtNetworkName(instance.getOvirtNetworkName());
        this.withOvirtStorageDomainId(instance.getOvirtStorageDomainId());
        this.withVnicProfileID(instance.getVnicProfileID());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AffinityGroupsNested<A> editAffinityGroup(int index) {
    if (affinityGroups.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "affinityGroups"));
    }
    return this.setNewAffinityGroupLike(index, this.buildAffinityGroup(index));
  }
  
  public DefaultMachinePlatformNested<A> editDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(null));
  }
  
  public AffinityGroupsNested<A> editFirstAffinityGroup() {
    if (affinityGroups.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "affinityGroups"));
    }
    return this.setNewAffinityGroupLike(0, this.buildAffinityGroup(0));
  }
  
  public AffinityGroupsNested<A> editLastAffinityGroup() {
    int index = affinityGroups.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "affinityGroups"));
    }
    return this.setNewAffinityGroupLike(index, this.buildAffinityGroup(index));
  }
  
  public AffinityGroupsNested<A> editMatchingAffinityGroup(Predicate<AffinityGroupBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < affinityGroups.size();i++) {
      if (predicate.test(affinityGroups.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "affinityGroups"));
    }
    return this.setNewAffinityGroupLike(index, this.buildAffinityGroup(index));
  }
  
  public DefaultMachinePlatformNested<A> editOrNewDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(new MachinePoolBuilder().build()));
  }
  
  public DefaultMachinePlatformNested<A> editOrNewDefaultMachinePlatformLike(MachinePool item) {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(item));
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
    PlatformFluent that = (PlatformFluent) o;
    if (!(Objects.equals(affinityGroups, that.affinityGroups))) {
      return false;
    }
    if (!(Objects.equals(apiVip, that.apiVip))) {
      return false;
    }
    if (!(Objects.equals(apiVips, that.apiVips))) {
      return false;
    }
    if (!(Objects.equals(defaultMachinePlatform, that.defaultMachinePlatform))) {
      return false;
    }
    if (!(Objects.equals(ingressVip, that.ingressVip))) {
      return false;
    }
    if (!(Objects.equals(ingressVips, that.ingressVips))) {
      return false;
    }
    if (!(Objects.equals(loadBalancer, that.loadBalancer))) {
      return false;
    }
    if (!(Objects.equals(ovirtClusterId, that.ovirtClusterId))) {
      return false;
    }
    if (!(Objects.equals(ovirtNetworkName, that.ovirtNetworkName))) {
      return false;
    }
    if (!(Objects.equals(ovirtStorageDomainId, that.ovirtStorageDomainId))) {
      return false;
    }
    if (!(Objects.equals(vnicProfileID, that.vnicProfileID))) {
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
  
  public String getApiVip() {
    return this.apiVip;
  }
  
  public String getApiVip(int index) {
    return this.apiVips.get(index);
  }
  
  public List<String> getApiVips() {
    return this.apiVips;
  }
  
  public String getFirstApiVip() {
    return this.apiVips.get(0);
  }
  
  public String getFirstIngressVip() {
    return this.ingressVips.get(0);
  }
  
  public String getIngressVip() {
    return this.ingressVip;
  }
  
  public String getIngressVip(int index) {
    return this.ingressVips.get(index);
  }
  
  public List<String> getIngressVips() {
    return this.ingressVips;
  }
  
  public String getLastApiVip() {
    return this.apiVips.get(apiVips.size() - 1);
  }
  
  public String getLastIngressVip() {
    return this.ingressVips.get(ingressVips.size() - 1);
  }
  
  public OvirtPlatformLoadBalancer getLoadBalancer() {
    return this.loadBalancer;
  }
  
  public String getMatchingApiVip(Predicate<String> predicate) {
      for (String item : apiVips) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIngressVip(Predicate<String> predicate) {
      for (String item : ingressVips) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOvirtClusterId() {
    return this.ovirtClusterId;
  }
  
  public String getOvirtNetworkName() {
    return this.ovirtNetworkName;
  }
  
  public String getOvirtStorageDomainId() {
    return this.ovirtStorageDomainId;
  }
  
  public String getVnicProfileID() {
    return this.vnicProfileID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinityGroups() {
    return this.affinityGroups != null && !(this.affinityGroups.isEmpty());
  }
  
  public boolean hasApiVip() {
    return this.apiVip != null;
  }
  
  public boolean hasApiVips() {
    return this.apiVips != null && !(this.apiVips.isEmpty());
  }
  
  public boolean hasDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null;
  }
  
  public boolean hasIngressVip() {
    return this.ingressVip != null;
  }
  
  public boolean hasIngressVips() {
    return this.ingressVips != null && !(this.ingressVips.isEmpty());
  }
  
  public boolean hasLoadBalancer() {
    return this.loadBalancer != null;
  }
  
  public boolean hasMatchingAffinityGroup(Predicate<AffinityGroupBuilder> predicate) {
      for (AffinityGroupBuilder item : affinityGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingApiVip(Predicate<String> predicate) {
      for (String item : apiVips) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIngressVip(Predicate<String> predicate) {
      for (String item : ingressVips) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOvirtClusterId() {
    return this.ovirtClusterId != null;
  }
  
  public boolean hasOvirtNetworkName() {
    return this.ovirtNetworkName != null;
  }
  
  public boolean hasOvirtStorageDomainId() {
    return this.ovirtStorageDomainId != null;
  }
  
  public boolean hasVnicProfileID() {
    return this.vnicProfileID != null;
  }
  
  public int hashCode() {
    return Objects.hash(affinityGroups, apiVip, apiVips, defaultMachinePlatform, ingressVip, ingressVips, loadBalancer, ovirtClusterId, ovirtNetworkName, ovirtStorageDomainId, vnicProfileID, additionalProperties);
  }
  
  public A removeAllFromAffinityGroups(Collection<AffinityGroup> items) {
    if (this.affinityGroups == null) {
      return (A) this;
    }
    for (AffinityGroup item : items) {
        AffinityGroupBuilder builder = new AffinityGroupBuilder(item);
        _visitables.get("affinityGroups").remove(builder);
        this.affinityGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromApiVips(Collection<String> items) {
    if (this.apiVips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiVips.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromIngressVips(Collection<String> items) {
    if (this.ingressVips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressVips.remove(item);
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
  
  public A removeFromAffinityGroups(AffinityGroup... items) {
    if (this.affinityGroups == null) {
      return (A) this;
    }
    for (AffinityGroup item : items) {
        AffinityGroupBuilder builder = new AffinityGroupBuilder(item);
        _visitables.get("affinityGroups").remove(builder);
        this.affinityGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromApiVips(String... items) {
    if (this.apiVips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiVips.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromIngressVips(String... items) {
    if (this.ingressVips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressVips.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAffinityGroups(Predicate<AffinityGroupBuilder> predicate) {
    if (affinityGroups == null) {
      return (A) this;
    }
    Iterator<AffinityGroupBuilder> each = affinityGroups.iterator();
    List visitables = _visitables.get("affinityGroups");
    while (each.hasNext()) {
        AffinityGroupBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AffinityGroupsNested<A> setNewAffinityGroupLike(int index,AffinityGroup item) {
    return new AffinityGroupsNested(index, item);
  }
  
  public A setToAffinityGroups(int index,AffinityGroup item) {
    if (this.affinityGroups == null) {
      this.affinityGroups = new ArrayList();
    }
    AffinityGroupBuilder builder = new AffinityGroupBuilder(item);
    if (index < 0 || index >= affinityGroups.size()) {
        _visitables.get("affinityGroups").add(builder);
        affinityGroups.add(builder);
    } else {
        _visitables.get("affinityGroups").add(builder);
        affinityGroups.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToApiVips(int index,String item) {
    if (this.apiVips == null) {
      this.apiVips = new ArrayList();
    }
    this.apiVips.set(index, item);
    return (A) this;
  }
  
  public A setToIngressVips(int index,String item) {
    if (this.ingressVips == null) {
      this.ingressVips = new ArrayList();
    }
    this.ingressVips.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(affinityGroups == null) && !(affinityGroups.isEmpty())) {
        sb.append("affinityGroups:");
        sb.append(affinityGroups);
        sb.append(",");
    }
    if (!(apiVip == null)) {
        sb.append("apiVip:");
        sb.append(apiVip);
        sb.append(",");
    }
    if (!(apiVips == null) && !(apiVips.isEmpty())) {
        sb.append("apiVips:");
        sb.append(apiVips);
        sb.append(",");
    }
    if (!(defaultMachinePlatform == null)) {
        sb.append("defaultMachinePlatform:");
        sb.append(defaultMachinePlatform);
        sb.append(",");
    }
    if (!(ingressVip == null)) {
        sb.append("ingressVip:");
        sb.append(ingressVip);
        sb.append(",");
    }
    if (!(ingressVips == null) && !(ingressVips.isEmpty())) {
        sb.append("ingressVips:");
        sb.append(ingressVips);
        sb.append(",");
    }
    if (!(loadBalancer == null)) {
        sb.append("loadBalancer:");
        sb.append(loadBalancer);
        sb.append(",");
    }
    if (!(ovirtClusterId == null)) {
        sb.append("ovirtClusterId:");
        sb.append(ovirtClusterId);
        sb.append(",");
    }
    if (!(ovirtNetworkName == null)) {
        sb.append("ovirtNetworkName:");
        sb.append(ovirtNetworkName);
        sb.append(",");
    }
    if (!(ovirtStorageDomainId == null)) {
        sb.append("ovirtStorageDomainId:");
        sb.append(ovirtStorageDomainId);
        sb.append(",");
    }
    if (!(vnicProfileID == null)) {
        sb.append("vnicProfileID:");
        sb.append(vnicProfileID);
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
  
  public A withAffinityGroups(List<AffinityGroup> affinityGroups) {
    if (this.affinityGroups != null) {
      this._visitables.get("affinityGroups").clear();
    }
    if (affinityGroups != null) {
        this.affinityGroups = new ArrayList();
        for (AffinityGroup item : affinityGroups) {
          this.addToAffinityGroups(item);
        }
    } else {
      this.affinityGroups = null;
    }
    return (A) this;
  }
  
  public A withAffinityGroups(AffinityGroup... affinityGroups) {
    if (this.affinityGroups != null) {
        this.affinityGroups.clear();
        _visitables.remove("affinityGroups");
    }
    if (affinityGroups != null) {
      for (AffinityGroup item : affinityGroups) {
        this.addToAffinityGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withApiVip(String apiVip) {
    this.apiVip = apiVip;
    return (A) this;
  }
  
  public A withApiVips(List<String> apiVips) {
    if (apiVips != null) {
        this.apiVips = new ArrayList();
        for (String item : apiVips) {
          this.addToApiVips(item);
        }
    } else {
      this.apiVips = null;
    }
    return (A) this;
  }
  
  public A withApiVips(String... apiVips) {
    if (this.apiVips != null) {
        this.apiVips.clear();
        _visitables.remove("apiVips");
    }
    if (apiVips != null) {
      for (String item : apiVips) {
        this.addToApiVips(item);
      }
    }
    return (A) this;
  }
  
  public A withDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
    this._visitables.remove("defaultMachinePlatform");
    if (defaultMachinePlatform != null) {
        this.defaultMachinePlatform = new MachinePoolBuilder(defaultMachinePlatform);
        this._visitables.get("defaultMachinePlatform").add(this.defaultMachinePlatform);
    } else {
        this.defaultMachinePlatform = null;
        this._visitables.get("defaultMachinePlatform").remove(this.defaultMachinePlatform);
    }
    return (A) this;
  }
  
  public A withIngressVip(String ingressVip) {
    this.ingressVip = ingressVip;
    return (A) this;
  }
  
  public A withIngressVips(List<String> ingressVips) {
    if (ingressVips != null) {
        this.ingressVips = new ArrayList();
        for (String item : ingressVips) {
          this.addToIngressVips(item);
        }
    } else {
      this.ingressVips = null;
    }
    return (A) this;
  }
  
  public A withIngressVips(String... ingressVips) {
    if (this.ingressVips != null) {
        this.ingressVips.clear();
        _visitables.remove("ingressVips");
    }
    if (ingressVips != null) {
      for (String item : ingressVips) {
        this.addToIngressVips(item);
      }
    }
    return (A) this;
  }
  
  public A withLoadBalancer(OvirtPlatformLoadBalancer loadBalancer) {
    this.loadBalancer = loadBalancer;
    return (A) this;
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatform() {
    return new DefaultMachinePlatformNested(null);
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatformLike(MachinePool item) {
    return new DefaultMachinePlatformNested(item);
  }
  
  public A withNewLoadBalancer(String type) {
    return (A) this.withLoadBalancer(new OvirtPlatformLoadBalancer(type));
  }
  
  public A withOvirtClusterId(String ovirtClusterId) {
    this.ovirtClusterId = ovirtClusterId;
    return (A) this;
  }
  
  public A withOvirtNetworkName(String ovirtNetworkName) {
    this.ovirtNetworkName = ovirtNetworkName;
    return (A) this;
  }
  
  public A withOvirtStorageDomainId(String ovirtStorageDomainId) {
    this.ovirtStorageDomainId = ovirtStorageDomainId;
    return (A) this;
  }
  
  public A withVnicProfileID(String vnicProfileID) {
    this.vnicProfileID = vnicProfileID;
    return (A) this;
  }
  public class AffinityGroupsNested<N> extends AffinityGroupFluent<AffinityGroupsNested<N>> implements Nested<N>{
  
    AffinityGroupBuilder builder;
    int index;
  
    AffinityGroupsNested(int index,AffinityGroup item) {
      this.index = index;
      this.builder = new AffinityGroupBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.setToAffinityGroups(index, builder.build());
    }
    
    public N endAffinityGroup() {
      return and();
    }
    
  }
  public class DefaultMachinePlatformNested<N> extends MachinePoolFluent<DefaultMachinePlatformNested<N>> implements Nested<N>{
  
    MachinePoolBuilder builder;
  
    DefaultMachinePlatformNested(MachinePool item) {
      this.builder = new MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withDefaultMachinePlatform(builder.build());
    }
    
    public N endDefaultMachinePlatform() {
      return and();
    }
    
  }
}