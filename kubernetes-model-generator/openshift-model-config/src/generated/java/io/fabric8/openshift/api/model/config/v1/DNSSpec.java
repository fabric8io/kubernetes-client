
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "baseDomain",
    "platform",
    "privateZone",
    "publicZone"
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
public class DNSSpec implements Editable<DNSSpecBuilder>, KubernetesResource
{

    @JsonProperty("baseDomain")
    private String baseDomain;
    @JsonProperty("platform")
    private DNSPlatformSpec platform;
    @JsonProperty("privateZone")
    private DNSZone privateZone;
    @JsonProperty("publicZone")
    private DNSZone publicZone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSSpec() {
    }

    public DNSSpec(String baseDomain, DNSPlatformSpec platform, DNSZone privateZone, DNSZone publicZone) {
        super();
        this.baseDomain = baseDomain;
        this.platform = platform;
        this.privateZone = privateZone;
        this.publicZone = publicZone;
    }

    /**
     * baseDomain is the base domain of the cluster. All managed DNS records will be sub-domains of this base.<br><p> <br><p> For example, given the base domain `openshift.example.com`, an API server DNS record may be created for `cluster-api.openshift.example.com`.<br><p> <br><p> Once set, this field cannot be changed.
     */
    @JsonProperty("baseDomain")
    public String getBaseDomain() {
        return baseDomain;
    }

    /**
     * baseDomain is the base domain of the cluster. All managed DNS records will be sub-domains of this base.<br><p> <br><p> For example, given the base domain `openshift.example.com`, an API server DNS record may be created for `cluster-api.openshift.example.com`.<br><p> <br><p> Once set, this field cannot be changed.
     */
    @JsonProperty("baseDomain")
    public void setBaseDomain(String baseDomain) {
        this.baseDomain = baseDomain;
    }

    @JsonProperty("platform")
    public DNSPlatformSpec getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(DNSPlatformSpec platform) {
        this.platform = platform;
    }

    @JsonProperty("privateZone")
    public DNSZone getPrivateZone() {
        return privateZone;
    }

    @JsonProperty("privateZone")
    public void setPrivateZone(DNSZone privateZone) {
        this.privateZone = privateZone;
    }

    @JsonProperty("publicZone")
    public DNSZone getPublicZone() {
        return publicZone;
    }

    @JsonProperty("publicZone")
    public void setPublicZone(DNSZone publicZone) {
        this.publicZone = publicZone;
    }

    @JsonIgnore
    public DNSSpecBuilder edit() {
        return new DNSSpecBuilder(this);
    }

    @JsonIgnore
    public DNSSpecBuilder toBuilder() {
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
        if (!(o instanceof DNSSpec)) {
            return false;
        }
        DNSSpec other = (DNSSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$baseDomain = this.getBaseDomain();
        Object other$baseDomain = other.getBaseDomain();
        if (this$baseDomain == null ? other$baseDomain != null : !this$baseDomain.equals(other$baseDomain)) {
            return false;
        }
        Object this$platform = this.getPlatform();
        Object other$platform = other.getPlatform();
        if (this$platform == null ? other$platform != null : !this$platform.equals(other$platform)) {
            return false;
        }
        Object this$privateZone = this.getPrivateZone();
        Object other$privateZone = other.getPrivateZone();
        if (this$privateZone == null ? other$privateZone != null : !this$privateZone.equals(other$privateZone)) {
            return false;
        }
        Object this$publicZone = this.getPublicZone();
        Object other$publicZone = other.getPublicZone();
        if (this$publicZone == null ? other$publicZone != null : !this$publicZone.equals(other$publicZone)) {
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
        return other instanceof DNSSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $baseDomain = this.getBaseDomain();
        result = result * prime + ($baseDomain == null ? 43 : $baseDomain.hashCode());
        Object $platform = this.getPlatform();
        result = result * prime + ($platform == null ? 43 : $platform.hashCode());
        Object $privateZone = this.getPrivateZone();
        result = result * prime + ($privateZone == null ? 43 : $privateZone.hashCode());
        Object $publicZone = this.getPublicZone();
        result = result * prime + ($publicZone == null ? 43 : $publicZone.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSSpec(" + "baseDomain=" + this.getBaseDomain() + ", platform=" + this.getPlatform() + ", privateZone=" + this.getPrivateZone() + ", publicZone=" + this.getPublicZone() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
