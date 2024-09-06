
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
    "initramfsURL",
    "isoURL",
    "kernelURL",
    "rootfsURL"
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
public class ProvisioningSpecPreProvisioningOSDownloadURLs implements Editable<ProvisioningSpecPreProvisioningOSDownloadURLsBuilder> , KubernetesResource
{

    @JsonProperty("initramfsURL")
    private String initramfsURL;
    @JsonProperty("isoURL")
    private String isoURL;
    @JsonProperty("kernelURL")
    private String kernelURL;
    @JsonProperty("rootfsURL")
    private String rootfsURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProvisioningSpecPreProvisioningOSDownloadURLs() {
    }

    public ProvisioningSpecPreProvisioningOSDownloadURLs(String initramfsURL, String isoURL, String kernelURL, String rootfsURL) {
        super();
        this.initramfsURL = initramfsURL;
        this.isoURL = isoURL;
        this.kernelURL = kernelURL;
        this.rootfsURL = rootfsURL;
    }

    @JsonProperty("initramfsURL")
    public String getInitramfsURL() {
        return initramfsURL;
    }

    @JsonProperty("initramfsURL")
    public void setInitramfsURL(String initramfsURL) {
        this.initramfsURL = initramfsURL;
    }

    @JsonProperty("isoURL")
    public String getIsoURL() {
        return isoURL;
    }

    @JsonProperty("isoURL")
    public void setIsoURL(String isoURL) {
        this.isoURL = isoURL;
    }

    @JsonProperty("kernelURL")
    public String getKernelURL() {
        return kernelURL;
    }

    @JsonProperty("kernelURL")
    public void setKernelURL(String kernelURL) {
        this.kernelURL = kernelURL;
    }

    @JsonProperty("rootfsURL")
    public String getRootfsURL() {
        return rootfsURL;
    }

    @JsonProperty("rootfsURL")
    public void setRootfsURL(String rootfsURL) {
        this.rootfsURL = rootfsURL;
    }

    @JsonIgnore
    public ProvisioningSpecPreProvisioningOSDownloadURLsBuilder edit() {
        return new ProvisioningSpecPreProvisioningOSDownloadURLsBuilder(this);
    }

    @JsonIgnore
    public ProvisioningSpecPreProvisioningOSDownloadURLsBuilder toBuilder() {
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
