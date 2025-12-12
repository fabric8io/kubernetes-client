
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * MachineDrainRuleSpec defines the spec of a MachineDrainRule.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "drain",
    "machines",
    "pods"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class MachineDrainRuleSpec implements Editable<MachineDrainRuleSpecBuilder>, KubernetesResource
{

    @JsonProperty("drain")
    private MachineDrainRuleDrainConfig drain;
    @JsonProperty("machines")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineDrainRuleMachineSelector> machines = new ArrayList<>();
    @JsonProperty("pods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineDrainRulePodSelector> pods = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineDrainRuleSpec() {
    }

    public MachineDrainRuleSpec(MachineDrainRuleDrainConfig drain, List<MachineDrainRuleMachineSelector> machines, List<MachineDrainRulePodSelector> pods) {
        super();
        this.drain = drain;
        this.machines = machines;
        this.pods = pods;
    }

    /**
     * MachineDrainRuleSpec defines the spec of a MachineDrainRule.
     */
    @JsonProperty("drain")
    public MachineDrainRuleDrainConfig getDrain() {
        return drain;
    }

    /**
     * MachineDrainRuleSpec defines the spec of a MachineDrainRule.
     */
    @JsonProperty("drain")
    public void setDrain(MachineDrainRuleDrainConfig drain) {
        this.drain = drain;
    }

    /**
     * machines defines to which Machines this MachineDrainRule should be applied.<br><p> <br><p> If machines is not set, the MachineDrainRule applies to all Machines in the Namespace. If machines contains multiple selectors, the results are ORed. Within a single Machine selector the results of selector and clusterSelector are ANDed. Machines will be selected from all Clusters in the Namespace unless otherwise restricted with the clusterSelector.<br><p> <br><p> Example: Selects control plane Machines in all Clusters or<br><p>          Machines with label "os" == "linux" in Clusters with label<br><p>          "stage" == "production".<br><p> <br><p>  - selector:<br><p>      matchExpressions:<br><p>      - key: cluster.x-k8s.io/control-plane<br><p>        operator: Exists<br><p>  - selector:<br><p>      matchLabels:<br><p>        os: linux<br><p>    clusterSelector:<br><p>      matchExpressions:<br><p>      - key: stage<br><p>        operator: In<br><p>        values:<br><p>        - production
     */
    @JsonProperty("machines")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineDrainRuleMachineSelector> getMachines() {
        return machines;
    }

    /**
     * machines defines to which Machines this MachineDrainRule should be applied.<br><p> <br><p> If machines is not set, the MachineDrainRule applies to all Machines in the Namespace. If machines contains multiple selectors, the results are ORed. Within a single Machine selector the results of selector and clusterSelector are ANDed. Machines will be selected from all Clusters in the Namespace unless otherwise restricted with the clusterSelector.<br><p> <br><p> Example: Selects control plane Machines in all Clusters or<br><p>          Machines with label "os" == "linux" in Clusters with label<br><p>          "stage" == "production".<br><p> <br><p>  - selector:<br><p>      matchExpressions:<br><p>      - key: cluster.x-k8s.io/control-plane<br><p>        operator: Exists<br><p>  - selector:<br><p>      matchLabels:<br><p>        os: linux<br><p>    clusterSelector:<br><p>      matchExpressions:<br><p>      - key: stage<br><p>        operator: In<br><p>        values:<br><p>        - production
     */
    @JsonProperty("machines")
    public void setMachines(List<MachineDrainRuleMachineSelector> machines) {
        this.machines = machines;
    }

    /**
     * pods defines to which Pods this MachineDrainRule should be applied.<br><p> <br><p> If pods is not set, the MachineDrainRule applies to all Pods in all Namespaces. If pods contains multiple selectors, the results are ORed. Within a single Pod selector the results of selector and namespaceSelector are ANDed. Pods will be selected from all Namespaces unless otherwise restricted with the namespaceSelector.<br><p> <br><p> Example: Selects Pods with label "app" == "logging" in all Namespaces or<br><p>          Pods with label "app" == "prometheus" in the "monitoring"<br><p>          Namespace.<br><p> <br><p>  - selector:<br><p>      matchExpressions:<br><p>      - key: app<br><p>        operator: In<br><p>        values:<br><p>        - logging<br><p>  - selector:<br><p>      matchLabels:<br><p>        app: prometheus<br><p>    namespaceSelector:<br><p>      matchLabels:<br><p>        kubernetes.io/metadata.name: monitoring
     */
    @JsonProperty("pods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineDrainRulePodSelector> getPods() {
        return pods;
    }

    /**
     * pods defines to which Pods this MachineDrainRule should be applied.<br><p> <br><p> If pods is not set, the MachineDrainRule applies to all Pods in all Namespaces. If pods contains multiple selectors, the results are ORed. Within a single Pod selector the results of selector and namespaceSelector are ANDed. Pods will be selected from all Namespaces unless otherwise restricted with the namespaceSelector.<br><p> <br><p> Example: Selects Pods with label "app" == "logging" in all Namespaces or<br><p>          Pods with label "app" == "prometheus" in the "monitoring"<br><p>          Namespace.<br><p> <br><p>  - selector:<br><p>      matchExpressions:<br><p>      - key: app<br><p>        operator: In<br><p>        values:<br><p>        - logging<br><p>  - selector:<br><p>      matchLabels:<br><p>        app: prometheus<br><p>    namespaceSelector:<br><p>      matchLabels:<br><p>        kubernetes.io/metadata.name: monitoring
     */
    @JsonProperty("pods")
    public void setPods(List<MachineDrainRulePodSelector> pods) {
        this.pods = pods;
    }

    @JsonIgnore
    public MachineDrainRuleSpecBuilder edit() {
        return new MachineDrainRuleSpecBuilder(this);
    }

    @JsonIgnore
    public MachineDrainRuleSpecBuilder toBuilder() {
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
