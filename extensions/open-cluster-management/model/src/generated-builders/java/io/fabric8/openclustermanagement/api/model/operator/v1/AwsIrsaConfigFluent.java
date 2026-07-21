package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class AwsIrsaConfigFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.AwsIrsaConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> autoApprovedIdentities = new ArrayList<String>();
  private String hubClusterArn;
  private List<String> tags = new ArrayList<String>();

  public AwsIrsaConfigFluent() {
  }
  
  public AwsIrsaConfigFluent(AwsIrsaConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToAutoApprovedIdentities(Collection<String> items) {
    if (this.autoApprovedIdentities == null) {
      this.autoApprovedIdentities = new ArrayList();
    }
    for (String item : items) {
      this.autoApprovedIdentities.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTags(Collection<String> items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
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
  
  public A addToAutoApprovedIdentities(String... items) {
    if (this.autoApprovedIdentities == null) {
      this.autoApprovedIdentities = new ArrayList();
    }
    for (String item : items) {
      this.autoApprovedIdentities.add(item);
    }
    return (A) this;
  }
  
  public A addToAutoApprovedIdentities(int index,String item) {
    if (this.autoApprovedIdentities == null) {
      this.autoApprovedIdentities = new ArrayList();
    }
    this.autoApprovedIdentities.add(index, item);
    return (A) this;
  }
  
  public A addToTags(String... items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
    }
    return (A) this;
  }
  
  public A addToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(AwsIrsaConfig instance) {
    instance = instance != null ? instance : new AwsIrsaConfig();
    if (instance != null) {
        this.withAutoApprovedIdentities(instance.getAutoApprovedIdentities());
        this.withHubClusterArn(instance.getHubClusterArn());
        this.withTags(instance.getTags());
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
    AwsIrsaConfigFluent that = (AwsIrsaConfigFluent) o;
    if (!(Objects.equals(autoApprovedIdentities, that.autoApprovedIdentities))) {
      return false;
    }
    if (!(Objects.equals(hubClusterArn, that.hubClusterArn))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
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
  
  public List<String> getAutoApprovedIdentities() {
    return this.autoApprovedIdentities;
  }
  
  public String getAutoApprovedIdentity(int index) {
    return this.autoApprovedIdentities.get(index);
  }
  
  public String getFirstAutoApprovedIdentity() {
    return this.autoApprovedIdentities.get(0);
  }
  
  public String getFirstTag() {
    return this.tags.get(0);
  }
  
  public String getHubClusterArn() {
    return this.hubClusterArn;
  }
  
  public String getLastAutoApprovedIdentity() {
    return this.autoApprovedIdentities.get(autoApprovedIdentities.size() - 1);
  }
  
  public String getLastTag() {
    return this.tags.get(tags.size() - 1);
  }
  
  public String getMatchingAutoApprovedIdentity(Predicate<String> predicate) {
      for (String item : autoApprovedIdentities) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getTag(int index) {
    return this.tags.get(index);
  }
  
  public List<String> getTags() {
    return this.tags;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAutoApprovedIdentities() {
    return this.autoApprovedIdentities != null && !(this.autoApprovedIdentities.isEmpty());
  }
  
  public boolean hasHubClusterArn() {
    return this.hubClusterArn != null;
  }
  
  public boolean hasMatchingAutoApprovedIdentity(Predicate<String> predicate) {
      for (String item : autoApprovedIdentities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTags() {
    return this.tags != null && !(this.tags.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(autoApprovedIdentities, hubClusterArn, tags, additionalProperties);
  }
  
  public A removeAllFromAutoApprovedIdentities(Collection<String> items) {
    if (this.autoApprovedIdentities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.autoApprovedIdentities.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTags(Collection<String> items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
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
  
  public A removeFromAutoApprovedIdentities(String... items) {
    if (this.autoApprovedIdentities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.autoApprovedIdentities.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTags(String... items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
    }
    return (A) this;
  }
  
  public A setToAutoApprovedIdentities(int index,String item) {
    if (this.autoApprovedIdentities == null) {
      this.autoApprovedIdentities = new ArrayList();
    }
    this.autoApprovedIdentities.set(index, item);
    return (A) this;
  }
  
  public A setToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(autoApprovedIdentities == null) && !(autoApprovedIdentities.isEmpty())) {
        sb.append("autoApprovedIdentities:");
        sb.append(autoApprovedIdentities);
        sb.append(",");
    }
    if (!(hubClusterArn == null)) {
        sb.append("hubClusterArn:");
        sb.append(hubClusterArn);
        sb.append(",");
    }
    if (!(tags == null) && !(tags.isEmpty())) {
        sb.append("tags:");
        sb.append(tags);
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
  
  public A withAutoApprovedIdentities(List<String> autoApprovedIdentities) {
    if (autoApprovedIdentities != null) {
        this.autoApprovedIdentities = new ArrayList();
        for (String item : autoApprovedIdentities) {
          this.addToAutoApprovedIdentities(item);
        }
    } else {
      this.autoApprovedIdentities = null;
    }
    return (A) this;
  }
  
  public A withAutoApprovedIdentities(String... autoApprovedIdentities) {
    if (this.autoApprovedIdentities != null) {
        this.autoApprovedIdentities.clear();
        _visitables.remove("autoApprovedIdentities");
    }
    if (autoApprovedIdentities != null) {
      for (String item : autoApprovedIdentities) {
        this.addToAutoApprovedIdentities(item);
      }
    }
    return (A) this;
  }
  
  public A withHubClusterArn(String hubClusterArn) {
    this.hubClusterArn = hubClusterArn;
    return (A) this;
  }
  
  public A withTags(List<String> tags) {
    if (tags != null) {
        this.tags = new ArrayList();
        for (String item : tags) {
          this.addToTags(item);
        }
    } else {
      this.tags = null;
    }
    return (A) this;
  }
  
  public A withTags(String... tags) {
    if (this.tags != null) {
        this.tags.clear();
        _visitables.remove("tags");
    }
    if (tags != null) {
      for (String item : tags) {
        this.addToTags(item);
      }
    }
    return (A) this;
  }
  
}