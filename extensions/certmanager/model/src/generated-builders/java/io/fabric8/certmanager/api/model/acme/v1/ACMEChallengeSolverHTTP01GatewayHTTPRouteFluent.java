package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.gatewayapi.v1.ParentReference;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> labels;
  private List<ParentReference> parentRefs = new ArrayList<ParentReference>();
  private ACMEChallengeSolverHTTP01IngressPodTemplateBuilder podTemplate;
  private String serviceType;

  public ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent() {
  }
  
  public ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent(ACMEChallengeSolverHTTP01GatewayHTTPRoute instance) {
    this.copyInstance(instance);
  }

  public A addAllToParentRefs(Collection<ParentReference> items) {
    if (this.parentRefs == null) {
      this.parentRefs = new ArrayList();
    }
    for (ParentReference item : items) {
      this.parentRefs.add(item);
    }
    return (A) this;
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
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToParentRefs(ParentReference... items) {
    if (this.parentRefs == null) {
      this.parentRefs = new ArrayList();
    }
    for (ParentReference item : items) {
      this.parentRefs.add(item);
    }
    return (A) this;
  }
  
  public A addToParentRefs(int index,ParentReference item) {
    if (this.parentRefs == null) {
      this.parentRefs = new ArrayList();
    }
    this.parentRefs.add(index, item);
    return (A) this;
  }
  
  public ACMEChallengeSolverHTTP01IngressPodTemplate buildPodTemplate() {
    return this.podTemplate != null ? this.podTemplate.build() : null;
  }
  
  protected void copyInstance(ACMEChallengeSolverHTTP01GatewayHTTPRoute instance) {
    instance = instance != null ? instance : new ACMEChallengeSolverHTTP01GatewayHTTPRoute();
    if (instance != null) {
        this.withLabels(instance.getLabels());
        this.withParentRefs(instance.getParentRefs());
        this.withPodTemplate(instance.getPodTemplate());
        this.withServiceType(instance.getServiceType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PodTemplateNested<A> editOrNewPodTemplate() {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(new ACMEChallengeSolverHTTP01IngressPodTemplateBuilder().build()));
  }
  
  public PodTemplateNested<A> editOrNewPodTemplateLike(ACMEChallengeSolverHTTP01IngressPodTemplate item) {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(item));
  }
  
  public PodTemplateNested<A> editPodTemplate() {
    return this.withNewPodTemplateLike(Optional.ofNullable(this.buildPodTemplate()).orElse(null));
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
    ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent that = (ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent) o;
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(parentRefs, that.parentRefs))) {
      return false;
    }
    if (!(Objects.equals(podTemplate, that.podTemplate))) {
      return false;
    }
    if (!(Objects.equals(serviceType, that.serviceType))) {
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
  
  public ParentReference getFirstParentRef() {
    return this.parentRefs.get(0);
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public ParentReference getLastParentRef() {
    return this.parentRefs.get(parentRefs.size() - 1);
  }
  
  public ParentReference getMatchingParentRef(Predicate<ParentReference> predicate) {
      for (ParentReference item : parentRefs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public ParentReference getParentRef(int index) {
    return this.parentRefs.get(index);
  }
  
  public List<ParentReference> getParentRefs() {
    return this.parentRefs;
  }
  
  public String getServiceType() {
    return this.serviceType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasMatchingParentRef(Predicate<ParentReference> predicate) {
      for (ParentReference item : parentRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasParentRefs() {
    return this.parentRefs != null && !(this.parentRefs.isEmpty());
  }
  
  public boolean hasPodTemplate() {
    return this.podTemplate != null;
  }
  
  public boolean hasServiceType() {
    return this.serviceType != null;
  }
  
  public int hashCode() {
    return Objects.hash(labels, parentRefs, podTemplate, serviceType, additionalProperties);
  }
  
  public A removeAllFromParentRefs(Collection<ParentReference> items) {
    if (this.parentRefs == null) {
      return (A) this;
    }
    for (ParentReference item : items) {
      this.parentRefs.remove(item);
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
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromParentRefs(ParentReference... items) {
    if (this.parentRefs == null) {
      return (A) this;
    }
    for (ParentReference item : items) {
      this.parentRefs.remove(item);
    }
    return (A) this;
  }
  
  public A setToParentRefs(int index,ParentReference item) {
    if (this.parentRefs == null) {
      this.parentRefs = new ArrayList();
    }
    this.parentRefs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(parentRefs == null) && !(parentRefs.isEmpty())) {
        sb.append("parentRefs:");
        sb.append(parentRefs);
        sb.append(",");
    }
    if (!(podTemplate == null)) {
        sb.append("podTemplate:");
        sb.append(podTemplate);
        sb.append(",");
    }
    if (!(serviceType == null)) {
        sb.append("serviceType:");
        sb.append(serviceType);
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
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public PodTemplateNested<A> withNewPodTemplate() {
    return new PodTemplateNested(null);
  }
  
  public PodTemplateNested<A> withNewPodTemplateLike(ACMEChallengeSolverHTTP01IngressPodTemplate item) {
    return new PodTemplateNested(item);
  }
  
  public A withParentRefs(List<ParentReference> parentRefs) {
    if (parentRefs != null) {
        this.parentRefs = new ArrayList();
        for (ParentReference item : parentRefs) {
          this.addToParentRefs(item);
        }
    } else {
      this.parentRefs = null;
    }
    return (A) this;
  }
  
  public A withParentRefs(ParentReference... parentRefs) {
    if (this.parentRefs != null) {
        this.parentRefs.clear();
        _visitables.remove("parentRefs");
    }
    if (parentRefs != null) {
      for (ParentReference item : parentRefs) {
        this.addToParentRefs(item);
      }
    }
    return (A) this;
  }
  
  public A withPodTemplate(ACMEChallengeSolverHTTP01IngressPodTemplate podTemplate) {
    this._visitables.remove("podTemplate");
    if (podTemplate != null) {
        this.podTemplate = new ACMEChallengeSolverHTTP01IngressPodTemplateBuilder(podTemplate);
        this._visitables.get("podTemplate").add(this.podTemplate);
    } else {
        this.podTemplate = null;
        this._visitables.get("podTemplate").remove(this.podTemplate);
    }
    return (A) this;
  }
  
  public A withServiceType(String serviceType) {
    this.serviceType = serviceType;
    return (A) this;
  }
  public class PodTemplateNested<N> extends ACMEChallengeSolverHTTP01IngressPodTemplateFluent<PodTemplateNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverHTTP01IngressPodTemplateBuilder builder;
  
    PodTemplateNested(ACMEChallengeSolverHTTP01IngressPodTemplate item) {
      this.builder = new ACMEChallengeSolverHTTP01IngressPodTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent.this.withPodTemplate(builder.build());
    }
    
    public N endPodTemplate() {
      return and();
    }
    
  }
}