package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OrderStatusFluent<A extends io.fabric8.certmanager.api.model.acme.v1.OrderStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ACMEAuthorizationBuilder> authorizations = new ArrayList<ACMEAuthorizationBuilder>();
  private String certificate;
  private String failureTime;
  private String finalizeURL;
  private String reason;
  private String state;
  private String url;

  public OrderStatusFluent() {
  }
  
  public OrderStatusFluent(OrderStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAuthorizations(Collection<ACMEAuthorization> items) {
    if (this.authorizations == null) {
      this.authorizations = new ArrayList();
    }
    for (ACMEAuthorization item : items) {
        ACMEAuthorizationBuilder builder = new ACMEAuthorizationBuilder(item);
        _visitables.get("authorizations").add(builder);
        this.authorizations.add(builder);
    }
    return (A) this;
  }
  
  public AuthorizationsNested<A> addNewAuthorization() {
    return new AuthorizationsNested(-1, null);
  }
  
  public AuthorizationsNested<A> addNewAuthorizationLike(ACMEAuthorization item) {
    return new AuthorizationsNested(-1, item);
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
  
  public A addToAuthorizations(ACMEAuthorization... items) {
    if (this.authorizations == null) {
      this.authorizations = new ArrayList();
    }
    for (ACMEAuthorization item : items) {
        ACMEAuthorizationBuilder builder = new ACMEAuthorizationBuilder(item);
        _visitables.get("authorizations").add(builder);
        this.authorizations.add(builder);
    }
    return (A) this;
  }
  
  public A addToAuthorizations(int index,ACMEAuthorization item) {
    if (this.authorizations == null) {
      this.authorizations = new ArrayList();
    }
    ACMEAuthorizationBuilder builder = new ACMEAuthorizationBuilder(item);
    if (index < 0 || index >= authorizations.size()) {
        _visitables.get("authorizations").add(builder);
        authorizations.add(builder);
    } else {
        _visitables.get("authorizations").add(builder);
        authorizations.add(index, builder);
    }
    return (A) this;
  }
  
  public ACMEAuthorization buildAuthorization(int index) {
    return this.authorizations.get(index).build();
  }
  
  public List<ACMEAuthorization> buildAuthorizations() {
    return this.authorizations != null ? build(authorizations) : null;
  }
  
  public ACMEAuthorization buildFirstAuthorization() {
    return this.authorizations.get(0).build();
  }
  
  public ACMEAuthorization buildLastAuthorization() {
    return this.authorizations.get(authorizations.size() - 1).build();
  }
  
  public ACMEAuthorization buildMatchingAuthorization(Predicate<ACMEAuthorizationBuilder> predicate) {
      for (ACMEAuthorizationBuilder item : authorizations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(OrderStatus instance) {
    instance = instance != null ? instance : new OrderStatus();
    if (instance != null) {
        this.withAuthorizations(instance.getAuthorizations());
        this.withCertificate(instance.getCertificate());
        this.withFailureTime(instance.getFailureTime());
        this.withFinalizeURL(instance.getFinalizeURL());
        this.withReason(instance.getReason());
        this.withState(instance.getState());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthorizationsNested<A> editAuthorization(int index) {
    if (authorizations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "authorizations"));
    }
    return this.setNewAuthorizationLike(index, this.buildAuthorization(index));
  }
  
  public AuthorizationsNested<A> editFirstAuthorization() {
    if (authorizations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "authorizations"));
    }
    return this.setNewAuthorizationLike(0, this.buildAuthorization(0));
  }
  
  public AuthorizationsNested<A> editLastAuthorization() {
    int index = authorizations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "authorizations"));
    }
    return this.setNewAuthorizationLike(index, this.buildAuthorization(index));
  }
  
  public AuthorizationsNested<A> editMatchingAuthorization(Predicate<ACMEAuthorizationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < authorizations.size();i++) {
      if (predicate.test(authorizations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "authorizations"));
    }
    return this.setNewAuthorizationLike(index, this.buildAuthorization(index));
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
    OrderStatusFluent that = (OrderStatusFluent) o;
    if (!(Objects.equals(authorizations, that.authorizations))) {
      return false;
    }
    if (!(Objects.equals(certificate, that.certificate))) {
      return false;
    }
    if (!(Objects.equals(failureTime, that.failureTime))) {
      return false;
    }
    if (!(Objects.equals(finalizeURL, that.finalizeURL))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
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
  
  public String getCertificate() {
    return this.certificate;
  }
  
  public String getFailureTime() {
    return this.failureTime;
  }
  
  public String getFinalizeURL() {
    return this.finalizeURL;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public String getState() {
    return this.state;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthorizations() {
    return this.authorizations != null && !(this.authorizations.isEmpty());
  }
  
  public boolean hasCertificate() {
    return this.certificate != null;
  }
  
  public boolean hasFailureTime() {
    return this.failureTime != null;
  }
  
  public boolean hasFinalizeURL() {
    return this.finalizeURL != null;
  }
  
  public boolean hasMatchingAuthorization(Predicate<ACMEAuthorizationBuilder> predicate) {
      for (ACMEAuthorizationBuilder item : authorizations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(authorizations, certificate, failureTime, finalizeURL, reason, state, url, additionalProperties);
  }
  
  public A removeAllFromAuthorizations(Collection<ACMEAuthorization> items) {
    if (this.authorizations == null) {
      return (A) this;
    }
    for (ACMEAuthorization item : items) {
        ACMEAuthorizationBuilder builder = new ACMEAuthorizationBuilder(item);
        _visitables.get("authorizations").remove(builder);
        this.authorizations.remove(builder);
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
  
  public A removeFromAuthorizations(ACMEAuthorization... items) {
    if (this.authorizations == null) {
      return (A) this;
    }
    for (ACMEAuthorization item : items) {
        ACMEAuthorizationBuilder builder = new ACMEAuthorizationBuilder(item);
        _visitables.get("authorizations").remove(builder);
        this.authorizations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAuthorizations(Predicate<ACMEAuthorizationBuilder> predicate) {
    if (authorizations == null) {
      return (A) this;
    }
    Iterator<ACMEAuthorizationBuilder> each = authorizations.iterator();
    List visitables = _visitables.get("authorizations");
    while (each.hasNext()) {
        ACMEAuthorizationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AuthorizationsNested<A> setNewAuthorizationLike(int index,ACMEAuthorization item) {
    return new AuthorizationsNested(index, item);
  }
  
  public A setToAuthorizations(int index,ACMEAuthorization item) {
    if (this.authorizations == null) {
      this.authorizations = new ArrayList();
    }
    ACMEAuthorizationBuilder builder = new ACMEAuthorizationBuilder(item);
    if (index < 0 || index >= authorizations.size()) {
        _visitables.get("authorizations").add(builder);
        authorizations.add(builder);
    } else {
        _visitables.get("authorizations").add(builder);
        authorizations.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(authorizations == null) && !(authorizations.isEmpty())) {
        sb.append("authorizations:");
        sb.append(authorizations);
        sb.append(",");
    }
    if (!(certificate == null)) {
        sb.append("certificate:");
        sb.append(certificate);
        sb.append(",");
    }
    if (!(failureTime == null)) {
        sb.append("failureTime:");
        sb.append(failureTime);
        sb.append(",");
    }
    if (!(finalizeURL == null)) {
        sb.append("finalizeURL:");
        sb.append(finalizeURL);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
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
  
  public A withAuthorizations(List<ACMEAuthorization> authorizations) {
    if (this.authorizations != null) {
      this._visitables.get("authorizations").clear();
    }
    if (authorizations != null) {
        this.authorizations = new ArrayList();
        for (ACMEAuthorization item : authorizations) {
          this.addToAuthorizations(item);
        }
    } else {
      this.authorizations = null;
    }
    return (A) this;
  }
  
  public A withAuthorizations(ACMEAuthorization... authorizations) {
    if (this.authorizations != null) {
        this.authorizations.clear();
        _visitables.remove("authorizations");
    }
    if (authorizations != null) {
      for (ACMEAuthorization item : authorizations) {
        this.addToAuthorizations(item);
      }
    }
    return (A) this;
  }
  
  public A withCertificate(String certificate) {
    this.certificate = certificate;
    return (A) this;
  }
  
  public A withFailureTime(String failureTime) {
    this.failureTime = failureTime;
    return (A) this;
  }
  
  public A withFinalizeURL(String finalizeURL) {
    this.finalizeURL = finalizeURL;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class AuthorizationsNested<N> extends ACMEAuthorizationFluent<AuthorizationsNested<N>> implements Nested<N>{
  
    ACMEAuthorizationBuilder builder;
    int index;
  
    AuthorizationsNested(int index,ACMEAuthorization item) {
      this.index = index;
      this.builder = new ACMEAuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) OrderStatusFluent.this.setToAuthorizations(index, builder.build());
    }
    
    public N endAuthorization() {
      return and();
    }
    
  }
}