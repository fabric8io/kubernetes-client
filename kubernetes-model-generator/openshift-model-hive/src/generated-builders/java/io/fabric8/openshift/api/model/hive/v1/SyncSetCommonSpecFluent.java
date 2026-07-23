package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class SyncSetCommonSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.SyncSetCommonSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String applyBehavior;
  private Boolean enableResourceTemplates;
  private ArrayList<SyncObjectPatchBuilder> patches = new ArrayList<SyncObjectPatchBuilder>();
  private String resourceApplyMode;
  private List<Object> resources = new ArrayList<Object>();
  private ArrayList<SecretMappingBuilder> secretMappings = new ArrayList<SecretMappingBuilder>();

  public SyncSetCommonSpecFluent() {
  }
  
  public SyncSetCommonSpecFluent(SyncSetCommonSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPatches(Collection<SyncObjectPatch> items) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    for (SyncObjectPatch item : items) {
        SyncObjectPatchBuilder builder = new SyncObjectPatchBuilder(item);
        _visitables.get("patches").add(builder);
        this.patches.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResources(Collection<Object> items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (Object item : items) {
      this.resources.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSecretMappings(Collection<SecretMapping> items) {
    if (this.secretMappings == null) {
      this.secretMappings = new ArrayList();
    }
    for (SecretMapping item : items) {
        SecretMappingBuilder builder = new SecretMappingBuilder(item);
        _visitables.get("secretMappings").add(builder);
        this.secretMappings.add(builder);
    }
    return (A) this;
  }
  
  public PatchesNested<A> addNewPatch() {
    return new PatchesNested(-1, null);
  }
  
  public PatchesNested<A> addNewPatchLike(SyncObjectPatch item) {
    return new PatchesNested(-1, item);
  }
  
  public SecretMappingsNested<A> addNewSecretMapping() {
    return new SecretMappingsNested(-1, null);
  }
  
  public SecretMappingsNested<A> addNewSecretMappingLike(SecretMapping item) {
    return new SecretMappingsNested(-1, item);
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
  
  public A addToPatches(SyncObjectPatch... items) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    for (SyncObjectPatch item : items) {
        SyncObjectPatchBuilder builder = new SyncObjectPatchBuilder(item);
        _visitables.get("patches").add(builder);
        this.patches.add(builder);
    }
    return (A) this;
  }
  
  public A addToPatches(int index,SyncObjectPatch item) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    SyncObjectPatchBuilder builder = new SyncObjectPatchBuilder(item);
    if (index < 0 || index >= patches.size()) {
        _visitables.get("patches").add(builder);
        patches.add(builder);
    } else {
        _visitables.get("patches").add(builder);
        patches.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResources(Object... items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (Object item : items) {
      this.resources.add(item);
    }
    return (A) this;
  }
  
  public A addToResources(int index,Object item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    this.resources.add(index, item);
    return (A) this;
  }
  
  public A addToSecretMappings(SecretMapping... items) {
    if (this.secretMappings == null) {
      this.secretMappings = new ArrayList();
    }
    for (SecretMapping item : items) {
        SecretMappingBuilder builder = new SecretMappingBuilder(item);
        _visitables.get("secretMappings").add(builder);
        this.secretMappings.add(builder);
    }
    return (A) this;
  }
  
  public A addToSecretMappings(int index,SecretMapping item) {
    if (this.secretMappings == null) {
      this.secretMappings = new ArrayList();
    }
    SecretMappingBuilder builder = new SecretMappingBuilder(item);
    if (index < 0 || index >= secretMappings.size()) {
        _visitables.get("secretMappings").add(builder);
        secretMappings.add(builder);
    } else {
        _visitables.get("secretMappings").add(builder);
        secretMappings.add(index, builder);
    }
    return (A) this;
  }
  
  public SyncObjectPatch buildFirstPatch() {
    return this.patches.get(0).build();
  }
  
  public SecretMapping buildFirstSecretMapping() {
    return this.secretMappings.get(0).build();
  }
  
  public SyncObjectPatch buildLastPatch() {
    return this.patches.get(patches.size() - 1).build();
  }
  
  public SecretMapping buildLastSecretMapping() {
    return this.secretMappings.get(secretMappings.size() - 1).build();
  }
  
  public SyncObjectPatch buildMatchingPatch(Predicate<SyncObjectPatchBuilder> predicate) {
      for (SyncObjectPatchBuilder item : patches) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SecretMapping buildMatchingSecretMapping(Predicate<SecretMappingBuilder> predicate) {
      for (SecretMappingBuilder item : secretMappings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SyncObjectPatch buildPatch(int index) {
    return this.patches.get(index).build();
  }
  
  public List<SyncObjectPatch> buildPatches() {
    return this.patches != null ? build(patches) : null;
  }
  
  public SecretMapping buildSecretMapping(int index) {
    return this.secretMappings.get(index).build();
  }
  
  public List<SecretMapping> buildSecretMappings() {
    return this.secretMappings != null ? build(secretMappings) : null;
  }
  
  protected void copyInstance(SyncSetCommonSpec instance) {
    instance = instance != null ? instance : new SyncSetCommonSpec();
    if (instance != null) {
        this.withApplyBehavior(instance.getApplyBehavior());
        this.withEnableResourceTemplates(instance.getEnableResourceTemplates());
        this.withPatches(instance.getPatches());
        this.withResourceApplyMode(instance.getResourceApplyMode());
        this.withResources(instance.getResources());
        this.withSecretMappings(instance.getSecretMappings());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PatchesNested<A> editFirstPatch() {
    if (patches.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "patches"));
    }
    return this.setNewPatchLike(0, this.buildPatch(0));
  }
  
  public SecretMappingsNested<A> editFirstSecretMapping() {
    if (secretMappings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "secretMappings"));
    }
    return this.setNewSecretMappingLike(0, this.buildSecretMapping(0));
  }
  
  public PatchesNested<A> editLastPatch() {
    int index = patches.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "patches"));
    }
    return this.setNewPatchLike(index, this.buildPatch(index));
  }
  
  public SecretMappingsNested<A> editLastSecretMapping() {
    int index = secretMappings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "secretMappings"));
    }
    return this.setNewSecretMappingLike(index, this.buildSecretMapping(index));
  }
  
  public PatchesNested<A> editMatchingPatch(Predicate<SyncObjectPatchBuilder> predicate) {
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
  
  public SecretMappingsNested<A> editMatchingSecretMapping(Predicate<SecretMappingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < secretMappings.size();i++) {
      if (predicate.test(secretMappings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "secretMappings"));
    }
    return this.setNewSecretMappingLike(index, this.buildSecretMapping(index));
  }
  
  public PatchesNested<A> editPatch(int index) {
    if (patches.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "patches"));
    }
    return this.setNewPatchLike(index, this.buildPatch(index));
  }
  
  public SecretMappingsNested<A> editSecretMapping(int index) {
    if (secretMappings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "secretMappings"));
    }
    return this.setNewSecretMappingLike(index, this.buildSecretMapping(index));
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
    SyncSetCommonSpecFluent that = (SyncSetCommonSpecFluent) o;
    if (!(Objects.equals(applyBehavior, that.applyBehavior))) {
      return false;
    }
    if (!(Objects.equals(enableResourceTemplates, that.enableResourceTemplates))) {
      return false;
    }
    if (!(Objects.equals(patches, that.patches))) {
      return false;
    }
    if (!(Objects.equals(resourceApplyMode, that.resourceApplyMode))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(secretMappings, that.secretMappings))) {
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
  
  public String getApplyBehavior() {
    return this.applyBehavior;
  }
  
  public Boolean getEnableResourceTemplates() {
    return this.enableResourceTemplates;
  }
  
  public Object getFirstResource() {
    return this.resources.get(0);
  }
  
  public Object getLastResource() {
    return this.resources.get(resources.size() - 1);
  }
  
  public Object getMatchingResource(Predicate<Object> predicate) {
      for (Object item : resources) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Object getResource(int index) {
    return this.resources.get(index);
  }
  
  public String getResourceApplyMode() {
    return this.resourceApplyMode;
  }
  
  public List<Object> getResources() {
    return this.resources;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApplyBehavior() {
    return this.applyBehavior != null;
  }
  
  public boolean hasEnableResourceTemplates() {
    return this.enableResourceTemplates != null;
  }
  
  public boolean hasMatchingPatch(Predicate<SyncObjectPatchBuilder> predicate) {
      for (SyncObjectPatchBuilder item : patches) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResource(Predicate<Object> predicate) {
      for (Object item : resources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSecretMapping(Predicate<SecretMappingBuilder> predicate) {
      for (SecretMappingBuilder item : secretMappings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPatches() {
    return this.patches != null && !(this.patches.isEmpty());
  }
  
  public boolean hasResourceApplyMode() {
    return this.resourceApplyMode != null;
  }
  
  public boolean hasResources() {
    return this.resources != null && !(this.resources.isEmpty());
  }
  
  public boolean hasSecretMappings() {
    return this.secretMappings != null && !(this.secretMappings.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(applyBehavior, enableResourceTemplates, patches, resourceApplyMode, resources, secretMappings, additionalProperties);
  }
  
  public A removeAllFromPatches(Collection<SyncObjectPatch> items) {
    if (this.patches == null) {
      return (A) this;
    }
    for (SyncObjectPatch item : items) {
        SyncObjectPatchBuilder builder = new SyncObjectPatchBuilder(item);
        _visitables.get("patches").remove(builder);
        this.patches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResources(Collection<Object> items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (Object item : items) {
      this.resources.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSecretMappings(Collection<SecretMapping> items) {
    if (this.secretMappings == null) {
      return (A) this;
    }
    for (SecretMapping item : items) {
        SecretMappingBuilder builder = new SecretMappingBuilder(item);
        _visitables.get("secretMappings").remove(builder);
        this.secretMappings.remove(builder);
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
  
  public A removeFromPatches(SyncObjectPatch... items) {
    if (this.patches == null) {
      return (A) this;
    }
    for (SyncObjectPatch item : items) {
        SyncObjectPatchBuilder builder = new SyncObjectPatchBuilder(item);
        _visitables.get("patches").remove(builder);
        this.patches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResources(Object... items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (Object item : items) {
      this.resources.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSecretMappings(SecretMapping... items) {
    if (this.secretMappings == null) {
      return (A) this;
    }
    for (SecretMapping item : items) {
        SecretMappingBuilder builder = new SecretMappingBuilder(item);
        _visitables.get("secretMappings").remove(builder);
        this.secretMappings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPatches(Predicate<SyncObjectPatchBuilder> predicate) {
    if (patches == null) {
      return (A) this;
    }
    Iterator<SyncObjectPatchBuilder> each = patches.iterator();
    List visitables = _visitables.get("patches");
    while (each.hasNext()) {
        SyncObjectPatchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSecretMappings(Predicate<SecretMappingBuilder> predicate) {
    if (secretMappings == null) {
      return (A) this;
    }
    Iterator<SecretMappingBuilder> each = secretMappings.iterator();
    List visitables = _visitables.get("secretMappings");
    while (each.hasNext()) {
        SecretMappingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PatchesNested<A> setNewPatchLike(int index,SyncObjectPatch item) {
    return new PatchesNested(index, item);
  }
  
  public SecretMappingsNested<A> setNewSecretMappingLike(int index,SecretMapping item) {
    return new SecretMappingsNested(index, item);
  }
  
  public A setToPatches(int index,SyncObjectPatch item) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    SyncObjectPatchBuilder builder = new SyncObjectPatchBuilder(item);
    if (index < 0 || index >= patches.size()) {
        _visitables.get("patches").add(builder);
        patches.add(builder);
    } else {
        _visitables.get("patches").add(builder);
        patches.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResources(int index,Object item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    this.resources.set(index, item);
    return (A) this;
  }
  
  public A setToSecretMappings(int index,SecretMapping item) {
    if (this.secretMappings == null) {
      this.secretMappings = new ArrayList();
    }
    SecretMappingBuilder builder = new SecretMappingBuilder(item);
    if (index < 0 || index >= secretMappings.size()) {
        _visitables.get("secretMappings").add(builder);
        secretMappings.add(builder);
    } else {
        _visitables.get("secretMappings").add(builder);
        secretMappings.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(applyBehavior == null)) {
        sb.append("applyBehavior:");
        sb.append(applyBehavior);
        sb.append(",");
    }
    if (!(enableResourceTemplates == null)) {
        sb.append("enableResourceTemplates:");
        sb.append(enableResourceTemplates);
        sb.append(",");
    }
    if (!(patches == null) && !(patches.isEmpty())) {
        sb.append("patches:");
        sb.append(patches);
        sb.append(",");
    }
    if (!(resourceApplyMode == null)) {
        sb.append("resourceApplyMode:");
        sb.append(resourceApplyMode);
        sb.append(",");
    }
    if (!(resources == null) && !(resources.isEmpty())) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(secretMappings == null) && !(secretMappings.isEmpty())) {
        sb.append("secretMappings:");
        sb.append(secretMappings);
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
  
  public A withApplyBehavior(String applyBehavior) {
    this.applyBehavior = applyBehavior;
    return (A) this;
  }
  
  public A withEnableResourceTemplates() {
    return withEnableResourceTemplates(true);
  }
  
  public A withEnableResourceTemplates(Boolean enableResourceTemplates) {
    this.enableResourceTemplates = enableResourceTemplates;
    return (A) this;
  }
  
  public A withPatches(List<SyncObjectPatch> patches) {
    if (this.patches != null) {
      this._visitables.get("patches").clear();
    }
    if (patches != null) {
        this.patches = new ArrayList();
        for (SyncObjectPatch item : patches) {
          this.addToPatches(item);
        }
    } else {
      this.patches = null;
    }
    return (A) this;
  }
  
  public A withPatches(SyncObjectPatch... patches) {
    if (this.patches != null) {
        this.patches.clear();
        _visitables.remove("patches");
    }
    if (patches != null) {
      for (SyncObjectPatch item : patches) {
        this.addToPatches(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceApplyMode(String resourceApplyMode) {
    this.resourceApplyMode = resourceApplyMode;
    return (A) this;
  }
  
  public A withResources(List<Object> resources) {
    if (resources != null) {
        this.resources = new ArrayList();
        for (Object item : resources) {
          this.addToResources(item);
        }
    } else {
      this.resources = null;
    }
    return (A) this;
  }
  
  public A withResources(Object... resources) {
    if (this.resources != null) {
        this.resources.clear();
        _visitables.remove("resources");
    }
    if (resources != null) {
      for (Object item : resources) {
        this.addToResources(item);
      }
    }
    return (A) this;
  }
  
  public A withSecretMappings(List<SecretMapping> secretMappings) {
    if (this.secretMappings != null) {
      this._visitables.get("secretMappings").clear();
    }
    if (secretMappings != null) {
        this.secretMappings = new ArrayList();
        for (SecretMapping item : secretMappings) {
          this.addToSecretMappings(item);
        }
    } else {
      this.secretMappings = null;
    }
    return (A) this;
  }
  
  public A withSecretMappings(SecretMapping... secretMappings) {
    if (this.secretMappings != null) {
        this.secretMappings.clear();
        _visitables.remove("secretMappings");
    }
    if (secretMappings != null) {
      for (SecretMapping item : secretMappings) {
        this.addToSecretMappings(item);
      }
    }
    return (A) this;
  }
  public class PatchesNested<N> extends SyncObjectPatchFluent<PatchesNested<N>> implements Nested<N>{
  
    SyncObjectPatchBuilder builder;
    int index;
  
    PatchesNested(int index,SyncObjectPatch item) {
      this.index = index;
      this.builder = new SyncObjectPatchBuilder(this, item);
    }
  
    public N and() {
      return (N) SyncSetCommonSpecFluent.this.setToPatches(index, builder.build());
    }
    
    public N endPatch() {
      return and();
    }
    
  }
  public class SecretMappingsNested<N> extends SecretMappingFluent<SecretMappingsNested<N>> implements Nested<N>{
  
    SecretMappingBuilder builder;
    int index;
  
    SecretMappingsNested(int index,SecretMapping item) {
      this.index = index;
      this.builder = new SecretMappingBuilder(this, item);
    }
  
    public N and() {
      return (N) SyncSetCommonSpecFluent.this.setToSecretMappings(index, builder.build());
    }
    
    public N endSecretMapping() {
      return and();
    }
    
  }
}