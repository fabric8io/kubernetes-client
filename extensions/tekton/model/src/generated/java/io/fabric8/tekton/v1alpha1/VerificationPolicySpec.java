
package io.fabric8.tekton.v1alpha1;

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
 * VerificationPolicySpec defines the patterns and authorities.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorities",
    "mode",
    "resources"
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
public class VerificationPolicySpec implements Editable<VerificationPolicySpecBuilder>, KubernetesResource
{

    @JsonProperty("authorities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Authority> authorities = new ArrayList<>();
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourcePattern> resources = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VerificationPolicySpec() {
    }

    public VerificationPolicySpec(List<Authority> authorities, String mode, List<ResourcePattern> resources) {
        super();
        this.authorities = authorities;
        this.mode = mode;
        this.resources = resources;
    }

    /**
     * Authorities defines the rules for validating signatures.
     */
    @JsonProperty("authorities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Authority> getAuthorities() {
        return authorities;
    }

    /**
     * Authorities defines the rules for validating signatures.
     */
    @JsonProperty("authorities")
    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    /**
     * Mode controls whether a failing policy will fail the taskrun/pipelinerun, or only log the warnings enforce - fail the taskrun/pipelinerun if verification fails (default) warn - don't fail the taskrun/pipelinerun if verification fails but log warnings
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode controls whether a failing policy will fail the taskrun/pipelinerun, or only log the warnings enforce - fail the taskrun/pipelinerun if verification fails (default) warn - don't fail the taskrun/pipelinerun if verification fails but log warnings
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Resources defines the patterns of resources sources that should be subject to this policy. For example, we may want to apply this Policy from a certain GitHub repo. Then the ResourcesPattern should be valid regex. E.g. If using gitresolver, and we want to config keys from a certain git repo. `ResourcesPattern` can be `https://github.com/tektoncd/catalog.git`, we will use regex to filter out those resources.
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourcePattern> getResources() {
        return resources;
    }

    /**
     * Resources defines the patterns of resources sources that should be subject to this policy. For example, we may want to apply this Policy from a certain GitHub repo. Then the ResourcesPattern should be valid regex. E.g. If using gitresolver, and we want to config keys from a certain git repo. `ResourcesPattern` can be `https://github.com/tektoncd/catalog.git`, we will use regex to filter out those resources.
     */
    @JsonProperty("resources")
    public void setResources(List<ResourcePattern> resources) {
        this.resources = resources;
    }

    @JsonIgnore
    public VerificationPolicySpecBuilder edit() {
        return new VerificationPolicySpecBuilder(this);
    }

    @JsonIgnore
    public VerificationPolicySpecBuilder toBuilder() {
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
