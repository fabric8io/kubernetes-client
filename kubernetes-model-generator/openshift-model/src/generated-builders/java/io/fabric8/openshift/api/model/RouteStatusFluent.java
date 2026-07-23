package io.fabric8.openshift.api.model;

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
public class RouteStatusFluent<A extends io.fabric8.openshift.api.model.RouteStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RouteIngressBuilder> ingress = new ArrayList<RouteIngressBuilder>();

  public RouteStatusFluent() {
  }
  
  public RouteStatusFluent(RouteStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToIngress(Collection<RouteIngress> items) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    for (RouteIngress item : items) {
        RouteIngressBuilder builder = new RouteIngressBuilder(item);
        _visitables.get("ingress").add(builder);
        this.ingress.add(builder);
    }
    return (A) this;
  }
  
  public IngressNested<A> addNewIngress() {
    return new IngressNested(-1, null);
  }
  
  public IngressNested<A> addNewIngressLike(RouteIngress item) {
    return new IngressNested(-1, item);
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
  
  public A addToIngress(RouteIngress... items) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    for (RouteIngress item : items) {
        RouteIngressBuilder builder = new RouteIngressBuilder(item);
        _visitables.get("ingress").add(builder);
        this.ingress.add(builder);
    }
    return (A) this;
  }
  
  public A addToIngress(int index,RouteIngress item) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    RouteIngressBuilder builder = new RouteIngressBuilder(item);
    if (index < 0 || index >= ingress.size()) {
        _visitables.get("ingress").add(builder);
        ingress.add(builder);
    } else {
        _visitables.get("ingress").add(builder);
        ingress.add(index, builder);
    }
    return (A) this;
  }
  
  public RouteIngress buildFirstIngress() {
    return this.ingress.get(0).build();
  }
  
  public List<RouteIngress> buildIngress() {
    return this.ingress != null ? build(ingress) : null;
  }
  
  public RouteIngress buildIngress(int index) {
    return this.ingress.get(index).build();
  }
  
  public RouteIngress buildLastIngress() {
    return this.ingress.get(ingress.size() - 1).build();
  }
  
  public RouteIngress buildMatchingIngress(Predicate<RouteIngressBuilder> predicate) {
      for (RouteIngressBuilder item : ingress) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(RouteStatus instance) {
    instance = instance != null ? instance : new RouteStatus();
    if (instance != null) {
        this.withIngress(instance.getIngress());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IngressNested<A> editFirstIngress() {
    if (ingress.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ingress"));
    }
    return this.setNewIngressLike(0, this.buildIngress(0));
  }
  
  public IngressNested<A> editIngress(int index) {
    if (ingress.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
  }
  
  public IngressNested<A> editLastIngress() {
    int index = ingress.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
  }
  
  public IngressNested<A> editMatchingIngress(Predicate<RouteIngressBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ingress.size();i++) {
      if (predicate.test(ingress.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
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
    RouteStatusFluent that = (RouteStatusFluent) o;
    if (!(Objects.equals(ingress, that.ingress))) {
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
  
  public boolean hasIngress() {
    return this.ingress != null && !(this.ingress.isEmpty());
  }
  
  public boolean hasMatchingIngress(Predicate<RouteIngressBuilder> predicate) {
      for (RouteIngressBuilder item : ingress) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(ingress, additionalProperties);
  }
  
  public A removeAllFromIngress(Collection<RouteIngress> items) {
    if (this.ingress == null) {
      return (A) this;
    }
    for (RouteIngress item : items) {
        RouteIngressBuilder builder = new RouteIngressBuilder(item);
        _visitables.get("ingress").remove(builder);
        this.ingress.remove(builder);
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
  
  public A removeFromIngress(RouteIngress... items) {
    if (this.ingress == null) {
      return (A) this;
    }
    for (RouteIngress item : items) {
        RouteIngressBuilder builder = new RouteIngressBuilder(item);
        _visitables.get("ingress").remove(builder);
        this.ingress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromIngress(Predicate<RouteIngressBuilder> predicate) {
    if (ingress == null) {
      return (A) this;
    }
    Iterator<RouteIngressBuilder> each = ingress.iterator();
    List visitables = _visitables.get("ingress");
    while (each.hasNext()) {
        RouteIngressBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public IngressNested<A> setNewIngressLike(int index,RouteIngress item) {
    return new IngressNested(index, item);
  }
  
  public A setToIngress(int index,RouteIngress item) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    RouteIngressBuilder builder = new RouteIngressBuilder(item);
    if (index < 0 || index >= ingress.size()) {
        _visitables.get("ingress").add(builder);
        ingress.add(builder);
    } else {
        _visitables.get("ingress").add(builder);
        ingress.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ingress == null) && !(ingress.isEmpty())) {
        sb.append("ingress:");
        sb.append(ingress);
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
  
  public A withIngress(List<RouteIngress> ingress) {
    if (this.ingress != null) {
      this._visitables.get("ingress").clear();
    }
    if (ingress != null) {
        this.ingress = new ArrayList();
        for (RouteIngress item : ingress) {
          this.addToIngress(item);
        }
    } else {
      this.ingress = null;
    }
    return (A) this;
  }
  
  public A withIngress(RouteIngress... ingress) {
    if (this.ingress != null) {
        this.ingress.clear();
        _visitables.remove("ingress");
    }
    if (ingress != null) {
      for (RouteIngress item : ingress) {
        this.addToIngress(item);
      }
    }
    return (A) this;
  }
  public class IngressNested<N> extends RouteIngressFluent<IngressNested<N>> implements Nested<N>{
  
    RouteIngressBuilder builder;
    int index;
  
    IngressNested(int index,RouteIngress item) {
      this.index = index;
      this.builder = new RouteIngressBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteStatusFluent.this.setToIngress(index, builder.build());
    }
    
    public N endIngress() {
      return and();
    }
    
  }
}