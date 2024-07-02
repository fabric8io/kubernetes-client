
package io.fabric8.kubernetes.api.model.ovn.v1;

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
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidrSelector",
    "dnsName",
    "nodeSelector"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
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
@Generated("jsonschema2pojo")
public class EgressFirewallDestination implements Editable<EgressFirewallDestinationBuilder> , KubernetesResource
{

    @JsonProperty("cidrSelector")
    private String cidrSelector;
    @JsonProperty("dnsName")
    private String dnsName;
    @JsonProperty("nodeSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector nodeSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EgressFirewallDestination() {
    }

    public EgressFirewallDestination(String cidrSelector, String dnsName, io.fabric8.kubernetes.api.model.LabelSelector nodeSelector) {
        super();
        this.cidrSelector = cidrSelector;
        this.dnsName = dnsName;
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("cidrSelector")
    public String getCidrSelector() {
        return cidrSelector;
    }

    @JsonProperty("cidrSelector")
    public void setCidrSelector(String cidrSelector) {
        this.cidrSelector = cidrSelector;
    }

    @JsonProperty("dnsName")
    public String getDnsName() {
        return dnsName;
    }

    @JsonProperty("dnsName")
    public void setDnsName(String dnsName) {
        this.dnsName = dnsName;
    }

    @JsonProperty("nodeSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(io.fabric8.kubernetes.api.model.LabelSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonIgnore
    public EgressFirewallDestinationBuilder edit() {
        return new EgressFirewallDestinationBuilder(this);
    }

    @JsonIgnore
    public EgressFirewallDestinationBuilder toBuilder() {
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
