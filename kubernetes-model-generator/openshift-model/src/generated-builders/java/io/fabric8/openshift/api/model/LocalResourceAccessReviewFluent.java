package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class LocalResourceAccessReviewFluent<A extends io.fabric8.openshift.api.model.LocalResourceAccessReviewFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private Object content;
  private Boolean isNonResourceURL;
  private String kind;
  private ObjectMetaBuilder metadata;
  private String namespace;
  private String path;
  private String resource;
  private String resourceAPIGroup;
  private String resourceAPIVersion;
  private String resourceName;
  private String verb;

  public LocalResourceAccessReviewFluent() {
  }
  
  public LocalResourceAccessReviewFluent(LocalResourceAccessReview instance) {
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
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(LocalResourceAccessReview instance) {
    instance = instance != null ? instance : new LocalResourceAccessReview();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withContent(instance.getContent());
        this.withIsNonResourceURL(instance.getIsNonResourceURL());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withNamespace(instance.getNamespace());
        this.withPath(instance.getPath());
        this.withResource(instance.getResource());
        this.withResourceAPIGroup(instance.getResourceAPIGroup());
        this.withResourceAPIVersion(instance.getResourceAPIVersion());
        this.withResourceName(instance.getResourceName());
        this.withVerb(instance.getVerb());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
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
    LocalResourceAccessReviewFluent that = (LocalResourceAccessReviewFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(content, that.content))) {
      return false;
    }
    if (!(Objects.equals(isNonResourceURL, that.isNonResourceURL))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(resource, that.resource))) {
      return false;
    }
    if (!(Objects.equals(resourceAPIGroup, that.resourceAPIGroup))) {
      return false;
    }
    if (!(Objects.equals(resourceAPIVersion, that.resourceAPIVersion))) {
      return false;
    }
    if (!(Objects.equals(resourceName, that.resourceName))) {
      return false;
    }
    if (!(Objects.equals(verb, that.verb))) {
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
  
  public Object getContent() {
    return this.content;
  }
  
  public Boolean getIsNonResourceURL() {
    return this.isNonResourceURL;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public String getResource() {
    return this.resource;
  }
  
  public String getResourceAPIGroup() {
    return this.resourceAPIGroup;
  }
  
  public String getResourceAPIVersion() {
    return this.resourceAPIVersion;
  }
  
  public String getResourceName() {
    return this.resourceName;
  }
  
  public String getVerb() {
    return this.verb;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasContent() {
    return this.content != null;
  }
  
  public boolean hasIsNonResourceURL() {
    return this.isNonResourceURL != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasResource() {
    return this.resource != null;
  }
  
  public boolean hasResourceAPIGroup() {
    return this.resourceAPIGroup != null;
  }
  
  public boolean hasResourceAPIVersion() {
    return this.resourceAPIVersion != null;
  }
  
  public boolean hasResourceName() {
    return this.resourceName != null;
  }
  
  public boolean hasVerb() {
    return this.verb != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, content, isNonResourceURL, kind, metadata, namespace, path, resource, resourceAPIGroup, resourceAPIVersion, resourceName, verb, additionalProperties);
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
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(content == null)) {
        sb.append("content:");
        sb.append(content);
        sb.append(",");
    }
    if (!(isNonResourceURL == null)) {
        sb.append("isNonResourceURL:");
        sb.append(isNonResourceURL);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(resource == null)) {
        sb.append("resource:");
        sb.append(resource);
        sb.append(",");
    }
    if (!(resourceAPIGroup == null)) {
        sb.append("resourceAPIGroup:");
        sb.append(resourceAPIGroup);
        sb.append(",");
    }
    if (!(resourceAPIVersion == null)) {
        sb.append("resourceAPIVersion:");
        sb.append(resourceAPIVersion);
        sb.append(",");
    }
    if (!(resourceName == null)) {
        sb.append("resourceName:");
        sb.append(resourceName);
        sb.append(",");
    }
    if (!(verb == null)) {
        sb.append("verb:");
        sb.append(verb);
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
  
  public A withContent(Object content) {
    this.content = content;
    return (A) this;
  }
  
  public A withIsNonResourceURL() {
    return withIsNonResourceURL(true);
  }
  
  public A withIsNonResourceURL(Boolean isNonResourceURL) {
    this.isNonResourceURL = isNonResourceURL;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
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
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withResource(String resource) {
    this.resource = resource;
    return (A) this;
  }
  
  public A withResourceAPIGroup(String resourceAPIGroup) {
    this.resourceAPIGroup = resourceAPIGroup;
    return (A) this;
  }
  
  public A withResourceAPIVersion(String resourceAPIVersion) {
    this.resourceAPIVersion = resourceAPIVersion;
    return (A) this;
  }
  
  public A withResourceName(String resourceName) {
    this.resourceName = resourceName;
    return (A) this;
  }
  
  public A withVerb(String verb) {
    this.verb = verb;
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) LocalResourceAccessReviewFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}