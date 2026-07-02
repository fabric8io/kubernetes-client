package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class EnvVarSourceFluent<A extends io.fabric8.kubernetes.api.model.EnvVarSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapKeySelectorBuilder configMapKeyRef;
  private ObjectFieldSelectorBuilder fieldRef;
  private FileKeySelectorBuilder fileKeyRef;
  private ResourceFieldSelectorBuilder resourceFieldRef;
  private SecretKeySelectorBuilder secretKeyRef;

  public EnvVarSourceFluent() {
  }
  
  public EnvVarSourceFluent(EnvVarSource instance) {
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
  
  public ConfigMapKeySelector buildConfigMapKeyRef() {
    return this.configMapKeyRef != null ? this.configMapKeyRef.build() : null;
  }
  
  public ObjectFieldSelector buildFieldRef() {
    return this.fieldRef != null ? this.fieldRef.build() : null;
  }
  
  public FileKeySelector buildFileKeyRef() {
    return this.fileKeyRef != null ? this.fileKeyRef.build() : null;
  }
  
  public ResourceFieldSelector buildResourceFieldRef() {
    return this.resourceFieldRef != null ? this.resourceFieldRef.build() : null;
  }
  
  public SecretKeySelector buildSecretKeyRef() {
    return this.secretKeyRef != null ? this.secretKeyRef.build() : null;
  }
  
  protected void copyInstance(EnvVarSource instance) {
    instance = instance != null ? instance : new EnvVarSource();
    if (instance != null) {
        this.withConfigMapKeyRef(instance.getConfigMapKeyRef());
        this.withFieldRef(instance.getFieldRef());
        this.withFileKeyRef(instance.getFileKeyRef());
        this.withResourceFieldRef(instance.getResourceFieldRef());
        this.withSecretKeyRef(instance.getSecretKeyRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigMapKeyRefNested<A> editConfigMapKeyRef() {
    return this.withNewConfigMapKeyRefLike(Optional.ofNullable(this.buildConfigMapKeyRef()).orElse(null));
  }
  
  public FieldRefNested<A> editFieldRef() {
    return this.withNewFieldRefLike(Optional.ofNullable(this.buildFieldRef()).orElse(null));
  }
  
  public FileKeyRefNested<A> editFileKeyRef() {
    return this.withNewFileKeyRefLike(Optional.ofNullable(this.buildFileKeyRef()).orElse(null));
  }
  
  public ConfigMapKeyRefNested<A> editOrNewConfigMapKeyRef() {
    return this.withNewConfigMapKeyRefLike(Optional.ofNullable(this.buildConfigMapKeyRef()).orElse(new ConfigMapKeySelectorBuilder().build()));
  }
  
  public ConfigMapKeyRefNested<A> editOrNewConfigMapKeyRefLike(ConfigMapKeySelector item) {
    return this.withNewConfigMapKeyRefLike(Optional.ofNullable(this.buildConfigMapKeyRef()).orElse(item));
  }
  
  public FieldRefNested<A> editOrNewFieldRef() {
    return this.withNewFieldRefLike(Optional.ofNullable(this.buildFieldRef()).orElse(new ObjectFieldSelectorBuilder().build()));
  }
  
  public FieldRefNested<A> editOrNewFieldRefLike(ObjectFieldSelector item) {
    return this.withNewFieldRefLike(Optional.ofNullable(this.buildFieldRef()).orElse(item));
  }
  
  public FileKeyRefNested<A> editOrNewFileKeyRef() {
    return this.withNewFileKeyRefLike(Optional.ofNullable(this.buildFileKeyRef()).orElse(new FileKeySelectorBuilder().build()));
  }
  
  public FileKeyRefNested<A> editOrNewFileKeyRefLike(FileKeySelector item) {
    return this.withNewFileKeyRefLike(Optional.ofNullable(this.buildFileKeyRef()).orElse(item));
  }
  
  public ResourceFieldRefNested<A> editOrNewResourceFieldRef() {
    return this.withNewResourceFieldRefLike(Optional.ofNullable(this.buildResourceFieldRef()).orElse(new ResourceFieldSelectorBuilder().build()));
  }
  
  public ResourceFieldRefNested<A> editOrNewResourceFieldRefLike(ResourceFieldSelector item) {
    return this.withNewResourceFieldRefLike(Optional.ofNullable(this.buildResourceFieldRef()).orElse(item));
  }
  
  public SecretKeyRefNested<A> editOrNewSecretKeyRef() {
    return this.withNewSecretKeyRefLike(Optional.ofNullable(this.buildSecretKeyRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public SecretKeyRefNested<A> editOrNewSecretKeyRefLike(SecretKeySelector item) {
    return this.withNewSecretKeyRefLike(Optional.ofNullable(this.buildSecretKeyRef()).orElse(item));
  }
  
  public ResourceFieldRefNested<A> editResourceFieldRef() {
    return this.withNewResourceFieldRefLike(Optional.ofNullable(this.buildResourceFieldRef()).orElse(null));
  }
  
  public SecretKeyRefNested<A> editSecretKeyRef() {
    return this.withNewSecretKeyRefLike(Optional.ofNullable(this.buildSecretKeyRef()).orElse(null));
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
    EnvVarSourceFluent that = (EnvVarSourceFluent) o;
    if (!(Objects.equals(configMapKeyRef, that.configMapKeyRef))) {
      return false;
    }
    if (!(Objects.equals(fieldRef, that.fieldRef))) {
      return false;
    }
    if (!(Objects.equals(fileKeyRef, that.fileKeyRef))) {
      return false;
    }
    if (!(Objects.equals(resourceFieldRef, that.resourceFieldRef))) {
      return false;
    }
    if (!(Objects.equals(secretKeyRef, that.secretKeyRef))) {
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
  
  public boolean hasConfigMapKeyRef() {
    return this.configMapKeyRef != null;
  }
  
  public boolean hasFieldRef() {
    return this.fieldRef != null;
  }
  
  public boolean hasFileKeyRef() {
    return this.fileKeyRef != null;
  }
  
  public boolean hasResourceFieldRef() {
    return this.resourceFieldRef != null;
  }
  
  public boolean hasSecretKeyRef() {
    return this.secretKeyRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(configMapKeyRef, fieldRef, fileKeyRef, resourceFieldRef, secretKeyRef, additionalProperties);
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
    if (!(configMapKeyRef == null)) {
        sb.append("configMapKeyRef:");
        sb.append(configMapKeyRef);
        sb.append(",");
    }
    if (!(fieldRef == null)) {
        sb.append("fieldRef:");
        sb.append(fieldRef);
        sb.append(",");
    }
    if (!(fileKeyRef == null)) {
        sb.append("fileKeyRef:");
        sb.append(fileKeyRef);
        sb.append(",");
    }
    if (!(resourceFieldRef == null)) {
        sb.append("resourceFieldRef:");
        sb.append(resourceFieldRef);
        sb.append(",");
    }
    if (!(secretKeyRef == null)) {
        sb.append("secretKeyRef:");
        sb.append(secretKeyRef);
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
  
  public A withConfigMapKeyRef(ConfigMapKeySelector configMapKeyRef) {
    this._visitables.remove("configMapKeyRef");
    if (configMapKeyRef != null) {
        this.configMapKeyRef = new ConfigMapKeySelectorBuilder(configMapKeyRef);
        this._visitables.get("configMapKeyRef").add(this.configMapKeyRef);
    } else {
        this.configMapKeyRef = null;
        this._visitables.get("configMapKeyRef").remove(this.configMapKeyRef);
    }
    return (A) this;
  }
  
  public A withFieldRef(ObjectFieldSelector fieldRef) {
    this._visitables.remove("fieldRef");
    if (fieldRef != null) {
        this.fieldRef = new ObjectFieldSelectorBuilder(fieldRef);
        this._visitables.get("fieldRef").add(this.fieldRef);
    } else {
        this.fieldRef = null;
        this._visitables.get("fieldRef").remove(this.fieldRef);
    }
    return (A) this;
  }
  
  public A withFileKeyRef(FileKeySelector fileKeyRef) {
    this._visitables.remove("fileKeyRef");
    if (fileKeyRef != null) {
        this.fileKeyRef = new FileKeySelectorBuilder(fileKeyRef);
        this._visitables.get("fileKeyRef").add(this.fileKeyRef);
    } else {
        this.fileKeyRef = null;
        this._visitables.get("fileKeyRef").remove(this.fileKeyRef);
    }
    return (A) this;
  }
  
  public ConfigMapKeyRefNested<A> withNewConfigMapKeyRef() {
    return new ConfigMapKeyRefNested(null);
  }
  
  public A withNewConfigMapKeyRef(String key,String name,Boolean optional) {
    return (A) this.withConfigMapKeyRef(new ConfigMapKeySelector(key, name, optional));
  }
  
  public ConfigMapKeyRefNested<A> withNewConfigMapKeyRefLike(ConfigMapKeySelector item) {
    return new ConfigMapKeyRefNested(item);
  }
  
  public FieldRefNested<A> withNewFieldRef() {
    return new FieldRefNested(null);
  }
  
  public A withNewFieldRef(String apiVersion,String fieldPath) {
    return (A) this.withFieldRef(new ObjectFieldSelector(apiVersion, fieldPath));
  }
  
  public FieldRefNested<A> withNewFieldRefLike(ObjectFieldSelector item) {
    return new FieldRefNested(item);
  }
  
  public FileKeyRefNested<A> withNewFileKeyRef() {
    return new FileKeyRefNested(null);
  }
  
  public A withNewFileKeyRef(String key,Boolean optional,String path,String volumeName) {
    return (A) this.withFileKeyRef(new FileKeySelector(key, optional, path, volumeName));
  }
  
  public FileKeyRefNested<A> withNewFileKeyRefLike(FileKeySelector item) {
    return new FileKeyRefNested(item);
  }
  
  public ResourceFieldRefNested<A> withNewResourceFieldRef() {
    return new ResourceFieldRefNested(null);
  }
  
  public ResourceFieldRefNested<A> withNewResourceFieldRefLike(ResourceFieldSelector item) {
    return new ResourceFieldRefNested(item);
  }
  
  public SecretKeyRefNested<A> withNewSecretKeyRef() {
    return new SecretKeyRefNested(null);
  }
  
  public A withNewSecretKeyRef(String key,String name,Boolean optional) {
    return (A) this.withSecretKeyRef(new SecretKeySelector(key, name, optional));
  }
  
  public SecretKeyRefNested<A> withNewSecretKeyRefLike(SecretKeySelector item) {
    return new SecretKeyRefNested(item);
  }
  
  public A withResourceFieldRef(ResourceFieldSelector resourceFieldRef) {
    this._visitables.remove("resourceFieldRef");
    if (resourceFieldRef != null) {
        this.resourceFieldRef = new ResourceFieldSelectorBuilder(resourceFieldRef);
        this._visitables.get("resourceFieldRef").add(this.resourceFieldRef);
    } else {
        this.resourceFieldRef = null;
        this._visitables.get("resourceFieldRef").remove(this.resourceFieldRef);
    }
    return (A) this;
  }
  
  public A withSecretKeyRef(SecretKeySelector secretKeyRef) {
    this._visitables.remove("secretKeyRef");
    if (secretKeyRef != null) {
        this.secretKeyRef = new SecretKeySelectorBuilder(secretKeyRef);
        this._visitables.get("secretKeyRef").add(this.secretKeyRef);
    } else {
        this.secretKeyRef = null;
        this._visitables.get("secretKeyRef").remove(this.secretKeyRef);
    }
    return (A) this;
  }
  public class ConfigMapKeyRefNested<N> extends ConfigMapKeySelectorFluent<ConfigMapKeyRefNested<N>> implements Nested<N>{
  
    ConfigMapKeySelectorBuilder builder;
  
    ConfigMapKeyRefNested(ConfigMapKeySelector item) {
      this.builder = new ConfigMapKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvVarSourceFluent.this.withConfigMapKeyRef(builder.build());
    }
    
    public N endConfigMapKeyRef() {
      return and();
    }
    
  }
  public class FieldRefNested<N> extends ObjectFieldSelectorFluent<FieldRefNested<N>> implements Nested<N>{
  
    ObjectFieldSelectorBuilder builder;
  
    FieldRefNested(ObjectFieldSelector item) {
      this.builder = new ObjectFieldSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvVarSourceFluent.this.withFieldRef(builder.build());
    }
    
    public N endFieldRef() {
      return and();
    }
    
  }
  public class FileKeyRefNested<N> extends FileKeySelectorFluent<FileKeyRefNested<N>> implements Nested<N>{
  
    FileKeySelectorBuilder builder;
  
    FileKeyRefNested(FileKeySelector item) {
      this.builder = new FileKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvVarSourceFluent.this.withFileKeyRef(builder.build());
    }
    
    public N endFileKeyRef() {
      return and();
    }
    
  }
  public class ResourceFieldRefNested<N> extends ResourceFieldSelectorFluent<ResourceFieldRefNested<N>> implements Nested<N>{
  
    ResourceFieldSelectorBuilder builder;
  
    ResourceFieldRefNested(ResourceFieldSelector item) {
      this.builder = new ResourceFieldSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvVarSourceFluent.this.withResourceFieldRef(builder.build());
    }
    
    public N endResourceFieldRef() {
      return and();
    }
    
  }
  public class SecretKeyRefNested<N> extends SecretKeySelectorFluent<SecretKeyRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    SecretKeyRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvVarSourceFluent.this.withSecretKeyRef(builder.build());
    }
    
    public N endSecretKeyRef() {
      return and();
    }
    
  }
}