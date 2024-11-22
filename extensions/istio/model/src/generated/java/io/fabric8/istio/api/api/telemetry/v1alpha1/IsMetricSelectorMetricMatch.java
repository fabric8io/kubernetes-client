
package io.fabric8.istio.api.api.telemetry.v1alpha1;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import io.fabric8.kubernetes.api.model.KubernetesResource;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
@JsonSubTypes({
    @JsonSubTypes.Type(MetricSelectorCustomMetric.class),
    @JsonSubTypes.Type(MetricSelectorMetric.class),
})
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public interface IsMetricSelectorMetricMatch extends KubernetesResource
{



}
