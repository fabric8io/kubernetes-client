package io.fabric8.openshift.api.model.installer.powervs.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.config.v1.PowerVSServiceEndpoint;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.installer.powervs.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clusterOSImage;
  private MachinePoolBuilder defaultMachinePlatform;
  private String powervsResourceGroup;
  private String region;
  private List<PowerVSServiceEndpoint> serviceEndpoints = new ArrayList<PowerVSServiceEndpoint>();
  private String serviceInstanceGUID;
  private String tgName;
  private String userID;
  private String vpcName;
  private String vpcRegion;
  private List<String> vpcSubnets = new ArrayList<String>();
  private String zone;

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
    this.copyInstance(instance);
  }

  public A addAllToServiceEndpoints(Collection<PowerVSServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (PowerVSServiceEndpoint item : items) {
      this.serviceEndpoints.add(item);
    }
    return (A) this;
  }
  
  public A addAllToVpcSubnets(Collection<String> items) {
    if (this.vpcSubnets == null) {
      this.vpcSubnets = new ArrayList();
    }
    for (String item : items) {
      this.vpcSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addNewServiceEndpoint(String name,String url) {
    return (A) this.addToServiceEndpoints(new PowerVSServiceEndpoint(name, url));
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
  
  public A addToServiceEndpoints(PowerVSServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (PowerVSServiceEndpoint item : items) {
      this.serviceEndpoints.add(item);
    }
    return (A) this;
  }
  
  public A addToServiceEndpoints(int index,PowerVSServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    this.serviceEndpoints.add(index, item);
    return (A) this;
  }
  
  public A addToVpcSubnets(String... items) {
    if (this.vpcSubnets == null) {
      this.vpcSubnets = new ArrayList();
    }
    for (String item : items) {
      this.vpcSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addToVpcSubnets(int index,String item) {
    if (this.vpcSubnets == null) {
      this.vpcSubnets = new ArrayList();
    }
    this.vpcSubnets.add(index, item);
    return (A) this;
  }
  
  public MachinePool buildDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null ? this.defaultMachinePlatform.build() : null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withClusterOSImage(instance.getClusterOSImage());
        this.withDefaultMachinePlatform(instance.getDefaultMachinePlatform());
        this.withPowervsResourceGroup(instance.getPowervsResourceGroup());
        this.withRegion(instance.getRegion());
        this.withServiceEndpoints(instance.getServiceEndpoints());
        this.withServiceInstanceGUID(instance.getServiceInstanceGUID());
        this.withTgName(instance.getTgName());
        this.withUserID(instance.getUserID());
        this.withVpcName(instance.getVpcName());
        this.withVpcRegion(instance.getVpcRegion());
        this.withVpcSubnets(instance.getVpcSubnets());
        this.withZone(instance.getZone());
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
    if (!(Objects.equals(clusterOSImage, that.clusterOSImage))) {
      return false;
    }
    if (!(Objects.equals(defaultMachinePlatform, that.defaultMachinePlatform))) {
      return false;
    }
    if (!(Objects.equals(powervsResourceGroup, that.powervsResourceGroup))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(serviceEndpoints, that.serviceEndpoints))) {
      return false;
    }
    if (!(Objects.equals(serviceInstanceGUID, that.serviceInstanceGUID))) {
      return false;
    }
    if (!(Objects.equals(tgName, that.tgName))) {
      return false;
    }
    if (!(Objects.equals(userID, that.userID))) {
      return false;
    }
    if (!(Objects.equals(vpcName, that.vpcName))) {
      return false;
    }
    if (!(Objects.equals(vpcRegion, that.vpcRegion))) {
      return false;
    }
    if (!(Objects.equals(vpcSubnets, that.vpcSubnets))) {
      return false;
    }
    if (!(Objects.equals(zone, that.zone))) {
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
  
  public String getClusterOSImage() {
    return this.clusterOSImage;
  }
  
  public PowerVSServiceEndpoint getFirstServiceEndpoint() {
    return this.serviceEndpoints.get(0);
  }
  
  public String getFirstVpcSubnet() {
    return this.vpcSubnets.get(0);
  }
  
  public PowerVSServiceEndpoint getLastServiceEndpoint() {
    return this.serviceEndpoints.get(serviceEndpoints.size() - 1);
  }
  
  public String getLastVpcSubnet() {
    return this.vpcSubnets.get(vpcSubnets.size() - 1);
  }
  
  public PowerVSServiceEndpoint getMatchingServiceEndpoint(Predicate<PowerVSServiceEndpoint> predicate) {
      for (PowerVSServiceEndpoint item : serviceEndpoints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingVpcSubnet(Predicate<String> predicate) {
      for (String item : vpcSubnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPowervsResourceGroup() {
    return this.powervsResourceGroup;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public PowerVSServiceEndpoint getServiceEndpoint(int index) {
    return this.serviceEndpoints.get(index);
  }
  
  public List<PowerVSServiceEndpoint> getServiceEndpoints() {
    return this.serviceEndpoints;
  }
  
  public String getServiceInstanceGUID() {
    return this.serviceInstanceGUID;
  }
  
  public String getTgName() {
    return this.tgName;
  }
  
  public String getUserID() {
    return this.userID;
  }
  
  public String getVpcName() {
    return this.vpcName;
  }
  
  public String getVpcRegion() {
    return this.vpcRegion;
  }
  
  public String getVpcSubnet(int index) {
    return this.vpcSubnets.get(index);
  }
  
  public List<String> getVpcSubnets() {
    return this.vpcSubnets;
  }
  
  public String getZone() {
    return this.zone;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterOSImage() {
    return this.clusterOSImage != null;
  }
  
  public boolean hasDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null;
  }
  
  public boolean hasMatchingServiceEndpoint(Predicate<PowerVSServiceEndpoint> predicate) {
      for (PowerVSServiceEndpoint item : serviceEndpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVpcSubnet(Predicate<String> predicate) {
      for (String item : vpcSubnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPowervsResourceGroup() {
    return this.powervsResourceGroup != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasServiceEndpoints() {
    return this.serviceEndpoints != null && !(this.serviceEndpoints.isEmpty());
  }
  
  public boolean hasServiceInstanceGUID() {
    return this.serviceInstanceGUID != null;
  }
  
  public boolean hasTgName() {
    return this.tgName != null;
  }
  
  public boolean hasUserID() {
    return this.userID != null;
  }
  
  public boolean hasVpcName() {
    return this.vpcName != null;
  }
  
  public boolean hasVpcRegion() {
    return this.vpcRegion != null;
  }
  
  public boolean hasVpcSubnets() {
    return this.vpcSubnets != null && !(this.vpcSubnets.isEmpty());
  }
  
  public boolean hasZone() {
    return this.zone != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterOSImage, defaultMachinePlatform, powervsResourceGroup, region, serviceEndpoints, serviceInstanceGUID, tgName, userID, vpcName, vpcRegion, vpcSubnets, zone, additionalProperties);
  }
  
  public A removeAllFromServiceEndpoints(Collection<PowerVSServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (PowerVSServiceEndpoint item : items) {
      this.serviceEndpoints.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromVpcSubnets(Collection<String> items) {
    if (this.vpcSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.vpcSubnets.remove(item);
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
  
  public A removeFromServiceEndpoints(PowerVSServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (PowerVSServiceEndpoint item : items) {
      this.serviceEndpoints.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromVpcSubnets(String... items) {
    if (this.vpcSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.vpcSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A setToServiceEndpoints(int index,PowerVSServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    this.serviceEndpoints.set(index, item);
    return (A) this;
  }
  
  public A setToVpcSubnets(int index,String item) {
    if (this.vpcSubnets == null) {
      this.vpcSubnets = new ArrayList();
    }
    this.vpcSubnets.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterOSImage == null)) {
        sb.append("clusterOSImage:");
        sb.append(clusterOSImage);
        sb.append(",");
    }
    if (!(defaultMachinePlatform == null)) {
        sb.append("defaultMachinePlatform:");
        sb.append(defaultMachinePlatform);
        sb.append(",");
    }
    if (!(powervsResourceGroup == null)) {
        sb.append("powervsResourceGroup:");
        sb.append(powervsResourceGroup);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(serviceEndpoints == null) && !(serviceEndpoints.isEmpty())) {
        sb.append("serviceEndpoints:");
        sb.append(serviceEndpoints);
        sb.append(",");
    }
    if (!(serviceInstanceGUID == null)) {
        sb.append("serviceInstanceGUID:");
        sb.append(serviceInstanceGUID);
        sb.append(",");
    }
    if (!(tgName == null)) {
        sb.append("tgName:");
        sb.append(tgName);
        sb.append(",");
    }
    if (!(userID == null)) {
        sb.append("userID:");
        sb.append(userID);
        sb.append(",");
    }
    if (!(vpcName == null)) {
        sb.append("vpcName:");
        sb.append(vpcName);
        sb.append(",");
    }
    if (!(vpcRegion == null)) {
        sb.append("vpcRegion:");
        sb.append(vpcRegion);
        sb.append(",");
    }
    if (!(vpcSubnets == null) && !(vpcSubnets.isEmpty())) {
        sb.append("vpcSubnets:");
        sb.append(vpcSubnets);
        sb.append(",");
    }
    if (!(zone == null)) {
        sb.append("zone:");
        sb.append(zone);
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
  
  public A withClusterOSImage(String clusterOSImage) {
    this.clusterOSImage = clusterOSImage;
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
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatform() {
    return new DefaultMachinePlatformNested(null);
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatformLike(MachinePool item) {
    return new DefaultMachinePlatformNested(item);
  }
  
  public A withPowervsResourceGroup(String powervsResourceGroup) {
    this.powervsResourceGroup = powervsResourceGroup;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withServiceEndpoints(List<PowerVSServiceEndpoint> serviceEndpoints) {
    if (serviceEndpoints != null) {
        this.serviceEndpoints = new ArrayList();
        for (PowerVSServiceEndpoint item : serviceEndpoints) {
          this.addToServiceEndpoints(item);
        }
    } else {
      this.serviceEndpoints = null;
    }
    return (A) this;
  }
  
  public A withServiceEndpoints(PowerVSServiceEndpoint... serviceEndpoints) {
    if (this.serviceEndpoints != null) {
        this.serviceEndpoints.clear();
        _visitables.remove("serviceEndpoints");
    }
    if (serviceEndpoints != null) {
      for (PowerVSServiceEndpoint item : serviceEndpoints) {
        this.addToServiceEndpoints(item);
      }
    }
    return (A) this;
  }
  
  public A withServiceInstanceGUID(String serviceInstanceGUID) {
    this.serviceInstanceGUID = serviceInstanceGUID;
    return (A) this;
  }
  
  public A withTgName(String tgName) {
    this.tgName = tgName;
    return (A) this;
  }
  
  public A withUserID(String userID) {
    this.userID = userID;
    return (A) this;
  }
  
  public A withVpcName(String vpcName) {
    this.vpcName = vpcName;
    return (A) this;
  }
  
  public A withVpcRegion(String vpcRegion) {
    this.vpcRegion = vpcRegion;
    return (A) this;
  }
  
  public A withVpcSubnets(List<String> vpcSubnets) {
    if (vpcSubnets != null) {
        this.vpcSubnets = new ArrayList();
        for (String item : vpcSubnets) {
          this.addToVpcSubnets(item);
        }
    } else {
      this.vpcSubnets = null;
    }
    return (A) this;
  }
  
  public A withVpcSubnets(String... vpcSubnets) {
    if (this.vpcSubnets != null) {
        this.vpcSubnets.clear();
        _visitables.remove("vpcSubnets");
    }
    if (vpcSubnets != null) {
      for (String item : vpcSubnets) {
        this.addToVpcSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withZone(String zone) {
    this.zone = zone;
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