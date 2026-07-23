package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Long;
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
public class HTTPMatchRequestFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HTTPMatchRequestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private StringMatchBuilder authority;
  private List<String> gateways = new ArrayList<String>();
  private Map<String,StringMatch> headers;
  private Boolean ignoreUriCase;
  private StringMatchBuilder method;
  private String name;
  private Long port;
  private Map<String,StringMatch> queryParams;
  private StringMatchBuilder scheme;
  private Map<String,String> sourceLabels;
  private String sourceNamespace;
  private String statPrefix;
  private StringMatchBuilder uri;
  private Map<String,StringMatch> withoutHeaders;

  public HTTPMatchRequestFluent() {
  }
  
  public HTTPMatchRequestFluent(HTTPMatchRequest instance) {
    this.copyInstance(instance);
  }

  public A addAllToGateways(Collection<String> items) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    for (String item : items) {
      this.gateways.add(item);
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
  
  public A addToGateways(String... items) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    for (String item : items) {
      this.gateways.add(item);
    }
    return (A) this;
  }
  
  public A addToGateways(int index,String item) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    this.gateways.add(index, item);
    return (A) this;
  }
  
  public A addToHeaders(Map<String,StringMatch> map) {
    if (this.headers == null && map != null) {
      this.headers = new LinkedHashMap();
    }
    if (map != null) {
      this.headers.putAll(map);
    }
    return (A) this;
  }
  
  public A addToHeaders(String key,StringMatch value) {
    if (this.headers == null && key != null && value != null) {
      this.headers = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.headers.put(key, value);
    }
    return (A) this;
  }
  
  public A addToQueryParams(Map<String,StringMatch> map) {
    if (this.queryParams == null && map != null) {
      this.queryParams = new LinkedHashMap();
    }
    if (map != null) {
      this.queryParams.putAll(map);
    }
    return (A) this;
  }
  
  public A addToQueryParams(String key,StringMatch value) {
    if (this.queryParams == null && key != null && value != null) {
      this.queryParams = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.queryParams.put(key, value);
    }
    return (A) this;
  }
  
  public A addToSourceLabels(Map<String,String> map) {
    if (this.sourceLabels == null && map != null) {
      this.sourceLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.sourceLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSourceLabels(String key,String value) {
    if (this.sourceLabels == null && key != null && value != null) {
      this.sourceLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.sourceLabels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToWithoutHeaders(Map<String,StringMatch> map) {
    if (this.withoutHeaders == null && map != null) {
      this.withoutHeaders = new LinkedHashMap();
    }
    if (map != null) {
      this.withoutHeaders.putAll(map);
    }
    return (A) this;
  }
  
  public A addToWithoutHeaders(String key,StringMatch value) {
    if (this.withoutHeaders == null && key != null && value != null) {
      this.withoutHeaders = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.withoutHeaders.put(key, value);
    }
    return (A) this;
  }
  
  public StringMatch buildAuthority() {
    return this.authority != null ? this.authority.build() : null;
  }
  
  public StringMatch buildMethod() {
    return this.method != null ? this.method.build() : null;
  }
  
  public StringMatch buildScheme() {
    return this.scheme != null ? this.scheme.build() : null;
  }
  
  public StringMatch buildUri() {
    return this.uri != null ? this.uri.build() : null;
  }
  
  protected void copyInstance(HTTPMatchRequest instance) {
    instance = instance != null ? instance : new HTTPMatchRequest();
    if (instance != null) {
        this.withAuthority(instance.getAuthority());
        this.withGateways(instance.getGateways());
        this.withHeaders(instance.getHeaders());
        this.withIgnoreUriCase(instance.getIgnoreUriCase());
        this.withMethod(instance.getMethod());
        this.withName(instance.getName());
        this.withPort(instance.getPort());
        this.withQueryParams(instance.getQueryParams());
        this.withScheme(instance.getScheme());
        this.withSourceLabels(instance.getSourceLabels());
        this.withSourceNamespace(instance.getSourceNamespace());
        this.withStatPrefix(instance.getStatPrefix());
        this.withUri(instance.getUri());
        this.withWithoutHeaders(instance.getWithoutHeaders());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthorityNested<A> editAuthority() {
    return this.withNewAuthorityLike(Optional.ofNullable(this.buildAuthority()).orElse(null));
  }
  
  public MethodNested<A> editMethod() {
    return this.withNewMethodLike(Optional.ofNullable(this.buildMethod()).orElse(null));
  }
  
  public AuthorityNested<A> editOrNewAuthority() {
    return this.withNewAuthorityLike(Optional.ofNullable(this.buildAuthority()).orElse(new StringMatchBuilder().build()));
  }
  
  public AuthorityNested<A> editOrNewAuthorityLike(StringMatch item) {
    return this.withNewAuthorityLike(Optional.ofNullable(this.buildAuthority()).orElse(item));
  }
  
  public MethodNested<A> editOrNewMethod() {
    return this.withNewMethodLike(Optional.ofNullable(this.buildMethod()).orElse(new StringMatchBuilder().build()));
  }
  
  public MethodNested<A> editOrNewMethodLike(StringMatch item) {
    return this.withNewMethodLike(Optional.ofNullable(this.buildMethod()).orElse(item));
  }
  
  public SchemeNested<A> editOrNewScheme() {
    return this.withNewSchemeLike(Optional.ofNullable(this.buildScheme()).orElse(new StringMatchBuilder().build()));
  }
  
  public SchemeNested<A> editOrNewSchemeLike(StringMatch item) {
    return this.withNewSchemeLike(Optional.ofNullable(this.buildScheme()).orElse(item));
  }
  
  public UriNested<A> editOrNewUri() {
    return this.withNewUriLike(Optional.ofNullable(this.buildUri()).orElse(new StringMatchBuilder().build()));
  }
  
  public UriNested<A> editOrNewUriLike(StringMatch item) {
    return this.withNewUriLike(Optional.ofNullable(this.buildUri()).orElse(item));
  }
  
  public SchemeNested<A> editScheme() {
    return this.withNewSchemeLike(Optional.ofNullable(this.buildScheme()).orElse(null));
  }
  
  public UriNested<A> editUri() {
    return this.withNewUriLike(Optional.ofNullable(this.buildUri()).orElse(null));
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
    HTTPMatchRequestFluent that = (HTTPMatchRequestFluent) o;
    if (!(Objects.equals(authority, that.authority))) {
      return false;
    }
    if (!(Objects.equals(gateways, that.gateways))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(ignoreUriCase, that.ignoreUriCase))) {
      return false;
    }
    if (!(Objects.equals(method, that.method))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(queryParams, that.queryParams))) {
      return false;
    }
    if (!(Objects.equals(scheme, that.scheme))) {
      return false;
    }
    if (!(Objects.equals(sourceLabels, that.sourceLabels))) {
      return false;
    }
    if (!(Objects.equals(sourceNamespace, that.sourceNamespace))) {
      return false;
    }
    if (!(Objects.equals(statPrefix, that.statPrefix))) {
      return false;
    }
    if (!(Objects.equals(uri, that.uri))) {
      return false;
    }
    if (!(Objects.equals(withoutHeaders, that.withoutHeaders))) {
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
  
  public String getFirstGateway() {
    return this.gateways.get(0);
  }
  
  public String getGateway(int index) {
    return this.gateways.get(index);
  }
  
  public List<String> getGateways() {
    return this.gateways;
  }
  
  public Map<String,StringMatch> getHeaders() {
    return this.headers;
  }
  
  public Boolean getIgnoreUriCase() {
    return this.ignoreUriCase;
  }
  
  public String getLastGateway() {
    return this.gateways.get(gateways.size() - 1);
  }
  
  public String getMatchingGateway(Predicate<String> predicate) {
      for (String item : gateways) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Long getPort() {
    return this.port;
  }
  
  public Map<String,StringMatch> getQueryParams() {
    return this.queryParams;
  }
  
  public Map<String,String> getSourceLabels() {
    return this.sourceLabels;
  }
  
  public String getSourceNamespace() {
    return this.sourceNamespace;
  }
  
  public String getStatPrefix() {
    return this.statPrefix;
  }
  
  public Map<String,StringMatch> getWithoutHeaders() {
    return this.withoutHeaders;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthority() {
    return this.authority != null;
  }
  
  public boolean hasGateways() {
    return this.gateways != null && !(this.gateways.isEmpty());
  }
  
  public boolean hasHeaders() {
    return this.headers != null;
  }
  
  public boolean hasIgnoreUriCase() {
    return this.ignoreUriCase != null;
  }
  
  public boolean hasMatchingGateway(Predicate<String> predicate) {
      for (String item : gateways) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMethod() {
    return this.method != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasQueryParams() {
    return this.queryParams != null;
  }
  
  public boolean hasScheme() {
    return this.scheme != null;
  }
  
  public boolean hasSourceLabels() {
    return this.sourceLabels != null;
  }
  
  public boolean hasSourceNamespace() {
    return this.sourceNamespace != null;
  }
  
  public boolean hasStatPrefix() {
    return this.statPrefix != null;
  }
  
  public boolean hasUri() {
    return this.uri != null;
  }
  
  public boolean hasWithoutHeaders() {
    return this.withoutHeaders != null;
  }
  
  public int hashCode() {
    return Objects.hash(authority, gateways, headers, ignoreUriCase, method, name, port, queryParams, scheme, sourceLabels, sourceNamespace, statPrefix, uri, withoutHeaders, additionalProperties);
  }
  
  public A removeAllFromGateways(Collection<String> items) {
    if (this.gateways == null) {
      return (A) this;
    }
    for (String item : items) {
      this.gateways.remove(item);
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
  
  public A removeFromGateways(String... items) {
    if (this.gateways == null) {
      return (A) this;
    }
    for (String item : items) {
      this.gateways.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromHeaders(String key) {
    if (this.headers == null) {
      return (A) this;
    }
    if (key != null && this.headers != null) {
      this.headers.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromHeaders(Map<String,StringMatch> map) {
    if (this.headers == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.headers != null) {
          this.headers.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromQueryParams(String key) {
    if (this.queryParams == null) {
      return (A) this;
    }
    if (key != null && this.queryParams != null) {
      this.queryParams.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromQueryParams(Map<String,StringMatch> map) {
    if (this.queryParams == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.queryParams != null) {
          this.queryParams.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromSourceLabels(String key) {
    if (this.sourceLabels == null) {
      return (A) this;
    }
    if (key != null && this.sourceLabels != null) {
      this.sourceLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSourceLabels(Map<String,String> map) {
    if (this.sourceLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.sourceLabels != null) {
          this.sourceLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromWithoutHeaders(String key) {
    if (this.withoutHeaders == null) {
      return (A) this;
    }
    if (key != null && this.withoutHeaders != null) {
      this.withoutHeaders.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromWithoutHeaders(Map<String,StringMatch> map) {
    if (this.withoutHeaders == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.withoutHeaders != null) {
          this.withoutHeaders.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToGateways(int index,String item) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    this.gateways.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(authority == null)) {
        sb.append("authority:");
        sb.append(authority);
        sb.append(",");
    }
    if (!(gateways == null) && !(gateways.isEmpty())) {
        sb.append("gateways:");
        sb.append(gateways);
        sb.append(",");
    }
    if (!(headers == null) && !(headers.isEmpty())) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(ignoreUriCase == null)) {
        sb.append("ignoreUriCase:");
        sb.append(ignoreUriCase);
        sb.append(",");
    }
    if (!(method == null)) {
        sb.append("method:");
        sb.append(method);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(queryParams == null) && !(queryParams.isEmpty())) {
        sb.append("queryParams:");
        sb.append(queryParams);
        sb.append(",");
    }
    if (!(scheme == null)) {
        sb.append("scheme:");
        sb.append(scheme);
        sb.append(",");
    }
    if (!(sourceLabels == null) && !(sourceLabels.isEmpty())) {
        sb.append("sourceLabels:");
        sb.append(sourceLabels);
        sb.append(",");
    }
    if (!(sourceNamespace == null)) {
        sb.append("sourceNamespace:");
        sb.append(sourceNamespace);
        sb.append(",");
    }
    if (!(statPrefix == null)) {
        sb.append("statPrefix:");
        sb.append(statPrefix);
        sb.append(",");
    }
    if (!(uri == null)) {
        sb.append("uri:");
        sb.append(uri);
        sb.append(",");
    }
    if (!(withoutHeaders == null) && !(withoutHeaders.isEmpty())) {
        sb.append("withoutHeaders:");
        sb.append(withoutHeaders);
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
  
  public A withAuthority(StringMatch authority) {
    this._visitables.remove("authority");
    if (authority != null) {
        this.authority = new StringMatchBuilder(authority);
        this._visitables.get("authority").add(this.authority);
    } else {
        this.authority = null;
        this._visitables.get("authority").remove(this.authority);
    }
    return (A) this;
  }
  
  public A withGateways(List<String> gateways) {
    if (gateways != null) {
        this.gateways = new ArrayList();
        for (String item : gateways) {
          this.addToGateways(item);
        }
    } else {
      this.gateways = null;
    }
    return (A) this;
  }
  
  public A withGateways(String... gateways) {
    if (this.gateways != null) {
        this.gateways.clear();
        _visitables.remove("gateways");
    }
    if (gateways != null) {
      for (String item : gateways) {
        this.addToGateways(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withHeaders(Map<String,StringMatch> headers) {
    if (headers == null) {
      this.headers = null;
    } else {
      this.headers = new LinkedHashMap(headers);
    }
    return (A) this;
  }
  
  public A withIgnoreUriCase() {
    return withIgnoreUriCase(true);
  }
  
  public A withIgnoreUriCase(Boolean ignoreUriCase) {
    this.ignoreUriCase = ignoreUriCase;
    return (A) this;
  }
  
  public A withMethod(StringMatch method) {
    this._visitables.remove("method");
    if (method != null) {
        this.method = new StringMatchBuilder(method);
        this._visitables.get("method").add(this.method);
    } else {
        this.method = null;
        this._visitables.get("method").remove(this.method);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public AuthorityNested<A> withNewAuthority() {
    return new AuthorityNested(null);
  }
  
  public AuthorityNested<A> withNewAuthorityLike(StringMatch item) {
    return new AuthorityNested(item);
  }
  
  public MethodNested<A> withNewMethod() {
    return new MethodNested(null);
  }
  
  public MethodNested<A> withNewMethodLike(StringMatch item) {
    return new MethodNested(item);
  }
  
  public SchemeNested<A> withNewScheme() {
    return new SchemeNested(null);
  }
  
  public SchemeNested<A> withNewSchemeLike(StringMatch item) {
    return new SchemeNested(item);
  }
  
  public UriNested<A> withNewUri() {
    return new UriNested(null);
  }
  
  public UriNested<A> withNewUriLike(StringMatch item) {
    return new UriNested(item);
  }
  
  public A withPort(Long port) {
    this.port = port;
    return (A) this;
  }
  
  public <K,V>A withQueryParams(Map<String,StringMatch> queryParams) {
    if (queryParams == null) {
      this.queryParams = null;
    } else {
      this.queryParams = new LinkedHashMap(queryParams);
    }
    return (A) this;
  }
  
  public A withScheme(StringMatch scheme) {
    this._visitables.remove("scheme");
    if (scheme != null) {
        this.scheme = new StringMatchBuilder(scheme);
        this._visitables.get("scheme").add(this.scheme);
    } else {
        this.scheme = null;
        this._visitables.get("scheme").remove(this.scheme);
    }
    return (A) this;
  }
  
  public <K,V>A withSourceLabels(Map<String,String> sourceLabels) {
    if (sourceLabels == null) {
      this.sourceLabels = null;
    } else {
      this.sourceLabels = new LinkedHashMap(sourceLabels);
    }
    return (A) this;
  }
  
  public A withSourceNamespace(String sourceNamespace) {
    this.sourceNamespace = sourceNamespace;
    return (A) this;
  }
  
  public A withStatPrefix(String statPrefix) {
    this.statPrefix = statPrefix;
    return (A) this;
  }
  
  public A withUri(StringMatch uri) {
    this._visitables.remove("uri");
    if (uri != null) {
        this.uri = new StringMatchBuilder(uri);
        this._visitables.get("uri").add(this.uri);
    } else {
        this.uri = null;
        this._visitables.get("uri").remove(this.uri);
    }
    return (A) this;
  }
  
  public <K,V>A withWithoutHeaders(Map<String,StringMatch> withoutHeaders) {
    if (withoutHeaders == null) {
      this.withoutHeaders = null;
    } else {
      this.withoutHeaders = new LinkedHashMap(withoutHeaders);
    }
    return (A) this;
  }
  public class AuthorityNested<N> extends StringMatchFluent<AuthorityNested<N>> implements Nested<N>{
  
    StringMatchBuilder builder;
  
    AuthorityNested(StringMatch item) {
      this.builder = new StringMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPMatchRequestFluent.this.withAuthority(builder.build());
    }
    
    public N endAuthority() {
      return and();
    }
    
  }
  public class MethodNested<N> extends StringMatchFluent<MethodNested<N>> implements Nested<N>{
  
    StringMatchBuilder builder;
  
    MethodNested(StringMatch item) {
      this.builder = new StringMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPMatchRequestFluent.this.withMethod(builder.build());
    }
    
    public N endMethod() {
      return and();
    }
    
  }
  public class SchemeNested<N> extends StringMatchFluent<SchemeNested<N>> implements Nested<N>{
  
    StringMatchBuilder builder;
  
    SchemeNested(StringMatch item) {
      this.builder = new StringMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPMatchRequestFluent.this.withScheme(builder.build());
    }
    
    public N endScheme() {
      return and();
    }
    
  }
  public class UriNested<N> extends StringMatchFluent<UriNested<N>> implements Nested<N>{
  
    StringMatchBuilder builder;
  
    UriNested(StringMatch item) {
      this.builder = new StringMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPMatchRequestFluent.this.withUri(builder.build());
    }
    
    public N endUri() {
      return and();
    }
    
  }
}