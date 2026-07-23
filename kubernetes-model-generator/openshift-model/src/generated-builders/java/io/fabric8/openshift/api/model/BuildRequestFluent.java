package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.EnvVarFluent;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Boolean;
import java.lang.Long;
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
public class BuildRequestFluent<A extends io.fabric8.openshift.api.model.BuildRequestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private BinaryBuildSourceBuilder binary;
  private DockerStrategyOptionsBuilder dockerStrategyOptions;
  private ArrayList<EnvVarBuilder> env = new ArrayList<EnvVarBuilder>();
  private ObjectReferenceBuilder from;
  private String kind;
  private Long lastVersion;
  private ObjectMetaBuilder metadata;
  private SourceRevisionBuilder revision;
  private SourceStrategyOptionsBuilder sourceStrategyOptions;
  private ArrayList<BuildTriggerCauseBuilder> triggeredBy = new ArrayList<BuildTriggerCauseBuilder>();
  private ObjectReferenceBuilder triggeredByImage;

  public BuildRequestFluent() {
  }
  
  public BuildRequestFluent(BuildRequest instance) {
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
  
  public A addAllToTriggeredBy(Collection<BuildTriggerCause> items) {
    if (this.triggeredBy == null) {
      this.triggeredBy = new ArrayList();
    }
    for (BuildTriggerCause item : items) {
        BuildTriggerCauseBuilder builder = new BuildTriggerCauseBuilder(item);
        _visitables.get("triggeredBy").add(builder);
        this.triggeredBy.add(builder);
    }
    return (A) this;
  }
  
  public EnvNested<A> addNewEnv() {
    return new EnvNested(-1, null);
  }
  
  public EnvNested<A> addNewEnvLike(EnvVar item) {
    return new EnvNested(-1, item);
  }
  
  public TriggeredByNested<A> addNewTriggeredBy() {
    return new TriggeredByNested(-1, null);
  }
  
  public TriggeredByNested<A> addNewTriggeredByLike(BuildTriggerCause item) {
    return new TriggeredByNested(-1, item);
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
  
  public A addToTriggeredBy(BuildTriggerCause... items) {
    if (this.triggeredBy == null) {
      this.triggeredBy = new ArrayList();
    }
    for (BuildTriggerCause item : items) {
        BuildTriggerCauseBuilder builder = new BuildTriggerCauseBuilder(item);
        _visitables.get("triggeredBy").add(builder);
        this.triggeredBy.add(builder);
    }
    return (A) this;
  }
  
  public A addToTriggeredBy(int index,BuildTriggerCause item) {
    if (this.triggeredBy == null) {
      this.triggeredBy = new ArrayList();
    }
    BuildTriggerCauseBuilder builder = new BuildTriggerCauseBuilder(item);
    if (index < 0 || index >= triggeredBy.size()) {
        _visitables.get("triggeredBy").add(builder);
        triggeredBy.add(builder);
    } else {
        _visitables.get("triggeredBy").add(builder);
        triggeredBy.add(index, builder);
    }
    return (A) this;
  }
  
  public BinaryBuildSource buildBinary() {
    return this.binary != null ? this.binary.build() : null;
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
  
  public BuildTriggerCause buildFirstTriggeredBy() {
    return this.triggeredBy.get(0).build();
  }
  
  public ObjectReference buildFrom() {
    return this.from != null ? this.from.build() : null;
  }
  
  public EnvVar buildLastEnv() {
    return this.env.get(env.size() - 1).build();
  }
  
  public BuildTriggerCause buildLastTriggeredBy() {
    return this.triggeredBy.get(triggeredBy.size() - 1).build();
  }
  
  public EnvVar buildMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public BuildTriggerCause buildMatchingTriggeredBy(Predicate<BuildTriggerCauseBuilder> predicate) {
      for (BuildTriggerCauseBuilder item : triggeredBy) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public SourceRevision buildRevision() {
    return this.revision != null ? this.revision.build() : null;
  }
  
  public SourceStrategyOptions buildSourceStrategyOptions() {
    return this.sourceStrategyOptions != null ? this.sourceStrategyOptions.build() : null;
  }
  
  public List<BuildTriggerCause> buildTriggeredBy() {
    return this.triggeredBy != null ? build(triggeredBy) : null;
  }
  
  public BuildTriggerCause buildTriggeredBy(int index) {
    return this.triggeredBy.get(index).build();
  }
  
  public ObjectReference buildTriggeredByImage() {
    return this.triggeredByImage != null ? this.triggeredByImage.build() : null;
  }
  
  protected void copyInstance(BuildRequest instance) {
    instance = instance != null ? instance : new BuildRequest();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withBinary(instance.getBinary());
        this.withDockerStrategyOptions(instance.getDockerStrategyOptions());
        this.withEnv(instance.getEnv());
        this.withFrom(instance.getFrom());
        this.withKind(instance.getKind());
        this.withLastVersion(instance.getLastVersion());
        this.withMetadata(instance.getMetadata());
        this.withRevision(instance.getRevision());
        this.withSourceStrategyOptions(instance.getSourceStrategyOptions());
        this.withTriggeredBy(instance.getTriggeredBy());
        this.withTriggeredByImage(instance.getTriggeredByImage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BinaryNested<A> editBinary() {
    return this.withNewBinaryLike(Optional.ofNullable(this.buildBinary()).orElse(null));
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
  
  public TriggeredByNested<A> editFirstTriggeredBy() {
    if (triggeredBy.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "triggeredBy"));
    }
    return this.setNewTriggeredByLike(0, this.buildTriggeredBy(0));
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
  
  public TriggeredByNested<A> editLastTriggeredBy() {
    int index = triggeredBy.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "triggeredBy"));
    }
    return this.setNewTriggeredByLike(index, this.buildTriggeredBy(index));
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
  
  public TriggeredByNested<A> editMatchingTriggeredBy(Predicate<BuildTriggerCauseBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < triggeredBy.size();i++) {
      if (predicate.test(triggeredBy.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "triggeredBy"));
    }
    return this.setNewTriggeredByLike(index, this.buildTriggeredBy(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public BinaryNested<A> editOrNewBinary() {
    return this.withNewBinaryLike(Optional.ofNullable(this.buildBinary()).orElse(new BinaryBuildSourceBuilder().build()));
  }
  
  public BinaryNested<A> editOrNewBinaryLike(BinaryBuildSource item) {
    return this.withNewBinaryLike(Optional.ofNullable(this.buildBinary()).orElse(item));
  }
  
  public DockerStrategyOptionsNested<A> editOrNewDockerStrategyOptions() {
    return this.withNewDockerStrategyOptionsLike(Optional.ofNullable(this.buildDockerStrategyOptions()).orElse(new DockerStrategyOptionsBuilder().build()));
  }
  
  public DockerStrategyOptionsNested<A> editOrNewDockerStrategyOptionsLike(DockerStrategyOptions item) {
    return this.withNewDockerStrategyOptionsLike(Optional.ofNullable(this.buildDockerStrategyOptions()).orElse(item));
  }
  
  public FromNested<A> editOrNewFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public FromNested<A> editOrNewFromLike(ObjectReference item) {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public RevisionNested<A> editOrNewRevision() {
    return this.withNewRevisionLike(Optional.ofNullable(this.buildRevision()).orElse(new SourceRevisionBuilder().build()));
  }
  
  public RevisionNested<A> editOrNewRevisionLike(SourceRevision item) {
    return this.withNewRevisionLike(Optional.ofNullable(this.buildRevision()).orElse(item));
  }
  
  public SourceStrategyOptionsNested<A> editOrNewSourceStrategyOptions() {
    return this.withNewSourceStrategyOptionsLike(Optional.ofNullable(this.buildSourceStrategyOptions()).orElse(new SourceStrategyOptionsBuilder().build()));
  }
  
  public SourceStrategyOptionsNested<A> editOrNewSourceStrategyOptionsLike(SourceStrategyOptions item) {
    return this.withNewSourceStrategyOptionsLike(Optional.ofNullable(this.buildSourceStrategyOptions()).orElse(item));
  }
  
  public TriggeredByImageNested<A> editOrNewTriggeredByImage() {
    return this.withNewTriggeredByImageLike(Optional.ofNullable(this.buildTriggeredByImage()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public TriggeredByImageNested<A> editOrNewTriggeredByImageLike(ObjectReference item) {
    return this.withNewTriggeredByImageLike(Optional.ofNullable(this.buildTriggeredByImage()).orElse(item));
  }
  
  public RevisionNested<A> editRevision() {
    return this.withNewRevisionLike(Optional.ofNullable(this.buildRevision()).orElse(null));
  }
  
  public SourceStrategyOptionsNested<A> editSourceStrategyOptions() {
    return this.withNewSourceStrategyOptionsLike(Optional.ofNullable(this.buildSourceStrategyOptions()).orElse(null));
  }
  
  public TriggeredByNested<A> editTriggeredBy(int index) {
    if (triggeredBy.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "triggeredBy"));
    }
    return this.setNewTriggeredByLike(index, this.buildTriggeredBy(index));
  }
  
  public TriggeredByImageNested<A> editTriggeredByImage() {
    return this.withNewTriggeredByImageLike(Optional.ofNullable(this.buildTriggeredByImage()).orElse(null));
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
    BuildRequestFluent that = (BuildRequestFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(binary, that.binary))) {
      return false;
    }
    if (!(Objects.equals(dockerStrategyOptions, that.dockerStrategyOptions))) {
      return false;
    }
    if (!(Objects.equals(env, that.env))) {
      return false;
    }
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(lastVersion, that.lastVersion))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(revision, that.revision))) {
      return false;
    }
    if (!(Objects.equals(sourceStrategyOptions, that.sourceStrategyOptions))) {
      return false;
    }
    if (!(Objects.equals(triggeredBy, that.triggeredBy))) {
      return false;
    }
    if (!(Objects.equals(triggeredByImage, that.triggeredByImage))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Long getLastVersion() {
    return this.lastVersion;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasBinary() {
    return this.binary != null;
  }
  
  public boolean hasDockerStrategyOptions() {
    return this.dockerStrategyOptions != null;
  }
  
  public boolean hasEnv() {
    return this.env != null && !(this.env.isEmpty());
  }
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLastVersion() {
    return this.lastVersion != null;
  }
  
  public boolean hasMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTriggeredBy(Predicate<BuildTriggerCauseBuilder> predicate) {
      for (BuildTriggerCauseBuilder item : triggeredBy) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasRevision() {
    return this.revision != null;
  }
  
  public boolean hasSourceStrategyOptions() {
    return this.sourceStrategyOptions != null;
  }
  
  public boolean hasTriggeredBy() {
    return this.triggeredBy != null && !(this.triggeredBy.isEmpty());
  }
  
  public boolean hasTriggeredByImage() {
    return this.triggeredByImage != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, binary, dockerStrategyOptions, env, from, kind, lastVersion, metadata, revision, sourceStrategyOptions, triggeredBy, triggeredByImage, additionalProperties);
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
  
  public A removeAllFromTriggeredBy(Collection<BuildTriggerCause> items) {
    if (this.triggeredBy == null) {
      return (A) this;
    }
    for (BuildTriggerCause item : items) {
        BuildTriggerCauseBuilder builder = new BuildTriggerCauseBuilder(item);
        _visitables.get("triggeredBy").remove(builder);
        this.triggeredBy.remove(builder);
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
  
  public A removeFromTriggeredBy(BuildTriggerCause... items) {
    if (this.triggeredBy == null) {
      return (A) this;
    }
    for (BuildTriggerCause item : items) {
        BuildTriggerCauseBuilder builder = new BuildTriggerCauseBuilder(item);
        _visitables.get("triggeredBy").remove(builder);
        this.triggeredBy.remove(builder);
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
  
  public A removeMatchingFromTriggeredBy(Predicate<BuildTriggerCauseBuilder> predicate) {
    if (triggeredBy == null) {
      return (A) this;
    }
    Iterator<BuildTriggerCauseBuilder> each = triggeredBy.iterator();
    List visitables = _visitables.get("triggeredBy");
    while (each.hasNext()) {
        BuildTriggerCauseBuilder builder = each.next();
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
  
  public TriggeredByNested<A> setNewTriggeredByLike(int index,BuildTriggerCause item) {
    return new TriggeredByNested(index, item);
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
  
  public A setToTriggeredBy(int index,BuildTriggerCause item) {
    if (this.triggeredBy == null) {
      this.triggeredBy = new ArrayList();
    }
    BuildTriggerCauseBuilder builder = new BuildTriggerCauseBuilder(item);
    if (index < 0 || index >= triggeredBy.size()) {
        _visitables.get("triggeredBy").add(builder);
        triggeredBy.add(builder);
    } else {
        _visitables.get("triggeredBy").add(builder);
        triggeredBy.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(binary == null)) {
        sb.append("binary:");
        sb.append(binary);
        sb.append(",");
    }
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
    if (!(from == null)) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(lastVersion == null)) {
        sb.append("lastVersion:");
        sb.append(lastVersion);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(revision == null)) {
        sb.append("revision:");
        sb.append(revision);
        sb.append(",");
    }
    if (!(sourceStrategyOptions == null)) {
        sb.append("sourceStrategyOptions:");
        sb.append(sourceStrategyOptions);
        sb.append(",");
    }
    if (!(triggeredBy == null) && !(triggeredBy.isEmpty())) {
        sb.append("triggeredBy:");
        sb.append(triggeredBy);
        sb.append(",");
    }
    if (!(triggeredByImage == null)) {
        sb.append("triggeredByImage:");
        sb.append(triggeredByImage);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withBinary(BinaryBuildSource binary) {
    this._visitables.remove("binary");
    if (binary != null) {
        this.binary = new BinaryBuildSourceBuilder(binary);
        this._visitables.get("binary").add(this.binary);
    } else {
        this.binary = null;
        this._visitables.get("binary").remove(this.binary);
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
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withLastVersion(Long lastVersion) {
    this.lastVersion = lastVersion;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public BinaryNested<A> withNewBinary() {
    return new BinaryNested(null);
  }
  
  public A withNewBinary(String asFile) {
    return (A) this.withBinary(new BinaryBuildSource(asFile));
  }
  
  public BinaryNested<A> withNewBinaryLike(BinaryBuildSource item) {
    return new BinaryNested(item);
  }
  
  public DockerStrategyOptionsNested<A> withNewDockerStrategyOptions() {
    return new DockerStrategyOptionsNested(null);
  }
  
  public DockerStrategyOptionsNested<A> withNewDockerStrategyOptionsLike(DockerStrategyOptions item) {
    return new DockerStrategyOptionsNested(item);
  }
  
  public FromNested<A> withNewFrom() {
    return new FromNested(null);
  }
  
  public FromNested<A> withNewFromLike(ObjectReference item) {
    return new FromNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public RevisionNested<A> withNewRevision() {
    return new RevisionNested(null);
  }
  
  public RevisionNested<A> withNewRevisionLike(SourceRevision item) {
    return new RevisionNested(item);
  }
  
  public SourceStrategyOptionsNested<A> withNewSourceStrategyOptions() {
    return new SourceStrategyOptionsNested(null);
  }
  
  public A withNewSourceStrategyOptions(Boolean incremental) {
    return (A) this.withSourceStrategyOptions(new SourceStrategyOptions(incremental));
  }
  
  public SourceStrategyOptionsNested<A> withNewSourceStrategyOptionsLike(SourceStrategyOptions item) {
    return new SourceStrategyOptionsNested(item);
  }
  
  public TriggeredByImageNested<A> withNewTriggeredByImage() {
    return new TriggeredByImageNested(null);
  }
  
  public TriggeredByImageNested<A> withNewTriggeredByImageLike(ObjectReference item) {
    return new TriggeredByImageNested(item);
  }
  
  public A withRevision(SourceRevision revision) {
    this._visitables.remove("revision");
    if (revision != null) {
        this.revision = new SourceRevisionBuilder(revision);
        this._visitables.get("revision").add(this.revision);
    } else {
        this.revision = null;
        this._visitables.get("revision").remove(this.revision);
    }
    return (A) this;
  }
  
  public A withSourceStrategyOptions(SourceStrategyOptions sourceStrategyOptions) {
    this._visitables.remove("sourceStrategyOptions");
    if (sourceStrategyOptions != null) {
        this.sourceStrategyOptions = new SourceStrategyOptionsBuilder(sourceStrategyOptions);
        this._visitables.get("sourceStrategyOptions").add(this.sourceStrategyOptions);
    } else {
        this.sourceStrategyOptions = null;
        this._visitables.get("sourceStrategyOptions").remove(this.sourceStrategyOptions);
    }
    return (A) this;
  }
  
  public A withTriggeredBy(List<BuildTriggerCause> triggeredBy) {
    if (this.triggeredBy != null) {
      this._visitables.get("triggeredBy").clear();
    }
    if (triggeredBy != null) {
        this.triggeredBy = new ArrayList();
        for (BuildTriggerCause item : triggeredBy) {
          this.addToTriggeredBy(item);
        }
    } else {
      this.triggeredBy = null;
    }
    return (A) this;
  }
  
  public A withTriggeredBy(BuildTriggerCause... triggeredBy) {
    if (this.triggeredBy != null) {
        this.triggeredBy.clear();
        _visitables.remove("triggeredBy");
    }
    if (triggeredBy != null) {
      for (BuildTriggerCause item : triggeredBy) {
        this.addToTriggeredBy(item);
      }
    }
    return (A) this;
  }
  
  public A withTriggeredByImage(ObjectReference triggeredByImage) {
    this._visitables.remove("triggeredByImage");
    if (triggeredByImage != null) {
        this.triggeredByImage = new ObjectReferenceBuilder(triggeredByImage);
        this._visitables.get("triggeredByImage").add(this.triggeredByImage);
    } else {
        this.triggeredByImage = null;
        this._visitables.get("triggeredByImage").remove(this.triggeredByImage);
    }
    return (A) this;
  }
  public class BinaryNested<N> extends BinaryBuildSourceFluent<BinaryNested<N>> implements Nested<N>{
  
    BinaryBuildSourceBuilder builder;
  
    BinaryNested(BinaryBuildSource item) {
      this.builder = new BinaryBuildSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildRequestFluent.this.withBinary(builder.build());
    }
    
    public N endBinary() {
      return and();
    }
    
  }
  public class DockerStrategyOptionsNested<N> extends DockerStrategyOptionsFluent<DockerStrategyOptionsNested<N>> implements Nested<N>{
  
    DockerStrategyOptionsBuilder builder;
  
    DockerStrategyOptionsNested(DockerStrategyOptions item) {
      this.builder = new DockerStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildRequestFluent.this.withDockerStrategyOptions(builder.build());
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
      return (N) BuildRequestFluent.this.setToEnv(index, builder.build());
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
      return (N) BuildRequestFluent.this.withFrom(builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildRequestFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class RevisionNested<N> extends SourceRevisionFluent<RevisionNested<N>> implements Nested<N>{
  
    SourceRevisionBuilder builder;
  
    RevisionNested(SourceRevision item) {
      this.builder = new SourceRevisionBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildRequestFluent.this.withRevision(builder.build());
    }
    
    public N endRevision() {
      return and();
    }
    
  }
  public class SourceStrategyOptionsNested<N> extends SourceStrategyOptionsFluent<SourceStrategyOptionsNested<N>> implements Nested<N>{
  
    SourceStrategyOptionsBuilder builder;
  
    SourceStrategyOptionsNested(SourceStrategyOptions item) {
      this.builder = new SourceStrategyOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildRequestFluent.this.withSourceStrategyOptions(builder.build());
    }
    
    public N endSourceStrategyOptions() {
      return and();
    }
    
  }
  public class TriggeredByImageNested<N> extends ObjectReferenceFluent<TriggeredByImageNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    TriggeredByImageNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildRequestFluent.this.withTriggeredByImage(builder.build());
    }
    
    public N endTriggeredByImage() {
      return and();
    }
    
  }
  public class TriggeredByNested<N> extends BuildTriggerCauseFluent<TriggeredByNested<N>> implements Nested<N>{
  
    BuildTriggerCauseBuilder builder;
    int index;
  
    TriggeredByNested(int index,BuildTriggerCause item) {
      this.index = index;
      this.builder = new BuildTriggerCauseBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildRequestFluent.this.setToTriggeredBy(index, builder.build());
    }
    
    public N endTriggeredBy() {
      return and();
    }
    
  }
}