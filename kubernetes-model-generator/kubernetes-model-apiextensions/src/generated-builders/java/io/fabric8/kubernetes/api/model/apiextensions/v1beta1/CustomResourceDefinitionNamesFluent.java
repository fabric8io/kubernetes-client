package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

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
public class CustomResourceDefinitionNamesFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionNamesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> categories = new ArrayList<String>();
  private String kind;
  private String listKind;
  private String plural;
  private List<String> shortNames = new ArrayList<String>();
  private String singular;

  public CustomResourceDefinitionNamesFluent() {
  }
  
  public CustomResourceDefinitionNamesFluent(CustomResourceDefinitionNames instance) {
    this.copyInstance(instance);
  }

  public A addAllToCategories(Collection<String> items) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    for (String item : items) {
      this.categories.add(item);
    }
    return (A) this;
  }
  
  public A addAllToShortNames(Collection<String> items) {
    if (this.shortNames == null) {
      this.shortNames = new ArrayList();
    }
    for (String item : items) {
      this.shortNames.add(item);
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
  
  public A addToCategories(String... items) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    for (String item : items) {
      this.categories.add(item);
    }
    return (A) this;
  }
  
  public A addToCategories(int index,String item) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    this.categories.add(index, item);
    return (A) this;
  }
  
  public A addToShortNames(String... items) {
    if (this.shortNames == null) {
      this.shortNames = new ArrayList();
    }
    for (String item : items) {
      this.shortNames.add(item);
    }
    return (A) this;
  }
  
  public A addToShortNames(int index,String item) {
    if (this.shortNames == null) {
      this.shortNames = new ArrayList();
    }
    this.shortNames.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(CustomResourceDefinitionNames instance) {
    instance = instance != null ? instance : new CustomResourceDefinitionNames();
    if (instance != null) {
        this.withCategories(instance.getCategories());
        this.withKind(instance.getKind());
        this.withListKind(instance.getListKind());
        this.withPlural(instance.getPlural());
        this.withShortNames(instance.getShortNames());
        this.withSingular(instance.getSingular());
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
    CustomResourceDefinitionNamesFluent that = (CustomResourceDefinitionNamesFluent) o;
    if (!(Objects.equals(categories, that.categories))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(listKind, that.listKind))) {
      return false;
    }
    if (!(Objects.equals(plural, that.plural))) {
      return false;
    }
    if (!(Objects.equals(shortNames, that.shortNames))) {
      return false;
    }
    if (!(Objects.equals(singular, that.singular))) {
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
  
  public List<String> getCategories() {
    return this.categories;
  }
  
  public String getCategory(int index) {
    return this.categories.get(index);
  }
  
  public String getFirstCategory() {
    return this.categories.get(0);
  }
  
  public String getFirstShortName() {
    return this.shortNames.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastCategory() {
    return this.categories.get(categories.size() - 1);
  }
  
  public String getLastShortName() {
    return this.shortNames.get(shortNames.size() - 1);
  }
  
  public String getListKind() {
    return this.listKind;
  }
  
  public String getMatchingCategory(Predicate<String> predicate) {
      for (String item : categories) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingShortName(Predicate<String> predicate) {
      for (String item : shortNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPlural() {
    return this.plural;
  }
  
  public String getShortName(int index) {
    return this.shortNames.get(index);
  }
  
  public List<String> getShortNames() {
    return this.shortNames;
  }
  
  public String getSingular() {
    return this.singular;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCategories() {
    return this.categories != null && !(this.categories.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasListKind() {
    return this.listKind != null;
  }
  
  public boolean hasMatchingCategory(Predicate<String> predicate) {
      for (String item : categories) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingShortName(Predicate<String> predicate) {
      for (String item : shortNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPlural() {
    return this.plural != null;
  }
  
  public boolean hasShortNames() {
    return this.shortNames != null && !(this.shortNames.isEmpty());
  }
  
  public boolean hasSingular() {
    return this.singular != null;
  }
  
  public int hashCode() {
    return Objects.hash(categories, kind, listKind, plural, shortNames, singular, additionalProperties);
  }
  
  public A removeAllFromCategories(Collection<String> items) {
    if (this.categories == null) {
      return (A) this;
    }
    for (String item : items) {
      this.categories.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromShortNames(Collection<String> items) {
    if (this.shortNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.shortNames.remove(item);
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
  
  public A removeFromCategories(String... items) {
    if (this.categories == null) {
      return (A) this;
    }
    for (String item : items) {
      this.categories.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromShortNames(String... items) {
    if (this.shortNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.shortNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToCategories(int index,String item) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    this.categories.set(index, item);
    return (A) this;
  }
  
  public A setToShortNames(int index,String item) {
    if (this.shortNames == null) {
      this.shortNames = new ArrayList();
    }
    this.shortNames.set(index, item);
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
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(listKind == null)) {
        sb.append("listKind:");
        sb.append(listKind);
        sb.append(",");
    }
    if (!(plural == null)) {
        sb.append("plural:");
        sb.append(plural);
        sb.append(",");
    }
    if (!(shortNames == null) && !(shortNames.isEmpty())) {
        sb.append("shortNames:");
        sb.append(shortNames);
        sb.append(",");
    }
    if (!(singular == null)) {
        sb.append("singular:");
        sb.append(singular);
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
  
  public A withCategories(List<String> categories) {
    if (categories != null) {
        this.categories = new ArrayList();
        for (String item : categories) {
          this.addToCategories(item);
        }
    } else {
      this.categories = null;
    }
    return (A) this;
  }
  
  public A withCategories(String... categories) {
    if (this.categories != null) {
        this.categories.clear();
        _visitables.remove("categories");
    }
    if (categories != null) {
      for (String item : categories) {
        this.addToCategories(item);
      }
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withListKind(String listKind) {
    this.listKind = listKind;
    return (A) this;
  }
  
  public A withPlural(String plural) {
    this.plural = plural;
    return (A) this;
  }
  
  public A withShortNames(List<String> shortNames) {
    if (shortNames != null) {
        this.shortNames = new ArrayList();
        for (String item : shortNames) {
          this.addToShortNames(item);
        }
    } else {
      this.shortNames = null;
    }
    return (A) this;
  }
  
  public A withShortNames(String... shortNames) {
    if (this.shortNames != null) {
        this.shortNames.clear();
        _visitables.remove("shortNames");
    }
    if (shortNames != null) {
      for (String item : shortNames) {
        this.addToShortNames(item);
      }
    }
    return (A) this;
  }
  
  public A withSingular(String singular) {
    this.singular = singular;
    return (A) this;
  }
  
}