package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class InterceptorRequestFluent<A extends io.fabric8.tekton.triggers.v1beta1.InterceptorRequestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String body;
  private TriggerContextBuilder context;
  private Map<String,Object> extensions;
  private Map<String,List<String>> header;
  private Map<String,Object> interceptorParams;

  public InterceptorRequestFluent() {
  }
  
  public InterceptorRequestFluent(InterceptorRequest instance) {
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
  
  public A addToExtensions(Map<String,Object> map) {
    if (this.extensions == null && map != null) {
      this.extensions = new LinkedHashMap();
    }
    if (map != null) {
      this.extensions.putAll(map);
    }
    return (A) this;
  }
  
  public A addToExtensions(String key,Object value) {
    if (this.extensions == null && key != null && value != null) {
      this.extensions = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.extensions.put(key, value);
    }
    return (A) this;
  }
  
  public A addToHeader(Map<String,List<String>> map) {
    if (this.header == null && map != null) {
      this.header = new LinkedHashMap();
    }
    if (map != null) {
      this.header.putAll(map);
    }
    return (A) this;
  }
  
  public A addToHeader(String key,List<String> value) {
    if (this.header == null && key != null && value != null) {
      this.header = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.header.put(key, value);
    }
    return (A) this;
  }
  
  public A addToInterceptorParams(Map<String,Object> map) {
    if (this.interceptorParams == null && map != null) {
      this.interceptorParams = new LinkedHashMap();
    }
    if (map != null) {
      this.interceptorParams.putAll(map);
    }
    return (A) this;
  }
  
  public A addToInterceptorParams(String key,Object value) {
    if (this.interceptorParams == null && key != null && value != null) {
      this.interceptorParams = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.interceptorParams.put(key, value);
    }
    return (A) this;
  }
  
  public TriggerContext buildContext() {
    return this.context != null ? this.context.build() : null;
  }
  
  protected void copyInstance(InterceptorRequest instance) {
    instance = instance != null ? instance : new InterceptorRequest();
    if (instance != null) {
        this.withBody(instance.getBody());
        this.withContext(instance.getContext());
        this.withExtensions(instance.getExtensions());
        this.withHeader(instance.getHeader());
        this.withInterceptorParams(instance.getInterceptorParams());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContextNested<A> editContext() {
    return this.withNewContextLike(Optional.ofNullable(this.buildContext()).orElse(null));
  }
  
  public ContextNested<A> editOrNewContext() {
    return this.withNewContextLike(Optional.ofNullable(this.buildContext()).orElse(new TriggerContextBuilder().build()));
  }
  
  public ContextNested<A> editOrNewContextLike(TriggerContext item) {
    return this.withNewContextLike(Optional.ofNullable(this.buildContext()).orElse(item));
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
    InterceptorRequestFluent that = (InterceptorRequestFluent) o;
    if (!(Objects.equals(body, that.body))) {
      return false;
    }
    if (!(Objects.equals(context, that.context))) {
      return false;
    }
    if (!(Objects.equals(extensions, that.extensions))) {
      return false;
    }
    if (!(Objects.equals(header, that.header))) {
      return false;
    }
    if (!(Objects.equals(interceptorParams, that.interceptorParams))) {
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
  
  public String getBody() {
    return this.body;
  }
  
  public Map<String,Object> getExtensions() {
    return this.extensions;
  }
  
  public Map<String,List<String>> getHeader() {
    return this.header;
  }
  
  public Map<String,Object> getInterceptorParams() {
    return this.interceptorParams;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBody() {
    return this.body != null;
  }
  
  public boolean hasContext() {
    return this.context != null;
  }
  
  public boolean hasExtensions() {
    return this.extensions != null;
  }
  
  public boolean hasHeader() {
    return this.header != null;
  }
  
  public boolean hasInterceptorParams() {
    return this.interceptorParams != null;
  }
  
  public int hashCode() {
    return Objects.hash(body, context, extensions, header, interceptorParams, additionalProperties);
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
  
  public A removeFromExtensions(String key) {
    if (this.extensions == null) {
      return (A) this;
    }
    if (key != null && this.extensions != null) {
      this.extensions.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromExtensions(Map<String,Object> map) {
    if (this.extensions == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.extensions != null) {
          this.extensions.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromHeader(String key) {
    if (this.header == null) {
      return (A) this;
    }
    if (key != null && this.header != null) {
      this.header.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromHeader(Map<String,List<String>> map) {
    if (this.header == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.header != null) {
          this.header.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromInterceptorParams(String key) {
    if (this.interceptorParams == null) {
      return (A) this;
    }
    if (key != null && this.interceptorParams != null) {
      this.interceptorParams.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromInterceptorParams(Map<String,Object> map) {
    if (this.interceptorParams == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.interceptorParams != null) {
          this.interceptorParams.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(body == null)) {
        sb.append("body:");
        sb.append(body);
        sb.append(",");
    }
    if (!(context == null)) {
        sb.append("context:");
        sb.append(context);
        sb.append(",");
    }
    if (!(extensions == null) && !(extensions.isEmpty())) {
        sb.append("extensions:");
        sb.append(extensions);
        sb.append(",");
    }
    if (!(header == null) && !(header.isEmpty())) {
        sb.append("header:");
        sb.append(header);
        sb.append(",");
    }
    if (!(interceptorParams == null) && !(interceptorParams.isEmpty())) {
        sb.append("interceptorParams:");
        sb.append(interceptorParams);
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
  
  public A withBody(String body) {
    this.body = body;
    return (A) this;
  }
  
  public A withContext(TriggerContext context) {
    this._visitables.remove("context");
    if (context != null) {
        this.context = new TriggerContextBuilder(context);
        this._visitables.get("context").add(this.context);
    } else {
        this.context = null;
        this._visitables.get("context").remove(this.context);
    }
    return (A) this;
  }
  
  public <K,V>A withExtensions(Map<String,Object> extensions) {
    if (extensions == null) {
      this.extensions = null;
    } else {
      this.extensions = new LinkedHashMap(extensions);
    }
    return (A) this;
  }
  
  public <K,V>A withHeader(Map<String,List<String>> header) {
    if (header == null) {
      this.header = null;
    } else {
      this.header = new LinkedHashMap(header);
    }
    return (A) this;
  }
  
  public <K,V>A withInterceptorParams(Map<String,Object> interceptorParams) {
    if (interceptorParams == null) {
      this.interceptorParams = null;
    } else {
      this.interceptorParams = new LinkedHashMap(interceptorParams);
    }
    return (A) this;
  }
  
  public ContextNested<A> withNewContext() {
    return new ContextNested(null);
  }
  
  public A withNewContext(String eventId,String eventUrl,String triggerId) {
    return (A) this.withContext(new TriggerContext(eventId, eventUrl, triggerId));
  }
  
  public ContextNested<A> withNewContextLike(TriggerContext item) {
    return new ContextNested(item);
  }
  public class ContextNested<N> extends TriggerContextFluent<ContextNested<N>> implements Nested<N>{
  
    TriggerContextBuilder builder;
  
    ContextNested(TriggerContext item) {
      this.builder = new TriggerContextBuilder(this, item);
    }
  
    public N and() {
      return (N) InterceptorRequestFluent.this.withContext(builder.build());
    }
    
    public N endContext() {
      return and();
    }
    
  }
}