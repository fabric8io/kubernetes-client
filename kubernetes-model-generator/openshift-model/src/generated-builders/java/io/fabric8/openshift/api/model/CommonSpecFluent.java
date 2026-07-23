package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import java.lang.Boolean;
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
public class CommonSpecFluent<A extends io.fabric8.openshift.api.model.CommonSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long completionDeadlineSeconds;
  private Boolean mountTrustedCA;
  private Map<String,String> nodeSelector;
  private BuildOutputBuilder output;
  private BuildPostCommitSpecBuilder postCommit;
  private ResourceRequirementsBuilder resources;
  private SourceRevisionBuilder revision;
  private String serviceAccount;
  private BuildSourceBuilder source;
  private BuildStrategyBuilder strategy;

  public CommonSpecFluent() {
  }
  
  public CommonSpecFluent(CommonSpec instance) {
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
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public BuildOutput buildOutput() {
    return this.output != null ? this.output.build() : null;
  }
  
  public BuildPostCommitSpec buildPostCommit() {
    return this.postCommit != null ? this.postCommit.build() : null;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public SourceRevision buildRevision() {
    return this.revision != null ? this.revision.build() : null;
  }
  
  public BuildSource buildSource() {
    return this.source != null ? this.source.build() : null;
  }
  
  public BuildStrategy buildStrategy() {
    return this.strategy != null ? this.strategy.build() : null;
  }
  
  protected void copyInstance(CommonSpec instance) {
    instance = instance != null ? instance : new CommonSpec();
    if (instance != null) {
        this.withCompletionDeadlineSeconds(instance.getCompletionDeadlineSeconds());
        this.withMountTrustedCA(instance.getMountTrustedCA());
        this.withNodeSelector(instance.getNodeSelector());
        this.withOutput(instance.getOutput());
        this.withPostCommit(instance.getPostCommit());
        this.withResources(instance.getResources());
        this.withRevision(instance.getRevision());
        this.withServiceAccount(instance.getServiceAccount());
        this.withSource(instance.getSource());
        this.withStrategy(instance.getStrategy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OutputNested<A> editOrNewOutput() {
    return this.withNewOutputLike(Optional.ofNullable(this.buildOutput()).orElse(new BuildOutputBuilder().build()));
  }
  
  public OutputNested<A> editOrNewOutputLike(BuildOutput item) {
    return this.withNewOutputLike(Optional.ofNullable(this.buildOutput()).orElse(item));
  }
  
  public PostCommitNested<A> editOrNewPostCommit() {
    return this.withNewPostCommitLike(Optional.ofNullable(this.buildPostCommit()).orElse(new BuildPostCommitSpecBuilder().build()));
  }
  
  public PostCommitNested<A> editOrNewPostCommitLike(BuildPostCommitSpec item) {
    return this.withNewPostCommitLike(Optional.ofNullable(this.buildPostCommit()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public RevisionNested<A> editOrNewRevision() {
    return this.withNewRevisionLike(Optional.ofNullable(this.buildRevision()).orElse(new SourceRevisionBuilder().build()));
  }
  
  public RevisionNested<A> editOrNewRevisionLike(SourceRevision item) {
    return this.withNewRevisionLike(Optional.ofNullable(this.buildRevision()).orElse(item));
  }
  
  public SourceNested<A> editOrNewSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(new BuildSourceBuilder().build()));
  }
  
  public SourceNested<A> editOrNewSourceLike(BuildSource item) {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(item));
  }
  
  public StrategyNested<A> editOrNewStrategy() {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(new BuildStrategyBuilder().build()));
  }
  
  public StrategyNested<A> editOrNewStrategyLike(BuildStrategy item) {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(item));
  }
  
  public OutputNested<A> editOutput() {
    return this.withNewOutputLike(Optional.ofNullable(this.buildOutput()).orElse(null));
  }
  
  public PostCommitNested<A> editPostCommit() {
    return this.withNewPostCommitLike(Optional.ofNullable(this.buildPostCommit()).orElse(null));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public RevisionNested<A> editRevision() {
    return this.withNewRevisionLike(Optional.ofNullable(this.buildRevision()).orElse(null));
  }
  
  public SourceNested<A> editSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(null));
  }
  
  public StrategyNested<A> editStrategy() {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(null));
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
    CommonSpecFluent that = (CommonSpecFluent) o;
    if (!(Objects.equals(completionDeadlineSeconds, that.completionDeadlineSeconds))) {
      return false;
    }
    if (!(Objects.equals(mountTrustedCA, that.mountTrustedCA))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(output, that.output))) {
      return false;
    }
    if (!(Objects.equals(postCommit, that.postCommit))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(revision, that.revision))) {
      return false;
    }
    if (!(Objects.equals(serviceAccount, that.serviceAccount))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(strategy, that.strategy))) {
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
  
  public Long getCompletionDeadlineSeconds() {
    return this.completionDeadlineSeconds;
  }
  
  public Boolean getMountTrustedCA() {
    return this.mountTrustedCA;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public String getServiceAccount() {
    return this.serviceAccount;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompletionDeadlineSeconds() {
    return this.completionDeadlineSeconds != null;
  }
  
  public boolean hasMountTrustedCA() {
    return this.mountTrustedCA != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasOutput() {
    return this.output != null;
  }
  
  public boolean hasPostCommit() {
    return this.postCommit != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasRevision() {
    return this.revision != null;
  }
  
  public boolean hasServiceAccount() {
    return this.serviceAccount != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public boolean hasStrategy() {
    return this.strategy != null;
  }
  
  public int hashCode() {
    return Objects.hash(completionDeadlineSeconds, mountTrustedCA, nodeSelector, output, postCommit, resources, revision, serviceAccount, source, strategy, additionalProperties);
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
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(completionDeadlineSeconds == null)) {
        sb.append("completionDeadlineSeconds:");
        sb.append(completionDeadlineSeconds);
        sb.append(",");
    }
    if (!(mountTrustedCA == null)) {
        sb.append("mountTrustedCA:");
        sb.append(mountTrustedCA);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(output == null)) {
        sb.append("output:");
        sb.append(output);
        sb.append(",");
    }
    if (!(postCommit == null)) {
        sb.append("postCommit:");
        sb.append(postCommit);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(revision == null)) {
        sb.append("revision:");
        sb.append(revision);
        sb.append(",");
    }
    if (!(serviceAccount == null)) {
        sb.append("serviceAccount:");
        sb.append(serviceAccount);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
        sb.append(",");
    }
    if (!(strategy == null)) {
        sb.append("strategy:");
        sb.append(strategy);
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
  
  public A withCompletionDeadlineSeconds(Long completionDeadlineSeconds) {
    this.completionDeadlineSeconds = completionDeadlineSeconds;
    return (A) this;
  }
  
  public A withMountTrustedCA() {
    return withMountTrustedCA(true);
  }
  
  public A withMountTrustedCA(Boolean mountTrustedCA) {
    this.mountTrustedCA = mountTrustedCA;
    return (A) this;
  }
  
  public OutputNested<A> withNewOutput() {
    return new OutputNested(null);
  }
  
  public OutputNested<A> withNewOutputLike(BuildOutput item) {
    return new OutputNested(item);
  }
  
  public PostCommitNested<A> withNewPostCommit() {
    return new PostCommitNested(null);
  }
  
  public PostCommitNested<A> withNewPostCommitLike(BuildPostCommitSpec item) {
    return new PostCommitNested(item);
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public RevisionNested<A> withNewRevision() {
    return new RevisionNested(null);
  }
  
  public RevisionNested<A> withNewRevisionLike(SourceRevision item) {
    return new RevisionNested(item);
  }
  
  public SourceNested<A> withNewSource() {
    return new SourceNested(null);
  }
  
  public SourceNested<A> withNewSourceLike(BuildSource item) {
    return new SourceNested(item);
  }
  
  public StrategyNested<A> withNewStrategy() {
    return new StrategyNested(null);
  }
  
  public StrategyNested<A> withNewStrategyLike(BuildStrategy item) {
    return new StrategyNested(item);
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public A withOutput(BuildOutput output) {
    this._visitables.remove("output");
    if (output != null) {
        this.output = new BuildOutputBuilder(output);
        this._visitables.get("output").add(this.output);
    } else {
        this.output = null;
        this._visitables.get("output").remove(this.output);
    }
    return (A) this;
  }
  
  public A withPostCommit(BuildPostCommitSpec postCommit) {
    this._visitables.remove("postCommit");
    if (postCommit != null) {
        this.postCommit = new BuildPostCommitSpecBuilder(postCommit);
        this._visitables.get("postCommit").add(this.postCommit);
    } else {
        this.postCommit = null;
        this._visitables.get("postCommit").remove(this.postCommit);
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
  
  public A withServiceAccount(String serviceAccount) {
    this.serviceAccount = serviceAccount;
    return (A) this;
  }
  
  public A withSource(BuildSource source) {
    this._visitables.remove("source");
    if (source != null) {
        this.source = new BuildSourceBuilder(source);
        this._visitables.get("source").add(this.source);
    } else {
        this.source = null;
        this._visitables.get("source").remove(this.source);
    }
    return (A) this;
  }
  
  public A withStrategy(BuildStrategy strategy) {
    this._visitables.remove("strategy");
    if (strategy != null) {
        this.strategy = new BuildStrategyBuilder(strategy);
        this._visitables.get("strategy").add(this.strategy);
    } else {
        this.strategy = null;
        this._visitables.get("strategy").remove(this.strategy);
    }
    return (A) this;
  }
  public class OutputNested<N> extends BuildOutputFluent<OutputNested<N>> implements Nested<N>{
  
    BuildOutputBuilder builder;
  
    OutputNested(BuildOutput item) {
      this.builder = new BuildOutputBuilder(this, item);
    }
  
    public N and() {
      return (N) CommonSpecFluent.this.withOutput(builder.build());
    }
    
    public N endOutput() {
      return and();
    }
    
  }
  public class PostCommitNested<N> extends BuildPostCommitSpecFluent<PostCommitNested<N>> implements Nested<N>{
  
    BuildPostCommitSpecBuilder builder;
  
    PostCommitNested(BuildPostCommitSpec item) {
      this.builder = new BuildPostCommitSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) CommonSpecFluent.this.withPostCommit(builder.build());
    }
    
    public N endPostCommit() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) CommonSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class RevisionNested<N> extends SourceRevisionFluent<RevisionNested<N>> implements Nested<N>{
  
    SourceRevisionBuilder builder;
  
    RevisionNested(SourceRevision item) {
      this.builder = new SourceRevisionBuilder(this, item);
    }
  
    public N and() {
      return (N) CommonSpecFluent.this.withRevision(builder.build());
    }
    
    public N endRevision() {
      return and();
    }
    
  }
  public class SourceNested<N> extends BuildSourceFluent<SourceNested<N>> implements Nested<N>{
  
    BuildSourceBuilder builder;
  
    SourceNested(BuildSource item) {
      this.builder = new BuildSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) CommonSpecFluent.this.withSource(builder.build());
    }
    
    public N endSource() {
      return and();
    }
    
  }
  public class StrategyNested<N> extends BuildStrategyFluent<StrategyNested<N>> implements Nested<N>{
  
    BuildStrategyBuilder builder;
  
    StrategyNested(BuildStrategy item) {
      this.builder = new BuildStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) CommonSpecFluent.this.withStrategy(builder.build());
    }
    
    public N endStrategy() {
      return and();
    }
    
  }
}