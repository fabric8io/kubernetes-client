package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import java.lang.Integer;
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
public class AlertmanagerSpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.AlertmanagerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer replicas;
  private ResourceRequirementsBuilder resources;
  private List<String> secrets = new ArrayList<String>();

  public AlertmanagerSpecFluent() {
  }
  
  public AlertmanagerSpecFluent(AlertmanagerSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToSecrets(Collection<String> items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (String item : items) {
      this.secrets.add(item);
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
  
  public A addToSecrets(String... items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (String item : items) {
      this.secrets.add(item);
    }
    return (A) this;
  }
  
  public A addToSecrets(int index,String item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    this.secrets.add(index, item);
    return (A) this;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  protected void copyInstance(AlertmanagerSpec instance) {
    instance = instance != null ? instance : new AlertmanagerSpec();
    if (instance != null) {
        this.withReplicas(instance.getReplicas());
        this.withResources(instance.getResources());
        this.withSecrets(instance.getSecrets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
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
    AlertmanagerSpecFluent that = (AlertmanagerSpecFluent) o;
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(secrets, that.secrets))) {
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
  
  public String getFirstSecret() {
    return this.secrets.get(0);
  }
  
  public String getLastSecret() {
    return this.secrets.get(secrets.size() - 1);
  }
  
  public String getMatchingSecret(Predicate<String> predicate) {
      for (String item : secrets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public String getSecret(int index) {
    return this.secrets.get(index);
  }
  
  public List<String> getSecrets() {
    return this.secrets;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingSecret(Predicate<String> predicate) {
      for (String item : secrets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasSecrets() {
    return this.secrets != null && !(this.secrets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(replicas, resources, secrets, additionalProperties);
  }
  
  public A removeAllFromSecrets(Collection<String> items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.secrets.remove(item);
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
  
  public A removeFromSecrets(String... items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.secrets.remove(item);
    }
    return (A) this;
  }
  
  public A setToSecrets(int index,String item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    this.secrets.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(secrets == null) && !(secrets.isEmpty())) {
        sb.append("secrets:");
        sb.append(secrets);
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
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withResources(ResourceRequirements resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new ResourceRequirementsBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withSecrets(List<String> secrets) {
    if (secrets != null) {
        this.secrets = new ArrayList();
        for (String item : secrets) {
          this.addToSecrets(item);
        }
    } else {
      this.secrets = null;
    }
    return (A) this;
  }
  
  public A withSecrets(String... secrets) {
    if (this.secrets != null) {
        this.secrets.clear();
        _visitables.remove("secrets");
    }
    if (secrets != null) {
      for (String item : secrets) {
        this.addToSecrets(item);
      }
    }
    return (A) this;
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
}