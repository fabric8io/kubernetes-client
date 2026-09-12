
package io.fabric8.openshift.api.model.hive.v1;

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
 * ClusterRelocateSpec defines the relocation of clusters from one Hive instance to another.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterDeploymentSelector",
    "kubeconfigSecretRef"
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
public class ClusterRelocateSpec implements Editable<ClusterRelocateSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterDeploymentSelector")
    private LabelSelector clusterDeploymentSelector;
    @JsonProperty("kubeconfigSecretRef")
    private KubeconfigSecretReference kubeconfigSecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterRelocateSpec() {
    }

    public ClusterRelocateSpec(LabelSelector clusterDeploymentSelector, KubeconfigSecretReference kubeconfigSecretRef) {
        super();
        this.clusterDeploymentSelector = clusterDeploymentSelector;
        this.kubeconfigSecretRef = kubeconfigSecretRef;
    }

    /**
     * ClusterRelocateSpec defines the relocation of clusters from one Hive instance to another.
     */
    @JsonProperty("clusterDeploymentSelector")
    public LabelSelector getClusterDeploymentSelector() {
        return clusterDeploymentSelector;
    }

    /**
     * ClusterRelocateSpec defines the relocation of clusters from one Hive instance to another.
     */
    @JsonProperty("clusterDeploymentSelector")
    public void setClusterDeploymentSelector(LabelSelector clusterDeploymentSelector) {
        this.clusterDeploymentSelector = clusterDeploymentSelector;
    }

    /**
     * ClusterRelocateSpec defines the relocation of clusters from one Hive instance to another.
     */
    @JsonProperty("kubeconfigSecretRef")
    public KubeconfigSecretReference getKubeconfigSecretRef() {
        return kubeconfigSecretRef;
    }

    /**
     * ClusterRelocateSpec defines the relocation of clusters from one Hive instance to another.
     */
    @JsonProperty("kubeconfigSecretRef")
    public void setKubeconfigSecretRef(KubeconfigSecretReference kubeconfigSecretRef) {
        this.kubeconfigSecretRef = kubeconfigSecretRef;
    }

    @JsonIgnore
    public ClusterRelocateSpecBuilder edit() {
        return new ClusterRelocateSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterRelocateSpecBuilder toBuilder() {
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
        if (!(o instanceof ClusterRelocateSpec)) {
            return false;
        }
        ClusterRelocateSpec other = (ClusterRelocateSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterDeploymentSelector = this.getClusterDeploymentSelector();
        Object other$clusterDeploymentSelector = other.getClusterDeploymentSelector();
        if (this$clusterDeploymentSelector == null ? other$clusterDeploymentSelector != null : !this$clusterDeploymentSelector.equals(other$clusterDeploymentSelector)) {
            return false;
        }
        Object this$kubeconfigSecretRef = this.getKubeconfigSecretRef();
        Object other$kubeconfigSecretRef = other.getKubeconfigSecretRef();
        if (this$kubeconfigSecretRef == null ? other$kubeconfigSecretRef != null : !this$kubeconfigSecretRef.equals(other$kubeconfigSecretRef)) {
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
        return other instanceof ClusterRelocateSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterDeploymentSelector = this.getClusterDeploymentSelector();
        result = result * prime + ($clusterDeploymentSelector == null ? 43 : $clusterDeploymentSelector.hashCode());
        Object $kubeconfigSecretRef = this.getKubeconfigSecretRef();
        result = result * prime + ($kubeconfigSecretRef == null ? 43 : $kubeconfigSecretRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterRelocateSpec(" + "clusterDeploymentSelector=" + this.getClusterDeploymentSelector() + ", kubeconfigSecretRef=" + this.getKubeconfigSecretRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
