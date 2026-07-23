package io.fabric8.openclustermanagement.api.model.apps.v1;

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
public class ClusterOverridesFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.ClusterOverridesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clusterName;
  private ArrayList<ClusterOverrideBuilder> clusterOverrides = new ArrayList<ClusterOverrideBuilder>();

  public ClusterOverridesFluent() {
  }
  
  public ClusterOverridesFluent(ClusterOverrides instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterOverrides(Collection<ClusterOverride> items) {
    if (this.clusterOverrides == null) {
      this.clusterOverrides = new ArrayList();
    }
    for (ClusterOverride item : items) {
        ClusterOverrideBuilder builder = new ClusterOverrideBuilder(item);
        _visitables.get("clusterOverrides").add(builder);
        this.clusterOverrides.add(builder);
    }
    return (A) this;
  }
  
  public ClusterOverridesNested<A> addNewClusterOverride() {
    return new ClusterOverridesNested(-1, null);
  }
  
  public ClusterOverridesNested<A> addNewClusterOverrideLike(ClusterOverride item) {
    return new ClusterOverridesNested(-1, item);
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
  
  public A addToClusterOverrides(ClusterOverride... items) {
    if (this.clusterOverrides == null) {
      this.clusterOverrides = new ArrayList();
    }
    for (ClusterOverride item : items) {
        ClusterOverrideBuilder builder = new ClusterOverrideBuilder(item);
        _visitables.get("clusterOverrides").add(builder);
        this.clusterOverrides.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterOverrides(int index,ClusterOverride item) {
    if (this.clusterOverrides == null) {
      this.clusterOverrides = new ArrayList();
    }
    ClusterOverrideBuilder builder = new ClusterOverrideBuilder(item);
    if (index < 0 || index >= clusterOverrides.size()) {
        _visitables.get("clusterOverrides").add(builder);
        clusterOverrides.add(builder);
    } else {
        _visitables.get("clusterOverrides").add(builder);
        clusterOverrides.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterOverride buildClusterOverride(int index) {
    return this.clusterOverrides.get(index).build();
  }
  
  public List<ClusterOverride> buildClusterOverrides() {
    return this.clusterOverrides != null ? build(clusterOverrides) : null;
  }
  
  public ClusterOverride buildFirstClusterOverride() {
    return this.clusterOverrides.get(0).build();
  }
  
  public ClusterOverride buildLastClusterOverride() {
    return this.clusterOverrides.get(clusterOverrides.size() - 1).build();
  }
  
  public ClusterOverride buildMatchingClusterOverride(Predicate<ClusterOverrideBuilder> predicate) {
      for (ClusterOverrideBuilder item : clusterOverrides) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ClusterOverrides instance) {
    instance = instance != null ? instance : new ClusterOverrides();
    if (instance != null) {
        this.withClusterName(instance.getClusterName());
        this.withClusterOverrides(instance.getClusterOverrides());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterOverridesNested<A> editClusterOverride(int index) {
    if (clusterOverrides.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterOverrides"));
    }
    return this.setNewClusterOverrideLike(index, this.buildClusterOverride(index));
  }
  
  public ClusterOverridesNested<A> editFirstClusterOverride() {
    if (clusterOverrides.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterOverrides"));
    }
    return this.setNewClusterOverrideLike(0, this.buildClusterOverride(0));
  }
  
  public ClusterOverridesNested<A> editLastClusterOverride() {
    int index = clusterOverrides.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterOverrides"));
    }
    return this.setNewClusterOverrideLike(index, this.buildClusterOverride(index));
  }
  
  public ClusterOverridesNested<A> editMatchingClusterOverride(Predicate<ClusterOverrideBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterOverrides.size();i++) {
      if (predicate.test(clusterOverrides.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterOverrides"));
    }
    return this.setNewClusterOverrideLike(index, this.buildClusterOverride(index));
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
    ClusterOverridesFluent that = (ClusterOverridesFluent) o;
    if (!(Objects.equals(clusterName, that.clusterName))) {
      return false;
    }
    if (!(Objects.equals(clusterOverrides, that.clusterOverrides))) {
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
  
  public String getClusterName() {
    return this.clusterName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterName() {
    return this.clusterName != null;
  }
  
  public boolean hasClusterOverrides() {
    return this.clusterOverrides != null && !(this.clusterOverrides.isEmpty());
  }
  
  public boolean hasMatchingClusterOverride(Predicate<ClusterOverrideBuilder> predicate) {
      for (ClusterOverrideBuilder item : clusterOverrides) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(clusterName, clusterOverrides, additionalProperties);
  }
  
  public A removeAllFromClusterOverrides(Collection<ClusterOverride> items) {
    if (this.clusterOverrides == null) {
      return (A) this;
    }
    for (ClusterOverride item : items) {
        ClusterOverrideBuilder builder = new ClusterOverrideBuilder(item);
        _visitables.get("clusterOverrides").remove(builder);
        this.clusterOverrides.remove(builder);
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
  
  public A removeFromClusterOverrides(ClusterOverride... items) {
    if (this.clusterOverrides == null) {
      return (A) this;
    }
    for (ClusterOverride item : items) {
        ClusterOverrideBuilder builder = new ClusterOverrideBuilder(item);
        _visitables.get("clusterOverrides").remove(builder);
        this.clusterOverrides.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterOverrides(Predicate<ClusterOverrideBuilder> predicate) {
    if (clusterOverrides == null) {
      return (A) this;
    }
    Iterator<ClusterOverrideBuilder> each = clusterOverrides.iterator();
    List visitables = _visitables.get("clusterOverrides");
    while (each.hasNext()) {
        ClusterOverrideBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClusterOverridesNested<A> setNewClusterOverrideLike(int index,ClusterOverride item) {
    return new ClusterOverridesNested(index, item);
  }
  
  public A setToClusterOverrides(int index,ClusterOverride item) {
    if (this.clusterOverrides == null) {
      this.clusterOverrides = new ArrayList();
    }
    ClusterOverrideBuilder builder = new ClusterOverrideBuilder(item);
    if (index < 0 || index >= clusterOverrides.size()) {
        _visitables.get("clusterOverrides").add(builder);
        clusterOverrides.add(builder);
    } else {
        _visitables.get("clusterOverrides").add(builder);
        clusterOverrides.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterName == null)) {
        sb.append("clusterName:");
        sb.append(clusterName);
        sb.append(",");
    }
    if (!(clusterOverrides == null) && !(clusterOverrides.isEmpty())) {
        sb.append("clusterOverrides:");
        sb.append(clusterOverrides);
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
  
  public A withClusterName(String clusterName) {
    this.clusterName = clusterName;
    return (A) this;
  }
  
  public A withClusterOverrides(List<ClusterOverride> clusterOverrides) {
    if (this.clusterOverrides != null) {
      this._visitables.get("clusterOverrides").clear();
    }
    if (clusterOverrides != null) {
        this.clusterOverrides = new ArrayList();
        for (ClusterOverride item : clusterOverrides) {
          this.addToClusterOverrides(item);
        }
    } else {
      this.clusterOverrides = null;
    }
    return (A) this;
  }
  
  public A withClusterOverrides(ClusterOverride... clusterOverrides) {
    if (this.clusterOverrides != null) {
        this.clusterOverrides.clear();
        _visitables.remove("clusterOverrides");
    }
    if (clusterOverrides != null) {
      for (ClusterOverride item : clusterOverrides) {
        this.addToClusterOverrides(item);
      }
    }
    return (A) this;
  }
  public class ClusterOverridesNested<N> extends ClusterOverrideFluent<ClusterOverridesNested<N>> implements Nested<N>{
  
    ClusterOverrideBuilder builder;
    int index;
  
    ClusterOverridesNested(int index,ClusterOverride item) {
      this.index = index;
      this.builder = new ClusterOverrideBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterOverridesFluent.this.setToClusterOverrides(index, builder.build());
    }
    
    public N endClusterOverride() {
      return and();
    }
    
  }
}