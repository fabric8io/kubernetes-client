
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deleteAction",
    "force"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DetachedAnnotationArguments implements Editable<DetachedAnnotationArgumentsBuilder>, KubernetesResource
{

    @JsonProperty("deleteAction")
    private String deleteAction;
    @JsonProperty("force")
    private Boolean force;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DetachedAnnotationArguments() {
    }

    public DetachedAnnotationArguments(String deleteAction, Boolean force) {
        super();
        this.deleteAction = deleteAction;
        this.force = force;
    }

    /**
     * DeleteAction indicates the desired delete logic when the detached annotation is present
     */
    @JsonProperty("deleteAction")
    public String getDeleteAction() {
        return deleteAction;
    }

    /**
     * DeleteAction indicates the desired delete logic when the detached annotation is present
     */
    @JsonProperty("deleteAction")
    public void setDeleteAction(String deleteAction) {
        this.deleteAction = deleteAction;
    }

    /**
     * Force indicates if detaching should be forced regardless of the host's state
     */
    @JsonProperty("force")
    public Boolean getForce() {
        return force;
    }

    /**
     * Force indicates if detaching should be forced regardless of the host's state
     */
    @JsonProperty("force")
    public void setForce(Boolean force) {
        this.force = force;
    }

    @JsonIgnore
    public DetachedAnnotationArgumentsBuilder edit() {
        return new DetachedAnnotationArgumentsBuilder(this);
    }

    @JsonIgnore
    public DetachedAnnotationArgumentsBuilder toBuilder() {
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
        if (!(o instanceof DetachedAnnotationArguments)) {
            return false;
        }
        DetachedAnnotationArguments other = (DetachedAnnotationArguments) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$deleteAction = this.getDeleteAction();
        Object other$deleteAction = other.getDeleteAction();
        if (this$deleteAction == null ? other$deleteAction != null : !this$deleteAction.equals(other$deleteAction)) {
            return false;
        }
        Object this$force = this.getForce();
        Object other$force = other.getForce();
        if (this$force == null ? other$force != null : !this$force.equals(other$force)) {
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
        return other instanceof DetachedAnnotationArguments;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $deleteAction = this.getDeleteAction();
        result = result * prime + ($deleteAction == null ? 43 : $deleteAction.hashCode());
        Object $force = this.getForce();
        result = result * prime + ($force == null ? 43 : $force.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DetachedAnnotationArguments(" + "deleteAction=" + this.getDeleteAction() + ", force=" + this.getForce() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
