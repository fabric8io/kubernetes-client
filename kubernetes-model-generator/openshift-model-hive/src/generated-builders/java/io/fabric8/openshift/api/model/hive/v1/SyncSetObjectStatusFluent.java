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
public class SyncSetObjectStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.SyncSetObjectStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<SyncConditionBuilder> conditions = new ArrayList<SyncConditionBuilder>();
  private String name;
  private ArrayList<SyncStatusBuilder> patches = new ArrayList<SyncStatusBuilder>();
  private String resourceApplyMode;
  private ArrayList<SyncStatusBuilder> resources = new ArrayList<SyncStatusBuilder>();
  private ArrayList<SyncStatusBuilder> secrets = new ArrayList<SyncStatusBuilder>();

  public SyncSetObjectStatusFluent() {
  }
  
  public SyncSetObjectStatusFluent(SyncSetObjectStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<SyncCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (SyncCondition item : items) {
        SyncConditionBuilder builder = new SyncConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPatches(Collection<SyncStatus> items) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("patches").add(builder);
        this.patches.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResources(Collection<SyncStatus> items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSecrets(Collection<SyncStatus> items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("secrets").add(builder);
        this.secrets.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(SyncCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public PatchesNested<A> addNewPatch() {
    return new PatchesNested(-1, null);
  }
  
  public PatchesNested<A> addNewPatchLike(SyncStatus item) {
    return new PatchesNested(-1, item);
  }
  
  public ResourcesNested<A> addNewResource() {
    return new ResourcesNested(-1, null);
  }
  
  public ResourcesNested<A> addNewResourceLike(SyncStatus item) {
    return new ResourcesNested(-1, item);
  }
  
  public SecretsNested<A> addNewSecret() {
    return new SecretsNested(-1, null);
  }
  
  public SecretsNested<A> addNewSecretLike(SyncStatus item) {
    return new SecretsNested(-1, item);
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
  
  public A addToConditions(SyncCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (SyncCondition item : items) {
        SyncConditionBuilder builder = new SyncConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,SyncCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    SyncConditionBuilder builder = new SyncConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPatches(SyncStatus... items) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("patches").add(builder);
        this.patches.add(builder);
    }
    return (A) this;
  }
  
  public A addToPatches(int index,SyncStatus item) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    SyncStatusBuilder builder = new SyncStatusBuilder(item);
    if (index < 0 || index >= patches.size()) {
        _visitables.get("patches").add(builder);
        patches.add(builder);
    } else {
        _visitables.get("patches").add(builder);
        patches.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResources(SyncStatus... items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public A addToResources(int index,SyncStatus item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    SyncStatusBuilder builder = new SyncStatusBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSecrets(SyncStatus... items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("secrets").add(builder);
        this.secrets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSecrets(int index,SyncStatus item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    SyncStatusBuilder builder = new SyncStatusBuilder(item);
    if (index < 0 || index >= secrets.size()) {
        _visitables.get("secrets").add(builder);
        secrets.add(builder);
    } else {
        _visitables.get("secrets").add(builder);
        secrets.add(index, builder);
    }
    return (A) this;
  }
  
  public SyncCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<SyncCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public SyncCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public SyncStatus buildFirstPatch() {
    return this.patches.get(0).build();
  }
  
  public SyncStatus buildFirstResource() {
    return this.resources.get(0).build();
  }
  
  public SyncStatus buildFirstSecret() {
    return this.secrets.get(0).build();
  }
  
  public SyncCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public SyncStatus buildLastPatch() {
    return this.patches.get(patches.size() - 1).build();
  }
  
  public SyncStatus buildLastResource() {
    return this.resources.get(resources.size() - 1).build();
  }
  
  public SyncStatus buildLastSecret() {
    return this.secrets.get(secrets.size() - 1).build();
  }
  
  public SyncCondition buildMatchingCondition(Predicate<SyncConditionBuilder> predicate) {
      for (SyncConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SyncStatus buildMatchingPatch(Predicate<SyncStatusBuilder> predicate) {
      for (SyncStatusBuilder item : patches) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SyncStatus buildMatchingResource(Predicate<SyncStatusBuilder> predicate) {
      for (SyncStatusBuilder item : resources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SyncStatus buildMatchingSecret(Predicate<SyncStatusBuilder> predicate) {
      for (SyncStatusBuilder item : secrets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SyncStatus buildPatch(int index) {
    return this.patches.get(index).build();
  }
  
  public List<SyncStatus> buildPatches() {
    return this.patches != null ? build(patches) : null;
  }
  
  public SyncStatus buildResource(int index) {
    return this.resources.get(index).build();
  }
  
  public List<SyncStatus> buildResources() {
    return this.resources != null ? build(resources) : null;
  }
  
  public SyncStatus buildSecret(int index) {
    return this.secrets.get(index).build();
  }
  
  public List<SyncStatus> buildSecrets() {
    return this.secrets != null ? build(secrets) : null;
  }
  
  protected void copyInstance(SyncSetObjectStatus instance) {
    instance = instance != null ? instance : new SyncSetObjectStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withName(instance.getName());
        this.withPatches(instance.getPatches());
        this.withResourceApplyMode(instance.getResourceApplyMode());
        this.withResources(instance.getResources());
        this.withSecrets(instance.getSecrets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public PatchesNested<A> editFirstPatch() {
    if (patches.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "patches"));
    }
    return this.setNewPatchLike(0, this.buildPatch(0));
  }
  
  public ResourcesNested<A> editFirstResource() {
    if (resources.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(0, this.buildResource(0));
  }
  
  public SecretsNested<A> editFirstSecret() {
    if (secrets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "secrets"));
    }
    return this.setNewSecretLike(0, this.buildSecret(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public PatchesNested<A> editLastPatch() {
    int index = patches.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "patches"));
    }
    return this.setNewPatchLike(index, this.buildPatch(index));
  }
  
  public ResourcesNested<A> editLastResource() {
    int index = resources.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public SecretsNested<A> editLastSecret() {
    int index = secrets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "secrets"));
    }
    return this.setNewSecretLike(index, this.buildSecret(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<SyncConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public PatchesNested<A> editMatchingPatch(Predicate<SyncStatusBuilder> predicate) {
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
  
  public ResourcesNested<A> editMatchingResource(Predicate<SyncStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resources.size();i++) {
      if (predicate.test(resources.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public SecretsNested<A> editMatchingSecret(Predicate<SyncStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < secrets.size();i++) {
      if (predicate.test(secrets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "secrets"));
    }
    return this.setNewSecretLike(index, this.buildSecret(index));
  }
  
  public PatchesNested<A> editPatch(int index) {
    if (patches.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "patches"));
    }
    return this.setNewPatchLike(index, this.buildPatch(index));
  }
  
  public ResourcesNested<A> editResource(int index) {
    if (resources.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public SecretsNested<A> editSecret(int index) {
    if (secrets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "secrets"));
    }
    return this.setNewSecretLike(index, this.buildSecret(index));
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
    SyncSetObjectStatusFluent that = (SyncSetObjectStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
    if (!(Objects.equals(secrets, that.secrets))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public String getResourceApplyMode() {
    return this.resourceApplyMode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<SyncConditionBuilder> predicate) {
      for (SyncConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPatch(Predicate<SyncStatusBuilder> predicate) {
      for (SyncStatusBuilder item : patches) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResource(Predicate<SyncStatusBuilder> predicate) {
      for (SyncStatusBuilder item : resources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSecret(Predicate<SyncStatusBuilder> predicate) {
      for (SyncStatusBuilder item : secrets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
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
  
  public boolean hasSecrets() {
    return this.secrets != null && !(this.secrets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, name, patches, resourceApplyMode, resources, secrets, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<SyncCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (SyncCondition item : items) {
        SyncConditionBuilder builder = new SyncConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPatches(Collection<SyncStatus> items) {
    if (this.patches == null) {
      return (A) this;
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("patches").remove(builder);
        this.patches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResources(Collection<SyncStatus> items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSecrets(Collection<SyncStatus> items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("secrets").remove(builder);
        this.secrets.remove(builder);
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
  
  public A removeFromConditions(SyncCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (SyncCondition item : items) {
        SyncConditionBuilder builder = new SyncConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPatches(SyncStatus... items) {
    if (this.patches == null) {
      return (A) this;
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("patches").remove(builder);
        this.patches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResources(SyncStatus... items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSecrets(SyncStatus... items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (SyncStatus item : items) {
        SyncStatusBuilder builder = new SyncStatusBuilder(item);
        _visitables.get("secrets").remove(builder);
        this.secrets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<SyncConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<SyncConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        SyncConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPatches(Predicate<SyncStatusBuilder> predicate) {
    if (patches == null) {
      return (A) this;
    }
    Iterator<SyncStatusBuilder> each = patches.iterator();
    List visitables = _visitables.get("patches");
    while (each.hasNext()) {
        SyncStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResources(Predicate<SyncStatusBuilder> predicate) {
    if (resources == null) {
      return (A) this;
    }
    Iterator<SyncStatusBuilder> each = resources.iterator();
    List visitables = _visitables.get("resources");
    while (each.hasNext()) {
        SyncStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSecrets(Predicate<SyncStatusBuilder> predicate) {
    if (secrets == null) {
      return (A) this;
    }
    Iterator<SyncStatusBuilder> each = secrets.iterator();
    List visitables = _visitables.get("secrets");
    while (each.hasNext()) {
        SyncStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,SyncCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public PatchesNested<A> setNewPatchLike(int index,SyncStatus item) {
    return new PatchesNested(index, item);
  }
  
  public ResourcesNested<A> setNewResourceLike(int index,SyncStatus item) {
    return new ResourcesNested(index, item);
  }
  
  public SecretsNested<A> setNewSecretLike(int index,SyncStatus item) {
    return new SecretsNested(index, item);
  }
  
  public A setToConditions(int index,SyncCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    SyncConditionBuilder builder = new SyncConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPatches(int index,SyncStatus item) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    SyncStatusBuilder builder = new SyncStatusBuilder(item);
    if (index < 0 || index >= patches.size()) {
        _visitables.get("patches").add(builder);
        patches.add(builder);
    } else {
        _visitables.get("patches").add(builder);
        patches.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResources(int index,SyncStatus item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    SyncStatusBuilder builder = new SyncStatusBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSecrets(int index,SyncStatus item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    SyncStatusBuilder builder = new SyncStatusBuilder(item);
    if (index < 0 || index >= secrets.size()) {
        _visitables.get("secrets").add(builder);
        secrets.add(builder);
    } else {
        _visitables.get("secrets").add(builder);
        secrets.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
    if (!(secrets == null) && !(secrets.isEmpty())) {
        sb.append("secrets:");
        sb.append(secrets);
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
  
  public A withConditions(List<SyncCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (SyncCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(SyncCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (SyncCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withPatches(List<SyncStatus> patches) {
    if (this.patches != null) {
      this._visitables.get("patches").clear();
    }
    if (patches != null) {
        this.patches = new ArrayList();
        for (SyncStatus item : patches) {
          this.addToPatches(item);
        }
    } else {
      this.patches = null;
    }
    return (A) this;
  }
  
  public A withPatches(SyncStatus... patches) {
    if (this.patches != null) {
        this.patches.clear();
        _visitables.remove("patches");
    }
    if (patches != null) {
      for (SyncStatus item : patches) {
        this.addToPatches(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceApplyMode(String resourceApplyMode) {
    this.resourceApplyMode = resourceApplyMode;
    return (A) this;
  }
  
  public A withResources(List<SyncStatus> resources) {
    if (this.resources != null) {
      this._visitables.get("resources").clear();
    }
    if (resources != null) {
        this.resources = new ArrayList();
        for (SyncStatus item : resources) {
          this.addToResources(item);
        }
    } else {
      this.resources = null;
    }
    return (A) this;
  }
  
  public A withResources(SyncStatus... resources) {
    if (this.resources != null) {
        this.resources.clear();
        _visitables.remove("resources");
    }
    if (resources != null) {
      for (SyncStatus item : resources) {
        this.addToResources(item);
      }
    }
    return (A) this;
  }
  
  public A withSecrets(List<SyncStatus> secrets) {
    if (this.secrets != null) {
      this._visitables.get("secrets").clear();
    }
    if (secrets != null) {
        this.secrets = new ArrayList();
        for (SyncStatus item : secrets) {
          this.addToSecrets(item);
        }
    } else {
      this.secrets = null;
    }
    return (A) this;
  }
  
  public A withSecrets(SyncStatus... secrets) {
    if (this.secrets != null) {
        this.secrets.clear();
        _visitables.remove("secrets");
    }
    if (secrets != null) {
      for (SyncStatus item : secrets) {
        this.addToSecrets(item);
      }
    }
    return (A) this;
  }
  public class ConditionsNested<N> extends SyncConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    SyncConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,SyncCondition item) {
      this.index = index;
      this.builder = new SyncConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) SyncSetObjectStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class PatchesNested<N> extends SyncStatusFluent<PatchesNested<N>> implements Nested<N>{
  
    SyncStatusBuilder builder;
    int index;
  
    PatchesNested(int index,SyncStatus item) {
      this.index = index;
      this.builder = new SyncStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) SyncSetObjectStatusFluent.this.setToPatches(index, builder.build());
    }
    
    public N endPatch() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends SyncStatusFluent<ResourcesNested<N>> implements Nested<N>{
  
    SyncStatusBuilder builder;
    int index;
  
    ResourcesNested(int index,SyncStatus item) {
      this.index = index;
      this.builder = new SyncStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) SyncSetObjectStatusFluent.this.setToResources(index, builder.build());
    }
    
    public N endResource() {
      return and();
    }
    
  }
  public class SecretsNested<N> extends SyncStatusFluent<SecretsNested<N>> implements Nested<N>{
  
    SyncStatusBuilder builder;
    int index;
  
    SecretsNested(int index,SyncStatus item) {
      this.index = index;
      this.builder = new SyncStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) SyncSetObjectStatusFluent.this.setToSecrets(index, builder.build());
    }
    
    public N endSecret() {
      return and();
    }
    
  }
}