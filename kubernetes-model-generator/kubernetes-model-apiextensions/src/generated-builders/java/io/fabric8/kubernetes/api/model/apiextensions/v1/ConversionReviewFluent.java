package io.fabric8.kubernetes.api.model.apiextensions.v1;

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
public class ConversionReviewFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1.ConversionReviewFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private ConversionRequestBuilder request;
  private ConversionResponseBuilder response;

  public ConversionReviewFluent() {
  }
  
  public ConversionReviewFluent(ConversionReview instance) {
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
  
  public ConversionRequest buildRequest() {
    return this.request != null ? this.request.build() : null;
  }
  
  public ConversionResponse buildResponse() {
    return this.response != null ? this.response.build() : null;
  }
  
  protected void copyInstance(ConversionReview instance) {
    instance = instance != null ? instance : new ConversionReview();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withRequest(instance.getRequest());
        this.withResponse(instance.getResponse());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RequestNested<A> editOrNewRequest() {
    return this.withNewRequestLike(Optional.ofNullable(this.buildRequest()).orElse(new ConversionRequestBuilder().build()));
  }
  
  public RequestNested<A> editOrNewRequestLike(ConversionRequest item) {
    return this.withNewRequestLike(Optional.ofNullable(this.buildRequest()).orElse(item));
  }
  
  public ResponseNested<A> editOrNewResponse() {
    return this.withNewResponseLike(Optional.ofNullable(this.buildResponse()).orElse(new ConversionResponseBuilder().build()));
  }
  
  public ResponseNested<A> editOrNewResponseLike(ConversionResponse item) {
    return this.withNewResponseLike(Optional.ofNullable(this.buildResponse()).orElse(item));
  }
  
  public RequestNested<A> editRequest() {
    return this.withNewRequestLike(Optional.ofNullable(this.buildRequest()).orElse(null));
  }
  
  public ResponseNested<A> editResponse() {
    return this.withNewResponseLike(Optional.ofNullable(this.buildResponse()).orElse(null));
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
    ConversionReviewFluent that = (ConversionReviewFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(request, that.request))) {
      return false;
    }
    if (!(Objects.equals(response, that.response))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasRequest() {
    return this.request != null;
  }
  
  public boolean hasResponse() {
    return this.response != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, request, response, additionalProperties);
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
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(request == null)) {
        sb.append("request:");
        sb.append(request);
        sb.append(",");
    }
    if (!(response == null)) {
        sb.append("response:");
        sb.append(response);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public RequestNested<A> withNewRequest() {
    return new RequestNested(null);
  }
  
  public RequestNested<A> withNewRequestLike(ConversionRequest item) {
    return new RequestNested(item);
  }
  
  public ResponseNested<A> withNewResponse() {
    return new ResponseNested(null);
  }
  
  public ResponseNested<A> withNewResponseLike(ConversionResponse item) {
    return new ResponseNested(item);
  }
  
  public A withRequest(ConversionRequest request) {
    this._visitables.remove("request");
    if (request != null) {
        this.request = new ConversionRequestBuilder(request);
        this._visitables.get("request").add(this.request);
    } else {
        this.request = null;
        this._visitables.get("request").remove(this.request);
    }
    return (A) this;
  }
  
  public A withResponse(ConversionResponse response) {
    this._visitables.remove("response");
    if (response != null) {
        this.response = new ConversionResponseBuilder(response);
        this._visitables.get("response").add(this.response);
    } else {
        this.response = null;
        this._visitables.get("response").remove(this.response);
    }
    return (A) this;
  }
  public class RequestNested<N> extends ConversionRequestFluent<RequestNested<N>> implements Nested<N>{
  
    ConversionRequestBuilder builder;
  
    RequestNested(ConversionRequest item) {
      this.builder = new ConversionRequestBuilder(this, item);
    }
  
    public N and() {
      return (N) ConversionReviewFluent.this.withRequest(builder.build());
    }
    
    public N endRequest() {
      return and();
    }
    
  }
  public class ResponseNested<N> extends ConversionResponseFluent<ResponseNested<N>> implements Nested<N>{
  
    ConversionResponseBuilder builder;
  
    ResponseNested(ConversionResponse item) {
      this.builder = new ConversionResponseBuilder(this, item);
    }
  
    public N and() {
      return (N) ConversionReviewFluent.this.withResponse(builder.build());
    }
    
    public N endResponse() {
      return and();
    }
    
  }
}