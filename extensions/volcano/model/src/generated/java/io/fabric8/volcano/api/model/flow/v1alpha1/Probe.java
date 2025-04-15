
package io.fabric8.volcano.api.model.flow.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpGetList",
    "taskStatusList",
    "tcpSocketList"
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
public class Probe implements Editable<ProbeBuilder>, KubernetesResource
{

    @JsonProperty("httpGetList")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HttpGet> httpGetList = new ArrayList<>();
    @JsonProperty("taskStatusList")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskStatus> taskStatusList = new ArrayList<>();
    @JsonProperty("tcpSocketList")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TcpSocket> tcpSocketList = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Probe() {
    }

    public Probe(List<HttpGet> httpGetList, List<TaskStatus> taskStatusList, List<TcpSocket> tcpSocketList) {
        super();
        this.httpGetList = httpGetList;
        this.taskStatusList = taskStatusList;
        this.tcpSocketList = tcpSocketList;
    }

    @JsonProperty("httpGetList")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HttpGet> getHttpGetList() {
        return httpGetList;
    }

    @JsonProperty("httpGetList")
    public void setHttpGetList(List<HttpGet> httpGetList) {
        this.httpGetList = httpGetList;
    }

    @JsonProperty("taskStatusList")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskStatus> getTaskStatusList() {
        return taskStatusList;
    }

    @JsonProperty("taskStatusList")
    public void setTaskStatusList(List<TaskStatus> taskStatusList) {
        this.taskStatusList = taskStatusList;
    }

    @JsonProperty("tcpSocketList")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TcpSocket> getTcpSocketList() {
        return tcpSocketList;
    }

    @JsonProperty("tcpSocketList")
    public void setTcpSocketList(List<TcpSocket> tcpSocketList) {
        this.tcpSocketList = tcpSocketList;
    }

    @JsonIgnore
    public ProbeBuilder edit() {
        return new ProbeBuilder(this);
    }

    @JsonIgnore
    public ProbeBuilder toBuilder() {
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
