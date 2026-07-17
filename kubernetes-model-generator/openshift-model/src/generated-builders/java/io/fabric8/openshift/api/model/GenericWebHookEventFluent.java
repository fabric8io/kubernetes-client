package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.EnvVarFluent;
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
public class GenericWebHookEventFluent<A extends io.fabric8.openshift.api.model.GenericWebHookEventFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DockerStrategyOptionsBuilder dockerStrategyOptions;
  private ArrayList<EnvVarBuilder> env = new ArrayList<EnvVarBuilder>();
  private GitInfoBuilder git;
  private String type;

  public GenericWebHookEventFluent() {
  }
  
  public GenericWebHookEventFluent(GenericWebHookEvent instance) {
    this.copyInstance(instance);
  }

  public A addAllToEnv(Collection<EnvVar> items) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").add(builder);
        this.env.add(builder);
    }
    return (A) this;
  }
  
  public EnvNested<A> addNewEnv() {
    return new EnvNested(-1, null);
  }
  
  public EnvNested<A> addNewEnvLike(EnvVar item) {
    return new EnvNested(-1, item);
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
  
  public A addToEnv(EnvVar... items) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").add(builder);
        this.env.add(builder);
    }
    return (A) this;
  }
  
  public A addToEnv(int index,EnvVar item) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= env.size()) {
        _visitables.get("env").add(builder);
        env.add(builder);
    } else {
        _visitables.get("env").add(builder);
        env.add(index, builder);
    }
    return (A) this;
  }
  
  public DockerStrategyOptions buildDockerStrategyOptions() {
    return this.dockerStrategyOptions != null ? this.dockerStrategyOptions.build() : null;
  }
  
  public List<EnvVar> buildEnv() {
    return this.env != null ? build(env) : null;
  }
  
  public EnvVar buildEnv(int index) {
    return this.env.get(index).build();
  }
  
  public EnvVar buildFirstEnv() {
    return this.env.get(0).build();
  }
  
  public GitInfo buildGit() {
    return this.git != null ? this.git.build() : null;
  }
  
  public EnvVar buildLastEnv() {
    return this.env.get(env.size() - 1).build();
  }
  
  public EnvVar buildMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(GenericWebHookEvent instance) {
    instance = instance != null ? instance : new GenericWebHookEvent();
    if (instance != null) {
        this.withDockerStrategyOptions(instance.getDockerStrategyOptions());
        this.withEnv(instance.getEnv());
        this.withGit(instance.getGit());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DockerStrategyOptionsNested<A> editDockerStrategyOptions() {
    return this.withNewDockerStrategyOptionsLike(Optional.ofNullable(this.buildDockerStrategyOptions()).orElse(null));
  }
  
  public EnvNested<A> editEnv(int index) {
    if (env.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public EnvNested<A> editFirstEnv() {
    if (env.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(0, this.buildEnv(0));
  }
  
  public GitNested<A> editGit() {
    return this.withNewGitLike(Optional.ofNullable(this.buildGit()).orElse(null));
  }
  
  public EnvNested<A> editLastEnv() {
    int index = env.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public EnvNested<A> editMatchingEnv(Predicate<EnvVarBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < env.size();i++) {
      if (predicate.test(env.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public DockerStrategyOptionsNested<A> editOrNewDockerStrategyOptions() {
    return this.withNewDockerStrategyOptionsLike(Optional.ofNullable(this.buildDockerStrategyOptions()).orElse(new DockerStrategyOptionsBuilder().build()));
  }
  
  public DockerStrategyOptionsNested<A> editOrNewDockerStrategyOptionsLike(DockerStrategyOptions item) {
    return this.withNewDockerStrategyOptionsLike(Optional.ofNullable(this.buildDockerStrategyOptions()).orElse(item));
  }
  
  public GitNested<A> editOrNewGit() {
    return this.withNewGitLike(Optional.ofNullable(this.buildGit()).orElse(new GitInfoBuilder().build()));
  }
  
  public GitNested<A> editOrNewGitLike(GitInfo item) {
    return this.withNewGitLike(Optional.ofNullable(this.buildGit()).orElse(item));
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
    GenericWebHookEventFluent that = (GenericWebHookEventFluent) o;
    if (!(Objects.equals(dockerStrategyOptions, that.dockerStrategyOptions))) {
      return false;
    }
    if (!(Objects.equals(env, that.env))) {
      return false;
    }
    if (!(Objects.equals(git, that.git))) {
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
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDockerStrategyOptions() {
    return this.dockerStrategyOptions != null;
  }
  
  public boolean hasEnv() {
    return this.env != null && !(this.env.isEmpty());
  }
  
  public boolean hasGit() {
    return this.git != null;
  }
  
  public boolean hasMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(dockerStrategyOptions, env, git, type, additionalProperties);
  }
  
  public A removeAllFromEnv(Collection<EnvVar> items) {
    if (this.env == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").remove(builder);
        this.env.remove(builder);
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
  
  public A removeFromEnv(EnvVar... items) {
    if (this.env == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").remove(builder);
        this.env.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEnv(Predicate<EnvVarBuilder> predicate) {
    if (env == null) {
      return (A) this;
    }
    Iterator<EnvVarBuilder> each = env.iterator();
    List visitables = _visitables.get("env");
    while (each.hasNext()) {
        EnvVarBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EnvNested<A> setNewEnvLike(int index,EnvVar item) {
    return new EnvNested(index, item);
  }
  
  public A setToEnv(int index,EnvVar item) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= env.size()) {
        _visitables.get("env").add(builder);
        env.add(builder);
    } else {
        _visitables.get("env").add(builder);
        env.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dockerStrategyOptions == null)) {
        sb.append("dockerStrategyOptions:");
        sb.append(dockerStrategyOptions);
        sb.append(",");
    }
    if (!(env == null) && !(env.isEmpty())) {
        sb.append("env:");
        sb.append(env);
        sb.append(",");
    }
    if (!(git == null)) {
        sb.append("git:");
        sb.append(git);
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
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withDockerStrategyOptions(DockerStrategyOptions dockerStrategyOptions) {
    this._visitables.remove("dockerStrategyOptions");
    if (dockerStrategyOptions != null) {
        this.dockerStrategyOptions = new DockerStrategyOptionsBuilder(dockerStrategyOptions);
        this._visitables.get("dockerStrategyOptions").add(this.dockerStrategyOptions);
    } else {
        this.dockerStrategyOptions = null;
        this._visitables.get("dockerStrategyOptions").remove(this.dockerStrategyOptions);
    }
    return (A) this;
  }
  
  public A withEnv(List<EnvVar> env) {
    if (this.env != null) {
      this._visitables.get("env").clear();
    }
    if (env != null) {
        this.env = new ArrayList();
        for (EnvVar item : env) {
          this.addToEnv(item);
        }
    } else {
      this.env = null;
    }
    return (A) this;
  }
  
  public A withEnv(EnvVar... env) {
    if (this.env != null) {
        this.env.clear();
        _visitables.remove("env");
    }
    if (env != null) {
      for (EnvVar item : env) {
        this.addToEnv(item);
      }
    }
    return (A) this;
  }
  
  public A withGit(GitInfo git) {
    this._visitables.remove("git");
    if (git != null) {
        this.git = new GitInfoBuilder(git);
        this._visitables.get("git").add(this.git);
    } else {
        this.git = null;
        this._visitables.get("git").remove(this.git);
    }
    return (A) this;
  }
  
  public DockerStrategyOptionsNested<A> withNewDockerStrategyOptions() {
    return new DockerStrategyOptionsNested(null);
  }
  
  public DockerStrategyOptionsNested<A> withNewDockerStrategyOptionsLike(DockerStrategyOptions item) {
    return new DockerStrategyOptionsNested(item);
  }
  
  public GitNested<A> withNewGit() {
    return new GitNested(null);
  }
  
  public GitNested<A> withNewGitLike(GitInfo item) {
    return new GitNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class DockerStrategyOptionsNested<N> extends DockerStrategyOptionsFluent<DockerStrategyOptionsNested<N>> implements Nested<N>{
  
    DockerStrategyOptionsBuilder builder;
  
    DockerStrategyOptionsNested(DockerStrategyOptions item) {
      this.builder = new DockerStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericWebHookEventFluent.this.withDockerStrategyOptions(builder.build());
    }
    
    public N endDockerStrategyOptions() {
      return and();
    }
    
  }
  public class EnvNested<N> extends EnvVarFluent<EnvNested<N>> implements Nested<N>{
  
    EnvVarBuilder builder;
    int index;
  
    EnvNested(int index,EnvVar item) {
      this.index = index;
      this.builder = new EnvVarBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericWebHookEventFluent.this.setToEnv(index, builder.build());
    }
    
    public N endEnv() {
      return and();
    }
    
  }
  public class GitNested<N> extends GitInfoFluent<GitNested<N>> implements Nested<N>{
  
    GitInfoBuilder builder;
  
    GitNested(GitInfo item) {
      this.builder = new GitInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericWebHookEventFluent.this.withGit(builder.build());
    }
    
    public N endGit() {
      return and();
    }
    
  }
}