package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HTTPBodyFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HTTPBodyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VisitableBuilder<? extends IsHTTPBodySpecifier,?> specifier;

  public HTTPBodyFluent() {
  }
  
  public HTTPBodyFluent(HTTPBody instance) {
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
  
  public IsHTTPBodySpecifier buildSpecifier() {
    return this.specifier != null ? this.specifier.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "HTTPBodyBytes":
    
          return (VisitableBuilder<T,?>) new HTTPBodyBytesBuilder((HTTPBodyBytes) item);
    
      case "HTTPBodyString":
    
          return (VisitableBuilder<T,?>) new HTTPBodyStringBuilder((HTTPBodyString) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(HTTPBody instance) {
    instance = instance != null ? instance : new HTTPBody();
    if (instance != null) {
        this.withSpecifier(instance.getSpecifier());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    HTTPBodyFluent that = (HTTPBodyFluent) o;
    if (!(Objects.equals(specifier, that.specifier))) {
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
  
  public boolean hasSpecifier() {
    return this.specifier != null;
  }
  
  public int hashCode() {
    return Objects.hash(specifier, additionalProperties);
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
    if (!(specifier == null)) {
        sb.append("specifier:");
        sb.append(specifier);
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
  
  public HTTPBodyBytesSpecifierNested<A> withNewHTTPBodyBytesSpecifier() {
    return new HTTPBodyBytesSpecifierNested(null);
  }
  
  public A withNewHTTPBodyBytesSpecifier(String bytes) {
    return (A) this.withSpecifier(new HTTPBodyBytes(bytes));
  }
  
  public HTTPBodyBytesSpecifierNested<A> withNewHTTPBodyBytesSpecifierLike(HTTPBodyBytes item) {
    return new HTTPBodyBytesSpecifierNested(item);
  }
  
  public HTTPBodyStringSpecifierNested<A> withNewHTTPBodyStringSpecifier() {
    return new HTTPBodyStringSpecifierNested(null);
  }
  
  public A withNewHTTPBodyStringSpecifier(String string) {
    return (A) this.withSpecifier(new HTTPBodyString(string));
  }
  
  public HTTPBodyStringSpecifierNested<A> withNewHTTPBodyStringSpecifierLike(HTTPBodyString item) {
    return new HTTPBodyStringSpecifierNested(item);
  }
  
  public A withSpecifier(IsHTTPBodySpecifier specifier) {
    if (specifier == null) {
        this.specifier = null;
        this._visitables.remove("specifier");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsHTTPBodySpecifier,?> builder = builder(specifier);
        this._visitables.get("specifier").clear();
        this._visitables.get("specifier").add(builder);
        this.specifier = builder;
        return (A) this;
    }
  }
  public class HTTPBodyBytesSpecifierNested<N> extends HTTPBodyBytesFluent<HTTPBodyBytesSpecifierNested<N>> implements Nested<N>{
  
    HTTPBodyBytesBuilder builder;
  
    HTTPBodyBytesSpecifierNested(HTTPBodyBytes item) {
      this.builder = new HTTPBodyBytesBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPBodyFluent.this.withSpecifier(builder.build());
    }
    
    public N endHTTPBodyBytesSpecifier() {
      return and();
    }
    
  }
  public class HTTPBodyStringSpecifierNested<N> extends HTTPBodyStringFluent<HTTPBodyStringSpecifierNested<N>> implements Nested<N>{
  
    HTTPBodyStringBuilder builder;
  
    HTTPBodyStringSpecifierNested(HTTPBodyString item) {
      this.builder = new HTTPBodyStringBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPBodyFluent.this.withSpecifier(builder.build());
    }
    
    public N endHTTPBodyStringSpecifier() {
      return and();
    }
    
  }
}