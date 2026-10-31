
package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

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
 * TargetResponder allows you to specify the responder reacting to the Eviction. Responders should observe and communicate through the Eviction API (see .state) to help with the graceful eviction of a target (e.g. termination of a pod).
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "priority",
    "state"
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
public class TargetResponder implements Editable<TargetResponderBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TargetResponder() {
    }

    public TargetResponder(String name, Integer priority, String state) {
        super();
        this.name = name;
        this.priority = priority;
        this.state = state;
    }

    /**
     * name allows you to identify the responder reacting to the Eviction.<br><p> <br><p> It must be a valid domain-prefixed key (such as "acme.io/foo"). This field must be unique for each responder. This field is required.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name allows you to identify the responder reacting to the Eviction.<br><p> <br><p> It must be a valid domain-prefixed key (such as "acme.io/foo"). This field must be unique for each responder. This field is required.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * priority for this responder. Higher priorities are selected first by the evictionrequest-controller. If there are responders with the same priority, the responder whose domain name comes first in the alphabetical higher domain order, will be picked. This means that the top domain labels are compared alphabetically first, followed by the lower domain labels. The key is compared last.<br><p> <br><p> The responder that is the managing controller of the pod should set the value of this field to 10000 to allow both for preemption or fallback registration by other responders.<br><p> <br><p> The minimum value is 0 and the maximum value is 100000. The interval 0-999 is reserved for responders with &#42;.k8s.io suffix. This field is required and immutable.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * priority for this responder. Higher priorities are selected first by the evictionrequest-controller. If there are responders with the same priority, the responder whose domain name comes first in the alphabetical higher domain order, will be picked. This means that the top domain labels are compared alphabetically first, followed by the lower domain labels. The key is compared last.<br><p> <br><p> The responder that is the managing controller of the pod should set the value of this field to 10000 to allow both for preemption or fallback registration by other responders.<br><p> <br><p> The minimum value is 0 and the maximum value is 100000. The interval 0-999 is reserved for responders with &#42;.k8s.io suffix. This field is required and immutable.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * state specifies a state that is assigned by the evictionrequest-controller. Responders should observe this state in order to navigate their lifecycle. - Inactive means that the responder should not yet process this eviction request. - Active means that the responder is either running or expected to start soon.<br><p>   Also, startTime has been set in the ResponderStatus by the evictionrequest-controller.<br><p> <br><p>   An active responder should currently interact with the eviction process by updating<br><p>   .status.responders, where .name is the active responder name. ResponderStatus fields<br><p>   should be periodically updated to indicate the progress or completion of the eviction process.<br><p>   If .status.responders[].heartbeatTime field is not updated within the heartbeat deadline defined<br><p>   by the Eviction API (currently 20 minutes), the eviction is passed over to the next responder<br><p> 	 with a lower priority. Only one responder can be active at a time.<br><p> - Interrupted means that the responder has failed to start or failed to update<br><p>   heartbeatTime in ResponderStatus in a timely manner.<br><p> - Canceled means that the responder has been canceled. In other words, there	is no<br><p>   EvictionRequest with the same target and Eviction intent in .spec.intent.<br><p> - Completed means that the responder has successfully completed and set completionTime<br><p>   in ResponderStatus.<br><p> <br><p> Please refer to the ResponderStatus in .status.responders for more details on each responder.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state specifies a state that is assigned by the evictionrequest-controller. Responders should observe this state in order to navigate their lifecycle. - Inactive means that the responder should not yet process this eviction request. - Active means that the responder is either running or expected to start soon.<br><p>   Also, startTime has been set in the ResponderStatus by the evictionrequest-controller.<br><p> <br><p>   An active responder should currently interact with the eviction process by updating<br><p>   .status.responders, where .name is the active responder name. ResponderStatus fields<br><p>   should be periodically updated to indicate the progress or completion of the eviction process.<br><p>   If .status.responders[].heartbeatTime field is not updated within the heartbeat deadline defined<br><p>   by the Eviction API (currently 20 minutes), the eviction is passed over to the next responder<br><p> 	 with a lower priority. Only one responder can be active at a time.<br><p> - Interrupted means that the responder has failed to start or failed to update<br><p>   heartbeatTime in ResponderStatus in a timely manner.<br><p> - Canceled means that the responder has been canceled. In other words, there	is no<br><p>   EvictionRequest with the same target and Eviction intent in .spec.intent.<br><p> - Completed means that the responder has successfully completed and set completionTime<br><p>   in ResponderStatus.<br><p> <br><p> Please refer to the ResponderStatus in .status.responders for more details on each responder.
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public TargetResponderBuilder edit() {
        return new TargetResponderBuilder(this);
    }

    @JsonIgnore
    public TargetResponderBuilder toBuilder() {
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
