package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class RuleFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.RuleFluent<A>> extends BaseFluent<A>{

  private String _for;
  private Map<String,Object> additionalProperties;
  private String alert;
  private Map<String,String> annotations;
  private IntOrStringBuilder expr;
  private String keepFiringFor;
  private Map<String,String> labels;
  private String record;

  public RuleFluent() {
  }
  
  public RuleFluent(Rule instance) {
    this.copyInstance(instance);
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
  
  public A addToAnnotations(Map<String,String> map) {
    if (this.annotations == null && map != null) {
      this.annotations = new LinkedHashMap();
    }
    if (map != null) {
      this.annotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAnnotations(String key,String value) {
    if (this.annotations == null && key != null && value != null) {
      this.annotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.annotations.put(key, value);
    }
    return (A) this;
  }
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public IntOrString buildExpr() {
    return this.expr != null ? this.expr.build() : null;
  }
  
  protected void copyInstance(Rule instance) {
    instance = instance != null ? instance : new Rule();
    if (instance != null) {
        this.withAlert(instance.getAlert());
        this.withAnnotations(instance.getAnnotations());
        this.withExpr(instance.getExpr());
        this.withFor(instance.getFor());
        this.withKeepFiringFor(instance.getKeepFiringFor());
        this.withLabels(instance.getLabels());
        this.withRecord(instance.getRecord());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExprNested<A> editExpr() {
    return this.withNewExprLike(Optional.ofNullable(this.buildExpr()).orElse(null));
  }
  
  public ExprNested<A> editOrNewExpr() {
    return this.withNewExprLike(Optional.ofNullable(this.buildExpr()).orElse(new IntOrStringBuilder().build()));
  }
  
  public ExprNested<A> editOrNewExprLike(IntOrString item) {
    return this.withNewExprLike(Optional.ofNullable(this.buildExpr()).orElse(item));
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
    RuleFluent that = (RuleFluent) o;
    if (!(Objects.equals(alert, that.alert))) {
      return false;
    }
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(expr, that.expr))) {
      return false;
    }
    if (!(Objects.equals(_for, that._for))) {
      return false;
    }
    if (!(Objects.equals(keepFiringFor, that.keepFiringFor))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(record, that.record))) {
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
  
  public String getAlert() {
    return this.alert;
  }
  
  public Map<String,String> getAnnotations() {
    return this.annotations;
  }
  
  public String getFor() {
    return this._for;
  }
  
  public String getKeepFiringFor() {
    return this.keepFiringFor;
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public String getRecord() {
    return this.record;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAlert() {
    return this.alert != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasExpr() {
    return this.expr != null;
  }
  
  public boolean hasFor() {
    return this._for != null;
  }
  
  public boolean hasKeepFiringFor() {
    return this.keepFiringFor != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasRecord() {
    return this.record != null;
  }
  
  public int hashCode() {
    return Objects.hash(alert, annotations, expr, _for, keepFiringFor, labels, record, additionalProperties);
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
  
  public A removeFromAnnotations(String key) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (key != null && this.annotations != null) {
      this.annotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAnnotations(Map<String,String> map) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.annotations != null) {
          this.annotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(alert == null)) {
        sb.append("alert:");
        sb.append(alert);
        sb.append(",");
    }
    if (!(annotations == null) && !(annotations.isEmpty())) {
        sb.append("annotations:");
        sb.append(annotations);
        sb.append(",");
    }
    if (!(expr == null)) {
        sb.append("expr:");
        sb.append(expr);
        sb.append(",");
    }
    if (!(_for == null)) {
        sb.append("_for:");
        sb.append(_for);
        sb.append(",");
    }
    if (!(keepFiringFor == null)) {
        sb.append("keepFiringFor:");
        sb.append(keepFiringFor);
        sb.append(",");
    }
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(record == null)) {
        sb.append("record:");
        sb.append(record);
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
  
  public A withAlert(String alert) {
    this.alert = alert;
    return (A) this;
  }
  
  public <K,V>A withAnnotations(Map<String,String> annotations) {
    if (annotations == null) {
      this.annotations = null;
    } else {
      this.annotations = new LinkedHashMap(annotations);
    }
    return (A) this;
  }
  
  public A withExpr(IntOrString expr) {
    this._visitables.remove("expr");
    if (expr != null) {
        this.expr = new IntOrStringBuilder(expr);
        this._visitables.get("expr").add(this.expr);
    } else {
        this.expr = null;
        this._visitables.get("expr").remove(this.expr);
    }
    return (A) this;
  }
  
  public A withFor(String _for) {
    this._for = _for;
    return (A) this;
  }
  
  public A withKeepFiringFor(String keepFiringFor) {
    this.keepFiringFor = keepFiringFor;
    return (A) this;
  }
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public ExprNested<A> withNewExpr() {
    return new ExprNested(null);
  }
  
  public A withNewExpr(Object value) {
    return (A) this.withExpr(new IntOrString(value));
  }
  
  public ExprNested<A> withNewExprLike(IntOrString item) {
    return new ExprNested(item);
  }
  
  public A withRecord(String record) {
    this.record = record;
    return (A) this;
  }
  public class ExprNested<N> extends IntOrStringFluent<ExprNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    ExprNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) RuleFluent.this.withExpr(builder.build());
    }
    
    public N endExpr() {
      return and();
    }
    
  }
}