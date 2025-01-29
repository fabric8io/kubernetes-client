
package io.fabric8.istio.api.api.security.v1beta1;

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
 * Rule matches requests from a list of sources that perform a list of operations subject to a list of conditions. A match occurs when at least one source, one operation and all conditions matches the request. An empty rule is always matched.<br><p> <br><p> Any string field in the rule supports Exact, Prefix, Suffix and Presence match:<br><p> <br><p> - Exact match: `abc` will match on value `abc`. - Prefix match: `abc&#42;` will match on value `abc` and `abcd`. - Suffix match: `&#42;abc` will match on value `abc` and `xabc`. - Presence match: `&#42;` will match when value is not empty.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "from",
    "to",
    "when"
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
public class Rule implements Editable<RuleBuilder>, KubernetesResource
{

    @JsonProperty("from")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RuleFrom> from = new ArrayList<>();
    @JsonProperty("to")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RuleTo> to = new ArrayList<>();
    @JsonProperty("when")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> when = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Rule() {
    }

    public Rule(List<RuleFrom> from, List<RuleTo> to, List<Condition> when) {
        super();
        this.from = from;
        this.to = to;
        this.when = when;
    }

    /**
     * Optional. `from` specifies the source of a request.<br><p> <br><p> If not set, any source is allowed.
     */
    @JsonProperty("from")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RuleFrom> getFrom() {
        return from;
    }

    /**
     * Optional. `from` specifies the source of a request.<br><p> <br><p> If not set, any source is allowed.
     */
    @JsonProperty("from")
    public void setFrom(List<RuleFrom> from) {
        this.from = from;
    }

    /**
     * Optional. `to` specifies the operation of a request.<br><p> <br><p> If not set, any operation is allowed.
     */
    @JsonProperty("to")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RuleTo> getTo() {
        return to;
    }

    /**
     * Optional. `to` specifies the operation of a request.<br><p> <br><p> If not set, any operation is allowed.
     */
    @JsonProperty("to")
    public void setTo(List<RuleTo> to) {
        this.to = to;
    }

    /**
     * Optional. `when` specifies a list of additional conditions of a request.<br><p> <br><p> If not set, any condition is allowed.
     */
    @JsonProperty("when")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getWhen() {
        return when;
    }

    /**
     * Optional. `when` specifies a list of additional conditions of a request.<br><p> <br><p> If not set, any condition is allowed.
     */
    @JsonProperty("when")
    public void setWhen(List<Condition> when) {
        this.when = when;
    }

    @JsonIgnore
    public RuleBuilder edit() {
        return new RuleBuilder(this);
    }

    @JsonIgnore
    public RuleBuilder toBuilder() {
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
