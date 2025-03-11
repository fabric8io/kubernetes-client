
package io.fabric8.istio.api.api.telemetry.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReference;
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
 * &lt;!-- crd generation tags is a timestamp representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessLogging",
    "metrics",
    "selector",
    "targetRef",
    "targetRefs",
    "tracing"
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
@Version("v1alpha1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Telemetry implements Editable<TelemetryBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("accessLogging")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AccessLogging> accessLogging = new ArrayList<>();
    @JsonProperty("metrics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Metrics> metrics = new ArrayList<>();
    @JsonProperty("selector")
    private WorkloadSelector selector;
    @JsonProperty("targetRef")
    private PolicyTargetReference targetRef;
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicyTargetReference> targetRefs = new ArrayList<>();
    @JsonProperty("tracing")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Tracing> tracing = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Telemetry() {
    }

    public Telemetry(List<AccessLogging> accessLogging, List<Metrics> metrics, WorkloadSelector selector, PolicyTargetReference targetRef, List<PolicyTargetReference> targetRefs, List<Tracing> tracing) {
        super();
        this.accessLogging = accessLogging;
        this.metrics = metrics;
        this.selector = selector;
        this.targetRef = targetRef;
        this.targetRefs = targetRefs;
        this.tracing = tracing;
    }

    /**
     * Optional. Access logging configures the access logging behavior for all selected workloads.
     */
    @JsonProperty("accessLogging")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AccessLogging> getAccessLogging() {
        return accessLogging;
    }

    /**
     * Optional. Access logging configures the access logging behavior for all selected workloads.
     */
    @JsonProperty("accessLogging")
    public void setAccessLogging(List<AccessLogging> accessLogging) {
        this.accessLogging = accessLogging;
    }

    /**
     * Optional. Metrics configures the metrics behavior for all selected workloads.
     */
    @JsonProperty("metrics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Metrics> getMetrics() {
        return metrics;
    }

    /**
     * Optional. Metrics configures the metrics behavior for all selected workloads.
     */
    @JsonProperty("metrics")
    public void setMetrics(List<Metrics> metrics) {
        this.metrics = metrics;
    }

    /**
     * &lt;!-- crd generation tags is a timestamp representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("selector")
    public WorkloadSelector getSelector() {
        return selector;
    }

    /**
     * &lt;!-- crd generation tags is a timestamp representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("selector")
    public void setSelector(WorkloadSelector selector) {
        this.selector = selector;
    }

    /**
     * &lt;!-- crd generation tags is a timestamp representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("targetRef")
    public PolicyTargetReference getTargetRef() {
        return targetRef;
    }

    /**
     * &lt;!-- crd generation tags is a timestamp representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("targetRef")
    public void setTargetRef(PolicyTargetReference targetRef) {
        this.targetRef = targetRef;
    }

    /**
     * Optional. The targetRefs specifies a list of resources the policy should be applied to. The targeted resources specified will determine which workloads the policy applies to.<br><p> <br><p> Currently, the following resource attachment types are supported: &#42; `kind: Gateway` with `group: gateway.networking.k8s.io` in the same namespace. &#42; `kind: GatewayClass` with `group: gateway.networking.k8s.io` in the root namespace. &#42; `kind: Service` with `group: ""` or `group: "core"` in the same namespace. This type is only supported for waypoints. &#42; `kind: ServiceEntry` with `group: networking.istio.io` in the same namespace.<br><p> <br><p> If not set, the policy is applied as defined by the selector. At most one of the selector and targetRefs can be set.<br><p> <br><p> NOTE: If you are using the `targetRefs` field in a multi-revision environment with Istio versions prior to 1.22, it is highly recommended that you pin the policy to a revision running 1.22+ via the `istio.io/rev` label. This is to prevent proxies connected to older control planes (that don't know about the `targetRefs` field) from misinterpreting the policy as namespace-wide during the upgrade process.<br><p> <br><p> NOTE: Waypoint proxies are required to use this field for policies to apply; `selector` policies will be ignored.
     */
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyTargetReference> getTargetRefs() {
        return targetRefs;
    }

    /**
     * Optional. The targetRefs specifies a list of resources the policy should be applied to. The targeted resources specified will determine which workloads the policy applies to.<br><p> <br><p> Currently, the following resource attachment types are supported: &#42; `kind: Gateway` with `group: gateway.networking.k8s.io` in the same namespace. &#42; `kind: GatewayClass` with `group: gateway.networking.k8s.io` in the root namespace. &#42; `kind: Service` with `group: ""` or `group: "core"` in the same namespace. This type is only supported for waypoints. &#42; `kind: ServiceEntry` with `group: networking.istio.io` in the same namespace.<br><p> <br><p> If not set, the policy is applied as defined by the selector. At most one of the selector and targetRefs can be set.<br><p> <br><p> NOTE: If you are using the `targetRefs` field in a multi-revision environment with Istio versions prior to 1.22, it is highly recommended that you pin the policy to a revision running 1.22+ via the `istio.io/rev` label. This is to prevent proxies connected to older control planes (that don't know about the `targetRefs` field) from misinterpreting the policy as namespace-wide during the upgrade process.<br><p> <br><p> NOTE: Waypoint proxies are required to use this field for policies to apply; `selector` policies will be ignored.
     */
    @JsonProperty("targetRefs")
    public void setTargetRefs(List<PolicyTargetReference> targetRefs) {
        this.targetRefs = targetRefs;
    }

    /**
     * Optional. Tracing configures the tracing behavior for all selected workloads.
     */
    @JsonProperty("tracing")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Tracing> getTracing() {
        return tracing;
    }

    /**
     * Optional. Tracing configures the tracing behavior for all selected workloads.
     */
    @JsonProperty("tracing")
    public void setTracing(List<Tracing> tracing) {
        this.tracing = tracing;
    }

    @JsonIgnore
    public TelemetryBuilder edit() {
        return new TelemetryBuilder(this);
    }

    @JsonIgnore
    public TelemetryBuilder toBuilder() {
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
