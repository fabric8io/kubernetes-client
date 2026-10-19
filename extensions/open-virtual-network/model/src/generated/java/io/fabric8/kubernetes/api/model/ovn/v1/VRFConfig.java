
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
 * VRFConfig contains configuration for a VRF in EVPN.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "routeTarget",
    "vni"
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
public class VRFConfig implements Editable<VRFConfigBuilder>, KubernetesResource
{

    @JsonProperty("routeTarget")
    private String routeTarget;
    @JsonProperty("vni")
    private Integer vni;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VRFConfig() {
    }

    public VRFConfig(String routeTarget, Integer vni) {
        super();
        this.routeTarget = routeTarget;
        this.vni = vni;
    }

    /**
     * RouteTarget is the import/export route target for this VRF. If not specified, it will be auto-generated as "&lt;AS (Autonomous System)&gt;:&lt;VNI (Virtual Network Identifier)&gt;". Auto-generation will use 2-byte AS if VNI &gt; 65535, since 4-byte AS/IPv4 only allows 2-byte local admin.<br><p> <br><p> Follows FRR EVPN L3 Route-Target format (A.B.C.D:MN|EF:OPQR|GHJK:MN|&#42;:OPQR|&#42;:MN):<br><p>   - EF:OPQR   = 2-byte AS (1-65535) : local admin (4 bytes, 1-4294967295)<br><p>   - GHJK:MN   = 4-byte AS (65536-4294967295) : local admin (2 bytes, 1-65535)<br><p>   - A.B.C.D:MN = IPv4 address : local admin (2 bytes, 1-65535)<br><p>   - &#42;:OPQR    = wildcard AS : local admin (4 bytes, 1-4294967295) - for import matching<br><p>   - &#42;:MN      = wildcard AS : local admin (2 bytes, 1-65535) - for import matching<br><p> <br><p> The 6-byte value constraint (RFC 4360) means AS size + local admin size = 6 bytes.
     */
    @JsonProperty("routeTarget")
    public String getRouteTarget() {
        return routeTarget;
    }

    /**
     * RouteTarget is the import/export route target for this VRF. If not specified, it will be auto-generated as "&lt;AS (Autonomous System)&gt;:&lt;VNI (Virtual Network Identifier)&gt;". Auto-generation will use 2-byte AS if VNI &gt; 65535, since 4-byte AS/IPv4 only allows 2-byte local admin.<br><p> <br><p> Follows FRR EVPN L3 Route-Target format (A.B.C.D:MN|EF:OPQR|GHJK:MN|&#42;:OPQR|&#42;:MN):<br><p>   - EF:OPQR   = 2-byte AS (1-65535) : local admin (4 bytes, 1-4294967295)<br><p>   - GHJK:MN   = 4-byte AS (65536-4294967295) : local admin (2 bytes, 1-65535)<br><p>   - A.B.C.D:MN = IPv4 address : local admin (2 bytes, 1-65535)<br><p>   - &#42;:OPQR    = wildcard AS : local admin (4 bytes, 1-4294967295) - for import matching<br><p>   - &#42;:MN      = wildcard AS : local admin (2 bytes, 1-65535) - for import matching<br><p> <br><p> The 6-byte value constraint (RFC 4360) means AS size + local admin size = 6 bytes.
     */
    @JsonProperty("routeTarget")
    public void setRouteTarget(String routeTarget) {
        this.routeTarget = routeTarget;
    }

    /**
     * VNI is the Virtual Network Identifier for this VRF. VNI is a 24-bit field in the VXLAN header (RFC 7348), allowing values from 1 to 16777215. but in the future this could be having different limit for other dataplane implementations. Must be unique across all EVPN configurations in the cluster.
     */
    @JsonProperty("vni")
    public Integer getVni() {
        return vni;
    }

    /**
     * VNI is the Virtual Network Identifier for this VRF. VNI is a 24-bit field in the VXLAN header (RFC 7348), allowing values from 1 to 16777215. but in the future this could be having different limit for other dataplane implementations. Must be unique across all EVPN configurations in the cluster.
     */
    @JsonProperty("vni")
    public void setVni(Integer vni) {
        this.vni = vni;
    }

    @JsonIgnore
    public VRFConfigBuilder edit() {
        return new VRFConfigBuilder(this);
    }

    @JsonIgnore
    public VRFConfigBuilder toBuilder() {
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
