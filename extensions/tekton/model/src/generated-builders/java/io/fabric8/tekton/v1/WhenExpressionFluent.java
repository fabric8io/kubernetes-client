package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class WhenExpressionFluent<A extends io.fabric8.tekton.v1.WhenExpressionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cel;
  private String input;
  private String operator;
  private List<String> values = new ArrayList<String>();

  public WhenExpressionFluent() {
  }
  
  public WhenExpressionFluent(WhenExpression instance) {
    this.copyInstance(instance);
  }

  public A addAllToValues(Collection<String> items) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    for (String item : items) {
      this.values.add(item);
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
  
  public A addToValues(String... items) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    for (String item : items) {
      this.values.add(item);
    }
    return (A) this;
  }
  
  public A addToValues(int index,String item) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    this.values.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(WhenExpression instance) {
    instance = instance != null ? instance : new WhenExpression();
    if (instance != null) {
        this.withCel(instance.getCel());
        this.withInput(instance.getInput());
        this.withOperator(instance.getOperator());
        this.withValues(instance.getValues());
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
    WhenExpressionFluent that = (WhenExpressionFluent) o;
    if (!(Objects.equals(cel, that.cel))) {
      return false;
    }
    if (!(Objects.equals(input, that.input))) {
      return false;
    }
    if (!(Objects.equals(operator, that.operator))) {
      return false;
    }
    if (!(Objects.equals(values, that.values))) {
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
  
  public String getCel() {
    return this.cel;
  }
  
  public String getFirstValue() {
    return this.values.get(0);
  }
  
  public String getInput() {
    return this.input;
  }
  
  public String getLastValue() {
    return this.values.get(values.size() - 1);
  }
  
  public String getMatchingValue(Predicate<String> predicate) {
      for (String item : values) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOperator() {
    return this.operator;
  }
  
  public String getValue(int index) {
    return this.values.get(index);
  }
  
  public List<String> getValues() {
    return this.values;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCel() {
    return this.cel != null;
  }
  
  public boolean hasInput() {
    return this.input != null;
  }
  
  public boolean hasMatchingValue(Predicate<String> predicate) {
      for (String item : values) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOperator() {
    return this.operator != null;
  }
  
  public boolean hasValues() {
    return this.values != null && !(this.values.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(cel, input, operator, values, additionalProperties);
  }
  
  public A removeAllFromValues(Collection<String> items) {
    if (this.values == null) {
      return (A) this;
    }
    for (String item : items) {
      this.values.remove(item);
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
  
  public A removeFromValues(String... items) {
    if (this.values == null) {
      return (A) this;
    }
    for (String item : items) {
      this.values.remove(item);
    }
    return (A) this;
  }
  
  public A setToValues(int index,String item) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    this.values.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cel == null)) {
        sb.append("cel:");
        sb.append(cel);
        sb.append(",");
    }
    if (!(input == null)) {
        sb.append("input:");
        sb.append(input);
        sb.append(",");
    }
    if (!(operator == null)) {
        sb.append("operator:");
        sb.append(operator);
        sb.append(",");
    }
    if (!(values == null) && !(values.isEmpty())) {
        sb.append("values:");
        sb.append(values);
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
  
  public A withCel(String cel) {
    this.cel = cel;
    return (A) this;
  }
  
  public A withInput(String input) {
    this.input = input;
    return (A) this;
  }
  
  public A withOperator(String operator) {
    this.operator = operator;
    return (A) this;
  }
  
  public A withValues(List<String> values) {
    if (values != null) {
        this.values = new ArrayList();
        for (String item : values) {
          this.addToValues(item);
        }
    } else {
      this.values = null;
    }
    return (A) this;
  }
  
  public A withValues(String... values) {
    if (this.values != null) {
        this.values.clear();
        _visitables.remove("values");
    }
    if (values != null) {
      for (String item : values) {
        this.addToValues(item);
      }
    }
    return (A) this;
  }
  
}