package io.fabric8.kubernetes.api.model.batch.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PodFailurePolicyRuleFluent<A extends io.fabric8.kubernetes.api.model.batch.v1.PodFailurePolicyRuleFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private PodFailurePolicyOnExitCodesRequirementBuilder onExitCodes;
  private ArrayList<PodFailurePolicyOnPodConditionsPatternBuilder> onPodConditions = new ArrayList<PodFailurePolicyOnPodConditionsPatternBuilder>();

  public PodFailurePolicyRuleFluent() {
  }
  
  public PodFailurePolicyRuleFluent(PodFailurePolicyRule instance) {
    this.copyInstance(instance);
  }

  public A addAllToOnPodConditions(Collection<PodFailurePolicyOnPodConditionsPattern> items) {
    if (this.onPodConditions == null) {
      this.onPodConditions = new ArrayList();
    }
    for (PodFailurePolicyOnPodConditionsPattern item : items) {
        PodFailurePolicyOnPodConditionsPatternBuilder builder = new PodFailurePolicyOnPodConditionsPatternBuilder(item);
        _visitables.get("onPodConditions").add(builder);
        this.onPodConditions.add(builder);
    }
    return (A) this;
  }
  
  public OnPodConditionsNested<A> addNewOnPodCondition() {
    return new OnPodConditionsNested(-1, null);
  }
  
  public A addNewOnPodCondition(String status,String type) {
    return (A) this.addToOnPodConditions(new PodFailurePolicyOnPodConditionsPattern(status, type));
  }
  
  public OnPodConditionsNested<A> addNewOnPodConditionLike(PodFailurePolicyOnPodConditionsPattern item) {
    return new OnPodConditionsNested(-1, item);
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
  
  public A addToOnPodConditions(PodFailurePolicyOnPodConditionsPattern... items) {
    if (this.onPodConditions == null) {
      this.onPodConditions = new ArrayList();
    }
    for (PodFailurePolicyOnPodConditionsPattern item : items) {
        PodFailurePolicyOnPodConditionsPatternBuilder builder = new PodFailurePolicyOnPodConditionsPatternBuilder(item);
        _visitables.get("onPodConditions").add(builder);
        this.onPodConditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToOnPodConditions(int index,PodFailurePolicyOnPodConditionsPattern item) {
    if (this.onPodConditions == null) {
      this.onPodConditions = new ArrayList();
    }
    PodFailurePolicyOnPodConditionsPatternBuilder builder = new PodFailurePolicyOnPodConditionsPatternBuilder(item);
    if (index < 0 || index >= onPodConditions.size()) {
        _visitables.get("onPodConditions").add(builder);
        onPodConditions.add(builder);
    } else {
        _visitables.get("onPodConditions").add(builder);
        onPodConditions.add(index, builder);
    }
    return (A) this;
  }
  
  public PodFailurePolicyOnPodConditionsPattern buildFirstOnPodCondition() {
    return this.onPodConditions.get(0).build();
  }
  
  public PodFailurePolicyOnPodConditionsPattern buildLastOnPodCondition() {
    return this.onPodConditions.get(onPodConditions.size() - 1).build();
  }
  
  public PodFailurePolicyOnPodConditionsPattern buildMatchingOnPodCondition(Predicate<PodFailurePolicyOnPodConditionsPatternBuilder> predicate) {
      for (PodFailurePolicyOnPodConditionsPatternBuilder item : onPodConditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodFailurePolicyOnExitCodesRequirement buildOnExitCodes() {
    return this.onExitCodes != null ? this.onExitCodes.build() : null;
  }
  
  public PodFailurePolicyOnPodConditionsPattern buildOnPodCondition(int index) {
    return this.onPodConditions.get(index).build();
  }
  
  public List<PodFailurePolicyOnPodConditionsPattern> buildOnPodConditions() {
    return this.onPodConditions != null ? build(onPodConditions) : null;
  }
  
  protected void copyInstance(PodFailurePolicyRule instance) {
    instance = instance != null ? instance : new PodFailurePolicyRule();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withOnExitCodes(instance.getOnExitCodes());
        this.withOnPodConditions(instance.getOnPodConditions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OnPodConditionsNested<A> editFirstOnPodCondition() {
    if (onPodConditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "onPodConditions"));
    }
    return this.setNewOnPodConditionLike(0, this.buildOnPodCondition(0));
  }
  
  public OnPodConditionsNested<A> editLastOnPodCondition() {
    int index = onPodConditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "onPodConditions"));
    }
    return this.setNewOnPodConditionLike(index, this.buildOnPodCondition(index));
  }
  
  public OnPodConditionsNested<A> editMatchingOnPodCondition(Predicate<PodFailurePolicyOnPodConditionsPatternBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < onPodConditions.size();i++) {
      if (predicate.test(onPodConditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "onPodConditions"));
    }
    return this.setNewOnPodConditionLike(index, this.buildOnPodCondition(index));
  }
  
  public OnExitCodesNested<A> editOnExitCodes() {
    return this.withNewOnExitCodesLike(Optional.ofNullable(this.buildOnExitCodes()).orElse(null));
  }
  
  public OnPodConditionsNested<A> editOnPodCondition(int index) {
    if (onPodConditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "onPodConditions"));
    }
    return this.setNewOnPodConditionLike(index, this.buildOnPodCondition(index));
  }
  
  public OnExitCodesNested<A> editOrNewOnExitCodes() {
    return this.withNewOnExitCodesLike(Optional.ofNullable(this.buildOnExitCodes()).orElse(new PodFailurePolicyOnExitCodesRequirementBuilder().build()));
  }
  
  public OnExitCodesNested<A> editOrNewOnExitCodesLike(PodFailurePolicyOnExitCodesRequirement item) {
    return this.withNewOnExitCodesLike(Optional.ofNullable(this.buildOnExitCodes()).orElse(item));
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
    PodFailurePolicyRuleFluent that = (PodFailurePolicyRuleFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(onExitCodes, that.onExitCodes))) {
      return false;
    }
    if (!(Objects.equals(onPodConditions, that.onPodConditions))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAction() {
    return this.action;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public boolean hasAction() {
    return this.action != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingOnPodCondition(Predicate<PodFailurePolicyOnPodConditionsPatternBuilder> predicate) {
      for (PodFailurePolicyOnPodConditionsPatternBuilder item : onPodConditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOnExitCodes() {
    return this.onExitCodes != null;
  }
  
  public boolean hasOnPodConditions() {
    return this.onPodConditions != null && !(this.onPodConditions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(action, onExitCodes, onPodConditions, additionalProperties);
  }
  
  public A removeAllFromOnPodConditions(Collection<PodFailurePolicyOnPodConditionsPattern> items) {
    if (this.onPodConditions == null) {
      return (A) this;
    }
    for (PodFailurePolicyOnPodConditionsPattern item : items) {
        PodFailurePolicyOnPodConditionsPatternBuilder builder = new PodFailurePolicyOnPodConditionsPatternBuilder(item);
        _visitables.get("onPodConditions").remove(builder);
        this.onPodConditions.remove(builder);
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
  
  public A removeFromOnPodConditions(PodFailurePolicyOnPodConditionsPattern... items) {
    if (this.onPodConditions == null) {
      return (A) this;
    }
    for (PodFailurePolicyOnPodConditionsPattern item : items) {
        PodFailurePolicyOnPodConditionsPatternBuilder builder = new PodFailurePolicyOnPodConditionsPatternBuilder(item);
        _visitables.get("onPodConditions").remove(builder);
        this.onPodConditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromOnPodConditions(Predicate<PodFailurePolicyOnPodConditionsPatternBuilder> predicate) {
    if (onPodConditions == null) {
      return (A) this;
    }
    Iterator<PodFailurePolicyOnPodConditionsPatternBuilder> each = onPodConditions.iterator();
    List visitables = _visitables.get("onPodConditions");
    while (each.hasNext()) {
        PodFailurePolicyOnPodConditionsPatternBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public OnPodConditionsNested<A> setNewOnPodConditionLike(int index,PodFailurePolicyOnPodConditionsPattern item) {
    return new OnPodConditionsNested(index, item);
  }
  
  public A setToOnPodConditions(int index,PodFailurePolicyOnPodConditionsPattern item) {
    if (this.onPodConditions == null) {
      this.onPodConditions = new ArrayList();
    }
    PodFailurePolicyOnPodConditionsPatternBuilder builder = new PodFailurePolicyOnPodConditionsPatternBuilder(item);
    if (index < 0 || index >= onPodConditions.size()) {
        _visitables.get("onPodConditions").add(builder);
        onPodConditions.add(builder);
    } else {
        _visitables.get("onPodConditions").add(builder);
        onPodConditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(action == null)) {
        sb.append("action:");
        sb.append(action);
        sb.append(",");
    }
    if (!(onExitCodes == null)) {
        sb.append("onExitCodes:");
        sb.append(onExitCodes);
        sb.append(",");
    }
    if (!(onPodConditions == null) && !(onPodConditions.isEmpty())) {
        sb.append("onPodConditions:");
        sb.append(onPodConditions);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAction(String action) {
    this.action = action;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public OnExitCodesNested<A> withNewOnExitCodes() {
    return new OnExitCodesNested(null);
  }
  
  public OnExitCodesNested<A> withNewOnExitCodesLike(PodFailurePolicyOnExitCodesRequirement item) {
    return new OnExitCodesNested(item);
  }
  
  public A withOnExitCodes(PodFailurePolicyOnExitCodesRequirement onExitCodes) {
    this._visitables.remove("onExitCodes");
    if (onExitCodes != null) {
        this.onExitCodes = new PodFailurePolicyOnExitCodesRequirementBuilder(onExitCodes);
        this._visitables.get("onExitCodes").add(this.onExitCodes);
    } else {
        this.onExitCodes = null;
        this._visitables.get("onExitCodes").remove(this.onExitCodes);
    }
    return (A) this;
  }
  
  public A withOnPodConditions(List<PodFailurePolicyOnPodConditionsPattern> onPodConditions) {
    if (this.onPodConditions != null) {
      this._visitables.get("onPodConditions").clear();
    }
    if (onPodConditions != null) {
        this.onPodConditions = new ArrayList();
        for (PodFailurePolicyOnPodConditionsPattern item : onPodConditions) {
          this.addToOnPodConditions(item);
        }
    } else {
      this.onPodConditions = null;
    }
    return (A) this;
  }
  
  public A withOnPodConditions(PodFailurePolicyOnPodConditionsPattern... onPodConditions) {
    if (this.onPodConditions != null) {
        this.onPodConditions.clear();
        _visitables.remove("onPodConditions");
    }
    if (onPodConditions != null) {
      for (PodFailurePolicyOnPodConditionsPattern item : onPodConditions) {
        this.addToOnPodConditions(item);
      }
    }
    return (A) this;
  }
  public class OnExitCodesNested<N> extends PodFailurePolicyOnExitCodesRequirementFluent<OnExitCodesNested<N>> implements Nested<N>{
  
    PodFailurePolicyOnExitCodesRequirementBuilder builder;
  
    OnExitCodesNested(PodFailurePolicyOnExitCodesRequirement item) {
      this.builder = new PodFailurePolicyOnExitCodesRequirementBuilder(this, item);
    }
  
    public N and() {
      return (N) PodFailurePolicyRuleFluent.this.withOnExitCodes(builder.build());
    }
    
    public N endOnExitCodes() {
      return and();
    }
    
  }
  public class OnPodConditionsNested<N> extends PodFailurePolicyOnPodConditionsPatternFluent<OnPodConditionsNested<N>> implements Nested<N>{
  
    PodFailurePolicyOnPodConditionsPatternBuilder builder;
    int index;
  
    OnPodConditionsNested(int index,PodFailurePolicyOnPodConditionsPattern item) {
      this.index = index;
      this.builder = new PodFailurePolicyOnPodConditionsPatternBuilder(this, item);
    }
  
    public N and() {
      return (N) PodFailurePolicyRuleFluent.this.setToOnPodConditions(index, builder.build());
    }
    
    public N endOnPodCondition() {
      return and();
    }
    
  }
}