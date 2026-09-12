
package io.fabric8.volcano.api.model.flow.v1alpha1;

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
 * JobTemplateStatus defines the observed state of JobTemplate
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "jobDependsOnList"
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
public class JobTemplateStatus implements Editable<JobTemplateStatusBuilder>, KubernetesResource
{

    @JsonProperty("jobDependsOnList")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> jobDependsOnList = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JobTemplateStatus() {
    }

    public JobTemplateStatus(List<String> jobDependsOnList) {
        super();
        this.jobDependsOnList = jobDependsOnList;
    }

    /**
     * Describes the Jobs generated from the JobTemplate
     */
    @JsonProperty("jobDependsOnList")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getJobDependsOnList() {
        return jobDependsOnList;
    }

    /**
     * Describes the Jobs generated from the JobTemplate
     */
    @JsonProperty("jobDependsOnList")
    public void setJobDependsOnList(List<String> jobDependsOnList) {
        this.jobDependsOnList = jobDependsOnList;
    }

    @JsonIgnore
    public JobTemplateStatusBuilder edit() {
        return new JobTemplateStatusBuilder(this);
    }

    @JsonIgnore
    public JobTemplateStatusBuilder toBuilder() {
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
        if (!(o instanceof JobTemplateStatus)) {
            return false;
        }
        JobTemplateStatus other = (JobTemplateStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$jobDependsOnList = this.getJobDependsOnList();
        Object other$jobDependsOnList = other.getJobDependsOnList();
        if (this$jobDependsOnList == null ? other$jobDependsOnList != null : !this$jobDependsOnList.equals(other$jobDependsOnList)) {
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
        return other instanceof JobTemplateStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $jobDependsOnList = this.getJobDependsOnList();
        result = result * prime + ($jobDependsOnList == null ? 43 : $jobDependsOnList.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "JobTemplateStatus(" + "jobDependsOnList=" + this.getJobDependsOnList() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
