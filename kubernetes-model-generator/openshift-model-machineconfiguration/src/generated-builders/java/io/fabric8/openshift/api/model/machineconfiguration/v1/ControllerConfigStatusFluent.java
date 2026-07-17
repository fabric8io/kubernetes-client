package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
public class ControllerConfigStatusFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.ControllerConfigStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ControllerConfigStatusConditionBuilder> conditions = new ArrayList<ControllerConfigStatusConditionBuilder>();
  private ArrayList<ControllerCertificateBuilder> controllerCertificates = new ArrayList<ControllerCertificateBuilder>();
  private Long observedGeneration;

  public ControllerConfigStatusFluent() {
  }
  
  public ControllerConfigStatusFluent(ControllerConfigStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<ControllerConfigStatusCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ControllerConfigStatusCondition item : items) {
        ControllerConfigStatusConditionBuilder builder = new ControllerConfigStatusConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToControllerCertificates(Collection<ControllerCertificate> items) {
    if (this.controllerCertificates == null) {
      this.controllerCertificates = new ArrayList();
    }
    for (ControllerCertificate item : items) {
        ControllerCertificateBuilder builder = new ControllerCertificateBuilder(item);
        _visitables.get("controllerCertificates").add(builder);
        this.controllerCertificates.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new ControllerConfigStatusCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(ControllerConfigStatusCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public ControllerCertificatesNested<A> addNewControllerCertificate() {
    return new ControllerCertificatesNested(-1, null);
  }
  
  public A addNewControllerCertificate(String bundleFile,String notAfter,String notBefore,String signer,String subject) {
    return (A) this.addToControllerCertificates(new ControllerCertificate(bundleFile, notAfter, notBefore, signer, subject));
  }
  
  public ControllerCertificatesNested<A> addNewControllerCertificateLike(ControllerCertificate item) {
    return new ControllerCertificatesNested(-1, item);
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
  
  public A addToConditions(ControllerConfigStatusCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ControllerConfigStatusCondition item : items) {
        ControllerConfigStatusConditionBuilder builder = new ControllerConfigStatusConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,ControllerConfigStatusCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ControllerConfigStatusConditionBuilder builder = new ControllerConfigStatusConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToControllerCertificates(ControllerCertificate... items) {
    if (this.controllerCertificates == null) {
      this.controllerCertificates = new ArrayList();
    }
    for (ControllerCertificate item : items) {
        ControllerCertificateBuilder builder = new ControllerCertificateBuilder(item);
        _visitables.get("controllerCertificates").add(builder);
        this.controllerCertificates.add(builder);
    }
    return (A) this;
  }
  
  public A addToControllerCertificates(int index,ControllerCertificate item) {
    if (this.controllerCertificates == null) {
      this.controllerCertificates = new ArrayList();
    }
    ControllerCertificateBuilder builder = new ControllerCertificateBuilder(item);
    if (index < 0 || index >= controllerCertificates.size()) {
        _visitables.get("controllerCertificates").add(builder);
        controllerCertificates.add(builder);
    } else {
        _visitables.get("controllerCertificates").add(builder);
        controllerCertificates.add(index, builder);
    }
    return (A) this;
  }
  
  public ControllerConfigStatusCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<ControllerConfigStatusCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public ControllerCertificate buildControllerCertificate(int index) {
    return this.controllerCertificates.get(index).build();
  }
  
  public List<ControllerCertificate> buildControllerCertificates() {
    return this.controllerCertificates != null ? build(controllerCertificates) : null;
  }
  
  public ControllerConfigStatusCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public ControllerCertificate buildFirstControllerCertificate() {
    return this.controllerCertificates.get(0).build();
  }
  
  public ControllerConfigStatusCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public ControllerCertificate buildLastControllerCertificate() {
    return this.controllerCertificates.get(controllerCertificates.size() - 1).build();
  }
  
  public ControllerConfigStatusCondition buildMatchingCondition(Predicate<ControllerConfigStatusConditionBuilder> predicate) {
      for (ControllerConfigStatusConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ControllerCertificate buildMatchingControllerCertificate(Predicate<ControllerCertificateBuilder> predicate) {
      for (ControllerCertificateBuilder item : controllerCertificates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ControllerConfigStatus instance) {
    instance = instance != null ? instance : new ControllerConfigStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withControllerCertificates(instance.getControllerCertificates());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ControllerCertificatesNested<A> editControllerCertificate(int index) {
    if (controllerCertificates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "controllerCertificates"));
    }
    return this.setNewControllerCertificateLike(index, this.buildControllerCertificate(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ControllerCertificatesNested<A> editFirstControllerCertificate() {
    if (controllerCertificates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "controllerCertificates"));
    }
    return this.setNewControllerCertificateLike(0, this.buildControllerCertificate(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ControllerCertificatesNested<A> editLastControllerCertificate() {
    int index = controllerCertificates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "controllerCertificates"));
    }
    return this.setNewControllerCertificateLike(index, this.buildControllerCertificate(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ControllerConfigStatusConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ControllerCertificatesNested<A> editMatchingControllerCertificate(Predicate<ControllerCertificateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < controllerCertificates.size();i++) {
      if (predicate.test(controllerCertificates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "controllerCertificates"));
    }
    return this.setNewControllerCertificateLike(index, this.buildControllerCertificate(index));
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
    ControllerConfigStatusFluent that = (ControllerConfigStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(controllerCertificates, that.controllerCertificates))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
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
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasControllerCertificates() {
    return this.controllerCertificates != null && !(this.controllerCertificates.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<ControllerConfigStatusConditionBuilder> predicate) {
      for (ControllerConfigStatusConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingControllerCertificate(Predicate<ControllerCertificateBuilder> predicate) {
      for (ControllerCertificateBuilder item : controllerCertificates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, controllerCertificates, observedGeneration, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<ControllerConfigStatusCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ControllerConfigStatusCondition item : items) {
        ControllerConfigStatusConditionBuilder builder = new ControllerConfigStatusConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromControllerCertificates(Collection<ControllerCertificate> items) {
    if (this.controllerCertificates == null) {
      return (A) this;
    }
    for (ControllerCertificate item : items) {
        ControllerCertificateBuilder builder = new ControllerCertificateBuilder(item);
        _visitables.get("controllerCertificates").remove(builder);
        this.controllerCertificates.remove(builder);
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
  
  public A removeFromConditions(ControllerConfigStatusCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ControllerConfigStatusCondition item : items) {
        ControllerConfigStatusConditionBuilder builder = new ControllerConfigStatusConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromControllerCertificates(ControllerCertificate... items) {
    if (this.controllerCertificates == null) {
      return (A) this;
    }
    for (ControllerCertificate item : items) {
        ControllerCertificateBuilder builder = new ControllerCertificateBuilder(item);
        _visitables.get("controllerCertificates").remove(builder);
        this.controllerCertificates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ControllerConfigStatusConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ControllerConfigStatusConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ControllerConfigStatusConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromControllerCertificates(Predicate<ControllerCertificateBuilder> predicate) {
    if (controllerCertificates == null) {
      return (A) this;
    }
    Iterator<ControllerCertificateBuilder> each = controllerCertificates.iterator();
    List visitables = _visitables.get("controllerCertificates");
    while (each.hasNext()) {
        ControllerCertificateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,ControllerConfigStatusCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public ControllerCertificatesNested<A> setNewControllerCertificateLike(int index,ControllerCertificate item) {
    return new ControllerCertificatesNested(index, item);
  }
  
  public A setToConditions(int index,ControllerConfigStatusCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ControllerConfigStatusConditionBuilder builder = new ControllerConfigStatusConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToControllerCertificates(int index,ControllerCertificate item) {
    if (this.controllerCertificates == null) {
      this.controllerCertificates = new ArrayList();
    }
    ControllerCertificateBuilder builder = new ControllerCertificateBuilder(item);
    if (index < 0 || index >= controllerCertificates.size()) {
        _visitables.get("controllerCertificates").add(builder);
        controllerCertificates.add(builder);
    } else {
        _visitables.get("controllerCertificates").add(builder);
        controllerCertificates.set(index, builder);
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
    if (!(controllerCertificates == null) && !(controllerCertificates.isEmpty())) {
        sb.append("controllerCertificates:");
        sb.append(controllerCertificates);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
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
  
  public A withConditions(List<ControllerConfigStatusCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (ControllerConfigStatusCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(ControllerConfigStatusCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (ControllerConfigStatusCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withControllerCertificates(List<ControllerCertificate> controllerCertificates) {
    if (this.controllerCertificates != null) {
      this._visitables.get("controllerCertificates").clear();
    }
    if (controllerCertificates != null) {
        this.controllerCertificates = new ArrayList();
        for (ControllerCertificate item : controllerCertificates) {
          this.addToControllerCertificates(item);
        }
    } else {
      this.controllerCertificates = null;
    }
    return (A) this;
  }
  
  public A withControllerCertificates(ControllerCertificate... controllerCertificates) {
    if (this.controllerCertificates != null) {
        this.controllerCertificates.clear();
        _visitables.remove("controllerCertificates");
    }
    if (controllerCertificates != null) {
      for (ControllerCertificate item : controllerCertificates) {
        this.addToControllerCertificates(item);
      }
    }
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  public class ConditionsNested<N> extends ControllerConfigStatusConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ControllerConfigStatusConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,ControllerConfigStatusCondition item) {
      this.index = index;
      this.builder = new ControllerConfigStatusConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ControllerConfigStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ControllerCertificatesNested<N> extends ControllerCertificateFluent<ControllerCertificatesNested<N>> implements Nested<N>{
  
    ControllerCertificateBuilder builder;
    int index;
  
    ControllerCertificatesNested(int index,ControllerCertificate item) {
      this.index = index;
      this.builder = new ControllerCertificateBuilder(this, item);
    }
  
    public N and() {
      return (N) ControllerConfigStatusFluent.this.setToControllerCertificates(index, builder.build());
    }
    
    public N endControllerCertificate() {
      return and();
    }
    
  }
}