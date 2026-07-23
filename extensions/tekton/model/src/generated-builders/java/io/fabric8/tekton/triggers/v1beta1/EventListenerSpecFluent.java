package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class EventListenerSpecFluent<A extends io.fabric8.tekton.triggers.v1beta1.EventListenerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cloudEventURI;
  private LabelSelectorBuilder labelSelector;
  private NamespaceSelectorBuilder namespaceSelector;
  private ResourcesBuilder resources;
  private String serviceAccountName;
  private ArrayList<EventListenerTriggerGroupBuilder> triggerGroups = new ArrayList<EventListenerTriggerGroupBuilder>();
  private ArrayList<EventListenerTriggerBuilder> triggers = new ArrayList<EventListenerTriggerBuilder>();

  public EventListenerSpecFluent() {
  }
  
  public EventListenerSpecFluent(EventListenerSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTriggerGroups(Collection<EventListenerTriggerGroup> items) {
    if (this.triggerGroups == null) {
      this.triggerGroups = new ArrayList();
    }
    for (EventListenerTriggerGroup item : items) {
        EventListenerTriggerGroupBuilder builder = new EventListenerTriggerGroupBuilder(item);
        _visitables.get("triggerGroups").add(builder);
        this.triggerGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTriggers(Collection<EventListenerTrigger> items) {
    if (this.triggers == null) {
      this.triggers = new ArrayList();
    }
    for (EventListenerTrigger item : items) {
        EventListenerTriggerBuilder builder = new EventListenerTriggerBuilder(item);
        _visitables.get("triggers").add(builder);
        this.triggers.add(builder);
    }
    return (A) this;
  }
  
  public TriggersNested<A> addNewTrigger() {
    return new TriggersNested(-1, null);
  }
  
  public TriggerGroupsNested<A> addNewTriggerGroup() {
    return new TriggerGroupsNested(-1, null);
  }
  
  public TriggerGroupsNested<A> addNewTriggerGroupLike(EventListenerTriggerGroup item) {
    return new TriggerGroupsNested(-1, item);
  }
  
  public TriggersNested<A> addNewTriggerLike(EventListenerTrigger item) {
    return new TriggersNested(-1, item);
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
  
  public A addToTriggerGroups(EventListenerTriggerGroup... items) {
    if (this.triggerGroups == null) {
      this.triggerGroups = new ArrayList();
    }
    for (EventListenerTriggerGroup item : items) {
        EventListenerTriggerGroupBuilder builder = new EventListenerTriggerGroupBuilder(item);
        _visitables.get("triggerGroups").add(builder);
        this.triggerGroups.add(builder);
    }
    return (A) this;
  }
  
  public A addToTriggerGroups(int index,EventListenerTriggerGroup item) {
    if (this.triggerGroups == null) {
      this.triggerGroups = new ArrayList();
    }
    EventListenerTriggerGroupBuilder builder = new EventListenerTriggerGroupBuilder(item);
    if (index < 0 || index >= triggerGroups.size()) {
        _visitables.get("triggerGroups").add(builder);
        triggerGroups.add(builder);
    } else {
        _visitables.get("triggerGroups").add(builder);
        triggerGroups.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTriggers(EventListenerTrigger... items) {
    if (this.triggers == null) {
      this.triggers = new ArrayList();
    }
    for (EventListenerTrigger item : items) {
        EventListenerTriggerBuilder builder = new EventListenerTriggerBuilder(item);
        _visitables.get("triggers").add(builder);
        this.triggers.add(builder);
    }
    return (A) this;
  }
  
  public A addToTriggers(int index,EventListenerTrigger item) {
    if (this.triggers == null) {
      this.triggers = new ArrayList();
    }
    EventListenerTriggerBuilder builder = new EventListenerTriggerBuilder(item);
    if (index < 0 || index >= triggers.size()) {
        _visitables.get("triggers").add(builder);
        triggers.add(builder);
    } else {
        _visitables.get("triggers").add(builder);
        triggers.add(index, builder);
    }
    return (A) this;
  }
  
  public EventListenerTrigger buildFirstTrigger() {
    return this.triggers.get(0).build();
  }
  
  public EventListenerTriggerGroup buildFirstTriggerGroup() {
    return this.triggerGroups.get(0).build();
  }
  
  public LabelSelector buildLabelSelector() {
    return this.labelSelector != null ? this.labelSelector.build() : null;
  }
  
  public EventListenerTrigger buildLastTrigger() {
    return this.triggers.get(triggers.size() - 1).build();
  }
  
  public EventListenerTriggerGroup buildLastTriggerGroup() {
    return this.triggerGroups.get(triggerGroups.size() - 1).build();
  }
  
  public EventListenerTrigger buildMatchingTrigger(Predicate<EventListenerTriggerBuilder> predicate) {
      for (EventListenerTriggerBuilder item : triggers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EventListenerTriggerGroup buildMatchingTriggerGroup(Predicate<EventListenerTriggerGroupBuilder> predicate) {
      for (EventListenerTriggerGroupBuilder item : triggerGroups) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NamespaceSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public Resources buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public EventListenerTrigger buildTrigger(int index) {
    return this.triggers.get(index).build();
  }
  
  public EventListenerTriggerGroup buildTriggerGroup(int index) {
    return this.triggerGroups.get(index).build();
  }
  
  public List<EventListenerTriggerGroup> buildTriggerGroups() {
    return this.triggerGroups != null ? build(triggerGroups) : null;
  }
  
  public List<EventListenerTrigger> buildTriggers() {
    return this.triggers != null ? build(triggers) : null;
  }
  
  protected void copyInstance(EventListenerSpec instance) {
    instance = instance != null ? instance : new EventListenerSpec();
    if (instance != null) {
        this.withCloudEventURI(instance.getCloudEventURI());
        this.withLabelSelector(instance.getLabelSelector());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withResources(instance.getResources());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withTriggerGroups(instance.getTriggerGroups());
        this.withTriggers(instance.getTriggers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TriggersNested<A> editFirstTrigger() {
    if (triggers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "triggers"));
    }
    return this.setNewTriggerLike(0, this.buildTrigger(0));
  }
  
  public TriggerGroupsNested<A> editFirstTriggerGroup() {
    if (triggerGroups.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "triggerGroups"));
    }
    return this.setNewTriggerGroupLike(0, this.buildTriggerGroup(0));
  }
  
  public LabelSelectorNested<A> editLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(null));
  }
  
  public TriggersNested<A> editLastTrigger() {
    int index = triggers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "triggers"));
    }
    return this.setNewTriggerLike(index, this.buildTrigger(index));
  }
  
  public TriggerGroupsNested<A> editLastTriggerGroup() {
    int index = triggerGroups.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "triggerGroups"));
    }
    return this.setNewTriggerGroupLike(index, this.buildTriggerGroup(index));
  }
  
  public TriggersNested<A> editMatchingTrigger(Predicate<EventListenerTriggerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < triggers.size();i++) {
      if (predicate.test(triggers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "triggers"));
    }
    return this.setNewTriggerLike(index, this.buildTrigger(index));
  }
  
  public TriggerGroupsNested<A> editMatchingTriggerGroup(Predicate<EventListenerTriggerGroupBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < triggerGroups.size();i++) {
      if (predicate.test(triggerGroups.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "triggerGroups"));
    }
    return this.setNewTriggerGroupLike(index, this.buildTriggerGroup(index));
  }
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelector() {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public LabelSelectorNested<A> editOrNewLabelSelectorLike(LabelSelector item) {
    return this.withNewLabelSelectorLike(Optional.ofNullable(this.buildLabelSelector()).orElse(item));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new NamespaceSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(NamespaceSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourcesBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(Resources item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public TriggersNested<A> editTrigger(int index) {
    if (triggers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "triggers"));
    }
    return this.setNewTriggerLike(index, this.buildTrigger(index));
  }
  
  public TriggerGroupsNested<A> editTriggerGroup(int index) {
    if (triggerGroups.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "triggerGroups"));
    }
    return this.setNewTriggerGroupLike(index, this.buildTriggerGroup(index));
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
    EventListenerSpecFluent that = (EventListenerSpecFluent) o;
    if (!(Objects.equals(cloudEventURI, that.cloudEventURI))) {
      return false;
    }
    if (!(Objects.equals(labelSelector, that.labelSelector))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(triggerGroups, that.triggerGroups))) {
      return false;
    }
    if (!(Objects.equals(triggers, that.triggers))) {
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
  
  public String getCloudEventURI() {
    return this.cloudEventURI;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCloudEventURI() {
    return this.cloudEventURI != null;
  }
  
  public boolean hasLabelSelector() {
    return this.labelSelector != null;
  }
  
  public boolean hasMatchingTrigger(Predicate<EventListenerTriggerBuilder> predicate) {
      for (EventListenerTriggerBuilder item : triggers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTriggerGroup(Predicate<EventListenerTriggerGroupBuilder> predicate) {
      for (EventListenerTriggerGroupBuilder item : triggerGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasTriggerGroups() {
    return this.triggerGroups != null && !(this.triggerGroups.isEmpty());
  }
  
  public boolean hasTriggers() {
    return this.triggers != null && !(this.triggers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(cloudEventURI, labelSelector, namespaceSelector, resources, serviceAccountName, triggerGroups, triggers, additionalProperties);
  }
  
  public A removeAllFromTriggerGroups(Collection<EventListenerTriggerGroup> items) {
    if (this.triggerGroups == null) {
      return (A) this;
    }
    for (EventListenerTriggerGroup item : items) {
        EventListenerTriggerGroupBuilder builder = new EventListenerTriggerGroupBuilder(item);
        _visitables.get("triggerGroups").remove(builder);
        this.triggerGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTriggers(Collection<EventListenerTrigger> items) {
    if (this.triggers == null) {
      return (A) this;
    }
    for (EventListenerTrigger item : items) {
        EventListenerTriggerBuilder builder = new EventListenerTriggerBuilder(item);
        _visitables.get("triggers").remove(builder);
        this.triggers.remove(builder);
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
  
  public A removeFromTriggerGroups(EventListenerTriggerGroup... items) {
    if (this.triggerGroups == null) {
      return (A) this;
    }
    for (EventListenerTriggerGroup item : items) {
        EventListenerTriggerGroupBuilder builder = new EventListenerTriggerGroupBuilder(item);
        _visitables.get("triggerGroups").remove(builder);
        this.triggerGroups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTriggers(EventListenerTrigger... items) {
    if (this.triggers == null) {
      return (A) this;
    }
    for (EventListenerTrigger item : items) {
        EventListenerTriggerBuilder builder = new EventListenerTriggerBuilder(item);
        _visitables.get("triggers").remove(builder);
        this.triggers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTriggerGroups(Predicate<EventListenerTriggerGroupBuilder> predicate) {
    if (triggerGroups == null) {
      return (A) this;
    }
    Iterator<EventListenerTriggerGroupBuilder> each = triggerGroups.iterator();
    List visitables = _visitables.get("triggerGroups");
    while (each.hasNext()) {
        EventListenerTriggerGroupBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTriggers(Predicate<EventListenerTriggerBuilder> predicate) {
    if (triggers == null) {
      return (A) this;
    }
    Iterator<EventListenerTriggerBuilder> each = triggers.iterator();
    List visitables = _visitables.get("triggers");
    while (each.hasNext()) {
        EventListenerTriggerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TriggerGroupsNested<A> setNewTriggerGroupLike(int index,EventListenerTriggerGroup item) {
    return new TriggerGroupsNested(index, item);
  }
  
  public TriggersNested<A> setNewTriggerLike(int index,EventListenerTrigger item) {
    return new TriggersNested(index, item);
  }
  
  public A setToTriggerGroups(int index,EventListenerTriggerGroup item) {
    if (this.triggerGroups == null) {
      this.triggerGroups = new ArrayList();
    }
    EventListenerTriggerGroupBuilder builder = new EventListenerTriggerGroupBuilder(item);
    if (index < 0 || index >= triggerGroups.size()) {
        _visitables.get("triggerGroups").add(builder);
        triggerGroups.add(builder);
    } else {
        _visitables.get("triggerGroups").add(builder);
        triggerGroups.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTriggers(int index,EventListenerTrigger item) {
    if (this.triggers == null) {
      this.triggers = new ArrayList();
    }
    EventListenerTriggerBuilder builder = new EventListenerTriggerBuilder(item);
    if (index < 0 || index >= triggers.size()) {
        _visitables.get("triggers").add(builder);
        triggers.add(builder);
    } else {
        _visitables.get("triggers").add(builder);
        triggers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cloudEventURI == null)) {
        sb.append("cloudEventURI:");
        sb.append(cloudEventURI);
        sb.append(",");
    }
    if (!(labelSelector == null)) {
        sb.append("labelSelector:");
        sb.append(labelSelector);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(triggerGroups == null) && !(triggerGroups.isEmpty())) {
        sb.append("triggerGroups:");
        sb.append(triggerGroups);
        sb.append(",");
    }
    if (!(triggers == null) && !(triggers.isEmpty())) {
        sb.append("triggers:");
        sb.append(triggers);
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
  
  public A withCloudEventURI(String cloudEventURI) {
    this.cloudEventURI = cloudEventURI;
    return (A) this;
  }
  
  public A withLabelSelector(LabelSelector labelSelector) {
    this._visitables.remove("labelSelector");
    if (labelSelector != null) {
        this.labelSelector = new LabelSelectorBuilder(labelSelector);
        this._visitables.get("labelSelector").add(this.labelSelector);
    } else {
        this.labelSelector = null;
        this._visitables.get("labelSelector").remove(this.labelSelector);
    }
    return (A) this;
  }
  
  public A withNamespaceSelector(NamespaceSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new NamespaceSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public LabelSelectorNested<A> withNewLabelSelector() {
    return new LabelSelectorNested(null);
  }
  
  public LabelSelectorNested<A> withNewLabelSelectorLike(LabelSelector item) {
    return new LabelSelectorNested(item);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(NamespaceSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(Resources item) {
    return new ResourcesNested(item);
  }
  
  public A withResources(Resources resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new ResourcesBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withTriggerGroups(List<EventListenerTriggerGroup> triggerGroups) {
    if (this.triggerGroups != null) {
      this._visitables.get("triggerGroups").clear();
    }
    if (triggerGroups != null) {
        this.triggerGroups = new ArrayList();
        for (EventListenerTriggerGroup item : triggerGroups) {
          this.addToTriggerGroups(item);
        }
    } else {
      this.triggerGroups = null;
    }
    return (A) this;
  }
  
  public A withTriggerGroups(EventListenerTriggerGroup... triggerGroups) {
    if (this.triggerGroups != null) {
        this.triggerGroups.clear();
        _visitables.remove("triggerGroups");
    }
    if (triggerGroups != null) {
      for (EventListenerTriggerGroup item : triggerGroups) {
        this.addToTriggerGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withTriggers(List<EventListenerTrigger> triggers) {
    if (this.triggers != null) {
      this._visitables.get("triggers").clear();
    }
    if (triggers != null) {
        this.triggers = new ArrayList();
        for (EventListenerTrigger item : triggers) {
          this.addToTriggers(item);
        }
    } else {
      this.triggers = null;
    }
    return (A) this;
  }
  
  public A withTriggers(EventListenerTrigger... triggers) {
    if (this.triggers != null) {
        this.triggers.clear();
        _visitables.remove("triggers");
    }
    if (triggers != null) {
      for (EventListenerTrigger item : triggers) {
        this.addToTriggers(item);
      }
    }
    return (A) this;
  }
  public class LabelSelectorNested<N> extends LabelSelectorFluent<LabelSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    LabelSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EventListenerSpecFluent.this.withLabelSelector(builder.build());
    }
    
    public N endLabelSelector() {
      return and();
    }
    
  }
  public class NamespaceSelectorNested<N> extends NamespaceSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    NamespaceSelectorBuilder builder;
  
    NamespaceSelectorNested(NamespaceSelector item) {
      this.builder = new NamespaceSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EventListenerSpecFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourcesFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourcesBuilder builder;
  
    ResourcesNested(Resources item) {
      this.builder = new ResourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) EventListenerSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class TriggerGroupsNested<N> extends EventListenerTriggerGroupFluent<TriggerGroupsNested<N>> implements Nested<N>{
  
    EventListenerTriggerGroupBuilder builder;
    int index;
  
    TriggerGroupsNested(int index,EventListenerTriggerGroup item) {
      this.index = index;
      this.builder = new EventListenerTriggerGroupBuilder(this, item);
    }
  
    public N and() {
      return (N) EventListenerSpecFluent.this.setToTriggerGroups(index, builder.build());
    }
    
    public N endTriggerGroup() {
      return and();
    }
    
  }
  public class TriggersNested<N> extends EventListenerTriggerFluent<TriggersNested<N>> implements Nested<N>{
  
    EventListenerTriggerBuilder builder;
    int index;
  
    TriggersNested(int index,EventListenerTrigger item) {
      this.index = index;
      this.builder = new EventListenerTriggerBuilder(this, item);
    }
  
    public N and() {
      return (N) EventListenerSpecFluent.this.setToTriggers(index, builder.build());
    }
    
    public N endTrigger() {
      return and();
    }
    
  }
}