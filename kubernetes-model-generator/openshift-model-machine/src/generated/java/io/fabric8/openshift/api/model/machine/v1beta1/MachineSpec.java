
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Taint;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MachineSpec defines the desired state of Machine
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "authoritativeAPI",
    "lifecycleHooks",
    "providerID",
    "providerSpec",
    "taints"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class MachineSpec implements Editable<MachineSpecBuilder>, KubernetesResource
{

    @JsonProperty("authoritativeAPI")
    private String authoritativeAPI;
    @JsonProperty("lifecycleHooks")
    private LifecycleHooks lifecycleHooks;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("providerID")
    private String providerID;
    @JsonProperty("providerSpec")
    private ProviderSpec providerSpec;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Taint> taints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineSpec() {
    }

    public MachineSpec(String authoritativeAPI, LifecycleHooks lifecycleHooks, ObjectMeta metadata, String providerID, ProviderSpec providerSpec, List<Taint> taints) {
        super();
        this.authoritativeAPI = authoritativeAPI;
        this.lifecycleHooks = lifecycleHooks;
        this.metadata = metadata;
        this.providerID = providerID;
        this.providerSpec = providerSpec;
        this.taints = taints;
    }

    /**
     * authoritativeAPI is the API that is authoritative for this resource. Valid values are MachineAPI and ClusterAPI. When set to MachineAPI, writes to the spec of the machine.openshift.io copy of this resource will be reflected into the cluster.x-k8s.io copy. When set to ClusterAPI, writes to the spec of the cluster.x-k8s.io copy of this resource will be reflected into the machine.openshift.io copy. Updates to the status will be reflected in both copies of the resource, based on the controller implementing the functionality of the API. Currently the authoritative API determines which controller will manage the resource, this will change in a future release. To ensure the change has been accepted, please verify that the `status.authoritativeAPI` field has been updated to the desired value and that the `Synchronized` condition is present and set to `True`.
     */
    @JsonProperty("authoritativeAPI")
    public String getAuthoritativeAPI() {
        return authoritativeAPI;
    }

    /**
     * authoritativeAPI is the API that is authoritative for this resource. Valid values are MachineAPI and ClusterAPI. When set to MachineAPI, writes to the spec of the machine.openshift.io copy of this resource will be reflected into the cluster.x-k8s.io copy. When set to ClusterAPI, writes to the spec of the cluster.x-k8s.io copy of this resource will be reflected into the machine.openshift.io copy. Updates to the status will be reflected in both copies of the resource, based on the controller implementing the functionality of the API. Currently the authoritative API determines which controller will manage the resource, this will change in a future release. To ensure the change has been accepted, please verify that the `status.authoritativeAPI` field has been updated to the desired value and that the `Synchronized` condition is present and set to `True`.
     */
    @JsonProperty("authoritativeAPI")
    public void setAuthoritativeAPI(String authoritativeAPI) {
        this.authoritativeAPI = authoritativeAPI;
    }

    /**
     * MachineSpec defines the desired state of Machine
     */
    @JsonProperty("lifecycleHooks")
    public LifecycleHooks getLifecycleHooks() {
        return lifecycleHooks;
    }

    /**
     * MachineSpec defines the desired state of Machine
     */
    @JsonProperty("lifecycleHooks")
    public void setLifecycleHooks(LifecycleHooks lifecycleHooks) {
        this.lifecycleHooks = lifecycleHooks;
    }

    /**
     * MachineSpec defines the desired state of Machine
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * MachineSpec defines the desired state of Machine
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * providerID is the identification ID of the machine provided by the provider. This field must match the provider ID as seen on the node object corresponding to this machine. This field is required by higher level consumers of cluster-api. Example use case is cluster autoscaler with cluster-api as provider. Clean-up logic in the autoscaler compares machines to nodes to find out machines at provider which could not get registered as Kubernetes nodes. With cluster-api as a generic out-of-tree provider for autoscaler, this field is required by autoscaler to be able to have a provider view of the list of machines. Another list of nodes is queried from the k8s apiserver and then a comparison is done to find out unregistered machines and are marked for delete. This field will be set by the actuators and consumed by higher level entities like autoscaler that will be interfacing with cluster-api as generic provider.
     */
    @JsonProperty("providerID")
    public String getProviderID() {
        return providerID;
    }

    /**
     * providerID is the identification ID of the machine provided by the provider. This field must match the provider ID as seen on the node object corresponding to this machine. This field is required by higher level consumers of cluster-api. Example use case is cluster autoscaler with cluster-api as provider. Clean-up logic in the autoscaler compares machines to nodes to find out machines at provider which could not get registered as Kubernetes nodes. With cluster-api as a generic out-of-tree provider for autoscaler, this field is required by autoscaler to be able to have a provider view of the list of machines. Another list of nodes is queried from the k8s apiserver and then a comparison is done to find out unregistered machines and are marked for delete. This field will be set by the actuators and consumed by higher level entities like autoscaler that will be interfacing with cluster-api as generic provider.
     */
    @JsonProperty("providerID")
    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    /**
     * MachineSpec defines the desired state of Machine
     */
    @JsonProperty("providerSpec")
    public ProviderSpec getProviderSpec() {
        return providerSpec;
    }

    /**
     * MachineSpec defines the desired state of Machine
     */
    @JsonProperty("providerSpec")
    public void setProviderSpec(ProviderSpec providerSpec) {
        this.providerSpec = providerSpec;
    }

    /**
     * The list of the taints to be applied to the corresponding Node in additive manner. This list will not overwrite any other taints added to the Node on an ongoing basis by other entities. These taints should be actively reconciled e.g. if you ask the machine controller to apply a taint and then manually remove the taint the machine controller will put it back) but not have the machine controller remove any taints
     */
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Taint> getTaints() {
        return taints;
    }

    /**
     * The list of the taints to be applied to the corresponding Node in additive manner. This list will not overwrite any other taints added to the Node on an ongoing basis by other entities. These taints should be actively reconciled e.g. if you ask the machine controller to apply a taint and then manually remove the taint the machine controller will put it back) but not have the machine controller remove any taints
     */
    @JsonProperty("taints")
    public void setTaints(List<Taint> taints) {
        this.taints = taints;
    }

    @JsonIgnore
    public MachineSpecBuilder edit() {
        return new MachineSpecBuilder(this);
    }

    @JsonIgnore
    public MachineSpecBuilder toBuilder() {
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
        if (!(o instanceof MachineSpec)) {
            return false;
        }
        MachineSpec other = (MachineSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authoritativeAPI = this.getAuthoritativeAPI();
        Object other$authoritativeAPI = other.getAuthoritativeAPI();
        if (this$authoritativeAPI == null ? other$authoritativeAPI != null : !this$authoritativeAPI.equals(other$authoritativeAPI)) {
            return false;
        }
        Object this$lifecycleHooks = this.getLifecycleHooks();
        Object other$lifecycleHooks = other.getLifecycleHooks();
        if (this$lifecycleHooks == null ? other$lifecycleHooks != null : !this$lifecycleHooks.equals(other$lifecycleHooks)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$providerID = this.getProviderID();
        Object other$providerID = other.getProviderID();
        if (this$providerID == null ? other$providerID != null : !this$providerID.equals(other$providerID)) {
            return false;
        }
        Object this$providerSpec = this.getProviderSpec();
        Object other$providerSpec = other.getProviderSpec();
        if (this$providerSpec == null ? other$providerSpec != null : !this$providerSpec.equals(other$providerSpec)) {
            return false;
        }
        Object this$taints = this.getTaints();
        Object other$taints = other.getTaints();
        if (this$taints == null ? other$taints != null : !this$taints.equals(other$taints)) {
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
        return other instanceof MachineSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authoritativeAPI = this.getAuthoritativeAPI();
        result = result * prime + ($authoritativeAPI == null ? 43 : $authoritativeAPI.hashCode());
        Object $lifecycleHooks = this.getLifecycleHooks();
        result = result * prime + ($lifecycleHooks == null ? 43 : $lifecycleHooks.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $providerID = this.getProviderID();
        result = result * prime + ($providerID == null ? 43 : $providerID.hashCode());
        Object $providerSpec = this.getProviderSpec();
        result = result * prime + ($providerSpec == null ? 43 : $providerSpec.hashCode());
        Object $taints = this.getTaints();
        result = result * prime + ($taints == null ? 43 : $taints.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineSpec(" + "authoritativeAPI=" + this.getAuthoritativeAPI() + ", lifecycleHooks=" + this.getLifecycleHooks() + ", metadata=" + this.getMetadata() + ", providerID=" + this.getProviderID() + ", providerSpec=" + this.getProviderSpec() + ", taints=" + this.getTaints() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
