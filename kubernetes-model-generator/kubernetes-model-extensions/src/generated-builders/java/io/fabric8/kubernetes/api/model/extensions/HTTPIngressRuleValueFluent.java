package io.fabric8.kubernetes.api.model.extensions;

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
public class HTTPIngressRuleValueFluent<A extends io.fabric8.kubernetes.api.model.extensions.HTTPIngressRuleValueFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<HTTPIngressPathBuilder> paths = new ArrayList<HTTPIngressPathBuilder>();

  public HTTPIngressRuleValueFluent() {
  }
  
  public HTTPIngressRuleValueFluent(HTTPIngressRuleValue instance) {
    this.copyInstance(instance);
  }

  public A addAllToPaths(Collection<HTTPIngressPath> items) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    for (HTTPIngressPath item : items) {
        HTTPIngressPathBuilder builder = new HTTPIngressPathBuilder(item);
        _visitables.get("paths").add(builder);
        this.paths.add(builder);
    }
    return (A) this;
  }
  
  public PathsNested<A> addNewPath() {
    return new PathsNested(-1, null);
  }
  
  public PathsNested<A> addNewPathLike(HTTPIngressPath item) {
    return new PathsNested(-1, item);
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
  
  public A addToPaths(HTTPIngressPath... items) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    for (HTTPIngressPath item : items) {
        HTTPIngressPathBuilder builder = new HTTPIngressPathBuilder(item);
        _visitables.get("paths").add(builder);
        this.paths.add(builder);
    }
    return (A) this;
  }
  
  public A addToPaths(int index,HTTPIngressPath item) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    HTTPIngressPathBuilder builder = new HTTPIngressPathBuilder(item);
    if (index < 0 || index >= paths.size()) {
        _visitables.get("paths").add(builder);
        paths.add(builder);
    } else {
        _visitables.get("paths").add(builder);
        paths.add(index, builder);
    }
    return (A) this;
  }
  
  public HTTPIngressPath buildFirstPath() {
    return this.paths.get(0).build();
  }
  
  public HTTPIngressPath buildLastPath() {
    return this.paths.get(paths.size() - 1).build();
  }
  
  public HTTPIngressPath buildMatchingPath(Predicate<HTTPIngressPathBuilder> predicate) {
      for (HTTPIngressPathBuilder item : paths) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HTTPIngressPath buildPath(int index) {
    return this.paths.get(index).build();
  }
  
  public List<HTTPIngressPath> buildPaths() {
    return this.paths != null ? build(paths) : null;
  }
  
  protected void copyInstance(HTTPIngressRuleValue instance) {
    instance = instance != null ? instance : new HTTPIngressRuleValue();
    if (instance != null) {
        this.withPaths(instance.getPaths());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PathsNested<A> editFirstPath() {
    if (paths.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "paths"));
    }
    return this.setNewPathLike(0, this.buildPath(0));
  }
  
  public PathsNested<A> editLastPath() {
    int index = paths.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "paths"));
    }
    return this.setNewPathLike(index, this.buildPath(index));
  }
  
  public PathsNested<A> editMatchingPath(Predicate<HTTPIngressPathBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < paths.size();i++) {
      if (predicate.test(paths.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "paths"));
    }
    return this.setNewPathLike(index, this.buildPath(index));
  }
  
  public PathsNested<A> editPath(int index) {
    if (paths.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "paths"));
    }
    return this.setNewPathLike(index, this.buildPath(index));
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
    HTTPIngressRuleValueFluent that = (HTTPIngressRuleValueFluent) o;
    if (!(Objects.equals(paths, that.paths))) {
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
  
  public boolean hasMatchingPath(Predicate<HTTPIngressPathBuilder> predicate) {
      for (HTTPIngressPathBuilder item : paths) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPaths() {
    return this.paths != null && !(this.paths.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(paths, additionalProperties);
  }
  
  public A removeAllFromPaths(Collection<HTTPIngressPath> items) {
    if (this.paths == null) {
      return (A) this;
    }
    for (HTTPIngressPath item : items) {
        HTTPIngressPathBuilder builder = new HTTPIngressPathBuilder(item);
        _visitables.get("paths").remove(builder);
        this.paths.remove(builder);
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
  
  public A removeFromPaths(HTTPIngressPath... items) {
    if (this.paths == null) {
      return (A) this;
    }
    for (HTTPIngressPath item : items) {
        HTTPIngressPathBuilder builder = new HTTPIngressPathBuilder(item);
        _visitables.get("paths").remove(builder);
        this.paths.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPaths(Predicate<HTTPIngressPathBuilder> predicate) {
    if (paths == null) {
      return (A) this;
    }
    Iterator<HTTPIngressPathBuilder> each = paths.iterator();
    List visitables = _visitables.get("paths");
    while (each.hasNext()) {
        HTTPIngressPathBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PathsNested<A> setNewPathLike(int index,HTTPIngressPath item) {
    return new PathsNested(index, item);
  }
  
  public A setToPaths(int index,HTTPIngressPath item) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    HTTPIngressPathBuilder builder = new HTTPIngressPathBuilder(item);
    if (index < 0 || index >= paths.size()) {
        _visitables.get("paths").add(builder);
        paths.add(builder);
    } else {
        _visitables.get("paths").add(builder);
        paths.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(paths == null) && !(paths.isEmpty())) {
        sb.append("paths:");
        sb.append(paths);
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
  
  public A withPaths(List<HTTPIngressPath> paths) {
    if (this.paths != null) {
      this._visitables.get("paths").clear();
    }
    if (paths != null) {
        this.paths = new ArrayList();
        for (HTTPIngressPath item : paths) {
          this.addToPaths(item);
        }
    } else {
      this.paths = null;
    }
    return (A) this;
  }
  
  public A withPaths(HTTPIngressPath... paths) {
    if (this.paths != null) {
        this.paths.clear();
        _visitables.remove("paths");
    }
    if (paths != null) {
      for (HTTPIngressPath item : paths) {
        this.addToPaths(item);
      }
    }
    return (A) this;
  }
  public class PathsNested<N> extends HTTPIngressPathFluent<PathsNested<N>> implements Nested<N>{
  
    HTTPIngressPathBuilder builder;
    int index;
  
    PathsNested(int index,HTTPIngressPath item) {
      this.index = index;
      this.builder = new HTTPIngressPathBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPIngressRuleValueFluent.this.setToPaths(index, builder.build());
    }
    
    public N endPath() {
      return and();
    }
    
  }
}