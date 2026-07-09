package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class NamedResourcesAttributeFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.NamedResourcesAttributeFluent<A>> extends BaseFluent<A>{

  private Long _int;
  private Map<String,Object> additionalProperties;
  private Boolean bool;
  private NamedResourcesIntSliceBuilder intSlice;
  private String name;
  private Quantity quantity;
  private String string;
  private NamedResourcesStringSliceBuilder stringSlice;
  private String version;

  public NamedResourcesAttributeFluent() {
  }
  
  public NamedResourcesAttributeFluent(NamedResourcesAttribute instance) {
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
  
  public NamedResourcesIntSlice buildIntSlice() {
    return this.intSlice != null ? this.intSlice.build() : null;
  }
  
  public NamedResourcesStringSlice buildStringSlice() {
    return this.stringSlice != null ? this.stringSlice.build() : null;
  }
  
  protected void copyInstance(NamedResourcesAttribute instance) {
    instance = instance != null ? instance : new NamedResourcesAttribute();
    if (instance != null) {
        this.withBool(instance.getBool());
        this.withInt(instance.getInt());
        this.withIntSlice(instance.getIntSlice());
        this.withName(instance.getName());
        this.withQuantity(instance.getQuantity());
        this.withString(instance.getString());
        this.withStringSlice(instance.getStringSlice());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IntSliceNested<A> editIntSlice() {
    return this.withNewIntSliceLike(Optional.ofNullable(this.buildIntSlice()).orElse(null));
  }
  
  public IntSliceNested<A> editOrNewIntSlice() {
    return this.withNewIntSliceLike(Optional.ofNullable(this.buildIntSlice()).orElse(new NamedResourcesIntSliceBuilder().build()));
  }
  
  public IntSliceNested<A> editOrNewIntSliceLike(NamedResourcesIntSlice item) {
    return this.withNewIntSliceLike(Optional.ofNullable(this.buildIntSlice()).orElse(item));
  }
  
  public StringSliceNested<A> editOrNewStringSlice() {
    return this.withNewStringSliceLike(Optional.ofNullable(this.buildStringSlice()).orElse(new NamedResourcesStringSliceBuilder().build()));
  }
  
  public StringSliceNested<A> editOrNewStringSliceLike(NamedResourcesStringSlice item) {
    return this.withNewStringSliceLike(Optional.ofNullable(this.buildStringSlice()).orElse(item));
  }
  
  public StringSliceNested<A> editStringSlice() {
    return this.withNewStringSliceLike(Optional.ofNullable(this.buildStringSlice()).orElse(null));
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
    NamedResourcesAttributeFluent that = (NamedResourcesAttributeFluent) o;
    if (!(Objects.equals(bool, that.bool))) {
      return false;
    }
    if (!(Objects.equals(_int, that._int))) {
      return false;
    }
    if (!(Objects.equals(intSlice, that.intSlice))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(quantity, that.quantity))) {
      return false;
    }
    if (!(Objects.equals(string, that.string))) {
      return false;
    }
    if (!(Objects.equals(stringSlice, that.stringSlice))) {
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
  
  public Boolean getBool() {
    return this.bool;
  }
  
  public Long getInt() {
    return this._int;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Quantity getQuantity() {
    return this.quantity;
  }
  
  public String getString() {
    return this.string;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBool() {
    return this.bool != null;
  }
  
  public boolean hasInt() {
    return this._int != null;
  }
  
  public boolean hasIntSlice() {
    return this.intSlice != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasQuantity() {
    return this.quantity != null;
  }
  
  public boolean hasString() {
    return this.string != null;
  }
  
  public boolean hasStringSlice() {
    return this.stringSlice != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(bool, _int, intSlice, name, quantity, string, stringSlice, version, additionalProperties);
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
    if (!(bool == null)) {
        sb.append("bool:");
        sb.append(bool);
        sb.append(",");
    }
    if (!(_int == null)) {
        sb.append("_int:");
        sb.append(_int);
        sb.append(",");
    }
    if (!(intSlice == null)) {
        sb.append("intSlice:");
        sb.append(intSlice);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(quantity == null)) {
        sb.append("quantity:");
        sb.append(quantity);
        sb.append(",");
    }
    if (!(string == null)) {
        sb.append("string:");
        sb.append(string);
        sb.append(",");
    }
    if (!(stringSlice == null)) {
        sb.append("stringSlice:");
        sb.append(stringSlice);
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
  
  public A withBool() {
    return withBool(true);
  }
  
  public A withBool(Boolean bool) {
    this.bool = bool;
    return (A) this;
  }
  
  public A withInt(Long _int) {
    this._int = _int;
    return (A) this;
  }
  
  public A withIntSlice(NamedResourcesIntSlice intSlice) {
    this._visitables.remove("intSlice");
    if (intSlice != null) {
        this.intSlice = new NamedResourcesIntSliceBuilder(intSlice);
        this._visitables.get("intSlice").add(this.intSlice);
    } else {
        this.intSlice = null;
        this._visitables.get("intSlice").remove(this.intSlice);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public IntSliceNested<A> withNewIntSlice() {
    return new IntSliceNested(null);
  }
  
  public IntSliceNested<A> withNewIntSliceLike(NamedResourcesIntSlice item) {
    return new IntSliceNested(item);
  }
  
  public A withNewQuantity(String amount) {
    return (A) this.withQuantity(new Quantity(amount));
  }
  
  public A withNewQuantity(String amount,String format) {
    return (A) this.withQuantity(new Quantity(amount, format));
  }
  
  public StringSliceNested<A> withNewStringSlice() {
    return new StringSliceNested(null);
  }
  
  public StringSliceNested<A> withNewStringSliceLike(NamedResourcesStringSlice item) {
    return new StringSliceNested(item);
  }
  
  public A withQuantity(Quantity quantity) {
    this.quantity = quantity;
    return (A) this;
  }
  
  public A withString(String string) {
    this.string = string;
    return (A) this;
  }
  
  public A withStringSlice(NamedResourcesStringSlice stringSlice) {
    this._visitables.remove("stringSlice");
    if (stringSlice != null) {
        this.stringSlice = new NamedResourcesStringSliceBuilder(stringSlice);
        this._visitables.get("stringSlice").add(this.stringSlice);
    } else {
        this.stringSlice = null;
        this._visitables.get("stringSlice").remove(this.stringSlice);
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class IntSliceNested<N> extends NamedResourcesIntSliceFluent<IntSliceNested<N>> implements Nested<N>{
  
    NamedResourcesIntSliceBuilder builder;
  
    IntSliceNested(NamedResourcesIntSlice item) {
      this.builder = new NamedResourcesIntSliceBuilder(this, item);
    }
  
    public N and() {
      return (N) NamedResourcesAttributeFluent.this.withIntSlice(builder.build());
    }
    
    public N endIntSlice() {
      return and();
    }
    
  }
  public class StringSliceNested<N> extends NamedResourcesStringSliceFluent<StringSliceNested<N>> implements Nested<N>{
  
    NamedResourcesStringSliceBuilder builder;
  
    StringSliceNested(NamedResourcesStringSlice item) {
      this.builder = new NamedResourcesStringSliceBuilder(this, item);
    }
  
    public N and() {
      return (N) NamedResourcesAttributeFluent.this.withStringSlice(builder.build());
    }
    
    public N endStringSlice() {
      return and();
    }
    
  }
}