package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.EnvVarFluent;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import java.lang.Integer;
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
public class DeploymentConfigFluent<A extends io.fabric8.openclustermanagement.api.model.search.v1alpha1.DeploymentConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> arguments = new ArrayList<String>();
  private ArrayList<EnvVarBuilder> envVar = new ArrayList<EnvVarBuilder>();
  private String imageOverride;
  private Integer replicaCount;
  private ResourceRequirementsBuilder resources;

  public DeploymentConfigFluent() {
  }
  
  public DeploymentConfigFluent(DeploymentConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToArguments(Collection<String> items) {
    if (this.arguments == null) {
      this.arguments = new ArrayList();
    }
    for (String item : items) {
      this.arguments.add(item);
    }
    return (A) this;
  }
  
  public A addAllToEnvVar(Collection<EnvVar> items) {
    if (this.envVar == null) {
      this.envVar = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("envVar").add(builder);
        this.envVar.add(builder);
    }
    return (A) this;
  }
  
  public EnvVarNested<A> addNewEnvVar() {
    return new EnvVarNested(-1, null);
  }
  
  public EnvVarNested<A> addNewEnvVarLike(EnvVar item) {
    return new EnvVarNested(-1, item);
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
  
  public A addToArguments(String... items) {
    if (this.arguments == null) {
      this.arguments = new ArrayList();
    }
    for (String item : items) {
      this.arguments.add(item);
    }
    return (A) this;
  }
  
  public A addToArguments(int index,String item) {
    if (this.arguments == null) {
      this.arguments = new ArrayList();
    }
    this.arguments.add(index, item);
    return (A) this;
  }
  
  public A addToEnvVar(EnvVar... items) {
    if (this.envVar == null) {
      this.envVar = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("envVar").add(builder);
        this.envVar.add(builder);
    }
    return (A) this;
  }
  
  public A addToEnvVar(int index,EnvVar item) {
    if (this.envVar == null) {
      this.envVar = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= envVar.size()) {
        _visitables.get("envVar").add(builder);
        envVar.add(builder);
    } else {
        _visitables.get("envVar").add(builder);
        envVar.add(index, builder);
    }
    return (A) this;
  }
  
  public List<EnvVar> buildEnvVar() {
    return this.envVar != null ? build(envVar) : null;
  }
  
  public EnvVar buildEnvVar(int index) {
    return this.envVar.get(index).build();
  }
  
  public EnvVar buildFirstEnvVar() {
    return this.envVar.get(0).build();
  }
  
  public EnvVar buildLastEnvVar() {
    return this.envVar.get(envVar.size() - 1).build();
  }
  
  public EnvVar buildMatchingEnvVar(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : envVar) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  protected void copyInstance(DeploymentConfig instance) {
    instance = instance != null ? instance : new DeploymentConfig();
    if (instance != null) {
        this.withArguments(instance.getArguments());
        this.withEnvVar(instance.getEnvVar());
        this.withImageOverride(instance.getImageOverride());
        this.withReplicaCount(instance.getReplicaCount());
        this.withResources(instance.getResources());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EnvVarNested<A> editEnvVar(int index) {
    if (envVar.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "envVar"));
    }
    return this.setNewEnvVarLike(index, this.buildEnvVar(index));
  }
  
  public EnvVarNested<A> editFirstEnvVar() {
    if (envVar.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "envVar"));
    }
    return this.setNewEnvVarLike(0, this.buildEnvVar(0));
  }
  
  public EnvVarNested<A> editLastEnvVar() {
    int index = envVar.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "envVar"));
    }
    return this.setNewEnvVarLike(index, this.buildEnvVar(index));
  }
  
  public EnvVarNested<A> editMatchingEnvVar(Predicate<EnvVarBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < envVar.size();i++) {
      if (predicate.test(envVar.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "envVar"));
    }
    return this.setNewEnvVarLike(index, this.buildEnvVar(index));
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
    DeploymentConfigFluent that = (DeploymentConfigFluent) o;
    if (!(Objects.equals(arguments, that.arguments))) {
      return false;
    }
    if (!(Objects.equals(envVar, that.envVar))) {
      return false;
    }
    if (!(Objects.equals(imageOverride, that.imageOverride))) {
      return false;
    }
    if (!(Objects.equals(replicaCount, that.replicaCount))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
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
  
  public String getArgument(int index) {
    return this.arguments.get(index);
  }
  
  public List<String> getArguments() {
    return this.arguments;
  }
  
  public String getFirstArgument() {
    return this.arguments.get(0);
  }
  
  public String getImageOverride() {
    return this.imageOverride;
  }
  
  public String getLastArgument() {
    return this.arguments.get(arguments.size() - 1);
  }
  
  public String getMatchingArgument(Predicate<String> predicate) {
      for (String item : arguments) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getReplicaCount() {
    return this.replicaCount;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArguments() {
    return this.arguments != null && !(this.arguments.isEmpty());
  }
  
  public boolean hasEnvVar() {
    return this.envVar != null && !(this.envVar.isEmpty());
  }
  
  public boolean hasImageOverride() {
    return this.imageOverride != null;
  }
  
  public boolean hasMatchingArgument(Predicate<String> predicate) {
      for (String item : arguments) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEnvVar(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : envVar) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReplicaCount() {
    return this.replicaCount != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public int hashCode() {
    return Objects.hash(arguments, envVar, imageOverride, replicaCount, resources, additionalProperties);
  }
  
  public A removeAllFromArguments(Collection<String> items) {
    if (this.arguments == null) {
      return (A) this;
    }
    for (String item : items) {
      this.arguments.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromEnvVar(Collection<EnvVar> items) {
    if (this.envVar == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("envVar").remove(builder);
        this.envVar.remove(builder);
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
  
  public A removeFromArguments(String... items) {
    if (this.arguments == null) {
      return (A) this;
    }
    for (String item : items) {
      this.arguments.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromEnvVar(EnvVar... items) {
    if (this.envVar == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("envVar").remove(builder);
        this.envVar.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEnvVar(Predicate<EnvVarBuilder> predicate) {
    if (envVar == null) {
      return (A) this;
    }
    Iterator<EnvVarBuilder> each = envVar.iterator();
    List visitables = _visitables.get("envVar");
    while (each.hasNext()) {
        EnvVarBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EnvVarNested<A> setNewEnvVarLike(int index,EnvVar item) {
    return new EnvVarNested(index, item);
  }
  
  public A setToArguments(int index,String item) {
    if (this.arguments == null) {
      this.arguments = new ArrayList();
    }
    this.arguments.set(index, item);
    return (A) this;
  }
  
  public A setToEnvVar(int index,EnvVar item) {
    if (this.envVar == null) {
      this.envVar = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= envVar.size()) {
        _visitables.get("envVar").add(builder);
        envVar.add(builder);
    } else {
        _visitables.get("envVar").add(builder);
        envVar.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(arguments == null) && !(arguments.isEmpty())) {
        sb.append("arguments:");
        sb.append(arguments);
        sb.append(",");
    }
    if (!(envVar == null) && !(envVar.isEmpty())) {
        sb.append("envVar:");
        sb.append(envVar);
        sb.append(",");
    }
    if (!(imageOverride == null)) {
        sb.append("imageOverride:");
        sb.append(imageOverride);
        sb.append(",");
    }
    if (!(replicaCount == null)) {
        sb.append("replicaCount:");
        sb.append(replicaCount);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
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
  
  public A withArguments(List<String> arguments) {
    if (arguments != null) {
        this.arguments = new ArrayList();
        for (String item : arguments) {
          this.addToArguments(item);
        }
    } else {
      this.arguments = null;
    }
    return (A) this;
  }
  
  public A withArguments(String... arguments) {
    if (this.arguments != null) {
        this.arguments.clear();
        _visitables.remove("arguments");
    }
    if (arguments != null) {
      for (String item : arguments) {
        this.addToArguments(item);
      }
    }
    return (A) this;
  }
  
  public A withEnvVar(List<EnvVar> envVar) {
    if (this.envVar != null) {
      this._visitables.get("envVar").clear();
    }
    if (envVar != null) {
        this.envVar = new ArrayList();
        for (EnvVar item : envVar) {
          this.addToEnvVar(item);
        }
    } else {
      this.envVar = null;
    }
    return (A) this;
  }
  
  public A withEnvVar(EnvVar... envVar) {
    if (this.envVar != null) {
        this.envVar.clear();
        _visitables.remove("envVar");
    }
    if (envVar != null) {
      for (EnvVar item : envVar) {
        this.addToEnvVar(item);
      }
    }
    return (A) this;
  }
  
  public A withImageOverride(String imageOverride) {
    this.imageOverride = imageOverride;
    return (A) this;
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public A withReplicaCount(Integer replicaCount) {
    this.replicaCount = replicaCount;
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
  public class EnvVarNested<N> extends EnvVarFluent<EnvVarNested<N>> implements Nested<N>{
  
    EnvVarBuilder builder;
    int index;
  
    EnvVarNested(int index,EnvVar item) {
      this.index = index;
      this.builder = new EnvVarBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentConfigFluent.this.setToEnvVar(index, builder.build());
    }
    
    public N endEnvVar() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentConfigFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
}