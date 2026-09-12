
package io.fabric8.tekton.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.ContainerStateRunning;
import io.fabric8.kubernetes.api.model.ContainerStateTerminated;
import io.fabric8.kubernetes.api.model.ContainerStateWaiting;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * SidecarState reports the results of running a sidecar in a Task.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "container",
    "imageID",
    "name",
    "running",
    "terminated",
    "waiting"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SidecarState implements Editable<SidecarStateBuilder>, KubernetesResource
{

    @JsonProperty("container")
    private String container;
    @JsonProperty("imageID")
    private String imageID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("running")
    private ContainerStateRunning running;
    @JsonProperty("terminated")
    private ContainerStateTerminated terminated;
    @JsonProperty("waiting")
    private ContainerStateWaiting waiting;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SidecarState() {
    }

    public SidecarState(String container, String imageID, String name, ContainerStateRunning running, ContainerStateTerminated terminated, ContainerStateWaiting waiting) {
        super();
        this.container = container;
        this.imageID = imageID;
        this.name = name;
        this.running = running;
        this.terminated = terminated;
        this.waiting = waiting;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("imageID")
    public String getImageID() {
        return imageID;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("imageID")
    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("running")
    public ContainerStateRunning getRunning() {
        return running;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("running")
    public void setRunning(ContainerStateRunning running) {
        this.running = running;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("terminated")
    public ContainerStateTerminated getTerminated() {
        return terminated;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("terminated")
    public void setTerminated(ContainerStateTerminated terminated) {
        this.terminated = terminated;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("waiting")
    public ContainerStateWaiting getWaiting() {
        return waiting;
    }

    /**
     * SidecarState reports the results of running a sidecar in a Task.
     */
    @JsonProperty("waiting")
    public void setWaiting(ContainerStateWaiting waiting) {
        this.waiting = waiting;
    }

    @JsonIgnore
    public SidecarStateBuilder edit() {
        return new SidecarStateBuilder(this);
    }

    @JsonIgnore
    public SidecarStateBuilder toBuilder() {
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
        if (!(o instanceof SidecarState)) {
            return false;
        }
        SidecarState other = (SidecarState) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$container = this.getContainer();
        Object other$container = other.getContainer();
        if (this$container == null ? other$container != null : !this$container.equals(other$container)) {
            return false;
        }
        Object this$imageID = this.getImageID();
        Object other$imageID = other.getImageID();
        if (this$imageID == null ? other$imageID != null : !this$imageID.equals(other$imageID)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$running = this.getRunning();
        Object other$running = other.getRunning();
        if (this$running == null ? other$running != null : !this$running.equals(other$running)) {
            return false;
        }
        Object this$terminated = this.getTerminated();
        Object other$terminated = other.getTerminated();
        if (this$terminated == null ? other$terminated != null : !this$terminated.equals(other$terminated)) {
            return false;
        }
        Object this$waiting = this.getWaiting();
        Object other$waiting = other.getWaiting();
        if (this$waiting == null ? other$waiting != null : !this$waiting.equals(other$waiting)) {
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
        return other instanceof SidecarState;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $container = this.getContainer();
        result = result * prime + ($container == null ? 43 : $container.hashCode());
        Object $imageID = this.getImageID();
        result = result * prime + ($imageID == null ? 43 : $imageID.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $running = this.getRunning();
        result = result * prime + ($running == null ? 43 : $running.hashCode());
        Object $terminated = this.getTerminated();
        result = result * prime + ($terminated == null ? 43 : $terminated.hashCode());
        Object $waiting = this.getWaiting();
        result = result * prime + ($waiting == null ? 43 : $waiting.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SidecarState(" + "container=" + this.getContainer() + ", imageID=" + this.getImageID() + ", name=" + this.getName() + ", running=" + this.getRunning() + ", terminated=" + this.getTerminated() + ", waiting=" + this.getWaiting() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
