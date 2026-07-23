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
public class AlibabaCloudPlatformStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.AlibabaCloudPlatformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String region;
  private String resourceGroupID;
  private ArrayList<AlibabaCloudResourceTagBuilder> resourceTags = new ArrayList<AlibabaCloudResourceTagBuilder>();

  public AlibabaCloudPlatformStatusFluent() {
  }
  
  public AlibabaCloudPlatformStatusFluent(AlibabaCloudPlatformStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToResourceTags(Collection<AlibabaCloudResourceTag> items) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    for (AlibabaCloudResourceTag item : items) {
        AlibabaCloudResourceTagBuilder builder = new AlibabaCloudResourceTagBuilder(item);
        _visitables.get("resourceTags").add(builder);
        this.resourceTags.add(builder);
    }
    return (A) this;
  }
  
  public ResourceTagsNested<A> addNewResourceTag() {
    return new ResourceTagsNested(-1, null);
  }
  
  public A addNewResourceTag(String key,String value) {
    return (A) this.addToResourceTags(new AlibabaCloudResourceTag(key, value));
  }
  
  public ResourceTagsNested<A> addNewResourceTagLike(AlibabaCloudResourceTag item) {
    return new ResourceTagsNested(-1, item);
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
  
  public A addToResourceTags(AlibabaCloudResourceTag... items) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    for (AlibabaCloudResourceTag item : items) {
        AlibabaCloudResourceTagBuilder builder = new AlibabaCloudResourceTagBuilder(item);
        _visitables.get("resourceTags").add(builder);
        this.resourceTags.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceTags(int index,AlibabaCloudResourceTag item) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    AlibabaCloudResourceTagBuilder builder = new AlibabaCloudResourceTagBuilder(item);
    if (index < 0 || index >= resourceTags.size()) {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(builder);
    } else {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(index, builder);
    }
    return (A) this;
  }
  
  public AlibabaCloudResourceTag buildFirstResourceTag() {
    return this.resourceTags.get(0).build();
  }
  
  public AlibabaCloudResourceTag buildLastResourceTag() {
    return this.resourceTags.get(resourceTags.size() - 1).build();
  }
  
  public AlibabaCloudResourceTag buildMatchingResourceTag(Predicate<AlibabaCloudResourceTagBuilder> predicate) {
      for (AlibabaCloudResourceTagBuilder item : resourceTags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AlibabaCloudResourceTag buildResourceTag(int index) {
    return this.resourceTags.get(index).build();
  }
  
  public List<AlibabaCloudResourceTag> buildResourceTags() {
    return this.resourceTags != null ? build(resourceTags) : null;
  }
  
  protected void copyInstance(AlibabaCloudPlatformStatus instance) {
    instance = instance != null ? instance : new AlibabaCloudPlatformStatus();
    if (instance != null) {
        this.withRegion(instance.getRegion());
        this.withResourceGroupID(instance.getResourceGroupID());
        this.withResourceTags(instance.getResourceTags());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourceTagsNested<A> editFirstResourceTag() {
    if (resourceTags.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourceTags"));
    }
    return this.setNewResourceTagLike(0, this.buildResourceTag(0));
  }
  
  public ResourceTagsNested<A> editLastResourceTag() {
    int index = resourceTags.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceTags"));
    }
    return this.setNewResourceTagLike(index, this.buildResourceTag(index));
  }
  
  public ResourceTagsNested<A> editMatchingResourceTag(Predicate<AlibabaCloudResourceTagBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resourceTags.size();i++) {
      if (predicate.test(resourceTags.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resourceTags"));
    }
    return this.setNewResourceTagLike(index, this.buildResourceTag(index));
  }
  
  public ResourceTagsNested<A> editResourceTag(int index) {
    if (resourceTags.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resourceTags"));
    }
    return this.setNewResourceTagLike(index, this.buildResourceTag(index));
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
    AlibabaCloudPlatformStatusFluent that = (AlibabaCloudPlatformStatusFluent) o;
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(resourceGroupID, that.resourceGroupID))) {
      return false;
    }
    if (!(Objects.equals(resourceTags, that.resourceTags))) {
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
  
  public String getRegion() {
    return this.region;
  }
  
  public String getResourceGroupID() {
    return this.resourceGroupID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingResourceTag(Predicate<AlibabaCloudResourceTagBuilder> predicate) {
      for (AlibabaCloudResourceTagBuilder item : resourceTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasResourceGroupID() {
    return this.resourceGroupID != null;
  }
  
  public boolean hasResourceTags() {
    return this.resourceTags != null && !(this.resourceTags.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(region, resourceGroupID, resourceTags, additionalProperties);
  }
  
  public A removeAllFromResourceTags(Collection<AlibabaCloudResourceTag> items) {
    if (this.resourceTags == null) {
      return (A) this;
    }
    for (AlibabaCloudResourceTag item : items) {
        AlibabaCloudResourceTagBuilder builder = new AlibabaCloudResourceTagBuilder(item);
        _visitables.get("resourceTags").remove(builder);
        this.resourceTags.remove(builder);
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
  
  public A removeFromResourceTags(AlibabaCloudResourceTag... items) {
    if (this.resourceTags == null) {
      return (A) this;
    }
    for (AlibabaCloudResourceTag item : items) {
        AlibabaCloudResourceTagBuilder builder = new AlibabaCloudResourceTagBuilder(item);
        _visitables.get("resourceTags").remove(builder);
        this.resourceTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceTags(Predicate<AlibabaCloudResourceTagBuilder> predicate) {
    if (resourceTags == null) {
      return (A) this;
    }
    Iterator<AlibabaCloudResourceTagBuilder> each = resourceTags.iterator();
    List visitables = _visitables.get("resourceTags");
    while (each.hasNext()) {
        AlibabaCloudResourceTagBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResourceTagsNested<A> setNewResourceTagLike(int index,AlibabaCloudResourceTag item) {
    return new ResourceTagsNested(index, item);
  }
  
  public A setToResourceTags(int index,AlibabaCloudResourceTag item) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    AlibabaCloudResourceTagBuilder builder = new AlibabaCloudResourceTagBuilder(item);
    if (index < 0 || index >= resourceTags.size()) {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(builder);
    } else {
        _visitables.get("resourceTags").add(builder);
        resourceTags.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(resourceGroupID == null)) {
        sb.append("resourceGroupID:");
        sb.append(resourceGroupID);
        sb.append(",");
    }
    if (!(resourceTags == null) && !(resourceTags.isEmpty())) {
        sb.append("resourceTags:");
        sb.append(resourceTags);
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
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withResourceGroupID(String resourceGroupID) {
    this.resourceGroupID = resourceGroupID;
    return (A) this;
  }
  
  public A withResourceTags(List<AlibabaCloudResourceTag> resourceTags) {
    if (this.resourceTags != null) {
      this._visitables.get("resourceTags").clear();
    }
    if (resourceTags != null) {
        this.resourceTags = new ArrayList();
        for (AlibabaCloudResourceTag item : resourceTags) {
          this.addToResourceTags(item);
        }
    } else {
      this.resourceTags = null;
    }
    return (A) this;
  }
  
  public A withResourceTags(AlibabaCloudResourceTag... resourceTags) {
    if (this.resourceTags != null) {
        this.resourceTags.clear();
        _visitables.remove("resourceTags");
    }
    if (resourceTags != null) {
      for (AlibabaCloudResourceTag item : resourceTags) {
        this.addToResourceTags(item);
      }
    }
    return (A) this;
  }
  public class ResourceTagsNested<N> extends AlibabaCloudResourceTagFluent<ResourceTagsNested<N>> implements Nested<N>{
  
    AlibabaCloudResourceTagBuilder builder;
    int index;
  
    ResourceTagsNested(int index,AlibabaCloudResourceTag item) {
      this.index = index;
      this.builder = new AlibabaCloudResourceTagBuilder(this, item);
    }
  
    public N and() {
      return (N) AlibabaCloudPlatformStatusFluent.this.setToResourceTags(index, builder.build());
    }
    
    public N endResourceTag() {
      return and();
    }
    
  }
}