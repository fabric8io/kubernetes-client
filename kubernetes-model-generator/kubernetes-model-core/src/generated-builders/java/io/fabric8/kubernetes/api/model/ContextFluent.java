package io.fabric8.kubernetes.api.model;

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
public class ContextFluent<A extends io.fabric8.kubernetes.api.model.ContextFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cluster;
  private ArrayList<NamedExtensionBuilder> extensions = new ArrayList<NamedExtensionBuilder>();
  private String namespace;
  private String user;

  public ContextFluent() {
  }
  
  public ContextFluent(Context instance) {
    this.copyInstance(instance);
  }

  public A addAllToExtensions(Collection<NamedExtension> items) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    for (NamedExtension item : items) {
        NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
        _visitables.get("extensions").add(builder);
        this.extensions.add(builder);
    }
    return (A) this;
  }
  
  public ExtensionsNested<A> addNewExtension() {
    return new ExtensionsNested(-1, null);
  }
  
  public A addNewExtension(Object extension,String name) {
    return (A) this.addToExtensions(new NamedExtension(extension, name));
  }
  
  public ExtensionsNested<A> addNewExtensionLike(NamedExtension item) {
    return new ExtensionsNested(-1, item);
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
  
  public A addToExtensions(NamedExtension... items) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    for (NamedExtension item : items) {
        NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
        _visitables.get("extensions").add(builder);
        this.extensions.add(builder);
    }
    return (A) this;
  }
  
  public A addToExtensions(int index,NamedExtension item) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
    if (index < 0 || index >= extensions.size()) {
        _visitables.get("extensions").add(builder);
        extensions.add(builder);
    } else {
        _visitables.get("extensions").add(builder);
        extensions.add(index, builder);
    }
    return (A) this;
  }
  
  public NamedExtension buildExtension(int index) {
    return this.extensions.get(index).build();
  }
  
  public List<NamedExtension> buildExtensions() {
    return this.extensions != null ? build(extensions) : null;
  }
  
  public NamedExtension buildFirstExtension() {
    return this.extensions.get(0).build();
  }
  
  public NamedExtension buildLastExtension() {
    return this.extensions.get(extensions.size() - 1).build();
  }
  
  public NamedExtension buildMatchingExtension(Predicate<NamedExtensionBuilder> predicate) {
      for (NamedExtensionBuilder item : extensions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Context instance) {
    instance = instance != null ? instance : new Context();
    if (instance != null) {
        this.withCluster(instance.getCluster());
        this.withExtensions(instance.getExtensions());
        this.withNamespace(instance.getNamespace());
        this.withUser(instance.getUser());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExtensionsNested<A> editExtension(int index) {
    if (extensions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "extensions"));
    }
    return this.setNewExtensionLike(index, this.buildExtension(index));
  }
  
  public ExtensionsNested<A> editFirstExtension() {
    if (extensions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "extensions"));
    }
    return this.setNewExtensionLike(0, this.buildExtension(0));
  }
  
  public ExtensionsNested<A> editLastExtension() {
    int index = extensions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "extensions"));
    }
    return this.setNewExtensionLike(index, this.buildExtension(index));
  }
  
  public ExtensionsNested<A> editMatchingExtension(Predicate<NamedExtensionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < extensions.size();i++) {
      if (predicate.test(extensions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "extensions"));
    }
    return this.setNewExtensionLike(index, this.buildExtension(index));
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
    ContextFluent that = (ContextFluent) o;
    if (!(Objects.equals(cluster, that.cluster))) {
      return false;
    }
    if (!(Objects.equals(extensions, that.extensions))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(user, that.user))) {
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
  
  public String getCluster() {
    return this.cluster;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getUser() {
    return this.user;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCluster() {
    return this.cluster != null;
  }
  
  public boolean hasExtensions() {
    return this.extensions != null && !(this.extensions.isEmpty());
  }
  
  public boolean hasMatchingExtension(Predicate<NamedExtensionBuilder> predicate) {
      for (NamedExtensionBuilder item : extensions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasUser() {
    return this.user != null;
  }
  
  public int hashCode() {
    return Objects.hash(cluster, extensions, namespace, user, additionalProperties);
  }
  
  public A removeAllFromExtensions(Collection<NamedExtension> items) {
    if (this.extensions == null) {
      return (A) this;
    }
    for (NamedExtension item : items) {
        NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
        _visitables.get("extensions").remove(builder);
        this.extensions.remove(builder);
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
  
  public A removeFromExtensions(NamedExtension... items) {
    if (this.extensions == null) {
      return (A) this;
    }
    for (NamedExtension item : items) {
        NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
        _visitables.get("extensions").remove(builder);
        this.extensions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromExtensions(Predicate<NamedExtensionBuilder> predicate) {
    if (extensions == null) {
      return (A) this;
    }
    Iterator<NamedExtensionBuilder> each = extensions.iterator();
    List visitables = _visitables.get("extensions");
    while (each.hasNext()) {
        NamedExtensionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ExtensionsNested<A> setNewExtensionLike(int index,NamedExtension item) {
    return new ExtensionsNested(index, item);
  }
  
  public A setToExtensions(int index,NamedExtension item) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
    if (index < 0 || index >= extensions.size()) {
        _visitables.get("extensions").add(builder);
        extensions.add(builder);
    } else {
        _visitables.get("extensions").add(builder);
        extensions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cluster == null)) {
        sb.append("cluster:");
        sb.append(cluster);
        sb.append(",");
    }
    if (!(extensions == null) && !(extensions.isEmpty())) {
        sb.append("extensions:");
        sb.append(extensions);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(user == null)) {
        sb.append("user:");
        sb.append(user);
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
  
  public A withCluster(String cluster) {
    this.cluster = cluster;
    return (A) this;
  }
  
  public A withExtensions(List<NamedExtension> extensions) {
    if (this.extensions != null) {
      this._visitables.get("extensions").clear();
    }
    if (extensions != null) {
        this.extensions = new ArrayList();
        for (NamedExtension item : extensions) {
          this.addToExtensions(item);
        }
    } else {
      this.extensions = null;
    }
    return (A) this;
  }
  
  public A withExtensions(NamedExtension... extensions) {
    if (this.extensions != null) {
        this.extensions.clear();
        _visitables.remove("extensions");
    }
    if (extensions != null) {
      for (NamedExtension item : extensions) {
        this.addToExtensions(item);
      }
    }
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withUser(String user) {
    this.user = user;
    return (A) this;
  }
  public class ExtensionsNested<N> extends NamedExtensionFluent<ExtensionsNested<N>> implements Nested<N>{
  
    NamedExtensionBuilder builder;
    int index;
  
    ExtensionsNested(int index,NamedExtension item) {
      this.index = index;
      this.builder = new NamedExtensionBuilder(this, item);
    }
  
    public N and() {
      return (N) ContextFluent.this.setToExtensions(index, builder.build());
    }
    
    public N endExtension() {
      return and();
    }
    
  }
}