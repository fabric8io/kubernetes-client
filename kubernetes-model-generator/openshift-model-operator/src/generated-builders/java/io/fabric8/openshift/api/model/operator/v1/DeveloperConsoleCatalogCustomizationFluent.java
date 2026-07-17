package io.fabric8.openshift.api.model.operator.v1;

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
public class DeveloperConsoleCatalogCustomizationFluent<A extends io.fabric8.openshift.api.model.operator.v1.DeveloperConsoleCatalogCustomizationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<DeveloperConsoleCatalogCategoryBuilder> categories = new ArrayList<DeveloperConsoleCatalogCategoryBuilder>();
  private DeveloperConsoleCatalogTypesBuilder types;

  public DeveloperConsoleCatalogCustomizationFluent() {
  }
  
  public DeveloperConsoleCatalogCustomizationFluent(DeveloperConsoleCatalogCustomization instance) {
    this.copyInstance(instance);
  }

  public A addAllToCategories(Collection<DeveloperConsoleCatalogCategory> items) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    for (DeveloperConsoleCatalogCategory item : items) {
        DeveloperConsoleCatalogCategoryBuilder builder = new DeveloperConsoleCatalogCategoryBuilder(item);
        _visitables.get("categories").add(builder);
        this.categories.add(builder);
    }
    return (A) this;
  }
  
  public CategoriesNested<A> addNewCategory() {
    return new CategoriesNested(-1, null);
  }
  
  public CategoriesNested<A> addNewCategoryLike(DeveloperConsoleCatalogCategory item) {
    return new CategoriesNested(-1, item);
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
  
  public A addToCategories(DeveloperConsoleCatalogCategory... items) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    for (DeveloperConsoleCatalogCategory item : items) {
        DeveloperConsoleCatalogCategoryBuilder builder = new DeveloperConsoleCatalogCategoryBuilder(item);
        _visitables.get("categories").add(builder);
        this.categories.add(builder);
    }
    return (A) this;
  }
  
  public A addToCategories(int index,DeveloperConsoleCatalogCategory item) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    DeveloperConsoleCatalogCategoryBuilder builder = new DeveloperConsoleCatalogCategoryBuilder(item);
    if (index < 0 || index >= categories.size()) {
        _visitables.get("categories").add(builder);
        categories.add(builder);
    } else {
        _visitables.get("categories").add(builder);
        categories.add(index, builder);
    }
    return (A) this;
  }
  
  public List<DeveloperConsoleCatalogCategory> buildCategories() {
    return this.categories != null ? build(categories) : null;
  }
  
  public DeveloperConsoleCatalogCategory buildCategory(int index) {
    return this.categories.get(index).build();
  }
  
  public DeveloperConsoleCatalogCategory buildFirstCategory() {
    return this.categories.get(0).build();
  }
  
  public DeveloperConsoleCatalogCategory buildLastCategory() {
    return this.categories.get(categories.size() - 1).build();
  }
  
  public DeveloperConsoleCatalogCategory buildMatchingCategory(Predicate<DeveloperConsoleCatalogCategoryBuilder> predicate) {
      for (DeveloperConsoleCatalogCategoryBuilder item : categories) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeveloperConsoleCatalogTypes buildTypes() {
    return this.types != null ? this.types.build() : null;
  }
  
  protected void copyInstance(DeveloperConsoleCatalogCustomization instance) {
    instance = instance != null ? instance : new DeveloperConsoleCatalogCustomization();
    if (instance != null) {
        this.withCategories(instance.getCategories());
        this.withTypes(instance.getTypes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CategoriesNested<A> editCategory(int index) {
    if (categories.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "categories"));
    }
    return this.setNewCategoryLike(index, this.buildCategory(index));
  }
  
  public CategoriesNested<A> editFirstCategory() {
    if (categories.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "categories"));
    }
    return this.setNewCategoryLike(0, this.buildCategory(0));
  }
  
  public CategoriesNested<A> editLastCategory() {
    int index = categories.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "categories"));
    }
    return this.setNewCategoryLike(index, this.buildCategory(index));
  }
  
  public CategoriesNested<A> editMatchingCategory(Predicate<DeveloperConsoleCatalogCategoryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < categories.size();i++) {
      if (predicate.test(categories.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "categories"));
    }
    return this.setNewCategoryLike(index, this.buildCategory(index));
  }
  
  public TypesNested<A> editOrNewTypes() {
    return this.withNewTypesLike(Optional.ofNullable(this.buildTypes()).orElse(new DeveloperConsoleCatalogTypesBuilder().build()));
  }
  
  public TypesNested<A> editOrNewTypesLike(DeveloperConsoleCatalogTypes item) {
    return this.withNewTypesLike(Optional.ofNullable(this.buildTypes()).orElse(item));
  }
  
  public TypesNested<A> editTypes() {
    return this.withNewTypesLike(Optional.ofNullable(this.buildTypes()).orElse(null));
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
    DeveloperConsoleCatalogCustomizationFluent that = (DeveloperConsoleCatalogCustomizationFluent) o;
    if (!(Objects.equals(categories, that.categories))) {
      return false;
    }
    if (!(Objects.equals(types, that.types))) {
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
  
  public boolean hasCategories() {
    return this.categories != null && !(this.categories.isEmpty());
  }
  
  public boolean hasMatchingCategory(Predicate<DeveloperConsoleCatalogCategoryBuilder> predicate) {
      for (DeveloperConsoleCatalogCategoryBuilder item : categories) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTypes() {
    return this.types != null;
  }
  
  public int hashCode() {
    return Objects.hash(categories, types, additionalProperties);
  }
  
  public A removeAllFromCategories(Collection<DeveloperConsoleCatalogCategory> items) {
    if (this.categories == null) {
      return (A) this;
    }
    for (DeveloperConsoleCatalogCategory item : items) {
        DeveloperConsoleCatalogCategoryBuilder builder = new DeveloperConsoleCatalogCategoryBuilder(item);
        _visitables.get("categories").remove(builder);
        this.categories.remove(builder);
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
  
  public A removeFromCategories(DeveloperConsoleCatalogCategory... items) {
    if (this.categories == null) {
      return (A) this;
    }
    for (DeveloperConsoleCatalogCategory item : items) {
        DeveloperConsoleCatalogCategoryBuilder builder = new DeveloperConsoleCatalogCategoryBuilder(item);
        _visitables.get("categories").remove(builder);
        this.categories.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCategories(Predicate<DeveloperConsoleCatalogCategoryBuilder> predicate) {
    if (categories == null) {
      return (A) this;
    }
    Iterator<DeveloperConsoleCatalogCategoryBuilder> each = categories.iterator();
    List visitables = _visitables.get("categories");
    while (each.hasNext()) {
        DeveloperConsoleCatalogCategoryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CategoriesNested<A> setNewCategoryLike(int index,DeveloperConsoleCatalogCategory item) {
    return new CategoriesNested(index, item);
  }
  
  public A setToCategories(int index,DeveloperConsoleCatalogCategory item) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    DeveloperConsoleCatalogCategoryBuilder builder = new DeveloperConsoleCatalogCategoryBuilder(item);
    if (index < 0 || index >= categories.size()) {
        _visitables.get("categories").add(builder);
        categories.add(builder);
    } else {
        _visitables.get("categories").add(builder);
        categories.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(categories == null) && !(categories.isEmpty())) {
        sb.append("categories:");
        sb.append(categories);
        sb.append(",");
    }
    if (!(types == null)) {
        sb.append("types:");
        sb.append(types);
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
  
  public A withCategories(List<DeveloperConsoleCatalogCategory> categories) {
    if (this.categories != null) {
      this._visitables.get("categories").clear();
    }
    if (categories != null) {
        this.categories = new ArrayList();
        for (DeveloperConsoleCatalogCategory item : categories) {
          this.addToCategories(item);
        }
    } else {
      this.categories = null;
    }
    return (A) this;
  }
  
  public A withCategories(DeveloperConsoleCatalogCategory... categories) {
    if (this.categories != null) {
        this.categories.clear();
        _visitables.remove("categories");
    }
    if (categories != null) {
      for (DeveloperConsoleCatalogCategory item : categories) {
        this.addToCategories(item);
      }
    }
    return (A) this;
  }
  
  public TypesNested<A> withNewTypes() {
    return new TypesNested(null);
  }
  
  public TypesNested<A> withNewTypesLike(DeveloperConsoleCatalogTypes item) {
    return new TypesNested(item);
  }
  
  public A withTypes(DeveloperConsoleCatalogTypes types) {
    this._visitables.remove("types");
    if (types != null) {
        this.types = new DeveloperConsoleCatalogTypesBuilder(types);
        this._visitables.get("types").add(this.types);
    } else {
        this.types = null;
        this._visitables.get("types").remove(this.types);
    }
    return (A) this;
  }
  public class CategoriesNested<N> extends DeveloperConsoleCatalogCategoryFluent<CategoriesNested<N>> implements Nested<N>{
  
    DeveloperConsoleCatalogCategoryBuilder builder;
    int index;
  
    CategoriesNested(int index,DeveloperConsoleCatalogCategory item) {
      this.index = index;
      this.builder = new DeveloperConsoleCatalogCategoryBuilder(this, item);
    }
  
    public N and() {
      return (N) DeveloperConsoleCatalogCustomizationFluent.this.setToCategories(index, builder.build());
    }
    
    public N endCategory() {
      return and();
    }
    
  }
  public class TypesNested<N> extends DeveloperConsoleCatalogTypesFluent<TypesNested<N>> implements Nested<N>{
  
    DeveloperConsoleCatalogTypesBuilder builder;
  
    TypesNested(DeveloperConsoleCatalogTypes item) {
      this.builder = new DeveloperConsoleCatalogTypesBuilder(this, item);
    }
  
    public N and() {
      return (N) DeveloperConsoleCatalogCustomizationFluent.this.withTypes(builder.build());
    }
    
    public N endTypes() {
      return and();
    }
    
  }
}