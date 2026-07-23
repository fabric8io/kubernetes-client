package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Boolean;
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
public class ImageImportSpecFluent<A extends io.fabric8.openshift.api.model.ImageImportSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder from;
  private TagImportPolicyBuilder importPolicy;
  private Boolean includeManifest;
  private TagReferencePolicyBuilder referencePolicy;
  private LocalObjectReferenceBuilder to;

  public ImageImportSpecFluent() {
  }
  
  public ImageImportSpecFluent(ImageImportSpec instance) {
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
  
  public ObjectReference buildFrom() {
    return this.from != null ? this.from.build() : null;
  }
  
  public TagImportPolicy buildImportPolicy() {
    return this.importPolicy != null ? this.importPolicy.build() : null;
  }
  
  public TagReferencePolicy buildReferencePolicy() {
    return this.referencePolicy != null ? this.referencePolicy.build() : null;
  }
  
  public LocalObjectReference buildTo() {
    return this.to != null ? this.to.build() : null;
  }
  
  protected void copyInstance(ImageImportSpec instance) {
    instance = instance != null ? instance : new ImageImportSpec();
    if (instance != null) {
        this.withFrom(instance.getFrom());
        this.withImportPolicy(instance.getImportPolicy());
        this.withIncludeManifest(instance.getIncludeManifest());
        this.withReferencePolicy(instance.getReferencePolicy());
        this.withTo(instance.getTo());
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
  
  public ToNested<A> editOrNewTo() {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ToNested<A> editOrNewToLike(LocalObjectReference item) {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(item));
  }
  
  public ReferencePolicyNested<A> editReferencePolicy() {
    return this.withNewReferencePolicyLike(Optional.ofNullable(this.buildReferencePolicy()).orElse(null));
  }
  
  public ToNested<A> editTo() {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(null));
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
    ImageImportSpecFluent that = (ImageImportSpecFluent) o;
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(importPolicy, that.importPolicy))) {
      return false;
    }
    if (!(Objects.equals(includeManifest, that.includeManifest))) {
      return false;
    }
    if (!(Objects.equals(referencePolicy, that.referencePolicy))) {
      return false;
    }
    if (!(Objects.equals(to, that.to))) {
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
  
  public Boolean getIncludeManifest() {
    return this.includeManifest;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasImportPolicy() {
    return this.importPolicy != null;
  }
  
  public boolean hasIncludeManifest() {
    return this.includeManifest != null;
  }
  
  public boolean hasReferencePolicy() {
    return this.referencePolicy != null;
  }
  
  public boolean hasTo() {
    return this.to != null;
  }
  
  public int hashCode() {
    return Objects.hash(from, importPolicy, includeManifest, referencePolicy, to, additionalProperties);
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
    if (!(from == null)) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(importPolicy == null)) {
        sb.append("importPolicy:");
        sb.append(importPolicy);
        sb.append(",");
    }
    if (!(includeManifest == null)) {
        sb.append("includeManifest:");
        sb.append(includeManifest);
        sb.append(",");
    }
    if (!(referencePolicy == null)) {
        sb.append("referencePolicy:");
        sb.append(referencePolicy);
        sb.append(",");
    }
    if (!(to == null)) {
        sb.append("to:");
        sb.append(to);
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
  
  public A withIncludeManifest() {
    return withIncludeManifest(true);
  }
  
  public A withIncludeManifest(Boolean includeManifest) {
    this.includeManifest = includeManifest;
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
  
  public ToNested<A> withNewTo() {
    return new ToNested(null);
  }
  
  public A withNewTo(String name) {
    return (A) this.withTo(new LocalObjectReference(name));
  }
  
  public ToNested<A> withNewToLike(LocalObjectReference item) {
    return new ToNested(item);
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
  
  public A withTo(LocalObjectReference to) {
    this._visitables.remove("to");
    if (to != null) {
        this.to = new LocalObjectReferenceBuilder(to);
        this._visitables.get("to").add(this.to);
    } else {
        this.to = null;
        this._visitables.get("to").remove(this.to);
    }
    return (A) this;
  }
  public class FromNested<N> extends ObjectReferenceFluent<FromNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    FromNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageImportSpecFluent.this.withFrom(builder.build());
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
      return (N) ImageImportSpecFluent.this.withImportPolicy(builder.build());
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
      return (N) ImageImportSpecFluent.this.withReferencePolicy(builder.build());
    }
    
    public N endReferencePolicy() {
      return and();
    }
    
  }
  public class ToNested<N> extends LocalObjectReferenceFluent<ToNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ToNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageImportSpecFluent.this.withTo(builder.build());
    }
    
    public N endTo() {
      return and();
    }
    
  }
}