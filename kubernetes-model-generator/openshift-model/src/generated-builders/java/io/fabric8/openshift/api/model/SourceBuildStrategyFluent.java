package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.EnvVarFluent;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SourceBuildStrategyFluent<A extends io.fabric8.openshift.api.model.SourceBuildStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EnvVarBuilder> env = new ArrayList<EnvVarBuilder>();
  private Boolean forcePull;
  private ObjectReferenceBuilder from;
  private Boolean incremental;
  private LocalObjectReferenceBuilder pullSecret;
  private String scripts;
  private ArrayList<BuildVolumeBuilder> volumes = new ArrayList<BuildVolumeBuilder>();

  public SourceBuildStrategyFluent() {
  }
  
  public SourceBuildStrategyFluent(SourceBuildStrategy instance) {
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
  
  public A addAllToVolumes(Collection<BuildVolume> items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (BuildVolume item : items) {
        BuildVolumeBuilder builder = new BuildVolumeBuilder(item);
        _visitables.get("volumes").add(builder);
        this.volumes.add(builder);
    }
    return (A) this;
  }
  
  public EnvNested<A> addNewEnv() {
    return new EnvNested(-1, null);
  }
  
  public EnvNested<A> addNewEnvLike(EnvVar item) {
    return new EnvNested(-1, item);
  }
  
  public VolumesNested<A> addNewVolume() {
    return new VolumesNested(-1, null);
  }
  
  public VolumesNested<A> addNewVolumeLike(BuildVolume item) {
    return new VolumesNested(-1, item);
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
  
  public A addToVolumes(BuildVolume... items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (BuildVolume item : items) {
        BuildVolumeBuilder builder = new BuildVolumeBuilder(item);
        _visitables.get("volumes").add(builder);
        this.volumes.add(builder);
    }
    return (A) this;
  }
  
  public A addToVolumes(int index,BuildVolume item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    BuildVolumeBuilder builder = new BuildVolumeBuilder(item);
    if (index < 0 || index >= volumes.size()) {
        _visitables.get("volumes").add(builder);
        volumes.add(builder);
    } else {
        _visitables.get("volumes").add(builder);
        volumes.add(index, builder);
    }
    return (A) this;
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
  
  public BuildVolume buildFirstVolume() {
    return this.volumes.get(0).build();
  }
  
  public ObjectReference buildFrom() {
    return this.from != null ? this.from.build() : null;
  }
  
  public EnvVar buildLastEnv() {
    return this.env.get(env.size() - 1).build();
  }
  
  public BuildVolume buildLastVolume() {
    return this.volumes.get(volumes.size() - 1).build();
  }
  
  public EnvVar buildMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public BuildVolume buildMatchingVolume(Predicate<BuildVolumeBuilder> predicate) {
      for (BuildVolumeBuilder item : volumes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LocalObjectReference buildPullSecret() {
    return this.pullSecret != null ? this.pullSecret.build() : null;
  }
  
  public BuildVolume buildVolume(int index) {
    return this.volumes.get(index).build();
  }
  
  public List<BuildVolume> buildVolumes() {
    return this.volumes != null ? build(volumes) : null;
  }
  
  protected void copyInstance(SourceBuildStrategy instance) {
    instance = instance != null ? instance : new SourceBuildStrategy();
    if (instance != null) {
        this.withEnv(instance.getEnv());
        this.withForcePull(instance.getForcePull());
        this.withFrom(instance.getFrom());
        this.withIncremental(instance.getIncremental());
        this.withPullSecret(instance.getPullSecret());
        this.withScripts(instance.getScripts());
        this.withVolumes(instance.getVolumes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
  
  public VolumesNested<A> editFirstVolume() {
    if (volumes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(0, this.buildVolume(0));
  }
  
  public FromNested<A> editFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(null));
  }
  
  public EnvNested<A> editLastEnv() {
    int index = env.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public VolumesNested<A> editLastVolume() {
    int index = volumes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
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
  
  public VolumesNested<A> editMatchingVolume(Predicate<BuildVolumeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < volumes.size();i++) {
      if (predicate.test(volumes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
  }
  
  public FromNested<A> editOrNewFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public FromNested<A> editOrNewFromLike(ObjectReference item) {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(item));
  }
  
  public PullSecretNested<A> editOrNewPullSecret() {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public PullSecretNested<A> editOrNewPullSecretLike(LocalObjectReference item) {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(item));
  }
  
  public PullSecretNested<A> editPullSecret() {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(null));
  }
  
  public VolumesNested<A> editVolume(int index) {
    if (volumes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
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
    SourceBuildStrategyFluent that = (SourceBuildStrategyFluent) o;
    if (!(Objects.equals(env, that.env))) {
      return false;
    }
    if (!(Objects.equals(forcePull, that.forcePull))) {
      return false;
    }
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(incremental, that.incremental))) {
      return false;
    }
    if (!(Objects.equals(pullSecret, that.pullSecret))) {
      return false;
    }
    if (!(Objects.equals(scripts, that.scripts))) {
      return false;
    }
    if (!(Objects.equals(volumes, that.volumes))) {
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
  
  public Boolean getForcePull() {
    return this.forcePull;
  }
  
  public Boolean getIncremental() {
    return this.incremental;
  }
  
  public String getScripts() {
    return this.scripts;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnv() {
    return this.env != null && !(this.env.isEmpty());
  }
  
  public boolean hasForcePull() {
    return this.forcePull != null;
  }
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasIncremental() {
    return this.incremental != null;
  }
  
  public boolean hasMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolume(Predicate<BuildVolumeBuilder> predicate) {
      for (BuildVolumeBuilder item : volumes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPullSecret() {
    return this.pullSecret != null;
  }
  
  public boolean hasScripts() {
    return this.scripts != null;
  }
  
  public boolean hasVolumes() {
    return this.volumes != null && !(this.volumes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(env, forcePull, from, incremental, pullSecret, scripts, volumes, additionalProperties);
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
  
  public A removeAllFromVolumes(Collection<BuildVolume> items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (BuildVolume item : items) {
        BuildVolumeBuilder builder = new BuildVolumeBuilder(item);
        _visitables.get("volumes").remove(builder);
        this.volumes.remove(builder);
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
  
  public A removeFromVolumes(BuildVolume... items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (BuildVolume item : items) {
        BuildVolumeBuilder builder = new BuildVolumeBuilder(item);
        _visitables.get("volumes").remove(builder);
        this.volumes.remove(builder);
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
  
  public A removeMatchingFromVolumes(Predicate<BuildVolumeBuilder> predicate) {
    if (volumes == null) {
      return (A) this;
    }
    Iterator<BuildVolumeBuilder> each = volumes.iterator();
    List visitables = _visitables.get("volumes");
    while (each.hasNext()) {
        BuildVolumeBuilder builder = each.next();
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
  
  public VolumesNested<A> setNewVolumeLike(int index,BuildVolume item) {
    return new VolumesNested(index, item);
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
  
  public A setToVolumes(int index,BuildVolume item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    BuildVolumeBuilder builder = new BuildVolumeBuilder(item);
    if (index < 0 || index >= volumes.size()) {
        _visitables.get("volumes").add(builder);
        volumes.add(builder);
    } else {
        _visitables.get("volumes").add(builder);
        volumes.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(env == null) && !(env.isEmpty())) {
        sb.append("env:");
        sb.append(env);
        sb.append(",");
    }
    if (!(forcePull == null)) {
        sb.append("forcePull:");
        sb.append(forcePull);
        sb.append(",");
    }
    if (!(from == null)) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(incremental == null)) {
        sb.append("incremental:");
        sb.append(incremental);
        sb.append(",");
    }
    if (!(pullSecret == null)) {
        sb.append("pullSecret:");
        sb.append(pullSecret);
        sb.append(",");
    }
    if (!(scripts == null)) {
        sb.append("scripts:");
        sb.append(scripts);
        sb.append(",");
    }
    if (!(volumes == null) && !(volumes.isEmpty())) {
        sb.append("volumes:");
        sb.append(volumes);
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
  
  public A withForcePull() {
    return withForcePull(true);
  }
  
  public A withForcePull(Boolean forcePull) {
    this.forcePull = forcePull;
    return (A) this;
  }
  
  public A withFrom(ObjectReference from) {
    this._visitables.remove("from");
    if (from != null) {
        this.from = new ObjectReferenceBuilder(from);
        this._visitables.get("from").add(this.from);
    } else {
        this.from = null;
        this._visitables.get("from").remove(this.from);
    }
    return (A) this;
  }
  
  public A withIncremental() {
    return withIncremental(true);
  }
  
  public A withIncremental(Boolean incremental) {
    this.incremental = incremental;
    return (A) this;
  }
  
  public FromNested<A> withNewFrom() {
    return new FromNested(null);
  }
  
  public FromNested<A> withNewFromLike(ObjectReference item) {
    return new FromNested(item);
  }
  
  public PullSecretNested<A> withNewPullSecret() {
    return new PullSecretNested(null);
  }
  
  public A withNewPullSecret(String name) {
    return (A) this.withPullSecret(new LocalObjectReference(name));
  }
  
  public PullSecretNested<A> withNewPullSecretLike(LocalObjectReference item) {
    return new PullSecretNested(item);
  }
  
  public A withPullSecret(LocalObjectReference pullSecret) {
    this._visitables.remove("pullSecret");
    if (pullSecret != null) {
        this.pullSecret = new LocalObjectReferenceBuilder(pullSecret);
        this._visitables.get("pullSecret").add(this.pullSecret);
    } else {
        this.pullSecret = null;
        this._visitables.get("pullSecret").remove(this.pullSecret);
    }
    return (A) this;
  }
  
  public A withScripts(String scripts) {
    this.scripts = scripts;
    return (A) this;
  }
  
  public A withVolumes(List<BuildVolume> volumes) {
    if (this.volumes != null) {
      this._visitables.get("volumes").clear();
    }
    if (volumes != null) {
        this.volumes = new ArrayList();
        for (BuildVolume item : volumes) {
          this.addToVolumes(item);
        }
    } else {
      this.volumes = null;
    }
    return (A) this;
  }
  
  public A withVolumes(BuildVolume... volumes) {
    if (this.volumes != null) {
        this.volumes.clear();
        _visitables.remove("volumes");
    }
    if (volumes != null) {
      for (BuildVolume item : volumes) {
        this.addToVolumes(item);
      }
    }
    return (A) this;
  }
  public class EnvNested<N> extends EnvVarFluent<EnvNested<N>> implements Nested<N>{
  
    EnvVarBuilder builder;
    int index;
  
    EnvNested(int index,EnvVar item) {
      this.index = index;
      this.builder = new EnvVarBuilder(this, item);
    }
  
    public N and() {
      return (N) SourceBuildStrategyFluent.this.setToEnv(index, builder.build());
    }
    
    public N endEnv() {
      return and();
    }
    
  }
  public class FromNested<N> extends ObjectReferenceFluent<FromNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    FromNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SourceBuildStrategyFluent.this.withFrom(builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
  public class PullSecretNested<N> extends LocalObjectReferenceFluent<PullSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    PullSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SourceBuildStrategyFluent.this.withPullSecret(builder.build());
    }
    
    public N endPullSecret() {
      return and();
    }
    
  }
  public class VolumesNested<N> extends BuildVolumeFluent<VolumesNested<N>> implements Nested<N>{
  
    BuildVolumeBuilder builder;
    int index;
  
    VolumesNested(int index,BuildVolume item) {
      this.index = index;
      this.builder = new BuildVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) SourceBuildStrategyFluent.this.setToVolumes(index, builder.build());
    }
    
    public N endVolume() {
      return and();
    }
    
  }
}