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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PowerVSPlatformStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.PowerVSPlatformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cisInstanceCRN;
  private String dnsInstanceCRN;
  private String region;
  private String resourceGroup;
  private ArrayList<PowerVSServiceEndpointBuilder> serviceEndpoints = new ArrayList<PowerVSServiceEndpointBuilder>();
  private String zone;

  public PowerVSPlatformStatusFluent() {
  }
  
  public PowerVSPlatformStatusFluent(PowerVSPlatformStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToServiceEndpoints(Collection<PowerVSServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (PowerVSServiceEndpoint item : items) {
        PowerVSServiceEndpointBuilder builder = new PowerVSServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").add(builder);
        this.serviceEndpoints.add(builder);
    }
    return (A) this;
  }
  
  public ServiceEndpointsNested<A> addNewServiceEndpoint() {
    return new ServiceEndpointsNested(-1, null);
  }
  
  public A addNewServiceEndpoint(String name,String url) {
    return (A) this.addToServiceEndpoints(new PowerVSServiceEndpoint(name, url));
  }
  
  public ServiceEndpointsNested<A> addNewServiceEndpointLike(PowerVSServiceEndpoint item) {
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
  
  public A addToServiceEndpoints(PowerVSServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (PowerVSServiceEndpoint item : items) {
        PowerVSServiceEndpointBuilder builder = new PowerVSServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").add(builder);
        this.serviceEndpoints.add(builder);
    }
    return (A) this;
  }
  
  public A addToServiceEndpoints(int index,PowerVSServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    PowerVSServiceEndpointBuilder builder = new PowerVSServiceEndpointBuilder(item);
    if (index < 0 || index >= serviceEndpoints.size()) {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.add(builder);
    } else {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.add(index, builder);
    }
    return (A) this;
  }
  
  public PowerVSServiceEndpoint buildFirstServiceEndpoint() {
    return this.serviceEndpoints.get(0).build();
  }
  
  public PowerVSServiceEndpoint buildLastServiceEndpoint() {
    return this.serviceEndpoints.get(serviceEndpoints.size() - 1).build();
  }
  
  public PowerVSServiceEndpoint buildMatchingServiceEndpoint(Predicate<PowerVSServiceEndpointBuilder> predicate) {
      for (PowerVSServiceEndpointBuilder item : serviceEndpoints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PowerVSServiceEndpoint buildServiceEndpoint(int index) {
    return this.serviceEndpoints.get(index).build();
  }
  
  public List<PowerVSServiceEndpoint> buildServiceEndpoints() {
    return this.serviceEndpoints != null ? build(serviceEndpoints) : null;
  }
  
  protected void copyInstance(PowerVSPlatformStatus instance) {
    instance = instance != null ? instance : new PowerVSPlatformStatus();
    if (instance != null) {
        this.withCisInstanceCRN(instance.getCisInstanceCRN());
        this.withDnsInstanceCRN(instance.getDnsInstanceCRN());
        this.withRegion(instance.getRegion());
        this.withResourceGroup(instance.getResourceGroup());
        this.withServiceEndpoints(instance.getServiceEndpoints());
        this.withZone(instance.getZone());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
  
  public ServiceEndpointsNested<A> editMatchingServiceEndpoint(Predicate<PowerVSServiceEndpointBuilder> predicate) {
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
  
  public ServiceEndpointsNested<A> editServiceEndpoint(int index) {
    if (serviceEndpoints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "serviceEndpoints"));
    }
    return this.setNewServiceEndpointLike(index, this.buildServiceEndpoint(index));
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
    PowerVSPlatformStatusFluent that = (PowerVSPlatformStatusFluent) o;
    if (!(Objects.equals(cisInstanceCRN, that.cisInstanceCRN))) {
      return false;
    }
    if (!(Objects.equals(dnsInstanceCRN, that.dnsInstanceCRN))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(resourceGroup, that.resourceGroup))) {
      return false;
    }
    if (!(Objects.equals(serviceEndpoints, that.serviceEndpoints))) {
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
  
  public String getCisInstanceCRN() {
    return this.cisInstanceCRN;
  }
  
  public String getDnsInstanceCRN() {
    return this.dnsInstanceCRN;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getResourceGroup() {
    return this.resourceGroup;
  }
  
  public String getZone() {
    return this.zone;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCisInstanceCRN() {
    return this.cisInstanceCRN != null;
  }
  
  public boolean hasDnsInstanceCRN() {
    return this.dnsInstanceCRN != null;
  }
  
  public boolean hasMatchingServiceEndpoint(Predicate<PowerVSServiceEndpointBuilder> predicate) {
      for (PowerVSServiceEndpointBuilder item : serviceEndpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasResourceGroup() {
    return this.resourceGroup != null;
  }
  
  public boolean hasServiceEndpoints() {
    return this.serviceEndpoints != null && !(this.serviceEndpoints.isEmpty());
  }
  
  public boolean hasZone() {
    return this.zone != null;
  }
  
  public int hashCode() {
    return Objects.hash(cisInstanceCRN, dnsInstanceCRN, region, resourceGroup, serviceEndpoints, zone, additionalProperties);
  }
  
  public A removeAllFromServiceEndpoints(Collection<PowerVSServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (PowerVSServiceEndpoint item : items) {
        PowerVSServiceEndpointBuilder builder = new PowerVSServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").remove(builder);
        this.serviceEndpoints.remove(builder);
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
        PowerVSServiceEndpointBuilder builder = new PowerVSServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").remove(builder);
        this.serviceEndpoints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromServiceEndpoints(Predicate<PowerVSServiceEndpointBuilder> predicate) {
    if (serviceEndpoints == null) {
      return (A) this;
    }
    Iterator<PowerVSServiceEndpointBuilder> each = serviceEndpoints.iterator();
    List visitables = _visitables.get("serviceEndpoints");
    while (each.hasNext()) {
        PowerVSServiceEndpointBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ServiceEndpointsNested<A> setNewServiceEndpointLike(int index,PowerVSServiceEndpoint item) {
    return new ServiceEndpointsNested(index, item);
  }
  
  public A setToServiceEndpoints(int index,PowerVSServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    PowerVSServiceEndpointBuilder builder = new PowerVSServiceEndpointBuilder(item);
    if (index < 0 || index >= serviceEndpoints.size()) {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.add(builder);
    } else {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(resourceGroup == null)) {
        sb.append("resourceGroup:");
        sb.append(resourceGroup);
        sb.append(",");
    }
    if (!(serviceEndpoints == null) && !(serviceEndpoints.isEmpty())) {
        sb.append("serviceEndpoints:");
        sb.append(serviceEndpoints);
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
  
  public A withCisInstanceCRN(String cisInstanceCRN) {
    this.cisInstanceCRN = cisInstanceCRN;
    return (A) this;
  }
  
  public A withDnsInstanceCRN(String dnsInstanceCRN) {
    this.dnsInstanceCRN = dnsInstanceCRN;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withResourceGroup(String resourceGroup) {
    this.resourceGroup = resourceGroup;
    return (A) this;
  }
  
  public A withServiceEndpoints(List<PowerVSServiceEndpoint> serviceEndpoints) {
    if (this.serviceEndpoints != null) {
      this._visitables.get("serviceEndpoints").clear();
    }
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
  
  public A withZone(String zone) {
    this.zone = zone;
    return (A) this;
  }
  public class ServiceEndpointsNested<N> extends PowerVSServiceEndpointFluent<ServiceEndpointsNested<N>> implements Nested<N>{
  
    PowerVSServiceEndpointBuilder builder;
    int index;
  
    ServiceEndpointsNested(int index,PowerVSServiceEndpoint item) {
      this.index = index;
      this.builder = new PowerVSServiceEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) PowerVSPlatformStatusFluent.this.setToServiceEndpoints(index, builder.build());
    }
    
    public N endServiceEndpoint() {
      return and();
    }
    
  }
}