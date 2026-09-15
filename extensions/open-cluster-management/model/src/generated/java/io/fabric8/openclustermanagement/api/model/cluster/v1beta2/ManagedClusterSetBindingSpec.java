
package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

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
 * ManagedClusterSetBindingSpec defines the attributes of ManagedClusterSetBinding.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterSet"
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
public class ManagedClusterSetBindingSpec implements Editable<ManagedClusterSetBindingSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterSet")
    private String clusterSet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ManagedClusterSetBindingSpec() {
    }

    public ManagedClusterSetBindingSpec(String clusterSet) {
        super();
        this.clusterSet = clusterSet;
    }

    /**
     * clusterSet is the name of the ManagedClusterSet to bind. It must match the instance name of the ManagedClusterSetBinding and cannot change once created. User is allowed to set this field if they have an RBAC rule to CREATE on the virtual subresource of managedclustersets/bind.
     */
    @JsonProperty("clusterSet")
    public String getClusterSet() {
        return clusterSet;
    }

    /**
     * clusterSet is the name of the ManagedClusterSet to bind. It must match the instance name of the ManagedClusterSetBinding and cannot change once created. User is allowed to set this field if they have an RBAC rule to CREATE on the virtual subresource of managedclustersets/bind.
     */
    @JsonProperty("clusterSet")
    public void setClusterSet(String clusterSet) {
        this.clusterSet = clusterSet;
    }

    @JsonIgnore
    public ManagedClusterSetBindingSpecBuilder edit() {
        return new ManagedClusterSetBindingSpecBuilder(this);
    }

    @JsonIgnore
    public ManagedClusterSetBindingSpecBuilder toBuilder() {
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
        if (!(o instanceof ManagedClusterSetBindingSpec)) {
            return false;
        }
        ManagedClusterSetBindingSpec other = (ManagedClusterSetBindingSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterSet = this.getClusterSet();
        Object other$clusterSet = other.getClusterSet();
        if (this$clusterSet == null ? other$clusterSet != null : !this$clusterSet.equals(other$clusterSet)) {
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
        return other instanceof ManagedClusterSetBindingSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterSet = this.getClusterSet();
        result = result * prime + ($clusterSet == null ? 43 : $clusterSet.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ManagedClusterSetBindingSpec(" + "clusterSet=" + this.getClusterSet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
