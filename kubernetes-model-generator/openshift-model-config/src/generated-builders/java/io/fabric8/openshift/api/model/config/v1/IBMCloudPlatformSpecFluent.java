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
public class IBMCloudPlatformSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.IBMCloudPlatformSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<IBMCloudServiceEndpointBuilder> serviceEndpoints = new ArrayList<IBMCloudServiceEndpointBuilder>();

  public IBMCloudPlatformSpecFluent() {
  }
  
  public IBMCloudPlatformSpecFluent(IBMCloudPlatformSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToServiceEndpoints(Collection<IBMCloudServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (IBMCloudServiceEndpoint item : items) {
        IBMCloudServiceEndpointBuilder builder = new IBMCloudServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").add(builder);
        this.serviceEndpoints.add(builder);
    }
    return (A) this;
  }
  
  public ServiceEndpointsNested<A> addNewServiceEndpoint() {
    return new ServiceEndpointsNested(-1, null);
  }
  
  public A addNewServiceEndpoint(String name,String url) {
    return (A) this.addToServiceEndpoints(new IBMCloudServiceEndpoint(name, url));
  }
  
  public ServiceEndpointsNested<A> addNewServiceEndpointLike(IBMCloudServiceEndpoint item) {
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
  
  public A addToServiceEndpoints(IBMCloudServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (IBMCloudServiceEndpoint item : items) {
        IBMCloudServiceEndpointBuilder builder = new IBMCloudServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").add(builder);
        this.serviceEndpoints.add(builder);
    }
    return (A) this;
  }
  
  public A addToServiceEndpoints(int index,IBMCloudServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    IBMCloudServiceEndpointBuilder builder = new IBMCloudServiceEndpointBuilder(item);
    if (index < 0 || index >= serviceEndpoints.size()) {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.add(builder);
    } else {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.add(index, builder);
    }
    return (A) this;
  }
  
  public IBMCloudServiceEndpoint buildFirstServiceEndpoint() {
    return this.serviceEndpoints.get(0).build();
  }
  
  public IBMCloudServiceEndpoint buildLastServiceEndpoint() {
    return this.serviceEndpoints.get(serviceEndpoints.size() - 1).build();
  }
  
  public IBMCloudServiceEndpoint buildMatchingServiceEndpoint(Predicate<IBMCloudServiceEndpointBuilder> predicate) {
      for (IBMCloudServiceEndpointBuilder item : serviceEndpoints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IBMCloudServiceEndpoint buildServiceEndpoint(int index) {
    return this.serviceEndpoints.get(index).build();
  }
  
  public List<IBMCloudServiceEndpoint> buildServiceEndpoints() {
    return this.serviceEndpoints != null ? build(serviceEndpoints) : null;
  }
  
  protected void copyInstance(IBMCloudPlatformSpec instance) {
    instance = instance != null ? instance : new IBMCloudPlatformSpec();
    if (instance != null) {
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
  
  public ServiceEndpointsNested<A> editMatchingServiceEndpoint(Predicate<IBMCloudServiceEndpointBuilder> predicate) {
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
    IBMCloudPlatformSpecFluent that = (IBMCloudPlatformSpecFluent) o;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingServiceEndpoint(Predicate<IBMCloudServiceEndpointBuilder> predicate) {
      for (IBMCloudServiceEndpointBuilder item : serviceEndpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasServiceEndpoints() {
    return this.serviceEndpoints != null && !(this.serviceEndpoints.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(serviceEndpoints, additionalProperties);
  }
  
  public A removeAllFromServiceEndpoints(Collection<IBMCloudServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (IBMCloudServiceEndpoint item : items) {
        IBMCloudServiceEndpointBuilder builder = new IBMCloudServiceEndpointBuilder(item);
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
  
  public A removeFromServiceEndpoints(IBMCloudServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (IBMCloudServiceEndpoint item : items) {
        IBMCloudServiceEndpointBuilder builder = new IBMCloudServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").remove(builder);
        this.serviceEndpoints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromServiceEndpoints(Predicate<IBMCloudServiceEndpointBuilder> predicate) {
    if (serviceEndpoints == null) {
      return (A) this;
    }
    Iterator<IBMCloudServiceEndpointBuilder> each = serviceEndpoints.iterator();
    List visitables = _visitables.get("serviceEndpoints");
    while (each.hasNext()) {
        IBMCloudServiceEndpointBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ServiceEndpointsNested<A> setNewServiceEndpointLike(int index,IBMCloudServiceEndpoint item) {
    return new ServiceEndpointsNested(index, item);
  }
  
  public A setToServiceEndpoints(int index,IBMCloudServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    IBMCloudServiceEndpointBuilder builder = new IBMCloudServiceEndpointBuilder(item);
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
  
  public A withServiceEndpoints(List<IBMCloudServiceEndpoint> serviceEndpoints) {
    if (this.serviceEndpoints != null) {
      this._visitables.get("serviceEndpoints").clear();
    }
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
  public class ServiceEndpointsNested<N> extends IBMCloudServiceEndpointFluent<ServiceEndpointsNested<N>> implements Nested<N>{
  
    IBMCloudServiceEndpointBuilder builder;
    int index;
  
    ServiceEndpointsNested(int index,IBMCloudServiceEndpoint item) {
      this.index = index;
      this.builder = new IBMCloudServiceEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) IBMCloudPlatformSpecFluent.this.setToServiceEndpoints(index, builder.build());
    }
    
    public N endServiceEndpoint() {
      return and();
    }
    
  }
}