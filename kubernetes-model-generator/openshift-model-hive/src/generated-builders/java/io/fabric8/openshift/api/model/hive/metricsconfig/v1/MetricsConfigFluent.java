package io.fabric8.openshift.api.model.hive.metricsconfig.v1;

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
public class MetricsConfigFluent<A extends io.fabric8.openshift.api.model.hive.metricsconfig.v1.MetricsConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,String> additionalClusterDeploymentLabels;
  private Map<String,Object> additionalProperties;
  private ArrayList<MetricsWithDurationBuilder> metricsWithDuration = new ArrayList<MetricsWithDurationBuilder>();

  public MetricsConfigFluent() {
  }
  
  public MetricsConfigFluent(MetricsConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToMetricsWithDuration(Collection<MetricsWithDuration> items) {
    if (this.metricsWithDuration == null) {
      this.metricsWithDuration = new ArrayList();
    }
    for (MetricsWithDuration item : items) {
        MetricsWithDurationBuilder builder = new MetricsWithDurationBuilder(item);
        _visitables.get("metricsWithDuration").add(builder);
        this.metricsWithDuration.add(builder);
    }
    return (A) this;
  }
  
  public MetricsWithDurationNested<A> addNewMetricsWithDuration() {
    return new MetricsWithDurationNested(-1, null);
  }
  
  public A addNewMetricsWithDuration(String duration,String name) {
    return (A) this.addToMetricsWithDuration(new MetricsWithDuration(duration, name));
  }
  
  public MetricsWithDurationNested<A> addNewMetricsWithDurationLike(MetricsWithDuration item) {
    return new MetricsWithDurationNested(-1, item);
  }
  
  public A addToAdditionalClusterDeploymentLabels(Map<String,String> map) {
    if (this.additionalClusterDeploymentLabels == null && map != null) {
      this.additionalClusterDeploymentLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalClusterDeploymentLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalClusterDeploymentLabels(String key,String value) {
    if (this.additionalClusterDeploymentLabels == null && key != null && value != null) {
      this.additionalClusterDeploymentLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalClusterDeploymentLabels.put(key, value);
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
  
  public A addToMetricsWithDuration(MetricsWithDuration... items) {
    if (this.metricsWithDuration == null) {
      this.metricsWithDuration = new ArrayList();
    }
    for (MetricsWithDuration item : items) {
        MetricsWithDurationBuilder builder = new MetricsWithDurationBuilder(item);
        _visitables.get("metricsWithDuration").add(builder);
        this.metricsWithDuration.add(builder);
    }
    return (A) this;
  }
  
  public A addToMetricsWithDuration(int index,MetricsWithDuration item) {
    if (this.metricsWithDuration == null) {
      this.metricsWithDuration = new ArrayList();
    }
    MetricsWithDurationBuilder builder = new MetricsWithDurationBuilder(item);
    if (index < 0 || index >= metricsWithDuration.size()) {
        _visitables.get("metricsWithDuration").add(builder);
        metricsWithDuration.add(builder);
    } else {
        _visitables.get("metricsWithDuration").add(builder);
        metricsWithDuration.add(index, builder);
    }
    return (A) this;
  }
  
  public MetricsWithDuration buildFirstMetricsWithDuration() {
    return this.metricsWithDuration.get(0).build();
  }
  
  public MetricsWithDuration buildLastMetricsWithDuration() {
    return this.metricsWithDuration.get(metricsWithDuration.size() - 1).build();
  }
  
  public MetricsWithDuration buildMatchingMetricsWithDuration(Predicate<MetricsWithDurationBuilder> predicate) {
      for (MetricsWithDurationBuilder item : metricsWithDuration) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<MetricsWithDuration> buildMetricsWithDuration() {
    return this.metricsWithDuration != null ? build(metricsWithDuration) : null;
  }
  
  public MetricsWithDuration buildMetricsWithDuration(int index) {
    return this.metricsWithDuration.get(index).build();
  }
  
  protected void copyInstance(MetricsConfig instance) {
    instance = instance != null ? instance : new MetricsConfig();
    if (instance != null) {
        this.withAdditionalClusterDeploymentLabels(instance.getAdditionalClusterDeploymentLabels());
        this.withMetricsWithDuration(instance.getMetricsWithDuration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetricsWithDurationNested<A> editFirstMetricsWithDuration() {
    if (metricsWithDuration.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "metricsWithDuration"));
    }
    return this.setNewMetricsWithDurationLike(0, this.buildMetricsWithDuration(0));
  }
  
  public MetricsWithDurationNested<A> editLastMetricsWithDuration() {
    int index = metricsWithDuration.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "metricsWithDuration"));
    }
    return this.setNewMetricsWithDurationLike(index, this.buildMetricsWithDuration(index));
  }
  
  public MetricsWithDurationNested<A> editMatchingMetricsWithDuration(Predicate<MetricsWithDurationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < metricsWithDuration.size();i++) {
      if (predicate.test(metricsWithDuration.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "metricsWithDuration"));
    }
    return this.setNewMetricsWithDurationLike(index, this.buildMetricsWithDuration(index));
  }
  
  public MetricsWithDurationNested<A> editMetricsWithDuration(int index) {
    if (metricsWithDuration.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "metricsWithDuration"));
    }
    return this.setNewMetricsWithDurationLike(index, this.buildMetricsWithDuration(index));
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
    MetricsConfigFluent that = (MetricsConfigFluent) o;
    if (!(Objects.equals(additionalClusterDeploymentLabels, that.additionalClusterDeploymentLabels))) {
      return false;
    }
    if (!(Objects.equals(metricsWithDuration, that.metricsWithDuration))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,String> getAdditionalClusterDeploymentLabels() {
    return this.additionalClusterDeploymentLabels;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public boolean hasAdditionalClusterDeploymentLabels() {
    return this.additionalClusterDeploymentLabels != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingMetricsWithDuration(Predicate<MetricsWithDurationBuilder> predicate) {
      for (MetricsWithDurationBuilder item : metricsWithDuration) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetricsWithDuration() {
    return this.metricsWithDuration != null && !(this.metricsWithDuration.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(additionalClusterDeploymentLabels, metricsWithDuration, additionalProperties);
  }
  
  public A removeAllFromMetricsWithDuration(Collection<MetricsWithDuration> items) {
    if (this.metricsWithDuration == null) {
      return (A) this;
    }
    for (MetricsWithDuration item : items) {
        MetricsWithDurationBuilder builder = new MetricsWithDurationBuilder(item);
        _visitables.get("metricsWithDuration").remove(builder);
        this.metricsWithDuration.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalClusterDeploymentLabels(String key) {
    if (this.additionalClusterDeploymentLabels == null) {
      return (A) this;
    }
    if (key != null && this.additionalClusterDeploymentLabels != null) {
      this.additionalClusterDeploymentLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalClusterDeploymentLabels(Map<String,String> map) {
    if (this.additionalClusterDeploymentLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalClusterDeploymentLabels != null) {
          this.additionalClusterDeploymentLabels.remove(key);
        }
      }
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
  
  public A removeFromMetricsWithDuration(MetricsWithDuration... items) {
    if (this.metricsWithDuration == null) {
      return (A) this;
    }
    for (MetricsWithDuration item : items) {
        MetricsWithDurationBuilder builder = new MetricsWithDurationBuilder(item);
        _visitables.get("metricsWithDuration").remove(builder);
        this.metricsWithDuration.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMetricsWithDuration(Predicate<MetricsWithDurationBuilder> predicate) {
    if (metricsWithDuration == null) {
      return (A) this;
    }
    Iterator<MetricsWithDurationBuilder> each = metricsWithDuration.iterator();
    List visitables = _visitables.get("metricsWithDuration");
    while (each.hasNext()) {
        MetricsWithDurationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MetricsWithDurationNested<A> setNewMetricsWithDurationLike(int index,MetricsWithDuration item) {
    return new MetricsWithDurationNested(index, item);
  }
  
  public A setToMetricsWithDuration(int index,MetricsWithDuration item) {
    if (this.metricsWithDuration == null) {
      this.metricsWithDuration = new ArrayList();
    }
    MetricsWithDurationBuilder builder = new MetricsWithDurationBuilder(item);
    if (index < 0 || index >= metricsWithDuration.size()) {
        _visitables.get("metricsWithDuration").add(builder);
        metricsWithDuration.add(builder);
    } else {
        _visitables.get("metricsWithDuration").add(builder);
        metricsWithDuration.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalClusterDeploymentLabels == null) && !(additionalClusterDeploymentLabels.isEmpty())) {
        sb.append("additionalClusterDeploymentLabels:");
        sb.append(additionalClusterDeploymentLabels);
        sb.append(",");
    }
    if (!(metricsWithDuration == null) && !(metricsWithDuration.isEmpty())) {
        sb.append("metricsWithDuration:");
        sb.append(metricsWithDuration);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalClusterDeploymentLabels(Map<String,String> additionalClusterDeploymentLabels) {
    if (additionalClusterDeploymentLabels == null) {
      this.additionalClusterDeploymentLabels = null;
    } else {
      this.additionalClusterDeploymentLabels = new LinkedHashMap(additionalClusterDeploymentLabels);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withMetricsWithDuration(List<MetricsWithDuration> metricsWithDuration) {
    if (this.metricsWithDuration != null) {
      this._visitables.get("metricsWithDuration").clear();
    }
    if (metricsWithDuration != null) {
        this.metricsWithDuration = new ArrayList();
        for (MetricsWithDuration item : metricsWithDuration) {
          this.addToMetricsWithDuration(item);
        }
    } else {
      this.metricsWithDuration = null;
    }
    return (A) this;
  }
  
  public A withMetricsWithDuration(MetricsWithDuration... metricsWithDuration) {
    if (this.metricsWithDuration != null) {
        this.metricsWithDuration.clear();
        _visitables.remove("metricsWithDuration");
    }
    if (metricsWithDuration != null) {
      for (MetricsWithDuration item : metricsWithDuration) {
        this.addToMetricsWithDuration(item);
      }
    }
    return (A) this;
  }
  public class MetricsWithDurationNested<N> extends MetricsWithDurationFluent<MetricsWithDurationNested<N>> implements Nested<N>{
  
    MetricsWithDurationBuilder builder;
    int index;
  
    MetricsWithDurationNested(int index,MetricsWithDuration item) {
      this.index = index;
      this.builder = new MetricsWithDurationBuilder(this, item);
    }
  
    public N and() {
      return (N) MetricsConfigFluent.this.setToMetricsWithDuration(index, builder.build());
    }
    
    public N endMetricsWithDuration() {
      return and();
    }
    
  }
}