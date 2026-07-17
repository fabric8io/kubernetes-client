package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class ClusterRelocateSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterRelocateSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder clusterDeploymentSelector;
  private KubeconfigSecretReferenceBuilder kubeconfigSecretRef;

  public ClusterRelocateSpecFluent() {
  }
  
  public ClusterRelocateSpecFluent(ClusterRelocateSpec instance) {
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
  
  public LabelSelector buildClusterDeploymentSelector() {
    return this.clusterDeploymentSelector != null ? this.clusterDeploymentSelector.build() : null;
  }
  
  public KubeconfigSecretReference buildKubeconfigSecretRef() {
    return this.kubeconfigSecretRef != null ? this.kubeconfigSecretRef.build() : null;
  }
  
  protected void copyInstance(ClusterRelocateSpec instance) {
    instance = instance != null ? instance : new ClusterRelocateSpec();
    if (instance != null) {
        this.withClusterDeploymentSelector(instance.getClusterDeploymentSelector());
        this.withKubeconfigSecretRef(instance.getKubeconfigSecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterDeploymentSelectorNested<A> editClusterDeploymentSelector() {
    return this.withNewClusterDeploymentSelectorLike(Optional.ofNullable(this.buildClusterDeploymentSelector()).orElse(null));
  }
  
  public KubeconfigSecretRefNested<A> editKubeconfigSecretRef() {
    return this.withNewKubeconfigSecretRefLike(Optional.ofNullable(this.buildKubeconfigSecretRef()).orElse(null));
  }
  
  public ClusterDeploymentSelectorNested<A> editOrNewClusterDeploymentSelector() {
    return this.withNewClusterDeploymentSelectorLike(Optional.ofNullable(this.buildClusterDeploymentSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ClusterDeploymentSelectorNested<A> editOrNewClusterDeploymentSelectorLike(LabelSelector item) {
    return this.withNewClusterDeploymentSelectorLike(Optional.ofNullable(this.buildClusterDeploymentSelector()).orElse(item));
  }
  
  public KubeconfigSecretRefNested<A> editOrNewKubeconfigSecretRef() {
    return this.withNewKubeconfigSecretRefLike(Optional.ofNullable(this.buildKubeconfigSecretRef()).orElse(new KubeconfigSecretReferenceBuilder().build()));
  }
  
  public KubeconfigSecretRefNested<A> editOrNewKubeconfigSecretRefLike(KubeconfigSecretReference item) {
    return this.withNewKubeconfigSecretRefLike(Optional.ofNullable(this.buildKubeconfigSecretRef()).orElse(item));
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
    ClusterRelocateSpecFluent that = (ClusterRelocateSpecFluent) o;
    if (!(Objects.equals(clusterDeploymentSelector, that.clusterDeploymentSelector))) {
      return false;
    }
    if (!(Objects.equals(kubeconfigSecretRef, that.kubeconfigSecretRef))) {
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
  
  public boolean hasClusterDeploymentSelector() {
    return this.clusterDeploymentSelector != null;
  }
  
  public boolean hasKubeconfigSecretRef() {
    return this.kubeconfigSecretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterDeploymentSelector, kubeconfigSecretRef, additionalProperties);
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
    if (!(clusterDeploymentSelector == null)) {
        sb.append("clusterDeploymentSelector:");
        sb.append(clusterDeploymentSelector);
        sb.append(",");
    }
    if (!(kubeconfigSecretRef == null)) {
        sb.append("kubeconfigSecretRef:");
        sb.append(kubeconfigSecretRef);
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
  
  public A withClusterDeploymentSelector(LabelSelector clusterDeploymentSelector) {
    this._visitables.remove("clusterDeploymentSelector");
    if (clusterDeploymentSelector != null) {
        this.clusterDeploymentSelector = new LabelSelectorBuilder(clusterDeploymentSelector);
        this._visitables.get("clusterDeploymentSelector").add(this.clusterDeploymentSelector);
    } else {
        this.clusterDeploymentSelector = null;
        this._visitables.get("clusterDeploymentSelector").remove(this.clusterDeploymentSelector);
    }
    return (A) this;
  }
  
  public A withKubeconfigSecretRef(KubeconfigSecretReference kubeconfigSecretRef) {
    this._visitables.remove("kubeconfigSecretRef");
    if (kubeconfigSecretRef != null) {
        this.kubeconfigSecretRef = new KubeconfigSecretReferenceBuilder(kubeconfigSecretRef);
        this._visitables.get("kubeconfigSecretRef").add(this.kubeconfigSecretRef);
    } else {
        this.kubeconfigSecretRef = null;
        this._visitables.get("kubeconfigSecretRef").remove(this.kubeconfigSecretRef);
    }
    return (A) this;
  }
  
  public ClusterDeploymentSelectorNested<A> withNewClusterDeploymentSelector() {
    return new ClusterDeploymentSelectorNested(null);
  }
  
  public ClusterDeploymentSelectorNested<A> withNewClusterDeploymentSelectorLike(LabelSelector item) {
    return new ClusterDeploymentSelectorNested(item);
  }
  
  public KubeconfigSecretRefNested<A> withNewKubeconfigSecretRef() {
    return new KubeconfigSecretRefNested(null);
  }
  
  public A withNewKubeconfigSecretRef(String name,String namespace) {
    return (A) this.withKubeconfigSecretRef(new KubeconfigSecretReference(name, namespace));
  }
  
  public KubeconfigSecretRefNested<A> withNewKubeconfigSecretRefLike(KubeconfigSecretReference item) {
    return new KubeconfigSecretRefNested(item);
  }
  public class ClusterDeploymentSelectorNested<N> extends LabelSelectorFluent<ClusterDeploymentSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ClusterDeploymentSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterRelocateSpecFluent.this.withClusterDeploymentSelector(builder.build());
    }
    
    public N endClusterDeploymentSelector() {
      return and();
    }
    
  }
  public class KubeconfigSecretRefNested<N> extends KubeconfigSecretReferenceFluent<KubeconfigSecretRefNested<N>> implements Nested<N>{
  
    KubeconfigSecretReferenceBuilder builder;
  
    KubeconfigSecretRefNested(KubeconfigSecretReference item) {
      this.builder = new KubeconfigSecretReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterRelocateSpecFluent.this.withKubeconfigSecretRef(builder.build());
    }
    
    public N endKubeconfigSecretRef() {
      return and();
    }
    
  }
}