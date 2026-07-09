package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
public class LabelFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.LabelFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<FieldSpecBuilder> fields = new ArrayList<FieldSpecBuilder>();
  private Boolean includeSelectors;
  private Boolean includeTemplates;
  private Map<String,String> pairs;

  public LabelFluent() {
  }
  
  public LabelFluent(Label instance) {
    this.copyInstance(instance);
  }

  public A addAllToFields(Collection<FieldSpec> items) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    for (FieldSpec item : items) {
        FieldSpecBuilder builder = new FieldSpecBuilder(item);
        _visitables.get("fields").add(builder);
        this.fields.add(builder);
    }
    return (A) this;
  }
  
  public FieldsNested<A> addNewField() {
    return new FieldsNested(-1, null);
  }
  
  public A addNewField(Boolean create,String group,String kind,String path,String version) {
    return (A) this.addToFields(new FieldSpec(create, group, kind, path, version));
  }
  
  public FieldsNested<A> addNewFieldLike(FieldSpec item) {
    return new FieldsNested(-1, item);
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
  
  public A addToFields(FieldSpec... items) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    for (FieldSpec item : items) {
        FieldSpecBuilder builder = new FieldSpecBuilder(item);
        _visitables.get("fields").add(builder);
        this.fields.add(builder);
    }
    return (A) this;
  }
  
  public A addToFields(int index,FieldSpec item) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    FieldSpecBuilder builder = new FieldSpecBuilder(item);
    if (index < 0 || index >= fields.size()) {
        _visitables.get("fields").add(builder);
        fields.add(builder);
    } else {
        _visitables.get("fields").add(builder);
        fields.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPairs(Map<String,String> map) {
    if (this.pairs == null && map != null) {
      this.pairs = new LinkedHashMap();
    }
    if (map != null) {
      this.pairs.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPairs(String key,String value) {
    if (this.pairs == null && key != null && value != null) {
      this.pairs = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.pairs.put(key, value);
    }
    return (A) this;
  }
  
  public FieldSpec buildField(int index) {
    return this.fields.get(index).build();
  }
  
  public List<FieldSpec> buildFields() {
    return this.fields != null ? build(fields) : null;
  }
  
  public FieldSpec buildFirstField() {
    return this.fields.get(0).build();
  }
  
  public FieldSpec buildLastField() {
    return this.fields.get(fields.size() - 1).build();
  }
  
  public FieldSpec buildMatchingField(Predicate<FieldSpecBuilder> predicate) {
      for (FieldSpecBuilder item : fields) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Label instance) {
    instance = instance != null ? instance : new Label();
    if (instance != null) {
        this.withFields(instance.getFields());
        this.withIncludeSelectors(instance.getIncludeSelectors());
        this.withIncludeTemplates(instance.getIncludeTemplates());
        this.withPairs(instance.getPairs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FieldsNested<A> editField(int index) {
    if (fields.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "fields"));
    }
    return this.setNewFieldLike(index, this.buildField(index));
  }
  
  public FieldsNested<A> editFirstField() {
    if (fields.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "fields"));
    }
    return this.setNewFieldLike(0, this.buildField(0));
  }
  
  public FieldsNested<A> editLastField() {
    int index = fields.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "fields"));
    }
    return this.setNewFieldLike(index, this.buildField(index));
  }
  
  public FieldsNested<A> editMatchingField(Predicate<FieldSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < fields.size();i++) {
      if (predicate.test(fields.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "fields"));
    }
    return this.setNewFieldLike(index, this.buildField(index));
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
    LabelFluent that = (LabelFluent) o;
    if (!(Objects.equals(fields, that.fields))) {
      return false;
    }
    if (!(Objects.equals(includeSelectors, that.includeSelectors))) {
      return false;
    }
    if (!(Objects.equals(includeTemplates, that.includeTemplates))) {
      return false;
    }
    if (!(Objects.equals(pairs, that.pairs))) {
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
  
  public Boolean getIncludeSelectors() {
    return this.includeSelectors;
  }
  
  public Boolean getIncludeTemplates() {
    return this.includeTemplates;
  }
  
  public Map<String,String> getPairs() {
    return this.pairs;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFields() {
    return this.fields != null && !(this.fields.isEmpty());
  }
  
  public boolean hasIncludeSelectors() {
    return this.includeSelectors != null;
  }
  
  public boolean hasIncludeTemplates() {
    return this.includeTemplates != null;
  }
  
  public boolean hasMatchingField(Predicate<FieldSpecBuilder> predicate) {
      for (FieldSpecBuilder item : fields) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPairs() {
    return this.pairs != null;
  }
  
  public int hashCode() {
    return Objects.hash(fields, includeSelectors, includeTemplates, pairs, additionalProperties);
  }
  
  public A removeAllFromFields(Collection<FieldSpec> items) {
    if (this.fields == null) {
      return (A) this;
    }
    for (FieldSpec item : items) {
        FieldSpecBuilder builder = new FieldSpecBuilder(item);
        _visitables.get("fields").remove(builder);
        this.fields.remove(builder);
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
  
  public A removeFromFields(FieldSpec... items) {
    if (this.fields == null) {
      return (A) this;
    }
    for (FieldSpec item : items) {
        FieldSpecBuilder builder = new FieldSpecBuilder(item);
        _visitables.get("fields").remove(builder);
        this.fields.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPairs(String key) {
    if (this.pairs == null) {
      return (A) this;
    }
    if (key != null && this.pairs != null) {
      this.pairs.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPairs(Map<String,String> map) {
    if (this.pairs == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.pairs != null) {
          this.pairs.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFields(Predicate<FieldSpecBuilder> predicate) {
    if (fields == null) {
      return (A) this;
    }
    Iterator<FieldSpecBuilder> each = fields.iterator();
    List visitables = _visitables.get("fields");
    while (each.hasNext()) {
        FieldSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FieldsNested<A> setNewFieldLike(int index,FieldSpec item) {
    return new FieldsNested(index, item);
  }
  
  public A setToFields(int index,FieldSpec item) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    FieldSpecBuilder builder = new FieldSpecBuilder(item);
    if (index < 0 || index >= fields.size()) {
        _visitables.get("fields").add(builder);
        fields.add(builder);
    } else {
        _visitables.get("fields").add(builder);
        fields.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(fields == null) && !(fields.isEmpty())) {
        sb.append("fields:");
        sb.append(fields);
        sb.append(",");
    }
    if (!(includeSelectors == null)) {
        sb.append("includeSelectors:");
        sb.append(includeSelectors);
        sb.append(",");
    }
    if (!(includeTemplates == null)) {
        sb.append("includeTemplates:");
        sb.append(includeTemplates);
        sb.append(",");
    }
    if (!(pairs == null) && !(pairs.isEmpty())) {
        sb.append("pairs:");
        sb.append(pairs);
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
  
  public A withFields(List<FieldSpec> fields) {
    if (this.fields != null) {
      this._visitables.get("fields").clear();
    }
    if (fields != null) {
        this.fields = new ArrayList();
        for (FieldSpec item : fields) {
          this.addToFields(item);
        }
    } else {
      this.fields = null;
    }
    return (A) this;
  }
  
  public A withFields(FieldSpec... fields) {
    if (this.fields != null) {
        this.fields.clear();
        _visitables.remove("fields");
    }
    if (fields != null) {
      for (FieldSpec item : fields) {
        this.addToFields(item);
      }
    }
    return (A) this;
  }
  
  public A withIncludeSelectors() {
    return withIncludeSelectors(true);
  }
  
  public A withIncludeSelectors(Boolean includeSelectors) {
    this.includeSelectors = includeSelectors;
    return (A) this;
  }
  
  public A withIncludeTemplates() {
    return withIncludeTemplates(true);
  }
  
  public A withIncludeTemplates(Boolean includeTemplates) {
    this.includeTemplates = includeTemplates;
    return (A) this;
  }
  
  public <K,V>A withPairs(Map<String,String> pairs) {
    if (pairs == null) {
      this.pairs = null;
    } else {
      this.pairs = new LinkedHashMap(pairs);
    }
    return (A) this;
  }
  public class FieldsNested<N> extends FieldSpecFluent<FieldsNested<N>> implements Nested<N>{
  
    FieldSpecBuilder builder;
    int index;
  
    FieldsNested(int index,FieldSpec item) {
      this.index = index;
      this.builder = new FieldSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) LabelFluent.this.setToFields(index, builder.build());
    }
    
    public N endField() {
      return and();
    }
    
  }
}