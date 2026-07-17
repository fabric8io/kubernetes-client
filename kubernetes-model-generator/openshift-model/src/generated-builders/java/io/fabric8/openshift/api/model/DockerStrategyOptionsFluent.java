package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.EnvVarFluent;
import java.lang.Boolean;
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
public class DockerStrategyOptionsFluent<A extends io.fabric8.openshift.api.model.DockerStrategyOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EnvVarBuilder> buildArgs = new ArrayList<EnvVarBuilder>();
  private Boolean noCache;

  public DockerStrategyOptionsFluent() {
  }
  
  public DockerStrategyOptionsFluent(DockerStrategyOptions instance) {
    this.copyInstance(instance);
  }

  public A addAllToBuildArgs(Collection<EnvVar> items) {
    if (this.buildArgs == null) {
      this.buildArgs = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("buildArgs").add(builder);
        this.buildArgs.add(builder);
    }
    return (A) this;
  }
  
  public BuildArgsNested<A> addNewBuildArg() {
    return new BuildArgsNested(-1, null);
  }
  
  public BuildArgsNested<A> addNewBuildArgLike(EnvVar item) {
    return new BuildArgsNested(-1, item);
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
  
  public A addToBuildArgs(EnvVar... items) {
    if (this.buildArgs == null) {
      this.buildArgs = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("buildArgs").add(builder);
        this.buildArgs.add(builder);
    }
    return (A) this;
  }
  
  public A addToBuildArgs(int index,EnvVar item) {
    if (this.buildArgs == null) {
      this.buildArgs = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= buildArgs.size()) {
        _visitables.get("buildArgs").add(builder);
        buildArgs.add(builder);
    } else {
        _visitables.get("buildArgs").add(builder);
        buildArgs.add(index, builder);
    }
    return (A) this;
  }
  
  public EnvVar buildBuildArg(int index) {
    return this.buildArgs.get(index).build();
  }
  
  public List<EnvVar> buildBuildArgs() {
    return this.buildArgs != null ? build(buildArgs) : null;
  }
  
  public EnvVar buildFirstBuildArg() {
    return this.buildArgs.get(0).build();
  }
  
  public EnvVar buildLastBuildArg() {
    return this.buildArgs.get(buildArgs.size() - 1).build();
  }
  
  public EnvVar buildMatchingBuildArg(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : buildArgs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(DockerStrategyOptions instance) {
    instance = instance != null ? instance : new DockerStrategyOptions();
    if (instance != null) {
        this.withBuildArgs(instance.getBuildArgs());
        this.withNoCache(instance.getNoCache());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BuildArgsNested<A> editBuildArg(int index) {
    if (buildArgs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "buildArgs"));
    }
    return this.setNewBuildArgLike(index, this.buildBuildArg(index));
  }
  
  public BuildArgsNested<A> editFirstBuildArg() {
    if (buildArgs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "buildArgs"));
    }
    return this.setNewBuildArgLike(0, this.buildBuildArg(0));
  }
  
  public BuildArgsNested<A> editLastBuildArg() {
    int index = buildArgs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "buildArgs"));
    }
    return this.setNewBuildArgLike(index, this.buildBuildArg(index));
  }
  
  public BuildArgsNested<A> editMatchingBuildArg(Predicate<EnvVarBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < buildArgs.size();i++) {
      if (predicate.test(buildArgs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "buildArgs"));
    }
    return this.setNewBuildArgLike(index, this.buildBuildArg(index));
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
    DockerStrategyOptionsFluent that = (DockerStrategyOptionsFluent) o;
    if (!(Objects.equals(buildArgs, that.buildArgs))) {
      return false;
    }
    if (!(Objects.equals(noCache, that.noCache))) {
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
  
  public Boolean getNoCache() {
    return this.noCache;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBuildArgs() {
    return this.buildArgs != null && !(this.buildArgs.isEmpty());
  }
  
  public boolean hasMatchingBuildArg(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : buildArgs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNoCache() {
    return this.noCache != null;
  }
  
  public int hashCode() {
    return Objects.hash(buildArgs, noCache, additionalProperties);
  }
  
  public A removeAllFromBuildArgs(Collection<EnvVar> items) {
    if (this.buildArgs == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("buildArgs").remove(builder);
        this.buildArgs.remove(builder);
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
  
  public A removeFromBuildArgs(EnvVar... items) {
    if (this.buildArgs == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("buildArgs").remove(builder);
        this.buildArgs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromBuildArgs(Predicate<EnvVarBuilder> predicate) {
    if (buildArgs == null) {
      return (A) this;
    }
    Iterator<EnvVarBuilder> each = buildArgs.iterator();
    List visitables = _visitables.get("buildArgs");
    while (each.hasNext()) {
        EnvVarBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public BuildArgsNested<A> setNewBuildArgLike(int index,EnvVar item) {
    return new BuildArgsNested(index, item);
  }
  
  public A setToBuildArgs(int index,EnvVar item) {
    if (this.buildArgs == null) {
      this.buildArgs = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= buildArgs.size()) {
        _visitables.get("buildArgs").add(builder);
        buildArgs.add(builder);
    } else {
        _visitables.get("buildArgs").add(builder);
        buildArgs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(buildArgs == null) && !(buildArgs.isEmpty())) {
        sb.append("buildArgs:");
        sb.append(buildArgs);
        sb.append(",");
    }
    if (!(noCache == null)) {
        sb.append("noCache:");
        sb.append(noCache);
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
  
  public A withBuildArgs(List<EnvVar> buildArgs) {
    if (this.buildArgs != null) {
      this._visitables.get("buildArgs").clear();
    }
    if (buildArgs != null) {
        this.buildArgs = new ArrayList();
        for (EnvVar item : buildArgs) {
          this.addToBuildArgs(item);
        }
    } else {
      this.buildArgs = null;
    }
    return (A) this;
  }
  
  public A withBuildArgs(EnvVar... buildArgs) {
    if (this.buildArgs != null) {
        this.buildArgs.clear();
        _visitables.remove("buildArgs");
    }
    if (buildArgs != null) {
      for (EnvVar item : buildArgs) {
        this.addToBuildArgs(item);
      }
    }
    return (A) this;
  }
  
  public A withNoCache() {
    return withNoCache(true);
  }
  
  public A withNoCache(Boolean noCache) {
    this.noCache = noCache;
    return (A) this;
  }
  public class BuildArgsNested<N> extends EnvVarFluent<BuildArgsNested<N>> implements Nested<N>{
  
    EnvVarBuilder builder;
    int index;
  
    BuildArgsNested(int index,EnvVar item) {
      this.index = index;
      this.builder = new EnvVarBuilder(this, item);
    }
  
    public N and() {
      return (N) DockerStrategyOptionsFluent.this.setToBuildArgs(index, builder.build());
    }
    
    public N endBuildArg() {
      return and();
    }
    
  }
}