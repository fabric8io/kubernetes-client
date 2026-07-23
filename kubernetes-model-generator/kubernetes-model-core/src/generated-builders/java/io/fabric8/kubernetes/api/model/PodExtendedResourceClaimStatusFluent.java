package io.fabric8.kubernetes.api.model;

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
public class PodExtendedResourceClaimStatusFluent<A extends io.fabric8.kubernetes.api.model.PodExtendedResourceClaimStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ContainerExtendedResourceRequestBuilder> requestMappings = new ArrayList<ContainerExtendedResourceRequestBuilder>();
  private String resourceClaimName;

  public PodExtendedResourceClaimStatusFluent() {
  }
  
  public PodExtendedResourceClaimStatusFluent(PodExtendedResourceClaimStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToRequestMappings(Collection<ContainerExtendedResourceRequest> items) {
    if (this.requestMappings == null) {
      this.requestMappings = new ArrayList();
    }
    for (ContainerExtendedResourceRequest item : items) {
        ContainerExtendedResourceRequestBuilder builder = new ContainerExtendedResourceRequestBuilder(item);
        _visitables.get("requestMappings").add(builder);
        this.requestMappings.add(builder);
    }
    return (A) this;
  }
  
  public RequestMappingsNested<A> addNewRequestMapping() {
    return new RequestMappingsNested(-1, null);
  }
  
  public A addNewRequestMapping(String containerName,String requestName,String resourceName) {
    return (A) this.addToRequestMappings(new ContainerExtendedResourceRequest(containerName, requestName, resourceName));
  }
  
  public RequestMappingsNested<A> addNewRequestMappingLike(ContainerExtendedResourceRequest item) {
    return new RequestMappingsNested(-1, item);
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
  
  public A addToRequestMappings(ContainerExtendedResourceRequest... items) {
    if (this.requestMappings == null) {
      this.requestMappings = new ArrayList();
    }
    for (ContainerExtendedResourceRequest item : items) {
        ContainerExtendedResourceRequestBuilder builder = new ContainerExtendedResourceRequestBuilder(item);
        _visitables.get("requestMappings").add(builder);
        this.requestMappings.add(builder);
    }
    return (A) this;
  }
  
  public A addToRequestMappings(int index,ContainerExtendedResourceRequest item) {
    if (this.requestMappings == null) {
      this.requestMappings = new ArrayList();
    }
    ContainerExtendedResourceRequestBuilder builder = new ContainerExtendedResourceRequestBuilder(item);
    if (index < 0 || index >= requestMappings.size()) {
        _visitables.get("requestMappings").add(builder);
        requestMappings.add(builder);
    } else {
        _visitables.get("requestMappings").add(builder);
        requestMappings.add(index, builder);
    }
    return (A) this;
  }
  
  public ContainerExtendedResourceRequest buildFirstRequestMapping() {
    return this.requestMappings.get(0).build();
  }
  
  public ContainerExtendedResourceRequest buildLastRequestMapping() {
    return this.requestMappings.get(requestMappings.size() - 1).build();
  }
  
  public ContainerExtendedResourceRequest buildMatchingRequestMapping(Predicate<ContainerExtendedResourceRequestBuilder> predicate) {
      for (ContainerExtendedResourceRequestBuilder item : requestMappings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ContainerExtendedResourceRequest buildRequestMapping(int index) {
    return this.requestMappings.get(index).build();
  }
  
  public List<ContainerExtendedResourceRequest> buildRequestMappings() {
    return this.requestMappings != null ? build(requestMappings) : null;
  }
  
  protected void copyInstance(PodExtendedResourceClaimStatus instance) {
    instance = instance != null ? instance : new PodExtendedResourceClaimStatus();
    if (instance != null) {
        this.withRequestMappings(instance.getRequestMappings());
        this.withResourceClaimName(instance.getResourceClaimName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RequestMappingsNested<A> editFirstRequestMapping() {
    if (requestMappings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "requestMappings"));
    }
    return this.setNewRequestMappingLike(0, this.buildRequestMapping(0));
  }
  
  public RequestMappingsNested<A> editLastRequestMapping() {
    int index = requestMappings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "requestMappings"));
    }
    return this.setNewRequestMappingLike(index, this.buildRequestMapping(index));
  }
  
  public RequestMappingsNested<A> editMatchingRequestMapping(Predicate<ContainerExtendedResourceRequestBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < requestMappings.size();i++) {
      if (predicate.test(requestMappings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "requestMappings"));
    }
    return this.setNewRequestMappingLike(index, this.buildRequestMapping(index));
  }
  
  public RequestMappingsNested<A> editRequestMapping(int index) {
    if (requestMappings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "requestMappings"));
    }
    return this.setNewRequestMappingLike(index, this.buildRequestMapping(index));
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
    PodExtendedResourceClaimStatusFluent that = (PodExtendedResourceClaimStatusFluent) o;
    if (!(Objects.equals(requestMappings, that.requestMappings))) {
      return false;
    }
    if (!(Objects.equals(resourceClaimName, that.resourceClaimName))) {
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
  
  public String getResourceClaimName() {
    return this.resourceClaimName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingRequestMapping(Predicate<ContainerExtendedResourceRequestBuilder> predicate) {
      for (ContainerExtendedResourceRequestBuilder item : requestMappings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRequestMappings() {
    return this.requestMappings != null && !(this.requestMappings.isEmpty());
  }
  
  public boolean hasResourceClaimName() {
    return this.resourceClaimName != null;
  }
  
  public int hashCode() {
    return Objects.hash(requestMappings, resourceClaimName, additionalProperties);
  }
  
  public A removeAllFromRequestMappings(Collection<ContainerExtendedResourceRequest> items) {
    if (this.requestMappings == null) {
      return (A) this;
    }
    for (ContainerExtendedResourceRequest item : items) {
        ContainerExtendedResourceRequestBuilder builder = new ContainerExtendedResourceRequestBuilder(item);
        _visitables.get("requestMappings").remove(builder);
        this.requestMappings.remove(builder);
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
  
  public A removeFromRequestMappings(ContainerExtendedResourceRequest... items) {
    if (this.requestMappings == null) {
      return (A) this;
    }
    for (ContainerExtendedResourceRequest item : items) {
        ContainerExtendedResourceRequestBuilder builder = new ContainerExtendedResourceRequestBuilder(item);
        _visitables.get("requestMappings").remove(builder);
        this.requestMappings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRequestMappings(Predicate<ContainerExtendedResourceRequestBuilder> predicate) {
    if (requestMappings == null) {
      return (A) this;
    }
    Iterator<ContainerExtendedResourceRequestBuilder> each = requestMappings.iterator();
    List visitables = _visitables.get("requestMappings");
    while (each.hasNext()) {
        ContainerExtendedResourceRequestBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RequestMappingsNested<A> setNewRequestMappingLike(int index,ContainerExtendedResourceRequest item) {
    return new RequestMappingsNested(index, item);
  }
  
  public A setToRequestMappings(int index,ContainerExtendedResourceRequest item) {
    if (this.requestMappings == null) {
      this.requestMappings = new ArrayList();
    }
    ContainerExtendedResourceRequestBuilder builder = new ContainerExtendedResourceRequestBuilder(item);
    if (index < 0 || index >= requestMappings.size()) {
        _visitables.get("requestMappings").add(builder);
        requestMappings.add(builder);
    } else {
        _visitables.get("requestMappings").add(builder);
        requestMappings.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(requestMappings == null) && !(requestMappings.isEmpty())) {
        sb.append("requestMappings:");
        sb.append(requestMappings);
        sb.append(",");
    }
    if (!(resourceClaimName == null)) {
        sb.append("resourceClaimName:");
        sb.append(resourceClaimName);
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
  
  public A withRequestMappings(List<ContainerExtendedResourceRequest> requestMappings) {
    if (this.requestMappings != null) {
      this._visitables.get("requestMappings").clear();
    }
    if (requestMappings != null) {
        this.requestMappings = new ArrayList();
        for (ContainerExtendedResourceRequest item : requestMappings) {
          this.addToRequestMappings(item);
        }
    } else {
      this.requestMappings = null;
    }
    return (A) this;
  }
  
  public A withRequestMappings(ContainerExtendedResourceRequest... requestMappings) {
    if (this.requestMappings != null) {
        this.requestMappings.clear();
        _visitables.remove("requestMappings");
    }
    if (requestMappings != null) {
      for (ContainerExtendedResourceRequest item : requestMappings) {
        this.addToRequestMappings(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceClaimName(String resourceClaimName) {
    this.resourceClaimName = resourceClaimName;
    return (A) this;
  }
  public class RequestMappingsNested<N> extends ContainerExtendedResourceRequestFluent<RequestMappingsNested<N>> implements Nested<N>{
  
    ContainerExtendedResourceRequestBuilder builder;
    int index;
  
    RequestMappingsNested(int index,ContainerExtendedResourceRequest item) {
      this.index = index;
      this.builder = new ContainerExtendedResourceRequestBuilder(this, item);
    }
  
    public N and() {
      return (N) PodExtendedResourceClaimStatusFluent.this.setToRequestMappings(index, builder.build());
    }
    
    public N endRequestMapping() {
      return and();
    }
    
  }
}