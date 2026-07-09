package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Integer;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HTTPCORSFilterFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPCORSFilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allowCredentials;
  private List<String> allowHeaders = new ArrayList<String>();
  private List<String> allowMethods = new ArrayList<String>();
  private List<String> allowOrigins = new ArrayList<String>();
  private List<String> exposeHeaders = new ArrayList<String>();
  private Integer maxAge;

  public HTTPCORSFilterFluent() {
  }
  
  public HTTPCORSFilterFluent(HTTPCORSFilter instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowHeaders(Collection<String> items) {
    if (this.allowHeaders == null) {
      this.allowHeaders = new ArrayList();
    }
    for (String item : items) {
      this.allowHeaders.add(item);
    }
    return (A) this;
  }
  
  public A addAllToAllowMethods(Collection<String> items) {
    if (this.allowMethods == null) {
      this.allowMethods = new ArrayList();
    }
    for (String item : items) {
      this.allowMethods.add(item);
    }
    return (A) this;
  }
  
  public A addAllToAllowOrigins(Collection<String> items) {
    if (this.allowOrigins == null) {
      this.allowOrigins = new ArrayList();
    }
    for (String item : items) {
      this.allowOrigins.add(item);
    }
    return (A) this;
  }
  
  public A addAllToExposeHeaders(Collection<String> items) {
    if (this.exposeHeaders == null) {
      this.exposeHeaders = new ArrayList();
    }
    for (String item : items) {
      this.exposeHeaders.add(item);
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
  
  public A addToAllowHeaders(String... items) {
    if (this.allowHeaders == null) {
      this.allowHeaders = new ArrayList();
    }
    for (String item : items) {
      this.allowHeaders.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowHeaders(int index,String item) {
    if (this.allowHeaders == null) {
      this.allowHeaders = new ArrayList();
    }
    this.allowHeaders.add(index, item);
    return (A) this;
  }
  
  public A addToAllowMethods(String... items) {
    if (this.allowMethods == null) {
      this.allowMethods = new ArrayList();
    }
    for (String item : items) {
      this.allowMethods.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowMethods(int index,String item) {
    if (this.allowMethods == null) {
      this.allowMethods = new ArrayList();
    }
    this.allowMethods.add(index, item);
    return (A) this;
  }
  
  public A addToAllowOrigins(String... items) {
    if (this.allowOrigins == null) {
      this.allowOrigins = new ArrayList();
    }
    for (String item : items) {
      this.allowOrigins.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowOrigins(int index,String item) {
    if (this.allowOrigins == null) {
      this.allowOrigins = new ArrayList();
    }
    this.allowOrigins.add(index, item);
    return (A) this;
  }
  
  public A addToExposeHeaders(String... items) {
    if (this.exposeHeaders == null) {
      this.exposeHeaders = new ArrayList();
    }
    for (String item : items) {
      this.exposeHeaders.add(item);
    }
    return (A) this;
  }
  
  public A addToExposeHeaders(int index,String item) {
    if (this.exposeHeaders == null) {
      this.exposeHeaders = new ArrayList();
    }
    this.exposeHeaders.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(HTTPCORSFilter instance) {
    instance = instance != null ? instance : new HTTPCORSFilter();
    if (instance != null) {
        this.withAllowCredentials(instance.getAllowCredentials());
        this.withAllowHeaders(instance.getAllowHeaders());
        this.withAllowMethods(instance.getAllowMethods());
        this.withAllowOrigins(instance.getAllowOrigins());
        this.withExposeHeaders(instance.getExposeHeaders());
        this.withMaxAge(instance.getMaxAge());
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
    HTTPCORSFilterFluent that = (HTTPCORSFilterFluent) o;
    if (!(Objects.equals(allowCredentials, that.allowCredentials))) {
      return false;
    }
    if (!(Objects.equals(allowHeaders, that.allowHeaders))) {
      return false;
    }
    if (!(Objects.equals(allowMethods, that.allowMethods))) {
      return false;
    }
    if (!(Objects.equals(allowOrigins, that.allowOrigins))) {
      return false;
    }
    if (!(Objects.equals(exposeHeaders, that.exposeHeaders))) {
      return false;
    }
    if (!(Objects.equals(maxAge, that.maxAge))) {
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
  
  public Boolean getAllowCredentials() {
    return this.allowCredentials;
  }
  
  public String getAllowHeader(int index) {
    return this.allowHeaders.get(index);
  }
  
  public List<String> getAllowHeaders() {
    return this.allowHeaders;
  }
  
  public String getAllowMethod(int index) {
    return this.allowMethods.get(index);
  }
  
  public List<String> getAllowMethods() {
    return this.allowMethods;
  }
  
  public String getAllowOrigin(int index) {
    return this.allowOrigins.get(index);
  }
  
  public List<String> getAllowOrigins() {
    return this.allowOrigins;
  }
  
  public String getExposeHeader(int index) {
    return this.exposeHeaders.get(index);
  }
  
  public List<String> getExposeHeaders() {
    return this.exposeHeaders;
  }
  
  public String getFirstAllowHeader() {
    return this.allowHeaders.get(0);
  }
  
  public String getFirstAllowMethod() {
    return this.allowMethods.get(0);
  }
  
  public String getFirstAllowOrigin() {
    return this.allowOrigins.get(0);
  }
  
  public String getFirstExposeHeader() {
    return this.exposeHeaders.get(0);
  }
  
  public String getLastAllowHeader() {
    return this.allowHeaders.get(allowHeaders.size() - 1);
  }
  
  public String getLastAllowMethod() {
    return this.allowMethods.get(allowMethods.size() - 1);
  }
  
  public String getLastAllowOrigin() {
    return this.allowOrigins.get(allowOrigins.size() - 1);
  }
  
  public String getLastExposeHeader() {
    return this.exposeHeaders.get(exposeHeaders.size() - 1);
  }
  
  public String getMatchingAllowHeader(Predicate<String> predicate) {
      for (String item : allowHeaders) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingAllowMethod(Predicate<String> predicate) {
      for (String item : allowMethods) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingAllowOrigin(Predicate<String> predicate) {
      for (String item : allowOrigins) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingExposeHeader(Predicate<String> predicate) {
      for (String item : exposeHeaders) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMaxAge() {
    return this.maxAge;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowCredentials() {
    return this.allowCredentials != null;
  }
  
  public boolean hasAllowHeaders() {
    return this.allowHeaders != null && !(this.allowHeaders.isEmpty());
  }
  
  public boolean hasAllowMethods() {
    return this.allowMethods != null && !(this.allowMethods.isEmpty());
  }
  
  public boolean hasAllowOrigins() {
    return this.allowOrigins != null && !(this.allowOrigins.isEmpty());
  }
  
  public boolean hasExposeHeaders() {
    return this.exposeHeaders != null && !(this.exposeHeaders.isEmpty());
  }
  
  public boolean hasMatchingAllowHeader(Predicate<String> predicate) {
      for (String item : allowHeaders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAllowMethod(Predicate<String> predicate) {
      for (String item : allowMethods) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAllowOrigin(Predicate<String> predicate) {
      for (String item : allowOrigins) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingExposeHeader(Predicate<String> predicate) {
      for (String item : exposeHeaders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxAge() {
    return this.maxAge != null;
  }
  
  public int hashCode() {
    return Objects.hash(allowCredentials, allowHeaders, allowMethods, allowOrigins, exposeHeaders, maxAge, additionalProperties);
  }
  
  public A removeAllFromAllowHeaders(Collection<String> items) {
    if (this.allowHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowHeaders.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromAllowMethods(Collection<String> items) {
    if (this.allowMethods == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowMethods.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromAllowOrigins(Collection<String> items) {
    if (this.allowOrigins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowOrigins.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromExposeHeaders(Collection<String> items) {
    if (this.exposeHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.exposeHeaders.remove(item);
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
  
  public A removeFromAllowHeaders(String... items) {
    if (this.allowHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowHeaders.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAllowMethods(String... items) {
    if (this.allowMethods == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowMethods.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAllowOrigins(String... items) {
    if (this.allowOrigins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowOrigins.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromExposeHeaders(String... items) {
    if (this.exposeHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.exposeHeaders.remove(item);
    }
    return (A) this;
  }
  
  public A setToAllowHeaders(int index,String item) {
    if (this.allowHeaders == null) {
      this.allowHeaders = new ArrayList();
    }
    this.allowHeaders.set(index, item);
    return (A) this;
  }
  
  public A setToAllowMethods(int index,String item) {
    if (this.allowMethods == null) {
      this.allowMethods = new ArrayList();
    }
    this.allowMethods.set(index, item);
    return (A) this;
  }
  
  public A setToAllowOrigins(int index,String item) {
    if (this.allowOrigins == null) {
      this.allowOrigins = new ArrayList();
    }
    this.allowOrigins.set(index, item);
    return (A) this;
  }
  
  public A setToExposeHeaders(int index,String item) {
    if (this.exposeHeaders == null) {
      this.exposeHeaders = new ArrayList();
    }
    this.exposeHeaders.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowCredentials == null)) {
        sb.append("allowCredentials:");
        sb.append(allowCredentials);
        sb.append(",");
    }
    if (!(allowHeaders == null) && !(allowHeaders.isEmpty())) {
        sb.append("allowHeaders:");
        sb.append(allowHeaders);
        sb.append(",");
    }
    if (!(allowMethods == null) && !(allowMethods.isEmpty())) {
        sb.append("allowMethods:");
        sb.append(allowMethods);
        sb.append(",");
    }
    if (!(allowOrigins == null) && !(allowOrigins.isEmpty())) {
        sb.append("allowOrigins:");
        sb.append(allowOrigins);
        sb.append(",");
    }
    if (!(exposeHeaders == null) && !(exposeHeaders.isEmpty())) {
        sb.append("exposeHeaders:");
        sb.append(exposeHeaders);
        sb.append(",");
    }
    if (!(maxAge == null)) {
        sb.append("maxAge:");
        sb.append(maxAge);
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
  
  public A withAllowCredentials() {
    return withAllowCredentials(true);
  }
  
  public A withAllowCredentials(Boolean allowCredentials) {
    this.allowCredentials = allowCredentials;
    return (A) this;
  }
  
  public A withAllowHeaders(List<String> allowHeaders) {
    if (allowHeaders != null) {
        this.allowHeaders = new ArrayList();
        for (String item : allowHeaders) {
          this.addToAllowHeaders(item);
        }
    } else {
      this.allowHeaders = null;
    }
    return (A) this;
  }
  
  public A withAllowHeaders(String... allowHeaders) {
    if (this.allowHeaders != null) {
        this.allowHeaders.clear();
        _visitables.remove("allowHeaders");
    }
    if (allowHeaders != null) {
      for (String item : allowHeaders) {
        this.addToAllowHeaders(item);
      }
    }
    return (A) this;
  }
  
  public A withAllowMethods(List<String> allowMethods) {
    if (allowMethods != null) {
        this.allowMethods = new ArrayList();
        for (String item : allowMethods) {
          this.addToAllowMethods(item);
        }
    } else {
      this.allowMethods = null;
    }
    return (A) this;
  }
  
  public A withAllowMethods(String... allowMethods) {
    if (this.allowMethods != null) {
        this.allowMethods.clear();
        _visitables.remove("allowMethods");
    }
    if (allowMethods != null) {
      for (String item : allowMethods) {
        this.addToAllowMethods(item);
      }
    }
    return (A) this;
  }
  
  public A withAllowOrigins(List<String> allowOrigins) {
    if (allowOrigins != null) {
        this.allowOrigins = new ArrayList();
        for (String item : allowOrigins) {
          this.addToAllowOrigins(item);
        }
    } else {
      this.allowOrigins = null;
    }
    return (A) this;
  }
  
  public A withAllowOrigins(String... allowOrigins) {
    if (this.allowOrigins != null) {
        this.allowOrigins.clear();
        _visitables.remove("allowOrigins");
    }
    if (allowOrigins != null) {
      for (String item : allowOrigins) {
        this.addToAllowOrigins(item);
      }
    }
    return (A) this;
  }
  
  public A withExposeHeaders(List<String> exposeHeaders) {
    if (exposeHeaders != null) {
        this.exposeHeaders = new ArrayList();
        for (String item : exposeHeaders) {
          this.addToExposeHeaders(item);
        }
    } else {
      this.exposeHeaders = null;
    }
    return (A) this;
  }
  
  public A withExposeHeaders(String... exposeHeaders) {
    if (this.exposeHeaders != null) {
        this.exposeHeaders.clear();
        _visitables.remove("exposeHeaders");
    }
    if (exposeHeaders != null) {
      for (String item : exposeHeaders) {
        this.addToExposeHeaders(item);
      }
    }
    return (A) this;
  }
  
  public A withMaxAge(Integer maxAge) {
    this.maxAge = maxAge;
    return (A) this;
  }
  
}