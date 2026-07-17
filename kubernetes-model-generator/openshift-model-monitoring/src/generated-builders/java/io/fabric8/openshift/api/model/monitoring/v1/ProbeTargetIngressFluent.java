package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ProbeTargetIngressFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ProbeTargetIngressFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NamespaceSelectorBuilder namespaceSelector;
  private ArrayList<RelabelConfigBuilder> relabelingConfigs = new ArrayList<RelabelConfigBuilder>();
  private LabelSelectorBuilder selector;

  public ProbeTargetIngressFluent() {
  }
  
  public ProbeTargetIngressFluent(ProbeTargetIngress instance) {
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
  
  public NamespaceSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public RelabelConfig buildRelabelingConfig(int index) {
    return this.relabelingConfigs.get(index).build();
  }
  
  public List<RelabelConfig> buildRelabelingConfigs() {
    return this.relabelingConfigs != null ? build(relabelingConfigs) : null;
  }
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(ProbeTargetIngress instance) {
    instance = instance != null ? instance : new ProbeTargetIngress();
    if (instance != null) {
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withRelabelingConfigs(instance.getRelabelingConfigs());
        this.withSelector(instance.getSelector());
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
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new NamespaceSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(NamespaceSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public RelabelingConfigsNested<A> editRelabelingConfig(int index) {
    if (relabelingConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "relabelingConfigs"));
    }
    return this.setNewRelabelingConfigLike(index, this.buildRelabelingConfig(index));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    ProbeTargetIngressFluent that = (ProbeTargetIngressFluent) o;
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(relabelingConfigs, that.relabelingConfigs))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
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
  
  public boolean hasMatchingRelabelingConfig(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : relabelingConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasRelabelingConfigs() {
    return this.relabelingConfigs != null && !(this.relabelingConfigs.isEmpty());
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public int hashCode() {
    return Objects.hash(namespaceSelector, relabelingConfigs, selector, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(relabelingConfigs == null) && !(relabelingConfigs.isEmpty())) {
        sb.append("relabelingConfigs:");
        sb.append(relabelingConfigs);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
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
  
  public A withNamespaceSelector(NamespaceSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new NamespaceSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(NamespaceSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
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
  
  public A withSelector(LabelSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new LabelSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  public class NamespaceSelectorNested<N> extends NamespaceSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    NamespaceSelectorBuilder builder;
  
    NamespaceSelectorNested(NamespaceSelector item) {
      this.builder = new NamespaceSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeTargetIngressFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class RelabelingConfigsNested<N> extends RelabelConfigFluent<RelabelingConfigsNested<N>> implements Nested<N>{
  
    RelabelConfigBuilder builder;
    int index;
  
    RelabelingConfigsNested(int index,RelabelConfig item) {
      this.index = index;
      this.builder = new RelabelConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeTargetIngressFluent.this.setToRelabelingConfigs(index, builder.build());
    }
    
    public N endRelabelingConfig() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeTargetIngressFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}