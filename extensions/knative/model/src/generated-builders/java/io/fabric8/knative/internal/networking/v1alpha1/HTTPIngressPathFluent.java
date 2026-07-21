package io.fabric8.knative.internal.networking.v1alpha1;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HTTPIngressPathFluent<A extends io.fabric8.knative.internal.networking.v1alpha1.HTTPIngressPathFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> appendHeaders;
  private Map<String,HeaderMatch> headers;
  private String path;
  private String rewriteHost;
  private ArrayList<IngressBackendSplitBuilder> splits = new ArrayList<IngressBackendSplitBuilder>();

  public HTTPIngressPathFluent() {
  }
  
  public HTTPIngressPathFluent(HTTPIngressPath instance) {
    this.copyInstance(instance);
  }

  public A addAllToSplits(Collection<IngressBackendSplit> items) {
    if (this.splits == null) {
      this.splits = new ArrayList();
    }
    for (IngressBackendSplit item : items) {
        IngressBackendSplitBuilder builder = new IngressBackendSplitBuilder(item);
        _visitables.get("splits").add(builder);
        this.splits.add(builder);
    }
    return (A) this;
  }
  
  public SplitsNested<A> addNewSplit() {
    return new SplitsNested(-1, null);
  }
  
  public SplitsNested<A> addNewSplitLike(IngressBackendSplit item) {
    return new SplitsNested(-1, item);
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
  
  public A addToAppendHeaders(Map<String,String> map) {
    if (this.appendHeaders == null && map != null) {
      this.appendHeaders = new LinkedHashMap();
    }
    if (map != null) {
      this.appendHeaders.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAppendHeaders(String key,String value) {
    if (this.appendHeaders == null && key != null && value != null) {
      this.appendHeaders = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.appendHeaders.put(key, value);
    }
    return (A) this;
  }
  
  public A addToHeaders(Map<String,HeaderMatch> map) {
    if (this.headers == null && map != null) {
      this.headers = new LinkedHashMap();
    }
    if (map != null) {
      this.headers.putAll(map);
    }
    return (A) this;
  }
  
  public A addToHeaders(String key,HeaderMatch value) {
    if (this.headers == null && key != null && value != null) {
      this.headers = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.headers.put(key, value);
    }
    return (A) this;
  }
  
  public A addToSplits(IngressBackendSplit... items) {
    if (this.splits == null) {
      this.splits = new ArrayList();
    }
    for (IngressBackendSplit item : items) {
        IngressBackendSplitBuilder builder = new IngressBackendSplitBuilder(item);
        _visitables.get("splits").add(builder);
        this.splits.add(builder);
    }
    return (A) this;
  }
  
  public A addToSplits(int index,IngressBackendSplit item) {
    if (this.splits == null) {
      this.splits = new ArrayList();
    }
    IngressBackendSplitBuilder builder = new IngressBackendSplitBuilder(item);
    if (index < 0 || index >= splits.size()) {
        _visitables.get("splits").add(builder);
        splits.add(builder);
    } else {
        _visitables.get("splits").add(builder);
        splits.add(index, builder);
    }
    return (A) this;
  }
  
  public IngressBackendSplit buildFirstSplit() {
    return this.splits.get(0).build();
  }
  
  public IngressBackendSplit buildLastSplit() {
    return this.splits.get(splits.size() - 1).build();
  }
  
  public IngressBackendSplit buildMatchingSplit(Predicate<IngressBackendSplitBuilder> predicate) {
      for (IngressBackendSplitBuilder item : splits) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IngressBackendSplit buildSplit(int index) {
    return this.splits.get(index).build();
  }
  
  public List<IngressBackendSplit> buildSplits() {
    return this.splits != null ? build(splits) : null;
  }
  
  protected void copyInstance(HTTPIngressPath instance) {
    instance = instance != null ? instance : new HTTPIngressPath();
    if (instance != null) {
        this.withAppendHeaders(instance.getAppendHeaders());
        this.withHeaders(instance.getHeaders());
        this.withPath(instance.getPath());
        this.withRewriteHost(instance.getRewriteHost());
        this.withSplits(instance.getSplits());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SplitsNested<A> editFirstSplit() {
    if (splits.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "splits"));
    }
    return this.setNewSplitLike(0, this.buildSplit(0));
  }
  
  public SplitsNested<A> editLastSplit() {
    int index = splits.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "splits"));
    }
    return this.setNewSplitLike(index, this.buildSplit(index));
  }
  
  public SplitsNested<A> editMatchingSplit(Predicate<IngressBackendSplitBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < splits.size();i++) {
      if (predicate.test(splits.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "splits"));
    }
    return this.setNewSplitLike(index, this.buildSplit(index));
  }
  
  public SplitsNested<A> editSplit(int index) {
    if (splits.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "splits"));
    }
    return this.setNewSplitLike(index, this.buildSplit(index));
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
    HTTPIngressPathFluent that = (HTTPIngressPathFluent) o;
    if (!(Objects.equals(appendHeaders, that.appendHeaders))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(rewriteHost, that.rewriteHost))) {
      return false;
    }
    if (!(Objects.equals(splits, that.splits))) {
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
  
  public Map<String,String> getAppendHeaders() {
    return this.appendHeaders;
  }
  
  public Map<String,HeaderMatch> getHeaders() {
    return this.headers;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public String getRewriteHost() {
    return this.rewriteHost;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAppendHeaders() {
    return this.appendHeaders != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null;
  }
  
  public boolean hasMatchingSplit(Predicate<IngressBackendSplitBuilder> predicate) {
      for (IngressBackendSplitBuilder item : splits) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasRewriteHost() {
    return this.rewriteHost != null;
  }
  
  public boolean hasSplits() {
    return this.splits != null && !(this.splits.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(appendHeaders, headers, path, rewriteHost, splits, additionalProperties);
  }
  
  public A removeAllFromSplits(Collection<IngressBackendSplit> items) {
    if (this.splits == null) {
      return (A) this;
    }
    for (IngressBackendSplit item : items) {
        IngressBackendSplitBuilder builder = new IngressBackendSplitBuilder(item);
        _visitables.get("splits").remove(builder);
        this.splits.remove(builder);
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
  
  public A removeFromAppendHeaders(String key) {
    if (this.appendHeaders == null) {
      return (A) this;
    }
    if (key != null && this.appendHeaders != null) {
      this.appendHeaders.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAppendHeaders(Map<String,String> map) {
    if (this.appendHeaders == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.appendHeaders != null) {
          this.appendHeaders.remove(key);
        }
      }
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
  
  public A removeFromHeaders(Map<String,HeaderMatch> map) {
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
  
  public A removeFromSplits(IngressBackendSplit... items) {
    if (this.splits == null) {
      return (A) this;
    }
    for (IngressBackendSplit item : items) {
        IngressBackendSplitBuilder builder = new IngressBackendSplitBuilder(item);
        _visitables.get("splits").remove(builder);
        this.splits.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSplits(Predicate<IngressBackendSplitBuilder> predicate) {
    if (splits == null) {
      return (A) this;
    }
    Iterator<IngressBackendSplitBuilder> each = splits.iterator();
    List visitables = _visitables.get("splits");
    while (each.hasNext()) {
        IngressBackendSplitBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SplitsNested<A> setNewSplitLike(int index,IngressBackendSplit item) {
    return new SplitsNested(index, item);
  }
  
  public A setToSplits(int index,IngressBackendSplit item) {
    if (this.splits == null) {
      this.splits = new ArrayList();
    }
    IngressBackendSplitBuilder builder = new IngressBackendSplitBuilder(item);
    if (index < 0 || index >= splits.size()) {
        _visitables.get("splits").add(builder);
        splits.add(builder);
    } else {
        _visitables.get("splits").add(builder);
        splits.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(appendHeaders == null) && !(appendHeaders.isEmpty())) {
        sb.append("appendHeaders:");
        sb.append(appendHeaders);
        sb.append(",");
    }
    if (!(headers == null) && !(headers.isEmpty())) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(rewriteHost == null)) {
        sb.append("rewriteHost:");
        sb.append(rewriteHost);
        sb.append(",");
    }
    if (!(splits == null) && !(splits.isEmpty())) {
        sb.append("splits:");
        sb.append(splits);
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
  
  public <K,V>A withAppendHeaders(Map<String,String> appendHeaders) {
    if (appendHeaders == null) {
      this.appendHeaders = null;
    } else {
      this.appendHeaders = new LinkedHashMap(appendHeaders);
    }
    return (A) this;
  }
  
  public <K,V>A withHeaders(Map<String,HeaderMatch> headers) {
    if (headers == null) {
      this.headers = null;
    } else {
      this.headers = new LinkedHashMap(headers);
    }
    return (A) this;
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withRewriteHost(String rewriteHost) {
    this.rewriteHost = rewriteHost;
    return (A) this;
  }
  
  public A withSplits(List<IngressBackendSplit> splits) {
    if (this.splits != null) {
      this._visitables.get("splits").clear();
    }
    if (splits != null) {
        this.splits = new ArrayList();
        for (IngressBackendSplit item : splits) {
          this.addToSplits(item);
        }
    } else {
      this.splits = null;
    }
    return (A) this;
  }
  
  public A withSplits(IngressBackendSplit... splits) {
    if (this.splits != null) {
        this.splits.clear();
        _visitables.remove("splits");
    }
    if (splits != null) {
      for (IngressBackendSplit item : splits) {
        this.addToSplits(item);
      }
    }
    return (A) this;
  }
  public class SplitsNested<N> extends IngressBackendSplitFluent<SplitsNested<N>> implements Nested<N>{
  
    IngressBackendSplitBuilder builder;
    int index;
  
    SplitsNested(int index,IngressBackendSplit item) {
      this.index = index;
      this.builder = new IngressBackendSplitBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPIngressPathFluent.this.setToSplits(index, builder.build());
    }
    
    public N endSplit() {
      return and();
    }
    
  }
}