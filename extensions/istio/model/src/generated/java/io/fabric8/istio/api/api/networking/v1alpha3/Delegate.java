
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * Describes the delegate VirtualService. The following routing rules forward the traffic to `/productpage` by a delegate VirtualService named `productpage`, forward the traffic to `/reviews` by a delegate VirtualService named `reviews`.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: bookinfo<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- "bookinfo.com"<br><p> 	gateways:<br><p> 	- mygateway<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      prefix: "/productpage"<br><p> 	  delegate:<br><p> 	     name: productpage<br><p> 	     namespace: nsA<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      prefix: "/reviews"<br><p> 	  delegate:<br><p> 	      name: reviews<br><p> 	      namespace: nsB<br><p> <br><p> ```<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: productpage<br><p> 	namespace: nsA<br><p> <br><p> spec:<br><p> <br><p> 	http:<br><p> 	- match:<br><p> 	   - uri:<br><p> 	      prefix: "/productpage/v1/"<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: productpage-v1.nsA.svc.cluster.local<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: productpage.nsA.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews<br><p> 	namespace: nsB<br><p> <br><p> spec:<br><p> <br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: reviews.nsB.svc.cluster.local<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
public class Delegate implements Editable<DelegateBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Delegate() {
    }

    public Delegate(String name, String namespace) {
        super();
        this.name = name;
        this.namespace = namespace;
    }

    /**
     * Name specifies the name of the delegate VirtualService.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name specifies the name of the delegate VirtualService.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Namespace specifies the namespace where the delegate VirtualService resides. By default, it is same to the root's.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Namespace specifies the namespace where the delegate VirtualService resides. By default, it is same to the root's.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonIgnore
    public DelegateBuilder edit() {
        return new DelegateBuilder(this);
    }

    @JsonIgnore
    public DelegateBuilder toBuilder() {
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
