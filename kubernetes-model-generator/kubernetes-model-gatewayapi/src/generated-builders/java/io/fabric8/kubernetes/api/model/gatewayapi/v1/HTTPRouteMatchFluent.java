package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HTTPRouteMatchFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRouteMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<HTTPHeaderMatchBuilder> headers = new ArrayList<HTTPHeaderMatchBuilder>();
  private String method;
  private HTTPPathMatchBuilder path;
  private ArrayList<HTTPQueryParamMatchBuilder> queryParams = new ArrayList<HTTPQueryParamMatchBuilder>();

  public HTTPRouteMatchFluent() {
  }
  
  public HTTPRouteMatchFluent(HTTPRouteMatch instance) {
    this.copyInstance(instance);
  }

  public A addAllToHeaders(Collection<HTTPHeaderMatch> items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (HTTPHeaderMatch item : items) {
        HTTPHeaderMatchBuilder builder = new HTTPHeaderMatchBuilder(item);
        _visitables.get("headers").add(builder);
        this.headers.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToQueryParams(Collection<HTTPQueryParamMatch> items) {
    if (this.queryParams == null) {
      this.queryParams = new ArrayList();
    }
    for (HTTPQueryParamMatch item : items) {
        HTTPQueryParamMatchBuilder builder = new HTTPQueryParamMatchBuilder(item);
        _visitables.get("queryParams").add(builder);
        this.queryParams.add(builder);
    }
    return (A) this;
  }
  
  public HeadersNested<A> addNewHeader() {
    return new HeadersNested(-1, null);
  }
  
  public A addNewHeader(String name,String type,String value) {
    return (A) this.addToHeaders(new HTTPHeaderMatch(name, type, value));
  }
  
  public HeadersNested<A> addNewHeaderLike(HTTPHeaderMatch item) {
    return new HeadersNested(-1, item);
  }
  
  public QueryParamsNested<A> addNewQueryParam() {
    return new QueryParamsNested(-1, null);
  }
  
  public A addNewQueryParam(String name,String type,String value) {
    return (A) this.addToQueryParams(new HTTPQueryParamMatch(name, type, value));
  }
  
  public QueryParamsNested<A> addNewQueryParamLike(HTTPQueryParamMatch item) {
    return new QueryParamsNested(-1, item);
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
  
  public A addToHeaders(HTTPHeaderMatch... items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (HTTPHeaderMatch item : items) {
        HTTPHeaderMatchBuilder builder = new HTTPHeaderMatchBuilder(item);
        _visitables.get("headers").add(builder);
        this.headers.add(builder);
    }
    return (A) this;
  }
  
  public A addToHeaders(int index,HTTPHeaderMatch item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    HTTPHeaderMatchBuilder builder = new HTTPHeaderMatchBuilder(item);
    if (index < 0 || index >= headers.size()) {
        _visitables.get("headers").add(builder);
        headers.add(builder);
    } else {
        _visitables.get("headers").add(builder);
        headers.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToQueryParams(HTTPQueryParamMatch... items) {
    if (this.queryParams == null) {
      this.queryParams = new ArrayList();
    }
    for (HTTPQueryParamMatch item : items) {
        HTTPQueryParamMatchBuilder builder = new HTTPQueryParamMatchBuilder(item);
        _visitables.get("queryParams").add(builder);
        this.queryParams.add(builder);
    }
    return (A) this;
  }
  
  public A addToQueryParams(int index,HTTPQueryParamMatch item) {
    if (this.queryParams == null) {
      this.queryParams = new ArrayList();
    }
    HTTPQueryParamMatchBuilder builder = new HTTPQueryParamMatchBuilder(item);
    if (index < 0 || index >= queryParams.size()) {
        _visitables.get("queryParams").add(builder);
        queryParams.add(builder);
    } else {
        _visitables.get("queryParams").add(builder);
        queryParams.add(index, builder);
    }
    return (A) this;
  }
  
  public HTTPHeaderMatch buildFirstHeader() {
    return this.headers.get(0).build();
  }
  
  public HTTPQueryParamMatch buildFirstQueryParam() {
    return this.queryParams.get(0).build();
  }
  
  public HTTPHeaderMatch buildHeader(int index) {
    return this.headers.get(index).build();
  }
  
  public List<HTTPHeaderMatch> buildHeaders() {
    return this.headers != null ? build(headers) : null;
  }
  
  public HTTPHeaderMatch buildLastHeader() {
    return this.headers.get(headers.size() - 1).build();
  }
  
  public HTTPQueryParamMatch buildLastQueryParam() {
    return this.queryParams.get(queryParams.size() - 1).build();
  }
  
  public HTTPHeaderMatch buildMatchingHeader(Predicate<HTTPHeaderMatchBuilder> predicate) {
      for (HTTPHeaderMatchBuilder item : headers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HTTPQueryParamMatch buildMatchingQueryParam(Predicate<HTTPQueryParamMatchBuilder> predicate) {
      for (HTTPQueryParamMatchBuilder item : queryParams) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HTTPPathMatch buildPath() {
    return this.path != null ? this.path.build() : null;
  }
  
  public HTTPQueryParamMatch buildQueryParam(int index) {
    return this.queryParams.get(index).build();
  }
  
  public List<HTTPQueryParamMatch> buildQueryParams() {
    return this.queryParams != null ? build(queryParams) : null;
  }
  
  protected void copyInstance(HTTPRouteMatch instance) {
    instance = instance != null ? instance : new HTTPRouteMatch();
    if (instance != null) {
        this.withHeaders(instance.getHeaders());
        this.withMethod(instance.getMethod());
        this.withPath(instance.getPath());
        this.withQueryParams(instance.getQueryParams());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HeadersNested<A> editFirstHeader() {
    if (headers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "headers"));
    }
    return this.setNewHeaderLike(0, this.buildHeader(0));
  }
  
  public QueryParamsNested<A> editFirstQueryParam() {
    if (queryParams.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "queryParams"));
    }
    return this.setNewQueryParamLike(0, this.buildQueryParam(0));
  }
  
  public HeadersNested<A> editHeader(int index) {
    if (headers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "headers"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public HeadersNested<A> editLastHeader() {
    int index = headers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "headers"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public QueryParamsNested<A> editLastQueryParam() {
    int index = queryParams.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "queryParams"));
    }
    return this.setNewQueryParamLike(index, this.buildQueryParam(index));
  }
  
  public HeadersNested<A> editMatchingHeader(Predicate<HTTPHeaderMatchBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < headers.size();i++) {
      if (predicate.test(headers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "headers"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public QueryParamsNested<A> editMatchingQueryParam(Predicate<HTTPQueryParamMatchBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < queryParams.size();i++) {
      if (predicate.test(queryParams.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "queryParams"));
    }
    return this.setNewQueryParamLike(index, this.buildQueryParam(index));
  }
  
  public PathNested<A> editOrNewPath() {
    return this.withNewPathLike(Optional.ofNullable(this.buildPath()).orElse(new HTTPPathMatchBuilder().build()));
  }
  
  public PathNested<A> editOrNewPathLike(HTTPPathMatch item) {
    return this.withNewPathLike(Optional.ofNullable(this.buildPath()).orElse(item));
  }
  
  public PathNested<A> editPath() {
    return this.withNewPathLike(Optional.ofNullable(this.buildPath()).orElse(null));
  }
  
  public QueryParamsNested<A> editQueryParam(int index) {
    if (queryParams.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "queryParams"));
    }
    return this.setNewQueryParamLike(index, this.buildQueryParam(index));
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
    HTTPRouteMatchFluent that = (HTTPRouteMatchFluent) o;
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(method, that.method))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(queryParams, that.queryParams))) {
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
  
  public String getMethod() {
    return this.method;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null && !(this.headers.isEmpty());
  }
  
  public boolean hasMatchingHeader(Predicate<HTTPHeaderMatchBuilder> predicate) {
      for (HTTPHeaderMatchBuilder item : headers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingQueryParam(Predicate<HTTPQueryParamMatchBuilder> predicate) {
      for (HTTPQueryParamMatchBuilder item : queryParams) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMethod() {
    return this.method != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasQueryParams() {
    return this.queryParams != null && !(this.queryParams.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(headers, method, path, queryParams, additionalProperties);
  }
  
  public A removeAllFromHeaders(Collection<HTTPHeaderMatch> items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (HTTPHeaderMatch item : items) {
        HTTPHeaderMatchBuilder builder = new HTTPHeaderMatchBuilder(item);
        _visitables.get("headers").remove(builder);
        this.headers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromQueryParams(Collection<HTTPQueryParamMatch> items) {
    if (this.queryParams == null) {
      return (A) this;
    }
    for (HTTPQueryParamMatch item : items) {
        HTTPQueryParamMatchBuilder builder = new HTTPQueryParamMatchBuilder(item);
        _visitables.get("queryParams").remove(builder);
        this.queryParams.remove(builder);
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
  
  public A removeFromHeaders(HTTPHeaderMatch... items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (HTTPHeaderMatch item : items) {
        HTTPHeaderMatchBuilder builder = new HTTPHeaderMatchBuilder(item);
        _visitables.get("headers").remove(builder);
        this.headers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromQueryParams(HTTPQueryParamMatch... items) {
    if (this.queryParams == null) {
      return (A) this;
    }
    for (HTTPQueryParamMatch item : items) {
        HTTPQueryParamMatchBuilder builder = new HTTPQueryParamMatchBuilder(item);
        _visitables.get("queryParams").remove(builder);
        this.queryParams.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHeaders(Predicate<HTTPHeaderMatchBuilder> predicate) {
    if (headers == null) {
      return (A) this;
    }
    Iterator<HTTPHeaderMatchBuilder> each = headers.iterator();
    List visitables = _visitables.get("headers");
    while (each.hasNext()) {
        HTTPHeaderMatchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromQueryParams(Predicate<HTTPQueryParamMatchBuilder> predicate) {
    if (queryParams == null) {
      return (A) this;
    }
    Iterator<HTTPQueryParamMatchBuilder> each = queryParams.iterator();
    List visitables = _visitables.get("queryParams");
    while (each.hasNext()) {
        HTTPQueryParamMatchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HeadersNested<A> setNewHeaderLike(int index,HTTPHeaderMatch item) {
    return new HeadersNested(index, item);
  }
  
  public QueryParamsNested<A> setNewQueryParamLike(int index,HTTPQueryParamMatch item) {
    return new QueryParamsNested(index, item);
  }
  
  public A setToHeaders(int index,HTTPHeaderMatch item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    HTTPHeaderMatchBuilder builder = new HTTPHeaderMatchBuilder(item);
    if (index < 0 || index >= headers.size()) {
        _visitables.get("headers").add(builder);
        headers.add(builder);
    } else {
        _visitables.get("headers").add(builder);
        headers.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToQueryParams(int index,HTTPQueryParamMatch item) {
    if (this.queryParams == null) {
      this.queryParams = new ArrayList();
    }
    HTTPQueryParamMatchBuilder builder = new HTTPQueryParamMatchBuilder(item);
    if (index < 0 || index >= queryParams.size()) {
        _visitables.get("queryParams").add(builder);
        queryParams.add(builder);
    } else {
        _visitables.get("queryParams").add(builder);
        queryParams.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(headers == null) && !(headers.isEmpty())) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(method == null)) {
        sb.append("method:");
        sb.append(method);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(queryParams == null) && !(queryParams.isEmpty())) {
        sb.append("queryParams:");
        sb.append(queryParams);
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
  
  public A withHeaders(List<HTTPHeaderMatch> headers) {
    if (this.headers != null) {
      this._visitables.get("headers").clear();
    }
    if (headers != null) {
        this.headers = new ArrayList();
        for (HTTPHeaderMatch item : headers) {
          this.addToHeaders(item);
        }
    } else {
      this.headers = null;
    }
    return (A) this;
  }
  
  public A withHeaders(HTTPHeaderMatch... headers) {
    if (this.headers != null) {
        this.headers.clear();
        _visitables.remove("headers");
    }
    if (headers != null) {
      for (HTTPHeaderMatch item : headers) {
        this.addToHeaders(item);
      }
    }
    return (A) this;
  }
  
  public A withMethod(String method) {
    this.method = method;
    return (A) this;
  }
  
  public PathNested<A> withNewPath() {
    return new PathNested(null);
  }
  
  public A withNewPath(String type,String value) {
    return (A) this.withPath(new HTTPPathMatch(type, value));
  }
  
  public PathNested<A> withNewPathLike(HTTPPathMatch item) {
    return new PathNested(item);
  }
  
  public A withPath(HTTPPathMatch path) {
    this._visitables.remove("path");
    if (path != null) {
        this.path = new HTTPPathMatchBuilder(path);
        this._visitables.get("path").add(this.path);
    } else {
        this.path = null;
        this._visitables.get("path").remove(this.path);
    }
    return (A) this;
  }
  
  public A withQueryParams(List<HTTPQueryParamMatch> queryParams) {
    if (this.queryParams != null) {
      this._visitables.get("queryParams").clear();
    }
    if (queryParams != null) {
        this.queryParams = new ArrayList();
        for (HTTPQueryParamMatch item : queryParams) {
          this.addToQueryParams(item);
        }
    } else {
      this.queryParams = null;
    }
    return (A) this;
  }
  
  public A withQueryParams(HTTPQueryParamMatch... queryParams) {
    if (this.queryParams != null) {
        this.queryParams.clear();
        _visitables.remove("queryParams");
    }
    if (queryParams != null) {
      for (HTTPQueryParamMatch item : queryParams) {
        this.addToQueryParams(item);
      }
    }
    return (A) this;
  }
  public class HeadersNested<N> extends HTTPHeaderMatchFluent<HeadersNested<N>> implements Nested<N>{
  
    HTTPHeaderMatchBuilder builder;
    int index;
  
    HeadersNested(int index,HTTPHeaderMatch item) {
      this.index = index;
      this.builder = new HTTPHeaderMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteMatchFluent.this.setToHeaders(index, builder.build());
    }
    
    public N endHeader() {
      return and();
    }
    
  }
  public class PathNested<N> extends HTTPPathMatchFluent<PathNested<N>> implements Nested<N>{
  
    HTTPPathMatchBuilder builder;
  
    PathNested(HTTPPathMatch item) {
      this.builder = new HTTPPathMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteMatchFluent.this.withPath(builder.build());
    }
    
    public N endPath() {
      return and();
    }
    
  }
  public class QueryParamsNested<N> extends HTTPQueryParamMatchFluent<QueryParamsNested<N>> implements Nested<N>{
  
    HTTPQueryParamMatchBuilder builder;
    int index;
  
    QueryParamsNested(int index,HTTPQueryParamMatch item) {
      this.index = index;
      this.builder = new HTTPQueryParamMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteMatchFluent.this.setToQueryParams(index, builder.build());
    }
    
    public N endQueryParam() {
      return and();
    }
    
  }
}