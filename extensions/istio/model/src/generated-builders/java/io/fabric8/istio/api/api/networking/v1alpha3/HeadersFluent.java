package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class HeadersFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HeadersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HeadersHeaderOperationsBuilder request;
  private HeadersHeaderOperationsBuilder response;

  public HeadersFluent() {
  }
  
  public HeadersFluent(Headers instance) {
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
  
  public HeadersHeaderOperations buildRequest() {
    return this.request != null ? this.request.build() : null;
  }
  
  public HeadersHeaderOperations buildResponse() {
    return this.response != null ? this.response.build() : null;
  }
  
  protected void copyInstance(Headers instance) {
    instance = instance != null ? instance : new Headers();
    if (instance != null) {
        this.withRequest(instance.getRequest());
        this.withResponse(instance.getResponse());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RequestNested<A> editOrNewRequest() {
    return this.withNewRequestLike(Optional.ofNullable(this.buildRequest()).orElse(new HeadersHeaderOperationsBuilder().build()));
  }
  
  public RequestNested<A> editOrNewRequestLike(HeadersHeaderOperations item) {
    return this.withNewRequestLike(Optional.ofNullable(this.buildRequest()).orElse(item));
  }
  
  public ResponseNested<A> editOrNewResponse() {
    return this.withNewResponseLike(Optional.ofNullable(this.buildResponse()).orElse(new HeadersHeaderOperationsBuilder().build()));
  }
  
  public ResponseNested<A> editOrNewResponseLike(HeadersHeaderOperations item) {
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
    HeadersFluent that = (HeadersFluent) o;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRequest() {
    return this.request != null;
  }
  
  public boolean hasResponse() {
    return this.response != null;
  }
  
  public int hashCode() {
    return Objects.hash(request, response, additionalProperties);
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
  
  public RequestNested<A> withNewRequest() {
    return new RequestNested(null);
  }
  
  public RequestNested<A> withNewRequestLike(HeadersHeaderOperations item) {
    return new RequestNested(item);
  }
  
  public ResponseNested<A> withNewResponse() {
    return new ResponseNested(null);
  }
  
  public ResponseNested<A> withNewResponseLike(HeadersHeaderOperations item) {
    return new ResponseNested(item);
  }
  
  public A withRequest(HeadersHeaderOperations request) {
    this._visitables.remove("request");
    if (request != null) {
        this.request = new HeadersHeaderOperationsBuilder(request);
        this._visitables.get("request").add(this.request);
    } else {
        this.request = null;
        this._visitables.get("request").remove(this.request);
    }
    return (A) this;
  }
  
  public A withResponse(HeadersHeaderOperations response) {
    this._visitables.remove("response");
    if (response != null) {
        this.response = new HeadersHeaderOperationsBuilder(response);
        this._visitables.get("response").add(this.response);
    } else {
        this.response = null;
        this._visitables.get("response").remove(this.response);
    }
    return (A) this;
  }
  public class RequestNested<N> extends HeadersHeaderOperationsFluent<RequestNested<N>> implements Nested<N>{
  
    HeadersHeaderOperationsBuilder builder;
  
    RequestNested(HeadersHeaderOperations item) {
      this.builder = new HeadersHeaderOperationsBuilder(this, item);
    }
  
    public N and() {
      return (N) HeadersFluent.this.withRequest(builder.build());
    }
    
    public N endRequest() {
      return and();
    }
    
  }
  public class ResponseNested<N> extends HeadersHeaderOperationsFluent<ResponseNested<N>> implements Nested<N>{
  
    HeadersHeaderOperationsBuilder builder;
  
    ResponseNested(HeadersHeaderOperations item) {
      this.builder = new HeadersHeaderOperationsBuilder(this, item);
    }
  
    public N and() {
      return (N) HeadersFluent.this.withResponse(builder.build());
    }
    
    public N endResponse() {
      return and();
    }
    
  }
}