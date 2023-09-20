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
package io.fabric8.mockwebserver.utils;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Logger;

public final class Closeables {

  private static final Logger LOGGER = Logger.getLogger(Closeables.class.getName());

  private Closeables() {
    //Utility class
  }

  public static void closeQuietly(Closeable closeable) {
    try {
      closeable.close();
    } catch (IOException e) {
      LOGGER.warning("Error while closing object:" + closeable + ". Ignoring.");
    }
  }
}
