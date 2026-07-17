package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class HostFirmwareComponentsStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HostFirmwareComponentsStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<FirmwareComponentStatusBuilder> components = new ArrayList<FirmwareComponentStatusBuilder>();
  private List<Condition> conditions = new ArrayList<Condition>();
  private String lastUpdated;
  private ArrayList<FirmwareUpdateBuilder> updates = new ArrayList<FirmwareUpdateBuilder>();

  public HostFirmwareComponentsStatusFluent() {
  }
  
  public HostFirmwareComponentsStatusFluent(HostFirmwareComponentsStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToComponents(Collection<FirmwareComponentStatus> items) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    for (FirmwareComponentStatus item : items) {
        FirmwareComponentStatusBuilder builder = new FirmwareComponentStatusBuilder(item);
        _visitables.get("components").add(builder);
        this.components.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToUpdates(Collection<FirmwareUpdate> items) {
    if (this.updates == null) {
      this.updates = new ArrayList();
    }
    for (FirmwareUpdate item : items) {
        FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
        _visitables.get("updates").add(builder);
        this.updates.add(builder);
    }
    return (A) this;
  }
  
  public ComponentsNested<A> addNewComponent() {
    return new ComponentsNested(-1, null);
  }
  
  public A addNewComponent(String component,String currentVersion,String initialVersion,String lastVersionFlashed,String updatedAt) {
    return (A) this.addToComponents(new FirmwareComponentStatus(component, currentVersion, initialVersion, lastVersionFlashed, updatedAt));
  }
  
  public ComponentsNested<A> addNewComponentLike(FirmwareComponentStatus item) {
    return new ComponentsNested(-1, item);
  }
  
  public UpdatesNested<A> addNewUpdate() {
    return new UpdatesNested(-1, null);
  }
  
  public A addNewUpdate(String component,String url) {
    return (A) this.addToUpdates(new FirmwareUpdate(component, url));
  }
  
  public UpdatesNested<A> addNewUpdateLike(FirmwareUpdate item) {
    return new UpdatesNested(-1, item);
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
  
  public A addToComponents(FirmwareComponentStatus... items) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    for (FirmwareComponentStatus item : items) {
        FirmwareComponentStatusBuilder builder = new FirmwareComponentStatusBuilder(item);
        _visitables.get("components").add(builder);
        this.components.add(builder);
    }
    return (A) this;
  }
  
  public A addToComponents(int index,FirmwareComponentStatus item) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    FirmwareComponentStatusBuilder builder = new FirmwareComponentStatusBuilder(item);
    if (index < 0 || index >= components.size()) {
        _visitables.get("components").add(builder);
        components.add(builder);
    } else {
        _visitables.get("components").add(builder);
        components.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToUpdates(FirmwareUpdate... items) {
    if (this.updates == null) {
      this.updates = new ArrayList();
    }
    for (FirmwareUpdate item : items) {
        FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
        _visitables.get("updates").add(builder);
        this.updates.add(builder);
    }
    return (A) this;
  }
  
  public A addToUpdates(int index,FirmwareUpdate item) {
    if (this.updates == null) {
      this.updates = new ArrayList();
    }
    FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
    if (index < 0 || index >= updates.size()) {
        _visitables.get("updates").add(builder);
        updates.add(builder);
    } else {
        _visitables.get("updates").add(builder);
        updates.add(index, builder);
    }
    return (A) this;
  }
  
  public FirmwareComponentStatus buildComponent(int index) {
    return this.components.get(index).build();
  }
  
  public List<FirmwareComponentStatus> buildComponents() {
    return this.components != null ? build(components) : null;
  }
  
  public FirmwareComponentStatus buildFirstComponent() {
    return this.components.get(0).build();
  }
  
  public FirmwareUpdate buildFirstUpdate() {
    return this.updates.get(0).build();
  }
  
  public FirmwareComponentStatus buildLastComponent() {
    return this.components.get(components.size() - 1).build();
  }
  
  public FirmwareUpdate buildLastUpdate() {
    return this.updates.get(updates.size() - 1).build();
  }
  
  public FirmwareComponentStatus buildMatchingComponent(Predicate<FirmwareComponentStatusBuilder> predicate) {
      for (FirmwareComponentStatusBuilder item : components) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public FirmwareUpdate buildMatchingUpdate(Predicate<FirmwareUpdateBuilder> predicate) {
      for (FirmwareUpdateBuilder item : updates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public FirmwareUpdate buildUpdate(int index) {
    return this.updates.get(index).build();
  }
  
  public List<FirmwareUpdate> buildUpdates() {
    return this.updates != null ? build(updates) : null;
  }
  
  protected void copyInstance(HostFirmwareComponentsStatus instance) {
    instance = instance != null ? instance : new HostFirmwareComponentsStatus();
    if (instance != null) {
        this.withComponents(instance.getComponents());
        this.withConditions(instance.getConditions());
        this.withLastUpdated(instance.getLastUpdated());
        this.withUpdates(instance.getUpdates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ComponentsNested<A> editComponent(int index) {
    if (components.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "components"));
    }
    return this.setNewComponentLike(index, this.buildComponent(index));
  }
  
  public ComponentsNested<A> editFirstComponent() {
    if (components.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "components"));
    }
    return this.setNewComponentLike(0, this.buildComponent(0));
  }
  
  public UpdatesNested<A> editFirstUpdate() {
    if (updates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "updates"));
    }
    return this.setNewUpdateLike(0, this.buildUpdate(0));
  }
  
  public ComponentsNested<A> editLastComponent() {
    int index = components.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "components"));
    }
    return this.setNewComponentLike(index, this.buildComponent(index));
  }
  
  public UpdatesNested<A> editLastUpdate() {
    int index = updates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "updates"));
    }
    return this.setNewUpdateLike(index, this.buildUpdate(index));
  }
  
  public ComponentsNested<A> editMatchingComponent(Predicate<FirmwareComponentStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < components.size();i++) {
      if (predicate.test(components.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "components"));
    }
    return this.setNewComponentLike(index, this.buildComponent(index));
  }
  
  public UpdatesNested<A> editMatchingUpdate(Predicate<FirmwareUpdateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < updates.size();i++) {
      if (predicate.test(updates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "updates"));
    }
    return this.setNewUpdateLike(index, this.buildUpdate(index));
  }
  
  public UpdatesNested<A> editUpdate(int index) {
    if (updates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "updates"));
    }
    return this.setNewUpdateLike(index, this.buildUpdate(index));
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
    HostFirmwareComponentsStatusFluent that = (HostFirmwareComponentsStatusFluent) o;
    if (!(Objects.equals(components, that.components))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
      return false;
    }
    if (!(Objects.equals(updates, that.updates))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComponents() {
    return this.components != null && !(this.components.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public boolean hasMatchingComponent(Predicate<FirmwareComponentStatusBuilder> predicate) {
      for (FirmwareComponentStatusBuilder item : components) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUpdate(Predicate<FirmwareUpdateBuilder> predicate) {
      for (FirmwareUpdateBuilder item : updates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasUpdates() {
    return this.updates != null && !(this.updates.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(components, conditions, lastUpdated, updates, additionalProperties);
  }
  
  public A removeAllFromComponents(Collection<FirmwareComponentStatus> items) {
    if (this.components == null) {
      return (A) this;
    }
    for (FirmwareComponentStatus item : items) {
        FirmwareComponentStatusBuilder builder = new FirmwareComponentStatusBuilder(item);
        _visitables.get("components").remove(builder);
        this.components.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromUpdates(Collection<FirmwareUpdate> items) {
    if (this.updates == null) {
      return (A) this;
    }
    for (FirmwareUpdate item : items) {
        FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
        _visitables.get("updates").remove(builder);
        this.updates.remove(builder);
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
  
  public A removeFromComponents(FirmwareComponentStatus... items) {
    if (this.components == null) {
      return (A) this;
    }
    for (FirmwareComponentStatus item : items) {
        FirmwareComponentStatusBuilder builder = new FirmwareComponentStatusBuilder(item);
        _visitables.get("components").remove(builder);
        this.components.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromUpdates(FirmwareUpdate... items) {
    if (this.updates == null) {
      return (A) this;
    }
    for (FirmwareUpdate item : items) {
        FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
        _visitables.get("updates").remove(builder);
        this.updates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromComponents(Predicate<FirmwareComponentStatusBuilder> predicate) {
    if (components == null) {
      return (A) this;
    }
    Iterator<FirmwareComponentStatusBuilder> each = components.iterator();
    List visitables = _visitables.get("components");
    while (each.hasNext()) {
        FirmwareComponentStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromUpdates(Predicate<FirmwareUpdateBuilder> predicate) {
    if (updates == null) {
      return (A) this;
    }
    Iterator<FirmwareUpdateBuilder> each = updates.iterator();
    List visitables = _visitables.get("updates");
    while (each.hasNext()) {
        FirmwareUpdateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ComponentsNested<A> setNewComponentLike(int index,FirmwareComponentStatus item) {
    return new ComponentsNested(index, item);
  }
  
  public UpdatesNested<A> setNewUpdateLike(int index,FirmwareUpdate item) {
    return new UpdatesNested(index, item);
  }
  
  public A setToComponents(int index,FirmwareComponentStatus item) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    FirmwareComponentStatusBuilder builder = new FirmwareComponentStatusBuilder(item);
    if (index < 0 || index >= components.size()) {
        _visitables.get("components").add(builder);
        components.add(builder);
    } else {
        _visitables.get("components").add(builder);
        components.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToUpdates(int index,FirmwareUpdate item) {
    if (this.updates == null) {
      this.updates = new ArrayList();
    }
    FirmwareUpdateBuilder builder = new FirmwareUpdateBuilder(item);
    if (index < 0 || index >= updates.size()) {
        _visitables.get("updates").add(builder);
        updates.add(builder);
    } else {
        _visitables.get("updates").add(builder);
        updates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(components == null) && !(components.isEmpty())) {
        sb.append("components:");
        sb.append(components);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
        sb.append(",");
    }
    if (!(updates == null) && !(updates.isEmpty())) {
        sb.append("updates:");
        sb.append(updates);
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
  
  public A withComponents(List<FirmwareComponentStatus> components) {
    if (this.components != null) {
      this._visitables.get("components").clear();
    }
    if (components != null) {
        this.components = new ArrayList();
        for (FirmwareComponentStatus item : components) {
          this.addToComponents(item);
        }
    } else {
      this.components = null;
    }
    return (A) this;
  }
  
  public A withComponents(FirmwareComponentStatus... components) {
    if (this.components != null) {
        this.components.clear();
        _visitables.remove("components");
    }
    if (components != null) {
      for (FirmwareComponentStatus item : components) {
        this.addToComponents(item);
      }
    }
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  
  public A withUpdates(List<FirmwareUpdate> updates) {
    if (this.updates != null) {
      this._visitables.get("updates").clear();
    }
    if (updates != null) {
        this.updates = new ArrayList();
        for (FirmwareUpdate item : updates) {
          this.addToUpdates(item);
        }
    } else {
      this.updates = null;
    }
    return (A) this;
  }
  
  public A withUpdates(FirmwareUpdate... updates) {
    if (this.updates != null) {
        this.updates.clear();
        _visitables.remove("updates");
    }
    if (updates != null) {
      for (FirmwareUpdate item : updates) {
        this.addToUpdates(item);
      }
    }
    return (A) this;
  }
  public class ComponentsNested<N> extends FirmwareComponentStatusFluent<ComponentsNested<N>> implements Nested<N>{
  
    FirmwareComponentStatusBuilder builder;
    int index;
  
    ComponentsNested(int index,FirmwareComponentStatus item) {
      this.index = index;
      this.builder = new FirmwareComponentStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) HostFirmwareComponentsStatusFluent.this.setToComponents(index, builder.build());
    }
    
    public N endComponent() {
      return and();
    }
    
  }
  public class UpdatesNested<N> extends FirmwareUpdateFluent<UpdatesNested<N>> implements Nested<N>{
  
    FirmwareUpdateBuilder builder;
    int index;
  
    UpdatesNested(int index,FirmwareUpdate item) {
      this.index = index;
      this.builder = new FirmwareUpdateBuilder(this, item);
    }
  
    public N and() {
      return (N) HostFirmwareComponentsStatusFluent.this.setToUpdates(index, builder.build());
    }
    
    public N endUpdate() {
      return and();
    }
    
  }
}