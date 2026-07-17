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
public class BuildTriggerPolicyFluent<A extends io.fabric8.openshift.api.model.BuildTriggerPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private WebHookTriggerBuilder bitbucket;
  private WebHookTriggerBuilder generic;
  private WebHookTriggerBuilder github;
  private WebHookTriggerBuilder gitlab;
  private ImageChangeTriggerBuilder imageChange;
  private String type;

  public BuildTriggerPolicyFluent() {
  }
  
  public BuildTriggerPolicyFluent(BuildTriggerPolicy instance) {
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
  
  public WebHookTrigger buildBitbucket() {
    return this.bitbucket != null ? this.bitbucket.build() : null;
  }
  
  public WebHookTrigger buildGeneric() {
    return this.generic != null ? this.generic.build() : null;
  }
  
  public WebHookTrigger buildGithub() {
    return this.github != null ? this.github.build() : null;
  }
  
  public WebHookTrigger buildGitlab() {
    return this.gitlab != null ? this.gitlab.build() : null;
  }
  
  public ImageChangeTrigger buildImageChange() {
    return this.imageChange != null ? this.imageChange.build() : null;
  }
  
  protected void copyInstance(BuildTriggerPolicy instance) {
    instance = instance != null ? instance : new BuildTriggerPolicy();
    if (instance != null) {
        this.withBitbucket(instance.getBitbucket());
        this.withGeneric(instance.getGeneric());
        this.withGithub(instance.getGithub());
        this.withGitlab(instance.getGitlab());
        this.withImageChange(instance.getImageChange());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BitbucketNested<A> editBitbucket() {
    return this.withNewBitbucketLike(Optional.ofNullable(this.buildBitbucket()).orElse(null));
  }
  
  public GenericNested<A> editGeneric() {
    return this.withNewGenericLike(Optional.ofNullable(this.buildGeneric()).orElse(null));
  }
  
  public GithubNested<A> editGithub() {
    return this.withNewGithubLike(Optional.ofNullable(this.buildGithub()).orElse(null));
  }
  
  public GitlabNested<A> editGitlab() {
    return this.withNewGitlabLike(Optional.ofNullable(this.buildGitlab()).orElse(null));
  }
  
  public ImageChangeNested<A> editImageChange() {
    return this.withNewImageChangeLike(Optional.ofNullable(this.buildImageChange()).orElse(null));
  }
  
  public BitbucketNested<A> editOrNewBitbucket() {
    return this.withNewBitbucketLike(Optional.ofNullable(this.buildBitbucket()).orElse(new WebHookTriggerBuilder().build()));
  }
  
  public BitbucketNested<A> editOrNewBitbucketLike(WebHookTrigger item) {
    return this.withNewBitbucketLike(Optional.ofNullable(this.buildBitbucket()).orElse(item));
  }
  
  public GenericNested<A> editOrNewGeneric() {
    return this.withNewGenericLike(Optional.ofNullable(this.buildGeneric()).orElse(new WebHookTriggerBuilder().build()));
  }
  
  public GenericNested<A> editOrNewGenericLike(WebHookTrigger item) {
    return this.withNewGenericLike(Optional.ofNullable(this.buildGeneric()).orElse(item));
  }
  
  public GithubNested<A> editOrNewGithub() {
    return this.withNewGithubLike(Optional.ofNullable(this.buildGithub()).orElse(new WebHookTriggerBuilder().build()));
  }
  
  public GithubNested<A> editOrNewGithubLike(WebHookTrigger item) {
    return this.withNewGithubLike(Optional.ofNullable(this.buildGithub()).orElse(item));
  }
  
  public GitlabNested<A> editOrNewGitlab() {
    return this.withNewGitlabLike(Optional.ofNullable(this.buildGitlab()).orElse(new WebHookTriggerBuilder().build()));
  }
  
  public GitlabNested<A> editOrNewGitlabLike(WebHookTrigger item) {
    return this.withNewGitlabLike(Optional.ofNullable(this.buildGitlab()).orElse(item));
  }
  
  public ImageChangeNested<A> editOrNewImageChange() {
    return this.withNewImageChangeLike(Optional.ofNullable(this.buildImageChange()).orElse(new ImageChangeTriggerBuilder().build()));
  }
  
  public ImageChangeNested<A> editOrNewImageChangeLike(ImageChangeTrigger item) {
    return this.withNewImageChangeLike(Optional.ofNullable(this.buildImageChange()).orElse(item));
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
    BuildTriggerPolicyFluent that = (BuildTriggerPolicyFluent) o;
    if (!(Objects.equals(bitbucket, that.bitbucket))) {
      return false;
    }
    if (!(Objects.equals(generic, that.generic))) {
      return false;
    }
    if (!(Objects.equals(github, that.github))) {
      return false;
    }
    if (!(Objects.equals(gitlab, that.gitlab))) {
      return false;
    }
    if (!(Objects.equals(imageChange, that.imageChange))) {
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
  
  public boolean hasBitbucket() {
    return this.bitbucket != null;
  }
  
  public boolean hasGeneric() {
    return this.generic != null;
  }
  
  public boolean hasGithub() {
    return this.github != null;
  }
  
  public boolean hasGitlab() {
    return this.gitlab != null;
  }
  
  public boolean hasImageChange() {
    return this.imageChange != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(bitbucket, generic, github, gitlab, imageChange, type, additionalProperties);
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
    if (!(bitbucket == null)) {
        sb.append("bitbucket:");
        sb.append(bitbucket);
        sb.append(",");
    }
    if (!(generic == null)) {
        sb.append("generic:");
        sb.append(generic);
        sb.append(",");
    }
    if (!(github == null)) {
        sb.append("github:");
        sb.append(github);
        sb.append(",");
    }
    if (!(gitlab == null)) {
        sb.append("gitlab:");
        sb.append(gitlab);
        sb.append(",");
    }
    if (!(imageChange == null)) {
        sb.append("imageChange:");
        sb.append(imageChange);
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
  
  public A withBitbucket(WebHookTrigger bitbucket) {
    this._visitables.remove("bitbucket");
    if (bitbucket != null) {
        this.bitbucket = new WebHookTriggerBuilder(bitbucket);
        this._visitables.get("bitbucket").add(this.bitbucket);
    } else {
        this.bitbucket = null;
        this._visitables.get("bitbucket").remove(this.bitbucket);
    }
    return (A) this;
  }
  
  public A withGeneric(WebHookTrigger generic) {
    this._visitables.remove("generic");
    if (generic != null) {
        this.generic = new WebHookTriggerBuilder(generic);
        this._visitables.get("generic").add(this.generic);
    } else {
        this.generic = null;
        this._visitables.get("generic").remove(this.generic);
    }
    return (A) this;
  }
  
  public A withGithub(WebHookTrigger github) {
    this._visitables.remove("github");
    if (github != null) {
        this.github = new WebHookTriggerBuilder(github);
        this._visitables.get("github").add(this.github);
    } else {
        this.github = null;
        this._visitables.get("github").remove(this.github);
    }
    return (A) this;
  }
  
  public A withGitlab(WebHookTrigger gitlab) {
    this._visitables.remove("gitlab");
    if (gitlab != null) {
        this.gitlab = new WebHookTriggerBuilder(gitlab);
        this._visitables.get("gitlab").add(this.gitlab);
    } else {
        this.gitlab = null;
        this._visitables.get("gitlab").remove(this.gitlab);
    }
    return (A) this;
  }
  
  public A withImageChange(ImageChangeTrigger imageChange) {
    this._visitables.remove("imageChange");
    if (imageChange != null) {
        this.imageChange = new ImageChangeTriggerBuilder(imageChange);
        this._visitables.get("imageChange").add(this.imageChange);
    } else {
        this.imageChange = null;
        this._visitables.get("imageChange").remove(this.imageChange);
    }
    return (A) this;
  }
  
  public BitbucketNested<A> withNewBitbucket() {
    return new BitbucketNested(null);
  }
  
  public BitbucketNested<A> withNewBitbucketLike(WebHookTrigger item) {
    return new BitbucketNested(item);
  }
  
  public GenericNested<A> withNewGeneric() {
    return new GenericNested(null);
  }
  
  public GenericNested<A> withNewGenericLike(WebHookTrigger item) {
    return new GenericNested(item);
  }
  
  public GithubNested<A> withNewGithub() {
    return new GithubNested(null);
  }
  
  public GithubNested<A> withNewGithubLike(WebHookTrigger item) {
    return new GithubNested(item);
  }
  
  public GitlabNested<A> withNewGitlab() {
    return new GitlabNested(null);
  }
  
  public GitlabNested<A> withNewGitlabLike(WebHookTrigger item) {
    return new GitlabNested(item);
  }
  
  public ImageChangeNested<A> withNewImageChange() {
    return new ImageChangeNested(null);
  }
  
  public ImageChangeNested<A> withNewImageChangeLike(ImageChangeTrigger item) {
    return new ImageChangeNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class BitbucketNested<N> extends WebHookTriggerFluent<BitbucketNested<N>> implements Nested<N>{
  
    WebHookTriggerBuilder builder;
  
    BitbucketNested(WebHookTrigger item) {
      this.builder = new WebHookTriggerBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildTriggerPolicyFluent.this.withBitbucket(builder.build());
    }
    
    public N endBitbucket() {
      return and();
    }
    
  }
  public class GenericNested<N> extends WebHookTriggerFluent<GenericNested<N>> implements Nested<N>{
  
    WebHookTriggerBuilder builder;
  
    GenericNested(WebHookTrigger item) {
      this.builder = new WebHookTriggerBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildTriggerPolicyFluent.this.withGeneric(builder.build());
    }
    
    public N endGeneric() {
      return and();
    }
    
  }
  public class GithubNested<N> extends WebHookTriggerFluent<GithubNested<N>> implements Nested<N>{
  
    WebHookTriggerBuilder builder;
  
    GithubNested(WebHookTrigger item) {
      this.builder = new WebHookTriggerBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildTriggerPolicyFluent.this.withGithub(builder.build());
    }
    
    public N endGithub() {
      return and();
    }
    
  }
  public class GitlabNested<N> extends WebHookTriggerFluent<GitlabNested<N>> implements Nested<N>{
  
    WebHookTriggerBuilder builder;
  
    GitlabNested(WebHookTrigger item) {
      this.builder = new WebHookTriggerBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildTriggerPolicyFluent.this.withGitlab(builder.build());
    }
    
    public N endGitlab() {
      return and();
    }
    
  }
  public class ImageChangeNested<N> extends ImageChangeTriggerFluent<ImageChangeNested<N>> implements Nested<N>{
  
    ImageChangeTriggerBuilder builder;
  
    ImageChangeNested(ImageChangeTrigger item) {
      this.builder = new ImageChangeTriggerBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildTriggerPolicyFluent.this.withImageChange(builder.build());
    }
    
    public N endImageChange() {
      return and();
    }
    
  }
}