package io.fabric8.knative.duck.v1beta1;

import io.fabric8.knative.pkg.tracker.Reference;
import io.fabric8.knative.pkg.tracker.ReferenceBuilder;
import io.fabric8.knative.pkg.tracker.ReferenceFluent;
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
public class BindingSpecFluent<A extends io.fabric8.knative.duck.v1beta1.BindingSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ReferenceBuilder subject;

  public BindingSpecFluent() {
  }
  
  public BindingSpecFluent(BindingSpec instance) {
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
  
  public Reference buildSubject() {
    return this.subject != null ? this.subject.build() : null;
  }
  
  protected void copyInstance(BindingSpec instance) {
    instance = instance != null ? instance : new BindingSpec();
    if (instance != null) {
        this.withSubject(instance.getSubject());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SubjectNested<A> editOrNewSubject() {
    return this.withNewSubjectLike(Optional.ofNullable(this.buildSubject()).orElse(new ReferenceBuilder().build()));
  }
  
  public SubjectNested<A> editOrNewSubjectLike(Reference item) {
    return this.withNewSubjectLike(Optional.ofNullable(this.buildSubject()).orElse(item));
  }
  
  public SubjectNested<A> editSubject() {
    return this.withNewSubjectLike(Optional.ofNullable(this.buildSubject()).orElse(null));
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
    BindingSpecFluent that = (BindingSpecFluent) o;
    if (!(Objects.equals(subject, that.subject))) {
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
  
  public boolean hasSubject() {
    return this.subject != null;
  }
  
  public int hashCode() {
    return Objects.hash(subject, additionalProperties);
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
    if (!(subject == null)) {
        sb.append("subject:");
        sb.append(subject);
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
  
  public SubjectNested<A> withNewSubject() {
    return new SubjectNested(null);
  }
  
  public SubjectNested<A> withNewSubjectLike(Reference item) {
    return new SubjectNested(item);
  }
  
  public A withSubject(Reference subject) {
    this._visitables.remove("subject");
    if (subject != null) {
        this.subject = new ReferenceBuilder(subject);
        this._visitables.get("subject").add(this.subject);
    } else {
        this.subject = null;
        this._visitables.get("subject").remove(this.subject);
    }
    return (A) this;
  }
  public class SubjectNested<N> extends ReferenceFluent<SubjectNested<N>> implements Nested<N>{
  
    ReferenceBuilder builder;
  
    SubjectNested(Reference item) {
      this.builder = new ReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BindingSpecFluent.this.withSubject(builder.build());
    }
    
    public N endSubject() {
      return and();
    }
    
  }
}