package io.fabric8.kubernetes.api.model;

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
public class WindowsSecurityContextOptionsFluent<A extends io.fabric8.kubernetes.api.model.WindowsSecurityContextOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String gmsaCredentialSpec;
  private String gmsaCredentialSpecName;
  private Boolean hostProcess;
  private String runAsUserName;

  public WindowsSecurityContextOptionsFluent() {
  }
  
  public WindowsSecurityContextOptionsFluent(WindowsSecurityContextOptions instance) {
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
  
  protected void copyInstance(WindowsSecurityContextOptions instance) {
    instance = instance != null ? instance : new WindowsSecurityContextOptions();
    if (instance != null) {
        this.withGmsaCredentialSpec(instance.getGmsaCredentialSpec());
        this.withGmsaCredentialSpecName(instance.getGmsaCredentialSpecName());
        this.withHostProcess(instance.getHostProcess());
        this.withRunAsUserName(instance.getRunAsUserName());
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
    WindowsSecurityContextOptionsFluent that = (WindowsSecurityContextOptionsFluent) o;
    if (!(Objects.equals(gmsaCredentialSpec, that.gmsaCredentialSpec))) {
      return false;
    }
    if (!(Objects.equals(gmsaCredentialSpecName, that.gmsaCredentialSpecName))) {
      return false;
    }
    if (!(Objects.equals(hostProcess, that.hostProcess))) {
      return false;
    }
    if (!(Objects.equals(runAsUserName, that.runAsUserName))) {
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
  
  public String getGmsaCredentialSpec() {
    return this.gmsaCredentialSpec;
  }
  
  public String getGmsaCredentialSpecName() {
    return this.gmsaCredentialSpecName;
  }
  
  public Boolean getHostProcess() {
    return this.hostProcess;
  }
  
  public String getRunAsUserName() {
    return this.runAsUserName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGmsaCredentialSpec() {
    return this.gmsaCredentialSpec != null;
  }
  
  public boolean hasGmsaCredentialSpecName() {
    return this.gmsaCredentialSpecName != null;
  }
  
  public boolean hasHostProcess() {
    return this.hostProcess != null;
  }
  
  public boolean hasRunAsUserName() {
    return this.runAsUserName != null;
  }
  
  public int hashCode() {
    return Objects.hash(gmsaCredentialSpec, gmsaCredentialSpecName, hostProcess, runAsUserName, additionalProperties);
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
    if (!(gmsaCredentialSpec == null)) {
        sb.append("gmsaCredentialSpec:");
        sb.append(gmsaCredentialSpec);
        sb.append(",");
    }
    if (!(gmsaCredentialSpecName == null)) {
        sb.append("gmsaCredentialSpecName:");
        sb.append(gmsaCredentialSpecName);
        sb.append(",");
    }
    if (!(hostProcess == null)) {
        sb.append("hostProcess:");
        sb.append(hostProcess);
        sb.append(",");
    }
    if (!(runAsUserName == null)) {
        sb.append("runAsUserName:");
        sb.append(runAsUserName);
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
  
  public A withGmsaCredentialSpec(String gmsaCredentialSpec) {
    this.gmsaCredentialSpec = gmsaCredentialSpec;
    return (A) this;
  }
  
  public A withGmsaCredentialSpecName(String gmsaCredentialSpecName) {
    this.gmsaCredentialSpecName = gmsaCredentialSpecName;
    return (A) this;
  }
  
  public A withHostProcess() {
    return withHostProcess(true);
  }
  
  public A withHostProcess(Boolean hostProcess) {
    this.hostProcess = hostProcess;
    return (A) this;
  }
  
  public A withRunAsUserName(String runAsUserName) {
    this.runAsUserName = runAsUserName;
    return (A) this;
  }
  
}