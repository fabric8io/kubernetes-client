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
public class LogoFluent<A extends io.fabric8.openshift.api.model.operator.v1.LogoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ThemeBuilder> themes = new ArrayList<ThemeBuilder>();
  private String type;

  public LogoFluent() {
  }
  
  public LogoFluent(Logo instance) {
    this.copyInstance(instance);
  }

  public A addAllToThemes(Collection<Theme> items) {
    if (this.themes == null) {
      this.themes = new ArrayList();
    }
    for (Theme item : items) {
        ThemeBuilder builder = new ThemeBuilder(item);
        _visitables.get("themes").add(builder);
        this.themes.add(builder);
    }
    return (A) this;
  }
  
  public ThemesNested<A> addNewTheme() {
    return new ThemesNested(-1, null);
  }
  
  public ThemesNested<A> addNewThemeLike(Theme item) {
    return new ThemesNested(-1, item);
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
  
  public A addToThemes(Theme... items) {
    if (this.themes == null) {
      this.themes = new ArrayList();
    }
    for (Theme item : items) {
        ThemeBuilder builder = new ThemeBuilder(item);
        _visitables.get("themes").add(builder);
        this.themes.add(builder);
    }
    return (A) this;
  }
  
  public A addToThemes(int index,Theme item) {
    if (this.themes == null) {
      this.themes = new ArrayList();
    }
    ThemeBuilder builder = new ThemeBuilder(item);
    if (index < 0 || index >= themes.size()) {
        _visitables.get("themes").add(builder);
        themes.add(builder);
    } else {
        _visitables.get("themes").add(builder);
        themes.add(index, builder);
    }
    return (A) this;
  }
  
  public Theme buildFirstTheme() {
    return this.themes.get(0).build();
  }
  
  public Theme buildLastTheme() {
    return this.themes.get(themes.size() - 1).build();
  }
  
  public Theme buildMatchingTheme(Predicate<ThemeBuilder> predicate) {
      for (ThemeBuilder item : themes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Theme buildTheme(int index) {
    return this.themes.get(index).build();
  }
  
  public List<Theme> buildThemes() {
    return this.themes != null ? build(themes) : null;
  }
  
  protected void copyInstance(Logo instance) {
    instance = instance != null ? instance : new Logo();
    if (instance != null) {
        this.withThemes(instance.getThemes());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ThemesNested<A> editFirstTheme() {
    if (themes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "themes"));
    }
    return this.setNewThemeLike(0, this.buildTheme(0));
  }
  
  public ThemesNested<A> editLastTheme() {
    int index = themes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "themes"));
    }
    return this.setNewThemeLike(index, this.buildTheme(index));
  }
  
  public ThemesNested<A> editMatchingTheme(Predicate<ThemeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < themes.size();i++) {
      if (predicate.test(themes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "themes"));
    }
    return this.setNewThemeLike(index, this.buildTheme(index));
  }
  
  public ThemesNested<A> editTheme(int index) {
    if (themes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "themes"));
    }
    return this.setNewThemeLike(index, this.buildTheme(index));
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
    LogoFluent that = (LogoFluent) o;
    if (!(Objects.equals(themes, that.themes))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingTheme(Predicate<ThemeBuilder> predicate) {
      for (ThemeBuilder item : themes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasThemes() {
    return this.themes != null && !(this.themes.isEmpty());
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(themes, type, additionalProperties);
  }
  
  public A removeAllFromThemes(Collection<Theme> items) {
    if (this.themes == null) {
      return (A) this;
    }
    for (Theme item : items) {
        ThemeBuilder builder = new ThemeBuilder(item);
        _visitables.get("themes").remove(builder);
        this.themes.remove(builder);
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
  
  public A removeFromThemes(Theme... items) {
    if (this.themes == null) {
      return (A) this;
    }
    for (Theme item : items) {
        ThemeBuilder builder = new ThemeBuilder(item);
        _visitables.get("themes").remove(builder);
        this.themes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromThemes(Predicate<ThemeBuilder> predicate) {
    if (themes == null) {
      return (A) this;
    }
    Iterator<ThemeBuilder> each = themes.iterator();
    List visitables = _visitables.get("themes");
    while (each.hasNext()) {
        ThemeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ThemesNested<A> setNewThemeLike(int index,Theme item) {
    return new ThemesNested(index, item);
  }
  
  public A setToThemes(int index,Theme item) {
    if (this.themes == null) {
      this.themes = new ArrayList();
    }
    ThemeBuilder builder = new ThemeBuilder(item);
    if (index < 0 || index >= themes.size()) {
        _visitables.get("themes").add(builder);
        themes.add(builder);
    } else {
        _visitables.get("themes").add(builder);
        themes.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(themes == null) && !(themes.isEmpty())) {
        sb.append("themes:");
        sb.append(themes);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withThemes(List<Theme> themes) {
    if (this.themes != null) {
      this._visitables.get("themes").clear();
    }
    if (themes != null) {
        this.themes = new ArrayList();
        for (Theme item : themes) {
          this.addToThemes(item);
        }
    } else {
      this.themes = null;
    }
    return (A) this;
  }
  
  public A withThemes(Theme... themes) {
    if (this.themes != null) {
        this.themes.clear();
        _visitables.remove("themes");
    }
    if (themes != null) {
      for (Theme item : themes) {
        this.addToThemes(item);
      }
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ThemesNested<N> extends ThemeFluent<ThemesNested<N>> implements Nested<N>{
  
    ThemeBuilder builder;
    int index;
  
    ThemesNested(int index,Theme item) {
      this.index = index;
      this.builder = new ThemeBuilder(this, item);
    }
  
    public N and() {
      return (N) LogoFluent.this.setToThemes(index, builder.build());
    }
    
    public N endTheme() {
      return and();
    }
    
  }
}