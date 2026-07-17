package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class MachineConfigPoolStatusConfigurationFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineConfigPoolStatusConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String fieldPath;
  private String kind;
  private String name;
  private String namespace;
  private String resourceVersion;
  private ArrayList<ObjectReferenceBuilder> source = new ArrayList<ObjectReferenceBuilder>();
  private String uid;

  public MachineConfigPoolStatusConfigurationFluent() {
  }
  
  public MachineConfigPoolStatusConfigurationFluent(MachineConfigPoolStatusConfiguration instance) {
    this.copyInstance(instance);
  }

  public A addAllToSource(Collection<ObjectReference> items) {
    if (this.source == null) {
      this.source = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("source").add(builder);
        this.source.add(builder);
    }
    return (A) this;
  }
  
  public SourceNested<A> addNewSource() {
    return new SourceNested(-1, null);
  }
  
  public SourceNested<A> addNewSourceLike(ObjectReference item) {
    return new SourceNested(-1, item);
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
  
  public A addToSource(ObjectReference... items) {
    if (this.source == null) {
      this.source = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("source").add(builder);
        this.source.add(builder);
    }
    return (A) this;
  }
  
  public A addToSource(int index,ObjectReference item) {
    if (this.source == null) {
      this.source = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= source.size()) {
        _visitables.get("source").add(builder);
        source.add(builder);
    } else {
        _visitables.get("source").add(builder);
        source.add(index, builder);
    }
    return (A) this;
  }
  
  public ObjectReference buildFirstSource() {
    return this.source.get(0).build();
  }
  
  public ObjectReference buildLastSource() {
    return this.source.get(source.size() - 1).build();
  }
  
  public ObjectReference buildMatchingSource(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : source) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<ObjectReference> buildSource() {
    return this.source != null ? build(source) : null;
  }
  
  public ObjectReference buildSource(int index) {
    return this.source.get(index).build();
  }
  
  protected void copyInstance(MachineConfigPoolStatusConfiguration instance) {
    instance = instance != null ? instance : new MachineConfigPoolStatusConfiguration();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withFieldPath(instance.getFieldPath());
        this.withKind(instance.getKind());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withResourceVersion(instance.getResourceVersion());
        this.withSource(instance.getSource());
        this.withUid(instance.getUid());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SourceNested<A> editFirstSource() {
    if (source.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "source"));
    }
    return this.setNewSourceLike(0, this.buildSource(0));
  }
  
  public SourceNested<A> editLastSource() {
    int index = source.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "source"));
    }
    return this.setNewSourceLike(index, this.buildSource(index));
  }
  
  public SourceNested<A> editMatchingSource(Predicate<ObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < source.size();i++) {
      if (predicate.test(source.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "source"));
    }
    return this.setNewSourceLike(index, this.buildSource(index));
  }
  
  public SourceNested<A> editSource(int index) {
    if (source.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "source"));
    }
    return this.setNewSourceLike(index, this.buildSource(index));
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
    MachineConfigPoolStatusConfigurationFluent that = (MachineConfigPoolStatusConfigurationFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(fieldPath, that.fieldPath))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(resourceVersion, that.resourceVersion))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getFieldPath() {
    return this.fieldPath;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getResourceVersion() {
    return this.resourceVersion;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasFieldPath() {
    return this.fieldPath != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingSource(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : source) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasResourceVersion() {
    return this.resourceVersion != null;
  }
  
  public boolean hasSource() {
    return this.source != null && !(this.source.isEmpty());
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, fieldPath, kind, name, namespace, resourceVersion, source, uid, additionalProperties);
  }
  
  public A removeAllFromSource(Collection<ObjectReference> items) {
    if (this.source == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("source").remove(builder);
        this.source.remove(builder);
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
  
  public A removeFromSource(ObjectReference... items) {
    if (this.source == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("source").remove(builder);
        this.source.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSource(Predicate<ObjectReferenceBuilder> predicate) {
    if (source == null) {
      return (A) this;
    }
    Iterator<ObjectReferenceBuilder> each = source.iterator();
    List visitables = _visitables.get("source");
    while (each.hasNext()) {
        ObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SourceNested<A> setNewSourceLike(int index,ObjectReference item) {
    return new SourceNested(index, item);
  }
  
  public A setToSource(int index,ObjectReference item) {
    if (this.source == null) {
      this.source = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= source.size()) {
        _visitables.get("source").add(builder);
        source.add(builder);
    } else {
        _visitables.get("source").add(builder);
        source.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(fieldPath == null)) {
        sb.append("fieldPath:");
        sb.append(fieldPath);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(resourceVersion == null)) {
        sb.append("resourceVersion:");
        sb.append(resourceVersion);
        sb.append(",");
    }
    if (!(source == null) && !(source.isEmpty())) {
        sb.append("source:");
        sb.append(source);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withFieldPath(String fieldPath) {
    this.fieldPath = fieldPath;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withResourceVersion(String resourceVersion) {
    this.resourceVersion = resourceVersion;
    return (A) this;
  }
  
  public A withSource(List<ObjectReference> source) {
    if (this.source != null) {
      this._visitables.get("source").clear();
    }
    if (source != null) {
        this.source = new ArrayList();
        for (ObjectReference item : source) {
          this.addToSource(item);
        }
    } else {
      this.source = null;
    }
    return (A) this;
  }
  
  public A withSource(ObjectReference... source) {
    if (this.source != null) {
        this.source.clear();
        _visitables.remove("source");
    }
    if (source != null) {
      for (ObjectReference item : source) {
        this.addToSource(item);
      }
    }
    return (A) this;
  }
  
  public A withUid(String uid) {
    this.uid = uid;
    return (A) this;
  }
  public class SourceNested<N> extends ObjectReferenceFluent<SourceNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
    int index;
  
    SourceNested(int index,ObjectReference item) {
      this.index = index;
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigPoolStatusConfigurationFluent.this.setToSource(index, builder.build());
    }
    
    public N endSource() {
      return and();
    }
    
  }
}