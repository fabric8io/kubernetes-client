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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DeveloperConsoleCatalogCategoryFluent<A extends io.fabric8.openshift.api.model.operator.v1.DeveloperConsoleCatalogCategoryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String id;
  private String label;
  private ArrayList<DeveloperConsoleCatalogCategoryMetaBuilder> subcategories = new ArrayList<DeveloperConsoleCatalogCategoryMetaBuilder>();
  private List<String> tags = new ArrayList<String>();

  public DeveloperConsoleCatalogCategoryFluent() {
  }
  
  public DeveloperConsoleCatalogCategoryFluent(DeveloperConsoleCatalogCategory instance) {
    this.copyInstance(instance);
  }

  public A addAllToSubcategories(Collection<DeveloperConsoleCatalogCategoryMeta> items) {
    if (this.subcategories == null) {
      this.subcategories = new ArrayList();
    }
    for (DeveloperConsoleCatalogCategoryMeta item : items) {
        DeveloperConsoleCatalogCategoryMetaBuilder builder = new DeveloperConsoleCatalogCategoryMetaBuilder(item);
        _visitables.get("subcategories").add(builder);
        this.subcategories.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTags(Collection<String> items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
    }
    return (A) this;
  }
  
  public SubcategoriesNested<A> addNewSubcategory() {
    return new SubcategoriesNested(-1, null);
  }
  
  public SubcategoriesNested<A> addNewSubcategoryLike(DeveloperConsoleCatalogCategoryMeta item) {
    return new SubcategoriesNested(-1, item);
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
  
  public A addToSubcategories(DeveloperConsoleCatalogCategoryMeta... items) {
    if (this.subcategories == null) {
      this.subcategories = new ArrayList();
    }
    for (DeveloperConsoleCatalogCategoryMeta item : items) {
        DeveloperConsoleCatalogCategoryMetaBuilder builder = new DeveloperConsoleCatalogCategoryMetaBuilder(item);
        _visitables.get("subcategories").add(builder);
        this.subcategories.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubcategories(int index,DeveloperConsoleCatalogCategoryMeta item) {
    if (this.subcategories == null) {
      this.subcategories = new ArrayList();
    }
    DeveloperConsoleCatalogCategoryMetaBuilder builder = new DeveloperConsoleCatalogCategoryMetaBuilder(item);
    if (index < 0 || index >= subcategories.size()) {
        _visitables.get("subcategories").add(builder);
        subcategories.add(builder);
    } else {
        _visitables.get("subcategories").add(builder);
        subcategories.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTags(String... items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
    }
    return (A) this;
  }
  
  public A addToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.add(index, item);
    return (A) this;
  }
  
  public DeveloperConsoleCatalogCategoryMeta buildFirstSubcategory() {
    return this.subcategories.get(0).build();
  }
  
  public DeveloperConsoleCatalogCategoryMeta buildLastSubcategory() {
    return this.subcategories.get(subcategories.size() - 1).build();
  }
  
  public DeveloperConsoleCatalogCategoryMeta buildMatchingSubcategory(Predicate<DeveloperConsoleCatalogCategoryMetaBuilder> predicate) {
      for (DeveloperConsoleCatalogCategoryMetaBuilder item : subcategories) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<DeveloperConsoleCatalogCategoryMeta> buildSubcategories() {
    return this.subcategories != null ? build(subcategories) : null;
  }
  
  public DeveloperConsoleCatalogCategoryMeta buildSubcategory(int index) {
    return this.subcategories.get(index).build();
  }
  
  protected void copyInstance(DeveloperConsoleCatalogCategory instance) {
    instance = instance != null ? instance : new DeveloperConsoleCatalogCategory();
    if (instance != null) {
        this.withId(instance.getId());
        this.withLabel(instance.getLabel());
        this.withSubcategories(instance.getSubcategories());
        this.withTags(instance.getTags());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SubcategoriesNested<A> editFirstSubcategory() {
    if (subcategories.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subcategories"));
    }
    return this.setNewSubcategoryLike(0, this.buildSubcategory(0));
  }
  
  public SubcategoriesNested<A> editLastSubcategory() {
    int index = subcategories.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subcategories"));
    }
    return this.setNewSubcategoryLike(index, this.buildSubcategory(index));
  }
  
  public SubcategoriesNested<A> editMatchingSubcategory(Predicate<DeveloperConsoleCatalogCategoryMetaBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subcategories.size();i++) {
      if (predicate.test(subcategories.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subcategories"));
    }
    return this.setNewSubcategoryLike(index, this.buildSubcategory(index));
  }
  
  public SubcategoriesNested<A> editSubcategory(int index) {
    if (subcategories.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subcategories"));
    }
    return this.setNewSubcategoryLike(index, this.buildSubcategory(index));
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
    DeveloperConsoleCatalogCategoryFluent that = (DeveloperConsoleCatalogCategoryFluent) o;
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(label, that.label))) {
      return false;
    }
    if (!(Objects.equals(subcategories, that.subcategories))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
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
  
  public String getFirstTag() {
    return this.tags.get(0);
  }
  
  public String getId() {
    return this.id;
  }
  
  public String getLabel() {
    return this.label;
  }
  
  public String getLastTag() {
    return this.tags.get(tags.size() - 1);
  }
  
  public String getMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getTag(int index) {
    return this.tags.get(index);
  }
  
  public List<String> getTags() {
    return this.tags;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasLabel() {
    return this.label != null;
  }
  
  public boolean hasMatchingSubcategory(Predicate<DeveloperConsoleCatalogCategoryMetaBuilder> predicate) {
      for (DeveloperConsoleCatalogCategoryMetaBuilder item : subcategories) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSubcategories() {
    return this.subcategories != null && !(this.subcategories.isEmpty());
  }
  
  public boolean hasTags() {
    return this.tags != null && !(this.tags.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(id, label, subcategories, tags, additionalProperties);
  }
  
  public A removeAllFromSubcategories(Collection<DeveloperConsoleCatalogCategoryMeta> items) {
    if (this.subcategories == null) {
      return (A) this;
    }
    for (DeveloperConsoleCatalogCategoryMeta item : items) {
        DeveloperConsoleCatalogCategoryMetaBuilder builder = new DeveloperConsoleCatalogCategoryMetaBuilder(item);
        _visitables.get("subcategories").remove(builder);
        this.subcategories.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTags(Collection<String> items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
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
  
  public A removeFromSubcategories(DeveloperConsoleCatalogCategoryMeta... items) {
    if (this.subcategories == null) {
      return (A) this;
    }
    for (DeveloperConsoleCatalogCategoryMeta item : items) {
        DeveloperConsoleCatalogCategoryMetaBuilder builder = new DeveloperConsoleCatalogCategoryMetaBuilder(item);
        _visitables.get("subcategories").remove(builder);
        this.subcategories.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTags(String... items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubcategories(Predicate<DeveloperConsoleCatalogCategoryMetaBuilder> predicate) {
    if (subcategories == null) {
      return (A) this;
    }
    Iterator<DeveloperConsoleCatalogCategoryMetaBuilder> each = subcategories.iterator();
    List visitables = _visitables.get("subcategories");
    while (each.hasNext()) {
        DeveloperConsoleCatalogCategoryMetaBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubcategoriesNested<A> setNewSubcategoryLike(int index,DeveloperConsoleCatalogCategoryMeta item) {
    return new SubcategoriesNested(index, item);
  }
  
  public A setToSubcategories(int index,DeveloperConsoleCatalogCategoryMeta item) {
    if (this.subcategories == null) {
      this.subcategories = new ArrayList();
    }
    DeveloperConsoleCatalogCategoryMetaBuilder builder = new DeveloperConsoleCatalogCategoryMetaBuilder(item);
    if (index < 0 || index >= subcategories.size()) {
        _visitables.get("subcategories").add(builder);
        subcategories.add(builder);
    } else {
        _visitables.get("subcategories").add(builder);
        subcategories.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(label == null)) {
        sb.append("label:");
        sb.append(label);
        sb.append(",");
    }
    if (!(subcategories == null) && !(subcategories.isEmpty())) {
        sb.append("subcategories:");
        sb.append(subcategories);
        sb.append(",");
    }
    if (!(tags == null) && !(tags.isEmpty())) {
        sb.append("tags:");
        sb.append(tags);
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
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public A withLabel(String label) {
    this.label = label;
    return (A) this;
  }
  
  public A withSubcategories(List<DeveloperConsoleCatalogCategoryMeta> subcategories) {
    if (this.subcategories != null) {
      this._visitables.get("subcategories").clear();
    }
    if (subcategories != null) {
        this.subcategories = new ArrayList();
        for (DeveloperConsoleCatalogCategoryMeta item : subcategories) {
          this.addToSubcategories(item);
        }
    } else {
      this.subcategories = null;
    }
    return (A) this;
  }
  
  public A withSubcategories(DeveloperConsoleCatalogCategoryMeta... subcategories) {
    if (this.subcategories != null) {
        this.subcategories.clear();
        _visitables.remove("subcategories");
    }
    if (subcategories != null) {
      for (DeveloperConsoleCatalogCategoryMeta item : subcategories) {
        this.addToSubcategories(item);
      }
    }
    return (A) this;
  }
  
  public A withTags(List<String> tags) {
    if (tags != null) {
        this.tags = new ArrayList();
        for (String item : tags) {
          this.addToTags(item);
        }
    } else {
      this.tags = null;
    }
    return (A) this;
  }
  
  public A withTags(String... tags) {
    if (this.tags != null) {
        this.tags.clear();
        _visitables.remove("tags");
    }
    if (tags != null) {
      for (String item : tags) {
        this.addToTags(item);
      }
    }
    return (A) this;
  }
  public class SubcategoriesNested<N> extends DeveloperConsoleCatalogCategoryMetaFluent<SubcategoriesNested<N>> implements Nested<N>{
  
    DeveloperConsoleCatalogCategoryMetaBuilder builder;
    int index;
  
    SubcategoriesNested(int index,DeveloperConsoleCatalogCategoryMeta item) {
      this.index = index;
      this.builder = new DeveloperConsoleCatalogCategoryMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) DeveloperConsoleCatalogCategoryFluent.this.setToSubcategories(index, builder.build());
    }
    
    public N endSubcategory() {
      return and();
    }
    
  }
}