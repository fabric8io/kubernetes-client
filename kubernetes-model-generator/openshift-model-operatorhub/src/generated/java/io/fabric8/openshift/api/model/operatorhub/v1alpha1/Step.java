
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Step)) {
            return false;
        }
        Step other = (Step) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$optional = this.getOptional();
        Object other$optional = other.getOptional();
        if (this$optional == null ? other$optional != null : !this$optional.equals(other$optional)) {
            return false;
        }
        Object this$resolving = this.getResolving();
        Object other$resolving = other.getResolving();
        if (this$resolving == null ? other$resolving != null : !this$resolving.equals(other$resolving)) {
            return false;
        }
        Object this$resource = this.getResource();
        Object other$resource = other.getResource();
        if (this$resource == null ? other$resource != null : !this$resource.equals(other$resource)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
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
        return other instanceof Step;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $optional = this.getOptional();
        result = result * prime + ($optional == null ? 43 : $optional.hashCode());
        Object $resolving = this.getResolving();
        result = result * prime + ($resolving == null ? 43 : $resolving.hashCode());
        Object $resource = this.getResource();
        result = result * prime + ($resource == null ? 43 : $resource.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Step(" + "optional=" + this.getOptional() + ", resolving=" + this.getResolving() + ", resource=" + this.getResource() + ", status=" + this.getStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
