#!/bin/bash
#
# Copyright (C) 2015 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

#
# This script will run all test scripts that are in test/extended.
source "$(dirname "${BASH_SOURCE}")/../../hack/lib/init.sh"

test_scripts=`find test/extended -maxdepth 1 -name "*.sh" -not  \( -name "all.sh" \)`

OVERALL_RETURN=0
for test_script in $test_scripts; do
	STARTTIME=$(date +%s)
	echo "${STARTTIME} starting ${test_script}";

	set +e
	# use a subshell to prevent `exit` calls from killing this script
	(${test_script})
	CURR_RETURN=$?
	set -e

	if [ "${CURR_RETURN}" -ne "0" ]; then
		OVERALL_RETURN=${CURR_RETURN}
	fi
	ENDTIME=$(date +%s); echo "${test_script} took $(($ENDTIME - $STARTTIME)) seconds and returned with ${CURR_RETURN}";
done

exit ${OVERALL_RETURN}
