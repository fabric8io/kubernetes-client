package io.fabric8.openshift.api.model.hive.v1;

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
public class ControllersConfigFluent<A extends io.fabric8.openshift.api.model.hive.v1.ControllersConfigFluent<A>> extends BaseFluent<A>{

  private ControllerConfigBuilder _default;
  private Map<String,Object> additionalProperties;
  private ArrayList<SpecificControllerConfigBuilder> controllers = new ArrayList<SpecificControllerConfigBuilder>();

  public ControllersConfigFluent() {
  }
  
  public ControllersConfigFluent(ControllersConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToControllers(Collection<SpecificControllerConfig> items) {
    if (this.controllers == null) {
      this.controllers = new ArrayList();
    }
    for (SpecificControllerConfig item : items) {
        SpecificControllerConfigBuilder builder = new SpecificControllerConfigBuilder(item);
        _visitables.get("controllers").add(builder);
        this.controllers.add(builder);
    }
    return (A) this;
  }
  
  public ControllersNested<A> addNewController() {
    return new ControllersNested(-1, null);
  }
  
  public ControllersNested<A> addNewControllerLike(SpecificControllerConfig item) {
    return new ControllersNested(-1, item);
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
  
  public A addToControllers(SpecificControllerConfig... items) {
    if (this.controllers == null) {
      this.controllers = new ArrayList();
    }
    for (SpecificControllerConfig item : items) {
        SpecificControllerConfigBuilder builder = new SpecificControllerConfigBuilder(item);
        _visitables.get("controllers").add(builder);
        this.controllers.add(builder);
    }
    return (A) this;
  }
  
  public A addToControllers(int index,SpecificControllerConfig item) {
    if (this.controllers == null) {
      this.controllers = new ArrayList();
    }
    SpecificControllerConfigBuilder builder = new SpecificControllerConfigBuilder(item);
    if (index < 0 || index >= controllers.size()) {
        _visitables.get("controllers").add(builder);
        controllers.add(builder);
    } else {
        _visitables.get("controllers").add(builder);
        controllers.add(index, builder);
    }
    return (A) this;
  }
  
  public SpecificControllerConfig buildController(int index) {
    return this.controllers.get(index).build();
  }
  
  public List<SpecificControllerConfig> buildControllers() {
    return this.controllers != null ? build(controllers) : null;
  }
  
  public ControllerConfig buildDefault() {
    return this._default != null ? this._default.build() : null;
  }
  
  public SpecificControllerConfig buildFirstController() {
    return this.controllers.get(0).build();
  }
  
  public SpecificControllerConfig buildLastController() {
    return this.controllers.get(controllers.size() - 1).build();
  }
  
  public SpecificControllerConfig buildMatchingController(Predicate<SpecificControllerConfigBuilder> predicate) {
      for (SpecificControllerConfigBuilder item : controllers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ControllersConfig instance) {
    instance = instance != null ? instance : new ControllersConfig();
    if (instance != null) {
        this.withControllers(instance.getControllers());
        this.withDefault(instance.getDefault());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ControllersNested<A> editController(int index) {
    if (controllers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "controllers"));
    }
    return this.setNewControllerLike(index, this.buildController(index));
  }
  
  public DefaultNested<A> editDefault() {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(null));
  }
  
  public ControllersNested<A> editFirstController() {
    if (controllers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "controllers"));
    }
    return this.setNewControllerLike(0, this.buildController(0));
  }
  
  public ControllersNested<A> editLastController() {
    int index = controllers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "controllers"));
    }
    return this.setNewControllerLike(index, this.buildController(index));
  }
  
  public ControllersNested<A> editMatchingController(Predicate<SpecificControllerConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < controllers.size();i++) {
      if (predicate.test(controllers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "controllers"));
    }
    return this.setNewControllerLike(index, this.buildController(index));
  }
  
  public DefaultNested<A> editOrNewDefault() {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(new ControllerConfigBuilder().build()));
  }
  
  public DefaultNested<A> editOrNewDefaultLike(ControllerConfig item) {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(item));
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
    ControllersConfigFluent that = (ControllersConfigFluent) o;
    if (!(Objects.equals(controllers, that.controllers))) {
      return false;
    }
    if (!(Objects.equals(_default, that._default))) {
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
  
  public boolean hasControllers() {
    return this.controllers != null && !(this.controllers.isEmpty());
  }
  
  public boolean hasDefault() {
    return this._default != null;
  }
  
  public boolean hasMatchingController(Predicate<SpecificControllerConfigBuilder> predicate) {
      for (SpecificControllerConfigBuilder item : controllers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(controllers, _default, additionalProperties);
  }
  
  public A removeAllFromControllers(Collection<SpecificControllerConfig> items) {
    if (this.controllers == null) {
      return (A) this;
    }
    for (SpecificControllerConfig item : items) {
        SpecificControllerConfigBuilder builder = new SpecificControllerConfigBuilder(item);
        _visitables.get("controllers").remove(builder);
        this.controllers.remove(builder);
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
  
  public A removeFromControllers(SpecificControllerConfig... items) {
    if (this.controllers == null) {
      return (A) this;
    }
    for (SpecificControllerConfig item : items) {
        SpecificControllerConfigBuilder builder = new SpecificControllerConfigBuilder(item);
        _visitables.get("controllers").remove(builder);
        this.controllers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromControllers(Predicate<SpecificControllerConfigBuilder> predicate) {
    if (controllers == null) {
      return (A) this;
    }
    Iterator<SpecificControllerConfigBuilder> each = controllers.iterator();
    List visitables = _visitables.get("controllers");
    while (each.hasNext()) {
        SpecificControllerConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ControllersNested<A> setNewControllerLike(int index,SpecificControllerConfig item) {
    return new ControllersNested(index, item);
  }
  
  public A setToControllers(int index,SpecificControllerConfig item) {
    if (this.controllers == null) {
      this.controllers = new ArrayList();
    }
    SpecificControllerConfigBuilder builder = new SpecificControllerConfigBuilder(item);
    if (index < 0 || index >= controllers.size()) {
        _visitables.get("controllers").add(builder);
        controllers.add(builder);
    } else {
        _visitables.get("controllers").add(builder);
        controllers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(controllers == null) && !(controllers.isEmpty())) {
        sb.append("controllers:");
        sb.append(controllers);
        sb.append(",");
    }
    if (!(_default == null)) {
        sb.append("_default:");
        sb.append(_default);
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
  
  public A withControllers(List<SpecificControllerConfig> controllers) {
    if (this.controllers != null) {
      this._visitables.get("controllers").clear();
    }
    if (controllers != null) {
        this.controllers = new ArrayList();
        for (SpecificControllerConfig item : controllers) {
          this.addToControllers(item);
        }
    } else {
      this.controllers = null;
    }
    return (A) this;
  }
  
  public A withControllers(SpecificControllerConfig... controllers) {
    if (this.controllers != null) {
        this.controllers.clear();
        _visitables.remove("controllers");
    }
    if (controllers != null) {
      for (SpecificControllerConfig item : controllers) {
        this.addToControllers(item);
      }
    }
    return (A) this;
  }
  
  public A withDefault(ControllerConfig _default) {
    this._visitables.remove("_default");
    if (_default != null) {
        this._default = new ControllerConfigBuilder(_default);
        this._visitables.get("_default").add(this._default);
    } else {
        this._default = null;
        this._visitables.get("_default").remove(this._default);
    }
    return (A) this;
  }
  
  public DefaultNested<A> withNewDefault() {
    return new DefaultNested(null);
  }
  
  public DefaultNested<A> withNewDefaultLike(ControllerConfig item) {
    return new DefaultNested(item);
  }
  public class ControllersNested<N> extends SpecificControllerConfigFluent<ControllersNested<N>> implements Nested<N>{
  
    SpecificControllerConfigBuilder builder;
    int index;
  
    ControllersNested(int index,SpecificControllerConfig item) {
      this.index = index;
      this.builder = new SpecificControllerConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ControllersConfigFluent.this.setToControllers(index, builder.build());
    }
    
    public N endController() {
      return and();
    }
    
  }
  public class DefaultNested<N> extends ControllerConfigFluent<DefaultNested<N>> implements Nested<N>{
  
    ControllerConfigBuilder builder;
  
    DefaultNested(ControllerConfig item) {
      this.builder = new ControllerConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ControllersConfigFluent.this.withDefault(builder.build());
    }
    
    public N endDefault() {
      return and();
    }
    
  }
}