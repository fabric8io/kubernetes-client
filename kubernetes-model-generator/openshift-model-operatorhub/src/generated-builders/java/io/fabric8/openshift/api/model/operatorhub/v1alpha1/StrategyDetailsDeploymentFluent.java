package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
public class StrategyDetailsDeploymentFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.StrategyDetailsDeploymentFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<StrategyDeploymentPermissionsBuilder> clusterPermissions = new ArrayList<StrategyDeploymentPermissionsBuilder>();
  private ArrayList<StrategyDeploymentSpecBuilder> deployments = new ArrayList<StrategyDeploymentSpecBuilder>();
  private ArrayList<StrategyDeploymentPermissionsBuilder> permissions = new ArrayList<StrategyDeploymentPermissionsBuilder>();

  public StrategyDetailsDeploymentFluent() {
  }
  
  public StrategyDetailsDeploymentFluent(StrategyDetailsDeployment instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterPermissions(Collection<StrategyDeploymentPermissions> items) {
    if (this.clusterPermissions == null) {
      this.clusterPermissions = new ArrayList();
    }
    for (StrategyDeploymentPermissions item : items) {
        StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
        _visitables.get("clusterPermissions").add(builder);
        this.clusterPermissions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDeployments(Collection<StrategyDeploymentSpec> items) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    for (StrategyDeploymentSpec item : items) {
        StrategyDeploymentSpecBuilder builder = new StrategyDeploymentSpecBuilder(item);
        _visitables.get("deployments").add(builder);
        this.deployments.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPermissions(Collection<StrategyDeploymentPermissions> items) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    for (StrategyDeploymentPermissions item : items) {
        StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
        _visitables.get("permissions").add(builder);
        this.permissions.add(builder);
    }
    return (A) this;
  }
  
  public ClusterPermissionsNested<A> addNewClusterPermission() {
    return new ClusterPermissionsNested(-1, null);
  }
  
  public ClusterPermissionsNested<A> addNewClusterPermissionLike(StrategyDeploymentPermissions item) {
    return new ClusterPermissionsNested(-1, item);
  }
  
  public DeploymentsNested<A> addNewDeployment() {
    return new DeploymentsNested(-1, null);
  }
  
  public DeploymentsNested<A> addNewDeploymentLike(StrategyDeploymentSpec item) {
    return new DeploymentsNested(-1, item);
  }
  
  public PermissionsNested<A> addNewPermission() {
    return new PermissionsNested(-1, null);
  }
  
  public PermissionsNested<A> addNewPermissionLike(StrategyDeploymentPermissions item) {
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
  
  public A addToClusterPermissions(StrategyDeploymentPermissions... items) {
    if (this.clusterPermissions == null) {
      this.clusterPermissions = new ArrayList();
    }
    for (StrategyDeploymentPermissions item : items) {
        StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
        _visitables.get("clusterPermissions").add(builder);
        this.clusterPermissions.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterPermissions(int index,StrategyDeploymentPermissions item) {
    if (this.clusterPermissions == null) {
      this.clusterPermissions = new ArrayList();
    }
    StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
    if (index < 0 || index >= clusterPermissions.size()) {
        _visitables.get("clusterPermissions").add(builder);
        clusterPermissions.add(builder);
    } else {
        _visitables.get("clusterPermissions").add(builder);
        clusterPermissions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToDeployments(StrategyDeploymentSpec... items) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    for (StrategyDeploymentSpec item : items) {
        StrategyDeploymentSpecBuilder builder = new StrategyDeploymentSpecBuilder(item);
        _visitables.get("deployments").add(builder);
        this.deployments.add(builder);
    }
    return (A) this;
  }
  
  public A addToDeployments(int index,StrategyDeploymentSpec item) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    StrategyDeploymentSpecBuilder builder = new StrategyDeploymentSpecBuilder(item);
    if (index < 0 || index >= deployments.size()) {
        _visitables.get("deployments").add(builder);
        deployments.add(builder);
    } else {
        _visitables.get("deployments").add(builder);
        deployments.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPermissions(StrategyDeploymentPermissions... items) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    for (StrategyDeploymentPermissions item : items) {
        StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
        _visitables.get("permissions").add(builder);
        this.permissions.add(builder);
    }
    return (A) this;
  }
  
  public A addToPermissions(int index,StrategyDeploymentPermissions item) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
    if (index < 0 || index >= permissions.size()) {
        _visitables.get("permissions").add(builder);
        permissions.add(builder);
    } else {
        _visitables.get("permissions").add(builder);
        permissions.add(index, builder);
    }
    return (A) this;
  }
  
  public StrategyDeploymentPermissions buildClusterPermission(int index) {
    return this.clusterPermissions.get(index).build();
  }
  
  public List<StrategyDeploymentPermissions> buildClusterPermissions() {
    return this.clusterPermissions != null ? build(clusterPermissions) : null;
  }
  
  public StrategyDeploymentSpec buildDeployment(int index) {
    return this.deployments.get(index).build();
  }
  
  public List<StrategyDeploymentSpec> buildDeployments() {
    return this.deployments != null ? build(deployments) : null;
  }
  
  public StrategyDeploymentPermissions buildFirstClusterPermission() {
    return this.clusterPermissions.get(0).build();
  }
  
  public StrategyDeploymentSpec buildFirstDeployment() {
    return this.deployments.get(0).build();
  }
  
  public StrategyDeploymentPermissions buildFirstPermission() {
    return this.permissions.get(0).build();
  }
  
  public StrategyDeploymentPermissions buildLastClusterPermission() {
    return this.clusterPermissions.get(clusterPermissions.size() - 1).build();
  }
  
  public StrategyDeploymentSpec buildLastDeployment() {
    return this.deployments.get(deployments.size() - 1).build();
  }
  
  public StrategyDeploymentPermissions buildLastPermission() {
    return this.permissions.get(permissions.size() - 1).build();
  }
  
  public StrategyDeploymentPermissions buildMatchingClusterPermission(Predicate<StrategyDeploymentPermissionsBuilder> predicate) {
      for (StrategyDeploymentPermissionsBuilder item : clusterPermissions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StrategyDeploymentSpec buildMatchingDeployment(Predicate<StrategyDeploymentSpecBuilder> predicate) {
      for (StrategyDeploymentSpecBuilder item : deployments) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StrategyDeploymentPermissions buildMatchingPermission(Predicate<StrategyDeploymentPermissionsBuilder> predicate) {
      for (StrategyDeploymentPermissionsBuilder item : permissions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StrategyDeploymentPermissions buildPermission(int index) {
    return this.permissions.get(index).build();
  }
  
  public List<StrategyDeploymentPermissions> buildPermissions() {
    return this.permissions != null ? build(permissions) : null;
  }
  
  protected void copyInstance(StrategyDetailsDeployment instance) {
    instance = instance != null ? instance : new StrategyDetailsDeployment();
    if (instance != null) {
        this.withClusterPermissions(instance.getClusterPermissions());
        this.withDeployments(instance.getDeployments());
        this.withPermissions(instance.getPermissions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterPermissionsNested<A> editClusterPermission(int index) {
    if (clusterPermissions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterPermissions"));
    }
    return this.setNewClusterPermissionLike(index, this.buildClusterPermission(index));
  }
  
  public DeploymentsNested<A> editDeployment(int index) {
    if (deployments.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "deployments"));
    }
    return this.setNewDeploymentLike(index, this.buildDeployment(index));
  }
  
  public ClusterPermissionsNested<A> editFirstClusterPermission() {
    if (clusterPermissions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterPermissions"));
    }
    return this.setNewClusterPermissionLike(0, this.buildClusterPermission(0));
  }
  
  public DeploymentsNested<A> editFirstDeployment() {
    if (deployments.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "deployments"));
    }
    return this.setNewDeploymentLike(0, this.buildDeployment(0));
  }
  
  public PermissionsNested<A> editFirstPermission() {
    if (permissions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "permissions"));
    }
    return this.setNewPermissionLike(0, this.buildPermission(0));
  }
  
  public ClusterPermissionsNested<A> editLastClusterPermission() {
    int index = clusterPermissions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterPermissions"));
    }
    return this.setNewClusterPermissionLike(index, this.buildClusterPermission(index));
  }
  
  public DeploymentsNested<A> editLastDeployment() {
    int index = deployments.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "deployments"));
    }
    return this.setNewDeploymentLike(index, this.buildDeployment(index));
  }
  
  public PermissionsNested<A> editLastPermission() {
    int index = permissions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "permissions"));
    }
    return this.setNewPermissionLike(index, this.buildPermission(index));
  }
  
  public ClusterPermissionsNested<A> editMatchingClusterPermission(Predicate<StrategyDeploymentPermissionsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterPermissions.size();i++) {
      if (predicate.test(clusterPermissions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterPermissions"));
    }
    return this.setNewClusterPermissionLike(index, this.buildClusterPermission(index));
  }
  
  public DeploymentsNested<A> editMatchingDeployment(Predicate<StrategyDeploymentSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < deployments.size();i++) {
      if (predicate.test(deployments.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "deployments"));
    }
    return this.setNewDeploymentLike(index, this.buildDeployment(index));
  }
  
  public PermissionsNested<A> editMatchingPermission(Predicate<StrategyDeploymentPermissionsBuilder> predicate) {
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
    StrategyDetailsDeploymentFluent that = (StrategyDetailsDeploymentFluent) o;
    if (!(Objects.equals(clusterPermissions, that.clusterPermissions))) {
      return false;
    }
    if (!(Objects.equals(deployments, that.deployments))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterPermissions() {
    return this.clusterPermissions != null && !(this.clusterPermissions.isEmpty());
  }
  
  public boolean hasDeployments() {
    return this.deployments != null && !(this.deployments.isEmpty());
  }
  
  public boolean hasMatchingClusterPermission(Predicate<StrategyDeploymentPermissionsBuilder> predicate) {
      for (StrategyDeploymentPermissionsBuilder item : clusterPermissions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDeployment(Predicate<StrategyDeploymentSpecBuilder> predicate) {
      for (StrategyDeploymentSpecBuilder item : deployments) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPermission(Predicate<StrategyDeploymentPermissionsBuilder> predicate) {
      for (StrategyDeploymentPermissionsBuilder item : permissions) {
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
    return Objects.hash(clusterPermissions, deployments, permissions, additionalProperties);
  }
  
  public A removeAllFromClusterPermissions(Collection<StrategyDeploymentPermissions> items) {
    if (this.clusterPermissions == null) {
      return (A) this;
    }
    for (StrategyDeploymentPermissions item : items) {
        StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
        _visitables.get("clusterPermissions").remove(builder);
        this.clusterPermissions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDeployments(Collection<StrategyDeploymentSpec> items) {
    if (this.deployments == null) {
      return (A) this;
    }
    for (StrategyDeploymentSpec item : items) {
        StrategyDeploymentSpecBuilder builder = new StrategyDeploymentSpecBuilder(item);
        _visitables.get("deployments").remove(builder);
        this.deployments.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPermissions(Collection<StrategyDeploymentPermissions> items) {
    if (this.permissions == null) {
      return (A) this;
    }
    for (StrategyDeploymentPermissions item : items) {
        StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
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
  
  public A removeFromClusterPermissions(StrategyDeploymentPermissions... items) {
    if (this.clusterPermissions == null) {
      return (A) this;
    }
    for (StrategyDeploymentPermissions item : items) {
        StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
        _visitables.get("clusterPermissions").remove(builder);
        this.clusterPermissions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromDeployments(StrategyDeploymentSpec... items) {
    if (this.deployments == null) {
      return (A) this;
    }
    for (StrategyDeploymentSpec item : items) {
        StrategyDeploymentSpecBuilder builder = new StrategyDeploymentSpecBuilder(item);
        _visitables.get("deployments").remove(builder);
        this.deployments.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPermissions(StrategyDeploymentPermissions... items) {
    if (this.permissions == null) {
      return (A) this;
    }
    for (StrategyDeploymentPermissions item : items) {
        StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
        _visitables.get("permissions").remove(builder);
        this.permissions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterPermissions(Predicate<StrategyDeploymentPermissionsBuilder> predicate) {
    if (clusterPermissions == null) {
      return (A) this;
    }
    Iterator<StrategyDeploymentPermissionsBuilder> each = clusterPermissions.iterator();
    List visitables = _visitables.get("clusterPermissions");
    while (each.hasNext()) {
        StrategyDeploymentPermissionsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromDeployments(Predicate<StrategyDeploymentSpecBuilder> predicate) {
    if (deployments == null) {
      return (A) this;
    }
    Iterator<StrategyDeploymentSpecBuilder> each = deployments.iterator();
    List visitables = _visitables.get("deployments");
    while (each.hasNext()) {
        StrategyDeploymentSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPermissions(Predicate<StrategyDeploymentPermissionsBuilder> predicate) {
    if (permissions == null) {
      return (A) this;
    }
    Iterator<StrategyDeploymentPermissionsBuilder> each = permissions.iterator();
    List visitables = _visitables.get("permissions");
    while (each.hasNext()) {
        StrategyDeploymentPermissionsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClusterPermissionsNested<A> setNewClusterPermissionLike(int index,StrategyDeploymentPermissions item) {
    return new ClusterPermissionsNested(index, item);
  }
  
  public DeploymentsNested<A> setNewDeploymentLike(int index,StrategyDeploymentSpec item) {
    return new DeploymentsNested(index, item);
  }
  
  public PermissionsNested<A> setNewPermissionLike(int index,StrategyDeploymentPermissions item) {
    return new PermissionsNested(index, item);
  }
  
  public A setToClusterPermissions(int index,StrategyDeploymentPermissions item) {
    if (this.clusterPermissions == null) {
      this.clusterPermissions = new ArrayList();
    }
    StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
    if (index < 0 || index >= clusterPermissions.size()) {
        _visitables.get("clusterPermissions").add(builder);
        clusterPermissions.add(builder);
    } else {
        _visitables.get("clusterPermissions").add(builder);
        clusterPermissions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDeployments(int index,StrategyDeploymentSpec item) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    StrategyDeploymentSpecBuilder builder = new StrategyDeploymentSpecBuilder(item);
    if (index < 0 || index >= deployments.size()) {
        _visitables.get("deployments").add(builder);
        deployments.add(builder);
    } else {
        _visitables.get("deployments").add(builder);
        deployments.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPermissions(int index,StrategyDeploymentPermissions item) {
    if (this.permissions == null) {
      this.permissions = new ArrayList();
    }
    StrategyDeploymentPermissionsBuilder builder = new StrategyDeploymentPermissionsBuilder(item);
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
    if (!(clusterPermissions == null) && !(clusterPermissions.isEmpty())) {
        sb.append("clusterPermissions:");
        sb.append(clusterPermissions);
        sb.append(",");
    }
    if (!(deployments == null) && !(deployments.isEmpty())) {
        sb.append("deployments:");
        sb.append(deployments);
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
  
  public A withClusterPermissions(List<StrategyDeploymentPermissions> clusterPermissions) {
    if (this.clusterPermissions != null) {
      this._visitables.get("clusterPermissions").clear();
    }
    if (clusterPermissions != null) {
        this.clusterPermissions = new ArrayList();
        for (StrategyDeploymentPermissions item : clusterPermissions) {
          this.addToClusterPermissions(item);
        }
    } else {
      this.clusterPermissions = null;
    }
    return (A) this;
  }
  
  public A withClusterPermissions(StrategyDeploymentPermissions... clusterPermissions) {
    if (this.clusterPermissions != null) {
        this.clusterPermissions.clear();
        _visitables.remove("clusterPermissions");
    }
    if (clusterPermissions != null) {
      for (StrategyDeploymentPermissions item : clusterPermissions) {
        this.addToClusterPermissions(item);
      }
    }
    return (A) this;
  }
  
  public A withDeployments(List<StrategyDeploymentSpec> deployments) {
    if (this.deployments != null) {
      this._visitables.get("deployments").clear();
    }
    if (deployments != null) {
        this.deployments = new ArrayList();
        for (StrategyDeploymentSpec item : deployments) {
          this.addToDeployments(item);
        }
    } else {
      this.deployments = null;
    }
    return (A) this;
  }
  
  public A withDeployments(StrategyDeploymentSpec... deployments) {
    if (this.deployments != null) {
        this.deployments.clear();
        _visitables.remove("deployments");
    }
    if (deployments != null) {
      for (StrategyDeploymentSpec item : deployments) {
        this.addToDeployments(item);
      }
    }
    return (A) this;
  }
  
  public A withPermissions(List<StrategyDeploymentPermissions> permissions) {
    if (this.permissions != null) {
      this._visitables.get("permissions").clear();
    }
    if (permissions != null) {
        this.permissions = new ArrayList();
        for (StrategyDeploymentPermissions item : permissions) {
          this.addToPermissions(item);
        }
    } else {
      this.permissions = null;
    }
    return (A) this;
  }
  
  public A withPermissions(StrategyDeploymentPermissions... permissions) {
    if (this.permissions != null) {
        this.permissions.clear();
        _visitables.remove("permissions");
    }
    if (permissions != null) {
      for (StrategyDeploymentPermissions item : permissions) {
        this.addToPermissions(item);
      }
    }
    return (A) this;
  }
  public class ClusterPermissionsNested<N> extends StrategyDeploymentPermissionsFluent<ClusterPermissionsNested<N>> implements Nested<N>{
  
    StrategyDeploymentPermissionsBuilder builder;
    int index;
  
    ClusterPermissionsNested(int index,StrategyDeploymentPermissions item) {
      this.index = index;
      this.builder = new StrategyDeploymentPermissionsBuilder(this, item);
    }
  
    public N and() {
      return (N) StrategyDetailsDeploymentFluent.this.setToClusterPermissions(index, builder.build());
    }
    
    public N endClusterPermission() {
      return and();
    }
    
  }
  public class DeploymentsNested<N> extends StrategyDeploymentSpecFluent<DeploymentsNested<N>> implements Nested<N>{
  
    StrategyDeploymentSpecBuilder builder;
    int index;
  
    DeploymentsNested(int index,StrategyDeploymentSpec item) {
      this.index = index;
      this.builder = new StrategyDeploymentSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) StrategyDetailsDeploymentFluent.this.setToDeployments(index, builder.build());
    }
    
    public N endDeployment() {
      return and();
    }
    
  }
  public class PermissionsNested<N> extends StrategyDeploymentPermissionsFluent<PermissionsNested<N>> implements Nested<N>{
  
    StrategyDeploymentPermissionsBuilder builder;
    int index;
  
    PermissionsNested(int index,StrategyDeploymentPermissions item) {
      this.index = index;
      this.builder = new StrategyDeploymentPermissionsBuilder(this, item);
    }
  
    public N and() {
      return (N) StrategyDetailsDeploymentFluent.this.setToPermissions(index, builder.build());
    }
    
    public N endPermission() {
      return and();
    }
    
  }
}