package io.fabric8.kubernetes.api.model.authorization.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ResourceAttributesFluent<A extends io.fabric8.kubernetes.api.model.authorization.v1.ResourceAttributesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private FieldSelectorAttributesBuilder fieldSelector;
  private String group;
  private LabelSelectorAttributesBuilder labelSelector;
  private String name;
  private String namespace;
  private String resource;
  private String subresource;
  private String verb;
  private String version;

  public ResourceAttributesFluent() {
  }
  
  public ResourceAttributesFluent(ResourceAttributes instance) {
    this.copyInstance(instance);
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
  
  public FieldSelectorAttributes buildFieldSelector() {
    return this.fieldSelector != null ? this.fieldSelector.build() : null;
  }
  
  public LabelSelectorAttributes buildLabelSelector() {
    return this.labelSelector != null ? this.labelSelector.build() : null;
  }
  
  protected void copyInstance(ResourceAttributes instance) {
    instance = instance != null ? instance : new ResourceAttributes();
    if (instance != null) {
        this.withFieldSelector(instance.getFieldSelector());
        this.withGroup(instance.getGroup());
        this.withLabelSelector(instance.getLabelSelector());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withResource(instance.getResource());
        this.withSubresource(instance.getSubresource());
        this.withVerb(instance.getVerb());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FieldSelectorNested<A> editFieldSelector() {
    return this.withNewFieldSelectorLike(Optional.ofNullable(this.buildFieldSelector()).orElse(null));
  }
  
  public LabelSelectorNested<A> editLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(null));
  }
  
  public FieldSelectorNested<A> editOrNewFieldSelector() {
    return this.withNewFieldSelectorLike(Optional.ofNullable(this.buildFieldSelector()).orElse(new FieldSelectorAttributesBuilder().build()));
  }
  
  public FieldSelectorNested<A> editOrNewFieldSelectorLike(FieldSelectorAttributes item) {
    return this.withNewFieldSelectorLike(Optional.ofNullable(this.buildFieldSelector()).orElse(item));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(new LabelSelectorAttributesBuilder().build()));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelectorLike(LabelSelectorAttributes item) {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(item));
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
    ResourceAttributesFluent that = (ResourceAttributesFluent) o;
    if (!(Objects.equals(fieldSelector, that.fieldSelector))) {
      return false;
    }
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(labelSelector, that.labelSelector))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(resource, that.resource))) {
      return false;
    }
    if (!(Objects.equals(subresource, that.subresource))) {
      return false;
    }
    if (!(Objects.equals(verb, that.verb))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getGroup() {
    return this.group;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getResource() {
    return this.resource;
  }
  
  public String getSubresource() {
    return this.subresource;
  }
  
  public String getVerb() {
    return this.verb;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFieldSelector() {
    return this.fieldSelector != null;
  }
  
  public boolean hasGroup() {
    return this.group != null;
  }
  
  public boolean hasLabelSelector() {
    return this.labelSelector != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasResource() {
    return this.resource != null;
  }
  
  public boolean hasSubresource() {
    return this.subresource != null;
  }
  
  public boolean hasVerb() {
    return this.verb != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(fieldSelector, group, labelSelector, name, namespace, resource, subresource, verb, version, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(fieldSelector == null)) {
        sb.append("fieldSelector:");
        sb.append(fieldSelector);
        sb.append(",");
    }
    if (!(group == null)) {
        sb.append("group:");
        sb.append(group);
        sb.append(",");
    }
    if (!(labelSelector == null)) {
        sb.append("labelSelector:");
        sb.append(labelSelector);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(resource == null)) {
        sb.append("resource:");
        sb.append(resource);
        sb.append(",");
    }
    if (!(subresource == null)) {
        sb.append("subresource:");
        sb.append(subresource);
        sb.append(",");
    }
    if (!(verb == null)) {
        sb.append("verb:");
        sb.append(verb);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withFieldSelector(FieldSelectorAttributes fieldSelector) {
    this._visitables.remove("fieldSelector");
    if (fieldSelector != null) {
        this.fieldSelector = new FieldSelectorAttributesBuilder(fieldSelector);
        this._visitables.get("fieldSelector").add(this.fieldSelector);
    } else {
        this.fieldSelector = null;
        this._visitables.get("fieldSelector").remove(this.fieldSelector);
    }
    return (A) this;
  }
  
  public A withGroup(String group) {
    this.group = group;
    return (A) this;
  }
  
  public A withLabelSelector(LabelSelectorAttributes labelSelector) {
    this._visitables.remove("labelSelector");
    if (labelSelector != null) {
        this.labelSelector = new LabelSelectorAttributesBuilder(labelSelector);
        this._visitables.get("labelSelector").add(this.labelSelector);
    } else {
        this.labelSelector = null;
        this._visitables.get("labelSelector").remove(this.labelSelector);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public FieldSelectorNested<A> withNewFieldSelector() {
    return new FieldSelectorNested(null);
  }
  
  public FieldSelectorNested<A> withNewFieldSelectorLike(FieldSelectorAttributes item) {
    return new FieldSelectorNested(item);
  }
  
  public LabelSelectorNested<A> withNewLabelSelector() {
    return new LabelSelectorNested(null);
  }
  
  public LabelSelectorNested<A> withNewLabelSelectorLike(LabelSelectorAttributes item) {
    return new LabelSelectorNested(item);
  }
  
  public A withResource(String resource) {
    this.resource = resource;
    return (A) this;
  }
  
  public A withSubresource(String subresource) {
    this.subresource = subresource;
    return (A) this;
  }
  
  public A withVerb(String verb) {
    this.verb = verb;
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class FieldSelectorNested<N> extends FieldSelectorAttributesFluent<FieldSelectorNested<N>> implements Nested<N>{
  
    FieldSelectorAttributesBuilder builder;
  
    FieldSelectorNested(FieldSelectorAttributes item) {
      this.builder = new FieldSelectorAttributesBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceAttributesFluent.this.withFieldSelector(builder.build());
    }
    
    public N endFieldSelector() {
      return and();
    }
    
  }
  public class LabelSelectorNested<N> extends LabelSelectorAttributesFluent<LabelSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorAttributesBuilder builder;
  
    LabelSelectorNested(LabelSelectorAttributes item) {
      this.builder = new LabelSelectorAttributesBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceAttributesFluent.this.withLabelSelector(builder.build());
    }
    
    public N endLabelSelector() {
      return and();
    }
    
  }
}