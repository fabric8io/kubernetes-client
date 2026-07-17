package io.fabric8.openshift.api.model.installer.powervc.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.config.v1.OpenStackPlatformLoadBalancer;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.installer.powervc.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiFloatingIP;
  private List<String> apiVIPs = new ArrayList<String>();
  private String cloud;
  private String clusterOSImage;
  private Map<String,String> clusterOSImageProperties;
  private PortTargetBuilder controlPlanePort;
  private MachinePoolBuilder defaultMachinePlatform;
  private List<String> externalDNS = new ArrayList<String>();
  private String externalNetwork;
  private String imageName;
  private String ingressFloatingIP;
  private List<String> ingressVIPs = new ArrayList<String>();
  private OpenStackPlatformLoadBalancer loadBalancer;

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
  
  public A addAllToExternalDNS(Collection<String> items) {
    if (this.externalDNS == null) {
      this.externalDNS = new ArrayList();
    }
    for (String item : items) {
      this.externalDNS.add(item);
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
  
  public A addToClusterOSImageProperties(Map<String,String> map) {
    if (this.clusterOSImageProperties == null && map != null) {
      this.clusterOSImageProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.clusterOSImageProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToClusterOSImageProperties(String key,String value) {
    if (this.clusterOSImageProperties == null && key != null && value != null) {
      this.clusterOSImageProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.clusterOSImageProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToExternalDNS(String... items) {
    if (this.externalDNS == null) {
      this.externalDNS = new ArrayList();
    }
    for (String item : items) {
      this.externalDNS.add(item);
    }
    return (A) this;
  }
  
  public A addToExternalDNS(int index,String item) {
    if (this.externalDNS == null) {
      this.externalDNS = new ArrayList();
    }
    this.externalDNS.add(index, item);
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
  
  public PortTarget buildControlPlanePort() {
    return this.controlPlanePort != null ? this.controlPlanePort.build() : null;
  }
  
  public MachinePool buildDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null ? this.defaultMachinePlatform.build() : null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withApiFloatingIP(instance.getApiFloatingIP());
        this.withApiVIPs(instance.getApiVIPs());
        this.withCloud(instance.getCloud());
        this.withClusterOSImage(instance.getClusterOSImage());
        this.withClusterOSImageProperties(instance.getClusterOSImageProperties());
        this.withControlPlanePort(instance.getControlPlanePort());
        this.withDefaultMachinePlatform(instance.getDefaultMachinePlatform());
        this.withExternalDNS(instance.getExternalDNS());
        this.withExternalNetwork(instance.getExternalNetwork());
        this.withImageName(instance.getImageName());
        this.withIngressFloatingIP(instance.getIngressFloatingIP());
        this.withIngressVIPs(instance.getIngressVIPs());
        this.withLoadBalancer(instance.getLoadBalancer());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ControlPlanePortNested<A> editControlPlanePort() {
    return this.withNewControlPlanePortLike(Optional.ofNullable(this.buildControlPlanePort()).orElse(null));
  }
  
  public DefaultMachinePlatformNested<A> editDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(null));
  }
  
  public ControlPlanePortNested<A> editOrNewControlPlanePort() {
    return this.withNewControlPlanePortLike(Optional.ofNullable(this.buildControlPlanePort()).orElse(new PortTargetBuilder().build()));
  }
  
  public ControlPlanePortNested<A> editOrNewControlPlanePortLike(PortTarget item) {
    return this.withNewControlPlanePortLike(Optional.ofNullable(this.buildControlPlanePort()).orElse(item));
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
    if (!(Objects.equals(apiFloatingIP, that.apiFloatingIP))) {
      return false;
    }
    if (!(Objects.equals(apiVIPs, that.apiVIPs))) {
      return false;
    }
    if (!(Objects.equals(cloud, that.cloud))) {
      return false;
    }
    if (!(Objects.equals(clusterOSImage, that.clusterOSImage))) {
      return false;
    }
    if (!(Objects.equals(clusterOSImageProperties, that.clusterOSImageProperties))) {
      return false;
    }
    if (!(Objects.equals(controlPlanePort, that.controlPlanePort))) {
      return false;
    }
    if (!(Objects.equals(defaultMachinePlatform, that.defaultMachinePlatform))) {
      return false;
    }
    if (!(Objects.equals(externalDNS, that.externalDNS))) {
      return false;
    }
    if (!(Objects.equals(externalNetwork, that.externalNetwork))) {
      return false;
    }
    if (!(Objects.equals(imageName, that.imageName))) {
      return false;
    }
    if (!(Objects.equals(ingressFloatingIP, that.ingressFloatingIP))) {
      return false;
    }
    if (!(Objects.equals(ingressVIPs, that.ingressVIPs))) {
      return false;
    }
    if (!(Objects.equals(loadBalancer, that.loadBalancer))) {
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
  
  public String getApiFloatingIP() {
    return this.apiFloatingIP;
  }
  
  public String getApiVIP(int index) {
    return this.apiVIPs.get(index);
  }
  
  public List<String> getApiVIPs() {
    return this.apiVIPs;
  }
  
  public String getCloud() {
    return this.cloud;
  }
  
  public String getClusterOSImage() {
    return this.clusterOSImage;
  }
  
  public Map<String,String> getClusterOSImageProperties() {
    return this.clusterOSImageProperties;
  }
  
  public String getExternalDN(int index) {
    return this.externalDNS.get(index);
  }
  
  public List<String> getExternalDNS() {
    return this.externalDNS;
  }
  
  public String getExternalNetwork() {
    return this.externalNetwork;
  }
  
  public String getFirstApiVIP() {
    return this.apiVIPs.get(0);
  }
  
  public String getFirstExternalDN() {
    return this.externalDNS.get(0);
  }
  
  public String getFirstIngressVIP() {
    return this.ingressVIPs.get(0);
  }
  
  public String getImageName() {
    return this.imageName;
  }
  
  public String getIngressFloatingIP() {
    return this.ingressFloatingIP;
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
  
  public String getLastExternalDN() {
    return this.externalDNS.get(externalDNS.size() - 1);
  }
  
  public String getLastIngressVIP() {
    return this.ingressVIPs.get(ingressVIPs.size() - 1);
  }
  
  public OpenStackPlatformLoadBalancer getLoadBalancer() {
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
  
  public String getMatchingExternalDN(Predicate<String> predicate) {
      for (String item : externalDNS) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiFloatingIP() {
    return this.apiFloatingIP != null;
  }
  
  public boolean hasApiVIPs() {
    return this.apiVIPs != null && !(this.apiVIPs.isEmpty());
  }
  
  public boolean hasCloud() {
    return this.cloud != null;
  }
  
  public boolean hasClusterOSImage() {
    return this.clusterOSImage != null;
  }
  
  public boolean hasClusterOSImageProperties() {
    return this.clusterOSImageProperties != null;
  }
  
  public boolean hasControlPlanePort() {
    return this.controlPlanePort != null;
  }
  
  public boolean hasDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null;
  }
  
  public boolean hasExternalDNS() {
    return this.externalDNS != null && !(this.externalDNS.isEmpty());
  }
  
  public boolean hasExternalNetwork() {
    return this.externalNetwork != null;
  }
  
  public boolean hasImageName() {
    return this.imageName != null;
  }
  
  public boolean hasIngressFloatingIP() {
    return this.ingressFloatingIP != null;
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
  
  public boolean hasMatchingExternalDN(Predicate<String> predicate) {
      for (String item : externalDNS) {
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
  
  public int hashCode() {
    return Objects.hash(apiFloatingIP, apiVIPs, cloud, clusterOSImage, clusterOSImageProperties, controlPlanePort, defaultMachinePlatform, externalDNS, externalNetwork, imageName, ingressFloatingIP, ingressVIPs, loadBalancer, additionalProperties);
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
  
  public A removeAllFromExternalDNS(Collection<String> items) {
    if (this.externalDNS == null) {
      return (A) this;
    }
    for (String item : items) {
      this.externalDNS.remove(item);
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
  
  public A removeFromClusterOSImageProperties(String key) {
    if (this.clusterOSImageProperties == null) {
      return (A) this;
    }
    if (key != null && this.clusterOSImageProperties != null) {
      this.clusterOSImageProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromClusterOSImageProperties(Map<String,String> map) {
    if (this.clusterOSImageProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.clusterOSImageProperties != null) {
          this.clusterOSImageProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromExternalDNS(String... items) {
    if (this.externalDNS == null) {
      return (A) this;
    }
    for (String item : items) {
      this.externalDNS.remove(item);
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
  
  public A setToApiVIPs(int index,String item) {
    if (this.apiVIPs == null) {
      this.apiVIPs = new ArrayList();
    }
    this.apiVIPs.set(index, item);
    return (A) this;
  }
  
  public A setToExternalDNS(int index,String item) {
    if (this.externalDNS == null) {
      this.externalDNS = new ArrayList();
    }
    this.externalDNS.set(index, item);
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
    if (!(apiFloatingIP == null)) {
        sb.append("apiFloatingIP:");
        sb.append(apiFloatingIP);
        sb.append(",");
    }
    if (!(apiVIPs == null) && !(apiVIPs.isEmpty())) {
        sb.append("apiVIPs:");
        sb.append(apiVIPs);
        sb.append(",");
    }
    if (!(cloud == null)) {
        sb.append("cloud:");
        sb.append(cloud);
        sb.append(",");
    }
    if (!(clusterOSImage == null)) {
        sb.append("clusterOSImage:");
        sb.append(clusterOSImage);
        sb.append(",");
    }
    if (!(clusterOSImageProperties == null) && !(clusterOSImageProperties.isEmpty())) {
        sb.append("clusterOSImageProperties:");
        sb.append(clusterOSImageProperties);
        sb.append(",");
    }
    if (!(controlPlanePort == null)) {
        sb.append("controlPlanePort:");
        sb.append(controlPlanePort);
        sb.append(",");
    }
    if (!(defaultMachinePlatform == null)) {
        sb.append("defaultMachinePlatform:");
        sb.append(defaultMachinePlatform);
        sb.append(",");
    }
    if (!(externalDNS == null) && !(externalDNS.isEmpty())) {
        sb.append("externalDNS:");
        sb.append(externalDNS);
        sb.append(",");
    }
    if (!(externalNetwork == null)) {
        sb.append("externalNetwork:");
        sb.append(externalNetwork);
        sb.append(",");
    }
    if (!(imageName == null)) {
        sb.append("imageName:");
        sb.append(imageName);
        sb.append(",");
    }
    if (!(ingressFloatingIP == null)) {
        sb.append("ingressFloatingIP:");
        sb.append(ingressFloatingIP);
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
  
  public A withApiFloatingIP(String apiFloatingIP) {
    this.apiFloatingIP = apiFloatingIP;
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
  
  public A withCloud(String cloud) {
    this.cloud = cloud;
    return (A) this;
  }
  
  public A withClusterOSImage(String clusterOSImage) {
    this.clusterOSImage = clusterOSImage;
    return (A) this;
  }
  
  public <K,V>A withClusterOSImageProperties(Map<String,String> clusterOSImageProperties) {
    if (clusterOSImageProperties == null) {
      this.clusterOSImageProperties = null;
    } else {
      this.clusterOSImageProperties = new LinkedHashMap(clusterOSImageProperties);
    }
    return (A) this;
  }
  
  public A withControlPlanePort(PortTarget controlPlanePort) {
    this._visitables.remove("controlPlanePort");
    if (controlPlanePort != null) {
        this.controlPlanePort = new PortTargetBuilder(controlPlanePort);
        this._visitables.get("controlPlanePort").add(this.controlPlanePort);
    } else {
        this.controlPlanePort = null;
        this._visitables.get("controlPlanePort").remove(this.controlPlanePort);
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
  
  public A withExternalDNS(List<String> externalDNS) {
    if (externalDNS != null) {
        this.externalDNS = new ArrayList();
        for (String item : externalDNS) {
          this.addToExternalDNS(item);
        }
    } else {
      this.externalDNS = null;
    }
    return (A) this;
  }
  
  public A withExternalDNS(String... externalDNS) {
    if (this.externalDNS != null) {
        this.externalDNS.clear();
        _visitables.remove("externalDNS");
    }
    if (externalDNS != null) {
      for (String item : externalDNS) {
        this.addToExternalDNS(item);
      }
    }
    return (A) this;
  }
  
  public A withExternalNetwork(String externalNetwork) {
    this.externalNetwork = externalNetwork;
    return (A) this;
  }
  
  public A withImageName(String imageName) {
    this.imageName = imageName;
    return (A) this;
  }
  
  public A withIngressFloatingIP(String ingressFloatingIP) {
    this.ingressFloatingIP = ingressFloatingIP;
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
  
  public A withLoadBalancer(OpenStackPlatformLoadBalancer loadBalancer) {
    this.loadBalancer = loadBalancer;
    return (A) this;
  }
  
  public ControlPlanePortNested<A> withNewControlPlanePort() {
    return new ControlPlanePortNested(null);
  }
  
  public ControlPlanePortNested<A> withNewControlPlanePortLike(PortTarget item) {
    return new ControlPlanePortNested(item);
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatform() {
    return new DefaultMachinePlatformNested(null);
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatformLike(MachinePool item) {
    return new DefaultMachinePlatformNested(item);
  }
  
  public A withNewLoadBalancer(String type) {
    return (A) this.withLoadBalancer(new OpenStackPlatformLoadBalancer(type));
  }
  public class ControlPlanePortNested<N> extends PortTargetFluent<ControlPlanePortNested<N>> implements Nested<N>{
  
    PortTargetBuilder builder;
  
    ControlPlanePortNested(PortTarget item) {
      this.builder = new PortTargetBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withControlPlanePort(builder.build());
    }
    
    public N endControlPlanePort() {
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