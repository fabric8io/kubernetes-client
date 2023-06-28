
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "egressCIDRs",
    "egressIPs",
    "host",
    "hostIP",
    "subnet"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("network.openshift.io")
@Generated("jsonschema2pojo")
public class HostSubnet implements HasMetadata
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "network.openshift.io/v1";
    @JsonProperty("egressCIDRs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> egressCIDRs = new ArrayList<String>();
    @JsonProperty("egressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> egressIPs = new ArrayList<String>();
    @JsonProperty("host")
    private String host;
    @JsonProperty("hostIP")
    private String hostIP;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "HostSubnet";
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("subnet")
    private String subnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HostSubnet() {
    }

    public HostSubnet(String apiVersion, List<String> egressCIDRs, List<String> egressIPs, String host, String hostIP, String kind, io.fabric8.kubernetes.api.model.ObjectMeta metadata, String subnet) {
        super();
        this.apiVersion = apiVersion;
        this.egressCIDRs = egressCIDRs;
        this.egressIPs = egressIPs;
        this.host = host;
        this.hostIP = hostIP;
        this.kind = kind;
        this.metadata = metadata;
        this.subnet = subnet;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("egressCIDRs")
    public List<String> getEgressCIDRs() {
        return egressCIDRs;
    }

    @JsonProperty("egressCIDRs")
    public void setEgressCIDRs(List<String> egressCIDRs) {
        this.egressCIDRs = egressCIDRs;
    }

    @JsonProperty("egressIPs")
    public List<String> getEgressIPs() {
        return egressIPs;
    }

    @JsonProperty("egressIPs")
    public void setEgressIPs(List<String> egressIPs) {
        this.egressIPs = egressIPs;
    }

    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("hostIP")
    public String getHostIP() {
        return hostIP;
    }

    @JsonProperty("hostIP")
    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public io.fabric8.kubernetes.api.model.ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(io.fabric8.kubernetes.api.model.ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("subnet")
    public String getSubnet() {
        return subnet;
    }

    @JsonProperty("subnet")
    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
