
package io.fabric8.istio.api.security.v1beta1;

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
import io.fabric8.istio.api.api.meta.v1alpha1.IstioStatus;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
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
 * PeerAuthentication defines mutual TLS (mTLS) requirements for incoming connections.<br><p> <br><p> In sidecar mode, PeerAuthentication determines whether or not mTLS is allowed or required for connections to an Envoy proxy sidecar.<br><p> <br><p> In ambient mode, security is transparently enabled for a pod by the ztunnel node agent. (Traffic between proxies uses the HBONE protocol, which includes encryption with mTLS.) Because of this, `DISABLE` mode is not supported. `STRICT` mode is useful to ensure that connections that bypass the mesh are not possible.<br><p> <br><p> Examples:<br><p> <br><p> Policy to require mTLS traffic for all workloads under namespace `foo`: ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: STRICT<br><p> <br><p> ``` For mesh level, put the policy in root-namespace according to your Istio installation.<br><p> <br><p> Policies to allow both mTLS and plaintext traffic for all workloads under namespace `foo`, but require mTLS for workload `finance`. ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: PERMISSIVE
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1beta1")
@Group("security.istio.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PeerAuthentication implements Editable<PeerAuthenticationBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "security.istio.io/v1beta1";
    @JsonProperty("kind")
    private String kind = "PeerAuthentication";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private io.fabric8.istio.api.api.security.v1beta1.PeerAuthentication spec;
    @JsonProperty("status")
    private IstioStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PeerAuthentication() {
    }

    public PeerAuthentication(String apiVersion, String kind, ObjectMeta metadata, io.fabric8.istio.api.api.security.v1beta1.PeerAuthentication spec, IstioStatus status) {
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
     * PeerAuthentication defines mutual TLS (mTLS) requirements for incoming connections.<br><p> <br><p> In sidecar mode, PeerAuthentication determines whether or not mTLS is allowed or required for connections to an Envoy proxy sidecar.<br><p> <br><p> In ambient mode, security is transparently enabled for a pod by the ztunnel node agent. (Traffic between proxies uses the HBONE protocol, which includes encryption with mTLS.) Because of this, `DISABLE` mode is not supported. `STRICT` mode is useful to ensure that connections that bypass the mesh are not possible.<br><p> <br><p> Examples:<br><p> <br><p> Policy to require mTLS traffic for all workloads under namespace `foo`: ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: STRICT<br><p> <br><p> ``` For mesh level, put the policy in root-namespace according to your Istio installation.<br><p> <br><p> Policies to allow both mTLS and plaintext traffic for all workloads under namespace `foo`, but require mTLS for workload `finance`. ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: PERMISSIVE
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * PeerAuthentication defines mutual TLS (mTLS) requirements for incoming connections.<br><p> <br><p> In sidecar mode, PeerAuthentication determines whether or not mTLS is allowed or required for connections to an Envoy proxy sidecar.<br><p> <br><p> In ambient mode, security is transparently enabled for a pod by the ztunnel node agent. (Traffic between proxies uses the HBONE protocol, which includes encryption with mTLS.) Because of this, `DISABLE` mode is not supported. `STRICT` mode is useful to ensure that connections that bypass the mesh are not possible.<br><p> <br><p> Examples:<br><p> <br><p> Policy to require mTLS traffic for all workloads under namespace `foo`: ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: STRICT<br><p> <br><p> ``` For mesh level, put the policy in root-namespace according to your Istio installation.<br><p> <br><p> Policies to allow both mTLS and plaintext traffic for all workloads under namespace `foo`, but require mTLS for workload `finance`. ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: PERMISSIVE
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * PeerAuthentication defines mutual TLS (mTLS) requirements for incoming connections.<br><p> <br><p> In sidecar mode, PeerAuthentication determines whether or not mTLS is allowed or required for connections to an Envoy proxy sidecar.<br><p> <br><p> In ambient mode, security is transparently enabled for a pod by the ztunnel node agent. (Traffic between proxies uses the HBONE protocol, which includes encryption with mTLS.) Because of this, `DISABLE` mode is not supported. `STRICT` mode is useful to ensure that connections that bypass the mesh are not possible.<br><p> <br><p> Examples:<br><p> <br><p> Policy to require mTLS traffic for all workloads under namespace `foo`: ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: STRICT<br><p> <br><p> ``` For mesh level, put the policy in root-namespace according to your Istio installation.<br><p> <br><p> Policies to allow both mTLS and plaintext traffic for all workloads under namespace `foo`, but require mTLS for workload `finance`. ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: PERMISSIVE
     */
    @JsonProperty("spec")
    public io.fabric8.istio.api.api.security.v1beta1.PeerAuthentication getSpec() {
        return spec;
    }

    /**
     * PeerAuthentication defines mutual TLS (mTLS) requirements for incoming connections.<br><p> <br><p> In sidecar mode, PeerAuthentication determines whether or not mTLS is allowed or required for connections to an Envoy proxy sidecar.<br><p> <br><p> In ambient mode, security is transparently enabled for a pod by the ztunnel node agent. (Traffic between proxies uses the HBONE protocol, which includes encryption with mTLS.) Because of this, `DISABLE` mode is not supported. `STRICT` mode is useful to ensure that connections that bypass the mesh are not possible.<br><p> <br><p> Examples:<br><p> <br><p> Policy to require mTLS traffic for all workloads under namespace `foo`: ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: STRICT<br><p> <br><p> ``` For mesh level, put the policy in root-namespace according to your Istio installation.<br><p> <br><p> Policies to allow both mTLS and plaintext traffic for all workloads under namespace `foo`, but require mTLS for workload `finance`. ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: PERMISSIVE
     */
    @JsonProperty("spec")
    public void setSpec(io.fabric8.istio.api.api.security.v1beta1.PeerAuthentication spec) {
        this.spec = spec;
    }

    /**
     * PeerAuthentication defines mutual TLS (mTLS) requirements for incoming connections.<br><p> <br><p> In sidecar mode, PeerAuthentication determines whether or not mTLS is allowed or required for connections to an Envoy proxy sidecar.<br><p> <br><p> In ambient mode, security is transparently enabled for a pod by the ztunnel node agent. (Traffic between proxies uses the HBONE protocol, which includes encryption with mTLS.) Because of this, `DISABLE` mode is not supported. `STRICT` mode is useful to ensure that connections that bypass the mesh are not possible.<br><p> <br><p> Examples:<br><p> <br><p> Policy to require mTLS traffic for all workloads under namespace `foo`: ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: STRICT<br><p> <br><p> ``` For mesh level, put the policy in root-namespace according to your Istio installation.<br><p> <br><p> Policies to allow both mTLS and plaintext traffic for all workloads under namespace `foo`, but require mTLS for workload `finance`. ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: PERMISSIVE
     */
    @JsonProperty("status")
    public IstioStatus getStatus() {
        return status;
    }

    /**
     * PeerAuthentication defines mutual TLS (mTLS) requirements for incoming connections.<br><p> <br><p> In sidecar mode, PeerAuthentication determines whether or not mTLS is allowed or required for connections to an Envoy proxy sidecar.<br><p> <br><p> In ambient mode, security is transparently enabled for a pod by the ztunnel node agent. (Traffic between proxies uses the HBONE protocol, which includes encryption with mTLS.) Because of this, `DISABLE` mode is not supported. `STRICT` mode is useful to ensure that connections that bypass the mesh are not possible.<br><p> <br><p> Examples:<br><p> <br><p> Policy to require mTLS traffic for all workloads under namespace `foo`: ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: STRICT<br><p> <br><p> ``` For mesh level, put the policy in root-namespace according to your Istio installation.<br><p> <br><p> Policies to allow both mTLS and plaintext traffic for all workloads under namespace `foo`, but require mTLS for workload `finance`. ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: PERMISSIVE
     */
    @JsonProperty("status")
    public void setStatus(IstioStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public PeerAuthenticationBuilder edit() {
        return new PeerAuthenticationBuilder(this);
    }

    @JsonIgnore
    public PeerAuthenticationBuilder toBuilder() {
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
