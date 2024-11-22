
package io.fabric8.openclustermanagement.api.model.policy.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "compliant",
    "details",
    "placement",
    "status"
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
public class PolicyStatus implements Editable<PolicyStatusBuilder> , KubernetesResource
{

    @JsonProperty("compliant")
    private String compliant;
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DetailsPerTemplate> details = new ArrayList<>();
    @JsonProperty("placement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Placement> placement = new ArrayList<>();
    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CompliancePerClusterStatus> status = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PolicyStatus() {
    }

    public PolicyStatus(String compliant, List<DetailsPerTemplate> details, List<Placement> placement, List<CompliancePerClusterStatus> status) {
        super();
        this.compliant = compliant;
        this.details = details;
        this.placement = placement;
        this.status = status;
    }

    @JsonProperty("compliant")
    public String getCompliant() {
        return compliant;
    }

    @JsonProperty("compliant")
    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }

    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DetailsPerTemplate> getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(List<DetailsPerTemplate> details) {
        this.details = details;
    }

    @JsonProperty("placement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Placement> getPlacement() {
        return placement;
    }

    @JsonProperty("placement")
    public void setPlacement(List<Placement> placement) {
        this.placement = placement;
    }

    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CompliancePerClusterStatus> getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(List<CompliancePerClusterStatus> status) {
        this.status = status;
    }

    @JsonIgnore
    public PolicyStatusBuilder edit() {
        return new PolicyStatusBuilder(this);
    }

    @JsonIgnore
    public PolicyStatusBuilder toBuilder() {
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
