package io.fabric8.openshift.api.model.monitoring.v1;

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
public class WebHTTPHeadersFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.WebHTTPHeadersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String contentSecurityPolicy;
  private String strictTransportSecurity;
  private String xContentTypeOptions;
  private String xFrameOptions;
  private String xXSSProtection;

  public WebHTTPHeadersFluent() {
  }
  
  public WebHTTPHeadersFluent(WebHTTPHeaders instance) {
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
  
  protected void copyInstance(WebHTTPHeaders instance) {
    instance = instance != null ? instance : new WebHTTPHeaders();
    if (instance != null) {
        this.withContentSecurityPolicy(instance.getContentSecurityPolicy());
        this.withStrictTransportSecurity(instance.getStrictTransportSecurity());
        this.withXContentTypeOptions(instance.getXContentTypeOptions());
        this.withXFrameOptions(instance.getXFrameOptions());
        this.withXXSSProtection(instance.getXXSSProtection());
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
    WebHTTPHeadersFluent that = (WebHTTPHeadersFluent) o;
    if (!(Objects.equals(contentSecurityPolicy, that.contentSecurityPolicy))) {
      return false;
    }
    if (!(Objects.equals(strictTransportSecurity, that.strictTransportSecurity))) {
      return false;
    }
    if (!(Objects.equals(xContentTypeOptions, that.xContentTypeOptions))) {
      return false;
    }
    if (!(Objects.equals(xFrameOptions, that.xFrameOptions))) {
      return false;
    }
    if (!(Objects.equals(xXSSProtection, that.xXSSProtection))) {
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
  
  public String getContentSecurityPolicy() {
    return this.contentSecurityPolicy;
  }
  
  public String getStrictTransportSecurity() {
    return this.strictTransportSecurity;
  }
  
  public String getXContentTypeOptions() {
    return this.xContentTypeOptions;
  }
  
  public String getXFrameOptions() {
    return this.xFrameOptions;
  }
  
  public String getXXSSProtection() {
    return this.xXSSProtection;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContentSecurityPolicy() {
    return this.contentSecurityPolicy != null;
  }
  
  public boolean hasStrictTransportSecurity() {
    return this.strictTransportSecurity != null;
  }
  
  public boolean hasXContentTypeOptions() {
    return this.xContentTypeOptions != null;
  }
  
  public boolean hasXFrameOptions() {
    return this.xFrameOptions != null;
  }
  
  public boolean hasXXSSProtection() {
    return this.xXSSProtection != null;
  }
  
  public int hashCode() {
    return Objects.hash(contentSecurityPolicy, strictTransportSecurity, xContentTypeOptions, xFrameOptions, xXSSProtection, additionalProperties);
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
    if (!(contentSecurityPolicy == null)) {
        sb.append("contentSecurityPolicy:");
        sb.append(contentSecurityPolicy);
        sb.append(",");
    }
    if (!(strictTransportSecurity == null)) {
        sb.append("strictTransportSecurity:");
        sb.append(strictTransportSecurity);
        sb.append(",");
    }
    if (!(xContentTypeOptions == null)) {
        sb.append("xContentTypeOptions:");
        sb.append(xContentTypeOptions);
        sb.append(",");
    }
    if (!(xFrameOptions == null)) {
        sb.append("xFrameOptions:");
        sb.append(xFrameOptions);
        sb.append(",");
    }
    if (!(xXSSProtection == null)) {
        sb.append("xXSSProtection:");
        sb.append(xXSSProtection);
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
  
  public A withContentSecurityPolicy(String contentSecurityPolicy) {
    this.contentSecurityPolicy = contentSecurityPolicy;
    return (A) this;
  }
  
  public A withStrictTransportSecurity(String strictTransportSecurity) {
    this.strictTransportSecurity = strictTransportSecurity;
    return (A) this;
  }
  
  public A withXContentTypeOptions(String xContentTypeOptions) {
    this.xContentTypeOptions = xContentTypeOptions;
    return (A) this;
  }
  
  public A withXFrameOptions(String xFrameOptions) {
    this.xFrameOptions = xFrameOptions;
    return (A) this;
  }
  
  public A withXXSSProtection(String xXSSProtection) {
    this.xXSSProtection = xXSSProtection;
    return (A) this;
  }
  
}