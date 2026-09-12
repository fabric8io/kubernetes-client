
package io.fabric8.knative.eventing.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * SubscriptionsAPIFilter allows defining a filter expression using CloudEvents Subscriptions API. If multiple filters are specified, then the same semantics of SubscriptionsAPIFilter.All is applied. If no filter dialect or empty object is specified, then the filter always accept the events.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "all",
    "any",
    "cesql",
    "exact",
    "not",
    "prefix",
    "suffix"
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
public class SubscriptionsAPIFilter implements Editable<SubscriptionsAPIFilterBuilder>, KubernetesResource
{

    @JsonProperty("all")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter> all = new ArrayList<>();
    @JsonProperty("any")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter> any = new ArrayList<>();
    @JsonProperty("cesql")
    private String cesql;
    @JsonProperty("exact")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> exact = new LinkedHashMap<>();
    @JsonProperty("not")
    private io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter not;
    @JsonProperty("prefix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> prefix = new LinkedHashMap<>();
    @JsonProperty("suffix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> suffix = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubscriptionsAPIFilter() {
    }

    public SubscriptionsAPIFilter(List<io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter> all, List<io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter> any, String cesql, Map<String, String> exact, io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter not, Map<String, String> prefix, Map<String, String> suffix) {
        super();
        this.all = all;
        this.any = any;
        this.cesql = cesql;
        this.exact = exact;
        this.not = not;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    /**
     * All evaluates to true if all the nested expressions evaluate to true. It must contain at least one filter expression.
     */
    @JsonProperty("all")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter> getAll() {
        return all;
    }

    /**
     * All evaluates to true if all the nested expressions evaluate to true. It must contain at least one filter expression.
     */
    @JsonProperty("all")
    public void setAll(List<io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter> all) {
        this.all = all;
    }

    /**
     * Any evaluates to true if at least one of the nested expressions evaluates to true. It must contain at least one filter expression.
     */
    @JsonProperty("any")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter> getAny() {
        return any;
    }

    /**
     * Any evaluates to true if at least one of the nested expressions evaluates to true. It must contain at least one filter expression.
     */
    @JsonProperty("any")
    public void setAny(List<io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter> any) {
        this.any = any;
    }

    /**
     * CESQL is a CloudEvents SQL expression that will be evaluated to true or false against each CloudEvent.
     */
    @JsonProperty("cesql")
    public String getCesql() {
        return cesql;
    }

    /**
     * CESQL is a CloudEvents SQL expression that will be evaluated to true or false against each CloudEvent.
     */
    @JsonProperty("cesql")
    public void setCesql(String cesql) {
        this.cesql = cesql;
    }

    /**
     * Exact evaluates to true if the values of the matching CloudEvents attributes MUST all exactly match with the associated value String specified (case-sensitive). The keys are the names of the CloudEvents attributes to be matched, and their values are the String values to use in the comparison. The attribute name and value specified in the filter express MUST NOT be empty strings.
     */
    @JsonProperty("exact")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getExact() {
        return exact;
    }

    /**
     * Exact evaluates to true if the values of the matching CloudEvents attributes MUST all exactly match with the associated value String specified (case-sensitive). The keys are the names of the CloudEvents attributes to be matched, and their values are the String values to use in the comparison. The attribute name and value specified in the filter express MUST NOT be empty strings.
     */
    @JsonProperty("exact")
    public void setExact(Map<String, String> exact) {
        this.exact = exact;
    }

    /**
     * SubscriptionsAPIFilter allows defining a filter expression using CloudEvents Subscriptions API. If multiple filters are specified, then the same semantics of SubscriptionsAPIFilter.All is applied. If no filter dialect or empty object is specified, then the filter always accept the events.
     */
    @JsonProperty("not")
    public io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter getNot() {
        return not;
    }

    /**
     * SubscriptionsAPIFilter allows defining a filter expression using CloudEvents Subscriptions API. If multiple filters are specified, then the same semantics of SubscriptionsAPIFilter.All is applied. If no filter dialect or empty object is specified, then the filter always accept the events.
     */
    @JsonProperty("not")
    public void setNot(io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter not) {
        this.not = not;
    }

    /**
     * Prefix evaluates to true if the values of the matching CloudEvents attributes MUST all start with the associated value String specified (case sensitive). The keys are the names of the CloudEvents attributes to be matched, and their values are the String values to use in the comparison. The attribute name and value specified in the filter express MUST NOT be empty strings.
     */
    @JsonProperty("prefix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getPrefix() {
        return prefix;
    }

    /**
     * Prefix evaluates to true if the values of the matching CloudEvents attributes MUST all start with the associated value String specified (case sensitive). The keys are the names of the CloudEvents attributes to be matched, and their values are the String values to use in the comparison. The attribute name and value specified in the filter express MUST NOT be empty strings.
     */
    @JsonProperty("prefix")
    public void setPrefix(Map<String, String> prefix) {
        this.prefix = prefix;
    }

    /**
     * Suffix evaluates to true if the values of the matching CloudEvents attributes MUST all end with the associated value String specified (case sensitive). The keys are the names of the CloudEvents attributes to be matched, and their values are the String values to use in the comparison. The attribute name and value specified in the filter express MUST NOT be empty strings.
     */
    @JsonProperty("suffix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSuffix() {
        return suffix;
    }

    /**
     * Suffix evaluates to true if the values of the matching CloudEvents attributes MUST all end with the associated value String specified (case sensitive). The keys are the names of the CloudEvents attributes to be matched, and their values are the String values to use in the comparison. The attribute name and value specified in the filter express MUST NOT be empty strings.
     */
    @JsonProperty("suffix")
    public void setSuffix(Map<String, String> suffix) {
        this.suffix = suffix;
    }

    @JsonIgnore
    public SubscriptionsAPIFilterBuilder edit() {
        return new SubscriptionsAPIFilterBuilder(this);
    }

    @JsonIgnore
    public SubscriptionsAPIFilterBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SubscriptionsAPIFilter)) {
            return false;
        }
        SubscriptionsAPIFilter other = (SubscriptionsAPIFilter) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$all = this.getAll();
        Object other$all = other.getAll();
        if (this$all == null ? other$all != null : !this$all.equals(other$all)) {
            return false;
        }
        Object this$any = this.getAny();
        Object other$any = other.getAny();
        if (this$any == null ? other$any != null : !this$any.equals(other$any)) {
            return false;
        }
        Object this$cesql = this.getCesql();
        Object other$cesql = other.getCesql();
        if (this$cesql == null ? other$cesql != null : !this$cesql.equals(other$cesql)) {
            return false;
        }
        Object this$exact = this.getExact();
        Object other$exact = other.getExact();
        if (this$exact == null ? other$exact != null : !this$exact.equals(other$exact)) {
            return false;
        }
        Object this$not = this.getNot();
        Object other$not = other.getNot();
        if (this$not == null ? other$not != null : !this$not.equals(other$not)) {
            return false;
        }
        Object this$prefix = this.getPrefix();
        Object other$prefix = other.getPrefix();
        if (this$prefix == null ? other$prefix != null : !this$prefix.equals(other$prefix)) {
            return false;
        }
        Object this$suffix = this.getSuffix();
        Object other$suffix = other.getSuffix();
        if (this$suffix == null ? other$suffix != null : !this$suffix.equals(other$suffix)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof SubscriptionsAPIFilter;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $all = this.getAll();
        result = result * prime + ($all == null ? 43 : $all.hashCode());
        Object $any = this.getAny();
        result = result * prime + ($any == null ? 43 : $any.hashCode());
        Object $cesql = this.getCesql();
        result = result * prime + ($cesql == null ? 43 : $cesql.hashCode());
        Object $exact = this.getExact();
        result = result * prime + ($exact == null ? 43 : $exact.hashCode());
        Object $not = this.getNot();
        result = result * prime + ($not == null ? 43 : $not.hashCode());
        Object $prefix = this.getPrefix();
        result = result * prime + ($prefix == null ? 43 : $prefix.hashCode());
        Object $suffix = this.getSuffix();
        result = result * prime + ($suffix == null ? 43 : $suffix.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubscriptionsAPIFilter(" + "all=" + this.getAll() + ", any=" + this.getAny() + ", cesql=" + this.getCesql() + ", exact=" + this.getExact() + ", not=" + this.getNot() + ", prefix=" + this.getPrefix() + ", suffix=" + this.getSuffix() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
