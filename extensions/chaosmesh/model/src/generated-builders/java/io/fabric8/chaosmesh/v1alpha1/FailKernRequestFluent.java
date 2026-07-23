package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Long;
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
public class FailKernRequestFluent<A extends io.fabric8.chaosmesh.v1alpha1.FailKernRequestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<FrameBuilder> callchain = new ArrayList<FrameBuilder>();
  private Integer failtype;
  private List<String> headers = new ArrayList<String>();
  private Long probability;
  private Long times;

  public FailKernRequestFluent() {
  }
  
  public FailKernRequestFluent(FailKernRequest instance) {
    this.copyInstance(instance);
  }

  public A addAllToCallchain(Collection<Frame> items) {
    if (this.callchain == null) {
      this.callchain = new ArrayList();
    }
    for (Frame item : items) {
        FrameBuilder builder = new FrameBuilder(item);
        _visitables.get("callchain").add(builder);
        this.callchain.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToHeaders(Collection<String> items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (String item : items) {
      this.headers.add(item);
    }
    return (A) this;
  }
  
  public CallchainNested<A> addNewCallchain() {
    return new CallchainNested(-1, null);
  }
  
  public A addNewCallchain(String funcname,String parameters,String predicate) {
    return (A) this.addToCallchain(new Frame(funcname, parameters, predicate));
  }
  
  public CallchainNested<A> addNewCallchainLike(Frame item) {
    return new CallchainNested(-1, item);
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
  
  public A addToCallchain(Frame... items) {
    if (this.callchain == null) {
      this.callchain = new ArrayList();
    }
    for (Frame item : items) {
        FrameBuilder builder = new FrameBuilder(item);
        _visitables.get("callchain").add(builder);
        this.callchain.add(builder);
    }
    return (A) this;
  }
  
  public A addToCallchain(int index,Frame item) {
    if (this.callchain == null) {
      this.callchain = new ArrayList();
    }
    FrameBuilder builder = new FrameBuilder(item);
    if (index < 0 || index >= callchain.size()) {
        _visitables.get("callchain").add(builder);
        callchain.add(builder);
    } else {
        _visitables.get("callchain").add(builder);
        callchain.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToHeaders(String... items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (String item : items) {
      this.headers.add(item);
    }
    return (A) this;
  }
  
  public A addToHeaders(int index,String item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    this.headers.add(index, item);
    return (A) this;
  }
  
  public List<Frame> buildCallchain() {
    return this.callchain != null ? build(callchain) : null;
  }
  
  public Frame buildCallchain(int index) {
    return this.callchain.get(index).build();
  }
  
  public Frame buildFirstCallchain() {
    return this.callchain.get(0).build();
  }
  
  public Frame buildLastCallchain() {
    return this.callchain.get(callchain.size() - 1).build();
  }
  
  public Frame buildMatchingCallchain(Predicate<FrameBuilder> predicate) {
      for (FrameBuilder item : callchain) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(FailKernRequest instance) {
    instance = instance != null ? instance : new FailKernRequest();
    if (instance != null) {
        this.withCallchain(instance.getCallchain());
        this.withFailtype(instance.getFailtype());
        this.withHeaders(instance.getHeaders());
        this.withProbability(instance.getProbability());
        this.withTimes(instance.getTimes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CallchainNested<A> editCallchain(int index) {
    if (callchain.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "callchain"));
    }
    return this.setNewCallchainLike(index, this.buildCallchain(index));
  }
  
  public CallchainNested<A> editFirstCallchain() {
    if (callchain.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "callchain"));
    }
    return this.setNewCallchainLike(0, this.buildCallchain(0));
  }
  
  public CallchainNested<A> editLastCallchain() {
    int index = callchain.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "callchain"));
    }
    return this.setNewCallchainLike(index, this.buildCallchain(index));
  }
  
  public CallchainNested<A> editMatchingCallchain(Predicate<FrameBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < callchain.size();i++) {
      if (predicate.test(callchain.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "callchain"));
    }
    return this.setNewCallchainLike(index, this.buildCallchain(index));
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
    FailKernRequestFluent that = (FailKernRequestFluent) o;
    if (!(Objects.equals(callchain, that.callchain))) {
      return false;
    }
    if (!(Objects.equals(failtype, that.failtype))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(probability, that.probability))) {
      return false;
    }
    if (!(Objects.equals(times, that.times))) {
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
  
  public Integer getFailtype() {
    return this.failtype;
  }
  
  public String getFirstHeader() {
    return this.headers.get(0);
  }
  
  public String getHeader(int index) {
    return this.headers.get(index);
  }
  
  public List<String> getHeaders() {
    return this.headers;
  }
  
  public String getLastHeader() {
    return this.headers.get(headers.size() - 1);
  }
  
  public String getMatchingHeader(Predicate<String> predicate) {
      for (String item : headers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getProbability() {
    return this.probability;
  }
  
  public Long getTimes() {
    return this.times;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCallchain() {
    return this.callchain != null && !(this.callchain.isEmpty());
  }
  
  public boolean hasFailtype() {
    return this.failtype != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null && !(this.headers.isEmpty());
  }
  
  public boolean hasMatchingCallchain(Predicate<FrameBuilder> predicate) {
      for (FrameBuilder item : callchain) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHeader(Predicate<String> predicate) {
      for (String item : headers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProbability() {
    return this.probability != null;
  }
  
  public boolean hasTimes() {
    return this.times != null;
  }
  
  public int hashCode() {
    return Objects.hash(callchain, failtype, headers, probability, times, additionalProperties);
  }
  
  public A removeAllFromCallchain(Collection<Frame> items) {
    if (this.callchain == null) {
      return (A) this;
    }
    for (Frame item : items) {
        FrameBuilder builder = new FrameBuilder(item);
        _visitables.get("callchain").remove(builder);
        this.callchain.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromHeaders(Collection<String> items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.headers.remove(item);
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
  
  public A removeFromCallchain(Frame... items) {
    if (this.callchain == null) {
      return (A) this;
    }
    for (Frame item : items) {
        FrameBuilder builder = new FrameBuilder(item);
        _visitables.get("callchain").remove(builder);
        this.callchain.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromHeaders(String... items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.headers.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCallchain(Predicate<FrameBuilder> predicate) {
    if (callchain == null) {
      return (A) this;
    }
    Iterator<FrameBuilder> each = callchain.iterator();
    List visitables = _visitables.get("callchain");
    while (each.hasNext()) {
        FrameBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CallchainNested<A> setNewCallchainLike(int index,Frame item) {
    return new CallchainNested(index, item);
  }
  
  public A setToCallchain(int index,Frame item) {
    if (this.callchain == null) {
      this.callchain = new ArrayList();
    }
    FrameBuilder builder = new FrameBuilder(item);
    if (index < 0 || index >= callchain.size()) {
        _visitables.get("callchain").add(builder);
        callchain.add(builder);
    } else {
        _visitables.get("callchain").add(builder);
        callchain.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToHeaders(int index,String item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    this.headers.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(callchain == null) && !(callchain.isEmpty())) {
        sb.append("callchain:");
        sb.append(callchain);
        sb.append(",");
    }
    if (!(failtype == null)) {
        sb.append("failtype:");
        sb.append(failtype);
        sb.append(",");
    }
    if (!(headers == null) && !(headers.isEmpty())) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(probability == null)) {
        sb.append("probability:");
        sb.append(probability);
        sb.append(",");
    }
    if (!(times == null)) {
        sb.append("times:");
        sb.append(times);
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
  
  public A withCallchain(List<Frame> callchain) {
    if (this.callchain != null) {
      this._visitables.get("callchain").clear();
    }
    if (callchain != null) {
        this.callchain = new ArrayList();
        for (Frame item : callchain) {
          this.addToCallchain(item);
        }
    } else {
      this.callchain = null;
    }
    return (A) this;
  }
  
  public A withCallchain(Frame... callchain) {
    if (this.callchain != null) {
        this.callchain.clear();
        _visitables.remove("callchain");
    }
    if (callchain != null) {
      for (Frame item : callchain) {
        this.addToCallchain(item);
      }
    }
    return (A) this;
  }
  
  public A withFailtype(Integer failtype) {
    this.failtype = failtype;
    return (A) this;
  }
  
  public A withHeaders(List<String> headers) {
    if (headers != null) {
        this.headers = new ArrayList();
        for (String item : headers) {
          this.addToHeaders(item);
        }
    } else {
      this.headers = null;
    }
    return (A) this;
  }
  
  public A withHeaders(String... headers) {
    if (this.headers != null) {
        this.headers.clear();
        _visitables.remove("headers");
    }
    if (headers != null) {
      for (String item : headers) {
        this.addToHeaders(item);
      }
    }
    return (A) this;
  }
  
  public A withProbability(Long probability) {
    this.probability = probability;
    return (A) this;
  }
  
  public A withTimes(Long times) {
    this.times = times;
    return (A) this;
  }
  public class CallchainNested<N> extends FrameFluent<CallchainNested<N>> implements Nested<N>{
  
    FrameBuilder builder;
    int index;
  
    CallchainNested(int index,Frame item) {
      this.index = index;
      this.builder = new FrameBuilder(this, item);
    }
  
    public N and() {
      return (N) FailKernRequestFluent.this.setToCallchain(index, builder.build());
    }
    
    public N endCallchain() {
      return and();
    }
    
  }
}