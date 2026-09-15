
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * CloudControllerManagerStatus holds the state of Cloud Controller Manager (a.k.a. CCM or CPI) related settings
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "state"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class CloudControllerManagerStatus implements Editable<CloudControllerManagerStatusBuilder>, KubernetesResource
{

    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CloudControllerManagerStatus() {
    }

    public CloudControllerManagerStatus(String state) {
        super();
        this.state = state;
    }

    /**
     * state determines whether or not an external Cloud Controller Manager is expected to be installed within the cluster. https://kubernetes.io/docs/tasks/administer-cluster/running-cloud-controller/#running-cloud-controller-manager<br><p> <br><p> Valid values are "External", "None" and omitted. When set to "External", new nodes will be tainted as uninitialized when created, preventing them from running workloads until they are initialized by the cloud controller manager. When omitted or set to "None", new nodes will be not tainted and no extra initialization from the cloud controller manager is expected.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state determines whether or not an external Cloud Controller Manager is expected to be installed within the cluster. https://kubernetes.io/docs/tasks/administer-cluster/running-cloud-controller/#running-cloud-controller-manager<br><p> <br><p> Valid values are "External", "None" and omitted. When set to "External", new nodes will be tainted as uninitialized when created, preventing them from running workloads until they are initialized by the cloud controller manager. When omitted or set to "None", new nodes will be not tainted and no extra initialization from the cloud controller manager is expected.
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public CloudControllerManagerStatusBuilder edit() {
        return new CloudControllerManagerStatusBuilder(this);
    }

    @JsonIgnore
    public CloudControllerManagerStatusBuilder toBuilder() {
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
        if (!(o instanceof CloudControllerManagerStatus)) {
            return false;
        }
        CloudControllerManagerStatus other = (CloudControllerManagerStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
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
        return other instanceof CloudControllerManagerStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CloudControllerManagerStatus(" + "state=" + this.getState() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
