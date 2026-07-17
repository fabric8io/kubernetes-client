package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class IngressControllerCaptureHTTPHeadersFluent<A extends io.fabric8.openshift.api.model.operator.v1.IngressControllerCaptureHTTPHeadersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<IngressControllerCaptureHTTPHeaderBuilder> request = new ArrayList<IngressControllerCaptureHTTPHeaderBuilder>();
  private ArrayList<IngressControllerCaptureHTTPHeaderBuilder> response = new ArrayList<IngressControllerCaptureHTTPHeaderBuilder>();

  public IngressControllerCaptureHTTPHeadersFluent() {
  }
  
  public IngressControllerCaptureHTTPHeadersFluent(IngressControllerCaptureHTTPHeaders instance) {
    this.copyInstance(instance);
  }

  public A addAllToRequest(Collection<IngressControllerCaptureHTTPHeader> items) {
    if (this.request == null) {
      this.request = new ArrayList();
    }
    for (IngressControllerCaptureHTTPHeader item : items) {
        IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
        _visitables.get("request").add(builder);
        this.request.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResponse(Collection<IngressControllerCaptureHTTPHeader> items) {
    if (this.response == null) {
      this.response = new ArrayList();
    }
    for (IngressControllerCaptureHTTPHeader item : items) {
        IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
        _visitables.get("response").add(builder);
        this.response.add(builder);
    }
    return (A) this;
  }
  
  public RequestNested<A> addNewRequest() {
    return new RequestNested(-1, null);
  }
  
  public A addNewRequest(Integer maxLength,String name) {
    return (A) this.addToRequest(new IngressControllerCaptureHTTPHeader(maxLength, name));
  }
  
  public RequestNested<A> addNewRequestLike(IngressControllerCaptureHTTPHeader item) {
    return new RequestNested(-1, item);
  }
  
  public ResponseNested<A> addNewResponse() {
    return new ResponseNested(-1, null);
  }
  
  public A addNewResponse(Integer maxLength,String name) {
    return (A) this.addToResponse(new IngressControllerCaptureHTTPHeader(maxLength, name));
  }
  
  public ResponseNested<A> addNewResponseLike(IngressControllerCaptureHTTPHeader item) {
    return new ResponseNested(-1, item);
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
  
  public A addToRequest(IngressControllerCaptureHTTPHeader... items) {
    if (this.request == null) {
      this.request = new ArrayList();
    }
    for (IngressControllerCaptureHTTPHeader item : items) {
        IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
        _visitables.get("request").add(builder);
        this.request.add(builder);
    }
    return (A) this;
  }
  
  public A addToRequest(int index,IngressControllerCaptureHTTPHeader item) {
    if (this.request == null) {
      this.request = new ArrayList();
    }
    IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
    if (index < 0 || index >= request.size()) {
        _visitables.get("request").add(builder);
        request.add(builder);
    } else {
        _visitables.get("request").add(builder);
        request.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResponse(IngressControllerCaptureHTTPHeader... items) {
    if (this.response == null) {
      this.response = new ArrayList();
    }
    for (IngressControllerCaptureHTTPHeader item : items) {
        IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
        _visitables.get("response").add(builder);
        this.response.add(builder);
    }
    return (A) this;
  }
  
  public A addToResponse(int index,IngressControllerCaptureHTTPHeader item) {
    if (this.response == null) {
      this.response = new ArrayList();
    }
    IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
    if (index < 0 || index >= response.size()) {
        _visitables.get("response").add(builder);
        response.add(builder);
    } else {
        _visitables.get("response").add(builder);
        response.add(index, builder);
    }
    return (A) this;
  }
  
  public IngressControllerCaptureHTTPHeader buildFirstRequest() {
    return this.request.get(0).build();
  }
  
  public IngressControllerCaptureHTTPHeader buildFirstResponse() {
    return this.response.get(0).build();
  }
  
  public IngressControllerCaptureHTTPHeader buildLastRequest() {
    return this.request.get(request.size() - 1).build();
  }
  
  public IngressControllerCaptureHTTPHeader buildLastResponse() {
    return this.response.get(response.size() - 1).build();
  }
  
  public IngressControllerCaptureHTTPHeader buildMatchingRequest(Predicate<IngressControllerCaptureHTTPHeaderBuilder> predicate) {
      for (IngressControllerCaptureHTTPHeaderBuilder item : request) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IngressControllerCaptureHTTPHeader buildMatchingResponse(Predicate<IngressControllerCaptureHTTPHeaderBuilder> predicate) {
      for (IngressControllerCaptureHTTPHeaderBuilder item : response) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<IngressControllerCaptureHTTPHeader> buildRequest() {
    return this.request != null ? build(request) : null;
  }
  
  public IngressControllerCaptureHTTPHeader buildRequest(int index) {
    return this.request.get(index).build();
  }
  
  public List<IngressControllerCaptureHTTPHeader> buildResponse() {
    return this.response != null ? build(response) : null;
  }
  
  public IngressControllerCaptureHTTPHeader buildResponse(int index) {
    return this.response.get(index).build();
  }
  
  protected void copyInstance(IngressControllerCaptureHTTPHeaders instance) {
    instance = instance != null ? instance : new IngressControllerCaptureHTTPHeaders();
    if (instance != null) {
        this.withRequest(instance.getRequest());
        this.withResponse(instance.getResponse());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RequestNested<A> editFirstRequest() {
    if (request.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "request"));
    }
    return this.setNewRequestLike(0, this.buildRequest(0));
  }
  
  public ResponseNested<A> editFirstResponse() {
    if (response.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "response"));
    }
    return this.setNewResponseLike(0, this.buildResponse(0));
  }
  
  public RequestNested<A> editLastRequest() {
    int index = request.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "request"));
    }
    return this.setNewRequestLike(index, this.buildRequest(index));
  }
  
  public ResponseNested<A> editLastResponse() {
    int index = response.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "response"));
    }
    return this.setNewResponseLike(index, this.buildResponse(index));
  }
  
  public RequestNested<A> editMatchingRequest(Predicate<IngressControllerCaptureHTTPHeaderBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < request.size();i++) {
      if (predicate.test(request.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "request"));
    }
    return this.setNewRequestLike(index, this.buildRequest(index));
  }
  
  public ResponseNested<A> editMatchingResponse(Predicate<IngressControllerCaptureHTTPHeaderBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < response.size();i++) {
      if (predicate.test(response.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "response"));
    }
    return this.setNewResponseLike(index, this.buildResponse(index));
  }
  
  public RequestNested<A> editRequest(int index) {
    if (request.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "request"));
    }
    return this.setNewRequestLike(index, this.buildRequest(index));
  }
  
  public ResponseNested<A> editResponse(int index) {
    if (response.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "response"));
    }
    return this.setNewResponseLike(index, this.buildResponse(index));
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
    IngressControllerCaptureHTTPHeadersFluent that = (IngressControllerCaptureHTTPHeadersFluent) o;
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
  
  public boolean hasMatchingRequest(Predicate<IngressControllerCaptureHTTPHeaderBuilder> predicate) {
      for (IngressControllerCaptureHTTPHeaderBuilder item : request) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResponse(Predicate<IngressControllerCaptureHTTPHeaderBuilder> predicate) {
      for (IngressControllerCaptureHTTPHeaderBuilder item : response) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRequest() {
    return this.request != null && !(this.request.isEmpty());
  }
  
  public boolean hasResponse() {
    return this.response != null && !(this.response.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(request, response, additionalProperties);
  }
  
  public A removeAllFromRequest(Collection<IngressControllerCaptureHTTPHeader> items) {
    if (this.request == null) {
      return (A) this;
    }
    for (IngressControllerCaptureHTTPHeader item : items) {
        IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
        _visitables.get("request").remove(builder);
        this.request.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResponse(Collection<IngressControllerCaptureHTTPHeader> items) {
    if (this.response == null) {
      return (A) this;
    }
    for (IngressControllerCaptureHTTPHeader item : items) {
        IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
        _visitables.get("response").remove(builder);
        this.response.remove(builder);
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
  
  public A removeFromRequest(IngressControllerCaptureHTTPHeader... items) {
    if (this.request == null) {
      return (A) this;
    }
    for (IngressControllerCaptureHTTPHeader item : items) {
        IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
        _visitables.get("request").remove(builder);
        this.request.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResponse(IngressControllerCaptureHTTPHeader... items) {
    if (this.response == null) {
      return (A) this;
    }
    for (IngressControllerCaptureHTTPHeader item : items) {
        IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
        _visitables.get("response").remove(builder);
        this.response.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRequest(Predicate<IngressControllerCaptureHTTPHeaderBuilder> predicate) {
    if (request == null) {
      return (A) this;
    }
    Iterator<IngressControllerCaptureHTTPHeaderBuilder> each = request.iterator();
    List visitables = _visitables.get("request");
    while (each.hasNext()) {
        IngressControllerCaptureHTTPHeaderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResponse(Predicate<IngressControllerCaptureHTTPHeaderBuilder> predicate) {
    if (response == null) {
      return (A) this;
    }
    Iterator<IngressControllerCaptureHTTPHeaderBuilder> each = response.iterator();
    List visitables = _visitables.get("response");
    while (each.hasNext()) {
        IngressControllerCaptureHTTPHeaderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RequestNested<A> setNewRequestLike(int index,IngressControllerCaptureHTTPHeader item) {
    return new RequestNested(index, item);
  }
  
  public ResponseNested<A> setNewResponseLike(int index,IngressControllerCaptureHTTPHeader item) {
    return new ResponseNested(index, item);
  }
  
  public A setToRequest(int index,IngressControllerCaptureHTTPHeader item) {
    if (this.request == null) {
      this.request = new ArrayList();
    }
    IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
    if (index < 0 || index >= request.size()) {
        _visitables.get("request").add(builder);
        request.add(builder);
    } else {
        _visitables.get("request").add(builder);
        request.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResponse(int index,IngressControllerCaptureHTTPHeader item) {
    if (this.response == null) {
      this.response = new ArrayList();
    }
    IngressControllerCaptureHTTPHeaderBuilder builder = new IngressControllerCaptureHTTPHeaderBuilder(item);
    if (index < 0 || index >= response.size()) {
        _visitables.get("response").add(builder);
        response.add(builder);
    } else {
        _visitables.get("response").add(builder);
        response.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(request == null) && !(request.isEmpty())) {
        sb.append("request:");
        sb.append(request);
        sb.append(",");
    }
    if (!(response == null) && !(response.isEmpty())) {
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
  
  public A withRequest(List<IngressControllerCaptureHTTPHeader> request) {
    if (this.request != null) {
      this._visitables.get("request").clear();
    }
    if (request != null) {
        this.request = new ArrayList();
        for (IngressControllerCaptureHTTPHeader item : request) {
          this.addToRequest(item);
        }
    } else {
      this.request = null;
    }
    return (A) this;
  }
  
  public A withRequest(IngressControllerCaptureHTTPHeader... request) {
    if (this.request != null) {
        this.request.clear();
        _visitables.remove("request");
    }
    if (request != null) {
      for (IngressControllerCaptureHTTPHeader item : request) {
        this.addToRequest(item);
      }
    }
    return (A) this;
  }
  
  public A withResponse(List<IngressControllerCaptureHTTPHeader> response) {
    if (this.response != null) {
      this._visitables.get("response").clear();
    }
    if (response != null) {
        this.response = new ArrayList();
        for (IngressControllerCaptureHTTPHeader item : response) {
          this.addToResponse(item);
        }
    } else {
      this.response = null;
    }
    return (A) this;
  }
  
  public A withResponse(IngressControllerCaptureHTTPHeader... response) {
    if (this.response != null) {
        this.response.clear();
        _visitables.remove("response");
    }
    if (response != null) {
      for (IngressControllerCaptureHTTPHeader item : response) {
        this.addToResponse(item);
      }
    }
    return (A) this;
  }
  public class RequestNested<N> extends IngressControllerCaptureHTTPHeaderFluent<RequestNested<N>> implements Nested<N>{
  
    IngressControllerCaptureHTTPHeaderBuilder builder;
    int index;
  
    RequestNested(int index,IngressControllerCaptureHTTPHeader item) {
      this.index = index;
      this.builder = new IngressControllerCaptureHTTPHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerCaptureHTTPHeadersFluent.this.setToRequest(index, builder.build());
    }
    
    public N endRequest() {
      return and();
    }
    
  }
  public class ResponseNested<N> extends IngressControllerCaptureHTTPHeaderFluent<ResponseNested<N>> implements Nested<N>{
  
    IngressControllerCaptureHTTPHeaderBuilder builder;
    int index;
  
    ResponseNested(int index,IngressControllerCaptureHTTPHeader item) {
      this.index = index;
      this.builder = new IngressControllerCaptureHTTPHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerCaptureHTTPHeadersFluent.this.setToResponse(index, builder.build());
    }
    
    public N endResponse() {
      return and();
    }
    
  }
}