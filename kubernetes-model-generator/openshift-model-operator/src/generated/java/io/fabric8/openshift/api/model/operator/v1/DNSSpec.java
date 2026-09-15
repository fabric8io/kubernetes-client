
package io.fabric8.openshift.api.model.operator.v1;

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

/**
 * DNSSpec is the specification of the desired behavior of the DNS.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cache",
    "logLevel",
    "managementState",
    "nodePlacement",
    "operatorLogLevel",
    "servers",
    "upstreamResolvers"
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
public class DNSSpec implements Editable<DNSSpecBuilder>, KubernetesResource
{

    @JsonProperty("cache")
    private DNSCache cache;
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
    private List<Server> servers = new ArrayList<>();
    @JsonProperty("upstreamResolvers")
    private UpstreamResolvers upstreamResolvers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSSpec() {
    }

    public DNSSpec(DNSCache cache, String logLevel, String managementState, DNSNodePlacement nodePlacement, String operatorLogLevel, List<Server> servers, UpstreamResolvers upstreamResolvers) {
        super();
        this.cache = cache;
        this.logLevel = logLevel;
        this.managementState = managementState;
        this.nodePlacement = nodePlacement;
        this.operatorLogLevel = operatorLogLevel;
        this.servers = servers;
        this.upstreamResolvers = upstreamResolvers;
    }

    /**
     * DNSSpec is the specification of the desired behavior of the DNS.
     */
    @JsonProperty("cache")
    public DNSCache getCache() {
        return cache;
    }

    /**
     * DNSSpec is the specification of the desired behavior of the DNS.
     */
    @JsonProperty("cache")
    public void setCache(DNSCache cache) {
        this.cache = cache;
    }

    /**
     * logLevel describes the desired logging verbosity for CoreDNS. Any one of the following values may be specified: &#42; Normal logs errors from upstream resolvers. &#42; Debug logs errors, NXDOMAIN responses, and NODATA responses. &#42; Trace logs errors and all responses.<br><p>  Setting logLevel: Trace will produce extremely verbose logs.<br><p> Valid values are: "Normal", "Debug", "Trace". Defaults to "Normal".
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * logLevel describes the desired logging verbosity for CoreDNS. Any one of the following values may be specified: &#42; Normal logs errors from upstream resolvers. &#42; Debug logs errors, NXDOMAIN responses, and NODATA responses. &#42; Trace logs errors and all responses.<br><p>  Setting logLevel: Trace will produce extremely verbose logs.<br><p> Valid values are: "Normal", "Debug", "Trace". Defaults to "Normal".
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * managementState indicates whether the DNS operator should manage cluster DNS
     */
    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    /**
     * managementState indicates whether the DNS operator should manage cluster DNS
     */
    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    /**
     * DNSSpec is the specification of the desired behavior of the DNS.
     */
    @JsonProperty("nodePlacement")
    public DNSNodePlacement getNodePlacement() {
        return nodePlacement;
    }

    /**
     * DNSSpec is the specification of the desired behavior of the DNS.
     */
    @JsonProperty("nodePlacement")
    public void setNodePlacement(DNSNodePlacement nodePlacement) {
        this.nodePlacement = nodePlacement;
    }

    /**
     * operatorLogLevel controls the logging level of the DNS Operator. Valid values are: "Normal", "Debug", "Trace". Defaults to "Normal". setting operatorLogLevel: Trace will produce extremely verbose logs.
     */
    @JsonProperty("operatorLogLevel")
    public String getOperatorLogLevel() {
        return operatorLogLevel;
    }

    /**
     * operatorLogLevel controls the logging level of the DNS Operator. Valid values are: "Normal", "Debug", "Trace". Defaults to "Normal". setting operatorLogLevel: Trace will produce extremely verbose logs.
     */
    @JsonProperty("operatorLogLevel")
    public void setOperatorLogLevel(String operatorLogLevel) {
        this.operatorLogLevel = operatorLogLevel;
    }

    /**
     * servers is a list of DNS resolvers that provide name query delegation for one or more subdomains outside the scope of the cluster domain. If servers consists of more than one Server, longest suffix match will be used to determine the Server.<br><p> <br><p> For example, if there are two Servers, one for "foo.com" and another for "a.foo.com", and the name query is for "www.a.foo.com", it will be routed to the Server with Zone "a.foo.com".<br><p> <br><p> If this field is nil, no servers are created.
     */
    @JsonProperty("servers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Server> getServers() {
        return servers;
    }

    /**
     * servers is a list of DNS resolvers that provide name query delegation for one or more subdomains outside the scope of the cluster domain. If servers consists of more than one Server, longest suffix match will be used to determine the Server.<br><p> <br><p> For example, if there are two Servers, one for "foo.com" and another for "a.foo.com", and the name query is for "www.a.foo.com", it will be routed to the Server with Zone "a.foo.com".<br><p> <br><p> If this field is nil, no servers are created.
     */
    @JsonProperty("servers")
    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    /**
     * DNSSpec is the specification of the desired behavior of the DNS.
     */
    @JsonProperty("upstreamResolvers")
    public UpstreamResolvers getUpstreamResolvers() {
        return upstreamResolvers;
    }

    /**
     * DNSSpec is the specification of the desired behavior of the DNS.
     */
    @JsonProperty("upstreamResolvers")
    public void setUpstreamResolvers(UpstreamResolvers upstreamResolvers) {
        this.upstreamResolvers = upstreamResolvers;
    }

    @JsonIgnore
    public DNSSpecBuilder edit() {
        return new DNSSpecBuilder(this);
    }

    @JsonIgnore
    public DNSSpecBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DNSSpec)) {
            return false;
        }
        DNSSpec other = (DNSSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cache = this.getCache();
        Object other$cache = other.getCache();
        if (this$cache == null ? other$cache != null : !this$cache.equals(other$cache)) {
            return false;
        }
        Object this$logLevel = this.getLogLevel();
        Object other$logLevel = other.getLogLevel();
        if (this$logLevel == null ? other$logLevel != null : !this$logLevel.equals(other$logLevel)) {
            return false;
        }
        Object this$managementState = this.getManagementState();
        Object other$managementState = other.getManagementState();
        if (this$managementState == null ? other$managementState != null : !this$managementState.equals(other$managementState)) {
            return false;
        }
        Object this$nodePlacement = this.getNodePlacement();
        Object other$nodePlacement = other.getNodePlacement();
        if (this$nodePlacement == null ? other$nodePlacement != null : !this$nodePlacement.equals(other$nodePlacement)) {
            return false;
        }
        Object this$operatorLogLevel = this.getOperatorLogLevel();
        Object other$operatorLogLevel = other.getOperatorLogLevel();
        if (this$operatorLogLevel == null ? other$operatorLogLevel != null : !this$operatorLogLevel.equals(other$operatorLogLevel)) {
            return false;
        }
        Object this$servers = this.getServers();
        Object other$servers = other.getServers();
        if (this$servers == null ? other$servers != null : !this$servers.equals(other$servers)) {
            return false;
        }
        Object this$upstreamResolvers = this.getUpstreamResolvers();
        Object other$upstreamResolvers = other.getUpstreamResolvers();
        if (this$upstreamResolvers == null ? other$upstreamResolvers != null : !this$upstreamResolvers.equals(other$upstreamResolvers)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof DNSSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cache = this.getCache();
        result = result * prime + ($cache == null ? 43 : $cache.hashCode());
        Object $logLevel = this.getLogLevel();
        result = result * prime + ($logLevel == null ? 43 : $logLevel.hashCode());
        Object $managementState = this.getManagementState();
        result = result * prime + ($managementState == null ? 43 : $managementState.hashCode());
        Object $nodePlacement = this.getNodePlacement();
        result = result * prime + ($nodePlacement == null ? 43 : $nodePlacement.hashCode());
        Object $operatorLogLevel = this.getOperatorLogLevel();
        result = result * prime + ($operatorLogLevel == null ? 43 : $operatorLogLevel.hashCode());
        Object $servers = this.getServers();
        result = result * prime + ($servers == null ? 43 : $servers.hashCode());
        Object $upstreamResolvers = this.getUpstreamResolvers();
        result = result * prime + ($upstreamResolvers == null ? 43 : $upstreamResolvers.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSSpec(" + "cache=" + this.getCache() + ", logLevel=" + this.getLogLevel() + ", managementState=" + this.getManagementState() + ", nodePlacement=" + this.getNodePlacement() + ", operatorLogLevel=" + this.getOperatorLogLevel() + ", servers=" + this.getServers() + ", upstreamResolvers=" + this.getUpstreamResolvers() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
