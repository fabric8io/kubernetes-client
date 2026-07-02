package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NodeSystemInfoFluent<A extends io.fabric8.kubernetes.api.model.NodeSystemInfoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String architecture;
  private String bootID;
  private String containerRuntimeVersion;
  private String kernelVersion;
  private String kubeProxyVersion;
  private String kubeletVersion;
  private String machineID;
  private String operatingSystem;
  private String osImage;
  private NodeSwapStatusBuilder swap;
  private String systemUUID;

  public NodeSystemInfoFluent() {
  }
  
  public NodeSystemInfoFluent(NodeSystemInfo instance) {
    this.copyInstance(instance);
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
  
  public NodeSwapStatus buildSwap() {
    return this.swap != null ? this.swap.build() : null;
  }
  
  protected void copyInstance(NodeSystemInfo instance) {
    instance = instance != null ? instance : new NodeSystemInfo();
    if (instance != null) {
        this.withArchitecture(instance.getArchitecture());
        this.withBootID(instance.getBootID());
        this.withContainerRuntimeVersion(instance.getContainerRuntimeVersion());
        this.withKernelVersion(instance.getKernelVersion());
        this.withKubeProxyVersion(instance.getKubeProxyVersion());
        this.withKubeletVersion(instance.getKubeletVersion());
        this.withMachineID(instance.getMachineID());
        this.withOperatingSystem(instance.getOperatingSystem());
        this.withOsImage(instance.getOsImage());
        this.withSwap(instance.getSwap());
        this.withSystemUUID(instance.getSystemUUID());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SwapNested<A> editOrNewSwap() {
    return this.withNewSwapLike(Optional.ofNullable(this.buildSwap()).orElse(new NodeSwapStatusBuilder().build()));
  }
  
  public SwapNested<A> editOrNewSwapLike(NodeSwapStatus item) {
    return this.withNewSwapLike(Optional.ofNullable(this.buildSwap()).orElse(item));
  }
  
  public SwapNested<A> editSwap() {
    return this.withNewSwapLike(Optional.ofNullable(this.buildSwap()).orElse(null));
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
    NodeSystemInfoFluent that = (NodeSystemInfoFluent) o;
    if (!(Objects.equals(architecture, that.architecture))) {
      return false;
    }
    if (!(Objects.equals(bootID, that.bootID))) {
      return false;
    }
    if (!(Objects.equals(containerRuntimeVersion, that.containerRuntimeVersion))) {
      return false;
    }
    if (!(Objects.equals(kernelVersion, that.kernelVersion))) {
      return false;
    }
    if (!(Objects.equals(kubeProxyVersion, that.kubeProxyVersion))) {
      return false;
    }
    if (!(Objects.equals(kubeletVersion, that.kubeletVersion))) {
      return false;
    }
    if (!(Objects.equals(machineID, that.machineID))) {
      return false;
    }
    if (!(Objects.equals(operatingSystem, that.operatingSystem))) {
      return false;
    }
    if (!(Objects.equals(osImage, that.osImage))) {
      return false;
    }
    if (!(Objects.equals(swap, that.swap))) {
      return false;
    }
    if (!(Objects.equals(systemUUID, that.systemUUID))) {
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
  
  public String getArchitecture() {
    return this.architecture;
  }
  
  public String getBootID() {
    return this.bootID;
  }
  
  public String getContainerRuntimeVersion() {
    return this.containerRuntimeVersion;
  }
  
  public String getKernelVersion() {
    return this.kernelVersion;
  }
  
  public String getKubeProxyVersion() {
    return this.kubeProxyVersion;
  }
  
  public String getKubeletVersion() {
    return this.kubeletVersion;
  }
  
  public String getMachineID() {
    return this.machineID;
  }
  
  public String getOperatingSystem() {
    return this.operatingSystem;
  }
  
  public String getOsImage() {
    return this.osImage;
  }
  
  public String getSystemUUID() {
    return this.systemUUID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArchitecture() {
    return this.architecture != null;
  }
  
  public boolean hasBootID() {
    return this.bootID != null;
  }
  
  public boolean hasContainerRuntimeVersion() {
    return this.containerRuntimeVersion != null;
  }
  
  public boolean hasKernelVersion() {
    return this.kernelVersion != null;
  }
  
  public boolean hasKubeProxyVersion() {
    return this.kubeProxyVersion != null;
  }
  
  public boolean hasKubeletVersion() {
    return this.kubeletVersion != null;
  }
  
  public boolean hasMachineID() {
    return this.machineID != null;
  }
  
  public boolean hasOperatingSystem() {
    return this.operatingSystem != null;
  }
  
  public boolean hasOsImage() {
    return this.osImage != null;
  }
  
  public boolean hasSwap() {
    return this.swap != null;
  }
  
  public boolean hasSystemUUID() {
    return this.systemUUID != null;
  }
  
  public int hashCode() {
    return Objects.hash(architecture, bootID, containerRuntimeVersion, kernelVersion, kubeProxyVersion, kubeletVersion, machineID, operatingSystem, osImage, swap, systemUUID, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(architecture == null)) {
        sb.append("architecture:");
        sb.append(architecture);
        sb.append(",");
    }
    if (!(bootID == null)) {
        sb.append("bootID:");
        sb.append(bootID);
        sb.append(",");
    }
    if (!(containerRuntimeVersion == null)) {
        sb.append("containerRuntimeVersion:");
        sb.append(containerRuntimeVersion);
        sb.append(",");
    }
    if (!(kernelVersion == null)) {
        sb.append("kernelVersion:");
        sb.append(kernelVersion);
        sb.append(",");
    }
    if (!(kubeProxyVersion == null)) {
        sb.append("kubeProxyVersion:");
        sb.append(kubeProxyVersion);
        sb.append(",");
    }
    if (!(kubeletVersion == null)) {
        sb.append("kubeletVersion:");
        sb.append(kubeletVersion);
        sb.append(",");
    }
    if (!(machineID == null)) {
        sb.append("machineID:");
        sb.append(machineID);
        sb.append(",");
    }
    if (!(operatingSystem == null)) {
        sb.append("operatingSystem:");
        sb.append(operatingSystem);
        sb.append(",");
    }
    if (!(osImage == null)) {
        sb.append("osImage:");
        sb.append(osImage);
        sb.append(",");
    }
    if (!(swap == null)) {
        sb.append("swap:");
        sb.append(swap);
        sb.append(",");
    }
    if (!(systemUUID == null)) {
        sb.append("systemUUID:");
        sb.append(systemUUID);
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
  
  public A withArchitecture(String architecture) {
    this.architecture = architecture;
    return (A) this;
  }
  
  public A withBootID(String bootID) {
    this.bootID = bootID;
    return (A) this;
  }
  
  public A withContainerRuntimeVersion(String containerRuntimeVersion) {
    this.containerRuntimeVersion = containerRuntimeVersion;
    return (A) this;
  }
  
  public A withKernelVersion(String kernelVersion) {
    this.kernelVersion = kernelVersion;
    return (A) this;
  }
  
  public A withKubeProxyVersion(String kubeProxyVersion) {
    this.kubeProxyVersion = kubeProxyVersion;
    return (A) this;
  }
  
  public A withKubeletVersion(String kubeletVersion) {
    this.kubeletVersion = kubeletVersion;
    return (A) this;
  }
  
  public A withMachineID(String machineID) {
    this.machineID = machineID;
    return (A) this;
  }
  
  public SwapNested<A> withNewSwap() {
    return new SwapNested(null);
  }
  
  public A withNewSwap(Long capacity) {
    return (A) this.withSwap(new NodeSwapStatus(capacity));
  }
  
  public SwapNested<A> withNewSwapLike(NodeSwapStatus item) {
    return new SwapNested(item);
  }
  
  public A withOperatingSystem(String operatingSystem) {
    this.operatingSystem = operatingSystem;
    return (A) this;
  }
  
  public A withOsImage(String osImage) {
    this.osImage = osImage;
    return (A) this;
  }
  
  public A withSwap(NodeSwapStatus swap) {
    this._visitables.remove("swap");
    if (swap != null) {
        this.swap = new NodeSwapStatusBuilder(swap);
        this._visitables.get("swap").add(this.swap);
    } else {
        this.swap = null;
        this._visitables.get("swap").remove(this.swap);
    }
    return (A) this;
  }
  
  public A withSystemUUID(String systemUUID) {
    this.systemUUID = systemUUID;
    return (A) this;
  }
  public class SwapNested<N> extends NodeSwapStatusFluent<SwapNested<N>> implements Nested<N>{
  
    NodeSwapStatusBuilder builder;
  
    SwapNested(NodeSwapStatus item) {
      this.builder = new NodeSwapStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeSystemInfoFluent.this.withSwap(builder.build());
    }
    
    public N endSwap() {
      return and();
    }
    
  }
}