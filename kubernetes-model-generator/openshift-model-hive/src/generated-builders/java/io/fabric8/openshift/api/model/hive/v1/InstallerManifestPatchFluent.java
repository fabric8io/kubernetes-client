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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class InstallerManifestPatchFluent<A extends io.fabric8.openshift.api.model.hive.v1.InstallerManifestPatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ManifestSelectorBuilder manifestSelector;
  private ArrayList<PatchEntityBuilder> patches = new ArrayList<PatchEntityBuilder>();

  public InstallerManifestPatchFluent() {
  }
  
  public InstallerManifestPatchFluent(InstallerManifestPatch instance) {
    this.copyInstance(instance);
  }

  public A addAllToPatches(Collection<PatchEntity> items) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    for (PatchEntity item : items) {
        PatchEntityBuilder builder = new PatchEntityBuilder(item);
        _visitables.get("patches").add(builder);
        this.patches.add(builder);
    }
    return (A) this;
  }
  
  public PatchesNested<A> addNewPatch() {
    return new PatchesNested(-1, null);
  }
  
  public A addNewPatch(String from,String op,String path,String value,String valueJSON) {
    return (A) this.addToPatches(new PatchEntity(from, op, path, value, valueJSON));
  }
  
  public PatchesNested<A> addNewPatchLike(PatchEntity item) {
    return new PatchesNested(-1, item);
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
  
  public A addToPatches(PatchEntity... items) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    for (PatchEntity item : items) {
        PatchEntityBuilder builder = new PatchEntityBuilder(item);
        _visitables.get("patches").add(builder);
        this.patches.add(builder);
    }
    return (A) this;
  }
  
  public A addToPatches(int index,PatchEntity item) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    PatchEntityBuilder builder = new PatchEntityBuilder(item);
    if (index < 0 || index >= patches.size()) {
        _visitables.get("patches").add(builder);
        patches.add(builder);
    } else {
        _visitables.get("patches").add(builder);
        patches.add(index, builder);
    }
    return (A) this;
  }
  
  public PatchEntity buildFirstPatch() {
    return this.patches.get(0).build();
  }
  
  public PatchEntity buildLastPatch() {
    return this.patches.get(patches.size() - 1).build();
  }
  
  public ManifestSelector buildManifestSelector() {
    return this.manifestSelector != null ? this.manifestSelector.build() : null;
  }
  
  public PatchEntity buildMatchingPatch(Predicate<PatchEntityBuilder> predicate) {
      for (PatchEntityBuilder item : patches) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PatchEntity buildPatch(int index) {
    return this.patches.get(index).build();
  }
  
  public List<PatchEntity> buildPatches() {
    return this.patches != null ? build(patches) : null;
  }
  
  protected void copyInstance(InstallerManifestPatch instance) {
    instance = instance != null ? instance : new InstallerManifestPatch();
    if (instance != null) {
        this.withManifestSelector(instance.getManifestSelector());
        this.withPatches(instance.getPatches());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PatchesNested<A> editFirstPatch() {
    if (patches.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "patches"));
    }
    return this.setNewPatchLike(0, this.buildPatch(0));
  }
  
  public PatchesNested<A> editLastPatch() {
    int index = patches.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "patches"));
    }
    return this.setNewPatchLike(index, this.buildPatch(index));
  }
  
  public ManifestSelectorNested<A> editManifestSelector() {
    return this.withNewManifestSelectorLike(Optional.ofNullable(this.buildManifestSelector()).orElse(null));
  }
  
  public PatchesNested<A> editMatchingPatch(Predicate<PatchEntityBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < patches.size();i++) {
      if (predicate.test(patches.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "patches"));
    }
    return this.setNewPatchLike(index, this.buildPatch(index));
  }
  
  public ManifestSelectorNested<A> editOrNewManifestSelector() {
    return this.withNewManifestSelectorLike(Optional.ofNullable(this.buildManifestSelector()).orElse(new ManifestSelectorBuilder().build()));
  }
  
  public ManifestSelectorNested<A> editOrNewManifestSelectorLike(ManifestSelector item) {
    return this.withNewManifestSelectorLike(Optional.ofNullable(this.buildManifestSelector()).orElse(item));
  }
  
  public PatchesNested<A> editPatch(int index) {
    if (patches.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "patches"));
    }
    return this.setNewPatchLike(index, this.buildPatch(index));
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
    InstallerManifestPatchFluent that = (InstallerManifestPatchFluent) o;
    if (!(Objects.equals(manifestSelector, that.manifestSelector))) {
      return false;
    }
    if (!(Objects.equals(patches, that.patches))) {
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
  
  public boolean hasManifestSelector() {
    return this.manifestSelector != null;
  }
  
  public boolean hasMatchingPatch(Predicate<PatchEntityBuilder> predicate) {
      for (PatchEntityBuilder item : patches) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPatches() {
    return this.patches != null && !(this.patches.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(manifestSelector, patches, additionalProperties);
  }
  
  public A removeAllFromPatches(Collection<PatchEntity> items) {
    if (this.patches == null) {
      return (A) this;
    }
    for (PatchEntity item : items) {
        PatchEntityBuilder builder = new PatchEntityBuilder(item);
        _visitables.get("patches").remove(builder);
        this.patches.remove(builder);
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
  
  public A removeFromPatches(PatchEntity... items) {
    if (this.patches == null) {
      return (A) this;
    }
    for (PatchEntity item : items) {
        PatchEntityBuilder builder = new PatchEntityBuilder(item);
        _visitables.get("patches").remove(builder);
        this.patches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPatches(Predicate<PatchEntityBuilder> predicate) {
    if (patches == null) {
      return (A) this;
    }
    Iterator<PatchEntityBuilder> each = patches.iterator();
    List visitables = _visitables.get("patches");
    while (each.hasNext()) {
        PatchEntityBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PatchesNested<A> setNewPatchLike(int index,PatchEntity item) {
    return new PatchesNested(index, item);
  }
  
  public A setToPatches(int index,PatchEntity item) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    PatchEntityBuilder builder = new PatchEntityBuilder(item);
    if (index < 0 || index >= patches.size()) {
        _visitables.get("patches").add(builder);
        patches.add(builder);
    } else {
        _visitables.get("patches").add(builder);
        patches.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(manifestSelector == null)) {
        sb.append("manifestSelector:");
        sb.append(manifestSelector);
        sb.append(",");
    }
    if (!(patches == null) && !(patches.isEmpty())) {
        sb.append("patches:");
        sb.append(patches);
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
  
  public A withManifestSelector(ManifestSelector manifestSelector) {
    this._visitables.remove("manifestSelector");
    if (manifestSelector != null) {
        this.manifestSelector = new ManifestSelectorBuilder(manifestSelector);
        this._visitables.get("manifestSelector").add(this.manifestSelector);
    } else {
        this.manifestSelector = null;
        this._visitables.get("manifestSelector").remove(this.manifestSelector);
    }
    return (A) this;
  }
  
  public ManifestSelectorNested<A> withNewManifestSelector() {
    return new ManifestSelectorNested(null);
  }
  
  public A withNewManifestSelector(String glob) {
    return (A) this.withManifestSelector(new ManifestSelector(glob));
  }
  
  public ManifestSelectorNested<A> withNewManifestSelectorLike(ManifestSelector item) {
    return new ManifestSelectorNested(item);
  }
  
  public A withPatches(List<PatchEntity> patches) {
    if (this.patches != null) {
      this._visitables.get("patches").clear();
    }
    if (patches != null) {
        this.patches = new ArrayList();
        for (PatchEntity item : patches) {
          this.addToPatches(item);
        }
    } else {
      this.patches = null;
    }
    return (A) this;
  }
  
  public A withPatches(PatchEntity... patches) {
    if (this.patches != null) {
        this.patches.clear();
        _visitables.remove("patches");
    }
    if (patches != null) {
      for (PatchEntity item : patches) {
        this.addToPatches(item);
      }
    }
    return (A) this;
  }
  public class ManifestSelectorNested<N> extends ManifestSelectorFluent<ManifestSelectorNested<N>> implements Nested<N>{
  
    ManifestSelectorBuilder builder;
  
    ManifestSelectorNested(ManifestSelector item) {
      this.builder = new ManifestSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallerManifestPatchFluent.this.withManifestSelector(builder.build());
    }
    
    public N endManifestSelector() {
      return and();
    }
    
  }
  public class PatchesNested<N> extends PatchEntityFluent<PatchesNested<N>> implements Nested<N>{
  
    PatchEntityBuilder builder;
    int index;
  
    PatchesNested(int index,PatchEntity item) {
      this.index = index;
      this.builder = new PatchEntityBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallerManifestPatchFluent.this.setToPatches(index, builder.build());
    }
    
    public N endPatch() {
      return and();
    }
    
  }
}