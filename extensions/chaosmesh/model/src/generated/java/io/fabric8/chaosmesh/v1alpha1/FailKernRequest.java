
package io.fabric8.chaosmesh.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * FailKernRequest defines the injection conditions
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "callchain",
    "failtype",
    "headers",
    "probability",
    "times"
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
public class FailKernRequest implements Editable<FailKernRequestBuilder>, KubernetesResource
{

    @JsonProperty("callchain")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Frame> callchain = new ArrayList<>();
    @JsonProperty("failtype")
    private Integer failtype;
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> headers = new ArrayList<>();
    @JsonProperty("probability")
    private Long probability;
    @JsonProperty("times")
    private Long times;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FailKernRequest() {
    }

    public FailKernRequest(List<Frame> callchain, Integer failtype, List<String> headers, Long probability, Long times) {
        super();
        this.callchain = callchain;
        this.failtype = failtype;
        this.headers = headers;
        this.probability = probability;
        this.times = times;
    }

    /**
     * Callchain indicate a special call chain, such as:<br><p>     ext4_mount<br><p>       -&gt; mount_subtree<br><p>          -&gt; ...<br><p>             -&gt; should_failslab<br><p> With an optional set of predicates and an optional set of parameters, which used with predicates. You can read call chan and predicate examples from https://github.com/chaos-mesh/bpfki/tree/develop/examples to learn more. If no special call chain, just keep Callchain empty, which means it will fail at any call chain with slab alloc (eg: kmalloc).
     */
    @JsonProperty("callchain")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Frame> getCallchain() {
        return callchain;
    }

    /**
     * Callchain indicate a special call chain, such as:<br><p>     ext4_mount<br><p>       -&gt; mount_subtree<br><p>          -&gt; ...<br><p>             -&gt; should_failslab<br><p> With an optional set of predicates and an optional set of parameters, which used with predicates. You can read call chan and predicate examples from https://github.com/chaos-mesh/bpfki/tree/develop/examples to learn more. If no special call chain, just keep Callchain empty, which means it will fail at any call chain with slab alloc (eg: kmalloc).
     */
    @JsonProperty("callchain")
    public void setCallchain(List<Frame> callchain) {
        this.callchain = callchain;
    }

    /**
     * FailType indicates what to fail, can be set to '0' / '1' / '2' If `0`, indicates slab to fail (should_failslab) If `1`, indicates alloc_page to fail (should_fail_alloc_page) If `2`, indicates bio to fail (should_fail_bio) You can read:<br><p>   1. https://www.kernel.org/doc/html/latest/fault-injection/fault-injection.html<br><p>   2. http://github.com/iovisor/bcc/blob/master/tools/inject_example.txt<br><p> to learn more
     */
    @JsonProperty("failtype")
    public Integer getFailtype() {
        return failtype;
    }

    /**
     * FailType indicates what to fail, can be set to '0' / '1' / '2' If `0`, indicates slab to fail (should_failslab) If `1`, indicates alloc_page to fail (should_fail_alloc_page) If `2`, indicates bio to fail (should_fail_bio) You can read:<br><p>   1. https://www.kernel.org/doc/html/latest/fault-injection/fault-injection.html<br><p>   2. http://github.com/iovisor/bcc/blob/master/tools/inject_example.txt<br><p> to learn more
     */
    @JsonProperty("failtype")
    public void setFailtype(Integer failtype) {
        this.failtype = failtype;
    }

    /**
     * Headers indicates the appropriate kernel headers you need. Eg: "linux/mmzone.h", "linux/blkdev.h" and so on
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHeaders() {
        return headers;
    }

    /**
     * Headers indicates the appropriate kernel headers you need. Eg: "linux/mmzone.h", "linux/blkdev.h" and so on
     */
    @JsonProperty("headers")
    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    /**
     * Probability indicates the fails with probability. If you want 1%, please set this field with 1.
     */
    @JsonProperty("probability")
    public Long getProbability() {
        return probability;
    }

    /**
     * Probability indicates the fails with probability. If you want 1%, please set this field with 1.
     */
    @JsonProperty("probability")
    public void setProbability(Long probability) {
        this.probability = probability;
    }

    /**
     * Times indicates the max times of fails.
     */
    @JsonProperty("times")
    public Long getTimes() {
        return times;
    }

    /**
     * Times indicates the max times of fails.
     */
    @JsonProperty("times")
    public void setTimes(Long times) {
        this.times = times;
    }

    @JsonIgnore
    public FailKernRequestBuilder edit() {
        return new FailKernRequestBuilder(this);
    }

    @JsonIgnore
    public FailKernRequestBuilder toBuilder() {
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
