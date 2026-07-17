package io.fabric8.openshift.api.model.hive.v1;

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
public class ClusterDeploymentCustomizationSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterDeploymentCustomizationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PatchEntityBuilder> installConfigPatches = new ArrayList<PatchEntityBuilder>();

  public ClusterDeploymentCustomizationSpecFluent() {
  }
  
  public ClusterDeploymentCustomizationSpecFluent(ClusterDeploymentCustomizationSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToInstallConfigPatches(Collection<PatchEntity> items) {
    if (this.installConfigPatches == null) {
      this.installConfigPatches = new ArrayList();
    }
    for (PatchEntity item : items) {
        PatchEntityBuilder builder = new PatchEntityBuilder(item);
        _visitables.get("installConfigPatches").add(builder);
        this.installConfigPatches.add(builder);
    }
    return (A) this;
  }
  
  public InstallConfigPatchesNested<A> addNewInstallConfigPatch() {
    return new InstallConfigPatchesNested(-1, null);
  }
  
  public A addNewInstallConfigPatch(String from,String op,String path,String value) {
    return (A) this.addToInstallConfigPatches(new PatchEntity(from, op, path, value));
  }
  
  public InstallConfigPatchesNested<A> addNewInstallConfigPatchLike(PatchEntity item) {
    return new InstallConfigPatchesNested(-1, item);
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
  
  public A addToInstallConfigPatches(PatchEntity... items) {
    if (this.installConfigPatches == null) {
      this.installConfigPatches = new ArrayList();
    }
    for (PatchEntity item : items) {
        PatchEntityBuilder builder = new PatchEntityBuilder(item);
        _visitables.get("installConfigPatches").add(builder);
        this.installConfigPatches.add(builder);
    }
    return (A) this;
  }
  
  public A addToInstallConfigPatches(int index,PatchEntity item) {
    if (this.installConfigPatches == null) {
      this.installConfigPatches = new ArrayList();
    }
    PatchEntityBuilder builder = new PatchEntityBuilder(item);
    if (index < 0 || index >= installConfigPatches.size()) {
        _visitables.get("installConfigPatches").add(builder);
        installConfigPatches.add(builder);
    } else {
        _visitables.get("installConfigPatches").add(builder);
        installConfigPatches.add(index, builder);
    }
    return (A) this;
  }
  
  public PatchEntity buildFirstInstallConfigPatch() {
    return this.installConfigPatches.get(0).build();
  }
  
  public PatchEntity buildInstallConfigPatch(int index) {
    return this.installConfigPatches.get(index).build();
  }
  
  public List<PatchEntity> buildInstallConfigPatches() {
    return this.installConfigPatches != null ? build(installConfigPatches) : null;
  }
  
  public PatchEntity buildLastInstallConfigPatch() {
    return this.installConfigPatches.get(installConfigPatches.size() - 1).build();
  }
  
  public PatchEntity buildMatchingInstallConfigPatch(Predicate<PatchEntityBuilder> predicate) {
      for (PatchEntityBuilder item : installConfigPatches) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ClusterDeploymentCustomizationSpec instance) {
    instance = instance != null ? instance : new ClusterDeploymentCustomizationSpec();
    if (instance != null) {
        this.withInstallConfigPatches(instance.getInstallConfigPatches());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public InstallConfigPatchesNested<A> editFirstInstallConfigPatch() {
    if (installConfigPatches.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "installConfigPatches"));
    }
    return this.setNewInstallConfigPatchLike(0, this.buildInstallConfigPatch(0));
  }
  
  public InstallConfigPatchesNested<A> editInstallConfigPatch(int index) {
    if (installConfigPatches.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "installConfigPatches"));
    }
    return this.setNewInstallConfigPatchLike(index, this.buildInstallConfigPatch(index));
  }
  
  public InstallConfigPatchesNested<A> editLastInstallConfigPatch() {
    int index = installConfigPatches.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "installConfigPatches"));
    }
    return this.setNewInstallConfigPatchLike(index, this.buildInstallConfigPatch(index));
  }
  
  public InstallConfigPatchesNested<A> editMatchingInstallConfigPatch(Predicate<PatchEntityBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < installConfigPatches.size();i++) {
      if (predicate.test(installConfigPatches.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "installConfigPatches"));
    }
    return this.setNewInstallConfigPatchLike(index, this.buildInstallConfigPatch(index));
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
    ClusterDeploymentCustomizationSpecFluent that = (ClusterDeploymentCustomizationSpecFluent) o;
    if (!(Objects.equals(installConfigPatches, that.installConfigPatches))) {
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
  
  public boolean hasInstallConfigPatches() {
    return this.installConfigPatches != null && !(this.installConfigPatches.isEmpty());
  }
  
  public boolean hasMatchingInstallConfigPatch(Predicate<PatchEntityBuilder> predicate) {
      for (PatchEntityBuilder item : installConfigPatches) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(installConfigPatches, additionalProperties);
  }
  
  public A removeAllFromInstallConfigPatches(Collection<PatchEntity> items) {
    if (this.installConfigPatches == null) {
      return (A) this;
    }
    for (PatchEntity item : items) {
        PatchEntityBuilder builder = new PatchEntityBuilder(item);
        _visitables.get("installConfigPatches").remove(builder);
        this.installConfigPatches.remove(builder);
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
  
  public A removeFromInstallConfigPatches(PatchEntity... items) {
    if (this.installConfigPatches == null) {
      return (A) this;
    }
    for (PatchEntity item : items) {
        PatchEntityBuilder builder = new PatchEntityBuilder(item);
        _visitables.get("installConfigPatches").remove(builder);
        this.installConfigPatches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromInstallConfigPatches(Predicate<PatchEntityBuilder> predicate) {
    if (installConfigPatches == null) {
      return (A) this;
    }
    Iterator<PatchEntityBuilder> each = installConfigPatches.iterator();
    List visitables = _visitables.get("installConfigPatches");
    while (each.hasNext()) {
        PatchEntityBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public InstallConfigPatchesNested<A> setNewInstallConfigPatchLike(int index,PatchEntity item) {
    return new InstallConfigPatchesNested(index, item);
  }
  
  public A setToInstallConfigPatches(int index,PatchEntity item) {
    if (this.installConfigPatches == null) {
      this.installConfigPatches = new ArrayList();
    }
    PatchEntityBuilder builder = new PatchEntityBuilder(item);
    if (index < 0 || index >= installConfigPatches.size()) {
        _visitables.get("installConfigPatches").add(builder);
        installConfigPatches.add(builder);
    } else {
        _visitables.get("installConfigPatches").add(builder);
        installConfigPatches.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(installConfigPatches == null) && !(installConfigPatches.isEmpty())) {
        sb.append("installConfigPatches:");
        sb.append(installConfigPatches);
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
  
  public A withInstallConfigPatches(List<PatchEntity> installConfigPatches) {
    if (this.installConfigPatches != null) {
      this._visitables.get("installConfigPatches").clear();
    }
    if (installConfigPatches != null) {
        this.installConfigPatches = new ArrayList();
        for (PatchEntity item : installConfigPatches) {
          this.addToInstallConfigPatches(item);
        }
    } else {
      this.installConfigPatches = null;
    }
    return (A) this;
  }
  
  public A withInstallConfigPatches(PatchEntity... installConfigPatches) {
    if (this.installConfigPatches != null) {
        this.installConfigPatches.clear();
        _visitables.remove("installConfigPatches");
    }
    if (installConfigPatches != null) {
      for (PatchEntity item : installConfigPatches) {
        this.addToInstallConfigPatches(item);
      }
    }
    return (A) this;
  }
  public class InstallConfigPatchesNested<N> extends PatchEntityFluent<InstallConfigPatchesNested<N>> implements Nested<N>{
  
    PatchEntityBuilder builder;
    int index;
  
    InstallConfigPatchesNested(int index,PatchEntity item) {
      this.index = index;
      this.builder = new PatchEntityBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentCustomizationSpecFluent.this.setToInstallConfigPatches(index, builder.build());
    }
    
    public N endInstallConfigPatch() {
      return and();
    }
    
  }
}