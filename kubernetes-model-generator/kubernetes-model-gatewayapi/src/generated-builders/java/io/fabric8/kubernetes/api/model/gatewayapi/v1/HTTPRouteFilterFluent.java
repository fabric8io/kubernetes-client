package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class HTTPRouteFilterFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRouteFilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HTTPCORSFilterBuilder cors;
  private LocalObjectReferenceBuilder extensionRef;
  private HTTPExternalAuthFilterBuilder externalAuth;
  private HTTPHeaderFilterBuilder requestHeaderModifier;
  private HTTPRequestMirrorFilterBuilder requestMirror;
  private HTTPRequestRedirectFilterBuilder requestRedirect;
  private HTTPHeaderFilterBuilder responseHeaderModifier;
  private String type;
  private HTTPURLRewriteFilterBuilder urlRewrite;

  public HTTPRouteFilterFluent() {
  }
  
  public HTTPRouteFilterFluent(HTTPRouteFilter instance) {
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
  
  public HTTPCORSFilter buildCors() {
    return this.cors != null ? this.cors.build() : null;
  }
  
  public LocalObjectReference buildExtensionRef() {
    return this.extensionRef != null ? this.extensionRef.build() : null;
  }
  
  public HTTPExternalAuthFilter buildExternalAuth() {
    return this.externalAuth != null ? this.externalAuth.build() : null;
  }
  
  public HTTPHeaderFilter buildRequestHeaderModifier() {
    return this.requestHeaderModifier != null ? this.requestHeaderModifier.build() : null;
  }
  
  public HTTPRequestMirrorFilter buildRequestMirror() {
    return this.requestMirror != null ? this.requestMirror.build() : null;
  }
  
  public HTTPRequestRedirectFilter buildRequestRedirect() {
    return this.requestRedirect != null ? this.requestRedirect.build() : null;
  }
  
  public HTTPHeaderFilter buildResponseHeaderModifier() {
    return this.responseHeaderModifier != null ? this.responseHeaderModifier.build() : null;
  }
  
  public HTTPURLRewriteFilter buildUrlRewrite() {
    return this.urlRewrite != null ? this.urlRewrite.build() : null;
  }
  
  protected void copyInstance(HTTPRouteFilter instance) {
    instance = instance != null ? instance : new HTTPRouteFilter();
    if (instance != null) {
        this.withCors(instance.getCors());
        this.withExtensionRef(instance.getExtensionRef());
        this.withExternalAuth(instance.getExternalAuth());
        this.withRequestHeaderModifier(instance.getRequestHeaderModifier());
        this.withRequestMirror(instance.getRequestMirror());
        this.withRequestRedirect(instance.getRequestRedirect());
        this.withResponseHeaderModifier(instance.getResponseHeaderModifier());
        this.withType(instance.getType());
        this.withUrlRewrite(instance.getUrlRewrite());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CorsNested<A> editCors() {
    return this.withNewCorsLike(Optional.ofNullable(this.buildCors()).orElse(null));
  }
  
  public ExtensionRefNested<A> editExtensionRef() {
    return this.withNewExtensionRefLike(Optional.ofNullable(this.buildExtensionRef()).orElse(null));
  }
  
  public ExternalAuthNested<A> editExternalAuth() {
    return this.withNewExternalAuthLike(Optional.ofNullable(this.buildExternalAuth()).orElse(null));
  }
  
  public CorsNested<A> editOrNewCors() {
    return this.withNewCorsLike(Optional.ofNullable(this.buildCors()).orElse(new HTTPCORSFilterBuilder().build()));
  }
  
  public CorsNested<A> editOrNewCorsLike(HTTPCORSFilter item) {
    return this.withNewCorsLike(Optional.ofNullable(this.buildCors()).orElse(item));
  }
  
  public ExtensionRefNested<A> editOrNewExtensionRef() {
    return this.withNewExtensionRefLike(Optional.ofNullable(this.buildExtensionRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ExtensionRefNested<A> editOrNewExtensionRefLike(LocalObjectReference item) {
    return this.withNewExtensionRefLike(Optional.ofNullable(this.buildExtensionRef()).orElse(item));
  }
  
  public ExternalAuthNested<A> editOrNewExternalAuth() {
    return this.withNewExternalAuthLike(Optional.ofNullable(this.buildExternalAuth()).orElse(new HTTPExternalAuthFilterBuilder().build()));
  }
  
  public ExternalAuthNested<A> editOrNewExternalAuthLike(HTTPExternalAuthFilter item) {
    return this.withNewExternalAuthLike(Optional.ofNullable(this.buildExternalAuth()).orElse(item));
  }
  
  public RequestHeaderModifierNested<A> editOrNewRequestHeaderModifier() {
    return this.withNewRequestHeaderModifierLike(Optional.ofNullable(this.buildRequestHeaderModifier()).orElse(new HTTPHeaderFilterBuilder().build()));
  }
  
  public RequestHeaderModifierNested<A> editOrNewRequestHeaderModifierLike(HTTPHeaderFilter item) {
    return this.withNewRequestHeaderModifierLike(Optional.ofNullable(this.buildRequestHeaderModifier()).orElse(item));
  }
  
  public RequestMirrorNested<A> editOrNewRequestMirror() {
    return this.withNewRequestMirrorLike(Optional.ofNullable(this.buildRequestMirror()).orElse(new HTTPRequestMirrorFilterBuilder().build()));
  }
  
  public RequestMirrorNested<A> editOrNewRequestMirrorLike(HTTPRequestMirrorFilter item) {
    return this.withNewRequestMirrorLike(Optional.ofNullable(this.buildRequestMirror()).orElse(item));
  }
  
  public RequestRedirectNested<A> editOrNewRequestRedirect() {
    return this.withNewRequestRedirectLike(Optional.ofNullable(this.buildRequestRedirect()).orElse(new HTTPRequestRedirectFilterBuilder().build()));
  }
  
  public RequestRedirectNested<A> editOrNewRequestRedirectLike(HTTPRequestRedirectFilter item) {
    return this.withNewRequestRedirectLike(Optional.ofNullable(this.buildRequestRedirect()).orElse(item));
  }
  
  public ResponseHeaderModifierNested<A> editOrNewResponseHeaderModifier() {
    return this.withNewResponseHeaderModifierLike(Optional.ofNullable(this.buildResponseHeaderModifier()).orElse(new HTTPHeaderFilterBuilder().build()));
  }
  
  public ResponseHeaderModifierNested<A> editOrNewResponseHeaderModifierLike(HTTPHeaderFilter item) {
    return this.withNewResponseHeaderModifierLike(Optional.ofNullable(this.buildResponseHeaderModifier()).orElse(item));
  }
  
  public UrlRewriteNested<A> editOrNewUrlRewrite() {
    return this.withNewUrlRewriteLike(Optional.ofNullable(this.buildUrlRewrite()).orElse(new HTTPURLRewriteFilterBuilder().build()));
  }
  
  public UrlRewriteNested<A> editOrNewUrlRewriteLike(HTTPURLRewriteFilter item) {
    return this.withNewUrlRewriteLike(Optional.ofNullable(this.buildUrlRewrite()).orElse(item));
  }
  
  public RequestHeaderModifierNested<A> editRequestHeaderModifier() {
    return this.withNewRequestHeaderModifierLike(Optional.ofNullable(this.buildRequestHeaderModifier()).orElse(null));
  }
  
  public RequestMirrorNested<A> editRequestMirror() {
    return this.withNewRequestMirrorLike(Optional.ofNullable(this.buildRequestMirror()).orElse(null));
  }
  
  public RequestRedirectNested<A> editRequestRedirect() {
    return this.withNewRequestRedirectLike(Optional.ofNullable(this.buildRequestRedirect()).orElse(null));
  }
  
  public ResponseHeaderModifierNested<A> editResponseHeaderModifier() {
    return this.withNewResponseHeaderModifierLike(Optional.ofNullable(this.buildResponseHeaderModifier()).orElse(null));
  }
  
  public UrlRewriteNested<A> editUrlRewrite() {
    return this.withNewUrlRewriteLike(Optional.ofNullable(this.buildUrlRewrite()).orElse(null));
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
    HTTPRouteFilterFluent that = (HTTPRouteFilterFluent) o;
    if (!(Objects.equals(cors, that.cors))) {
      return false;
    }
    if (!(Objects.equals(extensionRef, that.extensionRef))) {
      return false;
    }
    if (!(Objects.equals(externalAuth, that.externalAuth))) {
      return false;
    }
    if (!(Objects.equals(requestHeaderModifier, that.requestHeaderModifier))) {
      return false;
    }
    if (!(Objects.equals(requestMirror, that.requestMirror))) {
      return false;
    }
    if (!(Objects.equals(requestRedirect, that.requestRedirect))) {
      return false;
    }
    if (!(Objects.equals(responseHeaderModifier, that.responseHeaderModifier))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(urlRewrite, that.urlRewrite))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCors() {
    return this.cors != null;
  }
  
  public boolean hasExtensionRef() {
    return this.extensionRef != null;
  }
  
  public boolean hasExternalAuth() {
    return this.externalAuth != null;
  }
  
  public boolean hasRequestHeaderModifier() {
    return this.requestHeaderModifier != null;
  }
  
  public boolean hasRequestMirror() {
    return this.requestMirror != null;
  }
  
  public boolean hasRequestRedirect() {
    return this.requestRedirect != null;
  }
  
  public boolean hasResponseHeaderModifier() {
    return this.responseHeaderModifier != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasUrlRewrite() {
    return this.urlRewrite != null;
  }
  
  public int hashCode() {
    return Objects.hash(cors, extensionRef, externalAuth, requestHeaderModifier, requestMirror, requestRedirect, responseHeaderModifier, type, urlRewrite, additionalProperties);
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
    if (!(cors == null)) {
        sb.append("cors:");
        sb.append(cors);
        sb.append(",");
    }
    if (!(extensionRef == null)) {
        sb.append("extensionRef:");
        sb.append(extensionRef);
        sb.append(",");
    }
    if (!(externalAuth == null)) {
        sb.append("externalAuth:");
        sb.append(externalAuth);
        sb.append(",");
    }
    if (!(requestHeaderModifier == null)) {
        sb.append("requestHeaderModifier:");
        sb.append(requestHeaderModifier);
        sb.append(",");
    }
    if (!(requestMirror == null)) {
        sb.append("requestMirror:");
        sb.append(requestMirror);
        sb.append(",");
    }
    if (!(requestRedirect == null)) {
        sb.append("requestRedirect:");
        sb.append(requestRedirect);
        sb.append(",");
    }
    if (!(responseHeaderModifier == null)) {
        sb.append("responseHeaderModifier:");
        sb.append(responseHeaderModifier);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(urlRewrite == null)) {
        sb.append("urlRewrite:");
        sb.append(urlRewrite);
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
  
  public A withCors(HTTPCORSFilter cors) {
    this._visitables.remove("cors");
    if (cors != null) {
        this.cors = new HTTPCORSFilterBuilder(cors);
        this._visitables.get("cors").add(this.cors);
    } else {
        this.cors = null;
        this._visitables.get("cors").remove(this.cors);
    }
    return (A) this;
  }
  
  public A withExtensionRef(LocalObjectReference extensionRef) {
    this._visitables.remove("extensionRef");
    if (extensionRef != null) {
        this.extensionRef = new LocalObjectReferenceBuilder(extensionRef);
        this._visitables.get("extensionRef").add(this.extensionRef);
    } else {
        this.extensionRef = null;
        this._visitables.get("extensionRef").remove(this.extensionRef);
    }
    return (A) this;
  }
  
  public A withExternalAuth(HTTPExternalAuthFilter externalAuth) {
    this._visitables.remove("externalAuth");
    if (externalAuth != null) {
        this.externalAuth = new HTTPExternalAuthFilterBuilder(externalAuth);
        this._visitables.get("externalAuth").add(this.externalAuth);
    } else {
        this.externalAuth = null;
        this._visitables.get("externalAuth").remove(this.externalAuth);
    }
    return (A) this;
  }
  
  public CorsNested<A> withNewCors() {
    return new CorsNested(null);
  }
  
  public CorsNested<A> withNewCorsLike(HTTPCORSFilter item) {
    return new CorsNested(item);
  }
  
  public ExtensionRefNested<A> withNewExtensionRef() {
    return new ExtensionRefNested(null);
  }
  
  public A withNewExtensionRef(String group,String kind,String name) {
    return (A) this.withExtensionRef(new LocalObjectReference(group, kind, name));
  }
  
  public ExtensionRefNested<A> withNewExtensionRefLike(LocalObjectReference item) {
    return new ExtensionRefNested(item);
  }
  
  public ExternalAuthNested<A> withNewExternalAuth() {
    return new ExternalAuthNested(null);
  }
  
  public ExternalAuthNested<A> withNewExternalAuthLike(HTTPExternalAuthFilter item) {
    return new ExternalAuthNested(item);
  }
  
  public RequestHeaderModifierNested<A> withNewRequestHeaderModifier() {
    return new RequestHeaderModifierNested(null);
  }
  
  public RequestHeaderModifierNested<A> withNewRequestHeaderModifierLike(HTTPHeaderFilter item) {
    return new RequestHeaderModifierNested(item);
  }
  
  public RequestMirrorNested<A> withNewRequestMirror() {
    return new RequestMirrorNested(null);
  }
  
  public RequestMirrorNested<A> withNewRequestMirrorLike(HTTPRequestMirrorFilter item) {
    return new RequestMirrorNested(item);
  }
  
  public RequestRedirectNested<A> withNewRequestRedirect() {
    return new RequestRedirectNested(null);
  }
  
  public RequestRedirectNested<A> withNewRequestRedirectLike(HTTPRequestRedirectFilter item) {
    return new RequestRedirectNested(item);
  }
  
  public ResponseHeaderModifierNested<A> withNewResponseHeaderModifier() {
    return new ResponseHeaderModifierNested(null);
  }
  
  public ResponseHeaderModifierNested<A> withNewResponseHeaderModifierLike(HTTPHeaderFilter item) {
    return new ResponseHeaderModifierNested(item);
  }
  
  public UrlRewriteNested<A> withNewUrlRewrite() {
    return new UrlRewriteNested(null);
  }
  
  public UrlRewriteNested<A> withNewUrlRewriteLike(HTTPURLRewriteFilter item) {
    return new UrlRewriteNested(item);
  }
  
  public A withRequestHeaderModifier(HTTPHeaderFilter requestHeaderModifier) {
    this._visitables.remove("requestHeaderModifier");
    if (requestHeaderModifier != null) {
        this.requestHeaderModifier = new HTTPHeaderFilterBuilder(requestHeaderModifier);
        this._visitables.get("requestHeaderModifier").add(this.requestHeaderModifier);
    } else {
        this.requestHeaderModifier = null;
        this._visitables.get("requestHeaderModifier").remove(this.requestHeaderModifier);
    }
    return (A) this;
  }
  
  public A withRequestMirror(HTTPRequestMirrorFilter requestMirror) {
    this._visitables.remove("requestMirror");
    if (requestMirror != null) {
        this.requestMirror = new HTTPRequestMirrorFilterBuilder(requestMirror);
        this._visitables.get("requestMirror").add(this.requestMirror);
    } else {
        this.requestMirror = null;
        this._visitables.get("requestMirror").remove(this.requestMirror);
    }
    return (A) this;
  }
  
  public A withRequestRedirect(HTTPRequestRedirectFilter requestRedirect) {
    this._visitables.remove("requestRedirect");
    if (requestRedirect != null) {
        this.requestRedirect = new HTTPRequestRedirectFilterBuilder(requestRedirect);
        this._visitables.get("requestRedirect").add(this.requestRedirect);
    } else {
        this.requestRedirect = null;
        this._visitables.get("requestRedirect").remove(this.requestRedirect);
    }
    return (A) this;
  }
  
  public A withResponseHeaderModifier(HTTPHeaderFilter responseHeaderModifier) {
    this._visitables.remove("responseHeaderModifier");
    if (responseHeaderModifier != null) {
        this.responseHeaderModifier = new HTTPHeaderFilterBuilder(responseHeaderModifier);
        this._visitables.get("responseHeaderModifier").add(this.responseHeaderModifier);
    } else {
        this.responseHeaderModifier = null;
        this._visitables.get("responseHeaderModifier").remove(this.responseHeaderModifier);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withUrlRewrite(HTTPURLRewriteFilter urlRewrite) {
    this._visitables.remove("urlRewrite");
    if (urlRewrite != null) {
        this.urlRewrite = new HTTPURLRewriteFilterBuilder(urlRewrite);
        this._visitables.get("urlRewrite").add(this.urlRewrite);
    } else {
        this.urlRewrite = null;
        this._visitables.get("urlRewrite").remove(this.urlRewrite);
    }
    return (A) this;
  }
  public class CorsNested<N> extends HTTPCORSFilterFluent<CorsNested<N>> implements Nested<N>{
  
    HTTPCORSFilterBuilder builder;
  
    CorsNested(HTTPCORSFilter item) {
      this.builder = new HTTPCORSFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFilterFluent.this.withCors(builder.build());
    }
    
    public N endCors() {
      return and();
    }
    
  }
  public class ExtensionRefNested<N> extends LocalObjectReferenceFluent<ExtensionRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ExtensionRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFilterFluent.this.withExtensionRef(builder.build());
    }
    
    public N endExtensionRef() {
      return and();
    }
    
  }
  public class ExternalAuthNested<N> extends HTTPExternalAuthFilterFluent<ExternalAuthNested<N>> implements Nested<N>{
  
    HTTPExternalAuthFilterBuilder builder;
  
    ExternalAuthNested(HTTPExternalAuthFilter item) {
      this.builder = new HTTPExternalAuthFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFilterFluent.this.withExternalAuth(builder.build());
    }
    
    public N endExternalAuth() {
      return and();
    }
    
  }
  public class RequestHeaderModifierNested<N> extends HTTPHeaderFilterFluent<RequestHeaderModifierNested<N>> implements Nested<N>{
  
    HTTPHeaderFilterBuilder builder;
  
    RequestHeaderModifierNested(HTTPHeaderFilter item) {
      this.builder = new HTTPHeaderFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFilterFluent.this.withRequestHeaderModifier(builder.build());
    }
    
    public N endRequestHeaderModifier() {
      return and();
    }
    
  }
  public class RequestMirrorNested<N> extends HTTPRequestMirrorFilterFluent<RequestMirrorNested<N>> implements Nested<N>{
  
    HTTPRequestMirrorFilterBuilder builder;
  
    RequestMirrorNested(HTTPRequestMirrorFilter item) {
      this.builder = new HTTPRequestMirrorFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFilterFluent.this.withRequestMirror(builder.build());
    }
    
    public N endRequestMirror() {
      return and();
    }
    
  }
  public class RequestRedirectNested<N> extends HTTPRequestRedirectFilterFluent<RequestRedirectNested<N>> implements Nested<N>{
  
    HTTPRequestRedirectFilterBuilder builder;
  
    RequestRedirectNested(HTTPRequestRedirectFilter item) {
      this.builder = new HTTPRequestRedirectFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFilterFluent.this.withRequestRedirect(builder.build());
    }
    
    public N endRequestRedirect() {
      return and();
    }
    
  }
  public class ResponseHeaderModifierNested<N> extends HTTPHeaderFilterFluent<ResponseHeaderModifierNested<N>> implements Nested<N>{
  
    HTTPHeaderFilterBuilder builder;
  
    ResponseHeaderModifierNested(HTTPHeaderFilter item) {
      this.builder = new HTTPHeaderFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFilterFluent.this.withResponseHeaderModifier(builder.build());
    }
    
    public N endResponseHeaderModifier() {
      return and();
    }
    
  }
  public class UrlRewriteNested<N> extends HTTPURLRewriteFilterFluent<UrlRewriteNested<N>> implements Nested<N>{
  
    HTTPURLRewriteFilterBuilder builder;
  
    UrlRewriteNested(HTTPURLRewriteFilter item) {
      this.builder = new HTTPURLRewriteFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFilterFluent.this.withUrlRewrite(builder.build());
    }
    
    public N endUrlRewrite() {
      return and();
    }
    
  }
}