package io.fabric8.tekton.v1;

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
public class ChildStatusReferenceFluent<A extends io.fabric8.tekton.v1.ChildStatusReferenceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String displayName;
  private String kind;
  private String name;
  private String pipelineTaskName;
  private ArrayList<WhenExpressionBuilder> whenExpressions = new ArrayList<WhenExpressionBuilder>();

  public ChildStatusReferenceFluent() {
  }
  
  public ChildStatusReferenceFluent(ChildStatusReference instance) {
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
  
  protected void copyInstance(ChildStatusReference instance) {
    instance = instance != null ? instance : new ChildStatusReference();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withDisplayName(instance.getDisplayName());
        this.withKind(instance.getKind());
        this.withName(instance.getName());
        this.withPipelineTaskName(instance.getPipelineTaskName());
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
    ChildStatusReferenceFluent that = (ChildStatusReferenceFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(pipelineTaskName, that.pipelineTaskName))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getPipelineTaskName() {
    return this.pipelineTaskName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
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
  
  public boolean hasPipelineTaskName() {
    return this.pipelineTaskName != null;
  }
  
  public boolean hasWhenExpressions() {
    return this.whenExpressions != null && !(this.whenExpressions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, displayName, kind, name, pipelineTaskName, whenExpressions, additionalProperties);
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
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(displayName == null)) {
        sb.append("displayName:");
        sb.append(displayName);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(pipelineTaskName == null)) {
        sb.append("pipelineTaskName:");
        sb.append(pipelineTaskName);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withDisplayName(String displayName) {
    this.displayName = displayName;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withPipelineTaskName(String pipelineTaskName) {
    this.pipelineTaskName = pipelineTaskName;
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
      return (N) ChildStatusReferenceFluent.this.setToWhenExpressions(index, builder.build());
    }
    
    public N endWhenExpression() {
      return and();
    }
    
  }
}