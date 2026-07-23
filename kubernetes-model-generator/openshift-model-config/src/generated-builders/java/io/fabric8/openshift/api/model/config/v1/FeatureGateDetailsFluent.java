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
public class FeatureGateDetailsFluent<A extends io.fabric8.openshift.api.model.config.v1.FeatureGateDetailsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<FeatureGateAttributesBuilder> disabled = new ArrayList<FeatureGateAttributesBuilder>();
  private ArrayList<FeatureGateAttributesBuilder> enabled = new ArrayList<FeatureGateAttributesBuilder>();
  private String version;

  public FeatureGateDetailsFluent() {
  }
  
  public FeatureGateDetailsFluent(FeatureGateDetails instance) {
    this.copyInstance(instance);
  }

  public A addAllToDisabled(Collection<FeatureGateAttributes> items) {
    if (this.disabled == null) {
      this.disabled = new ArrayList();
    }
    for (FeatureGateAttributes item : items) {
        FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
        _visitables.get("disabled").add(builder);
        this.disabled.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToEnabled(Collection<FeatureGateAttributes> items) {
    if (this.enabled == null) {
      this.enabled = new ArrayList();
    }
    for (FeatureGateAttributes item : items) {
        FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
        _visitables.get("enabled").add(builder);
        this.enabled.add(builder);
    }
    return (A) this;
  }
  
  public DisabledNested<A> addNewDisabled() {
    return new DisabledNested(-1, null);
  }
  
  public A addNewDisabled(String name) {
    return (A) this.addToDisabled(new FeatureGateAttributes(name));
  }
  
  public DisabledNested<A> addNewDisabledLike(FeatureGateAttributes item) {
    return new DisabledNested(-1, item);
  }
  
  public EnabledNested<A> addNewEnabled() {
    return new EnabledNested(-1, null);
  }
  
  public A addNewEnabled(String name) {
    return (A) this.addToEnabled(new FeatureGateAttributes(name));
  }
  
  public EnabledNested<A> addNewEnabledLike(FeatureGateAttributes item) {
    return new EnabledNested(-1, item);
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
  
  public A addToDisabled(FeatureGateAttributes... items) {
    if (this.disabled == null) {
      this.disabled = new ArrayList();
    }
    for (FeatureGateAttributes item : items) {
        FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
        _visitables.get("disabled").add(builder);
        this.disabled.add(builder);
    }
    return (A) this;
  }
  
  public A addToDisabled(int index,FeatureGateAttributes item) {
    if (this.disabled == null) {
      this.disabled = new ArrayList();
    }
    FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
    if (index < 0 || index >= disabled.size()) {
        _visitables.get("disabled").add(builder);
        disabled.add(builder);
    } else {
        _visitables.get("disabled").add(builder);
        disabled.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToEnabled(FeatureGateAttributes... items) {
    if (this.enabled == null) {
      this.enabled = new ArrayList();
    }
    for (FeatureGateAttributes item : items) {
        FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
        _visitables.get("enabled").add(builder);
        this.enabled.add(builder);
    }
    return (A) this;
  }
  
  public A addToEnabled(int index,FeatureGateAttributes item) {
    if (this.enabled == null) {
      this.enabled = new ArrayList();
    }
    FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
    if (index < 0 || index >= enabled.size()) {
        _visitables.get("enabled").add(builder);
        enabled.add(builder);
    } else {
        _visitables.get("enabled").add(builder);
        enabled.add(index, builder);
    }
    return (A) this;
  }
  
  public List<FeatureGateAttributes> buildDisabled() {
    return this.disabled != null ? build(disabled) : null;
  }
  
  public FeatureGateAttributes buildDisabled(int index) {
    return this.disabled.get(index).build();
  }
  
  public List<FeatureGateAttributes> buildEnabled() {
    return this.enabled != null ? build(enabled) : null;
  }
  
  public FeatureGateAttributes buildEnabled(int index) {
    return this.enabled.get(index).build();
  }
  
  public FeatureGateAttributes buildFirstDisabled() {
    return this.disabled.get(0).build();
  }
  
  public FeatureGateAttributes buildFirstEnabled() {
    return this.enabled.get(0).build();
  }
  
  public FeatureGateAttributes buildLastDisabled() {
    return this.disabled.get(disabled.size() - 1).build();
  }
  
  public FeatureGateAttributes buildLastEnabled() {
    return this.enabled.get(enabled.size() - 1).build();
  }
  
  public FeatureGateAttributes buildMatchingDisabled(Predicate<FeatureGateAttributesBuilder> predicate) {
      for (FeatureGateAttributesBuilder item : disabled) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public FeatureGateAttributes buildMatchingEnabled(Predicate<FeatureGateAttributesBuilder> predicate) {
      for (FeatureGateAttributesBuilder item : enabled) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(FeatureGateDetails instance) {
    instance = instance != null ? instance : new FeatureGateDetails();
    if (instance != null) {
        this.withDisabled(instance.getDisabled());
        this.withEnabled(instance.getEnabled());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DisabledNested<A> editDisabled(int index) {
    if (disabled.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "disabled"));
    }
    return this.setNewDisabledLike(index, this.buildDisabled(index));
  }
  
  public EnabledNested<A> editEnabled(int index) {
    if (enabled.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "enabled"));
    }
    return this.setNewEnabledLike(index, this.buildEnabled(index));
  }
  
  public DisabledNested<A> editFirstDisabled() {
    if (disabled.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "disabled"));
    }
    return this.setNewDisabledLike(0, this.buildDisabled(0));
  }
  
  public EnabledNested<A> editFirstEnabled() {
    if (enabled.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "enabled"));
    }
    return this.setNewEnabledLike(0, this.buildEnabled(0));
  }
  
  public DisabledNested<A> editLastDisabled() {
    int index = disabled.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "disabled"));
    }
    return this.setNewDisabledLike(index, this.buildDisabled(index));
  }
  
  public EnabledNested<A> editLastEnabled() {
    int index = enabled.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "enabled"));
    }
    return this.setNewEnabledLike(index, this.buildEnabled(index));
  }
  
  public DisabledNested<A> editMatchingDisabled(Predicate<FeatureGateAttributesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < disabled.size();i++) {
      if (predicate.test(disabled.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "disabled"));
    }
    return this.setNewDisabledLike(index, this.buildDisabled(index));
  }
  
  public EnabledNested<A> editMatchingEnabled(Predicate<FeatureGateAttributesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < enabled.size();i++) {
      if (predicate.test(enabled.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "enabled"));
    }
    return this.setNewEnabledLike(index, this.buildEnabled(index));
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
    FeatureGateDetailsFluent that = (FeatureGateDetailsFluent) o;
    if (!(Objects.equals(disabled, that.disabled))) {
      return false;
    }
    if (!(Objects.equals(enabled, that.enabled))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisabled() {
    return this.disabled != null && !(this.disabled.isEmpty());
  }
  
  public boolean hasEnabled() {
    return this.enabled != null && !(this.enabled.isEmpty());
  }
  
  public boolean hasMatchingDisabled(Predicate<FeatureGateAttributesBuilder> predicate) {
      for (FeatureGateAttributesBuilder item : disabled) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEnabled(Predicate<FeatureGateAttributesBuilder> predicate) {
      for (FeatureGateAttributesBuilder item : enabled) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(disabled, enabled, version, additionalProperties);
  }
  
  public A removeAllFromDisabled(Collection<FeatureGateAttributes> items) {
    if (this.disabled == null) {
      return (A) this;
    }
    for (FeatureGateAttributes item : items) {
        FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
        _visitables.get("disabled").remove(builder);
        this.disabled.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromEnabled(Collection<FeatureGateAttributes> items) {
    if (this.enabled == null) {
      return (A) this;
    }
    for (FeatureGateAttributes item : items) {
        FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
        _visitables.get("enabled").remove(builder);
        this.enabled.remove(builder);
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
  
  public A removeFromDisabled(FeatureGateAttributes... items) {
    if (this.disabled == null) {
      return (A) this;
    }
    for (FeatureGateAttributes item : items) {
        FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
        _visitables.get("disabled").remove(builder);
        this.disabled.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromEnabled(FeatureGateAttributes... items) {
    if (this.enabled == null) {
      return (A) this;
    }
    for (FeatureGateAttributes item : items) {
        FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
        _visitables.get("enabled").remove(builder);
        this.enabled.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDisabled(Predicate<FeatureGateAttributesBuilder> predicate) {
    if (disabled == null) {
      return (A) this;
    }
    Iterator<FeatureGateAttributesBuilder> each = disabled.iterator();
    List visitables = _visitables.get("disabled");
    while (each.hasNext()) {
        FeatureGateAttributesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromEnabled(Predicate<FeatureGateAttributesBuilder> predicate) {
    if (enabled == null) {
      return (A) this;
    }
    Iterator<FeatureGateAttributesBuilder> each = enabled.iterator();
    List visitables = _visitables.get("enabled");
    while (each.hasNext()) {
        FeatureGateAttributesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DisabledNested<A> setNewDisabledLike(int index,FeatureGateAttributes item) {
    return new DisabledNested(index, item);
  }
  
  public EnabledNested<A> setNewEnabledLike(int index,FeatureGateAttributes item) {
    return new EnabledNested(index, item);
  }
  
  public A setToDisabled(int index,FeatureGateAttributes item) {
    if (this.disabled == null) {
      this.disabled = new ArrayList();
    }
    FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
    if (index < 0 || index >= disabled.size()) {
        _visitables.get("disabled").add(builder);
        disabled.add(builder);
    } else {
        _visitables.get("disabled").add(builder);
        disabled.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToEnabled(int index,FeatureGateAttributes item) {
    if (this.enabled == null) {
      this.enabled = new ArrayList();
    }
    FeatureGateAttributesBuilder builder = new FeatureGateAttributesBuilder(item);
    if (index < 0 || index >= enabled.size()) {
        _visitables.get("enabled").add(builder);
        enabled.add(builder);
    } else {
        _visitables.get("enabled").add(builder);
        enabled.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(disabled == null) && !(disabled.isEmpty())) {
        sb.append("disabled:");
        sb.append(disabled);
        sb.append(",");
    }
    if (!(enabled == null) && !(enabled.isEmpty())) {
        sb.append("enabled:");
        sb.append(enabled);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withDisabled(List<FeatureGateAttributes> disabled) {
    if (this.disabled != null) {
      this._visitables.get("disabled").clear();
    }
    if (disabled != null) {
        this.disabled = new ArrayList();
        for (FeatureGateAttributes item : disabled) {
          this.addToDisabled(item);
        }
    } else {
      this.disabled = null;
    }
    return (A) this;
  }
  
  public A withDisabled(FeatureGateAttributes... disabled) {
    if (this.disabled != null) {
        this.disabled.clear();
        _visitables.remove("disabled");
    }
    if (disabled != null) {
      for (FeatureGateAttributes item : disabled) {
        this.addToDisabled(item);
      }
    }
    return (A) this;
  }
  
  public A withEnabled(List<FeatureGateAttributes> enabled) {
    if (this.enabled != null) {
      this._visitables.get("enabled").clear();
    }
    if (enabled != null) {
        this.enabled = new ArrayList();
        for (FeatureGateAttributes item : enabled) {
          this.addToEnabled(item);
        }
    } else {
      this.enabled = null;
    }
    return (A) this;
  }
  
  public A withEnabled(FeatureGateAttributes... enabled) {
    if (this.enabled != null) {
        this.enabled.clear();
        _visitables.remove("enabled");
    }
    if (enabled != null) {
      for (FeatureGateAttributes item : enabled) {
        this.addToEnabled(item);
      }
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class DisabledNested<N> extends FeatureGateAttributesFluent<DisabledNested<N>> implements Nested<N>{
  
    FeatureGateAttributesBuilder builder;
    int index;
  
    DisabledNested(int index,FeatureGateAttributes item) {
      this.index = index;
      this.builder = new FeatureGateAttributesBuilder(this, item);
    }
  
    public N and() {
      return (N) FeatureGateDetailsFluent.this.setToDisabled(index, builder.build());
    }
    
    public N endDisabled() {
      return and();
    }
    
  }
  public class EnabledNested<N> extends FeatureGateAttributesFluent<EnabledNested<N>> implements Nested<N>{
  
    FeatureGateAttributesBuilder builder;
    int index;
  
    EnabledNested(int index,FeatureGateAttributes item) {
      this.index = index;
      this.builder = new FeatureGateAttributesBuilder(this, item);
    }
  
    public N and() {
      return (N) FeatureGateDetailsFluent.this.setToEnabled(index, builder.build());
    }
    
    public N endEnabled() {
      return and();
    }
    
  }
}