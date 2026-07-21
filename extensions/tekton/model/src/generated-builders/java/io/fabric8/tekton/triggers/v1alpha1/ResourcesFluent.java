package io.fabric8.tekton.triggers.v1alpha1;

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
public class ResourcesFluent<A extends io.fabric8.tekton.triggers.v1alpha1.ResourcesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CustomResourceBuilder customResource;
  private KubernetesResourceBuilder kubernetesResource;

  public ResourcesFluent() {
  }
  
  public ResourcesFluent(Resources instance) {
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
  
  public CustomResource buildCustomResource() {
    return this.customResource != null ? this.customResource.build() : null;
  }
  
  public KubernetesResource buildKubernetesResource() {
    return this.kubernetesResource != null ? this.kubernetesResource.build() : null;
  }
  
  protected void copyInstance(Resources instance) {
    instance = instance != null ? instance : new Resources();
    if (instance != null) {
        this.withCustomResource(instance.getCustomResource());
        this.withKubernetesResource(instance.getKubernetesResource());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomResourceNested<A> editCustomResource() {
    return this.withNewCustomResourceLike(Optional.ofNullable(this.buildCustomResource()).orElse(null));
  }
  
  public KubernetesResourceNested<A> editKubernetesResource() {
    return this.withNewKubernetesResourceLike(Optional.ofNullable(this.buildKubernetesResource()).orElse(null));
  }
  
  public CustomResourceNested<A> editOrNewCustomResource() {
    return this.withNewCustomResourceLike(Optional.ofNullable(this.buildCustomResource()).orElse(new CustomResourceBuilder().build()));
  }
  
  public CustomResourceNested<A> editOrNewCustomResourceLike(CustomResource item) {
    return this.withNewCustomResourceLike(Optional.ofNullable(this.buildCustomResource()).orElse(item));
  }
  
  public KubernetesResourceNested<A> editOrNewKubernetesResource() {
    return this.withNewKubernetesResourceLike(Optional.ofNullable(this.buildKubernetesResource()).orElse(new KubernetesResourceBuilder().build()));
  }
  
  public KubernetesResourceNested<A> editOrNewKubernetesResourceLike(KubernetesResource item) {
    return this.withNewKubernetesResourceLike(Optional.ofNullable(this.buildKubernetesResource()).orElse(item));
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
    ResourcesFluent that = (ResourcesFluent) o;
    if (!(Objects.equals(customResource, that.customResource))) {
      return false;
    }
    if (!(Objects.equals(kubernetesResource, that.kubernetesResource))) {
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
  
  public boolean hasCustomResource() {
    return this.customResource != null;
  }
  
  public boolean hasKubernetesResource() {
    return this.kubernetesResource != null;
  }
  
  public int hashCode() {
    return Objects.hash(customResource, kubernetesResource, additionalProperties);
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
    if (!(customResource == null)) {
        sb.append("customResource:");
        sb.append(customResource);
        sb.append(",");
    }
    if (!(kubernetesResource == null)) {
        sb.append("kubernetesResource:");
        sb.append(kubernetesResource);
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
  
  public A withCustomResource(CustomResource customResource) {
    this._visitables.remove("customResource");
    if (customResource != null) {
        this.customResource = new CustomResourceBuilder(customResource);
        this._visitables.get("customResource").add(this.customResource);
    } else {
        this.customResource = null;
        this._visitables.get("customResource").remove(this.customResource);
    }
    return (A) this;
  }
  
  public A withKubernetesResource(KubernetesResource kubernetesResource) {
    this._visitables.remove("kubernetesResource");
    if (kubernetesResource != null) {
        this.kubernetesResource = new KubernetesResourceBuilder(kubernetesResource);
        this._visitables.get("kubernetesResource").add(this.kubernetesResource);
    } else {
        this.kubernetesResource = null;
        this._visitables.get("kubernetesResource").remove(this.kubernetesResource);
    }
    return (A) this;
  }
  
  public CustomResourceNested<A> withNewCustomResource() {
    return new CustomResourceNested(null);
  }
  
  public CustomResourceNested<A> withNewCustomResourceLike(CustomResource item) {
    return new CustomResourceNested(item);
  }
  
  public KubernetesResourceNested<A> withNewKubernetesResource() {
    return new KubernetesResourceNested(null);
  }
  
  public KubernetesResourceNested<A> withNewKubernetesResourceLike(KubernetesResource item) {
    return new KubernetesResourceNested(item);
  }
  public class CustomResourceNested<N> extends CustomResourceFluent<CustomResourceNested<N>> implements Nested<N>{
  
    CustomResourceBuilder builder;
  
    CustomResourceNested(CustomResource item) {
      this.builder = new CustomResourceBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourcesFluent.this.withCustomResource(builder.build());
    }
    
    public N endCustomResource() {
      return and();
    }
    
  }
  public class KubernetesResourceNested<N> extends KubernetesResourceFluent<KubernetesResourceNested<N>> implements Nested<N>{
  
    KubernetesResourceBuilder builder;
  
    KubernetesResourceNested(KubernetesResource item) {
      this.builder = new KubernetesResourceBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourcesFluent.this.withKubernetesResource(builder.build());
    }
    
    public N endKubernetesResource() {
      return and();
    }
    
  }
}