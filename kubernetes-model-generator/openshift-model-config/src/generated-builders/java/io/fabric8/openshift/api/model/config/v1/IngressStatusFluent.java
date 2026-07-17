package io.fabric8.openshift.api.model.config.v1;

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
public class IngressStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.IngressStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ComponentRouteStatusBuilder> componentRoutes = new ArrayList<ComponentRouteStatusBuilder>();
  private String defaultPlacement;

  public IngressStatusFluent() {
  }
  
  public IngressStatusFluent(IngressStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToComponentRoutes(Collection<ComponentRouteStatus> items) {
    if (this.componentRoutes == null) {
      this.componentRoutes = new ArrayList();
    }
    for (ComponentRouteStatus item : items) {
        ComponentRouteStatusBuilder builder = new ComponentRouteStatusBuilder(item);
        _visitables.get("componentRoutes").add(builder);
        this.componentRoutes.add(builder);
    }
    return (A) this;
  }
  
  public ComponentRoutesNested<A> addNewComponentRoute() {
    return new ComponentRoutesNested(-1, null);
  }
  
  public ComponentRoutesNested<A> addNewComponentRouteLike(ComponentRouteStatus item) {
    return new ComponentRoutesNested(-1, item);
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
  
  public A addToComponentRoutes(ComponentRouteStatus... items) {
    if (this.componentRoutes == null) {
      this.componentRoutes = new ArrayList();
    }
    for (ComponentRouteStatus item : items) {
        ComponentRouteStatusBuilder builder = new ComponentRouteStatusBuilder(item);
        _visitables.get("componentRoutes").add(builder);
        this.componentRoutes.add(builder);
    }
    return (A) this;
  }
  
  public A addToComponentRoutes(int index,ComponentRouteStatus item) {
    if (this.componentRoutes == null) {
      this.componentRoutes = new ArrayList();
    }
    ComponentRouteStatusBuilder builder = new ComponentRouteStatusBuilder(item);
    if (index < 0 || index >= componentRoutes.size()) {
        _visitables.get("componentRoutes").add(builder);
        componentRoutes.add(builder);
    } else {
        _visitables.get("componentRoutes").add(builder);
        componentRoutes.add(index, builder);
    }
    return (A) this;
  }
  
  public ComponentRouteStatus buildComponentRoute(int index) {
    return this.componentRoutes.get(index).build();
  }
  
  public List<ComponentRouteStatus> buildComponentRoutes() {
    return this.componentRoutes != null ? build(componentRoutes) : null;
  }
  
  public ComponentRouteStatus buildFirstComponentRoute() {
    return this.componentRoutes.get(0).build();
  }
  
  public ComponentRouteStatus buildLastComponentRoute() {
    return this.componentRoutes.get(componentRoutes.size() - 1).build();
  }
  
  public ComponentRouteStatus buildMatchingComponentRoute(Predicate<ComponentRouteStatusBuilder> predicate) {
      for (ComponentRouteStatusBuilder item : componentRoutes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(IngressStatus instance) {
    instance = instance != null ? instance : new IngressStatus();
    if (instance != null) {
        this.withComponentRoutes(instance.getComponentRoutes());
        this.withDefaultPlacement(instance.getDefaultPlacement());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ComponentRoutesNested<A> editComponentRoute(int index) {
    if (componentRoutes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "componentRoutes"));
    }
    return this.setNewComponentRouteLike(index, this.buildComponentRoute(index));
  }
  
  public ComponentRoutesNested<A> editFirstComponentRoute() {
    if (componentRoutes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "componentRoutes"));
    }
    return this.setNewComponentRouteLike(0, this.buildComponentRoute(0));
  }
  
  public ComponentRoutesNested<A> editLastComponentRoute() {
    int index = componentRoutes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "componentRoutes"));
    }
    return this.setNewComponentRouteLike(index, this.buildComponentRoute(index));
  }
  
  public ComponentRoutesNested<A> editMatchingComponentRoute(Predicate<ComponentRouteStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < componentRoutes.size();i++) {
      if (predicate.test(componentRoutes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "componentRoutes"));
    }
    return this.setNewComponentRouteLike(index, this.buildComponentRoute(index));
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
    IngressStatusFluent that = (IngressStatusFluent) o;
    if (!(Objects.equals(componentRoutes, that.componentRoutes))) {
      return false;
    }
    if (!(Objects.equals(defaultPlacement, that.defaultPlacement))) {
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
  
  public String getDefaultPlacement() {
    return this.defaultPlacement;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComponentRoutes() {
    return this.componentRoutes != null && !(this.componentRoutes.isEmpty());
  }
  
  public boolean hasDefaultPlacement() {
    return this.defaultPlacement != null;
  }
  
  public boolean hasMatchingComponentRoute(Predicate<ComponentRouteStatusBuilder> predicate) {
      for (ComponentRouteStatusBuilder item : componentRoutes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(componentRoutes, defaultPlacement, additionalProperties);
  }
  
  public A removeAllFromComponentRoutes(Collection<ComponentRouteStatus> items) {
    if (this.componentRoutes == null) {
      return (A) this;
    }
    for (ComponentRouteStatus item : items) {
        ComponentRouteStatusBuilder builder = new ComponentRouteStatusBuilder(item);
        _visitables.get("componentRoutes").remove(builder);
        this.componentRoutes.remove(builder);
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
  
  public A removeFromComponentRoutes(ComponentRouteStatus... items) {
    if (this.componentRoutes == null) {
      return (A) this;
    }
    for (ComponentRouteStatus item : items) {
        ComponentRouteStatusBuilder builder = new ComponentRouteStatusBuilder(item);
        _visitables.get("componentRoutes").remove(builder);
        this.componentRoutes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromComponentRoutes(Predicate<ComponentRouteStatusBuilder> predicate) {
    if (componentRoutes == null) {
      return (A) this;
    }
    Iterator<ComponentRouteStatusBuilder> each = componentRoutes.iterator();
    List visitables = _visitables.get("componentRoutes");
    while (each.hasNext()) {
        ComponentRouteStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ComponentRoutesNested<A> setNewComponentRouteLike(int index,ComponentRouteStatus item) {
    return new ComponentRoutesNested(index, item);
  }
  
  public A setToComponentRoutes(int index,ComponentRouteStatus item) {
    if (this.componentRoutes == null) {
      this.componentRoutes = new ArrayList();
    }
    ComponentRouteStatusBuilder builder = new ComponentRouteStatusBuilder(item);
    if (index < 0 || index >= componentRoutes.size()) {
        _visitables.get("componentRoutes").add(builder);
        componentRoutes.add(builder);
    } else {
        _visitables.get("componentRoutes").add(builder);
        componentRoutes.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(componentRoutes == null) && !(componentRoutes.isEmpty())) {
        sb.append("componentRoutes:");
        sb.append(componentRoutes);
        sb.append(",");
    }
    if (!(defaultPlacement == null)) {
        sb.append("defaultPlacement:");
        sb.append(defaultPlacement);
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
  
  public A withComponentRoutes(List<ComponentRouteStatus> componentRoutes) {
    if (this.componentRoutes != null) {
      this._visitables.get("componentRoutes").clear();
    }
    if (componentRoutes != null) {
        this.componentRoutes = new ArrayList();
        for (ComponentRouteStatus item : componentRoutes) {
          this.addToComponentRoutes(item);
        }
    } else {
      this.componentRoutes = null;
    }
    return (A) this;
  }
  
  public A withComponentRoutes(ComponentRouteStatus... componentRoutes) {
    if (this.componentRoutes != null) {
        this.componentRoutes.clear();
        _visitables.remove("componentRoutes");
    }
    if (componentRoutes != null) {
      for (ComponentRouteStatus item : componentRoutes) {
        this.addToComponentRoutes(item);
      }
    }
    return (A) this;
  }
  
  public A withDefaultPlacement(String defaultPlacement) {
    this.defaultPlacement = defaultPlacement;
    return (A) this;
  }
  public class ComponentRoutesNested<N> extends ComponentRouteStatusFluent<ComponentRoutesNested<N>> implements Nested<N>{
  
    ComponentRouteStatusBuilder builder;
    int index;
  
    ComponentRoutesNested(int index,ComponentRouteStatus item) {
      this.index = index;
      this.builder = new ComponentRouteStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressStatusFluent.this.setToComponentRoutes(index, builder.build());
    }
    
    public N endComponentRoute() {
      return and();
    }
    
  }
}