package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class CatalogSourceSpecFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.CatalogSourceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String address;
  private String configMap;
  private String description;
  private String displayName;
  private GrpcPodConfigBuilder grpcPodConfig;
  private IconBuilder icon;
  private String image;
  private Integer priority;
  private String publisher;
  private List<String> secrets = new ArrayList<String>();
  private String sourceType;
  private UpdateStrategyBuilder updateStrategy;

  public CatalogSourceSpecFluent() {
  }
  
  public CatalogSourceSpecFluent(CatalogSourceSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToSecrets(Collection<String> items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (String item : items) {
      this.secrets.add(item);
    }
    return (A) this;
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
  
  public A addToSecrets(String... items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (String item : items) {
      this.secrets.add(item);
    }
    return (A) this;
  }
  
  public A addToSecrets(int index,String item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    this.secrets.add(index, item);
    return (A) this;
  }
  
  public GrpcPodConfig buildGrpcPodConfig() {
    return this.grpcPodConfig != null ? this.grpcPodConfig.build() : null;
  }
  
  public Icon buildIcon() {
    return this.icon != null ? this.icon.build() : null;
  }
  
  public UpdateStrategy buildUpdateStrategy() {
    return this.updateStrategy != null ? this.updateStrategy.build() : null;
  }
  
  protected void copyInstance(CatalogSourceSpec instance) {
    instance = instance != null ? instance : new CatalogSourceSpec();
    if (instance != null) {
        this.withAddress(instance.getAddress());
        this.withConfigMap(instance.getConfigMap());
        this.withDescription(instance.getDescription());
        this.withDisplayName(instance.getDisplayName());
        this.withGrpcPodConfig(instance.getGrpcPodConfig());
        this.withIcon(instance.getIcon());
        this.withImage(instance.getImage());
        this.withPriority(instance.getPriority());
        this.withPublisher(instance.getPublisher());
        this.withSecrets(instance.getSecrets());
        this.withSourceType(instance.getSourceType());
        this.withUpdateStrategy(instance.getUpdateStrategy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GrpcPodConfigNested<A> editGrpcPodConfig() {
    return this.withNewGrpcPodConfigLike(Optional.ofNullable(this.buildGrpcPodConfig()).orElse(null));
  }
  
  public IconNested<A> editIcon() {
    return this.withNewIconLike(Optional.ofNullable(this.buildIcon()).orElse(null));
  }
  
  public GrpcPodConfigNested<A> editOrNewGrpcPodConfig() {
    return this.withNewGrpcPodConfigLike(Optional.ofNullable(this.buildGrpcPodConfig()).orElse(new GrpcPodConfigBuilder().build()));
  }
  
  public GrpcPodConfigNested<A> editOrNewGrpcPodConfigLike(GrpcPodConfig item) {
    return this.withNewGrpcPodConfigLike(Optional.ofNullable(this.buildGrpcPodConfig()).orElse(item));
  }
  
  public IconNested<A> editOrNewIcon() {
    return this.withNewIconLike(Optional.ofNullable(this.buildIcon()).orElse(new IconBuilder().build()));
  }
  
  public IconNested<A> editOrNewIconLike(Icon item) {
    return this.withNewIconLike(Optional.ofNullable(this.buildIcon()).orElse(item));
  }
  
  public UpdateStrategyNested<A> editOrNewUpdateStrategy() {
    return this.withNewUpdateStrategyLike(Optional.ofNullable(this.buildUpdateStrategy()).orElse(new UpdateStrategyBuilder().build()));
  }
  
  public UpdateStrategyNested<A> editOrNewUpdateStrategyLike(UpdateStrategy item) {
    return this.withNewUpdateStrategyLike(Optional.ofNullable(this.buildUpdateStrategy()).orElse(item));
  }
  
  public UpdateStrategyNested<A> editUpdateStrategy() {
    return this.withNewUpdateStrategyLike(Optional.ofNullable(this.buildUpdateStrategy()).orElse(null));
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
    CatalogSourceSpecFluent that = (CatalogSourceSpecFluent) o;
    if (!(Objects.equals(address, that.address))) {
      return false;
    }
    if (!(Objects.equals(configMap, that.configMap))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(grpcPodConfig, that.grpcPodConfig))) {
      return false;
    }
    if (!(Objects.equals(icon, that.icon))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(publisher, that.publisher))) {
      return false;
    }
    if (!(Objects.equals(secrets, that.secrets))) {
      return false;
    }
    if (!(Objects.equals(sourceType, that.sourceType))) {
      return false;
    }
    if (!(Objects.equals(updateStrategy, that.updateStrategy))) {
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
  
  public String getAddress() {
    return this.address;
  }
  
  public String getConfigMap() {
    return this.configMap;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public String getFirstSecret() {
    return this.secrets.get(0);
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getLastSecret() {
    return this.secrets.get(secrets.size() - 1);
  }
  
  public String getMatchingSecret(Predicate<String> predicate) {
      for (String item : secrets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getPriority() {
    return this.priority;
  }
  
  public String getPublisher() {
    return this.publisher;
  }
  
  public String getSecret(int index) {
    return this.secrets.get(index);
  }
  
  public List<String> getSecrets() {
    return this.secrets;
  }
  
  public String getSourceType() {
    return this.sourceType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddress() {
    return this.address != null;
  }
  
  public boolean hasConfigMap() {
    return this.configMap != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasGrpcPodConfig() {
    return this.grpcPodConfig != null;
  }
  
  public boolean hasIcon() {
    return this.icon != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasMatchingSecret(Predicate<String> predicate) {
      for (String item : secrets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasPublisher() {
    return this.publisher != null;
  }
  
  public boolean hasSecrets() {
    return this.secrets != null && !(this.secrets.isEmpty());
  }
  
  public boolean hasSourceType() {
    return this.sourceType != null;
  }
  
  public boolean hasUpdateStrategy() {
    return this.updateStrategy != null;
  }
  
  public int hashCode() {
    return Objects.hash(address, configMap, description, displayName, grpcPodConfig, icon, image, priority, publisher, secrets, sourceType, updateStrategy, additionalProperties);
  }
  
  public A removeAllFromSecrets(Collection<String> items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.secrets.remove(item);
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
  
  public A removeFromSecrets(String... items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.secrets.remove(item);
    }
    return (A) this;
  }
  
  public A setToSecrets(int index,String item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    this.secrets.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(address == null)) {
        sb.append("address:");
        sb.append(address);
        sb.append(",");
    }
    if (!(configMap == null)) {
        sb.append("configMap:");
        sb.append(configMap);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(displayName == null)) {
        sb.append("displayName:");
        sb.append(displayName);
        sb.append(",");
    }
    if (!(grpcPodConfig == null)) {
        sb.append("grpcPodConfig:");
        sb.append(grpcPodConfig);
        sb.append(",");
    }
    if (!(icon == null)) {
        sb.append("icon:");
        sb.append(icon);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
        sb.append(",");
    }
    if (!(publisher == null)) {
        sb.append("publisher:");
        sb.append(publisher);
        sb.append(",");
    }
    if (!(secrets == null) && !(secrets.isEmpty())) {
        sb.append("secrets:");
        sb.append(secrets);
        sb.append(",");
    }
    if (!(sourceType == null)) {
        sb.append("sourceType:");
        sb.append(sourceType);
        sb.append(",");
    }
    if (!(updateStrategy == null)) {
        sb.append("updateStrategy:");
        sb.append(updateStrategy);
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
  
  public A withAddress(String address) {
    this.address = address;
    return (A) this;
  }
  
  public A withConfigMap(String configMap) {
    this.configMap = configMap;
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withDisplayName(String displayName) {
    this.displayName = displayName;
    return (A) this;
  }
  
  public A withGrpcPodConfig(GrpcPodConfig grpcPodConfig) {
    this._visitables.remove("grpcPodConfig");
    if (grpcPodConfig != null) {
        this.grpcPodConfig = new GrpcPodConfigBuilder(grpcPodConfig);
        this._visitables.get("grpcPodConfig").add(this.grpcPodConfig);
    } else {
        this.grpcPodConfig = null;
        this._visitables.get("grpcPodConfig").remove(this.grpcPodConfig);
    }
    return (A) this;
  }
  
  public A withIcon(Icon icon) {
    this._visitables.remove("icon");
    if (icon != null) {
        this.icon = new IconBuilder(icon);
        this._visitables.get("icon").add(this.icon);
    } else {
        this.icon = null;
        this._visitables.get("icon").remove(this.icon);
    }
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public GrpcPodConfigNested<A> withNewGrpcPodConfig() {
    return new GrpcPodConfigNested(null);
  }
  
  public GrpcPodConfigNested<A> withNewGrpcPodConfigLike(GrpcPodConfig item) {
    return new GrpcPodConfigNested(item);
  }
  
  public IconNested<A> withNewIcon() {
    return new IconNested(null);
  }
  
  public A withNewIcon(String base64data,String mediatype) {
    return (A) this.withIcon(new Icon(base64data, mediatype));
  }
  
  public IconNested<A> withNewIconLike(Icon item) {
    return new IconNested(item);
  }
  
  public UpdateStrategyNested<A> withNewUpdateStrategy() {
    return new UpdateStrategyNested(null);
  }
  
  public UpdateStrategyNested<A> withNewUpdateStrategyLike(UpdateStrategy item) {
    return new UpdateStrategyNested(item);
  }
  
  public A withPriority(Integer priority) {
    this.priority = priority;
    return (A) this;
  }
  
  public A withPublisher(String publisher) {
    this.publisher = publisher;
    return (A) this;
  }
  
  public A withSecrets(List<String> secrets) {
    if (secrets != null) {
        this.secrets = new ArrayList();
        for (String item : secrets) {
          this.addToSecrets(item);
        }
    } else {
      this.secrets = null;
    }
    return (A) this;
  }
  
  public A withSecrets(String... secrets) {
    if (this.secrets != null) {
        this.secrets.clear();
        _visitables.remove("secrets");
    }
    if (secrets != null) {
      for (String item : secrets) {
        this.addToSecrets(item);
      }
    }
    return (A) this;
  }
  
  public A withSourceType(String sourceType) {
    this.sourceType = sourceType;
    return (A) this;
  }
  
  public A withUpdateStrategy(UpdateStrategy updateStrategy) {
    this._visitables.remove("updateStrategy");
    if (updateStrategy != null) {
        this.updateStrategy = new UpdateStrategyBuilder(updateStrategy);
        this._visitables.get("updateStrategy").add(this.updateStrategy);
    } else {
        this.updateStrategy = null;
        this._visitables.get("updateStrategy").remove(this.updateStrategy);
    }
    return (A) this;
  }
  public class GrpcPodConfigNested<N> extends GrpcPodConfigFluent<GrpcPodConfigNested<N>> implements Nested<N>{
  
    GrpcPodConfigBuilder builder;
  
    GrpcPodConfigNested(GrpcPodConfig item) {
      this.builder = new GrpcPodConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) CatalogSourceSpecFluent.this.withGrpcPodConfig(builder.build());
    }
    
    public N endGrpcPodConfig() {
      return and();
    }
    
  }
  public class IconNested<N> extends IconFluent<IconNested<N>> implements Nested<N>{
  
    IconBuilder builder;
  
    IconNested(Icon item) {
      this.builder = new IconBuilder(this, item);
    }
  
    public N and() {
      return (N) CatalogSourceSpecFluent.this.withIcon(builder.build());
    }
    
    public N endIcon() {
      return and();
    }
    
  }
  public class UpdateStrategyNested<N> extends UpdateStrategyFluent<UpdateStrategyNested<N>> implements Nested<N>{
  
    UpdateStrategyBuilder builder;
  
    UpdateStrategyNested(UpdateStrategy item) {
      this.builder = new UpdateStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) CatalogSourceSpecFluent.this.withUpdateStrategy(builder.build());
    }
    
    public N endUpdateStrategy() {
      return and();
    }
    
  }
}