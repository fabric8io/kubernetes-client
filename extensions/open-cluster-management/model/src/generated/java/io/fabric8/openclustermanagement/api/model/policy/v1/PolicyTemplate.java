
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

    @JsonProperty("extraDependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyDependency> getExtraDependencies() {
        return extraDependencies;
    }

    @JsonProperty("extraDependencies")
    public void setExtraDependencies(List<PolicyDependency> extraDependencies) {
        this.extraDependencies = extraDependencies;
    }

    @JsonProperty("ignorePending")
    public Boolean getIgnorePending() {
        return ignorePending;
    }

    @JsonProperty("ignorePending")
    public void setIgnorePending(Boolean ignorePending) {
        this.ignorePending = ignorePending;
    }

    @JsonProperty("objectDefinition")
    public Object getObjectDefinition() {
        return objectDefinition;
    }

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
