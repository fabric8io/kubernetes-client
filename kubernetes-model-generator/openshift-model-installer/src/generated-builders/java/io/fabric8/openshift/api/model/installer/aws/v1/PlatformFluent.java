package io.fabric8.openshift.api.model.installer.aws.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.installer.aws.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String amiID;
  private Boolean bestEffortDeleteIgnition;
  private MachinePoolBuilder defaultMachinePlatform;
  private String hostedZone;
  private String hostedZoneRole;
  private String lbType;
  private Boolean preserveBootstrapIgnition;
  private Boolean propagateUserTags;
  private String publicIpv4Pool;
  private String region;
  private ArrayList<ServiceEndpointBuilder> serviceEndpoints = new ArrayList<ServiceEndpointBuilder>();
  private List<String> subnets = new ArrayList<String>();
  private String userProvisionedDNS;
  private Map<String,String> userTags;
  private VPCBuilder vpc;

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
    this.copyInstance(instance);
  }

  public A addAllToServiceEndpoints(Collection<ServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (ServiceEndpoint item : items) {
        ServiceEndpointBuilder builder = new ServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").add(builder);
        this.serviceEndpoints.add(builder);
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
  
  public ServiceEndpointsNested<A> addNewServiceEndpoint() {
    return new ServiceEndpointsNested(-1, null);
  }
  
  public A addNewServiceEndpoint(String name,String url) {
    return (A) this.addToServiceEndpoints(new ServiceEndpoint(name, url));
  }
  
  public ServiceEndpointsNested<A> addNewServiceEndpointLike(ServiceEndpoint item) {
    return new ServiceEndpointsNested(-1, item);
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
  
  public A addToServiceEndpoints(ServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (ServiceEndpoint item : items) {
        ServiceEndpointBuilder builder = new ServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").add(builder);
        this.serviceEndpoints.add(builder);
    }
    return (A) this;
  }
  
  public A addToServiceEndpoints(int index,ServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    ServiceEndpointBuilder builder = new ServiceEndpointBuilder(item);
    if (index < 0 || index >= serviceEndpoints.size()) {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.add(builder);
    } else {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.add(index, builder);
    }
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
  
  public A addToUserTags(Map<String,String> map) {
    if (this.userTags == null && map != null) {
      this.userTags = new LinkedHashMap();
    }
    if (map != null) {
      this.userTags.putAll(map);
    }
    return (A) this;
  }
  
  public A addToUserTags(String key,String value) {
    if (this.userTags == null && key != null && value != null) {
      this.userTags = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.userTags.put(key, value);
    }
    return (A) this;
  }
  
  public MachinePool buildDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null ? this.defaultMachinePlatform.build() : null;
  }
  
  public ServiceEndpoint buildFirstServiceEndpoint() {
    return this.serviceEndpoints.get(0).build();
  }
  
  public ServiceEndpoint buildLastServiceEndpoint() {
    return this.serviceEndpoints.get(serviceEndpoints.size() - 1).build();
  }
  
  public ServiceEndpoint buildMatchingServiceEndpoint(Predicate<ServiceEndpointBuilder> predicate) {
      for (ServiceEndpointBuilder item : serviceEndpoints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ServiceEndpoint buildServiceEndpoint(int index) {
    return this.serviceEndpoints.get(index).build();
  }
  
  public List<ServiceEndpoint> buildServiceEndpoints() {
    return this.serviceEndpoints != null ? build(serviceEndpoints) : null;
  }
  
  public VPC buildVpc() {
    return this.vpc != null ? this.vpc.build() : null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withAmiID(instance.getAmiID());
        this.withBestEffortDeleteIgnition(instance.getBestEffortDeleteIgnition());
        this.withDefaultMachinePlatform(instance.getDefaultMachinePlatform());
        this.withHostedZone(instance.getHostedZone());
        this.withHostedZoneRole(instance.getHostedZoneRole());
        this.withLbType(instance.getLbType());
        this.withPreserveBootstrapIgnition(instance.getPreserveBootstrapIgnition());
        this.withPropagateUserTags(instance.getPropagateUserTags());
        this.withPublicIpv4Pool(instance.getPublicIpv4Pool());
        this.withRegion(instance.getRegion());
        this.withServiceEndpoints(instance.getServiceEndpoints());
        this.withSubnets(instance.getSubnets());
        this.withUserProvisionedDNS(instance.getUserProvisionedDNS());
        this.withUserTags(instance.getUserTags());
        this.withVpc(instance.getVpc());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DefaultMachinePlatformNested<A> editDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(null));
  }
  
  public ServiceEndpointsNested<A> editFirstServiceEndpoint() {
    if (serviceEndpoints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "serviceEndpoints"));
    }
    return this.setNewServiceEndpointLike(0, this.buildServiceEndpoint(0));
  }
  
  public ServiceEndpointsNested<A> editLastServiceEndpoint() {
    int index = serviceEndpoints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "serviceEndpoints"));
    }
    return this.setNewServiceEndpointLike(index, this.buildServiceEndpoint(index));
  }
  
  public ServiceEndpointsNested<A> editMatchingServiceEndpoint(Predicate<ServiceEndpointBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < serviceEndpoints.size();i++) {
      if (predicate.test(serviceEndpoints.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "serviceEndpoints"));
    }
    return this.setNewServiceEndpointLike(index, this.buildServiceEndpoint(index));
  }
  
  public DefaultMachinePlatformNested<A> editOrNewDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(new MachinePoolBuilder().build()));
  }
  
  public DefaultMachinePlatformNested<A> editOrNewDefaultMachinePlatformLike(MachinePool item) {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(item));
  }
  
  public VpcNested<A> editOrNewVpc() {
    return this.withNewVpcLike(Optional.ofNullable(this.buildVpc()).orElse(new VPCBuilder().build()));
  }
  
  public VpcNested<A> editOrNewVpcLike(VPC item) {
    return this.withNewVpcLike(Optional.ofNullable(this.buildVpc()).orElse(item));
  }
  
  public ServiceEndpointsNested<A> editServiceEndpoint(int index) {
    if (serviceEndpoints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "serviceEndpoints"));
    }
    return this.setNewServiceEndpointLike(index, this.buildServiceEndpoint(index));
  }
  
  public VpcNested<A> editVpc() {
    return this.withNewVpcLike(Optional.ofNullable(this.buildVpc()).orElse(null));
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
    if (!(Objects.equals(amiID, that.amiID))) {
      return false;
    }
    if (!(Objects.equals(bestEffortDeleteIgnition, that.bestEffortDeleteIgnition))) {
      return false;
    }
    if (!(Objects.equals(defaultMachinePlatform, that.defaultMachinePlatform))) {
      return false;
    }
    if (!(Objects.equals(hostedZone, that.hostedZone))) {
      return false;
    }
    if (!(Objects.equals(hostedZoneRole, that.hostedZoneRole))) {
      return false;
    }
    if (!(Objects.equals(lbType, that.lbType))) {
      return false;
    }
    if (!(Objects.equals(preserveBootstrapIgnition, that.preserveBootstrapIgnition))) {
      return false;
    }
    if (!(Objects.equals(propagateUserTags, that.propagateUserTags))) {
      return false;
    }
    if (!(Objects.equals(publicIpv4Pool, that.publicIpv4Pool))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(serviceEndpoints, that.serviceEndpoints))) {
      return false;
    }
    if (!(Objects.equals(subnets, that.subnets))) {
      return false;
    }
    if (!(Objects.equals(userProvisionedDNS, that.userProvisionedDNS))) {
      return false;
    }
    if (!(Objects.equals(userTags, that.userTags))) {
      return false;
    }
    if (!(Objects.equals(vpc, that.vpc))) {
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
  
  public String getAmiID() {
    return this.amiID;
  }
  
  public Boolean getBestEffortDeleteIgnition() {
    return this.bestEffortDeleteIgnition;
  }
  
  public String getFirstSubnet() {
    return this.subnets.get(0);
  }
  
  public String getHostedZone() {
    return this.hostedZone;
  }
  
  public String getHostedZoneRole() {
    return this.hostedZoneRole;
  }
  
  public String getLastSubnet() {
    return this.subnets.get(subnets.size() - 1);
  }
  
  public String getLbType() {
    return this.lbType;
  }
  
  public String getMatchingSubnet(Predicate<String> predicate) {
      for (String item : subnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Boolean getPreserveBootstrapIgnition() {
    return this.preserveBootstrapIgnition;
  }
  
  public Boolean getPropagateUserTags() {
    return this.propagateUserTags;
  }
  
  public String getPublicIpv4Pool() {
    return this.publicIpv4Pool;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getSubnet(int index) {
    return this.subnets.get(index);
  }
  
  public List<String> getSubnets() {
    return this.subnets;
  }
  
  public String getUserProvisionedDNS() {
    return this.userProvisionedDNS;
  }
  
  public Map<String,String> getUserTags() {
    return this.userTags;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAmiID() {
    return this.amiID != null;
  }
  
  public boolean hasBestEffortDeleteIgnition() {
    return this.bestEffortDeleteIgnition != null;
  }
  
  public boolean hasDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null;
  }
  
  public boolean hasHostedZone() {
    return this.hostedZone != null;
  }
  
  public boolean hasHostedZoneRole() {
    return this.hostedZoneRole != null;
  }
  
  public boolean hasLbType() {
    return this.lbType != null;
  }
  
  public boolean hasMatchingServiceEndpoint(Predicate<ServiceEndpointBuilder> predicate) {
      for (ServiceEndpointBuilder item : serviceEndpoints) {
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
  
  public boolean hasPreserveBootstrapIgnition() {
    return this.preserveBootstrapIgnition != null;
  }
  
  public boolean hasPropagateUserTags() {
    return this.propagateUserTags != null;
  }
  
  public boolean hasPublicIpv4Pool() {
    return this.publicIpv4Pool != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasServiceEndpoints() {
    return this.serviceEndpoints != null && !(this.serviceEndpoints.isEmpty());
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public boolean hasUserProvisionedDNS() {
    return this.userProvisionedDNS != null;
  }
  
  public boolean hasUserTags() {
    return this.userTags != null;
  }
  
  public boolean hasVpc() {
    return this.vpc != null;
  }
  
  public int hashCode() {
    return Objects.hash(amiID, bestEffortDeleteIgnition, defaultMachinePlatform, hostedZone, hostedZoneRole, lbType, preserveBootstrapIgnition, propagateUserTags, publicIpv4Pool, region, serviceEndpoints, subnets, userProvisionedDNS, userTags, vpc, additionalProperties);
  }
  
  public A removeAllFromServiceEndpoints(Collection<ServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (ServiceEndpoint item : items) {
        ServiceEndpointBuilder builder = new ServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").remove(builder);
        this.serviceEndpoints.remove(builder);
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
  
  public A removeFromServiceEndpoints(ServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (ServiceEndpoint item : items) {
        ServiceEndpointBuilder builder = new ServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").remove(builder);
        this.serviceEndpoints.remove(builder);
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
  
  public A removeFromUserTags(String key) {
    if (this.userTags == null) {
      return (A) this;
    }
    if (key != null && this.userTags != null) {
      this.userTags.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromUserTags(Map<String,String> map) {
    if (this.userTags == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.userTags != null) {
          this.userTags.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromServiceEndpoints(Predicate<ServiceEndpointBuilder> predicate) {
    if (serviceEndpoints == null) {
      return (A) this;
    }
    Iterator<ServiceEndpointBuilder> each = serviceEndpoints.iterator();
    List visitables = _visitables.get("serviceEndpoints");
    while (each.hasNext()) {
        ServiceEndpointBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ServiceEndpointsNested<A> setNewServiceEndpointLike(int index,ServiceEndpoint item) {
    return new ServiceEndpointsNested(index, item);
  }
  
  public A setToServiceEndpoints(int index,ServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    ServiceEndpointBuilder builder = new ServiceEndpointBuilder(item);
    if (index < 0 || index >= serviceEndpoints.size()) {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.add(builder);
    } else {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.set(index, builder);
    }
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
    if (!(amiID == null)) {
        sb.append("amiID:");
        sb.append(amiID);
        sb.append(",");
    }
    if (!(bestEffortDeleteIgnition == null)) {
        sb.append("bestEffortDeleteIgnition:");
        sb.append(bestEffortDeleteIgnition);
        sb.append(",");
    }
    if (!(defaultMachinePlatform == null)) {
        sb.append("defaultMachinePlatform:");
        sb.append(defaultMachinePlatform);
        sb.append(",");
    }
    if (!(hostedZone == null)) {
        sb.append("hostedZone:");
        sb.append(hostedZone);
        sb.append(",");
    }
    if (!(hostedZoneRole == null)) {
        sb.append("hostedZoneRole:");
        sb.append(hostedZoneRole);
        sb.append(",");
    }
    if (!(lbType == null)) {
        sb.append("lbType:");
        sb.append(lbType);
        sb.append(",");
    }
    if (!(preserveBootstrapIgnition == null)) {
        sb.append("preserveBootstrapIgnition:");
        sb.append(preserveBootstrapIgnition);
        sb.append(",");
    }
    if (!(propagateUserTags == null)) {
        sb.append("propagateUserTags:");
        sb.append(propagateUserTags);
        sb.append(",");
    }
    if (!(publicIpv4Pool == null)) {
        sb.append("publicIpv4Pool:");
        sb.append(publicIpv4Pool);
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
    if (!(subnets == null) && !(subnets.isEmpty())) {
        sb.append("subnets:");
        sb.append(subnets);
        sb.append(",");
    }
    if (!(userProvisionedDNS == null)) {
        sb.append("userProvisionedDNS:");
        sb.append(userProvisionedDNS);
        sb.append(",");
    }
    if (!(userTags == null) && !(userTags.isEmpty())) {
        sb.append("userTags:");
        sb.append(userTags);
        sb.append(",");
    }
    if (!(vpc == null)) {
        sb.append("vpc:");
        sb.append(vpc);
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
  
  public A withAmiID(String amiID) {
    this.amiID = amiID;
    return (A) this;
  }
  
  public A withBestEffortDeleteIgnition() {
    return withBestEffortDeleteIgnition(true);
  }
  
  public A withBestEffortDeleteIgnition(Boolean bestEffortDeleteIgnition) {
    this.bestEffortDeleteIgnition = bestEffortDeleteIgnition;
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
  
  public A withHostedZone(String hostedZone) {
    this.hostedZone = hostedZone;
    return (A) this;
  }
  
  public A withHostedZoneRole(String hostedZoneRole) {
    this.hostedZoneRole = hostedZoneRole;
    return (A) this;
  }
  
  public A withLbType(String lbType) {
    this.lbType = lbType;
    return (A) this;
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatform() {
    return new DefaultMachinePlatformNested(null);
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatformLike(MachinePool item) {
    return new DefaultMachinePlatformNested(item);
  }
  
  public VpcNested<A> withNewVpc() {
    return new VpcNested(null);
  }
  
  public VpcNested<A> withNewVpcLike(VPC item) {
    return new VpcNested(item);
  }
  
  public A withPreserveBootstrapIgnition() {
    return withPreserveBootstrapIgnition(true);
  }
  
  public A withPreserveBootstrapIgnition(Boolean preserveBootstrapIgnition) {
    this.preserveBootstrapIgnition = preserveBootstrapIgnition;
    return (A) this;
  }
  
  public A withPropagateUserTags() {
    return withPropagateUserTags(true);
  }
  
  public A withPropagateUserTags(Boolean propagateUserTags) {
    this.propagateUserTags = propagateUserTags;
    return (A) this;
  }
  
  public A withPublicIpv4Pool(String publicIpv4Pool) {
    this.publicIpv4Pool = publicIpv4Pool;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withServiceEndpoints(List<ServiceEndpoint> serviceEndpoints) {
    if (this.serviceEndpoints != null) {
      this._visitables.get("serviceEndpoints").clear();
    }
    if (serviceEndpoints != null) {
        this.serviceEndpoints = new ArrayList();
        for (ServiceEndpoint item : serviceEndpoints) {
          this.addToServiceEndpoints(item);
        }
    } else {
      this.serviceEndpoints = null;
    }
    return (A) this;
  }
  
  public A withServiceEndpoints(ServiceEndpoint... serviceEndpoints) {
    if (this.serviceEndpoints != null) {
        this.serviceEndpoints.clear();
        _visitables.remove("serviceEndpoints");
    }
    if (serviceEndpoints != null) {
      for (ServiceEndpoint item : serviceEndpoints) {
        this.addToServiceEndpoints(item);
      }
    }
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
  
  public A withUserProvisionedDNS(String userProvisionedDNS) {
    this.userProvisionedDNS = userProvisionedDNS;
    return (A) this;
  }
  
  public <K,V>A withUserTags(Map<String,String> userTags) {
    if (userTags == null) {
      this.userTags = null;
    } else {
      this.userTags = new LinkedHashMap(userTags);
    }
    return (A) this;
  }
  
  public A withVpc(VPC vpc) {
    this._visitables.remove("vpc");
    if (vpc != null) {
        this.vpc = new VPCBuilder(vpc);
        this._visitables.get("vpc").add(this.vpc);
    } else {
        this.vpc = null;
        this._visitables.get("vpc").remove(this.vpc);
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
  public class ServiceEndpointsNested<N> extends ServiceEndpointFluent<ServiceEndpointsNested<N>> implements Nested<N>{
  
    ServiceEndpointBuilder builder;
    int index;
  
    ServiceEndpointsNested(int index,ServiceEndpoint item) {
      this.index = index;
      this.builder = new ServiceEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.setToServiceEndpoints(index, builder.build());
    }
    
    public N endServiceEndpoint() {
      return and();
    }
    
  }
  public class VpcNested<N> extends VPCFluent<VpcNested<N>> implements Nested<N>{
  
    VPCBuilder builder;
  
    VpcNested(VPC item) {
      this.builder = new VPCBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withVpc(builder.build());
    }
    
    public N endVpc() {
      return and();
    }
    
  }
}