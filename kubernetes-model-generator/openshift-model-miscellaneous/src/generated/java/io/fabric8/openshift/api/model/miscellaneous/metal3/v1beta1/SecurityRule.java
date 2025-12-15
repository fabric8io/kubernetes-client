
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * SecurityRule defines an Azure security rule for security groups.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "description",
    "destination",
    "destinationPorts",
    "direction",
    "name",
    "priority",
    "protocol",
    "source",
    "sourcePorts",
    "sources"
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
public class SecurityRule implements Editable<SecurityRuleBuilder>, KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("description")
    private String description;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("destinationPorts")
    private String destinationPorts;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("name")
    private String name;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("source")
    private String source;
    @JsonProperty("sourcePorts")
    private String sourcePorts;
    @JsonProperty("sources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> sources = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SecurityRule() {
    }

    public SecurityRule(String action, String description, String destination, String destinationPorts, String direction, String name, Integer priority, String protocol, String source, String sourcePorts, List<String> sources) {
        super();
        this.action = action;
        this.description = description;
        this.destination = destination;
        this.destinationPorts = destinationPorts;
        this.direction = direction;
        this.name = name;
        this.priority = priority;
        this.protocol = protocol;
        this.source = source;
        this.sourcePorts = sourcePorts;
        this.sources = sources;
    }

    /**
     * Action specifies whether network traffic is allowed or denied. Can either be "Allow" or "Deny". Defaults to "Allow".
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * Action specifies whether network traffic is allowed or denied. Can either be "Allow" or "Deny". Defaults to "Allow".
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * A description for this rule. Restricted to 140 chars.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * A description for this rule. Restricted to 140 chars.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Destination is the destination address prefix. CIDR or destination IP range. Asterix '&#42;' can also be used to match all source IPs. Default tags such as 'VirtualNetwork', 'AzureLoadBalancer' and 'Internet' can also be used.
     */
    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    /**
     * Destination is the destination address prefix. CIDR or destination IP range. Asterix '&#42;' can also be used to match all source IPs. Default tags such as 'VirtualNetwork', 'AzureLoadBalancer' and 'Internet' can also be used.
     */
    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * DestinationPorts specifies the destination port or range. Integer or range between 0 and 65535. Asterix '&#42;' can also be used to match all ports.
     */
    @JsonProperty("destinationPorts")
    public String getDestinationPorts() {
        return destinationPorts;
    }

    /**
     * DestinationPorts specifies the destination port or range. Integer or range between 0 and 65535. Asterix '&#42;' can also be used to match all ports.
     */
    @JsonProperty("destinationPorts")
    public void setDestinationPorts(String destinationPorts) {
        this.destinationPorts = destinationPorts;
    }

    /**
     * Direction indicates whether the rule applies to inbound, or outbound traffic. "Inbound" or "Outbound".
     */
    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    /**
     * Direction indicates whether the rule applies to inbound, or outbound traffic. "Inbound" or "Outbound".
     */
    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Name is a unique name within the network security group.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is a unique name within the network security group.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Priority is a number between 100 and 4096. Each rule should have a unique value for priority. Rules are processed in priority order, with lower numbers processed before higher numbers. Once traffic matches a rule, processing stops.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * Priority is a number between 100 and 4096. Each rule should have a unique value for priority. Rules are processed in priority order, with lower numbers processed before higher numbers. Once traffic matches a rule, processing stops.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * Protocol specifies the protocol type. "Tcp", "Udp", "Icmp", or "&#42;".
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * Protocol specifies the protocol type. "Tcp", "Udp", "Icmp", or "&#42;".
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Source specifies the CIDR or source IP range. Asterix '&#42;' can also be used to match all source IPs. Default tags such as 'VirtualNetwork', 'AzureLoadBalancer' and 'Internet' can also be used. If this is an ingress rule, specifies where network traffic originates from.
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * Source specifies the CIDR or source IP range. Asterix '&#42;' can also be used to match all source IPs. Default tags such as 'VirtualNetwork', 'AzureLoadBalancer' and 'Internet' can also be used. If this is an ingress rule, specifies where network traffic originates from.
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * SourcePorts specifies source port or range. Integer or range between 0 and 65535. Asterix '&#42;' can also be used to match all ports.
     */
    @JsonProperty("sourcePorts")
    public String getSourcePorts() {
        return sourcePorts;
    }

    /**
     * SourcePorts specifies source port or range. Integer or range between 0 and 65535. Asterix '&#42;' can also be used to match all ports.
     */
    @JsonProperty("sourcePorts")
    public void setSourcePorts(String sourcePorts) {
        this.sourcePorts = sourcePorts;
    }

    /**
     * Sources specifies The CIDR or source IP ranges.
     */
    @JsonProperty("sources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSources() {
        return sources;
    }

    /**
     * Sources specifies The CIDR or source IP ranges.
     */
    @JsonProperty("sources")
    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    @JsonIgnore
    public SecurityRuleBuilder edit() {
        return new SecurityRuleBuilder(this);
    }

    @JsonIgnore
    public SecurityRuleBuilder toBuilder() {
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

}
