
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
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
 * DeploymentTriggerImageChangeParams represents the parameters to the ImageChange trigger.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "automatic",
    "containerNames",
    "from",
    "lastTriggeredImage"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DeploymentTriggerImageChangeParams implements Editable<DeploymentTriggerImageChangeParamsBuilder>, KubernetesResource
{

    @JsonProperty("automatic")
    private Boolean automatic;
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> containerNames = new ArrayList<>();
    @JsonProperty("from")
    private ObjectReference from;
    @JsonProperty("lastTriggeredImage")
    private String lastTriggeredImage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeploymentTriggerImageChangeParams() {
    }

    public DeploymentTriggerImageChangeParams(Boolean automatic, List<String> containerNames, ObjectReference from, String lastTriggeredImage) {
        super();
        this.automatic = automatic;
        this.containerNames = containerNames;
        this.from = from;
        this.lastTriggeredImage = lastTriggeredImage;
    }

    /**
     * automatic means that the detection of a new tag value should result in an image update inside the pod template.
     */
    @JsonProperty("automatic")
    public Boolean getAutomatic() {
        return automatic;
    }

    /**
     * automatic means that the detection of a new tag value should result in an image update inside the pod template.
     */
    @JsonProperty("automatic")
    public void setAutomatic(Boolean automatic) {
        this.automatic = automatic;
    }

    /**
     * containerNames is used to restrict tag updates to the specified set of container names in a pod. If multiple triggers point to the same containers, the resulting behavior is undefined. Future API versions will make this a validation error. If ContainerNames does not point to a valid container, the trigger will be ignored. Future API versions will make this a validation error.
     */
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getContainerNames() {
        return containerNames;
    }

    /**
     * containerNames is used to restrict tag updates to the specified set of container names in a pod. If multiple triggers point to the same containers, the resulting behavior is undefined. Future API versions will make this a validation error. If ContainerNames does not point to a valid container, the trigger will be ignored. Future API versions will make this a validation error.
     */
    @JsonProperty("containerNames")
    public void setContainerNames(List<String> containerNames) {
        this.containerNames = containerNames;
    }

    /**
     * DeploymentTriggerImageChangeParams represents the parameters to the ImageChange trigger.
     */
    @JsonProperty("from")
    public ObjectReference getFrom() {
        return from;
    }

    /**
     * DeploymentTriggerImageChangeParams represents the parameters to the ImageChange trigger.
     */
    @JsonProperty("from")
    public void setFrom(ObjectReference from) {
        this.from = from;
    }

    /**
     * lastTriggeredImage is the last image to be triggered.
     */
    @JsonProperty("lastTriggeredImage")
    public String getLastTriggeredImage() {
        return lastTriggeredImage;
    }

    /**
     * lastTriggeredImage is the last image to be triggered.
     */
    @JsonProperty("lastTriggeredImage")
    public void setLastTriggeredImage(String lastTriggeredImage) {
        this.lastTriggeredImage = lastTriggeredImage;
    }

    @JsonIgnore
    public DeploymentTriggerImageChangeParamsBuilder edit() {
        return new DeploymentTriggerImageChangeParamsBuilder(this);
    }

    @JsonIgnore
    public DeploymentTriggerImageChangeParamsBuilder toBuilder() {
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
        if (!(o instanceof DeploymentTriggerImageChangeParams)) {
            return false;
        }
        DeploymentTriggerImageChangeParams other = (DeploymentTriggerImageChangeParams) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$automatic = this.getAutomatic();
        Object other$automatic = other.getAutomatic();
        if (this$automatic == null ? other$automatic != null : !this$automatic.equals(other$automatic)) {
            return false;
        }
        Object this$containerNames = this.getContainerNames();
        Object other$containerNames = other.getContainerNames();
        if (this$containerNames == null ? other$containerNames != null : !this$containerNames.equals(other$containerNames)) {
            return false;
        }
        Object this$from = this.getFrom();
        Object other$from = other.getFrom();
        if (this$from == null ? other$from != null : !this$from.equals(other$from)) {
            return false;
        }
        Object this$lastTriggeredImage = this.getLastTriggeredImage();
        Object other$lastTriggeredImage = other.getLastTriggeredImage();
        if (this$lastTriggeredImage == null ? other$lastTriggeredImage != null : !this$lastTriggeredImage.equals(other$lastTriggeredImage)) {
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
        return other instanceof DeploymentTriggerImageChangeParams;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $automatic = this.getAutomatic();
        result = result * prime + ($automatic == null ? 43 : $automatic.hashCode());
        Object $containerNames = this.getContainerNames();
        result = result * prime + ($containerNames == null ? 43 : $containerNames.hashCode());
        Object $from = this.getFrom();
        result = result * prime + ($from == null ? 43 : $from.hashCode());
        Object $lastTriggeredImage = this.getLastTriggeredImage();
        result = result * prime + ($lastTriggeredImage == null ? 43 : $lastTriggeredImage.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeploymentTriggerImageChangeParams(" + "automatic=" + this.getAutomatic() + ", containerNames=" + this.getContainerNames() + ", from=" + this.getFrom() + ", lastTriggeredImage=" + this.getLastTriggeredImage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
