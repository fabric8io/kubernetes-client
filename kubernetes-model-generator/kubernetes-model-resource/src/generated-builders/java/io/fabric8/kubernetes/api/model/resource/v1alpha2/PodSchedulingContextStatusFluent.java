package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
public class PodSchedulingContextStatusFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.PodSchedulingContextStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ResourceClaimSchedulingStatusBuilder> resourceClaims = new ArrayList<ResourceClaimSchedulingStatusBuilder>();

  public PodSchedulingContextStatusFluent() {
  }
  
  public PodSchedulingContextStatusFluent(PodSchedulingContextStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToResourceClaims(Collection<ResourceClaimSchedulingStatus> items) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    for (ResourceClaimSchedulingStatus item : items) {
        ResourceClaimSchedulingStatusBuilder builder = new ResourceClaimSchedulingStatusBuilder(item);
        _visitables.get("resourceClaims").add(builder);
        this.resourceClaims.add(builder);
    }
    return (A) this;
  }
  
  public ResourceClaimsNested<A> addNewResourceClaim() {
    return new ResourceClaimsNested(-1, null);
  }
  
  public ResourceClaimsNested<A> addNewResourceClaimLike(ResourceClaimSchedulingStatus item) {
    return new ResourceClaimsNested(-1, item);
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
  
  public A addToResourceClaims(ResourceClaimSchedulingStatus... items) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    for (ResourceClaimSchedulingStatus item : items) {
        ResourceClaimSchedulingStatusBuilder builder = new ResourceClaimSchedulingStatusBuilder(item);
        _visitables.get("resourceClaims").add(builder);
        this.resourceClaims.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceClaims(int index,ResourceClaimSchedulingStatus item) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    ResourceClaimSchedulingStatusBuilder builder = new ResourceClaimSchedulingStatusBuilder(item);
    if (index < 0 || index >= resourceClaims.size()) {
        _visitables.get("resourceClaims").add(builder);
        resourceClaims.add(builder);
    } else {
        _visitables.get("resourceClaims").add(builder);
        resourceClaims.add(index, builder);
    }
    return (A) this;
  }
  
  public ResourceClaimSchedulingStatus buildFirstResourceClaim() {
    return this.resourceClaims.get(0).build();
  }
  
  public ResourceClaimSchedulingStatus buildLastResourceClaim() {
    return this.resourceClaims.get(resourceClaims.size() - 1).build();
  }
  
  public ResourceClaimSchedulingStatus buildMatchingResourceClaim(Predicate<ResourceClaimSchedulingStatusBuilder> predicate) {
      for (ResourceClaimSchedulingStatusBuilder item : resourceClaims) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceClaimSchedulingStatus buildResourceClaim(int index) {
    return this.resourceClaims.get(index).build();
  }
  
  public List<ResourceClaimSchedulingStatus> buildResourceClaims() {
    return this.resourceClaims != null ? build(resourceClaims) : null;
  }
  
  protected void copyInstance(PodSchedulingContextStatus instance) {
    instance = instance != null ? instance : new PodSchedulingContextStatus();
    if (instance != null) {
        this.withResourceClaims(instance.getResourceClaims());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourceClaimsNested<A> editFirstResourceClaim() {
    if (resourceClaims.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourceClaims"));
    }
    return this.setNewResourceClaimLike(0, this.buildResourceClaim(0));
  }
  
  public ResourceClaimsNested<A> editLastResourceClaim() {
    int index = resourceClaims.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceClaims"));
    }
    return this.setNewResourceClaimLike(index, this.buildResourceClaim(index));
  }
  
  public ResourceClaimsNested<A> editMatchingResourceClaim(Predicate<ResourceClaimSchedulingStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resourceClaims.size();i++) {
      if (predicate.test(resourceClaims.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resourceClaims"));
    }
    return this.setNewResourceClaimLike(index, this.buildResourceClaim(index));
  }
  
  public ResourceClaimsNested<A> editResourceClaim(int index) {
    if (resourceClaims.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resourceClaims"));
    }
    return this.setNewResourceClaimLike(index, this.buildResourceClaim(index));
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
    PodSchedulingContextStatusFluent that = (PodSchedulingContextStatusFluent) o;
    if (!(Objects.equals(resourceClaims, that.resourceClaims))) {
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
  
  public boolean hasMatchingResourceClaim(Predicate<ResourceClaimSchedulingStatusBuilder> predicate) {
      for (ResourceClaimSchedulingStatusBuilder item : resourceClaims) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResourceClaims() {
    return this.resourceClaims != null && !(this.resourceClaims.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(resourceClaims, additionalProperties);
  }
  
  public A removeAllFromResourceClaims(Collection<ResourceClaimSchedulingStatus> items) {
    if (this.resourceClaims == null) {
      return (A) this;
    }
    for (ResourceClaimSchedulingStatus item : items) {
        ResourceClaimSchedulingStatusBuilder builder = new ResourceClaimSchedulingStatusBuilder(item);
        _visitables.get("resourceClaims").remove(builder);
        this.resourceClaims.remove(builder);
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
  
  public A removeFromResourceClaims(ResourceClaimSchedulingStatus... items) {
    if (this.resourceClaims == null) {
      return (A) this;
    }
    for (ResourceClaimSchedulingStatus item : items) {
        ResourceClaimSchedulingStatusBuilder builder = new ResourceClaimSchedulingStatusBuilder(item);
        _visitables.get("resourceClaims").remove(builder);
        this.resourceClaims.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceClaims(Predicate<ResourceClaimSchedulingStatusBuilder> predicate) {
    if (resourceClaims == null) {
      return (A) this;
    }
    Iterator<ResourceClaimSchedulingStatusBuilder> each = resourceClaims.iterator();
    List visitables = _visitables.get("resourceClaims");
    while (each.hasNext()) {
        ResourceClaimSchedulingStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResourceClaimsNested<A> setNewResourceClaimLike(int index,ResourceClaimSchedulingStatus item) {
    return new ResourceClaimsNested(index, item);
  }
  
  public A setToResourceClaims(int index,ResourceClaimSchedulingStatus item) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    ResourceClaimSchedulingStatusBuilder builder = new ResourceClaimSchedulingStatusBuilder(item);
    if (index < 0 || index >= resourceClaims.size()) {
        _visitables.get("resourceClaims").add(builder);
        resourceClaims.add(builder);
    } else {
        _visitables.get("resourceClaims").add(builder);
        resourceClaims.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(resourceClaims == null) && !(resourceClaims.isEmpty())) {
        sb.append("resourceClaims:");
        sb.append(resourceClaims);
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
  
  public A withResourceClaims(List<ResourceClaimSchedulingStatus> resourceClaims) {
    if (this.resourceClaims != null) {
      this._visitables.get("resourceClaims").clear();
    }
    if (resourceClaims != null) {
        this.resourceClaims = new ArrayList();
        for (ResourceClaimSchedulingStatus item : resourceClaims) {
          this.addToResourceClaims(item);
        }
    } else {
      this.resourceClaims = null;
    }
    return (A) this;
  }
  
  public A withResourceClaims(ResourceClaimSchedulingStatus... resourceClaims) {
    if (this.resourceClaims != null) {
        this.resourceClaims.clear();
        _visitables.remove("resourceClaims");
    }
    if (resourceClaims != null) {
      for (ResourceClaimSchedulingStatus item : resourceClaims) {
        this.addToResourceClaims(item);
      }
    }
    return (A) this;
  }
  public class ResourceClaimsNested<N> extends ResourceClaimSchedulingStatusFluent<ResourceClaimsNested<N>> implements Nested<N>{
  
    ResourceClaimSchedulingStatusBuilder builder;
    int index;
  
    ResourceClaimsNested(int index,ResourceClaimSchedulingStatus item) {
      this.index = index;
      this.builder = new ResourceClaimSchedulingStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSchedulingContextStatusFluent.this.setToResourceClaims(index, builder.build());
    }
    
    public N endResourceClaim() {
      return and();
    }
    
  }
}