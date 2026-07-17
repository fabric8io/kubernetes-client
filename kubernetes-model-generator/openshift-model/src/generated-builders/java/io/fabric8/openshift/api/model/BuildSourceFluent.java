package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class BuildSourceFluent<A extends io.fabric8.openshift.api.model.BuildSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BinaryBuildSourceBuilder binary;
  private ArrayList<ConfigMapBuildSourceBuilder> configMaps = new ArrayList<ConfigMapBuildSourceBuilder>();
  private String contextDir;
  private String dockerfile;
  private GitBuildSourceBuilder git;
  private ArrayList<ImageSourceBuilder> images = new ArrayList<ImageSourceBuilder>();
  private ArrayList<SecretBuildSourceBuilder> secrets = new ArrayList<SecretBuildSourceBuilder>();
  private LocalObjectReferenceBuilder sourceSecret;
  private String type;

  public BuildSourceFluent() {
  }
  
  public BuildSourceFluent(BuildSource instance) {
    this.copyInstance(instance);
  }

  public A addAllToConfigMaps(Collection<ConfigMapBuildSource> items) {
    if (this.configMaps == null) {
      this.configMaps = new ArrayList();
    }
    for (ConfigMapBuildSource item : items) {
        ConfigMapBuildSourceBuilder builder = new ConfigMapBuildSourceBuilder(item);
        _visitables.get("configMaps").add(builder);
        this.configMaps.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToImages(Collection<ImageSource> items) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    for (ImageSource item : items) {
        ImageSourceBuilder builder = new ImageSourceBuilder(item);
        _visitables.get("images").add(builder);
        this.images.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSecrets(Collection<SecretBuildSource> items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (SecretBuildSource item : items) {
        SecretBuildSourceBuilder builder = new SecretBuildSourceBuilder(item);
        _visitables.get("secrets").add(builder);
        this.secrets.add(builder);
    }
    return (A) this;
  }
  
  public ConfigMapsNested<A> addNewConfigMap() {
    return new ConfigMapsNested(-1, null);
  }
  
  public ConfigMapsNested<A> addNewConfigMapLike(ConfigMapBuildSource item) {
    return new ConfigMapsNested(-1, item);
  }
  
  public ImagesNested<A> addNewImage() {
    return new ImagesNested(-1, null);
  }
  
  public ImagesNested<A> addNewImageLike(ImageSource item) {
    return new ImagesNested(-1, item);
  }
  
  public SecretsNested<A> addNewSecret() {
    return new SecretsNested(-1, null);
  }
  
  public SecretsNested<A> addNewSecretLike(SecretBuildSource item) {
    return new SecretsNested(-1, item);
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
  
  public A addToConfigMaps(ConfigMapBuildSource... items) {
    if (this.configMaps == null) {
      this.configMaps = new ArrayList();
    }
    for (ConfigMapBuildSource item : items) {
        ConfigMapBuildSourceBuilder builder = new ConfigMapBuildSourceBuilder(item);
        _visitables.get("configMaps").add(builder);
        this.configMaps.add(builder);
    }
    return (A) this;
  }
  
  public A addToConfigMaps(int index,ConfigMapBuildSource item) {
    if (this.configMaps == null) {
      this.configMaps = new ArrayList();
    }
    ConfigMapBuildSourceBuilder builder = new ConfigMapBuildSourceBuilder(item);
    if (index < 0 || index >= configMaps.size()) {
        _visitables.get("configMaps").add(builder);
        configMaps.add(builder);
    } else {
        _visitables.get("configMaps").add(builder);
        configMaps.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToImages(ImageSource... items) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    for (ImageSource item : items) {
        ImageSourceBuilder builder = new ImageSourceBuilder(item);
        _visitables.get("images").add(builder);
        this.images.add(builder);
    }
    return (A) this;
  }
  
  public A addToImages(int index,ImageSource item) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    ImageSourceBuilder builder = new ImageSourceBuilder(item);
    if (index < 0 || index >= images.size()) {
        _visitables.get("images").add(builder);
        images.add(builder);
    } else {
        _visitables.get("images").add(builder);
        images.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSecrets(SecretBuildSource... items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (SecretBuildSource item : items) {
        SecretBuildSourceBuilder builder = new SecretBuildSourceBuilder(item);
        _visitables.get("secrets").add(builder);
        this.secrets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSecrets(int index,SecretBuildSource item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    SecretBuildSourceBuilder builder = new SecretBuildSourceBuilder(item);
    if (index < 0 || index >= secrets.size()) {
        _visitables.get("secrets").add(builder);
        secrets.add(builder);
    } else {
        _visitables.get("secrets").add(builder);
        secrets.add(index, builder);
    }
    return (A) this;
  }
  
  public BinaryBuildSource buildBinary() {
    return this.binary != null ? this.binary.build() : null;
  }
  
  public ConfigMapBuildSource buildConfigMap(int index) {
    return this.configMaps.get(index).build();
  }
  
  public List<ConfigMapBuildSource> buildConfigMaps() {
    return this.configMaps != null ? build(configMaps) : null;
  }
  
  public ConfigMapBuildSource buildFirstConfigMap() {
    return this.configMaps.get(0).build();
  }
  
  public ImageSource buildFirstImage() {
    return this.images.get(0).build();
  }
  
  public SecretBuildSource buildFirstSecret() {
    return this.secrets.get(0).build();
  }
  
  public GitBuildSource buildGit() {
    return this.git != null ? this.git.build() : null;
  }
  
  public ImageSource buildImage(int index) {
    return this.images.get(index).build();
  }
  
  public List<ImageSource> buildImages() {
    return this.images != null ? build(images) : null;
  }
  
  public ConfigMapBuildSource buildLastConfigMap() {
    return this.configMaps.get(configMaps.size() - 1).build();
  }
  
  public ImageSource buildLastImage() {
    return this.images.get(images.size() - 1).build();
  }
  
  public SecretBuildSource buildLastSecret() {
    return this.secrets.get(secrets.size() - 1).build();
  }
  
  public ConfigMapBuildSource buildMatchingConfigMap(Predicate<ConfigMapBuildSourceBuilder> predicate) {
      for (ConfigMapBuildSourceBuilder item : configMaps) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ImageSource buildMatchingImage(Predicate<ImageSourceBuilder> predicate) {
      for (ImageSourceBuilder item : images) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SecretBuildSource buildMatchingSecret(Predicate<SecretBuildSourceBuilder> predicate) {
      for (SecretBuildSourceBuilder item : secrets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SecretBuildSource buildSecret(int index) {
    return this.secrets.get(index).build();
  }
  
  public List<SecretBuildSource> buildSecrets() {
    return this.secrets != null ? build(secrets) : null;
  }
  
  public LocalObjectReference buildSourceSecret() {
    return this.sourceSecret != null ? this.sourceSecret.build() : null;
  }
  
  protected void copyInstance(BuildSource instance) {
    instance = instance != null ? instance : new BuildSource();
    if (instance != null) {
        this.withBinary(instance.getBinary());
        this.withConfigMaps(instance.getConfigMaps());
        this.withContextDir(instance.getContextDir());
        this.withDockerfile(instance.getDockerfile());
        this.withGit(instance.getGit());
        this.withImages(instance.getImages());
        this.withSecrets(instance.getSecrets());
        this.withSourceSecret(instance.getSourceSecret());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BinaryNested<A> editBinary() {
    return this.withNewBinaryLike(Optional.ofNullable(this.buildBinary()).orElse(null));
  }
  
  public ConfigMapsNested<A> editConfigMap(int index) {
    if (configMaps.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "configMaps"));
    }
    return this.setNewConfigMapLike(index, this.buildConfigMap(index));
  }
  
  public ConfigMapsNested<A> editFirstConfigMap() {
    if (configMaps.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "configMaps"));
    }
    return this.setNewConfigMapLike(0, this.buildConfigMap(0));
  }
  
  public ImagesNested<A> editFirstImage() {
    if (images.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "images"));
    }
    return this.setNewImageLike(0, this.buildImage(0));
  }
  
  public SecretsNested<A> editFirstSecret() {
    if (secrets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "secrets"));
    }
    return this.setNewSecretLike(0, this.buildSecret(0));
  }
  
  public GitNested<A> editGit() {
    return this.withNewGitLike(Optional.ofNullable(this.buildGit()).orElse(null));
  }
  
  public ImagesNested<A> editImage(int index) {
    if (images.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "images"));
    }
    return this.setNewImageLike(index, this.buildImage(index));
  }
  
  public ConfigMapsNested<A> editLastConfigMap() {
    int index = configMaps.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "configMaps"));
    }
    return this.setNewConfigMapLike(index, this.buildConfigMap(index));
  }
  
  public ImagesNested<A> editLastImage() {
    int index = images.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "images"));
    }
    return this.setNewImageLike(index, this.buildImage(index));
  }
  
  public SecretsNested<A> editLastSecret() {
    int index = secrets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "secrets"));
    }
    return this.setNewSecretLike(index, this.buildSecret(index));
  }
  
  public ConfigMapsNested<A> editMatchingConfigMap(Predicate<ConfigMapBuildSourceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < configMaps.size();i++) {
      if (predicate.test(configMaps.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "configMaps"));
    }
    return this.setNewConfigMapLike(index, this.buildConfigMap(index));
  }
  
  public ImagesNested<A> editMatchingImage(Predicate<ImageSourceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < images.size();i++) {
      if (predicate.test(images.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "images"));
    }
    return this.setNewImageLike(index, this.buildImage(index));
  }
  
  public SecretsNested<A> editMatchingSecret(Predicate<SecretBuildSourceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < secrets.size();i++) {
      if (predicate.test(secrets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "secrets"));
    }
    return this.setNewSecretLike(index, this.buildSecret(index));
  }
  
  public BinaryNested<A> editOrNewBinary() {
    return this.withNewBinaryLike(Optional.ofNullable(this.buildBinary()).orElse(new BinaryBuildSourceBuilder().build()));
  }
  
  public BinaryNested<A> editOrNewBinaryLike(BinaryBuildSource item) {
    return this.withNewBinaryLike(Optional.ofNullable(this.buildBinary()).orElse(item));
  }
  
  public GitNested<A> editOrNewGit() {
    return this.withNewGitLike(Optional.ofNullable(this.buildGit()).orElse(new GitBuildSourceBuilder().build()));
  }
  
  public GitNested<A> editOrNewGitLike(GitBuildSource item) {
    return this.withNewGitLike(Optional.ofNullable(this.buildGit()).orElse(item));
  }
  
  public SourceSecretNested<A> editOrNewSourceSecret() {
    return this.withNewSourceSecretLike(Optional.ofNullable(this.buildSourceSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public SourceSecretNested<A> editOrNewSourceSecretLike(LocalObjectReference item) {
    return this.withNewSourceSecretLike(Optional.ofNullable(this.buildSourceSecret()).orElse(item));
  }
  
  public SecretsNested<A> editSecret(int index) {
    if (secrets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "secrets"));
    }
    return this.setNewSecretLike(index, this.buildSecret(index));
  }
  
  public SourceSecretNested<A> editSourceSecret() {
    return this.withNewSourceSecretLike(Optional.ofNullable(this.buildSourceSecret()).orElse(null));
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
    BuildSourceFluent that = (BuildSourceFluent) o;
    if (!(Objects.equals(binary, that.binary))) {
      return false;
    }
    if (!(Objects.equals(configMaps, that.configMaps))) {
      return false;
    }
    if (!(Objects.equals(contextDir, that.contextDir))) {
      return false;
    }
    if (!(Objects.equals(dockerfile, that.dockerfile))) {
      return false;
    }
    if (!(Objects.equals(git, that.git))) {
      return false;
    }
    if (!(Objects.equals(images, that.images))) {
      return false;
    }
    if (!(Objects.equals(secrets, that.secrets))) {
      return false;
    }
    if (!(Objects.equals(sourceSecret, that.sourceSecret))) {
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
  
  public String getContextDir() {
    return this.contextDir;
  }
  
  public String getDockerfile() {
    return this.dockerfile;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBinary() {
    return this.binary != null;
  }
  
  public boolean hasConfigMaps() {
    return this.configMaps != null && !(this.configMaps.isEmpty());
  }
  
  public boolean hasContextDir() {
    return this.contextDir != null;
  }
  
  public boolean hasDockerfile() {
    return this.dockerfile != null;
  }
  
  public boolean hasGit() {
    return this.git != null;
  }
  
  public boolean hasImages() {
    return this.images != null && !(this.images.isEmpty());
  }
  
  public boolean hasMatchingConfigMap(Predicate<ConfigMapBuildSourceBuilder> predicate) {
      for (ConfigMapBuildSourceBuilder item : configMaps) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingImage(Predicate<ImageSourceBuilder> predicate) {
      for (ImageSourceBuilder item : images) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSecret(Predicate<SecretBuildSourceBuilder> predicate) {
      for (SecretBuildSourceBuilder item : secrets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSecrets() {
    return this.secrets != null && !(this.secrets.isEmpty());
  }
  
  public boolean hasSourceSecret() {
    return this.sourceSecret != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(binary, configMaps, contextDir, dockerfile, git, images, secrets, sourceSecret, type, additionalProperties);
  }
  
  public A removeAllFromConfigMaps(Collection<ConfigMapBuildSource> items) {
    if (this.configMaps == null) {
      return (A) this;
    }
    for (ConfigMapBuildSource item : items) {
        ConfigMapBuildSourceBuilder builder = new ConfigMapBuildSourceBuilder(item);
        _visitables.get("configMaps").remove(builder);
        this.configMaps.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromImages(Collection<ImageSource> items) {
    if (this.images == null) {
      return (A) this;
    }
    for (ImageSource item : items) {
        ImageSourceBuilder builder = new ImageSourceBuilder(item);
        _visitables.get("images").remove(builder);
        this.images.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSecrets(Collection<SecretBuildSource> items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (SecretBuildSource item : items) {
        SecretBuildSourceBuilder builder = new SecretBuildSourceBuilder(item);
        _visitables.get("secrets").remove(builder);
        this.secrets.remove(builder);
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
  
  public A removeFromConfigMaps(ConfigMapBuildSource... items) {
    if (this.configMaps == null) {
      return (A) this;
    }
    for (ConfigMapBuildSource item : items) {
        ConfigMapBuildSourceBuilder builder = new ConfigMapBuildSourceBuilder(item);
        _visitables.get("configMaps").remove(builder);
        this.configMaps.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromImages(ImageSource... items) {
    if (this.images == null) {
      return (A) this;
    }
    for (ImageSource item : items) {
        ImageSourceBuilder builder = new ImageSourceBuilder(item);
        _visitables.get("images").remove(builder);
        this.images.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSecrets(SecretBuildSource... items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (SecretBuildSource item : items) {
        SecretBuildSourceBuilder builder = new SecretBuildSourceBuilder(item);
        _visitables.get("secrets").remove(builder);
        this.secrets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConfigMaps(Predicate<ConfigMapBuildSourceBuilder> predicate) {
    if (configMaps == null) {
      return (A) this;
    }
    Iterator<ConfigMapBuildSourceBuilder> each = configMaps.iterator();
    List visitables = _visitables.get("configMaps");
    while (each.hasNext()) {
        ConfigMapBuildSourceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromImages(Predicate<ImageSourceBuilder> predicate) {
    if (images == null) {
      return (A) this;
    }
    Iterator<ImageSourceBuilder> each = images.iterator();
    List visitables = _visitables.get("images");
    while (each.hasNext()) {
        ImageSourceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSecrets(Predicate<SecretBuildSourceBuilder> predicate) {
    if (secrets == null) {
      return (A) this;
    }
    Iterator<SecretBuildSourceBuilder> each = secrets.iterator();
    List visitables = _visitables.get("secrets");
    while (each.hasNext()) {
        SecretBuildSourceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConfigMapsNested<A> setNewConfigMapLike(int index,ConfigMapBuildSource item) {
    return new ConfigMapsNested(index, item);
  }
  
  public ImagesNested<A> setNewImageLike(int index,ImageSource item) {
    return new ImagesNested(index, item);
  }
  
  public SecretsNested<A> setNewSecretLike(int index,SecretBuildSource item) {
    return new SecretsNested(index, item);
  }
  
  public A setToConfigMaps(int index,ConfigMapBuildSource item) {
    if (this.configMaps == null) {
      this.configMaps = new ArrayList();
    }
    ConfigMapBuildSourceBuilder builder = new ConfigMapBuildSourceBuilder(item);
    if (index < 0 || index >= configMaps.size()) {
        _visitables.get("configMaps").add(builder);
        configMaps.add(builder);
    } else {
        _visitables.get("configMaps").add(builder);
        configMaps.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToImages(int index,ImageSource item) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    ImageSourceBuilder builder = new ImageSourceBuilder(item);
    if (index < 0 || index >= images.size()) {
        _visitables.get("images").add(builder);
        images.add(builder);
    } else {
        _visitables.get("images").add(builder);
        images.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSecrets(int index,SecretBuildSource item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    SecretBuildSourceBuilder builder = new SecretBuildSourceBuilder(item);
    if (index < 0 || index >= secrets.size()) {
        _visitables.get("secrets").add(builder);
        secrets.add(builder);
    } else {
        _visitables.get("secrets").add(builder);
        secrets.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(binary == null)) {
        sb.append("binary:");
        sb.append(binary);
        sb.append(",");
    }
    if (!(configMaps == null) && !(configMaps.isEmpty())) {
        sb.append("configMaps:");
        sb.append(configMaps);
        sb.append(",");
    }
    if (!(contextDir == null)) {
        sb.append("contextDir:");
        sb.append(contextDir);
        sb.append(",");
    }
    if (!(dockerfile == null)) {
        sb.append("dockerfile:");
        sb.append(dockerfile);
        sb.append(",");
    }
    if (!(git == null)) {
        sb.append("git:");
        sb.append(git);
        sb.append(",");
    }
    if (!(images == null) && !(images.isEmpty())) {
        sb.append("images:");
        sb.append(images);
        sb.append(",");
    }
    if (!(secrets == null) && !(secrets.isEmpty())) {
        sb.append("secrets:");
        sb.append(secrets);
        sb.append(",");
    }
    if (!(sourceSecret == null)) {
        sb.append("sourceSecret:");
        sb.append(sourceSecret);
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
  
  public A withConfigMaps(List<ConfigMapBuildSource> configMaps) {
    if (this.configMaps != null) {
      this._visitables.get("configMaps").clear();
    }
    if (configMaps != null) {
        this.configMaps = new ArrayList();
        for (ConfigMapBuildSource item : configMaps) {
          this.addToConfigMaps(item);
        }
    } else {
      this.configMaps = null;
    }
    return (A) this;
  }
  
  public A withConfigMaps(ConfigMapBuildSource... configMaps) {
    if (this.configMaps != null) {
        this.configMaps.clear();
        _visitables.remove("configMaps");
    }
    if (configMaps != null) {
      for (ConfigMapBuildSource item : configMaps) {
        this.addToConfigMaps(item);
      }
    }
    return (A) this;
  }
  
  public A withContextDir(String contextDir) {
    this.contextDir = contextDir;
    return (A) this;
  }
  
  public A withDockerfile(String dockerfile) {
    this.dockerfile = dockerfile;
    return (A) this;
  }
  
  public A withGit(GitBuildSource git) {
    this._visitables.remove("git");
    if (git != null) {
        this.git = new GitBuildSourceBuilder(git);
        this._visitables.get("git").add(this.git);
    } else {
        this.git = null;
        this._visitables.get("git").remove(this.git);
    }
    return (A) this;
  }
  
  public A withImages(List<ImageSource> images) {
    if (this.images != null) {
      this._visitables.get("images").clear();
    }
    if (images != null) {
        this.images = new ArrayList();
        for (ImageSource item : images) {
          this.addToImages(item);
        }
    } else {
      this.images = null;
    }
    return (A) this;
  }
  
  public A withImages(ImageSource... images) {
    if (this.images != null) {
        this.images.clear();
        _visitables.remove("images");
    }
    if (images != null) {
      for (ImageSource item : images) {
        this.addToImages(item);
      }
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
  
  public GitNested<A> withNewGit() {
    return new GitNested(null);
  }
  
  public A withNewGit(String httpProxy,String httpsProxy,String noProxy,String ref,String uri) {
    return (A) this.withGit(new GitBuildSource(httpProxy, httpsProxy, noProxy, ref, uri));
  }
  
  public GitNested<A> withNewGitLike(GitBuildSource item) {
    return new GitNested(item);
  }
  
  public SourceSecretNested<A> withNewSourceSecret() {
    return new SourceSecretNested(null);
  }
  
  public A withNewSourceSecret(String name) {
    return (A) this.withSourceSecret(new LocalObjectReference(name));
  }
  
  public SourceSecretNested<A> withNewSourceSecretLike(LocalObjectReference item) {
    return new SourceSecretNested(item);
  }
  
  public A withSecrets(List<SecretBuildSource> secrets) {
    if (this.secrets != null) {
      this._visitables.get("secrets").clear();
    }
    if (secrets != null) {
        this.secrets = new ArrayList();
        for (SecretBuildSource item : secrets) {
          this.addToSecrets(item);
        }
    } else {
      this.secrets = null;
    }
    return (A) this;
  }
  
  public A withSecrets(SecretBuildSource... secrets) {
    if (this.secrets != null) {
        this.secrets.clear();
        _visitables.remove("secrets");
    }
    if (secrets != null) {
      for (SecretBuildSource item : secrets) {
        this.addToSecrets(item);
      }
    }
    return (A) this;
  }
  
  public A withSourceSecret(LocalObjectReference sourceSecret) {
    this._visitables.remove("sourceSecret");
    if (sourceSecret != null) {
        this.sourceSecret = new LocalObjectReferenceBuilder(sourceSecret);
        this._visitables.get("sourceSecret").add(this.sourceSecret);
    } else {
        this.sourceSecret = null;
        this._visitables.get("sourceSecret").remove(this.sourceSecret);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class BinaryNested<N> extends BinaryBuildSourceFluent<BinaryNested<N>> implements Nested<N>{
  
    BinaryBuildSourceBuilder builder;
  
    BinaryNested(BinaryBuildSource item) {
      this.builder = new BinaryBuildSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildSourceFluent.this.withBinary(builder.build());
    }
    
    public N endBinary() {
      return and();
    }
    
  }
  public class ConfigMapsNested<N> extends ConfigMapBuildSourceFluent<ConfigMapsNested<N>> implements Nested<N>{
  
    ConfigMapBuildSourceBuilder builder;
    int index;
  
    ConfigMapsNested(int index,ConfigMapBuildSource item) {
      this.index = index;
      this.builder = new ConfigMapBuildSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildSourceFluent.this.setToConfigMaps(index, builder.build());
    }
    
    public N endConfigMap() {
      return and();
    }
    
  }
  public class GitNested<N> extends GitBuildSourceFluent<GitNested<N>> implements Nested<N>{
  
    GitBuildSourceBuilder builder;
  
    GitNested(GitBuildSource item) {
      this.builder = new GitBuildSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildSourceFluent.this.withGit(builder.build());
    }
    
    public N endGit() {
      return and();
    }
    
  }
  public class ImagesNested<N> extends ImageSourceFluent<ImagesNested<N>> implements Nested<N>{
  
    ImageSourceBuilder builder;
    int index;
  
    ImagesNested(int index,ImageSource item) {
      this.index = index;
      this.builder = new ImageSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildSourceFluent.this.setToImages(index, builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class SecretsNested<N> extends SecretBuildSourceFluent<SecretsNested<N>> implements Nested<N>{
  
    SecretBuildSourceBuilder builder;
    int index;
  
    SecretsNested(int index,SecretBuildSource item) {
      this.index = index;
      this.builder = new SecretBuildSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildSourceFluent.this.setToSecrets(index, builder.build());
    }
    
    public N endSecret() {
      return and();
    }
    
  }
  public class SourceSecretNested<N> extends LocalObjectReferenceFluent<SourceSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    SourceSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildSourceFluent.this.withSourceSecret(builder.build());
    }
    
    public N endSourceSecret() {
      return and();
    }
    
  }
}