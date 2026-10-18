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
 * This exception class is used to prevent instantiation of the {@link ArgumentException} class.
 * <p>
 * The purpose of this exception is to ensure that the {@link ArgumentException} class should not be instantiated, which can lead to unexpected behavior or security issues if it were allowed.
 * </p>
 *
 * @author Alireza Khodakarami (TheMentor)
 * @version 1.0
 * @since 2025-04-18
 */
@Developer("TheMentor")
@CreatedAt("2026-10-08")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class ArgumentException extends RuntimeException
{
    /**
     * The default message thrown by the {@link ArgumentException}.
     */
    public static String ARGUMENT_ERROR_TEXT = "Argument not acceptable!";

    /**
     * Constructor that throws the {@link ArgumentException} with a default message.
     */
    public ArgumentException()
    {
        super(ARGUMENT_ERROR_TEXT);
    }
}