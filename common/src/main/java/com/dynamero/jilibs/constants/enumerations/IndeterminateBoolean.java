/*
 * Copyright (c) 2026 Alireza Khodakarami
 *
 * Licensed under the LPGL-3.0, (read the "LICENSE" file in repo);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.gnu.org/licenses/lgpl-3.0.en.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dynamero.jilibs.constants.enumerations;

import java.util.function.BooleanSupplier;

import com.dynamero.jilibs.contracts.annotations.*;
@SuppressWarnings("unused")
@Developer("TheMentor")
@CreatedAt("2026-10-08")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public enum IndeterminateBoolean
{
    TRUE,
    FALSE,
    INDETERMINATE;

    public boolean isTrue() {
        return this == TRUE;
    }

    public boolean isFalse() {
        return this == FALSE;
    }

    public boolean isIndeterminate() {
        return this == INDETERMINATE;
    }

    public boolean evaluate(boolean condition) {
        return evaluate(() -> condition);
    }

    public boolean evaluate(BooleanSupplier condition) {
        if (isIndeterminate())
            return condition.getAsBoolean();

        return isTrue();
    }
}