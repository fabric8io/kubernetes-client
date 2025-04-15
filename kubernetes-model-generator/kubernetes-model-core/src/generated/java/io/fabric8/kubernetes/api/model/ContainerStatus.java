
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    "user",
    "volumeMounts"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

    public ContainerStatus(Map<String, Quantity> allocatedResources, List<ResourceStatus> allocatedResourcesStatus, String containerID, String image, String imageID, ContainerState lastState, String name, Boolean ready, ResourceRequirements resources, Integer restartCount, Boolean started, ContainerState state, ContainerUser user, List<VolumeMountStatus> volumeMounts) {
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

}
