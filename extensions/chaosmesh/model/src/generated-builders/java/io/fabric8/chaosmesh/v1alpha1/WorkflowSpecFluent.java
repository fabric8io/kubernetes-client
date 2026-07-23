package io.fabric8.chaosmesh.v1alpha1;

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
public class WorkflowSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.WorkflowSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String entry;
  private ArrayList<TemplateBuilder> templates = new ArrayList<TemplateBuilder>();

  public WorkflowSpecFluent() {
  }
  
  public WorkflowSpecFluent(WorkflowSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTemplates(Collection<Template> items) {
    if (this.templates == null) {
      this.templates = new ArrayList();
    }
    for (Template item : items) {
        TemplateBuilder builder = new TemplateBuilder(item);
        _visitables.get("templates").add(builder);
        this.templates.add(builder);
    }
    return (A) this;
  }
  
  public TemplatesNested<A> addNewTemplate() {
    return new TemplatesNested(-1, null);
  }
  
  public TemplatesNested<A> addNewTemplateLike(Template item) {
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
  
  public A addToTemplates(Template... items) {
    if (this.templates == null) {
      this.templates = new ArrayList();
    }
    for (Template item : items) {
        TemplateBuilder builder = new TemplateBuilder(item);
        _visitables.get("templates").add(builder);
        this.templates.add(builder);
    }
    return (A) this;
  }
  
  public A addToTemplates(int index,Template item) {
    if (this.templates == null) {
      this.templates = new ArrayList();
    }
    TemplateBuilder builder = new TemplateBuilder(item);
    if (index < 0 || index >= templates.size()) {
        _visitables.get("templates").add(builder);
        templates.add(builder);
    } else {
        _visitables.get("templates").add(builder);
        templates.add(index, builder);
    }
    return (A) this;
  }
  
  public Template buildFirstTemplate() {
    return this.templates.get(0).build();
  }
  
  public Template buildLastTemplate() {
    return this.templates.get(templates.size() - 1).build();
  }
  
  public Template buildMatchingTemplate(Predicate<TemplateBuilder> predicate) {
      for (TemplateBuilder item : templates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Template buildTemplate(int index) {
    return this.templates.get(index).build();
  }
  
  public List<Template> buildTemplates() {
    return this.templates != null ? build(templates) : null;
  }
  
  protected void copyInstance(WorkflowSpec instance) {
    instance = instance != null ? instance : new WorkflowSpec();
    if (instance != null) {
        this.withEntry(instance.getEntry());
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
  
  public TemplatesNested<A> editLastTemplate() {
    int index = templates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "templates"));
    }
    return this.setNewTemplateLike(index, this.buildTemplate(index));
  }
  
  public TemplatesNested<A> editMatchingTemplate(Predicate<TemplateBuilder> predicate) {
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
    WorkflowSpecFluent that = (WorkflowSpecFluent) o;
    if (!(Objects.equals(entry, that.entry))) {
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
  
  public String getEntry() {
    return this.entry;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEntry() {
    return this.entry != null;
  }
  
  public boolean hasMatchingTemplate(Predicate<TemplateBuilder> predicate) {
      for (TemplateBuilder item : templates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTemplates() {
    return this.templates != null && !(this.templates.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(entry, templates, additionalProperties);
  }
  
  public A removeAllFromTemplates(Collection<Template> items) {
    if (this.templates == null) {
      return (A) this;
    }
    for (Template item : items) {
        TemplateBuilder builder = new TemplateBuilder(item);
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
  
  public A removeFromTemplates(Template... items) {
    if (this.templates == null) {
      return (A) this;
    }
    for (Template item : items) {
        TemplateBuilder builder = new TemplateBuilder(item);
        _visitables.get("templates").remove(builder);
        this.templates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTemplates(Predicate<TemplateBuilder> predicate) {
    if (templates == null) {
      return (A) this;
    }
    Iterator<TemplateBuilder> each = templates.iterator();
    List visitables = _visitables.get("templates");
    while (each.hasNext()) {
        TemplateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TemplatesNested<A> setNewTemplateLike(int index,Template item) {
    return new TemplatesNested(index, item);
  }
  
  public A setToTemplates(int index,Template item) {
    if (this.templates == null) {
      this.templates = new ArrayList();
    }
    TemplateBuilder builder = new TemplateBuilder(item);
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
    if (!(entry == null)) {
        sb.append("entry:");
        sb.append(entry);
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
  
  public A withEntry(String entry) {
    this.entry = entry;
    return (A) this;
  }
  
  public A withTemplates(List<Template> templates) {
    if (this.templates != null) {
      this._visitables.get("templates").clear();
    }
    if (templates != null) {
        this.templates = new ArrayList();
        for (Template item : templates) {
          this.addToTemplates(item);
        }
    } else {
      this.templates = null;
    }
    return (A) this;
  }
  
  public A withTemplates(Template... templates) {
    if (this.templates != null) {
        this.templates.clear();
        _visitables.remove("templates");
    }
    if (templates != null) {
      for (Template item : templates) {
        this.addToTemplates(item);
      }
    }
    return (A) this;
  }
  public class TemplatesNested<N> extends TemplateFluent<TemplatesNested<N>> implements Nested<N>{
  
    TemplateBuilder builder;
    int index;
  
    TemplatesNested(int index,Template item) {
      this.index = index;
      this.builder = new TemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkflowSpecFluent.this.setToTemplates(index, builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}