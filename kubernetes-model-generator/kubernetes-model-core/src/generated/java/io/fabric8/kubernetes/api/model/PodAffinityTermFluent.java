package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PodAffinityTermFluent<A extends io.fabric8.kubernetes.api.model.PodAffinityTermFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder labelSelector;
  private List<String> matchLabelKeys = new ArrayList<String>();
  private List<String> mismatchLabelKeys = new ArrayList<String>();
  private LabelSelectorBuilder namespaceSelector;
  private List<String> namespaces = new ArrayList<String>();
  private String topologyKey;

  public PodAffinityTermFluent() {
  }
  
  public PodAffinityTermFluent(PodAffinityTerm instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatchLabelKeys(Collection<String> items) {
    if (this.matchLabelKeys == null) {
      this.matchLabelKeys = new ArrayList();
    }
    for (String item : items) {
      this.matchLabelKeys.add(item);
    }
    return (A) this;
  }
  
  public A addAllToMismatchLabelKeys(Collection<String> items) {
    if (this.mismatchLabelKeys == null) {
      this.mismatchLabelKeys = new ArrayList();
    }
    for (String item : items) {
      this.mismatchLabelKeys.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNamespaces(Collection<String> items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (String item : items) {
      this.namespaces.add(item);
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
  
  public A addToMatchLabelKeys(String... items) {
    if (this.matchLabelKeys == null) {
      this.matchLabelKeys = new ArrayList();
    }
    for (String item : items) {
      this.matchLabelKeys.add(item);
    }
    return (A) this;
  }
  
  public A addToMatchLabelKeys(int index,String item) {
    if (this.matchLabelKeys == null) {
      this.matchLabelKeys = new ArrayList();
    }
    this.matchLabelKeys.add(index, item);
    return (A) this;
  }
  
  public A addToMismatchLabelKeys(String... items) {
    if (this.mismatchLabelKeys == null) {
      this.mismatchLabelKeys = new ArrayList();
    }
    for (String item : items) {
      this.mismatchLabelKeys.add(item);
    }
    return (A) this;
  }
  
  public A addToMismatchLabelKeys(int index,String item) {
    if (this.mismatchLabelKeys == null) {
      this.mismatchLabelKeys = new ArrayList();
    }
    this.mismatchLabelKeys.add(index, item);
    return (A) this;
  }
  
  public A addToNamespaces(String... items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (String item : items) {
      this.namespaces.add(item);
    }
    return (A) this;
  }
  
  public A addToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.add(index, item);
    return (A) this;
  }
  
  public LabelSelector buildLabelSelector() {
    return this.labelSelector != null ? this.labelSelector.build() : null;
  }
  
  public LabelSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  protected void copyInstance(PodAffinityTerm instance) {
    instance = instance != null ? instance : new PodAffinityTerm();
    if (instance != null) {
        this.withLabelSelector(instance.getLabelSelector());
        this.withMatchLabelKeys(instance.getMatchLabelKeys());
        this.withMismatchLabelKeys(instance.getMismatchLabelKeys());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withNamespaces(instance.getNamespaces());
        this.withTopologyKey(instance.getTopologyKey());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LabelSelectorNested<A> editLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(null));
  }
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelectorLike(LabelSelector item) {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(item));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(LabelSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
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
    PodAffinityTermFluent that = (PodAffinityTermFluent) o;
    if (!(Objects.equals(labelSelector, that.labelSelector))) {
      return false;
    }
    if (!(Objects.equals(matchLabelKeys, that.matchLabelKeys))) {
      return false;
    }
    if (!(Objects.equals(mismatchLabelKeys, that.mismatchLabelKeys))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(namespaces, that.namespaces))) {
      return false;
    }
    if (!(Objects.equals(topologyKey, that.topologyKey))) {
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
  
  public String getFirstMatchLabelKey() {
    return this.matchLabelKeys.get(0);
  }
  
  public String getFirstMismatchLabelKey() {
    return this.mismatchLabelKeys.get(0);
  }
  
  public String getFirstNamespace() {
    return this.namespaces.get(0);
  }
  
  public String getLastMatchLabelKey() {
    return this.matchLabelKeys.get(matchLabelKeys.size() - 1);
  }
  
  public String getLastMismatchLabelKey() {
    return this.mismatchLabelKeys.get(mismatchLabelKeys.size() - 1);
  }
  
  public String getLastNamespace() {
    return this.namespaces.get(namespaces.size() - 1);
  }
  
  public String getMatchLabelKey(int index) {
    return this.matchLabelKeys.get(index);
  }
  
  public List<String> getMatchLabelKeys() {
    return this.matchLabelKeys;
  }
  
  public String getMatchingMatchLabelKey(Predicate<String> predicate) {
      for (String item : matchLabelKeys) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingMismatchLabelKey(Predicate<String> predicate) {
      for (String item : mismatchLabelKeys) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMismatchLabelKey(int index) {
    return this.mismatchLabelKeys.get(index);
  }
  
  public List<String> getMismatchLabelKeys() {
    return this.mismatchLabelKeys;
  }
  
  public String getNamespace(int index) {
    return this.namespaces.get(index);
  }
  
  public List<String> getNamespaces() {
    return this.namespaces;
  }
  
  public String getTopologyKey() {
    return this.topologyKey;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLabelSelector() {
    return this.labelSelector != null;
  }
  
  public boolean hasMatchLabelKeys() {
    return this.matchLabelKeys != null && !(this.matchLabelKeys.isEmpty());
  }
  
  public boolean hasMatchingMatchLabelKey(Predicate<String> predicate) {
      for (String item : matchLabelKeys) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMismatchLabelKey(Predicate<String> predicate) {
      for (String item : mismatchLabelKeys) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMismatchLabelKeys() {
    return this.mismatchLabelKeys != null && !(this.mismatchLabelKeys.isEmpty());
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasNamespaces() {
    return this.namespaces != null && !(this.namespaces.isEmpty());
  }
  
  public boolean hasTopologyKey() {
    return this.topologyKey != null;
  }
  
  public int hashCode() {
    return Objects.hash(labelSelector, matchLabelKeys, mismatchLabelKeys, namespaceSelector, namespaces, topologyKey, additionalProperties);
  }
  
  public A removeAllFromMatchLabelKeys(Collection<String> items) {
    if (this.matchLabelKeys == null) {
      return (A) this;
    }
    for (String item : items) {
      this.matchLabelKeys.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromMismatchLabelKeys(Collection<String> items) {
    if (this.mismatchLabelKeys == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mismatchLabelKeys.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNamespaces(Collection<String> items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.namespaces.remove(item);
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
  
  public A removeFromMatchLabelKeys(String... items) {
    if (this.matchLabelKeys == null) {
      return (A) this;
    }
    for (String item : items) {
      this.matchLabelKeys.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMismatchLabelKeys(String... items) {
    if (this.mismatchLabelKeys == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mismatchLabelKeys.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNamespaces(String... items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.namespaces.remove(item);
    }
    return (A) this;
  }
  
  public A setToMatchLabelKeys(int index,String item) {
    if (this.matchLabelKeys == null) {
      this.matchLabelKeys = new ArrayList();
    }
    this.matchLabelKeys.set(index, item);
    return (A) this;
  }
  
  public A setToMismatchLabelKeys(int index,String item) {
    if (this.mismatchLabelKeys == null) {
      this.mismatchLabelKeys = new ArrayList();
    }
    this.mismatchLabelKeys.set(index, item);
    return (A) this;
  }
  
  public A setToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(labelSelector == null)) {
        sb.append("labelSelector:");
        sb.append(labelSelector);
        sb.append(",");
    }
    if (!(matchLabelKeys == null) && !(matchLabelKeys.isEmpty())) {
        sb.append("matchLabelKeys:");
        sb.append(matchLabelKeys);
        sb.append(",");
    }
    if (!(mismatchLabelKeys == null) && !(mismatchLabelKeys.isEmpty())) {
        sb.append("mismatchLabelKeys:");
        sb.append(mismatchLabelKeys);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(namespaces == null) && !(namespaces.isEmpty())) {
        sb.append("namespaces:");
        sb.append(namespaces);
        sb.append(",");
    }
    if (!(topologyKey == null)) {
        sb.append("topologyKey:");
        sb.append(topologyKey);
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
  
  public A withLabelSelector(LabelSelector labelSelector) {
    this._visitables.remove("labelSelector");
    if (labelSelector != null) {
        this.labelSelector = new LabelSelectorBuilder(labelSelector);
        this._visitables.get("labelSelector").add(this.labelSelector);
    } else {
        this.labelSelector = null;
        this._visitables.get("labelSelector").remove(this.labelSelector);
    }
    return (A) this;
  }
  
  public A withMatchLabelKeys(List<String> matchLabelKeys) {
    if (matchLabelKeys != null) {
        this.matchLabelKeys = new ArrayList();
        for (String item : matchLabelKeys) {
          this.addToMatchLabelKeys(item);
        }
    } else {
      this.matchLabelKeys = null;
    }
    return (A) this;
  }
  
  public A withMatchLabelKeys(String... matchLabelKeys) {
    if (this.matchLabelKeys != null) {
        this.matchLabelKeys.clear();
        _visitables.remove("matchLabelKeys");
    }
    if (matchLabelKeys != null) {
      for (String item : matchLabelKeys) {
        this.addToMatchLabelKeys(item);
      }
    }
    return (A) this;
  }
  
  public A withMismatchLabelKeys(List<String> mismatchLabelKeys) {
    if (mismatchLabelKeys != null) {
        this.mismatchLabelKeys = new ArrayList();
        for (String item : mismatchLabelKeys) {
          this.addToMismatchLabelKeys(item);
        }
    } else {
      this.mismatchLabelKeys = null;
    }
    return (A) this;
  }
  
  public A withMismatchLabelKeys(String... mismatchLabelKeys) {
    if (this.mismatchLabelKeys != null) {
        this.mismatchLabelKeys.clear();
        _visitables.remove("mismatchLabelKeys");
    }
    if (mismatchLabelKeys != null) {
      for (String item : mismatchLabelKeys) {
        this.addToMismatchLabelKeys(item);
      }
    }
    return (A) this;
  }
  
  public A withNamespaceSelector(LabelSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new LabelSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public A withNamespaces(List<String> namespaces) {
    if (namespaces != null) {
        this.namespaces = new ArrayList();
        for (String item : namespaces) {
          this.addToNamespaces(item);
        }
    } else {
      this.namespaces = null;
    }
    return (A) this;
  }
  
  public A withNamespaces(String... namespaces) {
    if (this.namespaces != null) {
        this.namespaces.clear();
        _visitables.remove("namespaces");
    }
    if (namespaces != null) {
      for (String item : namespaces) {
        this.addToNamespaces(item);
      }
    }
    return (A) this;
  }
  
  public LabelSelectorNested<A> withNewLabelSelector() {
    return new LabelSelectorNested(null);
  }
  
  public LabelSelectorNested<A> withNewLabelSelectorLike(LabelSelector item) {
    return new LabelSelectorNested(item);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(LabelSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public A withTopologyKey(String topologyKey) {
    this.topologyKey = topologyKey;
    return (A) this;
  }
  public class LabelSelectorNested<N> extends LabelSelectorFluent<LabelSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    LabelSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PodAffinityTermFluent.this.withLabelSelector(builder.build());
    }
    
    public N endLabelSelector() {
      return and();
    }
    
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PodAffinityTermFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
}