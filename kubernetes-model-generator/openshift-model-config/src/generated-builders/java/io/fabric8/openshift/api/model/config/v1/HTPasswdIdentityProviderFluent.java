package io.fabric8.openshift.api.model.config.v1;

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
public class HTPasswdIdentityProviderFluent<A extends io.fabric8.openshift.api.model.config.v1.HTPasswdIdentityProviderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretNameReferenceBuilder fileData;

  public HTPasswdIdentityProviderFluent() {
  }
  
  public HTPasswdIdentityProviderFluent(HTPasswdIdentityProvider instance) {
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
  
  public SecretNameReference buildFileData() {
    return this.fileData != null ? this.fileData.build() : null;
  }
  
  protected void copyInstance(HTPasswdIdentityProvider instance) {
    instance = instance != null ? instance : new HTPasswdIdentityProvider();
    if (instance != null) {
        this.withFileData(instance.getFileData());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FileDataNested<A> editFileData() {
    return this.withNewFileDataLike(Optional.ofNullable(this.buildFileData()).orElse(null));
  }
  
  public FileDataNested<A> editOrNewFileData() {
    return this.withNewFileDataLike(Optional.ofNullable(this.buildFileData()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public FileDataNested<A> editOrNewFileDataLike(SecretNameReference item) {
    return this.withNewFileDataLike(Optional.ofNullable(this.buildFileData()).orElse(item));
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
    HTPasswdIdentityProviderFluent that = (HTPasswdIdentityProviderFluent) o;
    if (!(Objects.equals(fileData, that.fileData))) {
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
  
  public boolean hasFileData() {
    return this.fileData != null;
  }
  
  public int hashCode() {
    return Objects.hash(fileData, additionalProperties);
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
    if (!(fileData == null)) {
        sb.append("fileData:");
        sb.append(fileData);
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
  
  public A withFileData(SecretNameReference fileData) {
    this._visitables.remove("fileData");
    if (fileData != null) {
        this.fileData = new SecretNameReferenceBuilder(fileData);
        this._visitables.get("fileData").add(this.fileData);
    } else {
        this.fileData = null;
        this._visitables.get("fileData").remove(this.fileData);
    }
    return (A) this;
  }
  
  public FileDataNested<A> withNewFileData() {
    return new FileDataNested(null);
  }
  
  public A withNewFileData(String name) {
    return (A) this.withFileData(new SecretNameReference(name));
  }
  
  public FileDataNested<A> withNewFileDataLike(SecretNameReference item) {
    return new FileDataNested(item);
  }
  public class FileDataNested<N> extends SecretNameReferenceFluent<FileDataNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    FileDataNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HTPasswdIdentityProviderFluent.this.withFileData(builder.build());
    }
    
    public N endFileData() {
      return and();
    }
    
  }
}