
package io.fabric8.openshift.api.model.installer.baremetal.v1;

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
 * Metadata contains baremetal metadata (e.g. for uninstalling the cluster).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bootstrapProvisioningIP",
    "libvirtURI",
    "provisioningHostIP"
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
public class Metadata implements Editable<MetadataBuilder>, KubernetesResource
{

    @JsonProperty("bootstrapProvisioningIP")
    private String bootstrapProvisioningIP;
    @JsonProperty("libvirtURI")
    private String libvirtURI;
    @JsonProperty("provisioningHostIP")
    private String provisioningHostIP;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metadata() {
    }

    public Metadata(String bootstrapProvisioningIP, String libvirtURI, String provisioningHostIP) {
        super();
        this.bootstrapProvisioningIP = bootstrapProvisioningIP;
        this.libvirtURI = libvirtURI;
        this.provisioningHostIP = provisioningHostIP;
    }

    /**
     * Metadata contains baremetal metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("bootstrapProvisioningIP")
    public String getBootstrapProvisioningIP() {
        return bootstrapProvisioningIP;
    }

    /**
     * Metadata contains baremetal metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("bootstrapProvisioningIP")
    public void setBootstrapProvisioningIP(String bootstrapProvisioningIP) {
        this.bootstrapProvisioningIP = bootstrapProvisioningIP;
    }

    /**
     * Metadata contains baremetal metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("libvirtURI")
    public String getLibvirtURI() {
        return libvirtURI;
    }

    /**
     * Metadata contains baremetal metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("libvirtURI")
    public void setLibvirtURI(String libvirtURI) {
        this.libvirtURI = libvirtURI;
    }

    /**
     * Metadata contains baremetal metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("provisioningHostIP")
    public String getProvisioningHostIP() {
        return provisioningHostIP;
    }

    /**
     * Metadata contains baremetal metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("provisioningHostIP")
    public void setProvisioningHostIP(String provisioningHostIP) {
        this.provisioningHostIP = provisioningHostIP;
    }

    @JsonIgnore
    public MetadataBuilder edit() {
        return new MetadataBuilder(this);
    }

    @JsonIgnore
    public MetadataBuilder toBuilder() {
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
        if (!(o instanceof Metadata)) {
            return false;
        }
        Metadata other = (Metadata) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bootstrapProvisioningIP = this.getBootstrapProvisioningIP();
        Object other$bootstrapProvisioningIP = other.getBootstrapProvisioningIP();
        if (this$bootstrapProvisioningIP == null ? other$bootstrapProvisioningIP != null : !this$bootstrapProvisioningIP.equals(other$bootstrapProvisioningIP)) {
            return false;
        }
        Object this$libvirtURI = this.getLibvirtURI();
        Object other$libvirtURI = other.getLibvirtURI();
        if (this$libvirtURI == null ? other$libvirtURI != null : !this$libvirtURI.equals(other$libvirtURI)) {
            return false;
        }
        Object this$provisioningHostIP = this.getProvisioningHostIP();
        Object other$provisioningHostIP = other.getProvisioningHostIP();
        if (this$provisioningHostIP == null ? other$provisioningHostIP != null : !this$provisioningHostIP.equals(other$provisioningHostIP)) {
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
        return other instanceof Metadata;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bootstrapProvisioningIP = this.getBootstrapProvisioningIP();
        result = result * prime + ($bootstrapProvisioningIP == null ? 43 : $bootstrapProvisioningIP.hashCode());
        Object $libvirtURI = this.getLibvirtURI();
        result = result * prime + ($libvirtURI == null ? 43 : $libvirtURI.hashCode());
        Object $provisioningHostIP = this.getProvisioningHostIP();
        result = result * prime + ($provisioningHostIP == null ? 43 : $provisioningHostIP.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metadata(" + "bootstrapProvisioningIP=" + this.getBootstrapProvisioningIP() + ", libvirtURI=" + this.getLibvirtURI() + ", provisioningHostIP=" + this.getProvisioningHostIP() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
