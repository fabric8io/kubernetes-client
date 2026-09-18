
package io.fabric8.certmanager.api.model.acme.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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
 * ACMEIssuerDNS01ProviderCloudDNS is a structure containing the DNS configuration for Google Cloud DNS
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostedZoneName",
    "project",
    "serviceAccountSecretRef"
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
public class ACMEIssuerDNS01ProviderCloudDNS implements Editable<ACMEIssuerDNS01ProviderCloudDNSBuilder>, KubernetesResource
{

    @JsonProperty("hostedZoneName")
    private String hostedZoneName;
    @JsonProperty("project")
    private String project;
    @JsonProperty("serviceAccountSecretRef")
    private SecretKeySelector serviceAccountSecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEIssuerDNS01ProviderCloudDNS() {
    }

    public ACMEIssuerDNS01ProviderCloudDNS(String hostedZoneName, String project, SecretKeySelector serviceAccountSecretRef) {
        super();
        this.hostedZoneName = hostedZoneName;
        this.project = project;
        this.serviceAccountSecretRef = serviceAccountSecretRef;
    }

    /**
     * HostedZoneName is an optional field that tells cert-manager in which Cloud DNS zone the challenge record has to be created. If left empty cert-manager will automatically choose a zone.
     */
    @JsonProperty("hostedZoneName")
    public String getHostedZoneName() {
        return hostedZoneName;
    }

    /**
     * HostedZoneName is an optional field that tells cert-manager in which Cloud DNS zone the challenge record has to be created. If left empty cert-manager will automatically choose a zone.
     */
    @JsonProperty("hostedZoneName")
    public void setHostedZoneName(String hostedZoneName) {
        this.hostedZoneName = hostedZoneName;
    }

    /**
     * ACMEIssuerDNS01ProviderCloudDNS is a structure containing the DNS configuration for Google Cloud DNS
     */
    @JsonProperty("project")
    public String getProject() {
        return project;
    }

    /**
     * ACMEIssuerDNS01ProviderCloudDNS is a structure containing the DNS configuration for Google Cloud DNS
     */
    @JsonProperty("project")
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * ACMEIssuerDNS01ProviderCloudDNS is a structure containing the DNS configuration for Google Cloud DNS
     */
    @JsonProperty("serviceAccountSecretRef")
    public SecretKeySelector getServiceAccountSecretRef() {
        return serviceAccountSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderCloudDNS is a structure containing the DNS configuration for Google Cloud DNS
     */
    @JsonProperty("serviceAccountSecretRef")
    public void setServiceAccountSecretRef(SecretKeySelector serviceAccountSecretRef) {
        this.serviceAccountSecretRef = serviceAccountSecretRef;
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderCloudDNSBuilder edit() {
        return new ACMEIssuerDNS01ProviderCloudDNSBuilder(this);
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderCloudDNSBuilder toBuilder() {
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
        if (!(o instanceof ACMEIssuerDNS01ProviderCloudDNS)) {
            return false;
        }
        ACMEIssuerDNS01ProviderCloudDNS other = (ACMEIssuerDNS01ProviderCloudDNS) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hostedZoneName = this.getHostedZoneName();
        Object other$hostedZoneName = other.getHostedZoneName();
        if (this$hostedZoneName == null ? other$hostedZoneName != null : !this$hostedZoneName.equals(other$hostedZoneName)) {
            return false;
        }
        Object this$project = this.getProject();
        Object other$project = other.getProject();
        if (this$project == null ? other$project != null : !this$project.equals(other$project)) {
            return false;
        }
        Object this$serviceAccountSecretRef = this.getServiceAccountSecretRef();
        Object other$serviceAccountSecretRef = other.getServiceAccountSecretRef();
        if (this$serviceAccountSecretRef == null ? other$serviceAccountSecretRef != null : !this$serviceAccountSecretRef.equals(other$serviceAccountSecretRef)) {
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
        return other instanceof ACMEIssuerDNS01ProviderCloudDNS;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hostedZoneName = this.getHostedZoneName();
        result = result * prime + ($hostedZoneName == null ? 43 : $hostedZoneName.hashCode());
        Object $project = this.getProject();
        result = result * prime + ($project == null ? 43 : $project.hashCode());
        Object $serviceAccountSecretRef = this.getServiceAccountSecretRef();
        result = result * prime + ($serviceAccountSecretRef == null ? 43 : $serviceAccountSecretRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEIssuerDNS01ProviderCloudDNS(" + "hostedZoneName=" + this.getHostedZoneName() + ", project=" + this.getProject() + ", serviceAccountSecretRef=" + this.getServiceAccountSecretRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
