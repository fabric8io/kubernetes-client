/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.kubernetes.client.informers;

import com.fasterxml.jackson.core.JacksonException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;

public interface ExceptionHandler {

  /**
   * Called to determine if the informer should continue to retry after the given exception.
   * <p>
   * See also {@link #isDeserializationException(Throwable)} that can help determine if the
   * problem is a mismatch with the target client class.
   *
   * @param isStarted true if the informer had already successfully started
   * @param t the non-http gone {@link WatcherException} from a
   *        {@link Watcher#onClose(io.fabric8.kubernetes.client.WatcherException)}
   *        or throwable from a list/watch call.
   * @return true if the informer should continue to retry
   */
  boolean retryAfterException(boolean isStarted, Throwable t);

  /**
   * Check to see if the exception of it's cause is coming from what is likely a
   * deserialization issue - either an exception from jackson or a class cast
   *
   * @param t
   * @return
   */
  public static boolean isDeserializationException(Throwable t) {
    while (!(t instanceof ClassCastException || t instanceof JacksonException)) {
      Throwable cause = t.getCause();
      if (cause == t || cause == null) {
        return false;
      }
      t = cause;
    }
    return true;
  }
}
