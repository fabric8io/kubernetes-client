package io.fabric8.openshift.api.model.config.v1;

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
public class TLSSecurityProfileFluent<A extends io.fabric8.openshift.api.model.config.v1.TLSSecurityProfileFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CustomTLSProfileBuilder custom;
  private IntermediateTLSProfileBuilder intermediate;
  private ModernTLSProfileBuilder modern;
  private OldTLSProfileBuilder old;
  private String type;

  public TLSSecurityProfileFluent() {
  }
  
  public TLSSecurityProfileFluent(TLSSecurityProfile instance) {
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
  
  public CustomTLSProfile buildCustom() {
    return this.custom != null ? this.custom.build() : null;
  }
  
  public IntermediateTLSProfile buildIntermediate() {
    return this.intermediate != null ? this.intermediate.build() : null;
  }
  
  public ModernTLSProfile buildModern() {
    return this.modern != null ? this.modern.build() : null;
  }
  
  public OldTLSProfile buildOld() {
    return this.old != null ? this.old.build() : null;
  }
  
  protected void copyInstance(TLSSecurityProfile instance) {
    instance = instance != null ? instance : new TLSSecurityProfile();
    if (instance != null) {
        this.withCustom(instance.getCustom());
        this.withIntermediate(instance.getIntermediate());
        this.withModern(instance.getModern());
        this.withOld(instance.getOld());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomNested<A> editCustom() {
    return this.withNewCustomLike(Optional.ofNullable(this.buildCustom()).orElse(null));
  }
  
  public IntermediateNested<A> editIntermediate() {
    return this.withNewIntermediateLike(Optional.ofNullable(this.buildIntermediate()).orElse(null));
  }
  
  public ModernNested<A> editModern() {
    return this.withNewModernLike(Optional.ofNullable(this.buildModern()).orElse(null));
  }
  
  public OldNested<A> editOld() {
    return this.withNewOldLike(Optional.ofNullable(this.buildOld()).orElse(null));
  }
  
  public CustomNested<A> editOrNewCustom() {
    return this.withNewCustomLike(Optional.ofNullable(this.buildCustom()).orElse(new CustomTLSProfileBuilder().build()));
  }
  
  public CustomNested<A> editOrNewCustomLike(CustomTLSProfile item) {
    return this.withNewCustomLike(Optional.ofNullable(this.buildCustom()).orElse(item));
  }
  
  public IntermediateNested<A> editOrNewIntermediate() {
    return this.withNewIntermediateLike(Optional.ofNullable(this.buildIntermediate()).orElse(new IntermediateTLSProfileBuilder().build()));
  }
  
  public IntermediateNested<A> editOrNewIntermediateLike(IntermediateTLSProfile item) {
    return this.withNewIntermediateLike(Optional.ofNullable(this.buildIntermediate()).orElse(item));
  }
  
  public ModernNested<A> editOrNewModern() {
    return this.withNewModernLike(Optional.ofNullable(this.buildModern()).orElse(new ModernTLSProfileBuilder().build()));
  }
  
  public ModernNested<A> editOrNewModernLike(ModernTLSProfile item) {
    return this.withNewModernLike(Optional.ofNullable(this.buildModern()).orElse(item));
  }
  
  public OldNested<A> editOrNewOld() {
    return this.withNewOldLike(Optional.ofNullable(this.buildOld()).orElse(new OldTLSProfileBuilder().build()));
  }
  
  public OldNested<A> editOrNewOldLike(OldTLSProfile item) {
    return this.withNewOldLike(Optional.ofNullable(this.buildOld()).orElse(item));
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
    TLSSecurityProfileFluent that = (TLSSecurityProfileFluent) o;
    if (!(Objects.equals(custom, that.custom))) {
      return false;
    }
    if (!(Objects.equals(intermediate, that.intermediate))) {
      return false;
    }
    if (!(Objects.equals(modern, that.modern))) {
      return false;
    }
    if (!(Objects.equals(old, that.old))) {
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
  
  public boolean hasCustom() {
    return this.custom != null;
  }
  
  public boolean hasIntermediate() {
    return this.intermediate != null;
  }
  
  public boolean hasModern() {
    return this.modern != null;
  }
  
  public boolean hasOld() {
    return this.old != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(custom, intermediate, modern, old, type, additionalProperties);
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
    if (!(custom == null)) {
        sb.append("custom:");
        sb.append(custom);
        sb.append(",");
    }
    if (!(intermediate == null)) {
        sb.append("intermediate:");
        sb.append(intermediate);
        sb.append(",");
    }
    if (!(modern == null)) {
        sb.append("modern:");
        sb.append(modern);
        sb.append(",");
    }
    if (!(old == null)) {
        sb.append("old:");
        sb.append(old);
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
  
  public A withCustom(CustomTLSProfile custom) {
    this._visitables.remove("custom");
    if (custom != null) {
        this.custom = new CustomTLSProfileBuilder(custom);
        this._visitables.get("custom").add(this.custom);
    } else {
        this.custom = null;
        this._visitables.get("custom").remove(this.custom);
    }
    return (A) this;
  }
  
  public A withIntermediate(IntermediateTLSProfile intermediate) {
    this._visitables.remove("intermediate");
    if (intermediate != null) {
        this.intermediate = new IntermediateTLSProfileBuilder(intermediate);
        this._visitables.get("intermediate").add(this.intermediate);
    } else {
        this.intermediate = null;
        this._visitables.get("intermediate").remove(this.intermediate);
    }
    return (A) this;
  }
  
  public A withModern(ModernTLSProfile modern) {
    this._visitables.remove("modern");
    if (modern != null) {
        this.modern = new ModernTLSProfileBuilder(modern);
        this._visitables.get("modern").add(this.modern);
    } else {
        this.modern = null;
        this._visitables.get("modern").remove(this.modern);
    }
    return (A) this;
  }
  
  public CustomNested<A> withNewCustom() {
    return new CustomNested(null);
  }
  
  public CustomNested<A> withNewCustomLike(CustomTLSProfile item) {
    return new CustomNested(item);
  }
  
  public IntermediateNested<A> withNewIntermediate() {
    return new IntermediateNested(null);
  }
  
  public IntermediateNested<A> withNewIntermediateLike(IntermediateTLSProfile item) {
    return new IntermediateNested(item);
  }
  
  public ModernNested<A> withNewModern() {
    return new ModernNested(null);
  }
  
  public ModernNested<A> withNewModernLike(ModernTLSProfile item) {
    return new ModernNested(item);
  }
  
  public OldNested<A> withNewOld() {
    return new OldNested(null);
  }
  
  public OldNested<A> withNewOldLike(OldTLSProfile item) {
    return new OldNested(item);
  }
  
  public A withOld(OldTLSProfile old) {
    this._visitables.remove("old");
    if (old != null) {
        this.old = new OldTLSProfileBuilder(old);
        this._visitables.get("old").add(this.old);
    } else {
        this.old = null;
        this._visitables.get("old").remove(this.old);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class CustomNested<N> extends CustomTLSProfileFluent<CustomNested<N>> implements Nested<N>{
  
    CustomTLSProfileBuilder builder;
  
    CustomNested(CustomTLSProfile item) {
      this.builder = new CustomTLSProfileBuilder(this, item);
    }
  
    public N and() {
      return (N) TLSSecurityProfileFluent.this.withCustom(builder.build());
    }
    
    public N endCustom() {
      return and();
    }
    
  }
  public class IntermediateNested<N> extends IntermediateTLSProfileFluent<IntermediateNested<N>> implements Nested<N>{
  
    IntermediateTLSProfileBuilder builder;
  
    IntermediateNested(IntermediateTLSProfile item) {
      this.builder = new IntermediateTLSProfileBuilder(this, item);
    }
  
    public N and() {
      return (N) TLSSecurityProfileFluent.this.withIntermediate(builder.build());
    }
    
    public N endIntermediate() {
      return and();
    }
    
  }
  public class ModernNested<N> extends ModernTLSProfileFluent<ModernNested<N>> implements Nested<N>{
  
    ModernTLSProfileBuilder builder;
  
    ModernNested(ModernTLSProfile item) {
      this.builder = new ModernTLSProfileBuilder(this, item);
    }
  
    public N and() {
      return (N) TLSSecurityProfileFluent.this.withModern(builder.build());
    }
    
    public N endModern() {
      return and();
    }
    
  }
  public class OldNested<N> extends OldTLSProfileFluent<OldNested<N>> implements Nested<N>{
  
    OldTLSProfileBuilder builder;
  
    OldNested(OldTLSProfile item) {
      this.builder = new OldTLSProfileBuilder(this, item);
    }
  
    public N and() {
      return (N) TLSSecurityProfileFluent.this.withOld(builder.build());
    }
    
    public N endOld() {
      return and();
    }
    
  }
}