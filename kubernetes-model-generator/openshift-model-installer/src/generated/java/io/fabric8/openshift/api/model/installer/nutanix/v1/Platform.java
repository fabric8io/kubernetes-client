
package io.fabric8.openshift.api.model.installer.nutanix.v1;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.openshift.api.model.config.v1.NutanixPlatformLoadBalancer;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
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
    "apiVIP",
    "apiVIPs",
    "clusterOSImage",
    "defaultMachinePlatform",
    "ingressVIP",
    "ingressVIPs",
    "loadBalancer",
    "prismCentral",
    "prismElements",
    "subnetUUIDs"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class Platform implements KubernetesResource
{

    @JsonProperty("apiVIP")
    private String apiVIP;
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiVIPs = new ArrayList<String>();
    @JsonProperty("clusterOSImage")
    private String clusterOSImage;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("ingressVIP")
    private String ingressVIP;
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressVIPs = new ArrayList<String>();
    @JsonProperty("loadBalancer")
    private NutanixPlatformLoadBalancer loadBalancer;
    @JsonProperty("prismCentral")
    private PrismCentral prismCentral;
    @JsonProperty("prismElements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrismElement> prismElements = new ArrayList<PrismElement>();
    @JsonProperty("subnetUUIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subnetUUIDs = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(String apiVIP, List<String> apiVIPs, String clusterOSImage, MachinePool defaultMachinePlatform, String ingressVIP, List<String> ingressVIPs, NutanixPlatformLoadBalancer loadBalancer, PrismCentral prismCentral, List<PrismElement> prismElements, List<String> subnetUUIDs) {
        super();
        this.apiVIP = apiVIP;
        this.apiVIPs = apiVIPs;
        this.clusterOSImage = clusterOSImage;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.ingressVIP = ingressVIP;
        this.ingressVIPs = ingressVIPs;
        this.loadBalancer = loadBalancer;
        this.prismCentral = prismCentral;
        this.prismElements = prismElements;
        this.subnetUUIDs = subnetUUIDs;
    }

    @JsonProperty("apiVIP")
    public String getApiVIP() {
        return apiVIP;
    }

    @JsonProperty("apiVIP")
    public void setApiVIP(String apiVIP) {
        this.apiVIP = apiVIP;
    }

    @JsonProperty("apiVIPs")
    public List<String> getApiVIPs() {
        return apiVIPs;
    }

    @JsonProperty("apiVIPs")
    public void setApiVIPs(List<String> apiVIPs) {
        this.apiVIPs = apiVIPs;
    }

    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    @JsonProperty("ingressVIP")
    public String getIngressVIP() {
        return ingressVIP;
    }

    @JsonProperty("ingressVIP")
    public void setIngressVIP(String ingressVIP) {
        this.ingressVIP = ingressVIP;
    }

    @JsonProperty("ingressVIPs")
    public List<String> getIngressVIPs() {
        return ingressVIPs;
    }

    @JsonProperty("ingressVIPs")
    public void setIngressVIPs(List<String> ingressVIPs) {
        this.ingressVIPs = ingressVIPs;
    }

    @JsonProperty("loadBalancer")
    public NutanixPlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    @JsonProperty("loadBalancer")
    public void setLoadBalancer(NutanixPlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    @JsonProperty("prismCentral")
    public PrismCentral getPrismCentral() {
        return prismCentral;
    }

    @JsonProperty("prismCentral")
    public void setPrismCentral(PrismCentral prismCentral) {
        this.prismCentral = prismCentral;
    }

    @JsonProperty("prismElements")
    public List<PrismElement> getPrismElements() {
        return prismElements;
    }

    @JsonProperty("prismElements")
    public void setPrismElements(List<PrismElement> prismElements) {
        this.prismElements = prismElements;
    }

    @JsonProperty("subnetUUIDs")
    public List<String> getSubnetUUIDs() {
        return subnetUUIDs;
    }

    @JsonProperty("subnetUUIDs")
    public void setSubnetUUIDs(List<String> subnetUUIDs) {
        this.subnetUUIDs = subnetUUIDs;
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
