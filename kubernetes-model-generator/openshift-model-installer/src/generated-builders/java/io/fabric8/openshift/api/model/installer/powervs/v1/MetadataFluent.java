package io.fabric8.openshift.api.model.installer.powervs.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MetadataFluent<A extends io.fabric8.openshift.api.model.installer.powervs.v1.MetadataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String baseDomain;
  private String cisInstanceCRN;
  private String dnsInstanceCRN;
  private String powerVSResourceGroup;
  private String region;
  private List<PowerVSServiceEndpoint> serviceEndpoints = new ArrayList<PowerVSServiceEndpoint>();
  private String serviceInstanceGUID;
  private String transitGatewayName;
  private String vpcName;
  private String vpcRegion;
  private String zone;

  public MetadataFluent() {
  }
  
  public MetadataFluent(Metadata instance) {
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
  
  protected void copyInstance(Metadata instance) {
    instance = instance != null ? instance : new Metadata();
    if (instance != null) {
        this.withBaseDomain(instance.getBaseDomain());
        this.withCisInstanceCRN(instance.getCisInstanceCRN());
        this.withDnsInstanceCRN(instance.getDnsInstanceCRN());
        this.withPowerVSResourceGroup(instance.getPowerVSResourceGroup());
        this.withRegion(instance.getRegion());
        this.withServiceEndpoints(instance.getServiceEndpoints());
        this.withServiceInstanceGUID(instance.getServiceInstanceGUID());
        this.withTransitGatewayName(instance.getTransitGatewayName());
        this.withVpcName(instance.getVpcName());
        this.withVpcRegion(instance.getVpcRegion());
        this.withZone(instance.getZone());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    MetadataFluent that = (MetadataFluent) o;
    if (!(Objects.equals(baseDomain, that.baseDomain))) {
      return false;
    }
    if (!(Objects.equals(cisInstanceCRN, that.cisInstanceCRN))) {
      return false;
    }
    if (!(Objects.equals(dnsInstanceCRN, that.dnsInstanceCRN))) {
      return false;
    }
    if (!(Objects.equals(powerVSResourceGroup, that.powerVSResourceGroup))) {
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
    if (!(Objects.equals(transitGatewayName, that.transitGatewayName))) {
      return false;
    }
    if (!(Objects.equals(vpcName, that.vpcName))) {
      return false;
    }
    if (!(Objects.equals(vpcRegion, that.vpcRegion))) {
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
  
  public String getBaseDomain() {
    return this.baseDomain;
  }
  
  public String getCisInstanceCRN() {
    return this.cisInstanceCRN;
  }
  
  public String getDnsInstanceCRN() {
    return this.dnsInstanceCRN;
  }
  
  public PowerVSServiceEndpoint getFirstServiceEndpoint() {
    return this.serviceEndpoints.get(0);
  }
  
  public PowerVSServiceEndpoint getLastServiceEndpoint() {
    return this.serviceEndpoints.get(serviceEndpoints.size() - 1);
  }
  
  public PowerVSServiceEndpoint getMatchingServiceEndpoint(Predicate<PowerVSServiceEndpoint> predicate) {
      for (PowerVSServiceEndpoint item : serviceEndpoints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPowerVSResourceGroup() {
    return this.powerVSResourceGroup;
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
  
  public String getTransitGatewayName() {
    return this.transitGatewayName;
  }
  
  public String getVpcName() {
    return this.vpcName;
  }
  
  public String getVpcRegion() {
    return this.vpcRegion;
  }
  
  public String getZone() {
    return this.zone;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBaseDomain() {
    return this.baseDomain != null;
  }
  
  public boolean hasCisInstanceCRN() {
    return this.cisInstanceCRN != null;
  }
  
  public boolean hasDnsInstanceCRN() {
    return this.dnsInstanceCRN != null;
  }
  
  public boolean hasMatchingServiceEndpoint(Predicate<PowerVSServiceEndpoint> predicate) {
      for (PowerVSServiceEndpoint item : serviceEndpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPowerVSResourceGroup() {
    return this.powerVSResourceGroup != null;
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
  
  public boolean hasTransitGatewayName() {
    return this.transitGatewayName != null;
  }
  
  public boolean hasVpcName() {
    return this.vpcName != null;
  }
  
  public boolean hasVpcRegion() {
    return this.vpcRegion != null;
  }
  
  public boolean hasZone() {
    return this.zone != null;
  }
  
  public int hashCode() {
    return Objects.hash(baseDomain, cisInstanceCRN, dnsInstanceCRN, powerVSResourceGroup, region, serviceEndpoints, serviceInstanceGUID, transitGatewayName, vpcName, vpcRegion, zone, additionalProperties);
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
  
  public A setToServiceEndpoints(int index,PowerVSServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    this.serviceEndpoints.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(baseDomain == null)) {
        sb.append("baseDomain:");
        sb.append(baseDomain);
        sb.append(",");
    }
    if (!(cisInstanceCRN == null)) {
        sb.append("cisInstanceCRN:");
        sb.append(cisInstanceCRN);
        sb.append(",");
    }
    if (!(dnsInstanceCRN == null)) {
        sb.append("dnsInstanceCRN:");
        sb.append(dnsInstanceCRN);
        sb.append(",");
    }
    if (!(powerVSResourceGroup == null)) {
        sb.append("powerVSResourceGroup:");
        sb.append(powerVSResourceGroup);
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
    if (!(transitGatewayName == null)) {
        sb.append("transitGatewayName:");
        sb.append(transitGatewayName);
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
  
  public A withBaseDomain(String baseDomain) {
    this.baseDomain = baseDomain;
    return (A) this;
  }
  
  public A withCisInstanceCRN(String cisInstanceCRN) {
    this.cisInstanceCRN = cisInstanceCRN;
    return (A) this;
  }
  
  public A withDnsInstanceCRN(String dnsInstanceCRN) {
    this.dnsInstanceCRN = dnsInstanceCRN;
    return (A) this;
  }
  
  public A withPowerVSResourceGroup(String powerVSResourceGroup) {
    this.powerVSResourceGroup = powerVSResourceGroup;
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
  
  public A withTransitGatewayName(String transitGatewayName) {
    this.transitGatewayName = transitGatewayName;
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
  
  public A withZone(String zone) {
    this.zone = zone;
    return (A) this;
  }
  
}