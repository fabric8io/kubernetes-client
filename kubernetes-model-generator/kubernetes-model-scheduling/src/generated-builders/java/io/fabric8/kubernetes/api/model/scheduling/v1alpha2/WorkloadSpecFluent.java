package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

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
public class WorkloadSpecFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1alpha2.WorkloadSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TypedLocalObjectReferenceBuilder controllerRef;
  private ArrayList<PodGroupTemplateBuilder> podGroupTemplates = new ArrayList<PodGroupTemplateBuilder>();

  public WorkloadSpecFluent() {
  }
  
  public WorkloadSpecFluent(WorkloadSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPodGroupTemplates(Collection<PodGroupTemplate> items) {
    if (this.podGroupTemplates == null) {
      this.podGroupTemplates = new ArrayList();
    }
    for (PodGroupTemplate item : items) {
        PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
        _visitables.get("podGroupTemplates").add(builder);
        this.podGroupTemplates.add(builder);
    }
    return (A) this;
  }
  
  public PodGroupTemplatesNested<A> addNewPodGroupTemplate() {
    return new PodGroupTemplatesNested(-1, null);
  }
  
  public PodGroupTemplatesNested<A> addNewPodGroupTemplateLike(PodGroupTemplate item) {
    return new PodGroupTemplatesNested(-1, item);
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
  
  public A addToPodGroupTemplates(PodGroupTemplate... items) {
    if (this.podGroupTemplates == null) {
      this.podGroupTemplates = new ArrayList();
    }
    for (PodGroupTemplate item : items) {
        PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
        _visitables.get("podGroupTemplates").add(builder);
        this.podGroupTemplates.add(builder);
    }
    return (A) this;
  }
  
  public A addToPodGroupTemplates(int index,PodGroupTemplate item) {
    if (this.podGroupTemplates == null) {
      this.podGroupTemplates = new ArrayList();
    }
    PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
    if (index < 0 || index >= podGroupTemplates.size()) {
        _visitables.get("podGroupTemplates").add(builder);
        podGroupTemplates.add(builder);
    } else {
        _visitables.get("podGroupTemplates").add(builder);
        podGroupTemplates.add(index, builder);
    }
    return (A) this;
  }
  
  public TypedLocalObjectReference buildControllerRef() {
    return this.controllerRef != null ? this.controllerRef.build() : null;
  }
  
  public PodGroupTemplate buildFirstPodGroupTemplate() {
    return this.podGroupTemplates.get(0).build();
  }
  
  public PodGroupTemplate buildLastPodGroupTemplate() {
    return this.podGroupTemplates.get(podGroupTemplates.size() - 1).build();
  }
  
  public PodGroupTemplate buildMatchingPodGroupTemplate(Predicate<PodGroupTemplateBuilder> predicate) {
      for (PodGroupTemplateBuilder item : podGroupTemplates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodGroupTemplate buildPodGroupTemplate(int index) {
    return this.podGroupTemplates.get(index).build();
  }
  
  public List<PodGroupTemplate> buildPodGroupTemplates() {
    return this.podGroupTemplates != null ? build(podGroupTemplates) : null;
  }
  
  protected void copyInstance(WorkloadSpec instance) {
    instance = instance != null ? instance : new WorkloadSpec();
    if (instance != null) {
        this.withControllerRef(instance.getControllerRef());
        this.withPodGroupTemplates(instance.getPodGroupTemplates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ControllerRefNested<A> editControllerRef() {
    return this.withNewControllerRefLike(Optional.ofNullable(this.buildControllerRef()).orElse(null));
  }
  
  public PodGroupTemplatesNested<A> editFirstPodGroupTemplate() {
    if (podGroupTemplates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "podGroupTemplates"));
    }
    return this.setNewPodGroupTemplateLike(0, this.buildPodGroupTemplate(0));
  }
  
  public PodGroupTemplatesNested<A> editLastPodGroupTemplate() {
    int index = podGroupTemplates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "podGroupTemplates"));
    }
    return this.setNewPodGroupTemplateLike(index, this.buildPodGroupTemplate(index));
  }
  
  public PodGroupTemplatesNested<A> editMatchingPodGroupTemplate(Predicate<PodGroupTemplateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < podGroupTemplates.size();i++) {
      if (predicate.test(podGroupTemplates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "podGroupTemplates"));
    }
    return this.setNewPodGroupTemplateLike(index, this.buildPodGroupTemplate(index));
  }
  
  public ControllerRefNested<A> editOrNewControllerRef() {
    return this.withNewControllerRefLike(Optional.ofNullable(this.buildControllerRef()).orElse(new TypedLocalObjectReferenceBuilder().build()));
  }
  
  public ControllerRefNested<A> editOrNewControllerRefLike(TypedLocalObjectReference item) {
    return this.withNewControllerRefLike(Optional.ofNullable(this.buildControllerRef()).orElse(item));
  }
  
  public PodGroupTemplatesNested<A> editPodGroupTemplate(int index) {
    if (podGroupTemplates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "podGroupTemplates"));
    }
    return this.setNewPodGroupTemplateLike(index, this.buildPodGroupTemplate(index));
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
    WorkloadSpecFluent that = (WorkloadSpecFluent) o;
    if (!(Objects.equals(controllerRef, that.controllerRef))) {
      return false;
    }
    if (!(Objects.equals(podGroupTemplates, that.podGroupTemplates))) {
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
  
  public boolean hasControllerRef() {
    return this.controllerRef != null;
  }
  
  public boolean hasMatchingPodGroupTemplate(Predicate<PodGroupTemplateBuilder> predicate) {
      for (PodGroupTemplateBuilder item : podGroupTemplates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPodGroupTemplates() {
    return this.podGroupTemplates != null && !(this.podGroupTemplates.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(controllerRef, podGroupTemplates, additionalProperties);
  }
  
  public A removeAllFromPodGroupTemplates(Collection<PodGroupTemplate> items) {
    if (this.podGroupTemplates == null) {
      return (A) this;
    }
    for (PodGroupTemplate item : items) {
        PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
        _visitables.get("podGroupTemplates").remove(builder);
        this.podGroupTemplates.remove(builder);
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
  
  public A removeFromPodGroupTemplates(PodGroupTemplate... items) {
    if (this.podGroupTemplates == null) {
      return (A) this;
    }
    for (PodGroupTemplate item : items) {
        PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
        _visitables.get("podGroupTemplates").remove(builder);
        this.podGroupTemplates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPodGroupTemplates(Predicate<PodGroupTemplateBuilder> predicate) {
    if (podGroupTemplates == null) {
      return (A) this;
    }
    Iterator<PodGroupTemplateBuilder> each = podGroupTemplates.iterator();
    List visitables = _visitables.get("podGroupTemplates");
    while (each.hasNext()) {
        PodGroupTemplateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PodGroupTemplatesNested<A> setNewPodGroupTemplateLike(int index,PodGroupTemplate item) {
    return new PodGroupTemplatesNested(index, item);
  }
  
  public A setToPodGroupTemplates(int index,PodGroupTemplate item) {
    if (this.podGroupTemplates == null) {
      this.podGroupTemplates = new ArrayList();
    }
    PodGroupTemplateBuilder builder = new PodGroupTemplateBuilder(item);
    if (index < 0 || index >= podGroupTemplates.size()) {
        _visitables.get("podGroupTemplates").add(builder);
        podGroupTemplates.add(builder);
    } else {
        _visitables.get("podGroupTemplates").add(builder);
        podGroupTemplates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(controllerRef == null)) {
        sb.append("controllerRef:");
        sb.append(controllerRef);
        sb.append(",");
    }
    if (!(podGroupTemplates == null) && !(podGroupTemplates.isEmpty())) {
        sb.append("podGroupTemplates:");
        sb.append(podGroupTemplates);
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
  
  public A withControllerRef(TypedLocalObjectReference controllerRef) {
    this._visitables.remove("controllerRef");
    if (controllerRef != null) {
        this.controllerRef = new TypedLocalObjectReferenceBuilder(controllerRef);
        this._visitables.get("controllerRef").add(this.controllerRef);
    } else {
        this.controllerRef = null;
        this._visitables.get("controllerRef").remove(this.controllerRef);
    }
    return (A) this;
  }
  
  public ControllerRefNested<A> withNewControllerRef() {
    return new ControllerRefNested(null);
  }
  
  public A withNewControllerRef(String apiGroup,String kind,String name) {
    return (A) this.withControllerRef(new TypedLocalObjectReference(apiGroup, kind, name));
  }
  
  public ControllerRefNested<A> withNewControllerRefLike(TypedLocalObjectReference item) {
    return new ControllerRefNested(item);
  }
  
  public A withPodGroupTemplates(List<PodGroupTemplate> podGroupTemplates) {
    if (this.podGroupTemplates != null) {
      this._visitables.get("podGroupTemplates").clear();
    }
    if (podGroupTemplates != null) {
        this.podGroupTemplates = new ArrayList();
        for (PodGroupTemplate item : podGroupTemplates) {
          this.addToPodGroupTemplates(item);
        }
    } else {
      this.podGroupTemplates = null;
    }
    return (A) this;
  }
  
  public A withPodGroupTemplates(PodGroupTemplate... podGroupTemplates) {
    if (this.podGroupTemplates != null) {
        this.podGroupTemplates.clear();
        _visitables.remove("podGroupTemplates");
    }
    if (podGroupTemplates != null) {
      for (PodGroupTemplate item : podGroupTemplates) {
        this.addToPodGroupTemplates(item);
      }
    }
    return (A) this;
  }
  public class ControllerRefNested<N> extends TypedLocalObjectReferenceFluent<ControllerRefNested<N>> implements Nested<N>{
  
    TypedLocalObjectReferenceBuilder builder;
  
    ControllerRefNested(TypedLocalObjectReference item) {
      this.builder = new TypedLocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkloadSpecFluent.this.withControllerRef(builder.build());
    }
    
    public N endControllerRef() {
      return and();
    }
    
  }
  public class PodGroupTemplatesNested<N> extends PodGroupTemplateFluent<PodGroupTemplatesNested<N>> implements Nested<N>{
  
    PodGroupTemplateBuilder builder;
    int index;
  
    PodGroupTemplatesNested(int index,PodGroupTemplate item) {
      this.index = index;
      this.builder = new PodGroupTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkloadSpecFluent.this.setToPodGroupTemplates(index, builder.build());
    }
    
    public N endPodGroupTemplate() {
      return and();
    }
    
  }
}