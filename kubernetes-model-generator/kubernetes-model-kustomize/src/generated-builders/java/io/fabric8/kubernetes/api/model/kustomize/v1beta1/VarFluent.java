package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
public class VarFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.VarFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private FieldSelectorBuilder fieldref;
  private String name;
  private TargetBuilder objref;

  public VarFluent() {
  }
  
  public VarFluent(Var instance) {
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
  
  public FieldSelector buildFieldref() {
    return this.fieldref != null ? this.fieldref.build() : null;
  }
  
  public Target buildObjref() {
    return this.objref != null ? this.objref.build() : null;
  }
  
  protected void copyInstance(Var instance) {
    instance = instance != null ? instance : new Var();
    if (instance != null) {
        this.withFieldref(instance.getFieldref());
        this.withName(instance.getName());
        this.withObjref(instance.getObjref());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FieldrefNested<A> editFieldref() {
    return this.withNewFieldrefLike(Optional.ofNullable(this.buildFieldref()).orElse(null));
  }
  
  public ObjrefNested<A> editObjref() {
    return this.withNewObjrefLike(Optional.ofNullable(this.buildObjref()).orElse(null));
  }
  
  public FieldrefNested<A> editOrNewFieldref() {
    return this.withNewFieldrefLike(Optional.ofNullable(this.buildFieldref()).orElse(new FieldSelectorBuilder().build()));
  }
  
  public FieldrefNested<A> editOrNewFieldrefLike(FieldSelector item) {
    return this.withNewFieldrefLike(Optional.ofNullable(this.buildFieldref()).orElse(item));
  }
  
  public ObjrefNested<A> editOrNewObjref() {
    return this.withNewObjrefLike(Optional.ofNullable(this.buildObjref()).orElse(new TargetBuilder().build()));
  }
  
  public ObjrefNested<A> editOrNewObjrefLike(Target item) {
    return this.withNewObjrefLike(Optional.ofNullable(this.buildObjref()).orElse(item));
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
    VarFluent that = (VarFluent) o;
    if (!(Objects.equals(fieldref, that.fieldref))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(objref, that.objref))) {
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
  
  public boolean hasFieldref() {
    return this.fieldref != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasObjref() {
    return this.objref != null;
  }
  
  public int hashCode() {
    return Objects.hash(fieldref, name, objref, additionalProperties);
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
    if (!(fieldref == null)) {
        sb.append("fieldref:");
        sb.append(fieldref);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(objref == null)) {
        sb.append("objref:");
        sb.append(objref);
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
  
  public A withFieldref(FieldSelector fieldref) {
    this._visitables.remove("fieldref");
    if (fieldref != null) {
        this.fieldref = new FieldSelectorBuilder(fieldref);
        this._visitables.get("fieldref").add(this.fieldref);
    } else {
        this.fieldref = null;
        this._visitables.get("fieldref").remove(this.fieldref);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public FieldrefNested<A> withNewFieldref() {
    return new FieldrefNested(null);
  }
  
  public A withNewFieldref(String fieldPath) {
    return (A) this.withFieldref(new FieldSelector(fieldPath));
  }
  
  public FieldrefNested<A> withNewFieldrefLike(FieldSelector item) {
    return new FieldrefNested(item);
  }
  
  public ObjrefNested<A> withNewObjref() {
    return new ObjrefNested(null);
  }
  
  public ObjrefNested<A> withNewObjrefLike(Target item) {
    return new ObjrefNested(item);
  }
  
  public A withObjref(Target objref) {
    this._visitables.remove("objref");
    if (objref != null) {
        this.objref = new TargetBuilder(objref);
        this._visitables.get("objref").add(this.objref);
    } else {
        this.objref = null;
        this._visitables.get("objref").remove(this.objref);
    }
    return (A) this;
  }
  public class FieldrefNested<N> extends FieldSelectorFluent<FieldrefNested<N>> implements Nested<N>{
  
    FieldSelectorBuilder builder;
  
    FieldrefNested(FieldSelector item) {
      this.builder = new FieldSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) VarFluent.this.withFieldref(builder.build());
    }
    
    public N endFieldref() {
      return and();
    }
    
  }
  public class ObjrefNested<N> extends TargetFluent<ObjrefNested<N>> implements Nested<N>{
  
    TargetBuilder builder;
  
    ObjrefNested(Target item) {
      this.builder = new TargetBuilder(this, item);
    }
  
    public N and() {
      return (N) VarFluent.this.withObjref(builder.build());
    }
    
    public N endObjref() {
      return and();
    }
    
  }
}