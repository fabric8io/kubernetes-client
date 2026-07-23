package io.fabric8.certmanager.api.model.acme.v1;

import com.fasterxml.jackson.databind.JsonNode;
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
public class ACMEIssuerDNS01ProviderWebhookFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderWebhookFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private JsonNode config;
  private String groupName;
  private String solverName;

  public ACMEIssuerDNS01ProviderWebhookFluent() {
  }
  
  public ACMEIssuerDNS01ProviderWebhookFluent(ACMEIssuerDNS01ProviderWebhook instance) {
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
  
  protected void copyInstance(ACMEIssuerDNS01ProviderWebhook instance) {
    instance = instance != null ? instance : new ACMEIssuerDNS01ProviderWebhook();
    if (instance != null) {
        this.withConfig(instance.getConfig());
        this.withGroupName(instance.getGroupName());
        this.withSolverName(instance.getSolverName());
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
    ACMEIssuerDNS01ProviderWebhookFluent that = (ACMEIssuerDNS01ProviderWebhookFluent) o;
    if (!(Objects.equals(config, that.config))) {
      return false;
    }
    if (!(Objects.equals(groupName, that.groupName))) {
      return false;
    }
    if (!(Objects.equals(solverName, that.solverName))) {
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
  
  public JsonNode getConfig() {
    return this.config;
  }
  
  public String getGroupName() {
    return this.groupName;
  }
  
  public String getSolverName() {
    return this.solverName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfig() {
    return this.config != null;
  }
  
  public boolean hasGroupName() {
    return this.groupName != null;
  }
  
  public boolean hasSolverName() {
    return this.solverName != null;
  }
  
  public int hashCode() {
    return Objects.hash(config, groupName, solverName, additionalProperties);
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
    if (!(config == null)) {
        sb.append("config:");
        sb.append(config);
        sb.append(",");
    }
    if (!(groupName == null)) {
        sb.append("groupName:");
        sb.append(groupName);
        sb.append(",");
    }
    if (!(solverName == null)) {
        sb.append("solverName:");
        sb.append(solverName);
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
  
  public A withConfig(JsonNode config) {
    this.config = config;
    return (A) this;
  }
  
  public A withGroupName(String groupName) {
    this.groupName = groupName;
    return (A) this;
  }
  
  public A withSolverName(String solverName) {
    this.solverName = solverName;
    return (A) this;
  }
  
}