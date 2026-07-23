package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class VSphereProviderSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.VSphereProviderSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private ArrayList<VSpherePermissionBuilder> permissions = new ArrayList<VSpherePermissionBuilder>();

  public VSphereProviderSpecFluent() {
  }
  
  public VSphereProviderSpecFluent(VSphereProviderSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPermissions(Collection<VSpherePermission> items) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    for (VSpherePermission item : items) {
        VSpherePermissionBuilder builder = new VSpherePermissionBuilder(item);
        _visitables.get("permissions").add(builder);
        this.permissions.add(builder);
    }
    return (A) this;
  }
  
  public PermissionsNested<A> addNewPermission() {
    return new PermissionsNested(-1, null);
  }
  
  public PermissionsNested<A> addNewPermissionLike(VSpherePermission item) {
    return new PermissionsNested(-1, item);
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
  
  public A addToPermissions(VSpherePermission... items) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    for (VSpherePermission item : items) {
        VSpherePermissionBuilder builder = new VSpherePermissionBuilder(item);
        _visitables.get("permissions").add(builder);
        this.permissions.add(builder);
    }
    return (A) this;
  }
  
  public A addToPermissions(int index,VSpherePermission item) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    VSpherePermissionBuilder builder = new VSpherePermissionBuilder(item);
    if (index < 0 || index >= permissions.size()) {
        _visitables.get("permissions").add(builder);
        permissions.add(builder);
    } else {
        _visitables.get("permissions").add(builder);
        permissions.add(index, builder);
    }
    return (A) this;
  }
  
  public VSpherePermission buildFirstPermission() {
    return this.permissions.get(0).build();
  }
  
  public VSpherePermission buildLastPermission() {
    return this.permissions.get(permissions.size() - 1).build();
  }
  
  public VSpherePermission buildMatchingPermission(Predicate<VSpherePermissionBuilder> predicate) {
      for (VSpherePermissionBuilder item : permissions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VSpherePermission buildPermission(int index) {
    return this.permissions.get(index).build();
  }
  
  public List<VSpherePermission> buildPermissions() {
    return this.permissions != null ? build(permissions) : null;
  }
  
  protected void copyInstance(VSphereProviderSpec instance) {
    instance = instance != null ? instance : new VSphereProviderSpec();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withPermissions(instance.getPermissions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PermissionsNested<A> editFirstPermission() {
    if (permissions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "permissions"));
    }
    return this.setNewPermissionLike(0, this.buildPermission(0));
  }
  
  public PermissionsNested<A> editLastPermission() {
    int index = permissions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "permissions"));
    }
    return this.setNewPermissionLike(index, this.buildPermission(index));
  }
  
  public PermissionsNested<A> editMatchingPermission(Predicate<VSpherePermissionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < permissions.size();i++) {
      if (predicate.test(permissions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "permissions"));
    }
    return this.setNewPermissionLike(index, this.buildPermission(index));
  }
  
  public PermissionsNested<A> editPermission(int index) {
    if (permissions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "permissions"));
    }
    return this.setNewPermissionLike(index, this.buildPermission(index));
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
    VSphereProviderSpecFluent that = (VSphereProviderSpecFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(permissions, that.permissions))) {
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
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingPermission(Predicate<VSpherePermissionBuilder> predicate) {
      for (VSpherePermissionBuilder item : permissions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPermissions() {
    return this.permissions != null && !(this.permissions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, permissions, additionalProperties);
  }
  
  public A removeAllFromPermissions(Collection<VSpherePermission> items) {
    if (this.permissions == null) {
      return (A) this;
    }
    for (VSpherePermission item : items) {
        VSpherePermissionBuilder builder = new VSpherePermissionBuilder(item);
        _visitables.get("permissions").remove(builder);
        this.permissions.remove(builder);
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
  
  public A removeFromPermissions(VSpherePermission... items) {
    if (this.permissions == null) {
      return (A) this;
    }
    for (VSpherePermission item : items) {
        VSpherePermissionBuilder builder = new VSpherePermissionBuilder(item);
        _visitables.get("permissions").remove(builder);
        this.permissions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPermissions(Predicate<VSpherePermissionBuilder> predicate) {
    if (permissions == null) {
      return (A) this;
    }
    Iterator<VSpherePermissionBuilder> each = permissions.iterator();
    List visitables = _visitables.get("permissions");
    while (each.hasNext()) {
        VSpherePermissionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PermissionsNested<A> setNewPermissionLike(int index,VSpherePermission item) {
    return new PermissionsNested(index, item);
  }
  
  public A setToPermissions(int index,VSpherePermission item) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    VSpherePermissionBuilder builder = new VSpherePermissionBuilder(item);
    if (index < 0 || index >= permissions.size()) {
        _visitables.get("permissions").add(builder);
        permissions.add(builder);
    } else {
        _visitables.get("permissions").add(builder);
        permissions.set(index, builder);
    }
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
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withPermissions(List<VSpherePermission> permissions) {
    if (this.permissions != null) {
      this._visitables.get("permissions").clear();
    }
    if (permissions != null) {
        this.permissions = new ArrayList();
        for (VSpherePermission item : permissions) {
          this.addToPermissions(item);
        }
    } else {
      this.permissions = null;
    }
    return (A) this;
  }
  
  public A withPermissions(VSpherePermission... permissions) {
    if (this.permissions != null) {
        this.permissions.clear();
        _visitables.remove("permissions");
    }
    if (permissions != null) {
      for (VSpherePermission item : permissions) {
        this.addToPermissions(item);
      }
    }
    return (A) this;
  }
  public class PermissionsNested<N> extends VSpherePermissionFluent<PermissionsNested<N>> implements Nested<N>{
  
    VSpherePermissionBuilder builder;
    int index;
  
    PermissionsNested(int index,VSpherePermission item) {
      this.index = index;
      this.builder = new VSpherePermissionBuilder(this, item);
    }
  
    public N and() {
      return (N) VSphereProviderSpecFluent.this.setToPermissions(index, builder.build());
    }
    
    public N endPermission() {
      return and();
    }
    
  }
}