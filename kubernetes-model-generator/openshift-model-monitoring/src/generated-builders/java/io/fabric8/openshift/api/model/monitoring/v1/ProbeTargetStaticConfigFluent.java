package io.fabric8.openshift.api.model.monitoring.v1;

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
public class ProbeTargetStaticConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ProbeTargetStaticConfigFluent<A>> extends BaseFluent<A>{

  private List<String> _static = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private Map<String,String> labels;
  private ArrayList<RelabelConfigBuilder> relabelingConfigs = new ArrayList<RelabelConfigBuilder>();

  public ProbeTargetStaticConfigFluent() {
  }
  
  public ProbeTargetStaticConfigFluent(ProbeTargetStaticConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToRelabelingConfigs(Collection<RelabelConfig> items) {
    if (this.relabelingConfigs == null) {
      this.relabelingConfigs = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelingConfigs").add(builder);
        this.relabelingConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStatic(Collection<String> items) {
    if (this._static == null) {
      this._static = new ArrayList();
    }
    for (String item : items) {
      this._static.add(item);
    }
    return (A) this;
  }
  
  public RelabelingConfigsNested<A> addNewRelabelingConfig() {
    return new RelabelingConfigsNested(-1, null);
  }
  
  public RelabelingConfigsNested<A> addNewRelabelingConfigLike(RelabelConfig item) {
    return new RelabelingConfigsNested(-1, item);
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
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToRelabelingConfigs(RelabelConfig... items) {
    if (this.relabelingConfigs == null) {
      this.relabelingConfigs = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelingConfigs").add(builder);
        this.relabelingConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToRelabelingConfigs(int index,RelabelConfig item) {
    if (this.relabelingConfigs == null) {
      this.relabelingConfigs = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= relabelingConfigs.size()) {
        _visitables.get("relabelingConfigs").add(builder);
        relabelingConfigs.add(builder);
    } else {
        _visitables.get("relabelingConfigs").add(builder);
        relabelingConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStatic(String... items) {
    if (this._static == null) {
      this._static = new ArrayList();
    }
    for (String item : items) {
      this._static.add(item);
    }
    return (A) this;
  }
  
  public A addToStatic(int index,String item) {
    if (this._static == null) {
      this._static = new ArrayList();
    }
    this._static.add(index, item);
    return (A) this;
  }
  
  public RelabelConfig buildFirstRelabelingConfig() {
    return this.relabelingConfigs.get(0).build();
  }
  
  public RelabelConfig buildLastRelabelingConfig() {
    return this.relabelingConfigs.get(relabelingConfigs.size() - 1).build();
  }
  
  public RelabelConfig buildMatchingRelabelingConfig(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : relabelingConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RelabelConfig buildRelabelingConfig(int index) {
    return this.relabelingConfigs.get(index).build();
  }
  
  public List<RelabelConfig> buildRelabelingConfigs() {
    return this.relabelingConfigs != null ? build(relabelingConfigs) : null;
  }
  
  protected void copyInstance(ProbeTargetStaticConfig instance) {
    instance = instance != null ? instance : new ProbeTargetStaticConfig();
    if (instance != null) {
        this.withLabels(instance.getLabels());
        this.withRelabelingConfigs(instance.getRelabelingConfigs());
        this.withStatic(instance.getStatic());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RelabelingConfigsNested<A> editFirstRelabelingConfig() {
    if (relabelingConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "relabelingConfigs"));
    }
    return this.setNewRelabelingConfigLike(0, this.buildRelabelingConfig(0));
  }
  
  public RelabelingConfigsNested<A> editLastRelabelingConfig() {
    int index = relabelingConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "relabelingConfigs"));
    }
    return this.setNewRelabelingConfigLike(index, this.buildRelabelingConfig(index));
  }
  
  public RelabelingConfigsNested<A> editMatchingRelabelingConfig(Predicate<RelabelConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < relabelingConfigs.size();i++) {
      if (predicate.test(relabelingConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "relabelingConfigs"));
    }
    return this.setNewRelabelingConfigLike(index, this.buildRelabelingConfig(index));
  }
  
  public RelabelingConfigsNested<A> editRelabelingConfig(int index) {
    if (relabelingConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "relabelingConfigs"));
    }
    return this.setNewRelabelingConfigLike(index, this.buildRelabelingConfig(index));
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
    ProbeTargetStaticConfigFluent that = (ProbeTargetStaticConfigFluent) o;
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(relabelingConfigs, that.relabelingConfigs))) {
      return false;
    }
    if (!(Objects.equals(_static, that._static))) {
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
  
  public String getFirstStatic() {
    return this._static.get(0);
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public String getLastStatic() {
    return this._static.get(_static.size() - 1);
  }
  
  public String getMatchingStatic(Predicate<String> predicate) {
      for (String item : _static) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getStatic() {
    return this._static;
  }
  
  public String getStatic(int index) {
    return this._static.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasMatchingRelabelingConfig(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : relabelingConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStatic(Predicate<String> predicate) {
      for (String item : _static) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRelabelingConfigs() {
    return this.relabelingConfigs != null && !(this.relabelingConfigs.isEmpty());
  }
  
  public boolean hasStatic() {
    return this._static != null && !(this._static.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(labels, relabelingConfigs, _static, additionalProperties);
  }
  
  public A removeAllFromRelabelingConfigs(Collection<RelabelConfig> items) {
    if (this.relabelingConfigs == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelingConfigs").remove(builder);
        this.relabelingConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStatic(Collection<String> items) {
    if (this._static == null) {
      return (A) this;
    }
    for (String item : items) {
      this._static.remove(item);
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
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromRelabelingConfigs(RelabelConfig... items) {
    if (this.relabelingConfigs == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelingConfigs").remove(builder);
        this.relabelingConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStatic(String... items) {
    if (this._static == null) {
      return (A) this;
    }
    for (String item : items) {
      this._static.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRelabelingConfigs(Predicate<RelabelConfigBuilder> predicate) {
    if (relabelingConfigs == null) {
      return (A) this;
    }
    Iterator<RelabelConfigBuilder> each = relabelingConfigs.iterator();
    List visitables = _visitables.get("relabelingConfigs");
    while (each.hasNext()) {
        RelabelConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RelabelingConfigsNested<A> setNewRelabelingConfigLike(int index,RelabelConfig item) {
    return new RelabelingConfigsNested(index, item);
  }
  
  public A setToRelabelingConfigs(int index,RelabelConfig item) {
    if (this.relabelingConfigs == null) {
      this.relabelingConfigs = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= relabelingConfigs.size()) {
        _visitables.get("relabelingConfigs").add(builder);
        relabelingConfigs.add(builder);
    } else {
        _visitables.get("relabelingConfigs").add(builder);
        relabelingConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStatic(int index,String item) {
    if (this._static == null) {
      this._static = new ArrayList();
    }
    this._static.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(relabelingConfigs == null) && !(relabelingConfigs.isEmpty())) {
        sb.append("relabelingConfigs:");
        sb.append(relabelingConfigs);
        sb.append(",");
    }
    if (!(_static == null) && !(_static.isEmpty())) {
        sb.append("_static:");
        sb.append(_static);
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
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public A withRelabelingConfigs(List<RelabelConfig> relabelingConfigs) {
    if (this.relabelingConfigs != null) {
      this._visitables.get("relabelingConfigs").clear();
    }
    if (relabelingConfigs != null) {
        this.relabelingConfigs = new ArrayList();
        for (RelabelConfig item : relabelingConfigs) {
          this.addToRelabelingConfigs(item);
        }
    } else {
      this.relabelingConfigs = null;
    }
    return (A) this;
  }
  
  public A withRelabelingConfigs(RelabelConfig... relabelingConfigs) {
    if (this.relabelingConfigs != null) {
        this.relabelingConfigs.clear();
        _visitables.remove("relabelingConfigs");
    }
    if (relabelingConfigs != null) {
      for (RelabelConfig item : relabelingConfigs) {
        this.addToRelabelingConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withStatic(List<String> _static) {
    if (_static != null) {
        this._static = new ArrayList();
        for (String item : _static) {
          this.addToStatic(item);
        }
    } else {
      this._static = null;
    }
    return (A) this;
  }
  
  public A withStatic(String... _static) {
    if (this._static != null) {
        this._static.clear();
        _visitables.remove("_static");
    }
    if (_static != null) {
      for (String item : _static) {
        this.addToStatic(item);
      }
    }
    return (A) this;
  }
  public class RelabelingConfigsNested<N> extends RelabelConfigFluent<RelabelingConfigsNested<N>> implements Nested<N>{
  
    RelabelConfigBuilder builder;
    int index;
  
    RelabelingConfigsNested(int index,RelabelConfig item) {
      this.index = index;
      this.builder = new RelabelConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeTargetStaticConfigFluent.this.setToRelabelingConfigs(index, builder.build());
    }
    
    public N endRelabelingConfig() {
      return and();
    }
    
  }
}