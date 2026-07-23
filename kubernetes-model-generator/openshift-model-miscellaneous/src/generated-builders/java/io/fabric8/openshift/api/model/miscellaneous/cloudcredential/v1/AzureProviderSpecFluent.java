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
public class AzureProviderSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.AzureProviderSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String azureClientID;
  private String azureRegion;
  private String azureSubscriptionID;
  private String azureTenantID;
  private List<String> dataPermissions = new ArrayList<String>();
  private String kind;
  private List<String> permissions = new ArrayList<String>();
  private ArrayList<RoleBindingBuilder> roleBindings = new ArrayList<RoleBindingBuilder>();

  public AzureProviderSpecFluent() {
  }
  
  public AzureProviderSpecFluent(AzureProviderSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToDataPermissions(Collection<String> items) {
    if (this.dataPermissions == null) {
      this.dataPermissions = new ArrayList();
    }
    for (String item : items) {
      this.dataPermissions.add(item);
    }
    return (A) this;
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
  
  public A addAllToRoleBindings(Collection<RoleBinding> items) {
    if (this.roleBindings == null) {
      this.roleBindings = new ArrayList();
    }
    for (RoleBinding item : items) {
        RoleBindingBuilder builder = new RoleBindingBuilder(item);
        _visitables.get("roleBindings").add(builder);
        this.roleBindings.add(builder);
    }
    return (A) this;
  }
  
  public RoleBindingsNested<A> addNewRoleBinding() {
    return new RoleBindingsNested(-1, null);
  }
  
  public A addNewRoleBinding(String role) {
    return (A) this.addToRoleBindings(new RoleBinding(role));
  }
  
  public RoleBindingsNested<A> addNewRoleBindingLike(RoleBinding item) {
    return new RoleBindingsNested(-1, item);
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
  
  public A addToDataPermissions(String... items) {
    if (this.dataPermissions == null) {
      this.dataPermissions = new ArrayList();
    }
    for (String item : items) {
      this.dataPermissions.add(item);
    }
    return (A) this;
  }
  
  public A addToDataPermissions(int index,String item) {
    if (this.dataPermissions == null) {
      this.dataPermissions = new ArrayList();
    }
    this.dataPermissions.add(index, item);
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
  
  public A addToRoleBindings(RoleBinding... items) {
    if (this.roleBindings == null) {
      this.roleBindings = new ArrayList();
    }
    for (RoleBinding item : items) {
        RoleBindingBuilder builder = new RoleBindingBuilder(item);
        _visitables.get("roleBindings").add(builder);
        this.roleBindings.add(builder);
    }
    return (A) this;
  }
  
  public A addToRoleBindings(int index,RoleBinding item) {
    if (this.roleBindings == null) {
      this.roleBindings = new ArrayList();
    }
    RoleBindingBuilder builder = new RoleBindingBuilder(item);
    if (index < 0 || index >= roleBindings.size()) {
        _visitables.get("roleBindings").add(builder);
        roleBindings.add(builder);
    } else {
        _visitables.get("roleBindings").add(builder);
        roleBindings.add(index, builder);
    }
    return (A) this;
  }
  
  public RoleBinding buildFirstRoleBinding() {
    return this.roleBindings.get(0).build();
  }
  
  public RoleBinding buildLastRoleBinding() {
    return this.roleBindings.get(roleBindings.size() - 1).build();
  }
  
  public RoleBinding buildMatchingRoleBinding(Predicate<RoleBindingBuilder> predicate) {
      for (RoleBindingBuilder item : roleBindings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RoleBinding buildRoleBinding(int index) {
    return this.roleBindings.get(index).build();
  }
  
  public List<RoleBinding> buildRoleBindings() {
    return this.roleBindings != null ? build(roleBindings) : null;
  }
  
  protected void copyInstance(AzureProviderSpec instance) {
    instance = instance != null ? instance : new AzureProviderSpec();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withAzureClientID(instance.getAzureClientID());
        this.withAzureRegion(instance.getAzureRegion());
        this.withAzureSubscriptionID(instance.getAzureSubscriptionID());
        this.withAzureTenantID(instance.getAzureTenantID());
        this.withDataPermissions(instance.getDataPermissions());
        this.withKind(instance.getKind());
        this.withPermissions(instance.getPermissions());
        this.withRoleBindings(instance.getRoleBindings());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RoleBindingsNested<A> editFirstRoleBinding() {
    if (roleBindings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "roleBindings"));
    }
    return this.setNewRoleBindingLike(0, this.buildRoleBinding(0));
  }
  
  public RoleBindingsNested<A> editLastRoleBinding() {
    int index = roleBindings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "roleBindings"));
    }
    return this.setNewRoleBindingLike(index, this.buildRoleBinding(index));
  }
  
  public RoleBindingsNested<A> editMatchingRoleBinding(Predicate<RoleBindingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < roleBindings.size();i++) {
      if (predicate.test(roleBindings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "roleBindings"));
    }
    return this.setNewRoleBindingLike(index, this.buildRoleBinding(index));
  }
  
  public RoleBindingsNested<A> editRoleBinding(int index) {
    if (roleBindings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "roleBindings"));
    }
    return this.setNewRoleBindingLike(index, this.buildRoleBinding(index));
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
    AzureProviderSpecFluent that = (AzureProviderSpecFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(azureClientID, that.azureClientID))) {
      return false;
    }
    if (!(Objects.equals(azureRegion, that.azureRegion))) {
      return false;
    }
    if (!(Objects.equals(azureSubscriptionID, that.azureSubscriptionID))) {
      return false;
    }
    if (!(Objects.equals(azureTenantID, that.azureTenantID))) {
      return false;
    }
    if (!(Objects.equals(dataPermissions, that.dataPermissions))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(permissions, that.permissions))) {
      return false;
    }
    if (!(Objects.equals(roleBindings, that.roleBindings))) {
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
  
  public String getAzureClientID() {
    return this.azureClientID;
  }
  
  public String getAzureRegion() {
    return this.azureRegion;
  }
  
  public String getAzureSubscriptionID() {
    return this.azureSubscriptionID;
  }
  
  public String getAzureTenantID() {
    return this.azureTenantID;
  }
  
  public String getDataPermission(int index) {
    return this.dataPermissions.get(index);
  }
  
  public List<String> getDataPermissions() {
    return this.dataPermissions;
  }
  
  public String getFirstDataPermission() {
    return this.dataPermissions.get(0);
  }
  
  public String getFirstPermission() {
    return this.permissions.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastDataPermission() {
    return this.dataPermissions.get(dataPermissions.size() - 1);
  }
  
  public String getLastPermission() {
    return this.permissions.get(permissions.size() - 1);
  }
  
  public String getMatchingDataPermission(Predicate<String> predicate) {
      for (String item : dataPermissions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPermission(Predicate<String> predicate) {
      for (String item : permissions) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasAzureClientID() {
    return this.azureClientID != null;
  }
  
  public boolean hasAzureRegion() {
    return this.azureRegion != null;
  }
  
  public boolean hasAzureSubscriptionID() {
    return this.azureSubscriptionID != null;
  }
  
  public boolean hasAzureTenantID() {
    return this.azureTenantID != null;
  }
  
  public boolean hasDataPermissions() {
    return this.dataPermissions != null && !(this.dataPermissions.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingDataPermission(Predicate<String> predicate) {
      for (String item : dataPermissions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPermission(Predicate<String> predicate) {
      for (String item : permissions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRoleBinding(Predicate<RoleBindingBuilder> predicate) {
      for (RoleBindingBuilder item : roleBindings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPermissions() {
    return this.permissions != null && !(this.permissions.isEmpty());
  }
  
  public boolean hasRoleBindings() {
    return this.roleBindings != null && !(this.roleBindings.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, azureClientID, azureRegion, azureSubscriptionID, azureTenantID, dataPermissions, kind, permissions, roleBindings, additionalProperties);
  }
  
  public A removeAllFromDataPermissions(Collection<String> items) {
    if (this.dataPermissions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dataPermissions.remove(item);
    }
    return (A) this;
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
  
  public A removeAllFromRoleBindings(Collection<RoleBinding> items) {
    if (this.roleBindings == null) {
      return (A) this;
    }
    for (RoleBinding item : items) {
        RoleBindingBuilder builder = new RoleBindingBuilder(item);
        _visitables.get("roleBindings").remove(builder);
        this.roleBindings.remove(builder);
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
  
  public A removeFromDataPermissions(String... items) {
    if (this.dataPermissions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dataPermissions.remove(item);
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
  
  public A removeFromRoleBindings(RoleBinding... items) {
    if (this.roleBindings == null) {
      return (A) this;
    }
    for (RoleBinding item : items) {
        RoleBindingBuilder builder = new RoleBindingBuilder(item);
        _visitables.get("roleBindings").remove(builder);
        this.roleBindings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRoleBindings(Predicate<RoleBindingBuilder> predicate) {
    if (roleBindings == null) {
      return (A) this;
    }
    Iterator<RoleBindingBuilder> each = roleBindings.iterator();
    List visitables = _visitables.get("roleBindings");
    while (each.hasNext()) {
        RoleBindingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RoleBindingsNested<A> setNewRoleBindingLike(int index,RoleBinding item) {
    return new RoleBindingsNested(index, item);
  }
  
  public A setToDataPermissions(int index,String item) {
    if (this.dataPermissions == null) {
      this.dataPermissions = new ArrayList();
    }
    this.dataPermissions.set(index, item);
    return (A) this;
  }
  
  public A setToPermissions(int index,String item) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    this.permissions.set(index, item);
    return (A) this;
  }
  
  public A setToRoleBindings(int index,RoleBinding item) {
    if (this.roleBindings == null) {
      this.roleBindings = new ArrayList();
    }
    RoleBindingBuilder builder = new RoleBindingBuilder(item);
    if (index < 0 || index >= roleBindings.size()) {
        _visitables.get("roleBindings").add(builder);
        roleBindings.add(builder);
    } else {
        _visitables.get("roleBindings").add(builder);
        roleBindings.set(index, builder);
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
    if (!(azureClientID == null)) {
        sb.append("azureClientID:");
        sb.append(azureClientID);
        sb.append(",");
    }
    if (!(azureRegion == null)) {
        sb.append("azureRegion:");
        sb.append(azureRegion);
        sb.append(",");
    }
    if (!(azureSubscriptionID == null)) {
        sb.append("azureSubscriptionID:");
        sb.append(azureSubscriptionID);
        sb.append(",");
    }
    if (!(azureTenantID == null)) {
        sb.append("azureTenantID:");
        sb.append(azureTenantID);
        sb.append(",");
    }
    if (!(dataPermissions == null) && !(dataPermissions.isEmpty())) {
        sb.append("dataPermissions:");
        sb.append(dataPermissions);
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
    if (!(roleBindings == null) && !(roleBindings.isEmpty())) {
        sb.append("roleBindings:");
        sb.append(roleBindings);
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
  
  public A withAzureClientID(String azureClientID) {
    this.azureClientID = azureClientID;
    return (A) this;
  }
  
  public A withAzureRegion(String azureRegion) {
    this.azureRegion = azureRegion;
    return (A) this;
  }
  
  public A withAzureSubscriptionID(String azureSubscriptionID) {
    this.azureSubscriptionID = azureSubscriptionID;
    return (A) this;
  }
  
  public A withAzureTenantID(String azureTenantID) {
    this.azureTenantID = azureTenantID;
    return (A) this;
  }
  
  public A withDataPermissions(List<String> dataPermissions) {
    if (dataPermissions != null) {
        this.dataPermissions = new ArrayList();
        for (String item : dataPermissions) {
          this.addToDataPermissions(item);
        }
    } else {
      this.dataPermissions = null;
    }
    return (A) this;
  }
  
  public A withDataPermissions(String... dataPermissions) {
    if (this.dataPermissions != null) {
        this.dataPermissions.clear();
        _visitables.remove("dataPermissions");
    }
    if (dataPermissions != null) {
      for (String item : dataPermissions) {
        this.addToDataPermissions(item);
      }
    }
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
  
  public A withRoleBindings(List<RoleBinding> roleBindings) {
    if (this.roleBindings != null) {
      this._visitables.get("roleBindings").clear();
    }
    if (roleBindings != null) {
        this.roleBindings = new ArrayList();
        for (RoleBinding item : roleBindings) {
          this.addToRoleBindings(item);
        }
    } else {
      this.roleBindings = null;
    }
    return (A) this;
  }
  
  public A withRoleBindings(RoleBinding... roleBindings) {
    if (this.roleBindings != null) {
        this.roleBindings.clear();
        _visitables.remove("roleBindings");
    }
    if (roleBindings != null) {
      for (RoleBinding item : roleBindings) {
        this.addToRoleBindings(item);
      }
    }
    return (A) this;
  }
  public class RoleBindingsNested<N> extends RoleBindingFluent<RoleBindingsNested<N>> implements Nested<N>{
  
    RoleBindingBuilder builder;
    int index;
  
    RoleBindingsNested(int index,RoleBinding item) {
      this.index = index;
      this.builder = new RoleBindingBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureProviderSpecFluent.this.setToRoleBindings(index, builder.build());
    }
    
    public N endRoleBinding() {
      return and();
    }
    
  }
}