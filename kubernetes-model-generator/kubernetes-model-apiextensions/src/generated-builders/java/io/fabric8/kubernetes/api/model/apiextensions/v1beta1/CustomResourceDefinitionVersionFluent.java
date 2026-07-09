package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CustomResourceDefinitionVersionFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersionFluent<A>> extends BaseFluent<A>{

  private ArrayList<CustomResourceColumnDefinitionBuilder> additionalPrinterColumns = new ArrayList<CustomResourceColumnDefinitionBuilder>();
  private Map<String,Object> additionalProperties;
  private Boolean deprecated;
  private String deprecationWarning;
  private String name;
  private CustomResourceValidationBuilder schema;
  private Boolean served;
  private Boolean storage;
  private CustomResourceSubresourcesBuilder subresources;

  public CustomResourceDefinitionVersionFluent() {
  }
  
  public CustomResourceDefinitionVersionFluent(CustomResourceDefinitionVersion instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalPrinterColumns(Collection<CustomResourceColumnDefinition> items) {
    if (this.additionalPrinterColumns == null) {
      this.additionalPrinterColumns = new ArrayList();
    }
    for (CustomResourceColumnDefinition item : items) {
        CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
        _visitables.get("additionalPrinterColumns").add(builder);
        this.additionalPrinterColumns.add(builder);
    }
    return (A) this;
  }
  
  public AdditionalPrinterColumnsNested<A> addNewAdditionalPrinterColumn() {
    return new AdditionalPrinterColumnsNested(-1, null);
  }
  
  public AdditionalPrinterColumnsNested<A> addNewAdditionalPrinterColumnLike(CustomResourceColumnDefinition item) {
    return new AdditionalPrinterColumnsNested(-1, item);
  }
  
  public A addToAdditionalPrinterColumns(CustomResourceColumnDefinition... items) {
    if (this.additionalPrinterColumns == null) {
      this.additionalPrinterColumns = new ArrayList();
    }
    for (CustomResourceColumnDefinition item : items) {
        CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
        _visitables.get("additionalPrinterColumns").add(builder);
        this.additionalPrinterColumns.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalPrinterColumns(int index,CustomResourceColumnDefinition item) {
    if (this.additionalPrinterColumns == null) {
      this.additionalPrinterColumns = new ArrayList();
    }
    CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
    if (index < 0 || index >= additionalPrinterColumns.size()) {
        _visitables.get("additionalPrinterColumns").add(builder);
        additionalPrinterColumns.add(builder);
    } else {
        _visitables.get("additionalPrinterColumns").add(builder);
        additionalPrinterColumns.add(index, builder);
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
  
  public CustomResourceColumnDefinition buildAdditionalPrinterColumn(int index) {
    return this.additionalPrinterColumns.get(index).build();
  }
  
  public List<CustomResourceColumnDefinition> buildAdditionalPrinterColumns() {
    return this.additionalPrinterColumns != null ? build(additionalPrinterColumns) : null;
  }
  
  public CustomResourceColumnDefinition buildFirstAdditionalPrinterColumn() {
    return this.additionalPrinterColumns.get(0).build();
  }
  
  public CustomResourceColumnDefinition buildLastAdditionalPrinterColumn() {
    return this.additionalPrinterColumns.get(additionalPrinterColumns.size() - 1).build();
  }
  
  public CustomResourceColumnDefinition buildMatchingAdditionalPrinterColumn(Predicate<CustomResourceColumnDefinitionBuilder> predicate) {
      for (CustomResourceColumnDefinitionBuilder item : additionalPrinterColumns) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public CustomResourceValidation buildSchema() {
    return this.schema != null ? this.schema.build() : null;
  }
  
  public CustomResourceSubresources buildSubresources() {
    return this.subresources != null ? this.subresources.build() : null;
  }
  
  protected void copyInstance(CustomResourceDefinitionVersion instance) {
    instance = instance != null ? instance : new CustomResourceDefinitionVersion();
    if (instance != null) {
        this.withAdditionalPrinterColumns(instance.getAdditionalPrinterColumns());
        this.withDeprecated(instance.getDeprecated());
        this.withDeprecationWarning(instance.getDeprecationWarning());
        this.withName(instance.getName());
        this.withSchema(instance.getSchema());
        this.withServed(instance.getServed());
        this.withStorage(instance.getStorage());
        this.withSubresources(instance.getSubresources());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalPrinterColumnsNested<A> editAdditionalPrinterColumn(int index) {
    if (additionalPrinterColumns.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalPrinterColumns"));
    }
    return this.setNewAdditionalPrinterColumnLike(index, this.buildAdditionalPrinterColumn(index));
  }
  
  public AdditionalPrinterColumnsNested<A> editFirstAdditionalPrinterColumn() {
    if (additionalPrinterColumns.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalPrinterColumns"));
    }
    return this.setNewAdditionalPrinterColumnLike(0, this.buildAdditionalPrinterColumn(0));
  }
  
  public AdditionalPrinterColumnsNested<A> editLastAdditionalPrinterColumn() {
    int index = additionalPrinterColumns.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalPrinterColumns"));
    }
    return this.setNewAdditionalPrinterColumnLike(index, this.buildAdditionalPrinterColumn(index));
  }
  
  public AdditionalPrinterColumnsNested<A> editMatchingAdditionalPrinterColumn(Predicate<CustomResourceColumnDefinitionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalPrinterColumns.size();i++) {
      if (predicate.test(additionalPrinterColumns.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalPrinterColumns"));
    }
    return this.setNewAdditionalPrinterColumnLike(index, this.buildAdditionalPrinterColumn(index));
  }
  
  public SchemaNested<A> editOrNewSchema() {
    return this.withNewSchemaLike(Optional.ofNullable(this.buildSchema()).orElse(new CustomResourceValidationBuilder().build()));
  }
  
  public SchemaNested<A> editOrNewSchemaLike(CustomResourceValidation item) {
    return this.withNewSchemaLike(Optional.ofNullable(this.buildSchema()).orElse(item));
  }
  
  public SubresourcesNested<A> editOrNewSubresources() {
    return this.withNewSubresourcesLike(Optional.ofNullable(this.buildSubresources()).orElse(new CustomResourceSubresourcesBuilder().build()));
  }
  
  public SubresourcesNested<A> editOrNewSubresourcesLike(CustomResourceSubresources item) {
    return this.withNewSubresourcesLike(Optional.ofNullable(this.buildSubresources()).orElse(item));
  }
  
  public SchemaNested<A> editSchema() {
    return this.withNewSchemaLike(Optional.ofNullable(this.buildSchema()).orElse(null));
  }
  
  public SubresourcesNested<A> editSubresources() {
    return this.withNewSubresourcesLike(Optional.ofNullable(this.buildSubresources()).orElse(null));
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
    CustomResourceDefinitionVersionFluent that = (CustomResourceDefinitionVersionFluent) o;
    if (!(Objects.equals(additionalPrinterColumns, that.additionalPrinterColumns))) {
      return false;
    }
    if (!(Objects.equals(deprecated, that.deprecated))) {
      return false;
    }
    if (!(Objects.equals(deprecationWarning, that.deprecationWarning))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(schema, that.schema))) {
      return false;
    }
    if (!(Objects.equals(served, that.served))) {
      return false;
    }
    if (!(Objects.equals(storage, that.storage))) {
      return false;
    }
    if (!(Objects.equals(subresources, that.subresources))) {
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
  
  public Boolean getDeprecated() {
    return this.deprecated;
  }
  
  public String getDeprecationWarning() {
    return this.deprecationWarning;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Boolean getServed() {
    return this.served;
  }
  
  public Boolean getStorage() {
    return this.storage;
  }
  
  public boolean hasAdditionalPrinterColumns() {
    return this.additionalPrinterColumns != null && !(this.additionalPrinterColumns.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeprecated() {
    return this.deprecated != null;
  }
  
  public boolean hasDeprecationWarning() {
    return this.deprecationWarning != null;
  }
  
  public boolean hasMatchingAdditionalPrinterColumn(Predicate<CustomResourceColumnDefinitionBuilder> predicate) {
      for (CustomResourceColumnDefinitionBuilder item : additionalPrinterColumns) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSchema() {
    return this.schema != null;
  }
  
  public boolean hasServed() {
    return this.served != null;
  }
  
  public boolean hasStorage() {
    return this.storage != null;
  }
  
  public boolean hasSubresources() {
    return this.subresources != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalPrinterColumns, deprecated, deprecationWarning, name, schema, served, storage, subresources, additionalProperties);
  }
  
  public A removeAllFromAdditionalPrinterColumns(Collection<CustomResourceColumnDefinition> items) {
    if (this.additionalPrinterColumns == null) {
      return (A) this;
    }
    for (CustomResourceColumnDefinition item : items) {
        CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
        _visitables.get("additionalPrinterColumns").remove(builder);
        this.additionalPrinterColumns.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalPrinterColumns(CustomResourceColumnDefinition... items) {
    if (this.additionalPrinterColumns == null) {
      return (A) this;
    }
    for (CustomResourceColumnDefinition item : items) {
        CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
        _visitables.get("additionalPrinterColumns").remove(builder);
        this.additionalPrinterColumns.remove(builder);
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
  
  public A removeMatchingFromAdditionalPrinterColumns(Predicate<CustomResourceColumnDefinitionBuilder> predicate) {
    if (additionalPrinterColumns == null) {
      return (A) this;
    }
    Iterator<CustomResourceColumnDefinitionBuilder> each = additionalPrinterColumns.iterator();
    List visitables = _visitables.get("additionalPrinterColumns");
    while (each.hasNext()) {
        CustomResourceColumnDefinitionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AdditionalPrinterColumnsNested<A> setNewAdditionalPrinterColumnLike(int index,CustomResourceColumnDefinition item) {
    return new AdditionalPrinterColumnsNested(index, item);
  }
  
  public A setToAdditionalPrinterColumns(int index,CustomResourceColumnDefinition item) {
    if (this.additionalPrinterColumns == null) {
      this.additionalPrinterColumns = new ArrayList();
    }
    CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
    if (index < 0 || index >= additionalPrinterColumns.size()) {
        _visitables.get("additionalPrinterColumns").add(builder);
        additionalPrinterColumns.add(builder);
    } else {
        _visitables.get("additionalPrinterColumns").add(builder);
        additionalPrinterColumns.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalPrinterColumns == null) && !(additionalPrinterColumns.isEmpty())) {
        sb.append("additionalPrinterColumns:");
        sb.append(additionalPrinterColumns);
        sb.append(",");
    }
    if (!(deprecated == null)) {
        sb.append("deprecated:");
        sb.append(deprecated);
        sb.append(",");
    }
    if (!(deprecationWarning == null)) {
        sb.append("deprecationWarning:");
        sb.append(deprecationWarning);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(schema == null)) {
        sb.append("schema:");
        sb.append(schema);
        sb.append(",");
    }
    if (!(served == null)) {
        sb.append("served:");
        sb.append(served);
        sb.append(",");
    }
    if (!(storage == null)) {
        sb.append("storage:");
        sb.append(storage);
        sb.append(",");
    }
    if (!(subresources == null)) {
        sb.append("subresources:");
        sb.append(subresources);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalPrinterColumns(List<CustomResourceColumnDefinition> additionalPrinterColumns) {
    if (this.additionalPrinterColumns != null) {
      this._visitables.get("additionalPrinterColumns").clear();
    }
    if (additionalPrinterColumns != null) {
        this.additionalPrinterColumns = new ArrayList();
        for (CustomResourceColumnDefinition item : additionalPrinterColumns) {
          this.addToAdditionalPrinterColumns(item);
        }
    } else {
      this.additionalPrinterColumns = null;
    }
    return (A) this;
  }
  
  public A withAdditionalPrinterColumns(CustomResourceColumnDefinition... additionalPrinterColumns) {
    if (this.additionalPrinterColumns != null) {
        this.additionalPrinterColumns.clear();
        _visitables.remove("additionalPrinterColumns");
    }
    if (additionalPrinterColumns != null) {
      for (CustomResourceColumnDefinition item : additionalPrinterColumns) {
        this.addToAdditionalPrinterColumns(item);
      }
    }
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
  
  public A withDeprecated() {
    return withDeprecated(true);
  }
  
  public A withDeprecated(Boolean deprecated) {
    this.deprecated = deprecated;
    return (A) this;
  }
  
  public A withDeprecationWarning(String deprecationWarning) {
    this.deprecationWarning = deprecationWarning;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public SchemaNested<A> withNewSchema() {
    return new SchemaNested(null);
  }
  
  public SchemaNested<A> withNewSchemaLike(CustomResourceValidation item) {
    return new SchemaNested(item);
  }
  
  public SubresourcesNested<A> withNewSubresources() {
    return new SubresourcesNested(null);
  }
  
  public SubresourcesNested<A> withNewSubresourcesLike(CustomResourceSubresources item) {
    return new SubresourcesNested(item);
  }
  
  public A withSchema(CustomResourceValidation schema) {
    this._visitables.remove("schema");
    if (schema != null) {
        this.schema = new CustomResourceValidationBuilder(schema);
        this._visitables.get("schema").add(this.schema);
    } else {
        this.schema = null;
        this._visitables.get("schema").remove(this.schema);
    }
    return (A) this;
  }
  
  public A withServed() {
    return withServed(true);
  }
  
  public A withServed(Boolean served) {
    this.served = served;
    return (A) this;
  }
  
  public A withStorage() {
    return withStorage(true);
  }
  
  public A withStorage(Boolean storage) {
    this.storage = storage;
    return (A) this;
  }
  
  public A withSubresources(CustomResourceSubresources subresources) {
    this._visitables.remove("subresources");
    if (subresources != null) {
        this.subresources = new CustomResourceSubresourcesBuilder(subresources);
        this._visitables.get("subresources").add(this.subresources);
    } else {
        this.subresources = null;
        this._visitables.get("subresources").remove(this.subresources);
    }
    return (A) this;
  }
  public class AdditionalPrinterColumnsNested<N> extends CustomResourceColumnDefinitionFluent<AdditionalPrinterColumnsNested<N>> implements Nested<N>{
  
    CustomResourceColumnDefinitionBuilder builder;
    int index;
  
    AdditionalPrinterColumnsNested(int index,CustomResourceColumnDefinition item) {
      this.index = index;
      this.builder = new CustomResourceColumnDefinitionBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceDefinitionVersionFluent.this.setToAdditionalPrinterColumns(index, builder.build());
    }
    
    public N endAdditionalPrinterColumn() {
      return and();
    }
    
  }
  public class SchemaNested<N> extends CustomResourceValidationFluent<SchemaNested<N>> implements Nested<N>{
  
    CustomResourceValidationBuilder builder;
  
    SchemaNested(CustomResourceValidation item) {
      this.builder = new CustomResourceValidationBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceDefinitionVersionFluent.this.withSchema(builder.build());
    }
    
    public N endSchema() {
      return and();
    }
    
  }
  public class SubresourcesNested<N> extends CustomResourceSubresourcesFluent<SubresourcesNested<N>> implements Nested<N>{
  
    CustomResourceSubresourcesBuilder builder;
  
    SubresourcesNested(CustomResourceSubresources item) {
      this.builder = new CustomResourceSubresourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceDefinitionVersionFluent.this.withSubresources(builder.build());
    }
    
    public N endSubresources() {
      return and();
    }
    
  }
}