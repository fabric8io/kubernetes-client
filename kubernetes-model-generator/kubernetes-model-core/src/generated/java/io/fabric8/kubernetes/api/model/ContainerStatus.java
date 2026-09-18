
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;

/**
 * ContainerStatus contains details for the current status of this container.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocatedResources",
    "allocatedResourcesStatus",
    "containerID",
    "image",
    "imageID",
    "lastState",
    "name",
    "ready",
    "resources",
    "restartCount",
    "started",
    "state",
    "stopSignal",
    "user",
    "volumeMounts"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerStatus implements Editable<ContainerStatusBuilder>, KubernetesResource
{

    @JsonProperty("allocatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> allocatedResources = new LinkedHashMap<>();
    @JsonProperty("allocatedResourcesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceStatus> allocatedResourcesStatus = new ArrayList<>();
    @JsonProperty("containerID")
    private String containerID;
    @JsonProperty("image")
    private String image;
    @JsonProperty("imageID")
    private String imageID;
    @JsonProperty("lastState")
    private ContainerState lastState;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("restartCount")
    private Integer restartCount;
    @JsonProperty("started")
    private Boolean started;
    @JsonProperty("state")
    private ContainerState state;
    @JsonProperty("stopSignal")
    private String stopSignal;
    @JsonProperty("user")
    private ContainerUser user;
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeMountStatus> volumeMounts = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerStatus() {
    }

    public ContainerStatus(Map<String, Quantity> allocatedResources, List<ResourceStatus> allocatedResourcesStatus, String containerID, String image, String imageID, ContainerState lastState, String name, Boolean ready, ResourceRequirements resources, Integer restartCount, Boolean started, ContainerState state, String stopSignal, ContainerUser user, List<VolumeMountStatus> volumeMounts) {
        super();
        this.allocatedResources = allocatedResources;
        this.allocatedResourcesStatus = allocatedResourcesStatus;
        this.containerID = containerID;
        this.image = image;
        this.imageID = imageID;
        this.lastState = lastState;
        this.name = name;
        this.ready = ready;
        this.resources = resources;
        this.restartCount = restartCount;
        this.started = started;
        this.state = state;
        this.stopSignal = stopSignal;
        this.user = user;
        this.volumeMounts = volumeMounts;
    }

    /**
     * AllocatedResources represents the compute resources allocated for this container by the node. Kubelet sets this value to Container.Resources.Requests upon successful pod admission and after successfully admitting desired pod resize.
     */
    @JsonProperty("allocatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getAllocatedResources() {
        return allocatedResources;
    }

    /**
     * AllocatedResources represents the compute resources allocated for this container by the node. Kubelet sets this value to Container.Resources.Requests upon successful pod admission and after successfully admitting desired pod resize.
     */
    @JsonProperty("allocatedResources")
    public void setAllocatedResources(Map<String, Quantity> allocatedResources) {
        this.allocatedResources = allocatedResources;
    }

    /**
     * AllocatedResourcesStatus represents the status of various resources allocated for this Pod.
     */
    @JsonProperty("allocatedResourcesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceStatus> getAllocatedResourcesStatus() {
        return allocatedResourcesStatus;
    }

    /**
     * AllocatedResourcesStatus represents the status of various resources allocated for this Pod.
     */
    @JsonProperty("allocatedResourcesStatus")
    public void setAllocatedResourcesStatus(List<ResourceStatus> allocatedResourcesStatus) {
        this.allocatedResourcesStatus = allocatedResourcesStatus;
    }

    /**
     * ContainerID is the ID of the container in the format '&lt;type&gt;://&lt;container_id&gt;'. Where type is a container runtime identifier, returned from Version call of CRI API (for example "containerd").
     */
    @JsonProperty("containerID")
    public String getContainerID() {
        return containerID;
    }

    /**
     * ContainerID is the ID of the container in the format '&lt;type&gt;://&lt;container_id&gt;'. Where type is a container runtime identifier, returned from Version call of CRI API (for example "containerd").
     */
    @JsonProperty("containerID")
    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    /**
     * Image is the name of container image that the container is running. The container image may not match the image used in the PodSpec, as it may have been resolved by the runtime. More info: https://kubernetes.io/docs/concepts/containers/images.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * Image is the name of container image that the container is running. The container image may not match the image used in the PodSpec, as it may have been resolved by the runtime. More info: https://kubernetes.io/docs/concepts/containers/images.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * ImageID is the image ID of the container's image. The image ID may not match the image ID of the image used in the PodSpec, as it may have been resolved by the runtime.
     */
    @JsonProperty("imageID")
    public String getImageID() {
        return imageID;
    }

    /**
     * ImageID is the image ID of the container's image. The image ID may not match the image ID of the image used in the PodSpec, as it may have been resolved by the runtime.
     */
    @JsonProperty("imageID")
    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    /**
     * ContainerStatus contains details for the current status of this container.
     */
    @JsonProperty("lastState")
    public ContainerState getLastState() {
        return lastState;
    }

    /**
     * ContainerStatus contains details for the current status of this container.
     */
    @JsonProperty("lastState")
    public void setLastState(ContainerState lastState) {
        this.lastState = lastState;
    }

    /**
     * Name is a DNS_LABEL representing the unique name of the container. Each container in a pod must have a unique name across all container types. Cannot be updated.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is a DNS_LABEL representing the unique name of the container. Each container in a pod must have a unique name across all container types. Cannot be updated.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Ready specifies whether the container is currently passing its readiness check. The value will change as readiness probes keep executing. If no readiness probes are specified, this field defaults to true once the container is fully started (see Started field).<br><p> <br><p> The value is typically used to determine whether a container is ready to accept traffic.
     */
    @JsonProperty("ready")
    public Boolean getReady() {
        return ready;
    }

    /**
     * Ready specifies whether the container is currently passing its readiness check. The value will change as readiness probes keep executing. If no readiness probes are specified, this field defaults to true once the container is fully started (see Started field).<br><p> <br><p> The value is typically used to determine whether a container is ready to accept traffic.
     */
    @JsonProperty("ready")
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    /**
     * ContainerStatus contains details for the current status of this container.
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * ContainerStatus contains details for the current status of this container.
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * RestartCount holds the number of times the container has been restarted. Kubelet makes an effort to always increment the value, but there are cases when the state may be lost due to node restarts and then the value may be reset to 0. The value is never negative.
     */
    @JsonProperty("restartCount")
    public Integer getRestartCount() {
        return restartCount;
    }

    /**
     * RestartCount holds the number of times the container has been restarted. Kubelet makes an effort to always increment the value, but there are cases when the state may be lost due to node restarts and then the value may be reset to 0. The value is never negative.
     */
    @JsonProperty("restartCount")
    public void setRestartCount(Integer restartCount) {
        this.restartCount = restartCount;
    }

    /**
     * Started indicates whether the container has finished its postStart lifecycle hook and passed its startup probe. Initialized as false, becomes true after startupProbe is considered successful. Resets to false when the container is restarted, or if kubelet loses state temporarily. In both cases, startup probes will run again. Is always true when no startupProbe is defined and container is running and has passed the postStart lifecycle hook. The null value must be treated the same as false.
     */
    @JsonProperty("started")
    public Boolean getStarted() {
        return started;
    }

    /**
     * Started indicates whether the container has finished its postStart lifecycle hook and passed its startup probe. Initialized as false, becomes true after startupProbe is considered successful. Resets to false when the container is restarted, or if kubelet loses state temporarily. In both cases, startup probes will run again. Is always true when no startupProbe is defined and container is running and has passed the postStart lifecycle hook. The null value must be treated the same as false.
     */
    @JsonProperty("started")
    public void setStarted(Boolean started) {
        this.started = started;
    }

    /**
     * ContainerStatus contains details for the current status of this container.
     */
    @JsonProperty("state")
    public ContainerState getState() {
        return state;
    }

    /**
     * ContainerStatus contains details for the current status of this container.
     */
    @JsonProperty("state")
    public void setState(ContainerState state) {
        this.state = state;
    }

    /**
     * StopSignal reports the effective stop signal for this container
     */
    @JsonProperty("stopSignal")
    public String getStopSignal() {
        return stopSignal;
    }

    /**
     * StopSignal reports the effective stop signal for this container
     */
    @JsonProperty("stopSignal")
    public void setStopSignal(String stopSignal) {
        this.stopSignal = stopSignal;
    }

    /**
     * ContainerStatus contains details for the current status of this container.
     */
    @JsonProperty("user")
    public ContainerUser getUser() {
        return user;
    }

    /**
     * ContainerStatus contains details for the current status of this container.
     */
    @JsonProperty("user")
    public void setUser(ContainerUser user) {
        this.user = user;
    }

    /**
     * Status of volume mounts.
     */
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeMountStatus> getVolumeMounts() {
        return volumeMounts;
    }

    /**
     * Status of volume mounts.
     */
    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMountStatus> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    @JsonIgnore
    public ContainerStatusBuilder edit() {
        return new ContainerStatusBuilder(this);
    }

    @JsonIgnore
    public ContainerStatusBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ContainerStatus)) {
            return false;
        }
        ContainerStatus other = (ContainerStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allocatedResources = this.getAllocatedResources();
        Object other$allocatedResources = other.getAllocatedResources();
        if (this$allocatedResources == null ? other$allocatedResources != null : !this$allocatedResources.equals(other$allocatedResources)) {
            return false;
        }
        Object this$allocatedResourcesStatus = this.getAllocatedResourcesStatus();
        Object other$allocatedResourcesStatus = other.getAllocatedResourcesStatus();
        if (this$allocatedResourcesStatus == null ? other$allocatedResourcesStatus != null : !this$allocatedResourcesStatus.equals(other$allocatedResourcesStatus)) {
            return false;
        }
        Object this$containerID = this.getContainerID();
        Object other$containerID = other.getContainerID();
        if (this$containerID == null ? other$containerID != null : !this$containerID.equals(other$containerID)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$imageID = this.getImageID();
        Object other$imageID = other.getImageID();
        if (this$imageID == null ? other$imageID != null : !this$imageID.equals(other$imageID)) {
            return false;
        }
        Object this$lastState = this.getLastState();
        Object other$lastState = other.getLastState();
        if (this$lastState == null ? other$lastState != null : !this$lastState.equals(other$lastState)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$ready = this.getReady();
        Object other$ready = other.getReady();
        if (this$ready == null ? other$ready != null : !this$ready.equals(other$ready)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$restartCount = this.getRestartCount();
        Object other$restartCount = other.getRestartCount();
        if (this$restartCount == null ? other$restartCount != null : !this$restartCount.equals(other$restartCount)) {
            return false;
        }
        Object this$started = this.getStarted();
        Object other$started = other.getStarted();
        if (this$started == null ? other$started != null : !this$started.equals(other$started)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
            return false;
        }
        Object this$stopSignal = this.getStopSignal();
        Object other$stopSignal = other.getStopSignal();
        if (this$stopSignal == null ? other$stopSignal != null : !this$stopSignal.equals(other$stopSignal)) {
            return false;
        }
        Object this$user = this.getUser();
        Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) {
            return false;
        }
        Object this$volumeMounts = this.getVolumeMounts();
        Object other$volumeMounts = other.getVolumeMounts();
        if (this$volumeMounts == null ? other$volumeMounts != null : !this$volumeMounts.equals(other$volumeMounts)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ContainerStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allocatedResources = this.getAllocatedResources();
        result = result * prime + ($allocatedResources == null ? 43 : $allocatedResources.hashCode());
        Object $allocatedResourcesStatus = this.getAllocatedResourcesStatus();
        result = result * prime + ($allocatedResourcesStatus == null ? 43 : $allocatedResourcesStatus.hashCode());
        Object $containerID = this.getContainerID();
        result = result * prime + ($containerID == null ? 43 : $containerID.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $imageID = this.getImageID();
        result = result * prime + ($imageID == null ? 43 : $imageID.hashCode());
        Object $lastState = this.getLastState();
        result = result * prime + ($lastState == null ? 43 : $lastState.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $ready = this.getReady();
        result = result * prime + ($ready == null ? 43 : $ready.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $restartCount = this.getRestartCount();
        result = result * prime + ($restartCount == null ? 43 : $restartCount.hashCode());
        Object $started = this.getStarted();
        result = result * prime + ($started == null ? 43 : $started.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $stopSignal = this.getStopSignal();
        result = result * prime + ($stopSignal == null ? 43 : $stopSignal.hashCode());
        Object $user = this.getUser();
        result = result * prime + ($user == null ? 43 : $user.hashCode());
        Object $volumeMounts = this.getVolumeMounts();
        result = result * prime + ($volumeMounts == null ? 43 : $volumeMounts.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ContainerStatus(" + "allocatedResources=" + this.getAllocatedResources() + ", allocatedResourcesStatus=" + this.getAllocatedResourcesStatus() + ", containerID=" + this.getContainerID() + ", image=" + this.getImage() + ", imageID=" + this.getImageID() + ", lastState=" + this.getLastState() + ", name=" + this.getName() + ", ready=" + this.getReady() + ", resources=" + this.getResources() + ", restartCount=" + this.getRestartCount() + ", started=" + this.getStarted() + ", state=" + this.getState() + ", stopSignal=" + this.getStopSignal() + ", user=" + this.getUser() + ", volumeMounts=" + this.getVolumeMounts() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
