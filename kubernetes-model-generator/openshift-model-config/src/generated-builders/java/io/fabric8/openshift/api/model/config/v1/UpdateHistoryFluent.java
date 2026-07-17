package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class UpdateHistoryFluent<A extends io.fabric8.openshift.api.model.config.v1.UpdateHistoryFluent<A>> extends BaseFluent<A>{

  private String acceptedRisks;
  private Map<String,Object> additionalProperties;
  private String completionTime;
  private String image;
  private String startedTime;
  private String state;
  private Boolean verified;
  private String version;

  public UpdateHistoryFluent() {
  }
  
  public UpdateHistoryFluent(UpdateHistory instance) {
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
  
  protected void copyInstance(UpdateHistory instance) {
    instance = instance != null ? instance : new UpdateHistory();
    if (instance != null) {
        this.withAcceptedRisks(instance.getAcceptedRisks());
        this.withCompletionTime(instance.getCompletionTime());
        this.withImage(instance.getImage());
        this.withStartedTime(instance.getStartedTime());
        this.withState(instance.getState());
        this.withVerified(instance.getVerified());
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
    UpdateHistoryFluent that = (UpdateHistoryFluent) o;
    if (!(Objects.equals(acceptedRisks, that.acceptedRisks))) {
      return false;
    }
    if (!(Objects.equals(completionTime, that.completionTime))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(startedTime, that.startedTime))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
      return false;
    }
    if (!(Objects.equals(verified, that.verified))) {
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
  
  public String getAcceptedRisks() {
    return this.acceptedRisks;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getCompletionTime() {
    return this.completionTime;
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getStartedTime() {
    return this.startedTime;
  }
  
  public String getState() {
    return this.state;
  }
  
  public Boolean getVerified() {
    return this.verified;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAcceptedRisks() {
    return this.acceptedRisks != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompletionTime() {
    return this.completionTime != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasStartedTime() {
    return this.startedTime != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public boolean hasVerified() {
    return this.verified != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(acceptedRisks, completionTime, image, startedTime, state, verified, version, additionalProperties);
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
    if (!(acceptedRisks == null)) {
        sb.append("acceptedRisks:");
        sb.append(acceptedRisks);
        sb.append(",");
    }
    if (!(completionTime == null)) {
        sb.append("completionTime:");
        sb.append(completionTime);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(startedTime == null)) {
        sb.append("startedTime:");
        sb.append(startedTime);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
        sb.append(",");
    }
    if (!(verified == null)) {
        sb.append("verified:");
        sb.append(verified);
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
  
  public A withAcceptedRisks(String acceptedRisks) {
    this.acceptedRisks = acceptedRisks;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withCompletionTime(String completionTime) {
    this.completionTime = completionTime;
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public A withStartedTime(String startedTime) {
    this.startedTime = startedTime;
    return (A) this;
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  
  public A withVerified() {
    return withVerified(true);
  }
  
  public A withVerified(Boolean verified) {
    this.verified = verified;
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  
}