package io.fabric8.tekton.v1beta1;

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
public class SkippedTaskFluent<A extends io.fabric8.tekton.v1beta1.SkippedTaskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private String reason;
  private ArrayList<WhenExpressionBuilder> whenExpressions = new ArrayList<WhenExpressionBuilder>();

  public SkippedTaskFluent() {
  }
  
  public SkippedTaskFluent(SkippedTask instance) {
    this.copyInstance(instance);
  }

  public A addAllToWhenExpressions(Collection<WhenExpression> items) {
    if (this.whenExpressions == null) {
      this.whenExpressions = new ArrayList();
    }
    for (WhenExpression item : items) {
        WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
        _visitables.get("whenExpressions").add(builder);
        this.whenExpressions.add(builder);
    }
    return (A) this;
  }
  
  public WhenExpressionsNested<A> addNewWhenExpression() {
    return new WhenExpressionsNested(-1, null);
  }
  
  public WhenExpressionsNested<A> addNewWhenExpressionLike(WhenExpression item) {
    return new WhenExpressionsNested(-1, item);
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
  
  public A addToWhenExpressions(WhenExpression... items) {
    if (this.whenExpressions == null) {
      this.whenExpressions = new ArrayList();
    }
    for (WhenExpression item : items) {
        WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
        _visitables.get("whenExpressions").add(builder);
        this.whenExpressions.add(builder);
    }
    return (A) this;
  }
  
  public A addToWhenExpressions(int index,WhenExpression item) {
    if (this.whenExpressions == null) {
      this.whenExpressions = new ArrayList();
    }
    WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
    if (index < 0 || index >= whenExpressions.size()) {
        _visitables.get("whenExpressions").add(builder);
        whenExpressions.add(builder);
    } else {
        _visitables.get("whenExpressions").add(builder);
        whenExpressions.add(index, builder);
    }
    return (A) this;
  }
  
  public WhenExpression buildFirstWhenExpression() {
    return this.whenExpressions.get(0).build();
  }
  
  public WhenExpression buildLastWhenExpression() {
    return this.whenExpressions.get(whenExpressions.size() - 1).build();
  }
  
  public WhenExpression buildMatchingWhenExpression(Predicate<WhenExpressionBuilder> predicate) {
      for (WhenExpressionBuilder item : whenExpressions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public WhenExpression buildWhenExpression(int index) {
    return this.whenExpressions.get(index).build();
  }
  
  public List<WhenExpression> buildWhenExpressions() {
    return this.whenExpressions != null ? build(whenExpressions) : null;
  }
  
  protected void copyInstance(SkippedTask instance) {
    instance = instance != null ? instance : new SkippedTask();
    if (instance != null) {
        this.withName(instance.getName());
        this.withReason(instance.getReason());
        this.withWhenExpressions(instance.getWhenExpressions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public WhenExpressionsNested<A> editFirstWhenExpression() {
    if (whenExpressions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "whenExpressions"));
    }
    return this.setNewWhenExpressionLike(0, this.buildWhenExpression(0));
  }
  
  public WhenExpressionsNested<A> editLastWhenExpression() {
    int index = whenExpressions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "whenExpressions"));
    }
    return this.setNewWhenExpressionLike(index, this.buildWhenExpression(index));
  }
  
  public WhenExpressionsNested<A> editMatchingWhenExpression(Predicate<WhenExpressionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < whenExpressions.size();i++) {
      if (predicate.test(whenExpressions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "whenExpressions"));
    }
    return this.setNewWhenExpressionLike(index, this.buildWhenExpression(index));
  }
  
  public WhenExpressionsNested<A> editWhenExpression(int index) {
    if (whenExpressions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "whenExpressions"));
    }
    return this.setNewWhenExpressionLike(index, this.buildWhenExpression(index));
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
    SkippedTaskFluent that = (SkippedTaskFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(whenExpressions, that.whenExpressions))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingWhenExpression(Predicate<WhenExpressionBuilder> predicate) {
      for (WhenExpressionBuilder item : whenExpressions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasWhenExpressions() {
    return this.whenExpressions != null && !(this.whenExpressions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(name, reason, whenExpressions, additionalProperties);
  }
  
  public A removeAllFromWhenExpressions(Collection<WhenExpression> items) {
    if (this.whenExpressions == null) {
      return (A) this;
    }
    for (WhenExpression item : items) {
        WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
        _visitables.get("whenExpressions").remove(builder);
        this.whenExpressions.remove(builder);
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
  
  public A removeFromWhenExpressions(WhenExpression... items) {
    if (this.whenExpressions == null) {
      return (A) this;
    }
    for (WhenExpression item : items) {
        WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
        _visitables.get("whenExpressions").remove(builder);
        this.whenExpressions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromWhenExpressions(Predicate<WhenExpressionBuilder> predicate) {
    if (whenExpressions == null) {
      return (A) this;
    }
    Iterator<WhenExpressionBuilder> each = whenExpressions.iterator();
    List visitables = _visitables.get("whenExpressions");
    while (each.hasNext()) {
        WhenExpressionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public WhenExpressionsNested<A> setNewWhenExpressionLike(int index,WhenExpression item) {
    return new WhenExpressionsNested(index, item);
  }
  
  public A setToWhenExpressions(int index,WhenExpression item) {
    if (this.whenExpressions == null) {
      this.whenExpressions = new ArrayList();
    }
    WhenExpressionBuilder builder = new WhenExpressionBuilder(item);
    if (index < 0 || index >= whenExpressions.size()) {
        _visitables.get("whenExpressions").add(builder);
        whenExpressions.add(builder);
    } else {
        _visitables.get("whenExpressions").add(builder);
        whenExpressions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(whenExpressions == null) && !(whenExpressions.isEmpty())) {
        sb.append("whenExpressions:");
        sb.append(whenExpressions);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withWhenExpressions(List<WhenExpression> whenExpressions) {
    if (this.whenExpressions != null) {
      this._visitables.get("whenExpressions").clear();
    }
    if (whenExpressions != null) {
        this.whenExpressions = new ArrayList();
        for (WhenExpression item : whenExpressions) {
          this.addToWhenExpressions(item);
        }
    } else {
      this.whenExpressions = null;
    }
    return (A) this;
  }
  
  public A withWhenExpressions(WhenExpression... whenExpressions) {
    if (this.whenExpressions != null) {
        this.whenExpressions.clear();
        _visitables.remove("whenExpressions");
    }
    if (whenExpressions != null) {
      for (WhenExpression item : whenExpressions) {
        this.addToWhenExpressions(item);
      }
    }
    return (A) this;
  }
  public class WhenExpressionsNested<N> extends WhenExpressionFluent<WhenExpressionsNested<N>> implements Nested<N>{
  
    WhenExpressionBuilder builder;
    int index;
  
    WhenExpressionsNested(int index,WhenExpression item) {
      this.index = index;
      this.builder = new WhenExpressionBuilder(this, item);
    }
  
    public N and() {
      return (N) SkippedTaskFluent.this.setToWhenExpressions(index, builder.build());
    }
    
    public N endWhenExpression() {
      return and();
    }
    
  }
}