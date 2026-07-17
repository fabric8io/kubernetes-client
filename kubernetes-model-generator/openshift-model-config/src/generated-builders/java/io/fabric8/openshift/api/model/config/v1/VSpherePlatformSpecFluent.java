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
public class VSpherePlatformSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.VSpherePlatformSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> apiServerInternalIPs = new ArrayList<String>();
  private ArrayList<VSpherePlatformFailureDomainSpecBuilder> failureDomains = new ArrayList<VSpherePlatformFailureDomainSpecBuilder>();
  private List<String> ingressIPs = new ArrayList<String>();
  private List<String> machineNetworks = new ArrayList<String>();
  private VSpherePlatformNodeNetworkingBuilder nodeNetworking;
  private ArrayList<VSpherePlatformVCenterSpecBuilder> vcenters = new ArrayList<VSpherePlatformVCenterSpecBuilder>();

  public VSpherePlatformSpecFluent() {
  }
  
  public VSpherePlatformSpecFluent(VSpherePlatformSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToApiServerInternalIPs(Collection<String> items) {
    if (this.apiServerInternalIPs == null) {
      this.apiServerInternalIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiServerInternalIPs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToFailureDomains(Collection<VSpherePlatformFailureDomainSpec> items) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    for (VSpherePlatformFailureDomainSpec item : items) {
        VSpherePlatformFailureDomainSpecBuilder builder = new VSpherePlatformFailureDomainSpecBuilder(item);
        _visitables.get("failureDomains").add(builder);
        this.failureDomains.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIngressIPs(Collection<String> items) {
    if (this.ingressIPs == null) {
      this.ingressIPs = new ArrayList();
    }
    for (String item : items) {
      this.ingressIPs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToMachineNetworks(Collection<String> items) {
    if (this.machineNetworks == null) {
      this.machineNetworks = new ArrayList();
    }
    for (String item : items) {
      this.machineNetworks.add(item);
    }
    return (A) this;
  }
  
  public A addAllToVcenters(Collection<VSpherePlatformVCenterSpec> items) {
    if (this.vcenters == null) {
      this.vcenters = new ArrayList();
    }
    for (VSpherePlatformVCenterSpec item : items) {
        VSpherePlatformVCenterSpecBuilder builder = new VSpherePlatformVCenterSpecBuilder(item);
        _visitables.get("vcenters").add(builder);
        this.vcenters.add(builder);
    }
    return (A) this;
  }
  
  public FailureDomainsNested<A> addNewFailureDomain() {
    return new FailureDomainsNested(-1, null);
  }
  
  public FailureDomainsNested<A> addNewFailureDomainLike(VSpherePlatformFailureDomainSpec item) {
    return new FailureDomainsNested(-1, item);
  }
  
  public VcentersNested<A> addNewVcenter() {
    return new VcentersNested(-1, null);
  }
  
  public VcentersNested<A> addNewVcenterLike(VSpherePlatformVCenterSpec item) {
    return new VcentersNested(-1, item);
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
  
  public A addToApiServerInternalIPs(String... items) {
    if (this.apiServerInternalIPs == null) {
      this.apiServerInternalIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiServerInternalIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToApiServerInternalIPs(int index,String item) {
    if (this.apiServerInternalIPs == null) {
      this.apiServerInternalIPs = new ArrayList();
    }
    this.apiServerInternalIPs.add(index, item);
    return (A) this;
  }
  
  public A addToFailureDomains(VSpherePlatformFailureDomainSpec... items) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    for (VSpherePlatformFailureDomainSpec item : items) {
        VSpherePlatformFailureDomainSpecBuilder builder = new VSpherePlatformFailureDomainSpecBuilder(item);
        _visitables.get("failureDomains").add(builder);
        this.failureDomains.add(builder);
    }
    return (A) this;
  }
  
  public A addToFailureDomains(int index,VSpherePlatformFailureDomainSpec item) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    VSpherePlatformFailureDomainSpecBuilder builder = new VSpherePlatformFailureDomainSpecBuilder(item);
    if (index < 0 || index >= failureDomains.size()) {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(builder);
    } else {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIngressIPs(String... items) {
    if (this.ingressIPs == null) {
      this.ingressIPs = new ArrayList();
    }
    for (String item : items) {
      this.ingressIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToIngressIPs(int index,String item) {
    if (this.ingressIPs == null) {
      this.ingressIPs = new ArrayList();
    }
    this.ingressIPs.add(index, item);
    return (A) this;
  }
  
  public A addToMachineNetworks(String... items) {
    if (this.machineNetworks == null) {
      this.machineNetworks = new ArrayList();
    }
    for (String item : items) {
      this.machineNetworks.add(item);
    }
    return (A) this;
  }
  
  public A addToMachineNetworks(int index,String item) {
    if (this.machineNetworks == null) {
      this.machineNetworks = new ArrayList();
    }
    this.machineNetworks.add(index, item);
    return (A) this;
  }
  
  public A addToVcenters(VSpherePlatformVCenterSpec... items) {
    if (this.vcenters == null) {
      this.vcenters = new ArrayList();
    }
    for (VSpherePlatformVCenterSpec item : items) {
        VSpherePlatformVCenterSpecBuilder builder = new VSpherePlatformVCenterSpecBuilder(item);
        _visitables.get("vcenters").add(builder);
        this.vcenters.add(builder);
    }
    return (A) this;
  }
  
  public A addToVcenters(int index,VSpherePlatformVCenterSpec item) {
    if (this.vcenters == null) {
      this.vcenters = new ArrayList();
    }
    VSpherePlatformVCenterSpecBuilder builder = new VSpherePlatformVCenterSpecBuilder(item);
    if (index < 0 || index >= vcenters.size()) {
        _visitables.get("vcenters").add(builder);
        vcenters.add(builder);
    } else {
        _visitables.get("vcenters").add(builder);
        vcenters.add(index, builder);
    }
    return (A) this;
  }
  
  public VSpherePlatformFailureDomainSpec buildFailureDomain(int index) {
    return this.failureDomains.get(index).build();
  }
  
  public List<VSpherePlatformFailureDomainSpec> buildFailureDomains() {
    return this.failureDomains != null ? build(failureDomains) : null;
  }
  
  public VSpherePlatformFailureDomainSpec buildFirstFailureDomain() {
    return this.failureDomains.get(0).build();
  }
  
  public VSpherePlatformVCenterSpec buildFirstVcenter() {
    return this.vcenters.get(0).build();
  }
  
  public VSpherePlatformFailureDomainSpec buildLastFailureDomain() {
    return this.failureDomains.get(failureDomains.size() - 1).build();
  }
  
  public VSpherePlatformVCenterSpec buildLastVcenter() {
    return this.vcenters.get(vcenters.size() - 1).build();
  }
  
  public VSpherePlatformFailureDomainSpec buildMatchingFailureDomain(Predicate<VSpherePlatformFailureDomainSpecBuilder> predicate) {
      for (VSpherePlatformFailureDomainSpecBuilder item : failureDomains) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VSpherePlatformVCenterSpec buildMatchingVcenter(Predicate<VSpherePlatformVCenterSpecBuilder> predicate) {
      for (VSpherePlatformVCenterSpecBuilder item : vcenters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VSpherePlatformNodeNetworking buildNodeNetworking() {
    return this.nodeNetworking != null ? this.nodeNetworking.build() : null;
  }
  
  public VSpherePlatformVCenterSpec buildVcenter(int index) {
    return this.vcenters.get(index).build();
  }
  
  public List<VSpherePlatformVCenterSpec> buildVcenters() {
    return this.vcenters != null ? build(vcenters) : null;
  }
  
  protected void copyInstance(VSpherePlatformSpec instance) {
    instance = instance != null ? instance : new VSpherePlatformSpec();
    if (instance != null) {
        this.withApiServerInternalIPs(instance.getApiServerInternalIPs());
        this.withFailureDomains(instance.getFailureDomains());
        this.withIngressIPs(instance.getIngressIPs());
        this.withMachineNetworks(instance.getMachineNetworks());
        this.withNodeNetworking(instance.getNodeNetworking());
        this.withVcenters(instance.getVcenters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FailureDomainsNested<A> editFailureDomain(int index) {
    if (failureDomains.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "failureDomains"));
    }
    return this.setNewFailureDomainLike(index, this.buildFailureDomain(index));
  }
  
  public FailureDomainsNested<A> editFirstFailureDomain() {
    if (failureDomains.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "failureDomains"));
    }
    return this.setNewFailureDomainLike(0, this.buildFailureDomain(0));
  }
  
  public VcentersNested<A> editFirstVcenter() {
    if (vcenters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "vcenters"));
    }
    return this.setNewVcenterLike(0, this.buildVcenter(0));
  }
  
  public FailureDomainsNested<A> editLastFailureDomain() {
    int index = failureDomains.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "failureDomains"));
    }
    return this.setNewFailureDomainLike(index, this.buildFailureDomain(index));
  }
  
  public VcentersNested<A> editLastVcenter() {
    int index = vcenters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "vcenters"));
    }
    return this.setNewVcenterLike(index, this.buildVcenter(index));
  }
  
  public FailureDomainsNested<A> editMatchingFailureDomain(Predicate<VSpherePlatformFailureDomainSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < failureDomains.size();i++) {
      if (predicate.test(failureDomains.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "failureDomains"));
    }
    return this.setNewFailureDomainLike(index, this.buildFailureDomain(index));
  }
  
  public VcentersNested<A> editMatchingVcenter(Predicate<VSpherePlatformVCenterSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < vcenters.size();i++) {
      if (predicate.test(vcenters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "vcenters"));
    }
    return this.setNewVcenterLike(index, this.buildVcenter(index));
  }
  
  public NodeNetworkingNested<A> editNodeNetworking() {
    return this.withNewNodeNetworkingLike(Optional.ofNullable(this.buildNodeNetworking()).orElse(null));
  }
  
  public NodeNetworkingNested<A> editOrNewNodeNetworking() {
    return this.withNewNodeNetworkingLike(Optional.ofNullable(this.buildNodeNetworking()).orElse(new VSpherePlatformNodeNetworkingBuilder().build()));
  }
  
  public NodeNetworkingNested<A> editOrNewNodeNetworkingLike(VSpherePlatformNodeNetworking item) {
    return this.withNewNodeNetworkingLike(Optional.ofNullable(this.buildNodeNetworking()).orElse(item));
  }
  
  public VcentersNested<A> editVcenter(int index) {
    if (vcenters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "vcenters"));
    }
    return this.setNewVcenterLike(index, this.buildVcenter(index));
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
    VSpherePlatformSpecFluent that = (VSpherePlatformSpecFluent) o;
    if (!(Objects.equals(apiServerInternalIPs, that.apiServerInternalIPs))) {
      return false;
    }
    if (!(Objects.equals(failureDomains, that.failureDomains))) {
      return false;
    }
    if (!(Objects.equals(ingressIPs, that.ingressIPs))) {
      return false;
    }
    if (!(Objects.equals(machineNetworks, that.machineNetworks))) {
      return false;
    }
    if (!(Objects.equals(nodeNetworking, that.nodeNetworking))) {
      return false;
    }
    if (!(Objects.equals(vcenters, that.vcenters))) {
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
  
  public String getApiServerInternalIP(int index) {
    return this.apiServerInternalIPs.get(index);
  }
  
  public List<String> getApiServerInternalIPs() {
    return this.apiServerInternalIPs;
  }
  
  public String getFirstApiServerInternalIP() {
    return this.apiServerInternalIPs.get(0);
  }
  
  public String getFirstIngressIP() {
    return this.ingressIPs.get(0);
  }
  
  public String getFirstMachineNetwork() {
    return this.machineNetworks.get(0);
  }
  
  public String getIngressIP(int index) {
    return this.ingressIPs.get(index);
  }
  
  public List<String> getIngressIPs() {
    return this.ingressIPs;
  }
  
  public String getLastApiServerInternalIP() {
    return this.apiServerInternalIPs.get(apiServerInternalIPs.size() - 1);
  }
  
  public String getLastIngressIP() {
    return this.ingressIPs.get(ingressIPs.size() - 1);
  }
  
  public String getLastMachineNetwork() {
    return this.machineNetworks.get(machineNetworks.size() - 1);
  }
  
  public String getMachineNetwork(int index) {
    return this.machineNetworks.get(index);
  }
  
  public List<String> getMachineNetworks() {
    return this.machineNetworks;
  }
  
  public String getMatchingApiServerInternalIP(Predicate<String> predicate) {
      for (String item : apiServerInternalIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIngressIP(Predicate<String> predicate) {
      for (String item : ingressIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingMachineNetwork(Predicate<String> predicate) {
      for (String item : machineNetworks) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiServerInternalIPs() {
    return this.apiServerInternalIPs != null && !(this.apiServerInternalIPs.isEmpty());
  }
  
  public boolean hasFailureDomains() {
    return this.failureDomains != null && !(this.failureDomains.isEmpty());
  }
  
  public boolean hasIngressIPs() {
    return this.ingressIPs != null && !(this.ingressIPs.isEmpty());
  }
  
  public boolean hasMachineNetworks() {
    return this.machineNetworks != null && !(this.machineNetworks.isEmpty());
  }
  
  public boolean hasMatchingApiServerInternalIP(Predicate<String> predicate) {
      for (String item : apiServerInternalIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFailureDomain(Predicate<VSpherePlatformFailureDomainSpecBuilder> predicate) {
      for (VSpherePlatformFailureDomainSpecBuilder item : failureDomains) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIngressIP(Predicate<String> predicate) {
      for (String item : ingressIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMachineNetwork(Predicate<String> predicate) {
      for (String item : machineNetworks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVcenter(Predicate<VSpherePlatformVCenterSpecBuilder> predicate) {
      for (VSpherePlatformVCenterSpecBuilder item : vcenters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeNetworking() {
    return this.nodeNetworking != null;
  }
  
  public boolean hasVcenters() {
    return this.vcenters != null && !(this.vcenters.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiServerInternalIPs, failureDomains, ingressIPs, machineNetworks, nodeNetworking, vcenters, additionalProperties);
  }
  
  public A removeAllFromApiServerInternalIPs(Collection<String> items) {
    if (this.apiServerInternalIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiServerInternalIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromFailureDomains(Collection<VSpherePlatformFailureDomainSpec> items) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    for (VSpherePlatformFailureDomainSpec item : items) {
        VSpherePlatformFailureDomainSpecBuilder builder = new VSpherePlatformFailureDomainSpecBuilder(item);
        _visitables.get("failureDomains").remove(builder);
        this.failureDomains.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIngressIPs(Collection<String> items) {
    if (this.ingressIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromMachineNetworks(Collection<String> items) {
    if (this.machineNetworks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.machineNetworks.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromVcenters(Collection<VSpherePlatformVCenterSpec> items) {
    if (this.vcenters == null) {
      return (A) this;
    }
    for (VSpherePlatformVCenterSpec item : items) {
        VSpherePlatformVCenterSpecBuilder builder = new VSpherePlatformVCenterSpecBuilder(item);
        _visitables.get("vcenters").remove(builder);
        this.vcenters.remove(builder);
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
  
  public A removeFromApiServerInternalIPs(String... items) {
    if (this.apiServerInternalIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiServerInternalIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromFailureDomains(VSpherePlatformFailureDomainSpec... items) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    for (VSpherePlatformFailureDomainSpec item : items) {
        VSpherePlatformFailureDomainSpecBuilder builder = new VSpherePlatformFailureDomainSpecBuilder(item);
        _visitables.get("failureDomains").remove(builder);
        this.failureDomains.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIngressIPs(String... items) {
    if (this.ingressIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMachineNetworks(String... items) {
    if (this.machineNetworks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.machineNetworks.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromVcenters(VSpherePlatformVCenterSpec... items) {
    if (this.vcenters == null) {
      return (A) this;
    }
    for (VSpherePlatformVCenterSpec item : items) {
        VSpherePlatformVCenterSpecBuilder builder = new VSpherePlatformVCenterSpecBuilder(item);
        _visitables.get("vcenters").remove(builder);
        this.vcenters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFailureDomains(Predicate<VSpherePlatformFailureDomainSpecBuilder> predicate) {
    if (failureDomains == null) {
      return (A) this;
    }
    Iterator<VSpherePlatformFailureDomainSpecBuilder> each = failureDomains.iterator();
    List visitables = _visitables.get("failureDomains");
    while (each.hasNext()) {
        VSpherePlatformFailureDomainSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVcenters(Predicate<VSpherePlatformVCenterSpecBuilder> predicate) {
    if (vcenters == null) {
      return (A) this;
    }
    Iterator<VSpherePlatformVCenterSpecBuilder> each = vcenters.iterator();
    List visitables = _visitables.get("vcenters");
    while (each.hasNext()) {
        VSpherePlatformVCenterSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FailureDomainsNested<A> setNewFailureDomainLike(int index,VSpherePlatformFailureDomainSpec item) {
    return new FailureDomainsNested(index, item);
  }
  
  public VcentersNested<A> setNewVcenterLike(int index,VSpherePlatformVCenterSpec item) {
    return new VcentersNested(index, item);
  }
  
  public A setToApiServerInternalIPs(int index,String item) {
    if (this.apiServerInternalIPs == null) {
      this.apiServerInternalIPs = new ArrayList();
    }
    this.apiServerInternalIPs.set(index, item);
    return (A) this;
  }
  
  public A setToFailureDomains(int index,VSpherePlatformFailureDomainSpec item) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    VSpherePlatformFailureDomainSpecBuilder builder = new VSpherePlatformFailureDomainSpecBuilder(item);
    if (index < 0 || index >= failureDomains.size()) {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(builder);
    } else {
        _visitables.get("failureDomains").add(builder);
        failureDomains.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIngressIPs(int index,String item) {
    if (this.ingressIPs == null) {
      this.ingressIPs = new ArrayList();
    }
    this.ingressIPs.set(index, item);
    return (A) this;
  }
  
  public A setToMachineNetworks(int index,String item) {
    if (this.machineNetworks == null) {
      this.machineNetworks = new ArrayList();
    }
    this.machineNetworks.set(index, item);
    return (A) this;
  }
  
  public A setToVcenters(int index,VSpherePlatformVCenterSpec item) {
    if (this.vcenters == null) {
      this.vcenters = new ArrayList();
    }
    VSpherePlatformVCenterSpecBuilder builder = new VSpherePlatformVCenterSpecBuilder(item);
    if (index < 0 || index >= vcenters.size()) {
        _visitables.get("vcenters").add(builder);
        vcenters.add(builder);
    } else {
        _visitables.get("vcenters").add(builder);
        vcenters.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiServerInternalIPs == null) && !(apiServerInternalIPs.isEmpty())) {
        sb.append("apiServerInternalIPs:");
        sb.append(apiServerInternalIPs);
        sb.append(",");
    }
    if (!(failureDomains == null) && !(failureDomains.isEmpty())) {
        sb.append("failureDomains:");
        sb.append(failureDomains);
        sb.append(",");
    }
    if (!(ingressIPs == null) && !(ingressIPs.isEmpty())) {
        sb.append("ingressIPs:");
        sb.append(ingressIPs);
        sb.append(",");
    }
    if (!(machineNetworks == null) && !(machineNetworks.isEmpty())) {
        sb.append("machineNetworks:");
        sb.append(machineNetworks);
        sb.append(",");
    }
    if (!(nodeNetworking == null)) {
        sb.append("nodeNetworking:");
        sb.append(nodeNetworking);
        sb.append(",");
    }
    if (!(vcenters == null) && !(vcenters.isEmpty())) {
        sb.append("vcenters:");
        sb.append(vcenters);
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
  
  public A withApiServerInternalIPs(List<String> apiServerInternalIPs) {
    if (apiServerInternalIPs != null) {
        this.apiServerInternalIPs = new ArrayList();
        for (String item : apiServerInternalIPs) {
          this.addToApiServerInternalIPs(item);
        }
    } else {
      this.apiServerInternalIPs = null;
    }
    return (A) this;
  }
  
  public A withApiServerInternalIPs(String... apiServerInternalIPs) {
    if (this.apiServerInternalIPs != null) {
        this.apiServerInternalIPs.clear();
        _visitables.remove("apiServerInternalIPs");
    }
    if (apiServerInternalIPs != null) {
      for (String item : apiServerInternalIPs) {
        this.addToApiServerInternalIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withFailureDomains(List<VSpherePlatformFailureDomainSpec> failureDomains) {
    if (this.failureDomains != null) {
      this._visitables.get("failureDomains").clear();
    }
    if (failureDomains != null) {
        this.failureDomains = new ArrayList();
        for (VSpherePlatformFailureDomainSpec item : failureDomains) {
          this.addToFailureDomains(item);
        }
    } else {
      this.failureDomains = null;
    }
    return (A) this;
  }
  
  public A withFailureDomains(VSpherePlatformFailureDomainSpec... failureDomains) {
    if (this.failureDomains != null) {
        this.failureDomains.clear();
        _visitables.remove("failureDomains");
    }
    if (failureDomains != null) {
      for (VSpherePlatformFailureDomainSpec item : failureDomains) {
        this.addToFailureDomains(item);
      }
    }
    return (A) this;
  }
  
  public A withIngressIPs(List<String> ingressIPs) {
    if (ingressIPs != null) {
        this.ingressIPs = new ArrayList();
        for (String item : ingressIPs) {
          this.addToIngressIPs(item);
        }
    } else {
      this.ingressIPs = null;
    }
    return (A) this;
  }
  
  public A withIngressIPs(String... ingressIPs) {
    if (this.ingressIPs != null) {
        this.ingressIPs.clear();
        _visitables.remove("ingressIPs");
    }
    if (ingressIPs != null) {
      for (String item : ingressIPs) {
        this.addToIngressIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withMachineNetworks(List<String> machineNetworks) {
    if (machineNetworks != null) {
        this.machineNetworks = new ArrayList();
        for (String item : machineNetworks) {
          this.addToMachineNetworks(item);
        }
    } else {
      this.machineNetworks = null;
    }
    return (A) this;
  }
  
  public A withMachineNetworks(String... machineNetworks) {
    if (this.machineNetworks != null) {
        this.machineNetworks.clear();
        _visitables.remove("machineNetworks");
    }
    if (machineNetworks != null) {
      for (String item : machineNetworks) {
        this.addToMachineNetworks(item);
      }
    }
    return (A) this;
  }
  
  public NodeNetworkingNested<A> withNewNodeNetworking() {
    return new NodeNetworkingNested(null);
  }
  
  public NodeNetworkingNested<A> withNewNodeNetworkingLike(VSpherePlatformNodeNetworking item) {
    return new NodeNetworkingNested(item);
  }
  
  public A withNodeNetworking(VSpherePlatformNodeNetworking nodeNetworking) {
    this._visitables.remove("nodeNetworking");
    if (nodeNetworking != null) {
        this.nodeNetworking = new VSpherePlatformNodeNetworkingBuilder(nodeNetworking);
        this._visitables.get("nodeNetworking").add(this.nodeNetworking);
    } else {
        this.nodeNetworking = null;
        this._visitables.get("nodeNetworking").remove(this.nodeNetworking);
    }
    return (A) this;
  }
  
  public A withVcenters(List<VSpherePlatformVCenterSpec> vcenters) {
    if (this.vcenters != null) {
      this._visitables.get("vcenters").clear();
    }
    if (vcenters != null) {
        this.vcenters = new ArrayList();
        for (VSpherePlatformVCenterSpec item : vcenters) {
          this.addToVcenters(item);
        }
    } else {
      this.vcenters = null;
    }
    return (A) this;
  }
  
  public A withVcenters(VSpherePlatformVCenterSpec... vcenters) {
    if (this.vcenters != null) {
        this.vcenters.clear();
        _visitables.remove("vcenters");
    }
    if (vcenters != null) {
      for (VSpherePlatformVCenterSpec item : vcenters) {
        this.addToVcenters(item);
      }
    }
    return (A) this;
  }
  public class FailureDomainsNested<N> extends VSpherePlatformFailureDomainSpecFluent<FailureDomainsNested<N>> implements Nested<N>{
  
    VSpherePlatformFailureDomainSpecBuilder builder;
    int index;
  
    FailureDomainsNested(int index,VSpherePlatformFailureDomainSpec item) {
      this.index = index;
      this.builder = new VSpherePlatformFailureDomainSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) VSpherePlatformSpecFluent.this.setToFailureDomains(index, builder.build());
    }
    
    public N endFailureDomain() {
      return and();
    }
    
  }
  public class NodeNetworkingNested<N> extends VSpherePlatformNodeNetworkingFluent<NodeNetworkingNested<N>> implements Nested<N>{
  
    VSpherePlatformNodeNetworkingBuilder builder;
  
    NodeNetworkingNested(VSpherePlatformNodeNetworking item) {
      this.builder = new VSpherePlatformNodeNetworkingBuilder(this, item);
    }
  
    public N and() {
      return (N) VSpherePlatformSpecFluent.this.withNodeNetworking(builder.build());
    }
    
    public N endNodeNetworking() {
      return and();
    }
    
  }
  public class VcentersNested<N> extends VSpherePlatformVCenterSpecFluent<VcentersNested<N>> implements Nested<N>{
  
    VSpherePlatformVCenterSpecBuilder builder;
    int index;
  
    VcentersNested(int index,VSpherePlatformVCenterSpec item) {
      this.index = index;
      this.builder = new VSpherePlatformVCenterSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) VSpherePlatformSpecFluent.this.setToVcenters(index, builder.build());
    }
    
    public N endVcenter() {
      return and();
    }
    
  }
}