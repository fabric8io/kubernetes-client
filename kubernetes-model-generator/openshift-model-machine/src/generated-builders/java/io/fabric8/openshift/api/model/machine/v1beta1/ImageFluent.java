package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ImageFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.ImageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String offer;
  private String publisher;
  private String resourceID;
  private String sku;
  private String type;
  private String version;

  public ImageFluent() {
  }
  
  public ImageFluent(Image instance) {
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
  
  protected void copyInstance(Image instance) {
    instance = instance != null ? instance : new Image();
    if (instance != null) {
        this.withOffer(instance.getOffer());
        this.withPublisher(instance.getPublisher());
        this.withResourceID(instance.getResourceID());
        this.withSku(instance.getSku());
        this.withType(instance.getType());
        this.withVersion(instance.getVersion());
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
    ImageFluent that = (ImageFluent) o;
    if (!(Objects.equals(offer, that.offer))) {
      return false;
    }
    if (!(Objects.equals(publisher, that.publisher))) {
      return false;
    }
    if (!(Objects.equals(resourceID, that.resourceID))) {
      return false;
    }
    if (!(Objects.equals(sku, that.sku))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getOffer() {
    return this.offer;
  }
  
  public String getPublisher() {
    return this.publisher;
  }
  
  public String getResourceID() {
    return this.resourceID;
  }
  
  public String getSku() {
    return this.sku;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasOffer() {
    return this.offer != null;
  }
  
  public boolean hasPublisher() {
    return this.publisher != null;
  }
  
  public boolean hasResourceID() {
    return this.resourceID != null;
  }
  
  public boolean hasSku() {
    return this.sku != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(offer, publisher, resourceID, sku, type, version, additionalProperties);
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
    if (!(offer == null)) {
        sb.append("offer:");
        sb.append(offer);
        sb.append(",");
    }
    if (!(publisher == null)) {
        sb.append("publisher:");
        sb.append(publisher);
        sb.append(",");
    }
    if (!(resourceID == null)) {
        sb.append("resourceID:");
        sb.append(resourceID);
        sb.append(",");
    }
    if (!(sku == null)) {
        sb.append("sku:");
        sb.append(sku);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withOffer(String offer) {
    this.offer = offer;
    return (A) this;
  }
  
  public A withPublisher(String publisher) {
    this.publisher = publisher;
    return (A) this;
  }
  
  public A withResourceID(String resourceID) {
    this.resourceID = resourceID;
    return (A) this;
  }
  
  public A withSku(String sku) {
    this.sku = sku;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  
}