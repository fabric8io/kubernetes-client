package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class FileModifyPrivilegeSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.FileModifyPrivilegeSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String fileName;
  private Long privilege;

  public FileModifyPrivilegeSpecFluent() {
  }
  
  public FileModifyPrivilegeSpecFluent(FileModifyPrivilegeSpec instance) {
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
  
  protected void copyInstance(FileModifyPrivilegeSpec instance) {
    instance = instance != null ? instance : new FileModifyPrivilegeSpec();
    if (instance != null) {
        this.withFileName(instance.getFileName());
        this.withPrivilege(instance.getPrivilege());
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
    FileModifyPrivilegeSpecFluent that = (FileModifyPrivilegeSpecFluent) o;
    if (!(Objects.equals(fileName, that.fileName))) {
      return false;
    }
    if (!(Objects.equals(privilege, that.privilege))) {
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
  
  public String getFileName() {
    return this.fileName;
  }
  
  public Long getPrivilege() {
    return this.privilege;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFileName() {
    return this.fileName != null;
  }
  
  public boolean hasPrivilege() {
    return this.privilege != null;
  }
  
  public int hashCode() {
    return Objects.hash(fileName, privilege, additionalProperties);
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
    if (!(fileName == null)) {
        sb.append("fileName:");
        sb.append(fileName);
        sb.append(",");
    }
    if (!(privilege == null)) {
        sb.append("privilege:");
        sb.append(privilege);
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
  
  public A withFileName(String fileName) {
    this.fileName = fileName;
    return (A) this;
  }
  
  public A withPrivilege(Long privilege) {
    this.privilege = privilege;
    return (A) this;
  }
  
}