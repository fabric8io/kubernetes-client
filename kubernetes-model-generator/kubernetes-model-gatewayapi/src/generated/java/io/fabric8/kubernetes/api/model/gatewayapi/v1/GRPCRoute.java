
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * GRPCRoute provides a way to route gRPC requests. This includes the capability to match requests by hostname, gRPC service, gRPC method, or HTTP/2 header. Filters can be used to specify additional processing steps. Backends specify where matching requests will be routed.<br><p> <br><p> GRPCRoute falls under extended support within the Gateway API. Within the following specification, the word "MUST" indicates that an implementation supporting GRPCRoute must conform to the indicated requirement, but an implementation not supporting this route type need not follow the requirement unless explicitly indicated.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTPS` `ProtocolType` MUST accept HTTP/2 connections without an initial upgrade from HTTP/1.1, i.e. via ALPN. If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol".  Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTP` `ProtocolType` MUST support HTTP/2 over cleartext TCP (h2c, https://www.rfc-editor.org/rfc/rfc7540#section-3.1) without an initial upgrade from HTTP/1.1, i.e. with prior knowledge (https://www.rfc-editor.org/rfc/rfc7540#section-3.4). If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol". Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1, i.e. without prior knowledge.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec",
    "status"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("gateway.networking.k8s.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GRPCRoute implements Editable<GRPCRouteBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "gateway.networking.k8s.io/v1";
    @JsonProperty("kind")
    private String kind = "GRPCRoute";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private GRPCRouteSpec spec;
    @JsonProperty("status")
    private GRPCRouteStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GRPCRoute() {
    }

    public GRPCRoute(String apiVersion, String kind, ObjectMeta metadata, GRPCRouteSpec spec, GRPCRouteStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * GRPCRoute provides a way to route gRPC requests. This includes the capability to match requests by hostname, gRPC service, gRPC method, or HTTP/2 header. Filters can be used to specify additional processing steps. Backends specify where matching requests will be routed.<br><p> <br><p> GRPCRoute falls under extended support within the Gateway API. Within the following specification, the word "MUST" indicates that an implementation supporting GRPCRoute must conform to the indicated requirement, but an implementation not supporting this route type need not follow the requirement unless explicitly indicated.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTPS` `ProtocolType` MUST accept HTTP/2 connections without an initial upgrade from HTTP/1.1, i.e. via ALPN. If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol".  Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTP` `ProtocolType` MUST support HTTP/2 over cleartext TCP (h2c, https://www.rfc-editor.org/rfc/rfc7540#section-3.1) without an initial upgrade from HTTP/1.1, i.e. with prior knowledge (https://www.rfc-editor.org/rfc/rfc7540#section-3.4). If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol". Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1, i.e. without prior knowledge.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * GRPCRoute provides a way to route gRPC requests. This includes the capability to match requests by hostname, gRPC service, gRPC method, or HTTP/2 header. Filters can be used to specify additional processing steps. Backends specify where matching requests will be routed.<br><p> <br><p> GRPCRoute falls under extended support within the Gateway API. Within the following specification, the word "MUST" indicates that an implementation supporting GRPCRoute must conform to the indicated requirement, but an implementation not supporting this route type need not follow the requirement unless explicitly indicated.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTPS` `ProtocolType` MUST accept HTTP/2 connections without an initial upgrade from HTTP/1.1, i.e. via ALPN. If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol".  Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTP` `ProtocolType` MUST support HTTP/2 over cleartext TCP (h2c, https://www.rfc-editor.org/rfc/rfc7540#section-3.1) without an initial upgrade from HTTP/1.1, i.e. with prior knowledge (https://www.rfc-editor.org/rfc/rfc7540#section-3.4). If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol". Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1, i.e. without prior knowledge.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * GRPCRoute provides a way to route gRPC requests. This includes the capability to match requests by hostname, gRPC service, gRPC method, or HTTP/2 header. Filters can be used to specify additional processing steps. Backends specify where matching requests will be routed.<br><p> <br><p> GRPCRoute falls under extended support within the Gateway API. Within the following specification, the word "MUST" indicates that an implementation supporting GRPCRoute must conform to the indicated requirement, but an implementation not supporting this route type need not follow the requirement unless explicitly indicated.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTPS` `ProtocolType` MUST accept HTTP/2 connections without an initial upgrade from HTTP/1.1, i.e. via ALPN. If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol".  Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTP` `ProtocolType` MUST support HTTP/2 over cleartext TCP (h2c, https://www.rfc-editor.org/rfc/rfc7540#section-3.1) without an initial upgrade from HTTP/1.1, i.e. with prior knowledge (https://www.rfc-editor.org/rfc/rfc7540#section-3.4). If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol". Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1, i.e. without prior knowledge.
     */
    @JsonProperty("spec")
    public GRPCRouteSpec getSpec() {
        return spec;
    }

    /**
     * GRPCRoute provides a way to route gRPC requests. This includes the capability to match requests by hostname, gRPC service, gRPC method, or HTTP/2 header. Filters can be used to specify additional processing steps. Backends specify where matching requests will be routed.<br><p> <br><p> GRPCRoute falls under extended support within the Gateway API. Within the following specification, the word "MUST" indicates that an implementation supporting GRPCRoute must conform to the indicated requirement, but an implementation not supporting this route type need not follow the requirement unless explicitly indicated.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTPS` `ProtocolType` MUST accept HTTP/2 connections without an initial upgrade from HTTP/1.1, i.e. via ALPN. If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol".  Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTP` `ProtocolType` MUST support HTTP/2 over cleartext TCP (h2c, https://www.rfc-editor.org/rfc/rfc7540#section-3.1) without an initial upgrade from HTTP/1.1, i.e. with prior knowledge (https://www.rfc-editor.org/rfc/rfc7540#section-3.4). If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol". Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1, i.e. without prior knowledge.
     */
    @JsonProperty("spec")
    public void setSpec(GRPCRouteSpec spec) {
        this.spec = spec;
    }

    /**
     * GRPCRoute provides a way to route gRPC requests. This includes the capability to match requests by hostname, gRPC service, gRPC method, or HTTP/2 header. Filters can be used to specify additional processing steps. Backends specify where matching requests will be routed.<br><p> <br><p> GRPCRoute falls under extended support within the Gateway API. Within the following specification, the word "MUST" indicates that an implementation supporting GRPCRoute must conform to the indicated requirement, but an implementation not supporting this route type need not follow the requirement unless explicitly indicated.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTPS` `ProtocolType` MUST accept HTTP/2 connections without an initial upgrade from HTTP/1.1, i.e. via ALPN. If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol".  Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTP` `ProtocolType` MUST support HTTP/2 over cleartext TCP (h2c, https://www.rfc-editor.org/rfc/rfc7540#section-3.1) without an initial upgrade from HTTP/1.1, i.e. with prior knowledge (https://www.rfc-editor.org/rfc/rfc7540#section-3.4). If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol". Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1, i.e. without prior knowledge.
     */
    @JsonProperty("status")
    public GRPCRouteStatus getStatus() {
        return status;
    }

    /**
     * GRPCRoute provides a way to route gRPC requests. This includes the capability to match requests by hostname, gRPC service, gRPC method, or HTTP/2 header. Filters can be used to specify additional processing steps. Backends specify where matching requests will be routed.<br><p> <br><p> GRPCRoute falls under extended support within the Gateway API. Within the following specification, the word "MUST" indicates that an implementation supporting GRPCRoute must conform to the indicated requirement, but an implementation not supporting this route type need not follow the requirement unless explicitly indicated.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTPS` `ProtocolType` MUST accept HTTP/2 connections without an initial upgrade from HTTP/1.1, i.e. via ALPN. If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol".  Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1.<br><p> <br><p> Implementations supporting `GRPCRoute` with the `HTTP` `ProtocolType` MUST support HTTP/2 over cleartext TCP (h2c, https://www.rfc-editor.org/rfc/rfc7540#section-3.1) without an initial upgrade from HTTP/1.1, i.e. with prior knowledge (https://www.rfc-editor.org/rfc/rfc7540#section-3.4). If the implementation does not support this, then it MUST set the "Accepted" condition to "False" for the affected listener with a reason of "UnsupportedProtocol". Implementations MAY also accept HTTP/2 connections with an upgrade from HTTP/1, i.e. without prior knowledge.
     */
    @JsonProperty("status")
    public void setStatus(GRPCRouteStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public GRPCRouteBuilder edit() {
        return new GRPCRouteBuilder(this);
    }

    @JsonIgnore
    public GRPCRouteBuilder toBuilder() {
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
