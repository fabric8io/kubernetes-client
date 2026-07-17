package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class APIServiceDescriptionFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.APIServiceDescriptionFluent<A>> extends BaseFluent<A>{

  private ArrayList<ActionDescriptorBuilder> actionDescriptors = new ArrayList<ActionDescriptorBuilder>();
  private Map<String,Object> additionalProperties;
  private Integer containerPort;
  private String deploymentName;
  private String description;
  private String displayName;
  private String group;
  private String kind;
  private String name;
  private ArrayList<APIResourceReferenceBuilder> resources = new ArrayList<APIResourceReferenceBuilder>();
  private ArrayList<SpecDescriptorBuilder> specDescriptors = new ArrayList<SpecDescriptorBuilder>();
  private ArrayList<StatusDescriptorBuilder> statusDescriptors = new ArrayList<StatusDescriptorBuilder>();
  private String version;

  public APIServiceDescriptionFluent() {
  }
  
  public APIServiceDescriptionFluent(APIServiceDescription instance) {
    this.copyInstance(instance);
  }

  public A addAllToActionDescriptors(Collection<ActionDescriptor> items) {
    if (this.actionDescriptors == null) {
      this.actionDescriptors = new ArrayList();
    }
    for (ActionDescriptor item : items) {
        ActionDescriptorBuilder builder = new ActionDescriptorBuilder(item);
        _visitables.get("actionDescriptors").add(builder);
        this.actionDescriptors.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResources(Collection<APIResourceReference> items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (APIResourceReference item : items) {
        APIResourceReferenceBuilder builder = new APIResourceReferenceBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSpecDescriptors(Collection<SpecDescriptor> items) {
    if (this.specDescriptors == null) {
      this.specDescriptors = new ArrayList();
    }
    for (SpecDescriptor item : items) {
        SpecDescriptorBuilder builder = new SpecDescriptorBuilder(item);
        _visitables.get("specDescriptors").add(builder);
        this.specDescriptors.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStatusDescriptors(Collection<StatusDescriptor> items) {
    if (this.statusDescriptors == null) {
      this.statusDescriptors = new ArrayList();
    }
    for (StatusDescriptor item : items) {
        StatusDescriptorBuilder builder = new StatusDescriptorBuilder(item);
        _visitables.get("statusDescriptors").add(builder);
        this.statusDescriptors.add(builder);
    }
    return (A) this;
  }
  
  public ActionDescriptorsNested<A> addNewActionDescriptor() {
    return new ActionDescriptorsNested(-1, null);
  }
  
  public ActionDescriptorsNested<A> addNewActionDescriptorLike(ActionDescriptor item) {
    return new ActionDescriptorsNested(-1, item);
  }
  
  public ResourcesNested<A> addNewResource() {
    return new ResourcesNested(-1, null);
  }
  
  public A addNewResource(String kind,String name,String version) {
    return (A) this.addToResources(new APIResourceReference(kind, name, version));
  }
  
  public ResourcesNested<A> addNewResourceLike(APIResourceReference item) {
    return new ResourcesNested(-1, item);
  }
  
  public SpecDescriptorsNested<A> addNewSpecDescriptor() {
    return new SpecDescriptorsNested(-1, null);
  }
  
  public SpecDescriptorsNested<A> addNewSpecDescriptorLike(SpecDescriptor item) {
    return new SpecDescriptorsNested(-1, item);
  }
  
  public StatusDescriptorsNested<A> addNewStatusDescriptor() {
    return new StatusDescriptorsNested(-1, null);
  }
  
  public StatusDescriptorsNested<A> addNewStatusDescriptorLike(StatusDescriptor item) {
    return new StatusDescriptorsNested(-1, item);
  }
  
  public A addToActionDescriptors(ActionDescriptor... items) {
    if (this.actionDescriptors == null) {
      this.actionDescriptors = new ArrayList();
    }
    for (ActionDescriptor item : items) {
        ActionDescriptorBuilder builder = new ActionDescriptorBuilder(item);
        _visitables.get("actionDescriptors").add(builder);
        this.actionDescriptors.add(builder);
    }
    return (A) this;
  }
  
  public A addToActionDescriptors(int index,ActionDescriptor item) {
    if (this.actionDescriptors == null) {
      this.actionDescriptors = new ArrayList();
    }
    ActionDescriptorBuilder builder = new ActionDescriptorBuilder(item);
    if (index < 0 || index >= actionDescriptors.size()) {
        _visitables.get("actionDescriptors").add(builder);
        actionDescriptors.add(builder);
    } else {
        _visitables.get("actionDescriptors").add(builder);
        actionDescriptors.add(index, builder);
    }
    return (A) this;
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
  
  public A addToResources(APIResourceReference... items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (APIResourceReference item : items) {
        APIResourceReferenceBuilder builder = new APIResourceReferenceBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public A addToResources(int index,APIResourceReference item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    APIResourceReferenceBuilder builder = new APIResourceReferenceBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSpecDescriptors(SpecDescriptor... items) {
    if (this.specDescriptors == null) {
      this.specDescriptors = new ArrayList();
    }
    for (SpecDescriptor item : items) {
        SpecDescriptorBuilder builder = new SpecDescriptorBuilder(item);
        _visitables.get("specDescriptors").add(builder);
        this.specDescriptors.add(builder);
    }
    return (A) this;
  }
  
  public A addToSpecDescriptors(int index,SpecDescriptor item) {
    if (this.specDescriptors == null) {
      this.specDescriptors = new ArrayList();
    }
    SpecDescriptorBuilder builder = new SpecDescriptorBuilder(item);
    if (index < 0 || index >= specDescriptors.size()) {
        _visitables.get("specDescriptors").add(builder);
        specDescriptors.add(builder);
    } else {
        _visitables.get("specDescriptors").add(builder);
        specDescriptors.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStatusDescriptors(StatusDescriptor... items) {
    if (this.statusDescriptors == null) {
      this.statusDescriptors = new ArrayList();
    }
    for (StatusDescriptor item : items) {
        StatusDescriptorBuilder builder = new StatusDescriptorBuilder(item);
        _visitables.get("statusDescriptors").add(builder);
        this.statusDescriptors.add(builder);
    }
    return (A) this;
  }
  
  public A addToStatusDescriptors(int index,StatusDescriptor item) {
    if (this.statusDescriptors == null) {
      this.statusDescriptors = new ArrayList();
    }
    StatusDescriptorBuilder builder = new StatusDescriptorBuilder(item);
    if (index < 0 || index >= statusDescriptors.size()) {
        _visitables.get("statusDescriptors").add(builder);
        statusDescriptors.add(builder);
    } else {
        _visitables.get("statusDescriptors").add(builder);
        statusDescriptors.add(index, builder);
    }
    return (A) this;
  }
  
  public ActionDescriptor buildActionDescriptor(int index) {
    return this.actionDescriptors.get(index).build();
  }
  
  public List<ActionDescriptor> buildActionDescriptors() {
    return this.actionDescriptors != null ? build(actionDescriptors) : null;
  }
  
  public ActionDescriptor buildFirstActionDescriptor() {
    return this.actionDescriptors.get(0).build();
  }
  
  public APIResourceReference buildFirstResource() {
    return this.resources.get(0).build();
  }
  
  public SpecDescriptor buildFirstSpecDescriptor() {
    return this.specDescriptors.get(0).build();
  }
  
  public StatusDescriptor buildFirstStatusDescriptor() {
    return this.statusDescriptors.get(0).build();
  }
  
  public ActionDescriptor buildLastActionDescriptor() {
    return this.actionDescriptors.get(actionDescriptors.size() - 1).build();
  }
  
  public APIResourceReference buildLastResource() {
    return this.resources.get(resources.size() - 1).build();
  }
  
  public SpecDescriptor buildLastSpecDescriptor() {
    return this.specDescriptors.get(specDescriptors.size() - 1).build();
  }
  
  public StatusDescriptor buildLastStatusDescriptor() {
    return this.statusDescriptors.get(statusDescriptors.size() - 1).build();
  }
  
  public ActionDescriptor buildMatchingActionDescriptor(Predicate<ActionDescriptorBuilder> predicate) {
      for (ActionDescriptorBuilder item : actionDescriptors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public APIResourceReference buildMatchingResource(Predicate<APIResourceReferenceBuilder> predicate) {
      for (APIResourceReferenceBuilder item : resources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SpecDescriptor buildMatchingSpecDescriptor(Predicate<SpecDescriptorBuilder> predicate) {
      for (SpecDescriptorBuilder item : specDescriptors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StatusDescriptor buildMatchingStatusDescriptor(Predicate<StatusDescriptorBuilder> predicate) {
      for (StatusDescriptorBuilder item : statusDescriptors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public APIResourceReference buildResource(int index) {
    return this.resources.get(index).build();
  }
  
  public List<APIResourceReference> buildResources() {
    return this.resources != null ? build(resources) : null;
  }
  
  public SpecDescriptor buildSpecDescriptor(int index) {
    return this.specDescriptors.get(index).build();
  }
  
  public List<SpecDescriptor> buildSpecDescriptors() {
    return this.specDescriptors != null ? build(specDescriptors) : null;
  }
  
  public StatusDescriptor buildStatusDescriptor(int index) {
    return this.statusDescriptors.get(index).build();
  }
  
  public List<StatusDescriptor> buildStatusDescriptors() {
    return this.statusDescriptors != null ? build(statusDescriptors) : null;
  }
  
  protected void copyInstance(APIServiceDescription instance) {
    instance = instance != null ? instance : new APIServiceDescription();
    if (instance != null) {
        this.withActionDescriptors(instance.getActionDescriptors());
        this.withContainerPort(instance.getContainerPort());
        this.withDeploymentName(instance.getDeploymentName());
        this.withDescription(instance.getDescription());
        this.withDisplayName(instance.getDisplayName());
        this.withGroup(instance.getGroup());
        this.withKind(instance.getKind());
        this.withName(instance.getName());
        this.withResources(instance.getResources());
        this.withSpecDescriptors(instance.getSpecDescriptors());
        this.withStatusDescriptors(instance.getStatusDescriptors());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ActionDescriptorsNested<A> editActionDescriptor(int index) {
    if (actionDescriptors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "actionDescriptors"));
    }
    return this.setNewActionDescriptorLike(index, this.buildActionDescriptor(index));
  }
  
  public ActionDescriptorsNested<A> editFirstActionDescriptor() {
    if (actionDescriptors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "actionDescriptors"));
    }
    return this.setNewActionDescriptorLike(0, this.buildActionDescriptor(0));
  }
  
  public ResourcesNested<A> editFirstResource() {
    if (resources.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(0, this.buildResource(0));
  }
  
  public SpecDescriptorsNested<A> editFirstSpecDescriptor() {
    if (specDescriptors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "specDescriptors"));
    }
    return this.setNewSpecDescriptorLike(0, this.buildSpecDescriptor(0));
  }
  
  public StatusDescriptorsNested<A> editFirstStatusDescriptor() {
    if (statusDescriptors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "statusDescriptors"));
    }
    return this.setNewStatusDescriptorLike(0, this.buildStatusDescriptor(0));
  }
  
  public ActionDescriptorsNested<A> editLastActionDescriptor() {
    int index = actionDescriptors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "actionDescriptors"));
    }
    return this.setNewActionDescriptorLike(index, this.buildActionDescriptor(index));
  }
  
  public ResourcesNested<A> editLastResource() {
    int index = resources.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public SpecDescriptorsNested<A> editLastSpecDescriptor() {
    int index = specDescriptors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "specDescriptors"));
    }
    return this.setNewSpecDescriptorLike(index, this.buildSpecDescriptor(index));
  }
  
  public StatusDescriptorsNested<A> editLastStatusDescriptor() {
    int index = statusDescriptors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "statusDescriptors"));
    }
    return this.setNewStatusDescriptorLike(index, this.buildStatusDescriptor(index));
  }
  
  public ActionDescriptorsNested<A> editMatchingActionDescriptor(Predicate<ActionDescriptorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < actionDescriptors.size();i++) {
      if (predicate.test(actionDescriptors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "actionDescriptors"));
    }
    return this.setNewActionDescriptorLike(index, this.buildActionDescriptor(index));
  }
  
  public ResourcesNested<A> editMatchingResource(Predicate<APIResourceReferenceBuilder> predicate) {
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
  
  public SpecDescriptorsNested<A> editMatchingSpecDescriptor(Predicate<SpecDescriptorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < specDescriptors.size();i++) {
      if (predicate.test(specDescriptors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "specDescriptors"));
    }
    return this.setNewSpecDescriptorLike(index, this.buildSpecDescriptor(index));
  }
  
  public StatusDescriptorsNested<A> editMatchingStatusDescriptor(Predicate<StatusDescriptorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < statusDescriptors.size();i++) {
      if (predicate.test(statusDescriptors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "statusDescriptors"));
    }
    return this.setNewStatusDescriptorLike(index, this.buildStatusDescriptor(index));
  }
  
  public ResourcesNested<A> editResource(int index) {
    if (resources.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public SpecDescriptorsNested<A> editSpecDescriptor(int index) {
    if (specDescriptors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "specDescriptors"));
    }
    return this.setNewSpecDescriptorLike(index, this.buildSpecDescriptor(index));
  }
  
  public StatusDescriptorsNested<A> editStatusDescriptor(int index) {
    if (statusDescriptors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "statusDescriptors"));
    }
    return this.setNewStatusDescriptorLike(index, this.buildStatusDescriptor(index));
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
    APIServiceDescriptionFluent that = (APIServiceDescriptionFluent) o;
    if (!(Objects.equals(actionDescriptors, that.actionDescriptors))) {
      return false;
    }
    if (!(Objects.equals(containerPort, that.containerPort))) {
      return false;
    }
    if (!(Objects.equals(deploymentName, that.deploymentName))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(specDescriptors, that.specDescriptors))) {
      return false;
    }
    if (!(Objects.equals(statusDescriptors, that.statusDescriptors))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public Integer getContainerPort() {
    return this.containerPort;
  }
  
  public String getDeploymentName() {
    return this.deploymentName;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public String getGroup() {
    return this.group;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasActionDescriptors() {
    return this.actionDescriptors != null && !(this.actionDescriptors.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerPort() {
    return this.containerPort != null;
  }
  
  public boolean hasDeploymentName() {
    return this.deploymentName != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasGroup() {
    return this.group != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingActionDescriptor(Predicate<ActionDescriptorBuilder> predicate) {
      for (ActionDescriptorBuilder item : actionDescriptors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResource(Predicate<APIResourceReferenceBuilder> predicate) {
      for (APIResourceReferenceBuilder item : resources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSpecDescriptor(Predicate<SpecDescriptorBuilder> predicate) {
      for (SpecDescriptorBuilder item : specDescriptors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStatusDescriptor(Predicate<StatusDescriptorBuilder> predicate) {
      for (StatusDescriptorBuilder item : statusDescriptors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasResources() {
    return this.resources != null && !(this.resources.isEmpty());
  }
  
  public boolean hasSpecDescriptors() {
    return this.specDescriptors != null && !(this.specDescriptors.isEmpty());
  }
  
  public boolean hasStatusDescriptors() {
    return this.statusDescriptors != null && !(this.statusDescriptors.isEmpty());
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(actionDescriptors, containerPort, deploymentName, description, displayName, group, kind, name, resources, specDescriptors, statusDescriptors, version, additionalProperties);
  }
  
  public A removeAllFromActionDescriptors(Collection<ActionDescriptor> items) {
    if (this.actionDescriptors == null) {
      return (A) this;
    }
    for (ActionDescriptor item : items) {
        ActionDescriptorBuilder builder = new ActionDescriptorBuilder(item);
        _visitables.get("actionDescriptors").remove(builder);
        this.actionDescriptors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResources(Collection<APIResourceReference> items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (APIResourceReference item : items) {
        APIResourceReferenceBuilder builder = new APIResourceReferenceBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSpecDescriptors(Collection<SpecDescriptor> items) {
    if (this.specDescriptors == null) {
      return (A) this;
    }
    for (SpecDescriptor item : items) {
        SpecDescriptorBuilder builder = new SpecDescriptorBuilder(item);
        _visitables.get("specDescriptors").remove(builder);
        this.specDescriptors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStatusDescriptors(Collection<StatusDescriptor> items) {
    if (this.statusDescriptors == null) {
      return (A) this;
    }
    for (StatusDescriptor item : items) {
        StatusDescriptorBuilder builder = new StatusDescriptorBuilder(item);
        _visitables.get("statusDescriptors").remove(builder);
        this.statusDescriptors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromActionDescriptors(ActionDescriptor... items) {
    if (this.actionDescriptors == null) {
      return (A) this;
    }
    for (ActionDescriptor item : items) {
        ActionDescriptorBuilder builder = new ActionDescriptorBuilder(item);
        _visitables.get("actionDescriptors").remove(builder);
        this.actionDescriptors.remove(builder);
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
  
  public A removeFromResources(APIResourceReference... items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (APIResourceReference item : items) {
        APIResourceReferenceBuilder builder = new APIResourceReferenceBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSpecDescriptors(SpecDescriptor... items) {
    if (this.specDescriptors == null) {
      return (A) this;
    }
    for (SpecDescriptor item : items) {
        SpecDescriptorBuilder builder = new SpecDescriptorBuilder(item);
        _visitables.get("specDescriptors").remove(builder);
        this.specDescriptors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStatusDescriptors(StatusDescriptor... items) {
    if (this.statusDescriptors == null) {
      return (A) this;
    }
    for (StatusDescriptor item : items) {
        StatusDescriptorBuilder builder = new StatusDescriptorBuilder(item);
        _visitables.get("statusDescriptors").remove(builder);
        this.statusDescriptors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromActionDescriptors(Predicate<ActionDescriptorBuilder> predicate) {
    if (actionDescriptors == null) {
      return (A) this;
    }
    Iterator<ActionDescriptorBuilder> each = actionDescriptors.iterator();
    List visitables = _visitables.get("actionDescriptors");
    while (each.hasNext()) {
        ActionDescriptorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResources(Predicate<APIResourceReferenceBuilder> predicate) {
    if (resources == null) {
      return (A) this;
    }
    Iterator<APIResourceReferenceBuilder> each = resources.iterator();
    List visitables = _visitables.get("resources");
    while (each.hasNext()) {
        APIResourceReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSpecDescriptors(Predicate<SpecDescriptorBuilder> predicate) {
    if (specDescriptors == null) {
      return (A) this;
    }
    Iterator<SpecDescriptorBuilder> each = specDescriptors.iterator();
    List visitables = _visitables.get("specDescriptors");
    while (each.hasNext()) {
        SpecDescriptorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStatusDescriptors(Predicate<StatusDescriptorBuilder> predicate) {
    if (statusDescriptors == null) {
      return (A) this;
    }
    Iterator<StatusDescriptorBuilder> each = statusDescriptors.iterator();
    List visitables = _visitables.get("statusDescriptors");
    while (each.hasNext()) {
        StatusDescriptorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ActionDescriptorsNested<A> setNewActionDescriptorLike(int index,ActionDescriptor item) {
    return new ActionDescriptorsNested(index, item);
  }
  
  public ResourcesNested<A> setNewResourceLike(int index,APIResourceReference item) {
    return new ResourcesNested(index, item);
  }
  
  public SpecDescriptorsNested<A> setNewSpecDescriptorLike(int index,SpecDescriptor item) {
    return new SpecDescriptorsNested(index, item);
  }
  
  public StatusDescriptorsNested<A> setNewStatusDescriptorLike(int index,StatusDescriptor item) {
    return new StatusDescriptorsNested(index, item);
  }
  
  public A setToActionDescriptors(int index,ActionDescriptor item) {
    if (this.actionDescriptors == null) {
      this.actionDescriptors = new ArrayList();
    }
    ActionDescriptorBuilder builder = new ActionDescriptorBuilder(item);
    if (index < 0 || index >= actionDescriptors.size()) {
        _visitables.get("actionDescriptors").add(builder);
        actionDescriptors.add(builder);
    } else {
        _visitables.get("actionDescriptors").add(builder);
        actionDescriptors.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResources(int index,APIResourceReference item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    APIResourceReferenceBuilder builder = new APIResourceReferenceBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSpecDescriptors(int index,SpecDescriptor item) {
    if (this.specDescriptors == null) {
      this.specDescriptors = new ArrayList();
    }
    SpecDescriptorBuilder builder = new SpecDescriptorBuilder(item);
    if (index < 0 || index >= specDescriptors.size()) {
        _visitables.get("specDescriptors").add(builder);
        specDescriptors.add(builder);
    } else {
        _visitables.get("specDescriptors").add(builder);
        specDescriptors.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStatusDescriptors(int index,StatusDescriptor item) {
    if (this.statusDescriptors == null) {
      this.statusDescriptors = new ArrayList();
    }
    StatusDescriptorBuilder builder = new StatusDescriptorBuilder(item);
    if (index < 0 || index >= statusDescriptors.size()) {
        _visitables.get("statusDescriptors").add(builder);
        statusDescriptors.add(builder);
    } else {
        _visitables.get("statusDescriptors").add(builder);
        statusDescriptors.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(actionDescriptors == null) && !(actionDescriptors.isEmpty())) {
        sb.append("actionDescriptors:");
        sb.append(actionDescriptors);
        sb.append(",");
    }
    if (!(containerPort == null)) {
        sb.append("containerPort:");
        sb.append(containerPort);
        sb.append(",");
    }
    if (!(deploymentName == null)) {
        sb.append("deploymentName:");
        sb.append(deploymentName);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(displayName == null)) {
        sb.append("displayName:");
        sb.append(displayName);
        sb.append(",");
    }
    if (!(group == null)) {
        sb.append("group:");
        sb.append(group);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(resources == null) && !(resources.isEmpty())) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(specDescriptors == null) && !(specDescriptors.isEmpty())) {
        sb.append("specDescriptors:");
        sb.append(specDescriptors);
        sb.append(",");
    }
    if (!(statusDescriptors == null) && !(statusDescriptors.isEmpty())) {
        sb.append("statusDescriptors:");
        sb.append(statusDescriptors);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActionDescriptors(List<ActionDescriptor> actionDescriptors) {
    if (this.actionDescriptors != null) {
      this._visitables.get("actionDescriptors").clear();
    }
    if (actionDescriptors != null) {
        this.actionDescriptors = new ArrayList();
        for (ActionDescriptor item : actionDescriptors) {
          this.addToActionDescriptors(item);
        }
    } else {
      this.actionDescriptors = null;
    }
    return (A) this;
  }
  
  public A withActionDescriptors(ActionDescriptor... actionDescriptors) {
    if (this.actionDescriptors != null) {
        this.actionDescriptors.clear();
        _visitables.remove("actionDescriptors");
    }
    if (actionDescriptors != null) {
      for (ActionDescriptor item : actionDescriptors) {
        this.addToActionDescriptors(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withContainerPort(Integer containerPort) {
    this.containerPort = containerPort;
    return (A) this;
  }
  
  public A withDeploymentName(String deploymentName) {
    this.deploymentName = deploymentName;
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withDisplayName(String displayName) {
    this.displayName = displayName;
    return (A) this;
  }
  
  public A withGroup(String group) {
    this.group = group;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withResources(List<APIResourceReference> resources) {
    if (this.resources != null) {
      this._visitables.get("resources").clear();
    }
    if (resources != null) {
        this.resources = new ArrayList();
        for (APIResourceReference item : resources) {
          this.addToResources(item);
        }
    } else {
      this.resources = null;
    }
    return (A) this;
  }
  
  public A withResources(APIResourceReference... resources) {
    if (this.resources != null) {
        this.resources.clear();
        _visitables.remove("resources");
    }
    if (resources != null) {
      for (APIResourceReference item : resources) {
        this.addToResources(item);
      }
    }
    return (A) this;
  }
  
  public A withSpecDescriptors(List<SpecDescriptor> specDescriptors) {
    if (this.specDescriptors != null) {
      this._visitables.get("specDescriptors").clear();
    }
    if (specDescriptors != null) {
        this.specDescriptors = new ArrayList();
        for (SpecDescriptor item : specDescriptors) {
          this.addToSpecDescriptors(item);
        }
    } else {
      this.specDescriptors = null;
    }
    return (A) this;
  }
  
  public A withSpecDescriptors(SpecDescriptor... specDescriptors) {
    if (this.specDescriptors != null) {
        this.specDescriptors.clear();
        _visitables.remove("specDescriptors");
    }
    if (specDescriptors != null) {
      for (SpecDescriptor item : specDescriptors) {
        this.addToSpecDescriptors(item);
      }
    }
    return (A) this;
  }
  
  public A withStatusDescriptors(List<StatusDescriptor> statusDescriptors) {
    if (this.statusDescriptors != null) {
      this._visitables.get("statusDescriptors").clear();
    }
    if (statusDescriptors != null) {
        this.statusDescriptors = new ArrayList();
        for (StatusDescriptor item : statusDescriptors) {
          this.addToStatusDescriptors(item);
        }
    } else {
      this.statusDescriptors = null;
    }
    return (A) this;
  }
  
  public A withStatusDescriptors(StatusDescriptor... statusDescriptors) {
    if (this.statusDescriptors != null) {
        this.statusDescriptors.clear();
        _visitables.remove("statusDescriptors");
    }
    if (statusDescriptors != null) {
      for (StatusDescriptor item : statusDescriptors) {
        this.addToStatusDescriptors(item);
      }
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class ActionDescriptorsNested<N> extends ActionDescriptorFluent<ActionDescriptorsNested<N>> implements Nested<N>{
  
    ActionDescriptorBuilder builder;
    int index;
  
    ActionDescriptorsNested(int index,ActionDescriptor item) {
      this.index = index;
      this.builder = new ActionDescriptorBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServiceDescriptionFluent.this.setToActionDescriptors(index, builder.build());
    }
    
    public N endActionDescriptor() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends APIResourceReferenceFluent<ResourcesNested<N>> implements Nested<N>{
  
    APIResourceReferenceBuilder builder;
    int index;
  
    ResourcesNested(int index,APIResourceReference item) {
      this.index = index;
      this.builder = new APIResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServiceDescriptionFluent.this.setToResources(index, builder.build());
    }
    
    public N endResource() {
      return and();
    }
    
  }
  public class SpecDescriptorsNested<N> extends SpecDescriptorFluent<SpecDescriptorsNested<N>> implements Nested<N>{
  
    SpecDescriptorBuilder builder;
    int index;
  
    SpecDescriptorsNested(int index,SpecDescriptor item) {
      this.index = index;
      this.builder = new SpecDescriptorBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServiceDescriptionFluent.this.setToSpecDescriptors(index, builder.build());
    }
    
    public N endSpecDescriptor() {
      return and();
    }
    
  }
  public class StatusDescriptorsNested<N> extends StatusDescriptorFluent<StatusDescriptorsNested<N>> implements Nested<N>{
  
    StatusDescriptorBuilder builder;
    int index;
  
    StatusDescriptorsNested(int index,StatusDescriptor item) {
      this.index = index;
      this.builder = new StatusDescriptorBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServiceDescriptionFluent.this.setToStatusDescriptors(index, builder.build());
    }
    
    public N endStatusDescriptor() {
      return and();
    }
    
  }
}