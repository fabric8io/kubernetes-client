
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonTypeResolver;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
@JsonSubTypes({
    @JsonSubTypes.Type(LoadBalancerSettingsConsistentHash.class),
    @JsonSubTypes.Type(LoadBalancerSettingsSimple.class),
})
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public interface IsLoadBalancerSettingsLbPolicy extends KubernetesResource
{



}
