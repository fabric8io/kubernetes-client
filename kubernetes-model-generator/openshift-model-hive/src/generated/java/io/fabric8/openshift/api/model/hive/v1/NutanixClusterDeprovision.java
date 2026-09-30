
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
import io.fabric8.openshift.api.model.hive.nutanix.v1.PrismEndpoint;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * NutanixClusterDeprovision contains Nutanix-specific configuration for a ClusterDeprovision
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificatesSecretRef",
    "credentialsSecretRef",
    "prismCentral"
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
public class NutanixClusterDeprovision implements Editable<NutanixClusterDeprovisionBuilder>, KubernetesResource
{

    @JsonProperty("certificatesSecretRef")
    private LocalObjectReference certificatesSecretRef;
    @JsonProperty("credentialsSecretRef")
    private LocalObjectReference credentialsSecretRef;
    @JsonProperty("prismCentral")
    private PrismEndpoint prismCentral;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NutanixClusterDeprovision() {
    }

    public NutanixClusterDeprovision(LocalObjectReference certificatesSecretRef, LocalObjectReference credentialsSecretRef, PrismEndpoint prismCentral) {
        super();
        this.certificatesSecretRef = certificatesSecretRef;
        this.credentialsSecretRef = credentialsSecretRef;
        this.prismCentral = prismCentral;
    }

    /**
     * NutanixClusterDeprovision contains Nutanix-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("certificatesSecretRef")
    public LocalObjectReference getCertificatesSecretRef() {
        return certificatesSecretRef;
    }

    /**
     * NutanixClusterDeprovision contains Nutanix-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("certificatesSecretRef")
    public void setCertificatesSecretRef(LocalObjectReference certificatesSecretRef) {
        this.certificatesSecretRef = certificatesSecretRef;
    }

    /**
     * NutanixClusterDeprovision contains Nutanix-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("credentialsSecretRef")
    public LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    /**
     * NutanixClusterDeprovision contains Nutanix-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    /**
     * NutanixClusterDeprovision contains Nutanix-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("prismCentral")
    public PrismEndpoint getPrismCentral() {
        return prismCentral;
    }

    /**
     * NutanixClusterDeprovision contains Nutanix-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("prismCentral")
    public void setPrismCentral(PrismEndpoint prismCentral) {
        this.prismCentral = prismCentral;
    }

    @JsonIgnore
    public NutanixClusterDeprovisionBuilder edit() {
        return new NutanixClusterDeprovisionBuilder(this);
    }

    @JsonIgnore
    public NutanixClusterDeprovisionBuilder toBuilder() {
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
        if (!(o instanceof NutanixClusterDeprovision)) {
            return false;
        }
        NutanixClusterDeprovision other = (NutanixClusterDeprovision) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$certificatesSecretRef = this.getCertificatesSecretRef();
        Object other$certificatesSecretRef = other.getCertificatesSecretRef();
        if (this$certificatesSecretRef == null ? other$certificatesSecretRef != null : !this$certificatesSecretRef.equals(other$certificatesSecretRef)) {
            return false;
        }
        Object this$credentialsSecretRef = this.getCredentialsSecretRef();
        Object other$credentialsSecretRef = other.getCredentialsSecretRef();
        if (this$credentialsSecretRef == null ? other$credentialsSecretRef != null : !this$credentialsSecretRef.equals(other$credentialsSecretRef)) {
            return false;
        }
        Object this$prismCentral = this.getPrismCentral();
        Object other$prismCentral = other.getPrismCentral();
        if (this$prismCentral == null ? other$prismCentral != null : !this$prismCentral.equals(other$prismCentral)) {
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
        return other instanceof NutanixClusterDeprovision;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $certificatesSecretRef = this.getCertificatesSecretRef();
        result = result * prime + ($certificatesSecretRef == null ? 43 : $certificatesSecretRef.hashCode());
        Object $credentialsSecretRef = this.getCredentialsSecretRef();
        result = result * prime + ($credentialsSecretRef == null ? 43 : $credentialsSecretRef.hashCode());
        Object $prismCentral = this.getPrismCentral();
        result = result * prime + ($prismCentral == null ? 43 : $prismCentral.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NutanixClusterDeprovision(" + "certificatesSecretRef=" + this.getCertificatesSecretRef() + ", credentialsSecretRef=" + this.getCredentialsSecretRef() + ", prismCentral=" + this.getPrismCentral() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
