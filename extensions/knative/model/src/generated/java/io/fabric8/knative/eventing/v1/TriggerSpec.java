
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
import io.fabric8.knative.duck.v1.DeliverySpec;
import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.KReference;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "broker",
    "brokerRef",
    "delivery",
    "filter",
    "filters",
    "subscriber"
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
public class TriggerSpec implements Editable<TriggerSpecBuilder>, KubernetesResource
{

    @JsonProperty("broker")
    private String broker;
    @JsonProperty("brokerRef")
    private KReference brokerRef;
    @JsonProperty("delivery")
    private DeliverySpec delivery;
    @JsonProperty("filter")
    private TriggerFilter filter;
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionsAPIFilter> filters = new ArrayList<>();
    @JsonProperty("subscriber")
    private Destination subscriber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TriggerSpec() {
    }

    public TriggerSpec(String broker, KReference brokerRef, DeliverySpec delivery, TriggerFilter filter, List<SubscriptionsAPIFilter> filters, Destination subscriber) {
        super();
        this.broker = broker;
        this.brokerRef = brokerRef;
        this.delivery = delivery;
        this.filter = filter;
        this.filters = filters;
        this.subscriber = subscriber;
    }

    /**
     * Broker is the broker that this trigger receives events from.
     */
    @JsonProperty("broker")
    public String getBroker() {
        return broker;
    }

    /**
     * Broker is the broker that this trigger receives events from.
     */
    @JsonProperty("broker")
    public void setBroker(String broker) {
        this.broker = broker;
    }

    @JsonProperty("brokerRef")
    public KReference getBrokerRef() {
        return brokerRef;
    }

    @JsonProperty("brokerRef")
    public void setBrokerRef(KReference brokerRef) {
        this.brokerRef = brokerRef;
    }

    @JsonProperty("delivery")
    public DeliverySpec getDelivery() {
        return delivery;
    }

    @JsonProperty("delivery")
    public void setDelivery(DeliverySpec delivery) {
        this.delivery = delivery;
    }

    @JsonProperty("filter")
    public TriggerFilter getFilter() {
        return filter;
    }

    @JsonProperty("filter")
    public void setFilter(TriggerFilter filter) {
        this.filter = filter;
    }

    /**
     * Filters is an experimental field that conforms to the CNCF CloudEvents Subscriptions API. It's an array of filter expressions that evaluate to true or false. If any filter expression in the array evaluates to false, the event MUST NOT be sent to the Subscriber. If all the filter expressions in the array evaluate to true, the event MUST be attempted to be delivered. Absence of a filter or empty array implies a value of true. In the event of users specifying both Filter and Filters, then the latter will override the former. This will allow users to try out the effect of the new Filters field without compromising the existing attribute-based Filter and try it out on existing Trigger objects.
     */
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionsAPIFilter> getFilters() {
        return filters;
    }

    /**
     * Filters is an experimental field that conforms to the CNCF CloudEvents Subscriptions API. It's an array of filter expressions that evaluate to true or false. If any filter expression in the array evaluates to false, the event MUST NOT be sent to the Subscriber. If all the filter expressions in the array evaluate to true, the event MUST be attempted to be delivered. Absence of a filter or empty array implies a value of true. In the event of users specifying both Filter and Filters, then the latter will override the former. This will allow users to try out the effect of the new Filters field without compromising the existing attribute-based Filter and try it out on existing Trigger objects.
     */
    @JsonProperty("filters")
    public void setFilters(List<SubscriptionsAPIFilter> filters) {
        this.filters = filters;
    }

    @JsonProperty("subscriber")
    public Destination getSubscriber() {
        return subscriber;
    }

    @JsonProperty("subscriber")
    public void setSubscriber(Destination subscriber) {
        this.subscriber = subscriber;
    }

    @JsonIgnore
    public TriggerSpecBuilder edit() {
        return new TriggerSpecBuilder(this);
    }

    @JsonIgnore
    public TriggerSpecBuilder toBuilder() {
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
        if (!(o instanceof TriggerSpec)) {
            return false;
        }
        TriggerSpec other = (TriggerSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$broker = this.getBroker();
        Object other$broker = other.getBroker();
        if (this$broker == null ? other$broker != null : !this$broker.equals(other$broker)) {
            return false;
        }
        Object this$brokerRef = this.getBrokerRef();
        Object other$brokerRef = other.getBrokerRef();
        if (this$brokerRef == null ? other$brokerRef != null : !this$brokerRef.equals(other$brokerRef)) {
            return false;
        }
        Object this$delivery = this.getDelivery();
        Object other$delivery = other.getDelivery();
        if (this$delivery == null ? other$delivery != null : !this$delivery.equals(other$delivery)) {
            return false;
        }
        Object this$filter = this.getFilter();
        Object other$filter = other.getFilter();
        if (this$filter == null ? other$filter != null : !this$filter.equals(other$filter)) {
            return false;
        }
        Object this$filters = this.getFilters();
        Object other$filters = other.getFilters();
        if (this$filters == null ? other$filters != null : !this$filters.equals(other$filters)) {
            return false;
        }
        Object this$subscriber = this.getSubscriber();
        Object other$subscriber = other.getSubscriber();
        if (this$subscriber == null ? other$subscriber != null : !this$subscriber.equals(other$subscriber)) {
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
        return other instanceof TriggerSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $broker = this.getBroker();
        result = result * prime + ($broker == null ? 43 : $broker.hashCode());
        Object $brokerRef = this.getBrokerRef();
        result = result * prime + ($brokerRef == null ? 43 : $brokerRef.hashCode());
        Object $delivery = this.getDelivery();
        result = result * prime + ($delivery == null ? 43 : $delivery.hashCode());
        Object $filter = this.getFilter();
        result = result * prime + ($filter == null ? 43 : $filter.hashCode());
        Object $filters = this.getFilters();
        result = result * prime + ($filters == null ? 43 : $filters.hashCode());
        Object $subscriber = this.getSubscriber();
        result = result * prime + ($subscriber == null ? 43 : $subscriber.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TriggerSpec(" + "broker=" + this.getBroker() + ", brokerRef=" + this.getBrokerRef() + ", delivery=" + this.getDelivery() + ", filter=" + this.getFilter() + ", filters=" + this.getFilters() + ", subscriber=" + this.getSubscriber() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
