package io.fabric8.openshift.api.model.installer.aws.v1;

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
public class MetadataFluent<A extends io.fabric8.openshift.api.model.installer.aws.v1.MetadataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clusterDomain;
  private String hostedZoneRole;
  private List<Map<String,String>> identifier = new ArrayList<Map<String,String>>();
  private String region;
  private ArrayList<ServiceEndpointBuilder> serviceEndpoints = new ArrayList<ServiceEndpointBuilder>();

  public MetadataFluent() {
  }
  
  public MetadataFluent(Metadata instance) {
    this.copyInstance(instance);
  }

  public A addAllToIdentifier(Collection<Map<String,String>> items) {
    if (this.identifier == null) {
      this.identifier = new ArrayList();
    }
    for (Map<String,String> item : items) {
      this.identifier.add(item);
    }
    return (A) this;
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
  
  public A addToIdentifier(Map<String,String>... items) {
    if (this.identifier == null) {
      this.identifier = new ArrayList();
    }
    for (Map<String,String> item : items) {
      this.identifier.add(item);
    }
    return (A) this;
  }
  
  public A addToIdentifier(int index,Map<String,String> item) {
    if (this.identifier == null) {
      this.identifier = new ArrayList();
    }
    this.identifier.add(index, item);
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
  
  protected void copyInstance(Metadata instance) {
    instance = instance != null ? instance : new Metadata();
    if (instance != null) {
        this.withClusterDomain(instance.getClusterDomain());
        this.withHostedZoneRole(instance.getHostedZoneRole());
        this.withIdentifier(instance.getIdentifier());
        this.withRegion(instance.getRegion());
        this.withServiceEndpoints(instance.getServiceEndpoints());
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
    MetadataFluent that = (MetadataFluent) o;
    if (!(Objects.equals(clusterDomain, that.clusterDomain))) {
      return false;
    }
    if (!(Objects.equals(hostedZoneRole, that.hostedZoneRole))) {
      return false;
    }
    if (!(Objects.equals(identifier, that.identifier))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(serviceEndpoints, that.serviceEndpoints))) {
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
  
  public String getClusterDomain() {
    return this.clusterDomain;
  }
  
  public Map<String,String> getFirstIdentifier() {
    return this.identifier.get(0);
  }
  
  public String getHostedZoneRole() {
    return this.hostedZoneRole;
  }
  
  public List<Map<String,String>> getIdentifier() {
    return this.identifier;
  }
  
  public Map<String,String> getIdentifier(int index) {
    return this.identifier.get(index);
  }
  
  public Map<String,String> getLastIdentifier() {
    return this.identifier.get(identifier.size() - 1);
  }
  
  public Map<String,String> getMatchingIdentifier(Predicate<Map<String,String>> predicate) {
      for (Map<String,String> item : identifier) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterDomain() {
    return this.clusterDomain != null;
  }
  
  public boolean hasHostedZoneRole() {
    return this.hostedZoneRole != null;
  }
  
  public boolean hasIdentifier() {
    return this.identifier != null && !(this.identifier.isEmpty());
  }
  
  public boolean hasMatchingIdentifier(Predicate<Map<String,String>> predicate) {
      for (Map<String,String> item : identifier) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingServiceEndpoint(Predicate<ServiceEndpointBuilder> predicate) {
      for (ServiceEndpointBuilder item : serviceEndpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasServiceEndpoints() {
    return this.serviceEndpoints != null && !(this.serviceEndpoints.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(clusterDomain, hostedZoneRole, identifier, region, serviceEndpoints, additionalProperties);
  }
  
  public A removeAllFromIdentifier(Collection<Map<String,String>> items) {
    if (this.identifier == null) {
      return (A) this;
    }
    for (Map<String,String> item : items) {
      this.identifier.remove(item);
    }
    return (A) this;
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
  
  public A removeFromIdentifier(Map<String,String>... items) {
    if (this.identifier == null) {
      return (A) this;
    }
    for (Map<String,String> item : items) {
      this.identifier.remove(item);
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
  
  public A setToIdentifier(int index,Map<String,String> item) {
    if (this.identifier == null) {
      this.identifier = new ArrayList();
    }
    this.identifier.set(index, item);
    return (A) this;
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterDomain == null)) {
        sb.append("clusterDomain:");
        sb.append(clusterDomain);
        sb.append(",");
    }
    if (!(hostedZoneRole == null)) {
        sb.append("hostedZoneRole:");
        sb.append(hostedZoneRole);
        sb.append(",");
    }
    if (!(identifier == null) && !(identifier.isEmpty())) {
        sb.append("identifier:");
        sb.append(identifier);
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
  
  public A withClusterDomain(String clusterDomain) {
    this.clusterDomain = clusterDomain;
    return (A) this;
  }
  
  public A withHostedZoneRole(String hostedZoneRole) {
    this.hostedZoneRole = hostedZoneRole;
    return (A) this;
  }
  
  public <K,V>A withIdentifier(List<Map<String,String>> identifier) {
    if (identifier != null) {
        this.identifier = new ArrayList();
        for (Map<String,String> item : identifier) {
          this.addToIdentifier(item);
        }
    } else {
      this.identifier = null;
    }
    return (A) this;
  }
  
  public A withIdentifier(Map<String,String>... identifier) {
    if (this.identifier != null) {
        this.identifier.clear();
        _visitables.remove("identifier");
    }
    if (identifier != null) {
      for (Map<String,String> item : identifier) {
        this.addToIdentifier(item);
      }
    }
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
  public class ServiceEndpointsNested<N> extends ServiceEndpointFluent<ServiceEndpointsNested<N>> implements Nested<N>{
  
    ServiceEndpointBuilder builder;
    int index;
  
    ServiceEndpointsNested(int index,ServiceEndpoint item) {
      this.index = index;
      this.builder = new ServiceEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) MetadataFluent.this.setToServiceEndpoints(index, builder.build());
    }
    
    public N endServiceEndpoint() {
      return and();
    }
    
  }
}