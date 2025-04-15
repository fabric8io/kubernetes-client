
package io.fabric8.kubernetes.api.model.ovn.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * EgressFirewallDestination is the target that traffic is either allowed or denied to
 */
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
public class EgressFirewallDestination implements Editable<EgressFirewallDestinationBuilder>, KubernetesResource
{

    @JsonProperty("cidrSelector")
    private String cidrSelector;
    @JsonProperty("dnsName")
    private String dnsName;
    @JsonProperty("nodeSelector")
    private LabelSelector nodeSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EgressFirewallDestination() {
    }

    public EgressFirewallDestination(String cidrSelector, String dnsName, LabelSelector nodeSelector) {
        super();
        this.cidrSelector = cidrSelector;
        this.dnsName = dnsName;
        this.nodeSelector = nodeSelector;
    }

    /**
     * cidrSelector is the CIDR range to allow/deny traffic to. If this is set, dnsName and nodeSelector must be unset.
     */
    @JsonProperty("cidrSelector")
    public String getCidrSelector() {
        return cidrSelector;
    }

    /**
     * cidrSelector is the CIDR range to allow/deny traffic to. If this is set, dnsName and nodeSelector must be unset.
     */
    @JsonProperty("cidrSelector")
    public void setCidrSelector(String cidrSelector) {
        this.cidrSelector = cidrSelector;
    }

    /**
     * dnsName is the domain name to allow/deny traffic to. If this is set, cidrSelector and nodeSelector must be unset. For a wildcard DNS name, the '&#42;' will match only one label. Additionally, only a single '&#42;' can be used at the beginning of the wildcard DNS name. For example, '&#42;.example.com' will match 'sub1.example.com' but won't match 'sub2.sub1.example.com'.
     */
    @JsonProperty("dnsName")
    public String getDnsName() {
        return dnsName;
    }

    /**
     * dnsName is the domain name to allow/deny traffic to. If this is set, cidrSelector and nodeSelector must be unset. For a wildcard DNS name, the '&#42;' will match only one label. Additionally, only a single '&#42;' can be used at the beginning of the wildcard DNS name. For example, '&#42;.example.com' will match 'sub1.example.com' but won't match 'sub2.sub1.example.com'.
     */
    @JsonProperty("dnsName")
    public void setDnsName(String dnsName) {
        this.dnsName = dnsName;
    }

    /**
     * EgressFirewallDestination is the target that traffic is either allowed or denied to
     */
    @JsonProperty("nodeSelector")
    public LabelSelector getNodeSelector() {
        return nodeSelector;
    }

    /**
     * EgressFirewallDestination is the target that traffic is either allowed or denied to
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(LabelSelector nodeSelector) {
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
