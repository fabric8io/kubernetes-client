package io.fabric8.openshift.api.model.installer.baremetal.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.config.v1.BareMetalPlatformLoadBalancer;
import java.lang.Boolean;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.installer.baremetal.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private List<String> additionalNTPServers = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private String apiVIP;
  private List<String> apiVIPs = new ArrayList<String>();
  private String bmcVerifyCA;
  private String bootstrapExternalStaticDNS;
  private String bootstrapExternalStaticGateway;
  private String bootstrapExternalStaticIP;
  private String bootstrapOSImage;
  private String bootstrapProvisioningIP;
  private String clusterOSImage;
  private String clusterProvisioningIP;
  private MachinePoolBuilder defaultMachinePlatform;
  private String externalBridge;
  private String externalMACAddress;
  private ArrayList<HostBuilder> hosts = new ArrayList<HostBuilder>();
  private String ingressVIP;
  private List<String> ingressVIPs = new ArrayList<String>();
  private String libvirtURI;
  private BareMetalPlatformLoadBalancer loadBalancer;
  private String provisioningBridge;
  private Boolean provisioningDHCPExternal;
  private String provisioningDHCPRange;
  private String provisioningHostIP;
  private String provisioningMACAddress;
  private String provisioningNetwork;
  private String provisioningNetworkCIDR;
  private String provisioningNetworkInterface;

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalNTPServers(Collection<String> items) {
    if (this.additionalNTPServers == null) {
      this.additionalNTPServers = new ArrayList();
    }
    for (String item : items) {
      this.additionalNTPServers.add(item);
    }
    return (A) this;
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
  
  public HostsNested<A> addNewHost() {
    return new HostsNested(-1, null);
  }
  
  public HostsNested<A> addNewHostLike(Host item) {
    return new HostsNested(-1, item);
  }
  
  public A addToAdditionalNTPServers(String... items) {
    if (this.additionalNTPServers == null) {
      this.additionalNTPServers = new ArrayList();
    }
    for (String item : items) {
      this.additionalNTPServers.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalNTPServers(int index,String item) {
    if (this.additionalNTPServers == null) {
      this.additionalNTPServers = new ArrayList();
    }
    this.additionalNTPServers.add(index, item);
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
  
  public MachinePool buildDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null ? this.defaultMachinePlatform.build() : null;
  }
  
  public Host buildFirstHost() {
    return this.hosts.get(0).build();
  }
  
  public Host buildHost(int index) {
    return this.hosts.get(index).build();
  }
  
  public List<Host> buildHosts() {
    return this.hosts != null ? build(hosts) : null;
  }
  
  public Host buildLastHost() {
    return this.hosts.get(hosts.size() - 1).build();
  }
  
  public Host buildMatchingHost(Predicate<HostBuilder> predicate) {
      for (HostBuilder item : hosts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withAdditionalNTPServers(instance.getAdditionalNTPServers());
        this.withApiVIP(instance.getApiVIP());
        this.withApiVIPs(instance.getApiVIPs());
        this.withBmcVerifyCA(instance.getBmcVerifyCA());
        this.withBootstrapExternalStaticDNS(instance.getBootstrapExternalStaticDNS());
        this.withBootstrapExternalStaticGateway(instance.getBootstrapExternalStaticGateway());
        this.withBootstrapExternalStaticIP(instance.getBootstrapExternalStaticIP());
        this.withBootstrapOSImage(instance.getBootstrapOSImage());
        this.withBootstrapProvisioningIP(instance.getBootstrapProvisioningIP());
        this.withClusterOSImage(instance.getClusterOSImage());
        this.withClusterProvisioningIP(instance.getClusterProvisioningIP());
        this.withDefaultMachinePlatform(instance.getDefaultMachinePlatform());
        this.withExternalBridge(instance.getExternalBridge());
        this.withExternalMACAddress(instance.getExternalMACAddress());
        this.withHosts(instance.getHosts());
        this.withIngressVIP(instance.getIngressVIP());
        this.withIngressVIPs(instance.getIngressVIPs());
        this.withLibvirtURI(instance.getLibvirtURI());
        this.withLoadBalancer(instance.getLoadBalancer());
        this.withProvisioningBridge(instance.getProvisioningBridge());
        this.withProvisioningDHCPExternal(instance.getProvisioningDHCPExternal());
        this.withProvisioningDHCPRange(instance.getProvisioningDHCPRange());
        this.withProvisioningHostIP(instance.getProvisioningHostIP());
        this.withProvisioningMACAddress(instance.getProvisioningMACAddress());
        this.withProvisioningNetwork(instance.getProvisioningNetwork());
        this.withProvisioningNetworkCIDR(instance.getProvisioningNetworkCIDR());
        this.withProvisioningNetworkInterface(instance.getProvisioningNetworkInterface());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DefaultMachinePlatformNested<A> editDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(null));
  }
  
  public HostsNested<A> editFirstHost() {
    if (hosts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "hosts"));
    }
    return this.setNewHostLike(0, this.buildHost(0));
  }
  
  public HostsNested<A> editHost(int index) {
    if (hosts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "hosts"));
    }
    return this.setNewHostLike(index, this.buildHost(index));
  }
  
  public HostsNested<A> editLastHost() {
    int index = hosts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "hosts"));
    }
    return this.setNewHostLike(index, this.buildHost(index));
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
    if (!(Objects.equals(additionalNTPServers, that.additionalNTPServers))) {
      return false;
    }
    if (!(Objects.equals(apiVIP, that.apiVIP))) {
      return false;
    }
    if (!(Objects.equals(apiVIPs, that.apiVIPs))) {
      return false;
    }
    if (!(Objects.equals(bmcVerifyCA, that.bmcVerifyCA))) {
      return false;
    }
    if (!(Objects.equals(bootstrapExternalStaticDNS, that.bootstrapExternalStaticDNS))) {
      return false;
    }
    if (!(Objects.equals(bootstrapExternalStaticGateway, that.bootstrapExternalStaticGateway))) {
      return false;
    }
    if (!(Objects.equals(bootstrapExternalStaticIP, that.bootstrapExternalStaticIP))) {
      return false;
    }
    if (!(Objects.equals(bootstrapOSImage, that.bootstrapOSImage))) {
      return false;
    }
    if (!(Objects.equals(bootstrapProvisioningIP, that.bootstrapProvisioningIP))) {
      return false;
    }
    if (!(Objects.equals(clusterOSImage, that.clusterOSImage))) {
      return false;
    }
    if (!(Objects.equals(clusterProvisioningIP, that.clusterProvisioningIP))) {
      return false;
    }
    if (!(Objects.equals(defaultMachinePlatform, that.defaultMachinePlatform))) {
      return false;
    }
    if (!(Objects.equals(externalBridge, that.externalBridge))) {
      return false;
    }
    if (!(Objects.equals(externalMACAddress, that.externalMACAddress))) {
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
    if (!(Objects.equals(libvirtURI, that.libvirtURI))) {
      return false;
    }
    if (!(Objects.equals(loadBalancer, that.loadBalancer))) {
      return false;
    }
    if (!(Objects.equals(provisioningBridge, that.provisioningBridge))) {
      return false;
    }
    if (!(Objects.equals(provisioningDHCPExternal, that.provisioningDHCPExternal))) {
      return false;
    }
    if (!(Objects.equals(provisioningDHCPRange, that.provisioningDHCPRange))) {
      return false;
    }
    if (!(Objects.equals(provisioningHostIP, that.provisioningHostIP))) {
      return false;
    }
    if (!(Objects.equals(provisioningMACAddress, that.provisioningMACAddress))) {
      return false;
    }
    if (!(Objects.equals(provisioningNetwork, that.provisioningNetwork))) {
      return false;
    }
    if (!(Objects.equals(provisioningNetworkCIDR, that.provisioningNetworkCIDR))) {
      return false;
    }
    if (!(Objects.equals(provisioningNetworkInterface, that.provisioningNetworkInterface))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAdditionalNTPServer(int index) {
    return this.additionalNTPServers.get(index);
  }
  
  public List<String> getAdditionalNTPServers() {
    return this.additionalNTPServers;
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
  
  public String getBmcVerifyCA() {
    return this.bmcVerifyCA;
  }
  
  public String getBootstrapExternalStaticDNS() {
    return this.bootstrapExternalStaticDNS;
  }
  
  public String getBootstrapExternalStaticGateway() {
    return this.bootstrapExternalStaticGateway;
  }
  
  public String getBootstrapExternalStaticIP() {
    return this.bootstrapExternalStaticIP;
  }
  
  public String getBootstrapOSImage() {
    return this.bootstrapOSImage;
  }
  
  public String getBootstrapProvisioningIP() {
    return this.bootstrapProvisioningIP;
  }
  
  public String getClusterOSImage() {
    return this.clusterOSImage;
  }
  
  public String getClusterProvisioningIP() {
    return this.clusterProvisioningIP;
  }
  
  public String getExternalBridge() {
    return this.externalBridge;
  }
  
  public String getExternalMACAddress() {
    return this.externalMACAddress;
  }
  
  public String getFirstAdditionalNTPServer() {
    return this.additionalNTPServers.get(0);
  }
  
  public String getFirstApiVIP() {
    return this.apiVIPs.get(0);
  }
  
  public String getFirstIngressVIP() {
    return this.ingressVIPs.get(0);
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
  
  public String getLastAdditionalNTPServer() {
    return this.additionalNTPServers.get(additionalNTPServers.size() - 1);
  }
  
  public String getLastApiVIP() {
    return this.apiVIPs.get(apiVIPs.size() - 1);
  }
  
  public String getLastIngressVIP() {
    return this.ingressVIPs.get(ingressVIPs.size() - 1);
  }
  
  public String getLibvirtURI() {
    return this.libvirtURI;
  }
  
  public BareMetalPlatformLoadBalancer getLoadBalancer() {
    return this.loadBalancer;
  }
  
  public String getMatchingAdditionalNTPServer(Predicate<String> predicate) {
      for (String item : additionalNTPServers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
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
  
  public String getProvisioningBridge() {
    return this.provisioningBridge;
  }
  
  public Boolean getProvisioningDHCPExternal() {
    return this.provisioningDHCPExternal;
  }
  
  public String getProvisioningDHCPRange() {
    return this.provisioningDHCPRange;
  }
  
  public String getProvisioningHostIP() {
    return this.provisioningHostIP;
  }
  
  public String getProvisioningMACAddress() {
    return this.provisioningMACAddress;
  }
  
  public String getProvisioningNetwork() {
    return this.provisioningNetwork;
  }
  
  public String getProvisioningNetworkCIDR() {
    return this.provisioningNetworkCIDR;
  }
  
  public String getProvisioningNetworkInterface() {
    return this.provisioningNetworkInterface;
  }
  
  public boolean hasAdditionalNTPServers() {
    return this.additionalNTPServers != null && !(this.additionalNTPServers.isEmpty());
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
  
  public boolean hasBmcVerifyCA() {
    return this.bmcVerifyCA != null;
  }
  
  public boolean hasBootstrapExternalStaticDNS() {
    return this.bootstrapExternalStaticDNS != null;
  }
  
  public boolean hasBootstrapExternalStaticGateway() {
    return this.bootstrapExternalStaticGateway != null;
  }
  
  public boolean hasBootstrapExternalStaticIP() {
    return this.bootstrapExternalStaticIP != null;
  }
  
  public boolean hasBootstrapOSImage() {
    return this.bootstrapOSImage != null;
  }
  
  public boolean hasBootstrapProvisioningIP() {
    return this.bootstrapProvisioningIP != null;
  }
  
  public boolean hasClusterOSImage() {
    return this.clusterOSImage != null;
  }
  
  public boolean hasClusterProvisioningIP() {
    return this.clusterProvisioningIP != null;
  }
  
  public boolean hasDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null;
  }
  
  public boolean hasExternalBridge() {
    return this.externalBridge != null;
  }
  
  public boolean hasExternalMACAddress() {
    return this.externalMACAddress != null;
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
  
  public boolean hasLibvirtURI() {
    return this.libvirtURI != null;
  }
  
  public boolean hasLoadBalancer() {
    return this.loadBalancer != null;
  }
  
  public boolean hasMatchingAdditionalNTPServer(Predicate<String> predicate) {
      for (String item : additionalNTPServers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingApiVIP(Predicate<String> predicate) {
      for (String item : apiVIPs) {
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
  
  public boolean hasProvisioningBridge() {
    return this.provisioningBridge != null;
  }
  
  public boolean hasProvisioningDHCPExternal() {
    return this.provisioningDHCPExternal != null;
  }
  
  public boolean hasProvisioningDHCPRange() {
    return this.provisioningDHCPRange != null;
  }
  
  public boolean hasProvisioningHostIP() {
    return this.provisioningHostIP != null;
  }
  
  public boolean hasProvisioningMACAddress() {
    return this.provisioningMACAddress != null;
  }
  
  public boolean hasProvisioningNetwork() {
    return this.provisioningNetwork != null;
  }
  
  public boolean hasProvisioningNetworkCIDR() {
    return this.provisioningNetworkCIDR != null;
  }
  
  public boolean hasProvisioningNetworkInterface() {
    return this.provisioningNetworkInterface != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalNTPServers, apiVIP, apiVIPs, bmcVerifyCA, bootstrapExternalStaticDNS, bootstrapExternalStaticGateway, bootstrapExternalStaticIP, bootstrapOSImage, bootstrapProvisioningIP, clusterOSImage, clusterProvisioningIP, defaultMachinePlatform, externalBridge, externalMACAddress, hosts, ingressVIP, ingressVIPs, libvirtURI, loadBalancer, provisioningBridge, provisioningDHCPExternal, provisioningDHCPRange, provisioningHostIP, provisioningMACAddress, provisioningNetwork, provisioningNetworkCIDR, provisioningNetworkInterface, additionalProperties);
  }
  
  public A removeAllFromAdditionalNTPServers(Collection<String> items) {
    if (this.additionalNTPServers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalNTPServers.remove(item);
    }
    return (A) this;
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
  
  public A removeFromAdditionalNTPServers(String... items) {
    if (this.additionalNTPServers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalNTPServers.remove(item);
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
  
  public HostsNested<A> setNewHostLike(int index,Host item) {
    return new HostsNested(index, item);
  }
  
  public A setToAdditionalNTPServers(int index,String item) {
    if (this.additionalNTPServers == null) {
      this.additionalNTPServers = new ArrayList();
    }
    this.additionalNTPServers.set(index, item);
    return (A) this;
  }
  
  public A setToApiVIPs(int index,String item) {
    if (this.apiVIPs == null) {
      this.apiVIPs = new ArrayList();
    }
    this.apiVIPs.set(index, item);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalNTPServers == null) && !(additionalNTPServers.isEmpty())) {
        sb.append("additionalNTPServers:");
        sb.append(additionalNTPServers);
        sb.append(",");
    }
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
    if (!(bmcVerifyCA == null)) {
        sb.append("bmcVerifyCA:");
        sb.append(bmcVerifyCA);
        sb.append(",");
    }
    if (!(bootstrapExternalStaticDNS == null)) {
        sb.append("bootstrapExternalStaticDNS:");
        sb.append(bootstrapExternalStaticDNS);
        sb.append(",");
    }
    if (!(bootstrapExternalStaticGateway == null)) {
        sb.append("bootstrapExternalStaticGateway:");
        sb.append(bootstrapExternalStaticGateway);
        sb.append(",");
    }
    if (!(bootstrapExternalStaticIP == null)) {
        sb.append("bootstrapExternalStaticIP:");
        sb.append(bootstrapExternalStaticIP);
        sb.append(",");
    }
    if (!(bootstrapOSImage == null)) {
        sb.append("bootstrapOSImage:");
        sb.append(bootstrapOSImage);
        sb.append(",");
    }
    if (!(bootstrapProvisioningIP == null)) {
        sb.append("bootstrapProvisioningIP:");
        sb.append(bootstrapProvisioningIP);
        sb.append(",");
    }
    if (!(clusterOSImage == null)) {
        sb.append("clusterOSImage:");
        sb.append(clusterOSImage);
        sb.append(",");
    }
    if (!(clusterProvisioningIP == null)) {
        sb.append("clusterProvisioningIP:");
        sb.append(clusterProvisioningIP);
        sb.append(",");
    }
    if (!(defaultMachinePlatform == null)) {
        sb.append("defaultMachinePlatform:");
        sb.append(defaultMachinePlatform);
        sb.append(",");
    }
    if (!(externalBridge == null)) {
        sb.append("externalBridge:");
        sb.append(externalBridge);
        sb.append(",");
    }
    if (!(externalMACAddress == null)) {
        sb.append("externalMACAddress:");
        sb.append(externalMACAddress);
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
    if (!(libvirtURI == null)) {
        sb.append("libvirtURI:");
        sb.append(libvirtURI);
        sb.append(",");
    }
    if (!(loadBalancer == null)) {
        sb.append("loadBalancer:");
        sb.append(loadBalancer);
        sb.append(",");
    }
    if (!(provisioningBridge == null)) {
        sb.append("provisioningBridge:");
        sb.append(provisioningBridge);
        sb.append(",");
    }
    if (!(provisioningDHCPExternal == null)) {
        sb.append("provisioningDHCPExternal:");
        sb.append(provisioningDHCPExternal);
        sb.append(",");
    }
    if (!(provisioningDHCPRange == null)) {
        sb.append("provisioningDHCPRange:");
        sb.append(provisioningDHCPRange);
        sb.append(",");
    }
    if (!(provisioningHostIP == null)) {
        sb.append("provisioningHostIP:");
        sb.append(provisioningHostIP);
        sb.append(",");
    }
    if (!(provisioningMACAddress == null)) {
        sb.append("provisioningMACAddress:");
        sb.append(provisioningMACAddress);
        sb.append(",");
    }
    if (!(provisioningNetwork == null)) {
        sb.append("provisioningNetwork:");
        sb.append(provisioningNetwork);
        sb.append(",");
    }
    if (!(provisioningNetworkCIDR == null)) {
        sb.append("provisioningNetworkCIDR:");
        sb.append(provisioningNetworkCIDR);
        sb.append(",");
    }
    if (!(provisioningNetworkInterface == null)) {
        sb.append("provisioningNetworkInterface:");
        sb.append(provisioningNetworkInterface);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalNTPServers(List<String> additionalNTPServers) {
    if (additionalNTPServers != null) {
        this.additionalNTPServers = new ArrayList();
        for (String item : additionalNTPServers) {
          this.addToAdditionalNTPServers(item);
        }
    } else {
      this.additionalNTPServers = null;
    }
    return (A) this;
  }
  
  public A withAdditionalNTPServers(String... additionalNTPServers) {
    if (this.additionalNTPServers != null) {
        this.additionalNTPServers.clear();
        _visitables.remove("additionalNTPServers");
    }
    if (additionalNTPServers != null) {
      for (String item : additionalNTPServers) {
        this.addToAdditionalNTPServers(item);
      }
    }
    return (A) this;
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
  
  public A withBmcVerifyCA(String bmcVerifyCA) {
    this.bmcVerifyCA = bmcVerifyCA;
    return (A) this;
  }
  
  public A withBootstrapExternalStaticDNS(String bootstrapExternalStaticDNS) {
    this.bootstrapExternalStaticDNS = bootstrapExternalStaticDNS;
    return (A) this;
  }
  
  public A withBootstrapExternalStaticGateway(String bootstrapExternalStaticGateway) {
    this.bootstrapExternalStaticGateway = bootstrapExternalStaticGateway;
    return (A) this;
  }
  
  public A withBootstrapExternalStaticIP(String bootstrapExternalStaticIP) {
    this.bootstrapExternalStaticIP = bootstrapExternalStaticIP;
    return (A) this;
  }
  
  public A withBootstrapOSImage(String bootstrapOSImage) {
    this.bootstrapOSImage = bootstrapOSImage;
    return (A) this;
  }
  
  public A withBootstrapProvisioningIP(String bootstrapProvisioningIP) {
    this.bootstrapProvisioningIP = bootstrapProvisioningIP;
    return (A) this;
  }
  
  public A withClusterOSImage(String clusterOSImage) {
    this.clusterOSImage = clusterOSImage;
    return (A) this;
  }
  
  public A withClusterProvisioningIP(String clusterProvisioningIP) {
    this.clusterProvisioningIP = clusterProvisioningIP;
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
  
  public A withExternalBridge(String externalBridge) {
    this.externalBridge = externalBridge;
    return (A) this;
  }
  
  public A withExternalMACAddress(String externalMACAddress) {
    this.externalMACAddress = externalMACAddress;
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
  
  public A withLibvirtURI(String libvirtURI) {
    this.libvirtURI = libvirtURI;
    return (A) this;
  }
  
  public A withLoadBalancer(BareMetalPlatformLoadBalancer loadBalancer) {
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
    return (A) this.withLoadBalancer(new BareMetalPlatformLoadBalancer(type));
  }
  
  public A withProvisioningBridge(String provisioningBridge) {
    this.provisioningBridge = provisioningBridge;
    return (A) this;
  }
  
  public A withProvisioningDHCPExternal() {
    return withProvisioningDHCPExternal(true);
  }
  
  public A withProvisioningDHCPExternal(Boolean provisioningDHCPExternal) {
    this.provisioningDHCPExternal = provisioningDHCPExternal;
    return (A) this;
  }
  
  public A withProvisioningDHCPRange(String provisioningDHCPRange) {
    this.provisioningDHCPRange = provisioningDHCPRange;
    return (A) this;
  }
  
  public A withProvisioningHostIP(String provisioningHostIP) {
    this.provisioningHostIP = provisioningHostIP;
    return (A) this;
  }
  
  public A withProvisioningMACAddress(String provisioningMACAddress) {
    this.provisioningMACAddress = provisioningMACAddress;
    return (A) this;
  }
  
  public A withProvisioningNetwork(String provisioningNetwork) {
    this.provisioningNetwork = provisioningNetwork;
    return (A) this;
  }
  
  public A withProvisioningNetworkCIDR(String provisioningNetworkCIDR) {
    this.provisioningNetworkCIDR = provisioningNetworkCIDR;
    return (A) this;
  }
  
  public A withProvisioningNetworkInterface(String provisioningNetworkInterface) {
    this.provisioningNetworkInterface = provisioningNetworkInterface;
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
}