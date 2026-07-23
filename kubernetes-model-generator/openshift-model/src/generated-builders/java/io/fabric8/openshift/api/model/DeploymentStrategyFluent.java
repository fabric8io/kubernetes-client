package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import java.lang.Long;
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
public class DeploymentStrategyFluent<A extends io.fabric8.openshift.api.model.DeploymentStrategyFluent<A>> extends BaseFluent<A>{

  private Long activeDeadlineSeconds;
  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private CustomDeploymentStrategyParamsBuilder customParams;
  private Map<String,String> labels;
  private RecreateDeploymentStrategyParamsBuilder recreateParams;
  private ResourceRequirementsBuilder resources;
  private RollingDeploymentStrategyParamsBuilder rollingParams;
  private String type;

  public DeploymentStrategyFluent() {
  }
  
  public DeploymentStrategyFluent(DeploymentStrategy instance) {
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
  
  public A addToAnnotations(Map<String,String> map) {
    if (this.annotations == null && map != null) {
      this.annotations = new LinkedHashMap();
    }
    if (map != null) {
      this.annotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAnnotations(String key,String value) {
    if (this.annotations == null && key != null && value != null) {
      this.annotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.annotations.put(key, value);
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
  
  public CustomDeploymentStrategyParams buildCustomParams() {
    return this.customParams != null ? this.customParams.build() : null;
  }
  
  public RecreateDeploymentStrategyParams buildRecreateParams() {
    return this.recreateParams != null ? this.recreateParams.build() : null;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public RollingDeploymentStrategyParams buildRollingParams() {
    return this.rollingParams != null ? this.rollingParams.build() : null;
  }
  
  protected void copyInstance(DeploymentStrategy instance) {
    instance = instance != null ? instance : new DeploymentStrategy();
    if (instance != null) {
        this.withActiveDeadlineSeconds(instance.getActiveDeadlineSeconds());
        this.withAnnotations(instance.getAnnotations());
        this.withCustomParams(instance.getCustomParams());
        this.withLabels(instance.getLabels());
        this.withRecreateParams(instance.getRecreateParams());
        this.withResources(instance.getResources());
        this.withRollingParams(instance.getRollingParams());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomParamsNested<A> editCustomParams() {
    return this.withNewCustomParamsLike(Optional.ofNullable(this.buildCustomParams()).orElse(null));
  }
  
  public CustomParamsNested<A> editOrNewCustomParams() {
    return this.withNewCustomParamsLike(Optional.ofNullable(this.buildCustomParams()).orElse(new CustomDeploymentStrategyParamsBuilder().build()));
  }
  
  public CustomParamsNested<A> editOrNewCustomParamsLike(CustomDeploymentStrategyParams item) {
    return this.withNewCustomParamsLike(Optional.ofNullable(this.buildCustomParams()).orElse(item));
  }
  
  public RecreateParamsNested<A> editOrNewRecreateParams() {
    return this.withNewRecreateParamsLike(Optional.ofNullable(this.buildRecreateParams()).orElse(new RecreateDeploymentStrategyParamsBuilder().build()));
  }
  
  public RecreateParamsNested<A> editOrNewRecreateParamsLike(RecreateDeploymentStrategyParams item) {
    return this.withNewRecreateParamsLike(Optional.ofNullable(this.buildRecreateParams()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public RollingParamsNested<A> editOrNewRollingParams() {
    return this.withNewRollingParamsLike(Optional.ofNullable(this.buildRollingParams()).orElse(new RollingDeploymentStrategyParamsBuilder().build()));
  }
  
  public RollingParamsNested<A> editOrNewRollingParamsLike(RollingDeploymentStrategyParams item) {
    return this.withNewRollingParamsLike(Optional.ofNullable(this.buildRollingParams()).orElse(item));
  }
  
  public RecreateParamsNested<A> editRecreateParams() {
    return this.withNewRecreateParamsLike(Optional.ofNullable(this.buildRecreateParams()).orElse(null));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public RollingParamsNested<A> editRollingParams() {
    return this.withNewRollingParamsLike(Optional.ofNullable(this.buildRollingParams()).orElse(null));
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
    DeploymentStrategyFluent that = (DeploymentStrategyFluent) o;
    if (!(Objects.equals(activeDeadlineSeconds, that.activeDeadlineSeconds))) {
      return false;
    }
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(customParams, that.customParams))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(recreateParams, that.recreateParams))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(rollingParams, that.rollingParams))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Long getActiveDeadlineSeconds() {
    return this.activeDeadlineSeconds;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Map<String,String> getAnnotations() {
    return this.annotations;
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasActiveDeadlineSeconds() {
    return this.activeDeadlineSeconds != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasCustomParams() {
    return this.customParams != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasRecreateParams() {
    return this.recreateParams != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasRollingParams() {
    return this.rollingParams != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(activeDeadlineSeconds, annotations, customParams, labels, recreateParams, resources, rollingParams, type, additionalProperties);
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
  
  public A removeFromAnnotations(String key) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (key != null && this.annotations != null) {
      this.annotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAnnotations(Map<String,String> map) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.annotations != null) {
          this.annotations.remove(key);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(activeDeadlineSeconds == null)) {
        sb.append("activeDeadlineSeconds:");
        sb.append(activeDeadlineSeconds);
        sb.append(",");
    }
    if (!(annotations == null) && !(annotations.isEmpty())) {
        sb.append("annotations:");
        sb.append(annotations);
        sb.append(",");
    }
    if (!(customParams == null)) {
        sb.append("customParams:");
        sb.append(customParams);
        sb.append(",");
    }
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(recreateParams == null)) {
        sb.append("recreateParams:");
        sb.append(recreateParams);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(rollingParams == null)) {
        sb.append("rollingParams:");
        sb.append(rollingParams);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActiveDeadlineSeconds(Long activeDeadlineSeconds) {
    this.activeDeadlineSeconds = activeDeadlineSeconds;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public <K,V>A withAnnotations(Map<String,String> annotations) {
    if (annotations == null) {
      this.annotations = null;
    } else {
      this.annotations = new LinkedHashMap(annotations);
    }
    return (A) this;
  }
  
  public A withCustomParams(CustomDeploymentStrategyParams customParams) {
    this._visitables.remove("customParams");
    if (customParams != null) {
        this.customParams = new CustomDeploymentStrategyParamsBuilder(customParams);
        this._visitables.get("customParams").add(this.customParams);
    } else {
        this.customParams = null;
        this._visitables.get("customParams").remove(this.customParams);
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
  
  public CustomParamsNested<A> withNewCustomParams() {
    return new CustomParamsNested(null);
  }
  
  public CustomParamsNested<A> withNewCustomParamsLike(CustomDeploymentStrategyParams item) {
    return new CustomParamsNested(item);
  }
  
  public RecreateParamsNested<A> withNewRecreateParams() {
    return new RecreateParamsNested(null);
  }
  
  public RecreateParamsNested<A> withNewRecreateParamsLike(RecreateDeploymentStrategyParams item) {
    return new RecreateParamsNested(item);
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public RollingParamsNested<A> withNewRollingParams() {
    return new RollingParamsNested(null);
  }
  
  public RollingParamsNested<A> withNewRollingParamsLike(RollingDeploymentStrategyParams item) {
    return new RollingParamsNested(item);
  }
  
  public A withRecreateParams(RecreateDeploymentStrategyParams recreateParams) {
    this._visitables.remove("recreateParams");
    if (recreateParams != null) {
        this.recreateParams = new RecreateDeploymentStrategyParamsBuilder(recreateParams);
        this._visitables.get("recreateParams").add(this.recreateParams);
    } else {
        this.recreateParams = null;
        this._visitables.get("recreateParams").remove(this.recreateParams);
    }
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
  
  public A withRollingParams(RollingDeploymentStrategyParams rollingParams) {
    this._visitables.remove("rollingParams");
    if (rollingParams != null) {
        this.rollingParams = new RollingDeploymentStrategyParamsBuilder(rollingParams);
        this._visitables.get("rollingParams").add(this.rollingParams);
    } else {
        this.rollingParams = null;
        this._visitables.get("rollingParams").remove(this.rollingParams);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class CustomParamsNested<N> extends CustomDeploymentStrategyParamsFluent<CustomParamsNested<N>> implements Nested<N>{
  
    CustomDeploymentStrategyParamsBuilder builder;
  
    CustomParamsNested(CustomDeploymentStrategyParams item) {
      this.builder = new CustomDeploymentStrategyParamsBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentStrategyFluent.this.withCustomParams(builder.build());
    }
    
    public N endCustomParams() {
      return and();
    }
    
  }
  public class RecreateParamsNested<N> extends RecreateDeploymentStrategyParamsFluent<RecreateParamsNested<N>> implements Nested<N>{
  
    RecreateDeploymentStrategyParamsBuilder builder;
  
    RecreateParamsNested(RecreateDeploymentStrategyParams item) {
      this.builder = new RecreateDeploymentStrategyParamsBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentStrategyFluent.this.withRecreateParams(builder.build());
    }
    
    public N endRecreateParams() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentStrategyFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class RollingParamsNested<N> extends RollingDeploymentStrategyParamsFluent<RollingParamsNested<N>> implements Nested<N>{
  
    RollingDeploymentStrategyParamsBuilder builder;
  
    RollingParamsNested(RollingDeploymentStrategyParams item) {
      this.builder = new RollingDeploymentStrategyParamsBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentStrategyFluent.this.withRollingParams(builder.build());
    }
    
    public N endRollingParams() {
      return and();
    }
    
  }
}