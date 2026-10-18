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

package com.dynamero.jilibs.contracts.exceptions;

import com.dynamero.jilibs.contracts.annotations.*;

/**
 * Contains custom exceptions for the Jibase project.
 */
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
public class Exceptions
{
    /**
     * Private constructor to prevent instantiation.
     */
    public Exceptions()
    {
        throwCtorAssertion();
    }

    /**
     * Throws an assertion error if the constructor is invoked directly.
     *
     * @throws InitCtorException always, as this method is a singleton and should not be instantiated
     */
    public static void throwCtorAssertion()
    {
        throw new InitCtorException();
    }

    public static void throwRuntimeException()
    {
        throw new RuntimeExeException();
    }

    public static void throwArgumentException()
    {
        throw new ArgumentException();
    }
}