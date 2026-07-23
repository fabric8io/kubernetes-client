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
public class StringMatchFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.StringMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VisitableBuilder<? extends IsStringMatchMatchType,?> matchType;

  public StringMatchFluent() {
  }
  
  public StringMatchFluent(StringMatch instance) {
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
  
  public IsStringMatchMatchType buildMatchType() {
    return this.matchType != null ? this.matchType.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "StringMatchRegex":
    
          return (VisitableBuilder<T,?>) new StringMatchRegexBuilder((StringMatchRegex) item);
    
      case "StringMatchExact":
    
          return (VisitableBuilder<T,?>) new StringMatchExactBuilder((StringMatchExact) item);
    
      case "StringMatchPrefix":
    
          return (VisitableBuilder<T,?>) new StringMatchPrefixBuilder((StringMatchPrefix) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(StringMatch instance) {
    instance = instance != null ? instance : new StringMatch();
    if (instance != null) {
        this.withMatchType(instance.getMatchType());
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
    StringMatchFluent that = (StringMatchFluent) o;
    if (!(Objects.equals(matchType, that.matchType))) {
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
  
  public boolean hasMatchType() {
    return this.matchType != null;
  }
  
  public int hashCode() {
    return Objects.hash(matchType, additionalProperties);
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
    if (!(matchType == null)) {
        sb.append("matchType:");
        sb.append(matchType);
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
  
  public A withMatchType(IsStringMatchMatchType matchType) {
    if (matchType == null) {
        this.matchType = null;
        this._visitables.remove("matchType");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsStringMatchMatchType,?> builder = builder(matchType);
        this._visitables.get("matchType").clear();
        this._visitables.get("matchType").add(builder);
        this.matchType = builder;
        return (A) this;
    }
  }
  
  public StringMatchExactTypeNested<A> withNewStringMatchExactType() {
    return new StringMatchExactTypeNested(null);
  }
  
  public A withNewStringMatchExactType(String exact) {
    return (A) this.withMatchType(new StringMatchExact(exact));
  }
  
  public StringMatchExactTypeNested<A> withNewStringMatchExactTypeLike(StringMatchExact item) {
    return new StringMatchExactTypeNested(item);
  }
  
  public StringMatchPrefixTypeNested<A> withNewStringMatchPrefixType() {
    return new StringMatchPrefixTypeNested(null);
  }
  
  public A withNewStringMatchPrefixType(String prefix) {
    return (A) this.withMatchType(new StringMatchPrefix(prefix));
  }
  
  public StringMatchPrefixTypeNested<A> withNewStringMatchPrefixTypeLike(StringMatchPrefix item) {
    return new StringMatchPrefixTypeNested(item);
  }
  
  public StringMatchRegexTypeNested<A> withNewStringMatchRegexType() {
    return new StringMatchRegexTypeNested(null);
  }
  
  public A withNewStringMatchRegexType(String regex) {
    return (A) this.withMatchType(new StringMatchRegex(regex));
  }
  
  public StringMatchRegexTypeNested<A> withNewStringMatchRegexTypeLike(StringMatchRegex item) {
    return new StringMatchRegexTypeNested(item);
  }
  public class StringMatchExactTypeNested<N> extends StringMatchExactFluent<StringMatchExactTypeNested<N>> implements Nested<N>{
  
    StringMatchExactBuilder builder;
  
    StringMatchExactTypeNested(StringMatchExact item) {
      this.builder = new StringMatchExactBuilder(this, item);
    }
  
    public N and() {
      return (N) StringMatchFluent.this.withMatchType(builder.build());
    }
    
    public N endStringMatchExactType() {
      return and();
    }
    
  }
  public class StringMatchPrefixTypeNested<N> extends StringMatchPrefixFluent<StringMatchPrefixTypeNested<N>> implements Nested<N>{
  
    StringMatchPrefixBuilder builder;
  
    StringMatchPrefixTypeNested(StringMatchPrefix item) {
      this.builder = new StringMatchPrefixBuilder(this, item);
    }
  
    public N and() {
      return (N) StringMatchFluent.this.withMatchType(builder.build());
    }
    
    public N endStringMatchPrefixType() {
      return and();
    }
    
  }
  public class StringMatchRegexTypeNested<N> extends StringMatchRegexFluent<StringMatchRegexTypeNested<N>> implements Nested<N>{
  
    StringMatchRegexBuilder builder;
  
    StringMatchRegexTypeNested(StringMatchRegex item) {
      this.builder = new StringMatchRegexBuilder(this, item);
    }
  
    public N and() {
      return (N) StringMatchFluent.this.withMatchType(builder.build());
    }
    
    public N endStringMatchRegexType() {
      return and();
    }
    
  }
}