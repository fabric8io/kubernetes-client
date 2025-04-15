
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * Gateway describes a load balancer operating at the edge of the mesh receiving incoming or outgoing HTTP/TCP connections.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "selector",
    "servers"
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
public class Gateway implements Editable<GatewayBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("selector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> selector = new LinkedHashMap<>();
    @JsonProperty("servers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Server> servers = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Gateway() {
    }

    public Gateway(Map<String, String> selector, List<Server> servers) {
        super();
        this.selector = selector;
        this.servers = servers;
    }

    /**
     * One or more labels that indicate a specific set of pods/VMs on which this gateway configuration should be applied. By default workloads are searched across all namespaces based on label selectors. This implies that a gateway resource in the namespace "foo" can select pods in the namespace "bar" based on labels. This behavior can be controlled via the `PILOT_SCOPE_GATEWAY_TO_NAMESPACE` environment variable in istiod. If this variable is set to true, the scope of label search is restricted to the configuration namespace in which the the resource is present. In other words, the Gateway resource must reside in the same namespace as the gateway workload instance. If selector is nil, the Gateway will be applied to all workloads.
     */
    @JsonProperty("selector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSelector() {
        return selector;
    }

    /**
     * One or more labels that indicate a specific set of pods/VMs on which this gateway configuration should be applied. By default workloads are searched across all namespaces based on label selectors. This implies that a gateway resource in the namespace "foo" can select pods in the namespace "bar" based on labels. This behavior can be controlled via the `PILOT_SCOPE_GATEWAY_TO_NAMESPACE` environment variable in istiod. If this variable is set to true, the scope of label search is restricted to the configuration namespace in which the the resource is present. In other words, the Gateway resource must reside in the same namespace as the gateway workload instance. If selector is nil, the Gateway will be applied to all workloads.
     */
    @JsonProperty("selector")
    public void setSelector(Map<String, String> selector) {
        this.selector = selector;
    }

    /**
     * A list of server specifications.
     */
    @JsonProperty("servers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Server> getServers() {
        return servers;
    }

    /**
     * A list of server specifications.
     */
    @JsonProperty("servers")
    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    @JsonIgnore
    public GatewayBuilder edit() {
        return new GatewayBuilder(this);
    }

    @JsonIgnore
    public GatewayBuilder toBuilder() {
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
