
package io.fabric8.openshift.api.model.console.v1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ConsoleQuickStartTaskReview contains instructions that validate a task was completed successfully.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "failedTaskHelp",
    "instructions"
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
public class ConsoleQuickStartTaskReview implements Editable<ConsoleQuickStartTaskReviewBuilder>, KubernetesResource
{

    @JsonProperty("failedTaskHelp")
    private String failedTaskHelp;
    @JsonProperty("instructions")
    private String instructions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleQuickStartTaskReview() {
    }

    public ConsoleQuickStartTaskReview(String failedTaskHelp, String instructions) {
        super();
        this.failedTaskHelp = failedTaskHelp;
        this.instructions = instructions;
    }

    /**
     * failedTaskHelp contains suggestions for a failed task review and is shown at the end of task. (includes markdown)
     */
    @JsonProperty("failedTaskHelp")
    public String getFailedTaskHelp() {
        return failedTaskHelp;
    }

    /**
     * failedTaskHelp contains suggestions for a failed task review and is shown at the end of task. (includes markdown)
     */
    @JsonProperty("failedTaskHelp")
    public void setFailedTaskHelp(String failedTaskHelp) {
        this.failedTaskHelp = failedTaskHelp;
    }

    /**
     * instructions contains steps that user needs to take in order to validate his work after going through a task. (includes markdown)
     */
    @JsonProperty("instructions")
    public String getInstructions() {
        return instructions;
    }

    /**
     * instructions contains steps that user needs to take in order to validate his work after going through a task. (includes markdown)
     */
    @JsonProperty("instructions")
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @JsonIgnore
    public ConsoleQuickStartTaskReviewBuilder edit() {
        return new ConsoleQuickStartTaskReviewBuilder(this);
    }

    @JsonIgnore
    public ConsoleQuickStartTaskReviewBuilder toBuilder() {
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
        if (!(o instanceof ConsoleQuickStartTaskReview)) {
            return false;
        }
        ConsoleQuickStartTaskReview other = (ConsoleQuickStartTaskReview) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$failedTaskHelp = this.getFailedTaskHelp();
        Object other$failedTaskHelp = other.getFailedTaskHelp();
        if (this$failedTaskHelp == null ? other$failedTaskHelp != null : !this$failedTaskHelp.equals(other$failedTaskHelp)) {
            return false;
        }
        Object this$instructions = this.getInstructions();
        Object other$instructions = other.getInstructions();
        if (this$instructions == null ? other$instructions != null : !this$instructions.equals(other$instructions)) {
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
        return other instanceof ConsoleQuickStartTaskReview;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $failedTaskHelp = this.getFailedTaskHelp();
        result = result * prime + ($failedTaskHelp == null ? 43 : $failedTaskHelp.hashCode());
        Object $instructions = this.getInstructions();
        result = result * prime + ($instructions == null ? 43 : $instructions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConsoleQuickStartTaskReview(" + "failedTaskHelp=" + this.getFailedTaskHelp() + ", instructions=" + this.getInstructions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
