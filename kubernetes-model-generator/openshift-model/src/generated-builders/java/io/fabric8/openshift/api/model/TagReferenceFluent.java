package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Boolean;
import java.lang.Long;
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
public class TagReferenceFluent<A extends io.fabric8.openshift.api.model.TagReferenceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private ObjectReferenceBuilder from;
  private Long generation;
  private TagImportPolicyBuilder importPolicy;
  private String name;
  private Boolean reference;
  private TagReferencePolicyBuilder referencePolicy;

  public TagReferenceFluent() {
  }
  
  public TagReferenceFluent(TagReference instance) {
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
  
  public A addToAnnotations(Map<String,String> map) {
    if (this.annotations == null && map != null) {
      this.annotations = new LinkedHashMap();
    }
    if (map != null) {
      this.annotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAnnotations(String key,String value) {
    if (this.annotations == null && key != null && value != null) {
      this.annotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.annotations.put(key, value);
    }
    return (A) this;
  }
  
  public ObjectReference buildFrom() {
    return this.from != null ? this.from.build() : null;
  }
  
  public TagImportPolicy buildImportPolicy() {
    return this.importPolicy != null ? this.importPolicy.build() : null;
  }
  
  public TagReferencePolicy buildReferencePolicy() {
    return this.referencePolicy != null ? this.referencePolicy.build() : null;
  }
  
  protected void copyInstance(TagReference instance) {
    instance = instance != null ? instance : new TagReference();
    if (instance != null) {
        this.withAnnotations(instance.getAnnotations());
        this.withFrom(instance.getFrom());
        this.withGeneration(instance.getGeneration());
        this.withImportPolicy(instance.getImportPolicy());
        this.withName(instance.getName());
        this.withReference(instance.getReference());
        this.withReferencePolicy(instance.getReferencePolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FromNested<A> editFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(null));
  }
  
  public ImportPolicyNested<A> editImportPolicy() {
    return this.withNewImportPolicyLike(Optional.ofNullable(this.buildImportPolicy()).orElse(null));
  }
  
  public FromNested<A> editOrNewFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public FromNested<A> editOrNewFromLike(ObjectReference item) {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(item));
  }
  
  public ImportPolicyNested<A> editOrNewImportPolicy() {
    return this.withNewImportPolicyLike(Optional.ofNullable(this.buildImportPolicy()).orElse(new TagImportPolicyBuilder().build()));
  }
  
  public ImportPolicyNested<A> editOrNewImportPolicyLike(TagImportPolicy item) {
    return this.withNewImportPolicyLike(Optional.ofNullable(this.buildImportPolicy()).orElse(item));
  }
  
  public ReferencePolicyNested<A> editOrNewReferencePolicy() {
    return this.withNewReferencePolicyLike(Optional.ofNullable(this.buildReferencePolicy()).orElse(new TagReferencePolicyBuilder().build()));
  }
  
  public ReferencePolicyNested<A> editOrNewReferencePolicyLike(TagReferencePolicy item) {
    return this.withNewReferencePolicyLike(Optional.ofNullable(this.buildReferencePolicy()).orElse(item));
  }
  
  public ReferencePolicyNested<A> editReferencePolicy() {
    return this.withNewReferencePolicyLike(Optional.ofNullable(this.buildReferencePolicy()).orElse(null));
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
    TagReferenceFluent that = (TagReferenceFluent) o;
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(generation, that.generation))) {
      return false;
    }
    if (!(Objects.equals(importPolicy, that.importPolicy))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(reference, that.reference))) {
      return false;
    }
    if (!(Objects.equals(referencePolicy, that.referencePolicy))) {
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
  
  public Map<String,String> getAnnotations() {
    return this.annotations;
  }
  
  public Long getGeneration() {
    return this.generation;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Boolean getReference() {
    return this.reference;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasGeneration() {
    return this.generation != null;
  }
  
  public boolean hasImportPolicy() {
    return this.importPolicy != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasReference() {
    return this.reference != null;
  }
  
  public boolean hasReferencePolicy() {
    return this.referencePolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(annotations, from, generation, importPolicy, name, reference, referencePolicy, additionalProperties);
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
  
  public A removeFromAnnotations(String key) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (key != null && this.annotations != null) {
      this.annotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAnnotations(Map<String,String> map) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.annotations != null) {
          this.annotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(annotations == null) && !(annotations.isEmpty())) {
        sb.append("annotations:");
        sb.append(annotations);
        sb.append(",");
    }
    if (!(from == null)) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(generation == null)) {
        sb.append("generation:");
        sb.append(generation);
        sb.append(",");
    }
    if (!(importPolicy == null)) {
        sb.append("importPolicy:");
        sb.append(importPolicy);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(reference == null)) {
        sb.append("reference:");
        sb.append(reference);
        sb.append(",");
    }
    if (!(referencePolicy == null)) {
        sb.append("referencePolicy:");
        sb.append(referencePolicy);
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
  
  public <K,V>A withAnnotations(Map<String,String> annotations) {
    if (annotations == null) {
      this.annotations = null;
    } else {
      this.annotations = new LinkedHashMap(annotations);
    }
    return (A) this;
  }
  
  public A withFrom(ObjectReference from) {
    this._visitables.remove("from");
    if (from != null) {
        this.from = new ObjectReferenceBuilder(from);
        this._visitables.get("from").add(this.from);
    } else {
        this.from = null;
        this._visitables.get("from").remove(this.from);
    }
    return (A) this;
  }
  
  public A withGeneration(Long generation) {
    this.generation = generation;
    return (A) this;
  }
  
  public A withImportPolicy(TagImportPolicy importPolicy) {
    this._visitables.remove("importPolicy");
    if (importPolicy != null) {
        this.importPolicy = new TagImportPolicyBuilder(importPolicy);
        this._visitables.get("importPolicy").add(this.importPolicy);
    } else {
        this.importPolicy = null;
        this._visitables.get("importPolicy").remove(this.importPolicy);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public FromNested<A> withNewFrom() {
    return new FromNested(null);
  }
  
  public FromNested<A> withNewFromLike(ObjectReference item) {
    return new FromNested(item);
  }
  
  public ImportPolicyNested<A> withNewImportPolicy() {
    return new ImportPolicyNested(null);
  }
  
  public A withNewImportPolicy(String importMode,Boolean insecure,Boolean scheduled) {
    return (A) this.withImportPolicy(new TagImportPolicy(importMode, insecure, scheduled));
  }
  
  public ImportPolicyNested<A> withNewImportPolicyLike(TagImportPolicy item) {
    return new ImportPolicyNested(item);
  }
  
  public ReferencePolicyNested<A> withNewReferencePolicy() {
    return new ReferencePolicyNested(null);
  }
  
  public A withNewReferencePolicy(String type) {
    return (A) this.withReferencePolicy(new TagReferencePolicy(type));
  }
  
  public ReferencePolicyNested<A> withNewReferencePolicyLike(TagReferencePolicy item) {
    return new ReferencePolicyNested(item);
  }
  
  public A withReference() {
    return withReference(true);
  }
  
  public A withReference(Boolean reference) {
    this.reference = reference;
    return (A) this;
  }
  
  public A withReferencePolicy(TagReferencePolicy referencePolicy) {
    this._visitables.remove("referencePolicy");
    if (referencePolicy != null) {
        this.referencePolicy = new TagReferencePolicyBuilder(referencePolicy);
        this._visitables.get("referencePolicy").add(this.referencePolicy);
    } else {
        this.referencePolicy = null;
        this._visitables.get("referencePolicy").remove(this.referencePolicy);
    }
    return (A) this;
  }
  public class FromNested<N> extends ObjectReferenceFluent<FromNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    FromNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) TagReferenceFluent.this.withFrom(builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
  public class ImportPolicyNested<N> extends TagImportPolicyFluent<ImportPolicyNested<N>> implements Nested<N>{
  
    TagImportPolicyBuilder builder;
  
    ImportPolicyNested(TagImportPolicy item) {
      this.builder = new TagImportPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) TagReferenceFluent.this.withImportPolicy(builder.build());
    }
    
    public N endImportPolicy() {
      return and();
    }
    
  }
  public class ReferencePolicyNested<N> extends TagReferencePolicyFluent<ReferencePolicyNested<N>> implements Nested<N>{
  
    TagReferencePolicyBuilder builder;
  
    ReferencePolicyNested(TagReferencePolicy item) {
      this.builder = new TagReferencePolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) TagReferenceFluent.this.withReferencePolicy(builder.build());
    }
    
    public N endReferencePolicy() {
      return and();
    }
    
  }
}