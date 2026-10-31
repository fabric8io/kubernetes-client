package io.fabric8.volcano.api.model.scheduling.v1beta1;

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
public class PodGroupAntiAffinityFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.PodGroupAntiAffinityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PodGroupAffinityTermBuilder> preferred = new ArrayList<PodGroupAffinityTermBuilder>();
  private ArrayList<PodGroupAffinityTermBuilder> required = new ArrayList<PodGroupAffinityTermBuilder>();

  public PodGroupAntiAffinityFluent() {
  }
  
  public PodGroupAntiAffinityFluent(PodGroupAntiAffinity instance) {
    this.copyInstance(instance);
  }

  public A addAllToPreferred(Collection<PodGroupAffinityTerm> items) {
    if (this.preferred == null) {
      this.preferred = new ArrayList();
    }
    for (PodGroupAffinityTerm item : items) {
        PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
        _visitables.get("preferred").add(builder);
        this.preferred.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRequired(Collection<PodGroupAffinityTerm> items) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    for (PodGroupAffinityTerm item : items) {
        PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
        _visitables.get("required").add(builder);
        this.required.add(builder);
    }
    return (A) this;
  }
  
  public PreferredNested<A> addNewPreferred() {
    return new PreferredNested(-1, null);
  }
  
  public PreferredNested<A> addNewPreferredLike(PodGroupAffinityTerm item) {
    return new PreferredNested(-1, item);
  }
  
  public RequiredNested<A> addNewRequired() {
    return new RequiredNested(-1, null);
  }
  
  public RequiredNested<A> addNewRequiredLike(PodGroupAffinityTerm item) {
    return new RequiredNested(-1, item);
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
  
  public A addToPreferred(PodGroupAffinityTerm... items) {
    if (this.preferred == null) {
      this.preferred = new ArrayList();
    }
    for (PodGroupAffinityTerm item : items) {
        PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
        _visitables.get("preferred").add(builder);
        this.preferred.add(builder);
    }
    return (A) this;
  }
  
  public A addToPreferred(int index,PodGroupAffinityTerm item) {
    if (this.preferred == null) {
      this.preferred = new ArrayList();
    }
    PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
    if (index < 0 || index >= preferred.size()) {
        _visitables.get("preferred").add(builder);
        preferred.add(builder);
    } else {
        _visitables.get("preferred").add(builder);
        preferred.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRequired(PodGroupAffinityTerm... items) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    for (PodGroupAffinityTerm item : items) {
        PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
        _visitables.get("required").add(builder);
        this.required.add(builder);
    }
    return (A) this;
  }
  
  public A addToRequired(int index,PodGroupAffinityTerm item) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
    if (index < 0 || index >= required.size()) {
        _visitables.get("required").add(builder);
        required.add(builder);
    } else {
        _visitables.get("required").add(builder);
        required.add(index, builder);
    }
    return (A) this;
  }
  
  public PodGroupAffinityTerm buildFirstPreferred() {
    return this.preferred.get(0).build();
  }
  
  public PodGroupAffinityTerm buildFirstRequired() {
    return this.required.get(0).build();
  }
  
  public PodGroupAffinityTerm buildLastPreferred() {
    return this.preferred.get(preferred.size() - 1).build();
  }
  
  public PodGroupAffinityTerm buildLastRequired() {
    return this.required.get(required.size() - 1).build();
  }
  
  public PodGroupAffinityTerm buildMatchingPreferred(Predicate<PodGroupAffinityTermBuilder> predicate) {
      for (PodGroupAffinityTermBuilder item : preferred) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodGroupAffinityTerm buildMatchingRequired(Predicate<PodGroupAffinityTermBuilder> predicate) {
      for (PodGroupAffinityTermBuilder item : required) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<PodGroupAffinityTerm> buildPreferred() {
    return this.preferred != null ? build(preferred) : null;
  }
  
  public PodGroupAffinityTerm buildPreferred(int index) {
    return this.preferred.get(index).build();
  }
  
  public List<PodGroupAffinityTerm> buildRequired() {
    return this.required != null ? build(required) : null;
  }
  
  public PodGroupAffinityTerm buildRequired(int index) {
    return this.required.get(index).build();
  }
  
  protected void copyInstance(PodGroupAntiAffinity instance) {
    instance = instance != null ? instance : new PodGroupAntiAffinity();
    if (instance != null) {
        this.withPreferred(instance.getPreferred());
        this.withRequired(instance.getRequired());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PreferredNested<A> editFirstPreferred() {
    if (preferred.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "preferred"));
    }
    return this.setNewPreferredLike(0, this.buildPreferred(0));
  }
  
  public RequiredNested<A> editFirstRequired() {
    if (required.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "required"));
    }
    return this.setNewRequiredLike(0, this.buildRequired(0));
  }
  
  public PreferredNested<A> editLastPreferred() {
    int index = preferred.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "preferred"));
    }
    return this.setNewPreferredLike(index, this.buildPreferred(index));
  }
  
  public RequiredNested<A> editLastRequired() {
    int index = required.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "required"));
    }
    return this.setNewRequiredLike(index, this.buildRequired(index));
  }
  
  public PreferredNested<A> editMatchingPreferred(Predicate<PodGroupAffinityTermBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < preferred.size();i++) {
      if (predicate.test(preferred.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "preferred"));
    }
    return this.setNewPreferredLike(index, this.buildPreferred(index));
  }
  
  public RequiredNested<A> editMatchingRequired(Predicate<PodGroupAffinityTermBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < required.size();i++) {
      if (predicate.test(required.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "required"));
    }
    return this.setNewRequiredLike(index, this.buildRequired(index));
  }
  
  public PreferredNested<A> editPreferred(int index) {
    if (preferred.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "preferred"));
    }
    return this.setNewPreferredLike(index, this.buildPreferred(index));
  }
  
  public RequiredNested<A> editRequired(int index) {
    if (required.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "required"));
    }
    return this.setNewRequiredLike(index, this.buildRequired(index));
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
    PodGroupAntiAffinityFluent that = (PodGroupAntiAffinityFluent) o;
    if (!(Objects.equals(preferred, that.preferred))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingPreferred(Predicate<PodGroupAffinityTermBuilder> predicate) {
      for (PodGroupAffinityTermBuilder item : preferred) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRequired(Predicate<PodGroupAffinityTermBuilder> predicate) {
      for (PodGroupAffinityTermBuilder item : required) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPreferred() {
    return this.preferred != null && !(this.preferred.isEmpty());
  }
  
  public boolean hasRequired() {
    return this.required != null && !(this.required.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(preferred, required, additionalProperties);
  }
  
  public A removeAllFromPreferred(Collection<PodGroupAffinityTerm> items) {
    if (this.preferred == null) {
      return (A) this;
    }
    for (PodGroupAffinityTerm item : items) {
        PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
        _visitables.get("preferred").remove(builder);
        this.preferred.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRequired(Collection<PodGroupAffinityTerm> items) {
    if (this.required == null) {
      return (A) this;
    }
    for (PodGroupAffinityTerm item : items) {
        PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
        _visitables.get("required").remove(builder);
        this.required.remove(builder);
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
  
  public A removeFromPreferred(PodGroupAffinityTerm... items) {
    if (this.preferred == null) {
      return (A) this;
    }
    for (PodGroupAffinityTerm item : items) {
        PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
        _visitables.get("preferred").remove(builder);
        this.preferred.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRequired(PodGroupAffinityTerm... items) {
    if (this.required == null) {
      return (A) this;
    }
    for (PodGroupAffinityTerm item : items) {
        PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
        _visitables.get("required").remove(builder);
        this.required.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPreferred(Predicate<PodGroupAffinityTermBuilder> predicate) {
    if (preferred == null) {
      return (A) this;
    }
    Iterator<PodGroupAffinityTermBuilder> each = preferred.iterator();
    List visitables = _visitables.get("preferred");
    while (each.hasNext()) {
        PodGroupAffinityTermBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRequired(Predicate<PodGroupAffinityTermBuilder> predicate) {
    if (required == null) {
      return (A) this;
    }
    Iterator<PodGroupAffinityTermBuilder> each = required.iterator();
    List visitables = _visitables.get("required");
    while (each.hasNext()) {
        PodGroupAffinityTermBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PreferredNested<A> setNewPreferredLike(int index,PodGroupAffinityTerm item) {
    return new PreferredNested(index, item);
  }
  
  public RequiredNested<A> setNewRequiredLike(int index,PodGroupAffinityTerm item) {
    return new RequiredNested(index, item);
  }
  
  public A setToPreferred(int index,PodGroupAffinityTerm item) {
    if (this.preferred == null) {
      this.preferred = new ArrayList();
    }
    PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
    if (index < 0 || index >= preferred.size()) {
        _visitables.get("preferred").add(builder);
        preferred.add(builder);
    } else {
        _visitables.get("preferred").add(builder);
        preferred.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRequired(int index,PodGroupAffinityTerm item) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    PodGroupAffinityTermBuilder builder = new PodGroupAffinityTermBuilder(item);
    if (index < 0 || index >= required.size()) {
        _visitables.get("required").add(builder);
        required.add(builder);
    } else {
        _visitables.get("required").add(builder);
        required.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(preferred == null) && !(preferred.isEmpty())) {
        sb.append("preferred:");
        sb.append(preferred);
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
  
  public A withPreferred(List<PodGroupAffinityTerm> preferred) {
    if (this.preferred != null) {
      this._visitables.get("preferred").clear();
    }
    if (preferred != null) {
        this.preferred = new ArrayList();
        for (PodGroupAffinityTerm item : preferred) {
          this.addToPreferred(item);
        }
    } else {
      this.preferred = null;
    }
    return (A) this;
  }
  
  public A withPreferred(PodGroupAffinityTerm... preferred) {
    if (this.preferred != null) {
        this.preferred.clear();
        _visitables.remove("preferred");
    }
    if (preferred != null) {
      for (PodGroupAffinityTerm item : preferred) {
        this.addToPreferred(item);
      }
    }
    return (A) this;
  }
  
  public A withRequired(List<PodGroupAffinityTerm> required) {
    if (this.required != null) {
      this._visitables.get("required").clear();
    }
    if (required != null) {
        this.required = new ArrayList();
        for (PodGroupAffinityTerm item : required) {
          this.addToRequired(item);
        }
    } else {
      this.required = null;
    }
    return (A) this;
  }
  
  public A withRequired(PodGroupAffinityTerm... required) {
    if (this.required != null) {
        this.required.clear();
        _visitables.remove("required");
    }
    if (required != null) {
      for (PodGroupAffinityTerm item : required) {
        this.addToRequired(item);
      }
    }
    return (A) this;
  }
  public class PreferredNested<N> extends PodGroupAffinityTermFluent<PreferredNested<N>> implements Nested<N>{
  
    PodGroupAffinityTermBuilder builder;
    int index;
  
    PreferredNested(int index,PodGroupAffinityTerm item) {
      this.index = index;
      this.builder = new PodGroupAffinityTermBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupAntiAffinityFluent.this.setToPreferred(index, builder.build());
    }
    
    public N endPreferred() {
      return and();
    }
    
  }
  public class RequiredNested<N> extends PodGroupAffinityTermFluent<RequiredNested<N>> implements Nested<N>{
  
    PodGroupAffinityTermBuilder builder;
    int index;
  
    RequiredNested(int index,PodGroupAffinityTerm item) {
      this.index = index;
      this.builder = new PodGroupAffinityTermBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupAntiAffinityFluent.this.setToRequired(index, builder.build());
    }
    
    public N endRequired() {
      return and();
    }
    
  }
}