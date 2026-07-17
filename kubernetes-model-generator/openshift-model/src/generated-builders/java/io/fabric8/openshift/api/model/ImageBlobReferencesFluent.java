package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ImageBlobReferencesFluent<A extends io.fabric8.openshift.api.model.ImageBlobReferencesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String config;
  private Boolean imageMissing;
  private List<String> layers = new ArrayList<String>();
  private List<String> manifests = new ArrayList<String>();

  public ImageBlobReferencesFluent() {
  }
  
  public ImageBlobReferencesFluent(ImageBlobReferences instance) {
    this.copyInstance(instance);
  }

  public A addAllToLayers(Collection<String> items) {
    if (this.layers == null) {
      this.layers = new ArrayList();
    }
    for (String item : items) {
      this.layers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToManifests(Collection<String> items) {
    if (this.manifests == null) {
      this.manifests = new ArrayList();
    }
    for (String item : items) {
      this.manifests.add(item);
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
  
  public A addToLayers(String... items) {
    if (this.layers == null) {
      this.layers = new ArrayList();
    }
    for (String item : items) {
      this.layers.add(item);
    }
    return (A) this;
  }
  
  public A addToLayers(int index,String item) {
    if (this.layers == null) {
      this.layers = new ArrayList();
    }
    this.layers.add(index, item);
    return (A) this;
  }
  
  public A addToManifests(String... items) {
    if (this.manifests == null) {
      this.manifests = new ArrayList();
    }
    for (String item : items) {
      this.manifests.add(item);
    }
    return (A) this;
  }
  
  public A addToManifests(int index,String item) {
    if (this.manifests == null) {
      this.manifests = new ArrayList();
    }
    this.manifests.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ImageBlobReferences instance) {
    instance = instance != null ? instance : new ImageBlobReferences();
    if (instance != null) {
        this.withConfig(instance.getConfig());
        this.withImageMissing(instance.getImageMissing());
        this.withLayers(instance.getLayers());
        this.withManifests(instance.getManifests());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ImageBlobReferencesFluent that = (ImageBlobReferencesFluent) o;
    if (!(Objects.equals(config, that.config))) {
      return false;
    }
    if (!(Objects.equals(imageMissing, that.imageMissing))) {
      return false;
    }
    if (!(Objects.equals(layers, that.layers))) {
      return false;
    }
    if (!(Objects.equals(manifests, that.manifests))) {
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
  
  public String getConfig() {
    return this.config;
  }
  
  public String getFirstLayer() {
    return this.layers.get(0);
  }
  
  public String getFirstManifest() {
    return this.manifests.get(0);
  }
  
  public Boolean getImageMissing() {
    return this.imageMissing;
  }
  
  public String getLastLayer() {
    return this.layers.get(layers.size() - 1);
  }
  
  public String getLastManifest() {
    return this.manifests.get(manifests.size() - 1);
  }
  
  public String getLayer(int index) {
    return this.layers.get(index);
  }
  
  public List<String> getLayers() {
    return this.layers;
  }
  
  public String getManifest(int index) {
    return this.manifests.get(index);
  }
  
  public List<String> getManifests() {
    return this.manifests;
  }
  
  public String getMatchingLayer(Predicate<String> predicate) {
      for (String item : layers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingManifest(Predicate<String> predicate) {
      for (String item : manifests) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfig() {
    return this.config != null;
  }
  
  public boolean hasImageMissing() {
    return this.imageMissing != null;
  }
  
  public boolean hasLayers() {
    return this.layers != null && !(this.layers.isEmpty());
  }
  
  public boolean hasManifests() {
    return this.manifests != null && !(this.manifests.isEmpty());
  }
  
  public boolean hasMatchingLayer(Predicate<String> predicate) {
      for (String item : layers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingManifest(Predicate<String> predicate) {
      for (String item : manifests) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(config, imageMissing, layers, manifests, additionalProperties);
  }
  
  public A removeAllFromLayers(Collection<String> items) {
    if (this.layers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.layers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromManifests(Collection<String> items) {
    if (this.manifests == null) {
      return (A) this;
    }
    for (String item : items) {
      this.manifests.remove(item);
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
  
  public A removeFromLayers(String... items) {
    if (this.layers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.layers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromManifests(String... items) {
    if (this.manifests == null) {
      return (A) this;
    }
    for (String item : items) {
      this.manifests.remove(item);
    }
    return (A) this;
  }
  
  public A setToLayers(int index,String item) {
    if (this.layers == null) {
      this.layers = new ArrayList();
    }
    this.layers.set(index, item);
    return (A) this;
  }
  
  public A setToManifests(int index,String item) {
    if (this.manifests == null) {
      this.manifests = new ArrayList();
    }
    this.manifests.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(config == null)) {
        sb.append("config:");
        sb.append(config);
        sb.append(",");
    }
    if (!(imageMissing == null)) {
        sb.append("imageMissing:");
        sb.append(imageMissing);
        sb.append(",");
    }
    if (!(layers == null) && !(layers.isEmpty())) {
        sb.append("layers:");
        sb.append(layers);
        sb.append(",");
    }
    if (!(manifests == null) && !(manifests.isEmpty())) {
        sb.append("manifests:");
        sb.append(manifests);
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
  
  public A withConfig(String config) {
    this.config = config;
    return (A) this;
  }
  
  public A withImageMissing() {
    return withImageMissing(true);
  }
  
  public A withImageMissing(Boolean imageMissing) {
    this.imageMissing = imageMissing;
    return (A) this;
  }
  
  public A withLayers(List<String> layers) {
    if (layers != null) {
        this.layers = new ArrayList();
        for (String item : layers) {
          this.addToLayers(item);
        }
    } else {
      this.layers = null;
    }
    return (A) this;
  }
  
  public A withLayers(String... layers) {
    if (this.layers != null) {
        this.layers.clear();
        _visitables.remove("layers");
    }
    if (layers != null) {
      for (String item : layers) {
        this.addToLayers(item);
      }
    }
    return (A) this;
  }
  
  public A withManifests(List<String> manifests) {
    if (manifests != null) {
        this.manifests = new ArrayList();
        for (String item : manifests) {
          this.addToManifests(item);
        }
    } else {
      this.manifests = null;
    }
    return (A) this;
  }
  
  public A withManifests(String... manifests) {
    if (this.manifests != null) {
        this.manifests.clear();
        _visitables.remove("manifests");
    }
    if (manifests != null) {
      for (String item : manifests) {
        this.addToManifests(item);
      }
    }
    return (A) this;
  }
  
}