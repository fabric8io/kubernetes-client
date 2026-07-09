package io.fabric8.kubernetes.api.model.admissionregistration.v1;

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
public class TypeCheckingFluent<A extends io.fabric8.kubernetes.api.model.admissionregistration.v1.TypeCheckingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ExpressionWarningBuilder> expressionWarnings = new ArrayList<ExpressionWarningBuilder>();

  public TypeCheckingFluent() {
  }
  
  public TypeCheckingFluent(TypeChecking instance) {
    this.copyInstance(instance);
  }

  public A addAllToExpressionWarnings(Collection<ExpressionWarning> items) {
    if (this.expressionWarnings == null) {
      this.expressionWarnings = new ArrayList();
    }
    for (ExpressionWarning item : items) {
        ExpressionWarningBuilder builder = new ExpressionWarningBuilder(item);
        _visitables.get("expressionWarnings").add(builder);
        this.expressionWarnings.add(builder);
    }
    return (A) this;
  }
  
  public ExpressionWarningsNested<A> addNewExpressionWarning() {
    return new ExpressionWarningsNested(-1, null);
  }
  
  public A addNewExpressionWarning(String fieldRef,String warning) {
    return (A) this.addToExpressionWarnings(new ExpressionWarning(fieldRef, warning));
  }
  
  public ExpressionWarningsNested<A> addNewExpressionWarningLike(ExpressionWarning item) {
    return new ExpressionWarningsNested(-1, item);
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
  
  public A addToExpressionWarnings(ExpressionWarning... items) {
    if (this.expressionWarnings == null) {
      this.expressionWarnings = new ArrayList();
    }
    for (ExpressionWarning item : items) {
        ExpressionWarningBuilder builder = new ExpressionWarningBuilder(item);
        _visitables.get("expressionWarnings").add(builder);
        this.expressionWarnings.add(builder);
    }
    return (A) this;
  }
  
  public A addToExpressionWarnings(int index,ExpressionWarning item) {
    if (this.expressionWarnings == null) {
      this.expressionWarnings = new ArrayList();
    }
    ExpressionWarningBuilder builder = new ExpressionWarningBuilder(item);
    if (index < 0 || index >= expressionWarnings.size()) {
        _visitables.get("expressionWarnings").add(builder);
        expressionWarnings.add(builder);
    } else {
        _visitables.get("expressionWarnings").add(builder);
        expressionWarnings.add(index, builder);
    }
    return (A) this;
  }
  
  public ExpressionWarning buildExpressionWarning(int index) {
    return this.expressionWarnings.get(index).build();
  }
  
  public List<ExpressionWarning> buildExpressionWarnings() {
    return this.expressionWarnings != null ? build(expressionWarnings) : null;
  }
  
  public ExpressionWarning buildFirstExpressionWarning() {
    return this.expressionWarnings.get(0).build();
  }
  
  public ExpressionWarning buildLastExpressionWarning() {
    return this.expressionWarnings.get(expressionWarnings.size() - 1).build();
  }
  
  public ExpressionWarning buildMatchingExpressionWarning(Predicate<ExpressionWarningBuilder> predicate) {
      for (ExpressionWarningBuilder item : expressionWarnings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(TypeChecking instance) {
    instance = instance != null ? instance : new TypeChecking();
    if (instance != null) {
        this.withExpressionWarnings(instance.getExpressionWarnings());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExpressionWarningsNested<A> editExpressionWarning(int index) {
    if (expressionWarnings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "expressionWarnings"));
    }
    return this.setNewExpressionWarningLike(index, this.buildExpressionWarning(index));
  }
  
  public ExpressionWarningsNested<A> editFirstExpressionWarning() {
    if (expressionWarnings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "expressionWarnings"));
    }
    return this.setNewExpressionWarningLike(0, this.buildExpressionWarning(0));
  }
  
  public ExpressionWarningsNested<A> editLastExpressionWarning() {
    int index = expressionWarnings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "expressionWarnings"));
    }
    return this.setNewExpressionWarningLike(index, this.buildExpressionWarning(index));
  }
  
  public ExpressionWarningsNested<A> editMatchingExpressionWarning(Predicate<ExpressionWarningBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < expressionWarnings.size();i++) {
      if (predicate.test(expressionWarnings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "expressionWarnings"));
    }
    return this.setNewExpressionWarningLike(index, this.buildExpressionWarning(index));
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
    TypeCheckingFluent that = (TypeCheckingFluent) o;
    if (!(Objects.equals(expressionWarnings, that.expressionWarnings))) {
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
  
  public boolean hasExpressionWarnings() {
    return this.expressionWarnings != null && !(this.expressionWarnings.isEmpty());
  }
  
  public boolean hasMatchingExpressionWarning(Predicate<ExpressionWarningBuilder> predicate) {
      for (ExpressionWarningBuilder item : expressionWarnings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(expressionWarnings, additionalProperties);
  }
  
  public A removeAllFromExpressionWarnings(Collection<ExpressionWarning> items) {
    if (this.expressionWarnings == null) {
      return (A) this;
    }
    for (ExpressionWarning item : items) {
        ExpressionWarningBuilder builder = new ExpressionWarningBuilder(item);
        _visitables.get("expressionWarnings").remove(builder);
        this.expressionWarnings.remove(builder);
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
  
  public A removeFromExpressionWarnings(ExpressionWarning... items) {
    if (this.expressionWarnings == null) {
      return (A) this;
    }
    for (ExpressionWarning item : items) {
        ExpressionWarningBuilder builder = new ExpressionWarningBuilder(item);
        _visitables.get("expressionWarnings").remove(builder);
        this.expressionWarnings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromExpressionWarnings(Predicate<ExpressionWarningBuilder> predicate) {
    if (expressionWarnings == null) {
      return (A) this;
    }
    Iterator<ExpressionWarningBuilder> each = expressionWarnings.iterator();
    List visitables = _visitables.get("expressionWarnings");
    while (each.hasNext()) {
        ExpressionWarningBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ExpressionWarningsNested<A> setNewExpressionWarningLike(int index,ExpressionWarning item) {
    return new ExpressionWarningsNested(index, item);
  }
  
  public A setToExpressionWarnings(int index,ExpressionWarning item) {
    if (this.expressionWarnings == null) {
      this.expressionWarnings = new ArrayList();
    }
    ExpressionWarningBuilder builder = new ExpressionWarningBuilder(item);
    if (index < 0 || index >= expressionWarnings.size()) {
        _visitables.get("expressionWarnings").add(builder);
        expressionWarnings.add(builder);
    } else {
        _visitables.get("expressionWarnings").add(builder);
        expressionWarnings.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(expressionWarnings == null) && !(expressionWarnings.isEmpty())) {
        sb.append("expressionWarnings:");
        sb.append(expressionWarnings);
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
  
  public A withExpressionWarnings(List<ExpressionWarning> expressionWarnings) {
    if (this.expressionWarnings != null) {
      this._visitables.get("expressionWarnings").clear();
    }
    if (expressionWarnings != null) {
        this.expressionWarnings = new ArrayList();
        for (ExpressionWarning item : expressionWarnings) {
          this.addToExpressionWarnings(item);
        }
    } else {
      this.expressionWarnings = null;
    }
    return (A) this;
  }
  
  public A withExpressionWarnings(ExpressionWarning... expressionWarnings) {
    if (this.expressionWarnings != null) {
        this.expressionWarnings.clear();
        _visitables.remove("expressionWarnings");
    }
    if (expressionWarnings != null) {
      for (ExpressionWarning item : expressionWarnings) {
        this.addToExpressionWarnings(item);
      }
    }
    return (A) this;
  }
  public class ExpressionWarningsNested<N> extends ExpressionWarningFluent<ExpressionWarningsNested<N>> implements Nested<N>{
  
    ExpressionWarningBuilder builder;
    int index;
  
    ExpressionWarningsNested(int index,ExpressionWarning item) {
      this.index = index;
      this.builder = new ExpressionWarningBuilder(this, item);
    }
  
    public N and() {
      return (N) TypeCheckingFluent.this.setToExpressionWarnings(index, builder.build());
    }
    
    public N endExpressionWarning() {
      return and();
    }
    
  }
}