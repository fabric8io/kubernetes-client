
package io.fabric8.kubernetes.api.model.batch.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PodFailurePolicyOnExitCodesRequirement describes the requirement for handling a failed pod based on its container exit codes. In particular, it lookups the .state.terminated.exitCode for each app container and init container status, represented by the .status.containerStatuses and .status.initContainerStatuses fields in the Pod status, respectively. Containers completed with success (exit code 0) are excluded from the requirement check.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerName",
    "operator",
    "values"
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
public class PodFailurePolicyOnExitCodesRequirement implements Editable<PodFailurePolicyOnExitCodesRequirementBuilder>, KubernetesResource
{

    @JsonProperty("containerName")
    private String containerName;
    @JsonProperty("operator")
    private String operator;
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Integer> values = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodFailurePolicyOnExitCodesRequirement() {
    }

    public PodFailurePolicyOnExitCodesRequirement(String containerName, String operator, List<Integer> values) {
        super();
        this.containerName = containerName;
        this.operator = operator;
        this.values = values;
    }

    /**
     * Restricts the check for exit codes to the container with the specified name. When null, the rule applies to all containers. When specified, it should match one the container or initContainer names in the pod template.
     */
    @JsonProperty("containerName")
    public String getContainerName() {
        return containerName;
    }

    /**
     * Restricts the check for exit codes to the container with the specified name. When null, the rule applies to all containers. When specified, it should match one the container or initContainer names in the pod template.
     */
    @JsonProperty("containerName")
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * Represents the relationship between the container exit code(s) and the specified values. Containers completed with success (exit code 0) are excluded from the requirement check. Possible values are:<br><p> <br><p> - In: the requirement is satisfied if at least one container exit code<br><p>   (might be multiple if there are multiple containers not restricted<br><p>   by the 'containerName' field) is in the set of specified values.<br><p> - NotIn: the requirement is satisfied if at least one container exit code<br><p>   (might be multiple if there are multiple containers not restricted<br><p>   by the 'containerName' field) is not in the set of specified values.<br><p> Additional values are considered to be added in the future. Clients should react to an unknown operator by assuming the requirement is not satisfied.
     */
    @JsonProperty("operator")
    public String getOperator() {
        return operator;
    }

    /**
     * Represents the relationship between the container exit code(s) and the specified values. Containers completed with success (exit code 0) are excluded from the requirement check. Possible values are:<br><p> <br><p> - In: the requirement is satisfied if at least one container exit code<br><p>   (might be multiple if there are multiple containers not restricted<br><p>   by the 'containerName' field) is in the set of specified values.<br><p> - NotIn: the requirement is satisfied if at least one container exit code<br><p>   (might be multiple if there are multiple containers not restricted<br><p>   by the 'containerName' field) is not in the set of specified values.<br><p> Additional values are considered to be added in the future. Clients should react to an unknown operator by assuming the requirement is not satisfied.
     */
    @JsonProperty("operator")
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Specifies the set of values. Each returned container exit code (might be multiple in case of multiple containers) is checked against this set of values with respect to the operator. The list of values must be ordered and must not contain duplicates. Value '0' cannot be used for the In operator. At least one element is required. At most 255 elements are allowed.
     */
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Integer> getValues() {
        return values;
    }

    /**
     * Specifies the set of values. Each returned container exit code (might be multiple in case of multiple containers) is checked against this set of values with respect to the operator. The list of values must be ordered and must not contain duplicates. Value '0' cannot be used for the In operator. At least one element is required. At most 255 elements are allowed.
     */
    @JsonProperty("values")
    public void setValues(List<Integer> values) {
        this.values = values;
    }

    @JsonIgnore
    public PodFailurePolicyOnExitCodesRequirementBuilder edit() {
        return new PodFailurePolicyOnExitCodesRequirementBuilder(this);
    }

    @JsonIgnore
    public PodFailurePolicyOnExitCodesRequirementBuilder toBuilder() {
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
