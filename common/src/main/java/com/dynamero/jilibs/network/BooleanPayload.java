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

package com.dynamero.jilibs.network;

import java.util.List;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import org.jetbrains.annotations.NotNull;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

import com.dynamero.jilibs.contracts.annotations.*;

/**
 * Represents a custom payload containing a float value.
 *
 * @param value the float value contained in this payload
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
public record BooleanPayload(boolean value) implements CustomPacketPayload
{
    /**
     * The unique identifier for this custom payload.
     */
    public static final Type<@NotNull BooleanPayload> ID = new Type<>(Identifier.fromNamespaceAndPath("jilibs", "boolean_payload"));

    /**
     * The codec used to serialize and deserialize the FloatPayload.
     */
    public static final Codec<BooleanPayload> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Codec.BOOL.fieldOf("value").forGetter(BooleanPayload::value)
    ).apply(inst, BooleanPayload::new));

    /**
     * The packet codec used to send and receive the FloatPayload.
     */
    public static final StreamCodec<RegistryFriendlyByteBuf, BooleanPayload> STREAM_CODEC =
            StreamCodec.composite(ByteBufCodecs.BOOL, BooleanPayload::value, BooleanPayload::new);

    public static final Codec<List<BooleanPayload>> LIST_CODEC = CODEC.listOf();

    /**
     * Retrieves the unique identifier for this custom payload.
     *
     * @return the unique identifier
     */
    @Override
    public @NotNull Type<? extends @NotNull CustomPacketPayload> type()
    {
        return ID;
    }
}