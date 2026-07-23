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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PipelineRunRunStatusFluent<A extends io.fabric8.tekton.v1beta1.PipelineRunRunStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String pipelineTaskName;
  private CustomRunStatusBuilder status;
  private ArrayList<WhenExpressionBuilder> whenExpressions = new ArrayList<WhenExpressionBuilder>();

  public PipelineRunRunStatusFluent() {
  }
  
  public PipelineRunRunStatusFluent(PipelineRunRunStatus instance) {
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
  
  public CustomRunStatus buildStatus() {
    return this.status != null ? this.status.build() : null;
  }
  
  public WhenExpression buildWhenExpression(int index) {
    return this.whenExpressions.get(index).build();
  }
  
  public List<WhenExpression> buildWhenExpressions() {
    return this.whenExpressions != null ? build(whenExpressions) : null;
  }
  
  protected void copyInstance(PipelineRunRunStatus instance) {
    instance = instance != null ? instance : new PipelineRunRunStatus();
    if (instance != null) {
        this.withPipelineTaskName(instance.getPipelineTaskName());
        this.withStatus(instance.getStatus());
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
  
  public StatusNested<A> editOrNewStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(new CustomRunStatusBuilder().build()));
  }
  
  public StatusNested<A> editOrNewStatusLike(CustomRunStatus item) {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(item));
  }
  
  public StatusNested<A> editStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(null));
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
    PipelineRunRunStatusFluent that = (PipelineRunRunStatusFluent) o;
    if (!(Objects.equals(pipelineTaskName, that.pipelineTaskName))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
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
  
  public String getPipelineTaskName() {
    return this.pipelineTaskName;
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
  
  public boolean hasPipelineTaskName() {
    return this.pipelineTaskName != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasWhenExpressions() {
    return this.whenExpressions != null && !(this.whenExpressions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(pipelineTaskName, status, whenExpressions, additionalProperties);
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
    if (!(pipelineTaskName == null)) {
        sb.append("pipelineTaskName:");
        sb.append(pipelineTaskName);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
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
  
  public StatusNested<A> withNewStatus() {
    return new StatusNested(null);
  }
  
  public StatusNested<A> withNewStatusLike(CustomRunStatus item) {
    return new StatusNested(item);
  }
  
  public A withPipelineTaskName(String pipelineTaskName) {
    this.pipelineTaskName = pipelineTaskName;
    return (A) this;
  }
  
  public A withStatus(CustomRunStatus status) {
    this._visitables.remove("status");
    if (status != null) {
        this.status = new CustomRunStatusBuilder(status);
        this._visitables.get("status").add(this.status);
    } else {
        this.status = null;
        this._visitables.get("status").remove(this.status);
    }
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
  public class StatusNested<N> extends CustomRunStatusFluent<StatusNested<N>> implements Nested<N>{
  
    CustomRunStatusBuilder builder;
  
    StatusNested(CustomRunStatus item) {
      this.builder = new CustomRunStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunRunStatusFluent.this.withStatus(builder.build());
    }
    
    public N endStatus() {
      return and();
    }
    
  }
  public class WhenExpressionsNested<N> extends WhenExpressionFluent<WhenExpressionsNested<N>> implements Nested<N>{
  
    WhenExpressionBuilder builder;
    int index;
  
    WhenExpressionsNested(int index,WhenExpression item) {
      this.index = index;
      this.builder = new WhenExpressionBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineRunRunStatusFluent.this.setToWhenExpressions(index, builder.build());
    }
    
    public N endWhenExpression() {
      return and();
    }
    
  }
}