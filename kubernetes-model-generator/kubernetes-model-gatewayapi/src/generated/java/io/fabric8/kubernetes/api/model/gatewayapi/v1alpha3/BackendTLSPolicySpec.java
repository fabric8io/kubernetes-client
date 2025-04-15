
package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha3;

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
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.LocalPolicyTargetReferenceWithSectionName;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * BackendTLSPolicySpec defines the desired state of BackendTLSPolicy.<br><p> <br><p> Support: Extended
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "options",
    "targetRefs",
    "validation"
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
public class BackendTLSPolicySpec implements Editable<BackendTLSPolicySpecBuilder>, KubernetesResource
{

    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> options = new LinkedHashMap<>();
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalPolicyTargetReferenceWithSectionName> targetRefs = new ArrayList<>();
    @JsonProperty("validation")
    private BackendTLSPolicyValidation validation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BackendTLSPolicySpec() {
    }

    public BackendTLSPolicySpec(Map<String, String> options, List<LocalPolicyTargetReferenceWithSectionName> targetRefs, BackendTLSPolicyValidation validation) {
        super();
        this.options = options;
        this.targetRefs = targetRefs;
        this.validation = validation;
    }

    /**
     * Options are a list of key/value pairs to enable extended TLS configuration for each implementation. For example, configuring the minimum TLS version or supported cipher suites.<br><p> <br><p> A set of common keys MAY be defined by the API in the future. To avoid any ambiguity, implementation-specific definitions MUST use domain-prefixed names, such as `example.com/my-custom-option`. Un-prefixed names are reserved for key names defined by Gateway API.<br><p> <br><p> Support: Implementation-specific
     */
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getOptions() {
        return options;
    }

    /**
     * Options are a list of key/value pairs to enable extended TLS configuration for each implementation. For example, configuring the minimum TLS version or supported cipher suites.<br><p> <br><p> A set of common keys MAY be defined by the API in the future. To avoid any ambiguity, implementation-specific definitions MUST use domain-prefixed names, such as `example.com/my-custom-option`. Un-prefixed names are reserved for key names defined by Gateway API.<br><p> <br><p> Support: Implementation-specific
     */
    @JsonProperty("options")
    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    /**
     * TargetRefs identifies an API object to apply the policy to. Only Services have Extended support. Implementations MAY support additional objects, with Implementation Specific support. Note that this config applies to the entire referenced resource by default, but this default may change in the future to provide a more granular application of the policy.<br><p> <br><p> Support: Extended for Kubernetes Service<br><p> <br><p> Support: Implementation-specific for any other resource
     */
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalPolicyTargetReferenceWithSectionName> getTargetRefs() {
        return targetRefs;
    }

    /**
     * TargetRefs identifies an API object to apply the policy to. Only Services have Extended support. Implementations MAY support additional objects, with Implementation Specific support. Note that this config applies to the entire referenced resource by default, but this default may change in the future to provide a more granular application of the policy.<br><p> <br><p> Support: Extended for Kubernetes Service<br><p> <br><p> Support: Implementation-specific for any other resource
     */
    @JsonProperty("targetRefs")
    public void setTargetRefs(List<LocalPolicyTargetReferenceWithSectionName> targetRefs) {
        this.targetRefs = targetRefs;
    }

    /**
     * BackendTLSPolicySpec defines the desired state of BackendTLSPolicy.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("validation")
    public BackendTLSPolicyValidation getValidation() {
        return validation;
    }

    /**
     * BackendTLSPolicySpec defines the desired state of BackendTLSPolicy.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("validation")
    public void setValidation(BackendTLSPolicyValidation validation) {
        this.validation = validation;
    }

    @JsonIgnore
    public BackendTLSPolicySpecBuilder edit() {
        return new BackendTLSPolicySpecBuilder(this);
    }

    @JsonIgnore
    public BackendTLSPolicySpecBuilder toBuilder() {
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
