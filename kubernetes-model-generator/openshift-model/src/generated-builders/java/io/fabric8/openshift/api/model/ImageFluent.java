package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Long;
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
public class ImageFluent<A extends io.fabric8.openshift.api.model.ImageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String dockerImageConfig;
  private ArrayList<ImageLayerBuilder> dockerImageLayers = new ArrayList<ImageLayerBuilder>();
  private String dockerImageManifest;
  private String dockerImageManifestMediaType;
  private ArrayList<ImageManifestBuilder> dockerImageManifests = new ArrayList<ImageManifestBuilder>();
  private Object dockerImageMetadata;
  private String dockerImageMetadataVersion;
  private String dockerImageReference;
  private List<String> dockerImageSignatures = new ArrayList<String>();
  private String kind;
  private ObjectMetaBuilder metadata;
  private ArrayList<ImageSignatureBuilder> signatures = new ArrayList<ImageSignatureBuilder>();

  public ImageFluent() {
  }
  
  public ImageFluent(Image instance) {
    this.copyInstance(instance);
  }

  public A addAllToDockerImageLayers(Collection<ImageLayer> items) {
    if (this.dockerImageLayers == null) {
      this.dockerImageLayers = new ArrayList();
    }
    for (ImageLayer item : items) {
        ImageLayerBuilder builder = new ImageLayerBuilder(item);
        _visitables.get("dockerImageLayers").add(builder);
        this.dockerImageLayers.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDockerImageManifests(Collection<ImageManifest> items) {
    if (this.dockerImageManifests == null) {
      this.dockerImageManifests = new ArrayList();
    }
    for (ImageManifest item : items) {
        ImageManifestBuilder builder = new ImageManifestBuilder(item);
        _visitables.get("dockerImageManifests").add(builder);
        this.dockerImageManifests.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDockerImageSignatures(Collection<String> items) {
    if (this.dockerImageSignatures == null) {
      this.dockerImageSignatures = new ArrayList();
    }
    for (String item : items) {
      this.dockerImageSignatures.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSignatures(Collection<ImageSignature> items) {
    if (this.signatures == null) {
      this.signatures = new ArrayList();
    }
    for (ImageSignature item : items) {
        ImageSignatureBuilder builder = new ImageSignatureBuilder(item);
        _visitables.get("signatures").add(builder);
        this.signatures.add(builder);
    }
    return (A) this;
  }
  
  public DockerImageLayersNested<A> addNewDockerImageLayer() {
    return new DockerImageLayersNested(-1, null);
  }
  
  public A addNewDockerImageLayer(String mediaType,String name,Long size) {
    return (A) this.addToDockerImageLayers(new ImageLayer(mediaType, name, size));
  }
  
  public DockerImageLayersNested<A> addNewDockerImageLayerLike(ImageLayer item) {
    return new DockerImageLayersNested(-1, item);
  }
  
  public DockerImageManifestsNested<A> addNewDockerImageManifest() {
    return new DockerImageManifestsNested(-1, null);
  }
  
  public DockerImageManifestsNested<A> addNewDockerImageManifestLike(ImageManifest item) {
    return new DockerImageManifestsNested(-1, item);
  }
  
  public SignaturesNested<A> addNewSignature() {
    return new SignaturesNested(-1, null);
  }
  
  public SignaturesNested<A> addNewSignatureLike(ImageSignature item) {
    return new SignaturesNested(-1, item);
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
  
  public A addToDockerImageLayers(ImageLayer... items) {
    if (this.dockerImageLayers == null) {
      this.dockerImageLayers = new ArrayList();
    }
    for (ImageLayer item : items) {
        ImageLayerBuilder builder = new ImageLayerBuilder(item);
        _visitables.get("dockerImageLayers").add(builder);
        this.dockerImageLayers.add(builder);
    }
    return (A) this;
  }
  
  public A addToDockerImageLayers(int index,ImageLayer item) {
    if (this.dockerImageLayers == null) {
      this.dockerImageLayers = new ArrayList();
    }
    ImageLayerBuilder builder = new ImageLayerBuilder(item);
    if (index < 0 || index >= dockerImageLayers.size()) {
        _visitables.get("dockerImageLayers").add(builder);
        dockerImageLayers.add(builder);
    } else {
        _visitables.get("dockerImageLayers").add(builder);
        dockerImageLayers.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToDockerImageManifests(ImageManifest... items) {
    if (this.dockerImageManifests == null) {
      this.dockerImageManifests = new ArrayList();
    }
    for (ImageManifest item : items) {
        ImageManifestBuilder builder = new ImageManifestBuilder(item);
        _visitables.get("dockerImageManifests").add(builder);
        this.dockerImageManifests.add(builder);
    }
    return (A) this;
  }
  
  public A addToDockerImageManifests(int index,ImageManifest item) {
    if (this.dockerImageManifests == null) {
      this.dockerImageManifests = new ArrayList();
    }
    ImageManifestBuilder builder = new ImageManifestBuilder(item);
    if (index < 0 || index >= dockerImageManifests.size()) {
        _visitables.get("dockerImageManifests").add(builder);
        dockerImageManifests.add(builder);
    } else {
        _visitables.get("dockerImageManifests").add(builder);
        dockerImageManifests.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToDockerImageSignatures(String... items) {
    if (this.dockerImageSignatures == null) {
      this.dockerImageSignatures = new ArrayList();
    }
    for (String item : items) {
      this.dockerImageSignatures.add(item);
    }
    return (A) this;
  }
  
  public A addToDockerImageSignatures(int index,String item) {
    if (this.dockerImageSignatures == null) {
      this.dockerImageSignatures = new ArrayList();
    }
    this.dockerImageSignatures.add(index, item);
    return (A) this;
  }
  
  public A addToSignatures(ImageSignature... items) {
    if (this.signatures == null) {
      this.signatures = new ArrayList();
    }
    for (ImageSignature item : items) {
        ImageSignatureBuilder builder = new ImageSignatureBuilder(item);
        _visitables.get("signatures").add(builder);
        this.signatures.add(builder);
    }
    return (A) this;
  }
  
  public A addToSignatures(int index,ImageSignature item) {
    if (this.signatures == null) {
      this.signatures = new ArrayList();
    }
    ImageSignatureBuilder builder = new ImageSignatureBuilder(item);
    if (index < 0 || index >= signatures.size()) {
        _visitables.get("signatures").add(builder);
        signatures.add(builder);
    } else {
        _visitables.get("signatures").add(builder);
        signatures.add(index, builder);
    }
    return (A) this;
  }
  
  public ImageLayer buildDockerImageLayer(int index) {
    return this.dockerImageLayers.get(index).build();
  }
  
  public List<ImageLayer> buildDockerImageLayers() {
    return this.dockerImageLayers != null ? build(dockerImageLayers) : null;
  }
  
  public ImageManifest buildDockerImageManifest(int index) {
    return this.dockerImageManifests.get(index).build();
  }
  
  public List<ImageManifest> buildDockerImageManifests() {
    return this.dockerImageManifests != null ? build(dockerImageManifests) : null;
  }
  
  public ImageLayer buildFirstDockerImageLayer() {
    return this.dockerImageLayers.get(0).build();
  }
  
  public ImageManifest buildFirstDockerImageManifest() {
    return this.dockerImageManifests.get(0).build();
  }
  
  public ImageSignature buildFirstSignature() {
    return this.signatures.get(0).build();
  }
  
  public ImageLayer buildLastDockerImageLayer() {
    return this.dockerImageLayers.get(dockerImageLayers.size() - 1).build();
  }
  
  public ImageManifest buildLastDockerImageManifest() {
    return this.dockerImageManifests.get(dockerImageManifests.size() - 1).build();
  }
  
  public ImageSignature buildLastSignature() {
    return this.signatures.get(signatures.size() - 1).build();
  }
  
  public ImageLayer buildMatchingDockerImageLayer(Predicate<ImageLayerBuilder> predicate) {
      for (ImageLayerBuilder item : dockerImageLayers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ImageManifest buildMatchingDockerImageManifest(Predicate<ImageManifestBuilder> predicate) {
      for (ImageManifestBuilder item : dockerImageManifests) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ImageSignature buildMatchingSignature(Predicate<ImageSignatureBuilder> predicate) {
      for (ImageSignatureBuilder item : signatures) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public ImageSignature buildSignature(int index) {
    return this.signatures.get(index).build();
  }
  
  public List<ImageSignature> buildSignatures() {
    return this.signatures != null ? build(signatures) : null;
  }
  
  protected void copyInstance(Image instance) {
    instance = instance != null ? instance : new Image();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withDockerImageConfig(instance.getDockerImageConfig());
        this.withDockerImageLayers(instance.getDockerImageLayers());
        this.withDockerImageManifest(instance.getDockerImageManifest());
        this.withDockerImageManifestMediaType(instance.getDockerImageManifestMediaType());
        this.withDockerImageManifests(instance.getDockerImageManifests());
        this.withDockerImageMetadata(instance.getDockerImageMetadata());
        this.withDockerImageMetadataVersion(instance.getDockerImageMetadataVersion());
        this.withDockerImageReference(instance.getDockerImageReference());
        this.withDockerImageSignatures(instance.getDockerImageSignatures());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withSignatures(instance.getSignatures());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DockerImageLayersNested<A> editDockerImageLayer(int index) {
    if (dockerImageLayers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dockerImageLayers"));
    }
    return this.setNewDockerImageLayerLike(index, this.buildDockerImageLayer(index));
  }
  
  public DockerImageManifestsNested<A> editDockerImageManifest(int index) {
    if (dockerImageManifests.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dockerImageManifests"));
    }
    return this.setNewDockerImageManifestLike(index, this.buildDockerImageManifest(index));
  }
  
  public DockerImageLayersNested<A> editFirstDockerImageLayer() {
    if (dockerImageLayers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dockerImageLayers"));
    }
    return this.setNewDockerImageLayerLike(0, this.buildDockerImageLayer(0));
  }
  
  public DockerImageManifestsNested<A> editFirstDockerImageManifest() {
    if (dockerImageManifests.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dockerImageManifests"));
    }
    return this.setNewDockerImageManifestLike(0, this.buildDockerImageManifest(0));
  }
  
  public SignaturesNested<A> editFirstSignature() {
    if (signatures.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "signatures"));
    }
    return this.setNewSignatureLike(0, this.buildSignature(0));
  }
  
  public DockerImageLayersNested<A> editLastDockerImageLayer() {
    int index = dockerImageLayers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dockerImageLayers"));
    }
    return this.setNewDockerImageLayerLike(index, this.buildDockerImageLayer(index));
  }
  
  public DockerImageManifestsNested<A> editLastDockerImageManifest() {
    int index = dockerImageManifests.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dockerImageManifests"));
    }
    return this.setNewDockerImageManifestLike(index, this.buildDockerImageManifest(index));
  }
  
  public SignaturesNested<A> editLastSignature() {
    int index = signatures.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "signatures"));
    }
    return this.setNewSignatureLike(index, this.buildSignature(index));
  }
  
  public DockerImageLayersNested<A> editMatchingDockerImageLayer(Predicate<ImageLayerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dockerImageLayers.size();i++) {
      if (predicate.test(dockerImageLayers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dockerImageLayers"));
    }
    return this.setNewDockerImageLayerLike(index, this.buildDockerImageLayer(index));
  }
  
  public DockerImageManifestsNested<A> editMatchingDockerImageManifest(Predicate<ImageManifestBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dockerImageManifests.size();i++) {
      if (predicate.test(dockerImageManifests.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dockerImageManifests"));
    }
    return this.setNewDockerImageManifestLike(index, this.buildDockerImageManifest(index));
  }
  
  public SignaturesNested<A> editMatchingSignature(Predicate<ImageSignatureBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < signatures.size();i++) {
      if (predicate.test(signatures.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "signatures"));
    }
    return this.setNewSignatureLike(index, this.buildSignature(index));
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
  
  public SignaturesNested<A> editSignature(int index) {
    if (signatures.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "signatures"));
    }
    return this.setNewSignatureLike(index, this.buildSignature(index));
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
    ImageFluent that = (ImageFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(dockerImageConfig, that.dockerImageConfig))) {
      return false;
    }
    if (!(Objects.equals(dockerImageLayers, that.dockerImageLayers))) {
      return false;
    }
    if (!(Objects.equals(dockerImageManifest, that.dockerImageManifest))) {
      return false;
    }
    if (!(Objects.equals(dockerImageManifestMediaType, that.dockerImageManifestMediaType))) {
      return false;
    }
    if (!(Objects.equals(dockerImageManifests, that.dockerImageManifests))) {
      return false;
    }
    if (!(Objects.equals(dockerImageMetadata, that.dockerImageMetadata))) {
      return false;
    }
    if (!(Objects.equals(dockerImageMetadataVersion, that.dockerImageMetadataVersion))) {
      return false;
    }
    if (!(Objects.equals(dockerImageReference, that.dockerImageReference))) {
      return false;
    }
    if (!(Objects.equals(dockerImageSignatures, that.dockerImageSignatures))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(signatures, that.signatures))) {
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
  
  public String getDockerImageConfig() {
    return this.dockerImageConfig;
  }
  
  public String getDockerImageManifest() {
    return this.dockerImageManifest;
  }
  
  public String getDockerImageManifestMediaType() {
    return this.dockerImageManifestMediaType;
  }
  
  public Object getDockerImageMetadata() {
    return this.dockerImageMetadata;
  }
  
  public String getDockerImageMetadataVersion() {
    return this.dockerImageMetadataVersion;
  }
  
  public String getDockerImageReference() {
    return this.dockerImageReference;
  }
  
  public String getDockerImageSignature(int index) {
    return this.dockerImageSignatures.get(index);
  }
  
  public List<String> getDockerImageSignatures() {
    return this.dockerImageSignatures;
  }
  
  public String getFirstDockerImageSignature() {
    return this.dockerImageSignatures.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastDockerImageSignature() {
    return this.dockerImageSignatures.get(dockerImageSignatures.size() - 1);
  }
  
  public String getMatchingDockerImageSignature(Predicate<String> predicate) {
      for (String item : dockerImageSignatures) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasDockerImageConfig() {
    return this.dockerImageConfig != null;
  }
  
  public boolean hasDockerImageLayers() {
    return this.dockerImageLayers != null && !(this.dockerImageLayers.isEmpty());
  }
  
  public boolean hasDockerImageManifest() {
    return this.dockerImageManifest != null;
  }
  
  public boolean hasDockerImageManifestMediaType() {
    return this.dockerImageManifestMediaType != null;
  }
  
  public boolean hasDockerImageManifests() {
    return this.dockerImageManifests != null && !(this.dockerImageManifests.isEmpty());
  }
  
  public boolean hasDockerImageMetadata() {
    return this.dockerImageMetadata != null;
  }
  
  public boolean hasDockerImageMetadataVersion() {
    return this.dockerImageMetadataVersion != null;
  }
  
  public boolean hasDockerImageReference() {
    return this.dockerImageReference != null;
  }
  
  public boolean hasDockerImageSignatures() {
    return this.dockerImageSignatures != null && !(this.dockerImageSignatures.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingDockerImageLayer(Predicate<ImageLayerBuilder> predicate) {
      for (ImageLayerBuilder item : dockerImageLayers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDockerImageManifest(Predicate<ImageManifestBuilder> predicate) {
      for (ImageManifestBuilder item : dockerImageManifests) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDockerImageSignature(Predicate<String> predicate) {
      for (String item : dockerImageSignatures) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSignature(Predicate<ImageSignatureBuilder> predicate) {
      for (ImageSignatureBuilder item : signatures) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasSignatures() {
    return this.signatures != null && !(this.signatures.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, dockerImageConfig, dockerImageLayers, dockerImageManifest, dockerImageManifestMediaType, dockerImageManifests, dockerImageMetadata, dockerImageMetadataVersion, dockerImageReference, dockerImageSignatures, kind, metadata, signatures, additionalProperties);
  }
  
  public A removeAllFromDockerImageLayers(Collection<ImageLayer> items) {
    if (this.dockerImageLayers == null) {
      return (A) this;
    }
    for (ImageLayer item : items) {
        ImageLayerBuilder builder = new ImageLayerBuilder(item);
        _visitables.get("dockerImageLayers").remove(builder);
        this.dockerImageLayers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDockerImageManifests(Collection<ImageManifest> items) {
    if (this.dockerImageManifests == null) {
      return (A) this;
    }
    for (ImageManifest item : items) {
        ImageManifestBuilder builder = new ImageManifestBuilder(item);
        _visitables.get("dockerImageManifests").remove(builder);
        this.dockerImageManifests.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDockerImageSignatures(Collection<String> items) {
    if (this.dockerImageSignatures == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dockerImageSignatures.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSignatures(Collection<ImageSignature> items) {
    if (this.signatures == null) {
      return (A) this;
    }
    for (ImageSignature item : items) {
        ImageSignatureBuilder builder = new ImageSignatureBuilder(item);
        _visitables.get("signatures").remove(builder);
        this.signatures.remove(builder);
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
  
  public A removeFromDockerImageLayers(ImageLayer... items) {
    if (this.dockerImageLayers == null) {
      return (A) this;
    }
    for (ImageLayer item : items) {
        ImageLayerBuilder builder = new ImageLayerBuilder(item);
        _visitables.get("dockerImageLayers").remove(builder);
        this.dockerImageLayers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromDockerImageManifests(ImageManifest... items) {
    if (this.dockerImageManifests == null) {
      return (A) this;
    }
    for (ImageManifest item : items) {
        ImageManifestBuilder builder = new ImageManifestBuilder(item);
        _visitables.get("dockerImageManifests").remove(builder);
        this.dockerImageManifests.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromDockerImageSignatures(String... items) {
    if (this.dockerImageSignatures == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dockerImageSignatures.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSignatures(ImageSignature... items) {
    if (this.signatures == null) {
      return (A) this;
    }
    for (ImageSignature item : items) {
        ImageSignatureBuilder builder = new ImageSignatureBuilder(item);
        _visitables.get("signatures").remove(builder);
        this.signatures.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDockerImageLayers(Predicate<ImageLayerBuilder> predicate) {
    if (dockerImageLayers == null) {
      return (A) this;
    }
    Iterator<ImageLayerBuilder> each = dockerImageLayers.iterator();
    List visitables = _visitables.get("dockerImageLayers");
    while (each.hasNext()) {
        ImageLayerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromDockerImageManifests(Predicate<ImageManifestBuilder> predicate) {
    if (dockerImageManifests == null) {
      return (A) this;
    }
    Iterator<ImageManifestBuilder> each = dockerImageManifests.iterator();
    List visitables = _visitables.get("dockerImageManifests");
    while (each.hasNext()) {
        ImageManifestBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSignatures(Predicate<ImageSignatureBuilder> predicate) {
    if (signatures == null) {
      return (A) this;
    }
    Iterator<ImageSignatureBuilder> each = signatures.iterator();
    List visitables = _visitables.get("signatures");
    while (each.hasNext()) {
        ImageSignatureBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DockerImageLayersNested<A> setNewDockerImageLayerLike(int index,ImageLayer item) {
    return new DockerImageLayersNested(index, item);
  }
  
  public DockerImageManifestsNested<A> setNewDockerImageManifestLike(int index,ImageManifest item) {
    return new DockerImageManifestsNested(index, item);
  }
  
  public SignaturesNested<A> setNewSignatureLike(int index,ImageSignature item) {
    return new SignaturesNested(index, item);
  }
  
  public A setToDockerImageLayers(int index,ImageLayer item) {
    if (this.dockerImageLayers == null) {
      this.dockerImageLayers = new ArrayList();
    }
    ImageLayerBuilder builder = new ImageLayerBuilder(item);
    if (index < 0 || index >= dockerImageLayers.size()) {
        _visitables.get("dockerImageLayers").add(builder);
        dockerImageLayers.add(builder);
    } else {
        _visitables.get("dockerImageLayers").add(builder);
        dockerImageLayers.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDockerImageManifests(int index,ImageManifest item) {
    if (this.dockerImageManifests == null) {
      this.dockerImageManifests = new ArrayList();
    }
    ImageManifestBuilder builder = new ImageManifestBuilder(item);
    if (index < 0 || index >= dockerImageManifests.size()) {
        _visitables.get("dockerImageManifests").add(builder);
        dockerImageManifests.add(builder);
    } else {
        _visitables.get("dockerImageManifests").add(builder);
        dockerImageManifests.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDockerImageSignatures(int index,String item) {
    if (this.dockerImageSignatures == null) {
      this.dockerImageSignatures = new ArrayList();
    }
    this.dockerImageSignatures.set(index, item);
    return (A) this;
  }
  
  public A setToSignatures(int index,ImageSignature item) {
    if (this.signatures == null) {
      this.signatures = new ArrayList();
    }
    ImageSignatureBuilder builder = new ImageSignatureBuilder(item);
    if (index < 0 || index >= signatures.size()) {
        _visitables.get("signatures").add(builder);
        signatures.add(builder);
    } else {
        _visitables.get("signatures").add(builder);
        signatures.set(index, builder);
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
    if (!(dockerImageConfig == null)) {
        sb.append("dockerImageConfig:");
        sb.append(dockerImageConfig);
        sb.append(",");
    }
    if (!(dockerImageLayers == null) && !(dockerImageLayers.isEmpty())) {
        sb.append("dockerImageLayers:");
        sb.append(dockerImageLayers);
        sb.append(",");
    }
    if (!(dockerImageManifest == null)) {
        sb.append("dockerImageManifest:");
        sb.append(dockerImageManifest);
        sb.append(",");
    }
    if (!(dockerImageManifestMediaType == null)) {
        sb.append("dockerImageManifestMediaType:");
        sb.append(dockerImageManifestMediaType);
        sb.append(",");
    }
    if (!(dockerImageManifests == null) && !(dockerImageManifests.isEmpty())) {
        sb.append("dockerImageManifests:");
        sb.append(dockerImageManifests);
        sb.append(",");
    }
    if (!(dockerImageMetadata == null)) {
        sb.append("dockerImageMetadata:");
        sb.append(dockerImageMetadata);
        sb.append(",");
    }
    if (!(dockerImageMetadataVersion == null)) {
        sb.append("dockerImageMetadataVersion:");
        sb.append(dockerImageMetadataVersion);
        sb.append(",");
    }
    if (!(dockerImageReference == null)) {
        sb.append("dockerImageReference:");
        sb.append(dockerImageReference);
        sb.append(",");
    }
    if (!(dockerImageSignatures == null) && !(dockerImageSignatures.isEmpty())) {
        sb.append("dockerImageSignatures:");
        sb.append(dockerImageSignatures);
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
    if (!(signatures == null) && !(signatures.isEmpty())) {
        sb.append("signatures:");
        sb.append(signatures);
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
  
  public A withDockerImageConfig(String dockerImageConfig) {
    this.dockerImageConfig = dockerImageConfig;
    return (A) this;
  }
  
  public A withDockerImageLayers(List<ImageLayer> dockerImageLayers) {
    if (this.dockerImageLayers != null) {
      this._visitables.get("dockerImageLayers").clear();
    }
    if (dockerImageLayers != null) {
        this.dockerImageLayers = new ArrayList();
        for (ImageLayer item : dockerImageLayers) {
          this.addToDockerImageLayers(item);
        }
    } else {
      this.dockerImageLayers = null;
    }
    return (A) this;
  }
  
  public A withDockerImageLayers(ImageLayer... dockerImageLayers) {
    if (this.dockerImageLayers != null) {
        this.dockerImageLayers.clear();
        _visitables.remove("dockerImageLayers");
    }
    if (dockerImageLayers != null) {
      for (ImageLayer item : dockerImageLayers) {
        this.addToDockerImageLayers(item);
      }
    }
    return (A) this;
  }
  
  public A withDockerImageManifest(String dockerImageManifest) {
    this.dockerImageManifest = dockerImageManifest;
    return (A) this;
  }
  
  public A withDockerImageManifestMediaType(String dockerImageManifestMediaType) {
    this.dockerImageManifestMediaType = dockerImageManifestMediaType;
    return (A) this;
  }
  
  public A withDockerImageManifests(List<ImageManifest> dockerImageManifests) {
    if (this.dockerImageManifests != null) {
      this._visitables.get("dockerImageManifests").clear();
    }
    if (dockerImageManifests != null) {
        this.dockerImageManifests = new ArrayList();
        for (ImageManifest item : dockerImageManifests) {
          this.addToDockerImageManifests(item);
        }
    } else {
      this.dockerImageManifests = null;
    }
    return (A) this;
  }
  
  public A withDockerImageManifests(ImageManifest... dockerImageManifests) {
    if (this.dockerImageManifests != null) {
        this.dockerImageManifests.clear();
        _visitables.remove("dockerImageManifests");
    }
    if (dockerImageManifests != null) {
      for (ImageManifest item : dockerImageManifests) {
        this.addToDockerImageManifests(item);
      }
    }
    return (A) this;
  }
  
  public A withDockerImageMetadata(Object dockerImageMetadata) {
    this.dockerImageMetadata = dockerImageMetadata;
    return (A) this;
  }
  
  public A withDockerImageMetadataVersion(String dockerImageMetadataVersion) {
    this.dockerImageMetadataVersion = dockerImageMetadataVersion;
    return (A) this;
  }
  
  public A withDockerImageReference(String dockerImageReference) {
    this.dockerImageReference = dockerImageReference;
    return (A) this;
  }
  
  public A withDockerImageSignatures(List<String> dockerImageSignatures) {
    if (dockerImageSignatures != null) {
        this.dockerImageSignatures = new ArrayList();
        for (String item : dockerImageSignatures) {
          this.addToDockerImageSignatures(item);
        }
    } else {
      this.dockerImageSignatures = null;
    }
    return (A) this;
  }
  
  public A withDockerImageSignatures(String... dockerImageSignatures) {
    if (this.dockerImageSignatures != null) {
        this.dockerImageSignatures.clear();
        _visitables.remove("dockerImageSignatures");
    }
    if (dockerImageSignatures != null) {
      for (String item : dockerImageSignatures) {
        this.addToDockerImageSignatures(item);
      }
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
  
  public A withSignatures(List<ImageSignature> signatures) {
    if (this.signatures != null) {
      this._visitables.get("signatures").clear();
    }
    if (signatures != null) {
        this.signatures = new ArrayList();
        for (ImageSignature item : signatures) {
          this.addToSignatures(item);
        }
    } else {
      this.signatures = null;
    }
    return (A) this;
  }
  
  public A withSignatures(ImageSignature... signatures) {
    if (this.signatures != null) {
        this.signatures.clear();
        _visitables.remove("signatures");
    }
    if (signatures != null) {
      for (ImageSignature item : signatures) {
        this.addToSignatures(item);
      }
    }
    return (A) this;
  }
  public class DockerImageLayersNested<N> extends ImageLayerFluent<DockerImageLayersNested<N>> implements Nested<N>{
  
    ImageLayerBuilder builder;
    int index;
  
    DockerImageLayersNested(int index,ImageLayer item) {
      this.index = index;
      this.builder = new ImageLayerBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageFluent.this.setToDockerImageLayers(index, builder.build());
    }
    
    public N endDockerImageLayer() {
      return and();
    }
    
  }
  public class DockerImageManifestsNested<N> extends ImageManifestFluent<DockerImageManifestsNested<N>> implements Nested<N>{
  
    ImageManifestBuilder builder;
    int index;
  
    DockerImageManifestsNested(int index,ImageManifest item) {
      this.index = index;
      this.builder = new ImageManifestBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageFluent.this.setToDockerImageManifests(index, builder.build());
    }
    
    public N endDockerImageManifest() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class SignaturesNested<N> extends ImageSignatureFluent<SignaturesNested<N>> implements Nested<N>{
  
    ImageSignatureBuilder builder;
    int index;
  
    SignaturesNested(int index,ImageSignature item) {
      this.index = index;
      this.builder = new ImageSignatureBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageFluent.this.setToSignatures(index, builder.build());
    }
    
    public N endSignature() {
      return and();
    }
    
  }
}