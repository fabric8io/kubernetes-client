package io.fabric8.knative.serving.v1;

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
public class RouteSpecFluent<A extends io.fabric8.knative.serving.v1.RouteSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<TrafficTargetBuilder> traffic = new ArrayList<TrafficTargetBuilder>();

  public RouteSpecFluent() {
  }
  
  public RouteSpecFluent(RouteSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTraffic(Collection<TrafficTarget> items) {
    if (this.traffic == null) {
      this.traffic = new ArrayList();
    }
    for (TrafficTarget item : items) {
        TrafficTargetBuilder builder = new TrafficTargetBuilder(item);
        _visitables.get("traffic").add(builder);
        this.traffic.add(builder);
    }
    return (A) this;
  }
  
  public TrafficNested<A> addNewTraffic() {
    return new TrafficNested(-1, null);
  }
  
  public TrafficNested<A> addNewTrafficLike(TrafficTarget item) {
    return new TrafficNested(-1, item);
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
  
  public A addToTraffic(TrafficTarget... items) {
    if (this.traffic == null) {
      this.traffic = new ArrayList();
    }
    for (TrafficTarget item : items) {
        TrafficTargetBuilder builder = new TrafficTargetBuilder(item);
        _visitables.get("traffic").add(builder);
        this.traffic.add(builder);
    }
    return (A) this;
  }
  
  public A addToTraffic(int index,TrafficTarget item) {
    if (this.traffic == null) {
      this.traffic = new ArrayList();
    }
    TrafficTargetBuilder builder = new TrafficTargetBuilder(item);
    if (index < 0 || index >= traffic.size()) {
        _visitables.get("traffic").add(builder);
        traffic.add(builder);
    } else {
        _visitables.get("traffic").add(builder);
        traffic.add(index, builder);
    }
    return (A) this;
  }
  
  public TrafficTarget buildFirstTraffic() {
    return this.traffic.get(0).build();
  }
  
  public TrafficTarget buildLastTraffic() {
    return this.traffic.get(traffic.size() - 1).build();
  }
  
  public TrafficTarget buildMatchingTraffic(Predicate<TrafficTargetBuilder> predicate) {
      for (TrafficTargetBuilder item : traffic) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<TrafficTarget> buildTraffic() {
    return this.traffic != null ? build(traffic) : null;
  }
  
  public TrafficTarget buildTraffic(int index) {
    return this.traffic.get(index).build();
  }
  
  protected void copyInstance(RouteSpec instance) {
    instance = instance != null ? instance : new RouteSpec();
    if (instance != null) {
        this.withTraffic(instance.getTraffic());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TrafficNested<A> editFirstTraffic() {
    if (traffic.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "traffic"));
    }
    return this.setNewTrafficLike(0, this.buildTraffic(0));
  }
  
  public TrafficNested<A> editLastTraffic() {
    int index = traffic.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "traffic"));
    }
    return this.setNewTrafficLike(index, this.buildTraffic(index));
  }
  
  public TrafficNested<A> editMatchingTraffic(Predicate<TrafficTargetBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < traffic.size();i++) {
      if (predicate.test(traffic.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "traffic"));
    }
    return this.setNewTrafficLike(index, this.buildTraffic(index));
  }
  
  public TrafficNested<A> editTraffic(int index) {
    if (traffic.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "traffic"));
    }
    return this.setNewTrafficLike(index, this.buildTraffic(index));
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
    RouteSpecFluent that = (RouteSpecFluent) o;
    if (!(Objects.equals(traffic, that.traffic))) {
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
  
  public boolean hasMatchingTraffic(Predicate<TrafficTargetBuilder> predicate) {
      for (TrafficTargetBuilder item : traffic) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTraffic() {
    return this.traffic != null && !(this.traffic.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(traffic, additionalProperties);
  }
  
  public A removeAllFromTraffic(Collection<TrafficTarget> items) {
    if (this.traffic == null) {
      return (A) this;
    }
    for (TrafficTarget item : items) {
        TrafficTargetBuilder builder = new TrafficTargetBuilder(item);
        _visitables.get("traffic").remove(builder);
        this.traffic.remove(builder);
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
  
  public A removeFromTraffic(TrafficTarget... items) {
    if (this.traffic == null) {
      return (A) this;
    }
    for (TrafficTarget item : items) {
        TrafficTargetBuilder builder = new TrafficTargetBuilder(item);
        _visitables.get("traffic").remove(builder);
        this.traffic.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTraffic(Predicate<TrafficTargetBuilder> predicate) {
    if (traffic == null) {
      return (A) this;
    }
    Iterator<TrafficTargetBuilder> each = traffic.iterator();
    List visitables = _visitables.get("traffic");
    while (each.hasNext()) {
        TrafficTargetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TrafficNested<A> setNewTrafficLike(int index,TrafficTarget item) {
    return new TrafficNested(index, item);
  }
  
  public A setToTraffic(int index,TrafficTarget item) {
    if (this.traffic == null) {
      this.traffic = new ArrayList();
    }
    TrafficTargetBuilder builder = new TrafficTargetBuilder(item);
    if (index < 0 || index >= traffic.size()) {
        _visitables.get("traffic").add(builder);
        traffic.add(builder);
    } else {
        _visitables.get("traffic").add(builder);
        traffic.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(traffic == null) && !(traffic.isEmpty())) {
        sb.append("traffic:");
        sb.append(traffic);
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
  
  public A withTraffic(List<TrafficTarget> traffic) {
    if (this.traffic != null) {
      this._visitables.get("traffic").clear();
    }
    if (traffic != null) {
        this.traffic = new ArrayList();
        for (TrafficTarget item : traffic) {
          this.addToTraffic(item);
        }
    } else {
      this.traffic = null;
    }
    return (A) this;
  }
  
  public A withTraffic(TrafficTarget... traffic) {
    if (this.traffic != null) {
        this.traffic.clear();
        _visitables.remove("traffic");
    }
    if (traffic != null) {
      for (TrafficTarget item : traffic) {
        this.addToTraffic(item);
      }
    }
    return (A) this;
  }
  public class TrafficNested<N> extends TrafficTargetFluent<TrafficNested<N>> implements Nested<N>{
  
    TrafficTargetBuilder builder;
    int index;
  
    TrafficNested(int index,TrafficTarget item) {
      this.index = index;
      this.builder = new TrafficTargetBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteSpecFluent.this.setToTraffic(index, builder.build());
    }
    
    public N endTraffic() {
      return and();
    }
    
  }
}