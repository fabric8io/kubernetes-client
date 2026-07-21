package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ParamSpecFluent<A extends io.fabric8.tekton.v1beta1.ParamSpecFluent<A>> extends BaseFluent<A>{

  private ParamValueBuilder _default;
  private List<String> _enum = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private String description;
  private String name;
  private Map<String,PropertySpec> properties;
  private String type;

  public ParamSpecFluent() {
  }
  
  public ParamSpecFluent(ParamSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToEnum(Collection<String> items) {
    if (this._enum == null) {
      this._enum = new ArrayList();
    }
    for (String item : items) {
      this._enum.add(item);
    }
    return (A) this;
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
  
  public A addToEnum(String... items) {
    if (this._enum == null) {
      this._enum = new ArrayList();
    }
    for (String item : items) {
      this._enum.add(item);
    }
    return (A) this;
  }
  
  public A addToEnum(int index,String item) {
    if (this._enum == null) {
      this._enum = new ArrayList();
    }
    this._enum.add(index, item);
    return (A) this;
  }
  
  public A addToProperties(Map<String,PropertySpec> map) {
    if (this.properties == null && map != null) {
      this.properties = new LinkedHashMap();
    }
    if (map != null) {
      this.properties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToProperties(String key,PropertySpec value) {
    if (this.properties == null && key != null && value != null) {
      this.properties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.properties.put(key, value);
    }
    return (A) this;
  }
  
  public ParamValue buildDefault() {
    return this._default != null ? this._default.build() : null;
  }
  
  protected void copyInstance(ParamSpec instance) {
    instance = instance != null ? instance : new ParamSpec();
    if (instance != null) {
        this.withDefault(instance.getDefault());
        this.withDescription(instance.getDescription());
        this.withEnum(instance.getEnum());
        this.withName(instance.getName());
        this.withProperties(instance.getProperties());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DefaultNested<A> editDefault() {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(null));
  }
  
  public DefaultNested<A> editOrNewDefault() {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(new ParamValueBuilder().build()));
  }
  
  public DefaultNested<A> editOrNewDefaultLike(ParamValue item) {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(item));
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
    ParamSpecFluent that = (ParamSpecFluent) o;
    if (!(Objects.equals(_default, that._default))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(_enum, that._enum))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(properties, that.properties))) {
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
  
  public String getDescription() {
    return this.description;
  }
  
  public List<String> getEnum() {
    return this._enum;
  }
  
  public String getEnum(int index) {
    return this._enum.get(index);
  }
  
  public String getFirstEnum() {
    return this._enum.get(0);
  }
  
  public String getLastEnum() {
    return this._enum.get(_enum.size() - 1);
  }
  
  public String getMatchingEnum(Predicate<String> predicate) {
      for (String item : _enum) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Map<String,PropertySpec> getProperties() {
    return this.properties;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDefault() {
    return this._default != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasEnum() {
    return this._enum != null && !(this._enum.isEmpty());
  }
  
  public boolean hasMatchingEnum(Predicate<String> predicate) {
      for (String item : _enum) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasProperties() {
    return this.properties != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(_default, description, _enum, name, properties, type, additionalProperties);
  }
  
  public A removeAllFromEnum(Collection<String> items) {
    if (this._enum == null) {
      return (A) this;
    }
    for (String item : items) {
      this._enum.remove(item);
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
  
  public A removeFromEnum(String... items) {
    if (this._enum == null) {
      return (A) this;
    }
    for (String item : items) {
      this._enum.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromProperties(String key) {
    if (this.properties == null) {
      return (A) this;
    }
    if (key != null && this.properties != null) {
      this.properties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromProperties(Map<String,PropertySpec> map) {
    if (this.properties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.properties != null) {
          this.properties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToEnum(int index,String item) {
    if (this._enum == null) {
      this._enum = new ArrayList();
    }
    this._enum.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(_default == null)) {
        sb.append("_default:");
        sb.append(_default);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(_enum == null) && !(_enum.isEmpty())) {
        sb.append("_enum:");
        sb.append(_enum);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(properties == null) && !(properties.isEmpty())) {
        sb.append("properties:");
        sb.append(properties);
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
  
  public A withDefault(ParamValue _default) {
    this._visitables.remove("_default");
    if (_default != null) {
        this._default = new ParamValueBuilder(_default);
        this._visitables.get("_default").add(this._default);
    } else {
        this._default = null;
        this._visitables.get("_default").remove(this._default);
    }
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withEnum(List<String> _enum) {
    if (_enum != null) {
        this._enum = new ArrayList();
        for (String item : _enum) {
          this.addToEnum(item);
        }
    } else {
      this._enum = null;
    }
    return (A) this;
  }
  
  public A withEnum(String... _enum) {
    if (this._enum != null) {
        this._enum.clear();
        _visitables.remove("_enum");
    }
    if (_enum != null) {
      for (String item : _enum) {
        this.addToEnum(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public DefaultNested<A> withNewDefault() {
    return new DefaultNested(null);
  }
  
  public A withNewDefault(String stringVal) {
    return (A) this.withDefault(new ParamValue(stringVal));
  }
  
  public DefaultNested<A> withNewDefaultLike(ParamValue item) {
    return new DefaultNested(item);
  }
  
  public <K,V>A withProperties(Map<String,PropertySpec> properties) {
    if (properties == null) {
      this.properties = null;
    } else {
      this.properties = new LinkedHashMap(properties);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class DefaultNested<N> extends ParamValueFluent<DefaultNested<N>> implements Nested<N>{
  
    ParamValueBuilder builder;
  
    DefaultNested(ParamValue item) {
      this.builder = new ParamValueBuilder(this, item);
    }
  
    public N and() {
      return (N) ParamSpecFluent.this.withDefault(builder.build());
    }
    
    public N endDefault() {
      return and();
    }
    
  }
}