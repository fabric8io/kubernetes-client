
package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

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
 * WorkloadReference references the Workload object together with the template that was used to create a particular PodGroup.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "templateName",
    "workloadName"
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
public class WorkloadReference implements Editable<WorkloadReferenceBuilder>, KubernetesResource
{

    @JsonProperty("templateName")
    private String templateName;
    @JsonProperty("workloadName")
    private String workloadName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WorkloadReference() {
    }

    public WorkloadReference(String templateName, String workloadName) {
        super();
        this.templateName = templateName;
        this.workloadName = workloadName;
    }

    /**
     * templateName is the name of a template within the Workload object that was used to create a pod group. It must be a DNS label. This field is required.
     */
    @JsonProperty("templateName")
    public String getTemplateName() {
        return templateName;
    }

    /**
     * templateName is the name of a template within the Workload object that was used to create a pod group. It must be a DNS label. This field is required.
     */
    @JsonProperty("templateName")
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * workloadName is the name of the Workload object that contains a template that was used when creating a pod group. It must be a DNS name. This field is required.
     */
    @JsonProperty("workloadName")
    public String getWorkloadName() {
        return workloadName;
    }

    /**
     * workloadName is the name of the Workload object that contains a template that was used when creating a pod group. It must be a DNS name. This field is required.
     */
    @JsonProperty("workloadName")
    public void setWorkloadName(String workloadName) {
        this.workloadName = workloadName;
    }

    @JsonIgnore
    public WorkloadReferenceBuilder edit() {
        return new WorkloadReferenceBuilder(this);
    }

    @JsonIgnore
    public WorkloadReferenceBuilder toBuilder() {
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
        if (!(o instanceof WorkloadReference)) {
            return false;
        }
        WorkloadReference other = (WorkloadReference) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$templateName = this.getTemplateName();
        Object other$templateName = other.getTemplateName();
        if (this$templateName == null ? other$templateName != null : !this$templateName.equals(other$templateName)) {
            return false;
        }
        Object this$workloadName = this.getWorkloadName();
        Object other$workloadName = other.getWorkloadName();
        if (this$workloadName == null ? other$workloadName != null : !this$workloadName.equals(other$workloadName)) {
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
        return other instanceof WorkloadReference;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $templateName = this.getTemplateName();
        result = result * prime + ($templateName == null ? 43 : $templateName.hashCode());
        Object $workloadName = this.getWorkloadName();
        result = result * prime + ($workloadName == null ? 43 : $workloadName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WorkloadReference(" + "templateName=" + this.getTemplateName() + ", workloadName=" + this.getWorkloadName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
