package io.fabric8.openshift.api.model;

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
public class DeploymentDetailsFluent<A extends io.fabric8.openshift.api.model.DeploymentDetailsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<DeploymentCauseBuilder> causes = new ArrayList<DeploymentCauseBuilder>();
  private String message;

  public DeploymentDetailsFluent() {
  }
  
  public DeploymentDetailsFluent(DeploymentDetails instance) {
    this.copyInstance(instance);
  }

  public A addAllToCauses(Collection<DeploymentCause> items) {
    if (this.causes == null) {
      this.causes = new ArrayList();
    }
    for (DeploymentCause item : items) {
        DeploymentCauseBuilder builder = new DeploymentCauseBuilder(item);
        _visitables.get("causes").add(builder);
        this.causes.add(builder);
    }
    return (A) this;
  }
  
  public CausesNested<A> addNewCause() {
    return new CausesNested(-1, null);
  }
  
  public CausesNested<A> addNewCauseLike(DeploymentCause item) {
    return new CausesNested(-1, item);
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
  
  public A addToCauses(DeploymentCause... items) {
    if (this.causes == null) {
      this.causes = new ArrayList();
    }
    for (DeploymentCause item : items) {
        DeploymentCauseBuilder builder = new DeploymentCauseBuilder(item);
        _visitables.get("causes").add(builder);
        this.causes.add(builder);
    }
    return (A) this;
  }
  
  public A addToCauses(int index,DeploymentCause item) {
    if (this.causes == null) {
      this.causes = new ArrayList();
    }
    DeploymentCauseBuilder builder = new DeploymentCauseBuilder(item);
    if (index < 0 || index >= causes.size()) {
        _visitables.get("causes").add(builder);
        causes.add(builder);
    } else {
        _visitables.get("causes").add(builder);
        causes.add(index, builder);
    }
    return (A) this;
  }
  
  public DeploymentCause buildCause(int index) {
    return this.causes.get(index).build();
  }
  
  public List<DeploymentCause> buildCauses() {
    return this.causes != null ? build(causes) : null;
  }
  
  public DeploymentCause buildFirstCause() {
    return this.causes.get(0).build();
  }
  
  public DeploymentCause buildLastCause() {
    return this.causes.get(causes.size() - 1).build();
  }
  
  public DeploymentCause buildMatchingCause(Predicate<DeploymentCauseBuilder> predicate) {
      for (DeploymentCauseBuilder item : causes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(DeploymentDetails instance) {
    instance = instance != null ? instance : new DeploymentDetails();
    if (instance != null) {
        this.withCauses(instance.getCauses());
        this.withMessage(instance.getMessage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CausesNested<A> editCause(int index) {
    if (causes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "causes"));
    }
    return this.setNewCauseLike(index, this.buildCause(index));
  }
  
  public CausesNested<A> editFirstCause() {
    if (causes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "causes"));
    }
    return this.setNewCauseLike(0, this.buildCause(0));
  }
  
  public CausesNested<A> editLastCause() {
    int index = causes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "causes"));
    }
    return this.setNewCauseLike(index, this.buildCause(index));
  }
  
  public CausesNested<A> editMatchingCause(Predicate<DeploymentCauseBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < causes.size();i++) {
      if (predicate.test(causes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "causes"));
    }
    return this.setNewCauseLike(index, this.buildCause(index));
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
    DeploymentDetailsFluent that = (DeploymentDetailsFluent) o;
    if (!(Objects.equals(causes, that.causes))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
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
  
  public String getMessage() {
    return this.message;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCauses() {
    return this.causes != null && !(this.causes.isEmpty());
  }
  
  public boolean hasMatchingCause(Predicate<DeploymentCauseBuilder> predicate) {
      for (DeploymentCauseBuilder item : causes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public int hashCode() {
    return Objects.hash(causes, message, additionalProperties);
  }
  
  public A removeAllFromCauses(Collection<DeploymentCause> items) {
    if (this.causes == null) {
      return (A) this;
    }
    for (DeploymentCause item : items) {
        DeploymentCauseBuilder builder = new DeploymentCauseBuilder(item);
        _visitables.get("causes").remove(builder);
        this.causes.remove(builder);
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
  
  public A removeFromCauses(DeploymentCause... items) {
    if (this.causes == null) {
      return (A) this;
    }
    for (DeploymentCause item : items) {
        DeploymentCauseBuilder builder = new DeploymentCauseBuilder(item);
        _visitables.get("causes").remove(builder);
        this.causes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCauses(Predicate<DeploymentCauseBuilder> predicate) {
    if (causes == null) {
      return (A) this;
    }
    Iterator<DeploymentCauseBuilder> each = causes.iterator();
    List visitables = _visitables.get("causes");
    while (each.hasNext()) {
        DeploymentCauseBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CausesNested<A> setNewCauseLike(int index,DeploymentCause item) {
    return new CausesNested(index, item);
  }
  
  public A setToCauses(int index,DeploymentCause item) {
    if (this.causes == null) {
      this.causes = new ArrayList();
    }
    DeploymentCauseBuilder builder = new DeploymentCauseBuilder(item);
    if (index < 0 || index >= causes.size()) {
        _visitables.get("causes").add(builder);
        causes.add(builder);
    } else {
        _visitables.get("causes").add(builder);
        causes.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(causes == null) && !(causes.isEmpty())) {
        sb.append("causes:");
        sb.append(causes);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
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
  
  public A withCauses(List<DeploymentCause> causes) {
    if (this.causes != null) {
      this._visitables.get("causes").clear();
    }
    if (causes != null) {
        this.causes = new ArrayList();
        for (DeploymentCause item : causes) {
          this.addToCauses(item);
        }
    } else {
      this.causes = null;
    }
    return (A) this;
  }
  
  public A withCauses(DeploymentCause... causes) {
    if (this.causes != null) {
        this.causes.clear();
        _visitables.remove("causes");
    }
    if (causes != null) {
      for (DeploymentCause item : causes) {
        this.addToCauses(item);
      }
    }
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  public class CausesNested<N> extends DeploymentCauseFluent<CausesNested<N>> implements Nested<N>{
  
    DeploymentCauseBuilder builder;
    int index;
  
    CausesNested(int index,DeploymentCause item) {
      this.index = index;
      this.builder = new DeploymentCauseBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentDetailsFluent.this.setToCauses(index, builder.build());
    }
    
    public N endCause() {
      return and();
    }
    
  }
}