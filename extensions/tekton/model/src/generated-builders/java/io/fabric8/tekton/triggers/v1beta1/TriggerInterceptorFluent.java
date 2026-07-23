package io.fabric8.tekton.triggers.v1beta1;

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
public class TriggerInterceptorFluent<A extends io.fabric8.tekton.triggers.v1beta1.TriggerInterceptorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private ArrayList<InterceptorParamsBuilder> params = new ArrayList<InterceptorParamsBuilder>();
  private InterceptorRefBuilder ref;
  private WebhookInterceptorBuilder webhook;

  public TriggerInterceptorFluent() {
  }
  
  public TriggerInterceptorFluent(TriggerInterceptor instance) {
    this.copyInstance(instance);
  }

  public A addAllToParams(Collection<InterceptorParams> items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (InterceptorParams item : items) {
        InterceptorParamsBuilder builder = new InterceptorParamsBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public ParamsNested<A> addNewParam() {
    return new ParamsNested(-1, null);
  }
  
  public ParamsNested<A> addNewParamLike(InterceptorParams item) {
    return new ParamsNested(-1, item);
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
  
  public A addToParams(InterceptorParams... items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (InterceptorParams item : items) {
        InterceptorParamsBuilder builder = new InterceptorParamsBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public A addToParams(int index,InterceptorParams item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    InterceptorParamsBuilder builder = new InterceptorParamsBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.add(index, builder);
    }
    return (A) this;
  }
  
  public InterceptorParams buildFirstParam() {
    return this.params.get(0).build();
  }
  
  public InterceptorParams buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public InterceptorParams buildMatchingParam(Predicate<InterceptorParamsBuilder> predicate) {
      for (InterceptorParamsBuilder item : params) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public InterceptorParams buildParam(int index) {
    return this.params.get(index).build();
  }
  
  public List<InterceptorParams> buildParams() {
    return this.params != null ? build(params) : null;
  }
  
  public InterceptorRef buildRef() {
    return this.ref != null ? this.ref.build() : null;
  }
  
  public WebhookInterceptor buildWebhook() {
    return this.webhook != null ? this.webhook.build() : null;
  }
  
  protected void copyInstance(TriggerInterceptor instance) {
    instance = instance != null ? instance : new TriggerInterceptor();
    if (instance != null) {
        this.withName(instance.getName());
        this.withParams(instance.getParams());
        this.withRef(instance.getRef());
        this.withWebhook(instance.getWebhook());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ParamsNested<A> editFirstParam() {
    if (params.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(0, this.buildParam(0));
  }
  
  public ParamsNested<A> editLastParam() {
    int index = params.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public ParamsNested<A> editMatchingParam(Predicate<InterceptorParamsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < params.size();i++) {
      if (predicate.test(params.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public RefNested<A> editOrNewRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(new InterceptorRefBuilder().build()));
  }
  
  public RefNested<A> editOrNewRefLike(InterceptorRef item) {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(item));
  }
  
  public WebhookNested<A> editOrNewWebhook() {
    return this.withNewWebhookLike(Optional.ofNullable(this.buildWebhook()).orElse(new WebhookInterceptorBuilder().build()));
  }
  
  public WebhookNested<A> editOrNewWebhookLike(WebhookInterceptor item) {
    return this.withNewWebhookLike(Optional.ofNullable(this.buildWebhook()).orElse(item));
  }
  
  public ParamsNested<A> editParam(int index) {
    if (params.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public RefNested<A> editRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(null));
  }
  
  public WebhookNested<A> editWebhook() {
    return this.withNewWebhookLike(Optional.ofNullable(this.buildWebhook()).orElse(null));
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
    TriggerInterceptorFluent that = (TriggerInterceptorFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(ref, that.ref))) {
      return false;
    }
    if (!(Objects.equals(webhook, that.webhook))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingParam(Predicate<InterceptorParamsBuilder> predicate) {
      for (InterceptorParamsBuilder item : params) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasParams() {
    return this.params != null && !(this.params.isEmpty());
  }
  
  public boolean hasRef() {
    return this.ref != null;
  }
  
  public boolean hasWebhook() {
    return this.webhook != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, params, ref, webhook, additionalProperties);
  }
  
  public A removeAllFromParams(Collection<InterceptorParams> items) {
    if (this.params == null) {
      return (A) this;
    }
    for (InterceptorParams item : items) {
        InterceptorParamsBuilder builder = new InterceptorParamsBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
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
  
  public A removeFromParams(InterceptorParams... items) {
    if (this.params == null) {
      return (A) this;
    }
    for (InterceptorParams item : items) {
        InterceptorParamsBuilder builder = new InterceptorParamsBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromParams(Predicate<InterceptorParamsBuilder> predicate) {
    if (params == null) {
      return (A) this;
    }
    Iterator<InterceptorParamsBuilder> each = params.iterator();
    List visitables = _visitables.get("params");
    while (each.hasNext()) {
        InterceptorParamsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ParamsNested<A> setNewParamLike(int index,InterceptorParams item) {
    return new ParamsNested(index, item);
  }
  
  public A setToParams(int index,InterceptorParams item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    InterceptorParamsBuilder builder = new InterceptorParamsBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(params == null) && !(params.isEmpty())) {
        sb.append("params:");
        sb.append(params);
        sb.append(",");
    }
    if (!(ref == null)) {
        sb.append("ref:");
        sb.append(ref);
        sb.append(",");
    }
    if (!(webhook == null)) {
        sb.append("webhook:");
        sb.append(webhook);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public RefNested<A> withNewRef() {
    return new RefNested(null);
  }
  
  public A withNewRef(String apiVersion,String kind,String name) {
    return (A) this.withRef(new InterceptorRef(apiVersion, kind, name));
  }
  
  public RefNested<A> withNewRefLike(InterceptorRef item) {
    return new RefNested(item);
  }
  
  public WebhookNested<A> withNewWebhook() {
    return new WebhookNested(null);
  }
  
  public WebhookNested<A> withNewWebhookLike(WebhookInterceptor item) {
    return new WebhookNested(item);
  }
  
  public A withParams(List<InterceptorParams> params) {
    if (this.params != null) {
      this._visitables.get("params").clear();
    }
    if (params != null) {
        this.params = new ArrayList();
        for (InterceptorParams item : params) {
          this.addToParams(item);
        }
    } else {
      this.params = null;
    }
    return (A) this;
  }
  
  public A withParams(InterceptorParams... params) {
    if (this.params != null) {
        this.params.clear();
        _visitables.remove("params");
    }
    if (params != null) {
      for (InterceptorParams item : params) {
        this.addToParams(item);
      }
    }
    return (A) this;
  }
  
  public A withRef(InterceptorRef ref) {
    this._visitables.remove("ref");
    if (ref != null) {
        this.ref = new InterceptorRefBuilder(ref);
        this._visitables.get("ref").add(this.ref);
    } else {
        this.ref = null;
        this._visitables.get("ref").remove(this.ref);
    }
    return (A) this;
  }
  
  public A withWebhook(WebhookInterceptor webhook) {
    this._visitables.remove("webhook");
    if (webhook != null) {
        this.webhook = new WebhookInterceptorBuilder(webhook);
        this._visitables.get("webhook").add(this.webhook);
    } else {
        this.webhook = null;
        this._visitables.get("webhook").remove(this.webhook);
    }
    return (A) this;
  }
  public class ParamsNested<N> extends InterceptorParamsFluent<ParamsNested<N>> implements Nested<N>{
  
    InterceptorParamsBuilder builder;
    int index;
  
    ParamsNested(int index,InterceptorParams item) {
      this.index = index;
      this.builder = new InterceptorParamsBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerInterceptorFluent.this.setToParams(index, builder.build());
    }
    
    public N endParam() {
      return and();
    }
    
  }
  public class RefNested<N> extends InterceptorRefFluent<RefNested<N>> implements Nested<N>{
  
    InterceptorRefBuilder builder;
  
    RefNested(InterceptorRef item) {
      this.builder = new InterceptorRefBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerInterceptorFluent.this.withRef(builder.build());
    }
    
    public N endRef() {
      return and();
    }
    
  }
  public class WebhookNested<N> extends WebhookInterceptorFluent<WebhookNested<N>> implements Nested<N>{
  
    WebhookInterceptorBuilder builder;
  
    WebhookNested(WebhookInterceptor item) {
      this.builder = new WebhookInterceptorBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerInterceptorFluent.this.withWebhook(builder.build());
    }
    
    public N endWebhook() {
      return and();
    }
    
  }
}