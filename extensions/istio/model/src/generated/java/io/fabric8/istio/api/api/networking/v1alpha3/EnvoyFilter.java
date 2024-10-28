
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReference;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configPatches",
    "priority",
    "targetRefs",
    "workloadSelector"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1alpha3")
@Group("")
@Generated("jsonschema2pojo")
public class EnvoyFilter implements Editable<EnvoyFilterBuilder> , KubernetesResource, Namespaced
{

    @JsonProperty("configPatches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvoyFilterEnvoyConfigObjectPatch> configPatches = new ArrayList<>();
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicyTargetReference> targetRefs = new ArrayList<>();
    @JsonProperty("workloadSelector")
    private WorkloadSelector workloadSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EnvoyFilter() {
    }

    public EnvoyFilter(List<EnvoyFilterEnvoyConfigObjectPatch> configPatches, Integer priority, List<PolicyTargetReference> targetRefs, WorkloadSelector workloadSelector) {
        super();
        this.configPatches = configPatches;
        this.priority = priority;
        this.targetRefs = targetRefs;
        this.workloadSelector = workloadSelector;
    }

    @JsonProperty("configPatches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvoyFilterEnvoyConfigObjectPatch> getConfigPatches() {
        return configPatches;
    }

    @JsonProperty("configPatches")
    public void setConfigPatches(List<EnvoyFilterEnvoyConfigObjectPatch> configPatches) {
        this.configPatches = configPatches;
    }

    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyTargetReference> getTargetRefs() {
        return targetRefs;
    }

    @JsonProperty("targetRefs")
    public void setTargetRefs(List<PolicyTargetReference> targetRefs) {
        this.targetRefs = targetRefs;
    }

    @JsonProperty("workloadSelector")
    public WorkloadSelector getWorkloadSelector() {
        return workloadSelector;
    }

    @JsonProperty("workloadSelector")
    public void setWorkloadSelector(WorkloadSelector workloadSelector) {
        this.workloadSelector = workloadSelector;
    }

    @JsonIgnore
    public EnvoyFilterBuilder edit() {
        return new EnvoyFilterBuilder(this);
    }

    @JsonIgnore
    public EnvoyFilterBuilder toBuilder() {
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
