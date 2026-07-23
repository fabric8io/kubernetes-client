package io.fabric8.openshift.api.model.operator.v1;

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
public class IngressControllerHTTPHeaderActionsFluent<A extends io.fabric8.openshift.api.model.operator.v1.IngressControllerHTTPHeaderActionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<IngressControllerHTTPHeaderBuilder> request = new ArrayList<IngressControllerHTTPHeaderBuilder>();
  private ArrayList<IngressControllerHTTPHeaderBuilder> response = new ArrayList<IngressControllerHTTPHeaderBuilder>();

  public IngressControllerHTTPHeaderActionsFluent() {
  }
  
  public IngressControllerHTTPHeaderActionsFluent(IngressControllerHTTPHeaderActions instance) {
    this.copyInstance(instance);
  }

  public A addAllToRequest(Collection<IngressControllerHTTPHeader> items) {
    if (this.request == null) {
      this.request = new ArrayList();
    }
    for (IngressControllerHTTPHeader item : items) {
        IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
        _visitables.get("request").add(builder);
        this.request.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResponse(Collection<IngressControllerHTTPHeader> items) {
    if (this.response == null) {
      this.response = new ArrayList();
    }
    for (IngressControllerHTTPHeader item : items) {
        IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
        _visitables.get("response").add(builder);
        this.response.add(builder);
    }
    return (A) this;
  }
  
  public RequestNested<A> addNewRequest() {
    return new RequestNested(-1, null);
  }
  
  public RequestNested<A> addNewRequestLike(IngressControllerHTTPHeader item) {
    return new RequestNested(-1, item);
  }
  
  public ResponseNested<A> addNewResponse() {
    return new ResponseNested(-1, null);
  }
  
  public ResponseNested<A> addNewResponseLike(IngressControllerHTTPHeader item) {
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
  
  public A addToRequest(IngressControllerHTTPHeader... items) {
    if (this.request == null) {
      this.request = new ArrayList();
    }
    for (IngressControllerHTTPHeader item : items) {
        IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
        _visitables.get("request").add(builder);
        this.request.add(builder);
    }
    return (A) this;
  }
  
  public A addToRequest(int index,IngressControllerHTTPHeader item) {
    if (this.request == null) {
      this.request = new ArrayList();
    }
    IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
    if (index < 0 || index >= request.size()) {
        _visitables.get("request").add(builder);
        request.add(builder);
    } else {
        _visitables.get("request").add(builder);
        request.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResponse(IngressControllerHTTPHeader... items) {
    if (this.response == null) {
      this.response = new ArrayList();
    }
    for (IngressControllerHTTPHeader item : items) {
        IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
        _visitables.get("response").add(builder);
        this.response.add(builder);
    }
    return (A) this;
  }
  
  public A addToResponse(int index,IngressControllerHTTPHeader item) {
    if (this.response == null) {
      this.response = new ArrayList();
    }
    IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
    if (index < 0 || index >= response.size()) {
        _visitables.get("response").add(builder);
        response.add(builder);
    } else {
        _visitables.get("response").add(builder);
        response.add(index, builder);
    }
    return (A) this;
  }
  
  public IngressControllerHTTPHeader buildFirstRequest() {
    return this.request.get(0).build();
  }
  
  public IngressControllerHTTPHeader buildFirstResponse() {
    return this.response.get(0).build();
  }
  
  public IngressControllerHTTPHeader buildLastRequest() {
    return this.request.get(request.size() - 1).build();
  }
  
  public IngressControllerHTTPHeader buildLastResponse() {
    return this.response.get(response.size() - 1).build();
  }
  
  public IngressControllerHTTPHeader buildMatchingRequest(Predicate<IngressControllerHTTPHeaderBuilder> predicate) {
      for (IngressControllerHTTPHeaderBuilder item : request) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IngressControllerHTTPHeader buildMatchingResponse(Predicate<IngressControllerHTTPHeaderBuilder> predicate) {
      for (IngressControllerHTTPHeaderBuilder item : response) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<IngressControllerHTTPHeader> buildRequest() {
    return this.request != null ? build(request) : null;
  }
  
  public IngressControllerHTTPHeader buildRequest(int index) {
    return this.request.get(index).build();
  }
  
  public List<IngressControllerHTTPHeader> buildResponse() {
    return this.response != null ? build(response) : null;
  }
  
  public IngressControllerHTTPHeader buildResponse(int index) {
    return this.response.get(index).build();
  }
  
  protected void copyInstance(IngressControllerHTTPHeaderActions instance) {
    instance = instance != null ? instance : new IngressControllerHTTPHeaderActions();
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
  
  public RequestNested<A> editMatchingRequest(Predicate<IngressControllerHTTPHeaderBuilder> predicate) {
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
  
  public ResponseNested<A> editMatchingResponse(Predicate<IngressControllerHTTPHeaderBuilder> predicate) {
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
    IngressControllerHTTPHeaderActionsFluent that = (IngressControllerHTTPHeaderActionsFluent) o;
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
  
  public boolean hasMatchingRequest(Predicate<IngressControllerHTTPHeaderBuilder> predicate) {
      for (IngressControllerHTTPHeaderBuilder item : request) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResponse(Predicate<IngressControllerHTTPHeaderBuilder> predicate) {
      for (IngressControllerHTTPHeaderBuilder item : response) {
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
  
  public A removeAllFromRequest(Collection<IngressControllerHTTPHeader> items) {
    if (this.request == null) {
      return (A) this;
    }
    for (IngressControllerHTTPHeader item : items) {
        IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
        _visitables.get("request").remove(builder);
        this.request.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResponse(Collection<IngressControllerHTTPHeader> items) {
    if (this.response == null) {
      return (A) this;
    }
    for (IngressControllerHTTPHeader item : items) {
        IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
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
  
  public A removeFromRequest(IngressControllerHTTPHeader... items) {
    if (this.request == null) {
      return (A) this;
    }
    for (IngressControllerHTTPHeader item : items) {
        IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
        _visitables.get("request").remove(builder);
        this.request.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResponse(IngressControllerHTTPHeader... items) {
    if (this.response == null) {
      return (A) this;
    }
    for (IngressControllerHTTPHeader item : items) {
        IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
        _visitables.get("response").remove(builder);
        this.response.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRequest(Predicate<IngressControllerHTTPHeaderBuilder> predicate) {
    if (request == null) {
      return (A) this;
    }
    Iterator<IngressControllerHTTPHeaderBuilder> each = request.iterator();
    List visitables = _visitables.get("request");
    while (each.hasNext()) {
        IngressControllerHTTPHeaderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResponse(Predicate<IngressControllerHTTPHeaderBuilder> predicate) {
    if (response == null) {
      return (A) this;
    }
    Iterator<IngressControllerHTTPHeaderBuilder> each = response.iterator();
    List visitables = _visitables.get("response");
    while (each.hasNext()) {
        IngressControllerHTTPHeaderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RequestNested<A> setNewRequestLike(int index,IngressControllerHTTPHeader item) {
    return new RequestNested(index, item);
  }
  
  public ResponseNested<A> setNewResponseLike(int index,IngressControllerHTTPHeader item) {
    return new ResponseNested(index, item);
  }
  
  public A setToRequest(int index,IngressControllerHTTPHeader item) {
    if (this.request == null) {
      this.request = new ArrayList();
    }
    IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
    if (index < 0 || index >= request.size()) {
        _visitables.get("request").add(builder);
        request.add(builder);
    } else {
        _visitables.get("request").add(builder);
        request.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResponse(int index,IngressControllerHTTPHeader item) {
    if (this.response == null) {
      this.response = new ArrayList();
    }
    IngressControllerHTTPHeaderBuilder builder = new IngressControllerHTTPHeaderBuilder(item);
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
  
  public A withRequest(List<IngressControllerHTTPHeader> request) {
    if (this.request != null) {
      this._visitables.get("request").clear();
    }
    if (request != null) {
        this.request = new ArrayList();
        for (IngressControllerHTTPHeader item : request) {
          this.addToRequest(item);
        }
    } else {
      this.request = null;
    }
    return (A) this;
  }
  
  public A withRequest(IngressControllerHTTPHeader... request) {
    if (this.request != null) {
        this.request.clear();
        _visitables.remove("request");
    }
    if (request != null) {
      for (IngressControllerHTTPHeader item : request) {
        this.addToRequest(item);
      }
    }
    return (A) this;
  }
  
  public A withResponse(List<IngressControllerHTTPHeader> response) {
    if (this.response != null) {
      this._visitables.get("response").clear();
    }
    if (response != null) {
        this.response = new ArrayList();
        for (IngressControllerHTTPHeader item : response) {
          this.addToResponse(item);
        }
    } else {
      this.response = null;
    }
    return (A) this;
  }
  
  public A withResponse(IngressControllerHTTPHeader... response) {
    if (this.response != null) {
        this.response.clear();
        _visitables.remove("response");
    }
    if (response != null) {
      for (IngressControllerHTTPHeader item : response) {
        this.addToResponse(item);
      }
    }
    return (A) this;
  }
  public class RequestNested<N> extends IngressControllerHTTPHeaderFluent<RequestNested<N>> implements Nested<N>{
  
    IngressControllerHTTPHeaderBuilder builder;
    int index;
  
    RequestNested(int index,IngressControllerHTTPHeader item) {
      this.index = index;
      this.builder = new IngressControllerHTTPHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerHTTPHeaderActionsFluent.this.setToRequest(index, builder.build());
    }
    
    public N endRequest() {
      return and();
    }
    
  }
  public class ResponseNested<N> extends IngressControllerHTTPHeaderFluent<ResponseNested<N>> implements Nested<N>{
  
    IngressControllerHTTPHeaderBuilder builder;
    int index;
  
    ResponseNested(int index,IngressControllerHTTPHeader item) {
      this.index = index;
      this.builder = new IngressControllerHTTPHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerHTTPHeaderActionsFluent.this.setToResponse(index, builder.build());
    }
    
    public N endResponse() {
      return and();
    }
    
  }
}