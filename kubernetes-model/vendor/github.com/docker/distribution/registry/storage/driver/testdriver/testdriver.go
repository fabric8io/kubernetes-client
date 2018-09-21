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
package testdriver

import (
	"github.com/docker/distribution/context"
	storagedriver "github.com/docker/distribution/registry/storage/driver"
	"github.com/docker/distribution/registry/storage/driver/factory"
	"github.com/docker/distribution/registry/storage/driver/inmemory"
)

const driverName = "testdriver"

func init() {
	factory.Register(driverName, &testDriverFactory{})
}

// testDriverFactory implements the factory.StorageDriverFactory interface.
type testDriverFactory struct{}

func (factory *testDriverFactory) Create(parameters map[string]interface{}) (storagedriver.StorageDriver, error) {
	return New(), nil
}

// TestDriver is a StorageDriver for testing purposes. The Writer returned by this driver
// simulates the case where Write operations are buffered. This causes the value returned by Size to lag
// behind until Close (or Commit, or Cancel) is called.
type TestDriver struct {
	storagedriver.StorageDriver
}

type testFileWriter struct {
	storagedriver.FileWriter
	prevchunk []byte
}

var _ storagedriver.StorageDriver = &TestDriver{}

// New constructs a new StorageDriver for testing purposes. The Writer returned by this driver
// simulates the case where Write operations are buffered. This causes the value returned by Size to lag
// behind until Close (or Commit, or Cancel) is called.
func New() *TestDriver {
	return &TestDriver{StorageDriver: inmemory.New()}
}

// Writer returns a FileWriter which will store the content written to it
// at the location designated by "path" after the call to Commit.
func (td *TestDriver) Writer(ctx context.Context, path string, append bool) (storagedriver.FileWriter, error) {
	fw, err := td.StorageDriver.Writer(ctx, path, append)
	return &testFileWriter{FileWriter: fw}, err
}

func (tfw *testFileWriter) Write(p []byte) (int, error) {
	_, err := tfw.FileWriter.Write(tfw.prevchunk)
	tfw.prevchunk = make([]byte, len(p))
	copy(tfw.prevchunk, p)
	return len(p), err
}

func (tfw *testFileWriter) Close() error {
	tfw.Write(nil)
	return tfw.FileWriter.Close()
}

func (tfw *testFileWriter) Cancel() error {
	tfw.Write(nil)
	return tfw.FileWriter.Cancel()
}

func (tfw *testFileWriter) Commit() error {
	tfw.Write(nil)
	return tfw.FileWriter.Commit()
}
