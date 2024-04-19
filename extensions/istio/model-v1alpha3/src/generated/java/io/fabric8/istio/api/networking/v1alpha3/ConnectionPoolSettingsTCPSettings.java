
package io.fabric8.istio.api.networking.v1alpha3;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "connectTimeout",
    "idleTimeout",
    "maxConnectionDuration",
    "maxConnections",
    "tcpKeepalive"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class ConnectionPoolSettingsTCPSettings implements Editable<ConnectionPoolSettingsTCPSettingsBuilder> , KubernetesResource
{

    @JsonProperty("connectTimeout")
    private String connectTimeout;
    @JsonProperty("idleTimeout")
    private String idleTimeout;
    @JsonProperty("maxConnectionDuration")
    private String maxConnectionDuration;
    @JsonProperty("maxConnections")
    private Integer maxConnections;
    @JsonProperty("tcpKeepalive")
    private ConnectionPoolSettingsTCPSettingsTcpKeepalive tcpKeepalive;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConnectionPoolSettingsTCPSettings() {
    }

    public ConnectionPoolSettingsTCPSettings(String connectTimeout, String idleTimeout, String maxConnectionDuration, Integer maxConnections, ConnectionPoolSettingsTCPSettingsTcpKeepalive tcpKeepalive) {
        super();
        this.connectTimeout = connectTimeout;
        this.idleTimeout = idleTimeout;
        this.maxConnectionDuration = maxConnectionDuration;
        this.maxConnections = maxConnections;
        this.tcpKeepalive = tcpKeepalive;
    }

    @JsonProperty("connectTimeout")
    public String getConnectTimeout() {
        return connectTimeout;
    }

    @JsonProperty("connectTimeout")
    public void setConnectTimeout(String connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    @JsonProperty("idleTimeout")
    public String getIdleTimeout() {
        return idleTimeout;
    }

    @JsonProperty("idleTimeout")
    public void setIdleTimeout(String idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    @JsonProperty("maxConnectionDuration")
    public String getMaxConnectionDuration() {
        return maxConnectionDuration;
    }

    @JsonProperty("maxConnectionDuration")
    public void setMaxConnectionDuration(String maxConnectionDuration) {
        this.maxConnectionDuration = maxConnectionDuration;
    }

    @JsonProperty("maxConnections")
    public Integer getMaxConnections() {
        return maxConnections;
    }

    @JsonProperty("maxConnections")
    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    @JsonProperty("tcpKeepalive")
    public ConnectionPoolSettingsTCPSettingsTcpKeepalive getTcpKeepalive() {
        return tcpKeepalive;
    }

    @JsonProperty("tcpKeepalive")
    public void setTcpKeepalive(ConnectionPoolSettingsTCPSettingsTcpKeepalive tcpKeepalive) {
        this.tcpKeepalive = tcpKeepalive;
    }

    @JsonIgnore
    public ConnectionPoolSettingsTCPSettingsBuilder edit() {
        return new ConnectionPoolSettingsTCPSettingsBuilder(this);
    }

    @JsonIgnore
    public ConnectionPoolSettingsTCPSettingsBuilder toBuilder() {
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

}
