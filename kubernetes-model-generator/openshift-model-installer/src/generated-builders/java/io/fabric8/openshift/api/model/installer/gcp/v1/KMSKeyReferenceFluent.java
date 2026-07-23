package io.fabric8.openshift.api.model.installer.gcp.v1;

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
public class KMSKeyReferenceFluent<A extends io.fabric8.openshift.api.model.installer.gcp.v1.KMSKeyReferenceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String keyRing;
  private String location;
  private String name;
  private String projectID;

  public KMSKeyReferenceFluent() {
  }
  
  public KMSKeyReferenceFluent(KMSKeyReference instance) {
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
  
  protected void copyInstance(KMSKeyReference instance) {
    instance = instance != null ? instance : new KMSKeyReference();
    if (instance != null) {
        this.withKeyRing(instance.getKeyRing());
        this.withLocation(instance.getLocation());
        this.withName(instance.getName());
        this.withProjectID(instance.getProjectID());
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
    KMSKeyReferenceFluent that = (KMSKeyReferenceFluent) o;
    if (!(Objects.equals(keyRing, that.keyRing))) {
      return false;
    }
    if (!(Objects.equals(location, that.location))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(projectID, that.projectID))) {
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
  
  public String getKeyRing() {
    return this.keyRing;
  }
  
  public String getLocation() {
    return this.location;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getProjectID() {
    return this.projectID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasKeyRing() {
    return this.keyRing != null;
  }
  
  public boolean hasLocation() {
    return this.location != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasProjectID() {
    return this.projectID != null;
  }
  
  public int hashCode() {
    return Objects.hash(keyRing, location, name, projectID, additionalProperties);
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
    if (!(keyRing == null)) {
        sb.append("keyRing:");
        sb.append(keyRing);
        sb.append(",");
    }
    if (!(location == null)) {
        sb.append("location:");
        sb.append(location);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(projectID == null)) {
        sb.append("projectID:");
        sb.append(projectID);
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
  
  public A withKeyRing(String keyRing) {
    this.keyRing = keyRing;
    return (A) this;
  }
  
  public A withLocation(String location) {
    this.location = location;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withProjectID(String projectID) {
    this.projectID = projectID;
    return (A) this;
  }
  
}