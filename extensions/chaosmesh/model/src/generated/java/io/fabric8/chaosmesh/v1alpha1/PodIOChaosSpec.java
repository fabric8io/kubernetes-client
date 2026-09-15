
package io.fabric8.chaosmesh.v1alpha1;

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
 * PodIOChaosSpec defines the desired state of IOChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actions",
    "container",
    "volumeMountPath"
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
public class PodIOChaosSpec implements Editable<PodIOChaosSpecBuilder>, KubernetesResource
{

    @JsonProperty("actions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IOChaosAction> actions = new ArrayList<>();
    @JsonProperty("container")
    private String container;
    @JsonProperty("volumeMountPath")
    private String volumeMountPath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodIOChaosSpec() {
    }

    public PodIOChaosSpec(List<IOChaosAction> actions, String container, String volumeMountPath) {
        super();
        this.actions = actions;
        this.container = container;
        this.volumeMountPath = volumeMountPath;
    }

    /**
     * Actions are a list of IOChaos actions
     */
    @JsonProperty("actions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IOChaosAction> getActions() {
        return actions;
    }

    /**
     * Actions are a list of IOChaos actions
     */
    @JsonProperty("actions")
    public void setActions(List<IOChaosAction> actions) {
        this.actions = actions;
    }

    /**
     * PodIOChaosSpec defines the desired state of IOChaos
     */
    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    /**
     * PodIOChaosSpec defines the desired state of IOChaos
     */
    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * VolumeMountPath represents the target mount path It must be a root of mount path now.
     */
    @JsonProperty("volumeMountPath")
    public String getVolumeMountPath() {
        return volumeMountPath;
    }

    /**
     * VolumeMountPath represents the target mount path It must be a root of mount path now.
     */
    @JsonProperty("volumeMountPath")
    public void setVolumeMountPath(String volumeMountPath) {
        this.volumeMountPath = volumeMountPath;
    }

    @JsonIgnore
    public PodIOChaosSpecBuilder edit() {
        return new PodIOChaosSpecBuilder(this);
    }

    @JsonIgnore
    public PodIOChaosSpecBuilder toBuilder() {
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
        if (!(o instanceof PodIOChaosSpec)) {
            return false;
        }
        PodIOChaosSpec other = (PodIOChaosSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$actions = this.getActions();
        Object other$actions = other.getActions();
        if (this$actions == null ? other$actions != null : !this$actions.equals(other$actions)) {
            return false;
        }
        Object this$container = this.getContainer();
        Object other$container = other.getContainer();
        if (this$container == null ? other$container != null : !this$container.equals(other$container)) {
            return false;
        }
        Object this$volumeMountPath = this.getVolumeMountPath();
        Object other$volumeMountPath = other.getVolumeMountPath();
        if (this$volumeMountPath == null ? other$volumeMountPath != null : !this$volumeMountPath.equals(other$volumeMountPath)) {
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
        return other instanceof PodIOChaosSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $actions = this.getActions();
        result = result * prime + ($actions == null ? 43 : $actions.hashCode());
        Object $container = this.getContainer();
        result = result * prime + ($container == null ? 43 : $container.hashCode());
        Object $volumeMountPath = this.getVolumeMountPath();
        result = result * prime + ($volumeMountPath == null ? 43 : $volumeMountPath.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodIOChaosSpec(" + "actions=" + this.getActions() + ", container=" + this.getContainer() + ", volumeMountPath=" + this.getVolumeMountPath() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
