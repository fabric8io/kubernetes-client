
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * NoOverlayConfig contains configuration options for networks operating in no-overlay mode.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "outboundSNAT",
    "routing"
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
public class NoOverlayConfig implements Editable<NoOverlayConfigBuilder>, KubernetesResource
{

    @JsonProperty("outboundSNAT")
    private String outboundSNAT;
    @JsonProperty("routing")
    private String routing;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NoOverlayConfig() {
    }

    public NoOverlayConfig(String outboundSNAT, String routing) {
        super();
        this.outboundSNAT = outboundSNAT;
        this.routing = routing;
    }

    /**
     * outboundSNAT defines the SNAT behavior for outbound traffic from pods. Allowed values are "Enabled" and "Disabled". When set to "Enabled", SNAT is performed on outbound traffic from pods. When set to "Disabled", SNAT is not performed and pod IPs are preserved in outbound traffic. This field is required when the network operates in no-overlay mode. This field can be set to any value at installation time and can be changed afterwards.
     */
    @JsonProperty("outboundSNAT")
    public String getOutboundSNAT() {
        return outboundSNAT;
    }

    /**
     * outboundSNAT defines the SNAT behavior for outbound traffic from pods. Allowed values are "Enabled" and "Disabled". When set to "Enabled", SNAT is performed on outbound traffic from pods. When set to "Disabled", SNAT is not performed and pod IPs are preserved in outbound traffic. This field is required when the network operates in no-overlay mode. This field can be set to any value at installation time and can be changed afterwards.
     */
    @JsonProperty("outboundSNAT")
    public void setOutboundSNAT(String outboundSNAT) {
        this.outboundSNAT = outboundSNAT;
    }

    /**
     * routing specifies whether the pod network routing is managed by OVN-Kubernetes or users. Allowed values are "Managed" and "Unmanaged". When set to "Managed", OVN-Kubernetes manages the pod network routing configuration through BGP. When set to "Unmanaged", users are responsible for configuring the pod network routing. This field is required when the network operates in no-overlay mode. This field is immutable once set.
     */
    @JsonProperty("routing")
    public String getRouting() {
        return routing;
    }

    /**
     * routing specifies whether the pod network routing is managed by OVN-Kubernetes or users. Allowed values are "Managed" and "Unmanaged". When set to "Managed", OVN-Kubernetes manages the pod network routing configuration through BGP. When set to "Unmanaged", users are responsible for configuring the pod network routing. This field is required when the network operates in no-overlay mode. This field is immutable once set.
     */
    @JsonProperty("routing")
    public void setRouting(String routing) {
        this.routing = routing;
    }

    @JsonIgnore
    public NoOverlayConfigBuilder edit() {
        return new NoOverlayConfigBuilder(this);
    }

    @JsonIgnore
    public NoOverlayConfigBuilder toBuilder() {
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
