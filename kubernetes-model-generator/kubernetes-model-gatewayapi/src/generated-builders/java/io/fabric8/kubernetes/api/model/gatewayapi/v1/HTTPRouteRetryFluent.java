package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class HTTPRouteRetryFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRouteRetryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer attempts;
  private String backoff;
  private List<Integer> codes = new ArrayList<Integer>();

  public HTTPRouteRetryFluent() {
  }
  
  public HTTPRouteRetryFluent(HTTPRouteRetry instance) {
    this.copyInstance(instance);
  }

  public A addAllToCodes(Collection<Integer> items) {
    if (this.codes == null) {
      this.codes = new ArrayList();
    }
    for (Integer item : items) {
      this.codes.add(item);
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
  
  public A addToCodes(Integer... items) {
    if (this.codes == null) {
      this.codes = new ArrayList();
    }
    for (Integer item : items) {
      this.codes.add(item);
    }
    return (A) this;
  }
  
  public A addToCodes(int index,Integer item) {
    if (this.codes == null) {
      this.codes = new ArrayList();
    }
    this.codes.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(HTTPRouteRetry instance) {
    instance = instance != null ? instance : new HTTPRouteRetry();
    if (instance != null) {
        this.withAttempts(instance.getAttempts());
        this.withBackoff(instance.getBackoff());
        this.withCodes(instance.getCodes());
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
    HTTPRouteRetryFluent that = (HTTPRouteRetryFluent) o;
    if (!(Objects.equals(attempts, that.attempts))) {
      return false;
    }
    if (!(Objects.equals(backoff, that.backoff))) {
      return false;
    }
    if (!(Objects.equals(codes, that.codes))) {
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
  
  public Integer getAttempts() {
    return this.attempts;
  }
  
  public String getBackoff() {
    return this.backoff;
  }
  
  public Integer getCode(int index) {
    return this.codes.get(index);
  }
  
  public List<Integer> getCodes() {
    return this.codes;
  }
  
  public Integer getFirstCode() {
    return this.codes.get(0);
  }
  
  public Integer getLastCode() {
    return this.codes.get(codes.size() - 1);
  }
  
  public Integer getMatchingCode(Predicate<Integer> predicate) {
      for (Integer item : codes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttempts() {
    return this.attempts != null;
  }
  
  public boolean hasBackoff() {
    return this.backoff != null;
  }
  
  public boolean hasCodes() {
    return this.codes != null && !(this.codes.isEmpty());
  }
  
  public boolean hasMatchingCode(Predicate<Integer> predicate) {
      for (Integer item : codes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(attempts, backoff, codes, additionalProperties);
  }
  
  public A removeAllFromCodes(Collection<Integer> items) {
    if (this.codes == null) {
      return (A) this;
    }
    for (Integer item : items) {
      this.codes.remove(item);
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
  
  public A removeFromCodes(Integer... items) {
    if (this.codes == null) {
      return (A) this;
    }
    for (Integer item : items) {
      this.codes.remove(item);
    }
    return (A) this;
  }
  
  public A setToCodes(int index,Integer item) {
    if (this.codes == null) {
      this.codes = new ArrayList();
    }
    this.codes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(attempts == null)) {
        sb.append("attempts:");
        sb.append(attempts);
        sb.append(",");
    }
    if (!(backoff == null)) {
        sb.append("backoff:");
        sb.append(backoff);
        sb.append(",");
    }
    if (!(codes == null) && !(codes.isEmpty())) {
        sb.append("codes:");
        sb.append(codes);
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
  
  public A withAttempts(Integer attempts) {
    this.attempts = attempts;
    return (A) this;
  }
  
  public A withBackoff(String backoff) {
    this.backoff = backoff;
    return (A) this;
  }
  
  public A withCodes(List<Integer> codes) {
    if (codes != null) {
        this.codes = new ArrayList();
        for (Integer item : codes) {
          this.addToCodes(item);
        }
    } else {
      this.codes = null;
    }
    return (A) this;
  }
  
  public A withCodes(Integer... codes) {
    if (this.codes != null) {
        this.codes.clear();
        _visitables.remove("codes");
    }
    if (codes != null) {
      for (Integer item : codes) {
        this.addToCodes(item);
      }
    }
    return (A) this;
  }
  
}