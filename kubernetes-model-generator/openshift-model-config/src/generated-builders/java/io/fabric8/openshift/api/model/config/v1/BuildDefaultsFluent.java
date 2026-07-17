package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.EnvVarFluent;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
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
public class BuildDefaultsFluent<A extends io.fabric8.openshift.api.model.config.v1.BuildDefaultsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ProxySpecBuilder defaultProxy;
  private ArrayList<EnvVarBuilder> env = new ArrayList<EnvVarBuilder>();
  private ProxySpecBuilder gitProxy;
  private ArrayList<ImageLabelBuilder> imageLabels = new ArrayList<ImageLabelBuilder>();
  private ResourceRequirementsBuilder resources;

  public BuildDefaultsFluent() {
  }
  
  public BuildDefaultsFluent(BuildDefaults instance) {
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
  
  public A addAllToImageLabels(Collection<ImageLabel> items) {
    if (this.imageLabels == null) {
      this.imageLabels = new ArrayList();
    }
    for (ImageLabel item : items) {
        ImageLabelBuilder builder = new ImageLabelBuilder(item);
        _visitables.get("imageLabels").add(builder);
        this.imageLabels.add(builder);
    }
    return (A) this;
  }
  
  public EnvNested<A> addNewEnv() {
    return new EnvNested(-1, null);
  }
  
  public EnvNested<A> addNewEnvLike(EnvVar item) {
    return new EnvNested(-1, item);
  }
  
  public ImageLabelsNested<A> addNewImageLabel() {
    return new ImageLabelsNested(-1, null);
  }
  
  public A addNewImageLabel(String name,String value) {
    return (A) this.addToImageLabels(new ImageLabel(name, value));
  }
  
  public ImageLabelsNested<A> addNewImageLabelLike(ImageLabel item) {
    return new ImageLabelsNested(-1, item);
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
  
  public A addToImageLabels(ImageLabel... items) {
    if (this.imageLabels == null) {
      this.imageLabels = new ArrayList();
    }
    for (ImageLabel item : items) {
        ImageLabelBuilder builder = new ImageLabelBuilder(item);
        _visitables.get("imageLabels").add(builder);
        this.imageLabels.add(builder);
    }
    return (A) this;
  }
  
  public A addToImageLabels(int index,ImageLabel item) {
    if (this.imageLabels == null) {
      this.imageLabels = new ArrayList();
    }
    ImageLabelBuilder builder = new ImageLabelBuilder(item);
    if (index < 0 || index >= imageLabels.size()) {
        _visitables.get("imageLabels").add(builder);
        imageLabels.add(builder);
    } else {
        _visitables.get("imageLabels").add(builder);
        imageLabels.add(index, builder);
    }
    return (A) this;
  }
  
  public ProxySpec buildDefaultProxy() {
    return this.defaultProxy != null ? this.defaultProxy.build() : null;
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
  
  public ImageLabel buildFirstImageLabel() {
    return this.imageLabels.get(0).build();
  }
  
  public ProxySpec buildGitProxy() {
    return this.gitProxy != null ? this.gitProxy.build() : null;
  }
  
  public ImageLabel buildImageLabel(int index) {
    return this.imageLabels.get(index).build();
  }
  
  public List<ImageLabel> buildImageLabels() {
    return this.imageLabels != null ? build(imageLabels) : null;
  }
  
  public EnvVar buildLastEnv() {
    return this.env.get(env.size() - 1).build();
  }
  
  public ImageLabel buildLastImageLabel() {
    return this.imageLabels.get(imageLabels.size() - 1).build();
  }
  
  public EnvVar buildMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ImageLabel buildMatchingImageLabel(Predicate<ImageLabelBuilder> predicate) {
      for (ImageLabelBuilder item : imageLabels) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  protected void copyInstance(BuildDefaults instance) {
    instance = instance != null ? instance : new BuildDefaults();
    if (instance != null) {
        this.withDefaultProxy(instance.getDefaultProxy());
        this.withEnv(instance.getEnv());
        this.withGitProxy(instance.getGitProxy());
        this.withImageLabels(instance.getImageLabels());
        this.withResources(instance.getResources());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DefaultProxyNested<A> editDefaultProxy() {
    return this.withNewDefaultProxyLike(Optional.ofNullable(this.buildDefaultProxy()).orElse(null));
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
  
  public ImageLabelsNested<A> editFirstImageLabel() {
    if (imageLabels.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imageLabels"));
    }
    return this.setNewImageLabelLike(0, this.buildImageLabel(0));
  }
  
  public GitProxyNested<A> editGitProxy() {
    return this.withNewGitProxyLike(Optional.ofNullable(this.buildGitProxy()).orElse(null));
  }
  
  public ImageLabelsNested<A> editImageLabel(int index) {
    if (imageLabels.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imageLabels"));
    }
    return this.setNewImageLabelLike(index, this.buildImageLabel(index));
  }
  
  public EnvNested<A> editLastEnv() {
    int index = env.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public ImageLabelsNested<A> editLastImageLabel() {
    int index = imageLabels.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imageLabels"));
    }
    return this.setNewImageLabelLike(index, this.buildImageLabel(index));
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
  
  public ImageLabelsNested<A> editMatchingImageLabel(Predicate<ImageLabelBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imageLabels.size();i++) {
      if (predicate.test(imageLabels.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imageLabels"));
    }
    return this.setNewImageLabelLike(index, this.buildImageLabel(index));
  }
  
  public DefaultProxyNested<A> editOrNewDefaultProxy() {
    return this.withNewDefaultProxyLike(Optional.ofNullable(this.buildDefaultProxy()).orElse(new ProxySpecBuilder().build()));
  }
  
  public DefaultProxyNested<A> editOrNewDefaultProxyLike(ProxySpec item) {
    return this.withNewDefaultProxyLike(Optional.ofNullable(this.buildDefaultProxy()).orElse(item));
  }
  
  public GitProxyNested<A> editOrNewGitProxy() {
    return this.withNewGitProxyLike(Optional.ofNullable(this.buildGitProxy()).orElse(new ProxySpecBuilder().build()));
  }
  
  public GitProxyNested<A> editOrNewGitProxyLike(ProxySpec item) {
    return this.withNewGitProxyLike(Optional.ofNullable(this.buildGitProxy()).orElse(item));
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
    BuildDefaultsFluent that = (BuildDefaultsFluent) o;
    if (!(Objects.equals(defaultProxy, that.defaultProxy))) {
      return false;
    }
    if (!(Objects.equals(env, that.env))) {
      return false;
    }
    if (!(Objects.equals(gitProxy, that.gitProxy))) {
      return false;
    }
    if (!(Objects.equals(imageLabels, that.imageLabels))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDefaultProxy() {
    return this.defaultProxy != null;
  }
  
  public boolean hasEnv() {
    return this.env != null && !(this.env.isEmpty());
  }
  
  public boolean hasGitProxy() {
    return this.gitProxy != null;
  }
  
  public boolean hasImageLabels() {
    return this.imageLabels != null && !(this.imageLabels.isEmpty());
  }
  
  public boolean hasMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingImageLabel(Predicate<ImageLabelBuilder> predicate) {
      for (ImageLabelBuilder item : imageLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public int hashCode() {
    return Objects.hash(defaultProxy, env, gitProxy, imageLabels, resources, additionalProperties);
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
  
  public A removeAllFromImageLabels(Collection<ImageLabel> items) {
    if (this.imageLabels == null) {
      return (A) this;
    }
    for (ImageLabel item : items) {
        ImageLabelBuilder builder = new ImageLabelBuilder(item);
        _visitables.get("imageLabels").remove(builder);
        this.imageLabels.remove(builder);
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
  
  public A removeFromImageLabels(ImageLabel... items) {
    if (this.imageLabels == null) {
      return (A) this;
    }
    for (ImageLabel item : items) {
        ImageLabelBuilder builder = new ImageLabelBuilder(item);
        _visitables.get("imageLabels").remove(builder);
        this.imageLabels.remove(builder);
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
  
  public A removeMatchingFromImageLabels(Predicate<ImageLabelBuilder> predicate) {
    if (imageLabels == null) {
      return (A) this;
    }
    Iterator<ImageLabelBuilder> each = imageLabels.iterator();
    List visitables = _visitables.get("imageLabels");
    while (each.hasNext()) {
        ImageLabelBuilder builder = each.next();
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
  
  public ImageLabelsNested<A> setNewImageLabelLike(int index,ImageLabel item) {
    return new ImageLabelsNested(index, item);
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
  
  public A setToImageLabels(int index,ImageLabel item) {
    if (this.imageLabels == null) {
      this.imageLabels = new ArrayList();
    }
    ImageLabelBuilder builder = new ImageLabelBuilder(item);
    if (index < 0 || index >= imageLabels.size()) {
        _visitables.get("imageLabels").add(builder);
        imageLabels.add(builder);
    } else {
        _visitables.get("imageLabels").add(builder);
        imageLabels.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(defaultProxy == null)) {
        sb.append("defaultProxy:");
        sb.append(defaultProxy);
        sb.append(",");
    }
    if (!(env == null) && !(env.isEmpty())) {
        sb.append("env:");
        sb.append(env);
        sb.append(",");
    }
    if (!(gitProxy == null)) {
        sb.append("gitProxy:");
        sb.append(gitProxy);
        sb.append(",");
    }
    if (!(imageLabels == null) && !(imageLabels.isEmpty())) {
        sb.append("imageLabels:");
        sb.append(imageLabels);
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
  
  public A withDefaultProxy(ProxySpec defaultProxy) {
    this._visitables.remove("defaultProxy");
    if (defaultProxy != null) {
        this.defaultProxy = new ProxySpecBuilder(defaultProxy);
        this._visitables.get("defaultProxy").add(this.defaultProxy);
    } else {
        this.defaultProxy = null;
        this._visitables.get("defaultProxy").remove(this.defaultProxy);
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
  
  public A withGitProxy(ProxySpec gitProxy) {
    this._visitables.remove("gitProxy");
    if (gitProxy != null) {
        this.gitProxy = new ProxySpecBuilder(gitProxy);
        this._visitables.get("gitProxy").add(this.gitProxy);
    } else {
        this.gitProxy = null;
        this._visitables.get("gitProxy").remove(this.gitProxy);
    }
    return (A) this;
  }
  
  public A withImageLabels(List<ImageLabel> imageLabels) {
    if (this.imageLabels != null) {
      this._visitables.get("imageLabels").clear();
    }
    if (imageLabels != null) {
        this.imageLabels = new ArrayList();
        for (ImageLabel item : imageLabels) {
          this.addToImageLabels(item);
        }
    } else {
      this.imageLabels = null;
    }
    return (A) this;
  }
  
  public A withImageLabels(ImageLabel... imageLabels) {
    if (this.imageLabels != null) {
        this.imageLabels.clear();
        _visitables.remove("imageLabels");
    }
    if (imageLabels != null) {
      for (ImageLabel item : imageLabels) {
        this.addToImageLabels(item);
      }
    }
    return (A) this;
  }
  
  public DefaultProxyNested<A> withNewDefaultProxy() {
    return new DefaultProxyNested(null);
  }
  
  public DefaultProxyNested<A> withNewDefaultProxyLike(ProxySpec item) {
    return new DefaultProxyNested(item);
  }
  
  public GitProxyNested<A> withNewGitProxy() {
    return new GitProxyNested(null);
  }
  
  public GitProxyNested<A> withNewGitProxyLike(ProxySpec item) {
    return new GitProxyNested(item);
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
  public class DefaultProxyNested<N> extends ProxySpecFluent<DefaultProxyNested<N>> implements Nested<N>{
  
    ProxySpecBuilder builder;
  
    DefaultProxyNested(ProxySpec item) {
      this.builder = new ProxySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildDefaultsFluent.this.withDefaultProxy(builder.build());
    }
    
    public N endDefaultProxy() {
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
      return (N) BuildDefaultsFluent.this.setToEnv(index, builder.build());
    }
    
    public N endEnv() {
      return and();
    }
    
  }
  public class GitProxyNested<N> extends ProxySpecFluent<GitProxyNested<N>> implements Nested<N>{
  
    ProxySpecBuilder builder;
  
    GitProxyNested(ProxySpec item) {
      this.builder = new ProxySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildDefaultsFluent.this.withGitProxy(builder.build());
    }
    
    public N endGitProxy() {
      return and();
    }
    
  }
  public class ImageLabelsNested<N> extends ImageLabelFluent<ImageLabelsNested<N>> implements Nested<N>{
  
    ImageLabelBuilder builder;
    int index;
  
    ImageLabelsNested(int index,ImageLabel item) {
      this.index = index;
      this.builder = new ImageLabelBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildDefaultsFluent.this.setToImageLabels(index, builder.build());
    }
    
    public N endImageLabel() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildDefaultsFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
}