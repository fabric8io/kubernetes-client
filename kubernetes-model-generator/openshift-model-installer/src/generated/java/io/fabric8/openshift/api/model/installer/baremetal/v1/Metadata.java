
package io.fabric8.openshift.api.model.installer.baremetal.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bootstrapProvisioningIP",
    "libvirtURI",
    "provisioningHostIP"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class Metadata implements Editable<MetadataBuilder> , KubernetesResource
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
     * 
     */
    public Metadata() {
    }

    public Metadata(String bootstrapProvisioningIP, String libvirtURI, String provisioningHostIP) {
        super();
        this.bootstrapProvisioningIP = bootstrapProvisioningIP;
        this.libvirtURI = libvirtURI;
        this.provisioningHostIP = provisioningHostIP;
    }

    @JsonProperty("bootstrapProvisioningIP")
    public String getBootstrapProvisioningIP() {
        return bootstrapProvisioningIP;
    }

    @JsonProperty("bootstrapProvisioningIP")
    public void setBootstrapProvisioningIP(String bootstrapProvisioningIP) {
        this.bootstrapProvisioningIP = bootstrapProvisioningIP;
    }

    @JsonProperty("libvirtURI")
    public String getLibvirtURI() {
        return libvirtURI;
    }

    @JsonProperty("libvirtURI")
    public void setLibvirtURI(String libvirtURI) {
        this.libvirtURI = libvirtURI;
    }

    @JsonProperty("provisioningHostIP")
    public String getProvisioningHostIP() {
        return provisioningHostIP;
    }

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

}
