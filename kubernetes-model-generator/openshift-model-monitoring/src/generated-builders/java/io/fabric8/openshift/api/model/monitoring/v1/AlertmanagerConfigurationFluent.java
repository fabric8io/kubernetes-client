package io.fabric8.openshift.api.model.monitoring.v1;

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
public class AlertmanagerConfigurationFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.AlertmanagerConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AlertmanagerGlobalConfigBuilder global;
  private String name;
  private ArrayList<SecretOrConfigMapBuilder> templates = new ArrayList<SecretOrConfigMapBuilder>();

  public AlertmanagerConfigurationFluent() {
  }
  
  public AlertmanagerConfigurationFluent(AlertmanagerConfiguration instance) {
    this.copyInstance(instance);
  }

  public A addAllToTemplates(Collection<SecretOrConfigMap> items) {
    if (this.templates == null) {
      this.templates = new ArrayList();
    }
    for (SecretOrConfigMap item : items) {
        SecretOrConfigMapBuilder builder = new SecretOrConfigMapBuilder(item);
        _visitables.get("templates").add(builder);
        this.templates.add(builder);
    }
    return (A) this;
  }
  
  public TemplatesNested<A> addNewTemplate() {
    return new TemplatesNested(-1, null);
  }
  
  public TemplatesNested<A> addNewTemplateLike(SecretOrConfigMap item) {
    return new TemplatesNested(-1, item);
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
  
  public A addToTemplates(SecretOrConfigMap... items) {
    if (this.templates == null) {
      this.templates = new ArrayList();
    }
    for (SecretOrConfigMap item : items) {
        SecretOrConfigMapBuilder builder = new SecretOrConfigMapBuilder(item);
        _visitables.get("templates").add(builder);
        this.templates.add(builder);
    }
    return (A) this;
  }
  
  public A addToTemplates(int index,SecretOrConfigMap item) {
    if (this.templates == null) {
      this.templates = new ArrayList();
    }
    SecretOrConfigMapBuilder builder = new SecretOrConfigMapBuilder(item);
    if (index < 0 || index >= templates.size()) {
        _visitables.get("templates").add(builder);
        templates.add(builder);
    } else {
        _visitables.get("templates").add(builder);
        templates.add(index, builder);
    }
    return (A) this;
  }
  
  public SecretOrConfigMap buildFirstTemplate() {
    return this.templates.get(0).build();
  }
  
  public AlertmanagerGlobalConfig buildGlobal() {
    return this.global != null ? this.global.build() : null;
  }
  
  public SecretOrConfigMap buildLastTemplate() {
    return this.templates.get(templates.size() - 1).build();
  }
  
  public SecretOrConfigMap buildMatchingTemplate(Predicate<SecretOrConfigMapBuilder> predicate) {
      for (SecretOrConfigMapBuilder item : templates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SecretOrConfigMap buildTemplate(int index) {
    return this.templates.get(index).build();
  }
  
  public List<SecretOrConfigMap> buildTemplates() {
    return this.templates != null ? build(templates) : null;
  }
  
  protected void copyInstance(AlertmanagerConfiguration instance) {
    instance = instance != null ? instance : new AlertmanagerConfiguration();
    if (instance != null) {
        this.withGlobal(instance.getGlobal());
        this.withName(instance.getName());
        this.withTemplates(instance.getTemplates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TemplatesNested<A> editFirstTemplate() {
    if (templates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "templates"));
    }
    return this.setNewTemplateLike(0, this.buildTemplate(0));
  }
  
  public GlobalNested<A> editGlobal() {
    return this.withNewGlobalLike(Optional.ofNullable(this.buildGlobal()).orElse(null));
  }
  
  public TemplatesNested<A> editLastTemplate() {
    int index = templates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "templates"));
    }
    return this.setNewTemplateLike(index, this.buildTemplate(index));
  }
  
  public TemplatesNested<A> editMatchingTemplate(Predicate<SecretOrConfigMapBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < templates.size();i++) {
      if (predicate.test(templates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "templates"));
    }
    return this.setNewTemplateLike(index, this.buildTemplate(index));
  }
  
  public GlobalNested<A> editOrNewGlobal() {
    return this.withNewGlobalLike(Optional.ofNullable(this.buildGlobal()).orElse(new AlertmanagerGlobalConfigBuilder().build()));
  }
  
  public GlobalNested<A> editOrNewGlobalLike(AlertmanagerGlobalConfig item) {
    return this.withNewGlobalLike(Optional.ofNullable(this.buildGlobal()).orElse(item));
  }
  
  public TemplatesNested<A> editTemplate(int index) {
    if (templates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "templates"));
    }
    return this.setNewTemplateLike(index, this.buildTemplate(index));
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
    AlertmanagerConfigurationFluent that = (AlertmanagerConfigurationFluent) o;
    if (!(Objects.equals(global, that.global))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(templates, that.templates))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGlobal() {
    return this.global != null;
  }
  
  public boolean hasMatchingTemplate(Predicate<SecretOrConfigMapBuilder> predicate) {
      for (SecretOrConfigMapBuilder item : templates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasTemplates() {
    return this.templates != null && !(this.templates.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(global, name, templates, additionalProperties);
  }
  
  public A removeAllFromTemplates(Collection<SecretOrConfigMap> items) {
    if (this.templates == null) {
      return (A) this;
    }
    for (SecretOrConfigMap item : items) {
        SecretOrConfigMapBuilder builder = new SecretOrConfigMapBuilder(item);
        _visitables.get("templates").remove(builder);
        this.templates.remove(builder);
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
  
  public A removeFromTemplates(SecretOrConfigMap... items) {
    if (this.templates == null) {
      return (A) this;
    }
    for (SecretOrConfigMap item : items) {
        SecretOrConfigMapBuilder builder = new SecretOrConfigMapBuilder(item);
        _visitables.get("templates").remove(builder);
        this.templates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTemplates(Predicate<SecretOrConfigMapBuilder> predicate) {
    if (templates == null) {
      return (A) this;
    }
    Iterator<SecretOrConfigMapBuilder> each = templates.iterator();
    List visitables = _visitables.get("templates");
    while (each.hasNext()) {
        SecretOrConfigMapBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TemplatesNested<A> setNewTemplateLike(int index,SecretOrConfigMap item) {
    return new TemplatesNested(index, item);
  }
  
  public A setToTemplates(int index,SecretOrConfigMap item) {
    if (this.templates == null) {
      this.templates = new ArrayList();
    }
    SecretOrConfigMapBuilder builder = new SecretOrConfigMapBuilder(item);
    if (index < 0 || index >= templates.size()) {
        _visitables.get("templates").add(builder);
        templates.add(builder);
    } else {
        _visitables.get("templates").add(builder);
        templates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(global == null)) {
        sb.append("global:");
        sb.append(global);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(templates == null) && !(templates.isEmpty())) {
        sb.append("templates:");
        sb.append(templates);
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
  
  public A withGlobal(AlertmanagerGlobalConfig global) {
    this._visitables.remove("global");
    if (global != null) {
        this.global = new AlertmanagerGlobalConfigBuilder(global);
        this._visitables.get("global").add(this.global);
    } else {
        this.global = null;
        this._visitables.get("global").remove(this.global);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public GlobalNested<A> withNewGlobal() {
    return new GlobalNested(null);
  }
  
  public GlobalNested<A> withNewGlobalLike(AlertmanagerGlobalConfig item) {
    return new GlobalNested(item);
  }
  
  public A withTemplates(List<SecretOrConfigMap> templates) {
    if (this.templates != null) {
      this._visitables.get("templates").clear();
    }
    if (templates != null) {
        this.templates = new ArrayList();
        for (SecretOrConfigMap item : templates) {
          this.addToTemplates(item);
        }
    } else {
      this.templates = null;
    }
    return (A) this;
  }
  
  public A withTemplates(SecretOrConfigMap... templates) {
    if (this.templates != null) {
        this.templates.clear();
        _visitables.remove("templates");
    }
    if (templates != null) {
      for (SecretOrConfigMap item : templates) {
        this.addToTemplates(item);
      }
    }
    return (A) this;
  }
  public class GlobalNested<N> extends AlertmanagerGlobalConfigFluent<GlobalNested<N>> implements Nested<N>{
  
    AlertmanagerGlobalConfigBuilder builder;
  
    GlobalNested(AlertmanagerGlobalConfig item) {
      this.builder = new AlertmanagerGlobalConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerConfigurationFluent.this.withGlobal(builder.build());
    }
    
    public N endGlobal() {
      return and();
    }
    
  }
  public class TemplatesNested<N> extends SecretOrConfigMapFluent<TemplatesNested<N>> implements Nested<N>{
  
    SecretOrConfigMapBuilder builder;
    int index;
  
    TemplatesNested(int index,SecretOrConfigMap item) {
      this.index = index;
      this.builder = new SecretOrConfigMapBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerConfigurationFluent.this.setToTemplates(index, builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}