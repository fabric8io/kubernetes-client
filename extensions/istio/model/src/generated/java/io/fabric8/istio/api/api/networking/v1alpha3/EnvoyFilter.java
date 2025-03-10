
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * EnvoyFilter provides a mechanism to customize the Envoy configuration generated by istiod.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configPatches",
    "priority",
    "targetRefs",
    "workloadSelector"
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
@Version("v1alpha3")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EnvoyFilter implements Editable<EnvoyFilterBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("configPatches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvoyFilterEnvoyConfigObjectPatch> configPatches = new ArrayList<>();
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicyTargetReference> targetRefs = new ArrayList<>();
    @JsonProperty("workloadSelector")
    private WorkloadSelector workloadSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EnvoyFilter() {
    }

    public EnvoyFilter(List<EnvoyFilterEnvoyConfigObjectPatch> configPatches, Integer priority, List<PolicyTargetReference> targetRefs, WorkloadSelector workloadSelector) {
        super();
        this.configPatches = configPatches;
        this.priority = priority;
        this.targetRefs = targetRefs;
        this.workloadSelector = workloadSelector;
    }

    /**
     * One or more patches with match conditions.
     */
    @JsonProperty("configPatches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvoyFilterEnvoyConfigObjectPatch> getConfigPatches() {
        return configPatches;
    }

    /**
     * One or more patches with match conditions.
     */
    @JsonProperty("configPatches")
    public void setConfigPatches(List<EnvoyFilterEnvoyConfigObjectPatch> configPatches) {
        this.configPatches = configPatches;
    }

    /**
     * Priority defines the order in which patch sets are applied within a context. When one patch depends on another patch, the order of patch application is significant. The API provides two primary ways to order patches. Patch sets in the root namespace are applied before the patch sets in the workload namespace. Patches within a patch set are processed in the order that they appear in the `configPatches` list.<br><p> <br><p> The default value for priority is 0 and the range is [ min-int32, max-int32 ]. A patch set with a negative priority is processed before the default. A patch set with a positive priority is processed after the default.<br><p> <br><p> It is recommended to start with priority values that are multiples of 10 to leave room for further insertion.<br><p> <br><p> Patch sets are sorted in the following ascending key order: priority, creation time, fully qualified resource name.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * Priority defines the order in which patch sets are applied within a context. When one patch depends on another patch, the order of patch application is significant. The API provides two primary ways to order patches. Patch sets in the root namespace are applied before the patch sets in the workload namespace. Patches within a patch set are processed in the order that they appear in the `configPatches` list.<br><p> <br><p> The default value for priority is 0 and the range is [ min-int32, max-int32 ]. A patch set with a negative priority is processed before the default. A patch set with a positive priority is processed after the default.<br><p> <br><p> It is recommended to start with priority values that are multiples of 10 to leave room for further insertion.<br><p> <br><p> Patch sets are sorted in the following ascending key order: priority, creation time, fully qualified resource name.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * Optional. The targetRefs specifies a list of resources the policy should be applied to. The targeted resources specified will determine which workloads the policy applies to.<br><p> <br><p> Currently, the following resource attachment types are supported: &#42; `kind: Gateway` with `group: gateway.networking.k8s.io` in the same namespace. &#42; `kind: GatewayClass` with `group: gateway.networking.k8s.io` in the root namespace. &#42; `kind: Service` with `""` in the same namespace. This type is only supported for waypoints. &#42; `kind: ServiceEntry` with `group: networking.istio.io` in the same namespace.<br><p> <br><p> If not set, the policy is applied as defined by the selector. At most one of the selector and targetRefs can be set.<br><p> <br><p> NOTE: If you are using the `targetRefs` field in a multi-revision environment with Istio versions prior to 1.22, it is highly recommended that you pin the policy to a revision running 1.22+ via the `istio.io/rev` label. This is to prevent proxies connected to older control planes (that don't know about the `targetRefs` field) from misinterpreting the policy as namespace-wide during the upgrade process.<br><p> <br><p> NOTE: Waypoint proxies are required to use this field for policies to apply; `selector` policies will be ignored.
     */
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyTargetReference> getTargetRefs() {
        return targetRefs;
    }

    /**
     * Optional. The targetRefs specifies a list of resources the policy should be applied to. The targeted resources specified will determine which workloads the policy applies to.<br><p> <br><p> Currently, the following resource attachment types are supported: &#42; `kind: Gateway` with `group: gateway.networking.k8s.io` in the same namespace. &#42; `kind: GatewayClass` with `group: gateway.networking.k8s.io` in the root namespace. &#42; `kind: Service` with `""` in the same namespace. This type is only supported for waypoints. &#42; `kind: ServiceEntry` with `group: networking.istio.io` in the same namespace.<br><p> <br><p> If not set, the policy is applied as defined by the selector. At most one of the selector and targetRefs can be set.<br><p> <br><p> NOTE: If you are using the `targetRefs` field in a multi-revision environment with Istio versions prior to 1.22, it is highly recommended that you pin the policy to a revision running 1.22+ via the `istio.io/rev` label. This is to prevent proxies connected to older control planes (that don't know about the `targetRefs` field) from misinterpreting the policy as namespace-wide during the upgrade process.<br><p> <br><p> NOTE: Waypoint proxies are required to use this field for policies to apply; `selector` policies will be ignored.
     */
    @JsonProperty("targetRefs")
    public void setTargetRefs(List<PolicyTargetReference> targetRefs) {
        this.targetRefs = targetRefs;
    }

    /**
     * EnvoyFilter provides a mechanism to customize the Envoy configuration generated by istiod.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("workloadSelector")
    public WorkloadSelector getWorkloadSelector() {
        return workloadSelector;
    }

    /**
     * EnvoyFilter provides a mechanism to customize the Envoy configuration generated by istiod.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("workloadSelector")
    public void setWorkloadSelector(WorkloadSelector workloadSelector) {
        this.workloadSelector = workloadSelector;
    }

    @JsonIgnore
    public EnvoyFilterBuilder edit() {
        return new EnvoyFilterBuilder(this);
    }

    @JsonIgnore
    public EnvoyFilterBuilder toBuilder() {
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
