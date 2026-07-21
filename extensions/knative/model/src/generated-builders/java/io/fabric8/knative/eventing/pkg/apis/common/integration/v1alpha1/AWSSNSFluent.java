package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

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
public class AWSSNSFluent<A extends io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSNSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String arn;
  private Boolean autoCreateTopic;
  private Boolean overrideEndpoint;
  private String region;
  private String uriEndpointOverride;

  public AWSSNSFluent() {
  }
  
  public AWSSNSFluent(AWSSNS instance) {
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
  
  protected void copyInstance(AWSSNS instance) {
    instance = instance != null ? instance : new AWSSNS();
    if (instance != null) {
        this.withArn(instance.getArn());
        this.withAutoCreateTopic(instance.getAutoCreateTopic());
        this.withOverrideEndpoint(instance.getOverrideEndpoint());
        this.withRegion(instance.getRegion());
        this.withUriEndpointOverride(instance.getUriEndpointOverride());
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
    AWSSNSFluent that = (AWSSNSFluent) o;
    if (!(Objects.equals(arn, that.arn))) {
      return false;
    }
    if (!(Objects.equals(autoCreateTopic, that.autoCreateTopic))) {
      return false;
    }
    if (!(Objects.equals(overrideEndpoint, that.overrideEndpoint))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(uriEndpointOverride, that.uriEndpointOverride))) {
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
  
  public String getArn() {
    return this.arn;
  }
  
  public Boolean getAutoCreateTopic() {
    return this.autoCreateTopic;
  }
  
  public Boolean getOverrideEndpoint() {
    return this.overrideEndpoint;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getUriEndpointOverride() {
    return this.uriEndpointOverride;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArn() {
    return this.arn != null;
  }
  
  public boolean hasAutoCreateTopic() {
    return this.autoCreateTopic != null;
  }
  
  public boolean hasOverrideEndpoint() {
    return this.overrideEndpoint != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasUriEndpointOverride() {
    return this.uriEndpointOverride != null;
  }
  
  public int hashCode() {
    return Objects.hash(arn, autoCreateTopic, overrideEndpoint, region, uriEndpointOverride, additionalProperties);
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
    if (!(arn == null)) {
        sb.append("arn:");
        sb.append(arn);
        sb.append(",");
    }
    if (!(autoCreateTopic == null)) {
        sb.append("autoCreateTopic:");
        sb.append(autoCreateTopic);
        sb.append(",");
    }
    if (!(overrideEndpoint == null)) {
        sb.append("overrideEndpoint:");
        sb.append(overrideEndpoint);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(uriEndpointOverride == null)) {
        sb.append("uriEndpointOverride:");
        sb.append(uriEndpointOverride);
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
  
  public A withArn(String arn) {
    this.arn = arn;
    return (A) this;
  }
  
  public A withAutoCreateTopic() {
    return withAutoCreateTopic(true);
  }
  
  public A withAutoCreateTopic(Boolean autoCreateTopic) {
    this.autoCreateTopic = autoCreateTopic;
    return (A) this;
  }
  
  public A withOverrideEndpoint() {
    return withOverrideEndpoint(true);
  }
  
  public A withOverrideEndpoint(Boolean overrideEndpoint) {
    this.overrideEndpoint = overrideEndpoint;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withUriEndpointOverride(String uriEndpointOverride) {
    this.uriEndpointOverride = uriEndpointOverride;
    return (A) this;
  }
  
}