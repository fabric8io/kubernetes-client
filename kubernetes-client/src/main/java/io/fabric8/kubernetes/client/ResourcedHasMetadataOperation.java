package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;

import java.util.function.BiFunction;

class ResourcedHasMetadataOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
    extends HasMetadataOperation<T, L, R> {

  private BiFunction<Resource<T>, Client, R> adapter;

  public ResourcedHasMetadataOperation(OperationContext ctx, Class<T> type, Class<L> listType, BiFunction<Resource<T>, Client, R> adapter) {
    super(ctx, type, listType);
    this.adapter = adapter;
  }

  @Override
  protected R newResource(OperationContext context) {
    return adapter.apply(super.newInstance(context), new BaseClient(context));
  }

  @Override
  public BaseOperation<T, L, R> newInstance(OperationContext context) {
    return new ResourcedHasMetadataOperation<>(context, type, listType, adapter);
  }
  
  public static <T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> void register(
      Class<T> type, BiFunction<Resource<T>, Client, R> target) {
    Handlers.register(type, (c) -> {
      return new ResourcedHasMetadataOperation<>(HasMetadataOperationsImpl.defaultContext(c), type,
          KubernetesResourceUtil.inferListType(type), target);
    });
  }

}
