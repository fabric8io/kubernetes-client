package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
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
public class HTTPChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.HTTPChaosSpecFluent<A>> extends BaseFluent<A>{

  private Boolean abort;
  private Map<String,Object> additionalProperties;
  private Integer code;
  private String delay;
  private String duration;
  private String method;
  private String mode;
  private PodHttpChaosPatchActionsBuilder patch;
  private String path;
  private Integer port;
  private String remoteCluster;
  private PodHttpChaosReplaceActionsBuilder replace;
  private Map<String,String> requestHeaders;
  private Map<String,String> responseHeaders;
  private PodSelectorSpecBuilder selector;
  private String target;
  private PodHttpChaosTLSBuilder tls;
  private String value;

  public HTTPChaosSpecFluent() {
  }
  
  public HTTPChaosSpecFluent(HTTPChaosSpec instance) {
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
  
  public A addToRequestHeaders(Map<String,String> map) {
    if (this.requestHeaders == null && map != null) {
      this.requestHeaders = new LinkedHashMap();
    }
    if (map != null) {
      this.requestHeaders.putAll(map);
    }
    return (A) this;
  }
  
  public A addToRequestHeaders(String key,String value) {
    if (this.requestHeaders == null && key != null && value != null) {
      this.requestHeaders = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.requestHeaders.put(key, value);
    }
    return (A) this;
  }
  
  public A addToResponseHeaders(Map<String,String> map) {
    if (this.responseHeaders == null && map != null) {
      this.responseHeaders = new LinkedHashMap();
    }
    if (map != null) {
      this.responseHeaders.putAll(map);
    }
    return (A) this;
  }
  
  public A addToResponseHeaders(String key,String value) {
    if (this.responseHeaders == null && key != null && value != null) {
      this.responseHeaders = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.responseHeaders.put(key, value);
    }
    return (A) this;
  }
  
  public PodHttpChaosPatchActions buildPatch() {
    return this.patch != null ? this.patch.build() : null;
  }
  
  public PodHttpChaosReplaceActions buildReplace() {
    return this.replace != null ? this.replace.build() : null;
  }
  
  public PodSelectorSpec buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public PodHttpChaosTLS buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  protected void copyInstance(HTTPChaosSpec instance) {
    instance = instance != null ? instance : new HTTPChaosSpec();
    if (instance != null) {
        this.withAbort(instance.getAbort());
        this.withCode(instance.getCode());
        this.withDelay(instance.getDelay());
        this.withDuration(instance.getDuration());
        this.withMethod(instance.getMethod());
        this.withMode(instance.getMode());
        this.withPatch(instance.getPatch());
        this.withPath(instance.getPath());
        this.withPort(instance.getPort());
        this.withRemoteCluster(instance.getRemoteCluster());
        this.withReplace(instance.getReplace());
        this.withRequestHeaders(instance.getRequestHeaders());
        this.withResponseHeaders(instance.getResponseHeaders());
        this.withSelector(instance.getSelector());
        this.withTarget(instance.getTarget());
        this.withTls(instance.getTls());
        this.withValue(instance.getValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PatchNested<A> editOrNewPatch() {
    return this.withNewPatchLike(Optional.ofNullable(this.buildPatch()).orElse(new PodHttpChaosPatchActionsBuilder().build()));
  }
  
  public PatchNested<A> editOrNewPatchLike(PodHttpChaosPatchActions item) {
    return this.withNewPatchLike(Optional.ofNullable(this.buildPatch()).orElse(item));
  }
  
  public ReplaceNested<A> editOrNewReplace() {
    return this.withNewReplaceLike(Optional.ofNullable(this.buildReplace()).orElse(new PodHttpChaosReplaceActionsBuilder().build()));
  }
  
  public ReplaceNested<A> editOrNewReplaceLike(PodHttpChaosReplaceActions item) {
    return this.withNewReplaceLike(Optional.ofNullable(this.buildReplace()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new PodSelectorSpecBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(PodSelectorSpec item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new PodHttpChaosTLSBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(PodHttpChaosTLS item) {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(item));
  }
  
  public PatchNested<A> editPatch() {
    return this.withNewPatchLike(Optional.ofNullable(this.buildPatch()).orElse(null));
  }
  
  public ReplaceNested<A> editReplace() {
    return this.withNewReplaceLike(Optional.ofNullable(this.buildReplace()).orElse(null));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public TlsNested<A> editTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(null));
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
    HTTPChaosSpecFluent that = (HTTPChaosSpecFluent) o;
    if (!(Objects.equals(abort, that.abort))) {
      return false;
    }
    if (!(Objects.equals(code, that.code))) {
      return false;
    }
    if (!(Objects.equals(delay, that.delay))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(method, that.method))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(patch, that.patch))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(remoteCluster, that.remoteCluster))) {
      return false;
    }
    if (!(Objects.equals(replace, that.replace))) {
      return false;
    }
    if (!(Objects.equals(requestHeaders, that.requestHeaders))) {
      return false;
    }
    if (!(Objects.equals(responseHeaders, that.responseHeaders))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(target, that.target))) {
      return false;
    }
    if (!(Objects.equals(tls, that.tls))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Boolean getAbort() {
    return this.abort;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Integer getCode() {
    return this.code;
  }
  
  public String getDelay() {
    return this.delay;
  }
  
  public String getDuration() {
    return this.duration;
  }
  
  public String getMethod() {
    return this.method;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public String getRemoteCluster() {
    return this.remoteCluster;
  }
  
  public Map<String,String> getRequestHeaders() {
    return this.requestHeaders;
  }
  
  public Map<String,String> getResponseHeaders() {
    return this.responseHeaders;
  }
  
  public String getTarget() {
    return this.target;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public boolean hasAbort() {
    return this.abort != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCode() {
    return this.code != null;
  }
  
  public boolean hasDelay() {
    return this.delay != null;
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasMethod() {
    return this.method != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasPatch() {
    return this.patch != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasRemoteCluster() {
    return this.remoteCluster != null;
  }
  
  public boolean hasReplace() {
    return this.replace != null;
  }
  
  public boolean hasRequestHeaders() {
    return this.requestHeaders != null;
  }
  
  public boolean hasResponseHeaders() {
    return this.responseHeaders != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasTarget() {
    return this.target != null;
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(abort, code, delay, duration, method, mode, patch, path, port, remoteCluster, replace, requestHeaders, responseHeaders, selector, target, tls, value, additionalProperties);
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
  
  public A removeFromRequestHeaders(String key) {
    if (this.requestHeaders == null) {
      return (A) this;
    }
    if (key != null && this.requestHeaders != null) {
      this.requestHeaders.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromRequestHeaders(Map<String,String> map) {
    if (this.requestHeaders == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.requestHeaders != null) {
          this.requestHeaders.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromResponseHeaders(String key) {
    if (this.responseHeaders == null) {
      return (A) this;
    }
    if (key != null && this.responseHeaders != null) {
      this.responseHeaders.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromResponseHeaders(Map<String,String> map) {
    if (this.responseHeaders == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.responseHeaders != null) {
          this.responseHeaders.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(abort == null)) {
        sb.append("abort:");
        sb.append(abort);
        sb.append(",");
    }
    if (!(code == null)) {
        sb.append("code:");
        sb.append(code);
        sb.append(",");
    }
    if (!(delay == null)) {
        sb.append("delay:");
        sb.append(delay);
        sb.append(",");
    }
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(method == null)) {
        sb.append("method:");
        sb.append(method);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(patch == null)) {
        sb.append("patch:");
        sb.append(patch);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(remoteCluster == null)) {
        sb.append("remoteCluster:");
        sb.append(remoteCluster);
        sb.append(",");
    }
    if (!(replace == null)) {
        sb.append("replace:");
        sb.append(replace);
        sb.append(",");
    }
    if (!(requestHeaders == null) && !(requestHeaders.isEmpty())) {
        sb.append("requestHeaders:");
        sb.append(requestHeaders);
        sb.append(",");
    }
    if (!(responseHeaders == null) && !(responseHeaders.isEmpty())) {
        sb.append("responseHeaders:");
        sb.append(responseHeaders);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(target == null)) {
        sb.append("target:");
        sb.append(target);
        sb.append(",");
    }
    if (!(tls == null)) {
        sb.append("tls:");
        sb.append(tls);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAbort() {
    return withAbort(true);
  }
  
  public A withAbort(Boolean abort) {
    this.abort = abort;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withCode(Integer code) {
    this.code = code;
    return (A) this;
  }
  
  public A withDelay(String delay) {
    this.delay = delay;
    return (A) this;
  }
  
  public A withDuration(String duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withMethod(String method) {
    this.method = method;
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public PatchNested<A> withNewPatch() {
    return new PatchNested(null);
  }
  
  public PatchNested<A> withNewPatchLike(PodHttpChaosPatchActions item) {
    return new PatchNested(item);
  }
  
  public ReplaceNested<A> withNewReplace() {
    return new ReplaceNested(null);
  }
  
  public ReplaceNested<A> withNewReplaceLike(PodHttpChaosReplaceActions item) {
    return new ReplaceNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(PodSelectorSpec item) {
    return new SelectorNested(item);
  }
  
  public TlsNested<A> withNewTls() {
    return new TlsNested(null);
  }
  
  public A withNewTls(String caName,String certName,String keyName,String secretName,String secretNamespace) {
    return (A) this.withTls(new PodHttpChaosTLS(caName, certName, keyName, secretName, secretNamespace));
  }
  
  public TlsNested<A> withNewTlsLike(PodHttpChaosTLS item) {
    return new TlsNested(item);
  }
  
  public A withPatch(PodHttpChaosPatchActions patch) {
    this._visitables.remove("patch");
    if (patch != null) {
        this.patch = new PodHttpChaosPatchActionsBuilder(patch);
        this._visitables.get("patch").add(this.patch);
    } else {
        this.patch = null;
        this._visitables.get("patch").remove(this.patch);
    }
    return (A) this;
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withRemoteCluster(String remoteCluster) {
    this.remoteCluster = remoteCluster;
    return (A) this;
  }
  
  public A withReplace(PodHttpChaosReplaceActions replace) {
    this._visitables.remove("replace");
    if (replace != null) {
        this.replace = new PodHttpChaosReplaceActionsBuilder(replace);
        this._visitables.get("replace").add(this.replace);
    } else {
        this.replace = null;
        this._visitables.get("replace").remove(this.replace);
    }
    return (A) this;
  }
  
  public <K,V>A withRequestHeaders(Map<String,String> requestHeaders) {
    if (requestHeaders == null) {
      this.requestHeaders = null;
    } else {
      this.requestHeaders = new LinkedHashMap(requestHeaders);
    }
    return (A) this;
  }
  
  public <K,V>A withResponseHeaders(Map<String,String> responseHeaders) {
    if (responseHeaders == null) {
      this.responseHeaders = null;
    } else {
      this.responseHeaders = new LinkedHashMap(responseHeaders);
    }
    return (A) this;
  }
  
  public A withSelector(PodSelectorSpec selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new PodSelectorSpecBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withTarget(String target) {
    this.target = target;
    return (A) this;
  }
  
  public A withTls(PodHttpChaosTLS tls) {
    this._visitables.remove("tls");
    if (tls != null) {
        this.tls = new PodHttpChaosTLSBuilder(tls);
        this._visitables.get("tls").add(this.tls);
    } else {
        this.tls = null;
        this._visitables.get("tls").remove(this.tls);
    }
    return (A) this;
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  public class PatchNested<N> extends PodHttpChaosPatchActionsFluent<PatchNested<N>> implements Nested<N>{
  
    PodHttpChaosPatchActionsBuilder builder;
  
    PatchNested(PodHttpChaosPatchActions item) {
      this.builder = new PodHttpChaosPatchActionsBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPChaosSpecFluent.this.withPatch(builder.build());
    }
    
    public N endPatch() {
      return and();
    }
    
  }
  public class ReplaceNested<N> extends PodHttpChaosReplaceActionsFluent<ReplaceNested<N>> implements Nested<N>{
  
    PodHttpChaosReplaceActionsBuilder builder;
  
    ReplaceNested(PodHttpChaosReplaceActions item) {
      this.builder = new PodHttpChaosReplaceActionsBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPChaosSpecFluent.this.withReplace(builder.build());
    }
    
    public N endReplace() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends PodSelectorSpecFluent<SelectorNested<N>> implements Nested<N>{
  
    PodSelectorSpecBuilder builder;
  
    SelectorNested(PodSelectorSpec item) {
      this.builder = new PodSelectorSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPChaosSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class TlsNested<N> extends PodHttpChaosTLSFluent<TlsNested<N>> implements Nested<N>{
  
    PodHttpChaosTLSBuilder builder;
  
    TlsNested(PodHttpChaosTLS item) {
      this.builder = new PodHttpChaosTLSBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPChaosSpecFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
}