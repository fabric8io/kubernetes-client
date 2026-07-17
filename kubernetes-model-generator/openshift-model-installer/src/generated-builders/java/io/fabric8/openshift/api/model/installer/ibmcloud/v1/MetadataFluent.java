package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MetadataFluent<A extends io.fabric8.openshift.api.model.installer.ibmcloud.v1.MetadataFluent<A>> extends BaseFluent<A>{

  private String accountID;
  private Map<String,Object> additionalProperties;
  private String baseDomain;
  private String cisInstanceCRN;
  private String dnsInstanceID;
  private String region;
  private String resourceGroupName;
  private List<IBMCloudServiceEndpoint> serviceEndpoints = new ArrayList<IBMCloudServiceEndpoint>();
  private List<String> subnets = new ArrayList<String>();
  private String vpc;

  public MetadataFluent() {
  }
  
  public MetadataFluent(Metadata instance) {
    this.copyInstance(instance);
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
  
  public A addAllToSubnets(Collection<String> items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (String item : items) {
      this.subnets.add(item);
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
  
  protected void copyInstance(Metadata instance) {
    instance = instance != null ? instance : new Metadata();
    if (instance != null) {
        this.withAccountID(instance.getAccountID());
        this.withBaseDomain(instance.getBaseDomain());
        this.withCisInstanceCRN(instance.getCisInstanceCRN());
        this.withDnsInstanceID(instance.getDnsInstanceID());
        this.withRegion(instance.getRegion());
        this.withResourceGroupName(instance.getResourceGroupName());
        this.withServiceEndpoints(instance.getServiceEndpoints());
        this.withSubnets(instance.getSubnets());
        this.withVpc(instance.getVpc());
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
    if (!(Objects.equals(accountID, that.accountID))) {
      return false;
    }
    if (!(Objects.equals(baseDomain, that.baseDomain))) {
      return false;
    }
    if (!(Objects.equals(cisInstanceCRN, that.cisInstanceCRN))) {
      return false;
    }
    if (!(Objects.equals(dnsInstanceID, that.dnsInstanceID))) {
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
    if (!(Objects.equals(subnets, that.subnets))) {
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
  
  public String getAccountID() {
    return this.accountID;
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
  
  public String getDnsInstanceID() {
    return this.dnsInstanceID;
  }
  
  public IBMCloudServiceEndpoint getFirstServiceEndpoint() {
    return this.serviceEndpoints.get(0);
  }
  
  public String getFirstSubnet() {
    return this.subnets.get(0);
  }
  
  public IBMCloudServiceEndpoint getLastServiceEndpoint() {
    return this.serviceEndpoints.get(serviceEndpoints.size() - 1);
  }
  
  public String getLastSubnet() {
    return this.subnets.get(subnets.size() - 1);
  }
  
  public IBMCloudServiceEndpoint getMatchingServiceEndpoint(Predicate<IBMCloudServiceEndpoint> predicate) {
      for (IBMCloudServiceEndpoint item : serviceEndpoints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSubnet(Predicate<String> predicate) {
      for (String item : subnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
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
  
  public String getSubnet(int index) {
    return this.subnets.get(index);
  }
  
  public List<String> getSubnets() {
    return this.subnets;
  }
  
  public String getVpc() {
    return this.vpc;
  }
  
  public boolean hasAccountID() {
    return this.accountID != null;
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
  
  public boolean hasDnsInstanceID() {
    return this.dnsInstanceID != null;
  }
  
  public boolean hasMatchingServiceEndpoint(Predicate<IBMCloudServiceEndpoint> predicate) {
      for (IBMCloudServiceEndpoint item : serviceEndpoints) {
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
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasResourceGroupName() {
    return this.resourceGroupName != null;
  }
  
  public boolean hasServiceEndpoints() {
    return this.serviceEndpoints != null && !(this.serviceEndpoints.isEmpty());
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public boolean hasVpc() {
    return this.vpc != null;
  }
  
  public int hashCode() {
    return Objects.hash(accountID, baseDomain, cisInstanceCRN, dnsInstanceID, region, resourceGroupName, serviceEndpoints, subnets, vpc, additionalProperties);
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
  
  public A removeFromServiceEndpoints(IBMCloudServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (IBMCloudServiceEndpoint item : items) {
      this.serviceEndpoints.remove(item);
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
  
  public A setToServiceEndpoints(int index,IBMCloudServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    this.serviceEndpoints.set(index, item);
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
    if (!(accountID == null)) {
        sb.append("accountID:");
        sb.append(accountID);
        sb.append(",");
    }
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
    if (!(dnsInstanceID == null)) {
        sb.append("dnsInstanceID:");
        sb.append(dnsInstanceID);
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
    if (!(subnets == null) && !(subnets.isEmpty())) {
        sb.append("subnets:");
        sb.append(subnets);
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
  
  public A withAccountID(String accountID) {
    this.accountID = accountID;
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
  
  public A withBaseDomain(String baseDomain) {
    this.baseDomain = baseDomain;
    return (A) this;
  }
  
  public A withCisInstanceCRN(String cisInstanceCRN) {
    this.cisInstanceCRN = cisInstanceCRN;
    return (A) this;
  }
  
  public A withDnsInstanceID(String dnsInstanceID) {
    this.dnsInstanceID = dnsInstanceID;
    return (A) this;
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
  
  public A withVpc(String vpc) {
    this.vpc = vpc;
    return (A) this;
  }
  
}