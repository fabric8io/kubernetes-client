package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.LabelSelectorRequirement;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class EventPolicySelectorFluent<A extends io.fabric8.knative.eventing.v1alpha1.EventPolicySelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private List<LabelSelectorRequirement> matchExpressions = new ArrayList<LabelSelectorRequirement>();
  private Map<String,String> matchLabels;

  public EventPolicySelectorFluent() {
  }
  
  public EventPolicySelectorFluent(EventPolicySelector instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatchExpressions(Collection<LabelSelectorRequirement> items) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    for (LabelSelectorRequirement item : items) {
      this.matchExpressions.add(item);
    }
    return (A) this;
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
  
  public A addToMatchExpressions(LabelSelectorRequirement... items) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    for (LabelSelectorRequirement item : items) {
      this.matchExpressions.add(item);
    }
    return (A) this;
  }
  
  public A addToMatchExpressions(int index,LabelSelectorRequirement item) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    this.matchExpressions.add(index, item);
    return (A) this;
  }
  
  public A addToMatchLabels(Map<String,String> map) {
    if (this.matchLabels == null && map != null) {
      this.matchLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.matchLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMatchLabels(String key,String value) {
    if (this.matchLabels == null && key != null && value != null) {
      this.matchLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.matchLabels.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(EventPolicySelector instance) {
    instance = instance != null ? instance : new EventPolicySelector();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withMatchExpressions(instance.getMatchExpressions());
        this.withMatchLabels(instance.getMatchLabels());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    EventPolicySelectorFluent that = (EventPolicySelectorFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(matchExpressions, that.matchExpressions))) {
      return false;
    }
    if (!(Objects.equals(matchLabels, that.matchLabels))) {
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
  
  public LabelSelectorRequirement getFirstMatchExpression() {
    return this.matchExpressions.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public LabelSelectorRequirement getLastMatchExpression() {
    return this.matchExpressions.get(matchExpressions.size() - 1);
  }
  
  public LabelSelectorRequirement getMatchExpression(int index) {
    return this.matchExpressions.get(index);
  }
  
  public List<LabelSelectorRequirement> getMatchExpressions() {
    return this.matchExpressions;
  }
  
  public Map<String,String> getMatchLabels() {
    return this.matchLabels;
  }
  
  public LabelSelectorRequirement getMatchingMatchExpression(Predicate<LabelSelectorRequirement> predicate) {
      for (LabelSelectorRequirement item : matchExpressions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchExpressions() {
    return this.matchExpressions != null && !(this.matchExpressions.isEmpty());
  }
  
  public boolean hasMatchLabels() {
    return this.matchLabels != null;
  }
  
  public boolean hasMatchingMatchExpression(Predicate<LabelSelectorRequirement> predicate) {
      for (LabelSelectorRequirement item : matchExpressions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, matchExpressions, matchLabels, additionalProperties);
  }
  
  public A removeAllFromMatchExpressions(Collection<LabelSelectorRequirement> items) {
    if (this.matchExpressions == null) {
      return (A) this;
    }
    for (LabelSelectorRequirement item : items) {
      this.matchExpressions.remove(item);
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
  
  public A removeFromMatchExpressions(LabelSelectorRequirement... items) {
    if (this.matchExpressions == null) {
      return (A) this;
    }
    for (LabelSelectorRequirement item : items) {
      this.matchExpressions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMatchLabels(String key) {
    if (this.matchLabels == null) {
      return (A) this;
    }
    if (key != null && this.matchLabels != null) {
      this.matchLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMatchLabels(Map<String,String> map) {
    if (this.matchLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.matchLabels != null) {
          this.matchLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToMatchExpressions(int index,LabelSelectorRequirement item) {
    if (this.matchExpressions == null) {
      this.matchExpressions = new ArrayList();
    }
    this.matchExpressions.set(index, item);
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
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(matchExpressions == null) && !(matchExpressions.isEmpty())) {
        sb.append("matchExpressions:");
        sb.append(matchExpressions);
        sb.append(",");
    }
    if (!(matchLabels == null) && !(matchLabels.isEmpty())) {
        sb.append("matchLabels:");
        sb.append(matchLabels);
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
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMatchExpressions(List<LabelSelectorRequirement> matchExpressions) {
    if (matchExpressions != null) {
        this.matchExpressions = new ArrayList();
        for (LabelSelectorRequirement item : matchExpressions) {
          this.addToMatchExpressions(item);
        }
    } else {
      this.matchExpressions = null;
    }
    return (A) this;
  }
  
  public A withMatchExpressions(LabelSelectorRequirement... matchExpressions) {
    if (this.matchExpressions != null) {
        this.matchExpressions.clear();
        _visitables.remove("matchExpressions");
    }
    if (matchExpressions != null) {
      for (LabelSelectorRequirement item : matchExpressions) {
        this.addToMatchExpressions(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withMatchLabels(Map<String,String> matchLabels) {
    if (matchLabels == null) {
      this.matchLabels = null;
    } else {
      this.matchLabels = new LinkedHashMap(matchLabels);
    }
    return (A) this;
  }
  
}