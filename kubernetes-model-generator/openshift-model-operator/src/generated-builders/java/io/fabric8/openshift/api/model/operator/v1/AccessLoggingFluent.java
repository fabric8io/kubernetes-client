package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AccessLoggingFluent<A extends io.fabric8.openshift.api.model.operator.v1.AccessLoggingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LoggingDestinationBuilder destination;
  private ArrayList<IngressControllerCaptureHTTPCookieBuilder> httpCaptureCookies = new ArrayList<IngressControllerCaptureHTTPCookieBuilder>();
  private IngressControllerCaptureHTTPHeadersBuilder httpCaptureHeaders;
  private String httpLogFormat;
  private String logEmptyRequests;

  public AccessLoggingFluent() {
  }
  
  public AccessLoggingFluent(AccessLogging instance) {
    this.copyInstance(instance);
  }

  public A addAllToHttpCaptureCookies(Collection<IngressControllerCaptureHTTPCookie> items) {
    if (this.httpCaptureCookies == null) {
      this.httpCaptureCookies = new ArrayList();
    }
    for (IngressControllerCaptureHTTPCookie item : items) {
        IngressControllerCaptureHTTPCookieBuilder builder = new IngressControllerCaptureHTTPCookieBuilder(item);
        _visitables.get("httpCaptureCookies").add(builder);
        this.httpCaptureCookies.add(builder);
    }
    return (A) this;
  }
  
  public HttpCaptureCookiesNested<A> addNewHttpCaptureCooky() {
    return new HttpCaptureCookiesNested(-1, null);
  }
  
  public A addNewHttpCaptureCooky(String matchType,Integer maxLength,String name,String namePrefix) {
    return (A) this.addToHttpCaptureCookies(new IngressControllerCaptureHTTPCookie(matchType, maxLength, name, namePrefix));
  }
  
  public HttpCaptureCookiesNested<A> addNewHttpCaptureCookyLike(IngressControllerCaptureHTTPCookie item) {
    return new HttpCaptureCookiesNested(-1, item);
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
  
  public A addToHttpCaptureCookies(IngressControllerCaptureHTTPCookie... items) {
    if (this.httpCaptureCookies == null) {
      this.httpCaptureCookies = new ArrayList();
    }
    for (IngressControllerCaptureHTTPCookie item : items) {
        IngressControllerCaptureHTTPCookieBuilder builder = new IngressControllerCaptureHTTPCookieBuilder(item);
        _visitables.get("httpCaptureCookies").add(builder);
        this.httpCaptureCookies.add(builder);
    }
    return (A) this;
  }
  
  public A addToHttpCaptureCookies(int index,IngressControllerCaptureHTTPCookie item) {
    if (this.httpCaptureCookies == null) {
      this.httpCaptureCookies = new ArrayList();
    }
    IngressControllerCaptureHTTPCookieBuilder builder = new IngressControllerCaptureHTTPCookieBuilder(item);
    if (index < 0 || index >= httpCaptureCookies.size()) {
        _visitables.get("httpCaptureCookies").add(builder);
        httpCaptureCookies.add(builder);
    } else {
        _visitables.get("httpCaptureCookies").add(builder);
        httpCaptureCookies.add(index, builder);
    }
    return (A) this;
  }
  
  public LoggingDestination buildDestination() {
    return this.destination != null ? this.destination.build() : null;
  }
  
  public IngressControllerCaptureHTTPCookie buildFirstHttpCaptureCooky() {
    return this.httpCaptureCookies.get(0).build();
  }
  
  public List<IngressControllerCaptureHTTPCookie> buildHttpCaptureCookies() {
    return this.httpCaptureCookies != null ? build(httpCaptureCookies) : null;
  }
  
  public IngressControllerCaptureHTTPCookie buildHttpCaptureCooky(int index) {
    return this.httpCaptureCookies.get(index).build();
  }
  
  public IngressControllerCaptureHTTPHeaders buildHttpCaptureHeaders() {
    return this.httpCaptureHeaders != null ? this.httpCaptureHeaders.build() : null;
  }
  
  public IngressControllerCaptureHTTPCookie buildLastHttpCaptureCooky() {
    return this.httpCaptureCookies.get(httpCaptureCookies.size() - 1).build();
  }
  
  public IngressControllerCaptureHTTPCookie buildMatchingHttpCaptureCooky(Predicate<IngressControllerCaptureHTTPCookieBuilder> predicate) {
      for (IngressControllerCaptureHTTPCookieBuilder item : httpCaptureCookies) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(AccessLogging instance) {
    instance = instance != null ? instance : new AccessLogging();
    if (instance != null) {
        this.withDestination(instance.getDestination());
        this.withHttpCaptureCookies(instance.getHttpCaptureCookies());
        this.withHttpCaptureHeaders(instance.getHttpCaptureHeaders());
        this.withHttpLogFormat(instance.getHttpLogFormat());
        this.withLogEmptyRequests(instance.getLogEmptyRequests());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DestinationNested<A> editDestination() {
    return this.withNewDestinationLike(Optional.ofNullable(this.buildDestination()).orElse(null));
  }
  
  public HttpCaptureCookiesNested<A> editFirstHttpCaptureCooky() {
    if (httpCaptureCookies.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "httpCaptureCookies"));
    }
    return this.setNewHttpCaptureCookyLike(0, this.buildHttpCaptureCooky(0));
  }
  
  public HttpCaptureCookiesNested<A> editHttpCaptureCooky(int index) {
    if (httpCaptureCookies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "httpCaptureCookies"));
    }
    return this.setNewHttpCaptureCookyLike(index, this.buildHttpCaptureCooky(index));
  }
  
  public HttpCaptureHeadersNested<A> editHttpCaptureHeaders() {
    return this.withNewHttpCaptureHeadersLike(Optional.ofNullable(this.buildHttpCaptureHeaders()).orElse(null));
  }
  
  public HttpCaptureCookiesNested<A> editLastHttpCaptureCooky() {
    int index = httpCaptureCookies.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "httpCaptureCookies"));
    }
    return this.setNewHttpCaptureCookyLike(index, this.buildHttpCaptureCooky(index));
  }
  
  public HttpCaptureCookiesNested<A> editMatchingHttpCaptureCooky(Predicate<IngressControllerCaptureHTTPCookieBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < httpCaptureCookies.size();i++) {
      if (predicate.test(httpCaptureCookies.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "httpCaptureCookies"));
    }
    return this.setNewHttpCaptureCookyLike(index, this.buildHttpCaptureCooky(index));
  }
  
  public DestinationNested<A> editOrNewDestination() {
    return this.withNewDestinationLike(Optional.ofNullable(this.buildDestination()).orElse(new LoggingDestinationBuilder().build()));
  }
  
  public DestinationNested<A> editOrNewDestinationLike(LoggingDestination item) {
    return this.withNewDestinationLike(Optional.ofNullable(this.buildDestination()).orElse(item));
  }
  
  public HttpCaptureHeadersNested<A> editOrNewHttpCaptureHeaders() {
    return this.withNewHttpCaptureHeadersLike(Optional.ofNullable(this.buildHttpCaptureHeaders()).orElse(new IngressControllerCaptureHTTPHeadersBuilder().build()));
  }
  
  public HttpCaptureHeadersNested<A> editOrNewHttpCaptureHeadersLike(IngressControllerCaptureHTTPHeaders item) {
    return this.withNewHttpCaptureHeadersLike(Optional.ofNullable(this.buildHttpCaptureHeaders()).orElse(item));
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
    AccessLoggingFluent that = (AccessLoggingFluent) o;
    if (!(Objects.equals(destination, that.destination))) {
      return false;
    }
    if (!(Objects.equals(httpCaptureCookies, that.httpCaptureCookies))) {
      return false;
    }
    if (!(Objects.equals(httpCaptureHeaders, that.httpCaptureHeaders))) {
      return false;
    }
    if (!(Objects.equals(httpLogFormat, that.httpLogFormat))) {
      return false;
    }
    if (!(Objects.equals(logEmptyRequests, that.logEmptyRequests))) {
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
  
  public String getHttpLogFormat() {
    return this.httpLogFormat;
  }
  
  public String getLogEmptyRequests() {
    return this.logEmptyRequests;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDestination() {
    return this.destination != null;
  }
  
  public boolean hasHttpCaptureCookies() {
    return this.httpCaptureCookies != null && !(this.httpCaptureCookies.isEmpty());
  }
  
  public boolean hasHttpCaptureHeaders() {
    return this.httpCaptureHeaders != null;
  }
  
  public boolean hasHttpLogFormat() {
    return this.httpLogFormat != null;
  }
  
  public boolean hasLogEmptyRequests() {
    return this.logEmptyRequests != null;
  }
  
  public boolean hasMatchingHttpCaptureCooky(Predicate<IngressControllerCaptureHTTPCookieBuilder> predicate) {
      for (IngressControllerCaptureHTTPCookieBuilder item : httpCaptureCookies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(destination, httpCaptureCookies, httpCaptureHeaders, httpLogFormat, logEmptyRequests, additionalProperties);
  }
  
  public A removeAllFromHttpCaptureCookies(Collection<IngressControllerCaptureHTTPCookie> items) {
    if (this.httpCaptureCookies == null) {
      return (A) this;
    }
    for (IngressControllerCaptureHTTPCookie item : items) {
        IngressControllerCaptureHTTPCookieBuilder builder = new IngressControllerCaptureHTTPCookieBuilder(item);
        _visitables.get("httpCaptureCookies").remove(builder);
        this.httpCaptureCookies.remove(builder);
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
  
  public A removeFromHttpCaptureCookies(IngressControllerCaptureHTTPCookie... items) {
    if (this.httpCaptureCookies == null) {
      return (A) this;
    }
    for (IngressControllerCaptureHTTPCookie item : items) {
        IngressControllerCaptureHTTPCookieBuilder builder = new IngressControllerCaptureHTTPCookieBuilder(item);
        _visitables.get("httpCaptureCookies").remove(builder);
        this.httpCaptureCookies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHttpCaptureCookies(Predicate<IngressControllerCaptureHTTPCookieBuilder> predicate) {
    if (httpCaptureCookies == null) {
      return (A) this;
    }
    Iterator<IngressControllerCaptureHTTPCookieBuilder> each = httpCaptureCookies.iterator();
    List visitables = _visitables.get("httpCaptureCookies");
    while (each.hasNext()) {
        IngressControllerCaptureHTTPCookieBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HttpCaptureCookiesNested<A> setNewHttpCaptureCookyLike(int index,IngressControllerCaptureHTTPCookie item) {
    return new HttpCaptureCookiesNested(index, item);
  }
  
  public A setToHttpCaptureCookies(int index,IngressControllerCaptureHTTPCookie item) {
    if (this.httpCaptureCookies == null) {
      this.httpCaptureCookies = new ArrayList();
    }
    IngressControllerCaptureHTTPCookieBuilder builder = new IngressControllerCaptureHTTPCookieBuilder(item);
    if (index < 0 || index >= httpCaptureCookies.size()) {
        _visitables.get("httpCaptureCookies").add(builder);
        httpCaptureCookies.add(builder);
    } else {
        _visitables.get("httpCaptureCookies").add(builder);
        httpCaptureCookies.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(destination == null)) {
        sb.append("destination:");
        sb.append(destination);
        sb.append(",");
    }
    if (!(httpCaptureCookies == null) && !(httpCaptureCookies.isEmpty())) {
        sb.append("httpCaptureCookies:");
        sb.append(httpCaptureCookies);
        sb.append(",");
    }
    if (!(httpCaptureHeaders == null)) {
        sb.append("httpCaptureHeaders:");
        sb.append(httpCaptureHeaders);
        sb.append(",");
    }
    if (!(httpLogFormat == null)) {
        sb.append("httpLogFormat:");
        sb.append(httpLogFormat);
        sb.append(",");
    }
    if (!(logEmptyRequests == null)) {
        sb.append("logEmptyRequests:");
        sb.append(logEmptyRequests);
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
  
  public A withDestination(LoggingDestination destination) {
    this._visitables.remove("destination");
    if (destination != null) {
        this.destination = new LoggingDestinationBuilder(destination);
        this._visitables.get("destination").add(this.destination);
    } else {
        this.destination = null;
        this._visitables.get("destination").remove(this.destination);
    }
    return (A) this;
  }
  
  public A withHttpCaptureCookies(List<IngressControllerCaptureHTTPCookie> httpCaptureCookies) {
    if (this.httpCaptureCookies != null) {
      this._visitables.get("httpCaptureCookies").clear();
    }
    if (httpCaptureCookies != null) {
        this.httpCaptureCookies = new ArrayList();
        for (IngressControllerCaptureHTTPCookie item : httpCaptureCookies) {
          this.addToHttpCaptureCookies(item);
        }
    } else {
      this.httpCaptureCookies = null;
    }
    return (A) this;
  }
  
  public A withHttpCaptureCookies(IngressControllerCaptureHTTPCookie... httpCaptureCookies) {
    if (this.httpCaptureCookies != null) {
        this.httpCaptureCookies.clear();
        _visitables.remove("httpCaptureCookies");
    }
    if (httpCaptureCookies != null) {
      for (IngressControllerCaptureHTTPCookie item : httpCaptureCookies) {
        this.addToHttpCaptureCookies(item);
      }
    }
    return (A) this;
  }
  
  public A withHttpCaptureHeaders(IngressControllerCaptureHTTPHeaders httpCaptureHeaders) {
    this._visitables.remove("httpCaptureHeaders");
    if (httpCaptureHeaders != null) {
        this.httpCaptureHeaders = new IngressControllerCaptureHTTPHeadersBuilder(httpCaptureHeaders);
        this._visitables.get("httpCaptureHeaders").add(this.httpCaptureHeaders);
    } else {
        this.httpCaptureHeaders = null;
        this._visitables.get("httpCaptureHeaders").remove(this.httpCaptureHeaders);
    }
    return (A) this;
  }
  
  public A withHttpLogFormat(String httpLogFormat) {
    this.httpLogFormat = httpLogFormat;
    return (A) this;
  }
  
  public A withLogEmptyRequests(String logEmptyRequests) {
    this.logEmptyRequests = logEmptyRequests;
    return (A) this;
  }
  
  public DestinationNested<A> withNewDestination() {
    return new DestinationNested(null);
  }
  
  public DestinationNested<A> withNewDestinationLike(LoggingDestination item) {
    return new DestinationNested(item);
  }
  
  public HttpCaptureHeadersNested<A> withNewHttpCaptureHeaders() {
    return new HttpCaptureHeadersNested(null);
  }
  
  public HttpCaptureHeadersNested<A> withNewHttpCaptureHeadersLike(IngressControllerCaptureHTTPHeaders item) {
    return new HttpCaptureHeadersNested(item);
  }
  public class DestinationNested<N> extends LoggingDestinationFluent<DestinationNested<N>> implements Nested<N>{
  
    LoggingDestinationBuilder builder;
  
    DestinationNested(LoggingDestination item) {
      this.builder = new LoggingDestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) AccessLoggingFluent.this.withDestination(builder.build());
    }
    
    public N endDestination() {
      return and();
    }
    
  }
  public class HttpCaptureCookiesNested<N> extends IngressControllerCaptureHTTPCookieFluent<HttpCaptureCookiesNested<N>> implements Nested<N>{
  
    IngressControllerCaptureHTTPCookieBuilder builder;
    int index;
  
    HttpCaptureCookiesNested(int index,IngressControllerCaptureHTTPCookie item) {
      this.index = index;
      this.builder = new IngressControllerCaptureHTTPCookieBuilder(this, item);
    }
  
    public N and() {
      return (N) AccessLoggingFluent.this.setToHttpCaptureCookies(index, builder.build());
    }
    
    public N endHttpCaptureCooky() {
      return and();
    }
    
  }
  public class HttpCaptureHeadersNested<N> extends IngressControllerCaptureHTTPHeadersFluent<HttpCaptureHeadersNested<N>> implements Nested<N>{
  
    IngressControllerCaptureHTTPHeadersBuilder builder;
  
    HttpCaptureHeadersNested(IngressControllerCaptureHTTPHeaders item) {
      this.builder = new IngressControllerCaptureHTTPHeadersBuilder(this, item);
    }
  
    public N and() {
      return (N) AccessLoggingFluent.this.withHttpCaptureHeaders(builder.build());
    }
    
    public N endHttpCaptureHeaders() {
      return and();
    }
    
  }
}