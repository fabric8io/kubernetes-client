package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class RelabelConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.RelabelConfigFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private Long modulus;
  private String regex;
  private String replacement;
  private String separator;
  private List<String> sourceLabels = new ArrayList<String>();
  private String targetLabel;

  public RelabelConfigFluent() {
  }
  
  public RelabelConfigFluent(RelabelConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToSourceLabels(Collection<String> items) {
    if (this.sourceLabels == null) {
      this.sourceLabels = new ArrayList();
    }
    for (String item : items) {
      this.sourceLabels.add(item);
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
  
  public A addToSourceLabels(String... items) {
    if (this.sourceLabels == null) {
      this.sourceLabels = new ArrayList();
    }
    for (String item : items) {
      this.sourceLabels.add(item);
    }
    return (A) this;
  }
  
  public A addToSourceLabels(int index,String item) {
    if (this.sourceLabels == null) {
      this.sourceLabels = new ArrayList();
    }
    this.sourceLabels.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(RelabelConfig instance) {
    instance = instance != null ? instance : new RelabelConfig();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withModulus(instance.getModulus());
        this.withRegex(instance.getRegex());
        this.withReplacement(instance.getReplacement());
        this.withSeparator(instance.getSeparator());
        this.withSourceLabels(instance.getSourceLabels());
        this.withTargetLabel(instance.getTargetLabel());
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
    RelabelConfigFluent that = (RelabelConfigFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(modulus, that.modulus))) {
      return false;
    }
    if (!(Objects.equals(regex, that.regex))) {
      return false;
    }
    if (!(Objects.equals(replacement, that.replacement))) {
      return false;
    }
    if (!(Objects.equals(separator, that.separator))) {
      return false;
    }
    if (!(Objects.equals(sourceLabels, that.sourceLabels))) {
      return false;
    }
    if (!(Objects.equals(targetLabel, that.targetLabel))) {
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
  
  public String getFirstSourceLabel() {
    return this.sourceLabels.get(0);
  }
  
  public String getLastSourceLabel() {
    return this.sourceLabels.get(sourceLabels.size() - 1);
  }
  
  public String getMatchingSourceLabel(Predicate<String> predicate) {
      for (String item : sourceLabels) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getModulus() {
    return this.modulus;
  }
  
  public String getRegex() {
    return this.regex;
  }
  
  public String getReplacement() {
    return this.replacement;
  }
  
  public String getSeparator() {
    return this.separator;
  }
  
  public String getSourceLabel(int index) {
    return this.sourceLabels.get(index);
  }
  
  public List<String> getSourceLabels() {
    return this.sourceLabels;
  }
  
  public String getTargetLabel() {
    return this.targetLabel;
  }
  
  public boolean hasAction() {
    return this.action != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingSourceLabel(Predicate<String> predicate) {
      for (String item : sourceLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasModulus() {
    return this.modulus != null;
  }
  
  public boolean hasRegex() {
    return this.regex != null;
  }
  
  public boolean hasReplacement() {
    return this.replacement != null;
  }
  
  public boolean hasSeparator() {
    return this.separator != null;
  }
  
  public boolean hasSourceLabels() {
    return this.sourceLabels != null && !(this.sourceLabels.isEmpty());
  }
  
  public boolean hasTargetLabel() {
    return this.targetLabel != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, modulus, regex, replacement, separator, sourceLabels, targetLabel, additionalProperties);
  }
  
  public A removeAllFromSourceLabels(Collection<String> items) {
    if (this.sourceLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.sourceLabels.remove(item);
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
  
  public A removeFromSourceLabels(String... items) {
    if (this.sourceLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.sourceLabels.remove(item);
    }
    return (A) this;
  }
  
  public A setToSourceLabels(int index,String item) {
    if (this.sourceLabels == null) {
      this.sourceLabels = new ArrayList();
    }
    this.sourceLabels.set(index, item);
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
    if (!(modulus == null)) {
        sb.append("modulus:");
        sb.append(modulus);
        sb.append(",");
    }
    if (!(regex == null)) {
        sb.append("regex:");
        sb.append(regex);
        sb.append(",");
    }
    if (!(replacement == null)) {
        sb.append("replacement:");
        sb.append(replacement);
        sb.append(",");
    }
    if (!(separator == null)) {
        sb.append("separator:");
        sb.append(separator);
        sb.append(",");
    }
    if (!(sourceLabels == null) && !(sourceLabels.isEmpty())) {
        sb.append("sourceLabels:");
        sb.append(sourceLabels);
        sb.append(",");
    }
    if (!(targetLabel == null)) {
        sb.append("targetLabel:");
        sb.append(targetLabel);
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
  
  public A withModulus(Long modulus) {
    this.modulus = modulus;
    return (A) this;
  }
  
  public A withRegex(String regex) {
    this.regex = regex;
    return (A) this;
  }
  
  public A withReplacement(String replacement) {
    this.replacement = replacement;
    return (A) this;
  }
  
  public A withSeparator(String separator) {
    this.separator = separator;
    return (A) this;
  }
  
  public A withSourceLabels(List<String> sourceLabels) {
    if (sourceLabels != null) {
        this.sourceLabels = new ArrayList();
        for (String item : sourceLabels) {
          this.addToSourceLabels(item);
        }
    } else {
      this.sourceLabels = null;
    }
    return (A) this;
  }
  
  public A withSourceLabels(String... sourceLabels) {
    if (this.sourceLabels != null) {
        this.sourceLabels.clear();
        _visitables.remove("sourceLabels");
    }
    if (sourceLabels != null) {
      for (String item : sourceLabels) {
        this.addToSourceLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withTargetLabel(String targetLabel) {
    this.targetLabel = targetLabel;
    return (A) this;
  }
  
}