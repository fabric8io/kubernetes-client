package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ContainerStatusFluent<A extends io.fabric8.kubernetes.api.model.ContainerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Quantity> allocatedResources;
  private ArrayList<ResourceStatusBuilder> allocatedResourcesStatus = new ArrayList<ResourceStatusBuilder>();
  private String containerID;
  private String image;
  private String imageID;
  private ContainerStateBuilder lastState;
  private String name;
  private Boolean ready;
  private ResourceRequirementsBuilder resources;
  private Integer restartCount;
  private Boolean started;
  private ContainerStateBuilder state;
  private String stopSignal;
  private ContainerUserBuilder user;
  private ArrayList<VolumeMountStatusBuilder> volumeMounts = new ArrayList<VolumeMountStatusBuilder>();

  public ContainerStatusFluent() {
  }
  
  public ContainerStatusFluent(ContainerStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllocatedResourcesStatus(Collection<ResourceStatus> items) {
    if (this.allocatedResourcesStatus == null) {
      this.allocatedResourcesStatus = new ArrayList();
    }
    for (ResourceStatus item : items) {
        ResourceStatusBuilder builder = new ResourceStatusBuilder(item);
        _visitables.get("allocatedResourcesStatus").add(builder);
        this.allocatedResourcesStatus.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVolumeMounts(Collection<VolumeMountStatus> items) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    for (VolumeMountStatus item : items) {
        VolumeMountStatusBuilder builder = new VolumeMountStatusBuilder(item);
        _visitables.get("volumeMounts").add(builder);
        this.volumeMounts.add(builder);
    }
    return (A) this;
  }
  
  public AllocatedResourcesStatusNested<A> addNewAllocatedResourcesStatus() {
    return new AllocatedResourcesStatusNested(-1, null);
  }
  
  public AllocatedResourcesStatusNested<A> addNewAllocatedResourcesStatusLike(ResourceStatus item) {
    return new AllocatedResourcesStatusNested(-1, item);
  }
  
  public VolumeMountsNested<A> addNewVolumeMount() {
    return new VolumeMountsNested(-1, null);
  }
  
  public VolumeMountsNested<A> addNewVolumeMountLike(VolumeMountStatus item) {
    return new VolumeMountsNested(-1, item);
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
  
  public A addToAllocatedResources(Map<String,Quantity> map) {
    if (this.allocatedResources == null && map != null) {
      this.allocatedResources = new LinkedHashMap();
    }
    if (map != null) {
      this.allocatedResources.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAllocatedResources(String key,Quantity value) {
    if (this.allocatedResources == null && key != null && value != null) {
      this.allocatedResources = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.allocatedResources.put(key, value);
    }
    return (A) this;
  }
  
  public A addToAllocatedResourcesStatus(ResourceStatus... items) {
    if (this.allocatedResourcesStatus == null) {
      this.allocatedResourcesStatus = new ArrayList();
    }
    for (ResourceStatus item : items) {
        ResourceStatusBuilder builder = new ResourceStatusBuilder(item);
        _visitables.get("allocatedResourcesStatus").add(builder);
        this.allocatedResourcesStatus.add(builder);
    }
    return (A) this;
  }
  
  public A addToAllocatedResourcesStatus(int index,ResourceStatus item) {
    if (this.allocatedResourcesStatus == null) {
      this.allocatedResourcesStatus = new ArrayList();
    }
    ResourceStatusBuilder builder = new ResourceStatusBuilder(item);
    if (index < 0 || index >= allocatedResourcesStatus.size()) {
        _visitables.get("allocatedResourcesStatus").add(builder);
        allocatedResourcesStatus.add(builder);
    } else {
        _visitables.get("allocatedResourcesStatus").add(builder);
        allocatedResourcesStatus.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVolumeMounts(VolumeMountStatus... items) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    for (VolumeMountStatus item : items) {
        VolumeMountStatusBuilder builder = new VolumeMountStatusBuilder(item);
        _visitables.get("volumeMounts").add(builder);
        this.volumeMounts.add(builder);
    }
    return (A) this;
  }
  
  public A addToVolumeMounts(int index,VolumeMountStatus item) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    VolumeMountStatusBuilder builder = new VolumeMountStatusBuilder(item);
    if (index < 0 || index >= volumeMounts.size()) {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(builder);
    } else {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(index, builder);
    }
    return (A) this;
  }
  
  public List<ResourceStatus> buildAllocatedResourcesStatus() {
    return this.allocatedResourcesStatus != null ? build(allocatedResourcesStatus) : null;
  }
  
  public ResourceStatus buildAllocatedResourcesStatus(int index) {
    return this.allocatedResourcesStatus.get(index).build();
  }
  
  public ResourceStatus buildFirstAllocatedResourcesStatus() {
    return this.allocatedResourcesStatus.get(0).build();
  }
  
  public VolumeMountStatus buildFirstVolumeMount() {
    return this.volumeMounts.get(0).build();
  }
  
  public ResourceStatus buildLastAllocatedResourcesStatus() {
    return this.allocatedResourcesStatus.get(allocatedResourcesStatus.size() - 1).build();
  }
  
  public ContainerState buildLastState() {
    return this.lastState != null ? this.lastState.build() : null;
  }
  
  public VolumeMountStatus buildLastVolumeMount() {
    return this.volumeMounts.get(volumeMounts.size() - 1).build();
  }
  
  public ResourceStatus buildMatchingAllocatedResourcesStatus(Predicate<ResourceStatusBuilder> predicate) {
      for (ResourceStatusBuilder item : allocatedResourcesStatus) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VolumeMountStatus buildMatchingVolumeMount(Predicate<VolumeMountStatusBuilder> predicate) {
      for (VolumeMountStatusBuilder item : volumeMounts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public ContainerState buildState() {
    return this.state != null ? this.state.build() : null;
  }
  
  public ContainerUser buildUser() {
    return this.user != null ? this.user.build() : null;
  }
  
  public VolumeMountStatus buildVolumeMount(int index) {
    return this.volumeMounts.get(index).build();
  }
  
  public List<VolumeMountStatus> buildVolumeMounts() {
    return this.volumeMounts != null ? build(volumeMounts) : null;
  }
  
  protected void copyInstance(ContainerStatus instance) {
    instance = instance != null ? instance : new ContainerStatus();
    if (instance != null) {
        this.withAllocatedResources(instance.getAllocatedResources());
        this.withAllocatedResourcesStatus(instance.getAllocatedResourcesStatus());
        this.withContainerID(instance.getContainerID());
        this.withImage(instance.getImage());
        this.withImageID(instance.getImageID());
        this.withLastState(instance.getLastState());
        this.withName(instance.getName());
        this.withReady(instance.getReady());
        this.withResources(instance.getResources());
        this.withRestartCount(instance.getRestartCount());
        this.withStarted(instance.getStarted());
        this.withState(instance.getState());
        this.withStopSignal(instance.getStopSignal());
        this.withUser(instance.getUser());
        this.withVolumeMounts(instance.getVolumeMounts());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllocatedResourcesStatusNested<A> editAllocatedResourcesStatus(int index) {
    if (allocatedResourcesStatus.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "allocatedResourcesStatus"));
    }
    return this.setNewAllocatedResourcesStatusLike(index, this.buildAllocatedResourcesStatus(index));
  }
  
  public AllocatedResourcesStatusNested<A> editFirstAllocatedResourcesStatus() {
    if (allocatedResourcesStatus.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "allocatedResourcesStatus"));
    }
    return this.setNewAllocatedResourcesStatusLike(0, this.buildAllocatedResourcesStatus(0));
  }
  
  public VolumeMountsNested<A> editFirstVolumeMount() {
    if (volumeMounts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(0, this.buildVolumeMount(0));
  }
  
  public AllocatedResourcesStatusNested<A> editLastAllocatedResourcesStatus() {
    int index = allocatedResourcesStatus.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "allocatedResourcesStatus"));
    }
    return this.setNewAllocatedResourcesStatusLike(index, this.buildAllocatedResourcesStatus(index));
  }
  
  public LastStateNested<A> editLastState() {
    return this.withNewLastStateLike(Optional.ofNullable(this.buildLastState()).orElse(null));
  }
  
  public VolumeMountsNested<A> editLastVolumeMount() {
    int index = volumeMounts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
  }
  
  public AllocatedResourcesStatusNested<A> editMatchingAllocatedResourcesStatus(Predicate<ResourceStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < allocatedResourcesStatus.size();i++) {
      if (predicate.test(allocatedResourcesStatus.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "allocatedResourcesStatus"));
    }
    return this.setNewAllocatedResourcesStatusLike(index, this.buildAllocatedResourcesStatus(index));
  }
  
  public VolumeMountsNested<A> editMatchingVolumeMount(Predicate<VolumeMountStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < volumeMounts.size();i++) {
      if (predicate.test(volumeMounts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
  }
  
  public LastStateNested<A> editOrNewLastState() {
    return this.withNewLastStateLike(Optional.ofNullable(this.buildLastState()).orElse(new ContainerStateBuilder().build()));
  }
  
  public LastStateNested<A> editOrNewLastStateLike(ContainerState item) {
    return this.withNewLastStateLike(Optional.ofNullable(this.buildLastState()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public StateNested<A> editOrNewState() {
    return this.withNewStateLike(Optional.ofNullable(this.buildState()).orElse(new ContainerStateBuilder().build()));
  }
  
  public StateNested<A> editOrNewStateLike(ContainerState item) {
    return this.withNewStateLike(Optional.ofNullable(this.buildState()).orElse(item));
  }
  
  public UserNested<A> editOrNewUser() {
    return this.withNewUserLike(Optional.ofNullable(this.buildUser()).orElse(new ContainerUserBuilder().build()));
  }
  
  public UserNested<A> editOrNewUserLike(ContainerUser item) {
    return this.withNewUserLike(Optional.ofNullable(this.buildUser()).orElse(item));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public StateNested<A> editState() {
    return this.withNewStateLike(Optional.ofNullable(this.buildState()).orElse(null));
  }
  
  public UserNested<A> editUser() {
    return this.withNewUserLike(Optional.ofNullable(this.buildUser()).orElse(null));
  }
  
  public VolumeMountsNested<A> editVolumeMount(int index) {
    if (volumeMounts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
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
    ContainerStatusFluent that = (ContainerStatusFluent) o;
    if (!(Objects.equals(allocatedResources, that.allocatedResources))) {
      return false;
    }
    if (!(Objects.equals(allocatedResourcesStatus, that.allocatedResourcesStatus))) {
      return false;
    }
    if (!(Objects.equals(containerID, that.containerID))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(imageID, that.imageID))) {
      return false;
    }
    if (!(Objects.equals(lastState, that.lastState))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(ready, that.ready))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(restartCount, that.restartCount))) {
      return false;
    }
    if (!(Objects.equals(started, that.started))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
      return false;
    }
    if (!(Objects.equals(stopSignal, that.stopSignal))) {
      return false;
    }
    if (!(Objects.equals(user, that.user))) {
      return false;
    }
    if (!(Objects.equals(volumeMounts, that.volumeMounts))) {
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
  
  public Map<String,Quantity> getAllocatedResources() {
    return this.allocatedResources;
  }
  
  public String getContainerID() {
    return this.containerID;
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getImageID() {
    return this.imageID;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Boolean getReady() {
    return this.ready;
  }
  
  public Integer getRestartCount() {
    return this.restartCount;
  }
  
  public Boolean getStarted() {
    return this.started;
  }
  
  public String getStopSignal() {
    return this.stopSignal;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocatedResources() {
    return this.allocatedResources != null;
  }
  
  public boolean hasAllocatedResourcesStatus() {
    return this.allocatedResourcesStatus != null && !(this.allocatedResourcesStatus.isEmpty());
  }
  
  public boolean hasContainerID() {
    return this.containerID != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasImageID() {
    return this.imageID != null;
  }
  
  public boolean hasLastState() {
    return this.lastState != null;
  }
  
  public boolean hasMatchingAllocatedResourcesStatus(Predicate<ResourceStatusBuilder> predicate) {
      for (ResourceStatusBuilder item : allocatedResourcesStatus) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolumeMount(Predicate<VolumeMountStatusBuilder> predicate) {
      for (VolumeMountStatusBuilder item : volumeMounts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasReady() {
    return this.ready != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasRestartCount() {
    return this.restartCount != null;
  }
  
  public boolean hasStarted() {
    return this.started != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public boolean hasStopSignal() {
    return this.stopSignal != null;
  }
  
  public boolean hasUser() {
    return this.user != null;
  }
  
  public boolean hasVolumeMounts() {
    return this.volumeMounts != null && !(this.volumeMounts.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(allocatedResources, allocatedResourcesStatus, containerID, image, imageID, lastState, name, ready, resources, restartCount, started, state, stopSignal, user, volumeMounts, additionalProperties);
  }
  
  public A removeAllFromAllocatedResourcesStatus(Collection<ResourceStatus> items) {
    if (this.allocatedResourcesStatus == null) {
      return (A) this;
    }
    for (ResourceStatus item : items) {
        ResourceStatusBuilder builder = new ResourceStatusBuilder(item);
        _visitables.get("allocatedResourcesStatus").remove(builder);
        this.allocatedResourcesStatus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVolumeMounts(Collection<VolumeMountStatus> items) {
    if (this.volumeMounts == null) {
      return (A) this;
    }
    for (VolumeMountStatus item : items) {
        VolumeMountStatusBuilder builder = new VolumeMountStatusBuilder(item);
        _visitables.get("volumeMounts").remove(builder);
        this.volumeMounts.remove(builder);
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
  
  public A removeFromAllocatedResources(String key) {
    if (this.allocatedResources == null) {
      return (A) this;
    }
    if (key != null && this.allocatedResources != null) {
      this.allocatedResources.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAllocatedResources(Map<String,Quantity> map) {
    if (this.allocatedResources == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.allocatedResources != null) {
          this.allocatedResources.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromAllocatedResourcesStatus(ResourceStatus... items) {
    if (this.allocatedResourcesStatus == null) {
      return (A) this;
    }
    for (ResourceStatus item : items) {
        ResourceStatusBuilder builder = new ResourceStatusBuilder(item);
        _visitables.get("allocatedResourcesStatus").remove(builder);
        this.allocatedResourcesStatus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVolumeMounts(VolumeMountStatus... items) {
    if (this.volumeMounts == null) {
      return (A) this;
    }
    for (VolumeMountStatus item : items) {
        VolumeMountStatusBuilder builder = new VolumeMountStatusBuilder(item);
        _visitables.get("volumeMounts").remove(builder);
        this.volumeMounts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAllocatedResourcesStatus(Predicate<ResourceStatusBuilder> predicate) {
    if (allocatedResourcesStatus == null) {
      return (A) this;
    }
    Iterator<ResourceStatusBuilder> each = allocatedResourcesStatus.iterator();
    List visitables = _visitables.get("allocatedResourcesStatus");
    while (each.hasNext()) {
        ResourceStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVolumeMounts(Predicate<VolumeMountStatusBuilder> predicate) {
    if (volumeMounts == null) {
      return (A) this;
    }
    Iterator<VolumeMountStatusBuilder> each = volumeMounts.iterator();
    List visitables = _visitables.get("volumeMounts");
    while (each.hasNext()) {
        VolumeMountStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AllocatedResourcesStatusNested<A> setNewAllocatedResourcesStatusLike(int index,ResourceStatus item) {
    return new AllocatedResourcesStatusNested(index, item);
  }
  
  public VolumeMountsNested<A> setNewVolumeMountLike(int index,VolumeMountStatus item) {
    return new VolumeMountsNested(index, item);
  }
  
  public A setToAllocatedResourcesStatus(int index,ResourceStatus item) {
    if (this.allocatedResourcesStatus == null) {
      this.allocatedResourcesStatus = new ArrayList();
    }
    ResourceStatusBuilder builder = new ResourceStatusBuilder(item);
    if (index < 0 || index >= allocatedResourcesStatus.size()) {
        _visitables.get("allocatedResourcesStatus").add(builder);
        allocatedResourcesStatus.add(builder);
    } else {
        _visitables.get("allocatedResourcesStatus").add(builder);
        allocatedResourcesStatus.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVolumeMounts(int index,VolumeMountStatus item) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    VolumeMountStatusBuilder builder = new VolumeMountStatusBuilder(item);
    if (index < 0 || index >= volumeMounts.size()) {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(builder);
    } else {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allocatedResources == null) && !(allocatedResources.isEmpty())) {
        sb.append("allocatedResources:");
        sb.append(allocatedResources);
        sb.append(",");
    }
    if (!(allocatedResourcesStatus == null) && !(allocatedResourcesStatus.isEmpty())) {
        sb.append("allocatedResourcesStatus:");
        sb.append(allocatedResourcesStatus);
        sb.append(",");
    }
    if (!(containerID == null)) {
        sb.append("containerID:");
        sb.append(containerID);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(imageID == null)) {
        sb.append("imageID:");
        sb.append(imageID);
        sb.append(",");
    }
    if (!(lastState == null)) {
        sb.append("lastState:");
        sb.append(lastState);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(ready == null)) {
        sb.append("ready:");
        sb.append(ready);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(restartCount == null)) {
        sb.append("restartCount:");
        sb.append(restartCount);
        sb.append(",");
    }
    if (!(started == null)) {
        sb.append("started:");
        sb.append(started);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
        sb.append(",");
    }
    if (!(stopSignal == null)) {
        sb.append("stopSignal:");
        sb.append(stopSignal);
        sb.append(",");
    }
    if (!(user == null)) {
        sb.append("user:");
        sb.append(user);
        sb.append(",");
    }
    if (!(volumeMounts == null) && !(volumeMounts.isEmpty())) {
        sb.append("volumeMounts:");
        sb.append(volumeMounts);
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
  
  public <K,V>A withAllocatedResources(Map<String,Quantity> allocatedResources) {
    if (allocatedResources == null) {
      this.allocatedResources = null;
    } else {
      this.allocatedResources = new LinkedHashMap(allocatedResources);
    }
    return (A) this;
  }
  
  public A withAllocatedResourcesStatus(List<ResourceStatus> allocatedResourcesStatus) {
    if (this.allocatedResourcesStatus != null) {
      this._visitables.get("allocatedResourcesStatus").clear();
    }
    if (allocatedResourcesStatus != null) {
        this.allocatedResourcesStatus = new ArrayList();
        for (ResourceStatus item : allocatedResourcesStatus) {
          this.addToAllocatedResourcesStatus(item);
        }
    } else {
      this.allocatedResourcesStatus = null;
    }
    return (A) this;
  }
  
  public A withAllocatedResourcesStatus(ResourceStatus... allocatedResourcesStatus) {
    if (this.allocatedResourcesStatus != null) {
        this.allocatedResourcesStatus.clear();
        _visitables.remove("allocatedResourcesStatus");
    }
    if (allocatedResourcesStatus != null) {
      for (ResourceStatus item : allocatedResourcesStatus) {
        this.addToAllocatedResourcesStatus(item);
      }
    }
    return (A) this;
  }
  
  public A withContainerID(String containerID) {
    this.containerID = containerID;
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public A withImageID(String imageID) {
    this.imageID = imageID;
    return (A) this;
  }
  
  public A withLastState(ContainerState lastState) {
    this._visitables.remove("lastState");
    if (lastState != null) {
        this.lastState = new ContainerStateBuilder(lastState);
        this._visitables.get("lastState").add(this.lastState);
    } else {
        this.lastState = null;
        this._visitables.get("lastState").remove(this.lastState);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public LastStateNested<A> withNewLastState() {
    return new LastStateNested(null);
  }
  
  public LastStateNested<A> withNewLastStateLike(ContainerState item) {
    return new LastStateNested(item);
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public StateNested<A> withNewState() {
    return new StateNested(null);
  }
  
  public StateNested<A> withNewStateLike(ContainerState item) {
    return new StateNested(item);
  }
  
  public UserNested<A> withNewUser() {
    return new UserNested(null);
  }
  
  public UserNested<A> withNewUserLike(ContainerUser item) {
    return new UserNested(item);
  }
  
  public A withReady() {
    return withReady(true);
  }
  
  public A withReady(Boolean ready) {
    this.ready = ready;
    return (A) this;
  }
  
  public A withResources(ResourceRequirements resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new ResourceRequirementsBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withRestartCount(Integer restartCount) {
    this.restartCount = restartCount;
    return (A) this;
  }
  
  public A withStarted() {
    return withStarted(true);
  }
  
  public A withStarted(Boolean started) {
    this.started = started;
    return (A) this;
  }
  
  public A withState(ContainerState state) {
    this._visitables.remove("state");
    if (state != null) {
        this.state = new ContainerStateBuilder(state);
        this._visitables.get("state").add(this.state);
    } else {
        this.state = null;
        this._visitables.get("state").remove(this.state);
    }
    return (A) this;
  }
  
  public A withStopSignal(String stopSignal) {
    this.stopSignal = stopSignal;
    return (A) this;
  }
  
  public A withUser(ContainerUser user) {
    this._visitables.remove("user");
    if (user != null) {
        this.user = new ContainerUserBuilder(user);
        this._visitables.get("user").add(this.user);
    } else {
        this.user = null;
        this._visitables.get("user").remove(this.user);
    }
    return (A) this;
  }
  
  public A withVolumeMounts(List<VolumeMountStatus> volumeMounts) {
    if (this.volumeMounts != null) {
      this._visitables.get("volumeMounts").clear();
    }
    if (volumeMounts != null) {
        this.volumeMounts = new ArrayList();
        for (VolumeMountStatus item : volumeMounts) {
          this.addToVolumeMounts(item);
        }
    } else {
      this.volumeMounts = null;
    }
    return (A) this;
  }
  
  public A withVolumeMounts(VolumeMountStatus... volumeMounts) {
    if (this.volumeMounts != null) {
        this.volumeMounts.clear();
        _visitables.remove("volumeMounts");
    }
    if (volumeMounts != null) {
      for (VolumeMountStatus item : volumeMounts) {
        this.addToVolumeMounts(item);
      }
    }
    return (A) this;
  }
  public class AllocatedResourcesStatusNested<N> extends ResourceStatusFluent<AllocatedResourcesStatusNested<N>> implements Nested<N>{
  
    ResourceStatusBuilder builder;
    int index;
  
    AllocatedResourcesStatusNested(int index,ResourceStatus item) {
      this.index = index;
      this.builder = new ResourceStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerStatusFluent.this.setToAllocatedResourcesStatus(index, builder.build());
    }
    
    public N endAllocatedResourcesStatus() {
      return and();
    }
    
  }
  public class LastStateNested<N> extends ContainerStateFluent<LastStateNested<N>> implements Nested<N>{
  
    ContainerStateBuilder builder;
  
    LastStateNested(ContainerState item) {
      this.builder = new ContainerStateBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerStatusFluent.this.withLastState(builder.build());
    }
    
    public N endLastState() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerStatusFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class StateNested<N> extends ContainerStateFluent<StateNested<N>> implements Nested<N>{
  
    ContainerStateBuilder builder;
  
    StateNested(ContainerState item) {
      this.builder = new ContainerStateBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerStatusFluent.this.withState(builder.build());
    }
    
    public N endState() {
      return and();
    }
    
  }
  public class UserNested<N> extends ContainerUserFluent<UserNested<N>> implements Nested<N>{
  
    ContainerUserBuilder builder;
  
    UserNested(ContainerUser item) {
      this.builder = new ContainerUserBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerStatusFluent.this.withUser(builder.build());
    }
    
    public N endUser() {
      return and();
    }
    
  }
  public class VolumeMountsNested<N> extends VolumeMountStatusFluent<VolumeMountsNested<N>> implements Nested<N>{
  
    VolumeMountStatusBuilder builder;
    int index;
  
    VolumeMountsNested(int index,VolumeMountStatus item) {
      this.index = index;
      this.builder = new VolumeMountStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerStatusFluent.this.setToVolumeMounts(index, builder.build());
    }
    
    public N endVolumeMount() {
      return and();
    }
    
  }
}