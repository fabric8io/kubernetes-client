package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import io.fabric8.tekton.v1beta1.Param;
import io.fabric8.tekton.v1beta1.ParamBuilder;
import io.fabric8.tekton.v1beta1.ParamFluent;
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
public class WebhookInterceptorFluent<A extends io.fabric8.tekton.triggers.v1beta1.WebhookInterceptorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ParamBuilder> header = new ArrayList<ParamBuilder>();
  private ObjectReferenceBuilder objectRef;
  private String url;

  public WebhookInterceptorFluent() {
  }
  
  public WebhookInterceptorFluent(WebhookInterceptor instance) {
    this.copyInstance(instance);
  }

  public A addAllToHeader(Collection<Param> items) {
    if (this.header == null) {
      this.header = new ArrayList();
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("header").add(builder);
        this.header.add(builder);
    }
    return (A) this;
  }
  
  public HeaderNested<A> addNewHeader() {
    return new HeaderNested(-1, null);
  }
  
  public HeaderNested<A> addNewHeaderLike(Param item) {
    return new HeaderNested(-1, item);
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
  
  public A addToHeader(Param... items) {
    if (this.header == null) {
      this.header = new ArrayList();
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("header").add(builder);
        this.header.add(builder);
    }
    return (A) this;
  }
  
  public A addToHeader(int index,Param item) {
    if (this.header == null) {
      this.header = new ArrayList();
    }
    ParamBuilder builder = new ParamBuilder(item);
    if (index < 0 || index >= header.size()) {
        _visitables.get("header").add(builder);
        header.add(builder);
    } else {
        _visitables.get("header").add(builder);
        header.add(index, builder);
    }
    return (A) this;
  }
  
  public Param buildFirstHeader() {
    return this.header.get(0).build();
  }
  
  public List<Param> buildHeader() {
    return this.header != null ? build(header) : null;
  }
  
  public Param buildHeader(int index) {
    return this.header.get(index).build();
  }
  
  public Param buildLastHeader() {
    return this.header.get(header.size() - 1).build();
  }
  
  public Param buildMatchingHeader(Predicate<ParamBuilder> predicate) {
      for (ParamBuilder item : header) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectReference buildObjectRef() {
    return this.objectRef != null ? this.objectRef.build() : null;
  }
  
  protected void copyInstance(WebhookInterceptor instance) {
    instance = instance != null ? instance : new WebhookInterceptor();
    if (instance != null) {
        this.withHeader(instance.getHeader());
        this.withObjectRef(instance.getObjectRef());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HeaderNested<A> editFirstHeader() {
    if (header.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "header"));
    }
    return this.setNewHeaderLike(0, this.buildHeader(0));
  }
  
  public HeaderNested<A> editHeader(int index) {
    if (header.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "header"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public HeaderNested<A> editLastHeader() {
    int index = header.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "header"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public HeaderNested<A> editMatchingHeader(Predicate<ParamBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < header.size();i++) {
      if (predicate.test(header.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "header"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public ObjectRefNested<A> editObjectRef() {
    return this.withNewObjectRefLike(Optional.ofNullable(this.buildObjectRef()).orElse(null));
  }
  
  public ObjectRefNested<A> editOrNewObjectRef() {
    return this.withNewObjectRefLike(Optional.ofNullable(this.buildObjectRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ObjectRefNested<A> editOrNewObjectRefLike(ObjectReference item) {
    return this.withNewObjectRefLike(Optional.ofNullable(this.buildObjectRef()).orElse(item));
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
    WebhookInterceptorFluent that = (WebhookInterceptorFluent) o;
    if (!(Objects.equals(header, that.header))) {
      return false;
    }
    if (!(Objects.equals(objectRef, that.objectRef))) {
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
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHeader() {
    return this.header != null && !(this.header.isEmpty());
  }
  
  public boolean hasMatchingHeader(Predicate<ParamBuilder> predicate) {
      for (ParamBuilder item : header) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObjectRef() {
    return this.objectRef != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(header, objectRef, url, additionalProperties);
  }
  
  public A removeAllFromHeader(Collection<Param> items) {
    if (this.header == null) {
      return (A) this;
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("header").remove(builder);
        this.header.remove(builder);
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
  
  public A removeFromHeader(Param... items) {
    if (this.header == null) {
      return (A) this;
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("header").remove(builder);
        this.header.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHeader(Predicate<ParamBuilder> predicate) {
    if (header == null) {
      return (A) this;
    }
    Iterator<ParamBuilder> each = header.iterator();
    List visitables = _visitables.get("header");
    while (each.hasNext()) {
        ParamBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HeaderNested<A> setNewHeaderLike(int index,Param item) {
    return new HeaderNested(index, item);
  }
  
  public A setToHeader(int index,Param item) {
    if (this.header == null) {
      this.header = new ArrayList();
    }
    ParamBuilder builder = new ParamBuilder(item);
    if (index < 0 || index >= header.size()) {
        _visitables.get("header").add(builder);
        header.add(builder);
    } else {
        _visitables.get("header").add(builder);
        header.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(header == null) && !(header.isEmpty())) {
        sb.append("header:");
        sb.append(header);
        sb.append(",");
    }
    if (!(objectRef == null)) {
        sb.append("objectRef:");
        sb.append(objectRef);
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
  
  public A withHeader(List<Param> header) {
    if (this.header != null) {
      this._visitables.get("header").clear();
    }
    if (header != null) {
        this.header = new ArrayList();
        for (Param item : header) {
          this.addToHeader(item);
        }
    } else {
      this.header = null;
    }
    return (A) this;
  }
  
  public A withHeader(Param... header) {
    if (this.header != null) {
        this.header.clear();
        _visitables.remove("header");
    }
    if (header != null) {
      for (Param item : header) {
        this.addToHeader(item);
      }
    }
    return (A) this;
  }
  
  public ObjectRefNested<A> withNewObjectRef() {
    return new ObjectRefNested(null);
  }
  
  public ObjectRefNested<A> withNewObjectRefLike(ObjectReference item) {
    return new ObjectRefNested(item);
  }
  
  public A withObjectRef(ObjectReference objectRef) {
    this._visitables.remove("objectRef");
    if (objectRef != null) {
        this.objectRef = new ObjectReferenceBuilder(objectRef);
        this._visitables.get("objectRef").add(this.objectRef);
    } else {
        this.objectRef = null;
        this._visitables.get("objectRef").remove(this.objectRef);
    }
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class HeaderNested<N> extends ParamFluent<HeaderNested<N>> implements Nested<N>{
  
    ParamBuilder builder;
    int index;
  
    HeaderNested(int index,Param item) {
      this.index = index;
      this.builder = new ParamBuilder(this, item);
    }
  
    public N and() {
      return (N) WebhookInterceptorFluent.this.setToHeader(index, builder.build());
    }
    
    public N endHeader() {
      return and();
    }
    
  }
  public class ObjectRefNested<N> extends ObjectReferenceFluent<ObjectRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ObjectRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) WebhookInterceptorFluent.this.withObjectRef(builder.build());
    }
    
    public N endObjectRef() {
      return and();
    }
    
  }
}