package io.fabric8.kubernetes.api.model.authorization.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.LabelSelectorRequirement;
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
public class LabelSelectorAttributesFluent<A extends io.fabric8.kubernetes.api.model.authorization.v1.LabelSelectorAttributesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String rawSelector;
  private List<LabelSelectorRequirement> requirements = new ArrayList<LabelSelectorRequirement>();

  public LabelSelectorAttributesFluent() {
  }
  
  public LabelSelectorAttributesFluent(LabelSelectorAttributes instance) {
    this.copyInstance(instance);
  }

  public A addAllToRequirements(Collection<LabelSelectorRequirement> items) {
    if (this.requirements == null) {
      this.requirements = new ArrayList();
    }
    for (LabelSelectorRequirement item : items) {
      this.requirements.add(item);
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
  
  public A addToRequirements(LabelSelectorRequirement... items) {
    if (this.requirements == null) {
      this.requirements = new ArrayList();
    }
    for (LabelSelectorRequirement item : items) {
      this.requirements.add(item);
    }
    return (A) this;
  }
  
  public A addToRequirements(int index,LabelSelectorRequirement item) {
    if (this.requirements == null) {
      this.requirements = new ArrayList();
    }
    this.requirements.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(LabelSelectorAttributes instance) {
    instance = instance != null ? instance : new LabelSelectorAttributes();
    if (instance != null) {
        this.withRawSelector(instance.getRawSelector());
        this.withRequirements(instance.getRequirements());
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
    LabelSelectorAttributesFluent that = (LabelSelectorAttributesFluent) o;
    if (!(Objects.equals(rawSelector, that.rawSelector))) {
      return false;
    }
    if (!(Objects.equals(requirements, that.requirements))) {
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
  
  public LabelSelectorRequirement getFirstRequirement() {
    return this.requirements.get(0);
  }
  
  public LabelSelectorRequirement getLastRequirement() {
    return this.requirements.get(requirements.size() - 1);
  }
  
  public LabelSelectorRequirement getMatchingRequirement(Predicate<LabelSelectorRequirement> predicate) {
      for (LabelSelectorRequirement item : requirements) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRawSelector() {
    return this.rawSelector;
  }
  
  public LabelSelectorRequirement getRequirement(int index) {
    return this.requirements.get(index);
  }
  
  public List<LabelSelectorRequirement> getRequirements() {
    return this.requirements;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingRequirement(Predicate<LabelSelectorRequirement> predicate) {
      for (LabelSelectorRequirement item : requirements) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRawSelector() {
    return this.rawSelector != null;
  }
  
  public boolean hasRequirements() {
    return this.requirements != null && !(this.requirements.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(rawSelector, requirements, additionalProperties);
  }
  
  public A removeAllFromRequirements(Collection<LabelSelectorRequirement> items) {
    if (this.requirements == null) {
      return (A) this;
    }
    for (LabelSelectorRequirement item : items) {
      this.requirements.remove(item);
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
  
  public A removeFromRequirements(LabelSelectorRequirement... items) {
    if (this.requirements == null) {
      return (A) this;
    }
    for (LabelSelectorRequirement item : items) {
      this.requirements.remove(item);
    }
    return (A) this;
  }
  
  public A setToRequirements(int index,LabelSelectorRequirement item) {
    if (this.requirements == null) {
      this.requirements = new ArrayList();
    }
    this.requirements.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(rawSelector == null)) {
        sb.append("rawSelector:");
        sb.append(rawSelector);
        sb.append(",");
    }
    if (!(requirements == null) && !(requirements.isEmpty())) {
        sb.append("requirements:");
        sb.append(requirements);
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
  
  public A withRawSelector(String rawSelector) {
    this.rawSelector = rawSelector;
    return (A) this;
  }
  
  public A withRequirements(List<LabelSelectorRequirement> requirements) {
    if (requirements != null) {
        this.requirements = new ArrayList();
        for (LabelSelectorRequirement item : requirements) {
          this.addToRequirements(item);
        }
    } else {
      this.requirements = null;
    }
    return (A) this;
  }
  
  public A withRequirements(LabelSelectorRequirement... requirements) {
    if (this.requirements != null) {
        this.requirements.clear();
        _visitables.remove("requirements");
    }
    if (requirements != null) {
      for (LabelSelectorRequirement item : requirements) {
        this.addToRequirements(item);
      }
    }
    return (A) this;
  }
  
}