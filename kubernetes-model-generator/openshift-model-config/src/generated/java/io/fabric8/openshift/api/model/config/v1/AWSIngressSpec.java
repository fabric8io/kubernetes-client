
package io.fabric8.openshift.api.model.config.v1;

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
 * AWSIngressSpec holds the desired state of the Ingress for Amazon Web Services infrastructure provider. This only includes fields that can be modified in the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type"
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
public class AWSIngressSpec implements Editable<AWSIngressSpecBuilder>, KubernetesResource
{

    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSIngressSpec() {
    }

    public AWSIngressSpec(String type) {
        super();
        this.type = type;
    }

    /**
     * type allows user to set a load balancer type. When this field is set the default ingresscontroller will get created using the specified LBType. If this field is not set then the default ingress controller of LBType Classic will be created. Valid values are:<br><p> <br><p> &#42; "Classic": A Classic Load Balancer that makes routing decisions at either<br><p>   the transport layer (TCP/SSL) or the application layer (HTTP/HTTPS). See<br><p>   the following for additional details:<br><p> <br><p>     https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#clb<br><p> <br><p> &#42; "NLB": A Network Load Balancer that makes routing decisions at the<br><p>   transport layer (TCP/SSL). See the following for additional details:<br><p> <br><p>     https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#nlb
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type allows user to set a load balancer type. When this field is set the default ingresscontroller will get created using the specified LBType. If this field is not set then the default ingress controller of LBType Classic will be created. Valid values are:<br><p> <br><p> &#42; "Classic": A Classic Load Balancer that makes routing decisions at either<br><p>   the transport layer (TCP/SSL) or the application layer (HTTP/HTTPS). See<br><p>   the following for additional details:<br><p> <br><p>     https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#clb<br><p> <br><p> &#42; "NLB": A Network Load Balancer that makes routing decisions at the<br><p>   transport layer (TCP/SSL). See the following for additional details:<br><p> <br><p>     https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#nlb
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public AWSIngressSpecBuilder edit() {
        return new AWSIngressSpecBuilder(this);
    }

    @JsonIgnore
    public AWSIngressSpecBuilder toBuilder() {
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
