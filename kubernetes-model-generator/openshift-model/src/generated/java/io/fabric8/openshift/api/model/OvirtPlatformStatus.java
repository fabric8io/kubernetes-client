
package io.fabric8.openshift.api.model;

import java.util.HashMap;
import java.util.Map;
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "apiServerInternalIP",
    "ingressIP",
    "nodeDNSIP"
})
@ToString
@EqualsAndHashCode
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
public class OvirtPlatformStatus implements KubernetesResource
{

    @JsonProperty("apiServerInternalIP")
    private String apiServerInternalIP;
    @JsonProperty("ingressIP")
    private String ingressIP;
    @JsonProperty("nodeDNSIP")
    private String nodeDNSIP;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OvirtPlatformStatus() {
    }

    /**
     * 
     * @param apiServerInternalIP
     * @param nodeDNSIP
     * @param ingressIP
     */
    public OvirtPlatformStatus(String apiServerInternalIP, String ingressIP, String nodeDNSIP) {
        super();
        this.apiServerInternalIP = apiServerInternalIP;
        this.ingressIP = ingressIP;
        this.nodeDNSIP = nodeDNSIP;
    }

    @JsonProperty("apiServerInternalIP")
    public String getApiServerInternalIP() {
        return apiServerInternalIP;
    }

    @JsonProperty("apiServerInternalIP")
    public void setApiServerInternalIP(String apiServerInternalIP) {
        this.apiServerInternalIP = apiServerInternalIP;
    }

    @JsonProperty("ingressIP")
    public String getIngressIP() {
        return ingressIP;
    }

    @JsonProperty("ingressIP")
    public void setIngressIP(String ingressIP) {
        this.ingressIP = ingressIP;
    }

    @JsonProperty("nodeDNSIP")
    public String getNodeDNSIP() {
        return nodeDNSIP;
    }

    @JsonProperty("nodeDNSIP")
    public void setNodeDNSIP(String nodeDNSIP) {
        this.nodeDNSIP = nodeDNSIP;
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
