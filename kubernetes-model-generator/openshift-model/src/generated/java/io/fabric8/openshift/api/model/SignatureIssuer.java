
package io.fabric8.openshift.api.model;

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
 * SignatureIssuer holds information about an issuer of signing certificate or key.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "commonName",
    "organization"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SignatureIssuer implements Editable<SignatureIssuerBuilder>, KubernetesResource
{

    @JsonProperty("commonName")
    private String commonName;
    @JsonProperty("organization")
    private String organization;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SignatureIssuer() {
    }

    public SignatureIssuer(String commonName, String organization) {
        super();
        this.commonName = commonName;
        this.organization = organization;
    }

    /**
     * Common name (e.g. openshift-signing-service).
     */
    @JsonProperty("commonName")
    public String getCommonName() {
        return commonName;
    }

    /**
     * Common name (e.g. openshift-signing-service).
     */
    @JsonProperty("commonName")
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    /**
     * organization name.
     */
    @JsonProperty("organization")
    public String getOrganization() {
        return organization;
    }

    /**
     * organization name.
     */
    @JsonProperty("organization")
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @JsonIgnore
    public SignatureIssuerBuilder edit() {
        return new SignatureIssuerBuilder(this);
    }

    @JsonIgnore
    public SignatureIssuerBuilder toBuilder() {
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
        if (!(o instanceof SignatureIssuer)) {
            return false;
        }
        SignatureIssuer other = (SignatureIssuer) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$commonName = this.getCommonName();
        Object other$commonName = other.getCommonName();
        if (this$commonName == null ? other$commonName != null : !this$commonName.equals(other$commonName)) {
            return false;
        }
        Object this$organization = this.getOrganization();
        Object other$organization = other.getOrganization();
        if (this$organization == null ? other$organization != null : !this$organization.equals(other$organization)) {
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
        return other instanceof SignatureIssuer;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $commonName = this.getCommonName();
        result = result * prime + ($commonName == null ? 43 : $commonName.hashCode());
        Object $organization = this.getOrganization();
        result = result * prime + ($organization == null ? 43 : $organization.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SignatureIssuer(" + "commonName=" + this.getCommonName() + ", organization=" + this.getOrganization() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
