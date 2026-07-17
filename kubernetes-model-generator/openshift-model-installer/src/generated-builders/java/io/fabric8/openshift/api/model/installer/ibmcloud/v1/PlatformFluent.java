package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.config.v1.IBMCloudServiceEndpoint;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.installer.ibmcloud.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> computeSubnets = new ArrayList<String>();
  private List<String> controlPlaneSubnets = new ArrayList<String>();
  private MachinePoolBuilder defaultMachinePlatform;
  private String networkResourceGroupName;
  private String region;
  private String resourceGroupName;
  private List<IBMCloudServiceEndpoint> serviceEndpoints = new ArrayList<IBMCloudServiceEndpoint>();
  private String vpcName;

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
    this.copyInstance(instance);
  }

  public A addAllToComputeSubnets(Collection<String> items) {
    if (this.computeSubnets == null) {
      this.computeSubnets = new ArrayList();
    }
    for (String item : items) {
      this.computeSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addAllToControlPlaneSubnets(Collection<String> items) {
    if (this.controlPlaneSubnets == null) {
      this.controlPlaneSubnets = new ArrayList();
    }
    for (String item : items) {
      this.controlPlaneSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addAllToServiceEndpoints(Collection<IBMCloudServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (IBMCloudServiceEndpoint item : items) {
      this.serviceEndpoints.add(item);
    }
    return (A) this;
  }
  
  public A addNewServiceEndpoint(String name,String url) {
    return (A) this.addToServiceEndpoints(new IBMCloudServiceEndpoint(name, url));
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
  
  public A addToComputeSubnets(String... items) {
    if (this.computeSubnets == null) {
      this.computeSubnets = new ArrayList();
    }
    for (String item : items) {
      this.computeSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addToComputeSubnets(int index,String item) {
    if (this.computeSubnets == null) {
      this.computeSubnets = new ArrayList();
    }
    this.computeSubnets.add(index, item);
    return (A) this;
  }
  
  public A addToControlPlaneSubnets(String... items) {
    if (this.controlPlaneSubnets == null) {
      this.controlPlaneSubnets = new ArrayList();
    }
    for (String item : items) {
      this.controlPlaneSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addToControlPlaneSubnets(int index,String item) {
    if (this.controlPlaneSubnets == null) {
      this.controlPlaneSubnets = new ArrayList();
    }
    this.controlPlaneSubnets.add(index, item);
    return (A) this;
  }
  
  public A addToServiceEndpoints(IBMCloudServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (IBMCloudServiceEndpoint item : items) {
      this.serviceEndpoints.add(item);
    }
    return (A) this;
  }
  
  public A addToServiceEndpoints(int index,IBMCloudServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    this.serviceEndpoints.add(index, item);
    return (A) this;
  }
  
  public MachinePool buildDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null ? this.defaultMachinePlatform.build() : null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withComputeSubnets(instance.getComputeSubnets());
        this.withControlPlaneSubnets(instance.getControlPlaneSubnets());
        this.withDefaultMachinePlatform(instance.getDefaultMachinePlatform());
        this.withNetworkResourceGroupName(instance.getNetworkResourceGroupName());
        this.withRegion(instance.getRegion());
        this.withResourceGroupName(instance.getResourceGroupName());
        this.withServiceEndpoints(instance.getServiceEndpoints());
        this.withVpcName(instance.getVpcName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DefaultMachinePlatformNested<A> editDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(null));
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
    if (!(Objects.equals(computeSubnets, that.computeSubnets))) {
      return false;
    }
    if (!(Objects.equals(controlPlaneSubnets, that.controlPlaneSubnets))) {
      return false;
    }
    if (!(Objects.equals(defaultMachinePlatform, that.defaultMachinePlatform))) {
      return false;
    }
    if (!(Objects.equals(networkResourceGroupName, that.networkResourceGroupName))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(resourceGroupName, that.resourceGroupName))) {
      return false;
    }
    if (!(Objects.equals(serviceEndpoints, that.serviceEndpoints))) {
      return false;
    }
    if (!(Objects.equals(vpcName, that.vpcName))) {
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
  
  public String getComputeSubnet(int index) {
    return this.computeSubnets.get(index);
  }
  
  public List<String> getComputeSubnets() {
    return this.computeSubnets;
  }
  
  public String getControlPlaneSubnet(int index) {
    return this.controlPlaneSubnets.get(index);
  }
  
  public List<String> getControlPlaneSubnets() {
    return this.controlPlaneSubnets;
  }
  
  public String getFirstComputeSubnet() {
    return this.computeSubnets.get(0);
  }
  
  public String getFirstControlPlaneSubnet() {
    return this.controlPlaneSubnets.get(0);
  }
  
  public IBMCloudServiceEndpoint getFirstServiceEndpoint() {
    return this.serviceEndpoints.get(0);
  }
  
  public String getLastComputeSubnet() {
    return this.computeSubnets.get(computeSubnets.size() - 1);
  }
  
  public String getLastControlPlaneSubnet() {
    return this.controlPlaneSubnets.get(controlPlaneSubnets.size() - 1);
  }
  
  public IBMCloudServiceEndpoint getLastServiceEndpoint() {
    return this.serviceEndpoints.get(serviceEndpoints.size() - 1);
  }
  
  public String getMatchingComputeSubnet(Predicate<String> predicate) {
      for (String item : computeSubnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingControlPlaneSubnet(Predicate<String> predicate) {
      for (String item : controlPlaneSubnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public IBMCloudServiceEndpoint getMatchingServiceEndpoint(Predicate<IBMCloudServiceEndpoint> predicate) {
      for (IBMCloudServiceEndpoint item : serviceEndpoints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNetworkResourceGroupName() {
    return this.networkResourceGroupName;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getResourceGroupName() {
    return this.resourceGroupName;
  }
  
  public IBMCloudServiceEndpoint getServiceEndpoint(int index) {
    return this.serviceEndpoints.get(index);
  }
  
  public List<IBMCloudServiceEndpoint> getServiceEndpoints() {
    return this.serviceEndpoints;
  }
  
  public String getVpcName() {
    return this.vpcName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComputeSubnets() {
    return this.computeSubnets != null && !(this.computeSubnets.isEmpty());
  }
  
  public boolean hasControlPlaneSubnets() {
    return this.controlPlaneSubnets != null && !(this.controlPlaneSubnets.isEmpty());
  }
  
  public boolean hasDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null;
  }
  
  public boolean hasMatchingComputeSubnet(Predicate<String> predicate) {
      for (String item : computeSubnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingControlPlaneSubnet(Predicate<String> predicate) {
      for (String item : controlPlaneSubnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingServiceEndpoint(Predicate<IBMCloudServiceEndpoint> predicate) {
      for (IBMCloudServiceEndpoint item : serviceEndpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworkResourceGroupName() {
    return this.networkResourceGroupName != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasResourceGroupName() {
    return this.resourceGroupName != null;
  }
  
  public boolean hasServiceEndpoints() {
    return this.serviceEndpoints != null && !(this.serviceEndpoints.isEmpty());
  }
  
  public boolean hasVpcName() {
    return this.vpcName != null;
  }
  
  public int hashCode() {
    return Objects.hash(computeSubnets, controlPlaneSubnets, defaultMachinePlatform, networkResourceGroupName, region, resourceGroupName, serviceEndpoints, vpcName, additionalProperties);
  }
  
  public A removeAllFromComputeSubnets(Collection<String> items) {
    if (this.computeSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.computeSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromControlPlaneSubnets(Collection<String> items) {
    if (this.controlPlaneSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.controlPlaneSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromServiceEndpoints(Collection<IBMCloudServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (IBMCloudServiceEndpoint item : items) {
      this.serviceEndpoints.remove(item);
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
  
  public A removeFromComputeSubnets(String... items) {
    if (this.computeSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.computeSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromControlPlaneSubnets(String... items) {
    if (this.controlPlaneSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.controlPlaneSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromServiceEndpoints(IBMCloudServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (IBMCloudServiceEndpoint item : items) {
      this.serviceEndpoints.remove(item);
    }
    return (A) this;
  }
  
  public A setToComputeSubnets(int index,String item) {
    if (this.computeSubnets == null) {
      this.computeSubnets = new ArrayList();
    }
    this.computeSubnets.set(index, item);
    return (A) this;
  }
  
  public A setToControlPlaneSubnets(int index,String item) {
    if (this.controlPlaneSubnets == null) {
      this.controlPlaneSubnets = new ArrayList();
    }
    this.controlPlaneSubnets.set(index, item);
    return (A) this;
  }
  
  public A setToServiceEndpoints(int index,IBMCloudServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    this.serviceEndpoints.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(computeSubnets == null) && !(computeSubnets.isEmpty())) {
        sb.append("computeSubnets:");
        sb.append(computeSubnets);
        sb.append(",");
    }
    if (!(controlPlaneSubnets == null) && !(controlPlaneSubnets.isEmpty())) {
        sb.append("controlPlaneSubnets:");
        sb.append(controlPlaneSubnets);
        sb.append(",");
    }
    if (!(defaultMachinePlatform == null)) {
        sb.append("defaultMachinePlatform:");
        sb.append(defaultMachinePlatform);
        sb.append(",");
    }
    if (!(networkResourceGroupName == null)) {
        sb.append("networkResourceGroupName:");
        sb.append(networkResourceGroupName);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(resourceGroupName == null)) {
        sb.append("resourceGroupName:");
        sb.append(resourceGroupName);
        sb.append(",");
    }
    if (!(serviceEndpoints == null) && !(serviceEndpoints.isEmpty())) {
        sb.append("serviceEndpoints:");
        sb.append(serviceEndpoints);
        sb.append(",");
    }
    if (!(vpcName == null)) {
        sb.append("vpcName:");
        sb.append(vpcName);
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
  
  public A withComputeSubnets(List<String> computeSubnets) {
    if (computeSubnets != null) {
        this.computeSubnets = new ArrayList();
        for (String item : computeSubnets) {
          this.addToComputeSubnets(item);
        }
    } else {
      this.computeSubnets = null;
    }
    return (A) this;
  }
  
  public A withComputeSubnets(String... computeSubnets) {
    if (this.computeSubnets != null) {
        this.computeSubnets.clear();
        _visitables.remove("computeSubnets");
    }
    if (computeSubnets != null) {
      for (String item : computeSubnets) {
        this.addToComputeSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withControlPlaneSubnets(List<String> controlPlaneSubnets) {
    if (controlPlaneSubnets != null) {
        this.controlPlaneSubnets = new ArrayList();
        for (String item : controlPlaneSubnets) {
          this.addToControlPlaneSubnets(item);
        }
    } else {
      this.controlPlaneSubnets = null;
    }
    return (A) this;
  }
  
  public A withControlPlaneSubnets(String... controlPlaneSubnets) {
    if (this.controlPlaneSubnets != null) {
        this.controlPlaneSubnets.clear();
        _visitables.remove("controlPlaneSubnets");
    }
    if (controlPlaneSubnets != null) {
      for (String item : controlPlaneSubnets) {
        this.addToControlPlaneSubnets(item);
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
  
  public A withNetworkResourceGroupName(String networkResourceGroupName) {
    this.networkResourceGroupName = networkResourceGroupName;
    return (A) this;
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatform() {
    return new DefaultMachinePlatformNested(null);
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatformLike(MachinePool item) {
    return new DefaultMachinePlatformNested(item);
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withResourceGroupName(String resourceGroupName) {
    this.resourceGroupName = resourceGroupName;
    return (A) this;
  }
  
  public A withServiceEndpoints(List<IBMCloudServiceEndpoint> serviceEndpoints) {
    if (serviceEndpoints != null) {
        this.serviceEndpoints = new ArrayList();
        for (IBMCloudServiceEndpoint item : serviceEndpoints) {
          this.addToServiceEndpoints(item);
        }
    } else {
      this.serviceEndpoints = null;
    }
    return (A) this;
  }
  
  public A withServiceEndpoints(IBMCloudServiceEndpoint... serviceEndpoints) {
    if (this.serviceEndpoints != null) {
        this.serviceEndpoints.clear();
        _visitables.remove("serviceEndpoints");
    }
    if (serviceEndpoints != null) {
      for (IBMCloudServiceEndpoint item : serviceEndpoints) {
        this.addToServiceEndpoints(item);
      }
    }
    return (A) this;
  }
  
  public A withVpcName(String vpcName) {
    this.vpcName = vpcName;
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
}