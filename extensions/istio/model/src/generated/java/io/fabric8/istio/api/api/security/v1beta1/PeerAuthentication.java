
package io.fabric8.istio.api.api.security.v1beta1;

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
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
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
    "mtls",
    "portLevelMtls",
    "selector"
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
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PeerAuthentication implements Editable<PeerAuthenticationBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("mtls")
    private PeerAuthenticationMutualTLS mtls;
    @JsonProperty("portLevelMtls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, PeerAuthenticationMutualTLS> portLevelMtls = new LinkedHashMap<>();
    @JsonProperty("selector")
    private WorkloadSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PeerAuthentication() {
    }

    public PeerAuthentication(PeerAuthenticationMutualTLS mtls, Map<String, PeerAuthenticationMutualTLS> portLevelMtls, WorkloadSelector selector) {
        super();
        this.mtls = mtls;
        this.portLevelMtls = portLevelMtls;
        this.selector = selector;
    }

    /**
     * PeerAuthentication defines mutual TLS (mTLS) requirements for incoming connections.<br><p> <br><p> In sidecar mode, PeerAuthentication determines whether or not mTLS is allowed or required for connections to an Envoy proxy sidecar.<br><p> <br><p> In ambient mode, security is transparently enabled for a pod by the ztunnel node agent. (Traffic between proxies uses the HBONE protocol, which includes encryption with mTLS.) Because of this, `DISABLE` mode is not supported. `STRICT` mode is useful to ensure that connections that bypass the mesh are not possible.<br><p> <br><p> Examples:<br><p> <br><p> Policy to require mTLS traffic for all workloads under namespace `foo`: ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: STRICT<br><p> <br><p> ``` For mesh level, put the policy in root-namespace according to your Istio installation.<br><p> <br><p> Policies to allow both mTLS and plaintext traffic for all workloads under namespace `foo`, but require mTLS for workload `finance`. ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: PERMISSIVE
     */
    @JsonProperty("mtls")
    public PeerAuthenticationMutualTLS getMtls() {
        return mtls;
    }

    /**
     * PeerAuthentication defines mutual TLS (mTLS) requirements for incoming connections.<br><p> <br><p> In sidecar mode, PeerAuthentication determines whether or not mTLS is allowed or required for connections to an Envoy proxy sidecar.<br><p> <br><p> In ambient mode, security is transparently enabled for a pod by the ztunnel node agent. (Traffic between proxies uses the HBONE protocol, which includes encryption with mTLS.) Because of this, `DISABLE` mode is not supported. `STRICT` mode is useful to ensure that connections that bypass the mesh are not possible.<br><p> <br><p> Examples:<br><p> <br><p> Policy to require mTLS traffic for all workloads under namespace `foo`: ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: STRICT<br><p> <br><p> ``` For mesh level, put the policy in root-namespace according to your Istio installation.<br><p> <br><p> Policies to allow both mTLS and plaintext traffic for all workloads under namespace `foo`, but require mTLS for workload `finance`. ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: PERMISSIVE
     */
    @JsonProperty("mtls")
    public void setMtls(PeerAuthenticationMutualTLS mtls) {
        this.mtls = mtls;
    }

    /**
     * Port specific mutual TLS settings. These only apply when a workload selector is specified. The port refers to the port of the workload, not the port of the Kubernetes service.
     */
    @JsonProperty("portLevelMtls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, PeerAuthenticationMutualTLS> getPortLevelMtls() {
        return portLevelMtls;
    }

    /**
     * Port specific mutual TLS settings. These only apply when a workload selector is specified. The port refers to the port of the workload, not the port of the Kubernetes service.
     */
    @JsonProperty("portLevelMtls")
    public void setPortLevelMtls(Map<String, PeerAuthenticationMutualTLS> portLevelMtls) {
        this.portLevelMtls = portLevelMtls;
    }

    /**
     * PeerAuthentication defines mutual TLS (mTLS) requirements for incoming connections.<br><p> <br><p> In sidecar mode, PeerAuthentication determines whether or not mTLS is allowed or required for connections to an Envoy proxy sidecar.<br><p> <br><p> In ambient mode, security is transparently enabled for a pod by the ztunnel node agent. (Traffic between proxies uses the HBONE protocol, which includes encryption with mTLS.) Because of this, `DISABLE` mode is not supported. `STRICT` mode is useful to ensure that connections that bypass the mesh are not possible.<br><p> <br><p> Examples:<br><p> <br><p> Policy to require mTLS traffic for all workloads under namespace `foo`: ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: STRICT<br><p> <br><p> ``` For mesh level, put the policy in root-namespace according to your Istio installation.<br><p> <br><p> Policies to allow both mTLS and plaintext traffic for all workloads under namespace `foo`, but require mTLS for workload `finance`. ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: PERMISSIVE
     */
    @JsonProperty("selector")
    public WorkloadSelector getSelector() {
        return selector;
    }

    /**
     * PeerAuthentication defines mutual TLS (mTLS) requirements for incoming connections.<br><p> <br><p> In sidecar mode, PeerAuthentication determines whether or not mTLS is allowed or required for connections to an Envoy proxy sidecar.<br><p> <br><p> In ambient mode, security is transparently enabled for a pod by the ztunnel node agent. (Traffic between proxies uses the HBONE protocol, which includes encryption with mTLS.) Because of this, `DISABLE` mode is not supported. `STRICT` mode is useful to ensure that connections that bypass the mesh are not possible.<br><p> <br><p> Examples:<br><p> <br><p> Policy to require mTLS traffic for all workloads under namespace `foo`: ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: STRICT<br><p> <br><p> ``` For mesh level, put the policy in root-namespace according to your Istio installation.<br><p> <br><p> Policies to allow both mTLS and plaintext traffic for all workloads under namespace `foo`, but require mTLS for workload `finance`. ```yaml apiVersion: security.istio.io/v1 kind: PeerAuthentication metadata:<br><p> <br><p> 	name: default<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	mtls:<br><p> 	  mode: PERMISSIVE
     */
    @JsonProperty("selector")
    public void setSelector(WorkloadSelector selector) {
        this.selector = selector;
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
