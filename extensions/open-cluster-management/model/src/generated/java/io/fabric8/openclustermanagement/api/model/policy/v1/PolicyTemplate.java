
package io.fabric8.openclustermanagement.api.model.policy.v1;

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
 * PolicyTemplate is the definition of the policy engine resource to apply to the managed cluster, along with configurations on how it should be applied.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "extraDependencies",
    "ignorePending",
    "objectDefinition"
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
public class PolicyTemplate implements Editable<PolicyTemplateBuilder>, KubernetesResource
{

    @JsonProperty("extraDependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicyDependency> extraDependencies = new ArrayList<>();
    @JsonProperty("ignorePending")
    private Boolean ignorePending;
    @JsonProperty("objectDefinition")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object objectDefinition;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicyTemplate() {
    }

    public PolicyTemplate(List<PolicyDependency> extraDependencies, Boolean ignorePending, Object objectDefinition) {
        super();
        this.extraDependencies = extraDependencies;
        this.ignorePending = ignorePending;
        this.objectDefinition = objectDefinition;
    }

    /**
     * ExtraDependencies is additional PolicyDependencies that only apply to this policy template. ExtraDependencies is a list of dependency objects detailed with extra considerations for compliance that should be fulfilled before applying the policy template to the managed clusters.
     */
    @JsonProperty("extraDependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyDependency> getExtraDependencies() {
        return extraDependencies;
    }

    /**
     * ExtraDependencies is additional PolicyDependencies that only apply to this policy template. ExtraDependencies is a list of dependency objects detailed with extra considerations for compliance that should be fulfilled before applying the policy template to the managed clusters.
     */
    @JsonProperty("extraDependencies")
    public void setExtraDependencies(List<PolicyDependency> extraDependencies) {
        this.extraDependencies = extraDependencies;
    }

    /**
     * IgnorePending is a boolean parameter to specify whether to ignore the "Pending" status of this template when calculating the overall policy status. The default value is "false" to not ignore a "Pending" status.
     */
    @JsonProperty("ignorePending")
    public Boolean getIgnorePending() {
        return ignorePending;
    }

    /**
     * IgnorePending is a boolean parameter to specify whether to ignore the "Pending" status of this template when calculating the overall policy status. The default value is "false" to not ignore a "Pending" status.
     */
    @JsonProperty("ignorePending")
    public void setIgnorePending(Boolean ignorePending) {
        this.ignorePending = ignorePending;
    }

    /**
     * PolicyTemplate is the definition of the policy engine resource to apply to the managed cluster, along with configurations on how it should be applied.
     */
    @JsonProperty("objectDefinition")
    public Object getObjectDefinition() {
        return objectDefinition;
    }

    /**
     * PolicyTemplate is the definition of the policy engine resource to apply to the managed cluster, along with configurations on how it should be applied.
     */
    @JsonProperty("objectDefinition")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setObjectDefinition(Object objectDefinition) {
        this.objectDefinition = objectDefinition;
    }

    @JsonIgnore
    public PolicyTemplateBuilder edit() {
        return new PolicyTemplateBuilder(this);
    }

    @JsonIgnore
    public PolicyTemplateBuilder toBuilder() {
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
