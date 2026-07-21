package io.fabric8.openclustermanagement.api.model.apps.v1;

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
public class OverridesFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.OverridesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String packageAlias;
  private String packageName;
  private ArrayList<PackageOverrideBuilder> packageOverrides = new ArrayList<PackageOverrideBuilder>();

  public OverridesFluent() {
  }
  
  public OverridesFluent(Overrides instance) {
    this.copyInstance(instance);
  }

  public A addAllToPackageOverrides(Collection<PackageOverride> items) {
    if (this.packageOverrides == null) {
      this.packageOverrides = new ArrayList();
    }
    for (PackageOverride item : items) {
        PackageOverrideBuilder builder = new PackageOverrideBuilder(item);
        _visitables.get("packageOverrides").add(builder);
        this.packageOverrides.add(builder);
    }
    return (A) this;
  }
  
  public PackageOverridesNested<A> addNewPackageOverride() {
    return new PackageOverridesNested(-1, null);
  }
  
  public PackageOverridesNested<A> addNewPackageOverrideLike(PackageOverride item) {
    return new PackageOverridesNested(-1, item);
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
  
  public A addToPackageOverrides(PackageOverride... items) {
    if (this.packageOverrides == null) {
      this.packageOverrides = new ArrayList();
    }
    for (PackageOverride item : items) {
        PackageOverrideBuilder builder = new PackageOverrideBuilder(item);
        _visitables.get("packageOverrides").add(builder);
        this.packageOverrides.add(builder);
    }
    return (A) this;
  }
  
  public A addToPackageOverrides(int index,PackageOverride item) {
    if (this.packageOverrides == null) {
      this.packageOverrides = new ArrayList();
    }
    PackageOverrideBuilder builder = new PackageOverrideBuilder(item);
    if (index < 0 || index >= packageOverrides.size()) {
        _visitables.get("packageOverrides").add(builder);
        packageOverrides.add(builder);
    } else {
        _visitables.get("packageOverrides").add(builder);
        packageOverrides.add(index, builder);
    }
    return (A) this;
  }
  
  public PackageOverride buildFirstPackageOverride() {
    return this.packageOverrides.get(0).build();
  }
  
  public PackageOverride buildLastPackageOverride() {
    return this.packageOverrides.get(packageOverrides.size() - 1).build();
  }
  
  public PackageOverride buildMatchingPackageOverride(Predicate<PackageOverrideBuilder> predicate) {
      for (PackageOverrideBuilder item : packageOverrides) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PackageOverride buildPackageOverride(int index) {
    return this.packageOverrides.get(index).build();
  }
  
  public List<PackageOverride> buildPackageOverrides() {
    return this.packageOverrides != null ? build(packageOverrides) : null;
  }
  
  protected void copyInstance(Overrides instance) {
    instance = instance != null ? instance : new Overrides();
    if (instance != null) {
        this.withPackageAlias(instance.getPackageAlias());
        this.withPackageName(instance.getPackageName());
        this.withPackageOverrides(instance.getPackageOverrides());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PackageOverridesNested<A> editFirstPackageOverride() {
    if (packageOverrides.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "packageOverrides"));
    }
    return this.setNewPackageOverrideLike(0, this.buildPackageOverride(0));
  }
  
  public PackageOverridesNested<A> editLastPackageOverride() {
    int index = packageOverrides.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "packageOverrides"));
    }
    return this.setNewPackageOverrideLike(index, this.buildPackageOverride(index));
  }
  
  public PackageOverridesNested<A> editMatchingPackageOverride(Predicate<PackageOverrideBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < packageOverrides.size();i++) {
      if (predicate.test(packageOverrides.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "packageOverrides"));
    }
    return this.setNewPackageOverrideLike(index, this.buildPackageOverride(index));
  }
  
  public PackageOverridesNested<A> editPackageOverride(int index) {
    if (packageOverrides.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "packageOverrides"));
    }
    return this.setNewPackageOverrideLike(index, this.buildPackageOverride(index));
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
    OverridesFluent that = (OverridesFluent) o;
    if (!(Objects.equals(packageAlias, that.packageAlias))) {
      return false;
    }
    if (!(Objects.equals(packageName, that.packageName))) {
      return false;
    }
    if (!(Objects.equals(packageOverrides, that.packageOverrides))) {
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
  
  public String getPackageAlias() {
    return this.packageAlias;
  }
  
  public String getPackageName() {
    return this.packageName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingPackageOverride(Predicate<PackageOverrideBuilder> predicate) {
      for (PackageOverrideBuilder item : packageOverrides) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPackageAlias() {
    return this.packageAlias != null;
  }
  
  public boolean hasPackageName() {
    return this.packageName != null;
  }
  
  public boolean hasPackageOverrides() {
    return this.packageOverrides != null && !(this.packageOverrides.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(packageAlias, packageName, packageOverrides, additionalProperties);
  }
  
  public A removeAllFromPackageOverrides(Collection<PackageOverride> items) {
    if (this.packageOverrides == null) {
      return (A) this;
    }
    for (PackageOverride item : items) {
        PackageOverrideBuilder builder = new PackageOverrideBuilder(item);
        _visitables.get("packageOverrides").remove(builder);
        this.packageOverrides.remove(builder);
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
  
  public A removeFromPackageOverrides(PackageOverride... items) {
    if (this.packageOverrides == null) {
      return (A) this;
    }
    for (PackageOverride item : items) {
        PackageOverrideBuilder builder = new PackageOverrideBuilder(item);
        _visitables.get("packageOverrides").remove(builder);
        this.packageOverrides.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPackageOverrides(Predicate<PackageOverrideBuilder> predicate) {
    if (packageOverrides == null) {
      return (A) this;
    }
    Iterator<PackageOverrideBuilder> each = packageOverrides.iterator();
    List visitables = _visitables.get("packageOverrides");
    while (each.hasNext()) {
        PackageOverrideBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PackageOverridesNested<A> setNewPackageOverrideLike(int index,PackageOverride item) {
    return new PackageOverridesNested(index, item);
  }
  
  public A setToPackageOverrides(int index,PackageOverride item) {
    if (this.packageOverrides == null) {
      this.packageOverrides = new ArrayList();
    }
    PackageOverrideBuilder builder = new PackageOverrideBuilder(item);
    if (index < 0 || index >= packageOverrides.size()) {
        _visitables.get("packageOverrides").add(builder);
        packageOverrides.add(builder);
    } else {
        _visitables.get("packageOverrides").add(builder);
        packageOverrides.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(packageAlias == null)) {
        sb.append("packageAlias:");
        sb.append(packageAlias);
        sb.append(",");
    }
    if (!(packageName == null)) {
        sb.append("packageName:");
        sb.append(packageName);
        sb.append(",");
    }
    if (!(packageOverrides == null) && !(packageOverrides.isEmpty())) {
        sb.append("packageOverrides:");
        sb.append(packageOverrides);
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
  
  public A withPackageAlias(String packageAlias) {
    this.packageAlias = packageAlias;
    return (A) this;
  }
  
  public A withPackageName(String packageName) {
    this.packageName = packageName;
    return (A) this;
  }
  
  public A withPackageOverrides(List<PackageOverride> packageOverrides) {
    if (this.packageOverrides != null) {
      this._visitables.get("packageOverrides").clear();
    }
    if (packageOverrides != null) {
        this.packageOverrides = new ArrayList();
        for (PackageOverride item : packageOverrides) {
          this.addToPackageOverrides(item);
        }
    } else {
      this.packageOverrides = null;
    }
    return (A) this;
  }
  
  public A withPackageOverrides(PackageOverride... packageOverrides) {
    if (this.packageOverrides != null) {
        this.packageOverrides.clear();
        _visitables.remove("packageOverrides");
    }
    if (packageOverrides != null) {
      for (PackageOverride item : packageOverrides) {
        this.addToPackageOverrides(item);
      }
    }
    return (A) this;
  }
  public class PackageOverridesNested<N> extends PackageOverrideFluent<PackageOverridesNested<N>> implements Nested<N>{
  
    PackageOverrideBuilder builder;
    int index;
  
    PackageOverridesNested(int index,PackageOverride item) {
      this.index = index;
      this.builder = new PackageOverrideBuilder(this, item);
    }
  
    public N and() {
      return (N) OverridesFluent.this.setToPackageOverrides(index, builder.build());
    }
    
    public N endPackageOverride() {
      return and();
    }
    
  }
}