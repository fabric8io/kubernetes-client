package io.fabric8.istio.api.api.analysis.v1alpha1;

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
public class AnalysisMessageBaseFluent<A extends io.fabric8.istio.api.api.analysis.v1alpha1.AnalysisMessageBaseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String documentationUrl;
  private AnalysisMessageBaseLevel level;
  private AnalysisMessageBaseTypeBuilder type;

  public AnalysisMessageBaseFluent() {
  }
  
  public AnalysisMessageBaseFluent(AnalysisMessageBase instance) {
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
  
  public AnalysisMessageBaseType buildType() {
    return this.type != null ? this.type.build() : null;
  }
  
  protected void copyInstance(AnalysisMessageBase instance) {
    instance = instance != null ? instance : new AnalysisMessageBase();
    if (instance != null) {
        this.withDocumentationUrl(instance.getDocumentationUrl());
        this.withLevel(instance.getLevel());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TypeNested<A> editOrNewType() {
    return this.withNewTypeLike(Optional.ofNullable(this.buildType()).orElse(new AnalysisMessageBaseTypeBuilder().build()));
  }
  
  public TypeNested<A> editOrNewTypeLike(AnalysisMessageBaseType item) {
    return this.withNewTypeLike(Optional.ofNullable(this.buildType()).orElse(item));
  }
  
  public TypeNested<A> editType() {
    return this.withNewTypeLike(Optional.ofNullable(this.buildType()).orElse(null));
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
    AnalysisMessageBaseFluent that = (AnalysisMessageBaseFluent) o;
    if (!(Objects.equals(documentationUrl, that.documentationUrl))) {
      return false;
    }
    if (!(Objects.equals(level, that.level))) {
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
  
  public String getDocumentationUrl() {
    return this.documentationUrl;
  }
  
  public AnalysisMessageBaseLevel getLevel() {
    return this.level;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDocumentationUrl() {
    return this.documentationUrl != null;
  }
  
  public boolean hasLevel() {
    return this.level != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(documentationUrl, level, type, additionalProperties);
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
    if (!(documentationUrl == null)) {
        sb.append("documentationUrl:");
        sb.append(documentationUrl);
        sb.append(",");
    }
    if (!(level == null)) {
        sb.append("level:");
        sb.append(level);
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
  
  public A withDocumentationUrl(String documentationUrl) {
    this.documentationUrl = documentationUrl;
    return (A) this;
  }
  
  public A withLevel(AnalysisMessageBaseLevel level) {
    this.level = level;
    return (A) this;
  }
  
  public TypeNested<A> withNewType() {
    return new TypeNested(null);
  }
  
  public A withNewType(String code,String name) {
    return (A) this.withType(new AnalysisMessageBaseType(code, name));
  }
  
  public TypeNested<A> withNewTypeLike(AnalysisMessageBaseType item) {
    return new TypeNested(item);
  }
  
  public A withType(AnalysisMessageBaseType type) {
    this._visitables.remove("type");
    if (type != null) {
        this.type = new AnalysisMessageBaseTypeBuilder(type);
        this._visitables.get("type").add(this.type);
    } else {
        this.type = null;
        this._visitables.get("type").remove(this.type);
    }
    return (A) this;
  }
  public class TypeNested<N> extends AnalysisMessageBaseTypeFluent<TypeNested<N>> implements Nested<N>{
  
    AnalysisMessageBaseTypeBuilder builder;
  
    TypeNested(AnalysisMessageBaseType item) {
      this.builder = new AnalysisMessageBaseTypeBuilder(this, item);
    }
  
    public N and() {
      return (N) AnalysisMessageBaseFluent.this.withType(builder.build());
    }
    
    public N endType() {
      return and();
    }
    
  }
}