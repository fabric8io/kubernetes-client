
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "bootIsoSource",
    "disableVirtualMediaTLS",
    "preProvisioningOSDownloadURLs",
    "provisioningDHCPExternal",
    "provisioningDHCPRange",
    "provisioningDNS",
    "provisioningIP",
    "provisioningInterface",
    "provisioningMacAddresses",
    "provisioningNetwork",
    "provisioningNetworkCIDR",
    "provisioningOSDownloadURL",
    "virtualMediaViaExternalNetwork",
    "watchAllNamespaces"
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
public class ProvisioningSpec implements Editable<ProvisioningSpecBuilder> , KubernetesResource
{

    @JsonProperty("bootIsoSource")
    private String bootIsoSource;
    @JsonProperty("disableVirtualMediaTLS")
    private Boolean disableVirtualMediaTLS;
    @JsonProperty("preProvisioningOSDownloadURLs")
    private ProvisioningSpecPreProvisioningOSDownloadURLs preProvisioningOSDownloadURLs;
    @JsonProperty("provisioningDHCPExternal")
    private Boolean provisioningDHCPExternal;
    @JsonProperty("provisioningDHCPRange")
    private String provisioningDHCPRange;
    @JsonProperty("provisioningDNS")
    private Boolean provisioningDNS;
    @JsonProperty("provisioningIP")
    private String provisioningIP;
    @JsonProperty("provisioningInterface")
    private String provisioningInterface;
    @JsonProperty("provisioningMacAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> provisioningMacAddresses = new ArrayList<>();
    @JsonProperty("provisioningNetwork")
    private String provisioningNetwork;
    @JsonProperty("provisioningNetworkCIDR")
    private String provisioningNetworkCIDR;
    @JsonProperty("provisioningOSDownloadURL")
    private String provisioningOSDownloadURL;
    @JsonProperty("virtualMediaViaExternalNetwork")
    private Boolean virtualMediaViaExternalNetwork;
    @JsonProperty("watchAllNamespaces")
    private Boolean watchAllNamespaces;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProvisioningSpec() {
    }

    public ProvisioningSpec(String bootIsoSource, Boolean disableVirtualMediaTLS, ProvisioningSpecPreProvisioningOSDownloadURLs preProvisioningOSDownloadURLs, Boolean provisioningDHCPExternal, String provisioningDHCPRange, Boolean provisioningDNS, String provisioningIP, String provisioningInterface, List<String> provisioningMacAddresses, String provisioningNetwork, String provisioningNetworkCIDR, String provisioningOSDownloadURL, Boolean virtualMediaViaExternalNetwork, Boolean watchAllNamespaces) {
        super();
        this.bootIsoSource = bootIsoSource;
        this.disableVirtualMediaTLS = disableVirtualMediaTLS;
        this.preProvisioningOSDownloadURLs = preProvisioningOSDownloadURLs;
        this.provisioningDHCPExternal = provisioningDHCPExternal;
        this.provisioningDHCPRange = provisioningDHCPRange;
        this.provisioningDNS = provisioningDNS;
        this.provisioningIP = provisioningIP;
        this.provisioningInterface = provisioningInterface;
        this.provisioningMacAddresses = provisioningMacAddresses;
        this.provisioningNetwork = provisioningNetwork;
        this.provisioningNetworkCIDR = provisioningNetworkCIDR;
        this.provisioningOSDownloadURL = provisioningOSDownloadURL;
        this.virtualMediaViaExternalNetwork = virtualMediaViaExternalNetwork;
        this.watchAllNamespaces = watchAllNamespaces;
    }

    @JsonProperty("bootIsoSource")
    public String getBootIsoSource() {
        return bootIsoSource;
    }

    @JsonProperty("bootIsoSource")
    public void setBootIsoSource(String bootIsoSource) {
        this.bootIsoSource = bootIsoSource;
    }

    @JsonProperty("disableVirtualMediaTLS")
    public Boolean getDisableVirtualMediaTLS() {
        return disableVirtualMediaTLS;
    }

    @JsonProperty("disableVirtualMediaTLS")
    public void setDisableVirtualMediaTLS(Boolean disableVirtualMediaTLS) {
        this.disableVirtualMediaTLS = disableVirtualMediaTLS;
    }

    @JsonProperty("preProvisioningOSDownloadURLs")
    public ProvisioningSpecPreProvisioningOSDownloadURLs getPreProvisioningOSDownloadURLs() {
        return preProvisioningOSDownloadURLs;
    }

    @JsonProperty("preProvisioningOSDownloadURLs")
    public void setPreProvisioningOSDownloadURLs(ProvisioningSpecPreProvisioningOSDownloadURLs preProvisioningOSDownloadURLs) {
        this.preProvisioningOSDownloadURLs = preProvisioningOSDownloadURLs;
    }

    @JsonProperty("provisioningDHCPExternal")
    public Boolean getProvisioningDHCPExternal() {
        return provisioningDHCPExternal;
    }

    @JsonProperty("provisioningDHCPExternal")
    public void setProvisioningDHCPExternal(Boolean provisioningDHCPExternal) {
        this.provisioningDHCPExternal = provisioningDHCPExternal;
    }

    @JsonProperty("provisioningDHCPRange")
    public String getProvisioningDHCPRange() {
        return provisioningDHCPRange;
    }

    @JsonProperty("provisioningDHCPRange")
    public void setProvisioningDHCPRange(String provisioningDHCPRange) {
        this.provisioningDHCPRange = provisioningDHCPRange;
    }

    @JsonProperty("provisioningDNS")
    public Boolean getProvisioningDNS() {
        return provisioningDNS;
    }

    @JsonProperty("provisioningDNS")
    public void setProvisioningDNS(Boolean provisioningDNS) {
        this.provisioningDNS = provisioningDNS;
    }

    @JsonProperty("provisioningIP")
    public String getProvisioningIP() {
        return provisioningIP;
    }

    @JsonProperty("provisioningIP")
    public void setProvisioningIP(String provisioningIP) {
        this.provisioningIP = provisioningIP;
    }

    @JsonProperty("provisioningInterface")
    public String getProvisioningInterface() {
        return provisioningInterface;
    }

    @JsonProperty("provisioningInterface")
    public void setProvisioningInterface(String provisioningInterface) {
        this.provisioningInterface = provisioningInterface;
    }

    @JsonProperty("provisioningMacAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getProvisioningMacAddresses() {
        return provisioningMacAddresses;
    }

    @JsonProperty("provisioningMacAddresses")
    public void setProvisioningMacAddresses(List<String> provisioningMacAddresses) {
        this.provisioningMacAddresses = provisioningMacAddresses;
    }

    @JsonProperty("provisioningNetwork")
    public String getProvisioningNetwork() {
        return provisioningNetwork;
    }

    @JsonProperty("provisioningNetwork")
    public void setProvisioningNetwork(String provisioningNetwork) {
        this.provisioningNetwork = provisioningNetwork;
    }

    @JsonProperty("provisioningNetworkCIDR")
    public String getProvisioningNetworkCIDR() {
        return provisioningNetworkCIDR;
    }

    @JsonProperty("provisioningNetworkCIDR")
    public void setProvisioningNetworkCIDR(String provisioningNetworkCIDR) {
        this.provisioningNetworkCIDR = provisioningNetworkCIDR;
    }

    @JsonProperty("provisioningOSDownloadURL")
    public String getProvisioningOSDownloadURL() {
        return provisioningOSDownloadURL;
    }

    @JsonProperty("provisioningOSDownloadURL")
    public void setProvisioningOSDownloadURL(String provisioningOSDownloadURL) {
        this.provisioningOSDownloadURL = provisioningOSDownloadURL;
    }

    @JsonProperty("virtualMediaViaExternalNetwork")
    public Boolean getVirtualMediaViaExternalNetwork() {
        return virtualMediaViaExternalNetwork;
    }

    @JsonProperty("virtualMediaViaExternalNetwork")
    public void setVirtualMediaViaExternalNetwork(Boolean virtualMediaViaExternalNetwork) {
        this.virtualMediaViaExternalNetwork = virtualMediaViaExternalNetwork;
    }

    @JsonProperty("watchAllNamespaces")
    public Boolean getWatchAllNamespaces() {
        return watchAllNamespaces;
    }

    @JsonProperty("watchAllNamespaces")
    public void setWatchAllNamespaces(Boolean watchAllNamespaces) {
        this.watchAllNamespaces = watchAllNamespaces;
    }

    @JsonIgnore
    public ProvisioningSpecBuilder edit() {
        return new ProvisioningSpecBuilder(this);
    }

    @JsonIgnore
    public ProvisioningSpecBuilder toBuilder() {
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
