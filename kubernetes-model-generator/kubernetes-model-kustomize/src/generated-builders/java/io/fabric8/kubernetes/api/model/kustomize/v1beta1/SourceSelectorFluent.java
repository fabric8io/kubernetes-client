package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
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
public class SourceSelectorFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.SourceSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String fieldPath;
  private String group;
  private String kind;
  private String name;
  private String namespace;
  private FieldOptionsBuilder options;
  private String version;

  public SourceSelectorFluent() {
  }
  
  public SourceSelectorFluent(SourceSelector instance) {
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
  
  public FieldOptions buildOptions() {
    return this.options != null ? this.options.build() : null;
  }
  
  protected void copyInstance(SourceSelector instance) {
    instance = instance != null ? instance : new SourceSelector();
    if (instance != null) {
        this.withFieldPath(instance.getFieldPath());
        this.withGroup(instance.getGroup());
        this.withKind(instance.getKind());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withOptions(instance.getOptions());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OptionsNested<A> editOptions() {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(null));
  }
  
  public OptionsNested<A> editOrNewOptions() {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(new FieldOptionsBuilder().build()));
  }
  
  public OptionsNested<A> editOrNewOptionsLike(FieldOptions item) {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(item));
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
    SourceSelectorFluent that = (SourceSelectorFluent) o;
    if (!(Objects.equals(fieldPath, that.fieldPath))) {
      return false;
    }
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(options, that.options))) {
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
  
  public String getFieldPath() {
    return this.fieldPath;
  }
  
  public String getGroup() {
    return this.group;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFieldPath() {
    return this.fieldPath != null;
  }
  
  public boolean hasGroup() {
    return this.group != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasOptions() {
    return this.options != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(fieldPath, group, kind, name, namespace, options, version, additionalProperties);
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
    if (!(fieldPath == null)) {
        sb.append("fieldPath:");
        sb.append(fieldPath);
        sb.append(",");
    }
    if (!(group == null)) {
        sb.append("group:");
        sb.append(group);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
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
    if (!(options == null)) {
        sb.append("options:");
        sb.append(options);
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
  
  public A withFieldPath(String fieldPath) {
    this.fieldPath = fieldPath;
    return (A) this;
  }
  
  public A withGroup(String group) {
    this.group = group;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
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
  
  public OptionsNested<A> withNewOptions() {
    return new OptionsNested(null);
  }
  
  public A withNewOptions(Boolean create,String delimiter,String encoding,Integer index) {
    return (A) this.withOptions(new FieldOptions(create, delimiter, encoding, index));
  }
  
  public OptionsNested<A> withNewOptionsLike(FieldOptions item) {
    return new OptionsNested(item);
  }
  
  public A withOptions(FieldOptions options) {
    this._visitables.remove("options");
    if (options != null) {
        this.options = new FieldOptionsBuilder(options);
        this._visitables.get("options").add(this.options);
    } else {
        this.options = null;
        this._visitables.get("options").remove(this.options);
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class OptionsNested<N> extends FieldOptionsFluent<OptionsNested<N>> implements Nested<N>{
  
    FieldOptionsBuilder builder;
  
    OptionsNested(FieldOptions item) {
      this.builder = new FieldOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) SourceSelectorFluent.this.withOptions(builder.build());
    }
    
    public N endOptions() {
      return and();
    }
    
  }
}