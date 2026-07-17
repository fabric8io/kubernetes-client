package io.fabric8.openshift.api.model.installer.gcp.v1;

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
public class DNSZoneParamsFluent<A extends io.fabric8.openshift.api.model.installer.gcp.v1.DNSZoneParamsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String baseDomain;
  private Boolean installerCreated;
  private Boolean isPublic;
  private String name;
  private String project;

  public DNSZoneParamsFluent() {
  }
  
  public DNSZoneParamsFluent(DNSZoneParams instance) {
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
  
  protected void copyInstance(DNSZoneParams instance) {
    instance = instance != null ? instance : new DNSZoneParams();
    if (instance != null) {
        this.withBaseDomain(instance.getBaseDomain());
        this.withInstallerCreated(instance.getInstallerCreated());
        this.withIsPublic(instance.getIsPublic());
        this.withName(instance.getName());
        this.withProject(instance.getProject());
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
    DNSZoneParamsFluent that = (DNSZoneParamsFluent) o;
    if (!(Objects.equals(baseDomain, that.baseDomain))) {
      return false;
    }
    if (!(Objects.equals(installerCreated, that.installerCreated))) {
      return false;
    }
    if (!(Objects.equals(isPublic, that.isPublic))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(project, that.project))) {
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
  
  public String getBaseDomain() {
    return this.baseDomain;
  }
  
  public Boolean getInstallerCreated() {
    return this.installerCreated;
  }
  
  public Boolean getIsPublic() {
    return this.isPublic;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getProject() {
    return this.project;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBaseDomain() {
    return this.baseDomain != null;
  }
  
  public boolean hasInstallerCreated() {
    return this.installerCreated != null;
  }
  
  public boolean hasIsPublic() {
    return this.isPublic != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasProject() {
    return this.project != null;
  }
  
  public int hashCode() {
    return Objects.hash(baseDomain, installerCreated, isPublic, name, project, additionalProperties);
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
    if (!(baseDomain == null)) {
        sb.append("baseDomain:");
        sb.append(baseDomain);
        sb.append(",");
    }
    if (!(installerCreated == null)) {
        sb.append("installerCreated:");
        sb.append(installerCreated);
        sb.append(",");
    }
    if (!(isPublic == null)) {
        sb.append("isPublic:");
        sb.append(isPublic);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(project == null)) {
        sb.append("project:");
        sb.append(project);
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
  
  public A withBaseDomain(String baseDomain) {
    this.baseDomain = baseDomain;
    return (A) this;
  }
  
  public A withInstallerCreated() {
    return withInstallerCreated(true);
  }
  
  public A withInstallerCreated(Boolean installerCreated) {
    this.installerCreated = installerCreated;
    return (A) this;
  }
  
  public A withIsPublic() {
    return withIsPublic(true);
  }
  
  public A withIsPublic(Boolean isPublic) {
    this.isPublic = isPublic;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withProject(String project) {
    this.project = project;
    return (A) this;
  }
  
}