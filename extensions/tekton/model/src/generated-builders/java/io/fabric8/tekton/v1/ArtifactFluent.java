package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class ArtifactFluent<A extends io.fabric8.tekton.v1.ArtifactFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean buildOutput;
  private String name;
  private ArrayList<ArtifactValueBuilder> values = new ArrayList<ArtifactValueBuilder>();

  public ArtifactFluent() {
  }
  
  public ArtifactFluent(Artifact instance) {
    this.copyInstance(instance);
  }

  public A addAllToValues(Collection<ArtifactValue> items) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    for (ArtifactValue item : items) {
        ArtifactValueBuilder builder = new ArtifactValueBuilder(item);
        _visitables.get("values").add(builder);
        this.values.add(builder);
    }
    return (A) this;
  }
  
  public ValuesNested<A> addNewValue() {
    return new ValuesNested(-1, null);
  }
  
  public ValuesNested<A> addNewValueLike(ArtifactValue item) {
    return new ValuesNested(-1, item);
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
  
  public A addToValues(ArtifactValue... items) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    for (ArtifactValue item : items) {
        ArtifactValueBuilder builder = new ArtifactValueBuilder(item);
        _visitables.get("values").add(builder);
        this.values.add(builder);
    }
    return (A) this;
  }
  
  public A addToValues(int index,ArtifactValue item) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    ArtifactValueBuilder builder = new ArtifactValueBuilder(item);
    if (index < 0 || index >= values.size()) {
        _visitables.get("values").add(builder);
        values.add(builder);
    } else {
        _visitables.get("values").add(builder);
        values.add(index, builder);
    }
    return (A) this;
  }
  
  public ArtifactValue buildFirstValue() {
    return this.values.get(0).build();
  }
  
  public ArtifactValue buildLastValue() {
    return this.values.get(values.size() - 1).build();
  }
  
  public ArtifactValue buildMatchingValue(Predicate<ArtifactValueBuilder> predicate) {
      for (ArtifactValueBuilder item : values) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ArtifactValue buildValue(int index) {
    return this.values.get(index).build();
  }
  
  public List<ArtifactValue> buildValues() {
    return this.values != null ? build(values) : null;
  }
  
  protected void copyInstance(Artifact instance) {
    instance = instance != null ? instance : new Artifact();
    if (instance != null) {
        this.withBuildOutput(instance.getBuildOutput());
        this.withName(instance.getName());
        this.withValues(instance.getValues());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ValuesNested<A> editFirstValue() {
    if (values.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "values"));
    }
    return this.setNewValueLike(0, this.buildValue(0));
  }
  
  public ValuesNested<A> editLastValue() {
    int index = values.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "values"));
    }
    return this.setNewValueLike(index, this.buildValue(index));
  }
  
  public ValuesNested<A> editMatchingValue(Predicate<ArtifactValueBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < values.size();i++) {
      if (predicate.test(values.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "values"));
    }
    return this.setNewValueLike(index, this.buildValue(index));
  }
  
  public ValuesNested<A> editValue(int index) {
    if (values.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "values"));
    }
    return this.setNewValueLike(index, this.buildValue(index));
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
    ArtifactFluent that = (ArtifactFluent) o;
    if (!(Objects.equals(buildOutput, that.buildOutput))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public Boolean getBuildOutput() {
    return this.buildOutput;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBuildOutput() {
    return this.buildOutput != null;
  }
  
  public boolean hasMatchingValue(Predicate<ArtifactValueBuilder> predicate) {
      for (ArtifactValueBuilder item : values) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasValues() {
    return this.values != null && !(this.values.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(buildOutput, name, values, additionalProperties);
  }
  
  public A removeAllFromValues(Collection<ArtifactValue> items) {
    if (this.values == null) {
      return (A) this;
    }
    for (ArtifactValue item : items) {
        ArtifactValueBuilder builder = new ArtifactValueBuilder(item);
        _visitables.get("values").remove(builder);
        this.values.remove(builder);
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
  
  public A removeFromValues(ArtifactValue... items) {
    if (this.values == null) {
      return (A) this;
    }
    for (ArtifactValue item : items) {
        ArtifactValueBuilder builder = new ArtifactValueBuilder(item);
        _visitables.get("values").remove(builder);
        this.values.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromValues(Predicate<ArtifactValueBuilder> predicate) {
    if (values == null) {
      return (A) this;
    }
    Iterator<ArtifactValueBuilder> each = values.iterator();
    List visitables = _visitables.get("values");
    while (each.hasNext()) {
        ArtifactValueBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ValuesNested<A> setNewValueLike(int index,ArtifactValue item) {
    return new ValuesNested(index, item);
  }
  
  public A setToValues(int index,ArtifactValue item) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    ArtifactValueBuilder builder = new ArtifactValueBuilder(item);
    if (index < 0 || index >= values.size()) {
        _visitables.get("values").add(builder);
        values.add(builder);
    } else {
        _visitables.get("values").add(builder);
        values.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(buildOutput == null)) {
        sb.append("buildOutput:");
        sb.append(buildOutput);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withBuildOutput() {
    return withBuildOutput(true);
  }
  
  public A withBuildOutput(Boolean buildOutput) {
    this.buildOutput = buildOutput;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withValues(List<ArtifactValue> values) {
    if (this.values != null) {
      this._visitables.get("values").clear();
    }
    if (values != null) {
        this.values = new ArrayList();
        for (ArtifactValue item : values) {
          this.addToValues(item);
        }
    } else {
      this.values = null;
    }
    return (A) this;
  }
  
  public A withValues(ArtifactValue... values) {
    if (this.values != null) {
        this.values.clear();
        _visitables.remove("values");
    }
    if (values != null) {
      for (ArtifactValue item : values) {
        this.addToValues(item);
      }
    }
    return (A) this;
  }
  public class ValuesNested<N> extends ArtifactValueFluent<ValuesNested<N>> implements Nested<N>{
  
    ArtifactValueBuilder builder;
    int index;
  
    ValuesNested(int index,ArtifactValue item) {
      this.index = index;
      this.builder = new ArtifactValueBuilder(this, item);
    }
  
    public N and() {
      return (N) ArtifactFluent.this.setToValues(index, builder.build());
    }
    
    public N endValue() {
      return and();
    }
    
  }
}