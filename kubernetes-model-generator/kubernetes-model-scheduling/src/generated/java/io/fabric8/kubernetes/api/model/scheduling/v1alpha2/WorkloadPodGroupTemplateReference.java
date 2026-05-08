
package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * WorkloadPodGroupTemplateReference references the PodGroupTemplate within the Workload object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "podGroupTemplateName",
    "workloadName"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
public class WorkloadPodGroupTemplateReference implements Editable<WorkloadPodGroupTemplateReferenceBuilder>, KubernetesResource
{

    @JsonProperty("podGroupTemplateName")
    private String podGroupTemplateName;
    @JsonProperty("workloadName")
    private String workloadName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WorkloadPodGroupTemplateReference() {
    }

    public WorkloadPodGroupTemplateReference(String podGroupTemplateName, String workloadName) {
        super();
        this.podGroupTemplateName = podGroupTemplateName;
        this.workloadName = workloadName;
    }

    /**
     * PodGroupTemplateName defines the PodGroupTemplate name within the Workload object.
     */
    @JsonProperty("podGroupTemplateName")
    public String getPodGroupTemplateName() {
        return podGroupTemplateName;
    }

    /**
     * PodGroupTemplateName defines the PodGroupTemplate name within the Workload object.
     */
    @JsonProperty("podGroupTemplateName")
    public void setPodGroupTemplateName(String podGroupTemplateName) {
        this.podGroupTemplateName = podGroupTemplateName;
    }

    /**
     * WorkloadName defines the name of the Workload object.
     */
    @JsonProperty("workloadName")
    public String getWorkloadName() {
        return workloadName;
    }

    /**
     * WorkloadName defines the name of the Workload object.
     */
    @JsonProperty("workloadName")
    public void setWorkloadName(String workloadName) {
        this.workloadName = workloadName;
    }

    @JsonIgnore
    public WorkloadPodGroupTemplateReferenceBuilder edit() {
        return new WorkloadPodGroupTemplateReferenceBuilder(this);
    }

    @JsonIgnore
    public WorkloadPodGroupTemplateReferenceBuilder toBuilder() {
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

}
