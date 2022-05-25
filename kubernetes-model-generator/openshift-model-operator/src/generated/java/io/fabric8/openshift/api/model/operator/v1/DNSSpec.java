
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "logLevel",
    "managementState",
    "nodePlacement",
    "operatorLogLevel",
    "servers",
    "upstreamResolvers"
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
public class DNSSpec implements KubernetesResource
{

    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("nodePlacement")
    private DNSNodePlacement nodePlacement;
    @JsonProperty("operatorLogLevel")
    private String operatorLogLevel;
    @JsonProperty("servers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Server> servers = new ArrayList<Server>();
    @JsonProperty("upstreamResolvers")
    private UpstreamResolvers upstreamResolvers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DNSSpec() {
    }

    /**
     * 
     * @param nodePlacement
     * @param servers
     * @param upstreamResolvers
     * @param logLevel
     * @param operatorLogLevel
     * @param managementState
     */
    public DNSSpec(String logLevel, String managementState, DNSNodePlacement nodePlacement, String operatorLogLevel, List<Server> servers, UpstreamResolvers upstreamResolvers) {
        super();
        this.logLevel = logLevel;
        this.managementState = managementState;
        this.nodePlacement = nodePlacement;
        this.operatorLogLevel = operatorLogLevel;
        this.servers = servers;
        this.upstreamResolvers = upstreamResolvers;
    }

    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    @JsonProperty("nodePlacement")
    public DNSNodePlacement getNodePlacement() {
        return nodePlacement;
    }

    @JsonProperty("nodePlacement")
    public void setNodePlacement(DNSNodePlacement nodePlacement) {
        this.nodePlacement = nodePlacement;
    }

    @JsonProperty("operatorLogLevel")
    public String getOperatorLogLevel() {
        return operatorLogLevel;
    }

    @JsonProperty("operatorLogLevel")
    public void setOperatorLogLevel(String operatorLogLevel) {
        this.operatorLogLevel = operatorLogLevel;
    }

    @JsonProperty("servers")
    public List<Server> getServers() {
        return servers;
    }

    @JsonProperty("servers")
    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    @JsonProperty("upstreamResolvers")
    public UpstreamResolvers getUpstreamResolvers() {
        return upstreamResolvers;
    }

    @JsonProperty("upstreamResolvers")
    public void setUpstreamResolvers(UpstreamResolvers upstreamResolvers) {
        this.upstreamResolvers = upstreamResolvers;
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
