package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ACMEChallengeSolverHTTP01IngressFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01IngressFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String className;
  private String ingressClassName;
  private ACMEChallengeSolverHTTP01IngressTemplateBuilder ingressTemplate;
  private String name;
  private ACMEChallengeSolverHTTP01IngressPodTemplateBuilder podTemplate;
  private String serviceType;

  public ACMEChallengeSolverHTTP01IngressFluent() {
  }
  
  public ACMEChallengeSolverHTTP01IngressFluent(ACMEChallengeSolverHTTP01Ingress instance) {
    this.copyInstance(instance);
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
  
  public ACMEChallengeSolverHTTP01IngressTemplate buildIngressTemplate() {
    return this.ingressTemplate != null ? this.ingressTemplate.build() : null;
  }
  
  public ACMEChallengeSolverHTTP01IngressPodTemplate buildPodTemplate() {
    return this.podTemplate != null ? this.podTemplate.build() : null;
  }
  
  protected void copyInstance(ACMEChallengeSolverHTTP01Ingress instance) {
    instance = instance != null ? instance : new ACMEChallengeSolverHTTP01Ingress();
    if (instance != null) {
        this.withClassName(instance.getClassName());
        this.withIngressClassName(instance.getIngressClassName());
        this.withIngressTemplate(instance.getIngressTemplate());
        this.withName(instance.getName());
        this.withPodTemplate(instance.getPodTemplate());
        this.withServiceType(instance.getServiceType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IngressTemplateNested<A> editIngressTemplate() {
    return this.withNewIngressTemplateLike(Optional.ofNullable(this.buildIngressTemplate()).orElse(null));
  }
  
  public IngressTemplateNested<A> editOrNewIngressTemplate() {
    return this.withNewIngressTemplateLike(Optional.ofNullable(this.buildIngressTemplate()).orElse(new ACMEChallengeSolverHTTP01IngressTemplateBuilder().build()));
  }
  
  public IngressTemplateNested<A> editOrNewIngressTemplateLike(ACMEChallengeSolverHTTP01IngressTemplate item) {
    return this.withNewIngressTemplateLike(Optional.ofNullable(this.buildIngressTemplate()).orElse(item));
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
    ACMEChallengeSolverHTTP01IngressFluent that = (ACMEChallengeSolverHTTP01IngressFluent) o;
    if (!(Objects.equals(className, that.className))) {
      return false;
    }
    if (!(Objects.equals(ingressClassName, that.ingressClassName))) {
      return false;
    }
    if (!(Objects.equals(ingressTemplate, that.ingressTemplate))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getClassName() {
    return this.className;
  }
  
  public String getIngressClassName() {
    return this.ingressClassName;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getServiceType() {
    return this.serviceType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClassName() {
    return this.className != null;
  }
  
  public boolean hasIngressClassName() {
    return this.ingressClassName != null;
  }
  
  public boolean hasIngressTemplate() {
    return this.ingressTemplate != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPodTemplate() {
    return this.podTemplate != null;
  }
  
  public boolean hasServiceType() {
    return this.serviceType != null;
  }
  
  public int hashCode() {
    return Objects.hash(className, ingressClassName, ingressTemplate, name, podTemplate, serviceType, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(className == null)) {
        sb.append("className:");
        sb.append(className);
        sb.append(",");
    }
    if (!(ingressClassName == null)) {
        sb.append("ingressClassName:");
        sb.append(ingressClassName);
        sb.append(",");
    }
    if (!(ingressTemplate == null)) {
        sb.append("ingressTemplate:");
        sb.append(ingressTemplate);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withClassName(String className) {
    this.className = className;
    return (A) this;
  }
  
  public A withIngressClassName(String ingressClassName) {
    this.ingressClassName = ingressClassName;
    return (A) this;
  }
  
  public A withIngressTemplate(ACMEChallengeSolverHTTP01IngressTemplate ingressTemplate) {
    this._visitables.remove("ingressTemplate");
    if (ingressTemplate != null) {
        this.ingressTemplate = new ACMEChallengeSolverHTTP01IngressTemplateBuilder(ingressTemplate);
        this._visitables.get("ingressTemplate").add(this.ingressTemplate);
    } else {
        this.ingressTemplate = null;
        this._visitables.get("ingressTemplate").remove(this.ingressTemplate);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public IngressTemplateNested<A> withNewIngressTemplate() {
    return new IngressTemplateNested(null);
  }
  
  public IngressTemplateNested<A> withNewIngressTemplateLike(ACMEChallengeSolverHTTP01IngressTemplate item) {
    return new IngressTemplateNested(item);
  }
  
  public PodTemplateNested<A> withNewPodTemplate() {
    return new PodTemplateNested(null);
  }
  
  public PodTemplateNested<A> withNewPodTemplateLike(ACMEChallengeSolverHTTP01IngressPodTemplate item) {
    return new PodTemplateNested(item);
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
  public class IngressTemplateNested<N> extends ACMEChallengeSolverHTTP01IngressTemplateFluent<IngressTemplateNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverHTTP01IngressTemplateBuilder builder;
  
    IngressTemplateNested(ACMEChallengeSolverHTTP01IngressTemplate item) {
      this.builder = new ACMEChallengeSolverHTTP01IngressTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverHTTP01IngressFluent.this.withIngressTemplate(builder.build());
    }
    
    public N endIngressTemplate() {
      return and();
    }
    
  }
  public class PodTemplateNested<N> extends ACMEChallengeSolverHTTP01IngressPodTemplateFluent<PodTemplateNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverHTTP01IngressPodTemplateBuilder builder;
  
    PodTemplateNested(ACMEChallengeSolverHTTP01IngressPodTemplate item) {
      this.builder = new ACMEChallengeSolverHTTP01IngressPodTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverHTTP01IngressFluent.this.withPodTemplate(builder.build());
    }
    
    public N endPodTemplate() {
      return and();
    }
    
  }
}