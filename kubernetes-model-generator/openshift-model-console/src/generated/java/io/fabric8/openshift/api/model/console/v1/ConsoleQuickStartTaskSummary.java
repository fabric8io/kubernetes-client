
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
 * ConsoleQuickStartTaskSummary contains information about a passed step.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "failed",
    "success"
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
public class ConsoleQuickStartTaskSummary implements Editable<ConsoleQuickStartTaskSummaryBuilder>, KubernetesResource
{

    @JsonProperty("failed")
    private String failed;
    @JsonProperty("success")
    private String success;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleQuickStartTaskSummary() {
    }

    public ConsoleQuickStartTaskSummary(String failed, String success) {
        super();
        this.failed = failed;
        this.success = success;
    }

    /**
     * failed briefly describes the unsuccessfully passed task. (includes markdown)
     */
    @JsonProperty("failed")
    public String getFailed() {
        return failed;
    }

    /**
     * failed briefly describes the unsuccessfully passed task. (includes markdown)
     */
    @JsonProperty("failed")
    public void setFailed(String failed) {
        this.failed = failed;
    }

    /**
     * success describes the succesfully passed task.
     */
    @JsonProperty("success")
    public String getSuccess() {
        return success;
    }

    /**
     * success describes the succesfully passed task.
     */
    @JsonProperty("success")
    public void setSuccess(String success) {
        this.success = success;
    }

    @JsonIgnore
    public ConsoleQuickStartTaskSummaryBuilder edit() {
        return new ConsoleQuickStartTaskSummaryBuilder(this);
    }

    @JsonIgnore
    public ConsoleQuickStartTaskSummaryBuilder toBuilder() {
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
        if (!(o instanceof ConsoleQuickStartTaskSummary)) {
            return false;
        }
        ConsoleQuickStartTaskSummary other = (ConsoleQuickStartTaskSummary) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$failed = this.getFailed();
        Object other$failed = other.getFailed();
        if (this$failed == null ? other$failed != null : !this$failed.equals(other$failed)) {
            return false;
        }
        Object this$success = this.getSuccess();
        Object other$success = other.getSuccess();
        if (this$success == null ? other$success != null : !this$success.equals(other$success)) {
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
        return other instanceof ConsoleQuickStartTaskSummary;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $failed = this.getFailed();
        result = result * prime + ($failed == null ? 43 : $failed.hashCode());
        Object $success = this.getSuccess();
        result = result * prime + ($success == null ? 43 : $success.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConsoleQuickStartTaskSummary(" + "failed=" + this.getFailed() + ", success=" + this.getSuccess() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
