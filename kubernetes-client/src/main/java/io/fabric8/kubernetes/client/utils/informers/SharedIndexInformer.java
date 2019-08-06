package io.fabric8.kubernetes.client.utils.informers;

import io.fabric8.kubernetes.client.utils.informers.cache.Indexer;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * SharedInxedInformer extends SharedInformer and provides indexer operability additionally.
 */
public interface SharedIndexInformer<T> extends SharedInformer<T> {

  /**
   * Add indexers
   *
   * @param indexers indexers
   */
  void addIndexers(Map<String, Function<T, List<String>>> indexers);

  /**
   * returns the internal indexer store.
   *
   * @return the internal indexer store
   */
  Indexer<T> getIndexer();
}
