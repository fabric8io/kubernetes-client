package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class ClusterAPIStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1alpha1.ClusterAPIStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String currentRevision;
  private String desiredRevision;
  private Long observedRevisionGeneration;
  private ArrayList<ClusterAPIInstallerRevisionBuilder> revisions = new ArrayList<ClusterAPIInstallerRevisionBuilder>();

  public ClusterAPIStatusFluent() {
  }
  
  public ClusterAPIStatusFluent(ClusterAPIStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToRevisions(Collection<ClusterAPIInstallerRevision> items) {
    if (this.revisions == null) {
      this.revisions = new ArrayList();
    }
    for (ClusterAPIInstallerRevision item : items) {
        ClusterAPIInstallerRevisionBuilder builder = new ClusterAPIInstallerRevisionBuilder(item);
        _visitables.get("revisions").add(builder);
        this.revisions.add(builder);
    }
    return (A) this;
  }
  
  public RevisionsNested<A> addNewRevision() {
    return new RevisionsNested(-1, null);
  }
  
  public RevisionsNested<A> addNewRevisionLike(ClusterAPIInstallerRevision item) {
    return new RevisionsNested(-1, item);
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
  
  public A addToRevisions(ClusterAPIInstallerRevision... items) {
    if (this.revisions == null) {
      this.revisions = new ArrayList();
    }
    for (ClusterAPIInstallerRevision item : items) {
        ClusterAPIInstallerRevisionBuilder builder = new ClusterAPIInstallerRevisionBuilder(item);
        _visitables.get("revisions").add(builder);
        this.revisions.add(builder);
    }
    return (A) this;
  }
  
  public A addToRevisions(int index,ClusterAPIInstallerRevision item) {
    if (this.revisions == null) {
      this.revisions = new ArrayList();
    }
    ClusterAPIInstallerRevisionBuilder builder = new ClusterAPIInstallerRevisionBuilder(item);
    if (index < 0 || index >= revisions.size()) {
        _visitables.get("revisions").add(builder);
        revisions.add(builder);
    } else {
        _visitables.get("revisions").add(builder);
        revisions.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterAPIInstallerRevision buildFirstRevision() {
    return this.revisions.get(0).build();
  }
  
  public ClusterAPIInstallerRevision buildLastRevision() {
    return this.revisions.get(revisions.size() - 1).build();
  }
  
  public ClusterAPIInstallerRevision buildMatchingRevision(Predicate<ClusterAPIInstallerRevisionBuilder> predicate) {
      for (ClusterAPIInstallerRevisionBuilder item : revisions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterAPIInstallerRevision buildRevision(int index) {
    return this.revisions.get(index).build();
  }
  
  public List<ClusterAPIInstallerRevision> buildRevisions() {
    return this.revisions != null ? build(revisions) : null;
  }
  
  protected void copyInstance(ClusterAPIStatus instance) {
    instance = instance != null ? instance : new ClusterAPIStatus();
    if (instance != null) {
        this.withCurrentRevision(instance.getCurrentRevision());
        this.withDesiredRevision(instance.getDesiredRevision());
        this.withObservedRevisionGeneration(instance.getObservedRevisionGeneration());
        this.withRevisions(instance.getRevisions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RevisionsNested<A> editFirstRevision() {
    if (revisions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "revisions"));
    }
    return this.setNewRevisionLike(0, this.buildRevision(0));
  }
  
  public RevisionsNested<A> editLastRevision() {
    int index = revisions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "revisions"));
    }
    return this.setNewRevisionLike(index, this.buildRevision(index));
  }
  
  public RevisionsNested<A> editMatchingRevision(Predicate<ClusterAPIInstallerRevisionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < revisions.size();i++) {
      if (predicate.test(revisions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "revisions"));
    }
    return this.setNewRevisionLike(index, this.buildRevision(index));
  }
  
  public RevisionsNested<A> editRevision(int index) {
    if (revisions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "revisions"));
    }
    return this.setNewRevisionLike(index, this.buildRevision(index));
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
    ClusterAPIStatusFluent that = (ClusterAPIStatusFluent) o;
    if (!(Objects.equals(currentRevision, that.currentRevision))) {
      return false;
    }
    if (!(Objects.equals(desiredRevision, that.desiredRevision))) {
      return false;
    }
    if (!(Objects.equals(observedRevisionGeneration, that.observedRevisionGeneration))) {
      return false;
    }
    if (!(Objects.equals(revisions, that.revisions))) {
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
  
  public String getCurrentRevision() {
    return this.currentRevision;
  }
  
  public String getDesiredRevision() {
    return this.desiredRevision;
  }
  
  public Long getObservedRevisionGeneration() {
    return this.observedRevisionGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCurrentRevision() {
    return this.currentRevision != null;
  }
  
  public boolean hasDesiredRevision() {
    return this.desiredRevision != null;
  }
  
  public boolean hasMatchingRevision(Predicate<ClusterAPIInstallerRevisionBuilder> predicate) {
      for (ClusterAPIInstallerRevisionBuilder item : revisions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedRevisionGeneration() {
    return this.observedRevisionGeneration != null;
  }
  
  public boolean hasRevisions() {
    return this.revisions != null && !(this.revisions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(currentRevision, desiredRevision, observedRevisionGeneration, revisions, additionalProperties);
  }
  
  public A removeAllFromRevisions(Collection<ClusterAPIInstallerRevision> items) {
    if (this.revisions == null) {
      return (A) this;
    }
    for (ClusterAPIInstallerRevision item : items) {
        ClusterAPIInstallerRevisionBuilder builder = new ClusterAPIInstallerRevisionBuilder(item);
        _visitables.get("revisions").remove(builder);
        this.revisions.remove(builder);
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
  
  public A removeFromRevisions(ClusterAPIInstallerRevision... items) {
    if (this.revisions == null) {
      return (A) this;
    }
    for (ClusterAPIInstallerRevision item : items) {
        ClusterAPIInstallerRevisionBuilder builder = new ClusterAPIInstallerRevisionBuilder(item);
        _visitables.get("revisions").remove(builder);
        this.revisions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRevisions(Predicate<ClusterAPIInstallerRevisionBuilder> predicate) {
    if (revisions == null) {
      return (A) this;
    }
    Iterator<ClusterAPIInstallerRevisionBuilder> each = revisions.iterator();
    List visitables = _visitables.get("revisions");
    while (each.hasNext()) {
        ClusterAPIInstallerRevisionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RevisionsNested<A> setNewRevisionLike(int index,ClusterAPIInstallerRevision item) {
    return new RevisionsNested(index, item);
  }
  
  public A setToRevisions(int index,ClusterAPIInstallerRevision item) {
    if (this.revisions == null) {
      this.revisions = new ArrayList();
    }
    ClusterAPIInstallerRevisionBuilder builder = new ClusterAPIInstallerRevisionBuilder(item);
    if (index < 0 || index >= revisions.size()) {
        _visitables.get("revisions").add(builder);
        revisions.add(builder);
    } else {
        _visitables.get("revisions").add(builder);
        revisions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(currentRevision == null)) {
        sb.append("currentRevision:");
        sb.append(currentRevision);
        sb.append(",");
    }
    if (!(desiredRevision == null)) {
        sb.append("desiredRevision:");
        sb.append(desiredRevision);
        sb.append(",");
    }
    if (!(observedRevisionGeneration == null)) {
        sb.append("observedRevisionGeneration:");
        sb.append(observedRevisionGeneration);
        sb.append(",");
    }
    if (!(revisions == null) && !(revisions.isEmpty())) {
        sb.append("revisions:");
        sb.append(revisions);
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
  
  public A withCurrentRevision(String currentRevision) {
    this.currentRevision = currentRevision;
    return (A) this;
  }
  
  public A withDesiredRevision(String desiredRevision) {
    this.desiredRevision = desiredRevision;
    return (A) this;
  }
  
  public A withObservedRevisionGeneration(Long observedRevisionGeneration) {
    this.observedRevisionGeneration = observedRevisionGeneration;
    return (A) this;
  }
  
  public A withRevisions(List<ClusterAPIInstallerRevision> revisions) {
    if (this.revisions != null) {
      this._visitables.get("revisions").clear();
    }
    if (revisions != null) {
        this.revisions = new ArrayList();
        for (ClusterAPIInstallerRevision item : revisions) {
          this.addToRevisions(item);
        }
    } else {
      this.revisions = null;
    }
    return (A) this;
  }
  
  public A withRevisions(ClusterAPIInstallerRevision... revisions) {
    if (this.revisions != null) {
        this.revisions.clear();
        _visitables.remove("revisions");
    }
    if (revisions != null) {
      for (ClusterAPIInstallerRevision item : revisions) {
        this.addToRevisions(item);
      }
    }
    return (A) this;
  }
  public class RevisionsNested<N> extends ClusterAPIInstallerRevisionFluent<RevisionsNested<N>> implements Nested<N>{
  
    ClusterAPIInstallerRevisionBuilder builder;
    int index;
  
    RevisionsNested(int index,ClusterAPIInstallerRevision item) {
      this.index = index;
      this.builder = new ClusterAPIInstallerRevisionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterAPIStatusFluent.this.setToRevisions(index, builder.build());
    }
    
    public N endRevision() {
      return and();
    }
    
  }
}