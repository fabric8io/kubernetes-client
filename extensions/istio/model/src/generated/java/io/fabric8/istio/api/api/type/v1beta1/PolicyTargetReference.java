
package io.fabric8.istio.api.api.type.v1beta1;

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
 * PolicyTargetReference format as defined by [GEP-2648](https://gateway-api.sigs.k8s.io/geps/gep-2648/#direct-policy-design-rules).<br><p> <br><p> PolicyTargetReference specifies the targeted resource which the policy should be applied to. It must only target a single resource at a time, but it can be used to target larger resources such as Gateways that may apply to multiple child resources. The PolicyTargetReference will be used instead of a WorkloadSelector in the RequestAuthentication, AuthorizationPolicy, Telemetry, and WasmPlugin CRDs to target a Kubernetes Gateway.<br><p> <br><p> The following is an example of an AuthorizationPolicy bound to a waypoint proxy using a PolicyTargetReference. The example sets `action` to `DENY` to create a deny policy. It denies all the requests with `POST` method on port `8080` directed through the `waypoint` Gateway in the `foo` namespace.<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: AuthorizationPolicy metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	targetRefs:<br><p> 	- name: waypoint<br><p> 	  kind: Gateway<br><p> 	  group: gateway.networking.k8s.io<br><p> 	action: DENY<br><p> 	rules:<br><p> 	- to:<br><p> 	  - operation:<br><p> 	      methods: ["POST"]<br><p> 	      ports: ["8080"]<br><p> <br><p> ```<br><p> <br><p> When binding to a GatewayClass resource using PolicyTargetReference, your policy must be in the root namespace.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "group",
    "name",
    "namespace"
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
public class PolicyTargetReference implements Editable<PolicyTargetReferenceBuilder>, KubernetesResource
{

    @JsonProperty("group")
    private String group;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicyTargetReference() {
    }

    public PolicyTargetReference(String group, String kind, String name, String namespace) {
        super();
        this.group = group;
        this.kind = kind;
        this.name = name;
        this.namespace = namespace;
    }

    /**
     * group is the group of the target resource.
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * group is the group of the target resource.
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * kind is kind of the target resource.
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * kind is kind of the target resource.
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * name is the name of the target resource.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the name of the target resource.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namespace is the namespace of the referent. When unspecified, the local namespace is inferred.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace is the namespace of the referent. When unspecified, the local namespace is inferred.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonIgnore
    public PolicyTargetReferenceBuilder edit() {
        return new PolicyTargetReferenceBuilder(this);
    }

    @JsonIgnore
    public PolicyTargetReferenceBuilder toBuilder() {
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
