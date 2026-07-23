package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class ImageStreamLayersFluent<A extends io.fabric8.openshift.api.model.ImageStreamLayersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private Map<String,ImageLayerData> blobs;
  private Map<String,ImageBlobReferences> images;
  private String kind;
  private ObjectMetaBuilder metadata;

  public ImageStreamLayersFluent() {
  }
  
  public ImageStreamLayersFluent(ImageStreamLayers instance) {
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
  
  public A addToBlobs(Map<String,ImageLayerData> map) {
    if (this.blobs == null && map != null) {
      this.blobs = new LinkedHashMap();
    }
    if (map != null) {
      this.blobs.putAll(map);
    }
    return (A) this;
  }
  
  public A addToBlobs(String key,ImageLayerData value) {
    if (this.blobs == null && key != null && value != null) {
      this.blobs = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.blobs.put(key, value);
    }
    return (A) this;
  }
  
  public A addToImages(Map<String,ImageBlobReferences> map) {
    if (this.images == null && map != null) {
      this.images = new LinkedHashMap();
    }
    if (map != null) {
      this.images.putAll(map);
    }
    return (A) this;
  }
  
  public A addToImages(String key,ImageBlobReferences value) {
    if (this.images == null && key != null && value != null) {
      this.images = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.images.put(key, value);
    }
    return (A) this;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(ImageStreamLayers instance) {
    instance = instance != null ? instance : new ImageStreamLayers();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withBlobs(instance.getBlobs());
        this.withImages(instance.getImages());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
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
    ImageStreamLayersFluent that = (ImageStreamLayersFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(blobs, that.blobs))) {
      return false;
    }
    if (!(Objects.equals(images, that.images))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
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
  
  public Map<String,ImageLayerData> getBlobs() {
    return this.blobs;
  }
  
  public Map<String,ImageBlobReferences> getImages() {
    return this.images;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasBlobs() {
    return this.blobs != null;
  }
  
  public boolean hasImages() {
    return this.images != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, blobs, images, kind, metadata, additionalProperties);
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
  
  public A removeFromBlobs(String key) {
    if (this.blobs == null) {
      return (A) this;
    }
    if (key != null && this.blobs != null) {
      this.blobs.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromBlobs(Map<String,ImageLayerData> map) {
    if (this.blobs == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.blobs != null) {
          this.blobs.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromImages(String key) {
    if (this.images == null) {
      return (A) this;
    }
    if (key != null && this.images != null) {
      this.images.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromImages(Map<String,ImageBlobReferences> map) {
    if (this.images == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.images != null) {
          this.images.remove(key);
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
    if (!(blobs == null) && !(blobs.isEmpty())) {
        sb.append("blobs:");
        sb.append(blobs);
        sb.append(",");
    }
    if (!(images == null) && !(images.isEmpty())) {
        sb.append("images:");
        sb.append(images);
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
  
  public <K,V>A withBlobs(Map<String,ImageLayerData> blobs) {
    if (blobs == null) {
      this.blobs = null;
    } else {
      this.blobs = new LinkedHashMap(blobs);
    }
    return (A) this;
  }
  
  public <K,V>A withImages(Map<String,ImageBlobReferences> images) {
    if (images == null) {
      this.images = null;
    } else {
      this.images = new LinkedHashMap(images);
    }
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
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageStreamLayersFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}