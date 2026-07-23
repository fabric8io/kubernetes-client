package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
public class HostClaimNamespacesFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HostClaimNamespacesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NameValuePairBuilder> hasLabels = new ArrayList<NameValuePairBuilder>();
  private String nameMatches;
  private List<String> names = new ArrayList<String>();

  public HostClaimNamespacesFluent() {
  }
  
  public HostClaimNamespacesFluent(HostClaimNamespaces instance) {
    this.copyInstance(instance);
  }

  public A addAllToHasLabels(Collection<NameValuePair> items) {
    if (this.hasLabels == null) {
      this.hasLabels = new ArrayList();
    }
    for (NameValuePair item : items) {
        NameValuePairBuilder builder = new NameValuePairBuilder(item);
        _visitables.get("hasLabels").add(builder);
        this.hasLabels.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToNames(Collection<String> items) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    for (String item : items) {
      this.names.add(item);
    }
    return (A) this;
  }
  
  public HasLabelsNested<A> addNewHasLabel() {
    return new HasLabelsNested(-1, null);
  }
  
  public A addNewHasLabel(String name,String value) {
    return (A) this.addToHasLabels(new NameValuePair(name, value));
  }
  
  public HasLabelsNested<A> addNewHasLabelLike(NameValuePair item) {
    return new HasLabelsNested(-1, item);
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
  
  public A addToHasLabels(NameValuePair... items) {
    if (this.hasLabels == null) {
      this.hasLabels = new ArrayList();
    }
    for (NameValuePair item : items) {
        NameValuePairBuilder builder = new NameValuePairBuilder(item);
        _visitables.get("hasLabels").add(builder);
        this.hasLabels.add(builder);
    }
    return (A) this;
  }
  
  public A addToHasLabels(int index,NameValuePair item) {
    if (this.hasLabels == null) {
      this.hasLabels = new ArrayList();
    }
    NameValuePairBuilder builder = new NameValuePairBuilder(item);
    if (index < 0 || index >= hasLabels.size()) {
        _visitables.get("hasLabels").add(builder);
        hasLabels.add(builder);
    } else {
        _visitables.get("hasLabels").add(builder);
        hasLabels.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToNames(String... items) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    for (String item : items) {
      this.names.add(item);
    }
    return (A) this;
  }
  
  public A addToNames(int index,String item) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    this.names.add(index, item);
    return (A) this;
  }
  
  public NameValuePair buildFirstHasLabel() {
    return this.hasLabels.get(0).build();
  }
  
  public NameValuePair buildHasLabel(int index) {
    return this.hasLabels.get(index).build();
  }
  
  public List<NameValuePair> buildHasLabels() {
    return this.hasLabels != null ? build(hasLabels) : null;
  }
  
  public NameValuePair buildLastHasLabel() {
    return this.hasLabels.get(hasLabels.size() - 1).build();
  }
  
  public NameValuePair buildMatchingHasLabel(Predicate<NameValuePairBuilder> predicate) {
      for (NameValuePairBuilder item : hasLabels) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(HostClaimNamespaces instance) {
    instance = instance != null ? instance : new HostClaimNamespaces();
    if (instance != null) {
        this.withHasLabels(instance.getHasLabels());
        this.withNameMatches(instance.getNameMatches());
        this.withNames(instance.getNames());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HasLabelsNested<A> editFirstHasLabel() {
    if (hasLabels.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "hasLabels"));
    }
    return this.setNewHasLabelLike(0, this.buildHasLabel(0));
  }
  
  public HasLabelsNested<A> editHasLabel(int index) {
    if (hasLabels.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "hasLabels"));
    }
    return this.setNewHasLabelLike(index, this.buildHasLabel(index));
  }
  
  public HasLabelsNested<A> editLastHasLabel() {
    int index = hasLabels.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "hasLabels"));
    }
    return this.setNewHasLabelLike(index, this.buildHasLabel(index));
  }
  
  public HasLabelsNested<A> editMatchingHasLabel(Predicate<NameValuePairBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < hasLabels.size();i++) {
      if (predicate.test(hasLabels.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "hasLabels"));
    }
    return this.setNewHasLabelLike(index, this.buildHasLabel(index));
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
    HostClaimNamespacesFluent that = (HostClaimNamespacesFluent) o;
    if (!(Objects.equals(hasLabels, that.hasLabels))) {
      return false;
    }
    if (!(Objects.equals(nameMatches, that.nameMatches))) {
      return false;
    }
    if (!(Objects.equals(names, that.names))) {
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
  
  public String getFirstName() {
    return this.names.get(0);
  }
  
  public String getLastName() {
    return this.names.get(names.size() - 1);
  }
  
  public String getMatchingName(Predicate<String> predicate) {
      for (String item : names) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName(int index) {
    return this.names.get(index);
  }
  
  public String getNameMatches() {
    return this.nameMatches;
  }
  
  public List<String> getNames() {
    return this.names;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHasLabels() {
    return this.hasLabels != null && !(this.hasLabels.isEmpty());
  }
  
  public boolean hasMatchingHasLabel(Predicate<NameValuePairBuilder> predicate) {
      for (NameValuePairBuilder item : hasLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingName(Predicate<String> predicate) {
      for (String item : names) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNameMatches() {
    return this.nameMatches != null;
  }
  
  public boolean hasNames() {
    return this.names != null && !(this.names.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(hasLabels, nameMatches, names, additionalProperties);
  }
  
  public A removeAllFromHasLabels(Collection<NameValuePair> items) {
    if (this.hasLabels == null) {
      return (A) this;
    }
    for (NameValuePair item : items) {
        NameValuePairBuilder builder = new NameValuePairBuilder(item);
        _visitables.get("hasLabels").remove(builder);
        this.hasLabels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromNames(Collection<String> items) {
    if (this.names == null) {
      return (A) this;
    }
    for (String item : items) {
      this.names.remove(item);
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
  
  public A removeFromHasLabels(NameValuePair... items) {
    if (this.hasLabels == null) {
      return (A) this;
    }
    for (NameValuePair item : items) {
        NameValuePairBuilder builder = new NameValuePairBuilder(item);
        _visitables.get("hasLabels").remove(builder);
        this.hasLabels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromNames(String... items) {
    if (this.names == null) {
      return (A) this;
    }
    for (String item : items) {
      this.names.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHasLabels(Predicate<NameValuePairBuilder> predicate) {
    if (hasLabels == null) {
      return (A) this;
    }
    Iterator<NameValuePairBuilder> each = hasLabels.iterator();
    List visitables = _visitables.get("hasLabels");
    while (each.hasNext()) {
        NameValuePairBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HasLabelsNested<A> setNewHasLabelLike(int index,NameValuePair item) {
    return new HasLabelsNested(index, item);
  }
  
  public A setToHasLabels(int index,NameValuePair item) {
    if (this.hasLabels == null) {
      this.hasLabels = new ArrayList();
    }
    NameValuePairBuilder builder = new NameValuePairBuilder(item);
    if (index < 0 || index >= hasLabels.size()) {
        _visitables.get("hasLabels").add(builder);
        hasLabels.add(builder);
    } else {
        _visitables.get("hasLabels").add(builder);
        hasLabels.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToNames(int index,String item) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    this.names.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hasLabels == null) && !(hasLabels.isEmpty())) {
        sb.append("hasLabels:");
        sb.append(hasLabels);
        sb.append(",");
    }
    if (!(nameMatches == null)) {
        sb.append("nameMatches:");
        sb.append(nameMatches);
        sb.append(",");
    }
    if (!(names == null) && !(names.isEmpty())) {
        sb.append("names:");
        sb.append(names);
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
  
  public A withHasLabels(List<NameValuePair> hasLabels) {
    if (this.hasLabels != null) {
      this._visitables.get("hasLabels").clear();
    }
    if (hasLabels != null) {
        this.hasLabels = new ArrayList();
        for (NameValuePair item : hasLabels) {
          this.addToHasLabels(item);
        }
    } else {
      this.hasLabels = null;
    }
    return (A) this;
  }
  
  public A withHasLabels(NameValuePair... hasLabels) {
    if (this.hasLabels != null) {
        this.hasLabels.clear();
        _visitables.remove("hasLabels");
    }
    if (hasLabels != null) {
      for (NameValuePair item : hasLabels) {
        this.addToHasLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withNameMatches(String nameMatches) {
    this.nameMatches = nameMatches;
    return (A) this;
  }
  
  public A withNames(List<String> names) {
    if (names != null) {
        this.names = new ArrayList();
        for (String item : names) {
          this.addToNames(item);
        }
    } else {
      this.names = null;
    }
    return (A) this;
  }
  
  public A withNames(String... names) {
    if (this.names != null) {
        this.names.clear();
        _visitables.remove("names");
    }
    if (names != null) {
      for (String item : names) {
        this.addToNames(item);
      }
    }
    return (A) this;
  }
  public class HasLabelsNested<N> extends NameValuePairFluent<HasLabelsNested<N>> implements Nested<N>{
  
    NameValuePairBuilder builder;
    int index;
  
    HasLabelsNested(int index,NameValuePair item) {
      this.index = index;
      this.builder = new NameValuePairBuilder(this, item);
    }
  
    public N and() {
      return (N) HostClaimNamespacesFluent.this.setToHasLabels(index, builder.build());
    }
    
    public N endHasLabel() {
      return and();
    }
    
  }
}