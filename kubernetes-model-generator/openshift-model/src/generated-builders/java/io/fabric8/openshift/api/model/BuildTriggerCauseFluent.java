package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class BuildTriggerCauseFluent<A extends io.fabric8.openshift.api.model.BuildTriggerCauseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BitbucketWebHookCauseBuilder bitbucketWebHook;
  private GenericWebHookCauseBuilder genericWebHook;
  private GitHubWebHookCauseBuilder githubWebHook;
  private GitLabWebHookCauseBuilder gitlabWebHook;
  private ImageChangeCauseBuilder imageChangeBuild;
  private String message;

  public BuildTriggerCauseFluent() {
  }
  
  public BuildTriggerCauseFluent(BuildTriggerCause instance) {
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
  
  public BitbucketWebHookCause buildBitbucketWebHook() {
    return this.bitbucketWebHook != null ? this.bitbucketWebHook.build() : null;
  }
  
  public GenericWebHookCause buildGenericWebHook() {
    return this.genericWebHook != null ? this.genericWebHook.build() : null;
  }
  
  public GitHubWebHookCause buildGithubWebHook() {
    return this.githubWebHook != null ? this.githubWebHook.build() : null;
  }
  
  public GitLabWebHookCause buildGitlabWebHook() {
    return this.gitlabWebHook != null ? this.gitlabWebHook.build() : null;
  }
  
  public ImageChangeCause buildImageChangeBuild() {
    return this.imageChangeBuild != null ? this.imageChangeBuild.build() : null;
  }
  
  protected void copyInstance(BuildTriggerCause instance) {
    instance = instance != null ? instance : new BuildTriggerCause();
    if (instance != null) {
        this.withBitbucketWebHook(instance.getBitbucketWebHook());
        this.withGenericWebHook(instance.getGenericWebHook());
        this.withGithubWebHook(instance.getGithubWebHook());
        this.withGitlabWebHook(instance.getGitlabWebHook());
        this.withImageChangeBuild(instance.getImageChangeBuild());
        this.withMessage(instance.getMessage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BitbucketWebHookNested<A> editBitbucketWebHook() {
    return this.withNewBitbucketWebHookLike(Optional.ofNullable(this.buildBitbucketWebHook()).orElse(null));
  }
  
  public GenericWebHookNested<A> editGenericWebHook() {
    return this.withNewGenericWebHookLike(Optional.ofNullable(this.buildGenericWebHook()).orElse(null));
  }
  
  public GithubWebHookNested<A> editGithubWebHook() {
    return this.withNewGithubWebHookLike(Optional.ofNullable(this.buildGithubWebHook()).orElse(null));
  }
  
  public GitlabWebHookNested<A> editGitlabWebHook() {
    return this.withNewGitlabWebHookLike(Optional.ofNullable(this.buildGitlabWebHook()).orElse(null));
  }
  
  public ImageChangeBuildNested<A> editImageChangeBuild() {
    return this.withNewImageChangeBuildLike(Optional.ofNullable(this.buildImageChangeBuild()).orElse(null));
  }
  
  public BitbucketWebHookNested<A> editOrNewBitbucketWebHook() {
    return this.withNewBitbucketWebHookLike(Optional.ofNullable(this.buildBitbucketWebHook()).orElse(new BitbucketWebHookCauseBuilder().build()));
  }
  
  public BitbucketWebHookNested<A> editOrNewBitbucketWebHookLike(BitbucketWebHookCause item) {
    return this.withNewBitbucketWebHookLike(Optional.ofNullable(this.buildBitbucketWebHook()).orElse(item));
  }
  
  public GenericWebHookNested<A> editOrNewGenericWebHook() {
    return this.withNewGenericWebHookLike(Optional.ofNullable(this.buildGenericWebHook()).orElse(new GenericWebHookCauseBuilder().build()));
  }
  
  public GenericWebHookNested<A> editOrNewGenericWebHookLike(GenericWebHookCause item) {
    return this.withNewGenericWebHookLike(Optional.ofNullable(this.buildGenericWebHook()).orElse(item));
  }
  
  public GithubWebHookNested<A> editOrNewGithubWebHook() {
    return this.withNewGithubWebHookLike(Optional.ofNullable(this.buildGithubWebHook()).orElse(new GitHubWebHookCauseBuilder().build()));
  }
  
  public GithubWebHookNested<A> editOrNewGithubWebHookLike(GitHubWebHookCause item) {
    return this.withNewGithubWebHookLike(Optional.ofNullable(this.buildGithubWebHook()).orElse(item));
  }
  
  public GitlabWebHookNested<A> editOrNewGitlabWebHook() {
    return this.withNewGitlabWebHookLike(Optional.ofNullable(this.buildGitlabWebHook()).orElse(new GitLabWebHookCauseBuilder().build()));
  }
  
  public GitlabWebHookNested<A> editOrNewGitlabWebHookLike(GitLabWebHookCause item) {
    return this.withNewGitlabWebHookLike(Optional.ofNullable(this.buildGitlabWebHook()).orElse(item));
  }
  
  public ImageChangeBuildNested<A> editOrNewImageChangeBuild() {
    return this.withNewImageChangeBuildLike(Optional.ofNullable(this.buildImageChangeBuild()).orElse(new ImageChangeCauseBuilder().build()));
  }
  
  public ImageChangeBuildNested<A> editOrNewImageChangeBuildLike(ImageChangeCause item) {
    return this.withNewImageChangeBuildLike(Optional.ofNullable(this.buildImageChangeBuild()).orElse(item));
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
    BuildTriggerCauseFluent that = (BuildTriggerCauseFluent) o;
    if (!(Objects.equals(bitbucketWebHook, that.bitbucketWebHook))) {
      return false;
    }
    if (!(Objects.equals(genericWebHook, that.genericWebHook))) {
      return false;
    }
    if (!(Objects.equals(githubWebHook, that.githubWebHook))) {
      return false;
    }
    if (!(Objects.equals(gitlabWebHook, that.gitlabWebHook))) {
      return false;
    }
    if (!(Objects.equals(imageChangeBuild, that.imageChangeBuild))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
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
  
  public String getMessage() {
    return this.message;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBitbucketWebHook() {
    return this.bitbucketWebHook != null;
  }
  
  public boolean hasGenericWebHook() {
    return this.genericWebHook != null;
  }
  
  public boolean hasGithubWebHook() {
    return this.githubWebHook != null;
  }
  
  public boolean hasGitlabWebHook() {
    return this.gitlabWebHook != null;
  }
  
  public boolean hasImageChangeBuild() {
    return this.imageChangeBuild != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public int hashCode() {
    return Objects.hash(bitbucketWebHook, genericWebHook, githubWebHook, gitlabWebHook, imageChangeBuild, message, additionalProperties);
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
    if (!(bitbucketWebHook == null)) {
        sb.append("bitbucketWebHook:");
        sb.append(bitbucketWebHook);
        sb.append(",");
    }
    if (!(genericWebHook == null)) {
        sb.append("genericWebHook:");
        sb.append(genericWebHook);
        sb.append(",");
    }
    if (!(githubWebHook == null)) {
        sb.append("githubWebHook:");
        sb.append(githubWebHook);
        sb.append(",");
    }
    if (!(gitlabWebHook == null)) {
        sb.append("gitlabWebHook:");
        sb.append(gitlabWebHook);
        sb.append(",");
    }
    if (!(imageChangeBuild == null)) {
        sb.append("imageChangeBuild:");
        sb.append(imageChangeBuild);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
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
  
  public A withBitbucketWebHook(BitbucketWebHookCause bitbucketWebHook) {
    this._visitables.remove("bitbucketWebHook");
    if (bitbucketWebHook != null) {
        this.bitbucketWebHook = new BitbucketWebHookCauseBuilder(bitbucketWebHook);
        this._visitables.get("bitbucketWebHook").add(this.bitbucketWebHook);
    } else {
        this.bitbucketWebHook = null;
        this._visitables.get("bitbucketWebHook").remove(this.bitbucketWebHook);
    }
    return (A) this;
  }
  
  public A withGenericWebHook(GenericWebHookCause genericWebHook) {
    this._visitables.remove("genericWebHook");
    if (genericWebHook != null) {
        this.genericWebHook = new GenericWebHookCauseBuilder(genericWebHook);
        this._visitables.get("genericWebHook").add(this.genericWebHook);
    } else {
        this.genericWebHook = null;
        this._visitables.get("genericWebHook").remove(this.genericWebHook);
    }
    return (A) this;
  }
  
  public A withGithubWebHook(GitHubWebHookCause githubWebHook) {
    this._visitables.remove("githubWebHook");
    if (githubWebHook != null) {
        this.githubWebHook = new GitHubWebHookCauseBuilder(githubWebHook);
        this._visitables.get("githubWebHook").add(this.githubWebHook);
    } else {
        this.githubWebHook = null;
        this._visitables.get("githubWebHook").remove(this.githubWebHook);
    }
    return (A) this;
  }
  
  public A withGitlabWebHook(GitLabWebHookCause gitlabWebHook) {
    this._visitables.remove("gitlabWebHook");
    if (gitlabWebHook != null) {
        this.gitlabWebHook = new GitLabWebHookCauseBuilder(gitlabWebHook);
        this._visitables.get("gitlabWebHook").add(this.gitlabWebHook);
    } else {
        this.gitlabWebHook = null;
        this._visitables.get("gitlabWebHook").remove(this.gitlabWebHook);
    }
    return (A) this;
  }
  
  public A withImageChangeBuild(ImageChangeCause imageChangeBuild) {
    this._visitables.remove("imageChangeBuild");
    if (imageChangeBuild != null) {
        this.imageChangeBuild = new ImageChangeCauseBuilder(imageChangeBuild);
        this._visitables.get("imageChangeBuild").add(this.imageChangeBuild);
    } else {
        this.imageChangeBuild = null;
        this._visitables.get("imageChangeBuild").remove(this.imageChangeBuild);
    }
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public BitbucketWebHookNested<A> withNewBitbucketWebHook() {
    return new BitbucketWebHookNested(null);
  }
  
  public BitbucketWebHookNested<A> withNewBitbucketWebHookLike(BitbucketWebHookCause item) {
    return new BitbucketWebHookNested(item);
  }
  
  public GenericWebHookNested<A> withNewGenericWebHook() {
    return new GenericWebHookNested(null);
  }
  
  public GenericWebHookNested<A> withNewGenericWebHookLike(GenericWebHookCause item) {
    return new GenericWebHookNested(item);
  }
  
  public GithubWebHookNested<A> withNewGithubWebHook() {
    return new GithubWebHookNested(null);
  }
  
  public GithubWebHookNested<A> withNewGithubWebHookLike(GitHubWebHookCause item) {
    return new GithubWebHookNested(item);
  }
  
  public GitlabWebHookNested<A> withNewGitlabWebHook() {
    return new GitlabWebHookNested(null);
  }
  
  public GitlabWebHookNested<A> withNewGitlabWebHookLike(GitLabWebHookCause item) {
    return new GitlabWebHookNested(item);
  }
  
  public ImageChangeBuildNested<A> withNewImageChangeBuild() {
    return new ImageChangeBuildNested(null);
  }
  
  public ImageChangeBuildNested<A> withNewImageChangeBuildLike(ImageChangeCause item) {
    return new ImageChangeBuildNested(item);
  }
  public class BitbucketWebHookNested<N> extends BitbucketWebHookCauseFluent<BitbucketWebHookNested<N>> implements Nested<N>{
  
    BitbucketWebHookCauseBuilder builder;
  
    BitbucketWebHookNested(BitbucketWebHookCause item) {
      this.builder = new BitbucketWebHookCauseBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildTriggerCauseFluent.this.withBitbucketWebHook(builder.build());
    }
    
    public N endBitbucketWebHook() {
      return and();
    }
    
  }
  public class GenericWebHookNested<N> extends GenericWebHookCauseFluent<GenericWebHookNested<N>> implements Nested<N>{
  
    GenericWebHookCauseBuilder builder;
  
    GenericWebHookNested(GenericWebHookCause item) {
      this.builder = new GenericWebHookCauseBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildTriggerCauseFluent.this.withGenericWebHook(builder.build());
    }
    
    public N endGenericWebHook() {
      return and();
    }
    
  }
  public class GithubWebHookNested<N> extends GitHubWebHookCauseFluent<GithubWebHookNested<N>> implements Nested<N>{
  
    GitHubWebHookCauseBuilder builder;
  
    GithubWebHookNested(GitHubWebHookCause item) {
      this.builder = new GitHubWebHookCauseBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildTriggerCauseFluent.this.withGithubWebHook(builder.build());
    }
    
    public N endGithubWebHook() {
      return and();
    }
    
  }
  public class GitlabWebHookNested<N> extends GitLabWebHookCauseFluent<GitlabWebHookNested<N>> implements Nested<N>{
  
    GitLabWebHookCauseBuilder builder;
  
    GitlabWebHookNested(GitLabWebHookCause item) {
      this.builder = new GitLabWebHookCauseBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildTriggerCauseFluent.this.withGitlabWebHook(builder.build());
    }
    
    public N endGitlabWebHook() {
      return and();
    }
    
  }
  public class ImageChangeBuildNested<N> extends ImageChangeCauseFluent<ImageChangeBuildNested<N>> implements Nested<N>{
  
    ImageChangeCauseBuilder builder;
  
    ImageChangeBuildNested(ImageChangeCause item) {
      this.builder = new ImageChangeCauseBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildTriggerCauseFluent.this.withImageChangeBuild(builder.build());
    }
    
    public N endImageChangeBuild() {
      return and();
    }
    
  }
}