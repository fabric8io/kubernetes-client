
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
 * Step represents the status of an individual step in an InstallPlan.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "optional",
    "resolving",
    "resource",
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
public class Step implements Editable<StepBuilder>, KubernetesResource
{

    @JsonProperty("optional")
    private Boolean optional;
    @JsonProperty("resolving")
    private String resolving;
    @JsonProperty("resource")
    private StepResource resource;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Step() {
    }

    public Step(Boolean optional, String resolving, StepResource resource, String status) {
        super();
        this.optional = optional;
        this.resolving = resolving;
        this.resource = resource;
        this.status = status;
    }

    /**
     * Step represents the status of an individual step in an InstallPlan.
     */
    @JsonProperty("optional")
    public Boolean getOptional() {
        return optional;
    }

    /**
     * Step represents the status of an individual step in an InstallPlan.
     */
    @JsonProperty("optional")
    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    /**
     * Step represents the status of an individual step in an InstallPlan.
     */
    @JsonProperty("resolving")
    public String getResolving() {
        return resolving;
    }

    /**
     * Step represents the status of an individual step in an InstallPlan.
     */
    @JsonProperty("resolving")
    public void setResolving(String resolving) {
        this.resolving = resolving;
    }

    /**
     * Step represents the status of an individual step in an InstallPlan.
     */
    @JsonProperty("resource")
    public StepResource getResource() {
        return resource;
    }

    /**
     * Step represents the status of an individual step in an InstallPlan.
     */
    @JsonProperty("resource")
    public void setResource(StepResource resource) {
        this.resource = resource;
    }

    /**
     * Step represents the status of an individual step in an InstallPlan.
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Step represents the status of an individual step in an InstallPlan.
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonIgnore
    public StepBuilder edit() {
        return new StepBuilder(this);
    }

    @JsonIgnore
    public StepBuilder toBuilder() {
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
