
package io.fabric8.certmanager.api.model.v1;

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
 * Configures an issuer to sign certificates using a CyberArk Certificate Manager Self-Hosted or SaaS policy zone.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloud",
    "tpp",
    "zone"
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
public class VenafiIssuer implements Editable<VenafiIssuerBuilder>, KubernetesResource
{

    @JsonProperty("cloud")
    private VenafiCloud cloud;
    @JsonProperty("tpp")
    private VenafiTPP tpp;
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VenafiIssuer() {
    }

    public VenafiIssuer(VenafiCloud cloud, VenafiTPP tpp, String zone) {
        super();
        this.cloud = cloud;
        this.tpp = tpp;
        this.zone = zone;
    }

    /**
     * Configures an issuer to sign certificates using a CyberArk Certificate Manager Self-Hosted or SaaS policy zone.
     */
    @JsonProperty("cloud")
    public VenafiCloud getCloud() {
        return cloud;
    }

    /**
     * Configures an issuer to sign certificates using a CyberArk Certificate Manager Self-Hosted or SaaS policy zone.
     */
    @JsonProperty("cloud")
    public void setCloud(VenafiCloud cloud) {
        this.cloud = cloud;
    }

    /**
     * Configures an issuer to sign certificates using a CyberArk Certificate Manager Self-Hosted or SaaS policy zone.
     */
    @JsonProperty("tpp")
    public VenafiTPP getTpp() {
        return tpp;
    }

    /**
     * Configures an issuer to sign certificates using a CyberArk Certificate Manager Self-Hosted or SaaS policy zone.
     */
    @JsonProperty("tpp")
    public void setTpp(VenafiTPP tpp) {
        this.tpp = tpp;
    }

    /**
     * Zone is the Certificate Manager Policy Zone to use for this issuer. All requests made to the Certificate Manager platform will be restricted by the named zone policy. This field is required.
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * Zone is the Certificate Manager Policy Zone to use for this issuer. All requests made to the Certificate Manager platform will be restricted by the named zone policy. This field is required.
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonIgnore
    public VenafiIssuerBuilder edit() {
        return new VenafiIssuerBuilder(this);
    }

    @JsonIgnore
    public VenafiIssuerBuilder toBuilder() {
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
        if (!(o instanceof VenafiIssuer)) {
            return false;
        }
        VenafiIssuer other = (VenafiIssuer) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cloud = this.getCloud();
        Object other$cloud = other.getCloud();
        if (this$cloud == null ? other$cloud != null : !this$cloud.equals(other$cloud)) {
            return false;
        }
        Object this$tpp = this.getTpp();
        Object other$tpp = other.getTpp();
        if (this$tpp == null ? other$tpp != null : !this$tpp.equals(other$tpp)) {
            return false;
        }
        Object this$zone = this.getZone();
        Object other$zone = other.getZone();
        if (this$zone == null ? other$zone != null : !this$zone.equals(other$zone)) {
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
        return other instanceof VenafiIssuer;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cloud = this.getCloud();
        result = result * prime + ($cloud == null ? 43 : $cloud.hashCode());
        Object $tpp = this.getTpp();
        result = result * prime + ($tpp == null ? 43 : $tpp.hashCode());
        Object $zone = this.getZone();
        result = result * prime + ($zone == null ? 43 : $zone.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VenafiIssuer(" + "cloud=" + this.getCloud() + ", tpp=" + this.getTpp() + ", zone=" + this.getZone() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
