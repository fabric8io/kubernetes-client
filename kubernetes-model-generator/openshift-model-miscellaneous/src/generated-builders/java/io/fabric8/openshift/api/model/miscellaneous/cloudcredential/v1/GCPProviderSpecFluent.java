package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

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
public class GCPProviderSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.GCPProviderSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String audience;
  private String kind;
  private List<String> permissions = new ArrayList<String>();
  private List<String> predefinedRoles = new ArrayList<String>();
  private String serviceAccountEmail;
  private Boolean skipServiceCheck;

  public GCPProviderSpecFluent() {
  }
  
  public GCPProviderSpecFluent(GCPProviderSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPermissions(Collection<String> items) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    for (String item : items) {
      this.permissions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPredefinedRoles(Collection<String> items) {
    if (this.predefinedRoles == null) {
      this.predefinedRoles = new ArrayList();
    }
    for (String item : items) {
      this.predefinedRoles.add(item);
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
  
  public A addToPermissions(String... items) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    for (String item : items) {
      this.permissions.add(item);
    }
    return (A) this;
  }
  
  public A addToPermissions(int index,String item) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    this.permissions.add(index, item);
    return (A) this;
  }
  
  public A addToPredefinedRoles(String... items) {
    if (this.predefinedRoles == null) {
      this.predefinedRoles = new ArrayList();
    }
    for (String item : items) {
      this.predefinedRoles.add(item);
    }
    return (A) this;
  }
  
  public A addToPredefinedRoles(int index,String item) {
    if (this.predefinedRoles == null) {
      this.predefinedRoles = new ArrayList();
    }
    this.predefinedRoles.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(GCPProviderSpec instance) {
    instance = instance != null ? instance : new GCPProviderSpec();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withAudience(instance.getAudience());
        this.withKind(instance.getKind());
        this.withPermissions(instance.getPermissions());
        this.withPredefinedRoles(instance.getPredefinedRoles());
        this.withServiceAccountEmail(instance.getServiceAccountEmail());
        this.withSkipServiceCheck(instance.getSkipServiceCheck());
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
    GCPProviderSpecFluent that = (GCPProviderSpecFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(audience, that.audience))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(permissions, that.permissions))) {
      return false;
    }
    if (!(Objects.equals(predefinedRoles, that.predefinedRoles))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountEmail, that.serviceAccountEmail))) {
      return false;
    }
    if (!(Objects.equals(skipServiceCheck, that.skipServiceCheck))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getAudience() {
    return this.audience;
  }
  
  public String getFirstPermission() {
    return this.permissions.get(0);
  }
  
  public String getFirstPredefinedRole() {
    return this.predefinedRoles.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastPermission() {
    return this.permissions.get(permissions.size() - 1);
  }
  
  public String getLastPredefinedRole() {
    return this.predefinedRoles.get(predefinedRoles.size() - 1);
  }
  
  public String getMatchingPermission(Predicate<String> predicate) {
      for (String item : permissions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPredefinedRole(Predicate<String> predicate) {
      for (String item : predefinedRoles) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPermission(int index) {
    return this.permissions.get(index);
  }
  
  public List<String> getPermissions() {
    return this.permissions;
  }
  
  public String getPredefinedRole(int index) {
    return this.predefinedRoles.get(index);
  }
  
  public List<String> getPredefinedRoles() {
    return this.predefinedRoles;
  }
  
  public String getServiceAccountEmail() {
    return this.serviceAccountEmail;
  }
  
  public Boolean getSkipServiceCheck() {
    return this.skipServiceCheck;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasAudience() {
    return this.audience != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingPermission(Predicate<String> predicate) {
      for (String item : permissions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPredefinedRole(Predicate<String> predicate) {
      for (String item : predefinedRoles) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPermissions() {
    return this.permissions != null && !(this.permissions.isEmpty());
  }
  
  public boolean hasPredefinedRoles() {
    return this.predefinedRoles != null && !(this.predefinedRoles.isEmpty());
  }
  
  public boolean hasServiceAccountEmail() {
    return this.serviceAccountEmail != null;
  }
  
  public boolean hasSkipServiceCheck() {
    return this.skipServiceCheck != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, audience, kind, permissions, predefinedRoles, serviceAccountEmail, skipServiceCheck, additionalProperties);
  }
  
  public A removeAllFromPermissions(Collection<String> items) {
    if (this.permissions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.permissions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPredefinedRoles(Collection<String> items) {
    if (this.predefinedRoles == null) {
      return (A) this;
    }
    for (String item : items) {
      this.predefinedRoles.remove(item);
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
  
  public A removeFromPermissions(String... items) {
    if (this.permissions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.permissions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPredefinedRoles(String... items) {
    if (this.predefinedRoles == null) {
      return (A) this;
    }
    for (String item : items) {
      this.predefinedRoles.remove(item);
    }
    return (A) this;
  }
  
  public A setToPermissions(int index,String item) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    this.permissions.set(index, item);
    return (A) this;
  }
  
  public A setToPredefinedRoles(int index,String item) {
    if (this.predefinedRoles == null) {
      this.predefinedRoles = new ArrayList();
    }
    this.predefinedRoles.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(audience == null)) {
        sb.append("audience:");
        sb.append(audience);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(permissions == null) && !(permissions.isEmpty())) {
        sb.append("permissions:");
        sb.append(permissions);
        sb.append(",");
    }
    if (!(predefinedRoles == null) && !(predefinedRoles.isEmpty())) {
        sb.append("predefinedRoles:");
        sb.append(predefinedRoles);
        sb.append(",");
    }
    if (!(serviceAccountEmail == null)) {
        sb.append("serviceAccountEmail:");
        sb.append(serviceAccountEmail);
        sb.append(",");
    }
    if (!(skipServiceCheck == null)) {
        sb.append("skipServiceCheck:");
        sb.append(skipServiceCheck);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withAudience(String audience) {
    this.audience = audience;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withPermissions(List<String> permissions) {
    if (permissions != null) {
        this.permissions = new ArrayList();
        for (String item : permissions) {
          this.addToPermissions(item);
        }
    } else {
      this.permissions = null;
    }
    return (A) this;
  }
  
  public A withPermissions(String... permissions) {
    if (this.permissions != null) {
        this.permissions.clear();
        _visitables.remove("permissions");
    }
    if (permissions != null) {
      for (String item : permissions) {
        this.addToPermissions(item);
      }
    }
    return (A) this;
  }
  
  public A withPredefinedRoles(List<String> predefinedRoles) {
    if (predefinedRoles != null) {
        this.predefinedRoles = new ArrayList();
        for (String item : predefinedRoles) {
          this.addToPredefinedRoles(item);
        }
    } else {
      this.predefinedRoles = null;
    }
    return (A) this;
  }
  
  public A withPredefinedRoles(String... predefinedRoles) {
    if (this.predefinedRoles != null) {
        this.predefinedRoles.clear();
        _visitables.remove("predefinedRoles");
    }
    if (predefinedRoles != null) {
      for (String item : predefinedRoles) {
        this.addToPredefinedRoles(item);
      }
    }
    return (A) this;
  }
  
  public A withServiceAccountEmail(String serviceAccountEmail) {
    this.serviceAccountEmail = serviceAccountEmail;
    return (A) this;
  }
  
  public A withSkipServiceCheck() {
    return withSkipServiceCheck(true);
  }
  
  public A withSkipServiceCheck(Boolean skipServiceCheck) {
    this.skipServiceCheck = skipServiceCheck;
    return (A) this;
  }
  
}