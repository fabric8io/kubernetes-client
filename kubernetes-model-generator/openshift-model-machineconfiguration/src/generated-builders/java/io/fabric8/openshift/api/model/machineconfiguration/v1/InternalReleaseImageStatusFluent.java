package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class InternalReleaseImageStatusFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.InternalReleaseImageStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ArrayList<InternalReleaseImageBundleStatusBuilder> releases = new ArrayList<InternalReleaseImageBundleStatusBuilder>();

  public InternalReleaseImageStatusFluent() {
  }
  
  public InternalReleaseImageStatusFluent(InternalReleaseImageStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToReleases(Collection<InternalReleaseImageBundleStatus> items) {
    if (this.releases == null) {
      this.releases = new ArrayList();
    }
    for (InternalReleaseImageBundleStatus item : items) {
        InternalReleaseImageBundleStatusBuilder builder = new InternalReleaseImageBundleStatusBuilder(item);
        _visitables.get("releases").add(builder);
        this.releases.add(builder);
    }
    return (A) this;
  }
  
  public ReleasesNested<A> addNewRelease() {
    return new ReleasesNested(-1, null);
  }
  
  public ReleasesNested<A> addNewReleaseLike(InternalReleaseImageBundleStatus item) {
    return new ReleasesNested(-1, item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToReleases(InternalReleaseImageBundleStatus... items) {
    if (this.releases == null) {
      this.releases = new ArrayList();
    }
    for (InternalReleaseImageBundleStatus item : items) {
        InternalReleaseImageBundleStatusBuilder builder = new InternalReleaseImageBundleStatusBuilder(item);
        _visitables.get("releases").add(builder);
        this.releases.add(builder);
    }
    return (A) this;
  }
  
  public A addToReleases(int index,InternalReleaseImageBundleStatus item) {
    if (this.releases == null) {
      this.releases = new ArrayList();
    }
    InternalReleaseImageBundleStatusBuilder builder = new InternalReleaseImageBundleStatusBuilder(item);
    if (index < 0 || index >= releases.size()) {
        _visitables.get("releases").add(builder);
        releases.add(builder);
    } else {
        _visitables.get("releases").add(builder);
        releases.add(index, builder);
    }
    return (A) this;
  }
  
  public InternalReleaseImageBundleStatus buildFirstRelease() {
    return this.releases.get(0).build();
  }
  
  public InternalReleaseImageBundleStatus buildLastRelease() {
    return this.releases.get(releases.size() - 1).build();
  }
  
  public InternalReleaseImageBundleStatus buildMatchingRelease(Predicate<InternalReleaseImageBundleStatusBuilder> predicate) {
      for (InternalReleaseImageBundleStatusBuilder item : releases) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public InternalReleaseImageBundleStatus buildRelease(int index) {
    return this.releases.get(index).build();
  }
  
  public List<InternalReleaseImageBundleStatus> buildReleases() {
    return this.releases != null ? build(releases) : null;
  }
  
  protected void copyInstance(InternalReleaseImageStatus instance) {
    instance = instance != null ? instance : new InternalReleaseImageStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withReleases(instance.getReleases());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ReleasesNested<A> editFirstRelease() {
    if (releases.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "releases"));
    }
    return this.setNewReleaseLike(0, this.buildRelease(0));
  }
  
  public ReleasesNested<A> editLastRelease() {
    int index = releases.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "releases"));
    }
    return this.setNewReleaseLike(index, this.buildRelease(index));
  }
  
  public ReleasesNested<A> editMatchingRelease(Predicate<InternalReleaseImageBundleStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < releases.size();i++) {
      if (predicate.test(releases.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "releases"));
    }
    return this.setNewReleaseLike(index, this.buildRelease(index));
  }
  
  public ReleasesNested<A> editRelease(int index) {
    if (releases.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "releases"));
    }
    return this.setNewReleaseLike(index, this.buildRelease(index));
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
    InternalReleaseImageStatusFluent that = (InternalReleaseImageStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(releases, that.releases))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRelease(Predicate<InternalReleaseImageBundleStatusBuilder> predicate) {
      for (InternalReleaseImageBundleStatusBuilder item : releases) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReleases() {
    return this.releases != null && !(this.releases.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, releases, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromReleases(Collection<InternalReleaseImageBundleStatus> items) {
    if (this.releases == null) {
      return (A) this;
    }
    for (InternalReleaseImageBundleStatus item : items) {
        InternalReleaseImageBundleStatusBuilder builder = new InternalReleaseImageBundleStatusBuilder(item);
        _visitables.get("releases").remove(builder);
        this.releases.remove(builder);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromReleases(InternalReleaseImageBundleStatus... items) {
    if (this.releases == null) {
      return (A) this;
    }
    for (InternalReleaseImageBundleStatus item : items) {
        InternalReleaseImageBundleStatusBuilder builder = new InternalReleaseImageBundleStatusBuilder(item);
        _visitables.get("releases").remove(builder);
        this.releases.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromReleases(Predicate<InternalReleaseImageBundleStatusBuilder> predicate) {
    if (releases == null) {
      return (A) this;
    }
    Iterator<InternalReleaseImageBundleStatusBuilder> each = releases.iterator();
    List visitables = _visitables.get("releases");
    while (each.hasNext()) {
        InternalReleaseImageBundleStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ReleasesNested<A> setNewReleaseLike(int index,InternalReleaseImageBundleStatus item) {
    return new ReleasesNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToReleases(int index,InternalReleaseImageBundleStatus item) {
    if (this.releases == null) {
      this.releases = new ArrayList();
    }
    InternalReleaseImageBundleStatusBuilder builder = new InternalReleaseImageBundleStatusBuilder(item);
    if (index < 0 || index >= releases.size()) {
        _visitables.get("releases").add(builder);
        releases.add(builder);
    } else {
        _visitables.get("releases").add(builder);
        releases.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(releases == null) && !(releases.isEmpty())) {
        sb.append("releases:");
        sb.append(releases);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withReleases(List<InternalReleaseImageBundleStatus> releases) {
    if (this.releases != null) {
      this._visitables.get("releases").clear();
    }
    if (releases != null) {
        this.releases = new ArrayList();
        for (InternalReleaseImageBundleStatus item : releases) {
          this.addToReleases(item);
        }
    } else {
      this.releases = null;
    }
    return (A) this;
  }
  
  public A withReleases(InternalReleaseImageBundleStatus... releases) {
    if (this.releases != null) {
        this.releases.clear();
        _visitables.remove("releases");
    }
    if (releases != null) {
      for (InternalReleaseImageBundleStatus item : releases) {
        this.addToReleases(item);
      }
    }
    return (A) this;
  }
  public class ReleasesNested<N> extends InternalReleaseImageBundleStatusFluent<ReleasesNested<N>> implements Nested<N>{
  
    InternalReleaseImageBundleStatusBuilder builder;
    int index;
  
    ReleasesNested(int index,InternalReleaseImageBundleStatus item) {
      this.index = index;
      this.builder = new InternalReleaseImageBundleStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) InternalReleaseImageStatusFluent.this.setToReleases(index, builder.build());
    }
    
    public N endRelease() {
      return and();
    }
    
  }
}