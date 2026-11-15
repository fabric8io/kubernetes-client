
package io.fabric8.openshift.api.model.hive.v1;

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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * VSphereClusterDeprovision contains VMware vSphere-specific configuration for a ClusterDeprovision
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificatesSecretRef",
    "credentialsSecretRef",
    "vCenter",
    "vCenters"
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
public class VSphereClusterDeprovision implements Editable<VSphereClusterDeprovisionBuilder>, KubernetesResource
{

    @JsonProperty("certificatesSecretRef")
    private LocalObjectReference certificatesSecretRef;
    @JsonProperty("credentialsSecretRef")
    private LocalObjectReference credentialsSecretRef;
    @JsonProperty("vCenter")
    private String vCenter;
    @JsonProperty("vCenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> vCenters = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSphereClusterDeprovision() {
    }

    public VSphereClusterDeprovision(LocalObjectReference certificatesSecretRef, LocalObjectReference credentialsSecretRef, String vCenter, List<String> vCenters) {
        super();
        this.certificatesSecretRef = certificatesSecretRef;
        this.credentialsSecretRef = credentialsSecretRef;
        this.vCenter = vCenter;
        this.vCenters = vCenters;
    }

    /**
     * VSphereClusterDeprovision contains VMware vSphere-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("certificatesSecretRef")
    public LocalObjectReference getCertificatesSecretRef() {
        return certificatesSecretRef;
    }

    /**
     * VSphereClusterDeprovision contains VMware vSphere-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("certificatesSecretRef")
    public void setCertificatesSecretRef(LocalObjectReference certificatesSecretRef) {
        this.certificatesSecretRef = certificatesSecretRef;
    }

    /**
     * VSphereClusterDeprovision contains VMware vSphere-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("credentialsSecretRef")
    public LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    /**
     * VSphereClusterDeprovision contains VMware vSphere-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    /**
     * DeprecatedVCenter is the vSphere vCenter hostname. Deprecated: use VCenters instead.
     */
    @JsonProperty("vCenter")
    public String getVCenter() {
        return vCenter;
    }

    /**
     * DeprecatedVCenter is the vSphere vCenter hostname. Deprecated: use VCenters instead.
     */
    @JsonProperty("vCenter")
    public void setVCenter(String vCenter) {
        this.vCenter = vCenter;
    }

    /**
     * VCenters are potentially multiple vCenter hostnames. Prefer this field over VCenter.
     */
    @JsonProperty("vCenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVCenters() {
        return vCenters;
    }

    /**
     * VCenters are potentially multiple vCenter hostnames. Prefer this field over VCenter.
     */
    @JsonProperty("vCenters")
    public void setVCenters(List<String> vCenters) {
        this.vCenters = vCenters;
    }

    @JsonIgnore
    public VSphereClusterDeprovisionBuilder edit() {
        return new VSphereClusterDeprovisionBuilder(this);
    }

    @JsonIgnore
    public VSphereClusterDeprovisionBuilder toBuilder() {
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
        if (!(o instanceof VSphereClusterDeprovision)) {
            return false;
        }
        VSphereClusterDeprovision other = (VSphereClusterDeprovision) o;
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
        Object this$vCenter = this.getVCenter();
        Object other$vCenter = other.getVCenter();
        if (this$vCenter == null ? other$vCenter != null : !this$vCenter.equals(other$vCenter)) {
            return false;
        }
        Object this$vCenters = this.getVCenters();
        Object other$vCenters = other.getVCenters();
        if (this$vCenters == null ? other$vCenters != null : !this$vCenters.equals(other$vCenters)) {
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
        return other instanceof VSphereClusterDeprovision;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $certificatesSecretRef = this.getCertificatesSecretRef();
        result = result * prime + ($certificatesSecretRef == null ? 43 : $certificatesSecretRef.hashCode());
        Object $credentialsSecretRef = this.getCredentialsSecretRef();
        result = result * prime + ($credentialsSecretRef == null ? 43 : $credentialsSecretRef.hashCode());
        Object $vCenter = this.getVCenter();
        result = result * prime + ($vCenter == null ? 43 : $vCenter.hashCode());
        Object $vCenters = this.getVCenters();
        result = result * prime + ($vCenters == null ? 43 : $vCenters.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VSphereClusterDeprovision(" + "certificatesSecretRef=" + this.getCertificatesSecretRef() + ", credentialsSecretRef=" + this.getCredentialsSecretRef() + ", vCenter=" + this.getVCenter() + ", vCenters=" + this.getVCenters() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
