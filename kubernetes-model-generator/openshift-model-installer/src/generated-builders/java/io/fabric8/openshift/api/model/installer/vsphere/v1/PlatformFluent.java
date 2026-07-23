package io.fabric8.openshift.api.model.installer.vsphere.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.config.v1.VSpherePlatformLoadBalancer;
import io.fabric8.openshift.api.model.config.v1.VSpherePlatformNodeNetworking;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.installer.vsphere.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVIP;
  private List<String> apiVIPs = new ArrayList<String>();
  private String cluster;
  private String clusterOSImage;
  private String datacenter;
  private String defaultDatastore;
  private MachinePoolBuilder defaultMachinePlatform;
  private String diskType;
  private ArrayList<FailureDomainBuilder> failureDomains = new ArrayList<FailureDomainBuilder>();
  private String folder;
  private ArrayList<HostBuilder> hosts = new ArrayList<HostBuilder>();
  private String ingressVIP;
  private List<String> ingressVIPs = new ArrayList<String>();
  private VSpherePlatformLoadBalancer loadBalancer;
  private String network;
  private VSpherePlatformNodeNetworking nodeNetworking;
  private String password;
  private String resourcePool;
  private String username;
  private String vCenter;
  private ArrayList<VCenterBuilder> vcenters = new ArrayList<VCenterBuilder>();

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
    this.copyInstance(instance);
  }

  public A addAllToApiVIPs(Collection<String> items) {
    if (this.apiVIPs == null) {
      this.apiVIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiVIPs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToFailureDomains(Collection<FailureDomain> items) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    for (FailureDomain item : items) {
        FailureDomainBuilder builder = new FailureDomainBuilder(item);
        _visitables.get("failureDomains").add(builder);
        this.failureDomains.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToHosts(Collection<Host> items) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    for (Host item : items) {
        HostBuilder builder = new HostBuilder(item);
        _visitables.get("hosts").add(builder);
        this.hosts.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIngressVIPs(Collection<String> items) {
    if (this.ingressVIPs == null) {
      this.ingressVIPs = new ArrayList();
    }
    for (String item : items) {
      this.ingressVIPs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToVcenters(Collection<VCenter> items) {
    if (this.vcenters == null) {
      this.vcenters = new ArrayList();
    }
    for (VCenter item : items) {
        VCenterBuilder builder = new VCenterBuilder(item);
        _visitables.get("vcenters").add(builder);
        this.vcenters.add(builder);
    }
    return (A) this;
  }
  
  public FailureDomainsNested<A> addNewFailureDomain() {
    return new FailureDomainsNested(-1, null);
  }
  
  public FailureDomainsNested<A> addNewFailureDomainLike(FailureDomain item) {
    return new FailureDomainsNested(-1, item);
  }
  
  public HostsNested<A> addNewHost() {
    return new HostsNested(-1, null);
  }
  
  public HostsNested<A> addNewHostLike(Host item) {
    return new HostsNested(-1, item);
  }
  
  public VcentersNested<A> addNewVcenter() {
    return new VcentersNested(-1, null);
  }
  
  public VcentersNested<A> addNewVcenterLike(VCenter item) {
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
  
  public A addToApiVIPs(String... items) {
    if (this.apiVIPs == null) {
      this.apiVIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiVIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToApiVIPs(int index,String item) {
    if (this.apiVIPs == null) {
      this.apiVIPs = new ArrayList();
    }
    this.apiVIPs.add(index, item);
    return (A) this;
  }
  
  public A addToFailureDomains(FailureDomain... items) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    for (FailureDomain item : items) {
        FailureDomainBuilder builder = new FailureDomainBuilder(item);
        _visitables.get("failureDomains").add(builder);
        this.failureDomains.add(builder);
    }
    return (A) this;
  }
  
  public A addToFailureDomains(int index,FailureDomain item) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    FailureDomainBuilder builder = new FailureDomainBuilder(item);
    if (index < 0 || index >= failureDomains.size()) {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(builder);
    } else {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToHosts(Host... items) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    for (Host item : items) {
        HostBuilder builder = new HostBuilder(item);
        _visitables.get("hosts").add(builder);
        this.hosts.add(builder);
    }
    return (A) this;
  }
  
  public A addToHosts(int index,Host item) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    HostBuilder builder = new HostBuilder(item);
    if (index < 0 || index >= hosts.size()) {
        _visitables.get("hosts").add(builder);
        hosts.add(builder);
    } else {
        _visitables.get("hosts").add(builder);
        hosts.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIngressVIPs(String... items) {
    if (this.ingressVIPs == null) {
      this.ingressVIPs = new ArrayList();
    }
    for (String item : items) {
      this.ingressVIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToIngressVIPs(int index,String item) {
    if (this.ingressVIPs == null) {
      this.ingressVIPs = new ArrayList();
    }
    this.ingressVIPs.add(index, item);
    return (A) this;
  }
  
  public A addToVcenters(VCenter... items) {
    if (this.vcenters == null) {
      this.vcenters = new ArrayList();
    }
    for (VCenter item : items) {
        VCenterBuilder builder = new VCenterBuilder(item);
        _visitables.get("vcenters").add(builder);
        this.vcenters.add(builder);
    }
    return (A) this;
  }
  
  public A addToVcenters(int index,VCenter item) {
    if (this.vcenters == null) {
      this.vcenters = new ArrayList();
    }
    VCenterBuilder builder = new VCenterBuilder(item);
    if (index < 0 || index >= vcenters.size()) {
        _visitables.get("vcenters").add(builder);
        vcenters.add(builder);
    } else {
        _visitables.get("vcenters").add(builder);
        vcenters.add(index, builder);
    }
    return (A) this;
  }
  
  public MachinePool buildDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null ? this.defaultMachinePlatform.build() : null;
  }
  
  public FailureDomain buildFailureDomain(int index) {
    return this.failureDomains.get(index).build();
  }
  
  public List<FailureDomain> buildFailureDomains() {
    return this.failureDomains != null ? build(failureDomains) : null;
  }
  
  public FailureDomain buildFirstFailureDomain() {
    return this.failureDomains.get(0).build();
  }
  
  public Host buildFirstHost() {
    return this.hosts.get(0).build();
  }
  
  public VCenter buildFirstVcenter() {
    return this.vcenters.get(0).build();
  }
  
  public Host buildHost(int index) {
    return this.hosts.get(index).build();
  }
  
  public List<Host> buildHosts() {
    return this.hosts != null ? build(hosts) : null;
  }
  
  public FailureDomain buildLastFailureDomain() {
    return this.failureDomains.get(failureDomains.size() - 1).build();
  }
  
  public Host buildLastHost() {
    return this.hosts.get(hosts.size() - 1).build();
  }
  
  public VCenter buildLastVcenter() {
    return this.vcenters.get(vcenters.size() - 1).build();
  }
  
  public FailureDomain buildMatchingFailureDomain(Predicate<FailureDomainBuilder> predicate) {
      for (FailureDomainBuilder item : failureDomains) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Host buildMatchingHost(Predicate<HostBuilder> predicate) {
      for (HostBuilder item : hosts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VCenter buildMatchingVcenter(Predicate<VCenterBuilder> predicate) {
      for (VCenterBuilder item : vcenters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VCenter buildVcenter(int index) {
    return this.vcenters.get(index).build();
  }
  
  public List<VCenter> buildVcenters() {
    return this.vcenters != null ? build(vcenters) : null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withApiVIP(instance.getApiVIP());
        this.withApiVIPs(instance.getApiVIPs());
        this.withCluster(instance.getCluster());
        this.withClusterOSImage(instance.getClusterOSImage());
        this.withDatacenter(instance.getDatacenter());
        this.withDefaultDatastore(instance.getDefaultDatastore());
        this.withDefaultMachinePlatform(instance.getDefaultMachinePlatform());
        this.withDiskType(instance.getDiskType());
        this.withFailureDomains(instance.getFailureDomains());
        this.withFolder(instance.getFolder());
        this.withHosts(instance.getHosts());
        this.withIngressVIP(instance.getIngressVIP());
        this.withIngressVIPs(instance.getIngressVIPs());
        this.withLoadBalancer(instance.getLoadBalancer());
        this.withNetwork(instance.getNetwork());
        this.withNodeNetworking(instance.getNodeNetworking());
        this.withPassword(instance.getPassword());
        this.withResourcePool(instance.getResourcePool());
        this.withUsername(instance.getUsername());
        this.withVCenter(instance.getVCenter());
        this.withVcenters(instance.getVcenters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DefaultMachinePlatformNested<A> editDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(null));
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
  
  public HostsNested<A> editFirstHost() {
    if (hosts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "hosts"));
    }
    return this.setNewHostLike(0, this.buildHost(0));
  }
  
  public VcentersNested<A> editFirstVcenter() {
    if (vcenters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "vcenters"));
    }
    return this.setNewVcenterLike(0, this.buildVcenter(0));
  }
  
  public HostsNested<A> editHost(int index) {
    if (hosts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "hosts"));
    }
    return this.setNewHostLike(index, this.buildHost(index));
  }
  
  public FailureDomainsNested<A> editLastFailureDomain() {
    int index = failureDomains.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "failureDomains"));
    }
    return this.setNewFailureDomainLike(index, this.buildFailureDomain(index));
  }
  
  public HostsNested<A> editLastHost() {
    int index = hosts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "hosts"));
    }
    return this.setNewHostLike(index, this.buildHost(index));
  }
  
  public VcentersNested<A> editLastVcenter() {
    int index = vcenters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "vcenters"));
    }
    return this.setNewVcenterLike(index, this.buildVcenter(index));
  }
  
  public FailureDomainsNested<A> editMatchingFailureDomain(Predicate<FailureDomainBuilder> predicate) {
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
  
  public HostsNested<A> editMatchingHost(Predicate<HostBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < hosts.size();i++) {
      if (predicate.test(hosts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "hosts"));
    }
    return this.setNewHostLike(index, this.buildHost(index));
  }
  
  public VcentersNested<A> editMatchingVcenter(Predicate<VCenterBuilder> predicate) {
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
  
  public DefaultMachinePlatformNested<A> editOrNewDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(new MachinePoolBuilder().build()));
  }
  
  public DefaultMachinePlatformNested<A> editOrNewDefaultMachinePlatformLike(MachinePool item) {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(item));
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
    PlatformFluent that = (PlatformFluent) o;
    if (!(Objects.equals(apiVIP, that.apiVIP))) {
      return false;
    }
    if (!(Objects.equals(apiVIPs, that.apiVIPs))) {
      return false;
    }
    if (!(Objects.equals(cluster, that.cluster))) {
      return false;
    }
    if (!(Objects.equals(clusterOSImage, that.clusterOSImage))) {
      return false;
    }
    if (!(Objects.equals(datacenter, that.datacenter))) {
      return false;
    }
    if (!(Objects.equals(defaultDatastore, that.defaultDatastore))) {
      return false;
    }
    if (!(Objects.equals(defaultMachinePlatform, that.defaultMachinePlatform))) {
      return false;
    }
    if (!(Objects.equals(diskType, that.diskType))) {
      return false;
    }
    if (!(Objects.equals(failureDomains, that.failureDomains))) {
      return false;
    }
    if (!(Objects.equals(folder, that.folder))) {
      return false;
    }
    if (!(Objects.equals(hosts, that.hosts))) {
      return false;
    }
    if (!(Objects.equals(ingressVIP, that.ingressVIP))) {
      return false;
    }
    if (!(Objects.equals(ingressVIPs, that.ingressVIPs))) {
      return false;
    }
    if (!(Objects.equals(loadBalancer, that.loadBalancer))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(nodeNetworking, that.nodeNetworking))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(resourcePool, that.resourcePool))) {
      return false;
    }
    if (!(Objects.equals(username, that.username))) {
      return false;
    }
    if (!(Objects.equals(vCenter, that.vCenter))) {
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
  
  public String getApiVIP() {
    return this.apiVIP;
  }
  
  public String getApiVIP(int index) {
    return this.apiVIPs.get(index);
  }
  
  public List<String> getApiVIPs() {
    return this.apiVIPs;
  }
  
  public String getCluster() {
    return this.cluster;
  }
  
  public String getClusterOSImage() {
    return this.clusterOSImage;
  }
  
  public String getDatacenter() {
    return this.datacenter;
  }
  
  public String getDefaultDatastore() {
    return this.defaultDatastore;
  }
  
  public String getDiskType() {
    return this.diskType;
  }
  
  public String getFirstApiVIP() {
    return this.apiVIPs.get(0);
  }
  
  public String getFirstIngressVIP() {
    return this.ingressVIPs.get(0);
  }
  
  public String getFolder() {
    return this.folder;
  }
  
  public String getIngressVIP() {
    return this.ingressVIP;
  }
  
  public String getIngressVIP(int index) {
    return this.ingressVIPs.get(index);
  }
  
  public List<String> getIngressVIPs() {
    return this.ingressVIPs;
  }
  
  public String getLastApiVIP() {
    return this.apiVIPs.get(apiVIPs.size() - 1);
  }
  
  public String getLastIngressVIP() {
    return this.ingressVIPs.get(ingressVIPs.size() - 1);
  }
  
  public VSpherePlatformLoadBalancer getLoadBalancer() {
    return this.loadBalancer;
  }
  
  public String getMatchingApiVIP(Predicate<String> predicate) {
      for (String item : apiVIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIngressVIP(Predicate<String> predicate) {
      for (String item : ingressVIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNetwork() {
    return this.network;
  }
  
  public VSpherePlatformNodeNetworking getNodeNetworking() {
    return this.nodeNetworking;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public String getResourcePool() {
    return this.resourcePool;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public String getVCenter() {
    return this.vCenter;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVIP() {
    return this.apiVIP != null;
  }
  
  public boolean hasApiVIPs() {
    return this.apiVIPs != null && !(this.apiVIPs.isEmpty());
  }
  
  public boolean hasCluster() {
    return this.cluster != null;
  }
  
  public boolean hasClusterOSImage() {
    return this.clusterOSImage != null;
  }
  
  public boolean hasDatacenter() {
    return this.datacenter != null;
  }
  
  public boolean hasDefaultDatastore() {
    return this.defaultDatastore != null;
  }
  
  public boolean hasDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null;
  }
  
  public boolean hasDiskType() {
    return this.diskType != null;
  }
  
  public boolean hasFailureDomains() {
    return this.failureDomains != null && !(this.failureDomains.isEmpty());
  }
  
  public boolean hasFolder() {
    return this.folder != null;
  }
  
  public boolean hasHosts() {
    return this.hosts != null && !(this.hosts.isEmpty());
  }
  
  public boolean hasIngressVIP() {
    return this.ingressVIP != null;
  }
  
  public boolean hasIngressVIPs() {
    return this.ingressVIPs != null && !(this.ingressVIPs.isEmpty());
  }
  
  public boolean hasLoadBalancer() {
    return this.loadBalancer != null;
  }
  
  public boolean hasMatchingApiVIP(Predicate<String> predicate) {
      for (String item : apiVIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFailureDomain(Predicate<FailureDomainBuilder> predicate) {
      for (FailureDomainBuilder item : failureDomains) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHost(Predicate<HostBuilder> predicate) {
      for (HostBuilder item : hosts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIngressVIP(Predicate<String> predicate) {
      for (String item : ingressVIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVcenter(Predicate<VCenterBuilder> predicate) {
      for (VCenterBuilder item : vcenters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasNodeNetworking() {
    return this.nodeNetworking != null;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasResourcePool() {
    return this.resourcePool != null;
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public boolean hasVCenter() {
    return this.vCenter != null;
  }
  
  public boolean hasVcenters() {
    return this.vcenters != null && !(this.vcenters.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVIP, apiVIPs, cluster, clusterOSImage, datacenter, defaultDatastore, defaultMachinePlatform, diskType, failureDomains, folder, hosts, ingressVIP, ingressVIPs, loadBalancer, network, nodeNetworking, password, resourcePool, username, vCenter, vcenters, additionalProperties);
  }
  
  public A removeAllFromApiVIPs(Collection<String> items) {
    if (this.apiVIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiVIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromFailureDomains(Collection<FailureDomain> items) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    for (FailureDomain item : items) {
        FailureDomainBuilder builder = new FailureDomainBuilder(item);
        _visitables.get("failureDomains").remove(builder);
        this.failureDomains.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromHosts(Collection<Host> items) {
    if (this.hosts == null) {
      return (A) this;
    }
    for (Host item : items) {
        HostBuilder builder = new HostBuilder(item);
        _visitables.get("hosts").remove(builder);
        this.hosts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIngressVIPs(Collection<String> items) {
    if (this.ingressVIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressVIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromVcenters(Collection<VCenter> items) {
    if (this.vcenters == null) {
      return (A) this;
    }
    for (VCenter item : items) {
        VCenterBuilder builder = new VCenterBuilder(item);
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
  
  public A removeFromApiVIPs(String... items) {
    if (this.apiVIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiVIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromFailureDomains(FailureDomain... items) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    for (FailureDomain item : items) {
        FailureDomainBuilder builder = new FailureDomainBuilder(item);
        _visitables.get("failureDomains").remove(builder);
        this.failureDomains.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromHosts(Host... items) {
    if (this.hosts == null) {
      return (A) this;
    }
    for (Host item : items) {
        HostBuilder builder = new HostBuilder(item);
        _visitables.get("hosts").remove(builder);
        this.hosts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIngressVIPs(String... items) {
    if (this.ingressVIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressVIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromVcenters(VCenter... items) {
    if (this.vcenters == null) {
      return (A) this;
    }
    for (VCenter item : items) {
        VCenterBuilder builder = new VCenterBuilder(item);
        _visitables.get("vcenters").remove(builder);
        this.vcenters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFailureDomains(Predicate<FailureDomainBuilder> predicate) {
    if (failureDomains == null) {
      return (A) this;
    }
    Iterator<FailureDomainBuilder> each = failureDomains.iterator();
    List visitables = _visitables.get("failureDomains");
    while (each.hasNext()) {
        FailureDomainBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromHosts(Predicate<HostBuilder> predicate) {
    if (hosts == null) {
      return (A) this;
    }
    Iterator<HostBuilder> each = hosts.iterator();
    List visitables = _visitables.get("hosts");
    while (each.hasNext()) {
        HostBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVcenters(Predicate<VCenterBuilder> predicate) {
    if (vcenters == null) {
      return (A) this;
    }
    Iterator<VCenterBuilder> each = vcenters.iterator();
    List visitables = _visitables.get("vcenters");
    while (each.hasNext()) {
        VCenterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FailureDomainsNested<A> setNewFailureDomainLike(int index,FailureDomain item) {
    return new FailureDomainsNested(index, item);
  }
  
  public HostsNested<A> setNewHostLike(int index,Host item) {
    return new HostsNested(index, item);
  }
  
  public VcentersNested<A> setNewVcenterLike(int index,VCenter item) {
    return new VcentersNested(index, item);
  }
  
  public A setToApiVIPs(int index,String item) {
    if (this.apiVIPs == null) {
      this.apiVIPs = new ArrayList();
    }
    this.apiVIPs.set(index, item);
    return (A) this;
  }
  
  public A setToFailureDomains(int index,FailureDomain item) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    FailureDomainBuilder builder = new FailureDomainBuilder(item);
    if (index < 0 || index >= failureDomains.size()) {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(builder);
    } else {
        _visitables.get("failureDomains").add(builder);
        failureDomains.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToHosts(int index,Host item) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    HostBuilder builder = new HostBuilder(item);
    if (index < 0 || index >= hosts.size()) {
        _visitables.get("hosts").add(builder);
        hosts.add(builder);
    } else {
        _visitables.get("hosts").add(builder);
        hosts.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIngressVIPs(int index,String item) {
    if (this.ingressVIPs == null) {
      this.ingressVIPs = new ArrayList();
    }
    this.ingressVIPs.set(index, item);
    return (A) this;
  }
  
  public A setToVcenters(int index,VCenter item) {
    if (this.vcenters == null) {
      this.vcenters = new ArrayList();
    }
    VCenterBuilder builder = new VCenterBuilder(item);
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
    if (!(apiVIP == null)) {
        sb.append("apiVIP:");
        sb.append(apiVIP);
        sb.append(",");
    }
    if (!(apiVIPs == null) && !(apiVIPs.isEmpty())) {
        sb.append("apiVIPs:");
        sb.append(apiVIPs);
        sb.append(",");
    }
    if (!(cluster == null)) {
        sb.append("cluster:");
        sb.append(cluster);
        sb.append(",");
    }
    if (!(clusterOSImage == null)) {
        sb.append("clusterOSImage:");
        sb.append(clusterOSImage);
        sb.append(",");
    }
    if (!(datacenter == null)) {
        sb.append("datacenter:");
        sb.append(datacenter);
        sb.append(",");
    }
    if (!(defaultDatastore == null)) {
        sb.append("defaultDatastore:");
        sb.append(defaultDatastore);
        sb.append(",");
    }
    if (!(defaultMachinePlatform == null)) {
        sb.append("defaultMachinePlatform:");
        sb.append(defaultMachinePlatform);
        sb.append(",");
    }
    if (!(diskType == null)) {
        sb.append("diskType:");
        sb.append(diskType);
        sb.append(",");
    }
    if (!(failureDomains == null) && !(failureDomains.isEmpty())) {
        sb.append("failureDomains:");
        sb.append(failureDomains);
        sb.append(",");
    }
    if (!(folder == null)) {
        sb.append("folder:");
        sb.append(folder);
        sb.append(",");
    }
    if (!(hosts == null) && !(hosts.isEmpty())) {
        sb.append("hosts:");
        sb.append(hosts);
        sb.append(",");
    }
    if (!(ingressVIP == null)) {
        sb.append("ingressVIP:");
        sb.append(ingressVIP);
        sb.append(",");
    }
    if (!(ingressVIPs == null) && !(ingressVIPs.isEmpty())) {
        sb.append("ingressVIPs:");
        sb.append(ingressVIPs);
        sb.append(",");
    }
    if (!(loadBalancer == null)) {
        sb.append("loadBalancer:");
        sb.append(loadBalancer);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(nodeNetworking == null)) {
        sb.append("nodeNetworking:");
        sb.append(nodeNetworking);
        sb.append(",");
    }
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(resourcePool == null)) {
        sb.append("resourcePool:");
        sb.append(resourcePool);
        sb.append(",");
    }
    if (!(username == null)) {
        sb.append("username:");
        sb.append(username);
        sb.append(",");
    }
    if (!(vCenter == null)) {
        sb.append("vCenter:");
        sb.append(vCenter);
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
  
  public A withApiVIP(String apiVIP) {
    this.apiVIP = apiVIP;
    return (A) this;
  }
  
  public A withApiVIPs(List<String> apiVIPs) {
    if (apiVIPs != null) {
        this.apiVIPs = new ArrayList();
        for (String item : apiVIPs) {
          this.addToApiVIPs(item);
        }
    } else {
      this.apiVIPs = null;
    }
    return (A) this;
  }
  
  public A withApiVIPs(String... apiVIPs) {
    if (this.apiVIPs != null) {
        this.apiVIPs.clear();
        _visitables.remove("apiVIPs");
    }
    if (apiVIPs != null) {
      for (String item : apiVIPs) {
        this.addToApiVIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withCluster(String cluster) {
    this.cluster = cluster;
    return (A) this;
  }
  
  public A withClusterOSImage(String clusterOSImage) {
    this.clusterOSImage = clusterOSImage;
    return (A) this;
  }
  
  public A withDatacenter(String datacenter) {
    this.datacenter = datacenter;
    return (A) this;
  }
  
  public A withDefaultDatastore(String defaultDatastore) {
    this.defaultDatastore = defaultDatastore;
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
  
  public A withDiskType(String diskType) {
    this.diskType = diskType;
    return (A) this;
  }
  
  public A withFailureDomains(List<FailureDomain> failureDomains) {
    if (this.failureDomains != null) {
      this._visitables.get("failureDomains").clear();
    }
    if (failureDomains != null) {
        this.failureDomains = new ArrayList();
        for (FailureDomain item : failureDomains) {
          this.addToFailureDomains(item);
        }
    } else {
      this.failureDomains = null;
    }
    return (A) this;
  }
  
  public A withFailureDomains(FailureDomain... failureDomains) {
    if (this.failureDomains != null) {
        this.failureDomains.clear();
        _visitables.remove("failureDomains");
    }
    if (failureDomains != null) {
      for (FailureDomain item : failureDomains) {
        this.addToFailureDomains(item);
      }
    }
    return (A) this;
  }
  
  public A withFolder(String folder) {
    this.folder = folder;
    return (A) this;
  }
  
  public A withHosts(List<Host> hosts) {
    if (this.hosts != null) {
      this._visitables.get("hosts").clear();
    }
    if (hosts != null) {
        this.hosts = new ArrayList();
        for (Host item : hosts) {
          this.addToHosts(item);
        }
    } else {
      this.hosts = null;
    }
    return (A) this;
  }
  
  public A withHosts(Host... hosts) {
    if (this.hosts != null) {
        this.hosts.clear();
        _visitables.remove("hosts");
    }
    if (hosts != null) {
      for (Host item : hosts) {
        this.addToHosts(item);
      }
    }
    return (A) this;
  }
  
  public A withIngressVIP(String ingressVIP) {
    this.ingressVIP = ingressVIP;
    return (A) this;
  }
  
  public A withIngressVIPs(List<String> ingressVIPs) {
    if (ingressVIPs != null) {
        this.ingressVIPs = new ArrayList();
        for (String item : ingressVIPs) {
          this.addToIngressVIPs(item);
        }
    } else {
      this.ingressVIPs = null;
    }
    return (A) this;
  }
  
  public A withIngressVIPs(String... ingressVIPs) {
    if (this.ingressVIPs != null) {
        this.ingressVIPs.clear();
        _visitables.remove("ingressVIPs");
    }
    if (ingressVIPs != null) {
      for (String item : ingressVIPs) {
        this.addToIngressVIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withLoadBalancer(VSpherePlatformLoadBalancer loadBalancer) {
    this.loadBalancer = loadBalancer;
    return (A) this;
  }
  
  public A withNetwork(String network) {
    this.network = network;
    return (A) this;
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatform() {
    return new DefaultMachinePlatformNested(null);
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatformLike(MachinePool item) {
    return new DefaultMachinePlatformNested(item);
  }
  
  public A withNewLoadBalancer(String type) {
    return (A) this.withLoadBalancer(new VSpherePlatformLoadBalancer(type));
  }
  
  public A withNodeNetworking(VSpherePlatformNodeNetworking nodeNetworking) {
    this.nodeNetworking = nodeNetworking;
    return (A) this;
  }
  
  public A withPassword(String password) {
    this.password = password;
    return (A) this;
  }
  
  public A withResourcePool(String resourcePool) {
    this.resourcePool = resourcePool;
    return (A) this;
  }
  
  public A withUsername(String username) {
    this.username = username;
    return (A) this;
  }
  
  public A withVCenter(String vCenter) {
    this.vCenter = vCenter;
    return (A) this;
  }
  
  public A withVcenters(List<VCenter> vcenters) {
    if (this.vcenters != null) {
      this._visitables.get("vcenters").clear();
    }
    if (vcenters != null) {
        this.vcenters = new ArrayList();
        for (VCenter item : vcenters) {
          this.addToVcenters(item);
        }
    } else {
      this.vcenters = null;
    }
    return (A) this;
  }
  
  public A withVcenters(VCenter... vcenters) {
    if (this.vcenters != null) {
        this.vcenters.clear();
        _visitables.remove("vcenters");
    }
    if (vcenters != null) {
      for (VCenter item : vcenters) {
        this.addToVcenters(item);
      }
    }
    return (A) this;
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
  public class FailureDomainsNested<N> extends FailureDomainFluent<FailureDomainsNested<N>> implements Nested<N>{
  
    FailureDomainBuilder builder;
    int index;
  
    FailureDomainsNested(int index,FailureDomain item) {
      this.index = index;
      this.builder = new FailureDomainBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.setToFailureDomains(index, builder.build());
    }
    
    public N endFailureDomain() {
      return and();
    }
    
  }
  public class HostsNested<N> extends HostFluent<HostsNested<N>> implements Nested<N>{
  
    HostBuilder builder;
    int index;
  
    HostsNested(int index,Host item) {
      this.index = index;
      this.builder = new HostBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.setToHosts(index, builder.build());
    }
    
    public N endHost() {
      return and();
    }
    
  }
  public class VcentersNested<N> extends VCenterFluent<VcentersNested<N>> implements Nested<N>{
  
    VCenterBuilder builder;
    int index;
  
    VcentersNested(int index,VCenter item) {
      this.index = index;
      this.builder = new VCenterBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.setToVcenters(index, builder.build());
    }
    
    public N endVcenter() {
      return and();
    }
    
  }
}