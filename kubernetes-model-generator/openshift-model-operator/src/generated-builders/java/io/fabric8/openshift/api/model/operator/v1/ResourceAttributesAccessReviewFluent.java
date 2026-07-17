package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.authorization.v1.ResourceAttributes;
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
public class ResourceAttributesAccessReviewFluent<A extends io.fabric8.openshift.api.model.operator.v1.ResourceAttributesAccessReviewFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<ResourceAttributes> missing = new ArrayList<ResourceAttributes>();
  private List<ResourceAttributes> required = new ArrayList<ResourceAttributes>();

  public ResourceAttributesAccessReviewFluent() {
  }
  
  public ResourceAttributesAccessReviewFluent(ResourceAttributesAccessReview instance) {
    this.copyInstance(instance);
  }

  public A addAllToMissing(Collection<ResourceAttributes> items) {
    if (this.missing == null) {
      this.missing = new ArrayList();
    }
    for (ResourceAttributes item : items) {
      this.missing.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRequired(Collection<ResourceAttributes> items) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    for (ResourceAttributes item : items) {
      this.required.add(item);
    }
    return (A) this;
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
  
  public A addToMissing(ResourceAttributes... items) {
    if (this.missing == null) {
      this.missing = new ArrayList();
    }
    for (ResourceAttributes item : items) {
      this.missing.add(item);
    }
    return (A) this;
  }
  
  public A addToMissing(int index,ResourceAttributes item) {
    if (this.missing == null) {
      this.missing = new ArrayList();
    }
    this.missing.add(index, item);
    return (A) this;
  }
  
  public A addToRequired(ResourceAttributes... items) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    for (ResourceAttributes item : items) {
      this.required.add(item);
    }
    return (A) this;
  }
  
  public A addToRequired(int index,ResourceAttributes item) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    this.required.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ResourceAttributesAccessReview instance) {
    instance = instance != null ? instance : new ResourceAttributesAccessReview();
    if (instance != null) {
        this.withMissing(instance.getMissing());
        this.withRequired(instance.getRequired());
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
    ResourceAttributesAccessReviewFluent that = (ResourceAttributesAccessReviewFluent) o;
    if (!(Objects.equals(missing, that.missing))) {
      return false;
    }
    if (!(Objects.equals(required, that.required))) {
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
  
  public ResourceAttributes getFirstMissing() {
    return this.missing.get(0);
  }
  
  public ResourceAttributes getFirstRequired() {
    return this.required.get(0);
  }
  
  public ResourceAttributes getLastMissing() {
    return this.missing.get(missing.size() - 1);
  }
  
  public ResourceAttributes getLastRequired() {
    return this.required.get(required.size() - 1);
  }
  
  public ResourceAttributes getMatchingMissing(Predicate<ResourceAttributes> predicate) {
      for (ResourceAttributes item : missing) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public ResourceAttributes getMatchingRequired(Predicate<ResourceAttributes> predicate) {
      for (ResourceAttributes item : required) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<ResourceAttributes> getMissing() {
    return this.missing;
  }
  
  public ResourceAttributes getMissing(int index) {
    return this.missing.get(index);
  }
  
  public List<ResourceAttributes> getRequired() {
    return this.required;
  }
  
  public ResourceAttributes getRequired(int index) {
    return this.required.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingMissing(Predicate<ResourceAttributes> predicate) {
      for (ResourceAttributes item : missing) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRequired(Predicate<ResourceAttributes> predicate) {
      for (ResourceAttributes item : required) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMissing() {
    return this.missing != null && !(this.missing.isEmpty());
  }
  
  public boolean hasRequired() {
    return this.required != null && !(this.required.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(missing, required, additionalProperties);
  }
  
  public A removeAllFromMissing(Collection<ResourceAttributes> items) {
    if (this.missing == null) {
      return (A) this;
    }
    for (ResourceAttributes item : items) {
      this.missing.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRequired(Collection<ResourceAttributes> items) {
    if (this.required == null) {
      return (A) this;
    }
    for (ResourceAttributes item : items) {
      this.required.remove(item);
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
  
  public A removeFromMissing(ResourceAttributes... items) {
    if (this.missing == null) {
      return (A) this;
    }
    for (ResourceAttributes item : items) {
      this.missing.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRequired(ResourceAttributes... items) {
    if (this.required == null) {
      return (A) this;
    }
    for (ResourceAttributes item : items) {
      this.required.remove(item);
    }
    return (A) this;
  }
  
  public A setToMissing(int index,ResourceAttributes item) {
    if (this.missing == null) {
      this.missing = new ArrayList();
    }
    this.missing.set(index, item);
    return (A) this;
  }
  
  public A setToRequired(int index,ResourceAttributes item) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    this.required.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(missing == null) && !(missing.isEmpty())) {
        sb.append("missing:");
        sb.append(missing);
        sb.append(",");
    }
    if (!(required == null) && !(required.isEmpty())) {
        sb.append("required:");
        sb.append(required);
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
  
  public A withMissing(List<ResourceAttributes> missing) {
    if (missing != null) {
        this.missing = new ArrayList();
        for (ResourceAttributes item : missing) {
          this.addToMissing(item);
        }
    } else {
      this.missing = null;
    }
    return (A) this;
  }
  
  public A withMissing(ResourceAttributes... missing) {
    if (this.missing != null) {
        this.missing.clear();
        _visitables.remove("missing");
    }
    if (missing != null) {
      for (ResourceAttributes item : missing) {
        this.addToMissing(item);
      }
    }
    return (A) this;
  }
  
  public A withRequired(List<ResourceAttributes> required) {
    if (required != null) {
        this.required = new ArrayList();
        for (ResourceAttributes item : required) {
          this.addToRequired(item);
        }
    } else {
      this.required = null;
    }
    return (A) this;
  }
  
  public A withRequired(ResourceAttributes... required) {
    if (this.required != null) {
        this.required.clear();
        _visitables.remove("required");
    }
    if (required != null) {
      for (ResourceAttributes item : required) {
        this.addToRequired(item);
      }
    }
    return (A) this;
  }
  
}