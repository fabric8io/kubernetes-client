package io.fabric8.openclustermanagement.api.model.shared;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import java.lang.Boolean;
import java.lang.Integer;
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
public class ObservabilityAddonSpecFluent<A extends io.fabric8.openclustermanagement.api.model.shared.ObservabilityAddonSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean enableMetrics;
  private Integer interval;
  private ResourceRequirementsBuilder resources;
  private Integer scrapeSizeLimitBytes;
  private Integer workers;

  public ObservabilityAddonSpecFluent() {
  }
  
  public ObservabilityAddonSpecFluent(ObservabilityAddonSpec instance) {
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
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  protected void copyInstance(ObservabilityAddonSpec instance) {
    instance = instance != null ? instance : new ObservabilityAddonSpec();
    if (instance != null) {
        this.withEnableMetrics(instance.getEnableMetrics());
        this.withInterval(instance.getInterval());
        this.withResources(instance.getResources());
        this.withScrapeSizeLimitBytes(instance.getScrapeSizeLimitBytes());
        this.withWorkers(instance.getWorkers());
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
    ObservabilityAddonSpecFluent that = (ObservabilityAddonSpecFluent) o;
    if (!(Objects.equals(enableMetrics, that.enableMetrics))) {
      return false;
    }
    if (!(Objects.equals(interval, that.interval))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(scrapeSizeLimitBytes, that.scrapeSizeLimitBytes))) {
      return false;
    }
    if (!(Objects.equals(workers, that.workers))) {
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
  
  public Boolean getEnableMetrics() {
    return this.enableMetrics;
  }
  
  public Integer getInterval() {
    return this.interval;
  }
  
  public Integer getScrapeSizeLimitBytes() {
    return this.scrapeSizeLimitBytes;
  }
  
  public Integer getWorkers() {
    return this.workers;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnableMetrics() {
    return this.enableMetrics != null;
  }
  
  public boolean hasInterval() {
    return this.interval != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasScrapeSizeLimitBytes() {
    return this.scrapeSizeLimitBytes != null;
  }
  
  public boolean hasWorkers() {
    return this.workers != null;
  }
  
  public int hashCode() {
    return Objects.hash(enableMetrics, interval, resources, scrapeSizeLimitBytes, workers, additionalProperties);
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
    if (!(enableMetrics == null)) {
        sb.append("enableMetrics:");
        sb.append(enableMetrics);
        sb.append(",");
    }
    if (!(interval == null)) {
        sb.append("interval:");
        sb.append(interval);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(scrapeSizeLimitBytes == null)) {
        sb.append("scrapeSizeLimitBytes:");
        sb.append(scrapeSizeLimitBytes);
        sb.append(",");
    }
    if (!(workers == null)) {
        sb.append("workers:");
        sb.append(workers);
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
  
  public A withEnableMetrics() {
    return withEnableMetrics(true);
  }
  
  public A withEnableMetrics(Boolean enableMetrics) {
    this.enableMetrics = enableMetrics;
    return (A) this;
  }
  
  public A withInterval(Integer interval) {
    this.interval = interval;
    return (A) this;
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
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
  
  public A withScrapeSizeLimitBytes(Integer scrapeSizeLimitBytes) {
    this.scrapeSizeLimitBytes = scrapeSizeLimitBytes;
    return (A) this;
  }
  
  public A withWorkers(Integer workers) {
    this.workers = workers;
    return (A) this;
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) ObservabilityAddonSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
}